package com.nostra13.universalimageloader.core.assist;

public class ImageSize
{
  private static final String TO_STRING_PATTERN = "%sx%s";
  private final int height;
  private final int width;

  public ImageSize(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }

  public int getHeight()
  {
    return this.height;
  }

  public int getWidth()
  {
    return this.width;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    Integer localInteger1 = Integer.valueOf(this.width);
    arrayOfObject[0] = localInteger1;
    Integer localInteger2 = Integer.valueOf(this.height);
    arrayOfObject[1] = localInteger2;
    return String.format("%sx%s", arrayOfObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.ImageSize
 * JD-Core Version:    0.6.2
 */