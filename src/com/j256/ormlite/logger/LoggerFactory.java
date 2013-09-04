package com.j256.ormlite.logger;

import java.lang.reflect.Constructor;

public class LoggerFactory
{
  private static LogType logType;

  private static LogType findLogType()
  {
    LogType[] arrayOfLogType = LogType.values();
    int i = arrayOfLogType.length;
    int j = 0;
    LogType localLogType;
    if (j < i)
    {
      localLogType = arrayOfLogType[j];
      if (!localLogType.isAvailable());
    }
    while (true)
    {
      return localLogType;
      j += 1;
      break;
      localLogType = LogType.LOCAL;
    }
  }

  public static Logger getLogger(Class<?> paramClass)
  {
    return getLogger(paramClass.getName());
  }

  public static Logger getLogger(String paramString)
  {
    if (logType == null)
      logType = findLogType();
    Log localLog = logType.createLog(paramString);
    return new Logger(localLog);
  }

  public static String getSimpleClassName(String paramString)
  {
    String[] arrayOfString = paramString.split("\\.");
    if (arrayOfString.length <= 1);
    while (true)
    {
      return paramString;
      int i = arrayOfString.length + -1;
      paramString = arrayOfString[i];
    }
  }

  static enum LogType
  {
    private final String detectClassName;
    private final String logClassName;

    static
    {
      LOCAL = new LogType()
      {
        public Log createLog(String paramAnonymousString)
        {
          return new LocalLog(paramAnonymousString);
        }

        public boolean isAvailable()
        {
          return true;
        }
      };
      LogType[] arrayOfLogType = new LogType[4];
      LogType localLogType1 = ANDROID;
      arrayOfLogType[0] = localLogType1;
      LogType localLogType2 = COMMONS_LOGGING;
      arrayOfLogType[1] = localLogType2;
      LogType localLogType3 = LOG4J;
      arrayOfLogType[2] = localLogType3;
      LogType localLogType4 = LOCAL;
      arrayOfLogType[3] = localLogType4;
    }

    private LogType(String paramString1, String paramString2)
    {
      this.detectClassName = paramString1;
      this.logClassName = paramString2;
    }

    public Log createLog(String paramString)
    {
      return createLogFromClassName(paramString);
    }

    Log createLogFromClassName(String paramString)
    {
      try
      {
        Class localClass = Class.forName(this.logClassName);
        Class[] arrayOfClass = new Class[1];
        arrayOfClass[0] = String.class;
        Constructor localConstructor = localClass.getConstructor(arrayOfClass);
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = paramString;
        localObject = (Log)localConstructor.newInstance(arrayOfObject);
        return localObject;
      }
      catch (Exception localException)
      {
        while (true)
        {
          LocalLog localLocalLog = new LocalLog(paramString);
          Log.Level localLevel = Log.Level.WARNING;
          StringBuilder localStringBuilder = new StringBuilder().append("Unable to call constructor for class ");
          String str1 = this.logClassName;
          String str2 = str1 + ", so had to use local log";
          localLocalLog.log(localLevel, str2, localException);
          Object localObject = localLocalLog;
        }
      }
    }

    public boolean isAvailable()
    {
      return isAvailableTestClass();
    }

    boolean isAvailableTestClass()
    {
      try
      {
        Class localClass = Class.forName(this.detectClassName);
        bool = true;
        return bool;
      }
      catch (Exception localException)
      {
        while (true)
          boolean bool = false;
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.logger.LoggerFactory
 * JD-Core Version:    0.6.2
 */