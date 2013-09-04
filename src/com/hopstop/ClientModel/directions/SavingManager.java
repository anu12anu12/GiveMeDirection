package com.hopstop.ClientModel.directions;

import com.hopstop.ClientView.DirectionsResultActivity;
import java.util.HashMap;

public class SavingManager
{
  private HashMap<String, ViewStep> _downloadingViewSteps;
  private DirectionsResultActivity _dra;
  private boolean _isCancel;
  private boolean _isTripSaved = false;

  public SavingManager(DirectionsResultActivity paramDirectionsResultActivity)
  {
    this._dra = paramDirectionsResultActivity;
    HashMap localHashMap = new HashMap();
    this._downloadingViewSteps = localHashMap;
  }

  public void add(String paramString, ViewStep paramViewStep)
  {
    if (this._isCancel)
      return;
    Object localObject = this._downloadingViewSteps.put(paramString, paramViewStep);
  }

  public void mapkStepDownloaded(String paramString)
  {
    Object localObject = this._downloadingViewSteps.remove(paramString);
    if (this._downloadingViewSteps.size() != 0)
      return;
    if (this._isCancel)
      return;
    this._dra.launchSavingTrip();
    this._isTripSaved = true;
  }

  public void onCancel()
  {
    this._isCancel = true;
  }

  public boolean tripSaved()
  {
    return this._isTripSaved;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.SavingManager
 * JD-Core Version:    0.6.2
 */