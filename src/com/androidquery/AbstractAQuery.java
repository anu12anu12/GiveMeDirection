package com.androidquery;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import com.androidquery.auth.AccountHandle;
import com.androidquery.callback.AbstractAjaxCallback;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.BitmapAjaxCallback;
import com.androidquery.callback.ImageOptions;
import com.androidquery.callback.Transformer;
import com.androidquery.util.AQUtility;
import com.androidquery.util.Common;
import com.androidquery.util.Constants;
import com.androidquery.util.WebImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Constructor;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;

public abstract class AbstractAQuery<T extends AbstractAQuery<T>>
  implements Constants
{
  private static Class<?>[] LAYER_TYPE_SIG = arrayOfClass7;
  private static final Class<?>[] ON_CLICK_SIG;
  private static Class<?>[] ON_ITEM_SIG;
  private static Class<?>[] ON_SCROLLED_STATE_SIG;
  private static final Class<?>[] OVER_SCROLL_SIG;
  private static Class<?>[] PENDING_TRANSITION_SIG;
  private static final Class<?>[] TEXT_CHANGE_SIG;
  private static WeakHashMap<Dialog, Void> dialogs = new WeakHashMap();
  private Activity act;
  protected AccountHandle ah;
  private Constructor<T> constructor;
  private Context context;
  private int policy = 0;
  protected Object progress;
  private HttpHost proxy;
  private View root;
  private Transformer trans;
  protected View view;

  static
  {
    Class[] arrayOfClass1 = new Class[1];
    arrayOfClass1[0] = View.class;
    ON_CLICK_SIG = arrayOfClass1;
    Class[] arrayOfClass2 = new Class[4];
    arrayOfClass2[0] = AdapterView.class;
    arrayOfClass2[1] = View.class;
    Class localClass1 = Integer.TYPE;
    arrayOfClass2[2] = localClass1;
    Class localClass2 = Long.TYPE;
    arrayOfClass2[3] = localClass2;
    ON_ITEM_SIG = arrayOfClass2;
    Class[] arrayOfClass3 = new Class[2];
    arrayOfClass3[0] = AbsListView.class;
    Class localClass3 = Integer.TYPE;
    arrayOfClass3[1] = localClass3;
    ON_SCROLLED_STATE_SIG = arrayOfClass3;
    Class[] arrayOfClass4 = new Class[4];
    arrayOfClass4[0] = CharSequence.class;
    Class localClass4 = Integer.TYPE;
    arrayOfClass4[1] = localClass4;
    Class localClass5 = Integer.TYPE;
    arrayOfClass4[2] = localClass5;
    Class localClass6 = Integer.TYPE;
    arrayOfClass4[3] = localClass6;
    TEXT_CHANGE_SIG = arrayOfClass4;
    Class[] arrayOfClass5 = new Class[2];
    Class localClass7 = Integer.TYPE;
    arrayOfClass5[0] = localClass7;
    Class localClass8 = Integer.TYPE;
    arrayOfClass5[1] = localClass8;
    PENDING_TRANSITION_SIG = arrayOfClass5;
    Class[] arrayOfClass6 = new Class[1];
    Class localClass9 = Integer.TYPE;
    arrayOfClass6[0] = localClass9;
    OVER_SCROLL_SIG = arrayOfClass6;
    Class[] arrayOfClass7 = new Class[2];
    Class localClass10 = Integer.TYPE;
    arrayOfClass7[0] = localClass10;
    arrayOfClass7[1] = Paint.class;
  }

  public AbstractAQuery(Activity paramActivity)
  {
    this.act = paramActivity;
  }

  public AbstractAQuery(Activity paramActivity, View paramView)
  {
    this.root = paramView;
    this.view = paramView;
    this.act = paramActivity;
  }

  public AbstractAQuery(Context paramContext)
  {
    this.context = paramContext;
  }

  public AbstractAQuery(View paramView)
  {
    this.root = paramView;
    this.view = paramView;
  }

  private View findView(int paramInt)
  {
    View localView = null;
    if (this.root != null)
      localView = this.root.findViewById(paramInt);
    while (true)
    {
      return localView;
      if (this.act != null)
        localView = this.act.findViewById(paramInt);
    }
  }

  private View findView(String paramString)
  {
    View localView1 = null;
    if (this.root != null)
      localView1 = this.root.findViewWithTag(paramString);
    while (true)
    {
      return localView1;
      if (this.act != null)
      {
        View localView2 = ((ViewGroup)this.act.findViewById(16908290)).getChildAt(0);
        if (localView2 != null)
          localView1 = localView2.findViewWithTag(paramString);
      }
    }
  }

  private View findView(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt[0];
    View localView = findView(i);
    int j = 1;
    while (true)
    {
      int k = paramArrayOfInt.length;
      if ((j >= k) || (localView == null))
        return localView;
      int m = paramArrayOfInt[j];
      localView = localView.findViewById(m);
      j += 1;
    }
  }

  private Constructor<T> getConstructor()
  {
    if (this.constructor == null);
    try
    {
      Class localClass = getClass();
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = View.class;
      Constructor localConstructor = localClass.getConstructor(arrayOfClass);
      this.constructor = localConstructor;
      return this.constructor;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  private T self()
  {
    return this;
  }

  private Common setScrollListener()
  {
    AbsListView localAbsListView = (AbsListView)this.view;
    Common localCommon = (Common)localAbsListView.getTag(1090453506);
    if (localCommon == null)
    {
      localCommon = new Common();
      localAbsListView.setOnScrollListener(localCommon);
      localAbsListView.setTag(1090453506, localCommon);
      AQUtility.debug("set scroll listenr");
    }
    return localCommon;
  }

  private void size(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (this.view == null)
      return;
    ViewGroup.LayoutParams localLayoutParams = this.view.getLayoutParams();
    Context localContext = getContext();
    if ((paramInt > 0) && (paramBoolean2))
    {
      float f = paramInt;
      paramInt = AQUtility.dip2pixel(localContext, f);
    }
    if (paramBoolean1)
      localLayoutParams.width = paramInt;
    while (true)
    {
      this.view.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.height = paramInt;
    }
  }

  public T adapter(Adapter paramAdapter)
  {
    if ((this.view instanceof AdapterView))
      ((AdapterView)this.view).setAdapter(paramAdapter);
    return self();
  }

  public T adapter(ExpandableListAdapter paramExpandableListAdapter)
  {
    if ((this.view instanceof ExpandableListView))
      ((ExpandableListView)this.view).setAdapter(paramExpandableListAdapter);
    return self();
  }

  public <K> T ajax(AjaxCallback<K> paramAjaxCallback)
  {
    return invoke(paramAjaxCallback);
  }

  public <K> T ajax(String paramString, Class<K> paramClass, long paramLong, AjaxCallback<K> paramAjaxCallback)
  {
    Object localObject = ((AjaxCallback)((AjaxCallback)((AjaxCallback)paramAjaxCallback.type(paramClass)).url(paramString)).fileCache(true)).expire(paramLong);
    return ajax(paramAjaxCallback);
  }

  public <K> T ajax(String paramString1, Class<K> paramClass, long paramLong, Object paramObject, String paramString2)
  {
    AjaxCallback localAjaxCallback = new AjaxCallback();
    Object localObject = ((AjaxCallback)((AjaxCallback)((AjaxCallback)localAjaxCallback.type(paramClass)).weakHandler(paramObject, paramString2)).fileCache(true)).expire(paramLong);
    return ajax(paramString1, paramClass, localAjaxCallback);
  }

  public <K> T ajax(String paramString, Class<K> paramClass, AjaxCallback<K> paramAjaxCallback)
  {
    Object localObject = ((AjaxCallback)paramAjaxCallback.type(paramClass)).url(paramString);
    return ajax(paramAjaxCallback);
  }

  public <K> T ajax(String paramString1, Class<K> paramClass, Object paramObject, String paramString2)
  {
    AjaxCallback localAjaxCallback = new AjaxCallback();
    Object localObject = ((AjaxCallback)localAjaxCallback.type(paramClass)).weakHandler(paramObject, paramString2);
    return ajax(paramString1, paramClass, localAjaxCallback);
  }

  public <K> T ajax(String paramString, Map<String, ?> paramMap, Class<K> paramClass, AjaxCallback<K> paramAjaxCallback)
  {
    Object localObject = ((AjaxCallback)((AjaxCallback)paramAjaxCallback.type(paramClass)).url(paramString)).params(paramMap);
    return ajax(paramAjaxCallback);
  }

  public <K> T ajax(String paramString1, Map<String, ?> paramMap, Class<K> paramClass, Object paramObject, String paramString2)
  {
    AjaxCallback localAjaxCallback = new AjaxCallback();
    Object localObject = ((AjaxCallback)localAjaxCallback.type(paramClass)).weakHandler(paramObject, paramString2);
    return ajax(paramString1, paramMap, paramClass, localAjaxCallback);
  }

  public T ajaxCancel()
  {
    AjaxCallback.cancel();
    return self();
  }

  public T animate(int paramInt)
  {
    return animate(paramInt, null);
  }

  public T animate(int paramInt, Animation.AnimationListener paramAnimationListener)
  {
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), paramInt);
    localAnimation.setAnimationListener(paramAnimationListener);
    return animate(localAnimation);
  }

  public T animate(Animation paramAnimation)
  {
    if ((this.view != null) && (paramAnimation != null))
      this.view.startAnimation(paramAnimation);
    return self();
  }

  public T auth(AccountHandle paramAccountHandle)
  {
    this.ah = paramAccountHandle;
    return self();
  }

  public T background(int paramInt)
  {
    if (this.view != null)
    {
      if (paramInt == 0)
        break label24;
      this.view.setBackgroundResource(paramInt);
    }
    while (true)
    {
      return self();
      label24: this.view.setBackgroundDrawable(null);
    }
  }

  public T backgroundColor(int paramInt)
  {
    if (this.view != null)
      this.view.setBackgroundColor(paramInt);
    return self();
  }

  public T cache(String paramString, long paramLong)
  {
    AbstractAQuery localAbstractAQuery = this;
    String str1 = paramString;
    long l = paramLong;
    String str2 = null;
    return localAbstractAQuery.ajax(str1, [B.class, l, null, str2);
  }

  public T checked(boolean paramBoolean)
  {
    if ((this.view instanceof CompoundButton))
      ((CompoundButton)this.view).setChecked(paramBoolean);
    return self();
  }

  public T clear()
  {
    if (this.view != null)
    {
      if (!(this.view instanceof ImageView))
        break label43;
      ImageView localImageView = (ImageView)this.view;
      localImageView.setImageBitmap(null);
      localImageView.setTag(1090453505, null);
    }
    while (true)
    {
      return self();
      label43: if ((this.view instanceof WebView))
      {
        WebView localWebView = (WebView)this.view;
        localWebView.stopLoading();
        localWebView.clearView();
        localWebView.setTag(1090453505, null);
      }
      else if ((this.view instanceof TextView))
      {
        ((TextView)this.view).setText("");
      }
    }
  }

  public T click()
  {
    if (this.view != null)
      boolean bool = this.view.performClick();
    return self();
  }

  public T clickable(boolean paramBoolean)
  {
    if (this.view != null)
      this.view.setClickable(paramBoolean);
    return self();
  }

  public T clicked(View.OnClickListener paramOnClickListener)
  {
    if (this.view != null)
      this.view.setOnClickListener(paramOnClickListener);
    return self();
  }

  public T clicked(Object paramObject, String paramString)
  {
    Common localCommon1 = new Common();
    Class[] arrayOfClass = ON_CLICK_SIG;
    Common localCommon2 = localCommon1.forward(paramObject, paramString, true, arrayOfClass);
    return clicked(localCommon2);
  }

  protected T create(View paramView)
  {
    try
    {
      Constructor localConstructor = getConstructor();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramView;
      AbstractAQuery localAbstractAQuery = (AbstractAQuery)localConstructor.newInstance(arrayOfObject);
      Activity localActivity = this.act;
      localAbstractAQuery.act = localActivity;
      return localAbstractAQuery;
    }
    catch (Exception localException)
    {
      while (true)
        localException.printStackTrace();
    }
  }

  public T dataChanged()
  {
    if ((this.view instanceof AdapterView))
    {
      Adapter localAdapter = ((AdapterView)this.view).getAdapter();
      if ((localAdapter instanceof BaseAdapter))
        ((BaseAdapter)localAdapter).notifyDataSetChanged();
    }
    return self();
  }

  public <K> T delete(String paramString, Class<K> paramClass, AjaxCallback<K> paramAjaxCallback)
  {
    Object localObject = ((AjaxCallback)((AjaxCallback)paramAjaxCallback.url(paramString)).type(paramClass)).method(2);
    return ajax(paramAjaxCallback);
  }

  public <K> T delete(String paramString1, Class<K> paramClass, Object paramObject, String paramString2)
  {
    AjaxCallback localAjaxCallback = new AjaxCallback();
    Object localObject = localAjaxCallback.weakHandler(paramObject, paramString2);
    return delete(paramString1, paramClass, localAjaxCallback);
  }

  public T dismiss()
  {
    Iterator localIterator = dialogs.keySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return self();
      Dialog localDialog = (Dialog)localIterator.next();
      try
      {
        localDialog.dismiss();
        label40: localIterator.remove();
      }
      catch (Exception localException)
      {
        break label40;
      }
    }
  }

  public T dismiss(Dialog paramDialog)
  {
    if (paramDialog != null);
    try
    {
      Object localObject = dialogs.remove(paramDialog);
      paramDialog.dismiss();
      label16: return self();
    }
    catch (Exception localException)
    {
      break label16;
    }
  }

  public T download(String paramString, File paramFile, AjaxCallback<File> paramAjaxCallback)
  {
    Object localObject = ((AjaxCallback)((AjaxCallback)paramAjaxCallback.url(paramString)).type(File.class)).targetFile(paramFile);
    return ajax(paramAjaxCallback);
  }

  public T download(String paramString1, File paramFile, Object paramObject, String paramString2)
  {
    AjaxCallback localAjaxCallback = new AjaxCallback();
    Object localObject = localAjaxCallback.weakHandler(paramObject, paramString2);
    return download(paramString1, paramFile, localAjaxCallback);
  }

  public T enabled(boolean paramBoolean)
  {
    if (this.view != null)
      this.view.setEnabled(paramBoolean);
    return self();
  }

  public T expand(int paramInt, boolean paramBoolean)
  {
    ExpandableListView localExpandableListView;
    if ((this.view instanceof ExpandableListView))
    {
      localExpandableListView = (ExpandableListView)this.view;
      if (!paramBoolean)
        break label34;
      boolean bool1 = localExpandableListView.expandGroup(paramInt);
    }
    while (true)
    {
      return self();
      label34: boolean bool2 = localExpandableListView.collapseGroup(paramInt);
    }
  }

  public T expand(boolean paramBoolean)
  {
    ExpandableListView localExpandableListView;
    int j;
    if ((this.view instanceof ExpandableListView))
    {
      localExpandableListView = (ExpandableListView)this.view;
      ExpandableListAdapter localExpandableListAdapter = localExpandableListView.getExpandableListAdapter();
      if (localExpandableListAdapter != null)
      {
        int i = localExpandableListAdapter.getGroupCount();
        j = 0;
        if (j < i)
          break label50;
      }
    }
    return self();
    label50: if (paramBoolean)
      boolean bool1 = localExpandableListView.expandGroup(j);
    while (true)
    {
      j += 1;
      break;
      boolean bool2 = localExpandableListView.collapseGroup(j);
    }
  }

  public T find(int paramInt)
  {
    View localView = findView(paramInt);
    return create(localView);
  }

  public Button getButton()
  {
    return (Button)this.view;
  }

  public File getCachedFile(String paramString)
  {
    File localFile = AQUtility.getExistedCacheByUrl(AQUtility.getCacheDir(getContext(), 1), paramString);
    if (localFile == null)
      localFile = AQUtility.getExistedCacheByUrl(AQUtility.getCacheDir(getContext(), 0), paramString);
    return localFile;
  }

  public Bitmap getCachedImage(int paramInt)
  {
    return BitmapAjaxCallback.getMemoryCached(getContext(), paramInt);
  }

  public Bitmap getCachedImage(String paramString)
  {
    return getCachedImage(paramString, 0);
  }

  public Bitmap getCachedImage(String paramString, int paramInt)
  {
    Bitmap localBitmap = BitmapAjaxCallback.getMemoryCached(paramString, paramInt);
    if (localBitmap == null)
    {
      File localFile = getCachedFile(paramString);
      if (localFile != null)
        localBitmap = BitmapAjaxCallback.getResizedImage(localFile.getAbsolutePath(), null, paramInt, true, 0);
    }
    return localBitmap;
  }

  public CheckBox getCheckBox()
  {
    return (CheckBox)this.view;
  }

  public Context getContext()
  {
    Object localObject;
    if (this.act != null)
      localObject = this.act;
    while (true)
    {
      return localObject;
      if (this.root != null)
        localObject = this.root.getContext();
      else
        localObject = this.context;
    }
  }

  public EditText getEditText()
  {
    return (EditText)this.view;
  }

  public Editable getEditable()
  {
    Editable localEditable = null;
    if ((this.view instanceof EditText))
      localEditable = ((EditText)this.view).getEditableText();
    return localEditable;
  }

  public ExpandableListView getExpandableListView()
  {
    return (ExpandableListView)this.view;
  }

  public Gallery getGallery()
  {
    return (Gallery)this.view;
  }

  public GridView getGridView()
  {
    return (GridView)this.view;
  }

  public ImageView getImageView()
  {
    return (ImageView)this.view;
  }

  public ListView getListView()
  {
    return (ListView)this.view;
  }

  public ProgressBar getProgressBar()
  {
    return (ProgressBar)this.view;
  }

  public RatingBar getRatingBar()
  {
    return (RatingBar)this.view;
  }

  public SeekBar getSeekBar()
  {
    return (SeekBar)this.view;
  }

  public Object getSelectedItem()
  {
    Object localObject = null;
    if ((this.view instanceof AdapterView))
      localObject = ((AdapterView)this.view).getSelectedItem();
    return localObject;
  }

  public int getSelectedItemPosition()
  {
    int i = -1;
    if ((this.view instanceof AdapterView))
      i = ((AdapterView)this.view).getSelectedItemPosition();
    return i;
  }

  public Spinner getSpinner()
  {
    return (Spinner)this.view;
  }

  public Object getTag()
  {
    Object localObject = null;
    if (this.view != null)
      localObject = this.view.getTag();
    return localObject;
  }

  public Object getTag(int paramInt)
  {
    Object localObject = null;
    if (this.view != null)
      localObject = this.view.getTag(paramInt);
    return localObject;
  }

  public CharSequence getText()
  {
    CharSequence localCharSequence = null;
    if ((this.view instanceof TextView))
      localCharSequence = ((TextView)this.view).getText();
    return localCharSequence;
  }

  public TextView getTextView()
  {
    return (TextView)this.view;
  }

  public View getView()
  {
    return this.view;
  }

  public WebView getWebView()
  {
    return (WebView)this.view;
  }

  public T gone()
  {
    if ((this.view != null) && (this.view.getVisibility() != 8))
      this.view.setVisibility(8);
    return self();
  }

  public T hardwareAccelerated11()
  {
    if (this.act != null)
      this.act.getWindow().setFlags(16777216, 16777216);
    return self();
  }

  public T height(int paramInt)
  {
    size(false, paramInt, true);
    return self();
  }

  public T height(int paramInt, boolean paramBoolean)
  {
    size(false, paramInt, paramBoolean);
    return self();
  }

  public T id(int paramInt)
  {
    View localView = findView(paramInt);
    return id(localView);
  }

  public T id(View paramView)
  {
    this.view = paramView;
    reset();
    return self();
  }

  public T id(String paramString)
  {
    View localView = findView(paramString);
    return id(localView);
  }

  public T id(int[] paramArrayOfInt)
  {
    View localView = findView(paramArrayOfInt);
    return id(localView);
  }

  public T image(int paramInt)
  {
    ImageView localImageView;
    if ((this.view instanceof ImageView))
    {
      localImageView = (ImageView)this.view;
      localImageView.setTag(1090453505, null);
      if (paramInt != 0)
        break label40;
      localImageView.setImageBitmap(null);
    }
    while (true)
    {
      return self();
      label40: localImageView.setImageResource(paramInt);
    }
  }

  public T image(Bitmap paramBitmap)
  {
    if ((this.view instanceof ImageView))
    {
      ImageView localImageView = (ImageView)this.view;
      localImageView.setTag(1090453505, null);
      localImageView.setImageBitmap(paramBitmap);
    }
    return self();
  }

  public T image(Bitmap paramBitmap, float paramFloat)
  {
    BitmapAjaxCallback localBitmapAjaxCallback1 = new BitmapAjaxCallback();
    BitmapAjaxCallback localBitmapAjaxCallback2 = localBitmapAjaxCallback1.ratio(paramFloat).bitmap(paramBitmap);
    return image(localBitmapAjaxCallback1);
  }

  public T image(Drawable paramDrawable)
  {
    if ((this.view instanceof ImageView))
    {
      ImageView localImageView = (ImageView)this.view;
      localImageView.setTag(1090453505, null);
      localImageView.setImageDrawable(paramDrawable);
    }
    return self();
  }

  public T image(BitmapAjaxCallback paramBitmapAjaxCallback)
  {
    if ((this.view instanceof ImageView))
    {
      ImageView localImageView = (ImageView)this.view;
      BitmapAjaxCallback localBitmapAjaxCallback = paramBitmapAjaxCallback.imageView(localImageView);
      AbstractAQuery localAbstractAQuery = invoke(paramBitmapAjaxCallback);
    }
    return self();
  }

  public T image(File paramFile, int paramInt)
  {
    return image(paramFile, true, paramInt, null);
  }

  public T image(File paramFile, boolean paramBoolean, int paramInt, BitmapAjaxCallback paramBitmapAjaxCallback)
  {
    if (paramBitmapAjaxCallback == null)
      paramBitmapAjaxCallback = new BitmapAjaxCallback();
    BitmapAjaxCallback localBitmapAjaxCallback1 = paramBitmapAjaxCallback.file(paramFile);
    String str = null;
    if (paramFile != null)
      str = paramFile.getAbsolutePath();
    AbstractAQuery localAbstractAQuery = this;
    boolean bool = paramBoolean;
    int i = paramInt;
    BitmapAjaxCallback localBitmapAjaxCallback2 = paramBitmapAjaxCallback;
    return localAbstractAQuery.image(str, bool, true, i, 0, localBitmapAjaxCallback2);
  }

  public T image(String paramString)
  {
    AbstractAQuery localAbstractAQuery = this;
    String str = paramString;
    boolean bool = true;
    int i = 0;
    return localAbstractAQuery.image(str, true, bool, 0, i);
  }

  public T image(String paramString, ImageOptions paramImageOptions)
  {
    return image(paramString, paramImageOptions, null);
  }

  protected T image(String paramString1, ImageOptions paramImageOptions, String paramString2)
  {
    if ((this.view instanceof ImageView))
    {
      Activity localActivity = this.act;
      Context localContext = getContext();
      ImageView localImageView = (ImageView)this.view;
      Object localObject = this.progress;
      AccountHandle localAccountHandle = this.ah;
      HttpHost localHttpHost = this.proxy;
      String str1 = paramString1;
      ImageOptions localImageOptions = paramImageOptions;
      String str2 = paramString2;
      BitmapAjaxCallback.async(localActivity, localContext, localImageView, str1, localObject, localAccountHandle, localImageOptions, localHttpHost, str2);
      reset();
    }
    return self();
  }

  public T image(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AbstractAQuery localAbstractAQuery = this;
    String str = paramString;
    boolean bool1 = paramBoolean1;
    boolean bool2 = paramBoolean2;
    int i = 0;
    return localAbstractAQuery.image(str, bool1, bool2, 0, i);
  }

  public T image(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2)
  {
    AbstractAQuery localAbstractAQuery = this;
    String str = paramString;
    boolean bool1 = paramBoolean1;
    boolean bool2 = paramBoolean2;
    int i = paramInt1;
    int j = paramInt2;
    return localAbstractAQuery.image(str, bool1, bool2, i, j, null, 0);
  }

  public T image(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3)
  {
    AbstractAQuery localAbstractAQuery = this;
    String str = paramString;
    boolean bool1 = paramBoolean1;
    boolean bool2 = paramBoolean2;
    int i = paramInt1;
    int j = paramInt2;
    Bitmap localBitmap = paramBitmap;
    int k = paramInt3;
    return localAbstractAQuery.image(str, bool1, bool2, i, j, localBitmap, k, 0.0F);
  }

  public T image(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, float paramFloat)
  {
    AbstractAQuery localAbstractAQuery = this;
    String str = paramString;
    boolean bool1 = paramBoolean1;
    boolean bool2 = paramBoolean2;
    int i = paramInt1;
    int j = paramInt2;
    Bitmap localBitmap = paramBitmap;
    int k = paramInt3;
    float f = paramFloat;
    return localAbstractAQuery.image(str, bool1, bool2, i, j, localBitmap, k, f, 0, null);
  }

  protected T image(String paramString1, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, float paramFloat, int paramInt4, String paramString2)
  {
    if ((this.view instanceof ImageView))
    {
      Activity localActivity = this.act;
      Context localContext = getContext();
      ImageView localImageView = (ImageView)this.view;
      Object localObject = this.progress;
      AccountHandle localAccountHandle = this.ah;
      int i = this.policy;
      HttpHost localHttpHost = this.proxy;
      String str1 = paramString1;
      boolean bool1 = paramBoolean1;
      boolean bool2 = paramBoolean2;
      int j = paramInt1;
      int k = paramInt2;
      Bitmap localBitmap = paramBitmap;
      int m = paramInt3;
      float f = paramFloat;
      int n = paramInt4;
      String str2 = paramString2;
      BitmapAjaxCallback.async(localActivity, localContext, localImageView, str1, bool1, bool2, j, k, localBitmap, m, f, 3.4028235E+38F, localObject, localAccountHandle, i, n, localHttpHost, str2);
      reset();
    }
    return self();
  }

  public T image(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, BitmapAjaxCallback paramBitmapAjaxCallback)
  {
    Object localObject = ((BitmapAjaxCallback)((BitmapAjaxCallback)paramBitmapAjaxCallback.targetWidth(paramInt1).fallback(paramInt2).url(paramString)).memCache(paramBoolean1)).fileCache(paramBoolean2);
    return image(paramBitmapAjaxCallback);
  }

  public View inflate(View paramView, int paramInt, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      Integer localInteger1 = (Integer)paramView.getTag(1090453507);
      if ((localInteger1 != null) && (localInteger1.intValue() != paramInt))
        return paramView;
    }
    if (this.act != null);
    for (LayoutInflater localLayoutInflater = this.act.getLayoutInflater(); ; localLayoutInflater = (LayoutInflater)getContext().getSystemService("layout_inflater"))
    {
      View localView = localLayoutInflater.inflate(paramInt, paramViewGroup, false);
      Integer localInteger2 = Integer.valueOf(paramInt);
      localView.setTag(1090453507, localInteger2);
      paramView = localView;
      break;
    }
  }

  public T invalidate(String paramString)
  {
    File localFile = getCachedFile(paramString);
    if (localFile != null)
      boolean bool = localFile.delete();
    return self();
  }

  public T invisible()
  {
    if ((this.view != null) && (this.view.getVisibility() != 4))
      this.view.setVisibility(4);
    return self();
  }

  protected <K> T invoke(AbstractAjaxCallback<?, K> paramAbstractAjaxCallback)
  {
    AccountHandle localAccountHandle = this.ah;
    Object localObject1 = paramAbstractAjaxCallback.auth(localAccountHandle);
    Object localObject2 = this.progress;
    Object localObject3 = paramAbstractAjaxCallback.progress(localObject2);
    Transformer localTransformer = this.trans;
    Object localObject4 = paramAbstractAjaxCallback.transformer(localTransformer);
    int i = this.policy;
    Object localObject5 = paramAbstractAjaxCallback.policy(i);
    if (this.proxy != null)
    {
      String str = this.proxy.getHostName();
      int j = this.proxy.getPort();
      Object localObject6 = paramAbstractAjaxCallback.proxy(str, j);
    }
    if (this.act != null)
    {
      Activity localActivity = this.act;
      paramAbstractAjaxCallback.async(localActivity);
    }
    while (true)
    {
      reset();
      return self();
      Context localContext = getContext();
      paramAbstractAjaxCallback.async(localContext);
    }
  }

  public Object invoke(String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    Object localObject = this.view;
    if (localObject == null)
      localObject = this.act;
    String str = paramString;
    boolean bool = false;
    Class<?>[] arrayOfClass = paramArrayOfClass;
    Object[] arrayOfObject = paramArrayOfObject;
    return AQUtility.invokeHandler(localObject, str, false, bool, arrayOfClass, arrayOfObject);
  }

  public boolean isChecked()
  {
    boolean bool = false;
    if ((this.view instanceof CompoundButton))
      bool = ((CompoundButton)this.view).isChecked();
    return bool;
  }

  public boolean isExist()
  {
    if (this.view != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public T itemClicked(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    if ((this.view instanceof AdapterView))
      ((AdapterView)this.view).setOnItemClickListener(paramOnItemClickListener);
    return self();
  }

  public T itemClicked(Object paramObject, String paramString)
  {
    Common localCommon1 = new Common();
    Class[] arrayOfClass = ON_ITEM_SIG;
    Common localCommon2 = localCommon1.forward(paramObject, paramString, true, arrayOfClass);
    return itemClicked(localCommon2);
  }

  public T itemSelected(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    if ((this.view instanceof AdapterView))
      ((AdapterView)this.view).setOnItemSelectedListener(paramOnItemSelectedListener);
    return self();
  }

  public T itemSelected(Object paramObject, String paramString)
  {
    Common localCommon1 = new Common();
    Class[] arrayOfClass = ON_ITEM_SIG;
    Common localCommon2 = localCommon1.forward(paramObject, paramString, true, arrayOfClass);
    return itemSelected(localCommon2);
  }

  public T longClick()
  {
    if (this.view != null)
      boolean bool = this.view.performLongClick();
    return self();
  }

  public T longClicked(View.OnLongClickListener paramOnLongClickListener)
  {
    if (this.view != null)
      this.view.setOnLongClickListener(paramOnLongClickListener);
    return self();
  }

  public T longClicked(Object paramObject, String paramString)
  {
    Common localCommon1 = new Common();
    Class[] arrayOfClass = ON_CLICK_SIG;
    Common localCommon2 = localCommon1.forward(paramObject, paramString, true, arrayOfClass);
    return longClicked(localCommon2);
  }

  public File makeSharedFile(String paramString1, String paramString2)
  {
    Object localObject1 = null;
    try
    {
      File localFile1 = getCachedFile(paramString1);
      if (localFile1 != null)
      {
        File localFile2 = AQUtility.getTempDir();
        if (localFile2 != null)
          localFile3 = new File(localFile2, paramString2);
      }
      try
      {
        boolean bool = localFile3.createNewFile();
        FileChannel localFileChannel1 = new FileInputStream(localFile1).getChannel();
        FileChannel localFileChannel2 = new FileOutputStream(localFile3).getChannel();
        FileChannel localFileChannel3 = localFileChannel2;
        long l1 = null;
        try
        {
          long l2 = localFileChannel1.size();
          long l3 = localFileChannel1.transferTo(l1, l2, localFileChannel3);
          if (localFileChannel1 != null)
            localFileChannel1.close();
          if (localFileChannel3 != null)
          {
            localFileChannel3.close();
            localObject1 = localFile3;
            return localObject1;
          }
        }
        finally
        {
          if (localFileChannel1 != null)
            localFileChannel1.close();
          if (localFileChannel3 != null)
            localFileChannel3.close();
        }
      }
      catch (Exception localException1)
      {
        while (true)
        {
          localObject1 = localFile3;
          AQUtility.debug(localException1);
        }
      }
    }
    catch (Exception localException2)
    {
      while (true)
      {
        File localFile3;
        continue;
        localObject1 = localFile3;
      }
    }
  }

  public T margin(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (this.view != null)
    {
      ViewGroup.LayoutParams localLayoutParams = this.view.getLayoutParams();
      if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
      {
        Context localContext = getContext();
        int i = AQUtility.dip2pixel(localContext, paramFloat1);
        int j = AQUtility.dip2pixel(localContext, paramFloat2);
        int k = AQUtility.dip2pixel(localContext, paramFloat3);
        int m = AQUtility.dip2pixel(localContext, paramFloat4);
        ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins(i, j, k, m);
        this.view.setLayoutParams(localLayoutParams);
      }
    }
    return self();
  }

  public T overridePendingTransition5(int paramInt1, int paramInt2)
  {
    if (this.act != null)
    {
      Activity localActivity = this.act;
      Class[] arrayOfClass = PENDING_TRANSITION_SIG;
      Object[] arrayOfObject = new Object[2];
      Integer localInteger1 = Integer.valueOf(paramInt1);
      arrayOfObject[0] = localInteger1;
      Integer localInteger2 = Integer.valueOf(paramInt2);
      arrayOfObject[1] = localInteger2;
      boolean bool = false;
      Object localObject = AQUtility.invokeHandler(localActivity, "overridePendingTransition", false, bool, arrayOfClass, arrayOfObject);
    }
    return self();
  }

  public T parent(int paramInt)
  {
    View localView1 = this.view;
    View localView2 = null;
    while (true)
    {
      if (localView1 == null);
      ViewParent localViewParent;
      do
      {
        while (true)
        {
          return create(localView2);
          if (localView1.getId() == paramInt)
            break;
          localView2 = localView1;
        }
        localViewParent = localView1.getParent();
      }
      while (!(localViewParent instanceof View));
      localView1 = (View)localViewParent;
    }
  }

  public T policy(int paramInt)
  {
    this.policy = paramInt;
    return self();
  }

  public T progress(int paramInt)
  {
    View localView = findView(paramInt);
    this.progress = localView;
    return self();
  }

  public T progress(Dialog paramDialog)
  {
    this.progress = paramDialog;
    return self();
  }

  public T progress(Object paramObject)
  {
    this.progress = paramObject;
    return self();
  }

  public T proxy(String paramString, int paramInt)
  {
    HttpHost localHttpHost = new HttpHost(paramString, paramInt);
    this.proxy = localHttpHost;
    return self();
  }

  public <K> T put(String paramString1, String paramString2, HttpEntity paramHttpEntity, Class<K> paramClass, AjaxCallback<K> paramAjaxCallback)
  {
    Object localObject = ((AjaxCallback)((AjaxCallback)((AjaxCallback)((AjaxCallback)paramAjaxCallback.url(paramString1)).type(paramClass)).method(3)).header("Content-Type", paramString2)).param("%entity", paramHttpEntity);
    return ajax(paramAjaxCallback);
  }

  public T rating(float paramFloat)
  {
    if ((this.view instanceof RatingBar))
      ((RatingBar)this.view).setRating(paramFloat);
    return self();
  }

  public T recycle(View paramView)
  {
    this.root = paramView;
    this.view = paramView;
    reset();
    this.context = null;
    return self();
  }

  protected void reset()
  {
    this.ah = null;
    this.progress = null;
    this.trans = null;
    this.policy = 0;
    this.proxy = null;
  }

  public T scrolled(AbsListView.OnScrollListener paramOnScrollListener)
  {
    if ((this.view instanceof AbsListView))
      setScrollListener().forward(paramOnScrollListener);
    return self();
  }

  public T scrolledBottom(Object paramObject, String paramString)
  {
    if ((this.view instanceof AbsListView))
    {
      Common localCommon1 = setScrollListener();
      Class[] arrayOfClass = ON_SCROLLED_STATE_SIG;
      Common localCommon2 = localCommon1.forward(paramObject, paramString, true, arrayOfClass);
    }
    return self();
  }

  public T setLayerType11(int paramInt, Paint paramPaint)
  {
    if (this.view != null)
    {
      View localView = this.view;
      Class[] arrayOfClass = LAYER_TYPE_SIG;
      Object[] arrayOfObject = new Object[2];
      Integer localInteger = Integer.valueOf(paramInt);
      arrayOfObject[0] = localInteger;
      arrayOfObject[1] = paramPaint;
      boolean bool = false;
      Object localObject = AQUtility.invokeHandler(localView, "setLayerType", false, bool, arrayOfClass, arrayOfObject);
    }
    return self();
  }

  public T setOverScrollMode9(int paramInt)
  {
    if ((this.view instanceof AbsListView))
    {
      View localView = this.view;
      Class[] arrayOfClass = OVER_SCROLL_SIG;
      Object[] arrayOfObject = new Object[1];
      Integer localInteger = Integer.valueOf(paramInt);
      arrayOfObject[0] = localInteger;
      boolean bool = false;
      Object localObject = AQUtility.invokeHandler(localView, "setOverScrollMode", false, bool, arrayOfClass, arrayOfObject);
    }
    return self();
  }

  public T setSelection(int paramInt)
  {
    if ((this.view instanceof AdapterView))
      ((AdapterView)this.view).setSelection(paramInt);
    return self();
  }

  public boolean shouldDelay(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup, String paramString)
  {
    return Common.shouldDelay(paramInt1, paramInt2, paramView, paramViewGroup, paramString);
  }

  public boolean shouldDelay(int paramInt, View paramView, ViewGroup paramViewGroup, String paramString)
  {
    if ((paramViewGroup instanceof ExpandableListView))
      throw new IllegalArgumentException("Please use the other shouldDelay methods for expandable list.");
    return Common.shouldDelay(paramInt, paramView, paramViewGroup, paramString);
  }

  public boolean shouldDelay(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup, String paramString)
  {
    return Common.shouldDelay(paramInt, -1, paramView, paramViewGroup, paramString);
  }

  @Deprecated
  public boolean shouldDelay(View paramView, ViewGroup paramViewGroup, String paramString, float paramFloat)
  {
    return Common.shouldDelay(paramView, paramViewGroup, paramString, paramFloat, true);
  }

  @Deprecated
  public boolean shouldDelay(View paramView, ViewGroup paramViewGroup, String paramString, float paramFloat, boolean paramBoolean)
  {
    return Common.shouldDelay(paramView, paramViewGroup, paramString, paramFloat, paramBoolean);
  }

  public T show(Dialog paramDialog)
  {
    if (paramDialog != null);
    try
    {
      paramDialog.show();
      Object localObject = dialogs.put(paramDialog, null);
      label17: return self();
    }
    catch (Exception localException)
    {
      break label17;
    }
  }

  public <K> T sync(AjaxCallback<K> paramAjaxCallback)
  {
    AbstractAQuery localAbstractAQuery = ajax(paramAjaxCallback);
    paramAjaxCallback.block();
    return self();
  }

  public T tag(int paramInt, Object paramObject)
  {
    if (this.view != null)
      this.view.setTag(paramInt, paramObject);
    return self();
  }

  public T tag(Object paramObject)
  {
    if (this.view != null)
      this.view.setTag(paramObject);
    return self();
  }

  public T text(int paramInt)
  {
    if ((this.view instanceof TextView))
      ((TextView)this.view).setText(paramInt);
    return self();
  }

  public T text(int paramInt, Object[] paramArrayOfObject)
  {
    Context localContext = getContext();
    if (localContext != null)
    {
      String str = localContext.getString(paramInt, paramArrayOfObject);
      AbstractAQuery localAbstractAQuery = text(str);
    }
    return self();
  }

  public T text(Spanned paramSpanned)
  {
    if ((this.view instanceof TextView))
      ((TextView)this.view).setText(paramSpanned);
    return self();
  }

  public T text(CharSequence paramCharSequence)
  {
    if ((this.view instanceof TextView))
      ((TextView)this.view).setText(paramCharSequence);
    return self();
  }

  public T text(CharSequence paramCharSequence, boolean paramBoolean)
  {
    if ((paramBoolean) && ((paramCharSequence == null) || (paramCharSequence.length() == 0)));
    for (AbstractAQuery localAbstractAQuery = gone(); ; localAbstractAQuery = text(paramCharSequence))
      return localAbstractAQuery;
  }

  public T textChanged(Object paramObject, String paramString)
  {
    if ((this.view instanceof TextView))
    {
      TextView localTextView = (TextView)this.view;
      Common localCommon1 = new Common();
      Class[] arrayOfClass = TEXT_CHANGE_SIG;
      Common localCommon2 = localCommon1.forward(paramObject, paramString, true, arrayOfClass);
      localTextView.addTextChangedListener(localCommon2);
    }
    return self();
  }

  public T textColor(int paramInt)
  {
    if ((this.view instanceof TextView))
      ((TextView)this.view).setTextColor(paramInt);
    return self();
  }

  public T textSize(float paramFloat)
  {
    if ((this.view instanceof TextView))
      ((TextView)this.view).setTextSize(paramFloat);
    return self();
  }

  public T transformer(Transformer paramTransformer)
  {
    this.trans = paramTransformer;
    return self();
  }

  public T transparent(boolean paramBoolean)
  {
    if (this.view != null)
      AQUtility.transparent(this.view, paramBoolean);
    return self();
  }

  public T typeface(Typeface paramTypeface)
  {
    if ((this.view instanceof TextView))
      ((TextView)this.view).setTypeface(paramTypeface);
    return self();
  }

  public T visible()
  {
    if ((this.view != null) && (this.view.getVisibility() != 0))
      this.view.setVisibility(0);
    return self();
  }

  public T webImage(String paramString)
  {
    return webImage(paramString, true, false, -16777216);
  }

  public T webImage(String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((this.view instanceof WebView))
    {
      AbstractAQuery localAbstractAQuery = setLayerType11(1, null);
      WebView localWebView = (WebView)this.view;
      Object localObject = this.progress;
      String str = paramString;
      boolean bool1 = paramBoolean1;
      boolean bool2 = paramBoolean2;
      int i = paramInt;
      new WebImage(localWebView, str, localObject, bool1, bool2, i).load();
      this.progress = null;
    }
    return self();
  }

  public T width(int paramInt)
  {
    size(true, paramInt, true);
    return self();
  }

  public T width(int paramInt, boolean paramBoolean)
  {
    size(true, paramInt, paramBoolean);
    return self();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.androidquery.AbstractAQuery
 * JD-Core Version:    0.6.2
 */