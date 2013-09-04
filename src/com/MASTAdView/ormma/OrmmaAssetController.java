package com.MASTAdView.ormma;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.StatFs;
import android.view.View;
import com.MASTAdView.MASTAdViewCore;
import com.MASTAdView.ormma.util.FileComparatorByDate;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

public class OrmmaAssetController extends OrmmaController
{
  private static final String ASSETS_DIRECTORY = "ormma_assets";

  public OrmmaAssetController(MASTAdViewCore paramMASTAdViewCore, Context paramContext)
  {
    super(paramMASTAdViewCore, paramContext);
  }

  private String getAlias(File paramFile)
  {
    File localFile = getAssetDir("");
    String str1 = paramFile.getAbsolutePath();
    String str2 = localFile.getAbsolutePath();
    int i = str1.indexOf(str2);
    String str3;
    int j;
    if (i >= 0)
    {
      str3 = paramFile.getAbsolutePath();
      j = localFile.getAbsolutePath().length() + i + 1;
    }
    for (String str4 = str3.substring(j); ; str4 = null)
      return str4;
  }

  private List<File> getAllFiles(File paramFile, List<File> paramList)
  {
    if (paramFile == null);
    while ((!paramFile.exists()) || (!paramFile.isDirectory()))
      return paramList;
    File[] arrayOfFile = paramFile.listFiles();
    int i = arrayOfFile.length;
    int j = 0;
    label32: File localFile;
    if (j < i)
    {
      localFile = arrayOfFile[j];
      if (!localFile.isFile())
        break label72;
      boolean bool = paramList.add(localFile);
    }
    while (true)
    {
      j += 1;
      break label32;
      break;
      label72: if (localFile.isDirectory())
        List localList = getAllFiles(localFile, paramList);
    }
  }

  private List<File> getAllFilesSortedByDate(File paramFile)
  {
    Vector localVector = new Vector();
    List localList = getAllFiles(paramFile, localVector);
    FileComparatorByDate localFileComparatorByDate = new FileComparatorByDate();
    sort(localList, localFileComparatorByDate);
    return localList;
  }

