package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
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

class FieldScanner extends ContactList
{
  private final ContactMap done;
  private final AnnotationFactory factory;
  private final Support support;

  public FieldScanner(Detail paramDetail, Support paramSupport)
    throws Exception
  {
    AnnotationFactory localAnnotationFactory = new AnnotationFactory(paramDetail);
    this.factory = localAnnotationFactory;
    ContactMap localContactMap = new ContactMap();
    this.done = localContactMap;
    this.support = paramSupport;
    scan(paramDetail);
  }

  private void build()
  {
    Iterator localIterator = this.done.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Contact localContact = (Contact)localIterator.next();
      boolean bool = add(localContact);
    }
  }

  private void extend(Class paramClass)
    throws Exception
  {
    ContactList localContactList = this.support.getFields(paramClass);
    if (localContactList == null)
      return;
    boolean bool = addAll(localContactList);
  }

  private void extract(Detail paramDetail)
  {
    Iterator localIterator = paramDetail.getFields().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      FieldDetail localFieldDetail = (FieldDetail)localIterator.next();
      Annotation[] arrayOfAnnotation1 = localFieldDetail.getAnnotations();
      Field localField = localFieldDetail.getField();
      Annotation[] arrayOfAnnotation2 = arrayOfAnnotation1;
      int i = arrayOfAnnotation2.length;
      int j = 0;
      while (j < i)
      {
        Annotation localAnnotation = arrayOfAnnotation2[j];
        scan(localField, localAnnotation, arrayOfAnnotation1);
        j += 1;
      }
    }
  }

  private void extract(Detail paramDetail, DefaultType paramDefaultType)
    throws Exception
  {
    List localList = paramDetail.getFields();
    DefaultType localDefaultType = DefaultType.FIELD;
    if (paramDefaultType != localDefaultType)
      return;
    Iterator localIterator = localList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      FieldDetail localFieldDetail = (FieldDetail)localIterator.next();
      Annotation[] arrayOfAnnotation = localFieldDetail.getAnnotations();
      Field localField = localFieldDetail.getField();
      Class localClass = localField.getType();
      if (!isStatic(localField))
        process(localField, localClass, arrayOfAnnotation);
    }
  }

  private void insert(Object paramObject, Contact paramContact)
  {
    Contact localContact = (Contact)this.done.remove(paramObject);
    if ((localContact != null) && (isText(paramContact)))
      paramContact = localContact;
    Object localObject = this.done.put(paramObject, paramContact);
  }

  private boolean isStatic(Field paramField)
  {
    if (Modifier.isStatic(paramField.getModifiers()));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private boolean isText(Contact paramContact)
  {
    if ((paramContact.getAnnotation() instanceof Text));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private void process(Field paramField, Class paramClass, Annotation[] paramArrayOfAnnotation)
    throws Exception
  {
    Annotation localAnnotation = this.factory.getInstance(paramClass);
    if (localAnnotation == null)
      return;
    process(paramField, localAnnotation, paramArrayOfAnnotation);
  }

  private void process(Field paramField, Annotation paramAnnotation, Annotation[] paramArrayOfAnnotation)
  {
    FieldContact localFieldContact = new FieldContact(paramField, paramAnnotation, paramArrayOfAnnotation);
    FieldKey localFieldKey = new FieldKey(paramField);
    if (!paramField.isAccessible())
      paramField.setAccessible(true);
    insert(localFieldKey, localFieldContact);
  }

  private void remove(Field paramField, Annotation paramAnnotation)
  {
    ContactMap localContactMap = this.done;
    FieldKey localFieldKey = new FieldKey(paramField);
    Object localObject = localContactMap.remove(localFieldKey);
  }

  private void scan(Field paramField, Annotation paramAnnotation, Annotation[] paramArrayOfAnnotation)
  {
    if ((paramAnnotation instanceof Attribute))
      process(paramField, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof ElementUnion))
      process(paramField, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof ElementListUnion))
      process(paramField, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof ElementMapUnion))
      process(paramField, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof ElementList))
      process(paramField, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof ElementArray))
      process(paramField, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof ElementMap))
      process(paramField, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof Element))
      process(paramField, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof Version))
      process(paramField, paramAnnotation, paramArrayOfAnnotation);
    if ((paramAnnotation instanceof Text))
      process(paramField, paramAnnotation, paramArrayOfAnnotation);
    if (!(paramAnnotation instanceof Transient))
      return;
    remove(paramField, paramAnnotation);
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
  }

  private static class FieldKey
  {
    private final String name;
    private final Class type;

    public FieldKey(Field paramField)
    {
      Class localClass = paramField.getDeclaringClass();
      this.type = localClass;
      String str = paramField.getName();
      this.name = str;
    }

    private boolean equals(FieldKey paramFieldKey)
    {
      Class localClass1 = paramFieldKey.type;
      Class localClass2 = this.type;
      if (localClass1 != localClass2);
      String str1;
      String str2;
      for (boolean bool = false; ; bool = str1.equals(str2))
      {
        return bool;
        str1 = paramFieldKey.name;
        str2 = this.name;
      }
    }

    public boolean equals(Object paramObject)
    {
      FieldKey localFieldKey;
      if ((paramObject instanceof FieldKey))
        localFieldKey = (FieldKey)paramObject;
      for (boolean bool = equals(localFieldKey); ; bool = false)
        return bool;
    }

    public int hashCode()
    {
      return this.name.hashCode();
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.FieldScanner
 * JD-Core Version:    0.6.2
 */