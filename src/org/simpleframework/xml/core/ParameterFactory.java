package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.stream.Format;

class ParameterFactory
{
  private final Format format;

  public ParameterFactory(Support paramSupport)
  {
    Format localFormat = paramSupport.getFormat();
    this.format = localFormat;
  }

  private ParameterBuilder getBuilder(Annotation paramAnnotation)
    throws Exception
  {
    ParameterBuilder localParameterBuilder;
    if ((paramAnnotation instanceof Element))
      localParameterBuilder = new ParameterBuilder(ElementParameter.class, Element.class);
    while (true)
    {
      return localParameterBuilder;
      if ((paramAnnotation instanceof ElementList))
      {
        localParameterBuilder = new ParameterBuilder(ElementListParameter.class, ElementList.class);
      }
      else if ((paramAnnotation instanceof ElementArray))
      {
        localParameterBuilder = new ParameterBuilder(ElementArrayParameter.class, ElementArray.class);
      }
      else if ((paramAnnotation instanceof ElementMapUnion))
      {
        localParameterBuilder = new ParameterBuilder(ElementMapUnionParameter.class, ElementMapUnion.class, ElementMap.class);
      }
      else if ((paramAnnotation instanceof ElementListUnion))
      {
        localParameterBuilder = new ParameterBuilder(ElementListUnionParameter.class, ElementListUnion.class, ElementList.class);
      }
      else if ((paramAnnotation instanceof ElementUnion))
      {
        localParameterBuilder = new ParameterBuilder(ElementUnionParameter.class, ElementUnion.class, Element.class);
      }
      else if ((paramAnnotation instanceof ElementMap))
      {
        localParameterBuilder = new ParameterBuilder(ElementMapParameter.class, ElementMap.class);
      }
      else if ((paramAnnotation instanceof Attribute))
      {
        localParameterBuilder = new ParameterBuilder(AttributeParameter.class, Attribute.class);
      }
      else
      {
        if (!(paramAnnotation instanceof Text))
          break;
        localParameterBuilder = new ParameterBuilder(TextParameter.class, Text.class);
      }
    }
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramAnnotation;
    throw new PersistenceException("Annotation %s not supported", arrayOfObject);
  }

  private Constructor getConstructor(Annotation paramAnnotation)
    throws Exception
  {
    Constructor localConstructor = getBuilder(paramAnnotation).getConstructor();
    if (!localConstructor.isAccessible())
      localConstructor.setAccessible(true);
    return localConstructor;
  }

  public Parameter getInstance(Constructor paramConstructor, Annotation paramAnnotation, int paramInt)
    throws Exception
  {
    return getInstance(paramConstructor, paramAnnotation, null, paramInt);
  }

  public Parameter getInstance(Constructor paramConstructor, Annotation paramAnnotation1, Annotation paramAnnotation2, int paramInt)
    throws Exception
  {
    Constructor localConstructor = getConstructor(paramAnnotation1);
    Object[] arrayOfObject1;
    if (paramAnnotation2 != null)
    {
      arrayOfObject1 = new Object[5];
      arrayOfObject1[0] = paramConstructor;
      arrayOfObject1[1] = paramAnnotation1;
      arrayOfObject1[2] = paramAnnotation2;
      Format localFormat1 = this.format;
      arrayOfObject1[3] = localFormat1;
      Integer localInteger1 = Integer.valueOf(paramInt);
      arrayOfObject1[4] = localInteger1;
    }
    Object[] arrayOfObject2;
    for (Parameter localParameter = (Parameter)localConstructor.newInstance(arrayOfObject1); ; localParameter = (Parameter)localConstructor.newInstance(arrayOfObject2))
    {
      return localParameter;
      arrayOfObject2 = new Object[4];
      arrayOfObject2[0] = paramConstructor;
      arrayOfObject2[1] = paramAnnotation1;
      Format localFormat2 = this.format;
      arrayOfObject2[2] = localFormat2;
      Integer localInteger2 = Integer.valueOf(paramInt);
      arrayOfObject2[3] = localInteger2;
    }
  }

  private static class ParameterBuilder
  {
    private final Class entry;
    private final Class label;
    private final Class type;

    public ParameterBuilder(Class paramClass1, Class paramClass2)
    {
      this(paramClass1, paramClass2, null);
    }

    public ParameterBuilder(Class paramClass1, Class paramClass2, Class paramClass3)
    {
      this.label = paramClass2;
      this.entry = paramClass3;
      this.type = paramClass1;
    }

    private Constructor getConstructor(Class[] paramArrayOfClass)
      throws Exception
    {
      return this.type.getConstructor(paramArrayOfClass);
    }

    public Constructor getConstructor()
      throws Exception
    {
      Class localClass1;
      Class localClass2;
      if (this.entry != null)
      {
        localClass1 = this.label;
        localClass2 = this.entry;
      }
      Class localClass3;
      for (Constructor localConstructor = getConstructor(localClass1, localClass2); ; localConstructor = getConstructor(localClass3))
      {
        return localConstructor;
        localClass3 = this.label;
      }
    }

    public Constructor getConstructor(Class paramClass)
      throws Exception
    {
      Class[] arrayOfClass = new Class[4];
      arrayOfClass[0] = Constructor.class;
      arrayOfClass[1] = paramClass;
      arrayOfClass[2] = Format.class;
      Class localClass = Integer.TYPE;
      arrayOfClass[3] = localClass;
      return getConstructor(arrayOfClass);
    }

    public Constructor getConstructor(Class paramClass1, Class paramClass2)
      throws Exception
    {
      Class[] arrayOfClass = new Class[5];
      arrayOfClass[0] = Constructor.class;
      arrayOfClass[1] = paramClass1;
      arrayOfClass[2] = paramClass2;
      arrayOfClass[3] = Format.class;
      Class localClass = Integer.TYPE;
      arrayOfClass[4] = localClass;
      return getConstructor(arrayOfClass);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ParameterFactory
 * JD-Core Version:    0.6.2
 */