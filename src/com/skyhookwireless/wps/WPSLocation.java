package com.skyhookwireless.wps;

import com.skyhookwireless._sdkhb;
import java.io.Serializable;

public class WPSLocation extends Location
  implements Cloneable, Serializable
{
  private static final long serialVersionUID = -7494157700399138637L;
  private static final String[] z;
  private int _sdkj;
  private int _sdkk;
  private int _sdkl;
  private double _sdkm;
  private double _sdkn;
  private StreetAddress _sdko;
  _sdkzb _sdkp;
  private boolean _sdkq;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[8];
    Object localObject2 = "\003iTk".toCharArray();
    int i = localObject2.length;
    int j;
    Object localObject3;
    int k;
    int i1;
    int i2;
    if (i <= 1)
    {
      j = 0;
      localObject3 = localObject2;
      k = j;
      int m = i;
      Object localObject4 = localObject2;
      int n = m;
      while (true)
      {
        i1 = localObject4[j];
        switch (k % 5)
        {
        default:
          i2 = 86;
          int i3 = (char)(i2 ^ i1);
          localObject4[j] = i3;
          j = k + 1;
          if (n != 0)
            break label129;
          localObject4 = localObject3;
          k = j;
          j = n;
        case 0:
        case 1:
        case 2:
        case 3:
        }
      }
      label129: i = n;
      localObject2 = localObject3;
    }
    while (i <= j)
    {
      String str1 = new String((char[])localObject2).intern();
      arrayOfString[0] = str1;
      Object localObject5 = "H/T.v".toCharArray();
      int i4 = localObject5.length;
      int i5;
      label180: int i8;
      if (i4 <= 1)
      {
        i5 = 0;
        localObject3 = localObject5;
        k = i5;
        int i6 = i4;
        Object localObject6 = localObject5;
        int i7 = i6;
        while (true)
        {
          i1 = localObject6[i5];
          switch (k % 5)
          {
          default:
            i8 = 86;
            label244: int i9 = (char)(i8 ^ i1);
            localObject6[i5] = i9;
            i5 = k + 1;
            if (i7 != 0)
              break label285;
            localObject6 = localObject3;
            int i10 = i5;
            i5 = i7;
          case 0:
          case 1:
          case 2:
          case 3:
          }
        }
        label285: i4 = i7;
        localObject5 = localObject3;
      }
      while (true)
      {
        if (i4 > i5)
          break label180;
        String str2 = new String((char[])localObject5).intern();
        arrayOfString[1] = str2;
        int i11 = 2;
        Object localObject7 = "Nb\032*\"".toCharArray();
        int i12 = localObject7.length;
        int i13;
        label343: int i16;
        int i17;
        if (i12 <= 1)
        {
          i13 = 0;
          localObject3 = localObject7;
          k = i13;
          int i14 = i12;
          Object localObject8 = localObject7;
          int i15 = i14;
          while (true)
          {
            i16 = localObject8[i13];
            switch (k % 5)
            {
            default:
              i17 = 86;
              label408: int i18 = (char)(i17 ^ i16);
              localObject8[i13] = i18;
              i13 = k + 1;
              if (i15 != 0)
                break label449;
              localObject8 = localObject3;
              int i19 = i13;
              i13 = i15;
            case 0:
            case 1:
            case 2:
            case 3:
            }
          }
          label449: i12 = i15;
          localObject7 = localObject3;
        }
        while (true)
        {
          if (i12 > i13)
            break label343;
          String str3 = new String((char[])localObject7).intern();
          arrayOfString[i11] = str3;
          int i20 = 3;
          Object localObject9 = "G'\034f".toCharArray();
          int i21 = localObject9.length;
          int i22;
          label508: int i25;
          if (i21 <= 1)
          {
            i22 = 0;
            localObject3 = localObject9;
            k = i22;
            int i23 = i21;
            Object localObject10 = localObject9;
            int i24 = i23;
            while (true)
            {
              i16 = localObject10[i22];
              switch (k % 5)
              {
              default:
                i25 = 86;
                label572: int i26 = (char)(i25 ^ i16);
                localObject10[i22] = i26;
                i22 = k + 1;
                if (i24 != 0)
                  break label613;
                localObject10 = localObject3;
                int i27 = i22;
                i22 = i24;
              case 0:
              case 1:
              case 2:
              case 3:
              }
            }
            label613: i21 = i24;
            localObject9 = localObject3;
          }
          while (true)
          {
            if (i21 > i22)
              break label508;
            String str4 = new String((char[])localObject9).intern();
            arrayOfString[i20] = str4;
            int i28 = 4;
            Object localObject11 = "\017b".toCharArray();
            int i29 = localObject11.length;
            int i30;
            label672: int i33;
            if (i29 <= 1)
            {
              i30 = 0;
              localObject3 = localObject11;
              k = i30;
              int i31 = i29;
              Object localObject12 = localObject11;
              int i32 = i31;
              while (true)
              {
                i16 = localObject12[i30];
                switch (k % 5)
                {
                default:
                  i33 = 86;
                  label736: int i34 = (char)(i33 ^ i16);
                  localObject12[i30] = i34;
                  i30 = k + 1;
                  if (i32 != 0)
                    break label777;
                  localObject12 = localObject3;
                  int i35 = i30;
                  i30 = i32;
                case 0:
                case 1:
                case 2:
                case 3:
                }
              }
              label777: i29 = i32;
              localObject11 = localObject3;
            }
            while (true)
            {
              if (i29 > i30)
                break label672;
              String str5 = new String((char[])localObject11).intern();
              arrayOfString[i28] = str5;
              int i36 = 5;
              Object localObject13 = "\nb".toCharArray();
              int i37 = localObject13.length;
              int i38;
              label836: int i41;
              if (i37 <= 1)
              {
                i38 = 0;
                localObject3 = localObject13;
                k = i38;
                int i39 = i37;
                Object localObject14 = localObject13;
                int i40 = i39;
                while (true)
                {
                  i16 = localObject14[i38];
                  switch (k % 5)
                  {
                  default:
                    i41 = 86;
                    label900: int i42 = (char)(i41 ^ i16);
                    localObject14[i38] = i42;
                    i38 = k + 1;
                    if (i40 != 0)
                      break label941;
                    localObject14 = localObject3;
                    int i43 = i38;
                    i38 = i40;
                  case 0:
                  case 1:
                  case 2:
                  case 3:
                  }
                }
                label941: i37 = i40;
                localObject13 = localObject3;
              }
              while (true)
              {
                if (i37 > i38)
                  break label836;
                String str6 = new String((char[])localObject13).intern();
                arrayOfString[i36] = str6;
                int i44 = 6;
                Object localObject15 = "NbS".toCharArray();
                int i45 = localObject15.length;
                label1001: int i50;
                label1068: int i47;
                if (i45 <= 1)
                {
                  int i46 = 0;
                  localObject3 = localObject15;
                  k = i46;
                  int i48 = i45;
                  Object localObject17 = localObject15;
                  int i49 = i48;
                  while (true)
                  {
                    i16 = localObject17[i46];
                    switch (k % 5)
                    {
                    default:
                      i50 = 86;
                      int i51 = (char)(i50 ^ i16);
                      localObject17[i46] = i51;
                      i47 = k + 1;
                      if (i49 != 0)
                        break label1109;
                      localObject17 = localObject3;
                      int i52 = i47;
                      i47 = i49;
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    }
                  }
                  label1109: i45 = i49;
                  localObject15 = localObject3;
                }
                while (true)
                {
                  if (i45 > i47)
                    break label1001;
                  String str7 = new String((char[])localObject15).intern();
                  arrayOfString[i44] = str7;
                  int i53 = 7;
                  Object localObject18 = "N1".toCharArray();
                  Object localObject19 = localObject18.length;
                  label1166: Object localObject21;
                  Object localObject22;
                  label1185: int i54;
                  if (localObject19 <= 1)
                  {
                    localObject16 = localObject18;
                    localObject3 = localObject1;
                    Object localObject20 = localObject19;
                    localObject21 = localObject18;
                    localObject22 = localObject20;
                    i44 = localObject21[localObject1];
                    switch (localObject3 % 5)
                    {
                    default:
                      i54 = 86;
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    }
                  }
                  while (true)
                  {
                    int i55 = (char)(i54 ^ i44);
                    localObject21[localObject1] = i55;
                    localObject1 = localObject3 + 1;
                    if (localObject22 == 0)
                    {
                      localObject21 = localObject16;
                      int i56 = localObject1;
                      localObject1 = localObject22;
                      break label1185;
                    }
                    localObject19 = localObject22;
                    localObject18 = localObject16;
                    if (localObject19 > localObject1)
                      break label1166;
                    String str8 = new String((char[])localObject18).intern();
                    arrayOfString[i53] = str8;
                    z = arrayOfString;
                    return;
                    i2 = 35;
                    break;
                    i2 = 66;
                    break;
                    i2 = 123;
                    break;
                    i2 = 70;
                    break;
                    i8 = 35;
                    break label244;
                    i8 = 66;
                    break label244;
                    i8 = 123;
                    break label244;
                    i8 = 70;
                    break label244;
                    i17 = 35;
                    break label408;
                    i17 = 66;
                    break label408;
                    i17 = 123;
                    break label408;
                    i17 = 70;
                    break label408;
                    i25 = 35;
                    break label572;
                    i25 = 66;
                    break label572;
                    i25 = 123;
                    break label572;
                    i25 = 70;
                    break label572;
                    i33 = 35;
                    break label736;
                    i33 = 66;
                    break label736;
                    i33 = 123;
                    break label736;
                    i33 = 70;
                    break label736;
                    i41 = 35;
                    break label900;
                    i41 = 66;
                    break label900;
                    i41 = 123;
                    break label900;
                    i41 = 70;
                    break label900;
                    i50 = 35;
                    break label1068;
                    i50 = 66;
                    break label1068;
                    i50 = 123;
                    break label1068;
                    i50 = 70;
                    break label1068;
                    i54 = 35;
                    continue;
                    i54 = 66;
                    continue;
                    i54 = 123;
                    continue;
                    i54 = 70;
                  }
                  Object localObject16 = null;
                }
                i38 = 0;
              }
              i30 = 0;
            }
            i22 = 0;
          }
          i13 = 0;
        }
        i5 = 0;
      }
      j = 0;
    }
  }

  @Deprecated
  protected WPSLocation()
  {
  }

  public WPSLocation(double paramDouble1, double paramDouble2, long paramLong, int paramInt1, int paramInt2, int paramInt3, double paramDouble3, double paramDouble4, StreetAddress paramStreetAddress, _sdkzb param_sdkzb)
  {
    super(paramDouble1, paramDouble2, paramLong);
    this._sdkj = paramInt1;
    this._sdkk = paramInt2;
    this._sdkl = paramInt3;
    this._sdkm = paramDouble3;
    this._sdkn = paramDouble4;
    this._sdko = paramStreetAddress;
    this._sdkp = param_sdkzb;
  }

  boolean _sdka()
  {
    if (this._sdkm == 0.0D);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public WPSLocation clone()
  {
    try
    {
      WPSLocation localWPSLocation = (WPSLocation)super.clone();
      if (this._sdko != null)
      {
        StreetAddress localStreetAddress = this._sdko.clone();
        localWPSLocation._sdko = localStreetAddress;
      }
      if (this._sdkp != null)
      {
        _sdkzb local_sdkzb = this._sdkp.clone();
        localWPSLocation._sdkp = local_sdkzb;
      }
      return localWPSLocation;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new RuntimeException(localCloneNotSupportedException);
    }
  }

  public double getBearing()
  {
    return this._sdkn;
  }

  public int getHPE()
  {
    return this._sdkj;
  }

  public int getNAP()
  {
    return this._sdkk;
  }

  public int getNCell()
  {
    return this._sdkl;
  }

  public double getSpeed()
  {
    return this._sdkm;
  }

  public StreetAddress getStreetAddress()
  {
    return this._sdko;
  }

  public boolean hasHPE()
  {
    return this._sdkq;
  }

  protected void setBearing(double paramDouble)
  {
    this._sdkn = paramDouble;
  }

  protected void setHPE(int paramInt)
  {
    this._sdkj = paramInt;
    this._sdkq = true;
  }

  protected void setNAP(int paramInt)
  {
    this._sdkk = paramInt;
  }

  protected void setNCell(int paramInt)
  {
    this._sdkl = paramInt;
  }

  protected void setSpeed(double paramDouble)
  {
    this._sdkm = paramDouble;
  }

  public void setStreetAddress(StreetAddress paramStreetAddress)
  {
    this._sdko = paramStreetAddress;
  }

  public String toString()
  {
    int i = Location._sdki;
    StringBuilder localStringBuilder1 = new StringBuilder();
    double d1 = Math.round(getLatitude() * 10000000.0D) / 10000000.0D;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(d1);
    String str1 = z[4];
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str1);
    double d2 = Math.round(getLongitude() * 10000000.0D) / 10000000.0D;
    StringBuilder localStringBuilder4 = localStringBuilder3.append(d2);
    String str2 = z[0];
    StringBuilder localStringBuilder5 = localStringBuilder4.append(str2);
    int j = Math.round(getHPE() * 10) / 10;
    StringBuilder localStringBuilder6 = localStringBuilder5.append(j);
    String str3 = z[6];
    StringBuilder localStringBuilder7 = localStringBuilder6.append(str3);
    int k = getNAP();
    StringBuilder localStringBuilder8 = localStringBuilder7.append(k).append("+");
    int m = getNCell();
    StringBuilder localStringBuilder9 = localStringBuilder8.append(m);
    String str4 = z[5];
    StringBuilder localStringBuilder10 = localStringBuilder9.append(str4);
    long l1 = Math.round(getSpeed() * 10.0D) / 10L;
    StringBuilder localStringBuilder11 = localStringBuilder10.append(l1);
    String str5 = z[1];
    StringBuilder localStringBuilder12 = localStringBuilder11.append(str5);
    long l2 = Math.round(getBearing() * 10.0D) / 10L;
    StringBuilder localStringBuilder13 = localStringBuilder12.append(l2);
    String str6 = z[3];
    StringBuilder localStringBuilder14 = localStringBuilder13.append(str6);
    String str8;
    StringBuilder localStringBuilder17;
    StringBuilder localStringBuilder18;
    StreetAddress localStreetAddress;
    if (hasAltitude())
    {
      StringBuilder localStringBuilder15 = new StringBuilder().append(" ");
      double d3 = getAltitude();
      StringBuilder localStringBuilder16 = localStringBuilder15.append(d3);
      String str7 = z[2];
      str8 = str7;
      localStringBuilder17 = localStringBuilder14.append(str8);
      if (this._sdko == null)
        break label409;
      localStringBuilder18 = new StringBuilder().append("\n");
      localStreetAddress = this._sdko;
    }
    label409: StringBuilder localStringBuilder20;
    String str11;
    for (String str9 = localStreetAddress; ; str9 = str11)
    {
      String str10 = str9;
      if (_sdkhb._sdkd)
        Location._sdki = i + 1;
      return str10;
      str8 = "";
      break;
      StringBuilder localStringBuilder19 = new StringBuilder().append(" ");
      long l3 = getTime();
      localStringBuilder20 = localStringBuilder19.append(l3);
      str11 = z[7];
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps.WPSLocation
 * JD-Core Version:    0.6.2
 */