package com.hopstop.ClientView;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.androidquery.AQuery;
import com.androidquery.AbstractAQuery;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.OverlayItem;
import com.hopstop.ClientController.HSAsyncTask;
import com.hopstop.ClientModel.Geocode.GeocodeRequest;
import com.hopstop.ClientModel.Geocode.HopStopGeocodeResponse;
import com.hopstop.ClientModel.Geocode.Item;
import com.hopstop.ClientModel.Model;
import com.hopstop.ClientModel.NearbyStations.HopStopNearbyStationsResponse;
import com.hopstop.ClientModel.NearbyStations.IconLarge;
import com.hopstop.ClientModel.NearbyStations.NearbyStationsRequest;
import com.hopstop.ClientModel.NearbyStations.Station;
import com.hopstop.ClientModel.NearbyStations.Vehicle;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.network.NetworkEngine;
import com.hopstop.network.NetworkSettings;
import com.hopstop.network.URLFactoryBuilder;
import com.hopstop.ui.BaseMapActivity;
import com.hopstop.ui.MapComponents.HopStopCustomItemizedOverlay;
import com.hopstop.ui.MapComponents.TapControlledMapView;
import com.hopstop.util.Util;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.DisplayImageOptions.Builder;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration.Builder;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class NearbyStationsResultActivity extends BaseMapActivity
{
  public static final String ADDRESS_KEY = "address";
  public static final String API_INCLUDE_BUS_KEY = "includedInBus";
  public static final String API_INCLUDE_SUBWAY_KEY = "includedInSubway";
  public static final String API_STATION_NUM_KEY = "maxStations";
  public static final String CITY_KEY = "\tcity";
  public static final String COUNTY_KEY = "county";
  public static final String DISPLAY_ADDRESS_KEY = "displayAddress";
  public static final int INCLUDE_BUS_DEFAULT = 1;
  public static final String INCLUDE_BUS_KEY = "includedInBus";
  public static final int INCLUDE_SUBWAY_DEFAULT = 1;
  public static final String INCLUDE_SUBWAY_KEY = "includedInSubway";
  public static final int MAX_STATIONS_DEFAULT = 9;
  public static final String STATION_NUM_KEY = "maxStations";
  String address;
  AQuery aq;
  GeoPoint centerPoint;
  String city;
  String county;
  String displayAddress;
  Drawable drawable;
  private GeocodeCallAPITask geocodeTask;
  int includeBus;
  int includeSubway;
  private GeoPoint mapCenterReserve;
  private MapController mapController;
  private TapControlledMapView mapView;
  private int mapZoomLevelReserve;
  int maxStations;
  private NearbyStationsCallAPITask nearbyStationsTask;
  float screenDensity;
  private ArrayList<Station> stations;

  public void LoadScreen()
  {
    ArrayList localArrayList1 = new ArrayList();
    int i = 2147483647;
    int j = 2147483647;
    int k = -2147483648;
    int m = -2147483648;
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = this.stations.iterator();
    List localList;
    int i5;
    if (!localIterator.hasNext())
    {
      ArrayList localArrayList3 = this.stations;
      NearbyStationsResultActivity localNearbyStationsResultActivity1 = this;
      NearbyStationsResultActivity localNearbyStationsResultActivity2 = this;
      ArrayList localArrayList4 = localArrayList3;
      NearbyStationsListAdapter localNearbyStationsListAdapter = new NearbyStationsListAdapter(localNearbyStationsResultActivity2, localArrayList4);
      ((AQuery)this.aq.id(2131493123)).getListView().setAdapter(localNearbyStationsListAdapter);
      ListView localListView = ((AQuery)this.aq.id(2131493123)).getListView();
      AdapterView.OnItemClickListener local31 = new com/hopstop/ClientView/NearbyStationsResultActivity$3;
      AdapterView.OnItemClickListener local32 = local31;
      NearbyStationsResultActivity localNearbyStationsResultActivity3 = this;
      local32.<init>(localNearbyStationsResultActivity3);
      localListView.setOnItemClickListener(local31);
      showMap();
      localList = this.mapView.getOverlays();
      localList.clear();
      int n = (k + i) / 2;
      int i1 = (m + j) / 2;
      int i2 = n;
      int i3 = i1;
      GeoPoint localGeoPoint1 = new GeoPoint(i2, i3);
      int i4 = this.mapController.setZoom(18);
      this.mapController.animateTo(localGeoPoint1);
      i5 = 0;
    }
    while (true)
    {
      int i6 = this.stations.size();
      if (i5 >= i6)
      {
        Drawable localDrawable1 = getResources().getDrawable(2130837569);
        NearbyStationsResultActivity localNearbyStationsResultActivity4 = this;
        HopStopCustomItemizedOverlay localHopStopCustomItemizedOverlay = new HopStopCustomItemizedOverlay(localDrawable1, localNearbyStationsResultActivity4);
        GeoPoint localGeoPoint2 = this.centerPoint;
        String str1 = this.displayAddress;
        String str2 = this.displayAddress;
        OverlayItem localOverlayItem = new OverlayItem(localGeoPoint2, str1, str2);
        localHopStopCustomItemizedOverlay.addOverlay(localOverlayItem);
        boolean bool1 = localList.add(localHopStopCustomItemizedOverlay);
        return;
        Station localStation1 = (Station)localIterator.next();
        String str3 = localStation1.getLocation();
        ArrayList localArrayList5 = localArrayList1;
        String str4 = str3;
        boolean bool2 = localArrayList5.add(str4);
        int i7 = Math.round((float)(localStation1.getY() * 0.0F));
        int i8 = Math.round((float)(localStation1.getX() * 0.0F));
        GeoPoint localGeoPoint3 = new com/google/android/maps/GeoPoint;
        localGeoPoint3.<init>(i7, i8);
        ArrayList localArrayList6 = localArrayList2;
        GeoPoint localGeoPoint4 = localGeoPoint3;
        boolean bool3 = localArrayList6.add(localGeoPoint4);
        int i9 = i;
        i = Math.min(i7, i9);
        int i10 = j;
        j = Math.min(i8, i10);
        k = Math.max(i7, k);
        int i11 = m;
        m = Math.max(i8, i11);
        break;
      }
      Drawable localDrawable2 = createFromView(i5);
      TapControlledMapView localTapControlledMapView = this.mapView;
      SimpleItemizedOverlay localSimpleItemizedOverlay = new SimpleItemizedOverlay(localDrawable2, localTapControlledMapView);
      Station localStation2 = (Station)this.stations.get(i5);
      NearbyStationsOverlayItem localNearbyStationsOverlayItem1 = new com/hopstop/ClientView/NearbyStationsOverlayItem;
      GeoPoint localGeoPoint5 = (GeoPoint)localArrayList2.get(i5);
      String str5 = localStation2.getVehicleListString();
      String str6 = localStation2.getLocation();
      NearbyStationsOverlayItem localNearbyStationsOverlayItem2 = localNearbyStationsOverlayItem1;
      GeoPoint localGeoPoint6 = localGeoPoint5;
      String str7 = str5;
      String str8 = str6;
      Station localStation3 = localStation2;
      localNearbyStationsOverlayItem2.<init>(localGeoPoint6, str7, str8, localStation3);
      NearbyStationsOverlayItem localNearbyStationsOverlayItem3 = localNearbyStationsOverlayItem1;
      localSimpleItemizedOverlay.addOverlay(localNearbyStationsOverlayItem3);
      boolean bool4 = localList.add(localSimpleItemizedOverlay);
      i5 += 1;
    }
  }

  public Drawable createFromView(int paramInt)
  {
    TextView localTextView = (TextView)((LayoutInflater)getSystemService("layout_inflater")).inflate(2130903049, null, false).findViewById(2131492895);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramInt + 1;
    String str = i;
    localTextView.setText(str);
    localTextView.setDrawingCacheEnabled(true);
    float f1 = this.screenDensity;
    int j = (int)(25.0F * f1);
    float f2 = this.screenDensity;
    int k = (int)(40.0F * f2);
    localTextView.layout(0, 0, j, k);
    localTextView.buildDrawingCache();
    Bitmap localBitmap1 = Bitmap.createBitmap(localTextView.getDrawingCache());
    localBitmap1.setDensity(160);
    Bitmap localBitmap2 = Bitmap.createScaledBitmap(localBitmap1, j, k, false);
    localTextView.setDrawingCacheEnabled(false);
    return new BitmapDrawable(localBitmap2);
  }

  public void getNearbyStations(Item paramItem)
  {
    String str1 = paramItem.getY();
    String str2 = paramItem.getX();
    int i = this.includeSubway;
    int j = this.includeBus;
    int k = this.maxStations;
    NearbyStationsRequest localNearbyStationsRequest = new NearbyStationsRequest(str1, str2, i, j, k);
    NearbyStationsCallAPITask localNearbyStationsCallAPITask1 = new NearbyStationsCallAPITask(null);
    this.nearbyStationsTask = localNearbyStationsCallAPITask1;
    NearbyStationsCallAPITask localNearbyStationsCallAPITask2 = this.nearbyStationsTask;
    NearbyStationsRequest[] arrayOfNearbyStationsRequest = new NearbyStationsRequest[1];
    arrayOfNearbyStationsRequest[0] = localNearbyStationsRequest;
    AsyncTask localAsyncTask = localNearbyStationsCallAPITask2.execute(arrayOfNearbyStationsRequest);
  }

  protected boolean isRouteDisplayed()
  {
    return false;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903096);
    AQuery localAQuery = new AQuery(this);
    this.aq = localAQuery;
    String str1 = getIntent().getStringExtra("address");
    this.address = str1;
    String str2 = getIntent().getStringExtra("displayAddress");
    this.displayAddress = str2;
    String str3 = getIntent().getStringExtra("\tcity");
    this.city = str3;
    String str4 = getIntent().getStringExtra("county");
    this.county = str4;
    int i = getIntent().getIntExtra("includedInSubway", 1);
    this.includeSubway = i;
    int j = getIntent().getIntExtra("includedInBus", 1);
    this.includeBus = j;
    int k = getIntent().getIntExtra("maxStations", 9);
    this.maxStations = k;
    String str5 = this.address;
    String str6 = this.city;
    String str7 = this.county;
    GeocodeRequest localGeocodeRequest = new GeocodeRequest(str5, str6, str7, null);
    GeocodeCallAPITask localGeocodeCallAPITask1 = new GeocodeCallAPITask(null);
    this.geocodeTask = localGeocodeCallAPITask1;
    GeocodeCallAPITask localGeocodeCallAPITask2 = this.geocodeTask;
    GeocodeRequest[] arrayOfGeocodeRequest = new GeocodeRequest[1];
    arrayOfGeocodeRequest[0] = localGeocodeRequest;
    AsyncTask localAsyncTask = localGeocodeCallAPITask2.execute(arrayOfGeocodeRequest);
    DisplayImageOptions localDisplayImageOptions = new DisplayImageOptions.Builder().cacheInMemory().cacheOnDisc().build();
    Context localContext = getApplicationContext();
    ImageLoaderConfiguration localImageLoaderConfiguration = new ImageLoaderConfiguration.Builder(localContext).defaultDisplayImageOptions(localDisplayImageOptions).build();
    ImageLoader.getInstance().init(localImageLoaderConfiguration);
    TapControlledMapView localTapControlledMapView = (TapControlledMapView)findViewById(2131493125);
    if (localTapControlledMapView != null)
    {
      this.mapView = localTapControlledMapView;
      this.mapView.setBuiltInZoomControls(true);
      MapController localMapController = this.mapView.getController();
      this.mapController = localMapController;
    }
    Drawable localDrawable = getResources().getDrawable(2130837612);
    this.drawable = localDrawable;
    String str8 = this.address;
    String str9 = this.city;
    int m = this.includeSubway;
    int n = this.includeBus;
    int i1 = this.maxStations;
    NearbyStationsRequest localNearbyStationsRequest = new NearbyStationsRequest(str8, str9, m, n, i1);
    AbstractAQuery localAbstractAQuery1 = ((AQuery)this.aq.id(2131493117)).clicked(this, "showMap");
    AbstractAQuery localAbstractAQuery2 = ((AQuery)this.aq.id(2131493118)).clicked(this, "showList");
    Hashtable localHashtable = new Hashtable();
    String str10 = ApplicationEngine.getModel().getDefaultCityId();
    Object localObject = localHashtable.put("defaultcity", str10);
    int i2 = ApplicationEngine.ZONE_STREET_MAP_RESULTS;
    update(i2, localHashtable, null, null);
    trackEvent("Stations Result Screen");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    float f = localDisplayMetrics.density;
    this.screenDensity = f;
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.nearbyStationsTask != null) && (!this.nearbyStationsTask.isCancelled()))
      boolean bool1 = this.nearbyStationsTask.cancel(true);
    if (this.geocodeTask == null)
      return;
    if (this.geocodeTask.isCancelled())
      return;
    boolean bool2 = this.geocodeTask.cancel(true);
  }

  protected void onPause()
  {
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

  public void pre_show()
  {
    AbstractAQuery localAbstractAQuery1 = ((AQuery)this.aq.id(2131493120)).visible();
    AbstractAQuery localAbstractAQuery2 = ((AQuery)this.aq.id(2131493119)).gone();
  }

  public void showError(String paramString)
  {
    pre_show();
    AbstractAQuery localAbstractAQuery1 = ((AQuery)this.aq.id(2131493124)).gone();
    AbstractAQuery localAbstractAQuery2 = ((AQuery)this.aq.id(2131493122)).gone();
    AbstractAQuery localAbstractAQuery3 = ((AQuery)this.aq.id(2131493121)).visible();
    AbstractAQuery localAbstractAQuery4 = ((AQuery)this.aq.id(2131493121)).text(paramString);
  }

  public void showList()
  {
    pre_show();
    AbstractAQuery localAbstractAQuery1 = ((AQuery)this.aq.id(2131493124)).gone();
    AbstractAQuery localAbstractAQuery2 = ((AQuery)this.aq.id(2131493122)).visible();
    AbstractAQuery localAbstractAQuery3 = ((AQuery)this.aq.id(2131493121)).gone();
  }

  public void showMap()
  {
    pre_show();
    AbstractAQuery localAbstractAQuery1 = ((AQuery)this.aq.id(2131493124)).visible();
    AbstractAQuery localAbstractAQuery2 = ((AQuery)this.aq.id(2131493122)).gone();
    AbstractAQuery localAbstractAQuery3 = ((AQuery)this.aq.id(2131493121)).gone();
  }

  public void showMultiplePoints(final HopStopGeocodeResponse paramHopStopGeocodeResponse)
  {
    CharSequence[] arrayOfCharSequence = new CharSequence[paramHopStopGeocodeResponse.getItemCount()];
    int i = 0;
    while (true)
    {
      int j = paramHopStopGeocodeResponse.getItemCount();
      if (i >= j)
      {
        AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(this);
        DialogInterface.OnClickListener local1 = new DialogInterface.OnClickListener()
        {
          public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            NearbyStationsResultActivity localNearbyStationsResultActivity = NearbyStationsResultActivity.this;
            Item localItem = (Item)paramHopStopGeocodeResponse.getPoints().get(paramAnonymousInt);
            localNearbyStationsResultActivity.getNearbyStations(localItem);
            paramAnonymousDialogInterface.dismiss();
          }
        };
        AlertDialog.Builder localBuilder2 = localBuilder1.setSingleChoiceItems(arrayOfCharSequence, -1, local1);
        DialogInterface.OnCancelListener local2 = new DialogInterface.OnCancelListener()
        {
          public void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            NearbyStationsResultActivity.this.finish();
          }
        };
        localBuilder2.setOnCancelListener(local2).setTitle("Multiple Points Found").create().show();
        return;
      }
      String str = ((Item)paramHopStopGeocodeResponse.getPoints().get(i)).getTitle();
      arrayOfCharSequence[i] = str;
      i += 1;
    }
  }

  private class GeocodeCallAPITask extends HSAsyncTask<GeocodeRequest, Void, HopStopGeocodeResponse>
  {
    private GeocodeCallAPITask()
    {
    }

    protected HopStopGeocodeResponse doInBackground(GeocodeRequest[] paramArrayOfGeocodeRequest)
    {
      HopStopGeocodeResponse localHopStopGeocodeResponse = new HopStopGeocodeResponse();
      GeocodeRequest localGeocodeRequest = paramArrayOfGeocodeRequest[0];
      try
      {
        String str1 = localGeocodeRequest.getGeocodeRequestURL();
        String str2 = NetworkSettings.keyNewAPI;
        String str3 = URLFactoryBuilder.GetGeocodeRequest(str1, str2);
        String str4 = ApplicationEngine.getNetworkEngine().retrieve(str3);
        if (str4 != null)
        {
          Persister localPersister = new Persister();
          StringReader localStringReader = new StringReader(str4);
          localHopStopGeocodeResponse = (HopStopGeocodeResponse)localPersister.read(HopStopGeocodeResponse.class, localStringReader, false);
        }
        return localHopStopGeocodeResponse;
      }
      catch (IOException localIOException)
      {
        while (true)
        {
          String str5 = NearbyStationsResultActivity.this.getString(2130968800);
          Error(localIOException, str5);
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          String str6 = NearbyStationsResultActivity.this.getString(2130968801);
          Error(localException, str6);
        }
      }
    }

    protected void onPostExecute(HopStopGeocodeResponse paramHopStopGeocodeResponse)
    {
      if (hasError())
      {
        NearbyStationsResultActivity localNearbyStationsResultActivity1 = NearbyStationsResultActivity.this;
        String str1 = getErrorString();
        localNearbyStationsResultActivity1.showError(str1);
        return;
      }
      if (paramHopStopGeocodeResponse == null)
      {
        NearbyStationsResultActivity localNearbyStationsResultActivity2 = NearbyStationsResultActivity.this;
        String str2 = NearbyStationsResultActivity.this.getString(2130968802);
        localNearbyStationsResultActivity2.showError(str2);
        return;
      }
      if (!paramHopStopGeocodeResponse.getResponseStatus().getResultCode().equals("200"))
      {
        NearbyStationsResultActivity localNearbyStationsResultActivity3 = NearbyStationsResultActivity.this;
        String str3 = paramHopStopGeocodeResponse.getResponseStatus().getFaultString();
        localNearbyStationsResultActivity3.showError(str3);
        return;
      }
      if (paramHopStopGeocodeResponse.getItemCount() > 1)
      {
        NearbyStationsResultActivity.this.showMultiplePoints(paramHopStopGeocodeResponse);
        return;
      }
      if (paramHopStopGeocodeResponse.getItemCount() < 1)
      {
        NearbyStationsResultActivity.this.showError("Cannot find the address you specified, please check address and try again.");
        return;
      }
      NearbyStationsResultActivity localNearbyStationsResultActivity4 = NearbyStationsResultActivity.this;
      Item localItem = (Item)paramHopStopGeocodeResponse.getPoints().get(0);
      localNearbyStationsResultActivity4.getNearbyStations(localItem);
    }

    protected void onPreExecute()
    {
    }

    protected void onProgressUpdate(Void[] paramArrayOfVoid)
    {
    }
  }

  static class ListViewItemHolder
  {
    public TextView distance;
    public LinearLayout icons;
    public TextView index;
    public TextView location;
  }

  private class NearbyStationsCallAPITask extends HSAsyncTask<NearbyStationsRequest, Void, HopStopNearbyStationsResponse>
  {
    private NearbyStationsCallAPITask()
    {
    }

    protected HopStopNearbyStationsResponse doInBackground(NearbyStationsRequest[] paramArrayOfNearbyStationsRequest)
    {
      HopStopNearbyStationsResponse localHopStopNearbyStationsResponse = new HopStopNearbyStationsResponse();
      NearbyStationsRequest localNearbyStationsRequest = paramArrayOfNearbyStationsRequest[0];
      try
      {
        String str1 = localNearbyStationsRequest.getNearbyRequestURL();
        String str2 = NetworkSettings.keyNewAPI;
        String str3 = URLFactoryBuilder.GetNearbyStationsRequest(str1, str2);
        String str4 = ApplicationEngine.getNetworkEngine().retrieve(str3);
        if (str4 != null)
        {
          Persister localPersister = new Persister();
          StringReader localStringReader = new StringReader(str4);
          localHopStopNearbyStationsResponse = (HopStopNearbyStationsResponse)localPersister.read(HopStopNearbyStationsResponse.class, localStringReader, false);
        }
        return localHopStopNearbyStationsResponse;
      }
      catch (IOException localIOException)
      {
        while (true)
        {
          String str5 = NearbyStationsResultActivity.this.getString(2130968800);
          Error(localIOException, str5);
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          String str6 = NearbyStationsResultActivity.this.getString(2130968801);
          Error(localException, str6);
        }
      }
    }

    protected void onPostExecute(HopStopNearbyStationsResponse paramHopStopNearbyStationsResponse)
    {
      if (hasError())
      {
        NearbyStationsResultActivity localNearbyStationsResultActivity1 = NearbyStationsResultActivity.this;
        String str1 = getErrorString();
        localNearbyStationsResultActivity1.showError(str1);
        return;
      }
      if (paramHopStopNearbyStationsResponse == null)
      {
        NearbyStationsResultActivity localNearbyStationsResultActivity2 = NearbyStationsResultActivity.this;
        String str2 = NearbyStationsResultActivity.this.getString(2130968802);
        localNearbyStationsResultActivity2.showError(str2);
        return;
      }
      if (!paramHopStopNearbyStationsResponse.getResponseStatus().getResultCode().equals("200"))
      {
        NearbyStationsResultActivity localNearbyStationsResultActivity3 = NearbyStationsResultActivity.this;
        String str3 = paramHopStopNearbyStationsResponse.getResponseStatus().getFaultString();
        localNearbyStationsResultActivity3.showError(str3);
        return;
      }
      if (paramHopStopNearbyStationsResponse.getStationCount() < 1)
      {
        NearbyStationsResultActivity.this.showError("No stations were found around the address specified.");
        return;
      }
      NearbyStationsResultActivity localNearbyStationsResultActivity4 = NearbyStationsResultActivity.this;
      ArrayList localArrayList = paramHopStopNearbyStationsResponse.getStations();
      localNearbyStationsResultActivity4.stations = localArrayList;
      NearbyStationsResultActivity localNearbyStationsResultActivity5 = NearbyStationsResultActivity.this;
      int i = Math.round((float)(paramHopStopNearbyStationsResponse.getY() * 1000000.0D));
      int j = Math.round((float)(paramHopStopNearbyStationsResponse.getX() * 1000000.0D));
      GeoPoint localGeoPoint = new GeoPoint(i, j);
      localNearbyStationsResultActivity5.centerPoint = localGeoPoint;
      NearbyStationsResultActivity.this.LoadScreen();
    }

    protected void onPreExecute()
    {
    }

    protected void onProgressUpdate(Void[] paramArrayOfVoid)
    {
    }
  }

  public class NearbyStationsListAdapter extends ArrayAdapter<Station>
  {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Station> rows;

    public NearbyStationsListAdapter(ArrayList<Station> arg2)
    {
      super(2130903097, localList);
      this.rows = localList;
      this.context = localContext;
      LayoutInflater localLayoutInflater = (LayoutInflater)localContext.getSystemService("layout_inflater");
      this.inflater = localLayoutInflater;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      NearbyStationsResultActivity.ListViewItemHolder localListViewItemHolder;
      Iterator localIterator;
      if (paramView == null)
      {
        paramView = this.inflater.inflate(2130903097, null);
        localListViewItemHolder = new NearbyStationsResultActivity.ListViewItemHolder();
        TextView localTextView1 = (TextView)paramView.findViewById(2131493128);
        localListViewItemHolder.location = localTextView1;
        LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131493129);
        localListViewItemHolder.icons = localLinearLayout;
        TextView localTextView2 = (TextView)paramView.findViewById(2131493130);
        localListViewItemHolder.distance = localTextView2;
        TextView localTextView3 = (TextView)paramView.findViewById(2131493127);
        localListViewItemHolder.index = localTextView3;
        paramView.setTag(localListViewItemHolder);
        TextView localTextView4 = localListViewItemHolder.index;
        String str1 = String.valueOf(paramInt + 1);
        String str2 = str1 + ".";
        localTextView4.setText(str2);
        TextView localTextView5 = localListViewItemHolder.location;
        String str3 = ((Station)this.rows.get(paramInt)).getLocation();
        localTextView5.setText(str3);
        localListViewItemHolder.icons.removeAllViews();
        localIterator = ((Station)this.rows.get(paramInt)).getVehicles().iterator();
      }
      while (true)
      {
        if (!localIterator.hasNext())
        {
          TextView localTextView6 = localListViewItemHolder.distance;
          boolean bool = ApplicationEngine.getModel().getIsMiles();
          float f = ((Station)this.rows.get(paramInt)).getWalkingDistance();
          String str4 = String.valueOf(Util.getDistance(bool, f));
          StringBuilder localStringBuilder = new StringBuilder(str4).append(" / ");
          String str5 = Util.getTimeStringFromSeconds(((Station)this.rows.get(paramInt)).getWalkingTime());
          String str6 = str5;
          localTextView6.setText(str6);
          return paramView;
          localListViewItemHolder = (NearbyStationsResultActivity.ListViewItemHolder)paramView.getTag();
          break;
        }
        Vehicle localVehicle = (Vehicle)localIterator.next();
        Context localContext = this.context;
        ImageView localImageView = new ImageView(localContext);
        localImageView.setPadding(0, 0, 5, 0);
        localListViewItemHolder.icons.addView(localImageView);
        ImageLoader localImageLoader = ImageLoader.getInstance();
        String str7 = localVehicle.getIconLarge().getURL();
        localImageLoader.displayImage(str7, localImageView);
      }
    }

    public boolean isEnabled(int paramInt)
    {
      return false;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.NearbyStationsResultActivity
 * JD-Core Version:    0.6.2
 */