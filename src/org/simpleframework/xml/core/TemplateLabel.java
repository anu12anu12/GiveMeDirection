package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;

abstract class TemplateLabel
  implements Label
{
  private final KeyBuilder builder;

  protected TemplateLabel()
  {
    KeyBuilder localKeyBuilder = new KeyBuilder(this);
    this.builder = localKeyBuilder;
  }

  public Type getDependent()
    throws Exception
  {
    return null;
  }

  public String getEntry()
    throws Exception
  {
    return null;
  }

  public Object getKey()
    throws Exception
  {
    return this.builder.getKey();
  }

  public Label getLabel(Class paramClass)
    throws Exception
  {
    return this;
  }

  public String[] getNames()
    throws Exception
  {
    String str1 = getPath();
    String str2 = getName();
    String[] arrayOfString = new String[2];
    arrayOfString[0] = str1;
    arrayOfString[1] = str2;
    return arrayOfString;
  }

  public String[] getPaths()
    throws Exception
  {
    String str = getPath();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = str;
    return arrayOfString;
  }

  public Type getType(Class paramClass)
    throws Exception
  {
    return getContact();
  }

  public boolean isAttribute()
  {
    return false;
  }

  public boolean isCollection()
  {
    return false;
  }

  public boolean isInline()
  {
    return false;
  }

  public boolean isText()
  {
    return false;
  }

  public boolean isTextList()
  {
    return false;
  }

  public boolean isUnion()
  {
    return false;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.TemplateLabel
 * JD-Core Version:    0.6.2
 */