package crittercism.android;

import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.math.BigInteger;

public final class j
{
  public static BigInteger a()
  {
    Object localObject = BigInteger.valueOf(65535L);
    try
    {
      String str = Environment.getDataDirectory().getPath();
      StatFs localStatFs = new StatFs(str);
      BigInteger localBigInteger1 = BigInteger.valueOf(localStatFs.getAvailableBlocks());
      BigInteger localBigInteger2 = BigInteger.valueOf(localStatFs.getBlockSize());
      BigInteger localBigInteger3 = localBigInteger1.multiply(localBigInteger2);
      localObject = localBigInteger3;
      label53: return localObject;
    }
    catch (Exception localException)
    {
      break label53;
    }
  }

  public static BigInteger b()
  {
    Object localObject = BigInteger.valueOf(65535L);
    try
    {
      String str = Environment.getDataDirectory().getPath();
      StatFs localStatFs = new StatFs(str);
      BigInteger localBigInteger1 = BigInteger.valueOf(localStatFs.getBlockCount());
      BigInteger localBigInteger2 = BigInteger.valueOf(localStatFs.getBlockSize());
      BigInteger localBigInteger3 = localBigInteger1.multiply(localBigInteger2);
      localObject = localBigInteger3;
      label53: return localObject;
    }
    catch (Exception localException)
    {
      break label53;
    }
  }

  public static BigInteger c()
  {
    Object localObject = BigInteger.valueOf(65535L);
    try
    {
      String str = Environment.getExternalStorageDirectory().getPath();
      StatFs localStatFs = new StatFs(str);
      BigInteger localBigInteger1 = BigInteger.valueOf(localStatFs.getAvailableBlocks());
      BigInteger localBigInteger2 = BigInteger.valueOf(localStatFs.getBlockSize());
      BigInteger localBigInteger3 = localBigInteger1.multiply(localBigInteger2);
      localObject = localBigInteger3;
      label53: return localObject;
    }
    catch (Exception localException)
    {
      break label53;
    }
  }

  public static BigInteger d()
  {
    Object localObject = BigInteger.valueOf(65535L);
    try
    {
      String str = Environment.getExternalStorageDirectory().getPath();
      StatFs localStatFs = new StatFs(str);
      BigInteger localBigInteger1 = BigInteger.valueOf(localStatFs.getBlockCount());
      BigInteger localBigInteger2 = BigInteger.valueOf(localStatFs.getBlockSize());
      BigInteger localBigInteger3 = localBigInteger1.multiply(localBigInteger2);
      localObject = localBigInteger3;
      label53: return localObject;
    }
    catch (Exception localException)
    {
      break label53;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     crittercism.android.j
 * JD-Core Version:    0.6.2
 */