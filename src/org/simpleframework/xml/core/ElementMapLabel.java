package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

class ElementMapLabel extends TemplateLabel
{
  private Expression cache;
  private boolean data;
  private Decorator decorator;
  private Introspector detail;
  private Entry entry;
  private Format format;
  private boolean inline;
  private Class[] items;
  private ElementMap label;
  private String name;
  private String override;
  private String parent;
  private String path;
  private boolean required;
  private Class type;

  public ElementMapLabel(Contact paramContact, ElementMap paramElementMap, Format paramFormat)
  {
    Introspector localIntrospector = new Introspector(paramContact, this, paramFormat);
    this.detail = localIntrospector;
    Qualifier localQualifier = new Qualifier(paramContact);
    this.decorator = localQualifier;
    Entry localEntry = new Entry(paramContact, paramElementMap);
    this.entry = localEntry;
    boolean bool1 = paramElementMap.required();
    this.required = bool1;
    Class localClass = paramContact.getType();
    this.type = localClass;
    boolean bool2 = paramElementMap.inline();
    this.inline = bool2;
    String str = paramElementMap.name();
    this.override = str;
    boolean bool3 = paramElementMap.data();
    this.data = bool3;
    this.format = paramFormat;
    this.label = paramElementMap;
  }

  private Type getMap()
  {
    Class localClass = this.type;
    return new ClassType(localClass);
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
    Type localType = getMap();
    Entry localEntry1;
    if (!this.label.inline())
      localEntry1 = this.entry;
    Entry localEntry2;
    for (Object localObject = new CompositeMap(paramContext, localEntry1, localType); ; localObject = new CompositeInlineMap(paramContext, localEntry2, localType))
    {
      return localObject;
      localEntry2 = this.entry;
    }
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
    if (this.items == null)
    {
      Class[] arrayOfClass = localContact.getDependents();
      this.items = arrayOfClass;
    }
    if (this.items == null)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localContact;
      throw new ElementException("Unable to determine type for %s", arrayOfObject);
    }
    if (this.items.length == 0);
    Class localClass;
    for (ClassType localClassType = new ClassType(Object.class); ; localClassType = new ClassType(localClass))
    {
      return localClassType;
      localClass = this.items[0];
    }
  }

  public Object getEmpty(Context paramContext)
    throws Exception
  {
    Class localClass = this.type;
    ClassType localClassType = new ClassType(localClass);
    MapFactory localMapFactory = new MapFactory(paramContext, localClassType);
    if (!this.label.empty());
    for (Object localObject = localMapFactory.getInstance(); ; localObject = null)
      return localObject;
  }

  public String getEntry()
    throws Exception
  {
    Style localStyle = this.format.getStyle();
    Introspector localIntrospector = this.detail;
    String str1 = this.parent;
    if (localIntrospector.isEmpty(str1))
    {
      String str2 = this.detail.getEntry();
      this.parent = str2;
    }
    String str3 = this.parent;
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
      String str1 = this.entry.getEntry();
      if (!this.label.inline())
        str1 = this.detail.getName();
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
 * Qualified Name:     org.simpleframework.xml.core.ElementMapLabel
 * JD-Core Version:    0.6.2
 */