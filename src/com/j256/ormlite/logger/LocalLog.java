package com.j256.ormlite.logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LocalLog
  implements Log
{
  private static final Log.Level DEFAULT_LEVEL = Log.Level.DEBUG;
  public static final String LOCAL_LOG_FILE_PROPERTY = "com.j256.ormlite.logger.file";
  public static final String LOCAL_LOG_LEVEL_PROPERTY = "com.j256.ormlite.logger.level";
  public static final String LOCAL_LOG_PROPERTIES_FILE = "/ormliteLocalLog.properties";
  private static final List<PatternLevel> classLevels;
  private static final ThreadLocal<DateFormat> dateFormatThreadLocal = new ThreadLocal()
  {
    protected DateFormat initialValue()
    {
      return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");
    }
  };
  private static PrintStream printStream;
  private final String className;
  private final Log.Level level;

  // ERROR //
  static
  {
    // Byte code:
    //   0: getstatic 43	com/j256/ormlite/logger/Log$Level:DEBUG	Lcom/j256/ormlite/logger/Log$Level;
    //   3: putstatic 45	com/j256/ormlite/logger/LocalLog:DEFAULT_LEVEL	Lcom/j256/ormlite/logger/Log$Level;
    //   6: new 8	com/j256/ormlite/logger/LocalLog$1
    //   9: dup
    //   10: invokespecial 48	com/j256/ormlite/logger/LocalLog$1:<init>	()V
    //   13: putstatic 50	com/j256/ormlite/logger/LocalLog:dateFormatThreadLocal	Ljava/lang/ThreadLocal;
    //   16: ldc 2
    //   18: ldc 24
    //   20: invokevirtual 56	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   23: astore_0
    //   24: aconst_null
    //   25: astore_1
    //   26: aload_0
    //   27: ifnull +14 -> 41
    //   30: aload_0
    //   31: invokestatic 60	com/j256/ormlite/logger/LocalLog:configureClassLevels	(Ljava/io/InputStream;)Ljava/util/List;
    //   34: astore_2
    //   35: aload_2
    //   36: astore_1
    //   37: aload_0
    //   38: invokevirtual 65	java/io/InputStream:close	()V
    //   41: aload_1
    //   42: putstatic 67	com/j256/ormlite/logger/LocalLog:classLevels	Ljava/util/List;
    //   45: ldc 18
    //   47: invokestatic 73	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   50: invokestatic 77	com/j256/ormlite/logger/LocalLog:openLogFile	(Ljava/lang/String;)V
    //   53: return
    //   54: astore_3
    //   55: getstatic 80	java/lang/System:err	Ljava/io/PrintStream;
    //   58: astore 4
    //   60: new 82	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   67: ldc 85
    //   69: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_3
    //   73: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: astore 5
    //   81: aload 4
    //   83: aload 5
    //   85: invokevirtual 101	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   88: aload_0
    //   89: invokevirtual 65	java/io/InputStream:close	()V
    //   92: goto -51 -> 41
    //   95: astore 6
    //   97: goto -56 -> 41
    //   100: astore 7
    //   102: aload_0
    //   103: invokevirtual 65	java/io/InputStream:close	()V
    //   106: aload 7
    //   108: athrow
    //   109: astore 8
    //   111: goto -70 -> 41
    //   114: astore 9
    //   116: goto -10 -> 106
    //
    // Exception table:
    //   from	to	target	type
    //   30	35	54	java/io/IOException
    //   88	92	95	java/io/IOException
    //   30	35	100	finally
    //   55	88	100	finally
    //   37	41	109	java/io/IOException
    //   102	106	114	java/io/IOException
  }

  public LocalLog(String paramString)
  {
    String str1 = LoggerFactory.getSimpleClassName(paramString);
    this.className = str1;
    Object localObject = null;
    if (classLevels != null)
    {
      Iterator localIterator = classLevels.iterator();
      while (localIterator.hasNext())
      {
        PatternLevel localPatternLevel = (PatternLevel)localIterator.next();
        if (localPatternLevel.pattern.matcher(paramString).matches())
          if (localObject != null)
          {
            int i = localPatternLevel.level.ordinal();
            int j = ((Log.Level)localObject).ordinal();
            if (i >= j);
          }
          else
          {
            localObject = localPatternLevel.level;
          }
      }
    }
    String str2;
    if (localObject == null)
    {
      str2 = System.getProperty("com.j256.ormlite.logger.level");
      if (str2 != null)
        break label131;
      localObject = DEFAULT_LEVEL;
    }
    while (true)
    {
      this.level = ((Log.Level)localObject);
      return;
      try
      {
        label131: Log.Level localLevel = Log.Level.valueOf(str2.toUpperCase());
        localObject = localLevel;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        String str3 = "Level '" + str2 + "' was not found";
        throw new IllegalArgumentException(str3, localIllegalArgumentException);
      }
    }
  }

  private static List<PatternLevel> configureClassLevels(InputStream paramInputStream)
    throws IOException
  {
    InputStreamReader localInputStreamReader = new InputStreamReader(paramInputStream);
    BufferedReader localBufferedReader = new BufferedReader(localInputStreamReader);
    ArrayList localArrayList = new ArrayList();
    while (true)
    {
      String str1 = localBufferedReader.readLine();
      if (str1 == null)
        return localArrayList;
      if ((str1.length() != 0) && (str1.charAt(0) != '#'))
      {
        String[] arrayOfString = str1.split("=");
        if (arrayOfString.length != 2)
        {
          PrintStream localPrintStream1 = System.err;
          String str2 = "Line is not in the format of 'pattern = level': " + str1;
          localPrintStream1.println(str2);
        }
        else
        {
          Pattern localPattern = Pattern.compile(arrayOfString[0].trim());
          int i = 1;
          try
          {
            Log.Level localLevel1 = Log.Level.valueOf(arrayOfString[i].trim());
            Log.Level localLevel2 = localLevel1;
            PatternLevel localPatternLevel = new PatternLevel(localPattern, localLevel2);
            boolean bool = localArrayList.add(localPatternLevel);
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            PrintStream localPrintStream2 = System.err;
            StringBuilder localStringBuilder = new StringBuilder().append("Level '");
            String str3 = arrayOfString[1];
            String str4 = str3 + "' was not found";
            localPrintStream2.println(str4);
          }
        }
      }
    }
  }

  public static void openLogFile(String paramString)
  {
    if (paramString == null)
    {
      printStream = System.out;
      return;
    }
    try
    {
      File localFile = new File(paramString);
      printStream = new PrintStream(localFile);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      String str = "Log file " + paramString + " was not found";
      throw new IllegalArgumentException(str, localFileNotFoundException);
    }
  }

  private void printMessage(Log.Level paramLevel, String paramString, Throwable paramThrowable)
  {
    if (!isLevelEnabled(paramLevel))
      return;
    StringBuilder localStringBuilder1 = new StringBuilder(128);
    DateFormat localDateFormat = (DateFormat)dateFormatThreadLocal.get();
    Date localDate = new Date();
    String str1 = localDateFormat.format(localDate);
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
    StringBuilder localStringBuilder3 = localStringBuilder1.append(" [");
    String str2 = paramLevel.name();
    StringBuilder localStringBuilder4 = localStringBuilder3.append(str2).append("] ");
    String str3 = this.className;
    StringBuilder localStringBuilder5 = localStringBuilder1.append(str3).append(' ');
    StringBuilder localStringBuilder6 = localStringBuilder1.append(paramString);
    PrintStream localPrintStream1 = printStream;
    String str4 = localStringBuilder1.toString();
    localPrintStream1.println(str4);
    if (paramThrowable == null)
      return;
    PrintStream localPrintStream2 = printStream;
    paramThrowable.printStackTrace(localPrintStream2);
  }

  void flush()
  {
    printStream.flush();
  }

  public boolean isLevelEnabled(Log.Level paramLevel)
  {
    return this.level.isEnabled(paramLevel);
  }

  public void log(Log.Level paramLevel, String paramString)
  {
    printMessage(paramLevel, paramString, null);
  }

  public void log(Log.Level paramLevel, String paramString, Throwable paramThrowable)
  {
    printMessage(paramLevel, paramString, paramThrowable);
  }

  private static class PatternLevel
  {
    Log.Level level;
    Pattern pattern;

    public PatternLevel(Pattern paramPattern, Log.Level paramLevel)
    {
      this.pattern = paramPattern;
      this.level = paramLevel;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.logger.LocalLog
 * JD-Core Version:    0.6.2
 */