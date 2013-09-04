package com.MASTAdView.ormma;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.MASTAdView.MASTAdViewCore;
import com.MASTAdView.ormma.util.NavigationStringEnum;
import com.MASTAdView.ormma.util.TransitionStringEnum;
import java.lang.reflect.Field;
import org.json.JSONException;
import org.json.JSONObject;

public class OrmmaController
{
  private static final String BOOLEAN_TYPE = "boolean";
  public static final String EXIT = "exit";
  private static final String FLOAT_TYPE = "float";
  public static final String FULL_SCREEN = "fullscreen";
  private static final String INT_TYPE = "int";
  private static final String NAVIGATION_TYPE = "class com.ormma.NavigationStringEnum";
  private static final String STRING_TYPE = "class java.lang.String";
  public static final String STYLE_NORMAL = "normal";
  private static final String TRANSITION_TYPE = "class com.ormma.TransitionStringEnum";
  protected Context mContext;
  protected MASTAdViewCore mOrmmaView;

  public OrmmaController(MASTAdViewCore paramMASTAdViewCore, Context paramContext)
  {
    this.mOrmmaView = paramMASTAdViewCore;
    this.mContext = paramContext;
  }

  protected static Object getFromJSON(JSONObject paramJSONObject, Class<?> paramClass)
    throws IllegalAccessException, InstantiationException, NumberFormatException, NullPointerException
  {
    Field[] arrayOfField1 = (Field[])null;
    Field[] arrayOfField2 = paramClass.getFields();
    Object localObject = paramClass.newInstance();
    int i = 0;
    while (true)
    {
      int j = arrayOfField2.length;
      if (i >= j)
        return localObject;
      Field localField = arrayOfField2[i];
      String str1 = localField.getName().replace('_', '-');
      String str2 = localField.getType().toString();
      try
      {
        String str3;
        int k;
        if (str2.equals("int"))
        {
          str3 = paramJSONObject.getString(str1);
          if (str3.startsWith("#"))
          {
            k = Integer.parseInt(str3.substring(1), 16);
            label104: Integer localInteger = Integer.valueOf(k);
            localField.set(localObject, localInteger);
          }
        }
        while (true)
        {
          i += 1;
          break;
          k = Integer.parseInt(str3);
          break label104;
          if (!str2.equals("class java.lang.String"))
            break label174;
          String str4 = paramJSONObject.getString(str1);
          localField.set(localObject, str4);
        }
      }
      catch (JSONException localJSONException)
      {
        while (true)
        {
          continue;
          label174: if (str2.equals("boolean"))
          {
            Boolean localBoolean = Boolean.valueOf(paramJSONObject.getBoolean(str1));
            localField.set(localObject, localBoolean);
          }
          else if (str2.equals("float"))
          {
            Float localFloat = Float.valueOf(Float.parseFloat(paramJSONObject.getString(str1)));
            localField.set(localObject, localFloat);
          }
          else if (str2.equals("class com.ormma.NavigationStringEnum"))
          {
            NavigationStringEnum localNavigationStringEnum = NavigationStringEnum.fromString(paramJSONObject.getString(str1));
            localField.set(localObject, localNavigationStringEnum);
          }
          else if (str2.equals("class com.ormma.TransitionStringEnum"))
          {
            TransitionStringEnum localTransitionStringEnum = TransitionStringEnum.fromString(paramJSONObject.getString(str1));
            localField.set(localObject, localTransitionStringEnum);
          }
        }
      }
    }
  }

  public static class Dimensions extends OrmmaController.ReflectedParcelable
  {
    public static final Parcelable.Creator<Dimensions> CREATOR = new Parcelable.Creator()
    {
      public OrmmaController.Dimensions createFromParcel(Parcel paramAnonymousParcel)
      {
        return new OrmmaController.Dimensions(paramAnonymousParcel);
      }

      public OrmmaController.Dimensions[] newArray(int paramAnonymousInt)
      {
        return new OrmmaController.Dimensions[paramAnonymousInt];
      }
    };
    public int height;
    public int width;
    public int x;
    public int y;

    public Dimensions()
    {
      this.x = -1;
      this.y = -1;
      this.width = -1;
      this.height = -1;
    }

    protected Dimensions(Parcel paramParcel)
    {
      super();
    }
  }

  public static class PlayerProperties extends OrmmaController.ReflectedParcelable
  {
    public static final Parcelable.Creator<PlayerProperties> CREATOR = new Parcelable.Creator()
    {
      public OrmmaController.PlayerProperties createFromParcel(Parcel paramAnonymousParcel)
      {
        return new OrmmaController.PlayerProperties(paramAnonymousParcel);
      }

      public OrmmaController.PlayerProperties[] newArray(int paramAnonymousInt)
      {
        return new OrmmaController.PlayerProperties[paramAnonymousInt];
      }
    };
    public boolean audioMuted;
    public boolean autoPlay;
    public boolean doLoop;
    public boolean inline;
    public boolean showControl;
    public String startStyle;
    public String stopStyle;

    public PlayerProperties()
    {
      this.showControl = true;
      this.autoPlay = true;
      this.audioMuted = false;
      this.doLoop = false;
      this.stopStyle = "normal";
      this.startStyle = "normal";
      this.inline = false;
    }

