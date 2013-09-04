package com.hopstop.ClientView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.OverlayItem;
import com.hopstop.ClientController.Controller;
import com.hopstop.ClientModel.DirectionMode;
import com.hopstop.ClientModel.DirectionResponse;
import com.hopstop.ClientModel.Model;
import com.hopstop.ClientModel.Yext.Address;
import com.hopstop.ClientModel.Yext.Listing;
import com.hopstop.ClientModel.Yext.YextListings;
import com.hopstop.ClientModel.directions.DirectionPathOverlay;
import com.hopstop.ClientModel.directions.GeoPoints;
import com.hopstop.ClientModel.directions.Icon;
import com.hopstop.ClientModel.directions.LoadImageFromNetworkTask;
import com.hopstop.ClientModel.directions.RouteIcons;
import com.hopstop.ClientModel.directions.RouteInfo;
import com.hopstop.ClientModel.directions.RouteOverlay;
import com.hopstop.ClientModel.directions.SavingManager;
import com.hopstop.ClientModel.directions.StartEndItemizedOverlay;
import com.hopstop.ClientModel.directions.ViewStep;
import com.hopstop.ClientModel.directions.ViewStepAddress;
import com.hopstop.ClientModel.directions.ViewStepDirections;
import com.hopstop.ClientModel.directions.ViewStepMap;
import com.hopstop.ClientModel.directions.ViewStepReverseNewSearch;
import com.hopstop.ClientModel.directions.ViewStepTotal;
import com.hopstop.ClientModel.directions.WrappedImageViewLayout;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.core.ApplicationEngine.UiCallBack;
import com.hopstop.core.ThreadUpdateResultsRunnable;
import com.hopstop.core.ThreadUpdateRunnable;
import com.hopstop.gps.XSPLocationManager;
import com.hopstop.network.NetworkEngine;
import com.hopstop.network.NetworkSettings;
import com.hopstop.network.URLFactoryBuilder;
import com.hopstop.ui.BaseMapActivity;
import com.hopstop.ui.ChevronImageView;
import com.hopstop.ui.PageNames;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.DisplayImageOptions.Builder;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

