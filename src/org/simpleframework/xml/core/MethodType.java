package org.simpleframework.xml.core;

 enum MethodType
{
  private int prefix;

  static
  {
    NONE = new MethodType("NONE", 3, 0);
    MethodType[] arrayOfMethodType = new MethodType[4];
    MethodType localMethodType1 = GET;
    arrayOfMethodType[0] = localMethodType1;
    MethodType localMethodType2 = IS;
    arrayOfMethodType[1] = localMethodType2;
    MethodType localMethodType3 = SET;
    arrayOfMethodType[2] = localMethodType3;
    MethodType localMethodType4 = NONE;
    arrayOfMethodType[3] = localMethodType4;
  }

  private MethodType(int paramInt)
  {
    this.prefix = paramInt;
  }

  public int getPrefix()
  {
    return this.prefix;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.MethodType
 * JD-Core Version:    0.6.2
 */