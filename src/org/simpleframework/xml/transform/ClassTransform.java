package org.simpleframework.xml.transform;

class ClassTransform
  implements Transform<Class>
{
  private ClassLoader getCallerClassLoader()
  {
    return getClass().getClassLoader();
  }

  private static ClassLoader getClassLoader()
  {
    return Thread.currentThread().getContextClassLoader();
  }

  public Class read(String paramString)
    throws Exception
  {
    ClassLoader localClassLoader = getClassLoader();
    if (localClassLoader == null)
      localClassLoader = getCallerClassLoader();
    return localClassLoader.loadClass(paramString);
  }

  public String write(Class paramClass)
    throws Exception
  {
    return paramClass.getName();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.ClassTransform
 * JD-Core Version:    0.6.2
 */