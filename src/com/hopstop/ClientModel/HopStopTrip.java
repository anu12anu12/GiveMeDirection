package com.hopstop.ClientModel;

import com.hopstop.ClientModel.xml.Step;
import java.util.ArrayList;
import java.util.Iterator;

public class HopStopTrip
{
  private String address1;
  private String address2;
  private String city1;
  private String city2;
  private String county1;
  private String county2;
  private ArrayList<HopStopMap> maps;
  private String name;
  private String routeId;
  private String shareText;
  private ArrayList<Step> steps;
  private String totalTravelTime;
  private String zip1;
  private String zip2;

  public HopStopTrip()
  {
    ArrayList localArrayList1 = new ArrayList();
    this.steps = localArrayList1;
    ArrayList localArrayList2 = new ArrayList();
    this.maps = localArrayList2;
  }

  private void parseSteps(String paramString)
  {
    if (paramString == null)
      return;
    String[] arrayOfString = paramString.split("\t");
    int i = arrayOfString.length;
    Step localStep = new Step();
    int j = 0;
    if (j >= i)
      return;
    String str1 = "\n";
    int k = arrayOfString[j].indexOf(str1);
    String str3;
    if (k > 0)
    {
      String str2 = arrayOfString[j];
      int m = str1.length() + k;
      str3 = str2.substring(m);
      label79: arrayOfString[j] = str3;
      if (j % 16 != 0)
        break label124;
      String str4 = arrayOfString[j];
      localStep.setDirections(str4);
    }
    label124: int i13;
    label322: label365: label369: 
    do
    {
      while (true)
      {
        j += 1;
        break;
        str3 = arrayOfString[j];
        break label79;
        int n = j % 16;
        if (1 != n)
        {
          double d = Double.parseDouble(arrayOfString[j]) / 60.0D;
          localStep.setStepTime(d);
        }
        else
        {
          int i1 = j % 16;
          if (2 != i1)
          {
            String str5 = arrayOfString[j];
            localStep.setType(str5);
          }
          else
          {
            int i2 = j % 16;
            if (3 != i2)
            {
              String str6 = arrayOfString[j];
              localStep.setPath(str6);
            }
            else if (localStep.hasIcon())
            {
              int i3 = j % 16;
              if (4 != i3)
              {
                int i4 = Integer.parseInt(arrayOfString[j]);
                localStep.setIconWidth(i4);
              }
            }
            else if (localStep.hasIcon())
            {
              int i5 = j % 16;
              if (5 != i5)
              {
                int i6 = Integer.parseInt(arrayOfString[j]);
                localStep.setIconHeight(i6);
              }
            }
            else
            {
              int i7 = j % 16;
              if (6 != i7)
              {
                int i8;
                if (arrayOfString[j] != null)
                {
                  i8 = 1;
                  if (arrayOfString[j].length() <= 0)
                    break label365;
                }
                for (i9 = 1; ; i9 = 0)
                {
                  if ((i8 & i9) == 0)
                    break label369;
                  String str7 = arrayOfString[j];
                  localStep.parseOptionalVehicle(str7);
                  break;
                  i8 = 0;
                  break label322;
                }
              }
              else
              {
                int i10 = j % 16;
                if (12 == i10)
                  break label447;
                int i11;
                if (arrayOfString[j] != null)
                {
                  i11 = 1;
                  if (arrayOfString[j].length() <= 0)
                    break label441;
                }
                for (i9 = 1; ; i9 = 0)
                {
                  if ((i11 & i9) == 0)
                    break label445;
                  int i12 = Integer.parseInt(arrayOfString[j]);
                  localStep.setStop_id(i12);
                  break;
                  i11 = 0;
                  break label395;
                }
              }
            }
          }
        }
      }
      i13 = j % 16;
    }
    while (15 == i13);
    label395: label441: label445: label447: int i14;
    if (arrayOfString[j] != null)
    {
      i14 = 1;
      label471: if (arrayOfString[j].length() <= 0)
        break label537;
    }
    label537: for (int i9 = 1; ; i9 = 0)
    {
      if ((i14 & i9) != 0)
      {
        long l = Long.parseLong(arrayOfString[j]);
        localStep.setVehicle_id(l);
      }
      boolean bool = this.steps.add(localStep);
      localStep = new Step();
      break;
      i14 = 0;
      break label471;
    }
  }

