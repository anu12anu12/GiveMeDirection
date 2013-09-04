package com.crashlytics.android;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Map;

class s
{
  private final File a;
  private final Map<String, String> b;

  public s(File paramFile)
  {
    this(paramFile, localMap);
  }

  public s(File paramFile, Map<String, String> paramMap)
  {
    this.a = paramFile;
    this.b = paramMap;
  }

  public boolean a()
  {
    StringBuilder localStringBuilder = new StringBuilder("Removing report at ");
    String str = this.a.getPath();
    D.c(str);
    return this.a.delete();
  }

  public boolean a(URL paramURL)
  {
    boolean bool1 = false;
    try
    {
      byte[] arrayOfByte = new byte[(int)this.a.length()];
      if (arrayOfByte.length == 0)
      {
        StringBuilder localStringBuilder1 = new StringBuilder("Session report ");
        File localFile1 = this.a;
        D.c(localFile1 + " has length 0, aborting upload");
      }
      while (true)
      {
        return bool1;
        File localFile2 = this.a;
        FileInputStream localFileInputStream = new FileInputStream(localFile2);
        int i = localFileInputStream.read(arrayOfByte);
        localFileInputStream.close();
        String str1 = this.a.getName();
        StringBuffer localStringBuffer1 = new StringBuffer();
        Object[] arrayOfObject1 = new Object[3];
        arrayOfObject1[0] = "uyojvw4tl243hjlkjht2luhkljsdhglkj";
        arrayOfObject1[1] = "cls[identifier]";
        int j = str1.lastIndexOf('.');
        String str2 = str1.substring(0, j);
        arrayOfObject1[2] = str2;
        String str3 = String.format("--%s\r\nContent-Disposition: form-data; name=\"%s\"\r\nContent-Type: text/plain; charset=utf-8\r\n\r\n%s\r\n", arrayOfObject1);
        StringBuffer localStringBuffer2 = localStringBuffer1.append(str3);
        Object[] arrayOfObject2 = new Object[3];
        arrayOfObject2[0] = "uyojvw4tl243hjlkjht2luhkljsdhglkj";
        arrayOfObject2[1] = "cls[file]";
        arrayOfObject2[2] = str1;
        String str4 = String.format("--%s\r\nContent-Disposition: form-data; name=\"%s\"; filename=\"%s\"\r\nContent-Type: application/octet-stream; charset=utf-8\r\n\r\n", arrayOfObject2);
        StringBuffer localStringBuffer3 = localStringBuffer1.append(str4);
        StringBuilder localStringBuilder2 = new StringBuilder("Posting report ").append(str1).append(" to ");
        String str5 = paramURL.toString();
        D.c(str5);
        Map localMap = this.b;
        boolean bool2 = D.a(localStringBuffer1, arrayOfByte, paramURL, localMap);
        bool1 = bool2;
      }
    }
    catch (Exception localException)
    {
      while (true)
        D.a("Error sending report to " + paramURL, localException);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.s
 * JD-Core Version:    0.6.2
 */