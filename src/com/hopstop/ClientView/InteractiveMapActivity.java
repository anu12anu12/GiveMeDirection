package com.hopstop.ClientView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.ui.BaseActivity;
import com.ls.widgets.map.MapWidget;
import com.ls.widgets.map.config.MapGraphicsConfig;
import com.ls.widgets.map.config.OfflineMapConfig;
import com.ls.widgets.map.events.MapTouchedEvent;
import com.ls.widgets.map.interfaces.MapEventsListener;
import com.ls.widgets.map.interfaces.OnMapTouchListener;

public class InteractiveMapActivity extends BaseActivity
  implements MapEventsListener, OnMapTouchListener
{
  private static final int MAP_ID = 23;
  private Dialog _dialog = null;
  private Handler handler;
  private MapWidget map;

  public InteractiveMapActivity()
  {
    Handler local1 = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        if (paramAnonymousMessage.what != 0)
          return;
        InteractiveMapActivity.this._dialog.dismiss();
      }
    };
    this.handler = local1;
  }

  private void sendFeedbackEmail()
  {
    String str1 = getString(2130968653);
    String str2 = "\n\n\nSent from HopStop Android App " + str1;
    sendEmail("transitmaps@hopstop.com", "HopStop Android App - Transit Map Feedback", str2);
  }

  public void GoHome()
  {
    Context localContext = getApplicationContext();
    Intent localIntent1 = new Intent(localContext, DirectionsMainViewActivity.class);
    Intent localIntent2 = localIntent1.setFlags(335544320);
    getApplicationContext().startActivity(localIntent1);
  }

  protected void initMap(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    MapWidget localMapWidget1 = new MapWidget(this, paramString, paramInt1);
    this.map = localMapWidget1;
    this.map.setId(23);
    OfflineMapConfig localOfflineMapConfig = this.map.getConfig();
    localOfflineMapConfig.setZoomBtnsVisible(true);
    localOfflineMapConfig.setPinchZoomEnabled(true);
    localOfflineMapConfig.setFlingEnabled(true);
    MapGraphicsConfig localMapGraphicsConfig = localOfflineMapConfig.getGraphicsConfig();
    localMapGraphicsConfig.setAccuracyAreaColor(1440800992);
    localMapGraphicsConfig.setAccuracyAreaBorderColor(-16776961);
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131493043);
    localRelativeLayout.removeAllViewsInLayout();
    MapWidget localMapWidget2 = this.map;
    localRelativeLayout.addView(localMapWidget2, 0);
    int i = Color.parseColor(ApplicationEngine.TRANSIT_MAP_BACKGROUND_COLOR);
    localRelativeLayout.setBackgroundColor(i);
    if (paramInt2 > 0)
      this.map.setMinZoomLevel(paramInt2);
    if (paramInt3 <= 0)
      return;
    this.map.setMaxZoomLevel(paramInt3);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }

  public void onDestroy()
  {
    super.onDestroy();
  }

  protected void onPause()
  {
    super.onPause();
  }

  public void onPostZoomIn()
  {
  }

  public void onPostZoomOut()
  {
  }

  public void onPreZoomIn()
  {
  }

  public void onPreZoomOut()
  {
  }

  protected void onRestart()
  {
    super.onRestart();
  }

  public void onResume()
  {
    super.onResume();
  }

  protected void onStart()
  {
    super.onStart();
  }

  protected void onStop()
  {
    super.onStop();
  }

  public void onTouch(MapWidget paramMapWidget, MapTouchedEvent paramMapTouchedEvent)
  {
  }

  protected void showPowerByDialog(int paramInt)
  {
    Dialog localDialog = new Dialog(this);
    this._dialog = localDialog;
    this._dialog.setContentView(2130903100);
    this._dialog.setTitle("Map Info");
    this._dialog.setCancelable(true);
    ((TextView)this._dialog.findViewById(2131493161)).setText(paramInt);
    Button localButton1 = (Button)this._dialog.findViewById(2131493163);
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        InteractiveMapActivity.this.sendFeedbackEmail();
      }
    };
    localButton1.setOnClickListener(local2);
    Button localButton2 = (Button)this._dialog.findViewById(2131493164);
    View.OnClickListener local3 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Message localMessage = new Message();
        localMessage.what = 0;
        boolean bool = InteractiveMapActivity.this.handler.sendMessage(localMessage);
      }
    };
    localButton2.setOnClickListener(local3);
    this._dialog.show();
  }

  protected void showPowerByDialog(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Dialog localDialog = new Dialog(this);
    this._dialog = localDialog;
    this._dialog.setContentView(2130903100);
    this._dialog.setTitle("Map Info");
    this._dialog.setCancelable(true);
    if (paramBoolean)
      ((ImageView)this._dialog.findViewById(2131493160)).setImageResource(paramInt2);
    ((TextView)this._dialog.findViewById(2131493161)).setText(paramInt1);
    Button localButton1 = (Button)this._dialog.findViewById(2131493163);
    View.OnClickListener local4 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        InteractiveMapActivity.this.sendFeedbackEmail();
      }
    };
    localButton1.setOnClickListener(local4);
    Button localButton2 = (Button)this._dialog.findViewById(2131493164);
    View.OnClickListener local5 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Message localMessage = new Message();
        localMessage.what = 0;
        boolean bool = InteractiveMapActivity.this.handler.sendMessage(localMessage);
      }
    };
    localButton2.setOnClickListener(local5);
    this._dialog.show();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.InteractiveMapActivity
 * JD-Core Version:    0.6.2
 */