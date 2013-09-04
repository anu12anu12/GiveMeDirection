package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.stream.Format;

class ExtractorFactory
{
  private final Contact contact;
  private final Format format;
  private final Annotation label;

  public ExtractorFactory(Contact paramContact, Annotation paramAnnotation, Format paramFormat)
  {
    this.contact = paramContact;
    this.format = paramFormat;
    this.label = paramAnnotation;
  }

  private ExtractorBuilder getBuilder(Annotation paramAnnotation)
    throws Exception
  {
    ExtractorBuilder localExtractorBuilder;
    if ((paramAnnotation instanceof ElementUnion))
      localExtractorBuilder = new ExtractorBuilder(ElementUnion.class, ElementExtractor.class);
    while (true)
    {
      return localExtractorBuilder;
      if ((paramAnnotation instanceof ElementListUnion))
      {
        localExtractorBuilder = new ExtractorBuilder(ElementListUnion.class, ElementListExtractor.class);
      }
      else
      {
        if (!(paramAnnotation instanceof ElementMapUnion))
          break;
        localExtractorBuilder = new ExtractorBuilder(ElementMapUnion.class, ElementMapExtractor.class);
      }
    }
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramAnnotation;
    throw new PersistenceException("Annotation %s is not a union", arrayOfObject);
  }

  private Object getInstance(Annotation paramAnnotation)
    throws Exception
  {
    Constructor localConstructor = getBuilder(paramAnnotation).getConstructor();
    if (!localConstructor.isAccessible())
      localConstructor.setAccessible(true);
    Object[] arrayOfObject = new Object[3];
    Contact localContact = this.contact;
    arrayOfObject[0] = localContact;
    arrayOfObject[1] = paramAnnotation;
    Format localFormat = this.format;
    arrayOfObject[2] = localFormat;
    return localConstructor.newInstance(arrayOfObject);
  }

  public Extractor getInstance()
    throws Exception
  {
    Annotation localAnnotation = this.label;
    return (Extractor)getInstance(localAnnotation);
  }

  private static class ElementMapExtractor
    implements Extractor<ElementMap>
  {
    private final Contact contact;
    private final Format format;
    private final ElementMapUnion union;

    public ElementMapExtractor(Contact paramContact, ElementMapUnion paramElementMapUnion, Format paramFormat)
      throws Exception
    {
      this.contact = paramContact;
      this.format = paramFormat;
      this.union = paramElementMapUnion;
    }

    public ElementMap[] getAnnotations()
    {
      return this.union.value();
    }

    public Label getLabel(ElementMap paramElementMap)
    {
      Contact localContact = this.contact;
      Format localFormat = this.format;
      return new ElementMapLabel(localContact, paramElementMap, localFormat);
    }

    public Class getType(ElementMap paramElementMap)
    {
      return paramElementMap.valueType();
    }
  }

  private static class ElementListExtractor
    implements Extractor<ElementList>
  {
    private final Contact contact;
    private final Format format;
    private final ElementListUnion union;

    public ElementListExtractor(Contact paramContact, ElementListUnion paramElementListUnion, Format paramFormat)
      throws Exception
    {
      this.contact = paramContact;
      this.format = paramFormat;
      this.union = paramElementListUnion;
    }

    public ElementList[] getAnnotations()
    {
      return this.union.value();
    }

    public Label getLabel(ElementList paramElementList)
    {
      Contact localContact = this.contact;
      Format localFormat = this.format;
      return new ElementListLabel(localContact, paramElementList, localFormat);
    }

    public Class getType(ElementList paramElementList)
    {
      return paramElementList.type();
    }
  }

  private static class ElementExtractor
    implements Extractor<Element>
  {
    private final Contact contact;
    private final Format format;
    private final ElementUnion union;

    public ElementExtractor(Contact paramContact, ElementUnion paramElementUnion, Format paramFormat)
      throws Exception
    {
      this.contact = paramContact;
      this.format = paramFormat;
      this.union = paramElementUnion;
    }

    public Element[] getAnnotations()
    {
      return this.union.value();
    }

    public Label getLabel(Element paramElement)
    {
      Contact localContact = this.contact;
      Format localFormat = this.format;
      return new ElementLabel(localContact, paramElement, localFormat);
    }

    public Class getType(Element paramElement)
    {
      Class localClass1 = paramElement.type();
      Class localClass2 = Void.TYPE;
      if (localClass1 == localClass2)
        localClass1 = this.contact.getType();
      return localClass1;
    }
  }

  private static class ExtractorBuilder
  {
    private final Class label;
    private final Class type;

    public ExtractorBuilder(Class paramClass1, Class paramClass2)
    {
      this.label = paramClass1;
      this.type = paramClass2;
    }

    private Constructor getConstructor()
      throws Exception
    {
      Class localClass1 = this.type;
      Class[] arrayOfClass = new Class[3];
      arrayOfClass[0] = Contact.class;
      Class localClass2 = this.label;
      arrayOfClass[1] = localClass2;
      arrayOfClass[2] = Format.class;
      return localClass1.getConstructor(arrayOfClass);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ExtractorFactory
 * JD-Core Version:    0.6.2
 */