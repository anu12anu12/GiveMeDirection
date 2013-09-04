package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Command
  implements Parcelable
{
  public static final String APPEND_CACHE_BUSTER = "appendCacheBuster";
  public static final String APPEND_QUEUE_TIME = "appendQueueTime";
  public static final String APPEND_VERSION = "appendVersion";
  public static final Parcelable.Creator<Command> CREATOR = new Parcelable.Creator()
  {
    public Command createFromParcel(Parcel paramAnonymousParcel)
    {
      return new Command(paramAnonymousParcel);
    }

    public Command[] newArray(int paramAnonymousInt)
    {
      return new Command[paramAnonymousInt];
    }
  };
  private String id;
  private String urlParam;
  private String value;

  public Command()
  {
  }

  Command(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }

  public Command(String paramString1, String paramString2, String paramString3)
  {
    this.id = paramString1;
    this.urlParam = paramString2;
    this.value = paramString3;
  }

  private void readFromParcel(Parcel paramParcel)
  {
    String str1 = paramParcel.readString();
    this.id = str1;
    String str2 = paramParcel.readString();
    this.urlParam = str2;
    String str3 = paramParcel.readString();
    this.value = str3;
  }

  public int describeContents()
  {
    return 0;
  }

  public String getId()
  {
    return this.id;
  }

  public String getUrlParam()
  {
    return this.urlParam;
  }

  public String getValue()
  {
    return this.value;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    String str1 = this.id;
    paramParcel.writeString(str1);
    String str2 = this.urlParam;
    paramParcel.writeString(str2);
    String str3 = this.value;
    paramParcel.writeString(str3);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.internal.Command
 * JD-Core Version:    0.6.2
 */