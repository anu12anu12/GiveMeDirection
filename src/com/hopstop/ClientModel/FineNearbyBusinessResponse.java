package com.hopstop.ClientModel;

import com.hopstop.ClientModel.xml.YextBusiness;
import com.hopstop.network.NetworkSettings;
import java.util.ArrayList;

public class FineNearbyBusinessResponse
{
  private int _result;
  private ArrayList<YextBusiness> _yBusiness;

  public FineNearbyBusinessResponse()
  {
    int i = NetworkSettings.FAIL_GET_NEARBY_BUSINESS;
    this._result = i;
    ArrayList localArrayList = new ArrayList();
    this._yBusiness = localArrayList;
  }

  public void addYextBusiness(YextBusiness paramYextBusiness)
  {
    boolean bool = this._yBusiness.add(paramYextBusiness);
  }

  public int getResult()
  {
    return this._result;
  }

  public ArrayList<YextBusiness> getYextBussiness()
  {
    return this._yBusiness;
  }

  public void setResult(int paramInt)
  {
    this._result = paramInt;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.FineNearbyBusinessResponse
 * JD-Core Version:    0.6.2
 */