  public void InitHopStopTrip(DirectionResponse paramDirectionResponse, String paramString)
  {
    if (paramDirectionResponse == null)
      return;
    setName(paramString);
  }

  public void clear()
  {
    this.maps.clear();
    this.steps.clear();
  }

  public void clone(HopStopTrip paramHopStopTrip)
  {
    if (paramHopStopTrip == null)
      return;
    String str1 = paramHopStopTrip.getName();
    setName(str1);
    String str2 = paramHopStopTrip.getAddress1();
    setAddress1(str2);
    String str3 = paramHopStopTrip.getCounty1();
    setCounty1(str3);
    String str4 = paramHopStopTrip.getCity1();
    setCity1(str4);
    String str5 = paramHopStopTrip.getZip1();
    setZip1(str5);
    String str6 = paramHopStopTrip.getAddress2();
    setAddress2(str6);
    String str7 = paramHopStopTrip.getCounty2();
    setCounty2(str7);
    String str8 = paramHopStopTrip.getCity2();
    setCity2(str8);
    String str9 = paramHopStopTrip.getZip2();
    setZip2(str9);
    String str10 = paramHopStopTrip.getTotalTravelTime();
    setTotalTravelTime(str10);
    String str11 = paramHopStopTrip.getShareText();
    setShareText(str11);
    String str12 = paramHopStopTrip.getRouteId();
    setRouteId(str12);
    this.steps.clear();
    this.maps.clear();
    Iterator localIterator1 = paramHopStopTrip.getSteps().iterator();
    while (true)
    {
      if (!localIterator1.hasNext())
      {
        Iterator localIterator2 = paramHopStopTrip.getMaps().iterator();
        while (true)
        {
          if (!localIterator2.hasNext())
            return;
          HopStopMap localHopStopMap = ((HopStopMap)localIterator2.next()).clone();
          boolean bool1 = this.maps.add(localHopStopMap);
        }
      }
      Step localStep = ((Step)localIterator1.next()).clone();
      boolean bool2 = this.steps.add(localStep);
    }
  }

  public String getAddress1()
  {
    return this.address1;
  }

  public String getAddress2()
  {
    return this.address2;
  }

  public String getCity1()
  {
    return this.city1;
  }

  public String getCity2()
  {
    return this.city2;
  }

  public String getCounty1()
  {
    return this.county1;
  }

  public String getCounty2()
  {
    return this.county2;
  }

  public String getFullAddress1()
  {
    String str1 = String.valueOf(getAddress1());
    StringBuilder localStringBuilder1 = new StringBuilder(str1);
    String str2;
    StringBuilder localStringBuilder2;
    if (getCounty1() == null)
    {
      str2 = "";
      localStringBuilder2 = localStringBuilder1.append(str2);
      if (getZip1() != null)
        break label88;
    }
    label88: StringBuilder localStringBuilder4;
    String str5;
    for (String str3 = ""; ; str3 = str5)
    {
      return str3;
      StringBuilder localStringBuilder3 = new StringBuilder(", ");
      String str4 = getCounty1();
      str2 = str4;
      break;
      localStringBuilder4 = new StringBuilder(", ");
      str5 = getZip1();
    }
  }

