package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;
import org.simpleframework.xml.Default;
import org.simpleframework.xml.DefaultType;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

class DetailScanner
  implements Detail
{
  private DefaultType access;
  private NamespaceList declaration;
  private List<FieldDetail> fields;
  private Annotation[] labels;
  private List<MethodDetail> methods;
  private String name;
  private Namespace namespace;
  private Order order;
  private boolean required;
  private Root root;
  private boolean strict;
  private Class type;

  public DetailScanner(Class paramClass)
  {
    LinkedList localLinkedList1 = new LinkedList();
    this.methods = localLinkedList1;
    LinkedList localLinkedList2 = new LinkedList();
    this.fields = localLinkedList2;
    Annotation[] arrayOfAnnotation = paramClass.getDeclaredAnnotations();
    this.labels = arrayOfAnnotation;
    this.strict = true;
    this.type = paramClass;
    scan(paramClass);
  }

  private void access(Annotation paramAnnotation)
  {
    if (paramAnnotation == null)
      return;
    Default localDefault = (Default)paramAnnotation;
    boolean bool = localDefault.required();
    this.required = bool;
    DefaultType localDefaultType = localDefault.value();
    this.access = localDefaultType;
  }

  private void extract(Class paramClass)
  {
    Annotation[] arrayOfAnnotation = this.labels;
    int i = arrayOfAnnotation.length;
    int j = 0;
    while (true)
    {
      if (j >= i)
        return;
      Annotation localAnnotation = arrayOfAnnotation[j];
      if ((localAnnotation instanceof Namespace))
        namespace(localAnnotation);
      if ((localAnnotation instanceof NamespaceList))
        scope(localAnnotation);
      if ((localAnnotation instanceof Root))
        root(localAnnotation);
      if ((localAnnotation instanceof Order))
        order(localAnnotation);
      if ((localAnnotation instanceof Default))
        access(localAnnotation);
      j += 1;
    }
  }

  private void fields(Class paramClass)
  {
    Field[] arrayOfField = paramClass.getDeclaredFields();
    int i = arrayOfField.length;
    int j = 0;
    while (true)
    {
      if (j >= i)
        return;
      Field localField = arrayOfField[j];
      FieldDetail localFieldDetail = new FieldDetail(localField);
      boolean bool = this.fields.add(localFieldDetail);
      j += 1;
    }
  }

  private boolean isEmpty(String paramString)
  {
    if (paramString.length() == 0);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private void methods(Class paramClass)
  {
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    int i = arrayOfMethod.length;
    int j = 0;
    while (true)
    {
      if (j >= i)
        return;
      Method localMethod = arrayOfMethod[j];
      MethodDetail localMethodDetail = new MethodDetail(localMethod);
      boolean bool = this.methods.add(localMethodDetail);
      j += 1;
    }
  }

  private void namespace(Annotation paramAnnotation)
  {
    if (paramAnnotation == null)
      return;
    Namespace localNamespace = (Namespace)paramAnnotation;
    this.namespace = localNamespace;
  }

  private void order(Annotation paramAnnotation)
  {
    if (paramAnnotation == null)
      return;
    Order localOrder = (Order)paramAnnotation;
    this.order = localOrder;
  }

  private void root(Annotation paramAnnotation)
  {
    if (paramAnnotation == null)
      return;
    Root localRoot = (Root)paramAnnotation;
    String str1 = this.type.getSimpleName();
    String str2 = str1;
    if (localRoot == null)
      return;
    String str3 = localRoot.name();
    if (isEmpty(str3))
      String str4 = Reflector.getName(str1);
    boolean bool = localRoot.strict();
    this.strict = bool;
    this.root = localRoot;
    this.name = str3;
  }

  private void scan(Class paramClass)
  {
    methods(paramClass);
    fields(paramClass);
    extract(paramClass);
  }

  private void scope(Annotation paramAnnotation)
  {
    if (paramAnnotation == null)
      return;
    NamespaceList localNamespaceList = (NamespaceList)paramAnnotation;
    this.declaration = localNamespaceList;
  }

  public DefaultType getAccess()
  {
    return this.access;
  }

  public Annotation[] getAnnotations()
  {
    return this.labels;
  }

  public Constructor[] getConstructors()
  {
    return this.type.getDeclaredConstructors();
  }

  public List<FieldDetail> getFields()
  {
    return this.fields;
  }

  public List<MethodDetail> getMethods()
  {
    return this.methods;
  }

  public String getName()
  {
    return this.name;
  }

  public Namespace getNamespace()
  {
    return this.namespace;
  }

  public NamespaceList getNamespaceList()
  {
    return this.declaration;
  }

  public Order getOrder()
  {
    return this.order;
  }

  public Root getRoot()
  {
    return this.root;
  }

  public Class getSuper()
  {
    Class localClass = this.type.getSuperclass();
    if (localClass == Object.class)
      localClass = null;
    return localClass;
  }

  public Class getType()
  {
    return this.type;
  }

  public boolean isInstantiable()
  {
    boolean bool = true;
    if (Modifier.isStatic(this.type.getModifiers()));
    while (true)
    {
      return bool;
      if (this.type.isMemberClass())
        bool = false;
    }
  }

  public boolean isPrimitive()
  {
    return this.type.isPrimitive();
  }

  public boolean isRequired()
  {
    return this.required;
  }

  public boolean isStrict()
  {
    return this.strict;
  }

  public String toString()
  {
    return this.type.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.DetailScanner
 * JD-Core Version:    0.6.2
 */