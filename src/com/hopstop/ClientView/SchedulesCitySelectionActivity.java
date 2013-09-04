package com.hopstop.ClientView;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.androidquery.AQuery;
import com.androidquery.AbstractAQuery;
import com.hopstop.ClientController.HSAsyncTask;
import com.hopstop.ClientModel.Model;
import com.hopstop.ClientModel.ResponseStatus;
import com.hopstop.ClientModel.Schedules.Cities;
import com.hopstop.ClientModel.Schedules.City;
import com.hopstop.ClientModel.db.HSOrmLiteDBHelper;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.network.NetworkEngine;
import com.hopstop.network.NetworkSettings;
import com.hopstop.network.URLFactoryBuilder;
import com.hopstop.ui.BaseActivity;
import com.j256.ormlite.dao.Dao;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class SchedulesCitySelectionActivity extends BaseActivity
{
  public static final String DB_LAST_UPDATE_TIME_KEY = "schedules_previous_city_update";
  public static final int DB_UPDATE_INTERVAL = 604800000;
  private ScheduleCitiesAdapter adapter;
  private AQuery aq;
  private Cities cities;
  private String cityIdSelected;

  private void LoadScreen(Cities paramCities)
  {
    if ((paramCities != null) && (paramCities.getSize() > 0))
      ApplicationEngine.getModel().setScheduleCities(paramCities);
    this.cities = paramCities;
    loadList(paramCities);
    dismissProgressBar();
  }

  private void closeDB()
  {
  }

  private void dismissProgressBar()
  {
    ((ProgressBar)findViewById(2131493176)).setVisibility(8);
  }

  protected void loadList(final Cities paramCities)
  {
    ArrayList localArrayList = paramCities.getCities();
    ScheduleCitiesAdapter localScheduleCitiesAdapter1 = new ScheduleCitiesAdapter(this, localArrayList);
    this.adapter = localScheduleCitiesAdapter1;
    ListView localListView = (ListView)findViewById(2131492873);
    if (localListView != null)
    {
      ScheduleCitiesAdapter localScheduleCitiesAdapter2 = this.adapter;
      localListView.setAdapter(localScheduleCitiesAdapter2);
    }
    AdapterView.OnItemClickListener local2 = new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        Intent localIntent1 = new Intent();
        String str1 = paramCities.getCity(paramAnonymousInt).getId();
        Intent localIntent2 = localIntent1.putExtra("CityIdSelected", str1);
        String str2 = paramCities.getCity(paramAnonymousInt).getName();
        Intent localIntent3 = localIntent1.putExtra("CityNameSelected", str2);
        SchedulesCitySelectionActivity.this.setResult(-1, localIntent1);
        SchedulesCitySelectionActivity.this.finish();
      }
    };
    localListView.setOnItemClickListener(local2);
  }

  public void onBackPressed()
  {
    if (((this.cityIdSelected == null) || (this.cityIdSelected.equals(""))) && (this.cities != null) && (this.cities.getSize() != 0))
    {
      Intent localIntent1 = new Intent();
      String str1 = this.cities.getCity(0).getId();
      Intent localIntent2 = localIntent1.putExtra("CityIdSelected", str1);
      String str2 = this.cities.getCity(0).getName();
      Intent localIntent3 = localIntent1.putExtra("CityNameSelected", str2);
      setResult(-1, localIntent1);
    }
    while (true)
    {
      super.onBackPressed();
      return;
      if (((this.cityIdSelected == null) || (this.cityIdSelected.equals(""))) && ((this.cities == null) || (this.cities.getSize() == 0)))
      {
        Intent localIntent4 = new Intent();
        setResult(-1, localIntent4);
      }
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    String str1 = getIntent().getStringExtra("CurrentCityIdSelected");
    this.cityIdSelected = str1;
    super.onCreate(paramBundle);
    setContentView(2130903105);
    Hashtable localHashtable = new Hashtable();
    String str2 = ApplicationEngine.getModel().getDefaultCityId();
    Object localObject = localHashtable.put("defaultcity", str2);
    update(121259, localHashtable, null, null);
    AQuery localAQuery1 = new AQuery(this);
    this.aq = localAQuery1;
    AbstractAQuery localAbstractAQuery1 = ((AQuery)this.aq.id(2131492968)).text(2130968770);
    Cities localCities = new Cities();
    this.cities = localCities;
    GetFromDBTask localGetFromDBTask = new GetFromDBTask(null);
    Void[] arrayOfVoid = new Void[0];
    AsyncTask localAsyncTask = localGetFromDBTask.execute(arrayOfVoid);
    trackEvent("Schedules City Selection Screen");
    AQuery localAQuery2 = (AQuery)this.aq.id(2131492906);
    View.OnClickListener local1 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        SchedulesCitySelectionActivity localSchedulesCitySelectionActivity = SchedulesCitySelectionActivity.this;
        String str1 = String.valueOf(getClass().getName());
        String str2 = str1 + "Clicked on logo";
        localSchedulesCitySelectionActivity.LogD(str2);
        Context localContext = SchedulesCitySelectionActivity.this.getApplicationContext();
        Intent localIntent1 = new Intent(localContext, DirectionsMainViewActivity.class);
        Intent localIntent2 = localIntent1.setFlags(335544320);
        SchedulesCitySelectionActivity.this.getApplicationContext().startActivity(localIntent1);
      }
    };
    AbstractAQuery localAbstractAQuery2 = localAQuery2.clicked(local1);
  }

  protected void onDestroy()
  {
    super.onDestroy();
  }

  protected void showError(int paramInt)
  {
    String str = getString(paramInt);
    showError(str);
  }

  protected void showError(String paramString)
  {
    AbstractAQuery localAbstractAQuery1 = ((AQuery)this.aq.id(2131492873)).gone();
    AbstractAQuery localAbstractAQuery2 = ((AQuery)this.aq.id(2131493186)).visible();
    AbstractAQuery localAbstractAQuery3 = ((AQuery)this.aq.id(2131493186)).text(paramString);
    dismissProgressBar();
  }

  private class CallAPITask extends HSAsyncTask<Void, Void, Cities>
  {
    private CallAPITask()
    {
    }

    protected Cities doInBackground(Void[] paramArrayOfVoid)
    {
      try
      {
        String str1 = URLFactoryBuilder.GetSchedulesCitiesURL(NetworkSettings.keyNewAPI);
        String str2 = ApplicationEngine.getNetworkEngine().retrieve(str1);
        Persister localPersister = new Persister();
        StringReader localStringReader = new StringReader(str2);
        SchedulesCitySelectionActivity localSchedulesCitySelectionActivity = SchedulesCitySelectionActivity.this;
        Cities localCities = (Cities)localPersister.read(Cities.class, localStringReader, false);
        localSchedulesCitySelectionActivity.cities = localCities;
        return SchedulesCitySelectionActivity.this.cities;
      }
      catch (IOException localIOException)
      {
        while (true)
        {
          String str3 = SchedulesCitySelectionActivity.this.getString(2130968784);
          Error(localIOException, str3);
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          String str4 = SchedulesCitySelectionActivity.this.getString(2130968785);
          Error(localException, str4);
        }
      }
    }

    protected void onCancelled()
    {
      SchedulesCitySelectionActivity.this.LogD("CitySelection, CallAPITask cancelled");
    }

    protected void onPostExecute(Cities paramCities)
    {
      if (hasError())
      {
        SchedulesCitySelectionActivity localSchedulesCitySelectionActivity1 = SchedulesCitySelectionActivity.this;
        String str1 = getErrorString();
        localSchedulesCitySelectionActivity1.showError(str1);
        return;
      }
      if (paramCities != null)
      {
        if (!paramCities.getResponseStatus().isSuccess())
        {
          SchedulesCitySelectionActivity localSchedulesCitySelectionActivity2 = SchedulesCitySelectionActivity.this;
          String str2 = paramCities.getResponseStatus().getErrorString();
          localSchedulesCitySelectionActivity2.showError(str2);
          return;
        }
        if (paramCities.getSize() == 0)
        {
          SchedulesCitySelectionActivity.this.showError("Cities were not found");
          return;
        }
        SchedulesCitySelectionActivity.this.LoadScreen(paramCities);
        SchedulesCitySelectionActivity localSchedulesCitySelectionActivity3 = SchedulesCitySelectionActivity.this;
        SchedulesCitySelectionActivity.SaveToDBTask localSaveToDBTask = new SchedulesCitySelectionActivity.SaveToDBTask(localSchedulesCitySelectionActivity3, null);
        Cities[] arrayOfCities = new Cities[1];
        arrayOfCities[0] = paramCities;
        AsyncTask localAsyncTask = localSaveToDBTask.execute(arrayOfCities);
        return;
      }
      SchedulesCitySelectionActivity.this.showError(2130968786);
    }

    protected void onProgressUpdate(Void[] paramArrayOfVoid)
    {
    }
  }

  private class GetFromDBTask extends AsyncTask<Void, Void, Cities>
  {
    private GetFromDBTask()
    {
    }

    protected Cities doInBackground(Void[] paramArrayOfVoid)
    {
      SchedulesCitySelectionActivity localSchedulesCitySelectionActivity1 = SchedulesCitySelectionActivity.this;
      Cities localCities1 = ApplicationEngine.getModel().getScheduleCities();
      localSchedulesCitySelectionActivity1.cities = localCities1;
      Cities localCities2;
      if ((SchedulesCitySelectionActivity.this.cities != null) && (SchedulesCitySelectionActivity.this.cities.getSize() != 0))
        localCities2 = SchedulesCitySelectionActivity.this.cities;
      while (true)
      {
        return localCities2;
        try
        {
          if (!SchedulesCitySelectionActivity.this.needUpdateFromPreferences("schedules_previous_city_update", 604800000))
          {
            SchedulesCitySelectionActivity.this.LogD("Getting schedules cities from DB");
            SchedulesCitySelectionActivity localSchedulesCitySelectionActivity2 = SchedulesCitySelectionActivity.this;
            List localList = HSOrmLiteDBHelper.getHelper(SchedulesCitySelectionActivity.this).getCitiesDao().queryForAll();
            Cities localCities3 = new Cities(localList);
            localSchedulesCitySelectionActivity2.cities = localCities3;
          }
          localCities2 = SchedulesCitySelectionActivity.this.cities;
        }
        catch (Exception localException)
        {
          while (true)
            localException.printStackTrace();
        }
      }
    }

    protected void onCancelled()
    {
    }

    protected void onPostExecute(Cities paramCities)
    {
      if ((paramCities == null) || (paramCities.getSize() == 0))
      {
        SchedulesCitySelectionActivity localSchedulesCitySelectionActivity = SchedulesCitySelectionActivity.this;
        SchedulesCitySelectionActivity.CallAPITask localCallAPITask = new SchedulesCitySelectionActivity.CallAPITask(localSchedulesCitySelectionActivity, null);
        Void[] arrayOfVoid = new Void[0];
        AsyncTask localAsyncTask = localCallAPITask.execute(arrayOfVoid);
        return;
      }
      SchedulesCitySelectionActivity.this.LoadScreen(paramCities);
    }
  }

  static class ListViewItemHolder
  {
    public TextView textView;
  }

  private class SaveToDBTask extends HSAsyncTask<Cities, Void, Boolean>
  {
    private SaveToDBTask()
    {
    }

    protected Boolean doInBackground(Cities[] paramArrayOfCities)
    {
      Cities localCities = paramArrayOfCities[0];
      if ((localCities != null) && (localCities.getSize() != 0) && (localCities != null) && (localCities.getSize() > 0))
      {
        HSOrmLiteDBHelper localHSOrmLiteDBHelper = HSOrmLiteDBHelper.getHelper(SchedulesCitySelectionActivity.this);
        ArrayList localArrayList = localCities.getCities();
        boolean bool = localHSOrmLiteDBHelper.UpdateCities(localArrayList);
        SchedulesCitySelectionActivity.this.closeDB();
        if (bool)
          SchedulesCitySelectionActivity.this.setNextUpdateFromPreferences("schedules_previous_city_update");
      }
      for (Boolean localBoolean = Boolean.valueOf(true); ; localBoolean = Boolean.valueOf(false))
        return localBoolean;
    }

    protected void onCancelled()
    {
      SchedulesCitySelectionActivity.this.LogD("CitySelection SaveToDBTask cancelled");
    }

    protected void onPostExecute(Boolean paramBoolean)
    {
    }
  }

  public class ScheduleCitiesAdapter extends ArrayAdapter<City>
    implements SectionIndexer
  {
    HashMap<String, Integer> alphaIndexer;
    private ArrayList<City> cities;
    private LayoutInflater inflater;
    String[] sections;

    public ScheduleCitiesAdapter(ArrayList<City> arg2)
    {
      super(2130903106, localList);
      this.cities = localList;
      LayoutInflater localLayoutInflater = (LayoutInflater)localContext.getSystemService("layout_inflater");
      this.inflater = localLayoutInflater;
      HashMap localHashMap1 = new HashMap();
      this.alphaIndexer = localHashMap1;
      int i = this.cities.size();
      int j = 0;
      while (true)
      {
        if (j >= i)
        {
          Set localSet = this.alphaIndexer.keySet();
          ArrayList localArrayList = new ArrayList(localSet);
          Collections.sort(localArrayList);
          String[] arrayOfString1 = new String[localArrayList.size()];
          this.sections = arrayOfString1;
          String[] arrayOfString2 = this.sections;
          Object[] arrayOfObject = localArrayList.toArray(arrayOfString2);
          return;
        }
        String str = ((City)this.cities.get(j)).getName().substring(0, 1).toUpperCase();
        HashMap localHashMap2 = this.alphaIndexer;
        Integer localInteger = Integer.valueOf(j);
        Object localObject = localHashMap2.put(str, localInteger);
        j += 1;
      }
    }

    public int getPositionForSection(int paramInt)
    {
      HashMap localHashMap = this.alphaIndexer;
      String str = this.sections[paramInt];
      return ((Integer)localHashMap.get(str)).intValue();
    }

    public int getSectionForPosition(int paramInt)
    {
      return 1;
    }

    public Object[] getSections()
    {
      return this.sections;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      SchedulesCitySelectionActivity.ListViewItemHolder localListViewItemHolder;
      if (localView == null)
      {
        localView = this.inflater.inflate(2130903106, null);
        localListViewItemHolder = new SchedulesCitySelectionActivity.ListViewItemHolder();
        TextView localTextView1 = (TextView)localView.findViewById(2131492875);
        localListViewItemHolder.textView = localTextView1;
        localView.setTag(localListViewItemHolder);
      }
      while (true)
      {
        TextView localTextView2 = localListViewItemHolder.textView;
        String str = ((City)this.cities.get(paramInt)).getName();
        localTextView2.setText(str);
        return localView;
        localListViewItemHolder = (SchedulesCitySelectionActivity.ListViewItemHolder)localView.getTag();
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.SchedulesCitySelectionActivity
 * JD-Core Version:    0.6.2
 */