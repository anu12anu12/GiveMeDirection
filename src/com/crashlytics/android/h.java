package com.crashlytics.android;

final class h
  implements Runnable
{
  h(long paramLong, String paramString)
  {
  }

  public final void run()
  {
    j localj = Crashlytics.a(Crashlytics.p());
    long l = this.a;
    String str = this.b;
    localj.a(l, str);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.h
 * JD-Core Version:    0.6.2
 */