package checkpoint.forms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.MASTAdView.MASTAdView;
import java.util.ArrayList;

public class TestListAdapter extends BaseAdapter
{
  ArrayList<MASTAdView> ads;
  Context context;
  protected LayoutInflater mInflater;
  int maxCount = 1000;

  public TestListAdapter(Context paramContext)
  {
    int i = this.maxCount;
    ArrayList localArrayList = new ArrayList(i);
    this.ads = localArrayList;
    LayoutInflater localLayoutInflater = LayoutInflater.from(paramContext);
    this.mInflater = localLayoutInflater;
    this.context = paramContext;
    int j = 0;
    while (true)
    {
      int k = this.maxCount;
      if (j >= k)
        return;
      boolean bool = this.ads.add(null);
      j += 1;
    }
  }

  public int getCount()
  {
    return this.maxCount;
  }

  public Object getItem(int paramInt)
  {
    return null;
  }

  public long getItemId(int paramInt)
  {
    return 0L;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MASTAdView localMASTAdView;
    if (this.ads.get(paramInt) == null)
    {
      Context localContext = this.context;
      Integer localInteger1 = Integer.valueOf(8061);
      Integer localInteger2 = Integer.valueOf(20249);
      localMASTAdView = new MASTAdView(localContext, localInteger1, localInteger2);
      ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
      localMASTAdView.setLayoutParams(localLayoutParams);
      localMASTAdView.update();
      Integer localInteger3 = Integer.valueOf(320);
      localMASTAdView.setMaxSizeX(localInteger3);
      Integer localInteger4 = Integer.valueOf(50);
      localMASTAdView.setMaxSizeY(localInteger4);
      localMASTAdView.setBackgroundColor(0);
      Object localObject = this.ads.set(paramInt, localMASTAdView);
    }
    while (true)
    {
      if (paramView == null)
      {
        LayoutInflater localLayoutInflater = this.mInflater;
        int i = R.layout.list_item;
        paramView = localLayoutInflater.inflate(i, null);
      }
      ((LinearLayout)paramView).removeAllViews();
      ((LinearLayout)paramView).addView(localMASTAdView);
      return paramView;
      localMASTAdView = (MASTAdView)this.ads.get(paramInt);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     checkpoint.forms.TestListAdapter
 * JD-Core Version:    0.6.2
 */