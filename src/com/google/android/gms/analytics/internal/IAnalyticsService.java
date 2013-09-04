package com.google.android.gms.analytics.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract interface IAnalyticsService extends IInterface
{
  public abstract void clearHits()
    throws RemoteException;

  public abstract void sendHit(Map paramMap, long paramLong, String paramString, List<Command> paramList)
    throws RemoteException;

  public static abstract class Stub extends Binder
    implements IAnalyticsService
  {
    private static final String DESCRIPTOR = "com.google.android.gms.analytics.internal.IAnalyticsService";
    static final int TRANSACTION_clearHits = 2;
    static final int TRANSACTION_sendHit = 1;

    public Stub()
    {
      attachInterface(this, "com.google.android.gms.analytics.internal.IAnalyticsService");
    }

    public static IAnalyticsService asInterface(IBinder paramIBinder)
    {
      Object localObject;
      if (paramIBinder == null)
        localObject = null;
      while (true)
      {
        return localObject;
        IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
        if ((localIInterface != null) && ((localIInterface instanceof IAnalyticsService)))
          localObject = (IAnalyticsService)localIInterface;
        else
          localObject = new Proxy(paramIBinder);
      }
    }

    public IBinder asBinder()
    {
      return this;
    }

    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      boolean bool;
      switch (paramInt1)
      {
      default:
        bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902:
      case 1:
      case 2:
      }
      while (true)
      {
        return bool;
        paramParcel2.writeString("com.google.android.gms.analytics.internal.IAnalyticsService");
        bool = true;
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
        ClassLoader localClassLoader = getClass().getClassLoader();
        HashMap localHashMap = paramParcel1.readHashMap(localClassLoader);
        long l = paramParcel1.readLong();
        String str = paramParcel1.readString();
        Parcelable.Creator localCreator = Command.CREATOR;
        ArrayList localArrayList = paramParcel1.createTypedArrayList(localCreator);
        sendHit(localHashMap, l, str, localArrayList);
        paramParcel2.writeNoException();
        bool = true;
        continue;
        paramParcel1.enforceInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
        clearHits();
        paramParcel2.writeNoException();
        bool = true;
      }
    }

    private static class Proxy
      implements IAnalyticsService
    {
      private IBinder mRemote;

      Proxy(IBinder paramIBinder)
      {
        this.mRemote = paramIBinder;
      }

      public IBinder asBinder()
      {
        return this.mRemote;
      }

      public void clearHits()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
          boolean bool = this.mRemote.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }

      public String getInterfaceDescriptor()
      {
        return "com.google.android.gms.analytics.internal.IAnalyticsService";
      }

      public void sendHit(Map paramMap, long paramLong, String paramString, List<Command> paramList)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.analytics.internal.IAnalyticsService");
          localParcel1.writeMap(paramMap);
          localParcel1.writeLong(paramLong);
          localParcel1.writeString(paramString);
          localParcel1.writeTypedList(paramList);
          boolean bool = this.mRemote.transact(1, localParcel1, localParcel2, 0);
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
 * Qualified Name:     com.google.android.gms.analytics.internal.IAnalyticsService
 * JD-Core Version:    0.6.2
 */