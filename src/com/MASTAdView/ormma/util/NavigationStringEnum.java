package com.MASTAdView.ormma.util;

public enum NavigationStringEnum
{
  private String text;

  static
  {
    CLOSE = new NavigationStringEnum("CLOSE", 1, "close");
    BACK = new NavigationStringEnum("BACK", 2, "back");
    FORWARD = new NavigationStringEnum("FORWARD", 3, "forward");
    REFRESH = new NavigationStringEnum("REFRESH", 4, "refresh");
    NavigationStringEnum[] arrayOfNavigationStringEnum = new NavigationStringEnum[5];
    NavigationStringEnum localNavigationStringEnum1 = NONE;
    arrayOfNavigationStringEnum[0] = localNavigationStringEnum1;
    NavigationStringEnum localNavigationStringEnum2 = CLOSE;
    arrayOfNavigationStringEnum[1] = localNavigationStringEnum2;
    NavigationStringEnum localNavigationStringEnum3 = BACK;
    arrayOfNavigationStringEnum[2] = localNavigationStringEnum3;
    NavigationStringEnum localNavigationStringEnum4 = FORWARD;
    arrayOfNavigationStringEnum[3] = localNavigationStringEnum4;
    NavigationStringEnum localNavigationStringEnum5 = REFRESH;
    arrayOfNavigationStringEnum[4] = localNavigationStringEnum5;
  }

  private NavigationStringEnum(String arg3)
  {
    Object localObject;
    this.text = localObject;
  }

  public static NavigationStringEnum fromString(String paramString)
  {
    NavigationStringEnum[] arrayOfNavigationStringEnum;
    int i;
    int j;
    if (paramString != null)
    {
      arrayOfNavigationStringEnum = values();
      i = arrayOfNavigationStringEnum.length;
      j = 0;
    }
    while (true)
    {
      NavigationStringEnum localNavigationStringEnum;
      if (j >= i)
        localNavigationStringEnum = null;
      String str;
      do
      {
        return localNavigationStringEnum;
        localNavigationStringEnum = arrayOfNavigationStringEnum[j];
        str = localNavigationStringEnum.text;
      }
      while (paramString.equalsIgnoreCase(str));
      j += 1;
    }
  }

  public String getText()
  {
    return this.text;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.ormma.util.NavigationStringEnum
 * JD-Core Version:    0.6.2
 */