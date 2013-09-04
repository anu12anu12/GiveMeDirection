package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

class ElementArrayLabel extends TemplateLabel
{
  private boolean data;
  private Decorator decorator;
  private Introspector detail;
  private String entry;
  private Format format;
  private ElementArray label;
  private String name;
  private Expression path;
  private boolean required;
  private Class type;

  public ElementArrayLabel(Contact paramContact, ElementArray paramElementArray, Format paramFormat)
  {
    Introspector localIntrospector = new Introspector(paramContact, this, paramFormat);
    this.detail = localIntrospector;
    Qualifier localQualifier = new Qualifier(paramContact);
    this.decorator = localQualifier;
    boolean bool1 = paramElementArray.required();
    this.required = bool1;
    Class localClass = paramContact.getType();
    this.type = localClass;
    String str1 = paramElementArray.entry();
    this.entry = str1;
    boolean bool2 = paramElementArray.data();
    this.data = bool2;
    String str2 = paramElementArray.name();
    this.name = str2;
    this.format = paramFormat;
    this.label = paramElementArray;
  }

  private Converter getConverter(Context paramContext, String paramString)
    throws Exception
  {
    Type localType = getDependent();
    Contact localContact = getContact();
    if (!paramContext.isPrimitive(localType));
    for (Object localObject = new CompositeArray(paramContext, localContact, localType, paramString); ; localObject = new PrimitiveArray(paramContext, localContact, localType, paramString))
      return localObject;
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
    String str = getEntry();
    if (!this.type.isArray())
    {
      Object[] arrayOfObject = new Object[2];
      Class localClass = this.type;
      arrayOfObject[0] = localClass;
      arrayOfObject[1] = localContact;
      throw new InstantiationException("Type is not an array %s for %s", arrayOfObject);
    }
    return getConverter(paramContext, str);
  }

  public Decorator getDecorator()
    throws Exception
  {
    return this.decorator;
  }

  public Type getDependent()
  {
    Class localClass1 = this.type.getComponentType();
    Class localClass2;
    if (localClass1 == null)
      localClass2 = this.type;
    for (ClassType localClassType = new ClassType(localClass2); ; localClassType = new ClassType(localClass1))
      return localClassType;
  }

  public Object getEmpty(Context paramContext)
    throws Exception
  {
    Class localClass = this.type;
    ClassType localClassType = new ClassType(localClass);
    ArrayFactory localArrayFactory = new ArrayFactory(paramContext, localClassType);
    if (!this.label.empty());
    for (Object localObject = localArrayFactory.getInstance(); ; localObject = null)
      return localObject;
  }

  public String getEntry()
    throws Exception
  {
    Style localStyle = this.format.getStyle();
    Introspector localIntrospector = this.detail;
    String str1 = this.entry;
    if (localIntrospector.isEmpty(str1))
    {
      String str2 = this.detail.getEntry();
      this.entry = str2;
    }
    String str3 = this.entry;
    return localStyle.getElement(str3);
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
    return localStyle.getElement(str);
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
    return localExpression.getElement(str);
  }

  public Class getType()
  {
    return this.type;
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
 * Qualified Name:     org.simpleframework.xml.core.ElementArrayLabel
 * JD-Core Version:    0.6.2
 */