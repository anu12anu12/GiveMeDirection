package com.crashlytics.android;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;

final class i extends AsyncTask<Void, Void, Void>
{
  i(Crashlytics paramCrashlytics, Context paramContext, float paramFloat, File paramFile)
  {
  }

  protected final void onPreExecute()
  {
    super.onPreExecute();
    String str = Crashlytics.b(this.d).e();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.i
 * JD-Core Version:    0.6.2
 */