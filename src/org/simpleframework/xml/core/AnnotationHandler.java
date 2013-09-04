package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class AnnotationHandler
  implements InvocationHandler
{
  private static final String CLASS = "annotationType";
  private static final String EQUAL = "equals";
  private static final String REQUIRED = "required";
  private static final String STRING = "toString";
  private final Comparer comparer;
  private final boolean required;
  private final Class type;

  public AnnotationHandler(Class paramClass)
  {
    this(paramClass, true);
  }

  public AnnotationHandler(Class paramClass, boolean paramBoolean)
  {
    Comparer localComparer = new Comparer();
    this.comparer = localComparer;
    this.required = paramBoolean;
    this.type = paramClass;
  }

  private void attributes(StringBuilder paramStringBuilder)
  {
    Method[] arrayOfMethod = this.type.getDeclaredMethods();
    int i = 0;
    while (true)
    {
      int j = arrayOfMethod.length;
      if (i >= j)
        break;
      String str = arrayOfMethod[i].getName();
      Method localMethod = arrayOfMethod[i];
      Object localObject = value(localMethod);
      if (i > 0)
      {
        StringBuilder localStringBuilder1 = paramStringBuilder.append(',');
        StringBuilder localStringBuilder2 = paramStringBuilder.append(' ');
      }
      StringBuilder localStringBuilder3 = paramStringBuilder.append(str);
      StringBuilder localStringBuilder4 = paramStringBuilder.append('=');
      StringBuilder localStringBuilder5 = paramStringBuilder.append(localObject);
      i += 1;
    }
    StringBuilder localStringBuilder6 = paramStringBuilder.append(')');
  }

  private boolean equals(Object paramObject, Object[] paramArrayOfObject)
    throws Throwable
  {
    Annotation localAnnotation1 = (Annotation)paramObject;
    Annotation localAnnotation2 = (Annotation)paramArrayOfObject[0];
    Class localClass1 = localAnnotation1.annotationType();
    Class localClass2 = localAnnotation2.annotationType();
    if (localClass1 != localClass2)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localAnnotation1;
      arrayOfObject[1] = localAnnotation2;
      throw new PersistenceException("Annotation %s is not the same as %s", arrayOfObject);
    }
    return this.comparer.equals(localAnnotation1, localAnnotation2);
  }

  private void name(StringBuilder paramStringBuilder)
  {
    String str = this.type.getName();
    if (str == null)
      return;
    StringBuilder localStringBuilder1 = paramStringBuilder.append('@');
    StringBuilder localStringBuilder2 = paramStringBuilder.append(str);
    StringBuilder localStringBuilder3 = paramStringBuilder.append('(');
  }

  private Object value(Method paramMethod)
  {
    if (paramMethod.getName().equals("required"));
    for (Object localObject = Boolean.valueOf(this.required); ; localObject = paramMethod.getDefaultValue())
      return localObject;
  }

  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    throws Throwable
  {
    String str = paramMethod.getName();
    Object localObject;
    if (str.equals("toString"))
      localObject = toString();
    while (true)
    {
      return localObject;
      if (str.equals("equals"))
        localObject = Boolean.valueOf(equals(paramObject, paramArrayOfObject));
      else if (str.equals("annotationType"))
        localObject = this.type;
      else if (str.equals("required"))
        localObject = Boolean.valueOf(this.required);
      else
        localObject = paramMethod.getDefaultValue();
    }
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.type != null)
    {
      name(localStringBuilder);
      attributes(localStringBuilder);
    }
    return localStringBuilder.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.AnnotationHandler
 * JD-Core Version:    0.6.2
 */