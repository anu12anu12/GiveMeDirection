package com.androidquery.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Gallery;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.androidquery.AQuery;
import com.androidquery.AbstractAQuery;
import com.androidquery.callback.BitmapAjaxCallback;
import java.io.File;
import java.util.Comparator;

public class Common
  implements Comparator<File>, Runnable, View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, AbsListView.OnScrollListener, AdapterView.OnItemSelectedListener, TextWatcher
{
  protected static final int CLEAN_CACHE = 2;
  protected static final int STORE_FILE = 1;
  private boolean fallback;
  private boolean galleryListen = false;
  private AdapterView.OnItemSelectedListener galleryListener;
  private Object handler;
  private int lastBottom;
  private String method;
  private int methodId;
  private AbsListView.OnScrollListener osl;
  private Object[] params;
  private int scrollState = 0;
  private Class<?>[] sig;

  private void checkScrolledBottom(AbsListView paramAbsListView, int paramInt)
  {
    int i = paramAbsListView.getCount();
    int j = paramAbsListView.getLastVisiblePosition();
    if (paramInt == 0)
    {
      int k = j + 1;
      if (i != k)
      {
        int m = this.lastBottom;
        if (j != m)
          return;
        this.lastBottom = j;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = paramAbsListView;
        Integer localInteger = Integer.valueOf(paramInt);
        arrayOfObject[1] = localInteger;
        Object localObject = invoke(arrayOfObject);
        return;
      }
    }
    this.lastBottom = -1;
  }

  private Object invoke(Object[] paramArrayOfObject)
  {
    Object localObject2;
    if (this.method != null)
    {
      Object[] arrayOfObject = paramArrayOfObject;
      if (this.params != null)
        arrayOfObject = this.params;
      Object localObject1 = this.handler;
      if (localObject1 == null)
        localObject1 = this;
      String str = this.method;
      boolean bool = this.fallback;
      Class[] arrayOfClass = this.sig;
      localObject2 = AQUtility.invokeHandler(localObject1, str, bool, true, arrayOfClass, arrayOfObject);
      return localObject2;
    }
    if (this.methodId != 0)
      switch (this.methodId)
      {
      default:
      case 2:
      case 1:
      }
    while (true)
    {
      localObject2 = null;
      break;
      File localFile1 = (File)this.params[0];
      long l1 = ((Long)this.params[1]).longValue();
      long l2 = ((Long)this.params[2]).longValue();
      AQUtility.cleanCache(localFile1, l1, l2);
      continue;
      File localFile2 = (File)this.params[0];
      byte[] arrayOfByte = (byte[])this.params[1];
      AQUtility.store(localFile2, arrayOfByte);
    }
  }

  private void onScrollStateChanged(ExpandableListView paramExpandableListView, int paramInt)
  {
    Integer localInteger = Integer.valueOf(paramInt);
    paramExpandableListView.setTag(1090453508, localInteger);
    if (paramInt != 0)
      return;
    int i = paramExpandableListView.getFirstVisiblePosition();
    int j = paramExpandableListView.getLastVisiblePosition() - i;
    ExpandableListAdapter localExpandableListAdapter = paramExpandableListView.getExpandableListAdapter();
    int k = 0;
    int n;
    int i1;
    View localView1;
    while (true)
    {
      if (k > j)
        return;
      int m = k + i;
      long l = paramExpandableListView.getExpandableListPosition(m);
      n = ExpandableListView.getPackedPositionGroup(l);
      i1 = ExpandableListView.getPackedPositionChild(l);
      if (n >= 0)
      {
        localView1 = paramExpandableListView.getChildAt(k);
        Long localLong = (Long)localView1.getTag(1090453508);
        if ((localLong != null) && (localLong.longValue() == l))
        {
          if (i1 != -1)
            break;
          boolean bool1 = paramExpandableListView.isGroupExpanded(n);
          ExpandableListView localExpandableListView1 = paramExpandableListView;
          View localView2 = localExpandableListAdapter.getGroupView(n, bool1, localView1, localExpandableListView1);
          localView1.setTag(1090453508, null);
        }
      }
      k += 1;
    }
    int i2 = localExpandableListAdapter.getChildrenCount(n) + -1;
    if (i1 != i2);
    for (boolean bool2 = true; ; bool2 = false)
    {
      ExpandableListView localExpandableListView2 = paramExpandableListView;
      View localView3 = localExpandableListAdapter.getChildView(n, i1, bool2, localView1, localExpandableListView2);
      break;
    }
  }

  private void onScrollStateChanged2(AbsListView paramAbsListView, int paramInt)
  {
    Integer localInteger = Integer.valueOf(paramInt);
    paramAbsListView.setTag(1090453508, localInteger);
    if (paramInt != 0)
      return;
    int i = paramAbsListView.getFirstVisiblePosition();
    int j = paramAbsListView.getLastVisiblePosition() - i;
    ListAdapter localListAdapter = (ListAdapter)paramAbsListView.getAdapter();
    int k = 0;
    while (true)
    {
      if (k > j)
        return;
      long l = k + i;
      View localView1 = paramAbsListView.getChildAt(k);
      if ((Number)localView1.getTag(1090453508) != null)
      {
        int m = (int)l;
        View localView2 = localListAdapter.getView(m, localView1, paramAbsListView);
        localView1.setTag(1090453508, null);
      }
      k += 1;
    }
  }

  public static boolean shouldDelay(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, String paramString)
  {
    boolean bool = true;
    if ((paramString == null) || (BitmapAjaxCallback.isMemoryCached(paramString)))
      bool = false;
    while (true)
    {
      return bool;
      AbsListView localAbsListView = (AbsListView)paramViewGroup;
      if ((AbsListView.OnScrollListener)paramViewGroup.getTag(1090453506) == null)
      {
        Common localCommon = new Common();
        localAbsListView.setOnScrollListener(localCommon);
        paramViewGroup.setTag(1090453506, localCommon);
      }
      Integer localInteger = (Integer)localAbsListView.getTag(1090453508);
      if ((localInteger == null) || (localInteger.intValue() == 0) || (localInteger.intValue() == 1))
      {
        bool = false;
      }
      else
      {
        long l = paramInt2;
        if ((paramViewGroup instanceof ExpandableListView))
          l = ExpandableListView.getPackedPositionForChild(paramInt1, paramInt2);
        Long localLong = Long.valueOf(l);
        paramView.setTag(1090453508, localLong);
      }
    }
  }

  public static boolean shouldDelay(int paramInt, View paramView, ViewGroup paramViewGroup, String paramString)
  {
    if ((paramViewGroup instanceof Gallery));
    for (boolean bool = shouldDelayGallery(paramInt, paramView, paramViewGroup, paramString); ; bool = shouldDelay(-1, paramInt, paramView, paramViewGroup, paramString))
      return bool;
  }

  public static boolean shouldDelay(View paramView, ViewGroup paramViewGroup, String paramString, float paramFloat, boolean paramBoolean)
  {
    return shouldDelay(-1, paramView, paramViewGroup, paramString);
  }

  private static boolean shouldDelayGallery(int paramInt, View paramView, ViewGroup paramViewGroup, String paramString)
  {
    boolean bool = false;
    if ((paramString == null) || (BitmapAjaxCallback.isMemoryCached(paramString)));
    while (true)
    {
      return bool;
      Gallery localGallery = (Gallery)paramViewGroup;
      Integer localInteger1 = (Integer)localGallery.getTag(1090453508);
      if (localInteger1 == null)
      {
        localInteger1 = Integer.valueOf(0);
        Integer localInteger2 = Integer.valueOf(0);
        localGallery.setTag(1090453508, localInteger2);
        localGallery.setCallbackDuringFling(false);
        new Common().listen(localGallery);
      }
      int i = localGallery.getFirstVisiblePosition();
      int j = (localGallery.getLastVisiblePosition() - i) / 2 + 1;
      int k = localInteger1.intValue() - j;
      int m = localInteger1.intValue() + j;
      if (k < 0)
      {
        m -= k;
        k = 0;
      }
      if ((paramInt >= k) && (paramInt <= m))
      {
        Integer localInteger3 = Integer.valueOf(paramInt);
        paramView.setTag(1090453508, localInteger3);
      }
      else
      {
        paramView.setTag(1090453508, null);
        bool = true;
      }
    }
  }

  public static void showProgress(Object paramObject, String paramString, boolean paramBoolean)
  {
    if (paramObject == null)
      return;
    if ((paramObject instanceof View))
    {
      View localView = (View)paramObject;
      ProgressBar localProgressBar = null;
      if ((paramObject instanceof ProgressBar))
        localProgressBar = (ProgressBar)paramObject;
      if (paramBoolean)
      {
        localView.setTag(1090453505, paramString);
        localView.setVisibility(0);
        if (localProgressBar == null)
          return;
        localProgressBar.setProgress(0);
        localProgressBar.setMax(100);
        return;
      }
      Object localObject = localView.getTag(1090453505);
      if ((localObject != null) && (!localObject.equals(paramString)))
        return;
      localView.setTag(1090453505, null);
      if ((localProgressBar != null) && (!localProgressBar.isIndeterminate()))
        return;
      localView.setVisibility(8);
      return;
    }
    if ((paramObject instanceof Dialog))
    {
      Dialog localDialog = (Dialog)paramObject;
      Context localContext = localDialog.getContext();
      AQuery localAQuery = new AQuery(localContext);
      if (paramBoolean)
      {
        AbstractAQuery localAbstractAQuery1 = localAQuery.show(localDialog);
        return;
      }
      AbstractAQuery localAbstractAQuery2 = localAQuery.dismiss(localDialog);
      return;
    }
    if (!(paramObject instanceof Activity))
      return;
    Activity localActivity = (Activity)paramObject;
    localActivity.setProgressBarIndeterminateVisibility(paramBoolean);
    localActivity.setProgressBarVisibility(paramBoolean);
    if (!paramBoolean)
      return;
    localActivity.setProgress(0);
  }

  public void afterTextChanged(Editable paramEditable)
  {
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public int compare(File paramFile1, File paramFile2)
  {
    long l1 = paramFile1.lastModified();
    long l2 = paramFile2.lastModified();
    int i;
    if (l2 > l1)
      i = 1;
    while (true)
    {
      return i;
      if (l2 == l1)
        i = 0;
      else
        i = -1;
    }
  }

  public Common forward(Object paramObject, String paramString, boolean paramBoolean, Class<?>[] paramArrayOfClass)
  {
    this.handler = paramObject;
    this.method = paramString;
    this.fallback = paramBoolean;
    this.sig = paramArrayOfClass;
    return this;
  }

  public void forward(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.osl = paramOnScrollListener;
  }

  public int getScrollState()
  {
    return this.scrollState;
  }

  public void listen(Gallery paramGallery)
  {
    AdapterView.OnItemSelectedListener localOnItemSelectedListener = paramGallery.getOnItemSelectedListener();
    this.galleryListener = localOnItemSelectedListener;
    this.galleryListen = true;
    paramGallery.setOnItemSelectedListener(this);
  }

  public Common method(int paramInt, Object[] paramArrayOfObject)
  {
    this.methodId = paramInt;
    this.params = paramArrayOfObject;
    return this;
  }

  public void onClick(View paramView)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramView;
    Object localObject = invoke(arrayOfObject);
  }

  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = paramAdapterView;
    arrayOfObject[1] = paramView;
    Integer localInteger = Integer.valueOf(paramInt);
    arrayOfObject[2] = localInteger;
    Long localLong = Long.valueOf(paramLong);
    arrayOfObject[3] = localLong;
    Object localObject = invoke(arrayOfObject);
  }

  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = paramAdapterView;
    arrayOfObject[1] = paramView;
    Integer localInteger1 = Integer.valueOf(paramInt);
    arrayOfObject[2] = localInteger1;
    Long localLong = Long.valueOf(paramLong);
    arrayOfObject[3] = localLong;
    Object localObject = invoke(arrayOfObject);
    if (this.galleryListener != null)
    {
      AdapterView.OnItemSelectedListener localOnItemSelectedListener = this.galleryListener;
      AdapterView<?> localAdapterView1 = paramAdapterView;
      View localView1 = paramView;
      int i = paramInt;
      long l = paramLong;
      localOnItemSelectedListener.onItemSelected(localAdapterView1, localView1, i, l);
    }
    if (!this.galleryListen)
      return;
    int j = ((Integer)paramAdapterView.getTag(1090453508)).intValue();
    int k = paramInt;
    if (j != k)
      return;
    Adapter localAdapter = paramAdapterView.getAdapter();
    Integer localInteger2 = Integer.valueOf(paramInt);
    paramAdapterView.setTag(1090453508, localInteger2);
    int m = paramAdapterView.getChildCount();
    int n = paramAdapterView.getFirstVisiblePosition();
    int i1 = 0;
    while (true)
    {
      if (i1 >= m)
        return;
      View localView2 = paramAdapterView.getChildAt(i1);
      int i2 = n + i1;
      Integer localInteger3 = (Integer)localView2.getTag(1090453508);
      if ((localInteger3 == null) || (localInteger3.intValue() != i2))
      {
        AdapterView<?> localAdapterView2 = paramAdapterView;
        View localView3 = localAdapter.getView(i2, localView2, localAdapterView2);
      }
      i1 += 1;
    }
  }

  public boolean onLongClick(View paramView)
  {
    boolean bool = false;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[bool] = paramView;
    Object localObject = invoke(arrayOfObject);
    if ((localObject instanceof Boolean))
      bool = ((Boolean)localObject).booleanValue();
    return bool;
  }

  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    if (this.galleryListener == null)
      return;
    this.galleryListener.onNothingSelected(paramAdapterView);
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.scrollState;
    checkScrolledBottom(paramAbsListView, i);
    if (this.osl == null)
      return;
    this.osl.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.scrollState = paramInt;
    checkScrolledBottom(paramAbsListView, paramInt);
    if ((paramAbsListView instanceof ExpandableListView))
    {
      ExpandableListView localExpandableListView = (ExpandableListView)paramAbsListView;
      onScrollStateChanged(localExpandableListView, paramInt);
    }
    while (true)
    {
      if (this.osl == null)
        return;
      this.osl.onScrollStateChanged(paramAbsListView, paramInt);
      return;
      onScrollStateChanged2(paramAbsListView, paramInt);
    }
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = paramCharSequence;
    Integer localInteger1 = Integer.valueOf(paramInt1);
    arrayOfObject[1] = localInteger1;
    Integer localInteger2 = Integer.valueOf(paramInt2);
    arrayOfObject[2] = localInteger2;
    Integer localInteger3 = Integer.valueOf(paramInt3);
    arrayOfObject[3] = localInteger3;
    Object localObject = invoke(arrayOfObject);
  }

  public void run()
  {
    Object[] arrayOfObject = new Object[0];
    Object localObject = invoke(arrayOfObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.androidquery.util.Common
 * JD-Core Version:    0.6.2
 */