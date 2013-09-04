package org.simpleframework.xml.convert;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

class RegistryBinder
{
  private final Cache<Class> cache;
  private final ConverterFactory factory;

  public RegistryBinder()
  {
    ConcurrentCache localConcurrentCache = new ConcurrentCache();
    this.cache = localConcurrentCache;
    ConverterFactory localConverterFactory = new ConverterFactory();
    this.factory = localConverterFactory;
  }

  private Converter create(Class paramClass)
    throws Exception
  {
    return this.factory.getInstance(paramClass);
  }

  public void bind(Class paramClass1, Class paramClass2)
    throws Exception
  {
    this.cache.cache(paramClass1, paramClass2);
  }

  public Converter lookup(Class paramClass)
    throws Exception
  {
    Class localClass = (Class)this.cache.fetch(paramClass);
    if (localClass != null);
    for (Converter localConverter = create(localClass); ; localConverter = null)
      return localConverter;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.convert.RegistryBinder
 * JD-Core Version:    0.6.2
 */