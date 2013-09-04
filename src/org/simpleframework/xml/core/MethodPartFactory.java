package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

class MethodPartFactory
{
  private final AnnotationFactory factory;

  public MethodPartFactory(Detail paramDetail)
  {
    AnnotationFactory localAnnotationFactory = new AnnotationFactory(paramDetail);
    this.factory = localAnnotationFactory;
  }

  private Annotation getAnnotation(Method paramMethod)
    throws Exception
  {
    Class localClass = getType(paramMethod);
    if (localClass != null);
    for (Annotation localAnnotation = this.factory.getInstance(localClass); ; localAnnotation = null)
      return localAnnotation;
  }

  private MethodType getMethodType(Method paramMethod)
  {
    String str = paramMethod.getName();
    MethodType localMethodType;
    if (str.startsWith("get"))
      localMethodType = MethodType.GET;
    while (true)
    {
      return localMethodType;
      if (str.startsWith("is"))
        localMethodType = MethodType.IS;
      else if (str.startsWith("set"))
        localMethodType = MethodType.SET;
      else
        localMethodType = MethodType.NONE;
    }
  }

  private MethodName getName(Method paramMethod, Annotation paramAnnotation)
    throws Exception
  {
    MethodType localMethodType1 = getMethodType(paramMethod);
    MethodType localMethodType2 = MethodType.GET;
    MethodName localMethodName;
    if (localMethodType1 == localMethodType2)
      localMethodName = getRead(paramMethod, localMethodType1);
    while (true)
    {
      return localMethodName;
      MethodType localMethodType3 = MethodType.IS;
      if (localMethodType1 == localMethodType3)
      {
        localMethodName = getRead(paramMethod, localMethodType1);
      }
      else
      {
        MethodType localMethodType4 = MethodType.SET;
        if (localMethodType1 != localMethodType4)
          break;
        localMethodName = getWrite(paramMethod, localMethodType1);
      }
    }
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramAnnotation;
    throw new MethodException("Annotation %s must mark a set or get method", arrayOfObject);
  }

  private Class getParameterType(Method paramMethod)
    throws Exception
  {
    if (paramMethod.getParameterTypes().length == 1);
    for (Class localClass = paramMethod.getParameterTypes()[0]; ; localClass = null)
      return localClass;
  }

  private MethodName getRead(Method paramMethod, MethodType paramMethodType)
    throws Exception
  {
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    String str1 = paramMethod.getName();
    if (arrayOfClass.length != 0)
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = paramMethod;
      throw new MethodException("Get method %s is not a valid property", arrayOfObject1);
    }
    String str2 = getTypeName(str1, paramMethodType);
    if (str2 == null)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = paramMethod;
      throw new MethodException("Could not get name for %s", arrayOfObject2);
    }
    return new MethodName(paramMethod, paramMethodType, str2);
  }

  private Class getReturnType(Method paramMethod)
    throws Exception
  {
    if (paramMethod.getParameterTypes().length == 0);
    for (Class localClass = paramMethod.getReturnType(); ; localClass = null)
      return localClass;
  }

  private String getTypeName(String paramString, MethodType paramMethodType)
  {
    int i = paramMethodType.getPrefix();
    int j = paramString.length();
    if (j > i)
      paramString = paramString.substring(i, j);
    return Reflector.getName(paramString);
  }

  private MethodName getWrite(Method paramMethod, MethodType paramMethodType)
    throws Exception
  {
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    String str1 = paramMethod.getName();
    if (arrayOfClass.length != 1)
    {
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = paramMethod;
      throw new MethodException("Set method %s is not a valid property", arrayOfObject1);
    }
    String str2 = getTypeName(str1, paramMethodType);
    if (str2 == null)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = paramMethod;
      throw new MethodException("Could not get name for %s", arrayOfObject2);
    }
    return new MethodName(paramMethod, paramMethodType, str2);
  }

  public MethodPart getInstance(Method paramMethod, Annotation paramAnnotation, Annotation[] paramArrayOfAnnotation)
    throws Exception
  {
    MethodName localMethodName = getName(paramMethod, paramAnnotation);
    MethodType localMethodType1 = localMethodName.getType();
    MethodType localMethodType2 = MethodType.SET;
    if (localMethodType1 == localMethodType2);
    for (Object localObject = new SetPart(localMethodName, paramAnnotation, paramArrayOfAnnotation); ; localObject = new GetPart(localMethodName, paramAnnotation, paramArrayOfAnnotation))
      return localObject;
  }

  public MethodPart getInstance(Method paramMethod, Annotation[] paramArrayOfAnnotation)
    throws Exception
  {
    Annotation localAnnotation = getAnnotation(paramMethod);
    if (localAnnotation != null);
    for (MethodPart localMethodPart = getInstance(paramMethod, localAnnotation, paramArrayOfAnnotation); ; localMethodPart = null)
      return localMethodPart;
  }

  public Class getType(Method paramMethod)
    throws Exception
  {
    MethodType localMethodType1 = getMethodType(paramMethod);
    MethodType localMethodType2 = MethodType.SET;
    Class localClass;
    if (localMethodType1 == localMethodType2)
      localClass = getParameterType(paramMethod);
    while (true)
    {
      return localClass;
      MethodType localMethodType3 = MethodType.GET;
      if (localMethodType1 == localMethodType3)
      {
        localClass = getReturnType(paramMethod);
      }
      else
      {
        MethodType localMethodType4 = MethodType.IS;
        if (localMethodType1 == localMethodType4)
          localClass = getReturnType(paramMethod);
        else
          localClass = null;
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.MethodPartFactory
 * JD-Core Version:    0.6.2
 */