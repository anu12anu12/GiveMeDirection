package com.hopstop.ClientModel.directions;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;
import com.hopstop.ClientModel.Model;
import com.hopstop.core.ApplicationEngine;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class InteractiveMapOverlay extends ItemizedOverlay<OverlayItem>
{
  private Context _context;
  private OverlayItem _currentPixelOverlayItem;
  private OverlayItem _destPixelOverlayItem;
  private ArrayList<GeoPoints> _geoPoints;
  private int _index = -1;
  private Drawable _marker;
  private OverlayItem _overlayItemEnd;
  private OverlayItem _overlayItemStart;
  private Resources _resource;
  private Hashtable<String, RouteIcons> _routeIcons;
  private List<OverlayItem> items;

  public InteractiveMapOverlay(Context paramContext, Drawable paramDrawable, int paramInt)
  {
    super(localDrawable1);
    ArrayList localArrayList1 = new ArrayList();
    this.items = localArrayList1;
    this._marker = null;
    int i = paramInt;
    this._index = i;
    this._context = paramContext;
    Resources localResources = paramContext.getResources();
    this._resource = localResources;
    if (this._index == -1);
    Model localModel;
    int i1;
    for (ArrayList localArrayList2 = ApplicationEngine.getModel().getRecentTrip(); ; localArrayList2 = localModel.getMyTrip(i1))
    {
      ViewStepTotal localViewStepTotal = (ViewStepTotal)localArrayList2.get(0);
      Hashtable localHashtable1 = localViewStepTotal.getRouteIcons();
      Hashtable localHashtable2 = new Hashtable(localHashtable1);
      this._routeIcons = localHashtable2;
      ArrayList localArrayList3 = localViewStepTotal.getRouteLines();
      this._geoPoints = localArrayList3;
      RouteIcons localRouteIcons1 = (RouteIcons)this._routeIcons.remove("start");
      RouteIcons localRouteIcons2 = (RouteIcons)this._routeIcons.remove("end");
      int j = localRouteIcons1.getLat();
      int k = localRouteIcons1.getLon();
      GeoPoint localGeoPoint1 = new GeoPoint(j, k);
      OverlayItem localOverlayItem1 = new OverlayItem(localGeoPoint1, "Start", "");
      this._overlayItemStart = localOverlayItem1;
      int m = localRouteIcons2.getLat();
      int n = localRouteIcons2.getLon();
      GeoPoint localGeoPoint2 = new GeoPoint(m, n);
      OverlayItem localOverlayItem2 = new OverlayItem(localGeoPoint2, "End", "");
      this._overlayItemEnd = localOverlayItem2;
      OverlayItem localOverlayItem3 = new OverlayItem(localGeoPoint1, null, null);
      this._currentPixelOverlayItem = localOverlayItem3;
      OverlayItem localOverlayItem4 = new OverlayItem(localGeoPoint2, null, null);
      this._destPixelOverlayItem = localOverlayItem4;
      Drawable localDrawable2 = this._resource.getDrawable(2130837569);
      Drawable localDrawable3 = this._resource.getDrawable(2130837570);
      StartEndItemizedOverlay localStartEndItemizedOverlay1 = new StartEndItemizedOverlay(localDrawable2);
      StartEndItemizedOverlay localStartEndItemizedOverlay2 = new StartEndItemizedOverlay(localDrawable3);
      OverlayItem localOverlayItem5 = this._overlayItemStart;
      localStartEndItemizedOverlay1.addOverlay(localOverlayItem5);
      OverlayItem localOverlayItem6 = this._overlayItemEnd;
      localStartEndItemizedOverlay2.addOverlay(localOverlayItem6);
      if ((this._routeIcons != null) && (this._routeIcons.size() > 0))
      {
        InteractiveMapTask localInteractiveMapTask = new InteractiveMapTask(null);
        Object[] arrayOfObject = new Object[0];
        AsyncTask localAsyncTask = localInteractiveMapTask.execute(arrayOfObject);
      }
      populate();
      return;
      localModel = ApplicationEngine.getModel();
      i1 = this._index;
    }
  }

  protected OverlayItem createItem(int paramInt)
  {
    return (OverlayItem)this.items.get(paramInt);
  }

  public OverlayItem getOverlayItemEnd()
  {
    return this._overlayItemEnd;
  }

  public OverlayItem getOverlayItemStart()
  {
    return this._overlayItemStart;
  }

  public int size()
  {
    return this.items.size();
  }

  private class InteractiveMapTask extends AsyncTask<Object[], StartEndItemizedOverlay, String>
  {
    private InteractiveMapTask()
    {
    }

    protected String doInBackground(Object[][] paramArrayOfObject)
    {
      return null;
    }

    protected void onCancelled()
    {
      super.onCancelled();
    }

    protected void onPostExecute(String paramString)
    {
    }

    protected void onProgressUpdate(StartEndItemizedOverlay[] paramArrayOfStartEndItemizedOverlay)
    {
      super.onProgressUpdate(paramArrayOfStartEndItemizedOverlay);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.InteractiveMapOverlay
 * JD-Core Version:    0.6.2
 */