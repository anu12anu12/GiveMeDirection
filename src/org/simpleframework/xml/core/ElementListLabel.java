package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

class ElementListLabel extends TemplateLabel
{
  private Expression cache;
  private boolean data;
  private Decorator decorator;
  private Introspector detail;
  private String entry;
  private Format format;
  private boolean inline;
  private Class item;
  private ElementList label;
  private String name;
  private String override;
  private String path;
  private boolean required;
  private Class type;

  public ElementListLabel(Contact paramContact, ElementList paramElementList, Format paramFormat)
  {
    Introspector localIntrospector = new Introspector(paramContact, this, paramFormat);
    this.detail = localIntrospector;
    Qualifier localQualifier = new Qualifier(paramContact);
    this.decorator = localQualifier;
    boolean bool1 = paramElementList.required();
    this.required = bool1;
    Class localClass1 = paramContact.getType();
    this.type = localClass1;
    String str1 = paramElementList.name();
    this.override = str1;
    boolean bool2 = paramElementList.inline();
    this.inline = bool2;
    String str2 = paramElementList.entry();
    this.entry = str2;
    boolean bool3 = paramElementList.data();
    this.data = bool3;
    Class localClass2 = paramElementList.type();
    this.item = localClass2;
    this.format = paramFormat;
    this.label = paramElementList;
  }

  private Converter getConverter(Context paramContext, String paramString)
    throws Exception
  {
    Type localType = getDependent();
    Contact localContact = getContact();
    if (!paramContext.isPrimitive(localType));
    for (Object localObject = new CompositeList(paramContext, localContact, localType, paramString); ; localObject = new PrimitiveList(paramContext, localContact, localType, paramString))
      return localObject;
  }

  private Converter getInlineConverter(Context paramContext, String paramString)
    throws Exception
  {
    Type localType = getDependent();
    Contact localContact = getContact();
    if (!paramContext.isPrimitive(localType));
    for (Object localObject = new CompositeInlineList(paramContext, localContact, localType, paramString); ; localObject = new PrimitiveInlineList(paramContext, localContact, localType, paramString))
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
    String str = getEntry();
    if (!this.label.inline());
    for (Converter localConverter = getConverter(paramContext, str); ; localConverter = getInlineConverter(paramContext, str))
      return localConverter;
  }

  public Decorator getDecorator()
    throws Exception
  {
    return this.decorator;
  }

  public Type getDependent()
    throws Exception
  {
    Contact localContact = getContact();
    Class localClass1 = this.item;
    Class localClass2 = Void.TYPE;
    if (localClass1 == localClass2)
    {
      Class localClass3 = localContact.getDependent();
      this.item = localClass3;
    }
    if (this.item == null)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localContact;
      throw new ElementException("Unable to determine generic type for %s", arrayOfObject);
    }
    Class localClass4 = this.item;
    return new ClassType(localClass4);
  }

  public Object getEmpty(Context paramContext)
    throws Exception
  {
    Class localClass = this.type;
    ClassType localClassType = new ClassType(localClass);
    CollectionFactory localCollectionFactory = new CollectionFactory(paramContext, localClassType);
    if (!this.label.empty());
    for (Object localObject = localCollectionFactory.getInstance(); ; localObject = null)
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
    return this.type;
  }

  public boolean isCollection()
  {
    return true;
  }

  public boolean isData()
  {
    return this.data;
  }

  public boolean isInline()
  {
    return this.inline;
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
 * Qualified Name:     org.simpleframework.xml.core.ElementListLabel
 * JD-Core Version:    0.6.2
 */