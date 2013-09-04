package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Root;

class ClassScanner
{
  private Function commit;
  private Function complete;
  private NamespaceDecorator decorator;
  private Order order;
  private Function persist;
  private Function replace;
  private Function resolve;
  private Root root;
  private ConstructorScanner scanner;
  private Support support;
  private Function validate;

  public ClassScanner(Detail paramDetail, Support paramSupport)
    throws Exception
  {
    ConstructorScanner localConstructorScanner = new ConstructorScanner(paramDetail, paramSupport);
    this.scanner = localConstructorScanner;
    NamespaceDecorator localNamespaceDecorator = new NamespaceDecorator();
    this.decorator = localNamespaceDecorator;
    this.support = paramSupport;
    scan(paramDetail);
  }

  private void commit(Method paramMethod)
  {
    if (this.commit != null)
      return;
    Function localFunction = getFunction(paramMethod);
    this.commit = localFunction;
  }

  private void commit(Detail paramDetail)
  {
    Namespace localNamespace = paramDetail.getNamespace();
    if (localNamespace == null)
      return;
    this.decorator.set(localNamespace);
  }

  private void complete(Method paramMethod)
  {
    if (this.complete != null)
      return;
    Function localFunction = getFunction(paramMethod);
    this.complete = localFunction;
  }

  private void definition(Detail paramDetail)
    throws Exception
  {
    if (this.root == null)
    {
      Root localRoot = paramDetail.getRoot();
      this.root = localRoot;
    }
    if (this.order != null)
      return;
    Order localOrder = paramDetail.getOrder();
    this.order = localOrder;
  }

  private Function getFunction(Method paramMethod)
  {
    boolean bool = isContextual(paramMethod);
    if (!paramMethod.isAccessible())
      paramMethod.setAccessible(true);
    return new Function(paramMethod, bool);
  }

  private boolean isContextual(Method paramMethod)
  {
    boolean bool = false;
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    if (arrayOfClass.length == 1)
    {
      Class localClass = arrayOfClass[0];
      bool = Map.class.equals(localClass);
    }
    return bool;
  }

  private void method(Detail paramDetail)
    throws Exception
  {
    Iterator localIterator = paramDetail.getMethods().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      MethodDetail localMethodDetail = (MethodDetail)localIterator.next();
      method(localMethodDetail);
    }
  }

  private void method(MethodDetail paramMethodDetail)
  {
    Annotation[] arrayOfAnnotation1 = paramMethodDetail.getAnnotations();
    Method localMethod = paramMethodDetail.getMethod();
    Annotation[] arrayOfAnnotation2 = arrayOfAnnotation1;
    int i = arrayOfAnnotation2.length;
    int j = 0;
    while (true)
    {
      if (j >= i)
        return;
      Annotation localAnnotation = arrayOfAnnotation2[j];
      if ((localAnnotation instanceof Commit))
        commit(localMethod);
      if ((localAnnotation instanceof Validate))
        validate(localMethod);
      if ((localAnnotation instanceof Persist))
        persist(localMethod);
      if ((localAnnotation instanceof Complete))
        complete(localMethod);
      if ((localAnnotation instanceof Replace))
        replace(localMethod);
      if ((localAnnotation instanceof Resolve))
        resolve(localMethod);
      j += 1;
    }
  }

  private void namespace(Detail paramDetail)
    throws Exception
  {
    NamespaceList localNamespaceList = paramDetail.getNamespaceList();
    Namespace localNamespace1 = paramDetail.getNamespace();
    if (localNamespace1 != null)
      this.decorator.add(localNamespace1);
    if (localNamespaceList == null)
      return;
    Namespace[] arrayOfNamespace = localNamespaceList.value();
    int i = arrayOfNamespace.length;
    int j = 0;
    while (true)
    {
      if (j >= i)
        return;
      Namespace localNamespace2 = arrayOfNamespace[j];
      this.decorator.add(localNamespace2);
      j += 1;
    }
  }

  private void persist(Method paramMethod)
  {
    if (this.persist != null)
      return;
    Function localFunction = getFunction(paramMethod);
    this.persist = localFunction;
  }

  private void replace(Method paramMethod)
  {
    if (this.replace != null)
      return;
    Function localFunction = getFunction(paramMethod);
    this.replace = localFunction;
  }

  private void resolve(Method paramMethod)
  {
    if (this.resolve != null)
      return;
    Function localFunction = getFunction(paramMethod);
    this.resolve = localFunction;
  }

  private void scan(Detail paramDetail)
    throws Exception
  {
    Detail localDetail;
    for (Class localClass = paramDetail.getType(); localClass != null; localClass = localDetail.getSuper())
    {
      localDetail = this.support.getDetail(localClass);
      namespace(localDetail);
      method(localDetail);
      definition(localDetail);
    }
    commit(paramDetail);
  }

  private void validate(Method paramMethod)
  {
    if (this.validate != null)
      return;
    Function localFunction = getFunction(paramMethod);
    this.validate = localFunction;
  }

  public Function getCommit()
  {
    return this.commit;
  }

  public Function getComplete()
  {
    return this.complete;
  }

  public Decorator getDecorator()
  {
    return this.decorator;
  }

  public Order getOrder()
  {
    return this.order;
  }

  public ParameterMap getParameters()
  {
    return this.scanner.getParameters();
  }

  public Function getPersist()
  {
    return this.persist;
  }

  public Function getReplace()
  {
    return this.replace;
  }

  public Function getResolve()
  {
    return this.resolve;
  }

  public Root getRoot()
  {
    return this.root;
  }

  public Signature getSignature()
  {
    return this.scanner.getSignature();
  }

  public List<Signature> getSignatures()
  {
    return this.scanner.getSignatures();
  }

  public Function getValidate()
  {
    return this.validate;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ClassScanner
 * JD-Core Version:    0.6.2
 */