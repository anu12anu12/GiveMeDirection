package com.crashlytics.android;

import android.content.Context;

final class q
{
  private final Context a;
  private final B b;

  public q(Context paramContext, B paramB)
  {
    this.a = paramContext;
    this.b = paramB;
  }

  private String a(String paramString1, String paramString2)
  {
    String str = D.a(this.a, paramString1);
    int i;
    if ((str == null) || (str.length() == 0))
    {
      i = 1;
      if (i == 0)
        break label36;
    }
    while (true)
    {
      return paramString2;
      i = 0;
      break;
      label36: paramString2 = str;
    }
  }

  public final String a()
  {
    String str = this.b.c();
    return a("com.crashlytics.CrashSubmissionPromptTitle", str);
  }

  public final String b()
  {
    String str = this.b.d();
    return a("com.crashlytics.CrashSubmissionPromptMessage", str);
  }

  public final String c()
  {
    String str = this.b.g();
    return a("com.crashlytics.CrashSubmissionSendTitle", str);
  }

  public final String d()
  {
    String str = this.b.h();
    return a("com.crashlytics.CrashSubmissionAlwaysSendTitle", str);
  }

  public final String e()
  {
    String str = this.b.i();
    return a("com.crashlytics.CrashSubmissionCancelTitle", str);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.q
 * JD-Core Version:    0.6.2
 */