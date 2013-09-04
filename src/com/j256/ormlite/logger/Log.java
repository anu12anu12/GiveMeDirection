package com.j256.ormlite.logger;

public abstract interface Log
{
  public abstract boolean isLevelEnabled(Level paramLevel);

  public abstract void log(Level paramLevel, String paramString);

  public abstract void log(Level paramLevel, String paramString, Throwable paramThrowable);

  public static enum Level
  {
    private int level;

    static
    {
      DEBUG = new Level("DEBUG", 1, 2);
      INFO = new Level("INFO", 2, 3);
      WARNING = new Level("WARNING", 3, 4);
      ERROR = new Level("ERROR", 4, 5);
      FATAL = new Level("FATAL", 5, 6);
      Level[] arrayOfLevel = new Level[6];
      Level localLevel1 = TRACE;
      arrayOfLevel[0] = localLevel1;
      Level localLevel2 = DEBUG;
      arrayOfLevel[1] = localLevel2;
      Level localLevel3 = INFO;
      arrayOfLevel[2] = localLevel3;
      Level localLevel4 = WARNING;
      arrayOfLevel[3] = localLevel4;
      Level localLevel5 = ERROR;
      arrayOfLevel[4] = localLevel5;
      Level localLevel6 = FATAL;
      arrayOfLevel[5] = localLevel6;
    }

    private Level(int paramInt)
    {
      this.level = paramInt;
    }

    public boolean isEnabled(Level paramLevel)
    {
      int i = this.level;
      int j = paramLevel.level;
      if (i <= j);
      for (boolean bool = true; ; bool = false)
        return bool;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.logger.Log
 * JD-Core Version:    0.6.2
 */