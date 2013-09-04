package com.hopstop.ClientView;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Spinner;
import android.widget.Toast;
import com.androidquery.AQuery;
import com.androidquery.AbstractAQuery;
import com.hopstop.ClientController.Controller;
import com.hopstop.ClientModel.Model;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.core.ApplicationEngine.UiCallBack;
import com.hopstop.gps.GPSEngine;
import com.hopstop.network.NetworkEngine;
import com.hopstop.network.NetworkSettings;
import com.hopstop.ui.BaseActivity;
import com.hopstop.util.Util;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Timer;
import java.util.TimerTask;

public class NearbyStationsRequestActivity extends BaseActivity
  implements Runnable
{
  private static final int CURRENT_LOCATION_REQ_TIMER = 5000;
  private static final int NO_CHANGE = 255;
  private ProgressDialog _progressDialog;
  private Timer _timer;
  private AlertDialog alert;
  private AlertDialog alert2;
  private AlertDialog alert3;
  private Handler alertHandlerMsg;
  private AlertDialog alertMsg;
  AQuery aq;
  private AlertDialog.Builder builder;
  private AlertDialog.Builder builder2;
  private AlertDialog.Builder builder3;
  private AlertDialog.Builder builderMsg;
  private String defaultCity;
  private int defaultCounty;
  private Handler handler;
  private boolean isBuilderShowing = false;
  SeekBar seekBar;

  public NearbyStationsRequestActivity()
  {
    Handler local1 = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        if (paramAnonymousMessage.what == 1)
        {
          NearbyStationsRequestActivity localNearbyStationsRequestActivity1 = NearbyStationsRequestActivity.this;
          AlertDialog localAlertDialog1 = NearbyStationsRequestActivity.this.builderMsg.create();
          localNearbyStationsRequestActivity1.alertMsg = localAlertDialog1;
          NearbyStationsRequestActivity.this.alertMsg.show();
          return;
        }
        if (paramAnonymousMessage.what == 9)
        {
          NearbyStationsRequestActivity.this.alertMsg.dismiss();
          return;
        }
        if (paramAnonymousMessage.what != 2)
          return;
        NearbyStationsRequestActivity localNearbyStationsRequestActivity2 = NearbyStationsRequestActivity.this;
        AlertDialog localAlertDialog2 = NearbyStationsRequestActivity.this.builderMsg.create();
        localNearbyStationsRequestActivity2.alertMsg = localAlertDialog2;
        NearbyStationsRequestActivity.this.alertMsg.show();
      }
    };
    this.alertHandlerMsg = local1;
    Handler local2 = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        if (paramAnonymousMessage.what == 0)
        {
          NearbyStationsRequestActivity.this._progressDialog.dismiss();
          NearbyStationsRequestActivity.this.stopSkyHook();
        }
        if (paramAnonymousMessage.what != 1)
          return;
        NearbyStationsRequestActivity.this._progressDialog.setMessage("It may take a moment to find your location, please be patient. To cancel, press the back button once. For best results, please enable GPS, Wireless Networks and WiFi in your phone's settings.");
      }
    };
    this.handler = local2;
  }

  private void initSpinners(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5)
  {
    String[] arrayOfString1 = ApplicationEngine.getModel().getCitiesNames();
    NearbyStationsRequestActivity localNearbyStationsRequestActivity1 = this;
    NearbyStationsRequestActivity localNearbyStationsRequestActivity2 = this;
    int i = paramInt2;
    HopStopCityAdapter localHopStopCityAdapter = new HopStopCityAdapter(localNearbyStationsRequestActivity2, 2130903085, arrayOfString1, i);
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
        break label240;
      int k = paramInt5;
      localSpinner2.setSelection(k);
    }
    while (true)
    {
      if (!ApplicationEngine.getModel().getDefaultCityByWidgetId(paramInt2).equals("newyork"))
        localSpinner2.setVisibility(8);
      AdapterView.OnItemSelectedListener local9 = new AdapterView.OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          NearbyStationsRequestActivity.HopStopCityAdapter localHopStopCityAdapter = (NearbyStationsRequestActivity.HopStopCityAdapter)paramAnonymousAdapterView.getAdapter();
          if (NearbyStationsRequestActivity.HopStopCityAdapter.access$1(localHopStopCityAdapter))
          {
            Model localModel1 = ApplicationEngine.getModel();
            int i = localHopStopCityAdapter.getResourceId();
            Model localModel2 = ApplicationEngine.getModel();
            String str1 = (String)localSpinner1.getSelectedItem();
            String str2 = localModel2.getSelectedCityFromName(str1);
            localModel1.setDefaultCityByWidgetId(i, str2);
          }
          if (paramAnonymousInt != 0)
          {
            localSpinner1.setSelection(0);
            localHopStopCityAdapter.sort(paramAnonymousInt);
          }
          while (true)
          {
            Spinner localSpinner = localSpinner2;
            LinearLayout localLinearLayout = localLinearLayout;
            String str3 = (String)paramAnonymousAdapterView.getSelectedItem();
            localHopStopCityAdapter.updateSpinners(localSpinner, localLinearLayout, str3, null);
            return;
            localHopStopCityAdapter.setInit(true);
          }
        }

        public void onNothingSelected(AdapterView paramAnonymousAdapterView)
        {
        }
      };
      localSpinner1.setOnItemSelectedListener(local9);
      final boolean bool = paramBoolean;
      AdapterView.OnItemSelectedListener local10 = new AdapterView.OnItemSelectedListener()
      {
        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          String str1 = Util.requiresBoroughChange((String)paramAnonymousAdapterView.getSelectedItem());
          if (str1 != null)
          {
            Spinner localSpinner = (Spinner)NearbyStationsRequestActivity.this.findViewById(2131493107);
            NearbyStationsRequestActivity.HopStopCityAdapter localHopStopCityAdapter = (NearbyStationsRequestActivity.HopStopCityAdapter)localSpinner.getAdapter();
            String str2 = ApplicationEngine.getModel().findSelectedCityFromShotName(str1);
            int i = localHopStopCityAdapter.getCityByName(str2);
            localSpinner.setSelection(i);
            paramAnonymousAdapterView.setVisibility(8);
            paramAnonymousAdapterView.invalidate();
            paramAnonymousAdapterView.setSelection(2);
          }
          if (!bool)
            return;
          Model localModel = ApplicationEngine.getModel();
          if (str1 == null);
          for (int j = paramAnonymousAdapterView.getSelectedItemPosition(); ; j = 2)
          {
            localModel.setDefaultCountySelection(j);
            return;
          }
        }

        public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView)
        {
        }
      };
      localSpinner2.setOnItemSelectedListener(local10);
      return;
      int m = ApplicationEngine.getModel().getDefaultCityPosition(paramInt2);
      localSpinner1.setSelection(m);
      break;
      label240: int n = ApplicationEngine.getModel().getDefaultCountySelection();
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
    DialogInterface.OnClickListener local7 = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        NearbyStationsRequestActivity.this.dismissErrorMessage();
      }
    };
    AlertDialog.Builder localBuilder4 = localBuilder3.setPositiveButton("OK", local7);
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

  public void createProgressDialogForLocation()
  {
    DialogInterface.OnCancelListener local5 = new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        ApplicationEngine.getGPSEngine(NearbyStationsRequestActivity.this).cancelRequestAllGPS(null);
        if (NearbyStationsRequestActivity.this._timer == null)
          return;
        NearbyStationsRequestActivity.this._timer.cancel();
      }
    };
    NearbyStationsRequestActivity localNearbyStationsRequestActivity = this;
    boolean bool = true;
    ProgressDialog localProgressDialog = ProgressDialog.show(localNearbyStationsRequestActivity, "Please wait...", "Getting Location ...", true, bool, local5);
    this._progressDialog = localProgressDialog;
    Timer localTimer1 = new Timer();
    this._timer = localTimer1;
    Timer localTimer2 = this._timer;
    TimerTask local6 = new TimerTask()
    {
      public void run()
      {
        NearbyStationsRequestActivity.this.changeProgressDialogForLocation();
        if (NearbyStationsRequestActivity.this._timer == null)
          return;
        NearbyStationsRequestActivity.this._timer.cancel();
      }
    };
    localTimer2.schedule(local6, 5000L);
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
    createProgressDialogForLocation();
    new Thread(this).start();
  }

  public void goButtonClicked()
  {
    String str1 = ((AQuery)this.aq.id(2131493102)).getText().toString();
    if (str1.length() == 0)
    {
      AlertDialog localAlertDialog = new AlertDialog.Builder(this).create();
      localAlertDialog.setMessage("Please Enter Address!");
      DialogInterface.OnClickListener local4 = new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface.dismiss();
        }
      };
      localAlertDialog.setButton("OK", local4);
      localAlertDialog.show();
      return;
    }
    Intent localIntent1 = new Intent(this, NearbyStationsResultActivity.class);
    String str2 = str1;
    String str3 = getString(2130968631);
    if (str1.equalsIgnoreCase(str3))
    {
      String str4 = String.valueOf(ApplicationEngine.getModel().Latitude());
      StringBuilder localStringBuilder = new StringBuilder(str4).append(",");
      double d = ApplicationEngine.getModel().Longitude();
      str2 = d;
    }
    Intent localIntent2 = localIntent1.putExtra("address", str2);
    Intent localIntent3 = localIntent1.putExtra("displayAddress", str1);
    int i = ((AQuery)this.aq.id(2131493107)).getSpinner().getSelectedItemPosition();
    String str5 = ApplicationEngine.getModel().getSelectedCityID(i);
    Intent localIntent4 = localIntent1.putExtra("\tcity", str5);
    Spinner localSpinner = ((AQuery)this.aq.id(2131493108)).getSpinner();
    if (localSpinner.getVisibility() == 0)
    {
      int j = localSpinner.getSelectedItemPosition();
      String str6 = ApplicationEngine.getModel().getCountyId(j);
      Intent localIntent5 = localIntent1.putExtra("county", str6);
    }
    int k = this.seekBar.getProgress() + 1;
    Intent localIntent6 = localIntent1.putExtra("maxStations", k);
    if (((AQuery)this.aq.id(2131493112)).isChecked())
    {
      Intent localIntent7 = localIntent1.putExtra("includedInBus", 1);
      Intent localIntent8 = localIntent1.putExtra("includedInSubway", 0);
    }
    while (true)
    {
      startActivity(localIntent1);
      return;
      if (((AQuery)this.aq.id(2131493111)).isChecked())
      {
        Intent localIntent9 = localIntent1.putExtra("includedInSubway", 1);
        Intent localIntent10 = localIntent1.putExtra("includedInBus", 0);
      }
      else
      {
        Intent localIntent11 = localIntent1.putExtra("includedInBus", 1);
        Intent localIntent12 = localIntent1.putExtra("includedInSubway", 1);
      }
    }
  }

  public void historyClicked()
  {
  }

  public void locationClicked()
  {
    getCurrentLocation();
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 10) && (paramInt2 == 1) && (paramIntent.hasExtra("get_address")))
    {
      AQuery localAQuery = (AQuery)this.aq.id(2131493102);
      String str = paramIntent.getStringExtra("get_address");
      AbstractAQuery localAbstractAQuery = localAQuery.text(str);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903095);
    AQuery localAQuery = new AQuery(this);
    this.aq = localAQuery;
    SeekBar localSeekBar1 = (SeekBar)((AQuery)this.aq.id(2131493116)).getView();
    this.seekBar = localSeekBar1;
    SeekBar localSeekBar2 = this.seekBar;
    SeekBar.OnSeekBarChangeListener local3 = new SeekBar.OnSeekBarChangeListener()
    {
      public void onProgressChanged(SeekBar paramAnonymousSeekBar, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        NearbyStationsRequestActivity.this.seekBarChanged();
      }

      public void onStartTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
      }

      public void onStopTrackingTouch(SeekBar paramAnonymousSeekBar)
      {
      }
    };
    localSeekBar2.setOnSeekBarChangeListener(local3);
    AbstractAQuery localAbstractAQuery1 = ((AQuery)this.aq.id(2131493105)).clicked(this, "locationClicked");
    AbstractAQuery localAbstractAQuery2 = ((AQuery)this.aq.id(2131493104)).clicked(this, "historyClicked");
    seekBarChanged();
    String str1 = ApplicationEngine.getModel().getDefaultCityId();
    this.defaultCity = str1;
    int i = ApplicationEngine.getModel().getDefaultCountySelection();
    this.defaultCounty = i;
    NearbyStationsRequestActivity localNearbyStationsRequestActivity = this;
    int j = -1;
    localNearbyStationsRequestActivity.initSpinners(2131493106, 2131493107, 2131493108, false, -1, j);
    AbstractAQuery localAbstractAQuery3 = ((AQuery)this.aq.id(2131493104)).clicked(this, "openHistoryActivity");
    AbstractAQuery localAbstractAQuery4 = ((AQuery)this.aq.id(2131493098)).clicked(this, "goButtonClicked");
    Hashtable localHashtable = new Hashtable();
    String str2 = ApplicationEngine.getModel().getDefaultCityId();
    Object localObject = localHashtable.put("defaultcity", str2);
    int k = ApplicationEngine.ZONE_STREET_MAP_RESULTS;
    update(k, localHashtable, null, null);
    trackEvent("Stations Search Screen");
  }

  public void onDestroy()
  {
    super.onDestroy();
  }

  public void onResume()
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
      NearbyStationsRequestActivity localNearbyStationsRequestActivity = this;
      int m = -1;
      localNearbyStationsRequestActivity.initSpinners(2131493106, 2131493107, 2131493108, false, -1, m);
    }
    super.onResume();
  }

  public void openHistoryActivity()
  {
    Intent localIntent = new Intent(this, HistoryCallsActivity.class);
    startActivityForResult(localIntent, 10);
  }

  public void run()
  {
    try
    {
      Controller localController = ApplicationEngine.getController();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this;
      ApplicationEngine.UiCallBack local8 = new ApplicationEngine.UiCallBack()
      {
        public void onStatusChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object[] paramAnonymousArrayOfObject)
        {
          NearbyStationsRequestActivity.this.dismissProgressBar();
          if (NearbyStationsRequestActivity.this._timer != null)
            NearbyStationsRequestActivity.this._timer.cancel();
          if (1 != paramAnonymousInt2)
            return;
          Location localLocation = (Location)paramAnonymousArrayOfObject[0];
          final Object[] arrayOfObject1 = new Object[2];
          Integer localInteger = Integer.valueOf(-1);
          arrayOfObject1[1] = localInteger;
          AbstractAQuery localAbstractAQuery = ((AQuery)NearbyStationsRequestActivity.this.aq.id(2131493102)).text(2130968631);
          try
          {
            Controller localController = ApplicationEngine.getController();
            Object[] arrayOfObject2 = new Object[2];
            NearbyStationsRequestActivity localNearbyStationsRequestActivity = NearbyStationsRequestActivity.this;
            arrayOfObject2[0] = localNearbyStationsRequestActivity;
            arrayOfObject2[1] = localLocation;
            ApplicationEngine.UiCallBack local1 = new ApplicationEngine.UiCallBack()
            {
              public void onStatusChanged(int paramAnonymous2Int1, int paramAnonymous2Int2, Object[] paramAnonymous2ArrayOfObject)
              {
                if (NetworkSettings.SUCCESS_GET_LONLAN_TO_CITY != paramAnonymous2Int2)
                  return;
                String str1 = (String)paramAnonymous2ArrayOfObject[0];
                arrayOfObject1[0] = str1;
                Spinner localSpinner1 = (Spinner)NearbyStationsRequestActivity.this.findViewById(2131493107);
                int i = 2131493107;
                Spinner localSpinner2 = (Spinner)NearbyStationsRequestActivity.this.findViewById(2131493108);
                LinearLayout localLinearLayout = (LinearLayout)NearbyStationsRequestActivity.this.findViewById(2131493106);
                NearbyStationsRequestActivity.HopStopCityAdapter localHopStopCityAdapter = (NearbyStationsRequestActivity.HopStopCityAdapter)localSpinner1.getAdapter();
                String str2 = ApplicationEngine.getModel().findSelectedCityFromShotName(str1);
                String str3 = localHopStopCityAdapter.getItem(0).toString();
                if (str2.equalsIgnoreCase(str3))
                  return;
                int j = localHopStopCityAdapter.sortByString(str2);
                localHopStopCityAdapter.sort(j);
                if (j == 0)
                {
                  int k = ApplicationEngine.getModel().getSelectedCityFromShotName(str1);
                  localHopStopCityAdapter.sort(k);
                }
                ApplicationEngine.getModel().setDefaultCityByWidgetId(i, str1);
                String str4 = (String)localSpinner1.getSelectedItem();
                localHopStopCityAdapter.updateSpinners(localSpinner2, localLinearLayout, str4, null);
              }
            };
            localController.handleViewRequest(301, arrayOfObject2, local1);
            return;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            localOutOfMemoryError.printStackTrace();
            return;
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
          }
        }
      };
      localController.handleViewRequest(1, arrayOfObject, local8);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  public void seekBarChanged()
  {
    String str = Integer.toString(this.seekBar.getProgress() + 1);
    AbstractAQuery localAbstractAQuery = ((AQuery)this.aq.id(2131493115)).text(str);
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
        return;
      }
      if (!paramString1.equalsIgnoreCase("New York"))
        return;
      paramSpinner.setVisibility(0);
      paramLinearLayout.invalidate();
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.NearbyStationsRequestActivity
 * JD-Core Version:    0.6.2
 */