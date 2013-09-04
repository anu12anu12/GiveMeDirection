package com.skyhookwireless;

public class _sdkud<T extends Comparable<? super T>, U extends Comparable<? super U>> extends _sdktd<T, U>
  implements Comparable<_sdktd<T, U>>
{
  public _sdkud(T paramT, U paramU)
  {
    super(paramT, paramU);
  }

  public static <T extends Comparable<? super T>, U extends Comparable<? super U>> _sdkud<T, U> _sdka(T paramT, U paramU)
  {
    return new _sdkud(paramT, paramU);
  }

  private static <V extends Comparable<? super V>> int _sdkb(V paramV1, V paramV2)
  {
    int i;
    if (paramV1 == paramV2)
      i = 0;
    while (true)
    {
      return i;
      if (paramV1 == null)
        i = -1;
      else if (paramV2 == null)
        i = 1;
      else
        i = paramV1.compareTo(paramV2);
    }
  }

  public int _sdka(_sdktd<T, U> param_sdktd)
  {
    int i;
    if (this == param_sdktd)
      i = 0;
    while (true)
    {
      return i;
      Comparable localComparable1 = (Comparable)this.first;
      Comparable localComparable2 = (Comparable)param_sdktd.first;
      i = _sdkb(localComparable1, localComparable2);
      if (i == 0)
      {
        Comparable localComparable3 = (Comparable)this.second;
        Comparable localComparable4 = (Comparable)param_sdktd.second;
        i = _sdkb(localComparable3, localComparable4);
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkud
 * JD-Core Version:    0.6.2
 */