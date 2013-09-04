package org.simpleframework.xml.convert;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.strategy.Value;

class ConverterScanner
{
  private final ScannerBuilder builder;
  private final ConverterFactory factory;

  public ConverterScanner()
  {
    ConverterFactory localConverterFactory = new ConverterFactory();
    this.factory = localConverterFactory;
    ScannerBuilder localScannerBuilder = new ScannerBuilder();
    this.builder = localScannerBuilder;
  }

  private <T extends Annotation> T getAnnotation(Class<?> paramClass, Class<T> paramClass1)
  {
    return this.builder.build(paramClass).scan(paramClass1);
  }

  private Convert getConvert(Class paramClass)
    throws Exception
  {
    Convert localConvert = (Convert)getAnnotation(paramClass, Convert.class);
    if ((localConvert != null) && ((Root)getAnnotation(paramClass, Root.class) == null))
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramClass;
      throw new ConvertException("Root annotation required for %s", arrayOfObject);
    }
    return localConvert;
  }

  private Convert getConvert(Type paramType)
    throws Exception
  {
    Convert localConvert = (Convert)paramType.getAnnotation(Convert.class);
    if ((localConvert != null) && ((Element)paramType.getAnnotation(Element.class) == null))
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramType;
      throw new ConvertException("Element annotation required for %s", arrayOfObject);
    }
    return localConvert;
  }

  private Convert getConvert(Type paramType, Class paramClass)
    throws Exception
  {
    Convert localConvert = getConvert(paramType);
    if (localConvert == null)
      localConvert = getConvert(paramClass);
    return localConvert;
  }

  private Class getType(Type paramType, Object paramObject)
  {
    Class localClass = paramType.getType();
    if (paramObject != null)
      localClass = paramObject.getClass();
    return localClass;
  }

  private Class getType(Type paramType, Value paramValue)
  {
    Class localClass = paramType.getType();
    if (paramValue != null)
      localClass = paramValue.getType();
    return localClass;
  }

  public Converter getConverter(Type paramType, Object paramObject)
    throws Exception
  {
    Class localClass = getType(paramType, paramObject);
    Convert localConvert = getConvert(paramType, localClass);
    if (localConvert != null);
    for (Converter localConverter = this.factory.getInstance(localConvert); ; localConverter = null)
      return localConverter;
  }

  public Converter getConverter(Type paramType, Value paramValue)
    throws Exception
  {
    Class localClass = getType(paramType, paramValue);
    Convert localConvert = getConvert(paramType, localClass);
    if (localConvert != null);
    for (Converter localConverter = this.factory.getInstance(localConvert); ; localConverter = null)
      return localConverter;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.convert.ConverterScanner
 * JD-Core Version:    0.6.2
 */