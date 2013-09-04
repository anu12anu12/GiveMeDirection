package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

public class DateType extends BaseDateType
{
  public static final BaseDateType.DateStringFormatConfig defaultDateFormatConfig = new BaseDateType.DateStringFormatConfig("yyyy-MM-dd HH:mm:ss.SSSSSS");
  private static final DateType singleTon = new DateType();

  private DateType()
  {
    super(localSqlType, arrayOfClass);
  }

  protected DateType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }

  public static DateType getSingleton()
  {
    return singleTon;
  }

  public boolean isArgumentHolderRequired()
  {
    return true;
  }

  public Object javaToSqlArg(FieldType paramFieldType, Object paramObject)
  {
    long l = ((Date)paramObject).getTime();
    return new Timestamp(l);
  }

  public Object parseDefaultString(FieldType paramFieldType, String paramString)
    throws SQLException
  {
    BaseDateType.DateStringFormatConfig localDateStringFormatConfig = convertDateStringConfig(paramFieldType);
    try
    {
      long l = parseDateString(localDateStringFormatConfig, paramString).getTime();
      Timestamp localTimestamp = new Timestamp(l);
      return localTimestamp;
    }
    catch (ParseException localParseException)
    {
      throw SqlExceptionUtil.create("Problems parsing default date string '" + paramString + "' using '" + localDateStringFormatConfig + '\'', localParseException);
    }
  }

  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException
  {
    return paramDatabaseResults.getTimestamp(paramInt);
  }

  public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt)
  {
    long l = ((Timestamp)paramObject).getTime();
    return new Date(l);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.field.types.DateType
 * JD-Core Version:    0.6.2
 */