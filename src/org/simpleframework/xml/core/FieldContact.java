package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

class FieldContact
  implements Contact
{
  private final Cache<Annotation> cache;
  private final Field field;
  private final Annotation label;
  private final Annotation[] list;
  private final int modifier;
  private final String name;

  public FieldContact(Field paramField, Annotation paramAnnotation, Annotation[] paramArrayOfAnnotation)
  {
    ConcurrentCache localConcurrentCache = new ConcurrentCache();
    this.cache = localConcurrentCache;
    int i = paramField.getModifiers();
    this.modifier = i;
    String str = paramField.getName();
    this.name = str;
    this.label = paramAnnotation;
    this.field = paramField;
    this.list = paramArrayOfAnnotation;
  }

  private <T extends Annotation> T getCache(Class<T> paramClass)
  {
    if (this.cache.isEmpty())
    {
      Annotation[] arrayOfAnnotation = this.list;
      int i = arrayOfAnnotation.length;
      int j = 0;
      while (j < i)
      {
        Annotation localAnnotation = arrayOfAnnotation[j];
        Class localClass = localAnnotation.annotationType();
        this.cache.cache(localClass, localAnnotation);
        j += 1;
      }
    }
    return (Annotation)this.cache.fetch(paramClass);
  }

  public Object get(Object paramObject)
    throws Exception
  {
    return this.field.get(paramObject);
  }

  public Annotation getAnnotation()
  {
    return this.label;
  }

  public <T extends Annotation> T getAnnotation(Class<T> paramClass)
  {
    Class localClass = this.label.annotationType();
    if (paramClass == localClass);
    for (Annotation localAnnotation = this.label; ; localAnnotation = getCache(paramClass))
      return localAnnotation;
  }

  public Class getDeclaringClass()
  {
    return this.field.getDeclaringClass();
  }

  public Class getDependent()
  {
    return Reflector.getDependent(this.field);
  }

  public Class[] getDependents()
  {
    return Reflector.getDependents(this.field);
  }

  public String getName()
  {
    return this.name;
  }

  public Class getType()
  {
    return this.field.getType();
  }

  public boolean isFinal()
  {
    return Modifier.isFinal(this.modifier);
  }

  public boolean isReadOnly()
  {
    if ((!isStatic()) && (isFinal()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean isStatic()
  {
    return Modifier.isStatic(this.modifier);
  }

  public void set(Object paramObject1, Object paramObject2)
    throws Exception
  {
    if (isFinal())
      return;
    this.field.set(paramObject1, paramObject2);
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    String str1 = getName();
    arrayOfObject[0] = str1;
    String str2 = this.field.toString();
    arrayOfObject[1] = str2;
    return String.format("field '%s' %s", arrayOfObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.FieldContact
 * JD-Core Version:    0.6.2
 */