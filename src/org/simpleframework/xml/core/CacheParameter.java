package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;

class CacheParameter
  implements Parameter
{
  private final Annotation annotation;
  private final boolean attribute;
  private final Expression expression;
  private final int index;
  private final Object key;
  private final String name;
  private final String path;
  private final boolean primitive;
  private final boolean required;
  private final String string;
  private final boolean text;
  private final Class type;

  public CacheParameter(Parameter paramParameter, Label paramLabel)
    throws Exception
  {
    Annotation localAnnotation = paramParameter.getAnnotation();
    this.annotation = localAnnotation;
    Expression localExpression = paramParameter.getExpression();
    this.expression = localExpression;
    boolean bool1 = paramParameter.isAttribute();
    this.attribute = bool1;
    boolean bool2 = paramParameter.isPrimitive();
    this.primitive = bool2;
    boolean bool3 = paramLabel.isRequired();
    this.required = bool3;
    String str1 = paramParameter.toString();
    this.string = str1;
    boolean bool4 = paramParameter.isText();
    this.text = bool4;
    int i = paramParameter.getIndex();
    this.index = i;
    String str2 = paramParameter.getName();
    this.name = str2;
    String str3 = paramParameter.getPath();
    this.path = str3;
    Class localClass = paramParameter.getType();
    this.type = localClass;
    Object localObject = paramLabel.getKey();
    this.key = localObject;
  }

  public Annotation getAnnotation()
  {
    return this.annotation;
  }

  public Expression getExpression()
  {
    return this.expression;
  }

  public int getIndex()
  {
    return this.index;
  }

  public Object getKey()
  {
    return this.key;
  }

  public String getName()
  {
    return this.name;
  }

  public String getPath()
  {
    return this.path;
  }

  public Class getType()
  {
    return this.type;
  }

  public boolean isAttribute()
  {
    return this.attribute;
  }

  public boolean isPrimitive()
  {
    return this.primitive;
  }

  public boolean isRequired()
  {
    return this.required;
  }

  public boolean isText()
  {
    return this.text;
  }

  public String toString()
  {
    return this.string;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.CacheParameter
 * JD-Core Version:    0.6.2
 */