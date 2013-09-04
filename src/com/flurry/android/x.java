package com.flurry.android;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class x extends LinearLayout
{
  private View a;
  private List b;
  private boolean c;

  public x(CatalogActivity paramCatalogActivity, Context paramContext)
  {
    super(paramContext);
    ArrayList localArrayList = new ArrayList();
    this.b = localArrayList;
    this.c = true;
    setOrientation(1);
    setGravity(48);
    s locals = new s(paramCatalogActivity, paramContext);
    this.a = locals;
    this.a.setId(10002);
    this.a.setOnClickListener(paramCatalogActivity);
    List localList = a(paramContext);
    boolean bool = this.c;
    a(localList, bool);
  }

  private void a(List paramList, boolean paramBoolean)
  {
    removeAllViews();
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(0, 0, 0, 0);
    View localView = this.a;
    addView(localView, localLayoutParams);
    if (paramList != null)
    {
      this.b.clear();
      boolean bool = this.b.addAll(paramList);
    }
    if (paramBoolean)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        z localz = (z)localIterator.next();
        addView(localz, localLayoutParams);
        p localp = localz.a();
        long l = CatalogActivity.b(this.d);
        f localf = new f((byte)3, l);
        localp.a(localf);
      }
    }
    refreshDrawableState();
  }

  final List a(Context paramContext)
  {
    Long localLong = null;
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    while (i <= 3)
    {
      String str = "Flurry_Canvas_Hook_" + i;
      boolean bool1 = localArrayList.add(str);
      i += 1;
    }
    w localw;
    if (CatalogActivity.a(this.d) == null)
    {
      localw = null;
      if (localw != null)
        break label169;
    }
    List localList;
    while (true)
    {
      v localv = CatalogActivity.c(this.d);
      Context localContext = paramContext;
      boolean bool2 = true;
      localList = localv.a(localContext, localArrayList, localLong, 1, bool2);
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        z localz = (z)localIterator.next();
        CatalogActivity localCatalogActivity = this.d;
        localz.setOnClickListener(localCatalogActivity);
      }
      localw = CatalogActivity.a(this.d).c;
      break;
      label169: localLong = Long.valueOf(localw.a);
    }
    return localList;
  }

  final void a()
  {
    if (!this.c);
    for (boolean bool1 = true; ; bool1 = false)
    {
      this.c = bool1;
      boolean bool2 = this.c;
      a(null, bool2);
      return;
    }
  }

  final void a(List paramList)
  {
    boolean bool = this.c;
    a(paramList, bool);
  }

  final List b()
  {
    return this.b;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.x
 * JD-Core Version:    0.6.2
 */