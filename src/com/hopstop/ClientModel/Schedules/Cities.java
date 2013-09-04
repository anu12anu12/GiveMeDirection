package com.hopstop.ClientModel.Schedules;

import com.hopstop.ClientModel.ResponseStatus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class Cities
  implements Serializable
{

  @ElementList(name="Cities")
  private ArrayList<City> cityList;

  @Element(name="ResponseStatus", required=false)
  private ResponseStatus responseStatus;

  public Cities()
  {
    ArrayList localArrayList = new ArrayList();
    this.cityList = localArrayList;
  }

  public Cities(ArrayList<City> paramArrayList)
  {
    this.cityList = paramArrayList;
  }

  public Cities(List<City> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    this.cityList = localArrayList;
    boolean bool = this.cityList.addAll(paramList);
  }

  public void addCity(int paramInt, City paramCity)
    throws IndexOutOfBoundsException
  {
    this.cityList.add(paramInt, paramCity);
  }

  public void addCity(City paramCity)
    throws IndexOutOfBoundsException
  {
    boolean bool = this.cityList.add(paramCity);
  }

  public ArrayList<City> getCities()
  {
    return this.cityList;
  }

  public City getCity(int paramInt)
    throws IndexOutOfBoundsException
  {
    if (paramInt >= 0)
    {
      int i = this.cityList.size();
      if (paramInt < i);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder("getCity: Index value '").append(paramInt).append("' not in range [0..");
      int j = this.cityList.size() + -1;
      String str = j + "]";
      throw new IndexOutOfBoundsException(str);
    }
    return (City)this.cityList.get(paramInt);
  }

  public City[] getCity()
  {
    City[] arrayOfCity = new City[0];
    return (City[])this.cityList.toArray(arrayOfCity);
  }

  public int getCityCount()
  {
    return this.cityList.size();
  }

  public ResponseStatus getResponseStatus()
  {
    return this.responseStatus;
  }

  public int getSize()
  {
    return this.cityList.size();
  }

  public void removeAllCity()
  {
    this.cityList.clear();
  }

  public boolean removeCity(City paramCity)
  {
    return this.cityList.remove(paramCity);
  }

  public City removeCityAt(int paramInt)
  {
    return (City)this.cityList.remove(paramInt);
  }

  public void setCity(int paramInt, City paramCity)
    throws IndexOutOfBoundsException
  {
    if (paramInt >= 0)
    {
      int i = this.cityList.size();
      if (paramInt < i);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder("setCity: Index value '").append(paramInt).append("' not in range [0..");
      int j = this.cityList.size() + -1;
      String str = j + "]";
      throw new IndexOutOfBoundsException(str);
    }
    Object localObject = this.cityList.set(paramInt, paramCity);
  }

  public void setCity(City[] paramArrayOfCity)
  {
    this.cityList.clear();
    int i = 0;
    while (true)
    {
      int j = paramArrayOfCity.length;
      if (i >= j)
        return;
      ArrayList localArrayList = this.cityList;
      City localCity = paramArrayOfCity[i];
      boolean bool = localArrayList.add(localCity);
      i += 1;
    }
  }

  public void setResponseStatus(ResponseStatus paramResponseStatus)
  {
    this.responseStatus = paramResponseStatus;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Schedules.Cities
 * JD-Core Version:    0.6.2
 */