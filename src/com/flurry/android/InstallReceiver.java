package com.flurry.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class InstallReceiver extends BroadcastReceiver
{
  private final Handler a;
  private File b = null;

  private InstallReceiver()
  {
    HandlerThread localHandlerThread = new HandlerThread("InstallReceiver");
    localHandlerThread.start();
    Looper localLooper = localHandlerThread.getLooper();
    Handler localHandler = new Handler(localLooper);
    this.a = localHandler;
  }

  private static Map a(String paramString)
  {
    if ((paramString == null) || (paramString.trim().equals("")))
      throw new IllegalArgumentException("Referrer is null or empty");
    HashMap localHashMap = new HashMap();
    String[] arrayOfString1 = paramString.split("&");
    int i = arrayOfString1.length;
    int j = 0;
    if (j < i)
    {
      String[] arrayOfString2 = arrayOfString1[j].split("=");
      if (arrayOfString2.length != 2)
      {
        StringBuilder localStringBuilder1 = new StringBuilder().append("Invalid referrer Element: ");
        String str1 = arrayOfString1[j];
        String str2 = str1 + " in referrer tag " + paramString;
        int k = ai.a("InstallReceiver", str2);
      }
      while (true)
      {
        j += 1;
        break;
        String str3 = arrayOfString2[0];
        String str4 = arrayOfString2[1];
        Object localObject = localHashMap.put(str3, str4);
      }
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    if (localHashMap.get("utm_source") == null)
      StringBuilder localStringBuilder3 = localStringBuilder2.append("Campaign Source is missing.\n");
    if (localHashMap.get("utm_medium") == null)
      StringBuilder localStringBuilder4 = localStringBuilder2.append("Campaign Medium is missing.\n");
    if (localHashMap.get("utm_campaign") == null)
      StringBuilder localStringBuilder5 = localStringBuilder2.append("Campaign Name is missing.\n");
    if (localStringBuilder2.length() > 0)
    {
      String str5 = localStringBuilder2.toString();
      throw new IllegalArgumentException(str5);
    }
    return localHashMap;
  }

  /** @deprecated */
  private void a(Map paramMap)
  {
    try
    {
      t localt = new t(this, paramMap);
      boolean bool = this.a.post(localt);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append(".flurryinstallreceiver.");
    String str1 = Integer.toString(FlurryAgent.e().hashCode(), 16);
    String str2 = str1;
    File localFile = paramContext.getFileStreamPath(str2);
    this.b = localFile;
    if (FlurryAgent.isCaptureUncaughtExceptions())
      Thread.setDefaultUncaughtExceptionHandler(new FlurryAgent.FlurryDefaultExceptionHandler());
    String str3 = paramIntent.getStringExtra("referrer");
    if (str3 == null)
      return;
    String str4 = paramIntent.getAction();
    if (!"com.android.vending.INSTALL_REFERRER".equals(str4))
      return;
    try
    {
      Map localMap = a(str3);
      a(localMap);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder().append("Invalid referrer Tag: ");
      String str5 = localIllegalArgumentException.getMessage();
      String str6 = str5;
      int i = ai.c("InstallReceiver", str6);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.InstallReceiver
 * JD-Core Version:    0.6.2
 */