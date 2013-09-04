package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Text;

class SignatureScanner
{
  private final SignatureBuilder builder;
  private final Constructor constructor;
  private final ParameterFactory factory;
  private final ParameterMap registry;
  private final Class type;

  public SignatureScanner(Constructor paramConstructor, ParameterMap paramParameterMap, Support paramSupport)
    throws Exception
  {
    SignatureBuilder localSignatureBuilder = new SignatureBuilder(paramConstructor);
    this.builder = localSignatureBuilder;
    ParameterFactory localParameterFactory = new ParameterFactory(paramSupport);
    this.factory = localParameterFactory;
    Class localClass1 = paramConstructor.getDeclaringClass();
    this.type = localClass1;
    this.constructor = paramConstructor;
    this.registry = paramParameterMap;
    Class localClass2 = this.type;
    scan(localClass2);
  }

  private List<Parameter> create(Annotation paramAnnotation, int paramInt)
    throws Exception
  {
    ParameterFactory localParameterFactory = this.factory;
    Constructor localConstructor = this.constructor;
    Parameter localParameter = localParameterFactory.getInstance(localConstructor, paramAnnotation, paramInt);
    if (localParameter != null)
      register(localParameter);
    return Collections.singletonList(localParameter);
  }

  private Annotation[] extract(Annotation paramAnnotation)
    throws Exception
  {
    Method[] arrayOfMethod = paramAnnotation.annotationType().getDeclaredMethods();
    if (arrayOfMethod.length != 1)
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = paramAnnotation;
      Class localClass = this.type;
      arrayOfObject1[1] = localClass;
      throw new UnionException("Annotation '%s' is not a valid union for %s", arrayOfObject1);
    }
    Method localMethod = arrayOfMethod[0];
    Object[] arrayOfObject2 = new Object[0];
    return (Annotation[])localMethod.invoke(paramAnnotation, arrayOfObject2);
  }

  private List<Parameter> process(Annotation paramAnnotation, int paramInt)
    throws Exception
  {
    List localList;
    if ((paramAnnotation instanceof Attribute))
      localList = create(paramAnnotation, paramInt);
    while (true)
    {
      return localList;
      if ((paramAnnotation instanceof Element))
        localList = create(paramAnnotation, paramInt);
      else if ((paramAnnotation instanceof ElementList))
        localList = create(paramAnnotation, paramInt);
      else if ((paramAnnotation instanceof ElementArray))
        localList = create(paramAnnotation, paramInt);
      else if ((paramAnnotation instanceof ElementMap))
        localList = create(paramAnnotation, paramInt);
      else if ((paramAnnotation instanceof ElementListUnion))
        localList = union(paramAnnotation, paramInt);
      else if ((paramAnnotation instanceof ElementMapUnion))
        localList = union(paramAnnotation, paramInt);
      else if ((paramAnnotation instanceof ElementUnion))
        localList = union(paramAnnotation, paramInt);
      else if ((paramAnnotation instanceof Text))
        localList = create(paramAnnotation, paramInt);
      else
        localList = Collections.emptyList();
    }
  }

  private void register(Parameter paramParameter)
    throws Exception
  {
    String str = paramParameter.getPath();
    Object localObject1 = paramParameter.getKey();
    if (this.registry.containsKey(localObject1))
      validate(paramParameter, localObject1);
    if (this.registry.containsKey(str))
      validate(paramParameter, str);
    Object localObject2 = this.registry.put(str, paramParameter);
    Object localObject3 = this.registry.put(localObject1, paramParameter);
  }

  private void scan(Class paramClass)
    throws Exception
  {
    Class[] arrayOfClass = this.constructor.getParameterTypes();
    int i = 0;
    while (true)
    {
      int j = arrayOfClass.length;
      if (i >= j)
        return;
      Class localClass = arrayOfClass[i];
      scan(localClass, i);
      i += 1;
    }
  }

  private void scan(Class paramClass, int paramInt)
    throws Exception
  {
    Annotation[][] arrayOfAnnotation = this.constructor.getParameterAnnotations();
    int i = 0;
    while (true)
    {
      int j = arrayOfAnnotation[paramInt].length;
      if (i >= j)
        return;
      Annotation localAnnotation = arrayOfAnnotation[paramInt][i];
      Iterator localIterator = process(localAnnotation, paramInt).iterator();
      while (localIterator.hasNext())
      {
        Parameter localParameter = (Parameter)localIterator.next();
        this.builder.insert(localParameter, paramInt);
      }
      i += 1;
    }
  }

  private List<Parameter> union(Annotation paramAnnotation, int paramInt)
    throws Exception
  {
    Constructor localConstructor1 = this.constructor;
    Signature localSignature = new Signature(localConstructor1);
    Annotation[] arrayOfAnnotation = extract(paramAnnotation);
    int i = arrayOfAnnotation.length;
    int j = 0;
    while (j < i)
    {
      Annotation localAnnotation = arrayOfAnnotation[j];
      ParameterFactory localParameterFactory = this.factory;
      Constructor localConstructor2 = this.constructor;
      Parameter localParameter = localParameterFactory.getInstance(localConstructor2, paramAnnotation, localAnnotation, paramInt);
      String str = localParameter.getPath();
      if (localSignature.contains(str))
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = str;
        arrayOfObject[1] = paramAnnotation;
        Class localClass = this.type;
        arrayOfObject[2] = localClass;
        throw new UnionException("Annotation name '%s' used more than once in %s for %s", arrayOfObject);
      }
      localSignature.set(str, localParameter);
      register(localParameter);
      j += 1;
    }
    return localSignature.getAll();
  }

  private void validate(Parameter paramParameter, Object paramObject)
    throws Exception
  {
    Parameter localParameter = (Parameter)this.registry.get(paramObject);
    boolean bool1 = paramParameter.isText();
    boolean bool2 = localParameter.isText();
    if (bool1 != bool2)
      return;
    Annotation localAnnotation1 = paramParameter.getAnnotation();
    Annotation localAnnotation2 = localParameter.getAnnotation();
    String str = paramParameter.getPath();
    if (!localAnnotation1.equals(localAnnotation2))
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = str;
      Class localClass1 = this.type;
      arrayOfObject1[1] = localClass1;
      throw new ConstructorException("Annotations do not match for '%s' in %s", arrayOfObject1);
    }
    Class localClass2 = localParameter.getType();
    Class localClass3 = paramParameter.getType();
    if (localClass2 == localClass3)
      return;
    Object[] arrayOfObject2 = new Object[2];
    arrayOfObject2[0] = str;
    Class localClass4 = this.type;
    arrayOfObject2[1] = localClass4;
    throw new ConstructorException("Parameter types do not match for '%s' in %s", arrayOfObject2);
  }

  public List<Signature> getSignatures()
    throws Exception
  {
    return this.builder.build();
  }

  public boolean isValid()
  {
    return this.builder.isValid();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.SignatureScanner
 * JD-Core Version:    0.6.2
 */