package com.crashlytics.android;

import java.io.File;
import java.util.Map;

final class o
  implements Runnable
{
  o(j paramj, File paramFile)
  {
  }

  public final void run()
  {
    t localt = t.a();
    File localFile = this.a;
    Map localMap = j.f();
    s locals = new s(localFile, localMap);
    boolean bool = localt.a(locals);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.o
 * JD-Core Version:    0.6.2
 */