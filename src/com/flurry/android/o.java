package com.flurry.android;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import java.util.Arrays;
import java.util.List;

final class o extends RelativeLayout
{
  private v a;
  private Context b;
  private String c;
  private int d;
  private boolean e;
  private boolean f;

  o(v paramv, Context paramContext, String paramString, int paramInt)
  {
    super(paramContext);
    this.a = paramv;
    this.b = paramContext;
    this.c = paramString;
    this.d = paramInt;
  }

  private static RelativeLayout.LayoutParams b()
  {
    return new RelativeLayout.LayoutParams(-1, -1);
  }

  /** @deprecated */
  private z c()
  {
    while (true)
    {
      try
      {
        v localv1 = this.a;
        Context localContext = this.b;
        String[] arrayOfString = new String[1];
        String str = this.c;
        arrayOfString[0] = str;
        List localList = Arrays.asList(arrayOfString);
        int i = this.d;
        localObject1 = localv1.a(localContext, localList, null, i, false);
        if (!((List)localObject1).isEmpty())
        {
          localObject1 = (z)((List)localObject1).get(0);
          v localv2 = this.a;
          ((z)localObject1).setOnClickListener(localv2);
          return localObject1;
        }
      }
      finally
      {
        localObject2 = finally;
        throw localObject2;
      }
      Object localObject1 = null;
    }
  }

  final void a()
  {
    if (this.e)
      return;
    z localz = c();
    if (localz != null)
    {
      removeAllViews();
      RelativeLayout.LayoutParams localLayoutParams1 = b();
      addView(localz, localLayoutParams1);
      p localp = localz.a();
      long l = this.a.j();
      f localf = new f((byte)3, l);
      localp.a(localf);
      this.e = true;
    }
    while (true)
    {
      this.f = true;
      return;
      if (!this.f)
      {
        Context localContext = this.b;
        TextView localTextView = new TextView(localContext);
        String str = v.b;
        localTextView.setText(str);
        localTextView.setTextSize(1, 20.0F);
        RelativeLayout.LayoutParams localLayoutParams2 = b();
        addView(localTextView, localLayoutParams2);
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.o
 * JD-Core Version:    0.6.2
 */