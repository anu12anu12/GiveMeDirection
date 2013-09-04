package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

class AttributeLabel extends TemplateLabel
{
  private Decorator decorator;
  private Introspector detail;
  private String empty;
  private Format format;
  private Attribute label;
  private String name;
  private Expression path;
  private boolean required;
  private Class type;

  public AttributeLabel(Contact paramContact, Attribute paramAttribute, Format paramFormat)
  {
    Introspector localIntrospector = new Introspector(paramContact, this, paramFormat);
    this.detail = localIntrospector;
    Qualifier localQualifier = new Qualifier(paramContact);
    this.decorator = localQualifier;
    boolean bool = paramAttribute.required();
    this.required = bool;
    Class localClass = paramContact.getType();
    this.type = localClass;
    String str1 = paramAttribute.empty();
    this.empty = str1;
    String str2 = paramAttribute.name();
    this.name = str2;
    this.format = paramFormat;
    this.label = paramAttribute;
  }

  public Annotation getAnnotation()
  {
    return this.label;
  }

  public Contact getContact()
  {
    return this.detail.getContact();
  }

  public Converter getConverter(Context paramContext)
    throws Exception
  {
    String str = getEmpty(paramContext);
    Contact localContact = getContact();
    return new Primitive(paramContext, localContact, str);
  }

  public Decorator getDecorator()
    throws Exception
  {
    return this.decorator;
  }

  public String getEmpty(Context paramContext)
  {
    Introspector localIntrospector = this.detail;
    String str1 = this.empty;
    if (localIntrospector.isEmpty(str1));
    for (String str2 = null; ; str2 = this.empty)
      return str2;
  }

  public Expression getExpression()
    throws Exception
  {
    if (this.path == null)
    {
      Expression localExpression = this.detail.getExpression();
      this.path = localExpression;
    }
    return this.path;
  }

  public String getName()
    throws Exception
  {
    Style localStyle = this.format.getStyle();
    String str = this.detail.getName();
    return localStyle.getAttribute(str);
  }

  public String getOverride()
  {
    return this.name;
  }

  public String getPath()
    throws Exception
  {
    Expression localExpression = getExpression();
    String str = getName();
    return localExpression.getAttribute(str);
  }

  public Class getType()
  {
    return this.type;
  }

  public boolean isAttribute()
  {
    return true;
  }

  public boolean isData()
  {
    return false;
  }

  public boolean isRequired()
  {
    return this.required;
  }

  public String toString()
  {
    return this.detail.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.AttributeLabel
 * JD-Core Version:    0.6.2
 */