package com.hopstop.ClientView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.hopstop.ClientModel.Model;
import com.hopstop.ClientView.anim.ViewStepSubwayVehicle;
import com.hopstop.ClientView.anim.ViewStepSubwayVehicleSubClass;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.network.NetworkEngine;
import com.hopstop.ui.BaseActivity;
import com.hopstop.util.Util;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

public class MoreSubwayAdvisoriesDetailActivity extends BaseActivity
{
  public static final String DATE_FORMAT_NOW = "HH:mm a";

  private String description(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder("<p><b><font size=\"3\" color=#000000>Posted: ").append(paramString1).append("</font></b><br /><font size=\"2\" color=#000000>").append(paramString2);
    String str = "</font></p>".toString();
    return str;
  }

  public static String now()
  {
    Calendar localCalendar = Calendar.getInstance();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm a");
    Date localDate = localCalendar.getTime();
    return localSimpleDateFormat.format(localDate);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903131);
    Hashtable localHashtable = new Hashtable();
    String str1 = ApplicationEngine.getModel().getDefaultCityId();
    Object localObject = localHashtable.put("defaultcity", str1);
    int i = ApplicationEngine.ZONE_ADVISORIES;
    update(i, localHashtable, null, null);
    View localView = findViewById(2131492906);
    View.OnClickListener local1 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Context localContext = MoreSubwayAdvisoriesDetailActivity.this.getApplicationContext();
        Intent localIntent1 = new Intent(localContext, DirectionsMainViewActivity.class);
        Intent localIntent2 = localIntent1.setFlags(335544320);
        MoreSubwayAdvisoriesDetailActivity.this.getApplicationContext().startActivity(localIntent1);
      }
    };
    localView.setOnClickListener(local1);
    ViewStepSubwayVehicleSubClass localViewStepSubwayVehicleSubClass = (ViewStepSubwayVehicleSubClass)getIntent().getSerializableExtra("advisorVehicleCopy");
    Bitmap localBitmap = Util.getBitmapFromByteArray(getIntent().getExtras().getByteArray("advisorVehicleImage"));
    ((ImageView)findViewById(2131493273)).setVisibility(4);
    ImageView localImageView = (ImageView)findViewById(2131493271);
    ViewStepSubwayVehicle localViewStepSubwayVehicle = new ViewStepSubwayVehicle();
    String str2 = localViewStepSubwayVehicleSubClass.getStatusDescription();
    localViewStepSubwayVehicle.setStatusDescription(str2);
    String str3 = localViewStepSubwayVehicleSubClass.get_status();
    localViewStepSubwayVehicle.setStatus(str3);
    String str4 = localViewStepSubwayVehicleSubClass.geType();
    localViewStepSubwayVehicle.setType(str4);
    String str5 = localViewStepSubwayVehicleSubClass.getVerbTime();
    localViewStepSubwayVehicle.setVerbTime(str5);
    String str6 = localViewStepSubwayVehicleSubClass.getName();
    localViewStepSubwayVehicle.setName(str6);
    localViewStepSubwayVehicle.setImageView(localImageView);
    if (localBitmap == null)
      if (NetworkEngine.dataNetworkAvail(this))
      {
        String str7 = localViewStepSubwayVehicleSubClass.getURL();
        localViewStepSubwayVehicle.setURL(str7, false, true);
      }
    while (true)
    {
      TextView localTextView1 = (TextView)findViewById(2131493269);
      String str8 = localTextView1.getText().toString();
      Object[] arrayOfObject = new Object[1];
      String str9 = localViewStepSubwayVehicleSubClass.getTimeOfDownload();
      arrayOfObject[0] = str9;
      String str10 = String.format(str8, arrayOfObject);
      localTextView1.setText(str10);
      TextView localTextView2 = (TextView)findViewById(2131493272);
      String str11 = localViewStepSubwayVehicle.getStatus();
      localTextView2.setText(str11);
      TextView localTextView3 = (TextView)findViewById(2131493270);
      String str12 = localViewStepSubwayVehicle.getVerbTime();
      String str13 = localViewStepSubwayVehicle.getStatusDescription();
      Spanned localSpanned = Html.fromHtml(description(str12, str13));
      localTextView3.setText(localSpanned);
      trackEvent("Advisories Subway Details Screen");
      return;
      localImageView.setImageBitmap(localBitmap);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.MoreSubwayAdvisoriesDetailActivity
 * JD-Core Version:    0.6.2
 */