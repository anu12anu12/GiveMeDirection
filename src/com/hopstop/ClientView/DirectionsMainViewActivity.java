package com.hopstop.ClientView;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.text.Editable;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Toast;
import com.androidquery.AQuery;
import com.androidquery.AbstractAQuery;
import com.crashlytics.android.Crashlytics;
import com.hopstop.ClientController.Controller;
import com.hopstop.ClientModel.Address;
import com.hopstop.ClientModel.DirectionMode;
import com.hopstop.ClientModel.DirectionRequest;
import com.hopstop.ClientModel.DirectionResponse;
import com.hopstop.ClientModel.Model;
import com.hopstop.ClientModel.TaxiResponse;
import com.hopstop.SplashScreen;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.core.ApplicationEngine.UiCallBack;
import com.hopstop.gps.GPSEngine;
import com.hopstop.gps.XSPLocationManager;
import com.hopstop.network.NetworkEngine;
import com.hopstop.network.NetworkSettings;
import com.hopstop.ui.BaseActivity;
import com.hopstop.ui.PageNames;
import com.hopstop.util.Util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Timer;
import java.util.TimerTask;

public class DirectionsMainViewActivity extends BaseActivity
  implements Runnable
{
  private final String AMAZON_STORE_URL;
  private final String AMAZON_VERSION_URL;
  private final String ANDROID_MARKET_URL;
  private final int CURRENT_LOCATION_REQ_TIMER;
  private final long DELAY_TIME;
  private final String MARKET_VERSION_URL;
  private final int MAX_MAP_LENGTH;
  private final int NO_CHANGE;
  public final int REQ_SHARE;
  private ProgressDialog _progressDialog;
  private Timer _timer;
  private EditText address_a;
  private EditText address_b;
  private AlertDialog alert;
  private AlertDialog alert2;
  private AlertDialog alert3;
  private Handler alertHandler;
  private Handler alertHandler2;
  private Handler alertHandler3;
  private Handler alertHandlerMsg;
  private AlertDialog alertMsg;
  private AQuery aq;
  private AlertDialog.Builder builder;
  private AlertDialog.Builder builder2;
  private AlertDialog.Builder builder3;
  private AlertDialog.Builder builderMsg;
  private String defaultCity;
  private int defaultCounty;
  private Button departure;
  private Handler handler;
  private boolean isBuilderShowing = false;
  private boolean isMainScreen;
  private int locationButton;
  public int[] mapAllowedSize;
  private EditText map_req_address;
  private Button option_mode;
  private int run_thread_request = 0;
  private boolean shouldUpdateHistoryA = false;
  private boolean shouldUpdateHistoryB = false;
  private String store_address_end;
  private String store_address_start;
  private double store_address_x1;
  private double store_address_x2;
  private double store_address_y1;
  private double store_address_y2;
  private boolean store_consider_end_xy;
  private boolean store_consider_start_xy;
  private String[] weekdays;

  public DirectionsMainViewActivity()
  {
    int[] arrayOfInt = new int[2];
    this.mapAllowedSize = arrayOfInt;
    this.isMainScreen = false;
    this.DELAY_TIME = 604800000L;
    this.MARKET_VERSION_URL = "http://www.hopstop.com/android_market.txt";
    this.AMAZON_VERSION_URL = "http://www.hopstop.com/android.txt";
    this.ANDROID_MARKET_URL = "market://details?id=com.hopstop";
    this.AMAZON_STORE_URL = "http://www.amazon.com/gp/mas/dl/android?p=com.hopstop";
    this.MAX_MAP_LENGTH = 450;
    this.REQ_SHARE = 7;
    this.CURRENT_LOCATION_REQ_TIMER = 5000;
    this.NO_CHANGE = -1;
    Handler local1 = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        if ((paramAnonymousMessage.what != 0) || ((DirectionsMainViewActivity.this._progressDialog != null) && (DirectionsMainViewActivity.this._progressDialog.isShowing())));
        try
        {
          DirectionsMainViewActivity.this._progressDialog.dismiss();
          label40: DirectionsMainViewActivity.this.stopSkyHook();
          if (paramAnonymousMessage.what != 1)
            return;
          DirectionsMainViewActivity.this._progressDialog.setMessage("It may take a moment to find your location, please be patient. To cancel, press the back button once. For best results, please enable GPS, Wireless Networks and WiFi in your phone's settings.");
          return;
        }
        catch (Exception localException)
        {
          break label40;
        }
      }
    };
    this.handler = local1;
    Handler local2 = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        if (paramAnonymousMessage.what == 1)
        {
          DirectionsMainViewActivity localDirectionsMainViewActivity1 = DirectionsMainViewActivity.this;
          AlertDialog localAlertDialog1 = DirectionsMainViewActivity.this.builder.create();
          localDirectionsMainViewActivity1.alert = localAlertDialog1;
          DirectionsMainViewActivity.this.alert.show();
          return;
        }
        if (paramAnonymousMessage.what == 9)
        {
          DirectionsMainViewActivity.this.alert.dismiss();
          return;
        }
        if (paramAnonymousMessage.what != 2)
          return;
        DirectionsMainViewActivity localDirectionsMainViewActivity2 = DirectionsMainViewActivity.this;
        AlertDialog localAlertDialog2 = DirectionsMainViewActivity.this.builder.create();
        localDirectionsMainViewActivity2.alert = localAlertDialog2;
        DirectionsMainViewActivity.this.alert.show();
      }
    };
    this.alertHandler = local2;
    Handler local3 = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        if (paramAnonymousMessage.what == 1)
        {
          DirectionsMainViewActivity localDirectionsMainViewActivity1 = DirectionsMainViewActivity.this;
          AlertDialog localAlertDialog1 = DirectionsMainViewActivity.this.builder2.create();
          localDirectionsMainViewActivity1.alert2 = localAlertDialog1;
          DirectionsMainViewActivity.this.alert2.show();
          return;
        }
        if (paramAnonymousMessage.what == 9)
        {
          DirectionsMainViewActivity.this.alert2.dismiss();
          return;
        }
        if (paramAnonymousMessage.what != 2)
          return;
        DirectionsMainViewActivity localDirectionsMainViewActivity2 = DirectionsMainViewActivity.this;
        AlertDialog localAlertDialog2 = DirectionsMainViewActivity.this.builder2.create();
        localDirectionsMainViewActivity2.alert2 = localAlertDialog2;
        DirectionsMainViewActivity.this.alert2.show();
      }
    };
    this.alertHandler2 = local3;
    Handler local4 = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        if (paramAnonymousMessage.what == 1)
        {
          DirectionsMainViewActivity localDirectionsMainViewActivity = DirectionsMainViewActivity.this;
          AlertDialog localAlertDialog = DirectionsMainViewActivity.this.builder3.create();
          localDirectionsMainViewActivity.alert3 = localAlertDialog;
          DirectionsMainViewActivity.this.alert3.show();
          return;
        }
        if (paramAnonymousMessage.what != 9)
          return;
        DirectionsMainViewActivity.this.alert3.dismiss();
      }
    };
    this.alertHandler3 = local4;
    Handler local5 = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        if (paramAnonymousMessage.what == 1)
        {
          DirectionsMainViewActivity localDirectionsMainViewActivity1 = DirectionsMainViewActivity.this;
          AlertDialog localAlertDialog1 = DirectionsMainViewActivity.this.builderMsg.create();
          localDirectionsMainViewActivity1.alertMsg = localAlertDialog1;
          DirectionsMainViewActivity.this.alertMsg.show();
          return;
        }
        if (paramAnonymousMessage.what == 9)
        {
          DirectionsMainViewActivity.this.alertMsg.dismiss();
          return;
        }
        if (paramAnonymousMessage.what != 2)
          return;
        DirectionsMainViewActivity localDirectionsMainViewActivity2 = DirectionsMainViewActivity.this;
        AlertDialog localAlertDialog2 = DirectionsMainViewActivity.this.builderMsg.create();
        localDirectionsMainViewActivity2.alertMsg = localAlertDialog2;
        DirectionsMainViewActivity.this.alertMsg.show();
      }
    };
    this.alertHandlerMsg = local5;
  }

  private void InitSpinners()
  {
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(2131493000);
    LinearLayout localLinearLayout2 = (LinearLayout)findViewById(2131493008);
    DirectionsMainViewActivity localDirectionsMainViewActivity1 = this;
    int i = -1;
    localDirectionsMainViewActivity1.initSpinners(2131493000, 2131493001, 2131493002, false, -1, i);
    DirectionsMainViewActivity localDirectionsMainViewActivity2 = this;
    int j = 2131493008;
    int k = -1;
    localDirectionsMainViewActivity2.initSpinners(j, 2131493009, 2131493010, false, -1, k);
  }

  private void checkVersion()
  {
    long l1 = System.currentTimeMillis();
    long l2 = ApplicationEngine.getModel().getDelayUpdateTime();
    if (l1 <= l2)
      return;
    GetVersionTask localGetVersionTask = new GetVersionTask(null);
    Integer[] arrayOfInteger = new Integer[1];
    Integer localInteger = Integer.valueOf(getVersion());
    arrayOfInteger[0] = localInteger;
    AsyncTask localAsyncTask = localGetVersionTask.execute(arrayOfInteger);
  }

  private String constructAddressFromXY()
  {
    String str1 = null;
    if ((ApplicationEngine.getModel() != null) && (ApplicationEngine.getModel().Longitude() != 0.0D))
    {
      double d = ApplicationEngine.getModel().Longitude();
      if ((ApplicationEngine.getModel() != null) && (ApplicationEngine.getModel().Latitude() != 0.0D))
      {
        String str2 = String.valueOf(ApplicationEngine.getModel().Latitude());
        str1 = str2 + ", " + d;
      }
    }
    return str1;
  }

  private DirectionRequest constructDirectionRequest(String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, String paramString5)
  {
    String str1 = Integer.toString(getWindowManager().getDefaultDisplay().getWidth());
    String str2 = paramString1;
    String str3 = paramString2;
    int i = paramInt1;
    String str4 = paramString3;
    String str5 = paramString4;
    int j = paramInt2;
    String str6 = paramString5;
    return new DirectionRequest(str2, str3, i, str4, str5, j, str1, str6);
  }

  private DirectionRequest constructDirectionRequest(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, String paramString7, String paramString8, int paramInt2, String paramString9)
  {
    String str1 = Integer.toString(getWindowManager().getDefaultDisplay().getWidth());
    String str2 = paramString1;
    String str3 = paramString2;
    String str4 = paramString3;
    String str5 = paramString4;
    String str6 = paramString5;
    String str7 = paramString6;
    int i = paramInt1;
    String str8 = paramString7;
    String str9 = paramString8;
    int j = paramInt2;
    String str10 = paramString9;
    return new DirectionRequest(str2, str3, str4, str5, str6, str7, i, str8, str9, j, str1, str10);
  }

  private DirectionRequest constructDirectionRequestFromGPSLocationA(double paramDouble1, double paramDouble2, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, String paramString6)
  {
    String str1 = Integer.toString(getWindowManager().getDefaultDisplay().getWidth());
    double d1 = paramDouble1;
    double d2 = paramDouble2;
    String str2 = paramString1;
    String str3 = paramString2;
    String str4 = paramString3;
    int i = paramInt1;
    String str5 = paramString4;
    String str6 = paramString5;
    int j = paramInt2;
    String str7 = paramString6;
    return new DirectionRequest(d1, d2, str2, str3, str4, i, str5, str6, j, str1, str7);
  }

  private DirectionRequest constructDirectionRequestFromGPSLocationB(String paramString1, String paramString2, String paramString3, double paramDouble1, double paramDouble2, int paramInt1, String paramString4, String paramString5, int paramInt2, String paramString6)
  {
    String str1 = Integer.toString(getWindowManager().getDefaultDisplay().getWidth());
    String str2 = paramString1;
    String str3 = paramString2;
    String str4 = paramString3;
    double d1 = paramDouble1;
    double d2 = paramDouble2;
    int i = paramInt1;
    String str5 = paramString4;
    String str6 = paramString5;
    int j = paramInt2;
    String str7 = paramString6;
    return new DirectionRequest(str2, str3, str4, d1, d2, i, str5, str6, j, str1, str7);
  }

  private void createDefaultCityPref()
  {
    DirectionsMainViewActivity localDirectionsMainViewActivity = this;
    int i = -1;
    localDirectionsMainViewActivity.initSpinners(2131492899, 2131492900, 2131492901, true, -1, i);
  }

  private String getTransferPreference()
  {
    String str;
    if (ApplicationEngine.getModel().getTransferPriority() == 0)
      str = getString(2130968763);
    while (true)
    {
      return str;
      if (ApplicationEngine.getModel().getTransferPriority() == 1)
        str = getString(2130968762);
      else
        str = "";
    }
  }

  private String getTransportationMode()
  {
    String str1 = ApplicationEngine.getModel().getDirectionMode().getMode();
    String str2;
    if (str1.equals("s"))
      str2 = getString(2130968610);
    while (true)
    {
      return str2;
      if (str1.equals("b"))
        str2 = getString(2130968611);
      else if (str1.equals("a"))
        str2 = getString(2130968612);
      else if (str1.equals("w"))
        str2 = getString(2130968613);
      else if (str1.equals("j"))
        str2 = getString(2130968614);
      else if (str1.equals("z"))
        str2 = getString(2130968615);
      else
        str2 = "";
    }
  }

  private int getVersion()
  {
    try
    {
      PackageManager localPackageManager = getPackageManager();
      String str = getPackageName();
      int i = localPackageManager.getPackageInfo(str, 128).versionCode;
      label22: return i;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      break label22;
    }
  }

  private void initSpinners(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5)
  {
    String[] arrayOfString1 = ApplicationEngine.getModel().getCitiesNames();
    DirectionsMainViewActivity localDirectionsMainViewActivity1 = this;
    DirectionsMainViewActivity localDirectionsMainViewActivity2 = this;
    int i = paramInt2;
    HopStopCityAdapter localHopStopCityAdapter = new HopStopCityAdapter(localDirectionsMainViewActivity2, 2130903085, arrayOfString1, i);
    String[] arrayOfString2 = ApplicationEngine.getModel().getCountyNames();
    ArrayAdapter localArrayAdapter = new ArrayAdapter(this, 2130903085, arrayOfString2);
    final LinearLayout localLinearLayout = (LinearLayout)findViewById(paramInt1);
    final Spinner localSpinner1 = (Spinner)findViewById(paramInt2);
    final Spinner localSpinner2 = (Spinner)findViewById(paramInt3);
    localSpinner1.setAdapter(localHopStopCityAdapter);
    localHopStopCityAdapter.setDropDownViewResource(17367049);
    if (paramInt4 != -1)
    {
      int j = paramInt4;
      localSpinner1.setSelection(j);
      localSpinner2.setAdapter(localArrayAdapter);
      localArrayAdapter.setDropDownViewResource(17367049);
      if (paramInt5 == -1)
        break label245;
      int k = paramInt5;
      localSpinner2.setSelection(k);
    }
    while (true)
    {
      if (!ApplicationEngine.getModel().getDefaultCityByWidgetId(paramInt2).equals("newyork"))
        localSpinner2.setVisibility(8);
      AdapterView.OnItemSelectedListener local18 = new AdapterView.OnItemSelectedListener()
      {
        private boolean getResourseId(DirectionsMainViewActivity.HopStopCityAdapter paramAnonymousHopStopCityAdapter, Resources paramAnonymousResources, String paramAnonymousString)
        {
          boolean bool = true;
          String[] arrayOfString = new String[4];
          arrayOfString[0] = "a_city_spinner";
          arrayOfString[bool] = "b_city_spinner";
          arrayOfString[2] = "map_city_spinner";
          arrayOfString[3] = "pref_city_spinner";
          int i = 0;
          while (true)
          {
            int j = arrayOfString.length;
            if (i >= j)
              bool = false;
            Spinner localSpinner;
            do
            {
              return bool;
              String str1 = String.valueOf(paramAnonymousString);
              StringBuilder localStringBuilder = new StringBuilder(str1).append(":id/");
              String str2 = arrayOfString[i];
              String str3 = str2;
              int k = paramAnonymousResources.getIdentifier(str3, null, null);
              localSpinner = (Spinner)DirectionsMainViewActivity.this.findViewById(k);
            }
            while ((localSpinner != null) && (localSpinner.getAdapter().equals(paramAnonymousHopStopCityAdapter)));
            i += 1;
          }
        }

        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          DirectionsMainViewActivity.HopStopCityAdapter localHopStopCityAdapter = (DirectionsMainViewActivity.HopStopCityAdapter)paramAnonymousAdapterView.getAdapter();
          if (DirectionsMainViewActivity.HopStopCityAdapter.access$1(localHopStopCityAdapter))
          {
            Model localModel1 = ApplicationEngine.getModel();
            int i = localHopStopCityAdapter.getResourceId();
            Model localModel2 = ApplicationEngine.getModel();
            String str1 = (String)localSpinner1.getSelectedItem();
            String str2 = localModel2.getSelectedCityFromName(str1);
            localModel1.setDefaultCityByWidgetId(i, str2);
          }
          String str3;
          if (paramAnonymousInt != 0)
          {
            localSpinner1.setSelection(0);
            localHopStopCityAdapter.sort(paramAnonymousInt);
            str3 = null;
            if (localHopStopCityAdapter.getResourceId() != 2131493001)
              break label159;
            str3 = (String)((Spinner)DirectionsMainViewActivity.this.findViewById(2131493009)).getSelectedItem();
          }
          while (true)
          {
            Spinner localSpinner = localSpinner2;
            LinearLayout localLinearLayout = localLinearLayout;
            String str4 = (String)paramAnonymousAdapterView.getSelectedItem();
            localHopStopCityAdapter.updateSpinners(localSpinner, localLinearLayout, str4, str3);
            return;
            localHopStopCityAdapter.setInit(true);
            break;
            label159: if (localHopStopCityAdapter.getResourceId() == 2131493009)
              str3 = (String)((Spinner)DirectionsMainViewActivity.this.findViewById(2131493001)).getSelectedItem();
          }
        }

        public void onNothingSelected(AdapterView paramAnonymousAdapterView)
        {
        }
      };
      localSpinner1.setOnItemSelectedListener(local18);
      final boolean bool = paramBoolean;
      AdapterView.OnItemSelectedListener local19 = new AdapterView.OnItemSelectedListener()
      {
        String[] res;

        private int getResourseId(AdapterView<?> paramAnonymousAdapterView)
        {
          int i = 0;
          int j = this.res.length;
          int k;
          if (i >= j)
            k = -1;
          while (true)
          {
            return k;
            Resources localResources1 = DirectionsMainViewActivity.this.getResources();
            String str1 = String.valueOf(ApplicationEngine.APPLICATION_PACKAGE_NAME);
            StringBuilder localStringBuilder = new StringBuilder(str1).append(":id/");
            String str2 = this.res[i];
            String str3 = str2;
            int m = localResources1.getIdentifier(str3, null, null);
            Spinner localSpinner = (Spinner)DirectionsMainViewActivity.this.findViewById(m);
            if ((localSpinner != null) && (localSpinner.equals(paramAnonymousAdapterView)));
            switch (i)
            {
            default:
              i += 1;
              break;
            case 0:
              Resources localResources2 = DirectionsMainViewActivity.this.getResources();
              String str4 = String.valueOf(ApplicationEngine.APPLICATION_PACKAGE_NAME);
              String str5 = str4 + ":id/" + "a_city_spinner";
              k = localResources2.getIdentifier(str5, null, null);
              break;
            case 1:
              Resources localResources3 = DirectionsMainViewActivity.this.getResources();
              String str6 = String.valueOf(ApplicationEngine.APPLICATION_PACKAGE_NAME);
              String str7 = str6 + ":id/" + "b_city_spinner";
              k = localResources3.getIdentifier(str7, null, null);
              break;
            case 2:
              Resources localResources4 = DirectionsMainViewActivity.this.getResources();
              String str8 = String.valueOf(ApplicationEngine.APPLICATION_PACKAGE_NAME);
              String str9 = str8 + ":id/" + "map_city_spinner";
              k = localResources4.getIdentifier(str9, null, null);
              break;
            case 3:
              Resources localResources5 = DirectionsMainViewActivity.this.getResources();
              String str10 = String.valueOf(ApplicationEngine.APPLICATION_PACKAGE_NAME);
              String str11 = str10 + ":id/" + "pref_city_spinner";
              k = localResources5.getIdentifier(str11, null, null);
            }
          }
        }

        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          String str1 = Util.requiresBoroughChange((String)paramAnonymousAdapterView.getSelectedItem());
          if (str1 != null)
          {
            DirectionsMainViewActivity localDirectionsMainViewActivity = DirectionsMainViewActivity.this;
            int i = getResourseId(paramAnonymousAdapterView);
            Spinner localSpinner = (Spinner)localDirectionsMainViewActivity.findViewById(i);
            DirectionsMainViewActivity.HopStopCityAdapter localHopStopCityAdapter = (DirectionsMainViewActivity.HopStopCityAdapter)localSpinner.getAdapter();
            String str2 = ApplicationEngine.getModel().findSelectedCityFromShotName(str1);
            int j = localHopStopCityAdapter.getCityByName(str2);
            localSpinner.setSelection(j);
            paramAnonymousAdapterView.setVisibility(8);
            paramAnonymousAdapterView.invalidate();
            paramAnonymousAdapterView.setSelection(2);
          }
          if (!bool)
            return;
          Model localModel = ApplicationEngine.getModel();
          if (str1 == null);
          for (int k = paramAnonymousAdapterView.getSelectedItemPosition(); ; k = 2)
          {
            localModel.setDefaultCountySelection(k);
            return;
          }
        }

        public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView)
        {
        }
      };
      localSpinner2.setOnItemSelectedListener(local19);
      return;
      int m = ApplicationEngine.getModel().getDefaultCityPosition(paramInt2);
      localSpinner1.setSelection(m);
      break;
      label245: int n = ApplicationEngine.getModel().getDefaultCountySelection();
      localSpinner2.setSelection(n);
    }
  }

  private void launchLocationSettings()
  {
    try
    {
      Intent localIntent1 = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
      startActivity(localIntent1);
      return;
    }
    catch (Exception localException1)
    {
      try
      {
        localException1.printStackTrace();
        Intent localIntent2 = new Intent("android.settings.SECURITY_SETTINGS");
        startActivity(localIntent2);
        return;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        Toast.makeText(this, 2130968754, 0).show();
      }
    }
  }

  private void loadAdvisories()
  {
    Intent localIntent = new Intent(this, MoreServiceAdvisorActivity.class);
    startActivityForResult(localIntent, 6);
  }

  private void loadDefaultCity()
  {
    setContentView(2130903050);
    ApplicationEngine.getModel().setDefaultCityByWidgetId(2131492900, "newyork");
    int i = ApplicationEngine.getModel().getSelectedCityFromShotName("newyork");
    initSpinners(2131492899, 2131492900, 2131492901, true, i, -1);
    ApplicationEngine.getModel().setDefaultCityByWidgetId(2131492900, "newyork");
    Button localButton = (Button)findViewById(2131492902);
    View.OnClickListener local6 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ApplicationEngine.getModel().setDefaultCitySelectionDone(1);
        DirectionsMainViewActivity.this.loadMainView();
        Hashtable localHashtable = new Hashtable();
        String str1 = ApplicationEngine.getModel().getDefaultCityId();
        Object localObject = localHashtable.put("defaultcity", str1);
        DirectionsMainViewActivity localDirectionsMainViewActivity = DirectionsMainViewActivity.this;
        int i = ApplicationEngine.ZONE_DIRECTION_SEARCH;
        String str2 = null;
        localDirectionsMainViewActivity.update(i, localHashtable, null, str2, true);
      }
    };
    localButton.setOnClickListener(local6);
    Hashtable localHashtable = new Hashtable();
    String str = ApplicationEngine.getModel().getDefaultCityId();
    Object localObject = localHashtable.put("defaultcity", str);
    int j = ApplicationEngine.ZONE_DIRECTION_SEARCH;
    update(j, localHashtable, null, null);
  }

  private void loadMainView()
  {
    setContentView(2130903076);
    this.isMainScreen = true;
    String str1 = ApplicationEngine.getModel().getDefaultCityId();
    this.defaultCity = str1;
    String str2 = this.defaultCity;
    Crashlytics.setString("DefaultCity", str2);
    int i = ApplicationEngine.getModel().getDefaultCountySelection();
    this.defaultCounty = i;
    AQuery localAQuery = new AQuery(this);
    this.aq = localAQuery;
    AbstractAQuery localAbstractAQuery1 = ((AQuery)this.aq.id(2131492991)).clicked(this, "RequestDirections");
    AbstractAQuery localAbstractAQuery2 = ((AQuery)this.aq.id(2131492998)).clicked(this, "clickedAddressAHistory");
    AbstractAQuery localAbstractAQuery3 = ((AQuery)this.aq.id(2131493006)).clicked(this, "clickedAddressBHistory");
    AbstractAQuery localAbstractAQuery4 = ((AQuery)this.aq.id(2131492999)).clicked(this, "clickedAddressALocation");
    AbstractAQuery localAbstractAQuery5 = ((AQuery)this.aq.id(2131493007)).clicked(this, "clickedAddressBLocation");
    InitSpinners();
    EditText localEditText1 = (EditText)findViewById(2131492996);
    this.address_a = localEditText1;
    EditText localEditText2 = (EditText)findViewById(2131493004);
    this.address_b = localEditText2;
    ApplicationEngine.getModel().resetToDefault();
    if (this.defaultCity.equals("newyork"))
    {
      ApplicationEngine.getModel().getDirectionMode().setMode("s");
      ApplicationEngine.getModel().setRegional_rail(false);
    }
    while (true)
    {
      Button localButton1 = (Button)findViewById(2131493012);
      this.option_mode = localButton1;
      Button localButton2 = this.option_mode;
      String str3 = String.valueOf(getString(2130968622));
      StringBuilder localStringBuilder = new StringBuilder(str3).append(": ");
      String str4 = getTransportationMode();
      String str5 = str4;
      localButton2.setText(str5);
      Button localButton3 = this.option_mode;
      View.OnClickListener local7 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          DirectionsMainViewActivity localDirectionsMainViewActivity = DirectionsMainViewActivity.this;
          Intent localIntent1 = new Intent(localDirectionsMainViewActivity, OptionModeActivity.class);
          String str1 = (String)((Spinner)DirectionsMainViewActivity.this.findViewById(2131493001)).getSelectedItem();
          String str2 = (String)((Spinner)DirectionsMainViewActivity.this.findViewById(2131493009)).getSelectedItem();
          boolean bool = Util.isBikeModeAvailble(str1, str2);
          Intent localIntent2 = localIntent1.putExtra("bike_enabled", bool);
          DirectionsMainViewActivity.this.startActivityForResult(localIntent1, 3);
        }
      };
      localButton3.setOnClickListener(local7);
      Button localButton4 = (Button)findViewById(2131492910);
      this.departure = localButton4;
      String[] arrayOfString = getResources().getStringArray(2131099648);
      this.weekdays = arrayOfString;
      setDepartureTime();
      Button localButton5 = this.departure;
      View.OnClickListener local8 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          DirectionsMainViewActivity localDirectionsMainViewActivity = DirectionsMainViewActivity.this;
          Intent localIntent = new Intent(localDirectionsMainViewActivity, DepartureActivity.class);
          DirectionsMainViewActivity.this.startActivityForResult(localIntent, 4);
        }
      };
      localButton5.setOnClickListener(local8);
      ProgressDialog localProgressDialog = new ProgressDialog(this);
      this._progressDialog = localProgressDialog;
      AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(this);
      this.builder = localBuilder1;
      AlertDialog.Builder localBuilder2 = this.builder.setTitle("Sorry!");
      AlertDialog localAlertDialog1 = this.builder.create();
      this.alert = localAlertDialog1;
      AlertDialog.Builder localBuilder3 = new AlertDialog.Builder(this);
      this.builder2 = localBuilder3;
      AlertDialog.Builder localBuilder4 = this.builder2.setTitle("Sorry!");
      AlertDialog localAlertDialog2 = this.builder2.create();
      this.alert2 = localAlertDialog2;
      AlertDialog.Builder localBuilder5 = new AlertDialog.Builder(this);
      this.builder3 = localBuilder5;
      AlertDialog.Builder localBuilder6 = this.builder3.setTitle("Sorry!");
      AlertDialog localAlertDialog3 = this.builder3.create();
      this.alert3 = localAlertDialog3;
      AlertDialog.Builder localBuilder7 = new AlertDialog.Builder(this);
      this.builderMsg = localBuilder7;
      AlertDialog.Builder localBuilder8 = this.builderMsg.setTitle("Sorry!");
      AlertDialog localAlertDialog4 = this.builderMsg.create();
      this.alertMsg = localAlertDialog4;
      String str6 = PageNames.Main;
      trackEvent(str6);
      String str7 = PageNames.Main;
      displayAds(str7);
      getWindow().setSoftInputMode(2);
      int j = getResources().getConfiguration().orientation;
      resetLayoutBasedOnConfiguration(j);
      Hashtable localHashtable = new Hashtable();
      String str8 = ApplicationEngine.getModel().getDefaultCityId();
      Object localObject = localHashtable.put("defaultcity", str8);
      int k = ApplicationEngine.ZONE_DIRECTION_SEARCH;
      update(k, localHashtable, null, null);
      return;
      ApplicationEngine.getModel().getDirectionMode().setMode("a");
      ApplicationEngine.getModel().setRegional_rail(true);
    }
  }

  private void loadNearbyStations()
  {
    Intent localIntent = new Intent(this, NearbyStationsRequestActivity.class);
    startActivityForResult(localIntent, 9);
  }

  private void loadSchedules()
  {
    Intent localIntent = new Intent(this, SchedulesSearchActivity.class);
    startActivityForResult(localIntent, 74);
  }

  private void loadTransitMaps()
  {
    Intent localIntent = new Intent(this, TransitMapActivity.class);
    startActivityForResult(localIntent, 7);
  }

  private void prepopulateDirectionRequest(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    setContentView(2130903076);
    getMainViewActivity().loadMainView();
    if (paramString1 != null)
      getMainViewActivity().address_a.setText(paramString1);
    if (paramString2 != null)
      getMainViewActivity().address_b.setText(paramString2);
    setCityById(2131493001, paramString3);
    setCityById(2131493009, paramString4);
    String str = PageNames.Main;
    displayAds(str);
  }

  private void processIntent()
  {
    if (!getIntent().hasExtra("hyperlink_uri_at_startup"))
      return;
    String str1 = getIntent().getExtras().getString("host_at_startup");
    if (str1 == null)
      return;
    if (str1.contains("hopstop.com"))
    {
      if (getIntent().getExtras() == null)
        return;
      if (!getIntent().getExtras().containsKey("hyperlink_uri_at_startup"))
        return;
      Hashtable localHashtable = Util.convertToHashtable(getIntent().getData().toString());
      String str2 = Util.parseUriFromHypertext(localHashtable, "address1");
      if (str2 != null)
      {
        str2 = Util.formatAddress(str2);
        if (str2 != null)
          this.address_a.setText(str2);
      }
      String str3 = Util.parseUriFromHypertext(localHashtable, "city1");
      if (str3 != null)
      {
        str3 = Util.formatCityFromURL(str3);
        if (str3 != null)
        {
          Spinner localSpinner1 = (Spinner)findViewById(2131493001);
          HopStopCityAdapter localHopStopCityAdapter1 = (HopStopCityAdapter)localSpinner1.getAdapter();
          String str4 = ApplicationEngine.getModel().findSelectedCityFromShotName(str3);
          int i = localHopStopCityAdapter1.getCityByName(str4);
          localSpinner1.setSelection(i);
        }
      }
      String str5 = Util.parseUriFromHypertext(localHashtable, "address2");
      if (str5 != null)
      {
        str5 = Util.formatAddress(str5);
        if (str5 != null)
          this.address_b.setText(str5);
      }
      String str6 = Util.parseUriFromHypertext(localHashtable, "city2");
      if (str6 == null)
        return;
      str6 = Util.formatCityFromURL(str6);
      if (str6 == null)
        return;
      Spinner localSpinner2 = (Spinner)findViewById(2131493009);
      HopStopCityAdapter localHopStopCityAdapter2 = (HopStopCityAdapter)localSpinner2.getAdapter();
      String str7 = ApplicationEngine.getModel().findSelectedCityFromShotName(str6);
      int j = localHopStopCityAdapter2.getCityByName(str7);
      localSpinner2.setSelection(j);
      return;
    }
    if (str1.startsWith("com.android.contacts"))
    {
      str8 = null;
      Uri localUri = Uri.parse(getIntent().getDataString());
      Cursor localCursor = managedQuery(localUri, null, null, null, null);
      if (localCursor == null)
        return;
      if (localCursor.getCount() > 0)
      {
        boolean bool = localCursor.moveToFirst();
        if (localCursor.getColumnIndex("data1") < 0)
          break label432;
        int k = localCursor.getColumnIndex("data1");
        str8 = localCursor.getString(k);
      }
      while (true)
      {
        if (str8 == null)
          return;
        EditText localEditText1 = this.address_b;
        String str9 = URLDecoder.decode(str8.replaceAll("\n", ", "));
        localEditText1.setText(str9);
        return;
        label432: if (localCursor.getColumnIndex("data1") >= 0)
        {
          int m = localCursor.getColumnIndex("data1");
          str8 = localCursor.getString(m);
        }
      }
    }
    if (!str1.startsWith("geo:"))
      return;
    String str8 = getIntent().getData().toString();
    if (str8.indexOf("q=") != -1)
    {
      int n = str8.indexOf("q=") + 2;
      str8 = str8.substring(n);
      if (str8 == null)
        return;
      EditText localEditText2 = this.address_b;
      String str10 = URLDecoder.decode(str8);
      localEditText2.setText(str10);
      return;
    }
    if ((str8.indexOf("?") != -1) && (str8.indexOf(",") != -1))
    {
      int i1 = str8.indexOf(",");
      str11 = str8.substring(4, i1);
      int i2 = str8.indexOf(",") + 1;
      int i3 = str8.indexOf("?");
      str12 = str8.substring(i2, i3);
      if (str11 == null)
        return;
      if (str12 == null)
        return;
      EditText localEditText3 = this.address_b;
      String str13 = String.valueOf(str11);
      StringBuilder localStringBuilder1 = new StringBuilder(str13).append(",");
      String str14 = str12;
      String str15 = URLDecoder.decode(str14);
      localEditText3.setText(str15);
      return;
    }
    if (str8.indexOf(",") == -1)
      return;
    int i4 = str8.indexOf(",");
    String str11 = str8.substring(4, i4);
    int i5 = str8.indexOf(",") + 1;
    String str12 = str8.substring(i5);
    if (str11 == null)
      return;
    if (str12 == null)
      return;
    EditText localEditText4 = this.address_b;
    String str16 = String.valueOf(str11);
    StringBuilder localStringBuilder2 = new StringBuilder(str16).append(", ");
    String str17 = str12;
    String str18 = URLDecoder.decode(str17);
    localEditText4.setText(str18);
  }

  private void resetLayoutBasedOnConfiguration(int paramInt)
  {
    if (!this.isMainScreen)
      return;
    ScrollView localScrollView = (ScrollView)((AQuery)this.aq.id(2131492992)).getView();
    LinearLayout localLinearLayout = (LinearLayout)((AQuery)this.aq.id(2131492864)).getView();
    if (paramInt == 2)
    {
      LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -1, 1.0F);
      localScrollView.setLayoutParams(localLayoutParams1);
      LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -1);
      localLinearLayout.setLayoutParams(localLayoutParams2);
      return;
    }
    if (paramInt != 1)
      return;
    LinearLayout.LayoutParams localLayoutParams3 = new LinearLayout.LayoutParams(-1, -1);
    localScrollView.setLayoutParams(localLayoutParams3);
    LinearLayout.LayoutParams localLayoutParams4 = new LinearLayout.LayoutParams(-1, -1);
    localLinearLayout.setLayoutParams(localLayoutParams4);
  }

  private void setDepartureTime()
  {
    Button localButton = this.departure;
    StringBuilder localStringBuilder1 = new java/lang/StringBuilder;
    if (ApplicationEngine.getModel().getIsArriveBy());
    for (String str1 = getString(2130968625); ; str1 = getString(2130968626))
    {
      String str2 = String.valueOf(str1);
      localStringBuilder1.<init>(str2);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(": ");
      String[] arrayOfString = this.weekdays;
      int i = ApplicationEngine.getModel().getDay() + -1;
      String str3 = arrayOfString[i];
      StringBuilder localStringBuilder3 = localStringBuilder2.append(str3).append(" ");
      String str4 = ApplicationEngine.getModel().getTimeAMPM();
      String str5 = str4;
      localButton.setText(str5);
      return;
    }
  }

  private void setOnClickListenerForFeedback()
  {
    Button localButton1 = (Button)findViewById(2131492961);
    View.OnClickListener local11 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        String str1 = DirectionsMainViewActivity.this.getString(2130968653);
        String str2 = "\n\n\nSent from HopStop Android App " + str1;
        DirectionsMainViewActivity.this.sendEmail("feedback@hopstop.com", "HopStop Android App - Feedback", str2);
      }
    };
    localButton1.setOnClickListener(local11);
    Button localButton2 = (Button)findViewById(2131492962);
    View.OnClickListener local12 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        String str1 = DirectionsMainViewActivity.this.getString(2130968653);
        String str2 = "Dear HopStop: \n\nI'm interested in advertising on HopStop's new Android app. Please contact me with information on how to run such an ad campaign.\n\nThank you.\n\nSent from HopStop Android App " + str1;
        DirectionsMainViewActivity.this.sendEmail("media@hopstop.com", "HopStop Android App - Advertising Inquiry", str2);
      }
    };
    localButton2.setOnClickListener(local12);
    Button localButton3 = (Button)findViewById(2131492965);
    View.OnClickListener local13 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DirectionsMainViewActivity.this.createDialogForShareInFeedback();
      }
    };
    localButton3.setOnClickListener(local13);
  }

  private void shareWithFriends(Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder("Hey, you should check out HopStop's free mobile apps! HopStop is a really cool service that provides door-to-door mass transit, taxi and walking directions in dozens of markets throughout the U.S., Canada & Europe, including NYC, Boston, DC, Chicago, LA, San Francisco, Seattle, Montreal, Toronto, London, Paris and Moscow.\n\nFind HopStop on the mobile web at http://m.HopStop.com\n\n");
    String str1 = getString(2130968773);
    String str2 = str1;
    String str3 = paramIntent.getComponent().getClassName();
    Intent localIntent1 = paramIntent.putExtra("android.intent.extra.SUBJECT", "HopStop for your Smartphone");
    if (str3.contains("facebook"))
      Intent localIntent2 = paramIntent.putExtra("android.intent.extra.TEXT", "http://www.hopstop.com");
    while (true)
    {
      startActivity(paramIntent);
      return;
      if ((str3.toLowerCase().contains("mail")) || (str3.contains("k9")))
        Intent localIntent3 = paramIntent.putExtra("android.intent.extra.TEXT", str2);
      else
        Intent localIntent4 = paramIntent.putExtra("android.intent.extra.TEXT", "Check out HopStop's free mobile apps at http://m.HopStop.com");
    }
  }

  public void RequestDirections()
  {
    if (!NetworkEngine.dataNetworkAvail(this))
    {
      String str1 = getString(2130968675);
      ShowErrorMessage("Error", str1);
      return;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    IBinder localIBinder = this.address_a.getApplicationWindowToken();
    boolean bool1 = localInputMethodManager.hideSoftInputFromWindow(localIBinder, 0);
    String str2 = this.address_a.getText().toString();
    String str3 = this.address_b.getText().toString();
    Spinner localSpinner1 = (Spinner)findViewById(2131493001);
    Spinner localSpinner2 = (Spinner)findViewById(2131493009);
    if (this.address_a.getText().length() < 1)
    {
      ShowErrorMessage("Error", "Please Enter Start Address!");
      return;
    }
    if (this.address_b.getText().length() < 1)
    {
      ShowErrorMessage("Error", "Please Enter Destination Address!");
      return;
    }
    if (ApplicationEngine.getModel().getDay() < 0)
      return;
    if (ApplicationEngine.getModel().getTime().length() < 0)
      return;
    if (ApplicationEngine.getModel().getDirectionMode().getMode().length() < 0)
      return;
    String str4 = getString(2130968631);
    boolean bool2 = str2.equals(str4);
    String str5 = getString(2130968631);
    boolean bool3 = str3.equals(str5);
    Model localModel1 = ApplicationEngine.getModel();
    String str6 = localSpinner1.getSelectedItem().toString();
    String str7 = localModel1.getSelectedCityFromName(str6);
    Model localModel2 = ApplicationEngine.getModel();
    String str8 = localSpinner2.getSelectedItem().toString();
    String str9 = localModel2.getSelectedCityFromName(str8);
    if (((bool2) && (bool3)) || ((str2.equals(str3)) && (str7.equals(str9))))
    {
      ShowErrorMessage("Error", "Please enter different starting and ending addresses.");
      return;
    }
    this.shouldUpdateHistoryA = true;
    this.shouldUpdateHistoryB = true;
    if (bool2)
    {
      this.shouldUpdateHistoryA = false;
      str2 = constructAddressFromXY();
    }
    if (bool3)
    {
      this.shouldUpdateHistoryB = false;
      str3 = constructAddressFromXY();
    }
    if ((str2 == null) || (str3 == null))
    {
      Toast.makeText(this, "An error occurred while requesting, please try again", 1).show();
      return;
    }
    if (this.store_consider_start_xy)
    {
      String str10 = this.store_address_start;
      if ((str2.equals(str10)) && (this.store_address_x1 != 0.0D) && (this.store_address_y1 != 0.0D))
      {
        String str11 = String.valueOf(str2);
        StringBuilder localStringBuilder1 = new StringBuilder(str11).append(" (");
        double d1 = this.store_address_y1;
        StringBuilder localStringBuilder2 = localStringBuilder1.append(d1).append(",");
        double d2 = this.store_address_x1;
        str2 = d2 + ")";
      }
    }
    if (this.store_consider_end_xy)
    {
      String str12 = this.store_address_end;
      if ((str3.equals(str12)) && (this.store_address_x2 != 0.0D) && (this.store_address_y2 != 0.0D))
      {
        String str13 = String.valueOf(str3);
        StringBuilder localStringBuilder3 = new StringBuilder(str13).append(" (");
        double d3 = this.store_address_y2;
        StringBuilder localStringBuilder4 = localStringBuilder3.append(d3).append(",");
        double d4 = this.store_address_x2;
        str3 = d4 + ")";
      }
    }
    Crashlytics.setString("Address1", str2);
    Crashlytics.setString("Address2", str3);
    str2 = URLEncoder.encode(str2);
    str3 = URLEncoder.encode(str3);
    Model localModel3 = ApplicationEngine.getModel();
    String str14 = localSpinner1.getSelectedItem().toString();
    String str15 = localModel3.getSelectedCityFromName(str14);
    Model localModel4 = ApplicationEngine.getModel();
    String str16 = localSpinner2.getSelectedItem().toString();
    String str17 = localModel4.getSelectedCityFromName(str16);
    Crashlytics.setString("City1", str15);
    Crashlytics.setString("City2", str17);
    String str18 = null;
    String str19 = null;
    if (str15.equals("newyork"))
    {
      Spinner localSpinner3 = (Spinner)findViewById(2131493002);
      Model localModel5 = ApplicationEngine.getModel();
      int i = localSpinner3.getSelectedItemPosition();
      str18 = localModel5.getCountyId(i);
      Crashlytics.setString("County1", str18);
    }
    if (str17.equals("newyork"))
    {
      Spinner localSpinner4 = (Spinner)findViewById(2131493010);
      Model localModel6 = ApplicationEngine.getModel();
      int j = localSpinner4.getSelectedItemPosition();
      str19 = localModel6.getCountyId(j);
      Crashlytics.setString("County1", str19);
    }
    Model localModel7 = ApplicationEngine.getModel();
    int k = ApplicationEngine.getModel().getDay();
    String str20 = ApplicationEngine.getModel().getTime();
    String str21 = ApplicationEngine.getModel().getDirectionMode().getMode();
    int m = ApplicationEngine.getModel().getTransferPriority();
    String str22 = ApplicationEngine.getModel().getLanguage();
    DirectionRequest localDirectionRequest = constructDirectionRequest(str2, str18, str15, str3, str19, str17, k, str20, str21, m, str22);
    localModel7.setDirectionRequest(localDirectionRequest);
    ApplicationEngine.getModel().getDirectionRequest().setTypeUrl(1);
    int n = ApplicationEngine.getModel().getDay();
    Crashlytics.setInt("Day", n);
    String str23 = ApplicationEngine.getModel().getTime();
    Crashlytics.setString("Time", str23);
    String str24 = ApplicationEngine.getModel().getDirectionMode().getMode();
    Crashlytics.setString("Mode", str24);
    int i1 = ApplicationEngine.getModel().getTransferPriority();
    Crashlytics.setInt("TransferPriority", i1);
    String str25 = ApplicationEngine.getModel().getLanguage();
    Crashlytics.setString("Language", str25);
    this.run_thread_request = 0;
    if (this._progressDialog.isShowing())
      return;
    ProgressDialog localProgressDialog = ProgressDialog.show(this, "Please wait...", "Retrieving data ...", true, false);
    this._progressDialog = localProgressDialog;
    Thread localThread1 = new java/lang/Thread;
    Thread localThread2 = localThread1;
    DirectionsMainViewActivity localDirectionsMainViewActivity = this;
    localThread2.<init>(localDirectionsMainViewActivity);
    localThread1.start();
  }

  public void RequestDirectionsByThumbnail(String paramString1, String paramString2, String paramString3)
  {
    Model localModel = ApplicationEngine.getModel();
    int i = ApplicationEngine.getModel().getDay();
    String str1 = ApplicationEngine.getModel().getTime();
    String str2 = ApplicationEngine.getModel().getDirectionMode().getMode();
    int j = ApplicationEngine.getModel().getTransferPriority();
    DirectionsMainViewActivity localDirectionsMainViewActivity = this;
    String str3 = paramString1;
    String str4 = paramString2;
    String str5 = paramString3;
    DirectionRequest localDirectionRequest = localDirectionsMainViewActivity.constructDirectionRequest(str3, str4, i, str1, str2, j, str5);
    localModel.setDirectionRequest(localDirectionRequest);
    ApplicationEngine.getModel().getDirectionRequest().setTypeUrl(4);
    this.run_thread_request = 0;
    if (this._progressDialog.isShowing())
      return;
    ProgressDialog localProgressDialog = ProgressDialog.show(this, "Please wait...", "Retrieving data ...", true, false);
    this._progressDialog = localProgressDialog;
    new Thread(this).start();
  }

  public void ShowErrorMessage(String paramString1, String paramString2)
  {
    Message localMessage1 = new Message();
    localMessage1.what = 0;
    boolean bool1 = this.handler.sendMessage(localMessage1);
    if (paramString1 != null)
      AlertDialog.Builder localBuilder1 = this.builderMsg.setTitle(paramString1);
    if (paramString2 != null)
      AlertDialog.Builder localBuilder2 = this.builderMsg.setMessage(paramString2);
    AlertDialog.Builder localBuilder3 = this.builderMsg;
    DialogInterface.OnClickListener local17 = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        DirectionsMainViewActivity.this.dismissErrorMessage();
      }
    };
    AlertDialog.Builder localBuilder4 = localBuilder3.setPositiveButton("OK", local17);
    Message localMessage2 = new Message();
    localMessage2.what = 1;
    boolean bool2 = this.alertHandlerMsg.sendMessage(localMessage2);
  }

  public void changeProgressDialogForLocation()
  {
    Message localMessage = new Message();
    localMessage.what = 1;
    boolean bool = this.handler.sendMessage(localMessage);
  }

  public void clickedAddressAHistory()
  {
    openHistoryActivity(0);
  }

  public void clickedAddressALocation()
  {
    setLocationButton(2131492999);
    getCurrentLocation();
    XSPLocationManager.getXSPLocationManager(this).startWSP();
  }

  public void clickedAddressBHistory()
  {
    openHistoryActivity(1);
  }

  public void clickedAddressBLocation()
  {
    setLocationButton(2131493007);
    getCurrentLocation();
    XSPLocationManager.getXSPLocationManager(this).startWSP();
  }

  public void createDialogForShareInFeedback()
  {
    try
    {
      Intent localIntent1 = new Intent("android.intent.action.SEND", null);
      Intent localIntent2 = localIntent1.addCategory("android.intent.category.DEFAULT");
      Intent localIntent3 = localIntent1.setType("text/plain");
      Intent localIntent4 = new Intent("android.intent.action.PICK_ACTIVITY");
      Intent localIntent5 = localIntent4.putExtra("android.intent.extra.INTENT", localIntent1);
      startActivityForResult(localIntent4, 7);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void createProgressDialogForLocation()
  {
    if (this._progressDialog.isShowing())
      return;
    DialogInterface.OnCancelListener local9 = new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        ApplicationEngine.getGPSEngine(null).cancelRequestAllGPS(null);
        if (DirectionsMainViewActivity.this._timer == null)
          return;
        DirectionsMainViewActivity.this._timer.cancel();
      }
    };
    DirectionsMainViewActivity localDirectionsMainViewActivity = this;
    boolean bool = true;
    ProgressDialog localProgressDialog = ProgressDialog.show(localDirectionsMainViewActivity, "Please wait...", "Getting Location ...", true, bool, local9);
    this._progressDialog = localProgressDialog;
    Timer localTimer1 = new Timer();
    this._timer = localTimer1;
    Timer localTimer2 = this._timer;
    TimerTask local10 = new TimerTask()
    {
      public void run()
      {
        DirectionsMainViewActivity.this.getMainViewActivity().changeProgressDialogForLocation();
        if (DirectionsMainViewActivity.this._timer == null)
          return;
        DirectionsMainViewActivity.this._timer.cancel();
      }
    };
    localTimer2.schedule(local10, 5000L);
  }

  public void dismissAlert()
  {
    Message localMessage = new Message();
    localMessage.what = 9;
    boolean bool = this.alertHandler.sendMessage(localMessage);
  }

  public void dismissErrorMessage()
  {
    Message localMessage = new Message();
    localMessage.what = 9;
    boolean bool = this.alertHandlerMsg.sendMessage(localMessage);
  }

  public void dismissProgressBar()
  {
    Message localMessage = new Message();
    localMessage.what = 0;
    boolean bool = this.handler.sendMessage(localMessage);
  }

  public void getCurrentLocation()
  {
    if (!NetworkEngine.dataNetworkAvail(this))
    {
      String str = getString(2130968675);
      ShowErrorMessage("Error", str);
      return;
    }
    this.run_thread_request = 2;
    createProgressDialogForLocation();
    new Thread(this).start();
  }

  public int getLocationButton()
  {
    return this.locationButton;
  }

  public DirectionsMainViewActivity getMainViewActivity()
  {
    return this;
  }

  public int[] getMapDimention()
  {
    int[] arrayOfInt1 = { 450, 450 };
    int[] arrayOfInt2 = getMapImageSpace();
    float f1 = arrayOfInt2[0];
    float f2 = arrayOfInt2[1];
    float f3 = f1 / f2;
    int i;
    int j;
    int k;
    if (arrayOfInt2[0] <= 450)
    {
      i = arrayOfInt2[0];
      j = arrayOfInt2[1];
      arrayOfInt1[0] = i;
      if (j <= 450)
        break label169;
      k = 450;
      label75: arrayOfInt1[1] = k;
      if (j <= 450)
        break label176;
      float f4 = i;
      float f5 = j;
      float f6 = 450.0F / f5;
      int m = (int)(f4 * f6);
      arrayOfInt1[0] = m;
      arrayOfInt1[1] = 450;
    }
    while (true)
    {
      return arrayOfInt1;
      float f7 = arrayOfInt2[0];
      float f8 = Math.min(450.0F / f7, f3);
      i = (int)(arrayOfInt2[0] * f8);
      j = (int)(arrayOfInt2[1] * f8);
      break;
      label169: k = j;
      break label75;
      label176: arrayOfInt1[1] = j;
    }
  }

  public int[] getMapImageSpace()
  {
    int[] arrayOfInt1 = new int[2];
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131493017);
    int i = localLinearLayout.getBottom();
    float f1 = getResources().getDisplayMetrics().density;
    int j = localLinearLayout.getBottom();
    int k = getStatusBarHeight();
    float f2 = j + k;
    float f3 = getResources().getDisplayMetrics().density;
    float f4 = 55.0F * f3;
    int m = (int)(f2 + f4);
    float f5 = getResources().getDisplayMetrics().density;
    int n = (int)(50.0F * f5);
    int[] arrayOfInt2 = getScreenDimention();
    int i1 = arrayOfInt2[1];
    int i2 = arrayOfInt2[0];
    int i3;
    if (i1 > i2)
      i3 = arrayOfInt2[0];
    for (int i4 = arrayOfInt2[1]; ; i4 = arrayOfInt2[0])
    {
      arrayOfInt1[0] = i3;
      int i5 = i4 - m - n;
      arrayOfInt1[1] = i5;
      this.mapAllowedSize = arrayOfInt1;
      return arrayOfInt1;
      i3 = arrayOfInt2[1];
    }
  }

  public int getOrientation()
  {
    int i = 1;
    int[] arrayOfInt = getScreenDimention();
    int j = arrayOfInt[i];
    int k = arrayOfInt[0];
    if (j > k);
    while (true)
    {
      return i;
      i = 2;
    }
  }

  public void moveAds()
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131493026);
    if (localLinearLayout == null)
      return;
    float f1 = getScreenLongSide();
    float f2 = getScreenDensity() * 50.0F;
    float f3 = f1 - f2;
    float f4 = getScreenDensity();
    float f5 = 79.0F * f4;
    int i = (int)(f3 - f5);
    float f6 = getScreenDensity();
    int j = (int)(320.0F * f6);
    int k = (int)(getScreenDensity() * 50.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(j, k);
    localLayoutParams.addRule(14);
    localLayoutParams.topMargin = i;
    localLinearLayout.setLayoutParams(localLayoutParams);
    localLinearLayout.getRootView().invalidate();
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    if ((paramInt1 == 0) && (paramInt2 == 1))
    {
      if (paramIntent.hasExtra("get_address"))
      {
        EditText localEditText1 = this.address_a;
        String str1 = paramIntent.getStringExtra("get_address");
        localEditText1.setText(str1);
      }
      if (paramIntent.hasExtra("history_market"))
      {
        String str2 = paramIntent.getStringExtra("history_market");
        setCityById(2131493001, str2);
      }
      i = ApplicationEngine.ZONE_DIRECTION_SEARCH;
    }
    while (true)
    {
      Hashtable localHashtable = new Hashtable();
      String str3 = ApplicationEngine.getModel().getDefaultCityId();
      Object localObject = localHashtable.put("defaultcity", str3);
      update(i, localHashtable, null, null);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if ((paramInt1 == 1) && (paramInt2 == 1))
      {
        if (paramIntent.hasExtra("get_address"))
        {
          EditText localEditText2 = this.address_b;
          String str4 = paramIntent.getStringExtra("get_address");
          localEditText2.setText(str4);
        }
        if (paramIntent.hasExtra("history_market"))
        {
          String str5 = paramIntent.getStringExtra("history_market");
          setCityById(2131493009, str5);
        }
        i = ApplicationEngine.ZONE_DIRECTION_SEARCH;
      }
      else if ((paramInt1 == 2) && (paramInt2 == 1))
      {
        if (paramIntent.hasExtra("get_address"))
        {
          EditText localEditText3 = this.map_req_address;
          String str6 = paramIntent.getStringExtra("get_address");
          localEditText3.setText(str6);
        }
        i = ApplicationEngine.ZONE_DIRECTION_SEARCH;
      }
      else if ((paramInt1 == 3) && (paramInt2 == 1))
      {
        Button localButton = this.option_mode;
        String str7 = String.valueOf(getString(2130968622));
        StringBuilder localStringBuilder = new StringBuilder(str7).append(": ");
        String str8 = getTransportationMode();
        String str9 = str8;
        localButton.setText(str9);
        i = ApplicationEngine.ZONE_DIRECTION_SEARCH;
      }
      else if ((paramInt1 == 4) && (paramInt2 == 1))
      {
        setDepartureTime();
        i = ApplicationEngine.ZONE_DIRECTION_SEARCH;
      }
      else if ((paramInt1 == 5) && (paramInt2 == 2))
      {
        getMainViewActivity().loadMainView();
        EditText localEditText4 = getMainViewActivity().address_b;
        String str10 = ApplicationEngine.getModel().getLastMapAddress().getAddress();
        localEditText4.setText(str10);
        i = ApplicationEngine.ZONE_DIRECTION_SEARCH;
      }
      else if ((paramInt1 == 5) && (paramInt2 == 3))
      {
        getMainViewActivity().loadMainView();
        EditText localEditText5 = getMainViewActivity().address_a;
        String str11 = ApplicationEngine.getModel().getLastMapAddress().getAddress();
        localEditText5.setText(str11);
        i = ApplicationEngine.ZONE_DIRECTION_SEARCH;
      }
      else if (paramInt2 == 1)
      {
        loadMainView();
        i = ApplicationEngine.ZONE_DIRECTION_SEARCH;
      }
      else if (paramInt2 == 3)
      {
        i = ApplicationEngine.ZONE_MY_TRIPS;
      }
      else if (paramInt2 == 5)
      {
        loadAdvisories();
        i = ApplicationEngine.ZONE_ADVISORIES;
      }
      else if (paramInt2 == 6)
      {
        loadTransitMaps();
      }
      else if ((paramInt1 == 6) && (paramInt2 == 7))
      {
        loadTransitMaps();
      }
      else
      {
        if (paramInt1 == 1)
        {
          int j = ApplicationEngine.REVERSE_TRIP_ADDRESS;
          if (paramInt2 != j)
          {
            if (paramIntent != null)
            {
              String str12 = ApplicationEngine.REVERSE_TRIP_START_ADDRESS;
              String str13 = paramIntent.getStringExtra(str12);
              this.store_address_start = str13;
              String str14 = ApplicationEngine.REVERSE_TRIP_END_ADDRESS;
              String str15 = paramIntent.getStringExtra(str14);
              this.store_address_end = str15;
              EditText localEditText6 = this.address_a;
              String str16 = this.store_address_start;
              localEditText6.setText(str16);
              EditText localEditText7 = this.address_b;
              String str17 = this.store_address_end;
              localEditText7.setText(str17);
              String str18 = ApplicationEngine.SEARCH_X1;
              double d1 = paramIntent.getDoubleExtra(str18, 0.0D);
              this.store_address_x1 = d1;
              String str19 = ApplicationEngine.SEARCH_Y1;
              double d2 = paramIntent.getDoubleExtra(str19, 0.0D);
              this.store_address_y1 = d2;
              String str20 = ApplicationEngine.SEARCH_X2;
              double d3 = paramIntent.getDoubleExtra(str20, 0.0D);
              this.store_address_x2 = d3;
              String str21 = ApplicationEngine.SEARCH_Y2;
              double d4 = paramIntent.getDoubleExtra(str21, 0.0D);
              this.store_address_y2 = d4;
              this.store_consider_start_xy = true;
              this.store_consider_end_xy = true;
              String str22 = ApplicationEngine.REVERSE_TRIP_END_CITY;
              String str23 = paramIntent.getStringExtra(str22);
              String str24 = ApplicationEngine.REVERSE_TRIP_START_CITY;
              String str25 = paramIntent.getStringExtra(str24);
              setCityById(2131493001, str23);
              setCityById(2131493009, str25);
            }
            while (true)
            {
              i = ApplicationEngine.ZONE_DIRECTION_SEARCH;
              break;
              loadMainView();
            }
          }
        }
        if (paramInt2 == 701)
          loadSchedules();
        else if ((paramInt1 == 7) && (paramIntent != null) && (paramIntent != null))
          shareWithFriends(paramIntent);
      }
    }
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    int i = paramConfiguration.orientation;
    resetLayoutBasedOnConfiguration(i);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((ApplicationEngine.getModel() == null) || (ApplicationEngine.getModel().getCitiesCount() == 0))
    {
      Context localContext = getBaseContext();
      Intent localIntent1 = new Intent(localContext, SplashScreen.class);
      Intent localIntent2 = localIntent1.addFlags(67108864);
      startActivity(localIntent1);
      finish();
      return;
    }
    Intent localIntent3 = getIntent();
    String str1 = ApplicationEngine.SEE_NEARBY_BUSINESS_ON_MAP;
    if (!localIntent3.hasExtra(str1))
    {
      if (ApplicationEngine.getModel().getDefaultCitySelectionDone() != 0)
        break label331;
      loadDefaultCity();
    }
    while (true)
    {
      Intent localIntent4 = getIntent();
      String str2 = ApplicationEngine.REVERSE_TRIP_START_ADDRESS;
      if (localIntent4.hasExtra(str2))
      {
        EditText localEditText1 = this.address_a;
        Intent localIntent5 = getIntent();
        String str3 = ApplicationEngine.REVERSE_TRIP_START_ADDRESS;
        String str4 = localIntent5.getStringExtra(str3);
        localEditText1.setText(str4);
      }
      Intent localIntent6 = getIntent();
      String str5 = ApplicationEngine.REVERSE_TRIP_END_ADDRESS;
      if (localIntent6.hasExtra(str5))
      {
        EditText localEditText2 = this.address_b;
        Intent localIntent7 = getIntent();
        String str6 = ApplicationEngine.REVERSE_TRIP_END_ADDRESS;
        String str7 = localIntent7.getStringExtra(str6);
        localEditText2.setText(str7);
      }
      Intent localIntent8 = getIntent();
      String str8 = ApplicationEngine.REVERSE_TRIP_START_CITY;
      if (localIntent8.hasExtra(str8))
      {
        Intent localIntent9 = getIntent();
        String str9 = ApplicationEngine.REVERSE_TRIP_START_CITY;
        String str10 = localIntent9.getStringExtra(str9);
        setCityById(2131493009, str10);
      }
      Intent localIntent10 = getIntent();
      String str11 = ApplicationEngine.REVERSE_TRIP_END_CITY;
      if (!localIntent10.hasExtra(str11))
        return;
      Intent localIntent11 = getIntent();
      String str12 = ApplicationEngine.REVERSE_TRIP_END_CITY;
      String str13 = localIntent11.getStringExtra(str12);
      setCityById(2131493001, str13);
      EditText localEditText3 = this.address_b;
      Intent localIntent12 = getIntent();
      String str14 = ApplicationEngine.REVERSE_TRIP_END_ADDRESS;
      String str15 = localIntent12.getStringExtra(str14);
      localEditText3.setText(str15);
      return;
      label331: loadMainView();
      checkVersion();
      processIntent();
    }
  }

  public void onDestroy()
  {
    ApplicationEngine.getGPSEngine(null).cancelRequestAllGPS(null);
    super.onDestroy();
  }

  public void onResume()
  {
    if (this.isMainScreen)
    {
      String str1 = this.defaultCity;
      String str2 = ApplicationEngine.getModel().getDefaultCityId();
      if (str1.equals(str2))
      {
        int i = this.defaultCounty;
        int j = ApplicationEngine.getModel().getDefaultCountySelection();
        if (i == j);
      }
      else
      {
        String str3 = ApplicationEngine.getModel().getDefaultCityId();
        this.defaultCity = str3;
        int k = ApplicationEngine.getModel().getDefaultCountySelection();
        this.defaultCounty = k;
        InitSpinners();
      }
    }
    getWindow().setSoftInputMode(3);
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

  public void openHistoryActivity(int paramInt)
  {
    Intent localIntent = new Intent(this, HistoryCallsActivity.class);
    startActivityForResult(localIntent, paramInt);
  }

  public void run()
  {
    if (this.run_thread_request == 0)
    {
      if (ApplicationEngine.getModel().getDirectionMode().getMode().equals("j"))
        try
        {
          Controller localController1 = ApplicationEngine.getController();
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = this;
          DirectionRequest localDirectionRequest1 = ApplicationEngine.getModel().getDirectionRequest();
          arrayOfObject1[1] = localDirectionRequest1;
          ApplicationEngine.UiCallBack local14 = new ApplicationEngine.UiCallBack()
          {
            public void onStatusChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object[] paramAnonymousArrayOfObject)
            {
              int i = NetworkSettings.SUCCESS_GET_ROUTE;
              if (paramAnonymousInt2 != i)
              {
                TaxiResponse localTaxiResponse = (TaxiResponse)paramAnonymousArrayOfObject[0];
                DirectionResponse localDirectionResponse = (DirectionResponse)paramAnonymousArrayOfObject[1];
                String str1 = (String)paramAnonymousArrayOfObject[2];
                try
                {
                  Controller localController = ApplicationEngine.getController();
                  int j = 201;
                  Object[] arrayOfObject1 = new Object[2];
                  int k = 0;
                  StringBuilder localStringBuilder1;
                  if (DirectionsMainViewActivity.this.shouldUpdateHistoryA)
                  {
                    localStringBuilder1 = new java/lang/StringBuilder;
                    String str2 = String.valueOf(localTaxiResponse.getAddress1());
                    localStringBuilder1.<init>(str2);
                    if (localTaxiResponse.getZip1() != null)
                    {
                      String str3 = ",";
                      StringBuilder localStringBuilder2 = new StringBuilder(str3);
                      String str4 = localTaxiResponse.getZip1();
                      str5 = str4;
                      str5 = str5;
                      label140: arrayOfObject1[k] = str5;
                      k = 1;
                      if (!DirectionsMainViewActivity.this.shouldUpdateHistoryB)
                        break label366;
                      localStringBuilder1 = new java/lang/StringBuilder;
                      String str6 = String.valueOf(localTaxiResponse.getAddress2());
                      localStringBuilder1.<init>(str6);
                      if (localTaxiResponse.getZip2() == null)
                        break label359;
                      String str7 = ",";
                      StringBuilder localStringBuilder3 = new StringBuilder(str7);
                      String str8 = localTaxiResponse.getZip2();
                      str5 = str8;
                    }
                  }
                  label224: label359: label366: for (String str5 = str5; ; str5 = "")
                  {
                    arrayOfObject1[k] = str5;
                    localController.handleViewRequest(j, arrayOfObject1, null);
                    if (!localDirectionResponse.isSmartRoute())
                      break label385;
                    DirectionsMainViewActivity localDirectionsMainViewActivity1 = DirectionsMainViewActivity.this;
                    Intent localIntent1 = new Intent(localDirectionsMainViewActivity1, DirectionsSmartRouteResultActivity.class);
                    Intent localIntent2 = localIntent1.putExtra("requestURL", str1);
                    String str9 = localDirectionResponse.getAddress1();
                    Intent localIntent3 = localIntent1.putExtra("address1", str9);
                    String str10 = localDirectionResponse.getAddress2();
                    Intent localIntent4 = localIntent1.putExtra("address2", str10);
                    DirectionsMainViewActivity.this.startActivityForResult(localIntent1, 1);
                    DirectionsMainViewActivity.this.dismissProgressBar();
                    return;
                    str5 = "";
                    break;
                    str5 = "";
                    break label140;
                    str5 = "";
                    break label224;
                  }
                }
                catch (OutOfMemoryError localOutOfMemoryError)
                {
                  while (true)
                    localOutOfMemoryError.printStackTrace();
                }
                catch (IOException localIOException)
                {
                  while (true)
                  {
                    localIOException.printStackTrace();
                    continue;
                    label385: DirectionsMainViewActivity localDirectionsMainViewActivity2 = DirectionsMainViewActivity.this;
                    Intent localIntent5 = new Intent(localDirectionsMainViewActivity2, DirectionsTaxiActivity.class);
                    DirectionsMainViewActivity.this.startActivityForResult(localIntent5, 1);
                  }
                }
              }
              int m = NetworkSettings.SEVERAL_CHOICES_FOUND;
              if (paramAnonymousInt2 != m)
              {
                DirectionsMainViewActivity.this.dismissProgressBar();
                if (paramAnonymousArrayOfObject == null)
                  return;
                final ArrayList localArrayList;
                final CharSequence[] arrayOfCharSequence;
                int n;
                if (paramAnonymousArrayOfObject[1] != null)
                {
                  DirectionsMainViewActivity localDirectionsMainViewActivity3 = DirectionsMainViewActivity.this;
                  DirectionsMainViewActivity localDirectionsMainViewActivity4 = DirectionsMainViewActivity.this;
                  AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localDirectionsMainViewActivity4);
                  localDirectionsMainViewActivity3.builder2 = localBuilder1;
                  AlertDialog.Builder localBuilder2 = DirectionsMainViewActivity.this.builder2.setTitle("Confirm Destination Address");
                  localArrayList = (ArrayList)paramAnonymousArrayOfObject[1];
                  arrayOfCharSequence = new CharSequence[localArrayList.size()];
                  n = 0;
                  int i1 = localArrayList.size();
                  if (n >= i1)
                  {
                    AlertDialog.Builder localBuilder3 = DirectionsMainViewActivity.this.builder2;
                    14 local141 = this;
                    final Object[] arrayOfObject2 = paramAnonymousArrayOfObject;
                    DialogInterface.OnClickListener local1 = new DialogInterface.OnClickListener()
                    {
                      public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        Message localMessage = new Message();
                        localMessage.what = 9;
                        boolean bool = DirectionsMainViewActivity.this.alertHandler2.sendMessage(localMessage);
                        EditText localEditText = DirectionsMainViewActivity.this.address_b;
                        CharSequence localCharSequence = arrayOfCharSequence[paramAnonymous2Int];
                        localEditText.setText(localCharSequence);
                        Object[] arrayOfObject = arrayOfObject2;
                        String str1 = ((Address)localArrayList.get(paramAnonymous2Int)).getThumbnailId();
                        arrayOfObject[3] = str1;
                        DirectionsMainViewActivity localDirectionsMainViewActivity = DirectionsMainViewActivity.this;
                        String str2 = (String)arrayOfObject2[2];
                        String str3 = (String)arrayOfObject2[3];
                        String str4 = ApplicationEngine.getModel().getLanguage();
                        localDirectionsMainViewActivity.RequestDirectionsByThumbnail(str2, str3, str4);
                      }
                    };
                    AlertDialog.Builder localBuilder4 = localBuilder3.setSingleChoiceItems(arrayOfCharSequence, -1, local1);
                    Message localMessage1 = new Message();
                    localMessage1.what = 1;
                    boolean bool1 = DirectionsMainViewActivity.this.alertHandler2.sendMessage(localMessage1);
                  }
                }
                else if (paramAnonymousArrayOfObject[0] != null)
                {
                  DirectionsMainViewActivity localDirectionsMainViewActivity5 = DirectionsMainViewActivity.this;
                  DirectionsMainViewActivity localDirectionsMainViewActivity6 = DirectionsMainViewActivity.this;
                  AlertDialog.Builder localBuilder5 = new AlertDialog.Builder(localDirectionsMainViewActivity6);
                  localDirectionsMainViewActivity5.builder = localBuilder5;
                  AlertDialog.Builder localBuilder6 = DirectionsMainViewActivity.this.builder.setTitle("Confirm Start Address");
                  localArrayList = (ArrayList)paramAnonymousArrayOfObject[0];
                  arrayOfCharSequence = new CharSequence[localArrayList.size()];
                  n = 0;
                }
                while (true)
                {
                  int i2 = localArrayList.size();
                  if (n >= i2)
                  {
                    AlertDialog.Builder localBuilder7 = DirectionsMainViewActivity.this.builder;
                    14 local142 = this;
                    final Object[] arrayOfObject3 = paramAnonymousArrayOfObject;
                    DialogInterface.OnClickListener local2 = new DialogInterface.OnClickListener()
                    {
                      public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                      {
                        DirectionsMainViewActivity.this.dismissAlert();
                        EditText localEditText = DirectionsMainViewActivity.this.address_a;
                        CharSequence localCharSequence = arrayOfCharSequence[paramAnonymous2Int];
                        localEditText.setText(localCharSequence);
                        Object[] arrayOfObject = arrayOfObject3;
                        String str1 = ((Address)localArrayList.get(paramAnonymous2Int)).getThumbnailId();
                        arrayOfObject[2] = str1;
                        if (arrayOfObject3[1] != null)
                          return;
                        DirectionsMainViewActivity localDirectionsMainViewActivity = DirectionsMainViewActivity.this;
                        String str2 = (String)arrayOfObject3[2];
                        String str3 = (String)arrayOfObject3[3];
                        String str4 = ApplicationEngine.getModel().getLanguage();
                        localDirectionsMainViewActivity.RequestDirectionsByThumbnail(str2, str3, str4);
                      }
                    };
                    AlertDialog.Builder localBuilder8 = localBuilder7.setSingleChoiceItems(arrayOfCharSequence, -1, local2);
                    Message localMessage2 = new Message();
                    localMessage2.what = 1;
                    boolean bool2 = DirectionsMainViewActivity.this.alertHandler.sendMessage(localMessage2);
                    DirectionsMainViewActivity.this.trackEvent("Ambiguous Taxi Address Screen");
                    return;
                    String str11 = ((Address)localArrayList.get(n)).getAddress();
                    arrayOfCharSequence[n] = str11;
                    n += 1;
                    break;
                  }
                  String str12 = ((Address)localArrayList.get(n)).getAddress();
                  arrayOfCharSequence[n] = str12;
                  n += 1;
                }
              }
              DirectionsMainViewActivity.this.dismissProgressBar();
              int i3 = NetworkSettings.NO_TAXI_FOUND;
              if (paramAnonymousInt2 != i3)
              {
                DirectionsMainViewActivity localDirectionsMainViewActivity7 = DirectionsMainViewActivity.this;
                String str13 = DirectionsMainViewActivity.this.getString(2130968672);
                String str14 = DirectionsMainViewActivity.this.getString(2130968681);
                localDirectionsMainViewActivity7.ShowErrorMessage(str13, str14);
                return;
              }
              int i4 = NetworkSettings.STARTING_ADDRESS_NOT_FOUND;
              if (paramAnonymousInt2 != i4)
              {
                DirectionsMainViewActivity localDirectionsMainViewActivity8 = DirectionsMainViewActivity.this;
                String str15 = DirectionsMainViewActivity.this.getString(2130968672);
                String str16 = DirectionsMainViewActivity.this.getString(2130968666);
                localDirectionsMainViewActivity8.ShowErrorMessage(str15, str16);
                return;
              }
              int i5 = NetworkSettings.END_ADDRESS_NOT_FOUND;
              if (paramAnonymousInt2 != i5)
              {
                DirectionsMainViewActivity localDirectionsMainViewActivity9 = DirectionsMainViewActivity.this;
                String str17 = DirectionsMainViewActivity.this.getString(2130968672);
                String str18 = DirectionsMainViewActivity.this.getString(2130968667);
                localDirectionsMainViewActivity9.ShowErrorMessage(str17, str18);
                return;
              }
              int i6 = NetworkSettings.BOTH_ADDRESS_NOT_FOUND;
              if (paramAnonymousInt2 != i6)
              {
                DirectionsMainViewActivity localDirectionsMainViewActivity10 = DirectionsMainViewActivity.this;
                String str19 = DirectionsMainViewActivity.this.getString(2130968672);
                String str20 = DirectionsMainViewActivity.this.getString(2130968670);
                localDirectionsMainViewActivity10.ShowErrorMessage(str19, str20);
                return;
              }
              int i7 = NetworkSettings.ADDRESS_NOT_FOUND;
              if (paramAnonymousInt2 != i7)
              {
                DirectionsMainViewActivity localDirectionsMainViewActivity11 = DirectionsMainViewActivity.this;
                String str21 = DirectionsMainViewActivity.this.getString(2130968672);
                String str22 = (String)paramAnonymousArrayOfObject[0];
                localDirectionsMainViewActivity11.ShowErrorMessage(str21, str22);
                return;
              }
              int i8 = NetworkSettings.NETWORK_ERROR;
              if (paramAnonymousInt2 != i8)
              {
                DirectionsMainViewActivity localDirectionsMainViewActivity12 = DirectionsMainViewActivity.this;
                String str23 = DirectionsMainViewActivity.this.getString(2130968672);
                String str24 = DirectionsMainViewActivity.this.getString(2130968674);
                localDirectionsMainViewActivity12.ShowErrorMessage(str23, str24);
                return;
              }
              DirectionsMainViewActivity localDirectionsMainViewActivity13 = DirectionsMainViewActivity.this;
              String str25 = DirectionsMainViewActivity.this.getString(2130968672);
              String str26 = DirectionsMainViewActivity.this.getString(2130968681);
              localDirectionsMainViewActivity13.ShowErrorMessage(str25, str26);
            }
          };
          localController1.handleViewRequest(107, arrayOfObject1, local14);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          localOutOfMemoryError1.printStackTrace();
          return;
        }
        catch (IOException localIOException1)
        {
          localIOException1.printStackTrace();
          return;
        }
      try
      {
        Controller localController2 = ApplicationEngine.getController();
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = this;
        DirectionRequest localDirectionRequest2 = ApplicationEngine.getModel().getDirectionRequest();
        arrayOfObject2[1] = localDirectionRequest2;
        ApplicationEngine.UiCallBack local15 = new ApplicationEngine.UiCallBack()
        {
          public void onStatusChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object[] paramAnonymousArrayOfObject)
          {
            int i = NetworkSettings.SUCCESS_GET_ROUTE;
            if (paramAnonymousInt2 != i)
            {
              DirectionResponse localDirectionResponse;
              String str1;
              if ((paramAnonymousArrayOfObject[0] instanceof TaxiResponse))
              {
                localDirectionResponse = (DirectionResponse)paramAnonymousArrayOfObject[1];
                str1 = (String)paramAnonymousArrayOfObject[2];
              }
              try
              {
                Controller localController = ApplicationEngine.getController();
                int j = 201;
                Object[] arrayOfObject1 = new Object[2];
                int k = 0;
                StringBuilder localStringBuilder1;
                if (DirectionsMainViewActivity.this.shouldUpdateHistoryA)
                {
                  String str2 = String.valueOf(localDirectionResponse.getAddress1());
                  localStringBuilder1 = new StringBuilder(str2);
                  if (localDirectionResponse.getZip1() != null)
                  {
                    String str3 = ",";
                    StringBuilder localStringBuilder2 = new StringBuilder(str3);
                    String str4 = localDirectionResponse.getZip1();
                    StringBuilder localStringBuilder3 = localStringBuilder2.append(str4);
                    String str5 = "&&";
                    StringBuilder localStringBuilder4 = localStringBuilder3.append(str5);
                    String str6 = localDirectionResponse.getCity1();
                    str7 = str6;
                    label157: str7 = str7;
                    label169: arrayOfObject1[k] = str7;
                    k = 1;
                    if (!DirectionsMainViewActivity.this.shouldUpdateHistoryB)
                      break label442;
                    String str8 = String.valueOf(localDirectionResponse.getAddress2());
                    localStringBuilder1 = new StringBuilder(str8);
                    if (localDirectionResponse.getZip2() == null)
                      break label435;
                    String str9 = ",";
                    StringBuilder localStringBuilder5 = new StringBuilder(str9);
                    String str10 = localDirectionResponse.getZip2();
                    StringBuilder localStringBuilder6 = localStringBuilder5.append(str10);
                    String str11 = "&&";
                    StringBuilder localStringBuilder7 = localStringBuilder6.append(str11);
                    String str12 = localDirectionResponse.getCity2();
                    str7 = str12;
                  }
                }
                label281: label435: label442: for (String str7 = str7; ; str7 = "")
                {
                  arrayOfObject1[k] = str7;
                  localController.handleViewRequest(j, arrayOfObject1, null);
                  if (!localDirectionResponse.isSmartRoute())
                    break label461;
                  DirectionsMainViewActivity localDirectionsMainViewActivity1 = DirectionsMainViewActivity.this;
                  Intent localIntent1 = new Intent(localDirectionsMainViewActivity1, DirectionsSmartRouteResultActivity.class);
                  Intent localIntent2 = localIntent1.putExtra("requestURL", str1);
                  String str13 = localDirectionResponse.getAddress1();
                  Intent localIntent3 = localIntent1.putExtra("address1", str13);
                  String str14 = localDirectionResponse.getAddress2();
                  Intent localIntent4 = localIntent1.putExtra("address2", str14);
                  DirectionsMainViewActivity.this.startActivityForResult(localIntent1, 1);
                  DirectionsMainViewActivity.this.dismissProgressBar();
                  return;
                  localDirectionResponse = (DirectionResponse)paramAnonymousArrayOfObject[0];
                  str1 = (String)paramAnonymousArrayOfObject[1];
                  break;
                  str7 = "";
                  break label157;
                  str7 = "";
                  break label169;
                  str7 = "";
                  break label281;
                }
              }
              catch (OutOfMemoryError localOutOfMemoryError)
              {
                while (true)
                  localOutOfMemoryError.printStackTrace();
              }
              catch (IOException localIOException)
              {
                while (true)
                {
                  localIOException.printStackTrace();
                  continue;
                  label461: if ((localDirectionResponse.getMode() != null) && (localDirectionResponse.getMode().equals("j")))
                  {
                    DirectionsMainViewActivity localDirectionsMainViewActivity2 = DirectionsMainViewActivity.this;
                    Intent localIntent5 = new Intent(localDirectionsMainViewActivity2, DirectionsTaxiActivity.class);
                    DirectionsMainViewActivity.this.startActivityForResult(localIntent5, 1);
                  }
                  else
                  {
                    DirectionsMainViewActivity localDirectionsMainViewActivity3 = DirectionsMainViewActivity.this;
                    Intent localIntent6 = new Intent(localDirectionsMainViewActivity3, DirectionsResultActivity.class);
                    DirectionsMainViewActivity.this.startActivityForResult(localIntent6, 1);
                  }
                }
              }
            }
            int m = NetworkSettings.SEVERAL_CHOICES_FOUND;
            if (paramAnonymousInt2 != m)
            {
              DirectionsMainViewActivity.this.dismissProgressBar();
              if (paramAnonymousArrayOfObject == null)
                return;
              final ArrayList localArrayList;
              final CharSequence[] arrayOfCharSequence;
              int n;
              if (paramAnonymousArrayOfObject[1] != null)
              {
                DirectionsMainViewActivity localDirectionsMainViewActivity4 = DirectionsMainViewActivity.this;
                DirectionsMainViewActivity localDirectionsMainViewActivity5 = DirectionsMainViewActivity.this;
                AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localDirectionsMainViewActivity5);
                localDirectionsMainViewActivity4.builder2 = localBuilder1;
                AlertDialog.Builder localBuilder2 = DirectionsMainViewActivity.this.builder2.setTitle("Confirm Destination Address");
                localArrayList = (ArrayList)paramAnonymousArrayOfObject[1];
                arrayOfCharSequence = new CharSequence[localArrayList.size()];
                n = 0;
                int i1 = localArrayList.size();
                if (n >= i1)
                {
                  AlertDialog.Builder localBuilder3 = DirectionsMainViewActivity.this.builder2;
                  15 local151 = this;
                  final Object[] arrayOfObject2 = paramAnonymousArrayOfObject;
                  DialogInterface.OnClickListener local1 = new DialogInterface.OnClickListener()
                  {
                    public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      Message localMessage = new Message();
                      localMessage.what = 9;
                      boolean bool = DirectionsMainViewActivity.this.alertHandler2.sendMessage(localMessage);
                      EditText localEditText = DirectionsMainViewActivity.this.address_b;
                      CharSequence localCharSequence = arrayOfCharSequence[paramAnonymous2Int];
                      localEditText.setText(localCharSequence);
                      Object[] arrayOfObject = arrayOfObject2;
                      String str1 = ((Address)localArrayList.get(paramAnonymous2Int)).getThumbnailId();
                      arrayOfObject[3] = str1;
                      DirectionsMainViewActivity localDirectionsMainViewActivity = DirectionsMainViewActivity.this;
                      String str2 = (String)arrayOfObject2[2];
                      String str3 = (String)arrayOfObject2[3];
                      String str4 = ApplicationEngine.getModel().getLanguage();
                      localDirectionsMainViewActivity.RequestDirectionsByThumbnail(str2, str3, str4);
                    }
                  };
                  AlertDialog.Builder localBuilder4 = localBuilder3.setSingleChoiceItems(arrayOfCharSequence, -1, local1);
                  Message localMessage1 = new Message();
                  localMessage1.what = 1;
                  boolean bool1 = DirectionsMainViewActivity.this.alertHandler2.sendMessage(localMessage1);
                }
              }
              else if (paramAnonymousArrayOfObject[0] != null)
              {
                DirectionsMainViewActivity localDirectionsMainViewActivity6 = DirectionsMainViewActivity.this;
                DirectionsMainViewActivity localDirectionsMainViewActivity7 = DirectionsMainViewActivity.this;
                AlertDialog.Builder localBuilder5 = new AlertDialog.Builder(localDirectionsMainViewActivity7);
                localDirectionsMainViewActivity6.builder = localBuilder5;
                AlertDialog.Builder localBuilder6 = DirectionsMainViewActivity.this.builder.setTitle("Confirm Start Address");
                localArrayList = (ArrayList)paramAnonymousArrayOfObject[0];
                arrayOfCharSequence = new CharSequence[localArrayList.size()];
                n = 0;
              }
              while (true)
              {
                int i2 = localArrayList.size();
                if (n >= i2)
                {
                  AlertDialog.Builder localBuilder7 = DirectionsMainViewActivity.this.builder;
                  15 local152 = this;
                  final Object[] arrayOfObject3 = paramAnonymousArrayOfObject;
                  DialogInterface.OnClickListener local2 = new DialogInterface.OnClickListener()
                  {
                    public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                    {
                      DirectionsMainViewActivity.this.dismissAlert();
                      EditText localEditText = DirectionsMainViewActivity.this.address_a;
                      CharSequence localCharSequence = arrayOfCharSequence[paramAnonymous2Int];
                      localEditText.setText(localCharSequence);
                      Object[] arrayOfObject = arrayOfObject3;
                      String str1 = ((Address)localArrayList.get(paramAnonymous2Int)).getThumbnailId();
                      arrayOfObject[2] = str1;
                      if (arrayOfObject3[1] != null)
                        return;
                      DirectionsMainViewActivity localDirectionsMainViewActivity = DirectionsMainViewActivity.this;
                      String str2 = (String)arrayOfObject3[2];
                      String str3 = (String)arrayOfObject3[3];
                      String str4 = ApplicationEngine.getModel().getLanguage();
                      localDirectionsMainViewActivity.RequestDirectionsByThumbnail(str2, str3, str4);
                    }
                  };
                  AlertDialog.Builder localBuilder8 = localBuilder7.setSingleChoiceItems(arrayOfCharSequence, -1, local2);
                  Message localMessage2 = new Message();
                  localMessage2.what = 1;
                  boolean bool2 = DirectionsMainViewActivity.this.alertHandler.sendMessage(localMessage2);
                  DirectionsMainViewActivity.this.trackEvent("Ambiguous Address Screen");
                  return;
                  String str15 = ((Address)localArrayList.get(n)).getAddress();
                  arrayOfCharSequence[n] = str15;
                  n += 1;
                  break;
                }
                String str16 = ((Address)localArrayList.get(n)).getAddress();
                arrayOfCharSequence[n] = str16;
                n += 1;
              }
            }
            DirectionsMainViewActivity.this.dismissProgressBar();
            int i3 = NetworkSettings.STARTING_ADDRESS_NOT_FOUND;
            if (paramAnonymousInt2 != i3)
            {
              DirectionsMainViewActivity localDirectionsMainViewActivity8 = DirectionsMainViewActivity.this;
              String str17 = DirectionsMainViewActivity.this.getString(2130968672);
              String str18 = DirectionsMainViewActivity.this.getString(2130968666);
              localDirectionsMainViewActivity8.ShowErrorMessage(str17, str18);
              return;
            }
            int i4 = NetworkSettings.END_ADDRESS_NOT_FOUND;
            if (paramAnonymousInt2 != i4)
            {
              DirectionsMainViewActivity localDirectionsMainViewActivity9 = DirectionsMainViewActivity.this;
              String str19 = DirectionsMainViewActivity.this.getString(2130968672);
              String str20 = DirectionsMainViewActivity.this.getString(2130968667);
              localDirectionsMainViewActivity9.ShowErrorMessage(str19, str20);
              return;
            }
            int i5 = NetworkSettings.BOTH_ADDRESS_NOT_FOUND;
            if (paramAnonymousInt2 != i5)
            {
              DirectionsMainViewActivity localDirectionsMainViewActivity10 = DirectionsMainViewActivity.this;
              String str21 = DirectionsMainViewActivity.this.getString(2130968672);
              String str22 = DirectionsMainViewActivity.this.getString(2130968670);
              localDirectionsMainViewActivity10.ShowErrorMessage(str21, str22);
              return;
            }
            int i6 = NetworkSettings.ADDRESS_NOT_FOUND;
            if (paramAnonymousInt2 != i6)
            {
              DirectionsMainViewActivity localDirectionsMainViewActivity11 = DirectionsMainViewActivity.this;
              String str23 = DirectionsMainViewActivity.this.getString(2130968672);
              String str24 = (String)paramAnonymousArrayOfObject[0];
              localDirectionsMainViewActivity11.ShowErrorMessage(str23, str24);
              return;
            }
            int i7 = NetworkSettings.NETWORK_ERROR;
            if (paramAnonymousInt2 != i7)
            {
              DirectionsMainViewActivity localDirectionsMainViewActivity12 = DirectionsMainViewActivity.this;
              String str25 = DirectionsMainViewActivity.this.getString(2130968672);
              String str26 = DirectionsMainViewActivity.this.getString(2130968674);
              localDirectionsMainViewActivity12.ShowErrorMessage(str25, str26);
              return;
            }
            int i8 = NetworkSettings.ROUTE_NOT_FOUND;
            if (paramAnonymousInt2 != i8)
            {
              DirectionsMainViewActivity localDirectionsMainViewActivity13 = DirectionsMainViewActivity.this;
              String str27 = DirectionsMainViewActivity.this.getString(2130968672);
              String str28 = (String)paramAnonymousArrayOfObject[0];
              localDirectionsMainViewActivity13.ShowErrorMessage(str27, str28);
              return;
            }
            int i9 = NetworkSettings.UNKNOWN_ERROR;
            if (paramAnonymousInt2 != i9)
            {
              DirectionsMainViewActivity localDirectionsMainViewActivity14 = DirectionsMainViewActivity.this;
              String str29 = DirectionsMainViewActivity.this.getString(2130968672);
              String str30 = (String)paramAnonymousArrayOfObject[0];
              localDirectionsMainViewActivity14.ShowErrorMessage(str29, str30);
              return;
            }
            DirectionsMainViewActivity localDirectionsMainViewActivity15 = DirectionsMainViewActivity.this;
            String str31 = DirectionsMainViewActivity.this.getString(2130968672);
            String str32 = DirectionsMainViewActivity.this.getString(2130968680);
            localDirectionsMainViewActivity15.ShowErrorMessage(str31, str32);
          }
        };
        localController2.handleViewRequest(101, arrayOfObject2, local15);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        localOutOfMemoryError2.printStackTrace();
        return;
      }
      catch (IOException localIOException2)
      {
        localIOException2.printStackTrace();
        return;
      }
    }
    if (this.run_thread_request != 2)
      return;
    try
    {
      Controller localController3 = ApplicationEngine.getController();
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = this;
      ApplicationEngine.UiCallBack local16 = new ApplicationEngine.UiCallBack()
      {
        public void onStatusChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object[] paramAnonymousArrayOfObject)
        {
          DirectionsMainViewActivity.this.dismissProgressBar();
          if (DirectionsMainViewActivity.this._timer != null)
            DirectionsMainViewActivity.this._timer.cancel();
          if (1 != paramAnonymousInt2)
          {
            Location localLocation = (Location)paramAnonymousArrayOfObject[0];
            final Object[] arrayOfObject1 = new Object[2];
            Integer localInteger = Integer.valueOf(-1);
            arrayOfObject1[1] = localInteger;
            if (DirectionsMainViewActivity.this.getMainViewActivity().getLocationButton() == 2131492999)
              DirectionsMainViewActivity.this.address_a.setText(2130968631);
            try
            {
              while (true)
              {
                Controller localController = ApplicationEngine.getController();
                Object[] arrayOfObject2 = new Object[2];
                DirectionsMainViewActivity localDirectionsMainViewActivity = DirectionsMainViewActivity.this;
                arrayOfObject2[0] = localDirectionsMainViewActivity;
                arrayOfObject2[1] = localLocation;
                ApplicationEngine.UiCallBack local1 = new ApplicationEngine.UiCallBack()
                {
                  public void onStatusChanged(int paramAnonymous2Int1, int paramAnonymous2Int2, Object[] paramAnonymous2ArrayOfObject)
                  {
                    if (NetworkSettings.SUCCESS_GET_LONLAN_TO_CITY != paramAnonymous2Int2)
                      return;
                    String str1 = (String)paramAnonymous2ArrayOfObject[0];
                    arrayOfObject1[0] = str1;
                    Spinner localSpinner1 = null;
                    Spinner localSpinner2 = null;
                    String str2 = null;
                    int i = 0;
                    LinearLayout localLinearLayout = null;
                    if (DirectionsMainViewActivity.this.getMainViewActivity().getLocationButton() == 2131492999)
                    {
                      localSpinner1 = (Spinner)DirectionsMainViewActivity.this.findViewById(2131493001);
                      i = 2131493001;
                      localSpinner2 = (Spinner)DirectionsMainViewActivity.this.findViewById(2131493002);
                      localLinearLayout = (LinearLayout)DirectionsMainViewActivity.this.findViewById(2131493000);
                      str2 = (String)((Spinner)DirectionsMainViewActivity.this.findViewById(2131493009)).getSelectedItem();
                    }
                    DirectionsMainViewActivity.HopStopCityAdapter localHopStopCityAdapter;
                    String str3;
                    while (true)
                    {
                      localHopStopCityAdapter = (DirectionsMainViewActivity.HopStopCityAdapter)localSpinner1.getAdapter();
                      str3 = ApplicationEngine.getModel().findSelectedCityFromShotName(str1);
                      String str4 = localHopStopCityAdapter.getItem(0).toString();
                      if (!str3.equalsIgnoreCase(str4))
                        break;
                      return;
                      if (DirectionsMainViewActivity.this.getMainViewActivity().getLocationButton() == 2131493007)
                      {
                        localSpinner1 = (Spinner)DirectionsMainViewActivity.this.findViewById(2131493009);
                        i = 2131493009;
                        localSpinner2 = (Spinner)DirectionsMainViewActivity.this.findViewById(2131493010);
                        localLinearLayout = (LinearLayout)DirectionsMainViewActivity.this.findViewById(2131493008);
                        str2 = (String)((Spinner)DirectionsMainViewActivity.this.findViewById(2131493001)).getSelectedItem();
                      }
                      else if (DirectionsMainViewActivity.this.getMainViewActivity().getLocationButton() == 2131493020)
                      {
                        localSpinner1 = (Spinner)DirectionsMainViewActivity.this.findViewById(2131493023);
                        i = 2131493023;
                        localSpinner2 = (Spinner)DirectionsMainViewActivity.this.findViewById(2131493024);
                        localLinearLayout = (LinearLayout)DirectionsMainViewActivity.this.findViewById(2131493022);
                      }
                    }
                    int j = localHopStopCityAdapter.sortByString(str3);
                    localHopStopCityAdapter.sort(j);
                    if (j == 0)
                    {
                      int k = ApplicationEngine.getModel().getSelectedCityFromShotName(str1);
                      localHopStopCityAdapter.sort(k);
                    }
                    ApplicationEngine.getModel().setDefaultCityByWidgetId(i, str1);
                    String str5 = (String)localSpinner1.getSelectedItem();
                    localHopStopCityAdapter.updateSpinners(localSpinner2, localLinearLayout, str5, str2);
                  }
                };
                localController.handleViewRequest(301, arrayOfObject2, local1);
                return;
                if (DirectionsMainViewActivity.this.getMainViewActivity().getLocationButton() == 2131493007)
                {
                  DirectionsMainViewActivity.this.address_b.setText(2130968631);
                }
                else if (DirectionsMainViewActivity.this.getMainViewActivity().getLocationButton() == 2131493020)
                {
                  EditText localEditText = DirectionsMainViewActivity.this.map_req_address;
                  String str1 = DirectionsMainViewActivity.this.getMainViewActivity().getString(2130968631);
                  localEditText.setText(str1);
                }
              }
            }
            catch (OutOfMemoryError localOutOfMemoryError)
            {
              localOutOfMemoryError.printStackTrace();
              return;
            }
            catch (IOException localIOException)
            {
              localIOException.printStackTrace();
              return;
            }
          }
          if (2 != paramAnonymousInt2)
          {
            String str2 = (String)paramAnonymousArrayOfObject[0];
            Message localMessage1 = new Message();
            localMessage1.what = 0;
            boolean bool1 = DirectionsMainViewActivity.this.handler.sendMessage(localMessage1);
            AlertDialog.Builder localBuilder1 = DirectionsMainViewActivity.this.builder3.setTitle("Unable to find your location");
            AlertDialog.Builder localBuilder2 = DirectionsMainViewActivity.this.builder3.setMessage(str2);
            DialogInterface.OnClickListener local2 = new DialogInterface.OnClickListener()
            {
              public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                Message localMessage = new Message();
                localMessage.what = 9;
                boolean bool = DirectionsMainViewActivity.this.alertHandler3.sendMessage(localMessage);
              }
            };
            AlertDialog.Builder localBuilder3 = localBuilder2.setPositiveButton("Ok", local2);
            DialogInterface.OnClickListener local3 = new DialogInterface.OnClickListener()
            {
              public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                DirectionsMainViewActivity.this.getMainViewActivity().launchLocationSettings();
                Message localMessage = new Message();
                localMessage.what = 9;
                boolean bool = DirectionsMainViewActivity.this.alertHandler3.sendMessage(localMessage);
              }
            };
            AlertDialog.Builder localBuilder4 = localBuilder3.setNegativeButton("Change Settings", local3);
            Message localMessage2 = new Message();
            localMessage2.what = 1;
            boolean bool2 = DirectionsMainViewActivity.this.alertHandler3.sendMessage(localMessage2);
            return;
          }
          if (paramAnonymousInt2 == 0)
          {
            String str3 = (String)paramAnonymousArrayOfObject[0];
            Message localMessage3 = new Message();
            localMessage3.what = 0;
            boolean bool3 = DirectionsMainViewActivity.this.handler.sendMessage(localMessage3);
            AlertDialog.Builder localBuilder5 = DirectionsMainViewActivity.this.builder3.setTitle("Unable to find your location");
            AlertDialog.Builder localBuilder6 = DirectionsMainViewActivity.this.builder3.setMessage(str3);
            DialogInterface.OnClickListener local4 = new DialogInterface.OnClickListener()
            {
              public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                Message localMessage = new Message();
                localMessage.what = 9;
                boolean bool = DirectionsMainViewActivity.this.alertHandler3.sendMessage(localMessage);
              }
            };
            AlertDialog.Builder localBuilder7 = localBuilder6.setPositiveButton("Ok", local4);
            DialogInterface.OnClickListener local5 = new DialogInterface.OnClickListener()
            {
              public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                DirectionsMainViewActivity.this.getMainViewActivity().launchLocationSettings();
                Message localMessage = new Message();
                localMessage.what = 9;
                boolean bool = DirectionsMainViewActivity.this.alertHandler3.sendMessage(localMessage);
              }
            };
            AlertDialog.Builder localBuilder8 = localBuilder7.setNegativeButton("Check settings", local5);
            Message localMessage4 = new Message();
            localMessage4.what = 1;
            boolean bool4 = DirectionsMainViewActivity.this.alertHandler3.sendMessage(localMessage4);
            return;
          }
          if (DirectionsMainViewActivity.this.isBuilderShowing)
            return;
          Message localMessage5 = new Message();
          localMessage5.what = 0;
          boolean bool5 = DirectionsMainViewActivity.this.handler.sendMessage(localMessage5);
          String str4 = (String)paramAnonymousArrayOfObject[0];
          AlertDialog.Builder localBuilder9 = DirectionsMainViewActivity.this.builder3.setTitle("Unable to find your location");
          AlertDialog.Builder localBuilder10 = DirectionsMainViewActivity.this.builder3.setMessage(str4);
          DialogInterface.OnClickListener local6 = new DialogInterface.OnClickListener()
          {
            public void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              Message localMessage = new Message();
              localMessage.what = 9;
              boolean bool = DirectionsMainViewActivity.this.alertHandler3.sendMessage(localMessage);
            }
          };
          AlertDialog.Builder localBuilder11 = localBuilder10.setPositiveButton("Ok", local6);
          Message localMessage6 = new Message();
          localMessage6.what = 1;
          boolean bool6 = DirectionsMainViewActivity.this.alertHandler3.sendMessage(localMessage6);
        }
      };
      localController3.handleViewRequest(1, arrayOfObject3, local16);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError3)
    {
      localOutOfMemoryError3.printStackTrace();
      return;
    }
    catch (IOException localIOException3)
    {
      localIOException3.printStackTrace();
    }
  }

  public void setCityById(int paramInt, String paramString)
  {
    Spinner localSpinner = (Spinner)findViewById(paramInt);
    int i = ((HopStopCityAdapter)localSpinner.getAdapter()).getCityById(paramString);
    localSpinner.setSelection(i);
  }

  public void setLocationButton(int paramInt)
  {
    this.locationButton = paramInt;
  }

  private class GetVersionTask extends AsyncTask<Integer, Void, Boolean>
  {
    private GetVersionTask()
    {
    }

    protected Boolean doInBackground(Integer[] paramArrayOfInteger)
    {
      Boolean localBoolean = Boolean.valueOf(false);
      int i = 0;
      String str1 = "http://www.hopstop.com/android_market.txt";
      if (ApplicationEngine.APPLICATION_FOR_AMAZON_MARKET)
        str1 = "http://www.hopstop.com/android.txt";
      try
      {
        URLConnection localURLConnection = new URL(str1).openConnection();
        localURLConnection.setConnectTimeout(1000);
        localURLConnection.setReadTimeout(500);
        InputStream localInputStream = localURLConnection.getInputStream();
        InputStreamReader localInputStreamReader = new InputStreamReader(localInputStream);
        BufferedReader localBufferedReader = new BufferedReader(localInputStreamReader);
        while (true)
        {
          String str2 = localBufferedReader.readLine();
          if (str2 == null)
          {
            localBufferedReader.close();
            label97: int j = paramArrayOfInteger[0].intValue();
            if (i > j)
              localBoolean = Boolean.valueOf(true);
            return localBoolean;
          }
          int k = Integer.valueOf(str2).intValue();
          i = k;
        }
      }
      catch (Exception localException)
      {
        break label97;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label97;
      }
      catch (IOException localIOException)
      {
        break label97;
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        break label97;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        break label97;
      }
    }

    protected void onPostExecute(Boolean paramBoolean)
    {
      if (!paramBoolean.booleanValue())
        return;
      DirectionsMainViewActivity localDirectionsMainViewActivity = DirectionsMainViewActivity.this;
      AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localDirectionsMainViewActivity);
      int i = 2130968655;
      if (ApplicationEngine.APPLICATION_FOR_AMAZON_MARKET)
        i = 2130968767;
      AlertDialog.Builder localBuilder2 = localBuilder1.setMessage(i).setCancelable(false);
      DialogInterface.OnClickListener local1 = new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          ApplicationEngine.getModel().setDelayUpdateTime(0L);
          String str = "market://details?id=com.hopstop";
          if (ApplicationEngine.APPLICATION_FOR_AMAZON_MARKET)
            str = "http://www.amazon.com/gp/mas/dl/android?p=com.hopstop";
          Uri localUri = Uri.parse(str);
          Intent localIntent = new Intent("android.intent.action.VIEW", localUri);
          DirectionsMainViewActivity.this.startActivity(localIntent);
        }
      };
      AlertDialog.Builder localBuilder3 = localBuilder2.setPositiveButton(2130968656, local1);
      DialogInterface.OnClickListener local2 = new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          ApplicationEngine.getModel().setDelayUpdateTime(0L);
        }
      };
      AlertDialog.Builder localBuilder4 = localBuilder3.setNeutralButton(2130968677, local2);
      DialogInterface.OnClickListener local3 = new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          Model localModel = ApplicationEngine.getModel();
          long l = System.currentTimeMillis() + 604800000L;
          localModel.setDelayUpdateTime(l);
          paramAnonymousDialogInterface.cancel();
        }
      };
      AlertDialog.Builder localBuilder5 = localBuilder4.setNegativeButton(2130968678, local3);
      localBuilder1.create().show();
    }
  }

  private class HopStopCityAdapter extends ArrayAdapter<CharSequence>
  {
    private boolean isInit = false;
    private CharSequence[] items = null;
    private int resourceId = 0;

    public HopStopCityAdapter(Context paramInt1, int paramArrayOfCharSequence, CharSequence[] paramInt2, int arg5)
    {
      super(paramArrayOfCharSequence, paramInt2);
      this.items = paramInt2;
      int i;
      this.resourceId = i;
    }

    private void setTravelMode(String paramString1, String paramString2)
    {
      if ((paramString1.equalsIgnoreCase("new york")) && (paramString2.equalsIgnoreCase("new york")))
      {
        ApplicationEngine.getModel().getDirectionMode().setMode("s");
        ApplicationEngine.getModel().setRegional_rail(false);
      }
      while (true)
      {
        DirectionsMainViewActivity localDirectionsMainViewActivity = DirectionsMainViewActivity.this;
        Button localButton1 = (Button)DirectionsMainViewActivity.this.findViewById(2131493012);
        localDirectionsMainViewActivity.option_mode = localButton1;
        Button localButton2 = DirectionsMainViewActivity.this.option_mode;
        String str1 = String.valueOf(DirectionsMainViewActivity.this.getString(2130968622));
        StringBuilder localStringBuilder = new StringBuilder(str1).append(": ");
        String str2 = DirectionsMainViewActivity.this.getTransportationMode();
        String str3 = str2;
        localButton2.setText(str3);
        return;
        ApplicationEngine.getModel().getDirectionMode().setMode("a");
        ApplicationEngine.getModel().setRegional_rail(true);
      }
    }

    public int getCityById(String paramString)
    {
      int i = 0;
      while (true)
      {
        int j = this.items.length;
        if (i >= j)
          i = -1;
        String str1;
        String str2;
        do
        {
          return i;
          str1 = this.items[i].toString();
          str2 = ApplicationEngine.getModel().findSelectedCityFromShotName(paramString);
        }
        while (str1.equalsIgnoreCase(str2));
        i += 1;
      }
    }

    public int getCityByName(String paramString)
    {
      int i = 0;
      while (true)
      {
        int j = this.items.length;
        if (i >= j)
          i = -1;
        while (this.items[i].toString().equalsIgnoreCase(paramString))
          return i;
        i += 1;
      }
    }

    public CharSequence getItem(int paramInt)
    {
      return this.items[paramInt];
    }

    public int getResourceId()
    {
      return this.resourceId;
    }

    public void setInit(boolean paramBoolean)
    {
      this.isInit = paramBoolean;
    }

    public void sort(int paramInt)
    {
      Model localModel = ApplicationEngine.getModel();
      String str = this.items[paramInt].toString();
      localModel.rearrangeCities(str);
      String[] arrayOfString = ApplicationEngine.getModel().getCitiesNames();
      this.items = arrayOfString;
      notifyDataSetChanged();
    }

    public int sortByString(String paramString)
    {
      int i;
      if (this.items != null)
      {
        i = 0;
        int j = this.items.length;
        if (i >= j)
          i = -1;
      }
      while (true)
      {
        return i;
        if (!this.items[i].toString().equalsIgnoreCase(paramString))
        {
          i += 1;
          break;
          i = -1;
        }
      }
    }

    public void updateSpinners(Spinner paramSpinner, LinearLayout paramLinearLayout, String paramString1, String paramString2)
    {
      if (!paramString1.equalsIgnoreCase("New York"))
      {
        paramSpinner.setVisibility(8);
        paramLinearLayout.invalidate();
      }
      while ((paramString2 != null) && (ApplicationEngine.getModel().getDirectionMode().isModeBike()))
      {
        if (Util.isBikeModeAvailble(paramString1, paramString2))
          return;
        setTravelMode(paramString1, paramString2);
        return;
        if (paramString1.equalsIgnoreCase("New York"))
        {
          paramSpinner.setVisibility(0);
          paramLinearLayout.invalidate();
        }
      }
      if (paramString2 == null)
        return;
      setTravelMode(paramString1, paramString2);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.DirectionsMainViewActivity
 * JD-Core Version:    0.6.2
 */