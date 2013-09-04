package org.simpleframework.xml.stream;

final class ProviderFactory
{
  public static Provider getInstance()
  {
    try
    {
      localObject = new StreamProvider();
      return localObject;
    }
    catch (Throwable localThrowable1)
    {
      while (true)
        try
        {
          localObject = new PullProvider();
        }
        catch (Throwable localThrowable2)
        {
          Object localObject = new DocumentProvider();
        }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.ProviderFactory
 * JD-Core Version:    0.6.2
 */