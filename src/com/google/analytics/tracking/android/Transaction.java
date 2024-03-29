package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transaction
{
  private final String affiliation;
  private final String currencyCode;
  private final Map<String, Item> items;
  private final long shippingCostInMicros;
  private final long totalCostInMicros;
  private final long totalTaxInMicros;
  private final String transactionId;

  private Transaction(Builder paramBuilder)
  {
    String str1 = paramBuilder.transactionId;
    this.transactionId = str1;
    long l1 = paramBuilder.totalCostInMicros;
    this.totalCostInMicros = l1;
    String str2 = paramBuilder.affiliation;
    this.affiliation = str2;
    long l2 = paramBuilder.totalTaxInMicros;
    this.totalTaxInMicros = l2;
    long l3 = paramBuilder.shippingCostInMicros;
    this.shippingCostInMicros = l3;
    String str3 = paramBuilder.currencyCode;
    this.currencyCode = str3;
    HashMap localHashMap = new HashMap();
    this.items = localHashMap;
  }

  public void addItem(Item paramItem)
  {
    Map localMap = this.items;
    String str = paramItem.getProductSKU();
    Object localObject = localMap.put(str, paramItem);
  }

  public String getAffiliation()
  {
    return this.affiliation;
  }

  String getCurrencyCode()
  {
    return this.currencyCode;
  }

  public List<Item> getItems()
  {
    Collection localCollection = this.items.values();
    return new ArrayList(localCollection);
  }

  public long getShippingCostInMicros()
  {
    return this.shippingCostInMicros;
  }

  public long getTotalCostInMicros()
  {
    return this.totalCostInMicros;
  }

  public long getTotalTaxInMicros()
  {
    return this.totalTaxInMicros;
  }

  public String getTransactionId()
  {
    return this.transactionId;
  }

  public static class Builder
  {
    private String affiliation = null;
    private String currencyCode = null;
    private long shippingCostInMicros = 0L;
    private final long totalCostInMicros;
    private long totalTaxInMicros = 0L;
    private final String transactionId;

    public Builder(String paramString, long paramLong)
    {
      if (TextUtils.isEmpty(paramString))
        throw new IllegalArgumentException("transactionId must not be empty or null");
      this.transactionId = paramString;
      this.totalCostInMicros = paramLong;
    }

    public Transaction build()
    {
      return new Transaction(this, null);
    }

    public Builder setAffiliation(String paramString)
    {
      this.affiliation = paramString;
      return this;
    }

    Builder setCurrencyCode(String paramString)
    {
      this.currencyCode = paramString;
      return this;
    }

    public Builder setShippingCostInMicros(long paramLong)
    {
      this.shippingCostInMicros = paramLong;
      return this;
    }

    public Builder setTotalTaxInMicros(long paramLong)
    {
      this.totalTaxInMicros = paramLong;
      return this;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.Transaction
 * JD-Core Version:    0.6.2
 */