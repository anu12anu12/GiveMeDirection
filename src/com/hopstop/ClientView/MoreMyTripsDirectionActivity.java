package com.hopstop.ClientView;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
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
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
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
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.OverlayItem;
import com.hopstop.ClientController.Controller;
import com.hopstop.ClientModel.Model;
import com.hopstop.ClientModel.db.HistoryManager;
import com.hopstop.ClientModel.directions.DirectionPathOverlay;
import com.hopstop.ClientModel.directions.GeoPoints;
import com.hopstop.ClientModel.directions.LoadImageFromNetworkTask;
import com.hopstop.ClientModel.directions.RouteIcons;
import com.hopstop.ClientModel.directions.RouteOverlay;
import com.hopstop.ClientModel.directions.StartEndItemizedOverlay;
import com.hopstop.ClientModel.directions.ViewStep;
import com.hopstop.ClientModel.directions.ViewStepAddress;
import com.hopstop.ClientModel.directions.ViewStepDirections;
import com.hopstop.ClientModel.directions.ViewStepMap;
import com.hopstop.ClientModel.directions.ViewStepReverseNewSearch;
import com.hopstop.ClientModel.directions.ViewStepTaxi;
import com.hopstop.ClientModel.directions.ViewStepTotal;
import com.hopstop.ClientModel.directions.WrappedImageViewLayout;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.core.ApplicationEngine.UiCallBack;
import com.hopstop.core.ThreadUpdateRunnable;
import com.hopstop.gps.XSPLocationManager;
import com.hopstop.ui.BaseMapActivity;
import com.hopstop.ui.PageNames;
import com.hopstop.util.Util;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class MoreMyTripsDirectionActivity extends BaseMapActivity
  implements View.OnClickListener, TabHost.OnTabChangeListener
{
  public static int DIRECTION_STEPS = 0;
  public static int MAP_STEPS = 0;
  public static int TAXI_STEPS = 0;
  private static final int myTripsMax = 50;
  private final String LIST_TAB_TAG = "List";
  private int MAPVIEW_CENTER_BETWEEN_TWO_POINTS;
  private int MAPVIEW_END_POINT_CENTER;
  private int MAPVIEW_FIRST_START;
  private int MAPVIEW_NO_CENTER;
  private final String MAP_TAB_TAG = "Map";
  private StartEndItemizedOverlay _bgItemizedOverlay;
  private StartEndItemizedOverlay _endOverlayPoint;
  private GeoPoint _endPoint;
  private ArrayList<GeoPoints> _geoPoints;
  private int _mapviewAnimTpZoom;
  private MyLocationOverlay _me = null;
  private MyGpsMapOverlay _myGpsOverlay;
  private View _myTripView;
  private StartEndItemizedOverlay _startOverlayPoint;
  private GeoPoint _startPoint;
  private TabHost _tabHost;
  private AlertDialog alert;
  private String city1Id = null;
  private String city2Id = null;
  private int index = -1;
  private boolean isRecent = false;
  private LoadMyTripTask loadMyTripTask;
  private StepAdapter m_adapter;
  private ArrayList<ViewStep> m_steps = null;
  private TaxiAdapter m_taxiAdapter;
  private GeoPoint mapCenterReserve;
  private HopStopMapView mapView;
  private int mapZoomLevelReserve;
  private Runnable returnResult;
  private String routeId;
  private ArrayList<ViewStep> trip;
  private Runnable viewSteps;

  public MoreMyTripsDirectionActivity()
  {
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        int i = 0;
        if (MoreMyTripsDirectionActivity.this.isRecent)
          if ((MoreMyTripsDirectionActivity.this.m_steps != null) && (MoreMyTripsDirectionActivity.this.m_steps.size() > 0))
          {
            localViewStepReverseNewSearch1 = new ViewStepReverseNewSearch();
            str1 = ((ViewStepAddress)MoreMyTripsDirectionActivity.this.m_steps.get(1)).getFullAddress1();
            localViewStepReverseNewSearch1.setFullAddress1(str1);
            localMoreMyTripsDirectionActivity1 = MoreMyTripsDirectionActivity.this;
            str2 = ((ViewStepAddress)MoreMyTripsDirectionActivity.this.m_steps.get(1)).getCity1();
            localMoreMyTripsDirectionActivity1.city1Id = str2;
            MoreMyTripsDirectionActivity.this.m_adapter.notifyDataSetChanged();
            j = 0;
            k = MoreMyTripsDirectionActivity.this.m_steps.size();
            if (j < k)
              break label192;
            if (i != 0)
            {
              localViewStepReverseNewSearch2 = new ViewStepReverseNewSearch();
              str3 = localViewStepReverseNewSearch1.getFullAddress1();
              localViewStepReverseNewSearch2.setFullAddress1(str3);
              str4 = localViewStepReverseNewSearch1.getFullAddress2();
              localViewStepReverseNewSearch2.setFullAddress2(str4);
              MoreMyTripsDirectionActivity.this.m_adapter.add(localViewStepReverseNewSearch2);
            }
          }
        label192: ViewStep localViewStep;
        while ((MoreMyTripsDirectionActivity.this.m_steps == null) || (MoreMyTripsDirectionActivity.this.m_steps.size() <= 0))
          while (true)
          {
            String str1;
            MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity1;
            String str2;
            int k;
            ViewStepReverseNewSearch localViewStepReverseNewSearch2;
            String str3;
            String str4;
            MoreMyTripsDirectionActivity.this.m_adapter.notifyDataSetChanged();
            return;
            localViewStep = (ViewStep)MoreMyTripsDirectionActivity.this.m_steps.get(j);
            if ((j > 1) && ((localViewStep instanceof ViewStepAddress)))
            {
              ArrayList localArrayList1 = MoreMyTripsDirectionActivity.this.m_steps;
              int m = j + 1;
              if (!(localArrayList1.get(m) instanceof ViewStepReverseNewSearch))
              {
                String str5 = ((ViewStepAddress)localViewStep).getFullAddress2();
                localViewStepReverseNewSearch1.setFullAddress2(str5);
                MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity2 = MoreMyTripsDirectionActivity.this;
                String str6 = ((ViewStepAddress)localViewStep).getCity2();
                localMoreMyTripsDirectionActivity2.city2Id = str6;
                MoreMyTripsDirectionActivity.this.m_adapter.add(localViewStepReverseNewSearch1);
                i = 1;
              }
            }
            MoreMyTripsDirectionActivity.this.m_adapter.add(localViewStep);
            j += 1;
          }
        ViewStepReverseNewSearch localViewStepReverseNewSearch1 = new ViewStepReverseNewSearch();
        String str7 = ((ViewStepAddress)MoreMyTripsDirectionActivity.this.m_steps.get(1)).getFullAddress1();
        localViewStepReverseNewSearch1.setFullAddress1(str7);
        MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity3 = MoreMyTripsDirectionActivity.this;
        String str8 = ((ViewStepAddress)MoreMyTripsDirectionActivity.this.m_steps.get(1)).getCity1();
        localMoreMyTripsDirectionActivity3.city1Id = str8;
        MoreMyTripsDirectionActivity.this.m_adapter.notifyDataSetChanged();
        int j = 0;
        while (true)
        {
          int n = MoreMyTripsDirectionActivity.this.m_steps.size();
          if (j >= n)
          {
            if (0 == 0)
              break;
            ViewStepReverseNewSearch localViewStepReverseNewSearch3 = new ViewStepReverseNewSearch();
            String str9 = localViewStepReverseNewSearch1.getFullAddress1();
            localViewStepReverseNewSearch3.setFullAddress1(str9);
            String str10 = localViewStepReverseNewSearch1.getFullAddress2();
            localViewStepReverseNewSearch3.setFullAddress2(str10);
            MoreMyTripsDirectionActivity.this.m_adapter.add(localViewStepReverseNewSearch3);
            break;
          }
          localViewStep = (ViewStep)MoreMyTripsDirectionActivity.this.m_steps.get(j);
          if ((j > 1) && ((localViewStep instanceof ViewStepAddress)))
          {
            ArrayList localArrayList2 = MoreMyTripsDirectionActivity.this.m_steps;
            int i1 = j + 1;
            if (!(localArrayList2.get(i1) instanceof ViewStepReverseNewSearch))
            {
              String str11 = ((ViewStepAddress)localViewStep).getFullAddress2();
              localViewStepReverseNewSearch1.setFullAddress2(str11);
              MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity4 = MoreMyTripsDirectionActivity.this;
              String str12 = ((ViewStepAddress)localViewStep).getCity2();
              localMoreMyTripsDirectionActivity4.city2Id = str12;
              MoreMyTripsDirectionActivity.this.m_adapter.add(localViewStepReverseNewSearch1);
            }
          }
          MoreMyTripsDirectionActivity.this.m_adapter.add(localViewStep);
          j += 1;
        }
      }
    };
    this.returnResult = local1;
    this.MAPVIEW_CENTER_BETWEEN_TWO_POINTS = 0;
    this.MAPVIEW_END_POINT_CENTER = 1;
    this.MAPVIEW_NO_CENTER = 2;
    this.MAPVIEW_FIRST_START = 3;
    int i = this.MAPVIEW_FIRST_START;
    this._mapviewAnimTpZoom = i;
  }

  private void addTaxis(ArrayList<ViewStep> paramArrayList)
  {
    ArrayList<ViewStep> localArrayList1 = paramArrayList;
    int i = 0;
    if ((localArrayList1.get(i) instanceof ViewStepTotal))
    {
      ArrayList<ViewStep> localArrayList2 = paramArrayList;
      int j = 0;
      ViewStepTotal localViewStepTotal1 = (ViewStepTotal)localArrayList2.get(j);
      MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity1 = this;
      ViewStepTotal localViewStepTotal2 = localViewStepTotal1;
      localMoreMyTripsDirectionActivity1.fillViewStepTotalData(localViewStepTotal2);
    }
    MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity2 = this;
    int k = 2131493288;
    TextView localTextView1 = (TextView)localMoreMyTripsDirectionActivity2.findViewById(k);
    ArrayList<ViewStep> localArrayList3 = paramArrayList;
    int m = 1;
    ViewStepAddress localViewStepAddress1 = (ViewStepAddress)localArrayList3.get(m);
    TextView localTextView2;
    ViewStepAddress localViewStepAddress2;
    if (localViewStepAddress1.getZip1() == null)
    {
      String str1 = localViewStepAddress1.getAddress();
      localTextView1.setText(str1);
      MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity3 = this;
      int n = 2131493290;
      localTextView2 = (TextView)localMoreMyTripsDirectionActivity3.findViewById(n);
      ArrayList<ViewStep> localArrayList4 = paramArrayList;
      int i1 = 2;
      localViewStepAddress2 = (ViewStepAddress)localArrayList4.get(i1);
      if (localViewStepAddress2.getZip2() != null)
        break label308;
      String str2 = localViewStepAddress2.getAddress();
      localTextView2.setText(str2);
    }
    ArrayList localArrayList5;
    LinearLayout localLinearLayout;
    LayoutInflater localLayoutInflater;
    while (true)
    {
      localArrayList5 = new java/util/ArrayList;
      int i2 = paramArrayList.size();
      ArrayList<ViewStep> localArrayList6 = paramArrayList;
      int i3 = 3;
      int i4 = i2;
      List localList1 = localArrayList6.subList(i3, i4);
      ArrayList localArrayList7 = localArrayList5;
      List localList2 = localList1;
      localArrayList7.<init>(localList2);
      MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity4 = this;
      int i5 = 2131493291;
      localLinearLayout = (LinearLayout)localMoreMyTripsDirectionActivity4.findViewById(i5);
      localLayoutInflater = getLayoutInflater();
      if (localLayoutInflater == null)
        return;
      if (localLinearLayout != null)
        break label364;
      return;
      String str3 = String.valueOf(localViewStepAddress1.getAddress());
      StringBuilder localStringBuilder1 = new StringBuilder(str3).append(", ");
      String str4 = localViewStepAddress1.getZip1();
      String str5 = str4;
      localTextView1.setText(str5);
      break;
      label308: String str6 = String.valueOf(localViewStepAddress2.getAddress());
      StringBuilder localStringBuilder2 = new StringBuilder(str6).append(", ");
      String str7 = localViewStepAddress2.getZip2();
      String str8 = str7;
      localTextView2.setText(str8);
    }
    label364: Iterator localIterator = localArrayList5.iterator();
    if (!localIterator.hasNext())
    {
      int i6 = 2130903102;
      ViewGroup localViewGroup1 = null;
      View localView1 = localLayoutInflater.inflate(i6, localViewGroup1);
      int i7 = 0;
      localView1.setVisibility(i7);
      int i8 = 2131493167;
      Button localButton1 = (Button)localView1.findViewById(i8);
      View.OnClickListener local111 = new com/hopstop/ClientView/MoreMyTripsDirectionActivity$11;
      View.OnClickListener local112 = local111;
      MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity5 = this;
      ViewStepAddress localViewStepAddress3 = localViewStepAddress2;
      ViewStepAddress localViewStepAddress4 = localViewStepAddress1;
      local112.<init>(localMoreMyTripsDirectionActivity5, localViewStepAddress3, localViewStepAddress4);
      View.OnClickListener local113 = local111;
      localButton1.setOnClickListener(local113);
      int i9 = 2131493168;
      Button localButton2 = (Button)localView1.findViewById(i9);
      int i10 = 4;
      localButton2.setVisibility(i10);
      View.OnClickListener local121 = new com/hopstop/ClientView/MoreMyTripsDirectionActivity$12;
      View.OnClickListener local122 = local121;
      MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity6 = this;
      local122.<init>(localMoreMyTripsDirectionActivity6);
      View.OnClickListener local123 = local121;
      localButton2.setOnClickListener(local123);
      int i11 = 2131493073;
      Button localButton3 = (Button)localView1.findViewById(i11);
      View.OnClickListener local131 = new com/hopstop/ClientView/MoreMyTripsDirectionActivity$13;
      View.OnClickListener local132 = local131;
      MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity7 = this;
      local132.<init>(localMoreMyTripsDirectionActivity7);
      View.OnClickListener local133 = local131;
      localButton3.setOnClickListener(local133);
      localLinearLayout.addView(localView1);
      return;
    }
    ViewStepTaxi localViewStepTaxi = (ViewStepTaxi)localIterator.next();
    int i12 = 2130903117;
    ViewGroup localViewGroup2 = null;
    View localView2 = localLayoutInflater.inflate(i12, localViewGroup2);
    if (localView2 == null)
      return;
    int i13 = 2131493223;
    TextView localTextView3 = (TextView)localView2.findViewById(i13);
    String str9 = localViewStepTaxi.getName();
    localTextView3.setText(str9);
    int i14 = 2131493225;
    TextView localTextView4 = (TextView)localView2.findViewById(i14);
    String str10 = localViewStepTaxi.getPhone();
    localTextView4.setText(str10);
    int i15 = 2131493224;
    TextView localTextView5 = (TextView)localView2.findViewById(i15);
    if (localViewStepTaxi.getPrice() > 0.0F)
    {
      StringBuilder localStringBuilder3 = new StringBuilder("Price: $");
      String str11 = Util.roundMyDataTwoDecimal(localViewStepTaxi.getPrice());
      String str12 = str11;
      TextView localTextView6 = localTextView5;
      String str13 = str12;
      localTextView6.setText(str13);
    }
    while (true)
    {
      localLinearLayout.addView(localView2);
      break;
      TextView localTextView7 = localTextView5;
      String str14 = "";
      localTextView7.setText(str14);
    }
  }

  private static View createTabView(Context paramContext, String paramString, boolean paramBoolean)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2130903134, null);
    ((TextView)localView.findViewById(2131493280)).setText(paramString);
    return localView;
  }

  private void fillViewStepAddressData(final ViewStepAddress paramViewStepAddress)
  {
    View localView;
    ImageView localImageView1;
    if (paramViewStepAddress.isStart())
    {
      localView = findViewById(2131492941);
      localView.setVisibility(0);
      TextView localTextView = (TextView)localView.findViewById(2131492933);
      String str = paramViewStepAddress.getAddress();
      localTextView.setText(str);
      localImageView1 = (ImageView)localView.findViewById(2131493251);
      if (!paramViewStepAddress.isStart())
        break label140;
      localImageView1.setImageResource(2130837612);
    }
    while (true)
    {
      ImageView localImageView2 = (ImageView)localView.findViewById(2131493252);
      if (localImageView2 != null)
      {
        localImageView2.setVisibility(0);
        View.OnClickListener local6 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity1 = MoreMyTripsDirectionActivity.this;
            int i = MoreMyTripsDirectionActivity.this.MAPVIEW_END_POINT_CENTER;
            localMoreMyTripsDirectionActivity1._mapviewAnimTpZoom = i;
            MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity2 = MoreMyTripsDirectionActivity.this;
            if (paramViewStepAddress.isStart());
            for (GeoPoint localGeoPoint = MoreMyTripsDirectionActivity.this._startPoint; ; localGeoPoint = MoreMyTripsDirectionActivity.this._endPoint)
            {
              int j = MoreMyTripsDirectionActivity.this.mapView.getMaxZoomLevel();
              localMoreMyTripsDirectionActivity2.setMapZoomPoint(localGeoPoint, j);
              MoreMyTripsDirectionActivity.this._tabHost.setCurrentTab(1);
              return;
            }
          }
        };
        localImageView2.setOnClickListener(local6);
      }
      View.OnClickListener local7 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity1 = MoreMyTripsDirectionActivity.this;
          int i = MoreMyTripsDirectionActivity.this.MAPVIEW_END_POINT_CENTER;
          localMoreMyTripsDirectionActivity1._mapviewAnimTpZoom = i;
          MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity2 = MoreMyTripsDirectionActivity.this;
          if (paramViewStepAddress.isStart());
          for (GeoPoint localGeoPoint = MoreMyTripsDirectionActivity.this._startPoint; ; localGeoPoint = MoreMyTripsDirectionActivity.this._endPoint)
          {
            int j = MoreMyTripsDirectionActivity.this.mapView.getMaxZoomLevel();
            localMoreMyTripsDirectionActivity2.setMapZoomPoint(localGeoPoint, j);
            MoreMyTripsDirectionActivity.this._tabHost.setCurrentTab(1);
            return;
          }
        }
      };
      localView.setOnClickListener(local7);
      return;
      localView = findViewById(2131492942);
      break;
      label140: localImageView1.setImageResource(2130837613);
    }
  }

  private void fillViewStepTotalData(ViewStepTotal paramViewStepTotal)
  {
    TextView localTextView1 = (TextView)findViewById(2131493259);
    String str1 = localTextView1.getText().toString();
    Object[] arrayOfObject1 = new Object[1];
    boolean bool = ApplicationEngine.getModel().getIsMiles();
    String str2 = paramViewStepTotal.getDistance(bool);
    arrayOfObject1[0] = str2;
    String str3 = String.format(str1, arrayOfObject1);
    localTextView1.setText(str3);
    TextView localTextView2 = (TextView)findViewById(2131493253);
    String str4 = localTextView2.getText().toString();
    Object[] arrayOfObject2 = new Object[1];
    String str5 = paramViewStepTotal.getDeparture();
    arrayOfObject2[0] = str5;
    String str6 = String.format(str4, arrayOfObject2);
    localTextView2.setText(str6);
    TextView localTextView3 = (TextView)findViewById(2131493255);
    String str7 = localTextView3.getText().toString();
    Object[] arrayOfObject3 = new Object[1];
    String str8 = paramViewStepTotal.getDuration();
    arrayOfObject3[0] = str8;
    String str9 = String.format(str7, arrayOfObject3);
    localTextView3.setText(str9);
    TextView localTextView4 = (TextView)findViewById(2131493254);
    String str10 = localTextView4.getText().toString();
    Object[] arrayOfObject4 = new Object[1];
    String str11 = paramViewStepTotal.getArrival();
    arrayOfObject4[0] = str11;
    String str12 = String.format(str10, arrayOfObject4);
    localTextView4.setText(str12);
    TextView localTextView5 = (TextView)findViewById(2131493262);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131493260);
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
      TextView localTextView6 = (TextView)findViewById(2131493256);
      String str16 = localTextView6.getText().toString();
      Object[] arrayOfObject6 = new Object[1];
      Integer localInteger = Integer.valueOf(paramViewStepTotal.getWalkingTime());
      arrayOfObject6[0] = localInteger;
      String str17 = String.format(str16, arrayOfObject6);
      localTextView6.setText(str17);
      return;
      localLinearLayout.setVisibility(4);
    }
  }

  private void getSteps(ArrayList<ViewStep> paramArrayList)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      this.m_steps = localArrayList;
      this.m_steps.clear();
      boolean bool = this.m_steps.addAll(paramArrayList);
      if (this.index == -1)
        this.isRecent = true;
      label43: Runnable localRunnable = this.returnResult;
      runOnUiThread(localRunnable);
      return;
    }
    catch (Exception localException)
    {
      break label43;
    }
  }

  private void init(int paramInt)
  {
    int i = paramInt;
    int j = 65535;
    ArrayList localArrayList1;
    ArrayList localArrayList3;
    TabWidget localTabWidget;
    int i7;
    int i8;
    if (i == j)
    {
      localArrayList1 = ApplicationEngine.getModel().getRecentTrip();
      ArrayList localArrayList2 = localArrayList1;
      int k = 0;
      ((ViewStepTotal)localArrayList2.get(k)).setRecent(true);
      localArrayList3 = localArrayList1;
      int m = 0;
      Hashtable localHashtable = ((ViewStepTotal)localArrayList3.get(m)).getRouteIcons();
      if ((localHashtable != null) && (localHashtable.size() > 0))
      {
        MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity1 = this;
        int n = 2130903058;
        localMoreMyTripsDirectionActivity1.setContentView(n);
        MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity2 = this;
        int i1 = 2131492945;
        ImageButton localImageButton = (ImageButton)localMoreMyTripsDirectionActivity2.findViewById(i1);
        int i2 = 8;
        localImageButton.setVisibility(i2);
        LoadMyTripTask localLoadMyTripTask1 = new com/hopstop/ClientView/MoreMyTripsDirectionActivity$LoadMyTripTask;
        LoadMyTripTask localLoadMyTripTask2 = localLoadMyTripTask1;
        MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity3 = this;
        LoadMyTripTask localLoadMyTripTask3 = null;
        localLoadMyTripTask2.<init>(localMoreMyTripsDirectionActivity3, localLoadMyTripTask3);
        LoadMyTripTask localLoadMyTripTask4 = localLoadMyTripTask1;
        this.loadMyTripTask = localLoadMyTripTask4;
        LoadMyTripTask localLoadMyTripTask5 = this.loadMyTripTask;
        ArrayList[] arrayOfArrayList1 = new ArrayList[1];
        arrayOfArrayList1[0] = localArrayList3;
        AsyncTask localAsyncTask1 = localLoadMyTripTask5.execute(arrayOfArrayList1);
        MyGpsMapOverlay localMyGpsMapOverlay1 = new com/hopstop/ClientView/MyGpsMapOverlay;
        MyGpsMapOverlay localMyGpsMapOverlay2 = localMyGpsMapOverlay1;
        MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity4 = this;
        localMyGpsMapOverlay2.<init>(localMoreMyTripsDirectionActivity4);
        MyGpsMapOverlay localMyGpsMapOverlay3 = localMyGpsMapOverlay1;
        this._myGpsOverlay = localMyGpsMapOverlay3;
        MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity5 = this;
        int i3 = 16908306;
        TabHost localTabHost1 = (TabHost)localMoreMyTripsDirectionActivity5.findViewById(i3);
        this._tabHost = localTabHost1;
        this._tabHost.setup();
        TabHost localTabHost2 = this._tabHost;
        MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity6 = this;
        localTabHost2.setOnTabChangedListener(localMoreMyTripsDirectionActivity6);
        MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity7 = this;
        int i4 = 2131492985;
        HopStopMapView localHopStopMapView = (HopStopMapView)localMoreMyTripsDirectionActivity7.findViewById(i4);
        this.mapView = localHopStopMapView;
        this.mapView.setBuiltInZoomControls(true);
        MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity8 = this;
        int i5 = 2131492947;
        View localView1 = localMoreMyTripsDirectionActivity8.findViewById(i5);
        this._myTripView = localView1;
        TabHost localTabHost3 = this._tabHost;
        TabHost.TabSpec localTabSpec1 = this._tabHost.newTabSpec("List");
        MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity9 = this;
        String str1 = "Route";
        boolean bool1 = true;
        View localView2 = createTabView(localMoreMyTripsDirectionActivity9, str1, bool1);
        TabHost.TabSpec localTabSpec2 = localTabSpec1.setIndicator(localView2);
        TabHost.TabContentFactory local41 = new com/hopstop/ClientView/MoreMyTripsDirectionActivity$4;
        TabHost.TabContentFactory local42 = local41;
        MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity10 = this;
        local42.<init>(localMoreMyTripsDirectionActivity10);
        TabHost.TabSpec localTabSpec3 = localTabSpec2.setContent(local41);
        localTabHost3.addTab(localTabSpec3);
        TabHost localTabHost4 = this._tabHost;
        TabHost.TabSpec localTabSpec4 = this._tabHost.newTabSpec("Map");
        MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity11 = this;
        String str2 = "Map";
        boolean bool2 = false;
        View localView3 = createTabView(localMoreMyTripsDirectionActivity11, str2, bool2);
        TabHost.TabSpec localTabSpec5 = localTabSpec4.setIndicator(localView3);
        TabHost.TabContentFactory local51 = new com/hopstop/ClientView/MoreMyTripsDirectionActivity$5;
        TabHost.TabContentFactory local52 = local51;
        MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity12 = this;
        local52.<init>(localMoreMyTripsDirectionActivity12);
        TabHost.TabSpec localTabSpec6 = localTabSpec5.setContent(local51);
        localTabHost4.addTab(localTabSpec6);
        MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity13 = this;
        int i6 = 16908307;
        localTabWidget = (TabWidget)localMoreMyTripsDirectionActivity13.findViewById(i6);
        i7 = localTabWidget.getChildCount();
        i8 = 0;
      }
    }
    else
    {
      while (true)
      {
        if (i8 >= i7)
        {
          localTabWidget.requestLayout();
          this._tabHost.setCurrentTab(1);
          this._tabHost.setCurrentTab(0);
          return;
          Model localModel = ApplicationEngine.getModel();
          int i9 = paramInt;
          localArrayList1 = localModel.getMyTrip(i9);
          break;
        }
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localTabWidget.getChildAt(i8).getLayoutParams();
        int i10 = 5;
        int i11 = 0;
        int i12 = 5;
        int i13 = 0;
        localLayoutParams.setMargins(i10, i11, i12, i13);
        i8 += 1;
      }
    }
    MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity14 = this;
    int i14 = 2130903087;
    localMoreMyTripsDirectionActivity14.setContentView(i14);
    LoadMyTripTask localLoadMyTripTask6 = new com/hopstop/ClientView/MoreMyTripsDirectionActivity$LoadMyTripTask;
    LoadMyTripTask localLoadMyTripTask7 = localLoadMyTripTask6;
    MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity15 = this;
    LoadMyTripTask localLoadMyTripTask8 = null;
    localLoadMyTripTask7.<init>(localMoreMyTripsDirectionActivity15, localLoadMyTripTask8);
    LoadMyTripTask localLoadMyTripTask9 = localLoadMyTripTask6;
    this.loadMyTripTask = localLoadMyTripTask9;
    LoadMyTripTask localLoadMyTripTask10 = this.loadMyTripTask;
    ArrayList[] arrayOfArrayList2 = new ArrayList[1];
    arrayOfArrayList2[0] = localArrayList3;
    AsyncTask localAsyncTask2 = localLoadMyTripTask10.execute(arrayOfArrayList2);
    MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity16 = this;
    int i15 = 2131492934;
    LinearLayout localLinearLayout = (LinearLayout)localMoreMyTripsDirectionActivity16.findViewById(i15);
    LayoutInflater localLayoutInflater = getLayoutInflater();
    int i16 = 2130903064;
    ViewGroup localViewGroup = null;
    View localView4 = localLayoutInflater.inflate(i16, localViewGroup);
    int i17 = 2131492968;
    TextView localTextView = (TextView)localView4.findViewById(i17);
    String str3 = "My Trip";
    localTextView.setText(str3);
    int i18 = 0;
    localLinearLayout.addView(localView4, i18);
  }

  private void initTaxis(final ArrayList<ViewStep> paramArrayList)
  {
    setContentView(2130903138);
    final String str = ((TelephonyManager)getSystemService("phone")).getNetworkOperatorName();
    View localView = findViewById(2131493169);
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent1 = new Intent("android.intent.action.DIAL");
        StringBuilder localStringBuilder = new StringBuilder("tel:");
        String str1 = Uri.encode("#8294");
        Uri localUri = Uri.parse(str1);
        Intent localIntent2 = localIntent1.setData(localUri);
        MoreMyTripsDirectionActivity.this.startActivity(localIntent1);
        MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity = MoreMyTripsDirectionActivity.this;
        String str2 = PageNames.MyTripRoute;
        String str3 = str;
        Long localLong = Long.valueOf(-9223372036854775808L);
        localMoreMyTripsDirectionActivity.trackAction(str2, "PoundTaxiClick", str3, localLong);
      }
    };
    localView.setOnClickListener(local2);
    TextView localTextView = (TextView)findViewById(2131493170);
    MovementMethod localMovementMethod = LinkMovementMethod.getInstance();
    localTextView.setMovementMethod(localMovementMethod);
    ImageButton localImageButton = (ImageButton)findViewById(2131493285);
    View.OnClickListener local3 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity = MoreMyTripsDirectionActivity.this;
        final Dialog localDialog = new Dialog(localMoreMyTripsDirectionActivity);
        localDialog.setContentView(2130903139);
        localDialog.setTitle("Report problems");
        localDialog.setCancelable(true);
        localDialog.setCanceledOnTouchOutside(true);
        localDialog.findViewById(2131492950).setVisibility(8);
        View localView1 = localDialog.findViewById(2131492952);
        final ArrayList localArrayList = paramArrayList;
        View.OnClickListener local1 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            ViewStepAddress localViewStepAddress1 = (ViewStepAddress)localArrayList.get(1);
            String str3;
            ViewStepAddress localViewStepAddress2;
            StringBuilder localStringBuilder2;
            String str5;
            if (localViewStepAddress1.getZip1() == null)
            {
              String str1 = String.valueOf("From: ");
              StringBuilder localStringBuilder1 = new StringBuilder(str1);
              String str2 = localViewStepAddress1.getAddress();
              str3 = str2;
              localViewStepAddress2 = (ViewStepAddress)localArrayList.get(2);
              if (localViewStepAddress2.getZip2() != null)
                break label300;
              String str4 = String.valueOf("To: ");
              localStringBuilder2 = new StringBuilder(str4);
              str5 = localViewStepAddress2.getAddress();
            }
            label300: StringBuilder localStringBuilder7;
            String str16;
            for (String str6 = str5; ; str6 = str16)
            {
              localDialog.dismiss();
              String str7 = MoreMyTripsDirectionActivity.this.getString(2130968653);
              StringBuilder localStringBuilder3 = new StringBuilder("Please describe the problem: \n\n\n======================\n").append(str3).append("\n").append(str6).append("\n").append("Link: http://hopstop.com/?route_id=");
              String str8 = MoreMyTripsDirectionActivity.this.routeId;
              String str9 = String.valueOf(str8 + "\n\n");
              String str10 = str9 + "\n\n\nSent from HopStop Android App " + str7;
              MoreMyTripsDirectionActivity.this.sendEmail("taxi@hopstop.com", "HopStop Android App - Taxi Directions Problem", str10);
              return;
              String str11 = String.valueOf("From: ");
              StringBuilder localStringBuilder4 = new StringBuilder(str11);
              String str12 = localViewStepAddress1.getAddress();
              StringBuilder localStringBuilder5 = localStringBuilder4.append(str12).append(", ");
              String str13 = localViewStepAddress1.getZip1();
              str3 = str13;
              break;
              String str14 = String.valueOf("To: ");
              StringBuilder localStringBuilder6 = new StringBuilder(str14);
              String str15 = localViewStepAddress2.getAddress();
              localStringBuilder7 = localStringBuilder6.append(str15).append(", ");
              str16 = localViewStepAddress2.getZip2();
            }
          }
        };
        localView1.setOnClickListener(local1);
        View localView2 = localDialog.findViewById(2131492953);
        View.OnClickListener local2 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            localDialog.dismiss();
          }
        };
        localView2.setOnClickListener(local2);
        localDialog.show();
      }
    };
    localImageButton.setOnClickListener(local3);
    addTaxis(paramArrayList);
  }

  private void sendDirection(Intent paramIntent)
  {
    if (this.trip == null)
      return;
    ArrayList localArrayList1 = this.trip;
    int i = 0 + 1;
    ViewStepTotal localViewStepTotal = (ViewStepTotal)localArrayList1.get(0);
    ViewStepAddress localViewStepAddress1 = (ViewStepAddress)this.trip.get(i);
    ArrayList localArrayList2 = this.trip;
    String str1 = getDirectionText(localArrayList2, "\n", i);
    ArrayList localArrayList3 = this.trip;
    ArrayList localArrayList4 = this.trip;
    int j = getDirectionAddress2(localArrayList4, i);
    ViewStepAddress localViewStepAddress2 = (ViewStepAddress)localArrayList3.get(j);
    StringBuilder localStringBuilder1 = new StringBuilder("HopStop Directions from ");
    String str2 = localViewStepAddress1.getAddress();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str2).append(" to ");
    String str3 = localViewStepAddress2.getAddress();
    String str4 = str3;
    String str5 = String.valueOf("The directions below have been sent to you from HopStop's free Android app\n\n");
    String str6 = String.valueOf(str5 + str1);
    StringBuilder localStringBuilder3 = new StringBuilder(str6).append("\nView these directions with walking maps on the HopStop Mobile Site:\n http://www.HopStop.com/pda?");
    String str7 = localViewStepTotal.getRouteId();
    String str8 = String.valueOf(str7 + '\n');
    StringBuilder localStringBuilder4 = new StringBuilder(str8).append("\nView these directions with walking maps and interactive maps on HopStop.com:\n http://www.HopStop.com?action=route&route_id=");
    String str9 = localViewStepTotal.getRouteId();
    String str10 = String.valueOf(str9 + '\n');
    StringBuilder localStringBuilder5 = new StringBuilder(str10);
    String str11 = getString(2130968773);
    String str12 = str11;
    StringBuilder localStringBuilder6 = new StringBuilder("http://hopstop.com/pda?");
    String str13 = localViewStepTotal.getRouteId();
    String str14 = str13;
    StringBuilder localStringBuilder7 = new StringBuilder("From: ");
    String str15;
    String str16;
    label388: String str18;
    String str19;
    if (localViewStepAddress1.getAddress() != null)
    {
      str15 = localViewStepAddress1.getAddress();
      StringBuilder localStringBuilder8 = localStringBuilder7.append(str15).append(", ").append("To: ");
      if (localViewStepAddress2.getAddress() == null)
        break label490;
      str16 = localViewStepAddress2.getAddress();
      StringBuilder localStringBuilder9 = localStringBuilder8.append(str16).append(", ").append("Link: ").append("http://hopstop.com/pda?");
      String str17 = localViewStepTotal.getRouteId();
      str18 = str17;
      str19 = paramIntent.getComponent().getClassName();
      Intent localIntent1 = paramIntent.putExtra("android.intent.extra.SUBJECT", str4);
      if (!str19.contains("facebook"))
        break label498;
      Intent localIntent2 = paramIntent.putExtra("android.intent.extra.TEXT", str14);
    }
    while (true)
    {
      startActivity(paramIntent);
      return;
      str15 = "My Current Location";
      break;
      label490: str16 = "My Current Location";
      break label388;
      label498: if ((str19.toLowerCase().contains("mail")) || (str19.contains("k9")))
        Intent localIntent3 = paramIntent.putExtra("android.intent.extra.TEXT", str12);
      else
        Intent localIntent4 = paramIntent.putExtra("android.intent.extra.TEXT", str18);
    }
  }

  private void setMapZoomPoint(GeoPoint paramGeoPoint, int paramInt)
  {
    int i = this.MAPVIEW_END_POINT_CENTER;
    this._mapviewAnimTpZoom = i;
    this.mapView.getController().setCenter(paramGeoPoint);
    int j = this.mapView.getController().setZoom(paramInt);
    this.mapView.postInvalidate();
  }

  public void addElementFromReposnse(final ArrayList<ViewStep> paramArrayList)
  {
    if (paramArrayList == null)
    {
      finish();
      return;
    }
    Runnable local10 = new Runnable()
    {
      public void run()
      {
        MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity = MoreMyTripsDirectionActivity.this;
        ArrayList localArrayList = paramArrayList;
        localMoreMyTripsDirectionActivity.getSteps(localArrayList);
      }
    };
    this.viewSteps = local10;
    ListView localListView = (ListView)findViewById(2131492936);
    ArrayList localArrayList1 = new ArrayList();
    this.m_steps = localArrayList1;
    ArrayList localArrayList2 = this.m_steps;
    StepAdapter localStepAdapter1 = new StepAdapter(this, 2130903127, localArrayList2);
    this.m_adapter = localStepAdapter1;
    StepAdapter localStepAdapter2 = this.m_adapter;
    localListView.setAdapter(localStepAdapter2);
    Runnable localRunnable = this.viewSteps;
    new Thread(null, localRunnable, "MagentoBackground").start();
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
    save_route(paramString);
  }

  public void createDialogForShare()
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
    AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(this);
    final EditText localEditText = new EditText(this);
    AlertDialog.Builder localBuilder2 = localBuilder1.setView(localEditText);
    DialogInterface.OnClickListener local8 = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        String str = localEditText.getText().toString().trim();
        MoreMyTripsDirectionActivity.this.checkTripName(str);
      }
    };
    AlertDialog.Builder localBuilder3 = localBuilder1.setPositiveButton("Ok", local8);
    DialogInterface.OnClickListener local9 = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.cancel();
      }
    };
    AlertDialog.Builder localBuilder4 = localBuilder1.setNegativeButton("Cancel", local9);
    AlertDialog.Builder localBuilder5 = localBuilder1.setTitle(paramString);
    AlertDialog localAlertDialog = localBuilder1.show();
  }

  public int getDirectionAddress2(ArrayList<ViewStep> paramArrayList, int paramInt)
  {
    int i;
    if (paramArrayList == null)
    {
      i = paramInt;
      return i;
    }
    int j = paramInt + 1;
    ViewStepAddress localViewStepAddress = (ViewStepAddress)paramArrayList.get(paramInt);
    paramInt = j;
    while (true)
    {
      int k = paramArrayList.size();
      if ((paramInt >= k) || (!(paramArrayList.get(paramInt) instanceof ViewStepDirections)))
      {
        i = paramInt;
        break;
      }
      ViewStepDirections localViewStepDirections = (ViewStepDirections)paramArrayList.get(paramInt);
      paramInt += 1;
    }
  }

  public String getDirectionText(ArrayList<ViewStep> paramArrayList, String paramString, int paramInt)
  {
    String str1;
    if (paramArrayList == null)
    {
      str1 = null;
      return str1;
    }
    int i = paramInt + 1;
    ViewStepAddress localViewStepAddress1 = (ViewStepAddress)paramArrayList.get(paramInt);
    String str2 = String.valueOf("");
    String str3 = String.valueOf(str2 + "From:");
    StringBuilder localStringBuilder1 = new StringBuilder(str3);
    String str4 = localViewStepAddress1.getAddress();
    String str5 = String.valueOf(str4);
    String str6 = str5 + paramString;
    String str7 = "";
    paramInt = i;
    while (true)
    {
      int j = paramArrayList.size();
      if ((paramInt >= j) || (!(paramArrayList.get(paramInt) instanceof ViewStepDirections)))
      {
        ViewStepAddress localViewStepAddress2 = (ViewStepAddress)paramArrayList.get(paramInt);
        String str8 = String.valueOf(str6);
        String str9 = String.valueOf(str8 + "To:");
        StringBuilder localStringBuilder2 = new StringBuilder(str9);
        String str10 = localViewStepAddress2.getAddress();
        String str11 = String.valueOf(str10);
        String str12 = String.valueOf(str11 + paramString);
        String str13 = String.valueOf(str12 + str7);
        str1 = str13 + paramString;
        break;
      }
      ViewStepDirections localViewStepDirections = (ViewStepDirections)paramArrayList.get(paramInt);
      String str14 = String.valueOf(str7);
      StringBuilder localStringBuilder3 = new StringBuilder(str14);
      String str15 = localViewStepDirections.getDirections();
      str7 = str15 + paramString;
      paramInt += 1;
    }
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
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      int i = localBundle.getInt("index");
      this.index = i;
    }
    String str1 = PageNames.MyTripRoute;
    trackEvent(str1);
    ArrayList localArrayList;
    if (this.index == -1)
    {
      localArrayList = ApplicationEngine.getModel().getRecentTrip();
      ViewStepTotal localViewStepTotal1 = (ViewStepTotal)localArrayList.get(0);
      String str2 = localViewStepTotal1.getRouteId();
      this.routeId = str2;
      if (localViewStepTotal1.isTaxi() == 1)
        initTaxis(localArrayList);
    }
    while (true)
    {
      Hashtable localHashtable = new Hashtable();
      String str3 = ApplicationEngine.getModel().getDefaultCityId();
      Object localObject = localHashtable.put("defaultcity", str3);
      int j = ApplicationEngine.ZONE_MY_TRIPS;
      update(j, localHashtable, null, null);
      return;
      int k = this.index;
      init(k);
      continue;
      Model localModel = ApplicationEngine.getModel();
      int m = this.index;
      localArrayList = localModel.getMyTrip(m);
      ViewStepTotal localViewStepTotal2 = (ViewStepTotal)localArrayList.get(0);
      String str4 = localViewStepTotal2.getRouteId();
      this.routeId = str4;
      if (localViewStepTotal2.isTaxi() == 1)
      {
        initTaxis(localArrayList);
      }
      else
      {
        int n = this.index;
        init(n);
      }
    }
  }

  public void onDestroy()
  {
    if ((this.loadMyTripTask != null) && (this.loadMyTripTask.isCancelled()))
      boolean bool1 = this.loadMyTripTask.cancel(true);
    try
    {
      if ((this.m_steps != null) && (this.index != -1))
      {
        localIterator = this.m_steps.iterator();
        if (localIterator.hasNext());
      }
      else
      {
        if (this.m_adapter != null)
        {
          boolean bool2 = this.m_adapter.destroy();
          this.m_adapter = null;
        }
        ListView localListView = (ListView)findViewById(2131492936);
        if (localListView != null)
        {
          View localView1 = findViewById(2131493075);
          if (localView1 != null)
            boolean bool3 = localListView.removeFooterView(localView1);
          View localView2 = findViewById(2131492940);
          if (localView2 != null)
          {
            WrappedImageViewLayout localWrappedImageViewLayout = (WrappedImageViewLayout)findViewById(2131492989);
            if (localWrappedImageViewLayout != null)
              localWrappedImageViewLayout.recycle(true);
            boolean bool4 = localListView.removeHeaderView(localView2);
          }
          localListView.setAdapter(null);
        }
        if (this._tabHost != null)
          this._tabHost.removeAllViews();
        super.onDestroy();
      }
    }
    catch (Exception localException)
    {
      try
      {
        while (true)
        {
          Iterator localIterator;
          if (this.mapView != null)
            boolean bool5 = this.mapView.recycle();
          Field localField1 = MapActivity.class.getDeclaredField("mConfig");
          localField1.setAccessible(true);
          Object localObject = localField1.get(this);
          if (localObject != null)
          {
            Field localField2 = localObject.getClass().getDeclaredField("context");
            localField2.setAccessible(true);
            localField2.set(localObject, null);
            localField1.set(this, null);
          }
          System.gc();
          return;
          ViewStep localViewStep = (ViewStep)localIterator.next();
          if (localViewStep != null)
          {
            localViewStep.recycle(false);
            continue;
            localException = localException;
          }
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        while (true)
          localIllegalArgumentException.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        while (true)
          localIllegalAccessException.printStackTrace();
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        while (true)
          localNoSuchFieldException.printStackTrace();
      }
    }
  }

  protected void onPause()
  {
    if (this._me != null)
    {
      this._me.disableCompass();
      this._me.disableMyLocation();
    }
    if (this.mapView != null)
    {
      GeoPoint localGeoPoint = this.mapView.getMapCenter();
      this.mapCenterReserve = localGeoPoint;
      int i = this.mapView.getZoomLevel();
      this.mapZoomLevelReserve = i;
    }
    super.onPause();
  }

  public void onResume()
  {
    if ((this.mapView != null) && (this.mapView.getController() != null) && (this.mapCenterReserve != null) && (this.mapZoomLevelReserve != 0))
    {
      MapController localMapController1 = this.mapView.getController();
      GeoPoint localGeoPoint = this.mapCenterReserve;
      localMapController1.setCenter(localGeoPoint);
      MapController localMapController2 = this.mapView.getController();
      int i = this.mapZoomLevelReserve;
      int j = localMapController2.setZoom(i);
    }
    super.onResume();
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
        this.mapView.postInvalidate();
        if (this._me != null)
          break label322;
        HopStopMapView localHopStopMapView = this.mapView;
        MyLocationOverlay localMyLocationOverlay1 = new MyLocationOverlay(this, localHopStopMapView);
        this._me = localMyLocationOverlay1;
        List localList1 = this.mapView.getOverlays();
        MyLocationOverlay localMyLocationOverlay2 = this._me;
        boolean bool1 = localList1.add(localMyLocationOverlay2);
        boolean bool2 = this._me.enableCompass();
      }
      while (true)
      {
        localImageButton.setVisibility(0);
        View.OnClickListener local14 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            XSPLocationManager.getXSPLocationManager(MoreMyTripsDirectionActivity.this).startWSP();
            try
            {
              Controller localController = ApplicationEngine.getController();
              Object[] arrayOfObject = new Object[1];
              MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity = MoreMyTripsDirectionActivity.this;
              arrayOfObject[0] = localMoreMyTripsDirectionActivity;
              ApplicationEngine.UiCallBack local1 = new ApplicationEngine.UiCallBack()
              {
                public void onStatusChanged(int paramAnonymous2Int1, int paramAnonymous2Int2, Object[] paramAnonymous2ArrayOfObject)
                {
                  if (1 != paramAnonymous2Int2)
                    return;
                  final Location localLocation = (Location)paramAnonymous2ArrayOfObject[0];
                  MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity = MoreMyTripsDirectionActivity.this;
                  Runnable local1 = new Runnable()
                  {
                    public void run()
                    {
                      int i = (int)(localLocation.getLatitude() * 1000000.0D);
                      int j = (int)(localLocation.getLongitude() * 1000000.0D);
                      GeoPoint localGeoPoint = new GeoPoint(i, j);
                      MapController localMapController = MoreMyTripsDirectionActivity.this.mapView.getController();
                      Message localMessage = new Message();
                      localMapController.animateTo(localGeoPoint, localMessage);
                      MoreMyTripsDirectionActivity.this._myGpsOverlay.setPointToDraw(localGeoPoint);
                      List localList = MoreMyTripsDirectionActivity.this.mapView.getOverlays();
                      MyGpsMapOverlay localMyGpsMapOverlay = MoreMyTripsDirectionActivity.this._myGpsOverlay;
                      boolean bool = localList.add(localMyGpsMapOverlay);
                    }
                  };
                  localMoreMyTripsDirectionActivity.runOnUiThread(local1);
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
        localImageButton.setOnClickListener(local14);
        return;
        int m = this._mapviewAnimTpZoom;
        int n = this.MAPVIEW_CENTER_BETWEEN_TWO_POINTS;
        if (m != n)
        {
          MapController localMapController = this.mapView.getController();
          int i1 = this._bgItemizedOverlay.getLatSpanE6();
          int i2 = this._bgItemizedOverlay.getLonSpanE6();
          localMapController.zoomToSpan(i1, i2);
          int i3 = this._endPoint.getLatitudeE6();
          int i4 = this._startPoint.getLatitudeE6();
          int i5 = (i3 + i4) / 2;
          int i6 = this._endPoint.getLongitudeE6();
          int i7 = this._startPoint.getLongitudeE6();
          int i8 = (i6 + i7) / 2;
          GeoPoint localGeoPoint = new GeoPoint(i5, i8);
          localMapController.animateTo(localGeoPoint);
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
        label322: boolean bool3 = this._me.enableCompass();
      }
    }
    if (!paramString.equals("List"))
      return;
    localImageButton.setVisibility(8);
    List localList2 = this.mapView.getOverlays();
    MyGpsMapOverlay localMyGpsMapOverlay = this._myGpsOverlay;
    boolean bool4 = localList2.remove(localMyGpsMapOverlay);
    if (this._me == null)
      return;
    this._me.disableCompass();
  }

  public void refresh()
  {
    if (this.index == -1)
    {
      ArrayList localArrayList1 = ApplicationEngine.getModel().getRecentTrip();
      this.trip = localArrayList1;
      ArrayList localArrayList2 = this.trip;
      addElementFromReposnse(localArrayList2);
      return;
    }
    Model localModel = ApplicationEngine.getModel();
    int i = this.index;
    ArrayList localArrayList3 = localModel.getMyTrip(i);
    this.trip = localArrayList3;
    ArrayList localArrayList4 = this.trip;
    addElementFromReposnse(localArrayList4);
  }

  protected void save_route(String paramString)
  {
    Toast.makeText(getApplicationContext(), "Saving trip, please wait...", 1).show();
    SaveTripTask localSaveTripTask = new SaveTripTask();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramString;
    AsyncTask localAsyncTask = localSaveTripTask.execute(arrayOfString);
  }

  public void updateImageView(ImageView paramImageView, Bitmap paramBitmap)
  {
    ((ThreadUpdateRunnable)this.returnResult).getImageView(paramImageView, paramBitmap);
    Runnable localRunnable = this.returnResult;
    runOnUiThread(localRunnable);
  }

  public void updateMapView(ImageView paramImageView, Bitmap paramBitmap)
  {
    paramImageView.setImageBitmap(paramBitmap);
    paramImageView.invalidate();
  }

  private class InteractiveMapTask extends AsyncTask<Hashtable<String, RouteIcons>, Void, DirectionPathOverlay>
  {
    private InteractiveMapTask()
    {
    }

    protected DirectionPathOverlay doInBackground(Hashtable<String, RouteIcons>[] paramArrayOfHashtable)
    {
      DirectionPathOverlay localDirectionPathOverlay = null;
      Drawable localDrawable = MoreMyTripsDirectionActivity.this.getResources().getDrawable(2130837566);
      if ((paramArrayOfHashtable == null) && (paramArrayOfHashtable.length == 0))
        boolean bool = cancel(true);
      while (true)
      {
        return localDirectionPathOverlay;
        HopStopMapView localHopStopMapView = MoreMyTripsDirectionActivity.this.mapView;
        drawPath(localHopStopMapView);
        Hashtable<String, RouteIcons> localHashtable = paramArrayOfHashtable[0];
        FrameLayout localFrameLayout = (FrameLayout)MoreMyTripsDirectionActivity.this.getLayoutInflater().inflate(2130903070, null);
        localDirectionPathOverlay = new DirectionPathOverlay(localDrawable, localHashtable, localFrameLayout, false);
      }
    }

    public void drawPath(MapView paramMapView)
    {
      try
      {
        GeoPoints localGeoPoints = (GeoPoints)MoreMyTripsDirectionActivity.this._geoPoints.get(0);
        List localList1 = paramMapView.getOverlays();
        GeoPoint localGeoPoint1 = localGeoPoints.getStart();
        GeoPoint localGeoPoint2 = localGeoPoints.getEnd();
        RouteOverlay localRouteOverlay1 = new RouteOverlay(localGeoPoint1, localGeoPoint2, 1);
        boolean bool1 = localList1.add(localRouteOverlay1);
        Object localObject = localGeoPoints.getEnd();
        int i = 1;
        while (true)
        {
          int j = MoreMyTripsDirectionActivity.this._geoPoints.size();
          int k = j;
          if (i >= k)
          {
            label88: paramMapView.setEnabled(true);
            return;
          }
          GeoPoint localGeoPoint4 = ((GeoPoints)MoreMyTripsDirectionActivity.this._geoPoints.get(i)).getStart();
          if (localObject != localGeoPoint4)
          {
            List localList2 = paramMapView.getOverlays();
            GeoPoint localGeoPoint5 = ((GeoPoints)MoreMyTripsDirectionActivity.this._geoPoints.get(i)).getStart();
            int m = ((GeoPoints)MoreMyTripsDirectionActivity.this._geoPoints.get(i)).getRouteColor();
            RouteOverlay localRouteOverlay2 = new RouteOverlay((GeoPoint)localObject, localGeoPoint5, 3, m);
            boolean bool2 = localList2.add(localRouteOverlay2);
          }
          List localList3 = paramMapView.getOverlays();
          GeoPoint localGeoPoint6 = ((GeoPoints)MoreMyTripsDirectionActivity.this._geoPoints.get(i)).getStart();
          GeoPoint localGeoPoint7 = ((GeoPoints)MoreMyTripsDirectionActivity.this._geoPoints.get(i)).getEnd();
          int n = ((GeoPoints)MoreMyTripsDirectionActivity.this._geoPoints.get(i)).getRouteColor();
          RouteOverlay localRouteOverlay3 = new RouteOverlay(localGeoPoint6, localGeoPoint7, 3, n);
          boolean bool3 = localList3.add(localRouteOverlay3);
          GeoPoint localGeoPoint3 = ((GeoPoints)MoreMyTripsDirectionActivity.this._geoPoints.get(i)).getEnd();
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
      boolean bool1 = MoreMyTripsDirectionActivity.this.mapView.getOverlays().add(paramDirectionPathOverlay);
      List localList1 = MoreMyTripsDirectionActivity.this.mapView.getOverlays();
      StartEndItemizedOverlay localStartEndItemizedOverlay1 = MoreMyTripsDirectionActivity.this._startOverlayPoint;
      boolean bool2 = localList1.add(localStartEndItemizedOverlay1);
      List localList2 = MoreMyTripsDirectionActivity.this.mapView.getOverlays();
      StartEndItemizedOverlay localStartEndItemizedOverlay2 = MoreMyTripsDirectionActivity.this._endOverlayPoint;
      boolean bool3 = localList2.add(localStartEndItemizedOverlay2);
      MoreMyTripsDirectionActivity.this.mapView.postInvalidate();
    }
  }

  protected class LoadImageFromDBTask extends AsyncTask<Object, Object, Object[]>
  {
    protected LoadImageFromDBTask()
    {
    }

    protected Object[] doInBackground(Object[] paramArrayOfObject)
    {
      ViewStepMap localViewStepMap = (ViewStepMap)paramArrayOfObject[0];
      ImageView localImageView = (ImageView)paramArrayOfObject[1];
      Bitmap localBitmap = localViewStepMap.loadImageFromDB(localImageView);
      if (localBitmap != null)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = localBitmap;
        arrayOfObject[1] = localViewStepMap;
        publishProgress(arrayOfObject);
      }
      return paramArrayOfObject;
    }

    protected void onPostExecute(Object[] paramArrayOfObject)
    {
      ViewStepMap localViewStepMap = (ViewStepMap)paramArrayOfObject[0];
      ImageView localImageView = (ImageView)paramArrayOfObject[1];
      if (localViewStepMap.getBitmap() == null)
      {
        localImageView.setImageResource(2130837567);
        HistoryManager localHistoryManager = ApplicationEngine.getHistoryManager(MoreMyTripsDirectionActivity.this.getApplicationContext());
        localViewStepMap.setImageView(localImageView);
        LoadImageFromNetworkTask localLoadImageFromNetworkTask = new LoadImageFromNetworkTask();
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = localViewStepMap;
        arrayOfObject[1] = localImageView;
        AsyncTask localAsyncTask = localLoadImageFromNetworkTask.execute(arrayOfObject);
        return;
      }
      Bitmap localBitmap = localViewStepMap.getBitmap();
      localImageView.setImageBitmap(localBitmap);
      localImageView.invalidate();
    }

    protected void onProgressUpdate(Object[] paramArrayOfObject)
    {
      Bitmap localBitmap = (Bitmap)paramArrayOfObject[0];
      ((ViewStepMap)paramArrayOfObject[1]).setBitmap(localBitmap);
    }
  }

  private class LoadMyTripTask extends AsyncTask<ArrayList<ViewStep>, Object, Integer>
  {
    private LoadMyTripTask()
    {
    }

    protected Integer doInBackground(ArrayList<ViewStep>[] paramArrayOfArrayList)
    {
      ArrayList<ViewStep> localArrayList = paramArrayOfArrayList[0];
      if ((localArrayList == null) || (localArrayList.size() < 3))
        boolean bool1 = cancel(true);
      ViewStepTotal localViewStepTotal = (ViewStepTotal)((ViewStep)localArrayList.get(0)).cloneItself();
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = localViewStepTotal;
      publishProgress(arrayOfObject1);
      ViewStepAddress localViewStepAddress1 = (ViewStepAddress)((ViewStep)localArrayList.get(1)).cloneItself();
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = localViewStepAddress1;
      publishProgress(arrayOfObject2);
      ViewStepAddress localViewStepAddress2 = (ViewStepAddress)((ViewStep)localArrayList.get(2)).cloneItself();
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = localViewStepAddress2;
      publishProgress(arrayOfObject3);
      int i = localArrayList.size();
      List localList = localArrayList.subList(3, i);
      if ((localList != null) && (localList.size() < 2))
        boolean bool2 = cancel(true);
      Iterator localIterator = localList.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
        {
          ViewStepReverseNewSearch localViewStepReverseNewSearch1 = new ViewStepReverseNewSearch();
          ViewStepReverseNewSearch localViewStepReverseNewSearch2 = new ViewStepReverseNewSearch();
          String str1 = localViewStepAddress1.getFullAddress1();
          localViewStepReverseNewSearch2.setFullAddress1(str1);
          String str2 = localViewStepAddress2.getFullAddress2();
          localViewStepReverseNewSearch2.setFullAddress2(str2);
          MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity1 = MoreMyTripsDirectionActivity.this;
          String str3 = localViewStepAddress2.getCity1();
          localMoreMyTripsDirectionActivity1.city1Id = str3;
          MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity2 = MoreMyTripsDirectionActivity.this;
          String str4 = localViewStepAddress2.getCity2();
          localMoreMyTripsDirectionActivity2.city2Id = str4;
          Object[] arrayOfObject4 = new Object[1];
          arrayOfObject4[0] = localViewStepReverseNewSearch2;
          publishProgress(arrayOfObject4);
          return Integer.valueOf(MoreMyTripsDirectionActivity.this.index);
        }
        ViewStep localViewStep = (ViewStep)localIterator.next();
        if ((localViewStep instanceof ViewStepDirections))
        {
          ViewStepDirections localViewStepDirections = (ViewStepDirections)localViewStep;
          if (localViewStepDirections.getBitmap() != null)
          {
            MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity3 = MoreMyTripsDirectionActivity.this;
            ImageView localImageView = new ImageView(localMoreMyTripsDirectionActivity3);
            localImageView.setPadding(5, 10, 5, 10);
            Bitmap localBitmap = localViewStepDirections.getBitmap();
            localImageView.setImageBitmap(localBitmap);
            Object[] arrayOfObject5 = new Object[2];
            arrayOfObject5[0] = localViewStep;
            arrayOfObject5[1] = localImageView;
            publishProgress(arrayOfObject5);
          }
          else
          {
            Object[] arrayOfObject6 = new Object[1];
            arrayOfObject6[0] = localViewStep;
            publishProgress(arrayOfObject6);
          }
        }
        else if (!(localViewStep instanceof ViewStepReverseNewSearch))
        {
          Object[] arrayOfObject7 = new Object[1];
          arrayOfObject7[0] = localViewStep;
          publishProgress(arrayOfObject7);
        }
      }
    }

    protected void onPostExecute(Integer paramInteger)
    {
      ArrayList localArrayList1;
      if (MoreMyTripsDirectionActivity.this.index == -1)
      {
        localArrayList1 = ApplicationEngine.getModel().getRecentTrip();
        ((ViewStepTotal)localArrayList1.get(0)).setRecent(true);
      }
      while (true)
      {
        ViewStepTotal localViewStepTotal = (ViewStepTotal)localArrayList1.get(0);
        Hashtable localHashtable1 = localViewStepTotal.getRouteIcons();
        if (localHashtable1 == null)
          return;
        if (localHashtable1.size() <= 0)
          return;
        MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity1 = MoreMyTripsDirectionActivity.this;
        ArrayList localArrayList2 = localViewStepTotal.getRouteLines();
        localMoreMyTripsDirectionActivity1._geoPoints = localArrayList2;
        Drawable localDrawable1 = MoreMyTripsDirectionActivity.this.getResources().getDrawable(2130837612);
        Drawable localDrawable2 = MoreMyTripsDirectionActivity.this.getResources().getDrawable(2130837613);
        Hashtable localHashtable2 = new Hashtable(localHashtable1);
        RouteIcons localRouteIcons1 = (RouteIcons)localHashtable2.remove("start");
        RouteIcons localRouteIcons2 = (RouteIcons)localHashtable2.remove("end");
        MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity2 = MoreMyTripsDirectionActivity.this;
        int i = localRouteIcons1.getLat();
        int j = localRouteIcons1.getLon();
        GeoPoint localGeoPoint1 = new GeoPoint(i, j);
        localMoreMyTripsDirectionActivity2._startPoint = localGeoPoint1;
        GeoPoint localGeoPoint2 = MoreMyTripsDirectionActivity.this._startPoint;
        OverlayItem localOverlayItem1 = new OverlayItem(localGeoPoint2, "Start", "");
        MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity3 = MoreMyTripsDirectionActivity.this;
        int k = localRouteIcons2.getLat();
        int m = localRouteIcons2.getLon();
        GeoPoint localGeoPoint3 = new GeoPoint(k, m);
        localMoreMyTripsDirectionActivity3._endPoint = localGeoPoint3;
        GeoPoint localGeoPoint4 = MoreMyTripsDirectionActivity.this._endPoint;
        OverlayItem localOverlayItem2 = new OverlayItem(localGeoPoint4, "End", "");
        MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity4 = MoreMyTripsDirectionActivity.this;
        MoreMyTripsDirectionActivity.InteractiveMapTask localInteractiveMapTask = new MoreMyTripsDirectionActivity.InteractiveMapTask(localMoreMyTripsDirectionActivity4, null);
        Hashtable[] arrayOfHashtable = new Hashtable[1];
        arrayOfHashtable[0] = localHashtable2;
        AsyncTask localAsyncTask = localInteractiveMapTask.execute(arrayOfHashtable);
        MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity5 = MoreMyTripsDirectionActivity.this;
        MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity6 = MoreMyTripsDirectionActivity.this;
        StartEndItemizedOverlay localStartEndItemizedOverlay1 = new StartEndItemizedOverlay(localDrawable2, localMoreMyTripsDirectionActivity6);
        localMoreMyTripsDirectionActivity5._bgItemizedOverlay = localStartEndItemizedOverlay1;
        GeoPoint localGeoPoint5 = MoreMyTripsDirectionActivity.this._startPoint;
        OverlayItem localOverlayItem3 = new OverlayItem(localGeoPoint5, null, null);
        GeoPoint localGeoPoint6 = MoreMyTripsDirectionActivity.this._endPoint;
        OverlayItem localOverlayItem4 = new OverlayItem(localGeoPoint6, null, null);
        MoreMyTripsDirectionActivity.this._bgItemizedOverlay.addOverlay(localOverlayItem3);
        MoreMyTripsDirectionActivity.this._bgItemizedOverlay.addOverlay(localOverlayItem4);
        MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity7 = MoreMyTripsDirectionActivity.this;
        StartEndItemizedOverlay localStartEndItemizedOverlay2 = new StartEndItemizedOverlay(localDrawable1);
        localMoreMyTripsDirectionActivity7._startOverlayPoint = localStartEndItemizedOverlay2;
        MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity8 = MoreMyTripsDirectionActivity.this;
        StartEndItemizedOverlay localStartEndItemizedOverlay3 = new StartEndItemizedOverlay(localDrawable2);
        localMoreMyTripsDirectionActivity8._endOverlayPoint = localStartEndItemizedOverlay3;
        MoreMyTripsDirectionActivity.this._startOverlayPoint.addOverlay(localOverlayItem1);
        MoreMyTripsDirectionActivity.this._endOverlayPoint.addOverlay(localOverlayItem2);
        return;
        Model localModel = ApplicationEngine.getModel();
        int n = MoreMyTripsDirectionActivity.this.index;
        localArrayList1 = localModel.getMyTrip(n);
      }
    }

    protected void onPreExecute()
    {
      super.onPreExecute();
      ListView localListView = (ListView)MoreMyTripsDirectionActivity.this.findViewById(2131492936);
      MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity1 = MoreMyTripsDirectionActivity.this;
      MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity2 = MoreMyTripsDirectionActivity.this;
      MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity3 = MoreMyTripsDirectionActivity.this;
      ArrayList localArrayList = new ArrayList();
      MoreMyTripsDirectionActivity.StepAdapter localStepAdapter1 = new MoreMyTripsDirectionActivity.StepAdapter(localMoreMyTripsDirectionActivity2, localMoreMyTripsDirectionActivity3, 2130903127, localArrayList);
      localMoreMyTripsDirectionActivity1.m_adapter = localStepAdapter1;
      View localView = MoreMyTripsDirectionActivity.this.getLayoutInflater().inflate(2130903057, null);
      localListView.addHeaderView(localView);
      MoreMyTripsDirectionActivity.StepAdapter localStepAdapter2 = MoreMyTripsDirectionActivity.this.m_adapter;
      localListView.setAdapter(localStepAdapter2);
    }

    protected void onProgressUpdate(Object[] paramArrayOfObject)
    {
      super.onProgressUpdate(paramArrayOfObject);
      ViewStep localViewStep = (ViewStep)paramArrayOfObject[0];
      if ((localViewStep instanceof ViewStepDirections))
      {
        if (paramArrayOfObject.length > 1)
        {
          LinearLayout localLinearLayout = (LinearLayout)MoreMyTripsDirectionActivity.this.findViewById(2131492988);
          ImageView localImageView = (ImageView)paramArrayOfObject[1];
          localLinearLayout.addView(localImageView);
        }
        MoreMyTripsDirectionActivity.this.m_adapter.add(localViewStep);
        MoreMyTripsDirectionActivity.this.m_adapter.notifyDataSetChanged();
        return;
      }
      if ((localViewStep instanceof ViewStepTotal))
      {
        ViewStepTotal localViewStepTotal = (ViewStepTotal)localViewStep;
        MoreMyTripsDirectionActivity.this.fillViewStepTotalData(localViewStepTotal);
        return;
      }
      if ((localViewStep instanceof ViewStepAddress))
      {
        ViewStepAddress localViewStepAddress = (ViewStepAddress)localViewStep;
        MoreMyTripsDirectionActivity.this.fillViewStepAddressData(localViewStepAddress);
        return;
      }
      if ((localViewStep instanceof WrappedImageViewLayout))
        return;
      MoreMyTripsDirectionActivity.this.m_adapter.add(localViewStep);
      MoreMyTripsDirectionActivity.this.m_adapter.notifyDataSetChanged();
    }
  }

  protected class SaveTripTask extends AsyncTask<String, Integer, String>
  {
    protected SaveTripTask()
    {
    }

    protected String doInBackground(String[] paramArrayOfString)
    {
      Model localModel = ApplicationEngine.getModel();
      String str = paramArrayOfString[0];
      int i = localModel.addMyTrip(str);
      return null;
    }

    protected void onPostExecute(String paramString)
    {
      Toast.makeText(MoreMyTripsDirectionActivity.this.getApplicationContext(), "Trip Saved", 0).show();
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

    public void add(ViewStep paramViewStep)
    {
      boolean bool = this._items.add(paramViewStep);
    }

    public boolean destroy()
    {
      Iterator localIterator;
      if (MoreMyTripsDirectionActivity.this.index != -1)
        localIterator = this._items.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
        {
          this._items.clear();
          this._items = null;
          return true;
        }
        ((ViewStep)localIterator.next()).recycle(false);
      }
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView1 = paramView;
      ArrayList localArrayList = this._items;
      int i = paramInt;
      ViewStep localViewStep = (ViewStep)localArrayList.get(i);
      MoreMyTripsDirectionActivity.ViewHolder localViewHolder;
      ViewStepDirections localViewStepDirections;
      View localView8;
      ImageView localImageView1;
      View localView11;
      LinearLayout.LayoutParams localLayoutParams1;
      label406: String[] arrayOfString;
      String str5;
      int i8;
      if (localView1 == null)
      {
        LayoutInflater localLayoutInflater1 = (LayoutInflater)MoreMyTripsDirectionActivity.this.getSystemService("layout_inflater");
        localViewHolder = new MoreMyTripsDirectionActivity.ViewHolder();
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
            break label1100;
          localViewStepDirections = (ViewStepDirections)localViewStep;
          localViewHolder.map.setVisibility(8);
          localViewHolder.reverse_new_search.setVisibility(8);
          localViewHolder.step.setVisibility(0);
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
          if (!localViewStepDirections.hasIcon())
            break label754;
          int i4 = 0;
          localImageView1.setVisibility(i4);
          int i5 = 0;
          localView11.setVisibility(i5);
          double d1 = localViewStepDirections.getIconWidth();
          float f1 = 0.0F * d1;
          double d2 = ApplicationEngine.DISPLAY_WIDTH;
          float f2 = (float)(f1 / d2) * 10.0F;
          localLayoutParams1.weight = f2;
          if (localViewStep.getBitmap() != null)
            break label735;
          if (localViewStep.isDownloading())
            break label725;
          LoadImageFromNetworkTask localLoadImageFromNetworkTask = new LoadImageFromNetworkTask();
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = localViewStepDirections;
          arrayOfObject1[1] = localImageView1;
          Object[] arrayOfObject2 = arrayOfObject1;
          AsyncTask localAsyncTask1 = localLoadImageFromNetworkTask.execute(arrayOfObject2);
          View localView13 = localView8;
          int i6 = 2131493058;
          TextView localTextView1 = (TextView)localView13.findViewById(i6);
          String str1 = localViewStepDirections.getStepTime();
          TextView localTextView2 = localTextView1;
          String str2 = str1;
          localTextView2.setText(str2);
          View localView14 = localView8;
          int i7 = 2131493056;
          TextView localTextView3 = (TextView)localView14.findViewById(i7);
          String str3 = localViewStepDirections.getDirections();
          localTextView3.setText(str3);
          if (localViewStepDirections.getOptionlVehicle() == null)
            break label1035;
          arrayOfString = localViewStepDirections.getOptionlVehicle();
          StringBuilder localStringBuilder1 = new StringBuilder("Other options: ");
          String str4 = arrayOfString[1];
          str5 = str4;
          i8 = 3;
          label529: int i9 = arrayOfString.length;
          if (i8 < i9)
            break label983;
          View localView15 = localView8;
          int i10 = 2131493057;
          TextView localTextView4 = (TextView)localView15.findViewById(i10);
          TextView localTextView5 = localTextView4;
          String str6 = str5;
          localTextView5.setText(str6);
          TextView localTextView6 = localTextView4;
          int i11 = 0;
          localTextView6.setVisibility(i11);
          label590: if ((!localViewStepDirections.hasDiversion()) || (localViewStepDirections.getDiversion() == null))
            break label1069;
          View localView16 = localView1;
          int i12 = 2131493246;
          View localView17 = localView16.findViewById(i12);
          int i13 = 0;
          localView17.setVisibility(i13);
          int i14 = 2131493247;
          ImageView localImageView2 = (ImageView)localView17.findViewById(i14);
          int i15 = 0;
          localImageView2.setVisibility(i15);
          int i16 = 2131492956;
          TextView localTextView7 = (TextView)localView17.findViewById(i16);
          int i17 = 0;
          localTextView7.setVisibility(i17);
          label685: double d3 = localLayoutParams1.weight;
          float f3 = (float)(7.5D - d3);
          localLayoutParams2.weight = f3;
        }
      }
      label725: label735: label754: 
      do
      {
        return localView1;
        localViewHolder = (MoreMyTripsDirectionActivity.ViewHolder)localView1.getTag();
        break;
        localViewStepDirections.setImageView(localImageView1);
        break label406;
        Bitmap localBitmap1 = localViewStep.getBitmap();
        localImageView1.setImageBitmap(localBitmap1);
        break label406;
        if (localViewStepDirections.isBikeFriendly())
        {
          if (localViewStepDirections.getBitmap() == null)
          {
            localViewStepDirections.setBikeAndNeedToSetWidth(true);
            Bitmap localBitmap2 = BitmapFactory.decodeResource(MoreMyTripsDirectionActivity.this.getResources(), 2130837522);
            localViewStepDirections.setBitmap(localBitmap2);
            localViewStepDirections.setHasIcon(true);
            int i18 = localViewStepDirections.getBitmap().getWidth();
            localViewStepDirections.setIconWidth(i18);
            int i19 = ApplicationEngine.DISPLAY_WIDTH;
            int i20 = localViewStepDirections.getBitmap().getWidth();
            float f4 = i19 - i20;
            float f5 = ApplicationEngine.DEVICE_DENSITY;
            float f6 = 70.0F + f5;
            int i21 = (int)(f4 - f6);
            localViewStepDirections.setDirectionViewStarts(i21);
          }
          int i22 = 2130837522;
          localImageView1.setImageResource(i22);
          int i23 = 0;
          localView11.setVisibility(i23);
          int i24 = 0;
          localImageView1.setVisibility(i24);
          double d4 = localViewStepDirections.getBitmap().getWidth();
          float f7 = 0.0F * d4;
          double d5 = ApplicationEngine.DISPLAY_WIDTH;
          float f8 = (float)(f7 / d5) * 10.0F;
          localLayoutParams1.weight = f8;
          break label406;
        }
        int i25 = 8;
        localImageView1.setVisibility(i25);
        int i26 = 8;
        localView11.setVisibility(i26);
        float f9 = 0.0F;
        localLayoutParams1.weight = f9;
        break label406;
        String str7 = String.valueOf(str5);
        StringBuilder localStringBuilder2 = new StringBuilder(str7).append(", ");
        String str8 = arrayOfString[i8];
        str5 = str8;
        i8 += 2;
        break label529;
        View localView18 = localView8;
        int i27 = 2131493057;
        TextView localTextView8 = (TextView)localView18.findViewById(i27);
        int i28 = 8;
        localTextView8.setVisibility(i28);
        break label590;
        View localView19 = localView1;
        int i29 = 2131493246;
        View localView20 = localView19.findViewById(i29);
        int i30 = 8;
        localView20.setVisibility(i30);
        break label685;
        if ((localViewStep instanceof ViewStepMap))
        {
          ViewStepMap localViewStepMap = (ViewStepMap)localViewStep;
          localViewHolder.step.setVisibility(8);
          localViewHolder.reverse_new_search.setVisibility(8);
          localViewHolder.map.setVisibility(0);
          View localView21 = localViewHolder.map;
          View localView22 = localView21;
          int i31 = 2131492939;
          ImageView localImageView3 = (ImageView)localView22.findViewById(i31);
          if (localViewStepMap.getBitmap() == null)
            if (!localViewStepMap.isDownloading())
            {
              MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity1 = MoreMyTripsDirectionActivity.this;
              MoreMyTripsDirectionActivity.LoadImageFromDBTask localLoadImageFromDBTask1 = new MoreMyTripsDirectionActivity.LoadImageFromDBTask(localMoreMyTripsDirectionActivity1);
              Object[] arrayOfObject3 = new Object[2];
              arrayOfObject3[0] = localViewStep;
              arrayOfObject3[1] = localImageView3;
              Object[] arrayOfObject4 = arrayOfObject3;
              AsyncTask localAsyncTask2 = localLoadImageFromDBTask1.execute(arrayOfObject4);
            }
          while (true)
          {
            View localView23 = localView21;
            int i32 = 2131492938;
            TextView localTextView9 = (TextView)localView23.findViewById(i32);
            String str9 = ((ViewStepMap)localViewStep).getDisplayInfo();
            TextView localTextView10 = localTextView9;
            String str10 = str9;
            localTextView10.setText(str10);
            break;
            localViewStepMap.setImageView(localImageView3);
            continue;
            if (localViewStepMap.getBitmap().isRecycled())
            {
              MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity2 = MoreMyTripsDirectionActivity.this;
              MoreMyTripsDirectionActivity.LoadImageFromDBTask localLoadImageFromDBTask2 = new MoreMyTripsDirectionActivity.LoadImageFromDBTask(localMoreMyTripsDirectionActivity2);
              Object[] arrayOfObject5 = new Object[2];
              arrayOfObject5[0] = localViewStep;
              arrayOfObject5[1] = localImageView3;
              Object[] arrayOfObject6 = arrayOfObject5;
              AsyncTask localAsyncTask3 = localLoadImageFromDBTask2.execute(arrayOfObject6);
            }
            else
            {
              Bitmap localBitmap3 = localViewStep.getBitmap();
              localImageView3.setImageBitmap(localBitmap3);
            }
          }
        }
      }
      while (!(localViewStep instanceof ViewStepReverseNewSearch));
      label983: localViewHolder.step.setVisibility(8);
      label1035: label1069: label1100: localViewHolder.map.setVisibility(8);
      localViewHolder.reverse_new_search.setVisibility(0);
      View localView24 = localViewHolder.reverse_new_search;
      View localView25 = localView24;
      int i33 = 2131493167;
      Button localButton1 = (Button)localView25.findViewById(i33);
      View.OnClickListener local11 = new com/hopstop/ClientView/MoreMyTripsDirectionActivity$StepAdapter$1;
      View.OnClickListener local12 = local11;
      StepAdapter localStepAdapter1 = this;
      int i34 = paramInt;
      local12.<init>(localStepAdapter1, i34);
      Button localButton2 = localButton1;
      View.OnClickListener local13 = local11;
      localButton2.setOnClickListener(local13);
      View localView26 = localView24;
      int i35 = 2131493168;
      Button localButton3 = (Button)localView26.findViewById(i35);
      if (MoreMyTripsDirectionActivity.this.isRecent)
      {
        Button localButton4 = localButton3;
        int i36 = 0;
        localButton4.setVisibility(i36);
        View localView27 = localView24;
        int i37 = 2131493172;
        TextView localTextView11 = (TextView)localView27.findViewById(i37);
        int i38 = 0;
        localTextView11.setVisibility(i38);
        View.OnClickListener local21 = new com/hopstop/ClientView/MoreMyTripsDirectionActivity$StepAdapter$2;
        View.OnClickListener local22 = local21;
        StepAdapter localStepAdapter2 = this;
        local22.<init>(localStepAdapter2);
        Button localButton5 = localButton3;
        View.OnClickListener local23 = local21;
        localButton5.setOnClickListener(local23);
      }
      while (true)
      {
        Button localButton6 = localButton3;
        int i39 = 8;
        localButton6.setVisibility(i39);
        View localView28 = localView24;
        int i40 = 2131493172;
        TextView localTextView12 = (TextView)localView28.findViewById(i40);
        int i41 = 8;
        localTextView12.setVisibility(i41);
        View localView29 = localView24;
        int i42 = 2131493073;
        Button localButton7 = (Button)localView29.findViewById(i42);
        View.OnClickListener local31 = new com/hopstop/ClientView/MoreMyTripsDirectionActivity$StepAdapter$3;
        View.OnClickListener local32 = local31;
        StepAdapter localStepAdapter3 = this;
        local32.<init>(localStepAdapter3);
        Button localButton8 = localButton7;
        View.OnClickListener local33 = local31;
        localButton8.setOnClickListener(local33);
        View localView30 = localView24;
        int i43 = 2131493169;
        View localView31 = localView30.findViewById(i43);
        View localView32 = localView31;
        int i44 = 0;
        localView32.setVisibility(i44);
        String str11 = ((TelephonyManager)MoreMyTripsDirectionActivity.this.getSystemService("phone")).getNetworkOperatorName();
        View.OnClickListener local41 = new com/hopstop/ClientView/MoreMyTripsDirectionActivity$StepAdapter$4;
        View.OnClickListener local42 = local41;
        StepAdapter localStepAdapter4 = this;
        local42.<init>(localStepAdapter4, str11);
        View localView33 = localView31;
        View.OnClickListener local43 = local41;
        localView33.setOnClickListener(local43);
        View localView34 = localView24;
        int i45 = 2131493170;
        TextView localTextView13 = (TextView)localView34.findViewById(i45);
        TextView localTextView14 = localTextView13;
        int i46 = 0;
        localTextView14.setVisibility(i46);
        MovementMethod localMovementMethod1 = LinkMovementMethod.getInstance();
        TextView localTextView15 = localTextView13;
        MovementMethod localMovementMethod2 = localMovementMethod1;
        localTextView15.setMovementMethod(localMovementMethod2);
        break;
        Button localButton9 = localButton3;
        int i47 = 8;
        localButton9.setVisibility(i47);
        View localView35 = localView24;
        int i48 = 2131493172;
        TextView localTextView16 = (TextView)localView35.findViewById(i48);
        int i49 = 8;
        localTextView16.setVisibility(i49);
      }
    }

    public void insert(ViewStep paramViewStep, int paramInt)
    {
      this._items.add(paramInt, paramViewStep);
    }
  }

  private class TaxiAdapter extends ArrayAdapter<ViewStep>
  {
    private ArrayList<ViewStep> items;

    public TaxiAdapter(int paramArrayList, ArrayList<ViewStep> arg3)
    {
      super(i, localList);
      this.items = localList;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView1 = paramView;
      ArrayList localArrayList = this.items;
      int i = paramInt;
      ViewStep localViewStep = (ViewStep)localArrayList.get(i);
      MoreMyTripsDirectionActivity.ViewTaxiHolder localViewTaxiHolder;
      TextView localTextView3;
      if (localView1 == null)
      {
        LayoutInflater localLayoutInflater1 = (LayoutInflater)MoreMyTripsDirectionActivity.this.getSystemService("layout_inflater");
        localViewTaxiHolder = new MoreMyTripsDirectionActivity.ViewTaxiHolder();
        LayoutInflater localLayoutInflater2 = localLayoutInflater1;
        int j = 2130903136;
        ViewGroup localViewGroup = null;
        localView1 = localLayoutInflater2.inflate(j, localViewGroup);
        View localView2 = localView1;
        int k = 2131492928;
        View localView3 = localView2.findViewById(k);
        localViewTaxiHolder.totalTime = localView3;
        View localView4 = localView1;
        int m = 2131492931;
        View localView5 = localView4.findViewById(m);
        localViewTaxiHolder.address = localView5;
        View localView6 = localView1;
        int n = 2131493222;
        View localView7 = localView6.findViewById(n);
        localViewTaxiHolder.taxi = localView7;
        View localView8 = localView1;
        int i1 = 2131493165;
        View localView9 = localView8.findViewById(i1);
        localViewTaxiHolder.reverse_new_search = localView9;
        localView1.setTag(localViewTaxiHolder);
        if (!(localViewStep instanceof ViewStepTaxi))
          break label401;
        localViewTaxiHolder.totalTime.setVisibility(8);
        localViewTaxiHolder.address.setVisibility(8);
        localViewTaxiHolder.taxi.setVisibility(0);
        localViewTaxiHolder.reverse_new_search.setVisibility(8);
        View localView10 = localViewTaxiHolder.taxi;
        int i2 = 2131493223;
        TextView localTextView1 = (TextView)localView10.findViewById(i2);
        String str1 = ((ViewStepTaxi)localViewStep).getName();
        localTextView1.setText(str1);
        int i3 = 2131493225;
        TextView localTextView2 = (TextView)localView10.findViewById(i3);
        String str2 = ((ViewStepTaxi)localViewStep).getPhone();
        localTextView2.setText(str2);
        int i4 = 2131493224;
        localTextView3 = (TextView)localView10.findViewById(i4);
        if (((ViewStepTaxi)localViewStep).getPrice() <= 0.0F)
          break label387;
        StringBuilder localStringBuilder = new StringBuilder("Price: $");
        String str3 = Util.roundMyDataTwoDecimal(((ViewStepTaxi)localViewStep).getPrice());
        String str4 = str3;
        localTextView3.setText(str4);
      }
      label387: label401: label583: 
      do
        while (true)
        {
          return localView1;
          localViewTaxiHolder = (MoreMyTripsDirectionActivity.ViewTaxiHolder)localView1.getTag();
          break;
          String str5 = "";
          localTextView3.setText(str5);
          continue;
          if ((localViewStep instanceof ViewStepAddress))
          {
            localViewTaxiHolder.totalTime.setVisibility(8);
            localViewTaxiHolder.address.setVisibility(0);
            localViewTaxiHolder.taxi.setVisibility(8);
            localViewTaxiHolder.reverse_new_search.setVisibility(8);
            View localView11 = localViewTaxiHolder.address;
            int i5 = 2131492933;
            TextView localTextView4 = (TextView)localView11.findViewById(i5);
            ViewStepAddress localViewStepAddress = (ViewStepAddress)localViewStep;
            String str6 = localViewStepAddress.getAddress();
            localTextView4.setText(str6);
            int i6 = 2131493054;
            ImageView localImageView = (ImageView)localView11.findViewById(i6);
            if (localViewStepAddress.isStart())
            {
              int i7 = 2130837612;
              localImageView.setImageResource(i7);
            }
            else
            {
              int i8 = 2130837613;
              localImageView.setImageResource(i8);
            }
          }
          else
          {
            if (!(localViewStep instanceof ViewStepTotal))
              break label583;
            MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity1 = MoreMyTripsDirectionActivity.this;
            ViewStepTotal localViewStepTotal1 = (ViewStepTotal)localViewStep;
            MoreMyTripsDirectionActivity localMoreMyTripsDirectionActivity2 = localMoreMyTripsDirectionActivity1;
            ViewStepTotal localViewStepTotal2 = localViewStepTotal1;
            localMoreMyTripsDirectionActivity2.fillViewStepTotalData(localViewStepTotal2);
          }
        }
      while (!(localViewStep instanceof ViewStepReverseNewSearch));
      localViewTaxiHolder.totalTime.setVisibility(8);
      localViewTaxiHolder.address.setVisibility(8);
      localViewTaxiHolder.taxi.setVisibility(8);
      localViewTaxiHolder.reverse_new_search.setVisibility(0);
      View localView12 = localViewTaxiHolder.reverse_new_search;
      int i9 = 2131493167;
      Button localButton1 = (Button)localView12.findViewById(i9);
      View.OnClickListener local11 = new com/hopstop/ClientView/MoreMyTripsDirectionActivity$TaxiAdapter$1;
      View.OnClickListener local12 = local11;
      TaxiAdapter localTaxiAdapter1 = this;
      int i10 = paramInt;
      local12.<init>(localTaxiAdapter1, i10);
      View.OnClickListener local13 = local11;
      localButton1.setOnClickListener(local13);
      int i11 = 2131493168;
      Button localButton2 = (Button)localView12.findViewById(i11);
      if (MoreMyTripsDirectionActivity.this.isRecent)
      {
        int i12 = 0;
        localButton2.setVisibility(i12);
        int i13 = 2131493172;
        TextView localTextView5 = (TextView)localView12.findViewById(i13);
        int i14 = 0;
        localTextView5.setVisibility(i14);
        View.OnClickListener local21 = new com/hopstop/ClientView/MoreMyTripsDirectionActivity$TaxiAdapter$2;
        View.OnClickListener local22 = local21;
        TaxiAdapter localTaxiAdapter2 = this;
        local22.<init>(localTaxiAdapter2);
        View.OnClickListener local23 = local21;
        localButton2.setOnClickListener(local23);
      }
      while (true)
      {
        int i15 = 2131493073;
        Button localButton3 = (Button)localView12.findViewById(i15);
        View.OnClickListener local31 = new com/hopstop/ClientView/MoreMyTripsDirectionActivity$TaxiAdapter$3;
        View.OnClickListener local32 = local31;
        TaxiAdapter localTaxiAdapter3 = this;
        local32.<init>(localTaxiAdapter3);
        View.OnClickListener local33 = local31;
        localButton3.setOnClickListener(local33);
        break;
        int i16 = 8;
        localButton2.setVisibility(i16);
        int i17 = 2131493172;
        TextView localTextView6 = (TextView)localView12.findViewById(i17);
        int i18 = 8;
        localTextView6.setVisibility(i18);
      }
    }
  }

  static class ViewHolder
  {
    public View map;
    public View reverse_new_search;
    public View step;
  }

  static class ViewTaxiHolder
  {
    public View address;
    public View reverse_new_search;
    public View taxi;
    public View totalTime;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.MoreMyTripsDirectionActivity
 * JD-Core Version:    0.6.2
 */