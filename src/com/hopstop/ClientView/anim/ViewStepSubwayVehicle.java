package com.hopstop.ClientView.anim;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.widget.ImageView;
import com.hopstop.ClientModel.directions.LoadImageFromNetworkTask;
import com.hopstop.ClientModel.directions.ViewStep;
import com.hopstop.core.ApplicationEngine;
import java.io.Serializable;

public class ViewStepSubwayVehicle
  implements ViewStep, Serializable
{
  public static String BUS = "B";
  private static String HOPSTOP_URL = "http://www.hopstop.com/i";
  public static String REGIONAL_RAIL;
  public static String SUBWAY_TRAIN = "S";
  private static final long serialVersionUID = -9063115787735111778L;
  private boolean _hasIcon;
  private String _id;
  private ImageView _imgView = null;
  private boolean _isDownloading;
  private String _name;
  private String _status;
  private String _statusDescription;
  private String _type;
  private String _url;
  private Bitmap _vehicleIcon;
  private String _verbTime;

  static
  {
    REGIONAL_RAIL = "R";
  }

  public ViewStepSubwayVehicle cloneItself()
  {
    ViewStepSubwayVehicle localViewStepSubwayVehicle = new ViewStepSubwayVehicle();
    String str1 = this._url;
    localViewStepSubwayVehicle._url = str1;
    String str2 = this._type;
    localViewStepSubwayVehicle.setType(str2);
    String str3 = this._id;
    localViewStepSubwayVehicle.setId(str3);
    String str4 = this._name;
    localViewStepSubwayVehicle.setName(str4);
    String str5 = this._verbTime;
    localViewStepSubwayVehicle.setVerbTime(str5);
    String str6 = this._statusDescription;
    localViewStepSubwayVehicle.setStatusDescription(str6);
    String str7 = this._status;
    localViewStepSubwayVehicle.setStatus(str7);
    Bitmap localBitmap = this._vehicleIcon;
    localViewStepSubwayVehicle.setBitmap(localBitmap);
    ImageView localImageView = this._imgView;
    localViewStepSubwayVehicle.setImageView(localImageView);
    boolean bool1 = this._isDownloading;
    localViewStepSubwayVehicle._isDownloading = bool1;
    boolean bool2 = this._hasIcon;
    localViewStepSubwayVehicle._hasIcon = bool2;
    return localViewStepSubwayVehicle;
  }

  public void downloadError(int paramInt)
  {
  }

  public Bitmap getBitmap()
  {
    return this._vehicleIcon;
  }

  public ViewStepSubwayVehicleSubClass getDetails(String paramString)
  {
    String str1 = this._name;
    String str2 = this._status;
    String str3 = this._type;
    String str4 = this._statusDescription;
    String str5 = this._url;
    String str6 = this._verbTime;
    String str7 = paramString;
    return new ViewStepSubwayVehicleSubClass(str1, str2, str3, str4, str5, str6, str7);
  }

  public String getId()
  {
    return this._id;
  }

  public String getName()
  {
    return this._name;
  }

  public String getStatus()
  {
    return this._status;
  }

  public String getStatusDescription()
  {
    return this._statusDescription;
  }

  public String getType()
  {
    return this._type;
  }

  public String getURL()
  {
    return this._url;
  }

  public String getVerbTime()
  {
    return this._verbTime;
  }

  public boolean hasIcon()
  {
    return this._hasIcon;
  }

  public boolean isDownloading()
  {
    return this._isDownloading;
  }

  public void recycle(boolean paramBoolean)
  {
  }

  public void setBitmap(Bitmap paramBitmap)
  {
    this._vehicleIcon = paramBitmap;
    if (this._imgView == null)
      return;
    ImageView localImageView1 = this._imgView;
    float f1 = paramBitmap.getWidth();
    float f2 = ApplicationEngine.DEVICE_DENSITY;
    int i = (int)(f1 * f2) + 30;
    localImageView1.setMinimumWidth(i);
    ImageView localImageView2 = this._imgView;
    float f3 = paramBitmap.getHeight();
    float f4 = ApplicationEngine.DEVICE_DENSITY;
    int j = (int)(f3 * f4);
    localImageView2.setMinimumHeight(j);
    ImageView localImageView3 = this._imgView;
    Bitmap localBitmap = this._vehicleIcon;
    localImageView3.setImageBitmap(localBitmap);
  }

  public void setDownloading(boolean paramBoolean)
  {
    this._isDownloading = paramBoolean;
  }

  public void setId(String paramString)
  {
    this._id = paramString;
  }

  public void setImageView(ImageView paramImageView)
  {
    this._imgView = paramImageView;
  }

  public void setName(String paramString)
  {
    String str = paramString;
    this._name = str;
  }

  public void setStatus(String paramString)
  {
    this._status = paramString;
  }

  public void setStatusDescription(String paramString)
  {
    this._statusDescription = paramString;
  }

  public void setType(String paramString)
  {
    this._type = paramString;
  }

  public void setURL(String paramString, boolean paramBoolean)
  {
    String str1 = HOPSTOP_URL;
    String str4;
    if (paramString.startsWith(str1))
    {
      int i = HOPSTOP_URL.length() + 1;
      String str2 = paramString.substring(i);
      String str3 = String.valueOf(HOPSTOP_URL);
      str4 = str3 + str2;
    }
    for (this._url = str4; ; this._url = paramString)
    {
      if (this._url == null)
        return;
      if (this._url.length() <= 0)
        return;
      this._hasIcon = true;
      String str5 = this._type;
      String str6 = REGIONAL_RAIL;
      if (!str5.equalsIgnoreCase(str6))
        break;
      Paint localPaint = new Paint();
      Paint.Style localStyle = Paint.Style.FILL;
      localPaint.setStyle(localStyle);
      localPaint.setColor(-65536);
      localPaint.setTextSize(12.0F);
      Typeface localTypeface1 = Typeface.create("Arial", 0);
      Typeface localTypeface2 = localPaint.setTypeface(localTypeface1);
      localPaint.setAntiAlias(true);
      Typeface localTypeface3 = Typeface.MONOSPACE;
      Typeface localTypeface4 = localPaint.setTypeface(localTypeface3);
      Bitmap.Config localConfig = Bitmap.Config.ALPHA_8;
      Bitmap localBitmap1 = Bitmap.createBitmap(170, 25, localConfig);
      this._vehicleIcon = localBitmap1;
      Bitmap localBitmap2 = this._vehicleIcon;
      Canvas localCanvas = new Canvas(localBitmap2);
      String str7 = this._name;
      localCanvas.drawText(str7, 0.0F, 16.0F, localPaint);
      return;
    }
    if (!paramBoolean)
      return;
    ImageView localImageView = this._imgView;
    LoadImageFromNetworkTask.addToQueue(this, localImageView);
  }

  public void setURL(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    this._url = paramString;
    if (this._url == null)
      return;
    if (this._url.length() <= 0)
      return;
    this._hasIcon = true;
    String str1 = this._type;
    String str2 = REGIONAL_RAIL;
    if (str1.equalsIgnoreCase(str2))
    {
      Paint localPaint = new Paint();
      Paint.Style localStyle = Paint.Style.FILL;
      localPaint.setStyle(localStyle);
      localPaint.setColor(-65536);
      localPaint.setTextSize(19.0F);
      localPaint.setAntiAlias(true);
      Typeface localTypeface1 = Typeface.MONOSPACE;
      Typeface localTypeface2 = localPaint.setTypeface(localTypeface1);
      Bitmap.Config localConfig = Bitmap.Config.ALPHA_8;
      Bitmap localBitmap1 = Bitmap.createBitmap(200, 25, localConfig);
      this._vehicleIcon = localBitmap1;
      Bitmap localBitmap2 = this._vehicleIcon;
      Canvas localCanvas = new Canvas(localBitmap2);
      String str3 = this._name;
      localCanvas.drawText(str3, 0.0F, 16.0F, localPaint);
      if (this._imgView == null)
        return;
      ImageView localImageView1 = this._imgView;
      Bitmap localBitmap3 = this._vehicleIcon;
      localImageView1.setImageBitmap(localBitmap3);
      return;
    }
    if (!paramBoolean2)
      return;
    ImageView localImageView2 = this._imgView;
    LoadImageFromNetworkTask.addToQueue(this, localImageView2);
  }

  public void setVerbTime(String paramString)
  {
    this._verbTime = paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.anim.ViewStepSubwayVehicle
 * JD-Core Version:    0.6.2
 */