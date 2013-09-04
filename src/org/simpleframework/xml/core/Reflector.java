package org.simpleframework.xml.core;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

final class Reflector
{
  private static Class getArrayClass(Type paramType)
  {
    Class localClass1 = getClass(((GenericArrayType)paramType).getGenericComponentType());
    if (localClass1 != null);
    for (Class localClass2 = Array.newInstance(localClass1, 0).getClass(); ; localClass2 = null)
      return localClass2;
  }

  private static Class getClass(ParameterizedType paramParameterizedType)
  {
    Type[] arrayOfType = paramParameterizedType.getActualTypeArguments();
    if (arrayOfType.length > 0);
    for (Class localClass = getClass(arrayOfType[0]); ; localClass = null)
      return localClass;
  }

  private static Class getClass(Type paramType)
  {
    if ((paramType instanceof Class));
    for (Class localClass = (Class)paramType; ; localClass = getGenericClass(paramType))
      return localClass;
  }

  private static Class[] getClasses(ParameterizedType paramParameterizedType)
  {
    Type[] arrayOfType = paramParameterizedType.getActualTypeArguments();
    Class[] arrayOfClass = new Class[arrayOfType.length];
    int i = 0;
    while (true)
    {
      int j = arrayOfType.length;
      if (i >= j)
        break;
      Class localClass = getClass(arrayOfType[i]);
      arrayOfClass[i] = localClass;
      i += 1;
    }
    return arrayOfClass;
  }

  public static Class getDependent(Field paramField)
  {
    ParameterizedType localParameterizedType = getType(paramField);
    if (localParameterizedType != null);
    for (Class localClass = getClass(localParameterizedType); ; localClass = null)
      return localClass;
  }

  public static Class[] getDependents(Field paramField)
  {
    ParameterizedType localParameterizedType = getType(paramField);
    if (localParameterizedType != null);
    for (Class[] arrayOfClass = getClasses(localParameterizedType); ; arrayOfClass = new Class[0])
      return arrayOfClass;
  }

  private static Class getGenericClass(Type paramType)
  {
    if ((paramType instanceof GenericArrayType));
    for (Object localObject = getArrayClass(paramType); ; localObject = Object.class)
      return localObject;
  }

  public static String getName(String paramString)
  {
    if (paramString.length() > 0)
    {
      char[] arrayOfChar = paramString.toCharArray();
      char c = arrayOfChar[0];
      if (!isAcronym(arrayOfChar))
      {
        int i = toLowerCase(c);
        arrayOfChar[0] = i;
      }
      paramString = new String(arrayOfChar);
    }
    return paramString;
  }

  public static Class getParameterDependent(Constructor paramConstructor, int paramInt)
  {
    ParameterizedType localParameterizedType = getParameterType(paramConstructor, paramInt);
    if (localParameterizedType != null);
    for (Class localClass = getClass(localParameterizedType); ; localClass = null)
      return localClass;
  }

  public static Class getParameterDependent(Method paramMethod, int paramInt)
  {
    ParameterizedType localParameterizedType = getParameterType(paramMethod, paramInt);
    if (localParameterizedType != null);
    for (Class localClass = getClass(localParameterizedType); ; localClass = null)
      return localClass;
  }

  public static Class[] getParameterDependents(Constructor paramConstructor, int paramInt)
  {
    ParameterizedType localParameterizedType = getParameterType(paramConstructor, paramInt);
    if (localParameterizedType != null);
    for (Class[] arrayOfClass = getClasses(localParameterizedType); ; arrayOfClass = new Class[0])
      return arrayOfClass;
  }

  public static Class[] getParameterDependents(Method paramMethod, int paramInt)
  {
    ParameterizedType localParameterizedType = getParameterType(paramMethod, paramInt);
    if (localParameterizedType != null);
    for (Class[] arrayOfClass = getClasses(localParameterizedType); ; arrayOfClass = new Class[0])
      return arrayOfClass;
  }

  private static ParameterizedType getParameterType(Constructor paramConstructor, int paramInt)
  {
    Type[] arrayOfType = paramConstructor.getGenericParameterTypes();
    Type localType;
    if (arrayOfType.length > paramInt)
    {
      localType = arrayOfType[paramInt];
      if (!(localType instanceof ParameterizedType));
    }
    for (ParameterizedType localParameterizedType = (ParameterizedType)localType; ; localParameterizedType = null)
      return localParameterizedType;
  }

  private static ParameterizedType getParameterType(Method paramMethod, int paramInt)
  {
    Type[] arrayOfType = paramMethod.getGenericParameterTypes();
    Type localType;
    if (arrayOfType.length > paramInt)
    {
      localType = arrayOfType[paramInt];
      if (!(localType instanceof ParameterizedType));
    }
    for (ParameterizedType localParameterizedType = (ParameterizedType)localType; ; localParameterizedType = null)
      return localParameterizedType;
  }

  public static Class getReturnDependent(Method paramMethod)
  {
    ParameterizedType localParameterizedType = getReturnType(paramMethod);
    if (localParameterizedType != null);
    for (Class localClass = getClass(localParameterizedType); ; localClass = null)
      return localClass;
  }

  public static Class[] getReturnDependents(Method paramMethod)
  {
    ParameterizedType localParameterizedType = getReturnType(paramMethod);
    if (localParameterizedType != null);
    for (Class[] arrayOfClass = getClasses(localParameterizedType); ; arrayOfClass = new Class[0])
      return arrayOfClass;
  }

  private static ParameterizedType getReturnType(Method paramMethod)
  {
    Type localType = paramMethod.getGenericReturnType();
    if ((localType instanceof ParameterizedType));
    for (ParameterizedType localParameterizedType = (ParameterizedType)localType; ; localParameterizedType = null)
      return localParameterizedType;
  }

  private static ParameterizedType getType(Field paramField)
  {
    Type localType = paramField.getGenericType();
    if ((localType instanceof ParameterizedType));
    for (ParameterizedType localParameterizedType = (ParameterizedType)localType; ; localParameterizedType = null)
      return localParameterizedType;
  }

  private static boolean isAcronym(char[] paramArrayOfChar)
  {
    boolean bool = false;
    if (paramArrayOfChar.length < 2);
    while (true)
    {
      return bool;
      if (isUpperCase(paramArrayOfChar[0]))
        bool = isUpperCase(paramArrayOfChar[1]);
    }
  }

  private static boolean isUpperCase(char paramChar)
  {
    return Character.isUpperCase(paramChar);
  }

  private static char toLowerCase(char paramChar)
  {
    return Character.toLowerCase(paramChar);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Reflector
 * JD-Core Version:    0.6.2
 */