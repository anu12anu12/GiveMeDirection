package com.j256.ormlite.logger;

import java.util.Arrays;

public class Logger
{
  private static final String ARG_STRING = "{}";
  private static final int ARG_STRING_LENGTH = "{}".length();
  private static final Object UNKNOWN_ARG = new Object();
  private final Log log;

  public Logger(Log paramLog)
  {
    this.log = paramLog;
  }

  private void appendArg(StringBuilder paramStringBuilder, Object paramObject)
  {
    Object localObject = UNKNOWN_ARG;
    if (paramObject == localObject)
      return;
    if ((paramObject != null) && (paramObject.getClass().isArray()))
    {
      String str = Arrays.toString((Object[])paramObject);
      StringBuilder localStringBuilder1 = paramStringBuilder.append(str);
      return;
    }
    StringBuilder localStringBuilder2 = paramStringBuilder.append(paramObject);
  }

  private String buildFullMessage(String paramString, Object paramObject1, Object paramObject2, Object paramObject3, Object[] paramArrayOfObject)
  {
    StringBuilder localStringBuilder1 = new StringBuilder(128);
    int i = 0;
    int j = 0;
    int k = paramString.indexOf("{}", i);
    if (k == -1)
    {
      String str1 = paramString.substring(i);
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str1);
      return localStringBuilder1.toString();
    }
    String str2 = paramString.substring(i, k);
    StringBuilder localStringBuilder3 = localStringBuilder1.append(str2);
    int m = ARG_STRING_LENGTH;
    i = k + m;
    if (paramArrayOfObject == null)
      if (j == 0)
        appendArg(localStringBuilder1, paramObject1);
    while (true)
    {
      j += 1;
      break;
      if (j == 1)
      {
        appendArg(localStringBuilder1, paramObject2);
      }
      else if (j == 2)
      {
        appendArg(localStringBuilder1, paramObject3);
        continue;
        int n = paramArrayOfObject.length;
        if (j < n)
        {
          Object localObject = paramArrayOfObject[j];
          appendArg(localStringBuilder1, localObject);
        }
      }
    }
  }

  private void innerLog(Log.Level paramLevel, Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2, Object paramObject3, Object[] paramArrayOfObject)
  {
    if (!this.log.isLevelEnabled(paramLevel))
      return;
    Logger localLogger = this;
    String str1 = paramString;
    Object localObject1 = paramObject1;
    Object localObject2 = paramObject2;
    Object localObject3 = paramObject3;
    Object[] arrayOfObject = paramArrayOfObject;
    String str2 = localLogger.buildFullMessage(str1, localObject1, localObject2, localObject3, arrayOfObject);
    if (paramThrowable == null)
    {
      this.log.log(paramLevel, str2);
      return;
    }
    this.log.log(paramLevel, str2, paramThrowable);
  }

  public void debug(String paramString)
  {
    Log.Level localLevel = Log.Level.DEBUG;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    String str = paramString;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void debug(String paramString, Object paramObject)
  {
    Log.Level localLevel = Log.Level.DEBUG;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Logger localLogger = this;
    String str = paramString;
    Object localObject3 = paramObject;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject3, localObject1, localObject2, arrayOfObject);
  }

  public void debug(String paramString, Object paramObject1, Object paramObject2)
  {
    Log.Level localLevel = Log.Level.DEBUG;
    Object localObject1 = UNKNOWN_ARG;
    Logger localLogger = this;
    String str = paramString;
    Object localObject2 = paramObject1;
    Object localObject3 = paramObject2;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject2, localObject3, localObject1, arrayOfObject);
  }

  public void debug(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Log.Level localLevel = Log.Level.DEBUG;
    Logger localLogger = this;
    String str = paramString;
    Object localObject1 = paramObject1;
    Object localObject2 = paramObject2;
    Object localObject3 = paramObject3;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void debug(String paramString, Object[] paramArrayOfObject)
  {
    Log.Level localLevel = Log.Level.DEBUG;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    String str = paramString;
    Object[] arrayOfObject = paramArrayOfObject;
    localLogger.innerLog(localLevel, null, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void debug(Throwable paramThrowable, String paramString)
  {
    Log.Level localLevel = Log.Level.DEBUG;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    localLogger.innerLog(localLevel, localThrowable, str, localObject1, localObject2, localObject3, null);
  }

  public void debug(Throwable paramThrowable, String paramString, Object paramObject)
  {
    Log.Level localLevel = Log.Level.DEBUG;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object localObject3 = paramObject;
    localLogger.innerLog(localLevel, localThrowable, str, localObject3, localObject1, localObject2, null);
  }

  public void debug(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2)
  {
    Log.Level localLevel = Log.Level.DEBUG;
    Object localObject1 = UNKNOWN_ARG;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object localObject2 = paramObject1;
    Object localObject3 = paramObject2;
    localLogger.innerLog(localLevel, localThrowable, str, localObject2, localObject3, localObject1, null);
  }

  public void debug(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Log.Level localLevel = Log.Level.DEBUG;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object localObject1 = paramObject1;
    Object localObject2 = paramObject2;
    Object localObject3 = paramObject3;
    localLogger.innerLog(localLevel, localThrowable, str, localObject1, localObject2, localObject3, null);
  }

  public void debug(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    Log.Level localLevel = Log.Level.DEBUG;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object[] arrayOfObject = paramArrayOfObject;
    localLogger.innerLog(localLevel, localThrowable, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void error(String paramString)
  {
    Log.Level localLevel = Log.Level.ERROR;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    String str = paramString;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void error(String paramString, Object paramObject)
  {
    Log.Level localLevel = Log.Level.ERROR;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Logger localLogger = this;
    String str = paramString;
    Object localObject3 = paramObject;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject3, localObject1, localObject2, arrayOfObject);
  }

  public void error(String paramString, Object paramObject1, Object paramObject2)
  {
    Log.Level localLevel = Log.Level.ERROR;
    Object localObject1 = UNKNOWN_ARG;
    Logger localLogger = this;
    String str = paramString;
    Object localObject2 = paramObject1;
    Object localObject3 = paramObject2;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject2, localObject3, localObject1, arrayOfObject);
  }

  public void error(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Log.Level localLevel = Log.Level.ERROR;
    Logger localLogger = this;
    String str = paramString;
    Object localObject1 = paramObject1;
    Object localObject2 = paramObject2;
    Object localObject3 = paramObject3;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void error(String paramString, Object[] paramArrayOfObject)
  {
    Log.Level localLevel = Log.Level.ERROR;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    String str = paramString;
    Object[] arrayOfObject = paramArrayOfObject;
    localLogger.innerLog(localLevel, null, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void error(Throwable paramThrowable, String paramString)
  {
    Log.Level localLevel = Log.Level.ERROR;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    localLogger.innerLog(localLevel, localThrowable, str, localObject1, localObject2, localObject3, null);
  }

  public void error(Throwable paramThrowable, String paramString, Object paramObject)
  {
    Log.Level localLevel = Log.Level.ERROR;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object localObject3 = paramObject;
    localLogger.innerLog(localLevel, localThrowable, str, localObject3, localObject1, localObject2, null);
  }

  public void error(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2)
  {
    Log.Level localLevel = Log.Level.ERROR;
    Object localObject1 = UNKNOWN_ARG;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object localObject2 = paramObject1;
    Object localObject3 = paramObject2;
    localLogger.innerLog(localLevel, localThrowable, str, localObject2, localObject3, localObject1, null);
  }

  public void error(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Log.Level localLevel = Log.Level.ERROR;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object localObject1 = paramObject1;
    Object localObject2 = paramObject2;
    Object localObject3 = paramObject3;
    localLogger.innerLog(localLevel, localThrowable, str, localObject1, localObject2, localObject3, null);
  }

  public void error(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    Log.Level localLevel = Log.Level.ERROR;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object[] arrayOfObject = paramArrayOfObject;
    localLogger.innerLog(localLevel, localThrowable, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void fatal(String paramString)
  {
    Log.Level localLevel = Log.Level.FATAL;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    String str = paramString;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void fatal(String paramString, Object paramObject)
  {
    Log.Level localLevel = Log.Level.FATAL;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Logger localLogger = this;
    String str = paramString;
    Object localObject3 = paramObject;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject3, localObject1, localObject2, arrayOfObject);
  }

  public void fatal(String paramString, Object paramObject1, Object paramObject2)
  {
    Log.Level localLevel = Log.Level.FATAL;
    Object localObject1 = UNKNOWN_ARG;
    Logger localLogger = this;
    String str = paramString;
    Object localObject2 = paramObject1;
    Object localObject3 = paramObject2;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject2, localObject3, localObject1, arrayOfObject);
  }

  public void fatal(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Log.Level localLevel = Log.Level.FATAL;
    Logger localLogger = this;
    String str = paramString;
    Object localObject1 = paramObject1;
    Object localObject2 = paramObject2;
    Object localObject3 = paramObject3;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void fatal(String paramString, Object[] paramArrayOfObject)
  {
    Log.Level localLevel = Log.Level.FATAL;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    String str = paramString;
    Object[] arrayOfObject = paramArrayOfObject;
    localLogger.innerLog(localLevel, null, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void fatal(Throwable paramThrowable, String paramString)
  {
    Log.Level localLevel = Log.Level.FATAL;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    localLogger.innerLog(localLevel, localThrowable, str, localObject1, localObject2, localObject3, null);
  }

  public void fatal(Throwable paramThrowable, String paramString, Object paramObject)
  {
    Log.Level localLevel = Log.Level.FATAL;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object localObject3 = paramObject;
    localLogger.innerLog(localLevel, localThrowable, str, localObject3, localObject1, localObject2, null);
  }

  public void fatal(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2)
  {
    Log.Level localLevel = Log.Level.FATAL;
    Object localObject1 = UNKNOWN_ARG;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object localObject2 = paramObject1;
    Object localObject3 = paramObject2;
    localLogger.innerLog(localLevel, localThrowable, str, localObject2, localObject3, localObject1, null);
  }

  public void fatal(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Log.Level localLevel = Log.Level.FATAL;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object localObject1 = paramObject1;
    Object localObject2 = paramObject2;
    Object localObject3 = paramObject3;
    localLogger.innerLog(localLevel, localThrowable, str, localObject1, localObject2, localObject3, null);
  }

  public void fatal(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    Log.Level localLevel = Log.Level.FATAL;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object[] arrayOfObject = paramArrayOfObject;
    localLogger.innerLog(localLevel, localThrowable, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void info(String paramString)
  {
    Log.Level localLevel = Log.Level.INFO;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    String str = paramString;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void info(String paramString, Object paramObject)
  {
    Log.Level localLevel = Log.Level.INFO;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Logger localLogger = this;
    String str = paramString;
    Object localObject3 = paramObject;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject3, localObject1, localObject2, arrayOfObject);
  }

  public void info(String paramString, Object paramObject1, Object paramObject2)
  {
    Log.Level localLevel = Log.Level.INFO;
    Object localObject1 = UNKNOWN_ARG;
    Logger localLogger = this;
    String str = paramString;
    Object localObject2 = paramObject1;
    Object localObject3 = paramObject2;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject2, localObject3, localObject1, arrayOfObject);
  }

  public void info(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Log.Level localLevel = Log.Level.INFO;
    Logger localLogger = this;
    String str = paramString;
    Object localObject1 = paramObject1;
    Object localObject2 = paramObject2;
    Object localObject3 = paramObject3;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void info(String paramString, Object[] paramArrayOfObject)
  {
    Log.Level localLevel = Log.Level.INFO;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    String str = paramString;
    Object[] arrayOfObject = paramArrayOfObject;
    localLogger.innerLog(localLevel, null, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void info(Throwable paramThrowable, String paramString)
  {
    Log.Level localLevel = Log.Level.INFO;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    localLogger.innerLog(localLevel, localThrowable, str, localObject1, localObject2, localObject3, null);
  }

  public void info(Throwable paramThrowable, String paramString, Object paramObject)
  {
    Log.Level localLevel = Log.Level.INFO;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object localObject3 = paramObject;
    localLogger.innerLog(localLevel, localThrowable, str, localObject3, localObject1, localObject2, null);
  }

  public void info(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2)
  {
    Log.Level localLevel = Log.Level.INFO;
    Object localObject1 = UNKNOWN_ARG;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object localObject2 = paramObject1;
    Object localObject3 = paramObject2;
    localLogger.innerLog(localLevel, localThrowable, str, localObject2, localObject3, localObject1, null);
  }

  public void info(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Log.Level localLevel = Log.Level.INFO;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object localObject1 = paramObject1;
    Object localObject2 = paramObject2;
    Object localObject3 = paramObject3;
    localLogger.innerLog(localLevel, localThrowable, str, localObject1, localObject2, localObject3, null);
  }

  public void info(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    Log.Level localLevel = Log.Level.INFO;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object[] arrayOfObject = paramArrayOfObject;
    localLogger.innerLog(localLevel, localThrowable, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public boolean isLevelEnabled(Log.Level paramLevel)
  {
    return this.log.isLevelEnabled(paramLevel);
  }

  public void log(Log.Level paramLevel, String paramString)
  {
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    Log.Level localLevel = paramLevel;
    String str = paramString;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void log(Log.Level paramLevel, String paramString, Object paramObject)
  {
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Logger localLogger = this;
    Log.Level localLevel = paramLevel;
    String str = paramString;
    Object localObject3 = paramObject;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject3, localObject1, localObject2, arrayOfObject);
  }

  public void log(Log.Level paramLevel, String paramString, Object paramObject1, Object paramObject2)
  {
    Object localObject1 = UNKNOWN_ARG;
    Logger localLogger = this;
    Log.Level localLevel = paramLevel;
    String str = paramString;
    Object localObject2 = paramObject1;
    Object localObject3 = paramObject2;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject2, localObject3, localObject1, arrayOfObject);
  }

  public void log(Log.Level paramLevel, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Logger localLogger = this;
    Log.Level localLevel = paramLevel;
    String str = paramString;
    Object localObject1 = paramObject1;
    Object localObject2 = paramObject2;
    Object localObject3 = paramObject3;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void log(Log.Level paramLevel, String paramString, Object[] paramArrayOfObject)
  {
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    Log.Level localLevel = paramLevel;
    String str = paramString;
    Object[] arrayOfObject = paramArrayOfObject;
    localLogger.innerLog(localLevel, null, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void log(Log.Level paramLevel, Throwable paramThrowable, String paramString)
  {
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    Log.Level localLevel = paramLevel;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    localLogger.innerLog(localLevel, localThrowable, str, localObject1, localObject2, localObject3, null);
  }

  public void log(Log.Level paramLevel, Throwable paramThrowable, String paramString, Object paramObject)
  {
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Logger localLogger = this;
    Log.Level localLevel = paramLevel;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object localObject3 = paramObject;
    localLogger.innerLog(localLevel, localThrowable, str, localObject3, localObject1, localObject2, null);
  }

  public void log(Log.Level paramLevel, Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2)
  {
    Object localObject1 = UNKNOWN_ARG;
    Logger localLogger = this;
    Log.Level localLevel = paramLevel;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object localObject2 = paramObject1;
    Object localObject3 = paramObject2;
    localLogger.innerLog(localLevel, localThrowable, str, localObject2, localObject3, localObject1, null);
  }

  public void log(Log.Level paramLevel, Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Logger localLogger = this;
    Log.Level localLevel = paramLevel;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object localObject1 = paramObject1;
    Object localObject2 = paramObject2;
    Object localObject3 = paramObject3;
    localLogger.innerLog(localLevel, localThrowable, str, localObject1, localObject2, localObject3, null);
  }

  public void log(Log.Level paramLevel, Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    Log.Level localLevel = paramLevel;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object[] arrayOfObject = paramArrayOfObject;
    localLogger.innerLog(localLevel, localThrowable, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void trace(String paramString)
  {
    Log.Level localLevel = Log.Level.TRACE;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    String str = paramString;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void trace(String paramString, Object paramObject)
  {
    Log.Level localLevel = Log.Level.TRACE;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Logger localLogger = this;
    String str = paramString;
    Object localObject3 = paramObject;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject3, localObject1, localObject2, arrayOfObject);
  }

  public void trace(String paramString, Object paramObject1, Object paramObject2)
  {
    Log.Level localLevel = Log.Level.TRACE;
    Object localObject1 = UNKNOWN_ARG;
    Logger localLogger = this;
    String str = paramString;
    Object localObject2 = paramObject1;
    Object localObject3 = paramObject2;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject2, localObject3, localObject1, arrayOfObject);
  }

  public void trace(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Log.Level localLevel = Log.Level.TRACE;
    Logger localLogger = this;
    String str = paramString;
    Object localObject1 = paramObject1;
    Object localObject2 = paramObject2;
    Object localObject3 = paramObject3;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void trace(String paramString, Object[] paramArrayOfObject)
  {
    Log.Level localLevel = Log.Level.TRACE;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    String str = paramString;
    Object[] arrayOfObject = paramArrayOfObject;
    localLogger.innerLog(localLevel, null, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void trace(Throwable paramThrowable, String paramString)
  {
    Log.Level localLevel = Log.Level.TRACE;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    localLogger.innerLog(localLevel, localThrowable, str, localObject1, localObject2, localObject3, null);
  }

  public void trace(Throwable paramThrowable, String paramString, Object paramObject)
  {
    Log.Level localLevel = Log.Level.TRACE;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object localObject3 = paramObject;
    localLogger.innerLog(localLevel, localThrowable, str, localObject3, localObject1, localObject2, null);
  }

  public void trace(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2)
  {
    Log.Level localLevel = Log.Level.TRACE;
    Object localObject1 = UNKNOWN_ARG;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object localObject2 = paramObject1;
    Object localObject3 = paramObject2;
    localLogger.innerLog(localLevel, localThrowable, str, localObject2, localObject3, localObject1, null);
  }

  public void trace(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Log.Level localLevel = Log.Level.TRACE;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object localObject1 = paramObject1;
    Object localObject2 = paramObject2;
    Object localObject3 = paramObject3;
    localLogger.innerLog(localLevel, localThrowable, str, localObject1, localObject2, localObject3, null);
  }

  public void trace(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    Log.Level localLevel = Log.Level.TRACE;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object[] arrayOfObject = paramArrayOfObject;
    localLogger.innerLog(localLevel, localThrowable, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void warn(String paramString)
  {
    Log.Level localLevel = Log.Level.WARNING;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    String str = paramString;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void warn(String paramString, Object paramObject)
  {
    Log.Level localLevel = Log.Level.WARNING;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Logger localLogger = this;
    String str = paramString;
    Object localObject3 = paramObject;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject3, localObject1, localObject2, arrayOfObject);
  }

  public void warn(String paramString, Object paramObject1, Object paramObject2)
  {
    Log.Level localLevel = Log.Level.WARNING;
    Object localObject1 = UNKNOWN_ARG;
    Logger localLogger = this;
    String str = paramString;
    Object localObject2 = paramObject1;
    Object localObject3 = paramObject2;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject2, localObject3, localObject1, arrayOfObject);
  }

  public void warn(String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Log.Level localLevel = Log.Level.WARNING;
    Logger localLogger = this;
    String str = paramString;
    Object localObject1 = paramObject1;
    Object localObject2 = paramObject2;
    Object localObject3 = paramObject3;
    Object[] arrayOfObject = null;
    localLogger.innerLog(localLevel, null, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void warn(String paramString, Object[] paramArrayOfObject)
  {
    Log.Level localLevel = Log.Level.WARNING;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    String str = paramString;
    Object[] arrayOfObject = paramArrayOfObject;
    localLogger.innerLog(localLevel, null, str, localObject1, localObject2, localObject3, arrayOfObject);
  }

  public void warn(Throwable paramThrowable, String paramString)
  {
    Log.Level localLevel = Log.Level.WARNING;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    localLogger.innerLog(localLevel, localThrowable, str, localObject1, localObject2, localObject3, null);
  }

  public void warn(Throwable paramThrowable, String paramString, Object paramObject)
  {
    Log.Level localLevel = Log.Level.WARNING;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object localObject3 = paramObject;
    localLogger.innerLog(localLevel, localThrowable, str, localObject3, localObject1, localObject2, null);
  }

  public void warn(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2)
  {
    Log.Level localLevel = Log.Level.WARNING;
    Object localObject1 = UNKNOWN_ARG;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object localObject2 = paramObject1;
    Object localObject3 = paramObject2;
    localLogger.innerLog(localLevel, localThrowable, str, localObject2, localObject3, localObject1, null);
  }

  public void warn(Throwable paramThrowable, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Log.Level localLevel = Log.Level.WARNING;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object localObject1 = paramObject1;
    Object localObject2 = paramObject2;
    Object localObject3 = paramObject3;
    localLogger.innerLog(localLevel, localThrowable, str, localObject1, localObject2, localObject3, null);
  }

  public void warn(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    Log.Level localLevel = Log.Level.WARNING;
    Object localObject1 = UNKNOWN_ARG;
    Object localObject2 = UNKNOWN_ARG;
    Object localObject3 = UNKNOWN_ARG;
    Logger localLogger = this;
    Throwable localThrowable = paramThrowable;
    String str = paramString;
    Object[] arrayOfObject = paramArrayOfObject;
    localLogger.innerLog(localLevel, localThrowable, str, localObject1, localObject2, localObject3, arrayOfObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.logger.Logger
 * JD-Core Version:    0.6.2
 */