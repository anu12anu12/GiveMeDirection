package org.simpleframework.xml.transform;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

public class RegistryMatcher
  implements Matcher
{
  private final Cache<Transform> transforms;
  private final Cache<Class> types;

  public RegistryMatcher()
  {
    ConcurrentCache localConcurrentCache1 = new ConcurrentCache();
    this.transforms = localConcurrentCache1;
    ConcurrentCache localConcurrentCache2 = new ConcurrentCache();
    this.types = localConcurrentCache2;
  }

  private Transform create(Class paramClass)
    throws Exception
  {
    Class localClass = (Class)this.types.fetch(paramClass);
    if (localClass != null);
    for (Transform localTransform = create(paramClass, localClass); ; localTransform = null)
      return localTransform;
  }

  private Transform create(Class paramClass1, Class paramClass2)
    throws Exception
  {
    Transform localTransform = (Transform)paramClass2.newInstance();
    if (localTransform != null)
      this.transforms.cache(paramClass1, localTransform);
    return localTransform;
  }

  public void bind(Class paramClass1, Class paramClass2)
  {
    this.types.cache(paramClass1, paramClass2);
  }

  public void bind(Class paramClass, Transform paramTransform)
  {
    this.transforms.cache(paramClass, paramTransform);
  }

  public Transform match(Class paramClass)
    throws Exception
  {
    Transform localTransform = (Transform)this.transforms.fetch(paramClass);
    if (localTransform == null)
      localTransform = create(paramClass);
    return localTransform;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.RegistryMatcher
 * JD-Core Version:    0.6.2
 */