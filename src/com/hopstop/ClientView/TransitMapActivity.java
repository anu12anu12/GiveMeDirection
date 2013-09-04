package com.hopstop.ClientView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.hopstop.ClientModel.Model;
import com.hopstop.core.ApplicationEngine;
import com.ls.widgets.map.interfaces.MapEventsListener;
import com.ls.widgets.map.interfaces.OnMapTouchListener;
import java.util.Hashtable;

public class TransitMapActivity extends InteractiveMapActivity
  implements MapEventsListener, OnMapTouchListener
{
  public static final String HAS_ATTRIBUTION_IMAGE_KEY = "TransitMapsAttributionImage";
  public static final String MAP_ASSET_KEY = "TransitMapsAsset";
  public static final String MAP_LABEL_KEY = "MapLabel";
  public static final String PAGE_NAME_KEY = "TransitMapsPageName";
  int attributionImagePath;
  int attributionKey;
  Boolean hasAttributionImage;
  String mapAsset;
  String mapLabel;
  String pageName;

  private void setAttribution()
  {
    String str1 = this.mapLabel;
    String str2 = getString(2130968713);
    if (str1.equals(str2))
    {
      this.attributionKey = 2130968723;
      return;
    }
    String str3 = this.mapLabel;
    String str4 = getString(2130968715);
    if (str3.equals(str4))
    {
      this.attributionKey = 2130968725;
      return;
    }
    String str5 = this.mapLabel;
    String str6 = getString(2130968716);
    if (str5.equals(str6))
    {
      this.attributionKey = 2130968727;
      this.attributionImagePath = 2130837527;
      return;
    }
    String str7 = this.mapLabel;
    String str8 = getString(2130968717);
    if (str7.equals(str8))
    {
      this.attributionKey = 2130968726;
      return;
    }
    String str9 = this.mapLabel;
    String str10 = getString(2130968812);
    if (str9.equals(str10))
    {
      this.attributionKey = 2130968730;
      return;
    }
    String str11 = this.mapLabel;
    String str12 = getString(2130968813);
    if (str11.equals(str12))
    {
      this.attributionKey = 2130968791;
      return;
    }
    String str13 = this.mapLabel;
    String str14 = getString(2130968795);
    if (!str13.equals(str14))
      return;
    this.attributionKey = 2130968794;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1)
      return;
    setContent(paramIntent);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903079);
    Intent localIntent = getIntent();
    setContent(localIntent);
  }

  public void onPause()
  {
    String str1 = this.mapLabel;
    setSharedPreferenceString("MapLabel", str1);
    String str2 = this.mapAsset;
    setSharedPreferenceString("TransitMapsAsset", str2);
    String str3 = this.pageName;
    setSharedPreferenceString("TransitMapsPageName", str3);
    boolean bool = this.hasAttributionImage.booleanValue();
    setSharedPreferenceBoolean("TransitMapsAttributionImage", bool);
    super.onPause();
  }

  public void setContent(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("MapLabel");
    this.mapLabel = str1;
    if (this.mapLabel != null)
    {
      String str2 = paramIntent.getStringExtra("TransitMapsAsset");
      this.mapAsset = str2;
      String str3 = paramIntent.getStringExtra("TransitMapsPageName");
      this.pageName = str3;
      Boolean localBoolean1 = Boolean.valueOf(paramIntent.getBooleanExtra("TransitMapsAttributionImage", false));
      this.hasAttributionImage = localBoolean1;
      if (this.mapLabel == null)
      {
        if (!ApplicationEngine.getModel().getDefaultCityId().equals("sanfrancisco"))
          break label424;
        String str4 = getString(2130968715);
        this.mapLabel = str4;
        String str5 = ApplicationEngine.SAN_FRANSE_MAP_ASSETS;
        this.mapAsset = str5;
        this.attributionKey = 2130968725;
        this.pageName = "San Franse Transit Map Screen";
        Boolean localBoolean2 = Boolean.valueOf(false);
        this.hasAttributionImage = localBoolean2;
        this.attributionImagePath = 0;
      }
      label138: if (this.mapLabel == null)
        break label782;
      TextView localTextView = (TextView)findViewById(2131492958);
      String str6 = this.mapLabel;
      localTextView.setText(str6);
      setAttribution();
      String str7 = this.mapAsset;
      String str8 = ApplicationEngine.NYC_BUS_MANHATTAN_ASSETS;
      if (!str7.equals(str8))
        break label751;
      String str9 = this.mapAsset;
      int i = ApplicationEngine.TRANSIT_MAP_MIN_ZOOM_LEVEL;
      int j = ApplicationEngine.TRANSIT_MAP_MAX_ZOOM_LEVEL + 1;
      initMap(str9, 10, i, j);
    }
    while (true)
    {
      View localView = findViewById(2131492906);
      View.OnClickListener local1 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Context localContext = TransitMapActivity.this.getApplicationContext();
          Intent localIntent1 = new Intent(localContext, DirectionsMainViewActivity.class);
          Intent localIntent2 = localIntent1.setFlags(335544320);
          TransitMapActivity.this.getApplicationContext().startActivity(localIntent1);
        }
      };
      localView.setOnClickListener(local1);
      Button localButton = (Button)findViewById(2131493041);
      View.OnClickListener local2 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          TransitMapActivity localTransitMapActivity = TransitMapActivity.this;
          Intent localIntent = new Intent(localTransitMapActivity, TransitMapListActivity.class);
          TransitMapActivity.this.startActivityForResult(localIntent, 8);
        }
      };
      localButton.setOnClickListener(local2);
      Hashtable localHashtable = new Hashtable();
      String str10 = ApplicationEngine.getModel().getDefaultCityId();
      Object localObject = localHashtable.put("defaultcity", str10);
      int k = ApplicationEngine.ZONE_TRANSIT_MAPS;
      update(k, localHashtable, null, null);
      ImageView localImageView = (ImageView)findViewById(2131493042);
      View.OnClickListener local3 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          TransitMapActivity localTransitMapActivity = TransitMapActivity.this;
          int i = TransitMapActivity.this.attributionKey;
          boolean bool = TransitMapActivity.this.hasAttributionImage.booleanValue();
          int j = TransitMapActivity.this.attributionImagePath;
          localTransitMapActivity.showPowerByDialog(i, bool, j);
        }
      };
      localImageView.setOnClickListener(local3);
      String str11 = this.pageName;
      trackEvent(str11);
      return;
      String str12 = getSharedPreferenceString("MapLabel");
      this.mapLabel = str12;
      String str13 = getSharedPreferenceString("TransitMapsAsset");
      this.mapAsset = str13;
      String str14 = getSharedPreferenceString("TransitMapsPageName");
      this.pageName = str14;
      Boolean localBoolean3 = Boolean.valueOf(getSharedPreferenceBoolean("TransitMapsAttributionImage", false));
      this.hasAttributionImage = localBoolean3;
      break;
      label424: if (ApplicationEngine.getModel().getDefaultCityId().equals("chicago"))
      {
        String str15 = getString(2130968716);
        this.mapLabel = str15;
        String str16 = ApplicationEngine.CHICAGO_CTA_MAP_ASSETS;
        this.mapAsset = str16;
        this.attributionKey = 2130968727;
        this.pageName = "Chicago CTA Transit Map Screen";
        Boolean localBoolean4 = Boolean.valueOf(true);
        this.hasAttributionImage = localBoolean4;
        this.attributionImagePath = 2130837527;
        break label138;
      }
      if (ApplicationEngine.getModel().getDefaultCityId().equals("washington"))
      {
        String str17 = getString(2130968717);
        this.mapLabel = str17;
        String str18 = ApplicationEngine.WASHINGTON_WMATA_MAP_ASSETS;
        this.mapAsset = str18;
        this.attributionKey = 2130968726;
        this.pageName = "Washington DC WMATA Transit Map Screen";
        Boolean localBoolean5 = Boolean.valueOf(false);
        this.hasAttributionImage = localBoolean5;
        this.attributionImagePath = 0;
        break label138;
      }
      if (ApplicationEngine.getModel().getDefaultCityId().equals("boston"))
      {
        this.mapLabel = "Boston MBTA Subway";
        String str19 = ApplicationEngine.BOSTON_MBTA_SUBWAY_MAP_ASSETS;
        this.mapAsset = str19;
        this.attributionKey = 2130968730;
        this.pageName = "Boston MBTA Transit Map Screen";
        Boolean localBoolean6 = Boolean.valueOf(false);
        this.hasAttributionImage = localBoolean6;
        this.attributionImagePath = 0;
        break label138;
      }
      if (ApplicationEngine.getModel().getDefaultCityId().equals("london"))
      {
        this.mapLabel = "London Underground";
        String str20 = ApplicationEngine.LONDON_UNDERGROUND_MAP_ASSETS;
        this.mapAsset = str20;
        this.attributionKey = 2130968791;
        this.pageName = "London Underground Transit Map Screen";
        Boolean localBoolean7 = Boolean.valueOf(false);
        this.hasAttributionImage = localBoolean7;
        this.attributionImagePath = 0;
        break label138;
      }
      String str21 = getString(2130968713);
      this.mapLabel = str21;
      String str22 = ApplicationEngine.NYC_TRANSIT_MAP_ASSETS;
      this.mapAsset = str22;
      this.attributionKey = 2130968723;
      this.pageName = "NYC Transit Map Screen";
      Boolean localBoolean8 = Boolean.valueOf(false);
      this.hasAttributionImage = localBoolean8;
      this.attributionImagePath = 0;
      break label138;
      label751: String str23 = this.mapAsset;
      int m = ApplicationEngine.TRANSIT_MAP_MIN_ZOOM_LEVEL;
      int n = ApplicationEngine.TRANSIT_MAP_MAX_ZOOM_LEVEL;
      initMap(str23, 10, m, n);
      continue;
      label782: ((TextView)findViewById(2131493044)).setVisibility(0);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.TransitMapActivity
 * JD-Core Version:    0.6.2
 */