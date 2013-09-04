package com.flurry.android;

import android.content.Context;

final class m
  implements Runnable
{
  m(al paramal, String paramString)
  {
  }

  public final void run()
  {
    if (this.a != null)
    {
      v localv = this.b.d;
      Context localContext = this.b.b;
      String str1 = this.a;
      v.a(localv, localContext, str1);
      p localp = this.b.c;
      long l = this.b.d.j();
      f localf = new f((byte)8, l);
      localp.a(localf);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("Unable to launch in app market: ");
    String str2 = this.b.a;
    String str3 = str2;
    int i = ai.d(v.a, str3);
    v.b(this.b.d, str3);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.m
 * JD-Core Version:    0.6.2
 */