package org.simpleframework.xml.strategy;

class Loader
{
  private static ClassLoader getCallerClassLoader()
    throws Exception
  {
    return Loader.class.getClassLoader();
  }

  private static ClassLoader getClassLoader()
    throws Exception
  {
    return Thread.currentThread().getContextClassLoader();
  }

  public Class load(String paramString)
    throws Exception
  {
    ClassLoader localClassLoader = getClassLoader();
    if (localClassLoader == null)
      localClassLoader = getCallerClassLoader();
    return localClassLoader.loadClass(paramString);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.Loader
 * JD-Core Version:    0.6.2
 */