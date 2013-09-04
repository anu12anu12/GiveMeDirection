package com.hopstop.ClientController;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.os.AsyncTask;
import com.crashlytics.android.Crashlytics;
import com.hopstop.ClientModel.Address;
import com.hopstop.ClientModel.DirectionRequest;
import com.hopstop.ClientModel.DirectionResponse;
import com.hopstop.ClientModel.LonLonToCityResponse;
import com.hopstop.ClientModel.MapRequest;
import com.hopstop.ClientModel.MapResponse;
import com.hopstop.ClientModel.MapUpdateRequest;
import com.hopstop.ClientModel.Model;
import com.hopstop.ClientModel.ResponseStatus;
import com.hopstop.ClientModel.ServiceAdvisorResponse;
import com.hopstop.ClientModel.TaxiResponse;
import com.hopstop.ClientModel.Yext.Listing;
import com.hopstop.ClientModel.Yext.YextListings;
import com.hopstop.ClientModel.db.HistoryManager;
import com.hopstop.ClientModel.directions.RouteInfo;
import com.hopstop.ClientModel.directions.ViewStep;
import com.hopstop.ClientModel.directions.ViewStepAddress;
import com.hopstop.ClientModel.directions.ViewStepDirections;
import com.hopstop.ClientModel.directions.ViewStepReverseNewSearch;
import com.hopstop.ClientModel.directions.ViewStepTaxi;
import com.hopstop.ClientModel.directions.ViewStepTotal;
import com.hopstop.ClientModel.xml.GetCountImpressionsHandler;
import com.hopstop.ClientModel.xml.GetLonLanToCityRequestHandler;
import com.hopstop.ClientModel.xml.GetMapHandler;
import com.hopstop.ClientModel.xml.GetServiceAdvisorHandler;
import com.hopstop.ClientModel.xml.GetTaxisHandler;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.core.ApplicationEngine.UiCallBack;
import com.hopstop.gps.GPSEngine;
import com.hopstop.gps.GPSFixRequest;
import com.hopstop.gps.GPSSettings;
import com.hopstop.gps.GpsObserver;
import com.hopstop.network.DrawableManager;
import com.hopstop.network.NetworkEngine;
import com.hopstop.network.NetworkSettings;
import com.hopstop.network.URLFactoryBuilder;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class Controller
{
  private ArrayList<GPSFixRequest> _requests;
  private GPSEngine engine;
  private int fixNumber;
  private Model model;

  public Controller(Model paramModel)
  {
    ArrayList localArrayList = new ArrayList();
    this._requests = localArrayList;
    this.fixNumber = 0;
    this.model = paramModel;
  }

  private void GetCityFromLonLan(int paramInt, Object[] paramArrayOfObject, ApplicationEngine.UiCallBack paramUiCallBack)
  {
    Activity localActivity = (Activity)paramArrayOfObject[0];
    Location localLocation = (Location)paramArrayOfObject[1];
    NetworkEngine localNetworkEngine = ApplicationEngine.getNetworkEngine();
    int i = NetworkSettings.GET_LONLAN_TO_CITY;
    String str1 = NetworkSettings.keyNewAPI;
    String str2 = URLFactoryBuilder.GetLonLanToCityURL(localLocation, str1);
    GetLonLanToCityRequestHandler localGetLonLanToCityRequestHandler = (GetLonLanToCityRequestHandler)localNetworkEngine.getSynchronousExecute(localActivity, i, str2);
    if (localGetLonLanToCityRequestHandler == null)
      return;
    int j = localGetLonLanToCityRequestHandler.getLonLonToCityResponse().getResultCode();
    int k = NetworkSettings.SUCCESS_GET_LONLAN_TO_CITY;
    if ((j != k) && (localGetLonLanToCityRequestHandler.getLonLonToCityResponse().getCity() != null))
    {
      LonLonToCityResponse localLonLonToCityResponse = localGetLonLanToCityRequestHandler.getLonLonToCityResponse();
      String str3 = localLonLonToCityResponse.getCity();
      paramArrayOfObject[0] = str3;
      Integer localInteger = Integer.valueOf(localLonLonToCityResponse.getCityId());
      paramArrayOfObject[1] = localInteger;
      int m = NetworkSettings.SUCCESS_GET_LONLAN_TO_CITY;
      paramUiCallBack.onStatusChanged(paramInt, m, paramArrayOfObject);
      return;
    }
    paramUiCallBack.onStatusChanged(paramInt, 199, paramArrayOfObject);
  }

  private void GetCountImpression(int paramInt, Object[] paramArrayOfObject, ApplicationEngine.UiCallBack paramUiCallBack)
  {
    Activity localActivity = (Activity)paramArrayOfObject[0];
    String str1 = (String)paramArrayOfObject[1];
    NetworkEngine localNetworkEngine = ApplicationEngine.getNetworkEngine();
    int i = NetworkSettings.GET_COUNT_IMPRESSION;
    String str2 = URLFactoryBuilder.GetCountImpressionURL(str1);
    if ((GetCountImpressionsHandler)localNetworkEngine.getSynchronousExecute(localActivity, i, str2) != null);
  }

  private void GetDirections(int paramInt, Object[] paramArrayOfObject, ApplicationEngine.UiCallBack paramUiCallBack, String paramString)
    throws OutOfMemoryError, IOException
  {
    DirectionResponse localDirectionResponse1 = null;
    ApplicationEngine.getDrawableManager().clearHashMap();
    try
    {
      Crashlytics.log(paramString);
      NetworkEngine localNetworkEngine = ApplicationEngine.getNetworkEngine();
      String str1 = paramString;
      String str2 = localNetworkEngine.retrieve(str1);
      if (str2 != null)
      {
        Persister localPersister = new Persister();
        StringReader localStringReader = new StringReader(str2);
        localDirectionResponse1 = (DirectionResponse)localPersister.read(DirectionResponse.class, localStringReader, false);
      }
      label74: if (localDirectionResponse1 == null)
      {
        int i = NetworkSettings.UNKNOWN_ERROR;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = "An error has occurred, please try again.";
        paramUiCallBack.onStatusChanged(paramInt, i, arrayOfObject1);
        return;
      }
    }
    catch (IOException localIOException)
    {
      int j = NetworkSettings.NETWORK_ERROR;
      paramUiCallBack.onStatusChanged(paramInt, j, null);
      return;
      int k = localDirectionResponse1.getResponseStatus().getResultCode();
      int m = NetworkSettings.SUCCESS_GET_ROUTE;
      if (k != m)
      {
        DirectionResponse localDirectionResponse2 = localDirectionResponse1;
        ApplicationEngine.getModel().addTrip(0, localDirectionResponse2);
        if ((localDirectionResponse2.getMode() != null) && (localDirectionResponse2.getMode().equals("j")))
        {
          String str3 = paramString;
          taxiCallBack(paramInt, paramUiCallBack, str3, localDirectionResponse2);
          return;
        }
        int n = NetworkSettings.SUCCESS_GET_ROUTE;
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = localDirectionResponse2;
        arrayOfObject2[1] = paramString;
        paramUiCallBack.onStatusChanged(paramInt, n, arrayOfObject2);
        if (localDirectionResponse2.isSmartRoute())
          return;
        SaveRecentTrip(0, null, null);
        return;
      }
      int i1 = localDirectionResponse1.getResponseStatus().getResultCode();
      int i2 = NetworkSettings.SEVERAL_CHOICES_FOUND;
      if (i1 != i2)
      {
        Object[] arrayOfObject3 = new Object[4];
        if ((localDirectionResponse1.getFirstExtraAddresses().size() >= 1) && ((localDirectionResponse1.getRouteInfo().getAddress1FoundExact() == 0) || (localDirectionResponse1.getRouteInfo().getAddress1OneLocation() == 0)))
        {
          ArrayList localArrayList1 = localDirectionResponse1.getFirstExtraAddresses();
          arrayOfObject3[0] = localArrayList1;
          arrayOfObject3[2] = null;
          if ((localDirectionResponse1.getSecondExtraAddresses().size() < 1) || ((localDirectionResponse1.getRouteInfo().getAddress2FoundExact() != 0) && (localDirectionResponse1.getRouteInfo().getAddress2OneLocation() != 0)))
            break label428;
          ArrayList localArrayList2 = localDirectionResponse1.getSecondExtraAddresses();
          arrayOfObject3[1] = localArrayList2;
          arrayOfObject3[3] = null;
        }
        while (true)
        {
          int i3 = NetworkSettings.SEVERAL_CHOICES_FOUND;
          paramUiCallBack.onStatusChanged(paramInt, i3, arrayOfObject3);
          return;
          arrayOfObject3[0] = null;
          String str4 = ((Address)localDirectionResponse1.getFirstExtraAddresses().get(0)).getThumbnailId();
          arrayOfObject3[2] = str4;
          break;
          arrayOfObject3[1] = null;
          String str5 = ((Address)localDirectionResponse1.getSecondExtraAddresses().get(0)).getThumbnailId();
          arrayOfObject3[3] = str5;
        }
      }
      int i4 = localDirectionResponse1.getResponseStatus().getResultCode();
      int i5 = NetworkSettings.ADDRESS_NOT_FOUND;
      if (i4 != i5)
      {
        int i6 = NetworkSettings.ADDRESS_NOT_FOUND;
        Object[] arrayOfObject4 = new Object[1];
        String str6 = localDirectionResponse1.getResponseStatus().getErrorString();
        arrayOfObject4[0] = str6;
        paramUiCallBack.onStatusChanged(paramInt, i6, arrayOfObject4);
        return;
      }
      int i7 = localDirectionResponse1.getResponseStatus().getResultCode();
      int i8 = NetworkSettings.STARTING_ADDRESS_NOT_FOUND;
      if (i7 != i8)
      {
        int i9 = NetworkSettings.STARTING_ADDRESS_NOT_FOUND;
        Object[] arrayOfObject5 = new Object[1];
        String str7 = localDirectionResponse1.getResponseStatus().getErrorString();
        arrayOfObject5[0] = str7;
        paramUiCallBack.onStatusChanged(paramInt, i9, arrayOfObject5);
        return;
      }
      int i10 = localDirectionResponse1.getResponseStatus().getResultCode();
      int i11 = NetworkSettings.END_ADDRESS_NOT_FOUND;
      if (i10 != i11)
      {
        int i12 = NetworkSettings.END_ADDRESS_NOT_FOUND;
        Object[] arrayOfObject6 = new Object[1];
        String str8 = localDirectionResponse1.getResponseStatus().getErrorString();
        arrayOfObject6[0] = str8;
        paramUiCallBack.onStatusChanged(paramInt, i12, arrayOfObject6);
        return;
      }
      int i13 = localDirectionResponse1.getResponseStatus().getResultCode();
      int i14 = NetworkSettings.BOTH_ADDRESS_NOT_FOUND;
      if (i13 != i14)
      {
        int i15 = NetworkSettings.BOTH_ADDRESS_NOT_FOUND;
        Object[] arrayOfObject7 = new Object[1];
        String str9 = localDirectionResponse1.getResponseStatus().getErrorString();
        arrayOfObject7[0] = str9;
        paramUiCallBack.onStatusChanged(paramInt, i15, arrayOfObject7);
        return;
      }
      int i16 = localDirectionResponse1.getResponseStatus().getResultCode();
      int i17 = NetworkSettings.NETWORK_ERROR;
      if (i16 != i17)
      {
        int i18 = NetworkSettings.NETWORK_ERROR;
        Object[] arrayOfObject8 = new Object[1];
        String str10 = localDirectionResponse1.getResponseStatus().getResultString();
        arrayOfObject8[0] = str10;
        paramUiCallBack.onStatusChanged(paramInt, i18, arrayOfObject8);
        return;
      }
      int i19 = localDirectionResponse1.getResponseStatus().getResultCode();
      int i20 = NetworkSettings.ROUTE_NOT_FOUND;
      if (i19 != i20)
      {
        int i21 = NetworkSettings.ROUTE_NOT_FOUND;
        Object[] arrayOfObject9 = new Object[1];
        String str11 = localDirectionResponse1.getResponseStatus().getErrorString();
        arrayOfObject9[0] = str11;
        paramUiCallBack.onStatusChanged(paramInt, i21, arrayOfObject9);
        return;
      }
      int i22 = NetworkSettings.UNKNOWN_ERROR;
      Object[] arrayOfObject10 = new Object[1];
      String str12 = localDirectionResponse1.getResponseStatus().getErrorString();
      arrayOfObject10[0] = str12;
      paramUiCallBack.onStatusChanged(paramInt, i22, arrayOfObject10);
      return;
    }
    catch (Exception localException)
    {
      label428: break label74;
    }
  }

  private void GetDirectionsCMD(int paramInt, Object[] paramArrayOfObject, ApplicationEngine.UiCallBack paramUiCallBack)
    throws OutOfMemoryError, IOException
  {
    DirectionRequest localDirectionRequest = (DirectionRequest)paramArrayOfObject[1];
    String str1 = NetworkSettings.keyNewAPI;
    String str2 = URLFactoryBuilder.getRouteURL(localDirectionRequest, str1);
    GetDirections(paramInt, paramArrayOfObject, paramUiCallBack, str2);
  }

  private void GetDirectionsFromSmartRouteCMD(int paramInt, Object[] paramArrayOfObject, ApplicationEngine.UiCallBack paramUiCallBack)
    throws OutOfMemoryError, IOException
  {
    String str = (String)paramArrayOfObject[1];
    GetDirections(paramInt, paramArrayOfObject, paramUiCallBack, str);
  }

  private void GetDirectionsFromSmartRouteTaxiCMD(int paramInt, Object[] paramArrayOfObject, ApplicationEngine.UiCallBack paramUiCallBack)
  {
    String str = (String)paramArrayOfObject[1];
    getTaxiDirections(paramInt, paramArrayOfObject, paramUiCallBack, str);
  }

  private void GetDirectionsUpdatedCMD(int paramInt, Object[] paramArrayOfObject, ApplicationEngine.UiCallBack paramUiCallBack)
    throws OutOfMemoryError, IOException
  {
    String str = (String)paramArrayOfObject[1];
    GetDirections(paramInt, paramArrayOfObject, paramUiCallBack, str);
  }

  private void GetFromWS(int paramInt, Object[] paramArrayOfObject, ApplicationEngine.UiCallBack paramUiCallBack)
  {
  }

  private void GetMapCMD(int paramInt, Object[] paramArrayOfObject, ApplicationEngine.UiCallBack paramUiCallBack)
  {
    MapRequest localMapRequest = (MapRequest)paramArrayOfObject[0];
    Model localModel = ApplicationEngine.getModel();
    Address localAddress = localMapRequest.getAddress();
    localModel.setLastMapAddress(localAddress);
    String str1 = NetworkSettings.keyNewAPI;
    String str2 = URLFactoryBuilder.getMapURL(localMapRequest, str1);
    GetMaps(paramInt, paramArrayOfObject, paramUiCallBack, str2);
  }

  private void GetMaps(int paramInt, Object[] paramArrayOfObject, ApplicationEngine.UiCallBack paramUiCallBack, String paramString)
  {
    NetworkEngine localNetworkEngine = ApplicationEngine.getNetworkEngine();
    int i = NetworkSettings.GET_MAP;
    GetMapHandler localGetMapHandler = (GetMapHandler)localNetworkEngine.getSynchronousExecute(null, i, paramString);
    if (localGetMapHandler == null)
    {
      int j = NetworkSettings.NETWORK_ERROR;
      paramUiCallBack.onStatusChanged(paramInt, j, null);
      return;
    }
    int k = localGetMapHandler.getResultCode();
    int m = NetworkSettings.SUCCESS_GET_MAP;
    if (k != m)
    {
      MapResponse localMapResponse1 = localGetMapHandler.getMapResponse();
      paramArrayOfObject[0] = localMapResponse1;
      Model localModel1 = ApplicationEngine.getModel();
      MapResponse localMapResponse2 = localGetMapHandler.getMapResponse();
      localModel1.addMapResponses(0, localMapResponse2);
      if (localMapResponse1.getId() != null)
      {
        Model localModel2 = ApplicationEngine.getModel();
        String str1 = localMapResponse1.getId();
        localModel2.setMapID(str1);
      }
      int n = NetworkSettings.SUCCESS_GET_MAP;
      paramUiCallBack.onStatusChanged(paramInt, n, paramArrayOfObject);
      return;
    }
    int i1 = localGetMapHandler.getResultCode();
    int i2 = NetworkSettings.SEVERAL_CHOICES_FOUND;
    if (i1 != i2)
    {
      Object[] arrayOfObject1 = new Object[1];
      if (localGetMapHandler.getExtraAddresses().size() >= 1)
      {
        ArrayList localArrayList = localGetMapHandler.getExtraAddresses();
        arrayOfObject1[0] = localArrayList;
      }
      int i3 = NetworkSettings.SEVERAL_CHOICES_FOUND;
      paramUiCallBack.onStatusChanged(paramInt, i3, arrayOfObject1);
      return;
    }
    int i4 = localGetMapHandler.getResultCode();
    int i5 = NetworkSettings.MAP_ADDRESS_NOT_FOUND;
    if (i4 != i5)
    {
      int i6 = NetworkSettings.MAP_ADDRESS_NOT_FOUND;
      Object[] arrayOfObject2 = new Object[1];
      String str2 = localGetMapHandler.getResultString();
      arrayOfObject2[0] = str2;
      paramUiCallBack.onStatusChanged(paramInt, i6, arrayOfObject2);
      return;
    }
    int i7 = localGetMapHandler.getResultCode();
    int i8 = NetworkSettings.NETWORK_ERROR;
    if (i7 != i8)
    {
      int i9 = NetworkSettings.NETWORK_ERROR;
      paramUiCallBack.onStatusChanged(paramInt, i9, null);
      return;
    }
    int i10 = NetworkSettings.UNKNOWN_ERROR;
    paramUiCallBack.onStatusChanged(paramInt, i10, null);
  }

  private void GetNearbyBusiness(int paramInt, Object[] paramArrayOfObject, ApplicationEngine.UiCallBack paramUiCallBack)
  {
    Activity localActivity = (Activity)paramArrayOfObject[0];
    String str1 = (String)paramArrayOfObject[1];
    String str2 = (String)paramArrayOfObject[2];
    String str3 = (String)paramArrayOfObject[3];
    YextListings localYextListings = null;
    String str4 = URLFactoryBuilder.GetNearbyBusinessURL(str1, str2, str3);
    try
    {
      String str5 = ApplicationEngine.getNetworkEngine().retrieve(str4);
      if (str5 != null)
      {
        Persister localPersister = new Persister();
        StringReader localStringReader = new StringReader(str5);
        localYextListings = (YextListings)localPersister.read(YextListings.class, localStringReader, false);
      }
      if (localYextListings == null)
        return;
      if (localYextListings.getListingCount() == 0)
        return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      int i = NetworkSettings.NETWORK_ERROR;
      ApplicationEngine.UiCallBack localUiCallBack1 = paramUiCallBack;
      int j = paramInt;
      localUiCallBack1.onStatusChanged(j, i, null);
      return;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
      if (localYextListings.getListingCount() <= 0)
        return;
      paramArrayOfObject[0] = localYextListings;
      Controller localController = this;
      CountImpressionTask localCountImpressionTask = new CountImpressionTask();
      Object[] arrayOfObject1 = new Object[1];
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = localActivity;
      String str6 = getImpressionString(localYextListings);
      arrayOfObject2[1] = str6;
      arrayOfObject1[0] = arrayOfObject2;
      AsyncTask localAsyncTask = localCountImpressionTask.execute(arrayOfObject1);
      int k = NetworkSettings.SUCCESS_GET_NEARBY_BUSINESS;
      ApplicationEngine.UiCallBack localUiCallBack2 = paramUiCallBack;
      int m = paramInt;
      Object[] arrayOfObject3 = paramArrayOfObject;
      localUiCallBack2.onStatusChanged(m, k, arrayOfObject3);
    }
  }

  private void GetSchedulesCities(int paramInt, Object[] paramArrayOfObject, ApplicationEngine.UiCallBack paramUiCallBack)
  {
  }

  private void GetServiceAdvisor(int paramInt, Object[] paramArrayOfObject, ApplicationEngine.UiCallBack paramUiCallBack)
  {
    Activity localActivity = (Activity)paramArrayOfObject[0];
    int i = ((Integer)paramArrayOfObject[1]).intValue();
    NetworkEngine localNetworkEngine = ApplicationEngine.getNetworkEngine();
    String str = URLFactoryBuilder.GetServiceAdvisorURL(NetworkSettings.key);
    GetServiceAdvisorHandler localGetServiceAdvisorHandler = (GetServiceAdvisorHandler)localNetworkEngine.getSynchronousExecute(localActivity, i, str);
    if (localGetServiceAdvisorHandler == null)
    {
      int j = NetworkSettings.FAIL_GET_SERVICE_ADVISOR;
      paramUiCallBack.onStatusChanged(paramInt, j, paramArrayOfObject);
      return;
    }
    int k = localGetServiceAdvisorHandler.getResponse().getResult();
    int m = NetworkSettings.SUCCESS_GET_SERVICE_ADVISOR;
    if (k != m)
      return;
    ServiceAdvisorResponse localServiceAdvisorResponse = localGetServiceAdvisorHandler.getResponse();
    paramArrayOfObject[0] = localServiceAdvisorResponse;
    int n = NetworkSettings.SUCCESS_GET_SERVICE_ADVISOR;
    paramUiCallBack.onStatusChanged(paramInt, n, paramArrayOfObject);
  }

  private void GetTaxiCMD(int paramInt, Object[] paramArrayOfObject, ApplicationEngine.UiCallBack paramUiCallBack)
  {
    DirectionRequest localDirectionRequest = (DirectionRequest)paramArrayOfObject[1];
    String str1 = NetworkSettings.keyNewAPI;
    String str2 = URLFactoryBuilder.getTaxiRouteURL(localDirectionRequest, str1);
    getTaxiDirections(paramInt, paramArrayOfObject, paramUiCallBack, str2);
  }

  private void HandleDirectionSearch(int paramInt, Object[] paramArrayOfObject, ApplicationEngine.UiCallBack paramUiCallBack)
    throws OutOfMemoryError, IOException
  {
    if (paramInt == 101)
      GetDirectionsCMD(paramInt, paramArrayOfObject, paramUiCallBack);
    if (paramInt == 111)
      SaveRecentTrip(paramInt, paramArrayOfObject, paramUiCallBack);
    if (paramInt == 112)
      SaveTrip(paramInt, paramArrayOfObject, paramUiCallBack);
    if (paramInt == 105)
      GetDirectionsUpdatedCMD(paramInt, paramArrayOfObject, paramUiCallBack);
    if (paramInt == 109)
      GetDirectionsFromSmartRouteCMD(paramInt, paramArrayOfObject, paramUiCallBack);
    if (paramInt == 110)
      GetDirectionsFromSmartRouteTaxiCMD(paramInt, paramArrayOfObject, paramUiCallBack);
    if (paramInt != 107)
      return;
    GetTaxiCMD(paramInt, paramArrayOfObject, paramUiCallBack);
  }

  private void HandleLocationButtonCMD(int paramInt, Object[] paramArrayOfObject, ApplicationEngine.UiCallBack paramUiCallBack)
  {
    if (paramInt != 1)
      return;
    getCurrentLocation(paramInt, paramArrayOfObject, paramUiCallBack);
  }

  private void SaveRecentTrip(int paramInt, Object[] paramArrayOfObject, ApplicationEngine.UiCallBack paramUiCallBack)
  {
    ArrayList localArrayList = ApplicationEngine.getModel().getRecentTrip();
    if (localArrayList == null)
      return;
    if (localArrayList.size() <= 0)
      return;
    int i = 0;
    try
    {
      ((ViewStepTotal)localArrayList.get(i)).setRecent(true);
      ApplicationEngine.getHistoryManager(null).executeInserTask(localArrayList, false);
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

  private void SaveTrip(int paramInt, Object[] paramArrayOfObject, ApplicationEngine.UiCallBack paramUiCallBack)
  {
    if (paramArrayOfObject == null)
      return;
    if (paramArrayOfObject[0] == null)
      return;
    if (!(paramArrayOfObject[0] instanceof ArrayList))
      return;
    if (paramArrayOfObject.length <= 1)
      return;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = ApplicationEngine.getModel().getRecentTrip();
    boolean bool1 = localArrayList1.addAll(localArrayList2);
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = localArrayList1.iterator();
    while (true)
    {
      Context localContext;
      if (!localIterator.hasNext())
      {
        ApplicationEngine.getModel().addMyTrip(0, localArrayList3);
        if (localArrayList3 == null)
          return;
        if (localArrayList3.size() <= 0)
          return;
        ViewStepTotal localViewStepTotal = (ViewStepTotal)localArrayList3.get(0);
        String str = (String)paramArrayOfObject[1];
        localViewStepTotal.setMyTripName(str);
        localViewStepTotal.setRecent(false);
        localContext = null;
      }
      try
      {
        ApplicationEngine.getHistoryManager(localContext).executeInserTask(localArrayList3, true);
        return;
        ViewStep localViewStep = ((ViewStep)localIterator.next()).cloneItself();
        boolean bool2 = localArrayList3.add(localViewStep);
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
  }

  private void UpdateMapCMD(int paramInt, Object[] paramArrayOfObject, ApplicationEngine.UiCallBack paramUiCallBack)
  {
    MapUpdateRequest localMapUpdateRequest = (MapUpdateRequest)paramArrayOfObject[0];
    String str1 = NetworkSettings.keyNewAPI;
    String str2 = URLFactoryBuilder.updateMapURL(localMapUpdateRequest, str1);
    NetworkEngine localNetworkEngine = ApplicationEngine.getNetworkEngine();
    int i = NetworkSettings.UPDATE_MAP;
    GetMapHandler localGetMapHandler = (GetMapHandler)localNetworkEngine.getSynchronousExecute(null, i, str2);
    if (localGetMapHandler == null)
      return;
    int j = localGetMapHandler.getResultCode();
    int k = NetworkSettings.SUCCESS_GET_MAP;
    if (j != k)
    {
      MapResponse localMapResponse1 = localGetMapHandler.getMapResponse();
      paramArrayOfObject[0] = localMapResponse1;
      Model localModel1 = ApplicationEngine.getModel();
      MapResponse localMapResponse2 = localGetMapHandler.getMapResponse();
      localModel1.addMapResponses(0, localMapResponse2);
      if (localMapResponse1.getId() != null)
      {
        Model localModel2 = ApplicationEngine.getModel();
        String str3 = localMapResponse1.getId();
        localModel2.setMapID(str3);
      }
      int m = NetworkSettings.SUCCESS_GET_MAP;
      paramUiCallBack.onStatusChanged(paramInt, m, paramArrayOfObject);
      return;
    }
    int n = localGetMapHandler.getResultCode();
    int i1 = NetworkSettings.SEVERAL_CHOICES_FOUND;
    if (n != i1)
    {
      Object[] arrayOfObject = new Object[1];
      if (localGetMapHandler.getExtraAddresses().size() > 1)
      {
        ArrayList localArrayList = localGetMapHandler.getExtraAddresses();
        arrayOfObject[0] = localArrayList;
      }
      int i2 = NetworkSettings.SEVERAL_CHOICES_FOUND;
      paramUiCallBack.onStatusChanged(paramInt, i2, arrayOfObject);
      return;
    }
    int i3 = localGetMapHandler.getResultCode();
    int i4 = NetworkSettings.NETWORK_ERROR;
    if (i3 != i4)
    {
      int i5 = NetworkSettings.NETWORK_ERROR;
      paramUiCallBack.onStatusChanged(paramInt, i5, null);
      return;
    }
    int i6 = NetworkSettings.UNKNOWN_ERROR;
    paramUiCallBack.onStatusChanged(paramInt, i6, null);
  }

  private void deleteHistoryCalls(Object[] paramArrayOfObject, ApplicationEngine.UiCallBack paramUiCallBack)
  {
    if (paramArrayOfObject.length <= 0)
      return;
    int i = 0;
    while (true)
    {
      int j = paramArrayOfObject.length;
      if (i >= j)
        return;
      if (((String)paramArrayOfObject[i]).length() > 0)
      {
        Model localModel = this.model;
        String str = (String)paramArrayOfObject[i];
        localModel.deleteHistoryCalls(str);
      }
      i += 1;
    }
  }

  private ArrayList<ViewStep> filterStepViews(ArrayList<ViewStep> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    if (!localIterator.hasNext());
    while (true)
    {
      return localArrayList;
      ViewStep localViewStep = (ViewStep)localIterator.next();
      if (((localViewStep instanceof ViewStepTotal)) || ((localViewStep instanceof ViewStepAddress)))
        boolean bool1 = localArrayList.add(localViewStep);
      if (!(localViewStep instanceof ViewStepReverseNewSearch))
        break;
      boolean bool2 = localArrayList.add(localViewStep);
    }
  }

  private ArrayList<ViewStep> filterTaxiStepViews(ArrayList<ViewStepDirections> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return localArrayList;
      ViewStep localViewStep = (ViewStep)localIterator.next();
      float f1 = ((ViewStepDirections)localViewStep).getDistance();
      String str1 = ((ViewStepDirections)localViewStep).getDirections();
      float f2 = ((ViewStepDirections)localViewStep).getPrice();
      String str2 = ((ViewStepDirections)localViewStep).getPhone();
      String str3 = ((ViewStepDirections)localViewStep).getNotes();
      ViewStepTaxi localViewStepTaxi = new ViewStepTaxi(f1, str1, f2, str2, str3);
      boolean bool = localArrayList.add(localViewStepTaxi);
    }
  }

  private void getCurrentLocation(final int paramInt, final Object[] paramArrayOfObject, final ApplicationEngine.UiCallBack paramUiCallBack)
  {
    GPSEngine localGPSEngine = ApplicationEngine.getGPSEngine((Context)paramArrayOfObject[0]);
    this.engine = localGPSEngine;
    if (this.engine == null)
      return;
    ArrayList localArrayList = this._requests;
    GPSFixRequest localGPSFixRequest1 = this.engine.initGPSFixes();
    boolean bool = localArrayList.add(localGPSFixRequest1);
    if ((this._requests != null) && (this._requests.size() > 0))
    {
      Iterator localIterator = this._requests.iterator();
      while (true)
      {
        if (!localIterator.hasNext())
          return;
        GPSFixRequest localGPSFixRequest2 = (GPSFixRequest)localIterator.next();
        if (!localGPSFixRequest2.isRequested())
        {
          new Thread()
          {
            public void run()
            {
              Controller localController = Controller.this;
              int i = paramInt;
              Object[] arrayOfObject = paramArrayOfObject;
              ApplicationEngine.UiCallBack localUiCallBack = paramUiCallBack;
              localController.requestGPS(i, arrayOfObject, localUiCallBack);
            }
          }
          .start();
          localGPSFixRequest2.setRequested(true);
        }
      }
    }
    if (paramUiCallBack == null)
      return;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = "No Location provider available. please check your settings on your phone by going to settings->click on location->Check wireless or GPS othersie";
    paramUiCallBack.onStatusChanged(paramInt, 2, arrayOfObject);
  }

  private String getImpressionString(YextListings paramYextListings)
  {
    int i = 1;
    String str1 = "";
    int j = Math.min(paramYextListings.getListingCount(), 2);
    int k;
    if (j > i)
      k = 0;
    while (true)
    {
      if (k >= j)
      {
        return str1;
        i = 0;
        break;
      }
      String str2 = String.valueOf(str1);
      StringBuilder localStringBuilder = new StringBuilder(str2);
      String str3 = paramYextListings.getListing(k).getYextId();
      str1 = str3;
      if (i != 0)
      {
        String str4 = String.valueOf(str1);
        String str5 = str4 + ",";
        i = 0;
      }
      k += 1;
    }
  }

  private void getTaxi(int paramInt, Object[] paramArrayOfObject, String paramString, ArrayList<ViewStep> paramArrayList, ApplicationEngine.UiCallBack paramUiCallBack)
  {
    String str1 = NetworkSettings.key;
    String str2 = URLFactoryBuilder.getTaxiURL(paramString, str1);
    NetworkEngine localNetworkEngine = ApplicationEngine.getNetworkEngine();
    Activity localActivity = (Activity)paramArrayOfObject[0];
    int i = NetworkSettings.GET_TAXI;
    GetTaxisHandler localGetTaxisHandler = (GetTaxisHandler)localNetworkEngine.getSynchronousExecute(localActivity, i, str2);
    DirectionResponse localDirectionResponse = (DirectionResponse)paramArrayOfObject[1];
    if (localGetTaxisHandler == null)
    {
      int j = NetworkSettings.NETWORK_ERROR;
      paramUiCallBack.onStatusChanged(paramInt, j, null);
      return;
    }
    if (localGetTaxisHandler.isSuccess())
    {
      if ((localDirectionResponse != null) && (localGetTaxisHandler != null))
      {
        if (localGetTaxisHandler.getTaxiResponse() == null)
        {
          int k = NetworkSettings.NO_TAXI_FOUND;
          paramUiCallBack.onStatusChanged(paramInt, k, null);
          return;
        }
        if (localGetTaxisHandler.getTaxiResponse() == null)
        {
          int m = NetworkSettings.NO_TAXI_FOUND;
          paramUiCallBack.onStatusChanged(paramInt, m, null);
          return;
        }
        if (localGetTaxisHandler.getTaxiResponse().getViewStepTaxiCount() == 0)
        {
          int n = NetworkSettings.NO_TAXI_FOUND;
          paramUiCallBack.onStatusChanged(paramInt, n, null);
          return;
        }
        TaxiResponse localTaxiResponse1 = localGetTaxisHandler.getTaxiResponse();
        String str3 = localDirectionResponse.getAddress1();
        localTaxiResponse1.setAddress1(str3);
        TaxiResponse localTaxiResponse2 = localGetTaxisHandler.getTaxiResponse();
        String str4 = localDirectionResponse.getAddress2();
        localTaxiResponse2.setAddress2(str4);
        TaxiResponse localTaxiResponse3 = localGetTaxisHandler.getTaxiResponse();
        String str5 = localDirectionResponse.getZip1();
        localTaxiResponse3.setZip1(str5);
        TaxiResponse localTaxiResponse4 = localGetTaxisHandler.getTaxiResponse();
        String str6 = localDirectionResponse.getZip2();
        localTaxiResponse4.setZip2(str6);
        localGetTaxisHandler.getTaxiResponse().addStartEndAddresses(paramArrayList);
        Model localModel = ApplicationEngine.getModel();
        TaxiResponse localTaxiResponse5 = localGetTaxisHandler.getTaxiResponse();
        localModel.setTaxiResponse(localTaxiResponse5);
        int i1 = NetworkSettings.SUCCESS_GET_ROUTE;
        Object[] arrayOfObject = new Object[1];
        TaxiResponse localTaxiResponse6 = localGetTaxisHandler.getTaxiResponse();
        arrayOfObject[0] = localTaxiResponse6;
        paramUiCallBack.onStatusChanged(paramInt, i1, arrayOfObject);
        return;
      }
      int i2 = NetworkSettings.UNKNOWN_ERROR;
      paramUiCallBack.onStatusChanged(paramInt, i2, null);
      return;
    }
    int i3 = NetworkSettings.UNKNOWN_ERROR;
    paramUiCallBack.onStatusChanged(paramInt, i3, null);
  }

  private void getTaxiDirections(int paramInt, Object[] paramArrayOfObject, ApplicationEngine.UiCallBack paramUiCallBack, String paramString)
  {
    DirectionResponse localDirectionResponse1 = null;
    ApplicationEngine.getDrawableManager().clearHashMap();
    try
    {
      Crashlytics.log(paramString);
      NetworkEngine localNetworkEngine = ApplicationEngine.getNetworkEngine();
      String str1 = paramString;
      String str2 = localNetworkEngine.retrieve(str1);
      if (str2 != null)
      {
        Persister localPersister = new Persister();
        StringReader localStringReader = new StringReader(str2);
        localDirectionResponse1 = (DirectionResponse)localPersister.read(DirectionResponse.class, localStringReader, false);
      }
      label74: if (localDirectionResponse1 == null)
      {
        int i = NetworkSettings.UNKNOWN_ERROR;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = "An error has occurred, please try again.";
        paramUiCallBack.onStatusChanged(paramInt, i, arrayOfObject1);
        return;
      }
    }
    catch (IOException localIOException1)
    {
      int j = NetworkSettings.NETWORK_ERROR;
      paramUiCallBack.onStatusChanged(paramInt, j, null);
      return;
      int k = localDirectionResponse1.getResponseStatus().getResultCode();
      int m = NetworkSettings.SUCCESS_GET_ROUTE;
      if (k != m)
      {
        DirectionResponse localDirectionResponse2 = localDirectionResponse1;
        paramArrayOfObject[1] = localDirectionResponse2;
        try
        {
          ApplicationEngine.getModel().addTrip(0, localDirectionResponse2);
          if (localDirectionResponse2 == null)
            return;
          if (localDirectionResponse2.isSmartRoute())
          {
            int n = NetworkSettings.SUCCESS_GET_ROUTE;
            Object[] arrayOfObject2 = new Object[2];
            arrayOfObject2[0] = localDirectionResponse2;
            arrayOfObject2[1] = paramString;
            paramUiCallBack.onStatusChanged(paramInt, n, arrayOfObject2);
            return;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          while (true)
            localOutOfMemoryError.printStackTrace();
        }
        catch (IOException localIOException2)
        {
          while (true)
            localIOException2.printStackTrace();
          String str3 = paramString;
          taxiCallBack(paramInt, paramUiCallBack, str3, localDirectionResponse2);
          return;
        }
      }
      int i1 = localDirectionResponse1.getResponseStatus().getResultCode();
      int i2 = NetworkSettings.SEVERAL_CHOICES_FOUND;
      if (i1 != i2)
      {
        Object[] arrayOfObject3 = new Object[4];
        if (localDirectionResponse1.getFirstExtraAddresses().size() >= 1)
        {
          ArrayList localArrayList1 = localDirectionResponse1.getFirstExtraAddresses();
          arrayOfObject3[0] = localArrayList1;
          arrayOfObject3[2] = null;
          if (localDirectionResponse1.getSecondExtraAddresses().size() < 1)
            break label378;
          ArrayList localArrayList2 = localDirectionResponse1.getSecondExtraAddresses();
          arrayOfObject3[1] = localArrayList2;
          arrayOfObject3[3] = null;
        }
        while (true)
        {
          int i3 = NetworkSettings.SEVERAL_CHOICES_FOUND;
          paramUiCallBack.onStatusChanged(paramInt, i3, arrayOfObject3);
          return;
          arrayOfObject3[0] = null;
          String str4 = ((Address)localDirectionResponse1.getFirstExtraAddresses().get(0)).getThumbnailId();
          arrayOfObject3[2] = str4;
          break;
          arrayOfObject3[1] = null;
          String str5 = ((Address)localDirectionResponse1.getSecondExtraAddresses().get(0)).getThumbnailId();
          arrayOfObject3[3] = str5;
        }
      }
      int i4 = localDirectionResponse1.getResponseStatus().getResultCode();
      int i5 = NetworkSettings.ADDRESS_NOT_FOUND;
      if (i4 != i5)
      {
        int i6 = NetworkSettings.ADDRESS_NOT_FOUND;
        Object[] arrayOfObject4 = new Object[1];
        String str6 = localDirectionResponse1.getResponseStatus().getErrorString();
        arrayOfObject4[0] = str6;
        paramUiCallBack.onStatusChanged(paramInt, i6, arrayOfObject4);
        return;
      }
      int i7 = localDirectionResponse1.getResponseStatus().getResultCode();
      int i8 = NetworkSettings.STARTING_ADDRESS_NOT_FOUND;
      if (i7 != i8)
      {
        int i9 = NetworkSettings.STARTING_ADDRESS_NOT_FOUND;
        Object[] arrayOfObject5 = new Object[1];
        String str7 = localDirectionResponse1.getResponseStatus().getErrorString();
        arrayOfObject5[0] = str7;
        paramUiCallBack.onStatusChanged(paramInt, i9, arrayOfObject5);
        return;
      }
      int i10 = localDirectionResponse1.getResponseStatus().getResultCode();
      int i11 = NetworkSettings.END_ADDRESS_NOT_FOUND;
      if (i10 != i11)
      {
        int i12 = NetworkSettings.END_ADDRESS_NOT_FOUND;
        Object[] arrayOfObject6 = new Object[1];
        String str8 = localDirectionResponse1.getResponseStatus().getErrorString();
        arrayOfObject6[0] = str8;
        paramUiCallBack.onStatusChanged(paramInt, i12, arrayOfObject6);
        return;
      }
      int i13 = localDirectionResponse1.getResponseStatus().getResultCode();
      int i14 = NetworkSettings.BOTH_ADDRESS_NOT_FOUND;
      if (i13 != i14)
      {
        int i15 = NetworkSettings.BOTH_ADDRESS_NOT_FOUND;
        Object[] arrayOfObject7 = new Object[1];
        String str9 = localDirectionResponse1.getResponseStatus().getErrorString();
        arrayOfObject7[0] = str9;
        paramUiCallBack.onStatusChanged(paramInt, i15, arrayOfObject7);
        return;
      }
      int i16 = localDirectionResponse1.getResponseStatus().getResultCode();
      int i17 = NetworkSettings.NETWORK_ERROR;
      if (i16 != i17)
      {
        int i18 = NetworkSettings.NETWORK_ERROR;
        paramUiCallBack.onStatusChanged(paramInt, i18, null);
        return;
      }
      int i19 = NetworkSettings.UNKNOWN_ERROR;
      Object[] arrayOfObject8 = new Object[1];
      String str10 = localDirectionResponse1.getResponseStatus().getErrorString();
      arrayOfObject8[0] = str10;
      paramUiCallBack.onStatusChanged(paramInt, i19, arrayOfObject8);
      return;
    }
    catch (Exception localException)
    {
      label378: break label74;
    }
  }

  private void taxiCallBack(int paramInt, ApplicationEngine.UiCallBack paramUiCallBack, String paramString, DirectionResponse paramDirectionResponse)
  {
    TaxiResponse localTaxiResponse = new TaxiResponse();
    ViewStepTotal localViewStepTotal = paramDirectionResponse.getViewStepTotal();
    ViewStepAddress localViewStepAddress1 = paramDirectionResponse.getRouteInfo().getViewStepAddress1();
    ViewStepAddress localViewStepAddress2 = paramDirectionResponse.getRouteInfo().getViewStepAddress2();
    localTaxiResponse.addStartEndAddresses(localViewStepTotal, localViewStepAddress1, localViewStepAddress2);
    ArrayList localArrayList1 = paramDirectionResponse.getRouteInfo().getSteps();
    ArrayList localArrayList2 = filterTaxiStepViews(localArrayList1);
    localTaxiResponse.addDirectionSteps(localArrayList2);
    String str1 = paramDirectionResponse.getAddress1();
    localTaxiResponse.setAddress1(str1);
    String str2 = paramDirectionResponse.getAddress2();
    localTaxiResponse.setAddress2(str2);
    String str3 = paramDirectionResponse.getZip1();
    localTaxiResponse.setZip1(str3);
    String str4 = paramDirectionResponse.getZip2();
    localTaxiResponse.setZip2(str4);
    String str5 = paramDirectionResponse.getRouteInfo().getId();
    localTaxiResponse.setRouteId(str5);
    ApplicationEngine.getModel().setTaxiResponse(localTaxiResponse);
    int i = NetworkSettings.SUCCESS_GET_ROUTE;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = localTaxiResponse;
    arrayOfObject[1] = paramDirectionResponse;
    arrayOfObject[2] = paramString;
    paramUiCallBack.onStatusChanged(paramInt, i, arrayOfObject);
  }

  private void updateHistoryCalls(Object[] paramArrayOfObject, ApplicationEngine.UiCallBack paramUiCallBack)
  {
    if (paramArrayOfObject.length <= 0)
      return;
    int i = 0;
    while (true)
    {
      int j = paramArrayOfObject.length;
      if (i >= j)
        return;
      if (((String)paramArrayOfObject[i]).length() > 0)
      {
        Model localModel = this.model;
        String str = (String)paramArrayOfObject[i];
        localModel.updateHistoryCalls(str);
      }
      i += 1;
    }
  }

  public void handleViewRequest(int paramInt, Object[] paramArrayOfObject, ApplicationEngine.UiCallBack paramUiCallBack)
    throws OutOfMemoryError, IOException
  {
    if ((paramInt >= 0) && (paramInt <= 99))
      HandleLocationButtonCMD(paramInt, paramArrayOfObject, paramUiCallBack);
    if ((paramInt >= 300) && (paramInt <= 399))
      GetCityFromLonLan(paramInt, paramArrayOfObject, paramUiCallBack);
    if ((paramInt >= 100) && (paramInt <= 199))
      HandleDirectionSearch(paramInt, paramArrayOfObject, paramUiCallBack);
    if (paramInt == 702)
      GetMapCMD(paramInt, paramArrayOfObject, paramUiCallBack);
    if (paramInt == 803)
      UpdateMapCMD(paramInt, paramArrayOfObject, paramUiCallBack);
    if (paramInt == 201)
      updateHistoryCalls(paramArrayOfObject, paramUiCallBack);
    if (paramInt == 202)
      deleteHistoryCalls(paramArrayOfObject, paramUiCallBack);
    if (paramInt == 401)
      GetNearbyBusiness(paramInt, paramArrayOfObject, paramUiCallBack);
    if (paramInt == 402)
      GetCountImpression(paramInt, paramArrayOfObject, paramUiCallBack);
    if (paramInt == 501)
      GetServiceAdvisor(paramInt, paramArrayOfObject, paramUiCallBack);
    if (paramInt != 601)
      return;
    GetSchedulesCities(paramInt, paramArrayOfObject, paramUiCallBack);
  }

  protected void requestGPS(final int paramInt, Object[] paramArrayOfObject, final ApplicationEngine.UiCallBack paramUiCallBack)
  {
    GPSSettings localGPSSettings = new GPSSettings(60000, 550);
    localGPSSettings.acc = 550;
    if (this._requests == null)
      return;
    if (this._requests.size() < 1)
      return;
    GPSFixRequest localGPSFixRequest = (GPSFixRequest)this._requests.get(0);
    boolean bool1 = localGPSFixRequest.isSingleShot();
    localGPSSettings.singleShot = bool1;
    ArrayList localArrayList = localGPSSettings.gpsProviders;
    List localList = localGPSFixRequest.getProviderNames();
    boolean bool2 = localArrayList.addAll(localList);
    String str = localGPSFixRequest.getMode();
    localGPSSettings.mode = str;
    GpsObserver local2 = new GpsObserver()
    {
      public void onLocationChanged(Location paramAnonymousLocation)
      {
        Iterator localIterator = Controller.this._requests.iterator();
        while (true)
        {
          if (!localIterator.hasNext())
          {
            Controller.this._requests.clear();
            Model localModel = Controller.this.model;
            int i = paramInt;
            ApplicationEngine.UiCallBack localUiCallBack = paramUiCallBack;
            localModel.updateCurrentLocation(paramAnonymousLocation, i, 1, localUiCallBack);
            return;
          }
          ((GPSFixRequest)localIterator.next()).setRequested(false);
        }
      }

      public void onLocationError(int paramAnonymousInt)
      {
        if (Controller.this._requests == null)
          return;
        if (Controller.this._requests.size() <= 0)
          return;
        if (paramAnonymousInt != 3)
        {
          ApplicationEngine.UiCallBack localUiCallBack1 = paramUiCallBack;
          int i = paramInt;
          Object[] arrayOfObject1 = new Object[1];
          arrayOfObject1[0] = "Unable to acquire location, please check location settings on your phone";
          localUiCallBack1.onStatusChanged(i, 0, arrayOfObject1);
        }
        while (true)
        {
          Controller.this._requests.clear();
          return;
          if (paramAnonymousInt == 3)
          {
            ApplicationEngine.UiCallBack localUiCallBack2 = paramUiCallBack;
            int j = paramInt;
            Object[] arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = "We were unable to find your location. Please turn-on GPS, Wireless Networks and WiFi in your phone's settings, and try again";
            localUiCallBack2.onStatusChanged(j, 3, arrayOfObject2);
          }
        }
      }
    };
    if (localGPSSettings.singleShot)
    {
      GPSEngine localGPSEngine1 = this.engine;
      int i = localGPSFixRequest.getId();
      localGPSEngine1.getCurrentGPSFix(localGPSSettings, local2, i);
      return;
    }
    GPSEngine localGPSEngine2 = this.engine;
    int j = localGPSFixRequest.getId();
    localGPSEngine2.startGpsListenForGPSFixes(localGPSSettings, local2, j);
  }

  protected class CountImpressionTask extends AsyncTask<Object[], Integer, String>
  {
    protected CountImpressionTask()
    {
    }

    protected String doInBackground(Object[][] paramArrayOfObject)
    {
      final Object[] arrayOfObject1 = new Object[1];
      try
      {
        Controller localController = Controller.this;
        Object[] arrayOfObject2 = paramArrayOfObject[0];
        ApplicationEngine.UiCallBack local1 = new ApplicationEngine.UiCallBack()
        {
          public void onStatusChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object[] paramAnonymousArrayOfObject)
          {
            int i = NetworkSettings.SUCCESS_GET_COUNT_IMPRESSION;
            if (paramAnonymousInt2 != i)
              return;
            Object[] arrayOfObject = arrayOfObject1;
            Object localObject = paramAnonymousArrayOfObject[0];
            arrayOfObject[0] = localObject;
          }
        };
        localController.handleViewRequest(402, arrayOfObject2, local1);
        return null;
      }
      catch (IOException localIOException)
      {
        while (true)
          localIOException.printStackTrace();
      }
    }

    protected void onPostExecute(String paramString)
    {
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientController.Controller
 * JD-Core Version:    0.6.2
 */