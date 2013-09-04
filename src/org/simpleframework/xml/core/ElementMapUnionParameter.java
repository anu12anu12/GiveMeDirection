package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.stream.Format;

class ElementMapUnionParameter extends TemplateParameter
{
  private final Contact contact;
  private final Expression expression;
  private final int index;
  private final Object key;
  private final Label label;
  private final String name;
  private final String path;
  private final Class type;

  public ElementMapUnionParameter(Constructor paramConstructor, ElementMapUnion paramElementMapUnion, ElementMap paramElementMap, Format paramFormat, int paramInt)
    throws Exception
  {
    Contact localContact1 = new Contact(paramElementMap, paramConstructor, paramInt);
    this.contact = localContact1;
    Contact localContact2 = this.contact;
    ElementMapUnionLabel localElementMapUnionLabel = new ElementMapUnionLabel(localContact2, paramElementMapUnion, paramElementMap, paramFormat);
    this.label = localElementMapUnionLabel;
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

  private static class Contact extends ParameterContact<ElementMap>
  {
    public Contact(ElementMap paramElementMap, Constructor paramConstructor, int paramInt)
    {
      super(paramConstructor, paramInt);
    }

    public String getName()
    {
      return ((ElementMap)this.label).name();
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ElementMapUnionParameter
 * JD-Core Version:    0.6.2
 */