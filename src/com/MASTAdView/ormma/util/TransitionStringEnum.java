package com.MASTAdView.ormma.util;

public enum TransitionStringEnum
{
  private String text;

  static
  {
    NONE = new TransitionStringEnum("NONE", 6, "none");
    TransitionStringEnum[] arrayOfTransitionStringEnum = new TransitionStringEnum[7];
    TransitionStringEnum localTransitionStringEnum1 = DEFAULT;
    arrayOfTransitionStringEnum[0] = localTransitionStringEnum1;
    TransitionStringEnum localTransitionStringEnum2 = DISSOLVE;
    arrayOfTransitionStringEnum[1] = localTransitionStringEnum2;
    TransitionStringEnum localTransitionStringEnum3 = FADE;
    arrayOfTransitionStringEnum[2] = localTransitionStringEnum3;
    TransitionStringEnum localTransitionStringEnum4 = ROLL;
    arrayOfTransitionStringEnum[3] = localTransitionStringEnum4;
    TransitionStringEnum localTransitionStringEnum5 = SLIDE;
    arrayOfTransitionStringEnum[4] = localTransitionStringEnum5;
    TransitionStringEnum localTransitionStringEnum6 = ZOOM;
    arrayOfTransitionStringEnum[5] = localTransitionStringEnum6;
    TransitionStringEnum localTransitionStringEnum7 = NONE;
    arrayOfTransitionStringEnum[6] = localTransitionStringEnum7;
  }

  private TransitionStringEnum(String arg3)
  {
    Object localObject;
    this.text = localObject;
  }

  public static TransitionStringEnum fromString(String paramString)
  {
    TransitionStringEnum[] arrayOfTransitionStringEnum;
    int i;
    int j;
    if (paramString != null)
    {
      arrayOfTransitionStringEnum = values();
      i = arrayOfTransitionStringEnum.length;
      j = 0;
    }
    while (true)
    {
      TransitionStringEnum localTransitionStringEnum;
      if (j >= i)
        localTransitionStringEnum = null;
      String str;
      do
      {
        return localTransitionStringEnum;
        localTransitionStringEnum = arrayOfTransitionStringEnum[j];
        str = localTransitionStringEnum.text;
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
 * Qualified Name:     com.MASTAdView.ormma.util.TransitionStringEnum
 * JD-Core Version:    0.6.2
 */