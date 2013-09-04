package com.hopstop.ClientView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.androidquery.AQuery;
import com.androidquery.AbstractAQuery;
import com.hopstop.ClientModel.Model;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.ui.BaseActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class MoreActivity extends BaseActivity
{
  public AQuery aq;
  private LayoutInflater inflater;

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903081);
    AQuery localAQuery = new AQuery(this);
    this.aq = localAQuery;
    AbstractAQuery localAbstractAQuery = ((AQuery)this.aq.id(2131492968)).text("More");
    LayoutInflater localLayoutInflater = (LayoutInflater)getSystemService("layout_inflater");
    this.inflater = localLayoutInflater;
    ListView localListView = ((AQuery)this.aq.id(2131493047)).getListView();
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    Object localObject1 = localHashMap1.put("text", "MyTrips");
    String str1 = Integer.toString(2130837552);
    Object localObject2 = localHashMap1.put("image", str1);
    boolean bool1 = localArrayList.add(localHashMap1);
    HashMap localHashMap2 = new HashMap();
    Object localObject3 = localHashMap2.put("text", "Advisories");
    String str2 = Integer.toString(2130837545);
    Object localObject4 = localHashMap2.put("image", str2);
    boolean bool2 = localArrayList.add(localHashMap2);
    HashMap localHashMap3 = new HashMap();
    Object localObject5 = localHashMap3.put("text", "Feedback");
    String str3 = Integer.toString(2130837547);
    Object localObject6 = localHashMap3.put("image", str3);
    boolean bool3 = localArrayList.add(localHashMap3);
    HashMap localHashMap4 = new HashMap();
    Object localObject7 = localHashMap4.put("text", "Settings");
    String str4 = Integer.toString(2130837555);
    Object localObject8 = localHashMap4.put("image", str4);
    boolean bool4 = localArrayList.add(localHashMap4);
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "text";
    arrayOfString[1] = "image";
    int[] arrayOfInt = { 2131493046, 2131493048 };
    Context localContext = getBaseContext();
    SimpleAdapter localSimpleAdapter = new SimpleAdapter(localContext, localArrayList, 2130903082, arrayOfString, arrayOfInt);
    localListView.setAdapter(localSimpleAdapter);
    AdapterView.OnItemClickListener local1 = new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (paramAnonymousInt == 0)
        {
          MoreActivity localMoreActivity1 = MoreActivity.this;
          Intent localIntent1 = new Intent(localMoreActivity1, MoreMyTripsActivity.class);
          MoreActivity.this.startActivity(localIntent1);
          return;
        }
        if (paramAnonymousInt == 1)
        {
          MoreActivity localMoreActivity2 = MoreActivity.this;
          Intent localIntent2 = new Intent(localMoreActivity2, MoreServiceAdvisorActivity.class);
          MoreActivity.this.startActivity(localIntent2);
          return;
        }
        if (paramAnonymousInt == 2)
        {
          MoreActivity localMoreActivity3 = MoreActivity.this;
          Intent localIntent3 = new Intent(localMoreActivity3, MoreFeedbackActivity.class);
          MoreActivity.this.startActivity(localIntent3);
          return;
        }
        if (paramAnonymousInt != 3)
          return;
        MoreActivity localMoreActivity4 = MoreActivity.this;
        Intent localIntent4 = new Intent(localMoreActivity4, MoreSettingsActivity.class);
        MoreActivity.this.startActivity(localIntent4);
      }
    };
    localListView.setOnItemClickListener(local1);
    Hashtable localHashtable = new Hashtable();
    String str5 = ApplicationEngine.getModel().getDefaultCityId();
    Object localObject9 = localHashtable.put("defaultcity", str5);
    update(152036, localHashtable, null, null);
    trackEvent("More Screen");
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.MoreActivity
 * JD-Core Version:    0.6.2
 */