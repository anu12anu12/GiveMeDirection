package org.simpleframework.xml.core;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

class ScannerFactory
{
  private final Cache<Scanner> cache;
  private final Support support;

  public ScannerFactory(Support paramSupport)
  {
    ConcurrentCache localConcurrentCache = new ConcurrentCache();
    this.cache = localConcurrentCache;
    this.support = paramSupport;
  }

  public Scanner getInstance(Class paramClass)
    throws Exception
  {
    Object localObject = (Scanner)this.cache.fetch(paramClass);
    Detail localDetail;
    if (localObject == null)
    {
      localDetail = this.support.getDetail(paramClass);
      if (!this.support.isPrimitive(paramClass))
        break label60;
    }
    label60: Support localSupport;
    for (localObject = new PrimitiveScanner(localDetail); ; localObject = new ObjectScanner(localDetail, localSupport))
    {
      this.cache.cache(paramClass, localObject);
      return localObject;
      localSupport = this.support;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ScannerFactory
 * JD-Core Version:    0.6.2
 */