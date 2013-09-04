package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BaseDateType extends BaseDataType
{
  public static final DateStringFormatConfig defaultDateFormatConfig = new DateStringFormatConfig("yyyy-MM-dd HH:mm:ss.SSSSSS");

  protected BaseDateType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }

  protected static DateStringFormatConfig convertDateStringConfig(FieldType paramFieldType)
  {
    DateStringFormatConfig localDateStringFormatConfig;
    if (paramFieldType == null)
      localDateStringFormatConfig = defaultDateFormatConfig;
    while (true)
    {
      return localDateStringFormatConfig;
      localDateStringFormatConfig = (DateStringFormatConfig)paramFieldType.getDataTypeConfigObj();
      if (localDateStringFormatConfig == null)
        localDateStringFormatConfig = defaultDateFormatConfig;
    }
  }

  protected static String normalizeDateString(DateStringFormatConfig paramDateStringFormatConfig, String paramString)
    throws ParseException
  {
    DateFormat localDateFormat = paramDateStringFormatConfig.getDateFormat();
    Date localDate = localDateFormat.parse(paramString);
    return localDateFormat.format(localDate);
  }

  protected static Date parseDateString(DateStringFormatConfig paramDateStringFormatConfig, String paramString)
    throws ParseException
  {
    return paramDateStringFormatConfig.getDateFormat().parse(paramString);
  }

  public boolean isValidForField(Field paramField)
  {
    if (paramField.getType() == Date.class);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean isValidForVersion()
  {
    return true;
  }

  public Object moveToNextValue(Object paramObject)
  {
    long l1 = System.currentTimeMillis();
    Date localDate;
    if (paramObject == null)
      localDate = new Date(l1);
    while (true)
    {
      return localDate;
      long l2 = ((Date)paramObject).getTime();
      if (l1 == l2)
      {
        long l3 = 1L + l1;
        localDate = new Date(l3);
      }
      else
      {
        localDate = new Date(l1);
      }
    }
  }

  protected static class DateStringFormatConfig
  {
    final String dateFormatStr;
    private final ThreadLocal<DateFormat> threadLocal;

    public DateStringFormatConfig(String paramString)
    {
      ThreadLocal local1 = new ThreadLocal()
      {
        protected DateFormat initialValue()
        {
          String str = BaseDateType.DateStringFormatConfig.this.dateFormatStr;
          return new SimpleDateFormat(str);
        }
      };
      this.threadLocal = local1;
      this.dateFormatStr = paramString;
    }

    public DateFormat getDateFormat()
    {
      return (DateFormat)this.threadLocal.get();
    }

    public String toString()
    {
      return this.dateFormatStr;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.field.types.BaseDateType
 * JD-Core Version:    0.6.2
 */