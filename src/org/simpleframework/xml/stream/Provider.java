package org.simpleframework.xml.stream;

import java.io.InputStream;
import java.io.Reader;

abstract interface Provider
{
  public abstract EventReader provide(InputStream paramInputStream)
    throws Exception;

  public abstract EventReader provide(Reader paramReader)
    throws Exception;
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.Provider
 * JD-Core Version:    0.6.2
 */