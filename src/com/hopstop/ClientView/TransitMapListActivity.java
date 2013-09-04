package com.hopstop.ClientView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.hopstop.ClientModel.Model;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.ui.BaseActivity;
import java.util.Hashtable;

public class TransitMapListActivity extends BaseActivity
{
  private void sendTransitMapsFeedbackEmail()
  {
    String str1 = getString(2130968653);
    String str2 = "\n\n\nSent from HopStop Android App " + str1;
    sendEmail("transitmaps@hopstop.com", "HopStop Android App - Transit Map Feedback", str2);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903140);
    Hashtable localHashtable = new Hashtable();
    String str = ApplicationEngine.getModel().getDefaultCityId();
    Object localObject = localHashtable.put("defaultcity", str);
    int i = ApplicationEngine.ZONE_TRANSIT_MAPS;
    update(i, localHashtable, null, null);
    Button localButton1 = (Button)findViewById(2131493295);
    View.OnClickListener local1 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        TransitMapListActivity localTransitMapListActivity = TransitMapListActivity.this;
        Intent localIntent1 = new Intent(localTransitMapListActivity, TransitMapActivity.class);
        String str1 = TransitMapListActivity.this.getString(2130968713);
        Intent localIntent2 = localIntent1.putExtra("MapLabel", str1);
        String str2 = ApplicationEngine.NYC_TRANSIT_MAP_ASSETS;
        Intent localIntent3 = localIntent1.putExtra("TransitMapsAsset", str2);
        Intent localIntent4 = localIntent1.putExtra("TransitMapsPageName", "NYC Transit Map Screen");
        Intent localIntent5 = localIntent1.putExtra("TransitMapsAttributionImage", false);
        TransitMapListActivity.this.setResult(-1, localIntent1);
        TransitMapListActivity.this.finish();
      }
    };
    localButton1.setOnClickListener(local1);
    Button localButton2 = (Button)findViewById(2131493297);
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        TransitMapListActivity localTransitMapListActivity = TransitMapListActivity.this;
        Intent localIntent1 = new Intent(localTransitMapListActivity, TransitMapActivity.class);
        String str1 = TransitMapListActivity.this.getString(2130968715);
        Intent localIntent2 = localIntent1.putExtra("MapLabel", str1);
        String str2 = ApplicationEngine.SAN_FRANSE_MAP_ASSETS;
        Intent localIntent3 = localIntent1.putExtra("TransitMapsAsset", str2);
        Intent localIntent4 = localIntent1.putExtra("TransitMapsPageName", "San Franse Transit Map Screen");
        Intent localIntent5 = localIntent1.putExtra("TransitMapsAttributionImage", false);
        TransitMapListActivity.this.setResult(-1, localIntent1);
        TransitMapListActivity.this.finish();
      }
    };
    localButton2.setOnClickListener(local2);
    Button localButton3 = (Button)findViewById(2131493293);
    View.OnClickListener local3 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        TransitMapListActivity localTransitMapListActivity = TransitMapListActivity.this;
        Intent localIntent1 = new Intent(localTransitMapListActivity, TransitMapActivity.class);
        String str1 = TransitMapListActivity.this.getString(2130968716);
        Intent localIntent2 = localIntent1.putExtra("MapLabel", str1);
        String str2 = ApplicationEngine.CHICAGO_CTA_MAP_ASSETS;
        Intent localIntent3 = localIntent1.putExtra("TransitMapsAsset", str2);
        Intent localIntent4 = localIntent1.putExtra("TransitMapsPageName", "Chicago CTA Transit Map Screen");
        Intent localIntent5 = localIntent1.putExtra("TransitMapsAttributionImage", true);
        TransitMapListActivity.this.setResult(-1, localIntent1);
        TransitMapListActivity.this.finish();
      }
    };
    localButton3.setOnClickListener(local3);
    Button localButton4 = (Button)findViewById(2131493298);
    View.OnClickListener local4 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        TransitMapListActivity localTransitMapListActivity = TransitMapListActivity.this;
        Intent localIntent1 = new Intent(localTransitMapListActivity, TransitMapActivity.class);
        String str1 = TransitMapListActivity.this.getString(2130968717);
        Intent localIntent2 = localIntent1.putExtra("MapLabel", str1);
        String str2 = ApplicationEngine.WASHINGTON_WMATA_MAP_ASSETS;
        Intent localIntent3 = localIntent1.putExtra("TransitMapsAsset", str2);
        Intent localIntent4 = localIntent1.putExtra("TransitMapsPageName", "Washington DC WMATA Transit Map Screen");
        Intent localIntent5 = localIntent1.putExtra("TransitMapsAttributionImage", false);
        TransitMapListActivity.this.setResult(-1, localIntent1);
        TransitMapListActivity.this.finish();
      }
    };
    localButton4.setOnClickListener(local4);
    Button localButton5 = (Button)findViewById(2131493292);
    View.OnClickListener local5 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        TransitMapListActivity localTransitMapListActivity = TransitMapListActivity.this;
        Intent localIntent1 = new Intent(localTransitMapListActivity, TransitMapActivity.class);
        String str1 = TransitMapListActivity.this.getString(2130968812);
        Intent localIntent2 = localIntent1.putExtra("MapLabel", str1);
        String str2 = ApplicationEngine.BOSTON_MBTA_SUBWAY_MAP_ASSETS;
        Intent localIntent3 = localIntent1.putExtra("TransitMapsAsset", str2);
        Intent localIntent4 = localIntent1.putExtra("TransitMapsPageName", "Boston MBTA Transit Map Screen");
        Intent localIntent5 = localIntent1.putExtra("TransitMapsAttributionImage", false);
        TransitMapListActivity.this.setResult(-1, localIntent1);
        TransitMapListActivity.this.finish();
      }
    };
    localButton5.setOnClickListener(local5);
    Button localButton6 = (Button)findViewById(2131493294);
    View.OnClickListener local6 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        TransitMapListActivity localTransitMapListActivity = TransitMapListActivity.this;
        Intent localIntent1 = new Intent(localTransitMapListActivity, TransitMapActivity.class);
        String str1 = TransitMapListActivity.this.getString(2130968813);
        Intent localIntent2 = localIntent1.putExtra("MapLabel", str1);
        String str2 = ApplicationEngine.LONDON_UNDERGROUND_MAP_ASSETS;
        Intent localIntent3 = localIntent1.putExtra("TransitMapsAsset", str2);
        Intent localIntent4 = localIntent1.putExtra("TransitMapsPageName", "London Underground Transit Map Screen");
        Intent localIntent5 = localIntent1.putExtra("TransitMapsAttributionImage", false);
        TransitMapListActivity.this.setResult(-1, localIntent1);
        TransitMapListActivity.this.finish();
      }
    };
    localButton6.setOnClickListener(local6);
    Button localButton7 = (Button)findViewById(2131493296);
    View.OnClickListener local7 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        TransitMapListActivity localTransitMapListActivity = TransitMapListActivity.this;
        Intent localIntent1 = new Intent(localTransitMapListActivity, TransitMapActivity.class);
        String str1 = TransitMapListActivity.this.getString(2130968795);
        Intent localIntent2 = localIntent1.putExtra("MapLabel", str1);
        String str2 = ApplicationEngine.NYC_BUS_MANHATTAN_ASSETS;
        Intent localIntent3 = localIntent1.putExtra("TransitMapsAsset", str2);
        Intent localIntent4 = localIntent1.putExtra("TransitMapsPageName", "NYC Manhattan Bus Transit Map Screen");
        Intent localIntent5 = localIntent1.putExtra("TransitMapsAttributionImage", false);
        TransitMapListActivity.this.setResult(-1, localIntent1);
        TransitMapListActivity.this.finish();
      }
    };
    localButton7.setOnClickListener(local7);
    Button localButton8 = (Button)findViewById(2131493302);
    View.OnClickListener local8 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        TransitMapListActivity.this.sendTransitMapsFeedbackEmail();
      }
    };
    localButton8.setOnClickListener(local8);
    View localView = findViewById(2131492906);
    View.OnClickListener local9 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Context localContext = TransitMapListActivity.this.getApplicationContext();
        Intent localIntent1 = new Intent(localContext, DirectionsMainViewActivity.class);
        Intent localIntent2 = localIntent1.setFlags(335544320);
        TransitMapListActivity.this.getApplicationContext().startActivity(localIntent1);
      }
    };
    localView.setOnClickListener(local9);
    trackEvent("Transit Map Screen");
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.TransitMapListActivity
 * JD-Core Version:    0.6.2
 */