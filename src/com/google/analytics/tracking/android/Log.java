package com.google.analytics.tracking.android;

class Log
{
  static final String LOG_TAG = "GAV2";
  private static boolean debug;

  static int d(String paramString)
  {
    String str = formatMessage(paramString);
    return android.util.Log.d("GAV2", str);
  }

  static int dDebug(String paramString)
  {
    if (debug);
    for (int i = d(paramString); ; i = 0)
      return i;
  }

  static boolean debugEnabled()
  {
    return debug;
  }

  static int e(String paramString)
  {
    String str = formatMessage(paramString);
    return android.util.Log.e("GAV2", str);
  }

  static int eDebug(String paramString)
  {
    if (debug);
    for (int i = e(paramString); ; i = 0)
      return i;
  }

  private static String formatMessage(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str = Thread.currentThread().toString();
    return str + ": " + paramString;
  }

  static int i(String paramString)
  {
    String str = formatMessage(paramString);
    return android.util.Log.i("GAV2", str);
  }

  static int iDebug(String paramString)
  {
    if (debug);
    for (int i = i(paramString); ; i = 0)
      return i;
  }

  static void setDebug(boolean paramBoolean)
  {
    debug = paramBoolean;
  }

  static int v(String paramString)
  {
    String str = formatMessage(paramString);
    return android.util.Log.v("GAV2", str);
  }

  static int vDebug(String paramString)
  {
    if (debug);
    for (int i = v(paramString); ; i = 0)
      return i;
  }

  static int w(String paramString)
  {
    String str = formatMessage(paramString);
    return android.util.Log.w("GAV2", str);
  }

  static int wDebug(String paramString)
  {
    if (debug);
    for (int i = w(paramString); ; i = 0)
      return i;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.Log
 * JD-Core Version:    0.6.2
 */