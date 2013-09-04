package com.hopstop.ClientView;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.androidquery.AQuery;
import com.androidquery.AbstractAQuery;
import com.hopstop.ClientController.Controller;
import com.hopstop.ClientController.HSAsyncTask;
import com.hopstop.ClientModel.DirectionRequest;
import com.hopstop.ClientModel.DirectionResponse;
import com.hopstop.ClientModel.Model;
import com.hopstop.ClientModel.ResponseStatus;
import com.hopstop.ClientModel.SmartRoute.ExtraRoute;
import com.hopstop.ClientModel.SmartRoute.Icon;
import com.hopstop.ClientModel.SmartRoute.SmartRoute;
import com.hopstop.ClientModel.SmartRoute.Vehicle;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.core.ApplicationEngine.UiCallBack;
import com.hopstop.network.NetworkEngine;
import com.hopstop.network.NetworkSettings;
import com.hopstop.network.URLFactoryBuilder;
import com.hopstop.ui.BaseActivity;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.DisplayImageOptions.Builder;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder;
import java.io.IOException;
import java.io.StringReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class DirectionsSmartRouteResultActivity extends BaseActivity
{
  protected static final String ADDRESS1_KEY = "address1";
  protected static final String ADDRESS2_KEY = "address2";
  protected static final String REQUEST_URL_KEY = "requestURL";
  protected Dialog _dialog;
  private ProgressDialog _progressDialog;
  SmartRouteResultListAdapter adapter;
  private String address1;
  private String address2;
  private Handler alertHandlerMsg;
  private AlertDialog alertMsg;
  private AQuery aq;
  private AlertDialog.Builder builderMsg;
  private CallAPITask callAPItask;
  private boolean cancelled;
  private float density;
  DirectionResponse dr;
  private Handler feedback_handler;
  GetMoreRouteTask getMoreTask;
  private Handler handler;
  private String requestURL;
  private SmartRoute smartRouteData;
  private String smartRouteFeedbackLink = "http://www.hopstop.com/search?&trip_type=1&time=%s&mode=s&x1=&interval2=3600&city2=newyork&county2=QUEENS%2c%20NY%2c%20USA&day=2&interval1=3600&county1=BROOKLYN%2c%20NY%2c%20USA&arrive_by=0&x2=%2d73%2e83002&address2=120%2d34%20QUEENS%20BLVD%2c%20Queens%2c%20NY%2011415&city1=newyork&address1=1140%20Bergen%20Street%2c%20Brooklyn%20New%20York%2011216&stop_count=2&y2=40%2e713798&sm_rt=1&action=calc";
  private Thread thread;
  private int vehicleIconWidth;

  public DirectionsSmartRouteResultActivity()
  {
    Handler local1 = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        if (paramAnonymousMessage.what != 0)
          return;
        DirectionsSmartRouteResultActivity.this._progressDialog.dismiss();
      }
    };
    this.handler = local1;
    this.cancelled = false;
    Handler local2 = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        if (paramAnonymousMessage.what == 1)
        {
          DirectionsSmartRouteResultActivity localDirectionsSmartRouteResultActivity1 = DirectionsSmartRouteResultActivity.this;
          AlertDialog localAlertDialog1 = DirectionsSmartRouteResultActivity.this.builderMsg.create();
          localDirectionsSmartRouteResultActivity1.alertMsg = localAlertDialog1;
          DirectionsSmartRouteResultActivity.this.alertMsg.show();
          return;
        }
        if (paramAnonymousMessage.what == 9)
        {
          DirectionsSmartRouteResultActivity.this.alertMsg.dismiss();
          return;
        }
        if (paramAnonymousMessage.what != 2)
          return;
        DirectionsSmartRouteResultActivity localDirectionsSmartRouteResultActivity2 = DirectionsSmartRouteResultActivity.this;
        AlertDialog localAlertDialog2 = DirectionsSmartRouteResultActivity.this.builderMsg.create();
        localDirectionsSmartRouteResultActivity2.alertMsg = localAlertDialog2;
        DirectionsSmartRouteResultActivity.this.alertMsg.show();
      }
    };
    this.alertHandlerMsg = local2;
    Handler local3 = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        if (paramAnonymousMessage.what != 0)
          return;
        DirectionsSmartRouteResultActivity.this._dialog.dismiss();
      }
    };
    this.feedback_handler = local3;
  }

  private void LoadList()
  {
    ArrayList localArrayList = this.smartRouteData.getExtraRoutes();
    SmartRouteResultListAdapter localSmartRouteResultListAdapter1 = new SmartRouteResultListAdapter(this, localArrayList);
    this.adapter = localSmartRouteResultListAdapter1;
    final ListView localListView = ((AQuery)this.aq.id(2131493232)).getListView();
    LayoutInflater localLayoutInflater = (LayoutInflater)getSystemService("layout_inflater");
    View localView1 = localLayoutInflater.inflate(2130903119, null);
    TextView localTextView1 = (TextView)localView1.findViewById(2131493229);
    TextView localTextView2 = (TextView)localView1.findViewById(2131493230);
    String str1 = this.address1;
    localTextView1.setText(str1);
    String str2 = this.address2;
    localTextView2.setText(str2);
    localListView.addHeaderView(localView1, null, false);
    if ((this.smartRouteData.getExtraRoutesResumeData() != null) && (!this.smartRouteData.getExtraRoutesResumeData().equals("")))
    {
      final View localView2 = localLayoutInflater.inflate(2130903120, null);
      localListView.addFooterView(localView2);
      View.OnClickListener local5 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ListView localListView = localListView;
          View localView = localView2;
          boolean bool = localListView.removeFooterView(localView);
          DirectionsSmartRouteResultActivity localDirectionsSmartRouteResultActivity1 = DirectionsSmartRouteResultActivity.this;
          DirectionsSmartRouteResultActivity localDirectionsSmartRouteResultActivity2 = DirectionsSmartRouteResultActivity.this;
          DirectionsSmartRouteResultActivity.GetMoreRouteTask localGetMoreRouteTask1 = new DirectionsSmartRouteResultActivity.GetMoreRouteTask(localDirectionsSmartRouteResultActivity2, null);
          localDirectionsSmartRouteResultActivity1.getMoreTask = localGetMoreRouteTask1;
          DirectionsSmartRouteResultActivity.GetMoreRouteTask localGetMoreRouteTask2 = DirectionsSmartRouteResultActivity.this.getMoreTask;
          String[] arrayOfString = new String[1];
          String str1 = String.valueOf(URLFactoryBuilder.GetMoreSmartRouteRequest("extraRoutesResumeData="));
          StringBuilder localStringBuilder = new StringBuilder(str1);
          String str2 = URLEncoder.encode(DirectionsSmartRouteResultActivity.this.smartRouteData.getExtraRoutesResumeData());
          String str3 = str2;
          arrayOfString[0] = str3;
          AsyncTask localAsyncTask = localGetMoreRouteTask2.execute(arrayOfString);
        }
      };
      localView2.setOnClickListener(local5);
    }
    SmartRouteResultListAdapter localSmartRouteResultListAdapter2 = this.adapter;
    localListView.setAdapter(localSmartRouteResultListAdapter2);
    AdapterView.OnItemClickListener local6 = new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (paramAnonymousInt <= 0)
          return;
        ArrayList localArrayList = DirectionsSmartRouteResultActivity.this.smartRouteData.getExtraRoutes();
        int i = paramAnonymousInt + -1;
        ExtraRoute localExtraRoute = (ExtraRoute)localArrayList.get(i);
        StringBuilder localStringBuilder = new StringBuilder("extraRouteId=");
        String str1 = URLEncoder.encode(localExtraRoute.getId());
        String str2 = URLFactoryBuilder.GetSmartRouteRequest(str1);
        DirectionsSmartRouteResultActivity localDirectionsSmartRouteResultActivity = DirectionsSmartRouteResultActivity.this;
        String str3 = ((Vehicle)localExtraRoute.getVehicles().get(0)).getName();
        localDirectionsSmartRouteResultActivity.loadDirectionResult(str2, str3);
      }
    };
    localListView.setOnItemClickListener(local6);
  }

  private void dismissProgressBar()
  {
    AbstractAQuery localAbstractAQuery = ((AQuery)this.aq.id(2131493176)).gone();
  }

  private void loadDirectionResult(final String paramString1, final String paramString2)
  {
    if (this._progressDialog.isShowing())
      return;
    ProgressDialog localProgressDialog1 = ProgressDialog.show(this, "Please wait...", "Retrieving data ...", true, true);
    this._progressDialog = localProgressDialog1;
    ProgressDialog localProgressDialog2 = this._progressDialog;
    DialogInterface.OnCancelListener local7 = new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        DirectionsSmartRouteResultActivity.this.cancelled = true;
      }
    };
    localProgressDialog2.setOnCancelListener(local7);
    Thread local8 = new Thread()
    {
      public void run()
      {
        DirectionsSmartRouteResultActivity.this.cancelled = false;
        if (paramString2.equals("taxi"))
          try
          {
            Controller localController1 = ApplicationEngine.getController();
            Object[] arrayOfObject1 = new Object[2];
            DirectionsSmartRouteResultActivity localDirectionsSmartRouteResultActivity1 = DirectionsSmartRouteResultActivity.this;
            arrayOfObject1[0] = localDirectionsSmartRouteResultActivity1;
            String str1 = paramString1;
            arrayOfObject1[1] = str1;
            ApplicationEngine.UiCallBack local1 = new ApplicationEngine.UiCallBack()
            {
              public void onStatusChanged(int paramAnonymous2Int1, int paramAnonymous2Int2, Object[] paramAnonymous2ArrayOfObject)
              {
                if (DirectionsSmartRouteResultActivity.this.cancelled)
                  return;
                int i = NetworkSettings.SUCCESS_GET_ROUTE;
                if (paramAnonymous2Int2 != i)
                {
                  DirectionsSmartRouteResultActivity localDirectionsSmartRouteResultActivity1 = DirectionsSmartRouteResultActivity.this;
                  Intent localIntent = new Intent(localDirectionsSmartRouteResultActivity1, DirectionsTaxiActivity.class);
                  DirectionsSmartRouteResultActivity.this.startActivityForResult(localIntent, 1);
                }
                while (true)
                {
                  DirectionsSmartRouteResultActivity.this.dismissLoadingDialog();
                  return;
                  if ((paramAnonymous2ArrayOfObject != null) && (paramAnonymous2ArrayOfObject[0] != null))
                  {
                    DirectionsSmartRouteResultActivity localDirectionsSmartRouteResultActivity2 = DirectionsSmartRouteResultActivity.this;
                    String str1 = (String)paramAnonymous2ArrayOfObject[0];
                    localDirectionsSmartRouteResultActivity2.showDirectionResultError(paramAnonymous2Int2, str1);
                  }
                  else
                  {
                    DirectionsSmartRouteResultActivity localDirectionsSmartRouteResultActivity3 = DirectionsSmartRouteResultActivity.this;
                    String str2 = DirectionsSmartRouteResultActivity.this.getString(2130968680);
                    localDirectionsSmartRouteResultActivity3.showDirectionResultError(paramAnonymous2Int2, str2);
                  }
                }
              }
            };
            localController1.handleViewRequest(110, arrayOfObject1, local1);
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
          DirectionsSmartRouteResultActivity localDirectionsSmartRouteResultActivity2 = DirectionsSmartRouteResultActivity.this;
          arrayOfObject2[0] = localDirectionsSmartRouteResultActivity2;
          String str2 = paramString1;
          arrayOfObject2[1] = str2;
          ApplicationEngine.UiCallBack local2 = new ApplicationEngine.UiCallBack()
          {
            public void onStatusChanged(int paramAnonymous2Int1, int paramAnonymous2Int2, Object[] paramAnonymous2ArrayOfObject)
            {
              if (DirectionsSmartRouteResultActivity.this.cancelled)
                return;
              int i = NetworkSettings.SUCCESS_GET_ROUTE;
              if (paramAnonymous2Int2 != i)
              {
                DirectionsSmartRouteResultActivity localDirectionsSmartRouteResultActivity1 = DirectionsSmartRouteResultActivity.this;
                Intent localIntent = new Intent(localDirectionsSmartRouteResultActivity1, DirectionsResultActivity.class);
                DirectionsSmartRouteResultActivity.this.startActivityForResult(localIntent, 1);
                DirectionsSmartRouteResultActivity.this.dismissLoadingDialog();
              }
              while (true)
              {
                DirectionsSmartRouteResultActivity.this.dismissLoadingDialog();
                return;
                if ((paramAnonymous2ArrayOfObject != null) && (paramAnonymous2ArrayOfObject[0] != null))
                {
                  DirectionsSmartRouteResultActivity localDirectionsSmartRouteResultActivity2 = DirectionsSmartRouteResultActivity.this;
                  String str1 = (String)paramAnonymous2ArrayOfObject[0];
                  localDirectionsSmartRouteResultActivity2.showDirectionResultError(paramAnonymous2Int2, str1);
                }
                else
                {
                  DirectionsSmartRouteResultActivity localDirectionsSmartRouteResultActivity3 = DirectionsSmartRouteResultActivity.this;
                  String str2 = DirectionsSmartRouteResultActivity.this.getString(2130968680);
                  localDirectionsSmartRouteResultActivity3.showDirectionResultError(paramAnonymous2Int2, str2);
                }
              }
            }
          };
          localController2.handleViewRequest(109, arrayOfObject2, local2);
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
        }
      }
    };
    this.thread = local8;
    this.thread.start();
  }

  private void sendFeedbackEmail()
  {
    String str1 = getString(2130968653);
    String str2 = "";
    if (ApplicationEngine.getModel().getDirectionRequest() != null)
    {
      StringBuilder localStringBuilder = new StringBuilder("\n\n\n\nURL: ");
      String str3 = Uri.encode(ApplicationEngine.getModel().getDirectionRequest().getWebLink());
      str2 = str3;
    }
    String str4 = String.valueOf(str2);
    String str5 = str4 + "\n\n\nSent from HopStop Android App " + str1;
    sendEmail("feedback@hopstop.com", "HopStop Android App - Smart Route Feedback", str5);
  }

  public void GoHome()
  {
    Context localContext = getApplicationContext();
    Intent localIntent1 = new Intent(localContext, DirectionsMainViewActivity.class);
    Intent localIntent2 = localIntent1.setFlags(335544320);
    getApplicationContext().startActivity(localIntent1);
  }

  protected void LoadScreen(SmartRoute paramSmartRoute)
  {
    if (paramSmartRoute == null)
      showError("An error happened, please try again");
    while (true)
    {
      dismissProgressBar();
      return;
      if ((paramSmartRoute.getExtraRoutes() == null) || (paramSmartRoute.getExtraRoutes().size() == 0))
      {
        if (paramSmartRoute.getResponseStatus() == null)
        {
          showError(2130968786);
        }
        else
        {
          String str = paramSmartRoute.getResponseStatus().getErrorString();
          showError(str);
        }
      }
      else
      {
        this.smartRouteData = paramSmartRoute;
        LoadList();
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
    DialogInterface.OnClickListener local9 = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        DirectionsSmartRouteResultActivity.this.dismissErrorMessage();
      }
    };
    AlertDialog.Builder localBuilder4 = localBuilder3.setPositiveButton("OK", local9);
    Message localMessage2 = new Message();
    localMessage2.what = 1;
    boolean bool2 = this.alertHandlerMsg.sendMessage(localMessage2);
  }

  public void dismissErrorMessage()
  {
    Message localMessage = new Message();
    localMessage.what = 9;
    boolean bool = this.alertHandlerMsg.sendMessage(localMessage);
  }

  public void dismissLoadingDialog()
  {
    Message localMessage = new Message();
    localMessage.what = 0;
    boolean bool = this.handler.sendMessage(localMessage);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 1)
      return;
    int i = ApplicationEngine.REVERSE_TRIP_ADDRESS;
    if (paramInt2 != i)
      return;
    setResult(paramInt2, paramIntent);
    finish();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    float f = getResources().getDisplayMetrics().density;
    this.density = f;
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = (int)(this.density * 109.0F);
    int k = i - j;
    this.vehicleIconWidth = k;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    String str1 = getIntent().getStringExtra("requestURL");
    this.requestURL = str1;
    String str2 = getIntent().getStringExtra("address1");
    this.address1 = str2;
    String str3 = getIntent().getStringExtra("address2");
    this.address2 = str3;
    setContentView(2130903121);
    Hashtable localHashtable = new Hashtable();
    String str4 = ApplicationEngine.getModel().getDefaultCityId();
    Object localObject = localHashtable.put("defaultcity", str4);
    update(152034, localHashtable, null, null);
    AQuery localAQuery1 = new AQuery(this);
    this.aq = localAQuery1;
    AbstractAQuery localAbstractAQuery1 = ((AQuery)this.aq.id(2131492968)).text("Smart Route");
    trackEvent("Smart Route Screen");
    DisplayImageOptions localDisplayImageOptions = new DisplayImageOptions.Builder().cacheInMemory().cacheOnDisc().showStubImage(2130837564).build();
    Context localContext = getApplicationContext();
    ImageLoaderConfiguration localImageLoaderConfiguration = new ImageLoaderConfiguration.Builder(localContext).defaultDisplayImageOptions(localDisplayImageOptions).build();
    ImageLoader.getInstance().init(localImageLoaderConfiguration);
    AQuery localAQuery2 = (AQuery)this.aq.id(2131492906);
    View.OnClickListener local4 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DirectionsSmartRouteResultActivity localDirectionsSmartRouteResultActivity = DirectionsSmartRouteResultActivity.this;
        String str1 = String.valueOf(getClass().getName());
        String str2 = str1 + "Clicked on logo";
        localDirectionsSmartRouteResultActivity.LogD(str2);
        Context localContext = DirectionsSmartRouteResultActivity.this.getApplicationContext();
        Intent localIntent1 = new Intent(localContext, DirectionsMainViewActivity.class);
        Intent localIntent2 = localIntent1.setFlags(335544320);
        DirectionsSmartRouteResultActivity.this.getApplicationContext().startActivity(localIntent1);
      }
    };
    AbstractAQuery localAbstractAQuery2 = localAQuery2.clicked(local4);
    AbstractAQuery localAbstractAQuery3 = ((AQuery)this.aq.id(2131492970)).clicked(this, "showFeedbackDialog");
    AbstractAQuery localAbstractAQuery4 = ((AQuery)this.aq.id(2131492969)).clicked(this, "skipButtonClicked");
    AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(this);
    this.builderMsg = localBuilder1;
    AlertDialog.Builder localBuilder2 = this.builderMsg.setTitle("Sorry!");
    AlertDialog localAlertDialog = this.builderMsg.create();
    this.alertMsg = localAlertDialog;
    ProgressDialog localProgressDialog = new ProgressDialog(this);
    this._progressDialog = localProgressDialog;
    DirectionResponse localDirectionResponse = ApplicationEngine.getModel().getTrip(0);
    this.dr = localDirectionResponse;
    if ((this.dr != null) && (this.dr.getSmartRoute() != null))
    {
      SmartRoute localSmartRoute1 = this.dr.getSmartRoute();
      this.smartRouteData = localSmartRoute1;
      SmartRoute localSmartRoute2 = this.smartRouteData;
      LoadScreen(localSmartRoute2);
      dismissProgressBar();
      return;
    }
    SmartRoute localSmartRoute3 = new SmartRoute();
    this.smartRouteData = localSmartRoute3;
    CallAPITask localCallAPITask1 = new CallAPITask(null);
    this.callAPItask = localCallAPITask1;
    CallAPITask localCallAPITask2 = this.callAPItask;
    String[] arrayOfString = new String[1];
    String str5 = this.requestURL;
    arrayOfString[0] = str5;
    AsyncTask localAsyncTask = localCallAPITask2.execute(arrayOfString);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.callAPItask == null)
      return;
    if (this.callAPItask.isCancelled())
      return;
    boolean bool = this.callAPItask.cancel(true);
  }

  protected void onPause()
  {
    super.onPause();
  }

  public void onResume()
  {
    float f = getResources().getDisplayMetrics().density;
    this.density = f;
    int i = getResources().getDisplayMetrics().widthPixels;
    int j = (int)(this.density * 109.0F);
    int k = i - j;
    this.vehicleIconWidth = k;
    super.onResume();
  }

  protected void showDirectionResultError(int paramInt, String paramString)
  {
    int i = NetworkSettings.NO_TAXI_FOUND;
    if (paramInt != i)
    {
      String str1 = getString(2130968672);
      String str2 = getString(2130968681);
      ShowErrorMessage(str1, str2);
      return;
    }
    int j = NetworkSettings.STARTING_ADDRESS_NOT_FOUND;
    if (paramInt != j)
    {
      String str3 = getString(2130968672);
      ShowErrorMessage(str3, paramString);
      return;
    }
    int k = NetworkSettings.END_ADDRESS_NOT_FOUND;
    if (paramInt != k)
    {
      String str4 = getString(2130968672);
      ShowErrorMessage(str4, paramString);
      return;
    }
    int m = NetworkSettings.BOTH_ADDRESS_NOT_FOUND;
    if (paramInt != m)
    {
      String str5 = getString(2130968672);
      ShowErrorMessage(str5, paramString);
      return;
    }
    int n = NetworkSettings.ADDRESS_NOT_FOUND;
    if (paramInt != n)
    {
      String str6 = getString(2130968672);
      ShowErrorMessage(str6, paramString);
      return;
    }
    int i1 = NetworkSettings.NETWORK_ERROR;
    if (paramInt != i1)
    {
      String str7 = getString(2130968672);
      String str8 = getString(2130968674);
      ShowErrorMessage(str7, str8);
      return;
    }
    int i2 = NetworkSettings.ROUTE_NOT_FOUND;
    if (paramInt != i2)
    {
      String str9 = getString(2130968672);
      ShowErrorMessage(str9, paramString);
      return;
    }
    String str10 = getString(2130968672);
    if (paramString.length() > 0);
    while (true)
    {
      ShowErrorMessage(str10, paramString);
      return;
      paramString = getString(2130968680);
    }
  }

  protected void showError(int paramInt)
  {
    String str = getString(paramInt);
    showError(str);
  }

  protected void showError(String paramString)
  {
    AbstractAQuery localAbstractAQuery1 = ((AQuery)this.aq.id(2131493232)).gone();
    AbstractAQuery localAbstractAQuery2 = ((AQuery)this.aq.id(2131493178)).visible();
    AbstractAQuery localAbstractAQuery3 = ((AQuery)this.aq.id(2131493178)).text(paramString);
    dismissProgressBar();
  }

  public void showFeedbackDialog()
  {
    Dialog localDialog = new Dialog(this);
    this._dialog = localDialog;
    this._dialog.setContentView(2130903123);
    this._dialog.setTitle("Smart Route Info");
    this._dialog.setCancelable(true);
    this._dialog.setCanceledOnTouchOutside(true);
    Button localButton1 = (Button)this._dialog.findViewById(2131493236);
    View.OnClickListener local10 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DirectionsSmartRouteResultActivity.this.sendFeedbackEmail();
      }
    };
    localButton1.setOnClickListener(local10);
    Button localButton2 = (Button)this._dialog.findViewById(2131493237);
    View.OnClickListener local11 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DirectionsSmartRouteResultActivity.this._dialog.dismiss();
      }
    };
    localButton2.setOnClickListener(local11);
    this._dialog.show();
  }

  public void skipButtonClicked()
  {
    if ((ApplicationEngine.getModel().getTrip(0) != null) && (ApplicationEngine.getModel().getTrip(0).getViewSteps() != null) && (ApplicationEngine.getModel().getTrip(0).getViewSteps().size() != 0))
    {
      Intent localIntent = new Intent(this, DirectionsResultActivity.class);
      startActivityForResult(localIntent, 1);
      return;
    }
    ExtraRoute localExtraRoute = (ExtraRoute)this.smartRouteData.getExtraRoutes().get(0);
    StringBuilder localStringBuilder = new StringBuilder("extraRouteId=");
    String str1 = URLEncoder.encode(localExtraRoute.getId());
    String str2 = URLFactoryBuilder.GetSmartRouteRequest(str1);
    String str3 = ((Vehicle)localExtraRoute.getVehicles().get(0)).getName();
    loadDirectionResult(str2, str3);
  }

  private class CallAPITask extends HSAsyncTask<String, Void, SmartRoute>
  {
    private CallAPITask()
    {
    }

    protected SmartRoute doInBackground(String[] paramArrayOfString)
    {
      SmartRoute localSmartRoute = new SmartRoute();
      String str1 = paramArrayOfString[0];
      try
      {
        String str2 = ApplicationEngine.getNetworkEngine().retrieve(str1);
        if (str2 != null)
        {
          Persister localPersister = new Persister();
          StringReader localStringReader = new StringReader(str2);
          localSmartRoute = (SmartRoute)localPersister.read(SmartRoute.class, localStringReader, false);
        }
        return localSmartRoute;
      }
      catch (IOException localIOException)
      {
        while (true)
        {
          String str3 = DirectionsSmartRouteResultActivity.this.getString(2130968784);
          Error(localIOException, str3);
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          String str4 = DirectionsSmartRouteResultActivity.this.getString(2130968785);
          Error(localException, str4);
        }
      }
    }

    protected void onCancelled()
    {
      DirectionsSmartRouteResultActivity.this.LogD("SchedulesResultActivity, CallAPITask cancelled");
    }

    protected void onPostExecute(SmartRoute paramSmartRoute)
    {
      if (hasError())
      {
        DirectionsSmartRouteResultActivity localDirectionsSmartRouteResultActivity1 = DirectionsSmartRouteResultActivity.this;
        String str = getErrorString();
        localDirectionsSmartRouteResultActivity1.showError(str);
        return;
      }
      DirectionsSmartRouteResultActivity.this.smartRouteData = paramSmartRoute;
      DirectionsSmartRouteResultActivity localDirectionsSmartRouteResultActivity2 = DirectionsSmartRouteResultActivity.this;
      SmartRoute localSmartRoute = DirectionsSmartRouteResultActivity.this.smartRouteData;
      localDirectionsSmartRouteResultActivity2.LoadScreen(localSmartRoute);
    }

    protected void onPreExecute()
    {
    }

    protected void onProgressUpdate(Void[] paramArrayOfVoid)
    {
    }
  }

  private class GetMoreRouteTask extends HSAsyncTask<String, Void, SmartRoute>
  {
    private GetMoreRouteTask()
    {
    }

    protected SmartRoute doInBackground(String[] paramArrayOfString)
    {
      SmartRoute localSmartRoute = new SmartRoute();
      String str1 = paramArrayOfString[0];
      try
      {
        String str2 = ApplicationEngine.getNetworkEngine().retrieve(str1);
        if (str2 != null)
        {
          Persister localPersister = new Persister();
          StringReader localStringReader = new StringReader(str2);
          localSmartRoute = (SmartRoute)localPersister.read(SmartRoute.class, localStringReader, false);
        }
        return localSmartRoute;
      }
      catch (IOException localIOException)
      {
        while (true)
        {
          String str3 = DirectionsSmartRouteResultActivity.this.getString(2130968784);
          Error(localIOException, str3);
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          String str4 = DirectionsSmartRouteResultActivity.this.getString(2130968785);
          Error(localException, str4);
        }
      }
    }

    protected void onCancelled()
    {
      DirectionsSmartRouteResultActivity.this.LogD("SchedulesResultActivity, CallAPITask cancelled");
    }

    protected void onPostExecute(SmartRoute paramSmartRoute)
    {
      if (hasError())
      {
        DirectionsSmartRouteResultActivity localDirectionsSmartRouteResultActivity = DirectionsSmartRouteResultActivity.this;
        String str1 = getErrorString();
        localDirectionsSmartRouteResultActivity.showError(str1);
        return;
      }
      SmartRoute localSmartRoute1 = DirectionsSmartRouteResultActivity.this.smartRouteData;
      ArrayList localArrayList = paramSmartRoute.getExtraRoutes();
      localSmartRoute1.addExtraRoutes(localArrayList);
      SmartRoute localSmartRoute2 = DirectionsSmartRouteResultActivity.this.smartRouteData;
      String str2 = paramSmartRoute.getExtraRoutesResumeData();
      localSmartRoute2.setExtraRoutesResumeData(str2);
      DirectionsSmartRouteResultActivity.this.adapter.notifyDataSetChanged();
      final ListView localListView = ((AQuery)DirectionsSmartRouteResultActivity.this.aq.id(2131493232)).getListView();
      if ((paramSmartRoute.getExtraRoutesResumeData() != null) && (!paramSmartRoute.getExtraRoutesResumeData().equals("")))
      {
        final View localView = ((LayoutInflater)DirectionsSmartRouteResultActivity.this.getSystemService("layout_inflater")).inflate(2130903120, null);
        localListView.addFooterView(localView);
        View.OnClickListener local1 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            ListView localListView = localListView;
            View localView = localView;
            boolean bool = localListView.removeFooterView(localView);
            DirectionsSmartRouteResultActivity localDirectionsSmartRouteResultActivity1 = DirectionsSmartRouteResultActivity.this;
            DirectionsSmartRouteResultActivity localDirectionsSmartRouteResultActivity2 = DirectionsSmartRouteResultActivity.this;
            DirectionsSmartRouteResultActivity.GetMoreRouteTask localGetMoreRouteTask1 = new DirectionsSmartRouteResultActivity.GetMoreRouteTask(localDirectionsSmartRouteResultActivity2, null);
            localDirectionsSmartRouteResultActivity1.getMoreTask = localGetMoreRouteTask1;
            DirectionsSmartRouteResultActivity.GetMoreRouteTask localGetMoreRouteTask2 = DirectionsSmartRouteResultActivity.this.getMoreTask;
            String[] arrayOfString = new String[1];
            String str1 = String.valueOf(URLFactoryBuilder.GetMoreSmartRouteRequest("extraRoutesResumeData="));
            StringBuilder localStringBuilder = new StringBuilder(str1);
            String str2 = URLEncoder.encode(DirectionsSmartRouteResultActivity.this.smartRouteData.getExtraRoutesResumeData());
            String str3 = str2;
            arrayOfString[0] = str3;
            AsyncTask localAsyncTask = localGetMoreRouteTask2.execute(arrayOfString);
          }
        };
        localView.setOnClickListener(local1);
      }
      DirectionsSmartRouteResultActivity.this.dismissProgressBar();
    }

    protected void onPreExecute()
    {
      AbstractAQuery localAbstractAQuery = ((AQuery)DirectionsSmartRouteResultActivity.this.aq.id(2131493176)).visible();
    }

    protected void onProgressUpdate(Void[] paramArrayOfVoid)
    {
    }
  }

  static class ListViewItemHolder
  {
    public TextView duration;
    public TextView fare;
    public TextView start_end_time;
    public LinearLayout vehicle_icons;
  }

  public class SmartRouteResultListAdapter extends ArrayAdapter<ExtraRoute>
  {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<ExtraRoute> rows;

    public SmartRouteResultListAdapter(ArrayList<ExtraRoute> arg2)
    {
      super(2130903122, localList);
      this.rows = localList;
      this.context = localContext;
      LayoutInflater localLayoutInflater = (LayoutInflater)localContext.getSystemService("layout_inflater");
      this.inflater = localLayoutInflater;
    }

    private void createNewVehicleIcons(int paramInt, DirectionsSmartRouteResultActivity.ListViewItemHolder paramListViewItemHolder)
    {
      int i = ((ExtraRoute)this.rows.get(paramInt)).getVehicles().size();
      ArrayList localArrayList = ((ExtraRoute)this.rows.get(paramInt)).getVehicles();
      int j = paramListViewItemHolder.vehicle_icons.getPaddingLeft();
      int k = paramListViewItemHolder.vehicle_icons.getPaddingRight();
      int m = j + k + 30;
      int n = 0;
      while (true)
      {
        if (n >= i)
          return;
        int i1 = DirectionsSmartRouteResultActivity.this.vehicleIconWidth - m;
        int i2 = ((Vehicle)localArrayList.get(n)).getIcon().getWidth() * 2 + 5;
        if (i1 > i2)
        {
          Context localContext = this.context;
          ImageView localImageView = new ImageView(localContext);
          localImageView.setPadding(0, 0, 5, 0);
          paramListViewItemHolder.vehicle_icons.addView(localImageView);
          if (localImageView != null);
          try
          {
            ImageLoader localImageLoader = ImageLoader.getInstance();
            String str = ((Vehicle)localArrayList.get(n)).getIcon().getURL();
            localImageLoader.displayImage(str, localImageView);
            int i3 = ((Vehicle)localArrayList.get(n)).getIcon().getWidth() * 2 + 5;
            m += i3;
            n += 1;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            while (true)
              localOutOfMemoryError.printStackTrace();
          }
        }
      }
      TextView localTextView = (TextView)this.inflater.inflate(2130903118, null);
      paramListViewItemHolder.vehicle_icons.addView(localTextView);
    }

    private void populateText(int paramInt, DirectionsSmartRouteResultActivity.ListViewItemHolder paramListViewItemHolder)
    {
      TextView localTextView1 = paramListViewItemHolder.start_end_time;
      String str1 = String.valueOf(((ExtraRoute)this.rows.get(paramInt)).getDepartTimeVerb());
      StringBuilder localStringBuilder = new StringBuilder(str1).append(" - ");
      String str2 = ((ExtraRoute)this.rows.get(paramInt)).getArriveTimeVerbDisplay();
      String str3 = str2;
      localTextView1.setText(str3);
      TextView localTextView2 = paramListViewItemHolder.duration;
      String str4 = ((ExtraRoute)this.rows.get(paramInt)).getTotalTimeVerbDisplay();
      localTextView2.setText(str4);
      if (((ExtraRoute)this.rows.get(paramInt)).getTotalFarePriceVerb() != null)
      {
        TextView localTextView3 = paramListViewItemHolder.fare;
        String str5 = ((ExtraRoute)this.rows.get(paramInt)).getTotalFarePriceVerb();
        localTextView3.setText(str5);
        return;
      }
      paramListViewItemHolder.fare.setText("");
    }

    private void populateVehicleIcons(int paramInt, DirectionsSmartRouteResultActivity.ListViewItemHolder paramListViewItemHolder)
    {
      int i = paramListViewItemHolder.vehicle_icons.getChildCount();
      int j = 0;
      if (i != 0)
      {
        j = i;
        LinearLayout localLinearLayout = paramListViewItemHolder.vehicle_icons;
        int k = i + -1;
        if ((localLinearLayout.getChildAt(k) instanceof TextView))
        {
          j = i + -1;
          if (paramListViewItemHolder.vehicle_icons.getChildAt(j) != null)
            paramListViewItemHolder.vehicle_icons.removeViewAt(j);
        }
      }
      int m = ((ExtraRoute)this.rows.get(paramInt)).getVehicles().size();
      ArrayList localArrayList = ((ExtraRoute)this.rows.get(paramInt)).getVehicles();
      int i1;
      if (j > m)
      {
        int n = j + -1;
        if (n < m)
          i1 = 0;
        while (true)
        {
          if (i1 >= m)
          {
            return;
            if (paramListViewItemHolder.vehicle_icons.getChildAt(n) != null)
              paramListViewItemHolder.vehicle_icons.removeViewAt(n);
            n += -1;
            break;
          }
          ImageView localImageView1 = (ImageView)paramListViewItemHolder.vehicle_icons.getChildAt(i1);
          if (localImageView1 != null)
          {
            ImageLoader localImageLoader1 = ImageLoader.getInstance();
            String str1 = ((Vehicle)localArrayList.get(i1)).getIcon().getURL();
            localImageLoader1.displayImage(str1, localImageView1);
          }
          i1 += 1;
        }
      }
      int i2 = paramListViewItemHolder.vehicle_icons.getPaddingLeft();
      int i3 = paramListViewItemHolder.vehicle_icons.getPaddingRight();
      int i4 = i2 + i3 + 30;
      int i5 = 0;
      while (true)
      {
        label270: ImageView localImageView2;
        if (i5 >= j)
        {
          i1 = j;
          if (i1 >= m)
            return;
          int i6 = DirectionsSmartRouteResultActivity.this.vehicleIconWidth - i4;
          int i7 = ((Vehicle)localArrayList.get(i1)).getIcon().getWidth() * 2 + 5;
          if (i6 <= i7)
            break label524;
          Context localContext = this.context;
          localImageView2 = new ImageView(localContext);
          localImageView2.setPadding(0, 0, 5, 0);
          paramListViewItemHolder.vehicle_icons.addView(localImageView2);
          if (localImageView2 == null);
        }
        try
        {
          ImageLoader localImageLoader2 = ImageLoader.getInstance();
          String str2 = ((Vehicle)localArrayList.get(i1)).getIcon().getURL();
          localImageLoader2.displayImage(str2, localImageView2);
          int i8 = ((Vehicle)localArrayList.get(i1)).getIcon().getWidth() * 2 + 5;
          i4 += i8;
          i1 += 1;
          break label270;
          ImageView localImageView3 = (ImageView)paramListViewItemHolder.vehicle_icons.getChildAt(i5);
          if (localImageView3 != null)
          {
            ImageLoader localImageLoader3 = ImageLoader.getInstance();
            String str3 = ((Vehicle)localArrayList.get(i5)).getIcon().getURL();
            localImageLoader3.displayImage(str3, localImageView3);
            int i9 = ((Vehicle)localArrayList.get(i5)).getIcon().getWidth() * 2 + 5;
            int i10 = i4 + i9;
          }
          i5 += 1;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          while (true)
            localOutOfMemoryError.printStackTrace();
        }
      }
      label524: TextView localTextView = (TextView)this.inflater.inflate(2130903118, null);
      paramListViewItemHolder.vehicle_icons.addView(localTextView);
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = this.inflater.inflate(2130903122, null);
        DirectionsSmartRouteResultActivity.ListViewItemHolder localListViewItemHolder1 = new DirectionsSmartRouteResultActivity.ListViewItemHolder();
        TextView localTextView1 = (TextView)paramView.findViewById(2131493189);
        localListViewItemHolder1.start_end_time = localTextView1;
        TextView localTextView2 = (TextView)paramView.findViewById(2131493190);
        localListViewItemHolder1.duration = localTextView2;
        TextView localTextView3 = (TextView)paramView.findViewById(2131493235);
        localListViewItemHolder1.fare = localTextView3;
        LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131493234);
        localListViewItemHolder1.vehicle_icons = localLinearLayout;
        paramView.setTag(localListViewItemHolder1);
        populateText(paramInt, localListViewItemHolder1);
        createNewVehicleIcons(paramInt, localListViewItemHolder1);
      }
      while (true)
      {
        return paramView;
        DirectionsSmartRouteResultActivity.ListViewItemHolder localListViewItemHolder2 = (DirectionsSmartRouteResultActivity.ListViewItemHolder)paramView.getTag();
        populateText(paramInt, localListViewItemHolder2);
        if (paramInt == 0)
        {
          localListViewItemHolder2.vehicle_icons.removeAllViews();
          createNewVehicleIcons(paramInt, localListViewItemHolder2);
        }
        else
        {
          populateVehicleIcons(paramInt, localListViewItemHolder2);
        }
      }
    }

    public boolean isEnabled(int paramInt)
    {
      return true;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.DirectionsSmartRouteResultActivity
 * JD-Core Version:    0.6.2
 */