package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class DateStringType extends BaseDateType
{
  public static int DEFAULT_WIDTH = 50;
  private static final DateStringType singleTon = new DateStringType();

  private DateStringType()
  {
    super(localSqlType, arrayOfClass);
  }

  protected DateStringType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }

  public static DateStringType getSingleton()
  {
    return singleTon;
  }

  public int getDefaultWidth()
  {
    return DEFAULT_WIDTH;
  }

  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject)
  {
    DateFormat localDateFormat = convertDateStringConfig(paramFieldType).getDateFormat();
    Date localDate = (Date)paramObject;
    return localDateFormat.format(localDate);
  }

  public Object makeConfigObject(FieldType paramFieldType)
  {
    String str = paramFieldType.getFormat();
    if (str == null);
    for (BaseDateType.DateStringFormatConfig localDateStringFormatConfig = defaultDateFormatConfig; ; localDateStringFormatConfig = new BaseDateType.DateStringFormatConfig(str))
      return localDateStringFormatConfig;
  }

  public Object parseDefaultString(FieldType paramFieldType, String paramString)
    throws SQLException
  {
    BaseDateType.DateStringFormatConfig localDateStringFormatConfig = convertDateStringConfig(paramFieldType);
    try
    {
      String str = normalizeDateString(localDateStringFormatConfig, paramString);
      return str;
    }
    catch (ParseException localParseException)
    {
      throw SqlExceptionUtil.create("Problems with field " + paramFieldType + " parsing default date-string '" + paramString + "' using '" + localDateStringFormatConfig + "'", localParseException);
    }
  }

  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException
  {
    return paramDatabaseResults.getString(paramInt);
  }

  public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt)
    throws SQLException
  {
    String str = (String)paramObject;
    BaseDateType.DateStringFormatConfig localDateStringFormatConfig = convertDateStringConfig(paramFieldType);
    try
    {
      Date localDate = parseDateString(localDateStringFormatConfig, str);
      return localDate;
    }
    catch (ParseException localParseException)
    {
      throw SqlExceptionUtil.create("Problems with column " + paramInt + " parsing date-string '" + str + "' using '" + localDateStringFormatConfig + "'", localParseException);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.field.types.DateStringType
 * JD-Core Version:    0.6.2
 */