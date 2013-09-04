package org.simpleframework.xml.core;

import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.strategy.Type;

class Entry
{
  private static final String DEFAULT_NAME = "entry";
  private boolean attribute;
  private Contact contact;
  private String entry;
  private String key;
  private Class keyType;
  private ElementMap label;
  private String value;
  private Class valueType;

  public Entry(Contact paramContact, ElementMap paramElementMap)
  {
    boolean bool = paramElementMap.attribute();
    this.attribute = bool;
    String str1 = paramElementMap.entry();
    this.entry = str1;
    String str2 = paramElementMap.value();
    this.value = str2;
    String str3 = paramElementMap.key();
    this.key = str3;
    this.contact = paramContact;
    this.label = paramElementMap;
  }

  private Class getDependent(int paramInt)
    throws Exception
  {
    Class[] arrayOfClass = this.contact.getDependents();
    if (arrayOfClass.length < paramInt)
    {
      Object[] arrayOfObject = new Object[2];
      Contact localContact = this.contact;
      arrayOfObject[0] = localContact;
      Integer localInteger = Integer.valueOf(paramInt);
      arrayOfObject[1] = localInteger;
      throw new PersistenceException("Could not find type for %s at index %s", arrayOfObject);
    }
    return arrayOfClass[paramInt];
  }

  private boolean isEmpty(String paramString)
  {
    if (paramString.length() == 0);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public Contact getContact()
  {
    return this.contact;
  }

  public String getEntry()
    throws Exception
  {
    if (this.entry == null);
    for (String str1 = this.entry; ; str1 = this.entry)
    {
      return str1;
      String str2 = this.entry;
      if (isEmpty(str2))
        this.entry = "entry";
    }
  }

  public String getKey()
    throws Exception
  {
    if (this.key == null);
    for (String str1 = this.key; ; str1 = this.key)
    {
      return str1;
      String str2 = this.key;
      if (isEmpty(str2))
        this.key = null;
    }
  }

  public Converter getKey(Context paramContext)
    throws Exception
  {
    Type localType = getKeyType();
    if (paramContext.isPrimitive(localType));
    for (Object localObject = new PrimitiveKey(paramContext, this, localType); ; localObject = new CompositeKey(paramContext, this, localType))
      return localObject;
  }

  protected Type getKeyType()
    throws Exception
  {
    if (this.keyType == null)
    {
      Class localClass1 = this.label.keyType();
      this.keyType = localClass1;
      Class localClass2 = this.keyType;
      Class localClass3 = Void.TYPE;
      if (localClass2 == localClass3)
      {
        Class localClass4 = getDependent(0);
        this.keyType = localClass4;
      }
    }
    Class localClass5 = this.keyType;
    return new ClassType(localClass5);
  }

  public String getValue()
    throws Exception
  {
    if (this.value == null);
    for (String str1 = this.value; ; str1 = this.value)
    {
      return str1;
      String str2 = this.value;
      if (isEmpty(str2))
        this.value = null;
    }
  }

  public Converter getValue(Context paramContext)
    throws Exception
  {
    Type localType = getValueType();
    if (paramContext.isPrimitive(localType));
    for (Object localObject = new PrimitiveValue(paramContext, this, localType); ; localObject = new CompositeValue(paramContext, this, localType))
      return localObject;
  }

  protected Type getValueType()
    throws Exception
  {
    if (this.valueType == null)
    {
      Class localClass1 = this.label.valueType();
      this.valueType = localClass1;
      Class localClass2 = this.valueType;
      Class localClass3 = Void.TYPE;
      if (localClass2 == localClass3)
      {
        Class localClass4 = getDependent(1);
        this.valueType = localClass4;
      }
    }
    Class localClass5 = this.valueType;
    return new ClassType(localClass5);
  }

  public boolean isAttribute()
  {
    return this.attribute;
  }

  public boolean isInline()
    throws Exception
  {
    return isAttribute();
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    ElementMap localElementMap = this.label;
    arrayOfObject[0] = localElementMap;
    Contact localContact = this.contact;
    arrayOfObject[1] = localContact;
    return String.format("%s on %s", arrayOfObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Entry
 * JD-Core Version:    0.6.2
 */