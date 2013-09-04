package com.nostra13.universalimageloader.core.assist;

public enum ImageScaleType
{
  static
  {
    IN_SAMPLE_POWER_OF_2 = new ImageScaleType("IN_SAMPLE_POWER_OF_2", 1);
    EXACT = new ImageScaleType("EXACT", 2);
    IN_SAMPLE_INT = new ImageScaleType("IN_SAMPLE_INT", 3);
    EXACTLY = new ImageScaleType("EXACTLY", 4);
    EXACTLY_STRETCHED = new ImageScaleType("EXACTLY_STRETCHED", 5);
    ImageScaleType[] arrayOfImageScaleType = new ImageScaleType[6];
    ImageScaleType localImageScaleType1 = POWER_OF_2;
    arrayOfImageScaleType[0] = localImageScaleType1;
    ImageScaleType localImageScaleType2 = IN_SAMPLE_POWER_OF_2;
    arrayOfImageScaleType[1] = localImageScaleType2;
    ImageScaleType localImageScaleType3 = EXACT;
    arrayOfImageScaleType[2] = localImageScaleType3;
    ImageScaleType localImageScaleType4 = IN_SAMPLE_INT;
    arrayOfImageScaleType[3] = localImageScaleType4;
    ImageScaleType localImageScaleType5 = EXACTLY;
    arrayOfImageScaleType[4] = localImageScaleType5;
    ImageScaleType localImageScaleType6 = EXACTLY_STRETCHED;
    arrayOfImageScaleType[5] = localImageScaleType6;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.ImageScaleType
 * JD-Core Version:    0.6.2
 */