package org.simpleframework.xml.core;

class Revision
{
  private boolean equal = true;

  public boolean compare(Object paramObject1, Object paramObject2)
  {
    if (paramObject2 != null)
    {
      boolean bool1 = paramObject2.equals(paramObject1);
      this.equal = bool1;
    }
    while (true)
    {
      return this.equal;
      if (paramObject1 != null)
      {
        Double localDouble = Double.valueOf(1.0D);
        boolean bool2 = paramObject1.equals(localDouble);
        this.equal = bool2;
      }
    }
  }

  public double getDefault()
  {
    return 1.0D;
  }

  public boolean isEqual()
  {
    return this.equal;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Revision
 * JD-Core Version:    0.6.2
 */