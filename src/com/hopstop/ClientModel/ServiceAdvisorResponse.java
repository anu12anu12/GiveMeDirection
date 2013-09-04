package com.hopstop.ClientModel;

import com.hopstop.ClientView.anim.ViewStepSubwayVehicle;
import com.hopstop.network.NetworkSettings;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ServiceAdvisorResponse
{
  public static final String DATE_FORMAT_NOW = "hh:mm a";
  private ArrayList<ViewStepSubwayVehicle> _itemsBus;
  private ArrayList<ViewStepSubwayVehicle> _itemsRegionalRail;
  private ArrayList<ViewStepSubwayVehicle> _itemsSubwayTrain;
  private int _result;
  private String _timeOfDownload;
  private String _updatedTime;

  public ServiceAdvisorResponse()
  {
    int i = NetworkSettings.FAIL_GET_SERVICE_ADVISOR;
    this._result = i;
    ArrayList localArrayList1 = new ArrayList();
    this._itemsSubwayTrain = localArrayList1;
    ArrayList localArrayList2 = new ArrayList();
    this._itemsRegionalRail = localArrayList2;
    ArrayList localArrayList3 = new ArrayList();
    this._itemsBus = localArrayList3;
    String str = now();
    this._timeOfDownload = str;
  }

  public static String now()
  {
    Calendar localCalendar = Calendar.getInstance();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("hh:mm a");
    Date localDate = localCalendar.getTime();
    return localSimpleDateFormat.format(localDate);
  }

  public void addServiceAdvisorBus(ViewStepSubwayVehicle paramViewStepSubwayVehicle)
  {
    boolean bool = this._itemsBus.add(paramViewStepSubwayVehicle);
  }

  public void addServiceAdvisorRegionalRail(ViewStepSubwayVehicle paramViewStepSubwayVehicle)
  {
    boolean bool = this._itemsRegionalRail.add(paramViewStepSubwayVehicle);
  }

  public void addServiceAdvisorSubwayTrain(ViewStepSubwayVehicle paramViewStepSubwayVehicle)
  {
    boolean bool = this._itemsSubwayTrain.add(paramViewStepSubwayVehicle);
  }

  public int getResult()
  {
    return this._result;
  }

  public String getTimeOfDownload()
  {
    return this._timeOfDownload;
  }

  public String getUpdatedTime()
  {
    return this._updatedTime;
  }

  public ArrayList<ViewStepSubwayVehicle> getViewStepBusVehicle()
  {
    return this._itemsBus;
  }

  public ArrayList<ViewStepSubwayVehicle> getViewStepRegionalRailVehicle()
  {
    return this._itemsRegionalRail;
  }

  public ArrayList<ViewStepSubwayVehicle> getViewStepSubwayTrainVehicle()
  {
    return this._itemsSubwayTrain;
  }

  public void setResult(int paramInt)
  {
    this._result = paramInt;
  }

  public void setTimeOfDownload(String paramString)
  {
    this._timeOfDownload = paramString;
  }

  public void setUpdatedTime(String paramString)
  {
    this._updatedTime = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.ServiceAdvisorResponse
 * JD-Core Version:    0.6.2
 */