    public PlayerProperties(Parcel paramParcel)
    {
      super();
    }

    public boolean doLoop()
    {
      return this.doLoop;
    }

    public boolean doMute()
    {
      return this.audioMuted;
    }

    public boolean exitOnComplete()
    {
      return this.stopStyle.equalsIgnoreCase("exit");
    }

    public boolean isAutoPlay()
    {
      return this.autoPlay;
    }

    public boolean isFullScreen()
    {
      return this.startStyle.equalsIgnoreCase("fullscreen");
    }

    public void muteAudio()
    {
      this.audioMuted = true;
    }

    public void setProperties(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString1, String paramString2)
    {
      this.autoPlay = paramBoolean2;
      this.showControl = paramBoolean3;
      this.doLoop = paramBoolean5;
      this.audioMuted = paramBoolean1;
      this.startStyle = paramString1;
      this.stopStyle = paramString2;
      this.inline = paramBoolean4;
    }

    public void setStopStyle(String paramString)
    {
      this.stopStyle = paramString;
    }

    public boolean showControl()
    {
      return this.showControl;
    }
  }

  public static class Properties extends OrmmaController.ReflectedParcelable
  {
    public static final Parcelable.Creator<Properties> CREATOR = new Parcelable.Creator()
    {
      public OrmmaController.Properties createFromParcel(Parcel paramAnonymousParcel)
      {
        return new OrmmaController.Properties(paramAnonymousParcel);
      }

      public OrmmaController.Properties[] newArray(int paramAnonymousInt)
      {
        return new OrmmaController.Properties[paramAnonymousInt];
      }
    };
    public int backgroundColor;
    public float backgroundOpacity;
    public int height;
    public boolean isModal;
    public boolean lockOrientation;
    public NavigationStringEnum navigation;
    public TransitionStringEnum transition;
    public boolean useBackground;
    public boolean useCustomClose;
    public int width;

    public Properties()
    {
      TransitionStringEnum localTransitionStringEnum = TransitionStringEnum.DEFAULT;
      this.transition = localTransitionStringEnum;
      NavigationStringEnum localNavigationStringEnum = NavigationStringEnum.NONE;
      this.navigation = localNavigationStringEnum;
      this.useBackground = false;
      this.backgroundColor = 0;
      this.backgroundOpacity = 0.0F;
      this.isModal = true;
      this.width = 0;
      this.height = 0;
      this.useCustomClose = false;
      this.lockOrientation = true;
    }

    protected Properties(Parcel paramParcel)
    {
      super();
    }
  }

  public static class ReflectedParcelable
    implements Parcelable
  {
    public ReflectedParcelable()
    {
    }

    protected ReflectedParcelable(Parcel paramParcel)
    {
      Field[] arrayOfField1 = (Field[])null;
      Field[] arrayOfField2 = getClass().getDeclaredFields();
      ReflectedParcelable localReflectedParcelable = this;
      int i = 0;
      try
      {
        int j = arrayOfField2.length;
        if (i >= j)
          return;
        localField = arrayOfField2[i];
        Class localClass = localField.getType();
        if (localClass.isEnum())
        {
          String str = localClass.toString();
          if (str.equals("class com.ormma.NavigationStringEnum"))
          {
            NavigationStringEnum localNavigationStringEnum = NavigationStringEnum.fromString(paramParcel.readString());
            localField.set(localReflectedParcelable, localNavigationStringEnum);
          }
          while (true)
          {
            i += 1;
            break;
            if (str.equals("class com.ormma.TransitionStringEnum"))
            {
              TransitionStringEnum localTransitionStringEnum = TransitionStringEnum.fromString(paramParcel.readString());
              localField.set(localReflectedParcelable, localTransitionStringEnum);
            }
          }
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        while (true)
        {
          Field localField;
          localIllegalArgumentException.printStackTrace();
          return;
          if (!(localField.get(this) instanceof Parcelable.Creator))
          {
            Object localObject = paramParcel.readValue(null);
            localField.set(localReflectedParcelable, localObject);
          }
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      Field[] arrayOfField1 = (Field[])null;
      Field[] arrayOfField2 = getClass().getDeclaredFields();
      int i = 0;
      try
      {
        int j = arrayOfField2.length;
        if (i >= j)
          return;
        localField = arrayOfField2[i];
        Class localClass = localField.getType();
        if (localClass.isEnum())
        {
          String str1 = localClass.toString();
          if (str1.equals("class com.ormma.NavigationStringEnum"))
          {
            String str2 = ((NavigationStringEnum)localField.get(this)).getText();
            paramParcel.writeString(str2);
          }
          while (true)
          {
            i += 1;
            break;
            if (str1.equals("class com.ormma.TransitionStringEnum"))
            {
              String str3 = ((TransitionStringEnum)localField.get(this)).getText();
              paramParcel.writeString(str3);
            }
          }
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        while (true)
        {
          Field localField;
          localIllegalArgumentException.printStackTrace();
          return;
          Object localObject = localField.get(this);
          if (!(localObject instanceof Parcelable.Creator))
            paramParcel.writeValue(localObject);
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.ormma.OrmmaController
 * JD-Core Version:    0.6.2
 */