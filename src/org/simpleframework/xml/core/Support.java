package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.util.List;
import org.simpleframework.xml.filter.Filter;
import org.simpleframework.xml.filter.PlatformFilter;
import org.simpleframework.xml.strategy.Value;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;
import org.simpleframework.xml.transform.Matcher;
import org.simpleframework.xml.transform.Transform;
import org.simpleframework.xml.transform.Transformer;

class Support
  implements Filter
{
  private final DetailExtractor details;
  private final Filter filter;
  private final Format format;
  private final InstanceFactory instances;
  private final LabelExtractor labels;
  private final Matcher matcher;
  private final ScannerFactory scanners;
  private final Transformer transform;

  public Support()
  {
    this(localPlatformFilter);
  }

  public Support(Filter paramFilter)
  {
    this(paramFilter, localEmptyMatcher);
  }

  public Support(Filter paramFilter, Matcher paramMatcher)
  {
    this(paramFilter, paramMatcher, localFormat);
  }

  public Support(Filter paramFilter, Matcher paramMatcher, Format paramFormat)
  {
    Transformer localTransformer = new Transformer(paramMatcher);
    this.transform = localTransformer;
    ScannerFactory localScannerFactory = new ScannerFactory(this);
    this.scanners = localScannerFactory;
    DetailExtractor localDetailExtractor = new DetailExtractor(this);
    this.details = localDetailExtractor;
    LabelExtractor localLabelExtractor = new LabelExtractor(paramFormat);
    this.labels = localLabelExtractor;
    InstanceFactory localInstanceFactory = new InstanceFactory();
    this.instances = localInstanceFactory;
    this.matcher = paramMatcher;
    this.filter = paramFilter;
    this.format = paramFormat;
  }

  private String getClassName(Class paramClass)
    throws Exception
  {
    if (paramClass.isArray())
      paramClass = paramClass.getComponentType();
    String str = paramClass.getSimpleName();
    if (paramClass.isPrimitive());
    while (true)
    {
      return str;
      str = Reflector.getName(str);
    }
  }

  public static Class getPrimitive(Class paramClass)
  {
    Class localClass1 = Double.TYPE;
    if (paramClass == localClass1)
      paramClass = Double.class;
    while (true)
    {
      return paramClass;
      Class localClass2 = Float.TYPE;
      if (paramClass != localClass2)
      {
        Class localClass3 = Integer.TYPE;
        if (paramClass != localClass3)
        {
          Class localClass4 = Long.TYPE;
          if (paramClass != localClass4)
          {
            Class localClass5 = Boolean.TYPE;
            if (paramClass != localClass5)
            {
              Class localClass6 = Character.TYPE;
              if (paramClass != localClass6)
              {
                Class localClass7 = Short.TYPE;
                if (paramClass != localClass7)
                {
                  Class localClass8 = Byte.TYPE;
                  if (paramClass == localClass8)
                    paramClass = Byte.class;
                }
              }
            }
          }
        }
      }
    }
  }

  public static boolean isAssignable(Class paramClass1, Class paramClass2)
  {
    if (paramClass1.isPrimitive())
      paramClass1 = getPrimitive(paramClass1);
    if (paramClass2.isPrimitive())
      paramClass2 = getPrimitive(paramClass2);
    return paramClass2.isAssignableFrom(paramClass1);
  }

  public static boolean isFloat(Class paramClass)
    throws Exception
  {
    boolean bool = true;
    if (paramClass == Double.class);
    while (true)
    {
      return bool;
      if (paramClass != Float.class)
      {
        Class localClass1 = Float.TYPE;
        if (paramClass != localClass1)
        {
          Class localClass2 = Double.TYPE;
          if (paramClass != localClass2)
            bool = false;
        }
      }
    }
  }

  public Detail getDetail(Class paramClass)
  {
    return this.details.getDetail(paramClass);
  }

  public ContactList getFields(Class paramClass)
    throws Exception
  {
    return this.details.getFields(paramClass);
  }

  public Format getFormat()
  {
    return this.format;
  }

  public Instance getInstance(Class paramClass)
  {
    return this.instances.getInstance(paramClass);
  }

  public Instance getInstance(Value paramValue)
  {
    return this.instances.getInstance(paramValue);
  }

  public Label getLabel(Contact paramContact, Annotation paramAnnotation)
    throws Exception
  {
    return this.labels.getLabel(paramContact, paramAnnotation);
  }

  public List<Label> getLabels(Contact paramContact, Annotation paramAnnotation)
    throws Exception
  {
    return this.labels.getList(paramContact, paramAnnotation);
  }

  public ContactList getMethods(Class paramClass)
    throws Exception
  {
    return this.details.getMethods(paramClass);
  }

  public String getName(Class paramClass)
    throws Exception
  {
    String str = getScanner(paramClass).getName();
    if (str != null);
    while (true)
    {
      return str;
      str = getClassName(paramClass);
    }
  }

  public Scanner getScanner(Class paramClass)
    throws Exception
  {
    return this.scanners.getInstance(paramClass);
  }

  public Style getStyle()
  {
    return this.format.getStyle();
  }

  public Transform getTransform(Class paramClass)
    throws Exception
  {
    return this.matcher.match(paramClass);
  }

  public boolean isPrimitive(Class paramClass)
    throws Exception
  {
    boolean bool = true;
    if (paramClass == String.class);
    while (true)
    {
      return bool;
      if ((paramClass != Float.class) && (paramClass != Double.class) && (paramClass != Long.class) && (paramClass != Integer.class) && (paramClass != Boolean.class) && (!paramClass.isEnum()) && (!paramClass.isPrimitive()))
        bool = this.transform.valid(paramClass);
    }
  }

  public Object read(String paramString, Class paramClass)
    throws Exception
  {
    return this.transform.read(paramString, paramClass);
  }

  public String replace(String paramString)
  {
    return this.filter.replace(paramString);
  }

  public boolean valid(Class paramClass)
    throws Exception
  {
    return this.transform.valid(paramClass);
  }

  public String write(Object paramObject, Class paramClass)
    throws Exception
  {
    return this.transform.write(paramObject, paramClass);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Support
 * JD-Core Version:    0.6.2
 */