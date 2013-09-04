package org.simpleframework.xml.core;

import java.util.Arrays;

class KeyBuilder
{
  private final Label label;

  public KeyBuilder(Label paramLabel)
  {
    this.label = paramLabel;
  }

  private Object getKey(KeyType paramKeyType)
    throws Exception
  {
    String[] arrayOfString = this.label.getPaths();
    Object localObject = getKey(arrayOfString);
    if (paramKeyType == null);
    while (true)
    {
      return localObject;
      localObject = new Key(paramKeyType, (String)localObject);
    }
  }

  private String getKey(String[] paramArrayOfString)
    throws Exception
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (paramArrayOfString.length > 0)
    {
      Arrays.sort(paramArrayOfString);
      String[] arrayOfString = paramArrayOfString;
      int i = arrayOfString.length;
      int j = 0;
      while (j < i)
      {
        String str = arrayOfString[j];
        StringBuilder localStringBuilder2 = localStringBuilder1.append(str);
        StringBuilder localStringBuilder3 = localStringBuilder1.append('>');
        j += 1;
      }
    }
    return localStringBuilder1.toString();
  }

  public Object getKey()
    throws Exception
  {
    KeyType localKeyType1;
    if (this.label.isAttribute())
      localKeyType1 = KeyType.ATTRIBUTE;
    KeyType localKeyType2;
    for (Object localObject = getKey(localKeyType1); ; localObject = getKey(localKeyType2))
    {
      return localObject;
      localKeyType2 = KeyType.ELEMENT;
    }
  }

  private static class Key
  {
    private final KeyBuilder.KeyType type;
    private final String value;

    public Key(KeyBuilder.KeyType paramKeyType, String paramString)
      throws Exception
    {
      this.value = paramString;
      this.type = paramKeyType;
    }

    public boolean equals(Object paramObject)
    {
      Key localKey;
      if ((paramObject instanceof Key))
        localKey = (Key)paramObject;
      for (boolean bool = equals(localKey); ; bool = false)
        return bool;
    }

    public boolean equals(Key paramKey)
    {
      KeyBuilder.KeyType localKeyType1 = this.type;
      KeyBuilder.KeyType localKeyType2 = paramKey.type;
      String str1;
      String str2;
      if (localKeyType1 == localKeyType2)
      {
        str1 = paramKey.value;
        str2 = this.value;
      }
      for (boolean bool = str1.equals(str2); ; bool = false)
        return bool;
    }

    public int hashCode()
    {
      return this.value.hashCode();
    }

    public String toString()
    {
      return this.value;
    }
  }

  private static enum KeyType
  {
    static
    {
      ATTRIBUTE = new KeyType("ATTRIBUTE", 1);
      ELEMENT = new KeyType("ELEMENT", 2);
      KeyType[] arrayOfKeyType = new KeyType[3];
      KeyType localKeyType1 = TEXT;
      arrayOfKeyType[0] = localKeyType1;
      KeyType localKeyType2 = ATTRIBUTE;
      arrayOfKeyType[1] = localKeyType2;
      KeyType localKeyType3 = ELEMENT;
      arrayOfKeyType[2] = localKeyType3;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.KeyBuilder
 * JD-Core Version:    0.6.2
 */