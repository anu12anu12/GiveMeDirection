package com.hopstop.ClientView;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.androidquery.AQuery;
import com.androidquery.AbstractAQuery;
import com.hopstop.ClientController.HSAsyncTask;
import com.hopstop.ClientModel.Model;
import com.hopstop.ClientModel.ResponseStatus;
import com.hopstop.ClientModel.Schedules.CityStationGroupMapping;
import com.hopstop.ClientModel.Schedules.Group;
import com.hopstop.ClientModel.Schedules.Group.CategoryOrder;
import com.hopstop.ClientModel.Schedules.Groups;
import com.hopstop.ClientModel.db.HSOrmLiteDBHelper;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.network.NetworkEngine;
import com.hopstop.network.NetworkSettings;
import com.hopstop.network.URLFactoryBuilder;
import com.hopstop.ui.BaseActivity;
import com.hopstop.ui.PinnedHeaderListView;
import com.hopstop.ui.PinnedHeaderListView.PinnedHeaderAdapter;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.Where;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class SchedulesStationGroupSelectionActivity extends BaseActivity
{
  protected static final String CITY_ID_SELECTED = "CityIdSelected";
  protected static final String CITY_NAME_SELECTED = "CityNameSelected";
  public static final String DB_PREVIOUS_UPDATE_TIME_KEY_PREFIX = "schedules_previous_stationgroups_update_";
  public static final int DB_UPDATE_INTERVAL = 604800000;
  public static String SCHEDULES_DEFAULT_CITY_ID_KEY = "SchedulesDefaultCityId";
  public static String SCHEDULES_DEFAULT_CITY_NAME_KEY = "SchedulesDefaultCityName";
  private SchedulesGroupsAdapter adapter;
  private AQuery aq;
  private GetAPITask callAPItask;
  View.OnClickListener changecityListener;
  private String cityIdSelected;
  private String cityNameSelected;
  private GetFromDBTask getFromDBTask;
  private Groups groups;
  private Boolean setFirstDefault;

  public SchedulesStationGroupSelectionActivity()
  {
    View.OnClickListener local1 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        SchedulesStationGroupSelectionActivity.this.change_city();
      }
    };
    this.changecityListener = local1;
  }

  private void closeDB()
  {
  }

  private void dismissProgressBar()
  {
    AbstractAQuery localAbstractAQuery = ((AQuery)this.aq.id(2131493176)).gone();
  }

  protected void LoadScreen()
  {
    Groups localGroups1 = this.groups;
    SchedulesGroupsAdapter localSchedulesGroupsAdapter1 = new SchedulesGroupsAdapter(this, localGroups1);
    this.adapter = localSchedulesGroupsAdapter1;
    PinnedHeaderListView localPinnedHeaderListView = (PinnedHeaderListView)findViewById(2131493214);
    if (localPinnedHeaderListView != null)
    {
      SchedulesGroupsAdapter localSchedulesGroupsAdapter2 = this.adapter;
      localPinnedHeaderListView.setAdapter(localSchedulesGroupsAdapter2);
      AdapterView.OnItemClickListener local3 = new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          Intent localIntent1 = new Intent();
          String str1 = SchedulesStationGroupSelectionActivity.this.groups.getGroup(paramAnonymousInt).getId();
          Intent localIntent2 = localIntent1.putExtra("StationGroupSelectedId", str1);
          String str2 = SchedulesStationGroupSelectionActivity.this.groups.getGroup(paramAnonymousInt).getName();
          Intent localIntent3 = localIntent1.putExtra("StationGroupSelectedName", str2);
          SchedulesStationGroupSelectionActivity.this.setResult(-1, localIntent1);
          SchedulesStationGroupSelectionActivity.this.finish();
        }
      };
      localPinnedHeaderListView.setOnItemClickListener(local3);
      View localView = LayoutInflater.from(this).inflate(2130903112, localPinnedHeaderListView, false);
      localPinnedHeaderListView.setPinnedHeaderView(localView);
      SchedulesGroupsAdapter localSchedulesGroupsAdapter3 = this.adapter;
      localPinnedHeaderListView.setOnScrollListener(localSchedulesGroupsAdapter3);
    }
    if ((this.groups == null) || (this.groups.getSize() == 0))
    {
      AbstractAQuery localAbstractAQuery1 = ((AQuery)this.aq.id(2131493214)).gone();
      AbstractAQuery localAbstractAQuery2 = ((AQuery)this.aq.id(2131493186)).text(2130968772);
    }
    while (true)
    {
      dismissProgressBar();
      return;
      Model localModel = ApplicationEngine.getModel();
      String str = this.cityIdSelected;
      Groups localGroups2 = this.groups;
      localModel.AddStationGroupMapping(str, localGroups2);
    }
  }

  protected void change_city()
  {
    Intent localIntent = new Intent(this, SchedulesCitySelectionActivity.class);
    startActivityForResult(localIntent, 72);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(72, paramInt2, paramIntent);
    if (paramInt2 != 1)
      return;
    String str1 = paramIntent.getStringExtra("CityIdSelected");
    this.cityIdSelected = str1;
    String str2 = paramIntent.getStringExtra("CityNameSelected");
    this.cityNameSelected = str2;
    start();
  }

  public void onBackPressed()
  {
    if ((this.setFirstDefault.booleanValue()) && (this.groups != null) && (this.groups.getSize() != 0))
    {
      Intent localIntent1 = new Intent();
      String str1 = this.groups.getGroup(0).getId();
      Intent localIntent2 = localIntent1.putExtra("StationGroupSelectedId", str1);
      String str2 = this.groups.getGroup(0).getName();
      Intent localIntent3 = localIntent1.putExtra("StationGroupSelectedName", str2);
      setResult(-1, localIntent1);
    }
    while (true)
    {
      super.onBackPressed();
      return;
      if (this.setFirstDefault.booleanValue())
      {
        Intent localIntent4 = new Intent();
        setResult(-1, localIntent4);
      }
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    String str1 = getIntent().getStringExtra("CityIdSelected");
    this.cityIdSelected = str1;
    String str2 = getIntent().getStringExtra("CityNameSelected");
    this.cityNameSelected = str2;
    Boolean localBoolean = Boolean.valueOf(getIntent().getBooleanExtra("setFirstDefault", false));
    this.setFirstDefault = localBoolean;
    start();
    trackEvent("Schedules Station Groups Selection Screen");
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.getFromDBTask != null) && (!this.getFromDBTask.isCancelled()))
      boolean bool1 = this.getFromDBTask.cancel(true);
    if (this.callAPItask == null)
      return;
    if (this.callAPItask.isCancelled())
      return;
    boolean bool2 = this.callAPItask.cancel(true);
  }

  protected void onPause()
  {
    super.onPause();
  }

  protected boolean saveStationGroups(Groups paramGroups)
  {
    HSOrmLiteDBHelper localHSOrmLiteDBHelper1 = HSOrmLiteDBHelper.getHelper(this);
    ArrayList localArrayList1 = paramGroups.getGroups();
    boolean bool1 = localHSOrmLiteDBHelper1.UpdateOrInsertGroups(localArrayList1);
    ArrayList localArrayList2;
    Iterator localIterator;
    if (bool1)
    {
      localArrayList2 = new ArrayList();
      localIterator = paramGroups.getGroups().iterator();
      if (!localIterator.hasNext())
      {
        HSOrmLiteDBHelper localHSOrmLiteDBHelper2 = HSOrmLiteDBHelper.getHelper(this);
        String str1 = this.cityIdSelected;
        bool1 = localHSOrmLiteDBHelper2.UpdateOrInsertCityStationGroupMapping(localArrayList2, "cityId", str1);
      }
    }
    else
    {
      closeDB();
      if (!bool1)
        break label176;
      StringBuilder localStringBuilder = new StringBuilder("schedules_previous_stationgroups_update_");
      String str2 = this.cityIdSelected;
      String str3 = str2;
      setNextUpdateFromPreferences(str3);
    }
    label176: for (boolean bool2 = true; ; bool2 = false)
    {
      return bool2;
      Group localGroup = (Group)localIterator.next();
      String str4 = this.cityIdSelected;
      String str5 = localGroup.getId();
      CityStationGroupMapping localCityStationGroupMapping = new CityStationGroupMapping(str4, str5);
      boolean bool3 = localArrayList2.add(localCityStationGroupMapping);
      break;
    }
  }

  protected void showError(int paramInt)
  {
    String str = getString(paramInt);
    showError(str);
  }

  protected void showError(String paramString)
  {
    AbstractAQuery localAbstractAQuery1 = ((AQuery)this.aq.id(2131493214)).gone();
    AbstractAQuery localAbstractAQuery2 = ((AQuery)this.aq.id(2131493186)).visible();
    AbstractAQuery localAbstractAQuery3 = ((AQuery)this.aq.id(2131493186)).text(paramString);
    dismissProgressBar();
  }

  protected void start()
  {
    setContentView(2130903113);
    Hashtable localHashtable = new Hashtable();
    String str1 = ApplicationEngine.getModel().getDefaultCityId();
    Object localObject = localHashtable.put("defaultcity", str1);
    update(121259, localHashtable, null, null);
    AQuery localAQuery1 = new AQuery(this);
    this.aq = localAQuery1;
    AQuery localAQuery2 = (AQuery)this.aq.id(2131492968);
    String str2 = String.valueOf(this.cityNameSelected);
    StringBuilder localStringBuilder = new StringBuilder(str2).append(" ");
    String str3 = getString(2130968771);
    String str4 = str3;
    AbstractAQuery localAbstractAQuery1 = localAQuery2.text(str4);
    GetFromDBTask localGetFromDBTask1 = new GetFromDBTask(null);
    this.getFromDBTask = localGetFromDBTask1;
    GetFromDBTask localGetFromDBTask2 = this.getFromDBTask;
    Void[] arrayOfVoid = new Void[0];
    AsyncTask localAsyncTask = localGetFromDBTask2.execute(arrayOfVoid);
    AQuery localAQuery3 = (AQuery)this.aq.id(2131492906);
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        SchedulesStationGroupSelectionActivity localSchedulesStationGroupSelectionActivity = SchedulesStationGroupSelectionActivity.this;
        String str1 = String.valueOf(getClass().getName());
        String str2 = str1 + "Clicked on logo";
        localSchedulesStationGroupSelectionActivity.LogD(str2);
        Context localContext = SchedulesStationGroupSelectionActivity.this.getApplicationContext();
        Intent localIntent1 = new Intent(localContext, DirectionsMainViewActivity.class);
        Intent localIntent2 = localIntent1.setFlags(335544320);
        SchedulesStationGroupSelectionActivity.this.getApplicationContext().startActivity(localIntent1);
      }
    };
    AbstractAQuery localAbstractAQuery2 = localAQuery3.clicked(local2);
  }

  private class GetAPITask extends HSAsyncTask<Void, String, Groups>
  {
    private GetAPITask()
    {
    }

    protected Groups doInBackground(Void[] paramArrayOfVoid)
    {
      SchedulesStationGroupSelectionActivity localSchedulesStationGroupSelectionActivity1 = SchedulesStationGroupSelectionActivity.this;
      Groups localGroups1 = new Groups();
      localSchedulesStationGroupSelectionActivity1.groups = localGroups1;
      try
      {
        String str1 = SchedulesStationGroupSelectionActivity.this.cityIdSelected;
        String str2 = NetworkSettings.keyNewAPI;
        String str3 = URLFactoryBuilder.GetSchedulesGroupsURL(str1, str2);
        String[] arrayOfString1 = new String[1];
        String str4 = SchedulesStationGroupSelectionActivity.this.getString(2130968787);
        arrayOfString1[0] = str4;
        publishProgress(arrayOfString1);
        String str5 = ApplicationEngine.getNetworkEngine().retrieve(str3);
        if (str5 != null)
        {
          String[] arrayOfString2 = new String[1];
          String str6 = SchedulesStationGroupSelectionActivity.this.getString(2130968788);
          arrayOfString2[0] = str6;
          publishProgress(arrayOfString2);
          Persister localPersister = new Persister();
          StringReader localStringReader = new StringReader(str5);
          SchedulesStationGroupSelectionActivity localSchedulesStationGroupSelectionActivity2 = SchedulesStationGroupSelectionActivity.this;
          Groups localGroups2 = (Groups)localPersister.read(Groups.class, localStringReader, false);
          localSchedulesStationGroupSelectionActivity2.groups = localGroups2;
          SchedulesStationGroupSelectionActivity.this.groups.reArrange();
        }
        if ((SchedulesStationGroupSelectionActivity.this.groups != null) && (SchedulesStationGroupSelectionActivity.this.groups.getSize() > 0))
        {
          String[] arrayOfString3 = new String[1];
          String str7 = SchedulesStationGroupSelectionActivity.this.getString(2130968789);
          arrayOfString3[0] = str7;
          publishProgress(arrayOfString3);
        }
        return SchedulesStationGroupSelectionActivity.this.groups;
      }
      catch (IOException localIOException)
      {
        while (true)
        {
          String str8 = SchedulesStationGroupSelectionActivity.this.getString(2130968784);
          Error(localIOException, str8);
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          String str9 = SchedulesStationGroupSelectionActivity.this.getString(2130968785);
          Error(localException, str9);
        }
      }
    }

    protected void onCancelled()
    {
    }

    protected void onPostExecute(Groups paramGroups)
    {
      if (hasError())
      {
        SchedulesStationGroupSelectionActivity localSchedulesStationGroupSelectionActivity1 = SchedulesStationGroupSelectionActivity.this;
        String str1 = getErrorString();
        localSchedulesStationGroupSelectionActivity1.showError(str1);
        return;
      }
      if (paramGroups != null)
      {
        if (!paramGroups.getResponseStatus().isSuccess())
        {
          SchedulesStationGroupSelectionActivity localSchedulesStationGroupSelectionActivity2 = SchedulesStationGroupSelectionActivity.this;
          String str2 = paramGroups.getResponseStatus().getErrorString();
          localSchedulesStationGroupSelectionActivity2.showError(str2);
          return;
        }
        if (paramGroups.getSize() == 0)
        {
          SchedulesStationGroupSelectionActivity.this.showError("lines were not found");
          return;
        }
        SchedulesStationGroupSelectionActivity.this.groups = paramGroups;
        SchedulesStationGroupSelectionActivity.this.LoadScreen();
        SchedulesStationGroupSelectionActivity localSchedulesStationGroupSelectionActivity3 = SchedulesStationGroupSelectionActivity.this;
        SchedulesStationGroupSelectionActivity.SaveToDBTask localSaveToDBTask = new SchedulesStationGroupSelectionActivity.SaveToDBTask(localSchedulesStationGroupSelectionActivity3, null);
        Groups[] arrayOfGroups = new Groups[1];
        Groups localGroups = SchedulesStationGroupSelectionActivity.this.groups;
        arrayOfGroups[0] = localGroups;
        AsyncTask localAsyncTask = localSaveToDBTask.execute(arrayOfGroups);
        return;
      }
      SchedulesStationGroupSelectionActivity.this.showError(2130968786);
    }

    protected void onPreExecute()
    {
    }

    protected void onProgressUpdate(String[] paramArrayOfString)
    {
      AQuery localAQuery = (AQuery)SchedulesStationGroupSelectionActivity.this.aq.id(2131493201);
      String str = paramArrayOfString[0];
      AbstractAQuery localAbstractAQuery = localAQuery.text(str);
    }
  }

  private class GetFromDBTask extends AsyncTask<Void, Void, Groups>
  {
    private GetFromDBTask()
    {
    }

    protected Groups doInBackground(Void[] paramArrayOfVoid)
    {
      SchedulesStationGroupSelectionActivity localSchedulesStationGroupSelectionActivity1 = SchedulesStationGroupSelectionActivity.this;
      Model localModel = ApplicationEngine.getModel();
      String str1 = SchedulesStationGroupSelectionActivity.this.cityIdSelected;
      Groups localGroups1 = localModel.getStationGroupMapping(str1);
      localSchedulesStationGroupSelectionActivity1.groups = localGroups1;
      Groups localGroups2;
      if ((SchedulesStationGroupSelectionActivity.this.groups != null) && (SchedulesStationGroupSelectionActivity.this.groups.getSize() != 0))
        localGroups2 = SchedulesStationGroupSelectionActivity.this.groups;
      while (true)
      {
        return localGroups2;
        SchedulesStationGroupSelectionActivity localSchedulesStationGroupSelectionActivity2 = SchedulesStationGroupSelectionActivity.this;
        Groups localGroups3 = new Groups();
        localSchedulesStationGroupSelectionActivity2.groups = localGroups3;
        try
        {
          SchedulesStationGroupSelectionActivity localSchedulesStationGroupSelectionActivity3 = SchedulesStationGroupSelectionActivity.this;
          StringBuilder localStringBuilder = new StringBuilder("schedules_previous_stationgroups_update_");
          String str2 = SchedulesStationGroupSelectionActivity.this.cityIdSelected;
          String str3 = str2;
          Iterator localIterator;
          if (!localSchedulesStationGroupSelectionActivity3.needUpdateFromPreferences(str3, 604800000))
          {
            Dao localDao1 = HSOrmLiteDBHelper.getHelper(SchedulesStationGroupSelectionActivity.this).getCityStationGroupDao();
            String str4 = SchedulesStationGroupSelectionActivity.this.cityIdSelected;
            localIterator = localDao1.queryForEq("cityId", str4).iterator();
          }
          while (true)
          {
            if (!localIterator.hasNext())
            {
              SchedulesStationGroupSelectionActivity.this.groups.reArrange();
              localGroups2 = SchedulesStationGroupSelectionActivity.this.groups;
              break;
            }
            String str5 = ((CityStationGroupMapping)localIterator.next()).getStationGroupId();
            SelectArg localSelectArg = new SelectArg(str5);
            Dao localDao2 = HSOrmLiteDBHelper.getHelper(SchedulesStationGroupSelectionActivity.this).getGroupsDao();
            PreparedQuery localPreparedQuery = localDao2.queryBuilder().where().like("id", localSelectArg).prepare();
            Group localGroup = (Group)localDao2.queryForFirst(localPreparedQuery);
            SchedulesStationGroupSelectionActivity.this.groups.addGroup(localGroup);
          }
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

    protected void onPostExecute(Groups paramGroups)
    {
      SchedulesStationGroupSelectionActivity.this.groups = paramGroups;
      if ((paramGroups == null) || (paramGroups.getSize() == 0))
      {
        SchedulesStationGroupSelectionActivity.this.LogD("Updating lines from server");
        SchedulesStationGroupSelectionActivity localSchedulesStationGroupSelectionActivity1 = SchedulesStationGroupSelectionActivity.this;
        SchedulesStationGroupSelectionActivity localSchedulesStationGroupSelectionActivity2 = SchedulesStationGroupSelectionActivity.this;
        SchedulesStationGroupSelectionActivity.GetAPITask localGetAPITask1 = new SchedulesStationGroupSelectionActivity.GetAPITask(localSchedulesStationGroupSelectionActivity2, null);
        localSchedulesStationGroupSelectionActivity1.callAPItask = localGetAPITask1;
        SchedulesStationGroupSelectionActivity.GetAPITask localGetAPITask2 = SchedulesStationGroupSelectionActivity.this.callAPItask;
        Void[] arrayOfVoid = new Void[0];
        AsyncTask localAsyncTask = localGetAPITask2.execute(arrayOfVoid);
        return;
      }
      SchedulesStationGroupSelectionActivity.this.LoadScreen();
    }

    protected void onPreExecute()
    {
    }

    protected void onProgressUpdate(Void[] paramArrayOfVoid)
    {
    }
  }

  static class ListViewItemHolder
  {
    public TextView headerView;
    public TextView textView;
  }

  private class SaveToDBTask extends AsyncTask<Groups, Void, Boolean>
  {
    private SaveToDBTask()
    {
    }

    protected Boolean doInBackground(Groups[] paramArrayOfGroups)
    {
      Groups localGroups = paramArrayOfGroups[0];
      if ((localGroups != null) && (localGroups.getSize() != 0));
      while (true)
      {
        try
        {
          Boolean localBoolean1 = Boolean.valueOf(SchedulesStationGroupSelectionActivity.this.saveStationGroups(localGroups));
          localBoolean2 = localBoolean1;
          return localBoolean2;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        Boolean localBoolean2 = Boolean.valueOf(false);
      }
    }

    protected void onCancelled()
    {
    }

    protected void onPostExecute(Boolean paramBoolean)
    {
    }

    protected void onPreExecute()
    {
    }
  }

  public class SchedulesGroupsAdapter extends ArrayAdapter<Group>
    implements PinnedHeaderListView.PinnedHeaderAdapter, AbsListView.OnScrollListener
  {
    HashMap<String, Integer> alphaIndexer;
    private ArrayList<Group> groups;
    private LayoutInflater inflater;
    String[] sections;

    public SchedulesGroupsAdapter(Context paramGroups, Groups arg3)
    {
      super(2130903106, localArrayList1);
      localObject.setOrder();
      ArrayList localArrayList2 = localObject.getGroups();
      this.groups = localArrayList2;
      LayoutInflater localLayoutInflater = (LayoutInflater)paramGroups.getSystemService("layout_inflater");
      this.inflater = localLayoutInflater;
    }

    public void configurePinnedHeader(View paramView, int paramInt1, int paramInt2)
    {
      TextView localTextView = (TextView)paramView.findViewById(2131493213);
      String str = ((Group)this.groups.get(paramInt1)).getCategory();
      localTextView.setText(str);
    }

    public int getPinnedHeaderState(int paramInt)
    {
      int i;
      if (this.groups.size() == 1)
        i = 0;
      while (true)
      {
        return i;
        int[] arrayOfInt = $SWITCH_TABLE$com$hopstop$ClientModel$Schedules$Group$CategoryOrder();
        int j = ((Group)this.groups.get(paramInt)).getOrder().ordinal();
        switch (arrayOfInt[j])
        {
        default:
          i = 0;
          break;
        case 1:
          i = 1;
          break;
        case 2:
          i = 1;
          break;
        case 3:
          i = 2;
        }
      }
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      SchedulesStationGroupSelectionActivity.ListViewItemHolder localListViewItemHolder;
      if (localView == null)
      {
        localView = this.inflater.inflate(2130903114, null);
        localListViewItemHolder = new SchedulesStationGroupSelectionActivity.ListViewItemHolder();
        TextView localTextView1 = (TextView)localView.findViewById(2131492875);
        localListViewItemHolder.textView = localTextView1;
        TextView localTextView2 = (TextView)localView.findViewById(2131493213);
        localListViewItemHolder.headerView = localTextView2;
        localView.setTag(localListViewItemHolder);
        TextView localTextView3 = localListViewItemHolder.textView;
        String str1 = ((Group)this.groups.get(paramInt)).getName();
        localTextView3.setText(str1);
        Group.CategoryOrder localCategoryOrder1 = ((Group)this.groups.get(paramInt)).getOrder();
        Group.CategoryOrder localCategoryOrder2 = Group.CategoryOrder.First;
        if ((localCategoryOrder1 != localCategoryOrder2) || (this.groups.size() <= 1))
          break label198;
        localListViewItemHolder.headerView.setVisibility(0);
        TextView localTextView4 = localListViewItemHolder.headerView;
        String str2 = ((Group)this.groups.get(paramInt)).getCategory();
        localTextView4.setText(str2);
      }
      while (true)
      {
        return localView;
        localListViewItemHolder = (SchedulesStationGroupSelectionActivity.ListViewItemHolder)localView.getTag();
        break;
        label198: localListViewItemHolder.headerView.setVisibility(8);
      }
    }

    public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
    {
      if (!(paramAbsListView instanceof PinnedHeaderListView))
        return;
      ((PinnedHeaderListView)paramAbsListView).configureHeaderView(paramInt1);
    }

    public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
    {
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.SchedulesStationGroupSelectionActivity
 * JD-Core Version:    0.6.2
 */