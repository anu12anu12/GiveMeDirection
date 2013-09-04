package org.simpleframework.xml.transform;

import java.lang.reflect.Array;

class CharacterArrayTransform
  implements Transform
{
  private final Class entry;

  public CharacterArrayTransform(Class paramClass)
  {
    this.entry = paramClass;
  }

  private Object read(char[] paramArrayOfChar, int paramInt)
    throws Exception
  {
    Object localObject = Array.newInstance(this.entry, paramInt);
    int i = 0;
    while (i < paramInt)
    {
      Character localCharacter = Character.valueOf(paramArrayOfChar[i]);
      Array.set(localObject, i, localCharacter);
      i += 1;
    }
    return localObject;
  }

  private String write(Object paramObject, int paramInt)
    throws Exception
  {
    StringBuilder localStringBuilder1 = new StringBuilder(paramInt);
    int i = 0;
    while (i < paramInt)
    {
      Object localObject = Array.get(paramObject, i);
      if (localObject != null)
        StringBuilder localStringBuilder2 = localStringBuilder1.append(localObject);
      i += 1;
    }
    return localStringBuilder1.toString();
  }

  public Object read(String paramString)
    throws Exception
  {
    Object localObject = paramString.toCharArray();
    int i = localObject.length;
    Class localClass1 = this.entry;
    Class localClass2 = Character.TYPE;
    if (localClass1 == localClass2);
    while (true)
    {
      return localObject;
      localObject = read((char[])localObject, i);
    }
  }

  public String write(Object paramObject)
    throws Exception
  {
    int i = Array.getLength(paramObject);
    Class localClass1 = this.entry;
    Class localClass2 = Character.TYPE;
    char[] arrayOfChar;
    if (localClass1 == localClass2)
      arrayOfChar = (char[])paramObject;
    for (String str = new String(arrayOfChar); ; str = write(paramObject, i))
      return str;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.CharacterArrayTransform
 * JD-Core Version:    0.6.2
 */