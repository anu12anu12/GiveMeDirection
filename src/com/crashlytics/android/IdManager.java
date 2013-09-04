package com.crashlytics.android;

import android.bluetooth.BluetoothAdapter;
import android.content.ContextWrapper;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class IdManager
{
  private static final Pattern a = Pattern.compile("[^\\p{Alnum}]");
  private final boolean b;
  private final boolean c;
  private final ReentrantLock d;

  public IdManager()
  {
    ReentrantLock localReentrantLock = new ReentrantLock();
    this.d = localReentrantLock;
    if (Crashlytics.f() == null)
      throw new IllegalStateException("Cannot instantiate IdManager before Crashlytics has been started.");
    if (!D.a(Crashlytics.f(), "com.crashlytics.CollectDeviceIdentifiers", true))
    {
      StringBuilder localStringBuilder1 = new StringBuilder("Device ID collection disabled for ");
      String str1 = Crashlytics.g();
      D.c(str1);
    }
    for (boolean bool2 = false; ; bool2 = true)
    {
      this.b = bool2;
      if (!D.a(Crashlytics.f(), "com.crashlytics.CollectUserIdentifiers", true))
      {
        StringBuilder localStringBuilder2 = new StringBuilder("User information collection disabled for ");
        String str2 = Crashlytics.g();
        D.c(str2);
      }
      while (true)
      {
        this.c = bool1;
        return;
        bool1 = true;
      }
    }
  }

  private static boolean a(String paramString)
  {
    if (Crashlytics.f().checkCallingPermission(paramString) == 0);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private static String b(String paramString)
  {
    if (paramString == null);
    for (String str = null; ; str = a.matcher(paramString).replaceAll("").toLowerCase())
      return str;
  }

  private String f()
  {
    this.d.lock();
    try
    {
      SharedPreferences localSharedPreferences = D.a();
      String str = localSharedPreferences.getString("crashlytics.installation.id", null);
      if (str == null)
      {
        str = b(UUID.randomUUID().toString());
        SharedPreferences.Editor localEditor1 = localSharedPreferences.edit();
        SharedPreferences.Editor localEditor2 = localEditor1.putString("crashlytics.installation.id", str);
        boolean bool = localEditor1.commit();
      }
      return str;
    }
    finally
    {
      this.d.unlock();
    }
  }

  private String g()
  {
    String str1 = null;
    if (!this.b);
    while (true)
    {
      return str1;
      String str2 = Settings.Secure.getString(Crashlytics.f().getContentResolver(), "android_id");
      if ((str2 != null) && (!str2.equals("9774d56d682e549c")))
        str1 = b(str2);
    }
  }

  private String h()
  {
    if ((this.b) && (Build.VERSION.SDK_INT >= 9));
    while (true)
    {
      try
      {
        String str1 = b((String)Build.class.getField("SERIAL").get(null));
        str2 = str1;
        return str2;
      }
      catch (Exception localException)
      {
        D.a("Could not retrieve android.os.Build.SERIAL value", localException);
      }
      String str2 = null;
    }
  }

  public final boolean a()
  {
    return this.c;
  }

  public final String b()
  {
    String str;
    if (Crashlytics.getInstance().a != null)
      str = Crashlytics.getInstance().a;
    while (true)
    {
      return str;
      str = D.a().getString("crashlytics.installation.id", null);
      if (str == null)
        str = f();
    }
  }

  public final String c()
  {
    String str;
    if (!this.b)
      str = "";
    while (true)
    {
      return str;
      str = g();
      if (str == null)
      {
        str = D.a().getString("crashlytics.installation.id", null);
        if (str == null)
          str = f();
      }
    }
  }

  public final Map<IdManager.DeviceIdentifierType, String> d()
  {
    HashMap localHashMap = new HashMap();
    String str1 = g();
    if (str1 != null)
    {
      IdManager.DeviceIdentifierType localDeviceIdentifierType1 = IdManager.DeviceIdentifierType.ANDROID_ID;
      Object localObject1 = localHashMap.put(localDeviceIdentifierType1, str1);
    }
    String str2;
    Object localObject4;
    if ((this.b) && (a("android.permission.READ_PHONE_STATE")))
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)Crashlytics.f().getSystemService("phone");
      if (localTelephonyManager != null)
      {
        str2 = b(localTelephonyManager.getDeviceId());
        if (str2 != null)
        {
          IdManager.DeviceIdentifierType localDeviceIdentifierType2 = IdManager.DeviceIdentifierType.ANDROID_DEVICE_ID;
          Object localObject2 = localHashMap.put(localDeviceIdentifierType2, str2);
        }
        String str3 = h();
        if (str3 != null)
        {
          IdManager.DeviceIdentifierType localDeviceIdentifierType3 = IdManager.DeviceIdentifierType.ANDROID_SERIAL;
          Object localObject3 = localHashMap.put(localDeviceIdentifierType3, str3);
        }
        if ((!this.b) || (!a("android.permission.ACCESS_WIFI_STATE")))
          break label218;
        localObject4 = (WifiManager)Crashlytics.f().getSystemService("wifi");
        if (localObject4 == null)
          break label218;
        localObject4 = ((WifiManager)localObject4).getConnectionInfo();
        if (localObject4 == null)
          break label218;
      }
    }
    label218: for (String str4 = b(((WifiInfo)localObject4).getMacAddress()); ; str4 = null)
    {
      if (str4 != null)
      {
        IdManager.DeviceIdentifierType localDeviceIdentifierType4 = IdManager.DeviceIdentifierType.WIFI_MAC_ADDRESS;
        Object localObject5 = localHashMap.put(localDeviceIdentifierType4, str4);
      }
      String str5 = e();
      return Collections.unmodifiableMap(localHashMap);
      str2 = null;
      break;
    }
  }

  public final String e()
  {
    if ((this.b) && (a("android.permission.BLUETOOTH")));
    try
    {
      BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
      if (localBluetoothAdapter != null)
        String str = b(localBluetoothAdapter.getAddress());
      return null;
    }
    catch (Exception localException)
    {
      while (true)
        D.a("Utils#getBluetoothMacAddress failed, returning null. Requires prior call to BluetoothAdatpter.getDefaultAdapter() on thread that has called Looper.prepare()", localException);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.IdManager
 * JD-Core Version:    0.6.2
 */