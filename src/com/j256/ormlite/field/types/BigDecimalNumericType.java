package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseResults;
import java.math.BigDecimal;
import java.sql.SQLException;

public class BigDecimalNumericType extends BaseDataType
{
  private static final BigDecimalNumericType singleTon = new BigDecimalNumericType();

  private BigDecimalNumericType()
  {
    super(localSqlType, arrayOfClass);
  }

  protected BigDecimalNumericType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }

  public static BigDecimalNumericType getSingleton()
  {
    return singleTon;
  }

  public boolean isAppropriateId()
  {
    return false;
  }

  public boolean isEscapedValue()
  {
    return false;
  }

  public Object parseDefaultString(FieldType paramFieldType, String paramString)
    throws SQLException
  {
    try
    {
      BigDecimal localBigDecimal = new BigDecimal(paramString);
      return localBigDecimal;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw SqlExceptionUtil.create("Problems with field " + paramFieldType + " parsing default BigDecimal string '" + paramString + "'", localIllegalArgumentException);
    }
  }

  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException
  {
    return paramDatabaseResults.getBigDecimal(paramInt);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.field.types.BigDecimalNumericType
 * JD-Core Version:    0.6.2
 */