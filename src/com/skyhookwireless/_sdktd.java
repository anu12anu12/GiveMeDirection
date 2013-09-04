package com.skyhookwireless;

public class _sdktd<T, U>
{
  public final T first;
  public final U second;

  public _sdktd(T paramT, U paramU)
  {
    this.first = paramT;
    this.second = paramU;
  }

  public static <T, U> _sdktd<T, U> _sdka(T paramT, U paramU)
  {
    return new _sdktd(paramT, paramU);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (this == paramObject)
      bool = true;
    while (true)
    {
      return bool;
      if (paramObject != null)
        try
        {
          paramObject = (_sdktd)paramObject;
          if (this.first != null)
          {
            Object localObject1 = this.first;
            Object localObject2 = paramObject.first;
            if (localObject1.equals(localObject2))
              label47: if (this.second != null)
              {
                Object localObject3 = this.second;
                Object localObject4 = paramObject.second;
                if (!localObject3.equals(localObject4))
                  continue;
              }
          }
          else
          {
            while (true)
            {
              bool = true;
              break;
              if (paramObject.first != null)
                break;
              break label47;
              Object localObject5 = paramObject.second;
              if (localObject5 != null)
                break;
            }
          }
        }
        catch (ClassCastException localClassCastException)
        {
        }
    }
  }

  public int hashCode()
  {
    int i = 0;
    int j;
    int k;
    if (this.first == null)
    {
      j = 0;
      k = (j + 629) * 37;
      if (this.second != null)
        break label42;
    }
    while (true)
    {
      return k + i;
      j = this.first.hashCode();
      break;
      label42: i = this.second.hashCode();
    }
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder().append("(");
    Object localObject1 = this.first;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(localObject1).append(",");
    Object localObject2 = this.second;
    return localObject2 + ")";
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdktd
 * JD-Core Version:    0.6.2
 */