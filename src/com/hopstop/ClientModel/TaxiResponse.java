package com.hopstop.ClientModel;

import com.hopstop.ClientModel.directions.ViewStep;
import com.hopstop.ClientModel.directions.ViewStepAddress;
import com.hopstop.ClientModel.directions.ViewStepTaxi;
import com.hopstop.ClientModel.directions.ViewStepTotal;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class TaxiResponse
  implements Serializable
{
  private static final long serialVersionUID = 4857073440784363322L;
  private ArrayList<ViewStep> _steps;
  private double abDistance;
  private String address1;
  private String address2;
  private String routeId;
  private double segmentsLen;
  private int time;
  private int totalTime;
  private String totalTimeText;
  private String totalTimeVerb;
  private String zip1;
  private String zip2;

  public TaxiResponse()
  {
    ArrayList localArrayList = new ArrayList();
    this._steps = localArrayList;
  }

  private String convertSecondsToHours(int paramInt)
  {
    int i = 1;
    int j = paramInt / 3600;
    int k = paramInt % 3600;
    int m = k / 60;
    int n;
    label40: String str1;
    label90: String str2;
    String str3;
    label129: String str4;
    String str5;
    if (k % 60 > 29)
    {
      n = 1;
      if (n == 0)
        break label207;
      int i1 = m + i;
      if ((n != 0) && (i1 == 60))
      {
        j += 1;
        i1 = 0;
      }
      StringBuilder localStringBuilder1 = new StringBuilder().append(j);
      if (!isPlural(j))
        break label212;
      str1 = " hours";
      str2 = str1;
      StringBuilder localStringBuilder2 = new StringBuilder().append(i1);
      if (!isPlural(i1))
        break label219;
      str3 = " mins";
      str4 = str3;
      if (j == 0)
        str2 = "";
      if (i1 == 0)
        str4 = "";
      if ((j <= 0) || (i1 <= 0))
        break label226;
      str5 = String.valueOf(str2);
    }
    label207: label212: label219: label226: String str7;
    for (String str6 = str5 + " " + str4; ; str6 = str7 + str4)
    {
      return str6;
      n = 0;
      break;
      i = 0;
      break label40;
      str1 = " hour";
      break label90;
      str3 = " min";
      break label129;
      str7 = String.valueOf(str2);
    }
  }

  private boolean isPlural(int paramInt)
  {
    int i = 1;
    if (paramInt > i);
    while (true)
    {
      return i;
      i = 0;
    }
  }

  public void addDirectionSteps(ArrayList<ViewStep> paramArrayList)
  {
    boolean bool = this._steps.addAll(paramArrayList);
  }

  public void addStartEndAddresses(ViewStepTotal paramViewStepTotal, ViewStepAddress paramViewStepAddress1, ViewStepAddress paramViewStepAddress2)
  {
    ViewStepTotal localViewStepTotal = paramViewStepTotal;
    localViewStepTotal.setTaxi(1);
    this._steps.add(0, localViewStepTotal);
    this._steps.add(1, paramViewStepAddress1);
    this._steps.add(2, paramViewStepAddress2);
  }

  public void addStartEndAddresses(ArrayList<ViewStep> paramArrayList)
  {
    ViewStepTotal localViewStepTotal = (ViewStepTotal)paramArrayList.get(0);
    String str1 = this.totalTimeText;
    localViewStepTotal.setTotalTimeVerb(str1);
    String str2 = this.totalTimeVerb;
    localViewStepTotal.setDuration(str2);
    localViewStepTotal.setTaxi(1);
    this._steps.add(0, localViewStepTotal);
    ArrayList localArrayList1 = this._steps;
    ViewStep localViewStep1 = (ViewStep)paramArrayList.get(1);
    localArrayList1.add(1, localViewStep1);
    ArrayList localArrayList2 = this._steps;
    ViewStep localViewStep2 = (ViewStep)paramArrayList.get(2);
    localArrayList2.add(2, localViewStep2);
  }

  public void addTaxiViewStep(ViewStepTaxi paramViewStepTaxi)
  {
    boolean bool = this._steps.add(paramViewStepTaxi);
  }

  public double getAbDistance()
  {
    return this.abDistance;
  }

  public String getAddress1()
  {
    return this.address1;
  }

  public String getAddress2()
  {
    return this.address2;
  }

  public String getFullAddress1()
  {
    String str1 = String.valueOf(this.address1);
    StringBuilder localStringBuilder1 = new StringBuilder(str1);
    if (this.zip1 == null);
    StringBuilder localStringBuilder2;
    String str3;
    for (String str2 = ""; ; str2 = str3)
    {
      return str2;
      localStringBuilder2 = new StringBuilder(", ");
      str3 = this.zip1;
    }
  }

  public String getFullAddress2()
  {
    String str1 = String.valueOf(this.address2);
    StringBuilder localStringBuilder1 = new StringBuilder(str1);
    if (this.zip2 == null);
    StringBuilder localStringBuilder2;
    String str3;
    for (String str2 = ""; ; str2 = str3)
    {
      return str2;
      localStringBuilder2 = new StringBuilder(", ");
      str3 = this.zip2;
    }
  }

  public String getKeyWords()
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
      if (this.address1 != null)
      {
        String str7 = String.valueOf(str2);
        StringBuilder localStringBuilder3 = new StringBuilder(str7);
        String str8 = this.address1;
        str2 = str8 + ",";
      }
      if (this.address2 != null)
      {
        String str9 = String.valueOf(str2);
        StringBuilder localStringBuilder4 = new StringBuilder(str9);
        String str10 = this.address2;
        str2 = str10 + ",";
      }
      if ((str2 != null) && (str2.contains(",")))
      {
        int i = str2.lastIndexOf(",");
        str2 = str2.substring(0, i);
      }
    }
  }

  public String getRouteId()
  {
    return this.routeId;
  }

  public double getSegmentsLen()
  {
    return this.segmentsLen;
  }

  public int getTime()
  {
    return this.time;
  }

  public int getTotalTime()
  {
    return this.totalTime;
  }

  public String getTotalTimeVerb()
  {
    return this.totalTimeVerb;
  }

  public ArrayList<ViewStep> getViewStepTaxi()
  {
    return this._steps;
  }

  public int getViewStepTaxiCount()
  {
    if (this._steps != null);
    for (int i = this._steps.size(); ; i = 0)
      return i;
  }

  public String getZip1()
  {
    return this.zip1;
  }

  public String getZip2()
  {
    return this.zip2;
  }

  public void setAbDistance(double paramDouble)
  {
    this.abDistance = paramDouble;
  }

  public void setAddress1(String paramString)
  {
    if ((paramString == null) || (paramString.equals(" ")))
    {
      this.address1 = "Current Location (Approximate)";
      return;
    }
    this.address1 = paramString;
  }

  public void setAddress2(String paramString)
  {
    if ((paramString == null) || (paramString.equals(" ")))
    {
      this.address2 = "Current Location (Approximate)";
      return;
    }
    this.address2 = paramString;
  }

  public void setRouteId(String paramString)
  {
    this.routeId = paramString;
  }

  public void setSegmentsLen(double paramDouble)
  {
    this.segmentsLen = paramDouble;
  }

  public void setTime(int paramInt)
  {
    this.time = paramInt;
  }

  public void setTotalTime(int paramInt)
  {
    this.totalTime = paramInt;
  }

  public void setTotalTimeVerb(double paramDouble, int paramInt)
  {
    this.segmentsLen = paramDouble;
    String str1 = convertSecondsToHours(paramInt);
    this.totalTimeVerb = str1;
    DecimalFormat localDecimalFormat = new DecimalFormat("#.##");
    Object[] arrayOfObject = new Object[2];
    double d = this.segmentsLen;
    String str2 = localDecimalFormat.format(d);
    arrayOfObject[0] = str2;
    String str3 = this.totalTimeVerb;
    arrayOfObject[1] = str3;
    String str4 = String.format("TOTAL TRAVEL %1$s miles, %2$s", arrayOfObject);
    this.totalTimeText = str4;
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
 * Qualified Name:     com.hopstop.ClientModel.TaxiResponse
 * JD-Core Version:    0.6.2
 */