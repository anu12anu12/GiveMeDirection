package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.strategy.Type;

class CacheLabel
  implements Label
{
  private final Annotation annotation;
  private final boolean attribute;
  private final boolean collection;
  private final Contact contact;
  private final boolean data;
  private final Decorator decorator;
  private final Type depend;
  private final String entry;
  private final Expression expression;
  private final boolean inline;
  private final Object key;
  private final Label label;
  private final boolean list;
  private final String name;
  private final String[] names;
  private final String override;
  private final String path;
  private final String[] paths;
  private final boolean required;
  private final boolean text;
  private final Class type;
  private final boolean union;

  public CacheLabel(Label paramLabel)
    throws Exception
  {
    Annotation localAnnotation = paramLabel.getAnnotation();
    this.annotation = localAnnotation;
    Expression localExpression = paramLabel.getExpression();
    this.expression = localExpression;
    Decorator localDecorator = paramLabel.getDecorator();
    this.decorator = localDecorator;
    boolean bool1 = paramLabel.isAttribute();
    this.attribute = bool1;
    boolean bool2 = paramLabel.isCollection();
    this.collection = bool2;
    Contact localContact = paramLabel.getContact();
    this.contact = localContact;
    Type localType = paramLabel.getDependent();
    this.depend = localType;
    boolean bool3 = paramLabel.isRequired();
    this.required = bool3;
    String str1 = paramLabel.getOverride();
    this.override = str1;
    boolean bool4 = paramLabel.isTextList();
    this.list = bool4;
    boolean bool5 = paramLabel.isInline();
    this.inline = bool5;
    boolean bool6 = paramLabel.isUnion();
    this.union = bool6;
    String[] arrayOfString1 = paramLabel.getNames();
    this.names = arrayOfString1;
    String[] arrayOfString2 = paramLabel.getPaths();
    this.paths = arrayOfString2;
    String str2 = paramLabel.getPath();
    this.path = str2;
    Class localClass = paramLabel.getType();
    this.type = localClass;
    String str3 = paramLabel.getName();
    this.name = str3;
    String str4 = paramLabel.getEntry();
    this.entry = str4;
    boolean bool7 = paramLabel.isData();
    this.data = bool7;
    boolean bool8 = paramLabel.isText();
    this.text = bool8;
    Object localObject = paramLabel.getKey();
    this.key = localObject;
    this.label = paramLabel;
  }

  public Annotation getAnnotation()
  {
    return this.annotation;
  }

  public Contact getContact()
  {
    return this.contact;
  }

  public Converter getConverter(Context paramContext)
    throws Exception
  {
    return this.label.getConverter(paramContext);
  }

  public Decorator getDecorator()
    throws Exception
  {
    return this.decorator;
  }

  public Type getDependent()
    throws Exception
  {
    return this.depend;
  }

  public Object getEmpty(Context paramContext)
    throws Exception
  {
    return this.label.getEmpty(paramContext);
  }

  public String getEntry()
    throws Exception
  {
    return this.entry;
  }

  public Expression getExpression()
    throws Exception
  {
    return this.expression;
  }

  public Object getKey()
    throws Exception
  {
    return this.key;
  }

  public Label getLabel(Class paramClass)
    throws Exception
  {
    return this.label.getLabel(paramClass);
  }

  public String getName()
    throws Exception
  {
    return this.name;
  }

  public String[] getNames()
    throws Exception
  {
    return this.names;
  }

  public String getOverride()
  {
    return this.override;
  }

  public String getPath()
    throws Exception
  {
    return this.path;
  }

  public String[] getPaths()
    throws Exception
  {
    return this.paths;
  }

  public Class getType()
  {
    return this.type;
  }

  public Type getType(Class paramClass)
    throws Exception
  {
    return this.label.getType(paramClass);
  }

  public boolean isAttribute()
  {
    return this.attribute;
  }

  public boolean isCollection()
  {
    return this.collection;
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

  public boolean isText()
  {
    return this.text;
  }

  public boolean isTextList()
  {
    return this.list;
  }

  public boolean isUnion()
  {
    return this.union;
  }

  public String toString()
  {
    return this.label.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.CacheLabel
 * JD-Core Version:    0.6.2
 */