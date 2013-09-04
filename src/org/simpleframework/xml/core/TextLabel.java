package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.stream.Format;

class TextLabel extends TemplateLabel
{
  private Contact contact;
  private boolean data;
  private Introspector detail;
  private String empty;
  private Text label;
  private Expression path;
  private boolean required;
  private Class type;

  public TextLabel(Contact paramContact, Text paramText, Format paramFormat)
  {
    Introspector localIntrospector = new Introspector(paramContact, this, paramFormat);
    this.detail = localIntrospector;
    boolean bool1 = paramText.required();
    this.required = bool1;
    Class localClass = paramContact.getType();
    this.type = localClass;
    String str = paramText.empty();
    this.empty = str;
    boolean bool2 = paramText.data();
    this.data = bool2;
    this.contact = paramContact;
    this.label = paramText;
  }

  public Annotation getAnnotation()
  {
    return this.label;
  }

  public Contact getContact()
  {
    return this.contact;
  }

  public Converter getConverter(Context paramContext)
    throws Exception
  {
    String str = getEmpty(paramContext);
    Contact localContact = getContact();
    if (!paramContext.isPrimitive(localContact))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localContact;
      Text localText = this.label;
      arrayOfObject[1] = localText;
      throw new TextException("Cannot use %s to represent %s", arrayOfObject);
    }
    return new Primitive(paramContext, localContact, str);
  }

  public Decorator getDecorator()
    throws Exception
  {
    return null;
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
  {
    return "";
  }

  public String getOverride()
  {
    return this.contact.toString();
  }

  public String getPath()
    throws Exception
  {
    return getExpression().getPath();
  }

  public Class getType()
  {
    return this.type;
  }

  public boolean isData()
  {
    return this.data;
  }

  public boolean isInline()
  {
    return true;
  }

  public boolean isRequired()
  {
    return this.required;
  }

  public boolean isText()
  {
    return true;
  }

  public String toString()
  {
    return this.detail.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.TextLabel
 * JD-Core Version:    0.6.2
 */