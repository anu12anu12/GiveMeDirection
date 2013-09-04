package com.skyhookwireless;

import com.skyhookwireless.wps.WPS;
import java.io.IOException;
import java.io.InterruptedIOException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

final class _sdkub extends _sdktb
{
  private static final DefaultHttpClient _sdkf;
  private static final String[] z;
  private HttpUriRequest _sdke = null;

  static
  {
    Object localObject1 = 0;
    String[] arrayOfString = new String[11];
    Object localObject2 = "7|^".toCharArray();
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
          i2 = 101;
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
      Object localObject5 = "\030\r".toCharArray();
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
            i8 = 101;
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
        Object localObject7 = "7,".toCharArray();
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
              i17 = 101;
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
          Object localObject9 = "\007i\\\004��\006x\r\005\n\032g\r".toCharArray();
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
                i25 = 101;
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
            Object localObject11 = " H\003H4kH\037\021".toCharArray();
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
                  i33 = 101;
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
              Object localObject13 = "\035mIQ\025\020bI\030\013\022,D\037\021\020~_\004\025\001".toCharArray();
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
                    i41 = 101;
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
                Object localObject15 = "\"\\~Q$%E\rY".toCharArray();
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
                      i49 = 101;
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
                  Object localObject17 = "6cC\005��\033x��%\034\005i".toCharArray();
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
                        i57 = 101;
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
                    Object localObject19 = "\001iU\005J\raA".toCharArray();
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
                          i65 = 101;
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
                      Object localObject21 = "\035xY\001".toCharArray();
                      int i69 = localObject21.length;
                      label1505: int i74;
                      label1572: int i71;
                      if (i69 <= 1)
                      {
                        int i70 = 0;
                        localObject3 = localObject21;
                        k = i70;
                        int i72 = i69;
                        Object localObject23 = localObject21;
                        int i73 = i72;
                        while (true)
                        {
                          i16 = localObject23[i70];
                          switch (k % 5)
                          {
                          default:
                            i74 = 101;
                            int i75 = (char)(i74 ^ i16);
                            localObject23[i70] = i75;
                            i71 = k + 1;
                            if (i73 != 0)
                              break label1613;
                            localObject23 = localObject3;
                            int i76 = i71;
                            i71 = i73;
                          case 0:
                          case 1:
                          case 2:
                          case 3:
                          }
                        }
                        label1613: i69 = i73;
                        localObject21 = localObject3;
                      }
                      while (true)
                      {
                        if (i69 > i71)
                          break label1505;
                        String str10 = new String((char[])localObject21).intern();
                        arrayOfString[i68] = str10;
                        int i77 = 10;
                        Object localObject24 = "\035xY\001\026".toCharArray();
                        Object localObject25 = localObject24.length;
                        label1670: Object localObject27;
                        Object localObject28;
                        label1689: int i78;
                        if (localObject25 <= 1)
                        {
                          localObject22 = localObject24;
                          localObject3 = localObject1;
                          Object localObject26 = localObject25;
                          localObject27 = localObject24;
                          localObject28 = localObject26;
                          i68 = localObject27[localObject1];
                          switch (localObject3 % 5)
                          {
                          default:
                            i78 = 101;
                          case 0:
                          case 1:
                          case 2:
                          case 3:
                          }
                        }
                        while (true)
                        {
                          int i79 = (char)(i78 ^ i68);
                          localObject27[localObject1] = i79;
                          localObject1 = localObject3 + 1;
                          if (localObject28 == 0)
                          {
                            localObject27 = localObject22;
                            int i80 = localObject1;
                            localObject1 = localObject28;
                            break label1689;
                          }
                          localObject25 = localObject28;
                          localObject24 = localObject22;
                          if (localObject25 > localObject1)
                            break label1670;
                          String str11 = new String((char[])localObject24).intern();
                          arrayOfString[i77] = str11;
                          z = arrayOfString;
                          BasicHttpParams localBasicHttpParams = new BasicHttpParams();
                          HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 30000);
                          HttpConnectionParams.setSoTimeout(localBasicHttpParams, 30000);
                          SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
                          X509HostnameVerifier localX509HostnameVerifier = SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
                          localSSLSocketFactory.setHostnameVerifier(localX509HostnameVerifier);
                          SchemeRegistry localSchemeRegistry = new SchemeRegistry();
                          String str12 = z[9];
                          PlainSocketFactory localPlainSocketFactory = PlainSocketFactory.getSocketFactory();
                          Scheme localScheme1 = new Scheme(str12, localPlainSocketFactory, 80);
                          Scheme localScheme2 = localSchemeRegistry.register(localScheme1);
                          String str13 = z[10];
                          Scheme localScheme3 = new Scheme(str13, localSSLSocketFactory, 443);
                          Scheme localScheme4 = localSchemeRegistry.register(localScheme3);
                          ThreadSafeClientConnManager localThreadSafeClientConnManager = new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry);
                          _sdkf = new DefaultHttpClient(localThreadSafeClientConnManager, localBasicHttpParams);
                          return;
                          i2 = 117;
                          break;
                          i2 = 12;
                          break;
                          i2 = 45;
                          break;
                          i2 = 113;
                          break;
                          i8 = 117;
                          break label244;
                          i8 = 12;
                          break label244;
                          i8 = 45;
                          break label244;
                          i8 = 113;
                          break label244;
                          i17 = 117;
                          break label408;
                          i17 = 12;
                          break label408;
                          i17 = 45;
                          break label408;
                          i17 = 113;
                          break label408;
                          i25 = 117;
                          break label572;
                          i25 = 12;
                          break label572;
                          i25 = 45;
                          break label572;
                          i25 = 113;
                          break label572;
                          i33 = 117;
                          break label736;
                          i33 = 12;
                          break label736;
                          i33 = 45;
                          break label736;
                          i33 = 113;
                          break label736;
                          i41 = 117;
                          break label900;
                          i41 = 12;
                          break label900;
                          i41 = 45;
                          break label900;
                          i41 = 113;
                          break label900;
                          i49 = 117;
                          break label1068;
                          i49 = 12;
                          break label1068;
                          i49 = 45;
                          break label1068;
                          i49 = 113;
                          break label1068;
                          i57 = 117;
                          break label1236;
                          i57 = 12;
                          break label1236;
                          i57 = 45;
                          break label1236;
                          i57 = 113;
                          break label1236;
                          i65 = 117;
                          break label1404;
                          i65 = 12;
                          break label1404;
                          i65 = 45;
                          break label1404;
                          i65 = 113;
                          break label1404;
                          i74 = 117;
                          break label1572;
                          i74 = 12;
                          break label1572;
                          i74 = 45;
                          break label1572;
                          i74 = 113;
                          break label1572;
                          i78 = 117;
                          continue;
                          i78 = 12;
                          continue;
                          i78 = 45;
                          continue;
                          i78 = 113;
                        }
                        Object localObject22 = null;
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

