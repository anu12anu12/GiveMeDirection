package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.Format;

class ElementUnionLabel extends TemplateLabel
{
  private Contact contact;
  private GroupExtractor extractor;
  private Label label;
  private Expression path;
  private ElementUnion union;

  public ElementUnionLabel(Contact paramContact, ElementUnion paramElementUnion, Element paramElement, Format paramFormat)
    throws Exception
  {
    GroupExtractor localGroupExtractor = new GroupExtractor(paramContact, paramElementUnion, paramFormat);
    this.extractor = localGroupExtractor;
    ElementLabel localElementLabel = new ElementLabel(paramContact, paramElement, paramFormat);
    this.label = localElementLabel;
    this.contact = paramContact;
    this.union = paramElementUnion;
  }

  public Annotation getAnnotation()
  {
    return this.label.getAnnotation();
  }

  public Contact getContact()
  {
    return this.contact;
  }

  public Converter getConverter(Context paramContext)
    throws Exception
  {
    Expression localExpression = getExpression();
    Contact localContact = getContact();
    if (localContact == null)
    {
      Object[] arrayOfObject = new Object[1];
      Label localLabel = this.label;
      arrayOfObject[0] = localLabel;
      throw new UnionException("Union %s was not declared on a field or method", arrayOfObject);
    }
    GroupExtractor localGroupExtractor = this.extractor;
    return new CompositeUnion(paramContext, localGroupExtractor, localExpression, localContact);
  }

  public Decorator getDecorator()
    throws Exception
  {
    return this.label.getDecorator();
  }

  public Type getDependent()
    throws Exception
  {
    return this.label.getDependent();
  }

  public Object getEmpty(Context paramContext)
    throws Exception
  {
    return this.label.getEmpty(paramContext);
  }

  public String getEntry()
    throws Exception
  {
    return this.label.getEntry();
  }

  public Expression getExpression()
    throws Exception
  {
    if (this.path == null)
    {
      Expression localExpression = this.label.getExpression();
      this.path = localExpression;
    }
    return this.path;
  }

  public Label getLabel(Class paramClass)
    throws Exception
  {
    Contact localContact = getContact();
    if (!this.extractor.isValid(paramClass))
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = paramClass;
      ElementUnion localElementUnion = this.union;
      arrayOfObject[1] = localElementUnion;
      arrayOfObject[2] = localContact;
      throw new UnionException("No type matches %s in %s for %s", arrayOfObject);
    }
    return this.extractor.getLabel(paramClass);
  }

  public String getName()
    throws Exception
  {
    return this.label.getName();
  }

  public String[] getNames()
    throws Exception
  {
    return this.extractor.getNames();
  }

  public String getOverride()
  {
    return this.label.getOverride();
  }

  public String getPath()
    throws Exception
  {
    return this.label.getPath();
  }

  public String[] getPaths()
    throws Exception
  {
    return this.extractor.getPaths();
  }

  public Class getType()
  {
    return this.label.getType();
  }

  public Type getType(Class paramClass)
    throws Exception
  {
    Object localObject = getContact();
    if (!this.extractor.isValid(paramClass))
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = paramClass;
      ElementUnion localElementUnion = this.union;
      arrayOfObject[1] = localElementUnion;
      arrayOfObject[2] = localObject;
      throw new UnionException("No type matches %s in %s for %s", arrayOfObject);
    }
    if (this.extractor.isDeclared(paramClass))
      localObject = new OverrideType((Type)localObject, paramClass);
    return localObject;
  }

  public boolean isCollection()
  {
    return this.label.isCollection();
  }

  public boolean isData()
  {
    return this.label.isData();
  }

  public boolean isInline()
  {
    return this.label.isInline();
  }

  public boolean isRequired()
  {
    return this.label.isRequired();
  }

  public boolean isUnion()
  {
    return true;
  }

  public String toString()
  {
    return this.label.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ElementUnionLabel
 * JD-Core Version:    0.6.2
 */