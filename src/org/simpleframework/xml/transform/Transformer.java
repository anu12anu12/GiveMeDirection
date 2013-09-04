package org.simpleframework.xml.transform;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

public class Transformer
{
  private final Cache<Transform> cache;
  private final Cache<Object> error;
  private final Matcher matcher;

  public Transformer(Matcher paramMatcher)
  {
    ConcurrentCache localConcurrentCache1 = new ConcurrentCache();
    this.cache = localConcurrentCache1;
    ConcurrentCache localConcurrentCache2 = new ConcurrentCache();
    this.error = localConcurrentCache2;
    DefaultMatcher localDefaultMatcher = new DefaultMatcher(paramMatcher);
    this.matcher = localDefaultMatcher;
  }

  private Transform lookup(Class paramClass)
    throws Exception
  {
    Transform localTransform;
    if (!this.error.contains(paramClass))
    {
      localTransform = (Transform)this.cache.fetch(paramClass);
      if (localTransform == null);
    }
    while (true)
    {
      return localTransform;
      localTransform = match(paramClass);
      continue;
      localTransform = null;
    }
  }

  private Transform match(Class paramClass)
    throws Exception
  {
    Transform localTransform = this.matcher.match(paramClass);
    if (localTransform != null)
      this.cache.cache(paramClass, localTransform);
    while (true)
    {
      return localTransform;
      this.error.cache(paramClass, this);
    }
  }

  public Object read(String paramString, Class paramClass)
    throws Exception
  {
    Transform localTransform = lookup(paramClass);
    if (localTransform == null)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramClass;
      throw new TransformException("Transform of %s not supported", arrayOfObject);
    }
    return localTransform.read(paramString);
  }

  public boolean valid(Class paramClass)
    throws Exception
  {
    if (lookup(paramClass) != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public String write(Object paramObject, Class paramClass)
    throws Exception
  {
    Transform localTransform = lookup(paramClass);
    if (localTransform == null)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramClass;
      throw new TransformException("Transform of %s not supported", arrayOfObject);
    }
    return localTransform.write(paramObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.Transformer
 * JD-Core Version:    0.6.2
 */