package com.flurry.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

final class s extends LinearLayout
{
  public s(CatalogActivity paramCatalogActivity, Context paramContext)
  {
    super(paramContext);
    setBackgroundColor(-1);
    AdImage localAdImage = CatalogActivity.c(paramCatalogActivity).l();
    if (localAdImage == null)
      return;
    ImageView localImageView = new ImageView(paramContext);
    localImageView.setId(10000);
    byte[] arrayOfByte = localAdImage.e;
    if (arrayOfByte != null)
    {
      int i = arrayOfByte.length;
      Bitmap localBitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, i);
      localImageView.setImageBitmap(localBitmap);
    }
    int j = localAdImage.b;
    int k = r.a(paramContext, j);
    int m = localAdImage.c;
    int n = r.a(paramContext, m);
    r.a(paramContext, localImageView, k, n);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(0, 0, 0, -1);
    setGravity(3);
    addView(localImageView, localLayoutParams);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.s
 * JD-Core Version:    0.6.2
 */