  private File getAssetDir(String paramString)
  {
    String str1 = String.valueOf(this.mContext.getFilesDir().getPath());
    StringBuilder localStringBuilder1 = new StringBuilder(str1);
    String str2 = File.separator;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str2).append("ormma_assets");
    String str3 = File.separator;
    String str4 = str3 + paramString;
    return new File(str4);
  }

  private String getAssetName(String paramString)
  {
    int i = File.separatorChar;
    int j = paramString.lastIndexOf(i);
    String str = paramString;
    if (j >= 0)
    {
      int k = j + 1;
      str = paramString.substring(k);
    }
    return str;
  }

  private String getAssetPath(String paramString)
  {
    int i = File.separatorChar;
    int j = paramString.lastIndexOf(i);
    String str = "/";
    if (j >= 0)
      str = paramString.substring(0, j);
    return str;
  }

  public static String getHttpContent(String paramString)
    throws Exception
  {
    InputStream localInputStream = getHttpEntity(paramString).getContent();
    byte[] arrayOfByte = new byte[1024];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    while (true)
    {
      int i = localInputStream.read(arrayOfByte);
      if (i <= 0)
        return localByteArrayOutputStream.toString();
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
  }

  private static HttpEntity getHttpEntity(String paramString)
  {
    try
    {
      DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
      HttpGet localHttpGet = new HttpGet(paramString);
      HttpEntity localHttpEntity1 = localDefaultHttpClient.execute(localHttpGet).getEntity();
      localHttpEntity2 = localHttpEntity1;
      return localHttpEntity2;
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        HttpEntity localHttpEntity2 = null;
      }
    }
  }

  private InputStream getScreenshot(View paramView)
  {
    try
    {
      paramView.setDrawingCacheEnabled(true);
      Bitmap localBitmap = Bitmap.createBitmap(paramView.getDrawingCache());
      paramView.setDrawingCacheEnabled(false);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.PNG;
      boolean bool = localBitmap.compress(localCompressFormat, 90, localByteArrayOutputStream);
      byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
      localByteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
      return localByteArrayInputStream;
    }
    catch (Exception localException)
    {
      while (true)
      {
        this.mOrmmaView.injectJavaScript("Ormma.fireError(\"addAsset\",\"It is impossible to make a screenshot\")");
        ByteArrayInputStream localByteArrayInputStream = null;
      }
    }
  }

  private boolean removeAssetsFolder(File paramFile)
  {
    boolean bool1 = false;
    if (paramFile == null);
    int j;
    File localFile;
    do
    {
      File[] arrayOfFile;
      while (true)
      {
        return bool1;
        if ((paramFile.exists()) && (paramFile.isDirectory()))
        {
          arrayOfFile = paramFile.listFiles();
          int i = arrayOfFile.length;
          j = 0;
          if (j < i)
            break;
          bool1 = paramFile.delete();
        }
      }
      localFile = arrayOfFile[j];
      if (!localFile.isFile())
        break;
    }
    while (!localFile.delete());
    String str1 = getAlias(localFile);
    if (str1 != null)
    {
      MASTAdViewCore localMASTAdViewCore = this.mOrmmaView;
      String str2 = "Ormma.assetRemoved('" + str1 + "' )";
      localMASTAdViewCore.injectJavaScript(str2);
    }
    while (true)
    {
      j += 1;
      break;
      if (localFile.isDirectory())
        boolean bool2 = removeAssetsFolder(localFile);
    }
  }

  private boolean retireAssets(long paramLong)
  {
    boolean bool = true;
    File localFile1 = getAssetDir("");
    if (getCacheRemaining() > paramLong)
      return bool;
    List localList = getAllFilesSortedByDate(localFile1);
    int i = 0;
    int j = localList.size();
    while (true)
    {
      if ((getCacheRemaining() >= paramLong) || (j <= 0) || (i >= j))
      {
        if (getCacheRemaining() >= paramLong)
          break;
        bool = false;
        break;
      }
      File localFile2 = (File)localList.get(0);
      if (localFile2.delete())
      {
        Object localObject = localList.remove(0);
        String str1 = getAlias(localFile2);
        if (str1 != null)
        {
          MASTAdViewCore localMASTAdViewCore = this.mOrmmaView;
          String str2 = "Ormma.assetRetired('" + str1 + "' )";
          localMASTAdViewCore.injectJavaScript(str2);
        }
      }
      i += 1;
    }
  }

  private <T> void sort(List<T> paramList, Comparator<? super T> paramComparator)
  {
    Object[] arrayOfObject = paramList.toArray();
    Arrays.sort(arrayOfObject, paramComparator);
    ListIterator localListIterator = paramList.listIterator();
    int i = 0;
    while (true)
    {
      int j = arrayOfObject.length;
      if (i >= j)
        return;
      Object localObject1 = localListIterator.next();
      Object localObject2 = arrayOfObject[i];
      localListIterator.set(localObject2);
      i += 1;
    }
  }

  // ERROR //
  public void addAsset(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 217	com/MASTAdView/ormma/OrmmaAssetController:mOrmmaView	Lcom/MASTAdView/MASTAdViewCore;
    //   4: astore_3
    //   5: new 100	java/lang/StringBuilder
    //   8: dup
    //   9: ldc_w 284
    //   12: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: aload_1
    //   16: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc_w 286
    //   22: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_2
    //   26: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: astore 4
    //   34: aload_3
    //   35: ldc_w 288
    //   38: aload 4
    //   40: invokevirtual 291	com/MASTAdView/MASTAdViewCore:ormmaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_1
    //   44: ldc_w 293
    //   47: invokevirtual 297	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   50: ifeq +77 -> 127
    //   53: aload_0
    //   54: getfield 85	com/MASTAdView/ormma/OrmmaAssetController:mContext	Landroid/content/Context;
    //   57: checkcast 299	android/app/Activity
    //   60: invokevirtual 303	android/app/Activity:getWindow	()Landroid/view/Window;
    //   63: invokevirtual 309	android/view/Window:getDecorView	()Landroid/view/View;
    //   66: astore 5
    //   68: aload_0
    //   69: aload 5
    //   71: invokespecial 311	com/MASTAdView/ormma/OrmmaAssetController:getScreenshot	(Landroid/view/View;)Ljava/io/InputStream;
    //   74: astore 6
    //   76: aload 6
    //   78: ifnonnull +4 -> 82
    //   81: return
    //   82: aload_0
    //   83: aload 6
    //   85: aload_2
    //   86: invokevirtual 315	com/MASTAdView/ormma/OrmmaAssetController:writeAssetToDisk	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   89: aload_0
    //   90: getfield 217	com/MASTAdView/ormma/OrmmaAssetController:mOrmmaView	Lcom/MASTAdView/MASTAdViewCore;
    //   93: astore 7
    //   95: new 100	java/lang/StringBuilder
    //   98: dup
    //   99: ldc_w 317
    //   102: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: aload_2
    //   106: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 235
    //   111: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: astore 8
    //   119: aload 7
    //   121: aload 8
    //   123: invokevirtual 224	com/MASTAdView/MASTAdViewCore:injectJavaScript	(Ljava/lang/String;)V
    //   126: return
    //   127: aload_1
    //   128: ldc_w 319
    //   131: invokevirtual 297	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   134: astore 9
    //   136: aload 9
    //   138: ifnull +85 -> 223
    //   141: new 31	java/lang/String
    //   144: dup
    //   145: aload_2
    //   146: invokespecial 320	java/lang/String:<init>	(Ljava/lang/String;)V
    //   149: astore 10
    //   151: new 6	com/MASTAdView/ormma/OrmmaAssetController$1
    //   154: dup
    //   155: aload_0
    //   156: aload 10
    //   158: invokespecial 323	com/MASTAdView/ormma/OrmmaAssetController$1:<init>	(Lcom/MASTAdView/ormma/OrmmaAssetController;Ljava/lang/String;)V
    //   161: astore 11
    //   163: invokestatic 329	android/hardware/Camera:open	()Landroid/hardware/Camera;
    //   166: astore 9
    //   168: aload 9
    //   170: astore 12
    //   172: aload 12
    //   174: invokevirtual 332	android/hardware/Camera:startPreview	()V
    //   177: ldc2_w 333
    //   180: lstore 13
    //   182: lload 13
    //   184: invokestatic 340	java/lang/Thread:sleep	(J)V
    //   187: aload 12
    //   189: aconst_null
    //   190: aconst_null
    //   191: aload 11
    //   193: invokevirtual 344	android/hardware/Camera:takePicture	(Landroid/hardware/Camera$ShutterCallback;Landroid/hardware/Camera$PictureCallback;Landroid/hardware/Camera$PictureCallback;)V
    //   196: return
    //   197: astore 15
    //   199: aload_0
    //   200: getfield 217	com/MASTAdView/ormma/OrmmaAssetController:mOrmmaView	Lcom/MASTAdView/MASTAdViewCore;
    //   203: ldc_w 346
    //   206: invokevirtual 224	com/MASTAdView/MASTAdViewCore:injectJavaScript	(Ljava/lang/String;)V
    //   209: return
    //   210: astore 16
    //   212: aload_0
    //   213: getfield 217	com/MASTAdView/ormma/OrmmaAssetController:mOrmmaView	Lcom/MASTAdView/MASTAdViewCore;
    //   216: ldc_w 348
    //   219: invokevirtual 224	com/MASTAdView/MASTAdViewCore:injectJavaScript	(Ljava/lang/String;)V
    //   222: return
    //   223: aload_1
    //   224: invokestatic 137	com/MASTAdView/ormma/OrmmaAssetController:getHttpEntity	(Ljava/lang/String;)Lorg/apache/http/HttpEntity;
    //   227: astore 17
    //   229: aload 17
    //   231: invokeinterface 143 1 0
    //   236: astore 18
    //   238: aload_0
    //   239: aload 18
    //   241: aload_2
    //   242: invokevirtual 315	com/MASTAdView/ormma/OrmmaAssetController:writeAssetToDisk	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   245: aload_0
    //   246: getfield 217	com/MASTAdView/ormma/OrmmaAssetController:mOrmmaView	Lcom/MASTAdView/MASTAdViewCore;
    //   249: astore 19
    //   251: new 100	java/lang/StringBuilder
    //   254: dup
    //   255: ldc_w 317
    //   258: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   261: aload_2
    //   262: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc 235
    //   267: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: astore 20
    //   275: aload 19
    //   277: aload 20
    //   279: invokevirtual 224	com/MASTAdView/MASTAdViewCore:injectJavaScript	(Ljava/lang/String;)V
    //   282: aload 17
    //   284: invokeinterface 351 1 0
    //   289: return
    //   290: astore 21
    //   292: return
    //   293: astore 22
    //   295: goto -118 -> 177
    //
    // Exception table:
    //   from	to	target	type
    //   141	168	197	java/lang/Exception
    //   182	196	197	java/lang/Exception
    //   0	136	210	java/lang/Exception
    //   199	209	210	java/lang/Exception
    //   223	282	210	java/lang/Exception
    //   282	289	290	java/lang/Exception
    //   172	177	293	java/lang/Exception
  }

  public void addAssets(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      Iterator localIterator = localJSONObject.keys();
      while (true)
      {
        if (!localIterator.hasNext())
          return;
        String str1 = (String)localIterator.next();
        String str2 = localJSONObject.getString(str1);
        addAsset(str2, str1);
      }
    }
    catch (JSONException localJSONException)
    {
      this.mOrmmaView.injectJavaScript("Ormma.fireError(\"addAssets\",\"Incorrect argument\")");
    }
  }

  public String copyTextFromJarIntoAssetDir(String paramString1, String paramString2)
  {
    try
    {
      InputStream localInputStream = OrmmaAssetController.class.getResourceAsStream(paramString2);
      File localFile1 = this.mContext.getFilesDir();
      File localFile2 = new File(localFile1, paramString1);
      String str1 = writeToDisk(localInputStream, localFile2);
      str2 = str1;
      return str2;
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        String str2 = null;
      }
    }
  }

  public FileOutputStream getAssetOutputString(String paramString)
    throws IOException
  {
    String str1 = getAssetPath(paramString);
    File localFile1 = getAssetDir(str1);
    boolean bool = localFile1.mkdirs();
    String str2 = getAssetName(paramString);
    File localFile2 = new File(localFile1, str2);
    return new FileOutputStream(localFile2);
  }

  public String getAssetURL(String paramString)
  {
    String str1 = getAssetPath(paramString);
    File localFile1 = getAssetDir(str1);
    String str2 = getAssetName(paramString);
    File localFile2 = new File(localFile1, str2);
    StringBuilder localStringBuilder = new StringBuilder("file://");
    String str3 = localFile2.getAbsolutePath();
    return str3;
  }

  public long getCacheRemaining()
  {
    String str = this.mContext.getFilesDir().getPath();
    StatFs localStatFs = new StatFs(str);
    int i = localStatFs.getAvailableBlocks();
    int j = localStatFs.getBlockSize();
    return i * j;
  }

  public void removeAllAssets()
  {
    this.mOrmmaView.ormmaEvent("removeallassets", "");
    try
    {
      File localFile = getAssetDir("");
      boolean bool = removeAssetsFolder(localFile);
      return;
    }
    catch (Exception localException)
    {
      this.mOrmmaView.injectJavaScript("Ormma.fireError(\"removeAllAssets\",\"Internal error\")");
    }
  }

  public void removeAsset(String paramString)
  {
    MASTAdViewCore localMASTAdViewCore1 = this.mOrmmaView;
    String str1 = "alias=" + paramString;
    localMASTAdViewCore1.ormmaEvent("removeasset", str1);
    String str2 = getAssetPath(paramString);
    File localFile1 = getAssetDir(str2);
    String str3 = getAssetName(paramString);
    File localFile2 = new File(localFile1, str3);
    if (localFile2.exists())
    {
      boolean bool = localFile2.delete();
      MASTAdViewCore localMASTAdViewCore2 = this.mOrmmaView;
      String str4 = "Ormma.assetRemoved('" + paramString + "' )";
      localMASTAdViewCore2.injectJavaScript(str4);
      return;
    }
    this.mOrmmaView.injectJavaScript("Ormma.fireError(\"removeAsset\",\"File not exists\")");
  }

  // ERROR //
  public void storePicture(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 137	com/MASTAdView/ormma/OrmmaAssetController:getHttpEntity	(Ljava/lang/String;)Lorg/apache/http/HttpEntity;
    //   4: astore_2
    //   5: aload_2
    //   6: invokeinterface 143 1 0
    //   11: astore_3
    //   12: new 25	java/io/File
    //   15: dup
    //   16: ldc_w 432
    //   19: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore 4
    //   24: aload 4
    //   26: invokevirtual 398	java/io/File:mkdirs	()Z
    //   29: istore 5
    //   31: aload_2
    //   32: invokeinterface 436 1 0
    //   37: astore 6
    //   39: aconst_null
    //   40: astore 7
    //   42: aload 6
    //   44: ifnull +12 -> 56
    //   47: aload 6
    //   49: invokeinterface 441 1 0
    //   54: astore 7
    //   56: aload_1
    //   57: aconst_null
    //   58: aload 7
    //   60: invokestatic 447	android/webkit/URLUtil:guessFileName	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   63: astore 8
    //   65: new 25	java/io/File
    //   68: dup
    //   69: aload 4
    //   71: aload 8
    //   73: invokespecial 385	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   76: astore 9
    //   78: aload_0
    //   79: aload_3
    //   80: aload 9
    //   82: invokevirtual 389	com/MASTAdView/ormma/OrmmaAssetController:writeToDisk	(Ljava/io/InputStream;Ljava/io/File;)Ljava/lang/String;
    //   85: astore 10
    //   87: aload_2
    //   88: invokeinterface 351 1 0
    //   93: return
    //   94: astore 11
    //   96: aload_0
    //   97: getfield 217	com/MASTAdView/ormma/OrmmaAssetController:mOrmmaView	Lcom/MASTAdView/MASTAdViewCore;
    //   100: ldc_w 449
    //   103: invokevirtual 224	com/MASTAdView/MASTAdViewCore:injectJavaScript	(Ljava/lang/String;)V
    //   106: return
    //   107: astore 12
    //   109: return
    //
    // Exception table:
    //   from	to	target	type
    //   0	87	94	java/lang/Exception
    //   87	93	107	java/lang/Exception
  }

  public void writeAssetToDisk(InputStream paramInputStream, String paramString)
    throws IllegalStateException, IOException
  {
    int i = 0;
    byte[] arrayOfByte = new byte[1024];
    FileOutputStream localFileOutputStream = getAssetOutputString(paramString);
    while (true)
    {
      int j = paramInputStream.read(arrayOfByte);
      if (j <= 0)
      {
        localFileOutputStream.flush();
        localFileOutputStream.close();
        return;
      }
      long l = j;
      if (!retireAssets(l))
      {
        this.mOrmmaView.injectJavaScript("Ormma.fireError(\"addAsset\",\"No free memory\")");
        return;
      }
      localFileOutputStream.write(arrayOfByte, 0, j);
      i += 1;
    }
  }

  public String writeToDisk(InputStream paramInputStream, File paramFile)
    throws IllegalStateException, IOException
  {
    int i = 0;
    byte[] arrayOfByte = new byte[1024];
    FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
    while (true)
    {
      int j = paramInputStream.read(arrayOfByte);
      if (j <= 0)
      {
        localFileOutputStream.flush();
        localFileOutputStream.close();
        return paramFile.getAbsolutePath();
      }
      localFileOutputStream.write(arrayOfByte, 0, j);
      i += 1;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.ormma.OrmmaAssetController
 * JD-Core Version:    0.6.2
 */