  public String getFullAddress2()
  {
    String str1 = String.valueOf(getAddress2());
    StringBuilder localStringBuilder1 = new StringBuilder(str1);
    String str2;
    StringBuilder localStringBuilder2;
    if (getCounty2() == null)
    {
      str2 = "";
      localStringBuilder2 = localStringBuilder1.append(str2);
      if (getZip2() != null)
        break label88;
    }
    label88: StringBuilder localStringBuilder4;
    String str5;
    for (String str3 = ""; ; str3 = str5)
    {
      return str3;
      StringBuilder localStringBuilder3 = new StringBuilder(", ");
      String str4 = getCounty2();
      str2 = str4;
      break;
      localStringBuilder4 = new StringBuilder(", ");
      str5 = getZip2();
    }
  }

  public String getKeyWords(String paramString1, String paramString2)
  {
    if (this == null);
    String str2;
    for (String str1 = ""; ; str1 = str2.toLowerCase())
    {
      return str1;
      str2 = "";
      if (this.zip1 != null)
      {
        String str3 = String.valueOf(str2);
        StringBuilder localStringBuilder1 = new StringBuilder(str3);
        String str4 = this.zip1;
        str2 = str4 + ",";
      }
      if (this.zip2 != null)
      {
        String str5 = String.valueOf(str2);
        StringBuilder localStringBuilder2 = new StringBuilder(str5);
        String str6 = this.zip2;
        str2 = str6 + ",";
      }
      if (paramString1 != null)
      {
        String str7 = String.valueOf(str2);
        str2 = str7 + paramString1 + ",";
      }
      if (paramString2 != null)
      {
        String str8 = String.valueOf(str2);
        str2 = str8 + paramString2 + ",";
      }
      if (this.address1 != null)
      {
        String str9 = String.valueOf(str2);
        StringBuilder localStringBuilder3 = new StringBuilder(str9);
        String str10 = this.address1;
        str2 = str10 + ",";
      }
      if (this.address2 != null)
      {
        String str11 = String.valueOf(str2);
        StringBuilder localStringBuilder4 = new StringBuilder(str11);
        String str12 = this.address2;
        str2 = str12 + ",";
      }
      if (str2 != null)
      {
        int i = str2.lastIndexOf(",");
        str2 = str2.substring(0, i);
      }
    }
  }

  public ArrayList<HopStopMap> getMaps()
  {
    return this.maps;
  }

  public String getName()
  {
    return this.name;
  }

  public String getRouteId()
  {
    return this.routeId;
  }

  public String getShareText()
  {
    return this.shareText;
  }

  public ArrayList<Step> getSteps()
  {
    if (this.steps == null);
    for (Object localObject = null; ; localObject = this.steps)
      return localObject;
  }

  public String getTotalTravelTime()
  {
    return this.totalTravelTime;
  }

  public String getZip1()
  {
    return this.zip1;
  }

  public String getZip2()
  {
    return this.zip2;
  }

  public void setAddress1(String paramString)
  {
    this.address1 = paramString;
  }

  public void setAddress2(String paramString)
  {
    this.address2 = paramString;
  }

  public void setCity1(String paramString)
  {
    this.city1 = paramString;
  }

  public void setCity2(String paramString)
  {
    this.city2 = paramString;
  }

  public void setCounty1(String paramString)
  {
    this.county1 = paramString;
  }

  public void setCounty2(String paramString)
  {
    this.county2 = paramString;
  }

  public void setMaps(ArrayList<HopStopMap> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(paramArrayList);
    this.maps = localArrayList;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setRouteId(String paramString)
  {
    this.routeId = paramString;
  }

  public void setShareText(String paramString)
  {
    this.shareText = paramString;
  }

  public void setSteps(ArrayList<Step> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(paramArrayList);
    this.steps = localArrayList;
  }

  public void setTotalTravelTime(String paramString)
  {
    this.totalTravelTime = paramString;
  }

  public void setZip1(String paramString)
  {
    this.zip1 = paramString;
  }

  public void setZip2(String paramString)
  {
    this.zip2 = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.HopStopTrip
 * JD-Core Version:    0.6.2
 */