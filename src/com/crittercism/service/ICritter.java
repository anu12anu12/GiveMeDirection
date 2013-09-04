package com.crittercism.service;

import android.content.pm.ApplicationInfo;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract interface ICritter extends IInterface
{
  public abstract String a(String paramString);

  public abstract void a(ApplicationInfo paramApplicationInfo);

  public abstract void a(String paramString1, String paramString2);

  public abstract void b(ApplicationInfo paramApplicationInfo);

  public abstract void b(String paramString);

  public static abstract class a extends Binder
    implements ICritter
  {
    public a()
    {
      attachInterface(this, "com.crittercism.service.ICritter");
    }

    public static ICritter a(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder == null)
        localObject = null;
      while (true)
      {
        return localObject;
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.crittercism.service.ICritter");
        if ((localIInterface != null) && ((localIInterface instanceof ICritter)))
          localObject = (ICritter)localIInterface;
        else
          localObject = new a(paramIBinder);
      }
    }

    public IBinder asBinder()
    {
      return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    {
      ApplicationInfo localApplicationInfo = null;
      boolean bool;
      switch (paramInt1)
      {
      default:
        bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
      while (true)
      {
        return bool;
        paramParcel2.writeString("com.crittercism.service.ICritter");
        bool = true;
        continue;
        paramParcel1.enforceInterface("com.crittercism.service.ICritter");
        String str1 = paramParcel1.readString();
        String str2 = a(str1);
        paramParcel2.writeNoException();
        paramParcel2.writeString(str2);
        bool = true;
        continue;
        paramParcel1.enforceInterface("com.crittercism.service.ICritter");
        String str3 = paramParcel1.readString();
        String str4 = paramParcel1.readString();
        a(str3, str4);
        paramParcel2.writeNoException();
        bool = true;
        continue;
        paramParcel1.enforceInterface("com.crittercism.service.ICritter");
        String str5 = paramParcel1.readString();
        b(str5);
        paramParcel2.writeNoException();
        bool = true;
        continue;
        paramParcel1.enforceInterface("com.crittercism.service.ICritter");
        if (paramParcel1.readInt() != 0)
          localApplicationInfo = (ApplicationInfo)ApplicationInfo.CREATOR.createFromParcel(paramParcel1);
        a(localApplicationInfo);
        paramParcel2.writeNoException();
        bool = true;
        continue;
        paramParcel1.enforceInterface("com.crittercism.service.ICritter");
        if (paramParcel1.readInt() != 0)
          localApplicationInfo = (ApplicationInfo)ApplicationInfo.CREATOR.createFromParcel(paramParcel1);
        b(localApplicationInfo);
        paramParcel2.writeNoException();
        bool = true;
      }
    }

    static class a
      implements ICritter
    {
      private IBinder a;

      a(IBinder paramIBinder)
      {
        this.a = paramIBinder;
      }

      public final String a(String paramString)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.crittercism.service.ICritter");
          localParcel1.writeString(paramString);
          boolean bool = this.a.transact(1, localParcel1, localParcel2, 0);
          localParcel2.readException();
          String str1 = localParcel2.readString();
          String str2 = str1;
          return str2;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public final void a(ApplicationInfo paramApplicationInfo)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.crittercism.service.ICritter");
          if (paramApplicationInfo != null)
          {
            localParcel1.writeInt(1);
            paramApplicationInfo.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            boolean bool = this.a.transact(4, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            int i = 0;
            localParcel1.writeInt(i);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public final void a(String paramString1, String paramString2)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.crittercism.service.ICritter");
          localParcel1.writeString(paramString1);
          localParcel1.writeString(paramString2);
          boolean bool = this.a.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public final IBinder asBinder()
      {
        return this.a;
      }

      public final void b(ApplicationInfo paramApplicationInfo)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.crittercism.service.ICritter");
          if (paramApplicationInfo != null)
          {
            localParcel1.writeInt(1);
            paramApplicationInfo.writeToParcel(localParcel1, 0);
          }
          while (true)
          {
            boolean bool = this.a.transact(5, localParcel1, localParcel2, 0);
            localParcel2.readException();
            return;
            int i = 0;
            localParcel1.writeInt(i);
          }
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public final void b(String paramString)
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.crittercism.service.ICritter");
          localParcel1.writeString(paramString);
          boolean bool = this.a.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crittercism.service.ICritter
 * JD-Core Version:    0.6.2
 */