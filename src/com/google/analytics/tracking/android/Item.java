package com.google.analytics.tracking.android;

import android.text.TextUtils;

public class Item
{
  private final long itemPriceInMicros;
  private final long itemQuantity;
  private final String productCategory;
  private final String productName;
  private final String productSKU;

  private Item(Builder paramBuilder)
  {
    String str1 = paramBuilder.productSKU;
    this.productSKU = str1;
    long l1 = paramBuilder.itemPriceInMicros;
    this.itemPriceInMicros = l1;
    long l2 = paramBuilder.itemQuantity;
    this.itemQuantity = l2;
    String str2 = paramBuilder.productName;
    this.productName = str2;
    String str3 = paramBuilder.productCategory;
    this.productCategory = str3;
  }

  public long getItemPriceInMicros()
  {
    return this.itemPriceInMicros;
  }

  public long getItemQuantity()
  {
    return this.itemQuantity;
  }

  public String getProductCategory()
  {
    return this.productCategory;
  }

  public String getProductName()
  {
    return this.productName;
  }

  public String getProductSKU()
  {
    return this.productSKU;
  }

  public static class Builder
  {
    private final long itemPriceInMicros;
    private final long itemQuantity;
    private String productCategory = null;
    private final String productName;
    private final String productSKU;

    public Builder(String paramString1, String paramString2, long paramLong1, long paramLong2)
    {
      if (TextUtils.isEmpty(paramString1))
        throw new IllegalArgumentException("productSKU must not be empty or null");
      if (TextUtils.isEmpty(paramString2))
        throw new IllegalArgumentException("itemName must not be empty or null");
      this.productSKU = paramString1;
      this.productName = paramString2;
      this.itemPriceInMicros = paramLong1;
      this.itemQuantity = paramLong2;
    }

    public Item build()
    {
      return new Item(this, null);
    }

    public Builder setProductCategory(String paramString)
    {
      this.productCategory = paramString;
      return this;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.Item
 * JD-Core Version:    0.6.2
 */