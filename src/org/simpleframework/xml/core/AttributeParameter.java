package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.stream.Format;

class AttributeParameter extends TemplateParameter
{
  private final Contact contact;
  private final Expression expression;
  private final int index;
  private final Object key;
  private final Label label;
  private final String name;
  private final String path;
  private final Class type;

  public AttributeParameter(Constructor paramConstructor, Attribute paramAttribute, Format paramFormat, int paramInt)
    throws Exception
  {
    Contact localContact1 = new Contact(paramAttribute, paramConstructor, paramInt);
    this.contact = localContact1;
    Contact localContact2 = this.contact;
    AttributeLabel localAttributeLabel = new AttributeLabel(localContact2, paramAttribute, paramFormat);
    this.label = localAttributeLabel;
    Expression localExpression = this.label.getExpression();
    this.expression = localExpression;
    String str1 = this.label.getPath();
    this.path = str1;
    Class localClass = this.label.getType();
    this.type = localClass;
    String str2 = this.label.getName();
    this.name = str2;
    Object localObject = this.label.getKey();
    this.key = localObject;
    this.index = paramInt;
  }

  public Annotation getAnnotation()
  {
    return this.contact.getAnnotation();
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
    return true;
  }

  public boolean isPrimitive()
  {
    return this.type.isPrimitive();
  }

  public boolean isRequired()
  {
    return this.label.isRequired();
  }

  public String toString()
  {
    return this.contact.toString();
  }

  private static class Contact extends ParameterContact<Attribute>
  {
    public Contact(Attribute paramAttribute, Constructor paramConstructor, int paramInt)
    {
      super(paramConstructor, paramInt);
    }

    public String getName()
    {
      return ((Attribute)this.label).name();
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.AttributeParameter
 * JD-Core Version:    0.6.2
 */