package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.Transient;
import org.simpleframework.xml.Version;

class MethodScanner extends ContactList
{
  private final Detail detail;
  private final MethodPartFactory factory;
  private final PartMap read;
  private final Support support;
  private final PartMap write;

  public MethodScanner(Detail paramDetail, Support paramSupport)
    throws Exception
  {
    MethodPartFactory localMethodPartFactory = new MethodPartFactory(paramDetail);
    this.factory = localMethodPartFactory;
    PartMap localPartMap1 = new PartMap(null);
    this.write = localPartMap1;
    PartMap localPartMap2 = new PartMap(null);
    this.read = localPartMap2;
    this.support = paramSupport;
    this.detail = paramDetail;
    scan(paramDetail);
  }

  private void build()
    throws Exception
  {
    Iterator localIterator = this.read.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      String str = (String)localIterator.next();
      MethodPart localMethodPart = (MethodPart)this.read.get(str);
      if (localMethodPart != null)
        build(localMethodPart, str);
    }
  }

  private void build(MethodPart paramMethodPart)
    throws Exception
  {
    MethodContact localMethodContact = new MethodContact(paramMethodPart);
    boolean bool = add(localMethodContact);
  }

  private void build(MethodPart paramMethodPart, String paramString)
    throws Exception
  {
    MethodPart localMethodPart = this.write.take(paramString);
    if (localMethodPart != null)
    {
      build(paramMethodPart, localMethodPart);
      return;
    }
    build(paramMethodPart);
  }

  private void build(MethodPart paramMethodPart1, MethodPart paramMethodPart2)
    throws Exception
  {
    Annotation localAnnotation = paramMethodPart1.getAnnotation();
    String str = paramMethodPart1.getName();
    if (!paramMethodPart2.getAnnotation().equals(localAnnotation))
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = str;
      Detail localDetail = this.detail;
      arrayOfObject1[1] = localDetail;
      throw new MethodException("Annotations do not match for '%s' in %s", arrayOfObject1);
    }
    Class localClass1 = paramMethodPart1.getType();
    Class localClass2 = paramMethodPart2.getType();
    if (localClass1 != localClass2)
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = str;
      arrayOfObject2[1] = localClass1;
      throw new MethodException("Method types do not match for %s in %s", arrayOfObject2);
    }
    MethodContact localMethodContact = new MethodContact(paramMethodPart1, paramMethodPart2);
    boolean bool = add(localMethodContact);
  }

  private void extend(Class paramClass)
    throws Exception
  {
    Iterator localIterator = this.support.getMethods(paramClass).iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      MethodContact localMethodContact = (MethodContact)localIterator.next();
      process(localMethodContact);
    }
  }

  private void extract(Detail paramDetail)
    throws Exception
  {
    Iterator localIterator = paramDetail.getMethods().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      MethodDetail localMethodDetail = (MethodDetail)localIterator.next();
      Annotation[] arrayOfAnnotation1 = localMethodDetail.getAnnotations();
      Method localMethod = localMethodDetail.getMethod();
      Annotation[] arrayOfAnnotation2 = arrayOfAnnotation1;
      int i = arrayOfAnnotation2.length;
      int j = 0;
      while (j < i)
      {
        Annotation localAnnotation = arrayOfAnnotation2[j];
        scan(localMethod, localAnnotation, arrayOfAnnotation1);
        j += 1;
      }
    }
  }

  private void extract(Detail paramDetail, DefaultType paramDefaultType)
    throws Exception
  {
    List localList = paramDetail.getMethods();
    DefaultType localDefaultType = DefaultType.PROPERTY;
    if (paramDefaultType != localDefaultType)
      return;
    Iterator localIterator = localList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      MethodDetail localMethodDetail = (MethodDetail)localIterator.next();
      Annotation[] arrayOfAnnotation = localMethodDetail.getAnnotations();
      Method localMethod = localMethodDetail.getMethod();
      if (this.factory.getType(localMethod) != null)
        process(localMethod, arrayOfAnnotation);
    }
  }

  private void insert(MethodPart paramMethodPart, PartMap paramPartMap)
  {
    String str = paramMethodPart.getName();
    MethodPart localMethodPart = (MethodPart)paramPartMap.remove(str);
    if ((localMethodPart != null) && (isText(paramMethodPart)))
      paramMethodPart = localMethodPart;
    Object localObject = paramPartMap.put(str, paramMethodPart);
  }

  private boolean isText(MethodPart paramMethodPart)
  {
    if ((paramMethodPart.getAnnotation() instanceof Text));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private void process(Method paramMethod, Annotation paramAnnotation, Annotation[] paramArrayOfAnnotation)
    throws Exception
  {
    MethodPart localMethodPart = this.factory.getInstance(paramMethod, paramAnnotation, paramArrayOfAnnotation);
    MethodType localMethodType1 = localMethodPart.getMethodType();
    MethodType localMethodType2 = MethodType.GET;
    if (localMethodType1 == localMethodType2)
    {
      PartMap localPartMap1 = this.read;
      process(localMethodPart, localPartMap1);
    }
    MethodType localMethodType3 = MethodType.IS;
    if (localMethodType1 == localMethodType3)
    {
      PartMap localPartMap2 = this.read;
      process(localMethodPart, localPartMap2);
    }
    MethodType localMethodType4 = MethodType.SET;
    if (localMethodType1 != localMethodType4)
      return;
    PartMap localPartMap3 = this.write;
    process(localMethodPart, localPartMap3);
  }

  private void process(Method paramMethod, Annotation[] paramArrayOfAnnotation)
    throws Exception
  {
    MethodPart localMethodPart = this.factory.getInstance(paramMethod, paramArrayOfAnnotation);
    MethodType localMethodType1 = localMethodPart.getMethodType();
    MethodType localMethodType2 = MethodType.GET;
    if (localMethodType1 == localMethodType2)
    {
      PartMap localPartMap1 = this.read;
      process(localMethodPart, localPartMap1);
    }
    MethodType localMethodType3 = MethodType.IS;
    if (localMethodType1 == localMethodType3)
    {
      PartMap localPartMap2 = this.read;
      process(localMethodPart, localPartMap2);
    }
    MethodType localMethodType4 = MethodType.SET;
    if (localMethodType1 != localMethodType4)
      return;
    PartMap localPartMap3 = this.write;
    process(localMethodPart, localPartMap3);
  }

  private void process(MethodContact paramMethodContact)
  {
    MethodPart localMethodPart1 = paramMethodContact.getRead();
    MethodPart localMethodPart2 = paramMethodContact.getWrite();
    if (localMethodPart2 != null)
    {
      PartMap localPartMap1 = this.write;
      insert(localMethodPart2, localPartMap1);
    }
    PartMap localPartMap2 = this.read;
    insert(localMethodPart1, localPartMap2);
  }

  private void process(MethodPart paramMethodPart, PartMap paramPartMap)
  {
    String str = paramMethodPart.getName();
    if (str == null)
      return;
    Object localObject = paramPartMap.put(str, paramMethodPart);
  }

  private void remove(Method paramMethod, Annotation paramAnnotation, Annotation[] paramArrayOfAnnotation)
    throws Exception
  {
    MethodPart localMethodPart = this.factory.getInstance(paramMethod, paramAnnotation, paramArrayOfAnnotation);
    MethodType localMethodType1 = localMethodPart.getMethodType();
    MethodType localMethodType2 = MethodType.GET;
    if (localMethodType1 == localMethodType2)
    {
      PartMap localPartMap1 = this.read;
      remove(localMethodPart, localPartMap1);
    }
    MethodType localMethodType3 = MethodType.IS;
    if (localMethodType1 == localMethodType3)
    {
      PartMap localPartMap2 = this.read;
      remove(localMethodPart, localPartMap2);
    }
    MethodType localMethodType4 = MethodType.SET;
    if (localMethodType1 != localMethodType4)
      return;
    PartMap localPartMap3 = this.write;
    remove(localMethodPart, localPartMap3);
  }

  private void remove(MethodPart paramMethodPart, PartMap paramPartMap)
    throws Exception
  {
    String str = paramMethodPart.getName();
    if (str == null)
      return;
    Object localObject = paramPartMap.remove(str);
  }

  private void scan(Method paramMethod, Annotation paramAnnotation, Annotation[] paramArrayOfAnnotation)
    throws Exception
  {
    if ((paramAnnotation instanceof Attribute))
      process(paramMethod, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof ElementUnion))
      process(paramMethod, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof ElementListUnion))
      process(paramMethod, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof ElementMapUnion))
      process(paramMethod, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof ElementList))
      process(paramMethod, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof ElementArray))
      process(paramMethod, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof ElementMap))
      process(paramMethod, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof Element))
      process(paramMethod, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof Version))
      process(paramMethod, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof Text))
      process(paramMethod, paramAnnotation, paramArrayOfAnnotation);
    if (!(paramAnnotation instanceof Transient))
      return;
    remove(paramMethod, paramAnnotation, paramArrayOfAnnotation);
  }

  private void scan(Detail paramDetail)
    throws Exception
  {
    DefaultType localDefaultType = paramDetail.getAccess();
    Class localClass = paramDetail.getSuper();
    if (localClass != null)
      extend(localClass);
    extract(paramDetail, localDefaultType);
    extract(paramDetail);
    build();
    validate();
  }

  private void validate()
    throws Exception
  {
    Iterator localIterator = this.write.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      String str = (String)localIterator.next();
      MethodPart localMethodPart = (MethodPart)this.write.get(str);
      if (localMethodPart != null)
        validate(localMethodPart, str);
    }
  }

  private void validate(MethodPart paramMethodPart, String paramString)
    throws Exception
  {
    MethodPart localMethodPart = this.read.take(paramString);
    Method localMethod = paramMethodPart.getMethod();
    if (localMethodPart != null)
      return;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = localMethod;
    Detail localDetail = this.detail;
    arrayOfObject[1] = localDetail;
    throw new MethodException("No matching get method for %s in %s", arrayOfObject);
  }

  private static class PartMap extends LinkedHashMap<String, MethodPart>
    implements Iterable<String>
  {
    public Iterator<String> iterator()
    {
      return keySet().iterator();
    }

    public MethodPart take(String paramString)
    {
      return (MethodPart)remove(paramString);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.MethodScanner
 * JD-Core Version:    0.6.2
 */