  private void _sdka(HttpEntity paramHttpEntity1, HttpEntity paramHttpEntity2, long paramLong)
  {
    long l1;
    if (paramHttpEntity1 == null)
    {
      l1 = 0L;
      if (l1 <= 0L)
        break label218;
    }
    label218: for (long l2 = 0L + l1; ; l2 = 0L)
    {
      if (paramHttpEntity2 == null);
      for (long l3 = 0L; ; l3 = paramHttpEntity2.getContentLength())
      {
        if (l3 > 0L)
          l2 += l3;
        float f1 = (float)l2 * 1000.0F;
        float f2 = (float)paramLong;
        int i = Math.round(f1 / f2);
        _sdkhb local_sdkhb = _sdka;
        StringBuilder localStringBuilder1 = new StringBuilder();
        String str1 = z[3];
        StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(paramLong);
        String str2 = z[1];
        StringBuilder localStringBuilder3 = localStringBuilder2.append(str2).append(l1).append("+").append(l3).append("=").append(l2);
        String str3 = z[2];
        StringBuilder localStringBuilder4 = localStringBuilder3.append(str3).append(i);
        String str4 = z[0];
        String str5 = str4;
        local_sdkhb._sdkb(str5);
        return;
        l1 = paramHttpEntity1.getContentLength();
        break;
      }
    }
  }

  public void _sdka()
  {
    try
    {
      if (this._sdke != null)
        this._sdke.abort();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public _sdkrb _sdkb(String paramString)
    throws IOException
  {
    int i = _sdktb._sdkd;
    if (Thread.interrupted())
    {
      String str1 = z[5];
      throw new InterruptedIOException(str1);
    }
    HttpGet localHttpGet = new HttpGet(paramString);
    String str2 = z[4];
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str3 = z[6];
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str3);
    String str4 = WPS.getVersion();
    String str5 = str4 + ")";
    localHttpGet.setHeader(str2, str5);
    try
    {
      this._sdke = localHttpGet;
      _sdkec local_sdkec = _sdkec._sdkd();
      HttpResponse localHttpResponse = _sdkf.execute(localHttpGet);
      if (_sdka._sdkb())
      {
        HttpEntity localHttpEntity = localHttpResponse.getEntity();
        long l = local_sdkec._sdka();
        _sdka(null, localHttpEntity, l);
      }
      _sdksb local_sdksb = new _sdksb(localHttpResponse);
      if (_sdkhb._sdkd)
        _sdktb._sdkd = i + 1;
      return local_sdksb;
    }
    finally
    {
    }
  }

  protected _sdktb _sdkb()
  {
    return new _sdkub();
  }

  public _sdkrb _sdkc(String paramString1, String paramString2)
    throws IOException
  {
    int i = _sdktb._sdkd;
    if (Thread.interrupted())
    {
      String str1 = z[5];
      throw new InterruptedIOException(str1);
    }
    HttpPost localHttpPost = new HttpPost(paramString1);
    StringEntity localStringEntity = new StringEntity(paramString2);
    localHttpPost.setEntity(localStringEntity);
    String str2 = z[4];
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str3 = z[6];
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str3);
    String str4 = WPS.getVersion();
    String str5 = str4 + ")";
    localHttpPost.setHeader(str2, str5);
    String str6 = z[7];
    String str7 = z[8];
    localHttpPost.setHeader(str6, str7);
    while (true)
    {
      try
      {
        this._sdke = localHttpPost;
        _sdkec local_sdkec = _sdkec._sdkd();
        HttpResponse localHttpResponse = _sdkf.execute(localHttpPost);
        if (_sdka._sdkb())
        {
          HttpEntity localHttpEntity = localHttpResponse.getEntity();
          long l = local_sdkec._sdka();
          _sdka(localStringEntity, localHttpEntity, l);
        }
        _sdksb local_sdksb = new _sdksb(localHttpResponse);
        if (i != null)
        {
          if (_sdkhb._sdkd)
          {
            i = 0;
            _sdkhb._sdkd = i;
          }
        }
        else
          return local_sdksb;
      }
      finally
      {
      }
      int j = 1;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless._sdkub
 * JD-Core Version:    0.6.2
 */