package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

class Comparer
{
  private static final String NAME = "name";
  private final String[] ignore;

  public Comparer()
  {
    this(arrayOfString);
  }

  public Comparer(String[] paramArrayOfString)
  {
    this.ignore = paramArrayOfString;
  }

  private boolean isIgnore(Method paramMethod)
  {
    String str1 = paramMethod.getName();
    int j;
    if (this.ignore != null)
    {
      String[] arrayOfString = this.ignore;
      int i = arrayOfString.length;
      j = 0;
      if (j < i)
      {
        String str2 = arrayOfString[j];
        if (!str1.equals(str2));
      }
    }
    for (boolean bool = true; ; bool = false)
    {
      return bool;
      j += 1;
      break;
    }
  }

  public boolean equals(Annotation paramAnnotation1, Annotation paramAnnotation2)
    throws Exception
  {
    boolean bool = false;
    Class localClass1 = paramAnnotation1.annotationType();
    Class localClass2 = paramAnnotation2.annotationType();
    Method[] arrayOfMethod1 = localClass1.getDeclaredMethods();
    int j;
    if (localClass1.equals(localClass2))
    {
      Method[] arrayOfMethod2 = arrayOfMethod1;
      int i = arrayOfMethod2.length;
      j = 0;
      if (j >= i)
        break label123;
      Method localMethod = arrayOfMethod2[j];
      if (isIgnore(localMethod))
        break label114;
      Object[] arrayOfObject1 = new Object[0];
      Object localObject1 = localMethod.invoke(paramAnnotation1, arrayOfObject1);
      Object[] arrayOfObject2 = new Object[0];
      Object localObject2 = localMethod.invoke(paramAnnotation2, arrayOfObject2);
      if (localObject1.equals(localObject2))
        break label114;
    }
    while (true)
    {
      return bool;
      label114: j += 1;
      break;
      label123: bool = true;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Comparer
 * JD-Core Version:    0.6.2
 */