package com.nostra13.universalimageloader.cache.disc.naming;

import android.util.Log;
import com.nostra13.universalimageloader.core.ImageLoader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5FileNameGenerator
  implements FileNameGenerator
{
  private static final String HASH_ALGORITHM = "MD5";
  private static final int RADIX = 36;

  private byte[] getMD5(byte[] paramArrayOfByte)
  {
    Object localObject = null;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      byte[] arrayOfByte = localMessageDigest.digest();
      localObject = arrayOfByte;
      return localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      while (true)
      {
        String str1 = ImageLoader.TAG;
        String str2 = localNoSuchAlgorithmException.getMessage();
        int i = Log.e(str1, str2, localNoSuchAlgorithmException);
      }
    }
  }

  public String generate(String paramString)
  {
    byte[] arrayOfByte1 = paramString.getBytes();
    byte[] arrayOfByte2 = getMD5(arrayOfByte1);
    return new BigInteger(arrayOfByte2).abs().toString(36);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator
 * JD-Core Version:    0.6.2
 */