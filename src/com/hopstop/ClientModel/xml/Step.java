package com.hopstop.ClientModel.xml;

import android.graphics.Bitmap;
import java.io.Serializable;

public class Step
  implements Serializable
{
  private static final long serialVersionUID = -979274237610116385L;
  private String directions;
  private boolean hasDiversion;
  private boolean hasIcon;
  private int iconHeight = 0;
  private int iconWidth = 0;
  private String optionalVehicles = "";
  private String path;
  private Bitmap pathIcon;
  private double stepTime;
  private int stop_id;
  private String type;
  private long vehicle_id;
  private String vehicle_name;

  public Step clone()
  {
    Step localStep = new Step();
    String str1 = this.directions;
    localStep.setDirections(str1);
    int i = this.iconHeight;
    localStep.setIconHeight(i);
    int j = this.iconWidth;
    localStep.setIconWidth(j);
    String str2 = this.optionalVehicles;
    localStep.setOptionlVehicle(str2);
    String str3 = this.path;
    localStep.setPath(str3);
    double d = this.stepTime;
    localStep.setStepTime(d);
    int k = this.stop_id;
    localStep.setStop_id(k);
    String str4 = this.type;
    localStep.setType(str4);
    long l = this.vehicle_id;
    localStep.setVehicle_id(l);
    String str5 = this.vehicle_name;
    localStep.setVehicle_name(str5);
    return localStep;
  }

  public String getDirections()
  {
    return this.directions;
  }

  public Bitmap getIcon()
  {
    return this.pathIcon;
  }

  public int getIconHeight()
  {
    return this.iconHeight;
  }

  public int getIconWidth()
  {
    return this.iconWidth;
  }

  public String getOptionlVehicle()
  {
    return this.optionalVehicles;
  }

  public String getPath()
  {
    return this.path;
  }

  public double getStepTime()
  {
    return this.stepTime;
  }

  public int getStop_id()
  {
    return this.stop_id;
  }

  public String getType()
  {
    return this.type;
  }

  public long getVehicle_id()
  {
    return this.vehicle_id;
  }

  public String getVehicle_name()
  {
    return this.vehicle_name;
  }

  public boolean hasDiversion()
  {
    return this.hasDiversion;
  }

  public boolean hasIcon()
  {
    return this.hasIcon;
  }

  public void parseOptionalVehicle(String paramString)
  {
    String[] arrayOfString1 = paramString.replace("=>", "").split(";");
    int i = 0;
    int j = arrayOfString1.length;
    if (i >= j)
      return;
    String[] arrayOfString2 = paramString.split(",");
    int k = arrayOfString1.length + -1;
    String str3;
    if (i != k)
    {
      String str1 = String.valueOf(this.optionalVehicles);
      StringBuilder localStringBuilder1 = new StringBuilder(str1);
      String str2 = arrayOfString2[4];
      str3 = str2;
    }
    String str6;
    for (this.optionalVehicles = str3; ; this.optionalVehicles = str6)
    {
      i += 1;
      break;
      String str4 = String.valueOf(this.optionalVehicles);
      StringBuilder localStringBuilder2 = new StringBuilder(str4);
      String str5 = arrayOfString2[4];
      str6 = str5 + ", ";
    }
  }

  public void setBitmap(Bitmap paramBitmap)
  {
    this.pathIcon = paramBitmap;
  }

  public void setDirections(String paramString)
  {
    this.directions = paramString;
  }

  public void setHasDiversion(boolean paramBoolean)
  {
    this.hasDiversion = paramBoolean;
  }

  public void setIconHeight(int paramInt)
  {
    this.iconHeight = paramInt;
  }

  public void setIconWidth(int paramInt)
  {
    this.iconWidth = paramInt;
  }

  public void setOptionlVehicle(String paramString)
  {
    this.optionalVehicles = paramString;
  }

  public void setPath(String paramString)
  {
    this.path = paramString;
    if (this.path == null)
      return;
    if (this.path.length() <= 0)
      return;
    this.hasIcon = true;
  }

  public void setStepTime(double paramDouble)
  {
    this.stepTime = paramDouble;
  }

  public void setStop_id(int paramInt)
  {
    this.stop_id = paramInt;
  }

  public void setType(String paramString)
  {
    this.type = paramString;
  }

  public void setVehicle_id(long paramLong)
  {
    this.vehicle_id = paramLong;
  }

  public void setVehicle_name(String paramString)
  {
    this.vehicle_name = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.xml.Step
 * JD-Core Version:    0.6.2
 */