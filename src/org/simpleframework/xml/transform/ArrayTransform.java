package org.simpleframework.xml.transform;

import java.lang.reflect.Array;

class ArrayTransform
  implements Transform
{
  private final Transform delegate;
  private final Class entry;
  private final StringArrayTransform split;

  public ArrayTransform(Transform paramTransform, Class paramClass)
  {
    StringArrayTransform localStringArrayTransform = new StringArrayTransform();
    this.split = localStringArrayTransform;
    this.delegate = paramTransform;
    this.entry = paramClass;
  }

  private Object read(String[] paramArrayOfString, int paramInt)
    throws Exception
  {
    Object localObject1 = Array.newInstance(this.entry, paramInt);
    int i = 0;
    while (i < paramInt)
    {
      Transform localTransform = this.delegate;
      String str = paramArrayOfString[i];
      Object localObject2 = localTransform.read(str);
      if (localObject2 != null)
        Array.set(localObject1, i, localObject2);
      i += 1;
    }
    return localObject1;
  }

  private String write(Object paramObject, int paramInt)
    throws Exception
  {
    String[] arrayOfString = new String[paramInt];
    int i = 0;
    while (i < paramInt)
    {
      Object localObject = Array.get(paramObject, i);
      if (localObject != null)
      {
        String str = this.delegate.write(localObject);
        arrayOfString[i] = str;
      }
      i += 1;
    }
    return this.split.write(arrayOfString);
  }

  public Object read(String paramString)
    throws Exception
  {
    String[] arrayOfString = this.split.read(paramString);
    int i = arrayOfString.length;
    return read(arrayOfString, i);
  }

  public String write(Object paramObject)
    throws Exception
  {
    int i = Array.getLength(paramObject);
    return write(paramObject, i);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.ArrayTransform
 * JD-Core Version:    0.6.2
 */