package org.simpleframework.xml.convert;

import java.lang.reflect.Constructor;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

class ConverterFactory
{
  private final Cache<Converter> cache;

  public ConverterFactory()
  {
    ConcurrentCache localConcurrentCache = new ConcurrentCache();
    this.cache = localConcurrentCache;
  }

  private Constructor getConstructor(Class paramClass)
    throws Exception
  {
    Class[] arrayOfClass = new Class[0];
    Constructor localConstructor = paramClass.getDeclaredConstructor(arrayOfClass);
    if (!localConstructor.isAccessible())
      localConstructor.setAccessible(true);
    return localConstructor;
  }

  private Converter getConverter(Class paramClass)
    throws Exception
  {
    Constructor localConstructor = getConstructor(paramClass);
    if (localConstructor == null)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramClass;
      throw new ConvertException("No default constructor for %s", arrayOfObject);
    }
    return getConverter(paramClass, localConstructor);
  }

  private Converter getConverter(Class paramClass, Constructor paramConstructor)
    throws Exception
  {
    Object[] arrayOfObject = new Object[0];
    Converter localConverter = (Converter)paramConstructor.newInstance(arrayOfObject);
    if (localConverter != null)
      this.cache.cache(paramClass, localConverter);
    return localConverter;
  }

  public Converter getInstance(Class paramClass)
    throws Exception
  {
    Converter localConverter = (Converter)this.cache.fetch(paramClass);
    if (localConverter == null)
      localConverter = getConverter(paramClass);
    return localConverter;
  }

  public Converter getInstance(Convert paramConvert)
    throws Exception
  {
    Class localClass = paramConvert.value();
    if (localClass.isInterface())
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localClass;
      throw new ConvertException("Can not instantiate %s", arrayOfObject);
    }
    return getInstance(localClass);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.convert.ConverterFactory
 * JD-Core Version:    0.6.2
 */