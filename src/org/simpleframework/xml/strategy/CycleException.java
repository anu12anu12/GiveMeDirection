package org.simpleframework.xml.strategy;

import org.simpleframework.xml.core.PersistenceException;

public class CycleException extends PersistenceException
{
  public CycleException(String paramString, Object[] paramArrayOfObject)
  {
    super(paramString, paramArrayOfObject);
  }

  public CycleException(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    super(paramThrowable, paramString, paramArrayOfObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.CycleException
 * JD-Core Version:    0.6.2
 */