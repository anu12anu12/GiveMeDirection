package com.hopstop.ClientView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import android.widget.Toast;
import com.androidquery.AQuery;
import com.androidquery.AbstractAQuery;
import com.hopstop.ClientModel.HopStopCity;
import com.hopstop.ClientModel.Model;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.ui.BaseActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class CitiesSelectionActivity extends BaseActivity
{
  public static final String CITY_BUTTON_ID_KEY = "city_button_id";
  public static final String COUNTY_BUTTON_ID_KEY = "county_button_id";
  protected static final String INTENT_CITY_ID_SELECTED = null;
  protected static final String INTENT_CITY_NAME_SELECTED = null;
  public static final String LINEARLAYOUT_ID_KEY = "linear_layout_id";
  private AQuery aq;
  private Model model;

  protected void loadList(final ArrayList<HopStopCity> paramArrayList)
  {
    CitiesAdapter localCitiesAdapter = new CitiesAdapter(this, paramArrayList);
    ListView localListView = (ListView)findViewById(2131492873);
    if (localListView != null)
      localListView.setAdapter(localCitiesAdapter);
    AdapterView.OnItemClickListener local2 = new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        Intent localIntent1 = new Intent();
        String str1 = CitiesSelectionActivity.INTENT_CITY_ID_SELECTED;
        String str2 = ((HopStopCity)paramArrayList.get(paramAnonymousInt)).getId();
        Intent localIntent2 = localIntent1.putExtra(str1, str2);
        String str3 = CitiesSelectionActivity.INTENT_CITY_NAME_SELECTED;
        String str4 = ((HopStopCity)paramArrayList.get(paramAnonymousInt)).getName();
        Intent localIntent3 = localIntent1.putExtra(str3, str4);
        CitiesSelectionActivity.this.setResult(-1, localIntent1);
        CitiesSelectionActivity.this.finish();
      }
    };
    localListView.setOnItemClickListener(local2);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903043);
    AQuery localAQuery1 = new AQuery(this);
    this.aq = localAQuery1;
    Hashtable localHashtable = new Hashtable();
    String str = ApplicationEngine.getModel().getDefaultCityId();
    Object localObject = localHashtable.put("defaultcity", str);
    int i = ApplicationEngine.ZONE_DIRECTION_OPTIONS;
    update(i, localHashtable, null, null);
    Model localModel = ApplicationEngine.getModel();
    this.model = localModel;
    AbstractAQuery localAbstractAQuery1 = ((AQuery)this.aq.id(2131492968)).text(2130968806);
    AQuery localAQuery2 = (AQuery)this.aq.id(2131492906);
    View.OnClickListener local1 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CitiesSelectionActivity localCitiesSelectionActivity = CitiesSelectionActivity.this;
        String str1 = String.valueOf(getClass().getName());
        String str2 = str1 + "Clicked on logo";
        localCitiesSelectionActivity.LogD(str2);
        Context localContext = CitiesSelectionActivity.this.getApplicationContext();
        Intent localIntent1 = new Intent(localContext, DirectionsMainViewActivity.class);
        Intent localIntent2 = localIntent1.setFlags(335544320);
        CitiesSelectionActivity.this.getApplicationContext().startActivity(localIntent1);
      }
    };
    AbstractAQuery localAbstractAQuery2 = localAQuery2.clicked(local1);
    if (this.model.getHopStopCities() != null)
    {
      ArrayList localArrayList = this.model.getHopStopCities();
      loadList(localArrayList);
      return;
    }
    Toast.makeText(this, "An error occured, unable to load cities, please try again", 1).show();
  }

  public class CitiesAdapter extends ArrayAdapter<HopStopCity>
    implements SectionIndexer
  {
    HashMap<String, Integer> alphaIndexer;
    private ArrayList<HopStopCity> cities;
    private LayoutInflater inflater;
    String[] sections;

    public CitiesAdapter(ArrayList<HopStopCity> arg2)
    {
      super(2130903044, localList);
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
        String str = ((HopStopCity)this.cities.get(j)).getName().substring(0, 1).toUpperCase();
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
      CitiesSelectionActivity.ListViewItemHolder localListViewItemHolder;
      if (localView == null)
      {
        localView = this.inflater.inflate(2130903044, null);
        localListViewItemHolder = new CitiesSelectionActivity.ListViewItemHolder();
        TextView localTextView1 = (TextView)localView.findViewById(2131492875);
        localListViewItemHolder.textView = localTextView1;
        localView.setTag(localListViewItemHolder);
      }
      while (true)
      {
        TextView localTextView2 = localListViewItemHolder.textView;
        String str = ((HopStopCity)this.cities.get(paramInt)).getName();
        localTextView2.setText(str);
        return localView;
        localListViewItemHolder = (CitiesSelectionActivity.ListViewItemHolder)localView.getTag();
      }
    }
  }

  static class ListViewItemHolder
  {
    public TextView textView;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.CitiesSelectionActivity
 * JD-Core Version:    0.6.2
 */