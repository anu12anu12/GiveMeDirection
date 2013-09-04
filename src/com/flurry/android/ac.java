package com.flurry.android;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.Html;
import android.text.Spanned;
import android.text.SpannedString;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

final class ac extends RelativeLayout
{
  private final SpannedString a;
  private final SpannedString b;

  public ac(CatalogActivity paramCatalogActivity, Context paramContext)
  {
    super(paramContext);
    Spanned localSpanned1 = Html.fromHtml("<html><div='style:font-size:7px'>&lt; Previous</div></html>");
    SpannedString localSpannedString1 = new SpannedString(localSpanned1);
    this.a = localSpannedString1;
    Spanned localSpanned2 = Html.fromHtml("<html><div='style:font-size:7px;color:#ffA500'>&lt; Previous</div></html>");
    SpannedString localSpannedString2 = new SpannedString(localSpanned2);
    this.b = localSpannedString2;
    setBackgroundColor(-16777216);
    TextView localTextView = new TextView(paramContext);
    ColorStateList localColorStateList = ColorStateList.valueOf(-1);
    localTextView.setTextColor(localColorStateList);
    localTextView.setId(10001);
    SpannedString localSpannedString3 = this.a;
    localTextView.setText(localSpannedString3);
    localTextView.setPadding(5, 2, 5, 2);
    localTextView.setFocusable(true);
    ad localad = new ad(this, localTextView);
    localTextView.setOnFocusChangeListener(localad);
    localTextView.setOnClickListener(paramCatalogActivity);
    localTextView.setEnabled(true);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams1.setMargins(0, 0, 0, 0);
    setLayoutParams(localLayoutParams1);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams2.setMargins(2, 0, 0, 0);
    localLayoutParams2.addRule(4);
    addView(localTextView, localLayoutParams2);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.flurry.android.ac
 * JD-Core Version:    0.6.2
 */