@SuppressLint({"HandlerLeak"})
public class DirectionsResultActivity extends BaseMapActivity
  implements View.OnClickListener, Runnable, TabHost.OnTabChangeListener
{
  private static Dialog _dialog;
  private static Dialog _dialogRightArrow;
  private static Dialog _dialogWheelChair;
  private static ProgressDialog _progressDialog;
  private static Handler alertHandlerMsg = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 1)
      {
        DirectionsResultActivity.alertMsg = DirectionsResultActivity.builderMsg.create();
        DirectionsResultActivity.alertMsg.show();
        return;
      }
      if (paramAnonymousMessage.what == 9)
      {
        DirectionsResultActivity.alertMsg.dismiss();
        return;
      }
      if (paramAnonymousMessage.what != 2)
        return;
      DirectionsResultActivity.alertMsg = DirectionsResultActivity.builderMsg.create();
      DirectionsResultActivity.alertMsg.show();
    }
  };
  private static AlertDialog alertMsg;
  private static AlertDialog.Builder builderMsg;
  private static Handler handler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 0)
      {
        if (DirectionsResultActivity._dialog == null)
          return;
        if (!DirectionsResultActivity._dialog.isShowing())
          return;
        DirectionsResultActivity._dialog.dismiss();
        return;
      }
      if (paramAnonymousMessage.what == 1)
      {
        DirectionsResultActivity._progressDialog.dismiss();
        return;
      }
      if (paramAnonymousMessage.what == 2)
      {
        DirectionsResultActivity._dialogWheelChair.dismiss();
        return;
      }
      if (paramAnonymousMessage.what != 3)
        return;
      DirectionsResultActivity._dialogRightArrow.dismiss();
    }
  };
  private final String LIST_TAB_TAG = "List";
  private int MAPVIEW_CENTER_BETWEEN_TWO_POINTS;
  private int MAPVIEW_END_POINT_CENTER;
  private int MAPVIEW_FIRST_START;
  private int MAPVIEW_NO_CENTER;
  private final String MAP_TAB_TAG = "Map";
  private StartEndItemizedOverlay _bgItemizedOverlay;
  private View _directionView;
  private StartEndItemizedOverlay _endOverlayPoint;
  private GeoPoint _endPoint;
  private ArrayList<GeoPoints> _geoPoints;
  private ListView _listView;
  private HopStopMapView _mapView;
  private int _mapviewAnimTpZoom;
  private MyLocationOverlay _me = null;
  private MyGpsMapOverlay _myGpsOverlay;
  private String _routeId;
  private SavingManager _savingManager;
  private StartEndItemizedOverlay _startOverlayPoint;
  private GeoPoint _startPoint;
  private TabHost _tabHost;
  private String _updatedURLString;
  private String _urlString;
  private Html.ImageGetter imgGetter;
  private LoadDirectionResultsTask loadDirectionResultsTask;
  private StepAdapter m_adapter;
  private GeoPoint mapCenterReserve;
  private int mapZoomLevelReserve;
  private Runnable returnRes;
  private Runnable returnUpdate;
  private int totalMapCount;
  private URLPart urlExcludedObjects;
  private URLPart urlReroute;
  private final String wasForceShutDown = "force-shutted-down";
  private Hashtable<String, Boolean> yextClickTracking;

  public DirectionsResultActivity()
  {
    Hashtable localHashtable = new Hashtable();
    this.yextClickTracking = localHashtable;
    Html.ImageGetter local1 = new Html.ImageGetter()
    {
      public Drawable getDrawable(String paramAnonymousString)
      {
        Drawable localDrawable = DirectionsResultActivity.this.getResources().getDrawable(2130837637);
        int i = localDrawable.getIntrinsicWidth();
        int j = localDrawable.getIntrinsicHeight();
        localDrawable.setBounds(0, 0, i, j);
        return localDrawable;
      }
    };
    this.imgGetter = local1;
    ThreadUpdateRunnable local3 = new ThreadUpdateRunnable()
    {
      private Bitmap bitmap;
      private ImageView imgView;

      public void getImageView(ImageView paramAnonymousImageView, Bitmap paramAnonymousBitmap)
      {
        this.imgView = paramAnonymousImageView;
        this.bitmap = paramAnonymousBitmap;
      }

      public void run()
      {
        DirectionsResultActivity localDirectionsResultActivity = DirectionsResultActivity.this;
        ImageView localImageView = this.imgView;
        Bitmap localBitmap = this.bitmap;
        localDirectionsResultActivity.updateMapView(localImageView, localBitmap);
      }
    };
    this.returnRes = local3;
    ThreadUpdateResultsRunnable local4 = new ThreadUpdateResultsRunnable()
    {
      private DirectionResponse dr;

      public void getImageView(DirectionResponse paramAnonymousDirectionResponse)
      {
        this.dr = paramAnonymousDirectionResponse;
      }

      public void run()
      {
        DirectionsResultActivity localDirectionsResultActivity = DirectionsResultActivity.this;
        DirectionResponse localDirectionResponse = this.dr;
        localDirectionsResultActivity.updateElementFromReposnse(localDirectionResponse);
      }
    };
    this.returnUpdate = local4;
    this.MAPVIEW_CENTER_BETWEEN_TWO_POINTS = 0;
    this.MAPVIEW_END_POINT_CENTER = 1;
    this.MAPVIEW_NO_CENTER = 2;
    this.MAPVIEW_FIRST_START = 3;
    int i = this.MAPVIEW_FIRST_START;
    this._mapviewAnimTpZoom = i;
  }

  private void ShowErrorMessage(String paramString1, String paramString2)
  {
    if (paramString1 != null)
      AlertDialog.Builder localBuilder1 = builderMsg.setTitle(paramString1);
    if (paramString2 != null)
      AlertDialog.Builder localBuilder2 = builderMsg.setMessage(paramString2);
    AlertDialog.Builder localBuilder3 = builderMsg;
    DialogInterface.OnClickListener local18 = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        DirectionsResultActivity.this.dismissErrorMessage();
      }
    };
    AlertDialog.Builder localBuilder4 = localBuilder3.setPositiveButton("OK", local18);
    Message localMessage = new Message();
    localMessage.what = 1;
    boolean bool = alertHandlerMsg.sendMessage(localMessage);
  }

  private static View createTabView(Context paramContext, String paramString, boolean paramBoolean)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2130903134, null);
    ((TextView)localView.findViewById(2131493280)).setText(paramString);
    return localView;
  }

  private void directionTo(Listing paramListing)
  {
    Intent localIntent1 = new Intent();
    String str1 = ApplicationEngine.REVERSE_TRIP_END_ADDRESS;
    String str2 = paramListing.getFormatedAddress();
    Intent localIntent2 = localIntent1.putExtra(str1, str2);
    int i = ApplicationEngine.REVERSE_TRIP_ADDRESS;
    setResult(i, localIntent1);
    finish();
  }

  private YextListings getNearbyBusiness(String paramString1, String paramString2, String paramString3)
  {
    final Object[] arrayOfObject1 = new Object[1];
    try
    {
      Controller localController = ApplicationEngine.getController();
      Object[] arrayOfObject2 = new Object[4];
      arrayOfObject2[0] = this;
      arrayOfObject2[1] = paramString1;
      arrayOfObject2[2] = paramString2;
      arrayOfObject2[3] = paramString3;
      ApplicationEngine.UiCallBack local9 = new ApplicationEngine.UiCallBack()
      {
        public void onStatusChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object[] paramAnonymousArrayOfObject)
        {
          int i = NetworkSettings.SUCCESS_GET_NEARBY_BUSINESS;
          if (paramAnonymousInt2 != i)
            return;
          Object[] arrayOfObject = arrayOfObject1;
          Object localObject = paramAnonymousArrayOfObject[0];
          arrayOfObject[0] = localObject;
        }
      };
      localController.handleViewRequest(401, arrayOfObject2, local9);
      return (YextListings)arrayOfObject1[0];
    }
    catch (IOException localIOException)
    {
      while (true)
        localIOException.printStackTrace();
    }
  }

  private void initView(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this._mapView == null)
        setContentView(2130903058);
      while (true)
      {
        this._tabHost.getTabWidget().getChildAt(1).setEnabled(false);
        SavingManager localSavingManager = new SavingManager(this);
        this._savingManager = localSavingManager;
        MyGpsMapOverlay localMyGpsMapOverlay = new MyGpsMapOverlay(this);
        this._myGpsOverlay = localMyGpsMapOverlay;
        LoadDirectionResultsTask localLoadDirectionResultsTask1 = new LoadDirectionResultsTask(null);
        this.loadDirectionResultsTask = localLoadDirectionResultsTask1;
        LoadDirectionResultsTask localLoadDirectionResultsTask2 = this.loadDirectionResultsTask;
        Void[] arrayOfVoid = new Void[0];
        AsyncTask localAsyncTask1 = localLoadDirectionResultsTask2.execute(arrayOfVoid);
        String str1 = PageNames.DirectionResult;
        trackEvent(str1);
        DirectionResponse localDirectionResponse = ApplicationEngine.getModel().getTrip(0);
        String str2 = localDirectionResponse.getRouteId();
        this._routeId = str2;
        NearbyBusinessTask localNearbyBusinessTask = new NearbyBusinessTask();
        String[] arrayOfString = new String[2];
        String str3 = Double.toString(localDirectionResponse.getY2());
        arrayOfString[0] = str3;
        String str4 = Double.toString(localDirectionResponse.getX2());
        arrayOfString[1] = str4;
        AsyncTask localAsyncTask2 = localNearbyBusinessTask.execute(arrayOfString);
        return;
        boolean bool = this._mapView.recycle();
        ListView localListView = new ListView(this);
        this._listView = localListView;
      }
    }
    TabHost localTabHost1 = (TabHost)findViewById(16908306);
    this._tabHost = localTabHost1;
    this._tabHost.setup();
    this._tabHost.setOnTabChangedListener(this);
    HopStopMapView localHopStopMapView = (HopStopMapView)findViewById(2131492985);
    this._mapView = localHopStopMapView;
    this._mapView.setBuiltInZoomControls(true);
    View localView1 = findViewById(2131492947);
    this._directionView = localView1;
    TabHost localTabHost2 = this._tabHost;
    TabHost.TabSpec localTabSpec1 = this._tabHost.newTabSpec("List");
    View localView2 = createTabView(this, "Route", true);
    TabHost.TabSpec localTabSpec2 = localTabSpec1.setIndicator(localView2);
    TabHost.TabContentFactory local7 = new TabHost.TabContentFactory()
    {
      public View createTabContent(String paramAnonymousString)
      {
        return DirectionsResultActivity.this._directionView;
      }
    };
    TabHost.TabSpec localTabSpec3 = localTabSpec2.setContent(local7);
    localTabHost2.addTab(localTabSpec3);
    TabHost localTabHost3 = this._tabHost;
    TabHost.TabSpec localTabSpec4 = this._tabHost.newTabSpec("Map");
    View localView3 = createTabView(this, "Map", false);
    TabHost.TabSpec localTabSpec5 = localTabSpec4.setIndicator(localView3);
    TabHost.TabContentFactory local8 = new TabHost.TabContentFactory()
    {
      public View createTabContent(String paramAnonymousString)
      {
        return DirectionsResultActivity.this._mapView;
      }
    };
    TabHost.TabSpec localTabSpec6 = localTabSpec5.setContent(local8);
    localTabHost3.addTab(localTabSpec6);
    TabWidget localTabWidget = (TabWidget)findViewById(16908307);
    int i = localTabWidget.getChildCount();
    int j = 0;
    while (true)
    {
      if (j >= i)
      {
        localTabWidget.requestLayout();
        this._tabHost.setCurrentTab(1);
        this._tabHost.setCurrentTab(0);
        break;
      }
      ((LinearLayout.LayoutParams)localTabWidget.getChildAt(j).getLayoutParams()).setMargins(5, 0, 5, 0);
      j += 1;
    }
  }

  private void sendDirection(Intent paramIntent)
  {
    DirectionResponse localDirectionResponse = ApplicationEngine.getModel().getTrip(0);
    if (localDirectionResponse == null)
      return;
    StringBuilder localStringBuilder1 = new StringBuilder("HopStop Directions from ");
    String str1 = localDirectionResponse.getAddress1();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(" to ");
    String str2 = localDirectionResponse.getAddress2();
    String str3 = str2;
    String str4 = String.valueOf("The directions below have been sent to you from HopStop's free Android app:\n\n");
    StringBuilder localStringBuilder3 = new StringBuilder(str4);
    String str5 = getDirectionText(localDirectionResponse, "\n");
    String str6 = String.valueOf(str5);
    StringBuilder localStringBuilder4 = new StringBuilder(str6).append("\nView these directions with walking maps on the HopStop Mobile Site:\n http://www.HopStop.com/pda?");
    String str7 = localDirectionResponse.getRouteId();
    String str8 = String.valueOf(str7 + '\n');
    StringBuilder localStringBuilder5 = new StringBuilder(str8).append("\nView these directions with walking maps and interactive maps on HopStop.com:\n http://www.HopStop.com?action=route&route_id=");
    String str9 = localDirectionResponse.getRouteId();
    String str10 = String.valueOf(str9 + '\n');
    StringBuilder localStringBuilder6 = new StringBuilder(str10);
    String str11 = getString(2130968773);
    String str12 = str11;
    StringBuilder localStringBuilder7 = new StringBuilder("http://hopstop.com/pda?");
    String str13 = localDirectionResponse.getRouteId();
    String str14 = str13;
    StringBuilder localStringBuilder8 = new StringBuilder("From: ");
    String str15;
    String str16;
    label313: String str18;
    String str19;
    if (localDirectionResponse.getAddress1() != null)
    {
      str15 = localDirectionResponse.getAddress1();
      StringBuilder localStringBuilder9 = localStringBuilder8.append(str15).append(", ").append("To: ");
      if (localDirectionResponse.getAddress2() == null)
        break label414;
      str16 = localDirectionResponse.getAddress2();
      StringBuilder localStringBuilder10 = localStringBuilder9.append(str16).append(", ").append("Link: ").append("http://hopstop.com/pda?");
      String str17 = localDirectionResponse.getRouteId();
      str18 = str17;
      str19 = paramIntent.getComponent().getClassName();
      Intent localIntent1 = paramIntent.putExtra("android.intent.extra.SUBJECT", str3);
      if (!str19.contains("facebook"))
        break label422;
      Intent localIntent2 = paramIntent.putExtra("android.intent.extra.TEXT", str14);
    }
    while (true)
    {
      startActivity(paramIntent);
      return;
      str15 = "My Current Location";
      break;
      label414: str16 = "My Current Location";
      break label313;
      label422: if ((str19.toLowerCase().contains("mail")) || (str19.contains("k9")))
        Intent localIntent3 = paramIntent.putExtra("android.intent.extra.TEXT", str12);
      else
        Intent localIntent4 = paramIntent.putExtra("android.intent.extra.TEXT", str18);
    }
  }

  private void setMapZoomPoint(GeoPoint paramGeoPoint, int paramInt)
  {
    int i = this.MAPVIEW_END_POINT_CENTER;
    this._mapviewAnimTpZoom = i;
    this._mapView.getController().setCenter(paramGeoPoint);
    int j = this._mapView.getController().setZoom(paramInt);
    this._mapView.postInvalidate();
  }

  private void updateDirections(String paramString)
  {
    this._updatedURLString = paramString;
    _progressDialog = ProgressDialog.show(this, "Please wait...", "Retrieving data ...", true);
    new Thread(this).start();
  }

  private void updateElementFromReposnse(DirectionResponse paramDirectionResponse)
  {
    if (paramDirectionResponse == null)
      return;
    initView(true);
  }

  public void checkTripName(String paramString)
  {
    if (paramString.trim().equals(""))
    {
      createDialogForTripName("Trip not saved, at least one character expected");
      return;
    }
    if (ApplicationEngine.getModel().checkForDuplicateTrip(paramString))
    {
      createDialogForTripName("Trip not saved, same name exists. Please use other names.");
      return;
    }
    saveRoute(paramString);
  }

  protected String constracutURL()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    if ((this.urlReroute != null) && (this.urlReroute.include))
    {
      String str1 = this.urlReroute.getUrl();
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    }
    if ((this.urlExcludedObjects != null) && (this.urlExcludedObjects.include))
    {
      String str2 = this.urlExcludedObjects.getUrl();
      StringBuilder localStringBuilder3 = localStringBuilder1.append(str2);
    }
    return localStringBuilder1.toString();
  }

  public void createDialogForShare()
  {
    Message localMessage = new Message();
    localMessage.what = 0;
    boolean bool = handler.sendMessage(localMessage);
    try
    {
      Intent localIntent1 = new Intent("android.intent.action.SEND", null);
      Intent localIntent2 = localIntent1.addCategory("android.intent.category.DEFAULT");
      Intent localIntent3 = localIntent1.setType("text/plain");
      Intent localIntent4 = new Intent("android.intent.action.PICK_ACTIVITY");
      Intent localIntent5 = localIntent4.putExtra("android.intent.extra.INTENT", localIntent1);
      startActivityForResult(localIntent4, 0);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
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
      startActivityForResult(localIntent4, 0);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void createDialogForTripName(String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = 0;
    boolean bool = handler.sendMessage(localMessage);
    AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(this);
    final EditText localEditText = new EditText(this);
    AlertDialog.Builder localBuilder2 = localBuilder1.setView(localEditText);
    DialogInterface.OnClickListener local10 = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        String str = localEditText.getText().toString().trim();
        DirectionsResultActivity.this.checkTripName(str);
        InputMethodManager localInputMethodManager = (InputMethodManager)DirectionsResultActivity.this.getSystemService("input_method");
        IBinder localIBinder = localEditText.getWindowToken();
        boolean bool = localInputMethodManager.hideSoftInputFromWindow(localIBinder, 0);
      }
    };
    AlertDialog.Builder localBuilder3 = localBuilder1.setPositiveButton("Ok", local10);
    DialogInterface.OnClickListener local11 = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.cancel();
      }
    };
    AlertDialog.Builder localBuilder4 = localBuilder1.setNegativeButton("Cancel", local11);
    AlertDialog.Builder localBuilder5 = localBuilder1.setTitle(paramString);
    AlertDialog localAlertDialog = localBuilder1.show();
  }

  public void dismissErrorMessage()
  {
    Message localMessage = new Message();
    localMessage.what = 9;
    boolean bool = alertHandlerMsg.sendMessage(localMessage);
  }

  public String getDirectionText(DirectionResponse paramDirectionResponse, String paramString)
  {
    String str1;
    if (paramDirectionResponse == null)
    {
      str1 = null;
      return str1;
    }
    String str2 = String.valueOf("");
    String str3 = String.valueOf(str2 + "From:");
    StringBuilder localStringBuilder1 = new StringBuilder(str3);
    String str4 = paramDirectionResponse.getAddress1();
    String str5 = String.valueOf(str4);
    String str6 = String.valueOf(str5 + paramString);
    String str7 = String.valueOf(str6 + "To:");
    StringBuilder localStringBuilder2 = new StringBuilder(str7);
    String str8 = paramDirectionResponse.getAddress2();
    String str9 = String.valueOf(str8);
    String str10 = str9 + paramString;
    if (!paramDirectionResponse.getViewStepTotal().getFare().contains("0.00"))
    {
      String str11 = String.valueOf(str10);
      StringBuilder localStringBuilder3 = new StringBuilder(str11).append("Fare:");
      String str12 = paramDirectionResponse.getViewStepTotal().getFare();
      str10 = str12 + "\n";
    }
    ArrayList localArrayList = paramDirectionResponse.getRouteInfo().getSteps();
    int i = 0;
    while (true)
    {
      int j = localArrayList.size();
      if ((i >= j) || (!(localArrayList.get(i) instanceof ViewStepDirections)))
      {
        String str13 = String.valueOf(str10);
        String str14 = str13 + paramString;
        if ((paramDirectionResponse.getViewStepTotal() != null) && (paramDirectionResponse.getViewStepTotal().getTotalTimeVerb() != null))
        {
          ViewStepTotal localViewStepTotal = paramDirectionResponse.getViewStepTotal();
          String str15 = String.valueOf(str14);
          StringBuilder localStringBuilder4 = new StringBuilder(str15);
          String str16 = localViewStepTotal.getTotalTimeVerb();
          str14 = str16;
        }
        String str17 = String.valueOf(str14);
        str1 = str17 + paramString;
        break;
      }
      String str18 = ((ViewStepDirections)localArrayList.get(i)).getDirections();
      int k = str18.indexOf('\n');
      String str19 = String.valueOf(str10);
      StringBuilder localStringBuilder5 = new StringBuilder(str19);
      if (k > 0)
        str18 = str18.substring(k);
      String str20 = String.valueOf(str18);
      str10 = str20 + "\n";
      i += 1;
    }
  }

  public SavingManager getSavingManager()
  {
    this.m_adapter.notifyDataSetChanged();
    return this._savingManager;
  }

  public void launchSavingTrip()
  {
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 0)
      return;
    if (paramIntent == null)
      return;
    sendDirection(paramIntent);
  }

  public void onClick(View paramView)
  {
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    boolean bool = requestWindowFeature(1);
    setContentView(2130903058);
    ListView localListView = (ListView)findViewById(2131492936);
    this._listView = localListView;
    initView(false);
    DirectionResponse localDirectionResponse = ApplicationEngine.getModel().getTrip(0);
    Hashtable localHashtable = new Hashtable();
    String str1 = ApplicationEngine.getModel().getDefaultCityId();
    Object localObject1 = localHashtable.put("defaultcity", str1);
    if (localDirectionResponse.getCity1() != null)
    {
      String str2 = localDirectionResponse.getCity1();
      Object localObject2 = localHashtable.put("city1", str2);
    }
    if (localDirectionResponse.getCity2() != null)
    {
      String str3 = localDirectionResponse.getCity2();
      Object localObject3 = localHashtable.put("city2", str3);
    }
    String str4 = ApplicationEngine.getModel().getDirectionMode().getMode();
    Object localObject4 = localHashtable.put("mode", str4);
    if (localDirectionResponse.getZip1() != null)
    {
      String str5 = localDirectionResponse.getZip1();
      Object localObject5 = localHashtable.put("zip1", str5);
    }
    if (localDirectionResponse.getZip2() != null)
    {
      String str6 = localDirectionResponse.getZip2();
      Object localObject6 = localHashtable.put("zip2", str6);
    }
    int i = ApplicationEngine.ZONE_DIRECTION_RESULT;
    String str7 = Double.toString(localDirectionResponse.getY2());
    String str8 = Double.toString(localDirectionResponse.getX2());
    update(i, localHashtable, str7, str8);
    _progressDialog = new ProgressDialog(this);
    builderMsg = new AlertDialog.Builder(this);
    DisplayImageOptions localDisplayImageOptions = new DisplayImageOptions.Builder().cacheInMemory().cacheOnDisc().build();
    Context localContext = getApplicationContext();
    ImageLoaderConfiguration localImageLoaderConfiguration = new ImageLoaderConfiguration.Builder(localContext).defaultDisplayImageOptions(localDisplayImageOptions).build();
    ImageLoader.getInstance().init(localImageLoaderConfiguration);
    ImageView localImageView = (ImageView)findViewById(2131492945);
    View.OnClickListener local6 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DirectionsResultActivity localDirectionsResultActivity = DirectionsResultActivity.this;
        DirectionsResultActivity._dialog = new Dialog(localDirectionsResultActivity);
        DirectionsResultActivity._dialog.setContentView(2130903059);
        DirectionsResultActivity._dialog.setTitle("Save / Share this route");
        DirectionsResultActivity._dialog.setCancelable(true);
        DirectionsResultActivity._dialog.setCanceledOnTouchOutside(true);
        View localView1 = DirectionsResultActivity._dialog.findViewById(2131492950);
        View.OnClickListener local1 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            DirectionsResultActivity.this.openSaveTrip();
          }
        };
        localView1.setOnClickListener(local1);
        View localView2 = DirectionsResultActivity._dialog.findViewById(2131492951);
        View.OnClickListener local2 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            DirectionsResultActivity.this.createDialogForShare();
          }
        };
        localView2.setOnClickListener(local2);
        View localView3 = DirectionsResultActivity._dialog.findViewById(2131492952);
        View.OnClickListener local3 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            DirectionsResultActivity.this.openProblemEmail();
          }
        };
        localView3.setOnClickListener(local3);
        View localView4 = DirectionsResultActivity._dialog.findViewById(2131492953);
        View.OnClickListener local4 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            DirectionsResultActivity._dialog.dismiss();
          }
        };
        localView4.setOnClickListener(local4);
        DirectionsResultActivity._dialog.show();
      }
    };
    localImageView.setOnClickListener(local6);
  }

  // ERROR //
  public void onDestroy()
  {
    // Byte code:
    //   0: ldc_w 989
    //   3: invokestatic 995	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   6: ldc_w 997
    //   9: invokevirtual 1001	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   12: astore_1
    //   13: aload_1
    //   14: iconst_1
    //   15: invokevirtual 1006	java/lang/reflect/Field:setAccessible	(Z)V
    //   18: aload_1
    //   19: aconst_null
    //   20: invokevirtual 1009	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 1011	[Ljava/lang/Object;
    //   26: astore_2
    //   27: iconst_0
    //   28: istore_3
    //   29: aload_2
    //   30: arraylength
    //   31: istore 4
    //   33: iload_3
    //   34: iload 4
    //   36: if_icmplt +199 -> 235
    //   39: invokestatic 1015	com/hopstop/core/ApplicationEngine:getDrawableManager	()Lcom/hopstop/network/DrawableManager;
    //   42: invokevirtual 1020	com/hopstop/network/DrawableManager:clearHashMap	()V
    //   45: invokestatic 499	com/hopstop/core/ApplicationEngine:getModel	()Lcom/hopstop/ClientModel/Model;
    //   48: invokevirtual 1023	com/hopstop/ClientModel/Model:getMRViewStepTotal	()Lcom/hopstop/ClientModel/directions/ViewStepTotal;
    //   51: astore 5
    //   53: ldc2_w 1024
    //   56: lstore 6
    //   58: lload 6
    //   60: invokestatic 1029	java/lang/Thread:sleep	(J)V
    //   63: aload_0
    //   64: ldc_w 882
    //   67: invokevirtual 538	com/hopstop/ClientView/DirectionsResultActivity:findViewById	(I)Landroid/view/View;
    //   70: checkcast 535	android/widget/ListView
    //   73: astore 8
    //   75: aload 8
    //   77: ifnull +78 -> 155
    //   80: aload_0
    //   81: ldc_w 1030
    //   84: invokevirtual 538	com/hopstop/ClientView/DirectionsResultActivity:findViewById	(I)Landroid/view/View;
    //   87: astore 9
    //   89: aload 9
    //   91: ifnull +35 -> 126
    //   94: aload_0
    //   95: ldc_w 1031
    //   98: invokevirtual 538	com/hopstop/ClientView/DirectionsResultActivity:findViewById	(I)Landroid/view/View;
    //   101: checkcast 1033	com/hopstop/ClientModel/directions/WrappedImageViewLayout
    //   104: astore 10
    //   106: aload 10
    //   108: ifnull +9 -> 117
    //   111: aload 10
    //   113: iconst_1
    //   114: invokevirtual 1035	com/hopstop/ClientModel/directions/WrappedImageViewLayout:recycle	(Z)V
    //   117: aload 8
    //   119: aload 9
    //   121: invokevirtual 1039	android/widget/ListView:removeFooterView	(Landroid/view/View;)Z
    //   124: istore 11
    //   126: aload_0
    //   127: ldc_w 1040
    //   130: invokevirtual 538	com/hopstop/ClientView/DirectionsResultActivity:findViewById	(I)Landroid/view/View;
    //   133: astore 12
    //   135: aload 12
    //   137: ifnull +12 -> 149
    //   140: aload 8
    //   142: aload 12
    //   144: invokevirtual 1043	android/widget/ListView:removeHeaderView	(Landroid/view/View;)Z
    //   147: istore 13
    //   149: aload 8
    //   151: aconst_null
    //   152: invokevirtual 1047	android/widget/ListView:setAdapter	(Landroid/widget/ListAdapter;)V
    //   155: aload_0
    //   156: getfield 283	com/hopstop/ClientView/DirectionsResultActivity:_tabHost	Landroid/widget/TabHost;
    //   159: ifnull +10 -> 169
    //   162: aload_0
    //   163: getfield 283	com/hopstop/ClientView/DirectionsResultActivity:_tabHost	Landroid/widget/TabHost;
    //   166: invokevirtual 1050	android/widget/TabHost:removeAllViews	()V
    //   169: aload_0
    //   170: ldc 160
    //   172: iconst_0
    //   173: invokevirtual 1054	com/hopstop/ClientView/DirectionsResultActivity:setSharedPreferenceInt	(Ljava/lang/String;I)V
    //   176: aload 5
    //   178: ifnull +18 -> 196
    //   181: aload 5
    //   183: invokevirtual 1057	com/hopstop/ClientModel/directions/ViewStepTotal:isMostRecentSaved	()Z
    //   186: ifne +10 -> 196
    //   189: aload_0
    //   190: getfield 370	com/hopstop/ClientView/DirectionsResultActivity:_savingManager	Lcom/hopstop/ClientModel/directions/SavingManager;
    //   193: invokevirtual 1060	com/hopstop/ClientModel/directions/SavingManager:onCancel	()V
    //   196: aload_0
    //   197: getfield 273	com/hopstop/ClientView/DirectionsResultActivity:m_adapter	Lcom/hopstop/ClientView/DirectionsResultActivity$StepAdapter;
    //   200: invokevirtual 1063	com/hopstop/ClientView/DirectionsResultActivity$StepAdapter:destroy	()Z
    //   203: istore 14
    //   205: invokestatic 1015	com/hopstop/core/ApplicationEngine:getDrawableManager	()Lcom/hopstop/network/DrawableManager;
    //   208: invokevirtual 1020	com/hopstop/network/DrawableManager:clearHashMap	()V
    //   211: aload_0
    //   212: invokespecial 1065	com/hopstop/ui/BaseMapActivity:onDestroy	()V
    //   215: aload_0
    //   216: getfield 291	com/hopstop/ClientView/DirectionsResultActivity:_mapView	Lcom/hopstop/ClientView/HopStopMapView;
    //   219: ifnull +12 -> 231
    //   222: aload_0
    //   223: getfield 291	com/hopstop/ClientView/DirectionsResultActivity:_mapView	Lcom/hopstop/ClientView/HopStopMapView;
    //   226: invokevirtual 533	com/hopstop/ClientView/HopStopMapView:recycle	()Z
    //   229: istore 15
    //   231: invokestatic 1070	java/lang/System:gc	()V
    //   234: return
    //   235: iconst_0
    //   236: istore 4
    //   238: aload_2
    //   239: iload_3
    //   240: iload 4
    //   242: aastore
    //   243: iload_3
    //   244: iconst_1
    //   245: iadd
    //   246: istore_3
    //   247: goto -218 -> 29
    //   250: invokevirtual 1071	java/lang/IllegalArgumentException:printStackTrace	()V
    //   253: goto -214 -> 39
    //   256: invokevirtual 1072	java/lang/IllegalAccessException:printStackTrace	()V
    //   259: goto -220 -> 39
    //   262: invokevirtual 1073	java/lang/ClassNotFoundException:printStackTrace	()V
    //   265: goto -226 -> 39
    //   268: invokevirtual 1074	java/lang/NoSuchFieldException:printStackTrace	()V
    //   271: goto -232 -> 39
    //   274: invokevirtual 1075	java/lang/InterruptedException:printStackTrace	()V
    //   277: goto -214 -> 63
    //
    // Exception table:
    //   from	to	target	type
    //   0	33	250	java/lang/IllegalArgumentException
    //   238	243	250	java/lang/IllegalArgumentException
    //   0	33	256	java/lang/IllegalAccessException
    //   238	243	256	java/lang/IllegalAccessException
    //   0	33	262	java/lang/ClassNotFoundException
    //   238	243	262	java/lang/ClassNotFoundException
    //   0	33	268	java/lang/NoSuchFieldException
    //   238	243	268	java/lang/NoSuchFieldException
    //   58	63	274	java/lang/InterruptedException
  }

  protected void onPause()
  {
    if (this._me != null)
    {
      this._me.disableCompass();
      this._me.disableMyLocation();
    }
    if (this._mapView != null)
    {
      GeoPoint localGeoPoint = this._mapView.getMapCenter();
      this.mapCenterReserve = localGeoPoint;
      int i = this._mapView.getZoomLevel();
      this.mapZoomLevelReserve = i;
    }
    super.onPause();
  }

  protected void onRestart()
  {
    super.onRestart();
  }

  public void onResume()
  {
    if ((this._mapView != null) && (this._mapView.getController() != null) && (this.mapCenterReserve != null) && (this.mapZoomLevelReserve != 0))
    {
      MapController localMapController1 = this._mapView.getController();
      GeoPoint localGeoPoint = this.mapCenterReserve;
      localMapController1.setCenter(localGeoPoint);
      MapController localMapController2 = this._mapView.getController();
      int i = this.mapZoomLevelReserve;
      int j = localMapController2.setZoom(i);
    }
    super.onResume();
  }

  protected void onStart()
  {
    setSharedPreferenceInt("force-shutted-down", 0);
    super.onStart();
  }

  protected void onStop()
  {
    setSharedPreferenceInt("force-shutted-down", 1);
    super.onStop();
  }

  public void onTabChanged(String paramString)
  {
    ImageButton localImageButton = (ImageButton)findViewById(2131492986);
    if (paramString.equals("Map"))
    {
      int i = this._mapviewAnimTpZoom;
      int j = this.MAPVIEW_FIRST_START;
      if (i != j)
      {
        int k = this.MAPVIEW_CENTER_BETWEEN_TWO_POINTS;
        this._mapviewAnimTpZoom = k;
        this._mapView.postInvalidate();
        if (this._me != null)
          break label343;
        HopStopMapView localHopStopMapView = this._mapView;
        MyLocationOverlay localMyLocationOverlay1 = new MyLocationOverlay(this, localHopStopMapView);
        this._me = localMyLocationOverlay1;
        List localList1 = this._mapView.getOverlays();
        MyLocationOverlay localMyLocationOverlay2 = this._me;
        boolean bool1 = localList1.add(localMyLocationOverlay2);
        boolean bool2 = this._me.enableCompass();
      }
      while (true)
      {
        localImageButton.setVisibility(0);
        View.OnClickListener local19 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            Toast.makeText(DirectionsResultActivity.this, "Getting location, please wait...", 1).show();
            XSPLocationManager.getXSPLocationManager(DirectionsResultActivity.this).startWSP();
            try
            {
              Controller localController = ApplicationEngine.getController();
              Object[] arrayOfObject = new Object[1];
              DirectionsResultActivity localDirectionsResultActivity = DirectionsResultActivity.this;
              arrayOfObject[0] = localDirectionsResultActivity;
              ApplicationEngine.UiCallBack local1 = new ApplicationEngine.UiCallBack()
              {
                public void onStatusChanged(int paramAnonymous2Int1, int paramAnonymous2Int2, Object[] paramAnonymous2ArrayOfObject)
                {
                  if (1 != paramAnonymous2Int2)
                    return;
                  final Location localLocation = (Location)paramAnonymous2ArrayOfObject[0];
                  DirectionsResultActivity localDirectionsResultActivity = DirectionsResultActivity.this;
                  Runnable local1 = new Runnable()
                  {
                    public void run()
                    {
                      int i = (int)(localLocation.getLatitude() * 1000000.0D);
                      int j = (int)(localLocation.getLongitude() * 1000000.0D);
                      GeoPoint localGeoPoint = new GeoPoint(i, j);
                      MapController localMapController = DirectionsResultActivity.this._mapView.getController();
                      Message localMessage = new Message();
                      localMapController.animateTo(localGeoPoint, localMessage);
                      DirectionsResultActivity.this._myGpsOverlay.setPointToDraw(localGeoPoint);
                      List localList = DirectionsResultActivity.this._mapView.getOverlays();
                      MyGpsMapOverlay localMyGpsMapOverlay = DirectionsResultActivity.this._myGpsOverlay;
                      boolean bool = localList.add(localMyGpsMapOverlay);
                    }
                  };
                  localDirectionsResultActivity.runOnUiThread(local1);
                }
              };
              localController.handleViewRequest(1, arrayOfObject, local1);
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
        localImageButton.setOnClickListener(local19);
        return;
        int m = this._mapviewAnimTpZoom;
        int n = this.MAPVIEW_CENTER_BETWEEN_TWO_POINTS;
        if (m != n)
        {
          MapController localMapController = this._mapView.getController();
          if (this._bgItemizedOverlay != null)
          {
            int i1 = this._bgItemizedOverlay.getLatSpanE6();
            int i2 = this._bgItemizedOverlay.getLonSpanE6();
            localMapController.zoomToSpan(i1, i2);
          }
          if ((this._endPoint != null) && (this._startPoint != null))
          {
            int i3 = this._endPoint.getLatitudeE6();
            int i4 = this._startPoint.getLatitudeE6();
            int i5 = (i3 + i4) / 2;
            int i6 = this._endPoint.getLongitudeE6();
            int i7 = this._startPoint.getLongitudeE6();
            int i8 = (i6 + i7) / 2;
            GeoPoint localGeoPoint = new GeoPoint(i5, i8);
            localMapController.animateTo(localGeoPoint);
          }
          int i9 = this.MAPVIEW_NO_CENTER;
          this._mapviewAnimTpZoom = i9;
          break;
        }
        int i10 = this._mapviewAnimTpZoom;
        int i11 = this.MAPVIEW_END_POINT_CENTER;
        if (i10 == i11)
          break;
        int i12 = this.MAPVIEW_NO_CENTER;
        this._mapviewAnimTpZoom = i12;
        break;
        label343: boolean bool3 = this._me.enableCompass();
      }
    }
    if (!paramString.equals("List"))
      return;
    localImageButton.setVisibility(8);
    List localList2 = this._mapView.getOverlays();
    MyGpsMapOverlay localMyGpsMapOverlay = this._myGpsOverlay;
    boolean bool4 = localList2.remove(localMyGpsMapOverlay);
    if (this._me == null)
      return;
    this._me.disableCompass();
  }

  public void openProblemEmail()
  {
    Message localMessage = new Message();
    localMessage.what = 0;
    boolean bool = handler.sendMessage(localMessage);
    String str1 = getString(2130968653);
    DirectionResponse localDirectionResponse = ApplicationEngine.getModel().getTrip(0);
    StringBuilder localStringBuilder1 = new StringBuilder("Please describe the problem: \n\n\n======================\nLink: http://hopstop.com/?route_id=");
    String str2 = localDirectionResponse.getRouteId();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str2).append("\n\n");
    String str3 = getDirectionText(localDirectionResponse, "\n");
    String str4 = String.valueOf(str3);
    String str5 = str4 + "\n\n\nSent from HopStop Android App " + str1;
    sendEmail("feedback@hopstop.com", "HopStop Android App - Directions Problem", str5);
  }

  public void openSaveTrip()
  {
    Message localMessage = new Message();
    localMessage.what = 0;
    boolean bool = handler.sendMessage(localMessage);
    int i = ApplicationEngine.getModel().getMyTripsCount();
    int j = ApplicationEngine.MY_TRIP_MAX;
    if (i >= j)
    {
      Toast.makeText(getApplicationContext(), "Sorry, trip max reached, please delete some before saving", 1).show();
      return;
    }
    createDialogForTripName("Please input trip name");
  }

  public void run()
  {
    ApplicationEngine.getModel().cleanMyRecentTrip();
    try
    {
      Controller localController = ApplicationEngine.getController();
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this;
      String str = this._updatedURLString;
      arrayOfObject[1] = str;
      ApplicationEngine.UiCallBack local17 = new ApplicationEngine.UiCallBack()
      {
        public void onStatusChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object[] paramAnonymousArrayOfObject)
        {
          Message localMessage = new Message();
          localMessage.what = 1;
          boolean bool = DirectionsResultActivity.handler.sendMessage(localMessage);
          int i = NetworkSettings.SUCCESS_GET_ROUTE;
          if (paramAnonymousInt2 != i)
          {
            DirectionsResultActivity localDirectionsResultActivity1 = DirectionsResultActivity.this;
            Intent localIntent = new Intent(localDirectionsResultActivity1, DirectionsResultActivity.class);
            DirectionsResultActivity.this.startActivity(localIntent);
            DirectionsResultActivity.this.finish();
            return;
          }
          int j = NetworkSettings.NETWORK_ERROR;
          if (paramAnonymousInt2 != j)
          {
            DirectionsResultActivity localDirectionsResultActivity2 = DirectionsResultActivity.this;
            String str1 = DirectionsResultActivity.this.getString(2130968672);
            String str2 = DirectionsResultActivity.this.getString(2130968674);
            localDirectionsResultActivity2.ShowErrorMessage(str1, str2);
            return;
          }
          int k = NetworkSettings.ROUTE_NOT_FOUND;
          if (paramAnonymousInt2 != k)
            return;
          DirectionsResultActivity localDirectionsResultActivity3 = DirectionsResultActivity.this;
          String str3 = DirectionsResultActivity.this.getString(2130968672);
          String str4 = (String)paramAnonymousArrayOfObject[0];
          localDirectionsResultActivity3.ShowErrorMessage(str3, str4);
        }
      };
      localController.handleViewRequest(105, arrayOfObject, local17);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      finish();
      localOutOfMemoryError.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      finish();
      localIOException.printStackTrace();
    }
  }

  protected void saveRoute(String paramString)
  {
    SaveTripTask localSaveTripTask = new SaveTripTask();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramString;
    AsyncTask localAsyncTask = localSaveTripTask.execute(arrayOfString);
  }

  public void updateDirectionMap(ImageView paramImageView, Bitmap paramBitmap)
  {
    ((ThreadUpdateRunnable)this.returnRes).getImageView(paramImageView, paramBitmap);
    Runnable localRunnable = this.returnRes;
    runOnUiThread(localRunnable);
  }

  public void updateDirections(ChevronImageView paramChevronImageView)
  {
    _dialog = new Dialog(this);
    _dialog.setContentView(2130903053);
    _dialog.setTitle("Reroute Options");
    _dialog.setCancelable(true);
    final String str1 = paramChevronImageView.getReroute();
    final String[] arrayOfString = paramChevronImageView.getRerouteAll();
    final String str2 = paramChevronImageView.getUseAnotherStop();
    final String str3 = paramChevronImageView.getUseAnotherTransfer();
    if (paramChevronImageView.getReroute() != null)
    {
      Button localButton1 = (Button)_dialog.findViewById(2131492923);
      localButton1.setVisibility(0);
      View.OnClickListener local12 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          DirectionsResultActivity localDirectionsResultActivity1 = DirectionsResultActivity.this;
          String str1 = DirectionsResultActivity.this._routeId;
          StringBuilder localStringBuilder = new StringBuilder("excluded_vehicles=");
          String str2 = str1;
          String str3 = str2;
          String str4 = NetworkSettings.keyNewAPI;
          String str5 = URLFactoryBuilder.getReRouteURL(str1, str3, str4);
          localDirectionsResultActivity1._urlString = str5;
          DirectionsResultActivity localDirectionsResultActivity2 = DirectionsResultActivity.this;
          String str6 = DirectionsResultActivity.this._urlString;
          localDirectionsResultActivity2.updateDirections(str6);
          Message localMessage = new Message();
          localMessage.what = 0;
          boolean bool = DirectionsResultActivity.handler.sendMessage(localMessage);
        }
      };
      localButton1.setOnClickListener(local12);
    }
    if (paramChevronImageView.getRerouteAll() != null)
    {
      Button localButton2 = (Button)_dialog.findViewById(2131492924);
      localButton2.setVisibility(0);
      View.OnClickListener local13 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          String str1 = "";
          int i;
          DirectionsResultActivity localDirectionsResultActivity1;
          String str2;
          StringBuilder localStringBuilder1;
          String str3;
          if (arrayOfString != null)
          {
            str1 = arrayOfString[0];
            i = 2;
            int j = arrayOfString.length;
            if (i < j);
          }
          else
          {
            localDirectionsResultActivity1 = DirectionsResultActivity.this;
            str2 = DirectionsResultActivity.this._routeId;
            localStringBuilder1 = new StringBuilder("excluded_vehicles=");
            if ((str1 == null) || (str1.length() <= 0))
              break label240;
            str3 = String.valueOf(str1);
          }
          label240: for (String str4 = str3 + ","; ; str4 = "")
          {
            StringBuilder localStringBuilder2 = localStringBuilder1.append(str4);
            String str5 = str1;
            String str6 = str5;
            String str7 = NetworkSettings.keyNewAPI;
            String str8 = URLFactoryBuilder.getReRouteURL(str2, str6, str7);
            localDirectionsResultActivity1._urlString = str8;
            DirectionsResultActivity localDirectionsResultActivity2 = DirectionsResultActivity.this;
            String str9 = DirectionsResultActivity.this._urlString;
            localDirectionsResultActivity2.updateDirections(str9);
            Message localMessage = new Message();
            localMessage.what = 0;
            boolean bool = DirectionsResultActivity.handler.sendMessage(localMessage);
            return;
            String str10 = String.valueOf(str1);
            StringBuilder localStringBuilder3 = new StringBuilder(str10).append(",");
            String str11 = arrayOfString[i];
            str1 = str11;
            i += 2;
            break;
          }
        }
      };
      localButton2.setOnClickListener(local13);
    }
    if (paramChevronImageView.getUseAnotherStop() != null)
    {
      Button localButton3 = (Button)_dialog.findViewById(2131492925);
      localButton3.setVisibility(0);
      View.OnClickListener local14 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          DirectionsResultActivity localDirectionsResultActivity1 = DirectionsResultActivity.this;
          String str1 = DirectionsResultActivity.this._routeId;
          StringBuilder localStringBuilder = new StringBuilder("excluded_objects=s");
          String str2 = str2;
          String str3 = str2;
          String str4 = NetworkSettings.keyNewAPI;
          String str5 = URLFactoryBuilder.getReRouteURL(str1, str3, str4);
          localDirectionsResultActivity1._urlString = str5;
          DirectionsResultActivity localDirectionsResultActivity2 = DirectionsResultActivity.this;
          String str6 = DirectionsResultActivity.this._urlString;
          localDirectionsResultActivity2.updateDirections(str6);
          Message localMessage = new Message();
          localMessage.what = 0;
          boolean bool = DirectionsResultActivity.handler.sendMessage(localMessage);
        }
      };
      localButton3.setOnClickListener(local14);
    }
    if (paramChevronImageView.getUseAnotherTransfer() != null)
    {
      Button localButton4 = (Button)_dialog.findViewById(2131492926);
      localButton4.setVisibility(0);
      View.OnClickListener local15 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          DirectionsResultActivity localDirectionsResultActivity1 = DirectionsResultActivity.this;
          String str1 = DirectionsResultActivity.this._routeId;
          StringBuilder localStringBuilder = new StringBuilder("excluded_objects=t");
          String str2 = str3;
          String str3 = str2;
          String str4 = NetworkSettings.keyNewAPI;
          String str5 = URLFactoryBuilder.getReRouteURL(str1, str3, str4);
          localDirectionsResultActivity1._urlString = str5;
          DirectionsResultActivity localDirectionsResultActivity2 = DirectionsResultActivity.this;
          String str6 = DirectionsResultActivity.this._urlString;
          localDirectionsResultActivity2.updateDirections(str6);
          Message localMessage = new Message();
          localMessage.what = 0;
          boolean bool = DirectionsResultActivity.handler.sendMessage(localMessage);
        }
      };
      localButton4.setOnClickListener(local15);
    }
    Button localButton5 = (Button)_dialog.findViewById(2131492922);
    View.OnClickListener local16 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Message localMessage = new Message();
        localMessage.what = 0;
        boolean bool = DirectionsResultActivity.handler.sendMessage(localMessage);
      }
    };
    localButton5.setOnClickListener(local16);
    _dialog.show();
  }

  public void updateMapView(ImageView paramImageView, Bitmap paramBitmap)
  {
    paramImageView.setImageBitmap(paramBitmap);
    paramImageView.invalidate();
  }

  protected class CountYextClickAsync extends AsyncTask<String, Void, String>
  {
    protected CountYextClickAsync()
    {
    }

    protected String doInBackground(String[] paramArrayOfString)
    {
      String str1 = paramArrayOfString[0];
      String str2 = paramArrayOfString[1];
      String str3 = URLFactoryBuilder.GetYextEnhancedListClick(str1, str2);
      Object localObject = null;
      try
      {
        String str4 = ApplicationEngine.getNetworkEngine().retrieve(str3);
        localObject = str4;
        return localObject;
      }
      catch (IOException localIOException)
      {
        while (true)
          localIOException.printStackTrace();
      }
    }
  }

  private class InteractiveMapTask extends AsyncTask<Hashtable<String, RouteIcons>, Void, DirectionPathOverlay>
  {
    private InteractiveMapTask()
    {
    }

    protected DirectionPathOverlay doInBackground(Hashtable<String, RouteIcons>[] paramArrayOfHashtable)
    {
      DirectionPathOverlay localDirectionPathOverlay = null;
      Drawable localDrawable = DirectionsResultActivity.this.getResources().getDrawable(2130837566);
      if ((paramArrayOfHashtable == null) && (paramArrayOfHashtable.length == 0))
        boolean bool = cancel(true);
      while (true)
      {
        return localDirectionPathOverlay;
        HopStopMapView localHopStopMapView = DirectionsResultActivity.this._mapView;
        drawPath(localHopStopMapView);
        Hashtable<String, RouteIcons> localHashtable = paramArrayOfHashtable[0];
        FrameLayout localFrameLayout = (FrameLayout)DirectionsResultActivity.this.getLayoutInflater().inflate(2130903070, null);
        localDirectionPathOverlay = new DirectionPathOverlay(localDrawable, localHashtable, localFrameLayout, true);
      }
    }

    public void drawPath(MapView paramMapView)
    {
      try
      {
        GeoPoints localGeoPoints = (GeoPoints)DirectionsResultActivity.this._geoPoints.get(0);
        List localList1 = paramMapView.getOverlays();
        GeoPoint localGeoPoint1 = localGeoPoints.getStart();
        GeoPoint localGeoPoint2 = localGeoPoints.getEnd();
        RouteOverlay localRouteOverlay1 = new RouteOverlay(localGeoPoint1, localGeoPoint2, 1);
        boolean bool1 = localList1.add(localRouteOverlay1);
        Object localObject = localGeoPoints.getEnd();
        int i = 1;
        while (true)
        {
          int j = DirectionsResultActivity.this._geoPoints.size();
          int k = j;
          if (i >= k)
          {
            label88: paramMapView.setEnabled(true);
            return;
          }
          GeoPoint localGeoPoint4 = ((GeoPoints)DirectionsResultActivity.this._geoPoints.get(i)).getStart();
          if (localObject != localGeoPoint4)
          {
            List localList2 = paramMapView.getOverlays();
            GeoPoint localGeoPoint5 = ((GeoPoints)DirectionsResultActivity.this._geoPoints.get(i)).getStart();
            int m = ((GeoPoints)DirectionsResultActivity.this._geoPoints.get(i)).getRouteColor();
            RouteOverlay localRouteOverlay2 = new RouteOverlay((GeoPoint)localObject, localGeoPoint5, 3, m);
            boolean bool2 = localList2.add(localRouteOverlay2);
          }
          List localList3 = paramMapView.getOverlays();
          GeoPoint localGeoPoint6 = ((GeoPoints)DirectionsResultActivity.this._geoPoints.get(i)).getStart();
          GeoPoint localGeoPoint7 = ((GeoPoints)DirectionsResultActivity.this._geoPoints.get(i)).getEnd();
          int n = ((GeoPoints)DirectionsResultActivity.this._geoPoints.get(i)).getRouteColor();
          RouteOverlay localRouteOverlay3 = new RouteOverlay(localGeoPoint6, localGeoPoint7, 3, n);
          boolean bool3 = localList3.add(localRouteOverlay3);
          GeoPoint localGeoPoint3 = ((GeoPoints)DirectionsResultActivity.this._geoPoints.get(i)).getEnd();
          localObject = localGeoPoint3;
          i += 1;
        }
      }
      catch (NumberFormatException localNumberFormatException)
      {
        break label88;
      }
    }

    protected void onCancelled()
    {
      super.onCancelled();
    }

    protected void onPostExecute(DirectionPathOverlay paramDirectionPathOverlay)
    {
      boolean bool1 = DirectionsResultActivity.this._mapView.getOverlays().add(paramDirectionPathOverlay);
      List localList1 = DirectionsResultActivity.this._mapView.getOverlays();
      StartEndItemizedOverlay localStartEndItemizedOverlay1 = DirectionsResultActivity.this._startOverlayPoint;
      boolean bool2 = localList1.add(localStartEndItemizedOverlay1);
      List localList2 = DirectionsResultActivity.this._mapView.getOverlays();
      StartEndItemizedOverlay localStartEndItemizedOverlay2 = DirectionsResultActivity.this._endOverlayPoint;
      boolean bool3 = localList2.add(localStartEndItemizedOverlay2);
      DirectionsResultActivity.this._tabHost.getTabWidget().getChildAt(1).setEnabled(true);
      DirectionsResultActivity.this._mapView.postInvalidate();
    }
  }

  private class LoadDirectionResultsTask extends AsyncTask<Void, Object, Void>
  {
    private LoadDirectionResultsTask()
    {
    }

    private void fillViewStepAddressData(final ViewStepAddress paramViewStepAddress)
    {
      View localView;
      ImageView localImageView1;
      if (paramViewStepAddress.isStart())
      {
        localView = DirectionsResultActivity.this.findViewById(2131492941);
        localView.setVisibility(0);
        TextView localTextView = (TextView)localView.findViewById(2131492933);
        String str = paramViewStepAddress.getAddress().toUpperCase();
        localTextView.setText(str);
        localImageView1 = (ImageView)localView.findViewById(2131493251);
        if (!paramViewStepAddress.isStart())
          break label143;
        localImageView1.setImageResource(2130837612);
      }
      while (true)
      {
        ImageView localImageView2 = (ImageView)localView.findViewById(2131493252);
        if (localImageView2 != null)
        {
          localImageView2.setVisibility(0);
          View.OnClickListener local1 = new View.OnClickListener()
          {
            public void onClick(View paramAnonymousView)
            {
              if (!DirectionsResultActivity.this._tabHost.getTabWidget().getChildAt(1).isEnabled())
                return;
              DirectionsResultActivity localDirectionsResultActivity1 = DirectionsResultActivity.this;
              int i = DirectionsResultActivity.this.MAPVIEW_END_POINT_CENTER;
              localDirectionsResultActivity1._mapviewAnimTpZoom = i;
              DirectionsResultActivity localDirectionsResultActivity2 = DirectionsResultActivity.this;
              if (paramViewStepAddress.isStart());
              for (GeoPoint localGeoPoint = DirectionsResultActivity.this._startPoint; ; localGeoPoint = DirectionsResultActivity.this._endPoint)
              {
                int j = DirectionsResultActivity.this._mapView.getMaxZoomLevel();
                localDirectionsResultActivity2.setMapZoomPoint(localGeoPoint, j);
                DirectionsResultActivity.this._tabHost.setCurrentTab(1);
                return;
              }
            }
          };
          localImageView2.setOnClickListener(local1);
        }
        View.OnClickListener local2 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (!DirectionsResultActivity.this._tabHost.getTabWidget().getChildAt(1).isEnabled())
              return;
            DirectionsResultActivity localDirectionsResultActivity1 = DirectionsResultActivity.this;
            int i = DirectionsResultActivity.this.MAPVIEW_END_POINT_CENTER;
            localDirectionsResultActivity1._mapviewAnimTpZoom = i;
            DirectionsResultActivity localDirectionsResultActivity2 = DirectionsResultActivity.this;
            if (paramViewStepAddress.isStart());
            for (GeoPoint localGeoPoint = DirectionsResultActivity.this._startPoint; ; localGeoPoint = DirectionsResultActivity.this._endPoint)
            {
              int j = DirectionsResultActivity.this._mapView.getMaxZoomLevel();
              localDirectionsResultActivity2.setMapZoomPoint(localGeoPoint, j);
              DirectionsResultActivity.this._tabHost.setCurrentTab(1);
              return;
            }
          }
        };
        localView.setOnClickListener(local2);
        return;
        localView = DirectionsResultActivity.this.findViewById(2131492942);
        break;
        label143: localImageView1.setImageResource(2130837613);
      }
    }

    private void fillViewStepTotalData(ViewStepTotal paramViewStepTotal)
    {
      TextView localTextView1 = (TextView)DirectionsResultActivity.this.findViewById(2131493259);
      String str1 = localTextView1.getText().toString();
      Object[] arrayOfObject1 = new Object[1];
      boolean bool = ApplicationEngine.getModel().getIsMiles();
      String str2 = paramViewStepTotal.getDistance(bool);
      arrayOfObject1[0] = str2;
      String str3 = String.format(str1, arrayOfObject1);
      localTextView1.setText(str3);
      TextView localTextView2 = (TextView)DirectionsResultActivity.this.findViewById(2131493253);
      String str4 = localTextView2.getText().toString();
      Object[] arrayOfObject2 = new Object[1];
      String str5 = paramViewStepTotal.getDeparture();
      arrayOfObject2[0] = str5;
      String str6 = String.format(str4, arrayOfObject2);
      localTextView2.setText(str6);
      TextView localTextView3 = (TextView)DirectionsResultActivity.this.findViewById(2131493255);
      String str7 = paramViewStepTotal.getDuration().replace("hours", "h").replace("hour", "h").replace("mins", "m").replace("min", "m");
      String str8 = localTextView3.getText().toString();
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = str7;
      String str9 = String.format(str8, arrayOfObject3);
      localTextView3.setText(str9);
      TextView localTextView4 = (TextView)DirectionsResultActivity.this.findViewById(2131493254);
      String str10 = localTextView4.getText().toString();
      Object[] arrayOfObject4 = new Object[1];
      String str11 = paramViewStepTotal.getArrival();
      arrayOfObject4[0] = str11;
      String str12 = String.format(str10, arrayOfObject4);
      localTextView4.setText(str12);
      TextView localTextView5 = (TextView)DirectionsResultActivity.this.findViewById(2131493262);
      LinearLayout localLinearLayout = (LinearLayout)DirectionsResultActivity.this.findViewById(2131493260);
      if (!paramViewStepTotal.getFare().contains("$0.00"))
      {
        String str13 = localTextView5.getText().toString();
        Object[] arrayOfObject5 = new Object[1];
        String str14 = paramViewStepTotal.getFare();
        arrayOfObject5[0] = str14;
        String str15 = String.format(str13, arrayOfObject5);
        localTextView5.setText(str15);
      }
      while (true)
      {
        TextView localTextView6 = (TextView)DirectionsResultActivity.this.findViewById(2131493256);
        String str16 = localTextView6.getText().toString();
        Object[] arrayOfObject6 = new Object[1];
        Integer localInteger = Integer.valueOf(paramViewStepTotal.getWalkingTime());
        arrayOfObject6[0] = localInteger;
        String str17 = String.format(str16, arrayOfObject6);
        localTextView6.setText(str17);
        if (paramViewStepTotal.getWheelChairOut() != 1)
          return;
        ((ImageView)DirectionsResultActivity.this.findViewById(2131493265)).setVisibility(0);
        ((LinearLayout)DirectionsResultActivity.this.findViewById(2131493264)).setVisibility(0);
        return;
        localLinearLayout.setVisibility(4);
      }
    }

    private void launchDialog(final ViewStepAddress paramViewStepAddress)
    {
      DirectionsResultActivity localDirectionsResultActivity = DirectionsResultActivity.this;
      DirectionsResultActivity._dialogRightArrow = new Dialog(localDirectionsResultActivity);
      DirectionsResultActivity._dialogRightArrow.setContentView(2130903052);
      DirectionsResultActivity._dialogRightArrow.setTitle("Info");
      DirectionsResultActivity._dialogRightArrow.setCancelable(true);
      Button localButton1 = (Button)DirectionsResultActivity._dialogRightArrow.findViewById(2131492919);
      View.OnClickListener local3 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Message localMessage = new Message();
          localMessage.what = 3;
          boolean bool = DirectionsResultActivity.handler.sendMessage(localMessage);
          Intent localIntent1 = new Intent();
          String str1 = ApplicationEngine.REVERSE_TRIP_START_ADDRESS;
          String str2 = paramViewStepAddress.formartedAddress();
          Intent localIntent2 = localIntent1.putExtra(str1, str2);
          if (paramViewStepAddress.isStart())
          {
            String str3 = ApplicationEngine.REVERSE_TRIP_END_CITY;
            String str4 = paramViewStepAddress.getCity1();
            Intent localIntent3 = localIntent1.putExtra(str3, str4);
            String str5 = ApplicationEngine.SEARCH_X1;
            double d1 = paramViewStepAddress.getX();
            Intent localIntent4 = localIntent1.putExtra(str5, d1);
            String str6 = ApplicationEngine.SEARCH_Y1;
            double d2 = paramViewStepAddress.getY();
            Intent localIntent5 = localIntent1.putExtra(str6, d2);
          }
          while (true)
          {
            DirectionsResultActivity localDirectionsResultActivity = DirectionsResultActivity.this;
            int i = ApplicationEngine.REVERSE_TRIP_ADDRESS;
            localDirectionsResultActivity.setResult(i, localIntent1);
            DirectionsResultActivity.this.finish();
            return;
            String str7 = ApplicationEngine.REVERSE_TRIP_END_CITY;
            String str8 = paramViewStepAddress.getCity2();
            Intent localIntent6 = localIntent1.putExtra(str7, str8);
            String str9 = ApplicationEngine.SEARCH_X1;
            double d3 = paramViewStepAddress.getX();
            Intent localIntent7 = localIntent1.putExtra(str9, d3);
            String str10 = ApplicationEngine.SEARCH_Y1;
            double d4 = paramViewStepAddress.getY();
            Intent localIntent8 = localIntent1.putExtra(str10, d4);
          }
        }
      };
      localButton1.setOnClickListener(local3);
      Button localButton2 = (Button)DirectionsResultActivity._dialogRightArrow.findViewById(2131492920);
      View.OnClickListener local4 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Message localMessage = new Message();
          localMessage.what = 3;
          boolean bool = DirectionsResultActivity.handler.sendMessage(localMessage);
          Intent localIntent1 = new Intent();
          String str1 = ApplicationEngine.REVERSE_TRIP_END_ADDRESS;
          String str2 = paramViewStepAddress.formartedAddress();
          Intent localIntent2 = localIntent1.putExtra(str1, str2);
          if (paramViewStepAddress.isStart())
          {
            String str3 = ApplicationEngine.REVERSE_TRIP_START_CITY;
            String str4 = paramViewStepAddress.getCity1();
            Intent localIntent3 = localIntent1.putExtra(str3, str4);
            String str5 = ApplicationEngine.SEARCH_X2;
            double d1 = paramViewStepAddress.getX();
            Intent localIntent4 = localIntent1.putExtra(str5, d1);
            String str6 = ApplicationEngine.SEARCH_Y2;
            double d2 = paramViewStepAddress.getY();
            Intent localIntent5 = localIntent1.putExtra(str6, d2);
          }
          while (true)
          {
            DirectionsResultActivity localDirectionsResultActivity = DirectionsResultActivity.this;
            int i = ApplicationEngine.REVERSE_TRIP_ADDRESS;
            localDirectionsResultActivity.setResult(i, localIntent1);
            DirectionsResultActivity.this.finish();
            return;
            String str7 = ApplicationEngine.REVERSE_TRIP_START_CITY;
            String str8 = paramViewStepAddress.getCity2();
            Intent localIntent6 = localIntent1.putExtra(str7, str8);
            String str9 = ApplicationEngine.SEARCH_X2;
            double d3 = paramViewStepAddress.getX();
            Intent localIntent7 = localIntent1.putExtra(str9, d3);
            String str10 = ApplicationEngine.SEARCH_Y2;
            double d4 = paramViewStepAddress.getY();
            Intent localIntent8 = localIntent1.putExtra(str10, d4);
          }
        }
      };
      localButton2.setOnClickListener(local4);
      Button localButton3 = (Button)DirectionsResultActivity._dialogRightArrow.findViewById(2131492921);
      View.OnClickListener local5 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Message localMessage = new Message();
          localMessage.what = 3;
          boolean bool = DirectionsResultActivity.handler.sendMessage(localMessage);
          DirectionsResultActivity.LoadDirectionResultsTask localLoadDirectionResultsTask = DirectionsResultActivity.LoadDirectionResultsTask.this;
          ViewStepAddress localViewStepAddress = paramViewStepAddress;
          localLoadDirectionResultsTask.seeOnMap(localViewStepAddress);
        }
      };
      localButton3.setOnClickListener(local5);
      Button localButton4 = (Button)DirectionsResultActivity._dialogRightArrow.findViewById(2131492922);
      View.OnClickListener local6 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          Message localMessage = new Message();
          localMessage.what = 3;
          boolean bool = DirectionsResultActivity.handler.sendMessage(localMessage);
        }
      };
      localButton4.setOnClickListener(local6);
      DirectionsResultActivity._dialogRightArrow.show();
    }

    private void seeOnMap(ViewStepAddress paramViewStepAddress)
    {
      DirectionsResultActivity localDirectionsResultActivity = DirectionsResultActivity.this;
      Intent localIntent1 = new Intent(localDirectionsResultActivity, DirectionsMainViewActivity.class);
      String str1 = ApplicationEngine.SEE_NEARBY_BUSINESS_ON_MAP;
      String str2 = ApplicationEngine.SEE_NEARBY_BUSINESS_ON_MAP;
      Intent localIntent2 = localIntent1.putExtra(str1, str2);
      String str3 = ApplicationEngine.SEE_NEARBY_BUSINESS_ON_MAP_NAME;
      String str4 = paramViewStepAddress.formartedAddress();
      Intent localIntent3 = localIntent1.putExtra(str3, str4);
      String str5 = ApplicationEngine.SEE_NEARBY_BUSINESS_ON_MAP_XY;
      String str6 = paramViewStepAddress.formartedAddress();
      Intent localIntent4 = localIntent1.putExtra(str5, str6);
      String str7 = ApplicationEngine.SEE_NEARBY_BUSINESS_ON_MAP_CURRENT_LOCATION;
      Intent localIntent5 = localIntent1.putExtra(str7, "true");
      DirectionsResultActivity.this.startActivity(localIntent1);
    }

    protected Void doInBackground(Void[] paramArrayOfVoid)
    {
      DirectionResponse localDirectionResponse = ApplicationEngine.getModel().getTrip(0);
      RouteInfo localRouteInfo = localDirectionResponse.getRouteInfo();
      Object[] arrayOfObject1 = new Object[1];
      ViewStepTotal localViewStepTotal = localDirectionResponse.getViewStepTotal();
      arrayOfObject1[0] = localViewStepTotal;
      LoadDirectionResultsTask localLoadDirectionResultsTask1 = this;
      Object[] arrayOfObject2 = arrayOfObject1;
      localLoadDirectionResultsTask1.publishProgress(arrayOfObject2);
      ViewStepAddress localViewStepAddress1 = localRouteInfo.getViewStepAddress1();
      Object[] arrayOfObject3 = new Object[1];
      ViewStepAddress localViewStepAddress2 = localRouteInfo.getViewStepAddress1();
      arrayOfObject3[0] = localViewStepAddress2;
      LoadDirectionResultsTask localLoadDirectionResultsTask2 = this;
      Object[] arrayOfObject4 = arrayOfObject3;
      localLoadDirectionResultsTask2.publishProgress(arrayOfObject4);
      ViewStepAddress localViewStepAddress3 = localRouteInfo.getViewStepAddress2();
      Object[] arrayOfObject5 = new Object[1];
      arrayOfObject5[0] = localViewStepAddress3;
      LoadDirectionResultsTask localLoadDirectionResultsTask3 = this;
      Object[] arrayOfObject6 = arrayOfObject5;
      localLoadDirectionResultsTask3.publishProgress(arrayOfObject6);
      boolean bool = false;
      localViewStepAddress3.setStart(bool);
      ArrayList localArrayList1 = localRouteInfo.getSteps();
      Resources localResources = DirectionsResultActivity.this.getResources();
      Iterator localIterator1 = localArrayList1.iterator();
      Iterator localIterator2;
      if (!localIterator1.hasNext())
      {
        ArrayList localArrayList2 = localDirectionResponse.getMaps();
        DirectionsResultActivity localDirectionsResultActivity1 = DirectionsResultActivity.this;
        int i = localArrayList2.size();
        localDirectionsResultActivity1.totalMapCount = i;
        localIterator2 = localArrayList2.iterator();
      }
      while (true)
      {
        if (!localIterator2.hasNext())
        {
          ViewStepReverseNewSearch localViewStepReverseNewSearch1 = new ViewStepReverseNewSearch();
          ViewStepReverseNewSearch localViewStepReverseNewSearch2 = new ViewStepReverseNewSearch();
          String str1 = localViewStepAddress1.getFullAddress1();
          localViewStepReverseNewSearch2.setFullAddress1(str1);
          String str2 = localViewStepAddress3.getFullAddress2();
          localViewStepReverseNewSearch2.setFullAddress2(str2);
          Object[] arrayOfObject7 = new Object[1];
          arrayOfObject7[0] = localViewStepReverseNewSearch2;
          LoadDirectionResultsTask localLoadDirectionResultsTask4 = this;
          Object[] arrayOfObject8 = arrayOfObject7;
          localLoadDirectionResultsTask4.publishProgress(arrayOfObject8);
          return null;
          ViewStepDirections localViewStepDirections = (ViewStepDirections)localIterator1.next();
          if (localViewStepDirections.getIcon() != null)
          {
            DirectionsResultActivity localDirectionsResultActivity2 = DirectionsResultActivity.this;
            ImageView localImageView1 = new ImageView(localDirectionsResultActivity2);
            int j = 5;
            int k = 10;
            int m = 5;
            int n = 10;
            localImageView1.setPadding(j, k, m, n);
            SavingManager localSavingManager1 = DirectionsResultActivity.this._savingManager;
            String str3 = localViewStepDirections.getIcon().getURL();
            SavingManager localSavingManager2 = localSavingManager1;
            String str4 = str3;
            localSavingManager2.add(str4, localViewStepDirections);
            DirectionsResultActivity localDirectionsResultActivity3 = DirectionsResultActivity.this;
            localViewStepDirections.setContext(localDirectionsResultActivity3);
            ImageView localImageView2 = (ImageView)DirectionsResultActivity.this.findViewById(2131493054);
            localViewStepDirections.setImageView(localImageView2);
            Object[] arrayOfObject9 = new Object[3];
            arrayOfObject9[0] = localViewStepDirections;
            arrayOfObject9[1] = localImageView1;
            String str5 = localViewStepDirections.getIcon().getURL();
            arrayOfObject9[2] = str5;
            LoadDirectionResultsTask localLoadDirectionResultsTask5 = this;
            Object[] arrayOfObject10 = arrayOfObject9;
            localLoadDirectionResultsTask5.publishProgress(arrayOfObject10);
            break;
          }
          Object[] arrayOfObject11 = new Object[1];
          arrayOfObject11[0] = localViewStepDirections;
          LoadDirectionResultsTask localLoadDirectionResultsTask6 = this;
          Object[] arrayOfObject12 = arrayOfObject11;
          localLoadDirectionResultsTask6.publishProgress(arrayOfObject12);
          break;
        }
        ViewStepMap localViewStepMap = (ViewStepMap)localIterator2.next();
        SavingManager localSavingManager3 = DirectionsResultActivity.this._savingManager;
        String str6 = localViewStepMap.getURL();
        SavingManager localSavingManager4 = localSavingManager3;
        String str7 = str6;
        localSavingManager4.add(str7, localViewStepMap);
        if (DirectionsResultActivity.this != null)
        {
          DirectionsResultActivity localDirectionsResultActivity4 = DirectionsResultActivity.this;
          localViewStepMap.setContext(localDirectionsResultActivity4);
          ImageView localImageView3 = (ImageView)DirectionsResultActivity.this.findViewById(2131492939);
          localViewStepMap.setImageView(localImageView3);
        }
        Object[] arrayOfObject13 = new Object[1];
        arrayOfObject13[0] = localViewStepMap;
        LoadDirectionResultsTask localLoadDirectionResultsTask7 = this;
        Object[] arrayOfObject14 = arrayOfObject13;
        localLoadDirectionResultsTask7.publishProgress(arrayOfObject14);
      }
    }

    protected void onPostExecute(Void paramVoid)
    {
      ViewStepTotal localViewStepTotal = ApplicationEngine.getModel().getMRViewStepTotal();
      Hashtable localHashtable1 = localViewStepTotal.getRouteIcons();
      Hashtable localHashtable2 = new Hashtable(localHashtable1);
      DirectionsResultActivity localDirectionsResultActivity1 = DirectionsResultActivity.this;
      ArrayList localArrayList = localViewStepTotal.getRouteLines();
      localDirectionsResultActivity1._geoPoints = localArrayList;
      Drawable localDrawable1 = DirectionsResultActivity.this.getResources().getDrawable(2130837612);
      Drawable localDrawable2 = DirectionsResultActivity.this.getResources().getDrawable(2130837613);
      RouteIcons localRouteIcons1 = (RouteIcons)localHashtable2.remove("start");
      RouteIcons localRouteIcons2 = (RouteIcons)localHashtable2.remove("end");
      DirectionsResultActivity localDirectionsResultActivity2 = DirectionsResultActivity.this;
      int i = localRouteIcons1.getLat();
      int j = localRouteIcons1.getLon();
      GeoPoint localGeoPoint1 = new GeoPoint(i, j);
      localDirectionsResultActivity2._startPoint = localGeoPoint1;
      GeoPoint localGeoPoint2 = DirectionsResultActivity.this._startPoint;
      OverlayItem localOverlayItem1 = new OverlayItem(localGeoPoint2, "Start", "");
      DirectionsResultActivity localDirectionsResultActivity3 = DirectionsResultActivity.this;
      int k = localRouteIcons2.getLat();
      int m = localRouteIcons2.getLon();
      GeoPoint localGeoPoint3 = new GeoPoint(k, m);
      localDirectionsResultActivity3._endPoint = localGeoPoint3;
      GeoPoint localGeoPoint4 = DirectionsResultActivity.this._endPoint;
      OverlayItem localOverlayItem2 = new OverlayItem(localGeoPoint4, "End", "");
      DirectionsResultActivity localDirectionsResultActivity4 = DirectionsResultActivity.this;
      DirectionsResultActivity.InteractiveMapTask localInteractiveMapTask = new DirectionsResultActivity.InteractiveMapTask(localDirectionsResultActivity4, null);
      Hashtable[] arrayOfHashtable = new Hashtable[1];
      arrayOfHashtable[0] = localHashtable2;
      AsyncTask localAsyncTask = localInteractiveMapTask.execute(arrayOfHashtable);
      DirectionsResultActivity localDirectionsResultActivity5 = DirectionsResultActivity.this;
      DirectionsResultActivity localDirectionsResultActivity6 = DirectionsResultActivity.this;
      StartEndItemizedOverlay localStartEndItemizedOverlay1 = new StartEndItemizedOverlay(localDrawable2, localDirectionsResultActivity6);
      localDirectionsResultActivity5._bgItemizedOverlay = localStartEndItemizedOverlay1;
      GeoPoint localGeoPoint5 = DirectionsResultActivity.this._startPoint;
      OverlayItem localOverlayItem3 = new OverlayItem(localGeoPoint5, null, null);
      GeoPoint localGeoPoint6 = DirectionsResultActivity.this._endPoint;
      OverlayItem localOverlayItem4 = new OverlayItem(localGeoPoint6, null, null);
      DirectionsResultActivity.this._bgItemizedOverlay.addOverlay(localOverlayItem3);
      DirectionsResultActivity.this._bgItemizedOverlay.addOverlay(localOverlayItem4);
      DirectionsResultActivity localDirectionsResultActivity7 = DirectionsResultActivity.this;
      StartEndItemizedOverlay localStartEndItemizedOverlay2 = new StartEndItemizedOverlay(localDrawable1);
      localDirectionsResultActivity7._startOverlayPoint = localStartEndItemizedOverlay2;
      DirectionsResultActivity localDirectionsResultActivity8 = DirectionsResultActivity.this;
      StartEndItemizedOverlay localStartEndItemizedOverlay3 = new StartEndItemizedOverlay(localDrawable2);
      localDirectionsResultActivity8._endOverlayPoint = localStartEndItemizedOverlay3;
      DirectionsResultActivity.this._startOverlayPoint.addOverlay(localOverlayItem1);
      DirectionsResultActivity.this._endOverlayPoint.addOverlay(localOverlayItem2);
    }

    protected void onPreExecute()
    {
      DirectionsResultActivity localDirectionsResultActivity1 = DirectionsResultActivity.this;
      DirectionsResultActivity localDirectionsResultActivity2 = DirectionsResultActivity.this;
      DirectionsResultActivity localDirectionsResultActivity3 = DirectionsResultActivity.this;
      ArrayList localArrayList = new ArrayList();
      DirectionsResultActivity.StepAdapter localStepAdapter1 = new DirectionsResultActivity.StepAdapter(localDirectionsResultActivity2, localDirectionsResultActivity3, 2130903127, localArrayList);
      localDirectionsResultActivity1.m_adapter = localStepAdapter1;
      View localView1 = DirectionsResultActivity.this.getLayoutInflater().inflate(2130903092, null);
      DirectionsResultActivity.this._listView.addFooterView(localView1);
      View localView2 = DirectionsResultActivity.this.getLayoutInflater().inflate(2130903057, null);
      DirectionsResultActivity.this._listView.addHeaderView(localView2);
      ListView localListView = DirectionsResultActivity.this._listView;
      DirectionsResultActivity.StepAdapter localStepAdapter2 = DirectionsResultActivity.this.m_adapter;
      localListView.setAdapter(localStepAdapter2);
      super.onPreExecute();
    }

    protected void onProgressUpdate(Object[] paramArrayOfObject)
    {
      super.onProgressUpdate(paramArrayOfObject);
      ViewStep localViewStep = (ViewStep)paramArrayOfObject[0];
      if ((localViewStep instanceof ViewStepDirections))
      {
        ImageView localImageView;
        String str;
        if (paramArrayOfObject.length > 1)
        {
          LinearLayout localLinearLayout = (LinearLayout)DirectionsResultActivity.this.findViewById(2131492988);
          localImageView = (ImageView)paramArrayOfObject[1];
          str = (String)paramArrayOfObject[2];
          localLinearLayout.addView(localImageView);
        }
        try
        {
          ImageLoader.getInstance().displayImage(str, localImageView);
          DirectionsResultActivity.this.m_adapter.add(localViewStep);
          DirectionsResultActivity.this.m_adapter.notifyDataSetChanged();
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          while (true)
            localOutOfMemoryError.printStackTrace();
        }
      }
      if ((localViewStep instanceof ViewStepTotal))
      {
        ViewStepTotal localViewStepTotal = (ViewStepTotal)localViewStep;
        fillViewStepTotalData(localViewStepTotal);
        return;
      }
      if ((localViewStep instanceof ViewStepAddress))
      {
        ViewStepAddress localViewStepAddress = (ViewStepAddress)localViewStep;
        fillViewStepAddressData(localViewStepAddress);
        return;
      }
      if ((localViewStep instanceof WrappedImageViewLayout))
        return;
      DirectionsResultActivity.this.m_adapter.add(localViewStep);
      DirectionsResultActivity.this.m_adapter.notifyDataSetChanged();
    }
  }

  protected class NearbyBusinessTask extends AsyncTask<String, Integer, YextListings>
  {
    protected NearbyBusinessTask()
    {
    }

    private void addEnhancedLists(final Listing paramListing, int paramInt)
    {
      LinearLayout localLinearLayout1 = (LinearLayout)DirectionsResultActivity.this.findViewById(paramInt);
      if (paramListing.getEnhancedListsHash() == null)
        return;
      Enumeration localEnumeration = paramListing.getEnhancedListsHash().keys();
      while (true)
      {
        if (!localEnumeration.hasMoreElements())
          return;
        LinearLayout localLinearLayout2 = (LinearLayout)DirectionsResultActivity.this.getLayoutInflater().inflate(2130903060, null);
        Button localButton = (Button)localLinearLayout2.findViewById(2131492954);
        final String str = (String)localEnumeration.nextElement();
        CharSequence localCharSequence = (CharSequence)paramListing.getEnhancedListsHash().get(str);
        localButton.setText(localCharSequence);
        View.OnClickListener local3 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            Intent localIntent1 = new Intent("android.intent.action.VIEW");
            Hashtable localHashtable1 = DirectionsResultActivity.this.yextClickTracking;
            String str1 = String.valueOf(paramListing.getYextId());
            StringBuilder localStringBuilder1 = new StringBuilder(str1);
            String str2 = str;
            String str3 = str2;
            if (!localHashtable1.containsKey(str3))
            {
              Hashtable localHashtable2 = DirectionsResultActivity.this.yextClickTracking;
              String str4 = String.valueOf(paramListing.getYextId());
              StringBuilder localStringBuilder2 = new StringBuilder(str4);
              String str5 = str;
              String str6 = str5;
              Boolean localBoolean = Boolean.valueOf(true);
              Object localObject = localHashtable2.put(str6, localBoolean);
              DirectionsResultActivity localDirectionsResultActivity = DirectionsResultActivity.this;
              DirectionsResultActivity.CountYextClickAsync localCountYextClickAsync = new DirectionsResultActivity.CountYextClickAsync(localDirectionsResultActivity);
              String[] arrayOfString = new String[2];
              String str7 = paramListing.getYextId();
              arrayOfString[0] = str7;
              String str8 = str;
              arrayOfString[1] = str8;
              AsyncTask localAsyncTask = localCountYextClickAsync.execute(arrayOfString);
            }
            String str9 = paramListing.getYextId();
            String str10 = str;
            Uri localUri = Uri.parse(URLFactoryBuilder.GetYextEnhancedList(str9, str10));
            Intent localIntent2 = localIntent1.setData(localUri);
            DirectionsResultActivity.this.startActivity(localIntent1);
          }
        };
        localButton.setOnClickListener(local3);
        localLinearLayout1.addView(localLinearLayout2);
      }
    }

    protected YextListings doInBackground(String[] paramArrayOfString)
    {
      DirectionsResultActivity localDirectionsResultActivity = DirectionsResultActivity.this;
      String str1 = paramArrayOfString[0];
      String str2 = paramArrayOfString[1];
      return localDirectionsResultActivity.getNearbyBusiness(str1, str2, "200");
    }

    protected void onPostExecute(YextListings paramYextListings)
    {
      if (paramYextListings == null)
        return;
      if (paramYextListings.getListingCount() == 0)
        return;
      final Listing localListing1 = paramYextListings.getListing(0);
      View localView = DirectionsResultActivity.this.findViewById(2131493075);
      if (localView == null)
        return;
      localView.setVisibility(0);
      ((TextView)DirectionsResultActivity.this.findViewById(2131493076)).setVisibility(0);
      DirectionsResultActivity.this.findViewById(2131493079).setVisibility(0);
      TextView localTextView1 = (TextView)DirectionsResultActivity.this.findViewById(2131493080);
      String str1 = localListing1.getAd();
      Html.ImageGetter localImageGetter1 = DirectionsResultActivity.this.imgGetter;
      Spanned localSpanned1 = Html.fromHtml(str1, localImageGetter1, null);
      localTextView1.setText(localSpanned1);
      Pattern localPattern = Pattern.compile("\\d{6,}");
      Linkify.addLinks(localTextView1, localPattern, "tel:");
      localTextView1.setVisibility(0);
      TextView localTextView2 = (TextView)DirectionsResultActivity.this.findViewById(2131493082);
      if (localListing1.hasSpecialOffer())
      {
        ((LinearLayout)DirectionsResultActivity.this.findViewById(2131493084)).setVisibility(0);
        TextView localTextView3 = (TextView)DirectionsResultActivity.this.findViewById(2131493085);
        Spanned localSpanned2 = Html.fromHtml(localListing1.getOfferInHtml());
        localTextView3.setText(localSpanned2);
        MovementMethod localMovementMethod1 = LinkMovementMethod.getInstance();
        localTextView3.setMovementMethod(localMovementMethod1);
      }
      final Listing localListing2;
      Button localButton;
      if ((localListing1.getAddress() == null) || (localListing1.getAddress().getVisible().equals("false")))
      {
        localTextView2.setVisibility(4);
        addEnhancedLists(localListing1, 2131493081);
        if (paramYextListings.getListingCount() < 2)
          return;
        localListing2 = paramYextListings.getListing(1);
        TextView localTextView4 = (TextView)DirectionsResultActivity.this.findViewById(2131493089);
        String str2 = localListing2.getAd();
        Html.ImageGetter localImageGetter2 = DirectionsResultActivity.this.imgGetter;
        Spanned localSpanned3 = Html.fromHtml(str2, localImageGetter2, null);
        localTextView4.setText(localSpanned3);
        Linkify.addLinks(localTextView4, localPattern, "tel:");
        localTextView4.setVisibility(0);
        localButton = (Button)DirectionsResultActivity.this.findViewById(2131493091);
        localButton.setVisibility(0);
        if (localListing2.hasSpecialOffer())
        {
          ((LinearLayout)DirectionsResultActivity.this.findViewById(2131493093)).setVisibility(0);
          TextView localTextView5 = (TextView)DirectionsResultActivity.this.findViewById(2131493094);
          Spanned localSpanned4 = Html.fromHtml(localListing2.getOfferInHtml());
          localTextView5.setText(localSpanned4);
          MovementMethod localMovementMethod2 = LinkMovementMethod.getInstance();
          localTextView5.setMovementMethod(localMovementMethod2);
        }
        if ((localListing2.getAddress() != null) && (!localListing1.getAddress().getVisible().equals("false")))
          break label497;
        localButton.setVisibility(4);
      }
      while (true)
      {
        DirectionsResultActivity.this.findViewById(2131493088).setVisibility(0);
        addEnhancedLists(localListing2, 2131493090);
        return;
        localTextView2.setVisibility(0);
        NearbyBusinessTask localNearbyBusinessTask1 = this;
        View.OnClickListener local1 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            DirectionsResultActivity localDirectionsResultActivity = DirectionsResultActivity.this;
            Listing localListing = localListing1;
            localDirectionsResultActivity.directionTo(localListing);
          }
        };
        localTextView2.setOnClickListener(local1);
        break;
        label497: NearbyBusinessTask localNearbyBusinessTask2 = this;
        View.OnClickListener local2 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            DirectionsResultActivity localDirectionsResultActivity = DirectionsResultActivity.this;
            Listing localListing = localListing2;
            localDirectionsResultActivity.directionTo(localListing);
          }
        };
        localButton.setOnClickListener(local2);
      }
    }
  }

  private class SaveRecentTripTask extends AsyncTask<Void, Void, Void>
  {
    private SaveRecentTripTask()
    {
    }

    protected Void doInBackground(Void[] paramArrayOfVoid)
    {
      try
      {
        ApplicationEngine.getController().handleViewRequest(111, null, null);
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        while (true)
          localOutOfMemoryError.printStackTrace();
      }
      catch (IOException localIOException)
      {
        while (true)
          localIOException.printStackTrace();
      }
    }
  }

  protected class SaveTripTask extends AsyncTask<String, Integer, String>
  {
    ProgressDialog progressDialog;

    protected SaveTripTask()
    {
    }

    protected String doInBackground(String[] paramArrayOfString)
    {
      String str = paramArrayOfString[0];
      try
      {
        Controller localController = ApplicationEngine.getController();
        Object[] arrayOfObject = new Object[2];
        ArrayList localArrayList = DirectionsResultActivity.this.m_adapter.getItems();
        arrayOfObject[0] = localArrayList;
        arrayOfObject[1] = str;
        localController.handleViewRequest(112, arrayOfObject, null);
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        while (true)
          localOutOfMemoryError.printStackTrace();
      }
      catch (IOException localIOException)
      {
        while (true)
          localIOException.printStackTrace();
      }
    }

    protected void onPostExecute(String paramString)
    {
      this.progressDialog.dismiss();
      Toast.makeText(DirectionsResultActivity.this.getApplicationContext(), "Trip Saved", 1).show();
    }

    protected void onPreExecute()
    {
      DirectionsResultActivity.this.getWindow().setSoftInputMode(2);
      ProgressDialog localProgressDialog = ProgressDialog.show(DirectionsResultActivity.this, "Please wait...", "Saving Trip...", true, true);
      this.progressDialog = localProgressDialog;
    }
  }

  private class StepAdapter extends ArrayAdapter<ViewStep>
  {
    private ArrayList<ViewStep> _items;

    public StepAdapter(int paramArrayList, ArrayList<ViewStep> arg3)
    {
      super(i, localList);
      this._items = localList;
    }

    public boolean destroy()
    {
      Iterator localIterator = this._items.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
        {
          this._items.clear();
          clear();
          this._items = null;
          return true;
        }
        ((ViewStep)localIterator.next()).recycle(false);
      }
    }

    public ArrayList<ViewStep> getItems()
    {
      return this._items;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView1 = paramView;
      ArrayList localArrayList = this._items;
      int i = paramInt;
      ViewStep localViewStep = (ViewStep)localArrayList.get(i);
      DirectionsResultActivity.ViewHolder localViewHolder;
      ViewStepDirections localViewStepDirections1;
      View localView8;
      ImageView localImageView1;
      View localView11;
      LinearLayout.LayoutParams localLayoutParams1;
      label414: ChevronImageView localChevronImageView;
      label601: String[] arrayOfString2;
      String str9;
      int i10;
      if (localView1 == null)
      {
        LayoutInflater localLayoutInflater1 = (LayoutInflater)DirectionsResultActivity.this.getSystemService("layout_inflater");
        localViewHolder = new DirectionsResultActivity.ViewHolder();
        LayoutInflater localLayoutInflater2 = localLayoutInflater1;
        int j = 2130903127;
        ViewGroup localViewGroup = null;
        localView1 = localLayoutInflater2.inflate(j, localViewGroup);
        View localView2 = localView1;
        int k = 2131493241;
        View localView3 = localView2.findViewById(k);
        localViewHolder.step = localView3;
        View localView4 = localView1;
        int m = 2131493165;
        View localView5 = localView4.findViewById(m);
        localViewHolder.reverse_new_search = localView5;
        View localView6 = localView1;
        int n = 2131492937;
        View localView7 = localView6.findViewById(n);
        localViewHolder.map = localView7;
        localView1.setTag(localViewHolder);
        if (localViewStep != null)
        {
          if (!(localViewStep instanceof ViewStepDirections))
            break label1421;
          localViewStepDirections1 = (ViewStepDirections)localViewStep;
          localViewHolder.map.setVisibility(8);
          localViewHolder.step.setVisibility(0);
          localViewHolder.reverse_new_search.setVisibility(8);
          localView8 = localViewHolder.step;
          View localView9 = localView8;
          int i1 = 2131493054;
          localImageView1 = (ImageView)localView9.findViewById(i1);
          View localView10 = localView8;
          int i2 = 2131493242;
          localView11 = localView10.findViewById(i2);
          localLayoutParams1 = (LinearLayout.LayoutParams)localView11.getLayoutParams();
          View localView12 = localView8;
          int i3 = 2131493243;
          LinearLayout.LayoutParams localLayoutParams2 = (LinearLayout.LayoutParams)localView12.findViewById(i3).getLayoutParams();
          if (!localViewStepDirections1.hasIcon())
            break label1047;
          ImageView localImageView2 = localImageView1;
          int i4 = 0;
          localImageView2.setVisibility(i4);
          int i5 = 0;
          localView11.setVisibility(i5);
          double d1 = localViewStepDirections1.getIconWidth();
          float f1 = 0.0F * d1;
          double d2 = ApplicationEngine.DISPLAY_WIDTH;
          float f2 = (float)(f1 / d2) * 10.0F;
          localLayoutParams1.weight = f2;
          if (localViewStep.getBitmap() != null)
            break label960;
          if (localViewStep.isDownloading())
            break label942;
          LoadImageFromNetworkTask localLoadImageFromNetworkTask1 = new LoadImageFromNetworkTask();
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = localViewStepDirections1;
          arrayOfObject1[1] = localImageView1;
          LoadImageFromNetworkTask localLoadImageFromNetworkTask2 = localLoadImageFromNetworkTask1;
          Object[] arrayOfObject2 = arrayOfObject1;
          AsyncTask localAsyncTask1 = localLoadImageFromNetworkTask2.execute(arrayOfObject2);
          View localView13 = localView8;
          int i6 = 2131493058;
          TextView localTextView1 = (TextView)localView13.findViewById(i6);
          String str1 = localViewStepDirections1.getStepTime();
          TextView localTextView2 = localTextView1;
          String str2 = str1;
          localTextView2.setText(str2);
          View localView14 = localView8;
          int i7 = 2131493245;
          localChevronImageView = (ChevronImageView)localView14.findViewById(i7);
          if (!localViewStepDirections1.haveChevron())
            break label1290;
          int i8 = 0;
          localChevronImageView.setVisibility(i8);
          View.OnClickListener local11 = new com/hopstop/ClientView/DirectionsResultActivity$StepAdapter$1;
          View.OnClickListener local12 = local11;
          StepAdapter localStepAdapter1 = this;
          local12.<init>(localStepAdapter1);
          View.OnClickListener local13 = local11;
          localChevronImageView.setOnClickListener(local13);
          String[] arrayOfString1 = localViewStepDirections1.getOptionlVehicle();
          localChevronImageView.setRerouteAll(arrayOfString1);
          String str3 = localViewStepDirections1.getUseAnotherStop();
          localChevronImageView.setUseAnotherStop(str3);
          String str4 = localViewStepDirections1.getUseAnotherTransfer();
          localChevronImageView.setUseAnotherTransfer(str4);
          String str5 = localViewStepDirections1.getVehicle_id();
          localChevronImageView.setReroute(str5);
          String str6 = localViewStepDirections1.getUrlString();
          localChevronImageView.updatedURL(str6);
          localViewStepDirections1.setChevron(localChevronImageView);
          View localView15 = localView8;
          int i9 = 2131493056;
          TextView localTextView3 = (TextView)localView15.findViewById(i9);
          String str7 = localViewStepDirections1.getDirections();
          localTextView3.setText(str7);
          if (localViewStepDirections1.getOptionlVehicle() == null)
            break label1356;
          arrayOfString2 = localViewStepDirections1.getOptionlVehicle();
          StringBuilder localStringBuilder1 = new StringBuilder("Other options: ");
          String str8 = arrayOfString2[1];
          str9 = str8;
          i10 = 3;
          label682: int i11 = arrayOfString2.length;
          if (i10 < i11)
            break label1304;
          View localView16 = localView8;
          int i12 = 2131493057;
          TextView localTextView4 = (TextView)localView16.findViewById(i12);
          TextView localTextView5 = localTextView4;
          String str10 = str9;
          localTextView5.setText(str10);
          TextView localTextView6 = localTextView4;
          int i13 = 0;
          localTextView6.setVisibility(i13);
          label743: if ((!localViewStepDirections1.hasDiversion()) || (localViewStepDirections1.getDiversion() == null))
            break label1390;
          View localView17 = localView1;
          int i14 = 2131493246;
          View localView18 = localView17.findViewById(i14);
          int i15 = 0;
          localView18.setVisibility(i15);
          int i16 = 2131493247;
          ImageView localImageView3 = (ImageView)localView18.findViewById(i16);
          int i17 = 0;
          localImageView3.setVisibility(i17);
          int i18 = 2131492956;
          TextView localTextView7 = (TextView)localView18.findViewById(i18);
          int i19 = 0;
          localTextView7.setVisibility(i19);
          String str11 = localViewStepDirections1.getDiversion();
          localTextView7.setText(str11);
          int i20 = localTextView3.getPaddingLeft();
          int i21 = localTextView3.getPaddingTop();
          int i22 = localTextView3.getPaddingRight();
          int i23 = i20;
          int i24 = i21;
          int i25 = i22;
          int i26 = 20;
          localTextView3.setPadding(i23, i24, i25, i26);
          label902: double d3 = localLayoutParams1.weight;
          float f3 = (float)(7.5D - d3);
          localLayoutParams2.weight = f3;
        }
      }
      while (true)
      {
        return localView1;
        localViewHolder = (DirectionsResultActivity.ViewHolder)localView1.getTag();
        break;
        label942: ViewStepDirections localViewStepDirections2 = localViewStepDirections1;
        ImageView localImageView4 = localImageView1;
        localViewStepDirections2.setImageView(localImageView4);
        break label414;
        label960: if (localViewStep.getBitmap().isRecycled())
        {
          LoadImageFromNetworkTask localLoadImageFromNetworkTask3 = new LoadImageFromNetworkTask();
          Object[] arrayOfObject3 = new Object[2];
          arrayOfObject3[0] = localViewStepDirections1;
          arrayOfObject3[1] = localImageView1;
          LoadImageFromNetworkTask localLoadImageFromNetworkTask4 = localLoadImageFromNetworkTask3;
          Object[] arrayOfObject4 = arrayOfObject3;
          AsyncTask localAsyncTask2 = localLoadImageFromNetworkTask4.execute(arrayOfObject4);
          break label414;
        }
        Bitmap localBitmap1 = localViewStep.getBitmap();
        ImageView localImageView5 = localImageView1;
        Bitmap localBitmap2 = localBitmap1;
        localImageView5.setImageBitmap(localBitmap2);
        break label414;
        label1047: if (localViewStepDirections1.isBikeFriendly())
        {
          if (localViewStepDirections1.getBitmap() == null)
          {
            localViewStepDirections1.setBikeAndNeedToSetWidth(true);
            Bitmap localBitmap3 = BitmapFactory.decodeResource(DirectionsResultActivity.this.getResources(), 2130837522);
            localViewStepDirections1.setBitmap(localBitmap3);
            localViewStepDirections1.setHasIcon(true);
            int i27 = localViewStepDirections1.getBitmap().getWidth();
            localViewStepDirections1.setIconWidth(i27);
            int i28 = ApplicationEngine.DISPLAY_WIDTH;
            int i29 = localViewStepDirections1.getBitmap().getWidth();
            float f4 = i28 - i29;
            float f5 = ApplicationEngine.DEVICE_DENSITY;
            float f6 = 70.0F + f5;
            int i30 = (int)(f4 - f6);
            localViewStepDirections1.setDirectionViewStarts(i30);
          }
          ImageView localImageView6 = localImageView1;
          int i31 = 2130837522;
          localImageView6.setImageResource(i31);
          int i32 = 0;
          localView11.setVisibility(i32);
          ImageView localImageView7 = localImageView1;
          int i33 = 0;
          localImageView7.setVisibility(i33);
          double d4 = localViewStepDirections1.getBitmap().getWidth();
          float f7 = 0.0F * d4;
          double d5 = ApplicationEngine.DISPLAY_WIDTH;
          float f8 = (float)(f7 / d5) * 10.0F;
          localLayoutParams1.weight = f8;
          break label414;
        }
        ImageView localImageView8 = localImageView1;
        int i34 = 8;
        localImageView8.setVisibility(i34);
        int i35 = 8;
        localView11.setVisibility(i35);
        float f9 = 0.0F;
        localLayoutParams1.weight = f9;
        break label414;
        label1290: int i36 = 8;
        localChevronImageView.setVisibility(i36);
        break label601;
        label1304: String str12 = String.valueOf(str9);
        StringBuilder localStringBuilder2 = new StringBuilder(str12).append(", ");
        String str13 = arrayOfString2[i10];
        str9 = str13;
        i10 += 2;
        break label682;
        label1356: View localView19 = localView8;
        int i37 = 2131493057;
        TextView localTextView8 = (TextView)localView19.findViewById(i37);
        int i38 = 8;
        localTextView8.setVisibility(i38);
        break label743;
        label1390: View localView20 = localView1;
        int i39 = 2131493246;
        View localView21 = localView20.findViewById(i39);
        int i41 = 8;
        localView21.setVisibility(i41);
        break label902;
        label1421: if ((localViewStep instanceof ViewStepMap))
        {
          ViewStepMap localViewStepMap1 = (ViewStepMap)localViewStep;
          localViewHolder.step.setVisibility(8);
          localViewHolder.map.setVisibility(0);
          localViewHolder.reverse_new_search.setVisibility(8);
          View localView22 = localViewHolder.map;
          int i42 = localViewStepMap1.getNumber();
          int i40 = 1;
          label1520: ImageView localImageView9;
          if (i42 == i40)
          {
            View localView23 = localView22;
            int i43 = 2131493249;
            TextView localTextView9 = (TextView)localView23.findViewById(i43);
            int i44 = 0;
            localTextView9.setVisibility(i44);
            View localView24 = localView22;
            int i45 = 2131492939;
            localImageView9 = (ImageView)localView24.findViewById(i45);
            int i46 = localViewStepMap1.getNumber();
            int i47 = DirectionsResultActivity.this.totalMapCount;
            int i48 = i46;
            int i49 = i47;
            if (i48 != i49)
            {
              int i50 = localImageView9.getPaddingLeft();
              int i51 = localImageView9.getPaddingTop();
              int i52 = localImageView9.getPaddingRight();
              ImageView localImageView10 = localImageView9;
              int i53 = i50;
              int i54 = i51;
              int i55 = i52;
              int i56 = 10;
              localImageView10.setPadding(i53, i54, i55, i56);
            }
            if (localViewStepMap1.getBitmap() != null)
              break label1788;
            if (localViewStepMap1.isDownloading())
              break label1770;
            LoadImageFromNetworkTask localLoadImageFromNetworkTask5 = new LoadImageFromNetworkTask();
            Object[] arrayOfObject5 = new Object[2];
            arrayOfObject5[0] = localViewStep;
            arrayOfObject5[1] = localImageView9;
            LoadImageFromNetworkTask localLoadImageFromNetworkTask6 = localLoadImageFromNetworkTask5;
            Object[] arrayOfObject6 = arrayOfObject5;
            AsyncTask localAsyncTask3 = localLoadImageFromNetworkTask6.execute(arrayOfObject6);
          }
          while (true)
          {
            View localView25 = localView22;
            int i57 = 2131492938;
            TextView localTextView10 = (TextView)localView25.findViewById(i57);
            String str14 = ((ViewStepMap)localViewStep).getDisplayInfo();
            TextView localTextView11 = localTextView10;
            String str15 = str14;
            localTextView11.setText(str15);
            break;
            View localView26 = localView22;
            int i58 = 2131493249;
            TextView localTextView12 = (TextView)localView26.findViewById(i58);
            int i59 = 8;
            localTextView12.setVisibility(i59);
            break label1520;
            label1770: ViewStepMap localViewStepMap2 = localViewStepMap1;
            ImageView localImageView11 = localImageView9;
            localViewStepMap2.setImageView(localImageView11);
            continue;
            label1788: if (localViewStepMap1.getBitmap().isRecycled())
            {
              LoadImageFromNetworkTask localLoadImageFromNetworkTask7 = new LoadImageFromNetworkTask();
              Object[] arrayOfObject7 = new Object[2];
              arrayOfObject7[0] = localViewStep;
              arrayOfObject7[1] = localImageView9;
              LoadImageFromNetworkTask localLoadImageFromNetworkTask8 = localLoadImageFromNetworkTask7;
              Object[] arrayOfObject8 = arrayOfObject7;
              AsyncTask localAsyncTask4 = localLoadImageFromNetworkTask8.execute(arrayOfObject8);
            }
            else
            {
              Bitmap localBitmap4 = localViewStep.getBitmap();
              ImageView localImageView12 = localImageView9;
              Bitmap localBitmap5 = localBitmap4;
              localImageView12.setImageBitmap(localBitmap5);
            }
          }
        }
        if ((localViewStep instanceof ViewStepReverseNewSearch))
        {
          localViewHolder.step.setVisibility(8);
          localViewHolder.map.setVisibility(8);
          localViewHolder.reverse_new_search.setVisibility(0);
          View localView27 = localViewHolder.reverse_new_search;
          View localView28 = localView27;
          int i60 = 2131493167;
          Button localButton1 = (Button)localView28.findViewById(i60);
          View.OnClickListener local21 = new com/hopstop/ClientView/DirectionsResultActivity$StepAdapter$2;
          View.OnClickListener local22 = local21;
          StepAdapter localStepAdapter2 = this;
          int i61 = paramInt;
          local22.<init>(localStepAdapter2, i61);
          Button localButton2 = localButton1;
          View.OnClickListener local23 = local21;
          localButton2.setOnClickListener(local23);
          View localView29 = localView27;
          int i62 = 2131493168;
          Button localButton3 = (Button)localView29.findViewById(i62);
          View.OnClickListener local31 = new com/hopstop/ClientView/DirectionsResultActivity$StepAdapter$3;
          View.OnClickListener local32 = local31;
          StepAdapter localStepAdapter3 = this;
          local32.<init>(localStepAdapter3);
          Button localButton4 = localButton3;
          View.OnClickListener local33 = local31;
          localButton4.setOnClickListener(local33);
          View localView30 = localView27;
          int i63 = 2131493073;
          Button localButton5 = (Button)localView30.findViewById(i63);
          int i64 = 8;
          localButton5.setVisibility(i64);
          View localView31 = localView27;
          int i65 = 2131493169;
          View localView32 = localView31.findViewById(i65);
          View localView33 = localView32;
          int i66 = 0;
          localView33.setVisibility(i66);
          String str16 = ((TelephonyManager)DirectionsResultActivity.this.getSystemService("phone")).getNetworkOperatorName();
          View.OnClickListener local41 = new com/hopstop/ClientView/DirectionsResultActivity$StepAdapter$4;
          View.OnClickListener local42 = local41;
          StepAdapter localStepAdapter4 = this;
          local42.<init>(localStepAdapter4, str16);
          View localView34 = localView32;
          View.OnClickListener local43 = local41;
          localView34.setOnClickListener(local43);
          View localView35 = localView27;
          int i67 = 2131493170;
          TextView localTextView13 = (TextView)localView35.findViewById(i67);
          TextView localTextView14 = localTextView13;
          int i68 = 0;
          localTextView14.setVisibility(i68);
          MovementMethod localMovementMethod1 = LinkMovementMethod.getInstance();
          TextView localTextView15 = localTextView13;
          MovementMethod localMovementMethod2 = localMovementMethod1;
          localTextView15.setMovementMethod(localMovementMethod2);
        }
      }
    }

    public boolean isEnabled(int paramInt)
    {
      return false;
    }
  }

  private class URLPart
  {
    private boolean include;
    private String url;

    private URLPart()
    {
    }

    private void setInclude(boolean paramBoolean)
    {
      this.include = paramBoolean;
    }

    public String getUrl()
    {
      return this.url;
    }

    public void setUrl(String paramString)
    {
      this.url = paramString;
      setInclude(true);
    }
  }

  static class ViewHolder
  {
    public View map;
    public View reverse_new_search;
    public View step;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.DirectionsResultActivity
 * JD-Core Version:    0.6.2
 */