package com.skyhookwireless.wps;

import com.skyhookwireless._sdkbb;
import com.skyhookwireless._sdkec;
import com.skyhookwireless._sdkhd;
import java.util.ArrayList;

public class _sdkib extends WPSLocation
  implements _sdkbb
{
  private static final long serialVersionUID = -6586258996256528592L;
  private static final String[] z;
  private int _sdkr = 0;
  private _sdkec _sdks;
  private boolean _sdkt = false;
  private boolean _sdku = false;
  private boolean _sdkv = false;
  private boolean _sdkw = false;
  private boolean _sdkx = false;

  static
  {
    int i = 1;
    String[] arrayOfString = new String[8];
    Object localObject1 = "\021*j\030\036A'n\017p".toCharArray();
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
          i3 = 77;
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
      Object localObject4 = "\021*j\030\005a\0076".toCharArray();
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
            i9 = 77;
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
        Object localObject6 = "\0211j\037>\f".toCharArray();
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
              i18 = 77;
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
          Object localObject8 = "\021*j\030\f]6b\0378U'6".toCharArray();
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
                i26 = 77;
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
            Object localObject10 = "\021*j\030\031X/nV".toCharArray();
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
                  i34 = 77;
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
              int i37 = 5;
              Object localObject12 = "\021*j\030\001^,l\0029D&nV".toCharArray();
              int i38 = localObject12.length;
              int i39;
              label836: int i42;
              if (i38 <= 1)
              {
                i39 = 0;
                localObject2 = localObject12;
                m = i39;
                int i40 = i38;
                Object localObject13 = localObject12;
                int i41 = i40;
                while (true)
                {
                  i17 = localObject13[i39];
                  switch (m % 5)
                  {
                  default:
                    i42 = 77;
                    label900: int i43 = (char)(i42 ^ i17);
                    localObject13[i39] = i43;
                    i39 = m + 1;
                    if (i41 != 0)
                      break label941;
                    localObject13 = localObject2;
                    int i44 = i39;
                    i39 = i41;
                  case 0:
                  case 1:
                  case 2:
                  case 3:
                  }
                }
                label941: i38 = i41;
                localObject12 = localObject2;
              }
              while (true)
              {
                if (i38 > i39)
                  break label836;
                String str6 = new String((char[])localObject12).intern();
                arrayOfString[i37] = str6;
                int i45 = 6;
                Object localObject14 = "\021*j\030\017T#y\002#V".toCharArray();
                int i46 = localObject14.length;
                int i47;
                label1001: int i50;
                if (i46 <= 1)
                {
                  i47 = 0;
                  localObject2 = localObject14;
                  m = i47;
                  int i48 = i46;
                  Object localObject15 = localObject14;
                  int i49 = i48;
                  while (true)
                  {
                    i17 = localObject15[i47];
                    switch (m % 5)
                    {
                    default:
                      i50 = 77;
                      label1068: int i51 = (char)(i50 ^ i17);
                      localObject15[i47] = i51;
                      i47 = m + 1;
                      if (i49 != 0)
                        break label1109;
                      localObject15 = localObject2;
                      int i52 = i47;
                      i47 = i49;
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    }
                  }
                  label1109: i46 = i49;
                  localObject14 = localObject2;
                }
                while (true)
                {
                  if (i46 > i47)
                    break label1001;
                  String str7 = new String((char[])localObject14).intern();
                  arrayOfString[i45] = str7;
                  int i53 = 7;
                  Object localObject16 = "\021*j\030\001P6b\0378U'6".toCharArray();
                  int i54 = localObject16.length;
                  int i55;
                  label1169: int i58;
                  if (i54 <= 1)
                  {
                    i55 = 0;
                    localObject2 = localObject16;
                    m = i55;
                    int i56 = i54;
                    Object localObject17 = localObject16;
                    int i57 = i56;
                    while (true)
                    {
                      i17 = localObject17[i55];
                      switch (m % 5)
                      {
                      default:
                        i58 = 77;
                        label1236: int i59 = (char)(i58 ^ i17);
                        localObject17[i55] = i59;
                        i55 = m + 1;
                        if (i57 != 0)
                          break label1277;
                        localObject17 = localObject2;
                        int i60 = i55;
                        i55 = i57;
                      case 0:
                      case 1:
                      case 2:
                      case 3:
                      }
                    }
                    label1277: i54 = i57;
                    localObject16 = localObject2;
                  }
                  while (true)
                  {
                    if (i54 > i55)
                      break label1169;
                    String str8 = new String((char[])localObject16).intern();
                    arrayOfString[i53] = str8;
                    z = arrayOfString;
                    if (!_sdkib.class.desiredAssertionStatus());
                    while (true)
                    {
                      _sdky = i;
                      return;
                      i = 0;
                    }
                    i3 = 49;
                    break;
                    i3 = 66;
                    break;
                    i3 = 11;
                    break;
                    i3 = 107;
                    break;
                    i9 = 49;
                    break label244;
                    i9 = 66;
                    break label244;
                    i9 = 11;
                    break label244;
                    i9 = 107;
                    break label244;
                    i18 = 49;
                    break label408;
                    i18 = 66;
                    break label408;
                    i18 = 11;
                    break label408;
                    i18 = 107;
                    break label408;
                    i26 = 49;
                    break label572;
                    i26 = 66;
                    break label572;
                    i26 = 11;
                    break label572;
                    i26 = 107;
                    break label572;
                    i34 = 49;
                    break label736;
                    i34 = 66;
                    break label736;
                    i34 = 11;
                    break label736;
                    i34 = 107;
                    break label736;
                    i42 = 49;
                    break label900;
                    i42 = 66;
                    break label900;
                    i42 = 11;
                    break label900;
                    i42 = 107;
                    break label900;
                    i50 = 49;
                    break label1068;
                    i50 = 66;
                    break label1068;
                    i50 = 11;
                    break label1068;
                    i50 = 107;
                    break label1068;
                    i58 = 49;
                    break label1236;
                    i58 = 66;
                    break label1236;
                    i58 = 11;
                    break label1236;
                    i58 = 107;
                    break label1236;
                    i55 = 0;
                  }
                  i47 = 0;
                }
                i39 = 0;
              }
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

  public _sdkib()
  {
    super(0.0D, 0.0D, 0L, 0, 0, 0, 0.0D, 0.0D, null, null);
  }

  private long _sdka(_sdkec param_sdkec)
  {
    long l1 = System.currentTimeMillis();
    long l2 = param_sdkec._sdka();
    return l1 - l2;
  }

  private void _sdkb(_sdkec param_sdkec)
  {
    setAge(param_sdkec);
    long l = _sdka(param_sdkec);
    setTime(l);
  }

  boolean _sdkb()
  {
    return this._sdkw;
  }

  boolean _sdkc()
  {
    if ((getLatitude() == 0.0D) && (getLongitude() == 0.0D));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  boolean _sdkd()
  {
    int i = getNAP();
    int j = getSatellites();
    if (i + j >= 2)
    {
      int k = getNAP();
      int m = getSatellites();
      int n = k + m;
      int i1 = getNCell();
      if (n + i1 < 3);
    }
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  boolean _sdke()
  {
    int i = 1;
    if ((getSatellites() >= i) && (getNAP() == 0) && (getNCell() == 0));
    while (true)
    {
      return i;
      int j = 0;
    }
  }

  boolean _sdkf()
  {
    if ((!_sdky) && (!hasSpeed()))
      throw new AssertionError();
    if (getSpeed() <= 2.222222222222222D);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public _sdkib clone()
  {
    return (_sdkib)super.clone();
  }

  public _sdkec getAge()
  {
    return this._sdks;
  }

  public int getSatellites()
  {
    return this._sdkr;
  }

  public boolean hasBearing()
  {
    return this._sdkt;
  }

  public boolean hasLatitude()
  {
    return this._sdku;
  }

  public boolean hasLongitude()
  {
    return this._sdkv;
  }

  public boolean hasSpeed()
  {
    return this._sdkw;
  }

  public boolean hasTime()
  {
    return this._sdkx;
  }

  public boolean isExtrapolated()
  {
    if ((getNAP() == 0) && (getNCell() == 0) && (getSatellites() == 0));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void setAge(_sdkec param_sdkec)
  {
    this._sdks = param_sdkec;
  }

  public void setBearing(double paramDouble)
  {
    super.setBearing(paramDouble);
    this._sdkt = true;
  }

  public void setHPE(int paramInt)
  {
    super.setHPE(paramInt);
  }

  public void setLatitude(double paramDouble)
  {
    super.setLatitude(paramDouble);
    this._sdku = true;
  }

  public void setLongitude(double paramDouble)
  {
    super.setLongitude(paramDouble);
    this._sdkv = true;
  }

  public void setNAP(int paramInt)
  {
    super.setNAP(paramInt);
  }

  public void setNCell(int paramInt)
  {
    super.setNCell(paramInt);
  }

  public void setSatellites(int paramInt)
  {
    this._sdkr = paramInt;
  }

  public void setSpeed(double paramDouble)
  {
    super.setSpeed(paramDouble);
    this._sdkw = true;
  }

  public void setTime(long paramLong)
  {
    super.setTime(paramLong);
    if (paramLong == 0L);
    for (boolean bool = false; ; bool = true)
    {
      this._sdkx = bool;
      return;
    }
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = super.toString();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    String str2 = z[2];
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str2);
    int i = this._sdkr;
    StringBuilder localStringBuilder4 = localStringBuilder3.append(i);
    String str3 = z[3];
    StringBuilder localStringBuilder5 = localStringBuilder4.append(str3);
    boolean bool1 = hasAltitude();
    StringBuilder localStringBuilder6 = localStringBuilder5.append(bool1);
    String str4 = z[6];
    StringBuilder localStringBuilder7 = localStringBuilder6.append(str4);
    boolean bool2 = this._sdkt;
    StringBuilder localStringBuilder8 = localStringBuilder7.append(bool2);
    String str5 = z[1];
    StringBuilder localStringBuilder9 = localStringBuilder8.append(str5);
    boolean bool3 = hasHPE();
    StringBuilder localStringBuilder10 = localStringBuilder9.append(bool3);
    String str6 = z[7];
    StringBuilder localStringBuilder11 = localStringBuilder10.append(str6);
    boolean bool4 = this._sdku;
    StringBuilder localStringBuilder12 = localStringBuilder11.append(bool4);
    String str7 = z[5];
    StringBuilder localStringBuilder13 = localStringBuilder12.append(str7);
    boolean bool5 = this._sdkv;
    StringBuilder localStringBuilder14 = localStringBuilder13.append(bool5);
    String str8 = z[0];
    StringBuilder localStringBuilder15 = localStringBuilder14.append(str8);
    boolean bool6 = this._sdkw;
    StringBuilder localStringBuilder16 = localStringBuilder15.append(bool6);
    String str9 = z[4];
    StringBuilder localStringBuilder17 = localStringBuilder16.append(str9);
    boolean bool7 = this._sdkx;
    return bool7;
  }

  public void updateAgeBasedOn(_sdkzb param_sdkzb)
  {
    if ((!param_sdkzb.getAPs().isEmpty()) && (getNAP() > 0))
    {
      _sdkec local_sdkec1 = _sdkhd._sdka(param_sdkzb.getAPs()).getAge();
      _sdkb(local_sdkec1);
      if (Location._sdki == 0)
        return;
    }
    if (param_sdkzb.getCells().isEmpty())
      return;
    _sdkec local_sdkec2 = _sdkhd._sdka(param_sdkzb.getCells()).getAge();
    _sdkb(local_sdkec2);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkib
 * JD-Core Version:    0.6.2
 */