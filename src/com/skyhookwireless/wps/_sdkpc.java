package com.skyhookwireless.wps;

import com.skyhookwireless._sdkhb;
import com.skyhookwireless._sdkrb;
import com.skyhookwireless._sdktb;
import com.skyhookwireless._sdkxd;
import java.io.InputStream;
import java.util.LinkedList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

final class _sdkpc
  implements _sdke
{
  private static final String[] z;
  private final _sdkhb _sdka;
  private final String _sdkb;
  private final _sdkqc _sdkc;
  private final _sdktb _sdkd;
  private final _sdkxd _sdke;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[13];
    Object localObject2 = "I\n!\bh^\031>".toCharArray();
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
          i2 = 69;
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
      Object localObject5 = "\002>\004+L9\001".toCharArray();
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
            i8 = 69;
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
        Object localObject7 = "N\0231\b5_\002=\003eD\b1\0307Y\0166M,EK=\003\021B\007;\003\"y8r\016$G\0070\f&@".toCharArray();
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
              i17 = 69;
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
          Object localObject9 = "J\t=\0371N\017".toCharArray();
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
                i25 = 69;
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
            Object localObject11 = "B\017".toCharArray();
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
                  i33 = 69;
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
              Object localObject13 = "^\031>".toCharArray();
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
                    i41 = 69;
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
                Object localObject15 = "M\n;\001 OK&\002e[\n \036 \013\0317\0365D\005!\b".toCharArray();
                int i45 = localObject15.length;
                int i46;
                label1001: int i49;
                if (i45 <= 1)
                {
                  i46 = 0;
                  localObject3 = localObject15;
                  k = i46;
                  int i47 = i45;
                  Object localObject16 = localObject15;
                  int i48 = i47;
                  while (true)
                  {
                    i16 = localObject16[i46];
                    switch (k % 5)
                    {
                    default:
                      i49 = 69;
                      label1068: int i50 = (char)(i49 ^ i16);
                      localObject16[i46] = i50;
                      i46 = k + 1;
                      if (i48 != 0)
                        break label1109;
                      localObject16 = localObject3;
                      int i51 = i46;
                      i46 = i48;
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    }
                  }
                  label1109: i45 = i48;
                  localObject15 = localObject3;
                }
                while (true)
                {
                  if (i45 > i46)
                    break label1001;
                  String str7 = new String((char[])localObject15).intern();
                  arrayOfString[i44] = str7;
                  int i52 = 7;
                  Object localObject17 = "\004\037;\001,E\f".toCharArray();
                  int i53 = localObject17.length;
                  int i54;
                  label1169: int i57;
                  if (i53 <= 1)
                  {
                    i54 = 0;
                    localObject3 = localObject17;
                    k = i54;
                    int i55 = i53;
                    Object localObject18 = localObject17;
                    int i56 = i55;
                    while (true)
                    {
                      i16 = localObject18[i54];
                      switch (k % 5)
                      {
                      default:
                        i57 = 69;
                        label1236: int i58 = (char)(i57 ^ i16);
                        localObject18[i54] = i58;
                        i54 = k + 1;
                        if (i56 != 0)
                          break label1277;
                        localObject18 = localObject3;
                        int i59 = i54;
                        i54 = i56;
                      case 0:
                      case 1:
                      case 2:
                      case 3:
                      }
                    }
                    label1277: i53 = i56;
                    localObject17 = localObject3;
                  }
                  while (true)
                  {
                    if (i53 > i54)
                      break label1169;
                    String str8 = new String((char[])localObject17).intern();
                    arrayOfString[i52] = str8;
                    int i60 = 8;
                    Object localObject19 = "N\031 \0027".toCharArray();
                    int i61 = localObject19.length;
                    int i62;
                    label1337: int i65;
                    if (i61 <= 1)
                    {
                      i62 = 0;
                      localObject3 = localObject19;
                      k = i62;
                      int i63 = i61;
                      Object localObject20 = localObject19;
                      int i64 = i63;
                      while (true)
                      {
                        i16 = localObject20[i62];
                        switch (k % 5)
                        {
                        default:
                          i65 = 69;
                          label1404: int i66 = (char)(i65 ^ i16);
                          localObject20[i62] = i66;
                          i62 = k + 1;
                          if (i64 != 0)
                            break label1445;
                          localObject20 = localObject3;
                          int i67 = i62;
                          i62 = i64;
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        }
                      }
                      label1445: i61 = i64;
                      localObject19 = localObject3;
                    }
                    while (true)
                    {
                      if (i61 > i62)
                        break label1337;
                      String str9 = new String((char[])localObject19).intern();
                      arrayOfString[i60] = str9;
                      int i68 = 9;
                      Object localObject21 = "\002>\004+L9\003M#J\002>\b!\013\034;\031-\013\030&\f1^\030r\016*O\016r".toCharArray();
                      int i69 = localObject21.length;
                      int i70;
                      label1505: int i73;
                      if (i69 <= 1)
                      {
                        i70 = 0;
                        localObject3 = localObject21;
                        k = i70;
                        int i71 = i69;
                        Object localObject22 = localObject21;
                        int i72 = i71;
                        while (true)
                        {
                          i16 = localObject22[i70];
                          switch (k % 5)
                          {
                          default:
                            i73 = 69;
                            label1572: int i74 = (char)(i73 ^ i16);
                            localObject22[i70] = i74;
                            i70 = k + 1;
                            if (i72 != 0)
                              break label1613;
                            localObject22 = localObject3;
                            int i75 = i70;
                            i70 = i72;
                          case 0:
                          case 1:
                          case 2:
                          case 3:
                          }
                        }
                        label1613: i69 = i72;
                        localObject21 = localObject3;
                      }
                      while (true)
                      {
                        if (i69 > i70)
                          break label1505;
                        String str10 = new String((char[])localObject21).intern();
                        arrayOfString[i68] = str10;
                        int i76 = 10;
                        Object localObject23 = "]\016 \036,D\005".toCharArray();
                        int i77 = localObject23.length;
                        int i78;
                        label1673: int i81;
                        if (i77 <= 1)
                        {
                          i78 = 0;
                          localObject3 = localObject23;
                          k = i78;
                          int i79 = i77;
                          Object localObject24 = localObject23;
                          int i80 = i79;
                          while (true)
                          {
                            i16 = localObject24[i78];
                            switch (k % 5)
                            {
                            default:
                              i81 = 69;
                              label1740: int i82 = (char)(i81 ^ i16);
                              localObject24[i78] = i82;
                              i78 = k + 1;
                              if (i80 != 0)
                                break label1781;
                              localObject24 = localObject3;
                              int i83 = i78;
                              i78 = i80;
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            }
                          }
                          label1781: i77 = i80;
                          localObject23 = localObject3;
                        }
                        while (true)
                        {
                          if (i77 > i78)
                            break label1673;
                          String str11 = new String((char[])localObject23).intern();
                          arrayOfString[i76] = str11;
                          int i84 = 11;
                          Object localObject25 = "N\0231\b5_\002=\003eD\b1\0307Y\0166We".toCharArray();
                          int i85 = localObject25.length;
                          label1841: int i90;
                          label1908: int i87;
                          if (i85 <= 1)
                          {
                            int i86 = 0;
                            localObject3 = localObject25;
                            k = i86;
                            int i88 = i85;
                            Object localObject27 = localObject25;
                            int i89 = i88;
                            while (true)
                            {
                              i16 = localObject27[i86];
                              switch (k % 5)
                              {
                              default:
                                i90 = 69;
                                int i91 = (char)(i90 ^ i16);
                                localObject27[i86] = i91;
                                i87 = k + 1;
                                if (i89 != 0)
                                  break label1949;
                                localObject27 = localObject3;
                                int i92 = i87;
                                i87 = i89;
                              case 0:
                              case 1:
                              case 2:
                              case 3:
                              }
                            }
                            label1949: i85 = i89;
                            localObject25 = localObject3;
                          }
                          while (true)
                          {
                            if (i85 > i87)
                              break label1841;
                            String str12 = new String((char[])localObject25).intern();
                            arrayOfString[i84] = str12;
                            int i93 = 12;
                            Object localObject28 = "_\002>\b".toCharArray();
                            Object localObject29 = localObject28.length;
                            label2006: Object localObject31;
                            Object localObject32;
                            label2025: int i94;
                            if (localObject29 <= 1)
                            {
                              localObject26 = localObject28;
                              localObject3 = localObject1;
                              Object localObject30 = localObject29;
                              localObject31 = localObject28;
                              localObject32 = localObject30;
                              i84 = localObject31[localObject1];
                              switch (localObject3 % 5)
                              {
                              default:
                                i94 = 69;
                              case 0:
                              case 1:
                              case 2:
                              case 3:
                              }
                            }
                            while (true)
                            {
                              int i95 = (char)(i94 ^ i84);
                              localObject31[localObject1] = i95;
                              localObject1 = localObject3 + 1;
                              if (localObject32 == 0)
                              {
                                localObject31 = localObject26;
                                int i96 = localObject1;
                                localObject1 = localObject32;
                                break label2025;
                              }
                              localObject29 = localObject32;
                              localObject28 = localObject26;
                              if (localObject29 > localObject1)
                                break label2006;
                              String str13 = new String((char[])localObject28).intern();
                              arrayOfString[i93] = str13;
                              z = arrayOfString;
                              return;
                              i2 = 43;
                              break;
                              i2 = 107;
                              break;
                              i2 = 82;
                              break;
                              i2 = 109;
                              break;
                              i8 = 43;
                              break label244;
                              i8 = 107;
                              break label244;
                              i8 = 82;
                              break label244;
                              i8 = 109;
                              break label244;
                              i17 = 43;
                              break label408;
                              i17 = 107;
                              break label408;
                              i17 = 82;
                              break label408;
                              i17 = 109;
                              break label408;
                              i25 = 43;
                              break label572;
                              i25 = 107;
                              break label572;
                              i25 = 82;
                              break label572;
                              i25 = 109;
                              break label572;
                              i33 = 43;
                              break label736;
                              i33 = 107;
                              break label736;
                              i33 = 82;
                              break label736;
                              i33 = 109;
                              break label736;
                              i41 = 43;
                              break label900;
                              i41 = 107;
                              break label900;
                              i41 = 82;
                              break label900;
                              i41 = 109;
                              break label900;
                              i49 = 43;
                              break label1068;
                              i49 = 107;
                              break label1068;
                              i49 = 82;
                              break label1068;
                              i49 = 109;
                              break label1068;
                              i57 = 43;
                              break label1236;
                              i57 = 107;
                              break label1236;
                              i57 = 82;
                              break label1236;
                              i57 = 109;
                              break label1236;
                              i65 = 43;
                              break label1404;
                              i65 = 107;
                              break label1404;
                              i65 = 82;
                              break label1404;
                              i65 = 109;
                              break label1404;
                              i73 = 43;
                              break label1572;
                              i73 = 107;
                              break label1572;
                              i73 = 82;
                              break label1572;
                              i73 = 109;
                              break label1572;
                              i81 = 43;
                              break label1740;
                              i81 = 107;
                              break label1740;
                              i81 = 82;
                              break label1740;
                              i81 = 109;
                              break label1740;
                              i90 = 43;
                              break label1908;
                              i90 = 107;
                              break label1908;
                              i90 = 82;
                              break label1908;
                              i90 = 109;
                              break label1908;
                              i94 = 43;
                              continue;
                              i94 = 107;
                              continue;
                              i94 = 82;
                              continue;
                              i94 = 109;
                            }
                            Object localObject26 = null;
                          }
                          i78 = 0;
                        }
                        i70 = 0;
                      }
                      i62 = 0;
                    }
                    i54 = 0;
                  }
                  i46 = 0;
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

  _sdkpc(WPSAuthentication paramWPSAuthentication, ScanHistory paramScanHistory, _sdkqc param_sdkqc, long paramLong)
  {
    _sdkhb local_sdkhb = _sdkhb._sdkb(_sdkpc.class);
    this._sdka = local_sdkhb;
    String str = Protocol.getTilingRQ(paramWPSAuthentication, paramScanHistory, paramLong);
    this._sdkb = str;
    this._sdkc = param_sdkqc;
    _sdktb local_sdktb = _sdktb._sdkc();
    this._sdkd = local_sdktb;
    _sdkxd local_sdkxd = new _sdkxd();
    this._sdke = local_sdkxd;
  }

  private String _sdka(Document paramDocument)
  {
    String str1 = null;
    String str2 = z[1];
    Object localObject = _sdkxd._sdka(paramDocument, str2);
    if (localObject != null)
    {
      localObject = ((Node)localObject).getAttributes();
      if (localObject != null)
      {
        String str3 = z[0];
        localObject = ((NamedNodeMap)localObject).getNamedItem(str3);
        if (localObject != null)
          str1 = ((Node)localObject).getNodeValue();
      }
    }
    return str1;
  }

  public void abort()
  {
    this._sdkd._sdka();
  }

  public void run()
  {
    Object localObject1 = null;
    boolean bool = _sdkkc._sdkr;
    int j;
    try
    {
      _sdktb local_sdktb = this._sdkd;
      String str1 = z[7];
      String str2 = this._sdkb;
      j = local_sdktb._sdka(str1, str2);
      if (Thread.interrupted())
      {
        _sdkhb local_sdkhb1 = this._sdka;
        String str3 = z[3];
        local_sdkhb1._sdkb(str3);
        _sdkqc local_sdkqc1 = this._sdkc;
        String str4 = z[3];
        local_sdkqc1._sdka(-1, str4);
        return;
      }
      if (j._sdka() != 200)
      {
        _sdkhb local_sdkhb2 = this._sdka;
        StringBuilder localStringBuilder1 = new StringBuilder();
        String str5 = z[9];
        StringBuilder localStringBuilder2 = localStringBuilder1.append(str5);
        int n = j._sdka();
        String str6 = n;
        local_sdkhb2._sdke(str6);
        _sdkqc local_sdkqc2 = this._sdkc;
        int i1 = j._sdka();
        local_sdkqc2._sdka(i1, "");
        return;
      }
    }
    catch (Exception localException)
    {
      _sdkqc local_sdkqc3 = this._sdkc;
      StringBuilder localStringBuilder3 = new StringBuilder();
      String str7 = z[11];
      StringBuilder localStringBuilder4 = localStringBuilder3.append(str7);
      String str8 = localException.toString();
      String str9 = str8;
      local_sdkqc3._sdka(-1, str9);
      return;
    }
    _sdkxd local_sdkxd = this._sdke;
    InputStream localInputStream = j._sdke();
    Document localDocument = local_sdkxd._sdka(localInputStream);
    String str10 = z[8];
    if (_sdkxd._sdkb(localDocument, str10) != null)
    {
      _sdkhb local_sdkhb3 = this._sdka;
      String str11 = z[6];
      local_sdkhb3._sdke(str11);
      _sdkqc local_sdkqc4 = this._sdkc;
      String str12 = z[6];
      local_sdkqc4._sdka(-1, str12);
      return;
    }
    String str13 = z[12];
    NodeList localNodeList = localDocument.getElementsByTagName(str13);
    LinkedList localLinkedList = new LinkedList();
    label589: Object localObject2;
    int m;
    for (int k = 0; ; m = localObject2)
    {
      int i2 = localNodeList.getLength();
      String str15;
      int i3;
      String str17;
      if (k < i2)
      {
        Element localElement = (Element)localNodeList.item(k);
        String str14 = z[4];
        str15 = localElement.getAttribute(str14);
        String str16 = z[10];
        i3 = Integer.valueOf(localElement.getAttribute(str16)).intValue();
        str17 = _sdka(localDocument);
        String str18 = z[5];
        Node localNode = localElement.getElementsByTagName(str18).item(0);
        StringBuilder localStringBuilder5 = new StringBuilder();
        String str19 = z[7];
        StringBuilder localStringBuilder6 = localStringBuilder5.append(str19);
        String str20 = localNode.getChildNodes().item(0).getNodeValue();
        localObject1 = str20;
        if (str17 != null)
          break label589;
      }
      _sdkic local_sdkic;
      for (localObject1 = _sdkic._sdkb(str15, i3, (String)localObject1); ; localObject2 = local_sdkic)
      {
        localLinkedList.addLast(localObject1);
        int i = k + 1;
        if (!bool)
          break;
        try
        {
          this._sdkc._sdka(localLinkedList);
          return;
        }
        catch (Throwable localThrowable)
        {
          _sdkhb local_sdkhb4 = this._sdka;
          String str21 = z[2];
          local_sdkhb4._sdke(str21, localThrowable);
          return;
        }
        local_sdkic = _sdkic._sdka(str15, i3, str17, localThrowable);
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkpc
 * JD-Core Version:    0.6.2
 */