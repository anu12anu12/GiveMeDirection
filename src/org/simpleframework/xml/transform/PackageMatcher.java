package org.simpleframework.xml.transform;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

class PackageMatcher
  implements Matcher
{
  private Transform matchEnum(Class paramClass)
  {
    Class localClass = paramClass.getSuperclass();
    EnumTransform localEnumTransform;
    if (localClass != null)
      if (localClass.isEnum())
        localEnumTransform = new EnumTransform(paramClass);
    while (true)
    {
      return localEnumTransform;
      if (paramClass.isEnum())
        localEnumTransform = new EnumTransform(paramClass);
      else
        localEnumTransform = null;
    }
  }

  private Transform matchFile(Class paramClass)
    throws Exception
  {
    if (paramClass == File.class);
    for (FileTransform localFileTransform = new FileTransform(); ; localFileTransform = null)
      return localFileTransform;
  }

  private Transform matchLanguage(Class paramClass)
    throws Exception
  {
    Object localObject;
    if (paramClass == Boolean.class)
      localObject = new BooleanTransform();
    while (true)
    {
      return localObject;
      if (paramClass == Integer.class)
        localObject = new IntegerTransform();
      else if (paramClass == Long.class)
        localObject = new LongTransform();
      else if (paramClass == Double.class)
        localObject = new DoubleTransform();
      else if (paramClass == Float.class)
        localObject = new FloatTransform();
      else if (paramClass == Short.class)
        localObject = new ShortTransform();
      else if (paramClass == Byte.class)
        localObject = new ByteTransform();
      else if (paramClass == Character.class)
        localObject = new CharacterTransform();
      else if (paramClass == String.class)
        localObject = new StringTransform();
      else if (paramClass == Class.class)
        localObject = new ClassTransform();
      else
        localObject = null;
    }
  }

  private Transform matchMath(Class paramClass)
    throws Exception
  {
    Object localObject;
    if (paramClass == BigDecimal.class)
      localObject = new BigDecimalTransform();
    while (true)
    {
      return localObject;
      if (paramClass == BigInteger.class)
        localObject = new BigIntegerTransform();
      else
        localObject = null;
    }
  }

  private Transform matchSQL(Class paramClass)
    throws Exception
  {
    DateTransform localDateTransform;
    if (paramClass == Time.class)
      localDateTransform = new DateTransform(paramClass);
    while (true)
    {
      return localDateTransform;
      if (paramClass == java.sql.Date.class)
        localDateTransform = new DateTransform(paramClass);
      else if (paramClass == Timestamp.class)
        localDateTransform = new DateTransform(paramClass);
      else
        localDateTransform = null;
    }
  }

  private Transform matchURL(Class paramClass)
    throws Exception
  {
    if (paramClass == URL.class);
    for (URLTransform localURLTransform = new URLTransform(); ; localURLTransform = null)
      return localURLTransform;
  }

  private Transform matchUtility(Class paramClass)
    throws Exception
  {
    Object localObject;
    if (paramClass == java.util.Date.class)
      localObject = new DateTransform(paramClass);
    while (true)
    {
      return localObject;
      if (paramClass == Locale.class)
        localObject = new LocaleTransform();
      else if (paramClass == Currency.class)
        localObject = new CurrencyTransform();
      else if (paramClass == GregorianCalendar.class)
        localObject = new GregorianCalendarTransform();
      else if (paramClass == TimeZone.class)
        localObject = new TimeZoneTransform();
      else
        localObject = null;
    }
  }

  public Transform match(Class paramClass)
    throws Exception
  {
    String str = paramClass.getName();
    Transform localTransform;
    if (str.startsWith("java.lang"))
      localTransform = matchLanguage(paramClass);
    while (true)
    {
      return localTransform;
      if (str.startsWith("java.util"))
        localTransform = matchUtility(paramClass);
      else if (str.startsWith("java.net"))
        localTransform = matchURL(paramClass);
      else if (str.startsWith("java.io"))
        localTransform = matchFile(paramClass);
      else if (str.startsWith("java.sql"))
        localTransform = matchSQL(paramClass);
      else if (str.startsWith("java.math"))
        localTransform = matchMath(paramClass);
      else
        localTransform = matchEnum(paramClass);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.PackageMatcher
 * JD-Core Version:    0.6.2
 */