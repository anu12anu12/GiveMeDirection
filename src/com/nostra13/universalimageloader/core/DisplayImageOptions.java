package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;

public final class DisplayImageOptions
{
  private final boolean cacheInMemory;
  private final boolean cacheOnDisc;
  private final BitmapDisplayer displayer;
  private final Integer imageForEmptyUri;
  private final ImageScaleType imageScaleType;
  private final boolean resetViewBeforeLoading;
  private final Integer stubImage;

  private DisplayImageOptions(Builder paramBuilder)
  {
    Integer localInteger1 = paramBuilder.stubImage;
    this.stubImage = localInteger1;
    Integer localInteger2 = paramBuilder.imageForEmptyUri;
    this.imageForEmptyUri = localInteger2;
    boolean bool1 = paramBuilder.resetViewBeforeLoading;
    this.resetViewBeforeLoading = bool1;
    boolean bool2 = paramBuilder.cacheInMemory;
    this.cacheInMemory = bool2;
    boolean bool3 = paramBuilder.cacheOnDisc;
    this.cacheOnDisc = bool3;
    ImageScaleType localImageScaleType = paramBuilder.imageScaleType;
    this.imageScaleType = localImageScaleType;
    BitmapDisplayer localBitmapDisplayer = paramBuilder.displayer;
    this.displayer = localBitmapDisplayer;
  }

  public static DisplayImageOptions createSimple()
  {
    return new Builder().build();
  }

  BitmapDisplayer getDisplayer()
  {
    return this.displayer;
  }

  Integer getImageForEmptyUri()
  {
    return this.imageForEmptyUri;
  }

  ImageScaleType getImageScaleType()
  {
    return this.imageScaleType;
  }

  Integer getStubImage()
  {
    return this.stubImage;
  }

  boolean isCacheInMemory()
  {
    return this.cacheInMemory;
  }

  boolean isCacheOnDisc()
  {
    return this.cacheOnDisc;
  }

  boolean isResetViewBeforeLoading()
  {
    return this.resetViewBeforeLoading;
  }

  boolean isShowImageForEmptyUri()
  {
    if (this.imageForEmptyUri != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  boolean isShowStubImage()
  {
    if (this.stubImage != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public static class Builder
  {
    private boolean cacheInMemory = false;
    private boolean cacheOnDisc = false;
    private BitmapDisplayer displayer;
    private Integer imageForEmptyUri = null;
    private ImageScaleType imageScaleType;
    private boolean resetViewBeforeLoading = false;
    private Integer stubImage = null;

    public Builder()
    {
      ImageScaleType localImageScaleType = ImageScaleType.IN_SAMPLE_POWER_OF_2;
      this.imageScaleType = localImageScaleType;
      BitmapDisplayer localBitmapDisplayer = DefaultConfigurationFactory.createBitmapDisplayer();
      this.displayer = localBitmapDisplayer;
    }

    public DisplayImageOptions build()
    {
      return new DisplayImageOptions(this, null);
    }

    public Builder cacheInMemory()
    {
      this.cacheInMemory = true;
      return this;
    }

    public Builder cacheOnDisc()
    {
      this.cacheOnDisc = true;
      return this;
    }

    public Builder displayer(BitmapDisplayer paramBitmapDisplayer)
    {
      this.displayer = paramBitmapDisplayer;
      return this;
    }

    public Builder imageScaleType(ImageScaleType paramImageScaleType)
    {
      this.imageScaleType = paramImageScaleType;
      return this;
    }

    public Builder resetViewBeforeLoading()
    {
      this.resetViewBeforeLoading = true;
      return this;
    }

    public Builder showImageForEmptyUri(int paramInt)
    {
      Integer localInteger = Integer.valueOf(paramInt);
      this.imageForEmptyUri = localInteger;
      return this;
    }

    public Builder showStubImage(int paramInt)
    {
      Integer localInteger = Integer.valueOf(paramInt);
      this.stubImage = localInteger;
      return this;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.DisplayImageOptions
 * JD-Core Version:    0.6.2
 */