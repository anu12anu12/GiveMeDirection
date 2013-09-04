package org.simpleframework.xml.transform;

import org.simpleframework.xml.core.PersistenceException;

public class TransformException extends PersistenceException
{
  public TransformException(String paramString, Object[] paramArrayOfObject)
  {
    super(str, arrayOfObject);
  }

  public TransformException(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    super(str, arrayOfObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.TransformException
 * JD-Core Version:    0.6.2
 */