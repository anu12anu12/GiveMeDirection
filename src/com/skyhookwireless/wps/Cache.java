package com.skyhookwireless.wps;

import com.skyhookwireless._sdkhb;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Cache<K, V>
{
  static final boolean _sdke;
  private static final String[] z;
  private final Map<K, V> _sdka;
  private final _sdkhb _sdkb;
  private int _sdkc;
  private int _sdkd;

  static
  {
    int i = 1;
    String[] arrayOfString = new String[5];
    Object localObject1 = ".WW6".toCharArray();
    int j = localObject1.length;
    int k;
    Object localObject2;
    int m;
    int i2;
    int i3;
    if (j <= i)
    {
      k = 0;
      localObject2 = localObject1;
      m = k;
      int n = j;
      Object localObject3 = localObject1;
      int i1 = n;
      while (true)
      {
        i2 = localObject3[k];
        switch (m % 5)
        {
        default:
          i3 = 104;
          int i4 = (char)(i3 ^ i2);
          localObject3[k] = i4;
          k = m + 1;
          if (i1 != 0)
            break label129;
          localObject3 = localObject2;
          m = k;
          k = i1;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label129: j = i1;
      localObject1 = localObject2;
    }
    while (j <= k)
    {
      String str1 = new String((char[])localObject1).intern();
      arrayOfString[0] = str1;
      Object localObject4 = " _G-\rc\033We@+WPe\032\"JAHfZ\013`\fo\036\001kZ%\033\001l".toCharArray();
      int i5 = localObject4.length;
      int i6;
      label180: int i9;
      if (i5 <= 1)
      {
        i6 = 0;
        localObject2 = localObject4;
        m = i6;
        int i7 = i5;
        Object localObject5 = localObject4;
        int i8 = i7;
        while (true)
        {
          i2 = localObject5[i6];
          switch (m % 5)
          {
          default:
            i9 = 104;
            label244: int i10 = (char)(i9 ^ i2);
            localObject5[i6] = i10;
            i6 = m + 1;
            if (i8 != 0)
              break label285;
            localObject5 = localObject2;
            int i11 = i6;
            i6 = i8;
          case 0:
          case 1:
          case 2:
          case 3:
          }
        }
        label285: i5 = i8;
        localObject4 = localObject2;
      }
      while (true)
      {
        if (i5 > i6)
          break label180;
        String str2 = new String((char[])localObject4).intern();
        arrayOfString[1] = str2;
        int i12 = 2;
        Object localObject6 = "+WP".toCharArray();
        int i13 = localObject6.length;
        int i14;
        label343: int i17;
        int i18;
        if (i13 <= 1)
        {
          i14 = 0;
          localObject2 = localObject6;
          m = i14;
          int i15 = i13;
          Object localObject7 = localObject6;
          int i16 = i15;
          while (true)
          {
            i17 = localObject7[i14];
            switch (m % 5)
            {
            default:
              i18 = 104;
              label408: int i19 = (char)(i18 ^ i17);
              localObject7[i14] = i19;
              i14 = m + 1;
              if (i16 != 0)
                break label449;
              localObject7 = localObject2;
              int i20 = i14;
              i14 = i16;
            case 0:
            case 1:
            case 2:
            case 3:
            }
          }
          label449: i13 = i16;
          localObject6 = localObject2;
        }
        while (true)
        {
          if (i13 > i14)
            break label343;
          String str3 = new String((char[])localObject6).intern();
          arrayOfString[i12] = str3;
          int i21 = 3;
          Object localObject8 = "([]e\0056MPe\006,J\004'\rcPQ)\004".toCharArray();
          int i22 = localObject8.length;
          int i23;
          label508: int i26;
          if (i22 <= 1)
          {
            i23 = 0;
            localObject2 = localObject8;
            m = i23;
            int i24 = i22;
            Object localObject9 = localObject8;
            int i25 = i24;
            while (true)
            {
              i17 = localObject9[i23];
              switch (m % 5)
              {
              default:
                i26 = 104;
                label572: int i27 = (char)(i26 ^ i17);
                localObject9[i23] = i27;
                i23 = m + 1;
                if (i25 != 0)
                  break label613;
                localObject9 = localObject2;
                int i28 = i23;
                i23 = i25;
              case 0:
              case 1:
              case 2:
              case 3:
              }
            }
            label613: i22 = i25;
            localObject8 = localObject2;
          }
          while (true)
          {
            if (i22 > i23)
              break label508;
            String str4 = new String((char[])localObject8).intern();
            arrayOfString[i21] = str4;
            int i29 = 4;
            Object localObject10 = "5_H0\rcSQ6\034cPK1H![\004+\035/R".toCharArray();
            int i30 = localObject10.length;
            int i31;
            label672: int i34;
            if (i30 <= 1)
            {
              i31 = 0;
              localObject2 = localObject10;
              m = i31;
              int i32 = i30;
              Object localObject11 = localObject10;
              int i33 = i32;
              while (true)
              {
                i17 = localObject11[i31];
                switch (m % 5)
                {
                default:
                  i34 = 104;
                  label736: int i35 = (char)(i34 ^ i17);
                  localObject11[i31] = i35;
                  i31 = m + 1;
                  if (i33 != 0)
                    break label777;
                  localObject11 = localObject2;
                  int i36 = i31;
                  i31 = i33;
                case 0:
                case 1:
                case 2:
                case 3:
                }
              }
              label777: i30 = i33;
              localObject10 = localObject2;
            }
            while (true)
            {
              if (i30 > i31)
                break label672;
              String str5 = new String((char[])localObject10).intern();
              arrayOfString[i29] = str5;
              z = arrayOfString;
              if (!Cache.class.desiredAssertionStatus());
              while (true)
              {
                _sdke = i;
                return;
                i = 0;
              }
              i3 = 67;
              break;
              i3 = 62;
              break;
              i3 = 36;
              break;
              i3 = 69;
              break;
              i9 = 67;
              break label244;
              i9 = 62;
              break label244;
              i9 = 36;
              break label244;
              i9 = 69;
              break label244;
              i18 = 67;
              break label408;
              i18 = 62;
              break label408;
              i18 = 36;
              break label408;
              i18 = 69;
              break label408;
              i26 = 67;
              break label572;
              i26 = 62;
              break label572;
              i26 = 36;
              break label572;
              i26 = 69;
              break label572;
              i34 = 67;
              break label736;
              i34 = 62;
              break label736;
              i34 = 36;
              break label736;
              i34 = 69;
              break label736;
              i31 = 0;
            }
            i23 = 0;
          }
          i14 = 0;
        }
        i6 = 0;
      }
      k = 0;
    }
  }

  public Cache()
  {
    this(60);
  }

  public Cache(int paramInt)
  {
    _sdkhb local_sdkhb = _sdkhb._sdkb(Cache.class);
    this._sdkb = local_sdkhb;
    Cache localCache = this;
    int i = paramInt;
    int j = paramInt;
    _sdkzc local_sdkzc = new _sdkzc(localCache, i, 0.75F, true, j);
    this._sdka = local_sdkzc;
    if ((!_sdke) && (this._sdka.size() > paramInt))
      throw new AssertionError();
    _sdka();
  }

  private Map.Entry<K, V> _sdka(Cache.Finder<K, V> paramFinder, K paramK)
  {
    Iterator localIterator = this._sdka.entrySet().iterator();
    Map.Entry localEntry = paramFinder.call(localIterator, paramK);
    if (localEntry == null)
      localEntry = null;
    while (true)
    {
      return localEntry;
      Object localObject = localEntry.getKey();
      _sdka(localObject);
    }
  }

  private void _sdka()
  {
    this._sdkd = 0;
    this._sdkc = 0;
  }

  private void _sdka(K paramK)
  {
    Object localObject = this._sdka.get(paramK);
  }

  private void _sdkb(V paramV)
  {
    if (!this._sdkb._sdkb())
      return;
    int i;
    _sdkhb local_sdkhb;
    String str1;
    Object[] arrayOfObject;
    if (paramV != null)
    {
      i = 1;
      int j = this._sdkc + 1;
      this._sdkc = j;
      if (i != 0)
      {
        int k = this._sdkd + 1;
        this._sdkd = k;
      }
      local_sdkhb = this._sdkb;
      str1 = z[1];
      arrayOfObject = new Object[4];
      if (i == 0)
        break label173;
    }
    label173: for (String str2 = z[2]; ; str2 = z[0])
    {
      arrayOfObject[0] = str2;
      Integer localInteger1 = Integer.valueOf(this._sdkd);
      arrayOfObject[1] = localInteger1;
      Integer localInteger2 = Integer.valueOf(this._sdkc);
      arrayOfObject[2] = localInteger2;
      double d1 = this._sdkd;
      double d2 = 100.0D * d1;
      double d3 = this._sdkc;
      Double localDouble = Double.valueOf(d2 / d3);
      arrayOfObject[3] = localDouble;
      String str3 = String.format(str1, arrayOfObject);
      local_sdkhb._sdkb(str3);
      return;
      i = 0;
      break;
    }
  }

  public void add(K paramK, V paramV)
  {
    if (paramK == null)
    {
      String str1 = z[3];
      throw new NullPointerException(str1);
    }
    if (paramV == null)
    {
      String str2 = z[4];
      throw new NullPointerException(str2);
    }
    Object localObject = this._sdka.put(paramK, paramV);
  }

  public void add(K paramK, V paramV, Cache.Finder<K, V> paramFinder)
  {
    Map.Entry localEntry = _sdka(paramFinder, paramK);
    if (localEntry != null)
    {
      Object localObject = localEntry.setValue(paramV);
      return;
    }
    add(paramK, paramV);
  }

  public void clear()
  {
    this._sdka.clear();
    _sdka();
  }

  public V get(K paramK)
  {
    Object localObject = this._sdka.get(paramK);
    _sdkb(localObject);
    return localObject;
  }

  public V get(K paramK, Cache.Finder<K, V> paramFinder)
  {
    Map.Entry localEntry = _sdka(paramFinder, paramK);
    if (localEntry == null);
    for (Object localObject = null; ; localObject = localEntry.getKey())
      return get(localObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps.Cache
 * JD-Core Version:    0.6.2
 */