package com.hopstop;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.crashlytics.android.Crashlytics;
import com.crittercism.app.Crittercism;
import com.hopstop.ClientModel.DateTimeUtil;
import com.hopstop.ClientModel.Model;
import com.hopstop.ClientModel.db.HistoryManager;
import com.hopstop.ClientView.DirectionsMainViewActivity;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.ui.BaseActivity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

public class SplashScreen extends BaseActivity
{
  private final int INITIALIZE = 1;
  private final long SPLASHTIME = 0L;
  private final int STOPSPLASH = 0;
  private Uri hyperlink_uri;
  private String scheme;
  private Handler splashHandler;
  private DateTimeUtil time;

  public SplashScreen()
  {
    DateTimeUtil localDateTimeUtil = new DateTimeUtil();
    this.time = localDateTimeUtil;
    this.hyperlink_uri = null;
    this.scheme = null;
    Handler local1 = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        default:
        case 0:
        case 1:
        }
        while (true)
        {
          super.handleMessage(paramAnonymousMessage);
          return;
          SplashScreen localSplashScreen = SplashScreen.this;
          Intent localIntent1 = new Intent(localSplashScreen, DirectionsMainViewActivity.class);
          if (SplashScreen.this.hyperlink_uri != null)
          {
            Intent localIntent2 = localIntent1.putExtra("hyperlink_uri_at_startup", true);
            String str = SplashScreen.this.scheme;
            Intent localIntent3 = localIntent1.putExtra("host_at_startup", str);
            Uri localUri = SplashScreen.this.hyperlink_uri;
            Intent localIntent4 = localIntent1.setData(localUri);
          }
          SplashScreen.this.startActivity(localIntent1);
          SplashScreen.this.finish();
          continue;
          SplashScreen.this.initializeData();
        }
      }
    };
    this.splashHandler = local1;
  }

  public void initializeData()
  {
    InitDataTask localInitDataTask = new InitDataTask();
    SplashScreen[] arrayOfSplashScreen = new SplashScreen[1];
    arrayOfSplashScreen[0] = this;
    AsyncTask localAsyncTask = localInitDataTask.execute(arrayOfSplashScreen);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Crashlytics.start(this);
    Context localContext = getApplicationContext();
    boolean[] arrayOfBoolean = new boolean[0];
    Crittercism.init(localContext, "4fe1e707be790e3380000004", arrayOfBoolean);
    String str1;
    if (getIntent() != null)
    {
      Uri localUri = getIntent().getData();
      this.hyperlink_uri = localUri;
      if (this.hyperlink_uri != null)
      {
        str1 = this.hyperlink_uri.getHost();
        if (str1 == null)
          break label174;
        if (!str1.startsWith("com.android.contacts"))
          break label146;
        String str2 = this.hyperlink_uri.getHost();
        this.scheme = str2;
      }
    }
    while (true)
    {
      ApplicationEngine.DISPLAY_WIDTH = ((WindowManager)getSystemService("window")).getDefaultDisplay().getWidth();
      PackageManager localPackageManager = getPackageManager();
      try
      {
        int i = localPackageManager.getPackageInfo("com.hopstop", 2).versionCode;
        ApplicationEngine.DEVICE_DENSITY = getResources().getDisplayMetrics().density;
        return;
        label146: if (!str1.contains("hopstop.com"))
          continue;
        String str3 = this.hyperlink_uri.getHost();
        this.scheme = str3;
        continue;
        label174: if (!this.hyperlink_uri.toString().startsWith("geo:"))
          continue;
        this.scheme = "geo:";
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        while (true)
          localNameNotFoundException.printStackTrace();
      }
    }
  }

  public void onRestart()
  {
    super.onRestart();
  }

  public void onStart()
  {
    super.onStart();
    setContentView(2130903125);
    Message localMessage = new Message();
    localMessage.what = 1;
    boolean bool = this.splashHandler.sendMessageDelayed(localMessage, 1L);
  }

  protected class InitDataTask extends AsyncTask<SplashScreen, Integer, String>
  {
    protected InitDataTask()
    {
    }

    protected String doInBackground(SplashScreen[] paramArrayOfSplashScreen)
    {
      SplashScreen localSplashScreen1 = paramArrayOfSplashScreen[0];
      HistoryManager localHistoryManager = new HistoryManager(localSplashScreen1);
      SplashScreen localSplashScreen2 = paramArrayOfSplashScreen[0];
      ArrayList localArrayList1 = localHistoryManager.loadCities(localSplashScreen2);
      boolean bool = ApplicationEngine.getModel().addHopStopCities(localArrayList1);
      ApplicationEngine.getModel().updateCitiesMap();
      Model localModel = ApplicationEngine.getModel();
      SplashScreen localSplashScreen3 = paramArrayOfSplashScreen[0];
      LinkedList localLinkedList = localHistoryManager.loadHistoryVisits(localSplashScreen3);
      localModel.initHistory(localLinkedList);
      int i = Calendar.getInstance().get(7) + -1;
      if (i > 0);
      while (true)
      {
        ApplicationEngine.getModel().setDay(i);
        ApplicationEngine.getModel().setTime("");
        ArrayList localArrayList2 = ApplicationEngine.getModel().getMyTrips();
        localArrayList2.clear();
        ArrayList localArrayList3 = localHistoryManager.loadMyTrips(localArrayList2);
        return null;
        i = 7;
      }
    }

    protected void onPostExecute(String paramString)
    {
      Message localMessage = new Message();
      localMessage.what = 0;
      boolean bool = SplashScreen.this.splashHandler.sendMessageDelayed(localMessage, 0L);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.SplashScreen
 * JD-Core Version:    0.6.2
 */