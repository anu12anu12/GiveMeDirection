package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

class ElementLabel extends TemplateLabel
{
  private Expression cache;
  private boolean data;
  private Decorator decorator;
  private Introspector detail;
  private Class expect;
  private Format format;
  private Element label;
  private String name;
  private String override;
  private String path;
  private boolean required;
  private Class type;

  public ElementLabel(Contact paramContact, Element paramElement, Format paramFormat)
  {
    Introspector localIntrospector = new Introspector(paramContact, this, paramFormat);
    this.detail = localIntrospector;
    Qualifier localQualifier = new Qualifier(paramContact);
    this.decorator = localQualifier;
    boolean bool1 = paramElement.required();
    this.required = bool1;
    Class localClass1 = paramContact.getType();
    this.type = localClass1;
    String str = paramElement.name();
    this.override = str;
    Class localClass2 = paramElement.type();
    this.expect = localClass2;
    boolean bool2 = paramElement.data();
    this.data = bool2;
    this.format = paramFormat;
    this.label = paramElement;
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
    Contact localContact = getContact();
    Object localObject;
    if (paramContext.isPrimitive(localContact))
      localObject = new Primitive(paramContext, localContact);
    while (true)
    {
      return localObject;
      Class localClass1 = this.expect;
      Class localClass2 = Void.TYPE;
      if (localClass1 == localClass2)
      {
        localObject = new Composite(paramContext, localContact);
      }
      else
      {
        Class localClass3 = this.expect;
        localObject = new Composite(paramContext, localContact, localClass3);
      }
    }
  }

  public Decorator getDecorator()
    throws Exception
  {
    return this.decorator;
  }

  public Object getEmpty(Context paramContext)
  {
    return null;
  }

  public Expression getExpression()
    throws Exception
  {
    if (this.cache == null)
    {
      Expression localExpression = this.detail.getExpression();
      this.cache = localExpression;
    }
    return this.cache;
  }

  public String getName()
    throws Exception
  {
    if (this.name == null)
    {
      Style localStyle = this.format.getStyle();
      String str1 = this.detail.getName();
      String str2 = localStyle.getElement(str1);
      this.name = str2;
    }
    return this.name;
  }

  public String getOverride()
  {
    return this.override;
  }

  public String getPath()
    throws Exception
  {
    if (this.path == null)
    {
      Expression localExpression = getExpression();
      String str1 = getName();
      String str2 = localExpression.getElement(str1);
      this.path = str2;
    }
    return this.path;
  }

  public Class getType()
  {
    Class localClass1 = this.expect;
    Class localClass2 = Void.TYPE;
    if (localClass1 == localClass2);
    for (Class localClass3 = this.type; ; localClass3 = this.expect)
      return localClass3;
  }

  public Type getType(Class paramClass)
  {
    Object localObject = getContact();
    Class localClass1 = this.expect;
    Class localClass2 = Void.TYPE;
    if (localClass1 == localClass2);
    while (true)
    {
      return localObject;
      Class localClass3 = this.expect;
      localObject = new OverrideType((Type)localObject, localClass3);
    }
  }

  public boolean isData()
  {
    return this.data;
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
 * Qualified Name:     org.simpleframework.xml.core.ElementLabel
 * JD-Core Version:    0.6.2
 */