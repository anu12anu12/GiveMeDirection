package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Version;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

class VersionLabel extends TemplateLabel
{
  private Decorator decorator;
  private Introspector detail;
  private Format format;
  private Version label;
  private String name;
  private Expression path;
  private boolean required;
  private Class type;

  public VersionLabel(Contact paramContact, Version paramVersion, Format paramFormat)
  {
    Introspector localIntrospector = new Introspector(paramContact, this, paramFormat);
    this.detail = localIntrospector;
    Qualifier localQualifier = new Qualifier(paramContact);
    this.decorator = localQualifier;
    boolean bool = paramVersion.required();
    this.required = bool;
    Class localClass = paramContact.getType();
    this.type = localClass;
    String str = paramVersion.name();
    this.name = str;
    this.format = paramFormat;
    this.label = paramVersion;
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
    if (!paramContext.isFloat(localContact))
    {
      Object[] arrayOfObject = new Object[2];
      Version localVersion = this.label;
      arrayOfObject[0] = localVersion;
      arrayOfObject[1] = localContact;
      throw new AttributeException("Cannot use %s to represent %s", arrayOfObject);
    }
    return new Primitive(paramContext, localContact, str);
  }

  public Decorator getDecorator()
    throws Exception
  {
    return this.decorator;
  }

  public String getEmpty(Context paramContext)
  {
    return null;
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
 * Qualified Name:     org.simpleframework.xml.core.VersionLabel
 * JD-Core Version:    0.6.2
 */