package org.simpleframework.xml.stream;

import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;

public final class NodeBuilder
{
  private static Provider PROVIDER = ProviderFactory.getInstance();

  public static InputNode read(InputStream paramInputStream)
    throws Exception
  {
    return read(PROVIDER.provide(paramInputStream));
  }

  public static InputNode read(Reader paramReader)
    throws Exception
  {
    return read(PROVIDER.provide(paramReader));
  }

  private static InputNode read(EventReader paramEventReader)
    throws Exception
  {
    return new NodeReader(paramEventReader).readRoot();
  }

  public static OutputNode write(Writer paramWriter)
    throws Exception
  {
    Format localFormat = new Format();
    return write(paramWriter, localFormat);
  }

  public static OutputNode write(Writer paramWriter, Format paramFormat)
    throws Exception
  {
    return new NodeWriter(paramWriter, paramFormat).writeRoot();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.NodeBuilder
 * JD-Core Version:    0.6.2
 */