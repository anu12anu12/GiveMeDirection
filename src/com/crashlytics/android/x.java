package com.crashlytics.android;

import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

final class x
  implements DialogInterface.OnClickListener
{
  x(t paramt, B paramB, z paramz)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    B localB = this.a;
    ContextWrapper localContextWrapper = Crashlytics.f();
    SharedPreferences.Editor localEditor1 = D.a().edit();
    SharedPreferences.Editor localEditor2 = localEditor1.putBoolean("always_send_reports_opt_in", true);
    boolean bool = localEditor1.commit();
    this.b.a(true);
    paramDialogInterface.dismiss();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.x
 * JD-Core Version:    0.6.2
 */