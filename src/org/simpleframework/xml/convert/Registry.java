package org.simpleframework.xml.convert;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

public class Registry
{
  private final RegistryBinder binder;
  private final Cache<Converter> cache;

  public Registry()
  {
    ConcurrentCache localConcurrentCache = new ConcurrentCache();
    this.cache = localConcurrentCache;
    RegistryBinder localRegistryBinder = new RegistryBinder();
    this.binder = localRegistryBinder;
  }

  private Converter create(Class paramClass)
    throws Exception
  {
    Converter localConverter = this.binder.lookup(paramClass);
    if (localConverter != null)
      this.cache.cache(paramClass, localConverter);
    return localConverter;
  }

  public Registry bind(Class paramClass1, Class paramClass2)
    throws Exception
  {
    if (paramClass1 != null)
      this.binder.bind(paramClass1, paramClass2);
    return this;
  }

  public Registry bind(Class paramClass, Converter paramConverter)
    throws Exception
  {
    if (paramClass != null)
      this.cache.cache(paramClass, paramConverter);
    return this;
  }

  public Converter lookup(Class paramClass)
    throws Exception
  {
    Converter localConverter = (Converter)this.cache.fetch(paramClass);
    if (localConverter == null)
      localConverter = create(paramClass);
    return localConverter;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.convert.Registry
 * JD-Core Version:    0.6.2
 */