package org.simpleframework.xml.convert;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.util.ConcurrentCache;

class ScannerBuilder extends ConcurrentCache<Scanner>
{
  public Scanner build(Class<?> paramClass)
  {
    Object localObject1 = (Scanner)get(paramClass);
    if (localObject1 == null)
    {
      localObject1 = new Entry(paramClass);
      Object localObject2 = put(paramClass, localObject1);
    }
    return localObject1;
  }

  private static class Entry extends ConcurrentCache<Annotation>
    implements Scanner
  {
    private final Class root;

    public Entry(Class paramClass)
    {
      this.root = paramClass;
    }

    private <T extends Annotation> T find(Class<T> paramClass)
    {
      Class localClass = this.root;
      Annotation localAnnotation;
      if (localClass != null)
      {
        localAnnotation = localClass.getAnnotation(paramClass);
        if (localAnnotation == null);
      }
      while (true)
      {
        return localAnnotation;
        localClass = localClass.getSuperclass();
        break;
        localAnnotation = null;
      }
    }

    public <T extends Annotation> T scan(Class<T> paramClass)
    {
      if (!contains(paramClass))
      {
        Annotation localAnnotation = find(paramClass);
        if ((paramClass != null) && (localAnnotation != null))
          Object localObject = put(paramClass, localAnnotation);
      }
      return (Annotation)get(paramClass);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.convert.ScannerBuilder
 * JD-Core Version:    0.6.2
 */