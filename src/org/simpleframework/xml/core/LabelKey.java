package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;

class LabelKey
{
  private final Class label;
  private final String name;
  private final Class owner;
  private final Class type;

  public LabelKey(Contact paramContact, Annotation paramAnnotation)
  {
    Class localClass1 = paramContact.getDeclaringClass();
    this.owner = localClass1;
    Class localClass2 = paramAnnotation.annotationType();
    this.label = localClass2;
    String str = paramContact.getName();
    this.name = str;
    Class localClass3 = paramContact.getType();
    this.type = localClass3;
  }

  private boolean equals(LabelKey paramLabelKey)
  {
    boolean bool = false;
    if (paramLabelKey == this)
      bool = true;
    while (true)
    {
      return bool;
      Class localClass1 = paramLabelKey.label;
      Class localClass2 = this.label;
      if (localClass1 == localClass2)
      {
        Class localClass3 = paramLabelKey.owner;
        Class localClass4 = this.owner;
        if (localClass3 == localClass4)
        {
          Class localClass5 = paramLabelKey.type;
          Class localClass6 = this.type;
          if (localClass5 == localClass6)
          {
            String str1 = paramLabelKey.name;
            String str2 = this.name;
            bool = str1.equals(str2);
          }
        }
      }
    }
  }

  public boolean equals(Object paramObject)
  {
    LabelKey localLabelKey;
    if ((paramObject instanceof LabelKey))
      localLabelKey = (LabelKey)paramObject;
    for (boolean bool = equals(localLabelKey); ; bool = false)
      return bool;
  }

  public int hashCode()
  {
    int i = this.name.hashCode();
    int j = this.owner.hashCode();
    return i ^ j;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    String str = this.name;
    arrayOfObject[0] = str;
    Class localClass = this.owner;
    arrayOfObject[1] = localClass;
    return String.format("key '%s' for %s", arrayOfObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.LabelKey
 * JD-Core Version:    0.6.2
 */