package com.hopstop.ClientModel.directions;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.ImageView;
import com.crittercism.app.Crittercism;
import com.hopstop.ClientView.DirectionsResultActivity;
import com.hopstop.network.DrawableManager;
import com.hopstop.network.NetworkEngine;
import com.hopstop.ui.ChevronImageView;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Commit;

@Root(strict=false)
public class ViewStepDirections
  implements Serializable, ViewStep
{
  private Bitmap _bitmapDiversion;
  private Context _context;

  @Element(name="Distance", required=false)
  private float _distance;
  private String _diversion;

  @Element(name="Icon", required=false)
  private Icon _icon;

  @Element(name="Notes", required=false)
  private String _notes;

  @ElementList(name="OptionalVehicles", required=false)
  private ArrayList<Vehicle> _optionalVehicles;

  @Element(name="Phone", required=false)
  private String _phone;

  @Element(name="Price", required=false)
  private float _price;

  @Element(name="Vehicle", required=false)
  private Vehicle _vehicle;

  @Element(name="VehicleRoute", required=false)
  private VehicleRoute _vehicleRoute;
  private WrappedImageViewLayout _wivl;
  private int _wrappedListIndex = -1;

  @Element(name="BikeFriendly", required=false)
  private int bikeFriendly = 0;
  private ChevronImageView chevron;
  private int directionViewStarts = 0;

  @Element(name="Text", required=false)
  private String directions;
  private boolean hasDiversion;
  private boolean hasIcon;
  private boolean haveChevron = false;
  private int iconHeight = 0;
  private int iconWidth = 0;
  private ImageView imgView = null;
  private boolean isBikeAndNeedToSetWidth = false;
  private boolean isBikeFriendly = false;
  private boolean isDestroyed = false;
  private boolean isDownloading;
  private boolean isSaved = false;
  private String[] optionalVehicles = null;
  private String path;
  private Bitmap pathIcon;
  private int stepLenght;
  private String stepTime;

  @Element(name="Time", required=false)
  private String time;

  @Element(name="Type", required=false)
  private String type;
  private String urlString;
  private String useAnotherStop;
  private String useAnotherTransfer;
  private String vehicle_id;
  private String vehicle_name;

  @Element(name="WalkingPartInfo", required=false)
  private WalkingPartInfo walkingPartInfo;

  private String[] extractVehicles(String paramString)
  {
    String str1 = "";
    if (paramString.startsWith("http://www.hopstop.com/i2/=>"))
    {
      int i = "http://www.hopstop.com/i2/=>".length();
      str1 = paramString.substring(i);
    }
    String[] arrayOfString1;
    String[] arrayOfString2;
    int j;
    if (str1.length() > 0)
    {
      arrayOfString1 = str1.split(";");
      arrayOfString2 = new String[arrayOfString1.length * 2];
      String[] arrayOfString3 = (String[])null;
      j = 0;
      int k = arrayOfString1.length;
      if (j < k);
    }
    while (true)
    {
      return arrayOfString2;
      String[] arrayOfString4 = arrayOfString1[j].split(",");
      int m = j * 2 + 0;
      String str2 = arrayOfString4[3];
      arrayOfString2[m] = str2;
      int n = j * 2 + 1;
      String str3 = arrayOfString4[4];
      arrayOfString2[n] = str3;
      j += 1;
      break;
      arrayOfString2 = null;
    }
  }

  private void loadOptionalVehicles()
  {
    if (this._optionalVehicles == null)
      return;
    if (this._optionalVehicles.size() == 0)
      return;
    int i = this._optionalVehicles.size();
    String[] arrayOfString1 = new String[i * 2];
    this.optionalVehicles = arrayOfString1;
    int j = 0;
    while (true)
    {
      if (j >= i)
        return;
      String[] arrayOfString2 = this.optionalVehicles;
      int k = j * 2;
      String str1 = ((Vehicle)this._optionalVehicles.get(j)).getId();
      arrayOfString2[k] = str1;
      String[] arrayOfString3 = this.optionalVehicles;
      int m = j * 2 + 1;
      String str2 = ((Vehicle)this._optionalVehicles.get(j)).getName();
      arrayOfString3[m] = str2;
      j += 1;
    }
  }

  @Commit
  public void build()
  {
    String str1 = "";
    int i = Integer.parseInt(getTime());
    int j = i / 3600;
    int k;
    if (j > 0)
    {
      k = i % 3600 / 60;
      String str2 = String.valueOf(j);
      str1 = str2 + " h" + " ";
    }
    while (true)
    {
      String str3 = String.valueOf(str1);
      String str4 = str3 + k + " m";
      setStepTime(str4);
      if (getIcon() != null)
      {
        String str5 = getIcon().getURL();
        setURL(str5, false);
        setHasIcon(true);
        int m = getIcon().getWidth();
        setIconWidth(m);
        int n = getIcon().getHeight();
        setIconHeight(n);
      }
      if (this.bikeFriendly == 1)
        this.isBikeFriendly = true;
      loadOptionalVehicles();
      if ((getVehicleRoute() != null) && (getVehicleRoute().getStopId() != null))
      {
        String str6 = getVehicleRoute().getStopId();
        setUseAnotherStop(str6, null);
        if (getVehicleRoute().getDiversion() != null)
        {
          Diversion localDiversion = (Diversion)getVehicleRoute().getDiversion().get(0);
          setHasDiversion(true);
          if (localDiversion.getIcon() != null)
          {
            String str7 = localDiversion.getIcon().getURL();
            setBitmapDiversion(str7, null);
          }
          String str8 = localDiversion.getDescription();
          setDiversion(str8);
        }
      }
      if (getVehicle() != null)
      {
        String str9 = getVehicle().getId();
        setVehicle_id(str9, null);
      }
      if (getURL() == null)
        return;
      try
      {
        Bitmap localBitmap = DrawableManager.resizeDrawable(NetworkEngine.fetchDrawable(getURL()));
        this.pathIcon = localBitmap;
        return;
        if (i / 60 == 0);
        for (k = 1; ; k = i / 60)
          break;
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

  public ViewStepDirections cloneItself()
  {
    ViewStepDirections localViewStepDirections = new ViewStepDirections();
    String str1 = this.directions;
    localViewStepDirections.setDirections(str1);
    String str2 = this.stepTime;
    localViewStepDirections.setStepTime(str2);
    int i = this.stepLenght;
    localViewStepDirections.setStepLenght(i);
    String str3 = this.type;
    localViewStepDirections.setType(str3);
    if (this.pathIcon != null);
    try
    {
      Bitmap localBitmap1 = this.pathIcon;
      Bitmap.Config localConfig = Bitmap.Config.ARGB_8888;
      Bitmap localBitmap2 = localBitmap1.copy(localConfig, false);
      localViewStepDirections.setBitmap(localBitmap2);
      String str4 = this.path;
      localViewStepDirections.setURL(str4, false);
      boolean bool1 = this.hasIcon;
      localViewStepDirections.setHasIcon(bool1);
      int j = this.iconWidth;
      localViewStepDirections.setIconWidth(j);
      int k = this.iconHeight;
      localViewStepDirections.setIconHeight(k);
      String[] arrayOfString = this.optionalVehicles;
      localViewStepDirections.optionalVehicles = arrayOfString;
      String str5 = this.useAnotherStop;
      String str6 = this.urlString;
      localViewStepDirections.setUseAnotherStop(str5, str6);
      boolean bool2 = this.haveChevron;
      localViewStepDirections.haveChevron = bool2;
      String str7 = this.useAnotherTransfer;
      String str8 = this.urlString;
      localViewStepDirections.setUseAnotherTransfer(str7, str8);
      String str9 = this.vehicle_id;
      String str10 = this.urlString;
      localViewStepDirections.setVehicle_id(str9, str10);
      String str11 = this.vehicle_name;
      localViewStepDirections.setVehicle_name(str11);
      boolean bool3 = this.hasDiversion;
      localViewStepDirections.setHasDiversion(bool3);
      int m = this.directionViewStarts;
      localViewStepDirections.setDirectionViewStarts(m);
      boolean bool4 = this.isDownloading;
      localViewStepDirections.setDownloading(bool4);
      ChevronImageView localChevronImageView = this.chevron;
      localViewStepDirections.setChevron(localChevronImageView);
      boolean bool5 = this.isBikeFriendly;
      localViewStepDirections.setBikeFriendly(bool5);
      boolean bool6 = this.isBikeAndNeedToSetWidth;
      localViewStepDirections.isBikeAndNeedToSetWidth = bool6;
      return localViewStepDirections;
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        boolean bool7 = Crittercism.logHandledException(localException);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (true)
      {
        localOutOfMemoryError.printStackTrace();
        boolean bool8 = Crittercism.logHandledException(localOutOfMemoryError);
      }
    }
  }

  public void downloadError(int paramInt)
  {
  }

  public Bitmap getBitmap()
  {
    return this.pathIcon;
  }

  public Bitmap getBitmapDiversion()
  {
    return this._bitmapDiversion;
  }

  public ChevronImageView getChevron()
  {
    return this.chevron;
  }

  public int getDirectionViewStarts()
  {
    return this.directionViewStarts;
  }

  public String getDirections()
  {
    return this.directions;
  }

  public float getDistance()
  {
    return this._distance;
  }

  public String getDiversion()
  {
    return this._diversion;
  }

  public Icon getIcon()
  {
    return this._icon;
  }

  public int getIconHeight()
  {
    return this.iconHeight;
  }

  public int getIconWidth()
  {
    return this.iconWidth;
  }

  public String getNotes()
  {
    return this._notes;
  }

  public ArrayList<Vehicle> getOptionalVehicles()
  {
    return this._optionalVehicles;
  }

  public String[] getOptionlVehicle()
  {
    return this.optionalVehicles;
  }

  public String getOptionlVehicles()
  {
    String[] arrayOfString;
    if ((this.optionalVehicles != null) && (this.optionalVehicles.length > 0))
      arrayOfString = this.optionalVehicles;
    for (String str = TextUtils.join(",", arrayOfString); ; str = "")
      return str;
  }

  public String getPhone()
  {
    return this._phone;
  }

  public float getPrice()
  {
    return this._price;
  }

  public int getStepLenght()
  {
    return this.stepLenght;
  }

  public String getStepTime()
  {
    return this.stepTime;
  }

  public String getTime()
  {
    return this.time;
  }

  public String getType()
  {
    return this.type;
  }

  public String getURL()
  {
    return this.path;
  }

  public String getUrlString()
  {
    return this.urlString;
  }

  public String getUseAnotherStop()
  {
    return this.useAnotherStop;
  }

  public String getUseAnotherTransfer()
  {
    return this.useAnotherTransfer;
  }

  public Vehicle getVehicle()
  {
    return this._vehicle;
  }

  public VehicleRoute getVehicleRoute()
  {
    return this._vehicleRoute;
  }

  public String getVehicle_id()
  {
    return this.vehicle_id;
  }

  public String getVehicle_name()
  {
    return this.vehicle_name;
  }

  public int getWrappedListIndex()
  {
    return this._wrappedListIndex;
  }

  public boolean hasDiversion()
  {
    return this.hasDiversion;
  }

  public boolean hasIcon()
  {
    return this.hasIcon;
  }

  public boolean haveChevron()
  {
    return this.haveChevron;
  }

  public boolean isBikeAndNeedToSetWidth()
  {
    return this.isBikeAndNeedToSetWidth;
  }

  public boolean isBikeFriendly()
  {
    return this.isBikeFriendly;
  }

  public boolean isDestroyed()
  {
    return this.isDestroyed;
  }

  public boolean isDownloading()
  {
    return this.isDownloading;
  }

  public boolean isSaved()
  {
    return this.isSaved;
  }

  public void parseOptionalVehicle(String paramString1, String paramString2)
  {
    String[] arrayOfString = extractVehicles(paramString1);
    this.optionalVehicles = arrayOfString;
    this.urlString = paramString2;
    this.haveChevron = true;
  }

  public void recycle(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.pathIcon != null))
    {
      this.pathIcon.recycle();
      this.pathIcon = null;
    }
    if (this.chevron != null)
      this.chevron = null;
    if (this.imgView != null)
      this.imgView = null;
    if (this._bitmapDiversion == null)
      return;
    this._bitmapDiversion.recycle();
    this._bitmapDiversion = null;
  }

  public void setBikeAndNeedToSetWidth(boolean paramBoolean)
  {
    this.isBikeAndNeedToSetWidth = paramBoolean;
  }

  public void setBikeFriendly(boolean paramBoolean)
  {
    this.isBikeFriendly = paramBoolean;
  }

  public void setBitmap(Bitmap paramBitmap)
  {
    this.pathIcon = paramBitmap;
    if (this.imgView != null)
    {
      ImageView localImageView = this.imgView;
      Bitmap localBitmap = this.pathIcon;
      localImageView.setImageBitmap(localBitmap);
      this.imgView = null;
    }
    if (this._wivl != null)
    {
      WrappedImageViewLayout localWrappedImageViewLayout = this._wivl;
      int i = this._wrappedListIndex;
      localWrappedImageViewLayout.addBitmap(i, paramBitmap);
      this._wivl = null;
    }
    if (this._context == null)
      return;
    SavingManager localSavingManager = ((DirectionsResultActivity)this._context).getSavingManager();
    String str = this.path;
    localSavingManager.mapkStepDownloaded(str);
    this._context = null;
  }

  public void setBitmapDiversion(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this._bitmapDiversion = paramBitmap;
      return;
    }
    if (paramString == null)
      return;
    if (paramString.length() <= 0)
      return;
    NetworkEngine.fetchDrawableOnThread(paramString, null);
  }

  public void setChevron(ChevronImageView paramChevronImageView)
  {
    this.chevron = paramChevronImageView;
  }

  public void setContext(Context paramContext)
  {
    this._context = paramContext;
  }

  public void setDestroyed(boolean paramBoolean)
  {
    this.isDestroyed = paramBoolean;
  }

  public void setDirectionViewStarts(int paramInt)
  {
    this.directionViewStarts = paramInt;
  }

  public void setDirections(String paramString)
  {
    this.directions = paramString;
  }

  public void setDiversion(String paramString)
  {
    this._diversion = paramString;
  }

  public void setDownloading(boolean paramBoolean)
  {
    this.isDownloading = paramBoolean;
  }

  public void setHasChevron(boolean paramBoolean)
  {
    this.haveChevron = paramBoolean;
  }

  public void setHasDiversion(boolean paramBoolean)
  {
    this.hasDiversion = paramBoolean;
  }

  public void setHasIcon(boolean paramBoolean)
  {
    this.hasIcon = paramBoolean;
  }

  public void setIcon(Icon paramIcon)
  {
    this._icon = paramIcon;
  }

  public void setIconHeight(int paramInt)
  {
    this.iconHeight = paramInt;
  }

  public void setIconWidth(int paramInt)
  {
    this.iconWidth = paramInt;
  }

  public void setImageView(ImageView paramImageView)
  {
    this.imgView = paramImageView;
  }

  public void setOptionlVehicle(String paramString)
  {
    if (paramString == null)
      return;
    if (paramString.equals(""))
      return;
    String[] arrayOfString = TextUtils.split(paramString, ",");
    this.optionalVehicles = arrayOfString;
  }

  public void setSaved(boolean paramBoolean)
  {
    this.isSaved = paramBoolean;
  }

  public void setStepLenght(int paramInt)
  {
    this.stepLenght = paramInt;
  }

  public void setStepTime(String paramString)
  {
    this.stepTime = paramString;
  }

  public void setString(String paramString)
  {
    this.time = paramString;
  }

  public void setType(String paramString)
  {
    this.type = paramString;
  }

  public void setURL(String paramString, boolean paramBoolean)
  {
    this.path = paramString;
    if (this.path == null)
      return;
    if (this.path.length() <= 0)
      return;
    this.hasIcon = true;
    if (!paramBoolean)
      return;
    LoadImageFromNetworkTask localLoadImageFromNetworkTask = new LoadImageFromNetworkTask();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this;
    arrayOfObject[1] = null;
    AsyncTask localAsyncTask = localLoadImageFromNetworkTask.execute(arrayOfObject);
  }

  public void setUseAnotherStop(String paramString1, String paramString2)
  {
    this.useAnotherStop = paramString1;
    this.urlString = paramString2;
    this.haveChevron = true;
  }

  public void setUseAnotherTransfer(String paramString1, String paramString2)
  {
    this.useAnotherTransfer = paramString1;
    this.urlString = paramString2;
    this.haveChevron = true;
  }

  public void setVehicle(Vehicle paramVehicle)
  {
    this._vehicle = paramVehicle;
  }

  public void setVehicle_id(String paramString1, String paramString2)
  {
    this.vehicle_id = paramString1;
    this.urlString = paramString2;
    this.haveChevron = true;
  }

  public void setVehicle_name(String paramString)
  {
    this.vehicle_name = paramString;
  }

  public void setVehicles(ArrayList<Vehicle> paramArrayList)
  {
    this._optionalVehicles = paramArrayList;
  }

  public void setWrappedImageViewLayout(int paramInt, WrappedImageViewLayout paramWrappedImageViewLayout)
  {
    this._wrappedListIndex = paramInt;
    this._wivl = paramWrappedImageViewLayout;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.directions.ViewStepDirections
 * JD-Core Version:    0.6.2
 */