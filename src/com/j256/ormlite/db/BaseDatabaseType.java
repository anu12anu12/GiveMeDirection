package com.j256.ormlite.db;

import com.j256.ormlite.field.BaseFieldConverter;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldConverter;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDatabaseType
  implements DatabaseType
{
  protected static String DEFAULT_SEQUENCE_SUFFIX = "_id_seq";
  protected Driver driver;

  private void addSingleUnique(StringBuilder paramStringBuilder, FieldType paramFieldType, List<String> paramList1, List<String> paramList2)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(" UNIQUE (");
    String str1 = paramFieldType.getColumnName();
    appendEscapedEntityName(localStringBuilder1, str1);
    StringBuilder localStringBuilder3 = localStringBuilder1.append(")");
    String str2 = localStringBuilder1.toString();
    boolean bool = paramList1.add(str2);
  }

  private void appendCanBeNull(StringBuilder paramStringBuilder, FieldType paramFieldType)
  {
  }

  private void appendDefaultValue(StringBuilder paramStringBuilder, FieldType paramFieldType, Object paramObject)
  {
    if (paramFieldType.isEscapedDefaultValue())
    {
      String str = paramObject.toString();
      appendEscapedWord(paramStringBuilder, str);
      return;
    }
    StringBuilder localStringBuilder = paramStringBuilder.append(paramObject);
  }

  private void appendDoubleType(StringBuilder paramStringBuilder, int paramInt)
  {
    StringBuilder localStringBuilder = paramStringBuilder.append("DOUBLE PRECISION");
  }

  private void appendFloatType(StringBuilder paramStringBuilder, int paramInt)
  {
    StringBuilder localStringBuilder = paramStringBuilder.append("FLOAT");
  }

  private void appendIntegerType(StringBuilder paramStringBuilder, int paramInt)
  {
    StringBuilder localStringBuilder = paramStringBuilder.append("INTEGER");
  }

  public void addPrimaryKeySql(FieldType[] paramArrayOfFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4)
  {
    StringBuilder localStringBuilder1 = null;
    FieldType[] arrayOfFieldType = paramArrayOfFieldType;
    int i = arrayOfFieldType.length;
    int j = 0;
    if (j < i)
    {
      FieldType localFieldType = arrayOfFieldType[j];
      if ((localFieldType.isGeneratedId()) && (!generatedIdSqlAtEnd()) && (!localFieldType.isSelfGeneratedId()));
      while (!localFieldType.isId())
      {
        j += 1;
        break;
      }
      if (localStringBuilder1 == null)
      {
        localStringBuilder1 = new StringBuilder(48);
        StringBuilder localStringBuilder2 = localStringBuilder1.append("PRIMARY KEY (");
      }
      while (true)
      {
        String str1 = localFieldType.getColumnName();
        appendEscapedEntityName(localStringBuilder1, str1);
        break;
        StringBuilder localStringBuilder3 = localStringBuilder1.append(',');
      }
    }
    if (localStringBuilder1 == null)
      return;
    StringBuilder localStringBuilder4 = localStringBuilder1.append(") ");
    String str2 = localStringBuilder1.toString();
    boolean bool = paramList1.add(str2);
  }

  public void addUniqueComboSql(FieldType[] paramArrayOfFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4)
  {
    StringBuilder localStringBuilder1 = null;
    FieldType[] arrayOfFieldType = paramArrayOfFieldType;
    int i = arrayOfFieldType.length;
    int j = 0;
    if (j < i)
    {
      FieldType localFieldType = arrayOfFieldType[j];
      if (localFieldType.isUniqueCombo())
      {
        if (localStringBuilder1 != null)
          break label85;
        localStringBuilder1 = new StringBuilder(48);
        StringBuilder localStringBuilder2 = localStringBuilder1.append("UNIQUE (");
      }
      while (true)
      {
        String str1 = localFieldType.getColumnName();
        appendEscapedEntityName(localStringBuilder1, str1);
        j += 1;
        break;
        label85: StringBuilder localStringBuilder3 = localStringBuilder1.append(',');
      }
    }
    if (localStringBuilder1 == null)
      return;
    StringBuilder localStringBuilder4 = localStringBuilder1.append(") ");
    String str2 = localStringBuilder1.toString();
    boolean bool = paramList1.add(str2);
  }

  protected void appendBigDecimalNumericType(StringBuilder paramStringBuilder, int paramInt)
  {
    StringBuilder localStringBuilder = paramStringBuilder.append("NUMERIC");
  }

  protected void appendBooleanType(StringBuilder paramStringBuilder, int paramInt)
  {
    StringBuilder localStringBuilder = paramStringBuilder.append("BOOLEAN");
  }

  protected void appendByteArrayType(StringBuilder paramStringBuilder, int paramInt)
  {
    StringBuilder localStringBuilder = paramStringBuilder.append("BLOB");
  }

  protected void appendByteType(StringBuilder paramStringBuilder, int paramInt)
  {
    StringBuilder localStringBuilder = paramStringBuilder.append("TINYINT");
  }

  protected void appendCharType(StringBuilder paramStringBuilder, int paramInt)
  {
    StringBuilder localStringBuilder = paramStringBuilder.append("CHAR");
  }

  public void appendColumnArg(String paramString, StringBuilder paramStringBuilder, FieldType paramFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4)
    throws SQLException
  {
    String str1 = paramFieldType.getColumnName();
    StringBuilder localStringBuilder1 = paramStringBuilder;
    appendEscapedEntityName(localStringBuilder1, str1);
    StringBuilder localStringBuilder2 = paramStringBuilder.append(' ');
    DataPersister localDataPersister = paramFieldType.getDataPersister();
    int i = paramFieldType.getWidth();
    if (i == 0)
      i = localDataPersister.getDefaultWidth();
    int[] arrayOfInt = 1.$SwitchMap$com$j256$ormlite$field$SqlType;
    int j = localDataPersister.getSqlType().ordinal();
    switch (arrayOfInt[j])
    {
    default:
      StringBuilder localStringBuilder3 = new StringBuilder().append("Unknown SQL-type ");
      SqlType localSqlType = localDataPersister.getSqlType();
      String str2 = localSqlType;
      throw new IllegalArgumentException(str2);
    case 1:
      StringBuilder localStringBuilder4 = paramStringBuilder;
      appendStringType(localStringBuilder4, i);
      StringBuilder localStringBuilder5 = paramStringBuilder.append(' ');
      if ((paramFieldType.isGeneratedIdSequence()) && (!paramFieldType.isSelfGeneratedId()))
      {
        BaseDatabaseType localBaseDatabaseType1 = this;
        StringBuilder localStringBuilder6 = paramStringBuilder;
        FieldType localFieldType1 = paramFieldType;
        List<String> localList1 = paramList2;
        List<String> localList2 = paramList1;
        List<String> localList3 = paramList4;
        localBaseDatabaseType1.configureGeneratedIdSequence(localStringBuilder6, localFieldType1, localList1, localList2, localList3);
        label258: if (paramFieldType.isGeneratedId())
          return;
        Object localObject = paramFieldType.getDefaultValue();
        if (localObject != null)
        {
          StringBuilder localStringBuilder7 = paramStringBuilder.append("DEFAULT ");
          StringBuilder localStringBuilder8 = paramStringBuilder;
          FieldType localFieldType2 = paramFieldType;
          appendDefaultValue(localStringBuilder8, localFieldType2, localObject);
          StringBuilder localStringBuilder9 = paramStringBuilder.append(' ');
        }
        if (!paramFieldType.isCanBeNull())
          break label662;
        StringBuilder localStringBuilder10 = paramStringBuilder;
        FieldType localFieldType3 = paramFieldType;
        appendCanBeNull(localStringBuilder10, localFieldType3);
      }
      break;
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    case 11:
    case 12:
    case 13:
    case 14:
    }
    while (true)
    {
      if (!paramFieldType.isUnique())
        return;
      StringBuilder localStringBuilder11 = paramStringBuilder;
      FieldType localFieldType4 = paramFieldType;
      List<String> localList4 = paramList1;
      List<String> localList5 = paramList3;
      addSingleUnique(localStringBuilder11, localFieldType4, localList4, localList5);
      return;
      StringBuilder localStringBuilder12 = paramStringBuilder;
      appendLongStringType(localStringBuilder12, i);
      break;
      StringBuilder localStringBuilder13 = paramStringBuilder;
      appendBooleanType(localStringBuilder13, i);
      break;
      StringBuilder localStringBuilder14 = paramStringBuilder;
      appendDateType(localStringBuilder14, i);
      break;
      StringBuilder localStringBuilder15 = paramStringBuilder;
      appendCharType(localStringBuilder15, i);
      break;
      StringBuilder localStringBuilder16 = paramStringBuilder;
      appendByteType(localStringBuilder16, i);
      break;
      StringBuilder localStringBuilder17 = paramStringBuilder;
      appendByteArrayType(localStringBuilder17, i);
      break;
      StringBuilder localStringBuilder18 = paramStringBuilder;
      appendShortType(localStringBuilder18, i);
      break;
      StringBuilder localStringBuilder19 = paramStringBuilder;
      appendIntegerType(localStringBuilder19, i);
      break;
      FieldType localFieldType5 = paramFieldType;
      StringBuilder localStringBuilder20 = paramStringBuilder;
      appendLongType(localFieldType5, localStringBuilder20, i);
      break;
      StringBuilder localStringBuilder21 = paramStringBuilder;
      appendFloatType(localStringBuilder21, i);
      break;
      StringBuilder localStringBuilder22 = paramStringBuilder;
      appendDoubleType(localStringBuilder22, i);
      break;
      StringBuilder localStringBuilder23 = paramStringBuilder;
      appendSerializableType(localStringBuilder23, i);
      break;
      StringBuilder localStringBuilder24 = paramStringBuilder;
      appendBigDecimalNumericType(localStringBuilder24, i);
      break;
      if ((paramFieldType.isGeneratedId()) && (!paramFieldType.isSelfGeneratedId()))
      {
        BaseDatabaseType localBaseDatabaseType2 = this;
        String str3 = paramString;
        StringBuilder localStringBuilder25 = paramStringBuilder;
        FieldType localFieldType6 = paramFieldType;
        List<String> localList6 = paramList2;
        List<String> localList7 = paramList3;
        List<String> localList8 = paramList1;
        List<String> localList9 = paramList4;
        localBaseDatabaseType2.configureGeneratedId(str3, localStringBuilder25, localFieldType6, localList6, localList7, localList8, localList9);
        break label258;
      }
      if (!paramFieldType.isId())
        break label258;
      BaseDatabaseType localBaseDatabaseType3 = this;
      StringBuilder localStringBuilder26 = paramStringBuilder;
      FieldType localFieldType7 = paramFieldType;
      List<String> localList10 = paramList2;
      List<String> localList11 = paramList1;
      List<String> localList12 = paramList4;
      localBaseDatabaseType3.configureId(localStringBuilder26, localFieldType7, localList10, localList11, localList12);
      break label258;
      label662: StringBuilder localStringBuilder27 = paramStringBuilder.append("NOT NULL ");
    }
  }

  public void appendCreateTableSuffix(StringBuilder paramStringBuilder)
  {
  }

  protected void appendDateType(StringBuilder paramStringBuilder, int paramInt)
  {
    StringBuilder localStringBuilder = paramStringBuilder.append("TIMESTAMP");
  }

  public void appendEscapedEntityName(StringBuilder paramStringBuilder, String paramString)
  {
    StringBuilder localStringBuilder = paramStringBuilder.append('`').append(paramString).append('`');
  }

  public void appendEscapedWord(StringBuilder paramStringBuilder, String paramString)
  {
    StringBuilder localStringBuilder = paramStringBuilder.append('\'').append(paramString).append('\'');
  }

  public void appendLimitValue(StringBuilder paramStringBuilder, long paramLong, Long paramLong1)
  {
    StringBuilder localStringBuilder = paramStringBuilder.append("LIMIT ").append(paramLong).append(' ');
  }

  protected void appendLongStringType(StringBuilder paramStringBuilder, int paramInt)
  {
    StringBuilder localStringBuilder = paramStringBuilder.append("TEXT");
  }

  protected void appendLongType(FieldType paramFieldType, StringBuilder paramStringBuilder, int paramInt)
  {
    StringBuilder localStringBuilder = paramStringBuilder.append("BIGINT");
  }

  public void appendOffsetValue(StringBuilder paramStringBuilder, long paramLong)
  {
    StringBuilder localStringBuilder = paramStringBuilder.append("OFFSET ").append(paramLong).append(' ');
  }

  public void appendSelectNextValFromSequence(StringBuilder paramStringBuilder, String paramString)
  {
  }

  protected void appendSerializableType(StringBuilder paramStringBuilder, int paramInt)
  {
    StringBuilder localStringBuilder = paramStringBuilder.append("BLOB");
  }

  protected void appendShortType(StringBuilder paramStringBuilder, int paramInt)
  {
    StringBuilder localStringBuilder = paramStringBuilder.append("SMALLINT");
  }

  protected void appendStringType(StringBuilder paramStringBuilder, int paramInt)
  {
    if (isVarcharFieldWidthSupported())
    {
      StringBuilder localStringBuilder1 = paramStringBuilder.append("VARCHAR(").append(paramInt).append(")");
      return;
    }
    StringBuilder localStringBuilder2 = paramStringBuilder.append("VARCHAR");
  }

  protected void configureGeneratedId(String paramString, StringBuilder paramStringBuilder, FieldType paramFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("GeneratedId is not supported by database ");
    String str1 = getDatabaseName();
    String str2 = str1 + " for field " + paramFieldType;
    throw new IllegalStateException(str2);
  }

  protected void configureGeneratedIdSequence(StringBuilder paramStringBuilder, FieldType paramFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3)
    throws SQLException
  {
    StringBuilder localStringBuilder = new StringBuilder().append("GeneratedIdSequence is not supported by database ");
    String str1 = getDatabaseName();
    String str2 = str1 + " for field " + paramFieldType;
    throw new SQLException(str2);
  }

  protected void configureId(StringBuilder paramStringBuilder, FieldType paramFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3)
  {
  }

  public void dropColumnArg(FieldType paramFieldType, List<String> paramList1, List<String> paramList2)
  {
  }

  public <T> DatabaseTableConfig<T> extractDatabaseTableConfig(ConnectionSource paramConnectionSource, Class<T> paramClass)
    throws SQLException
  {
    return null;
  }

  public String generateIdSequenceName(String paramString, FieldType paramFieldType)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(paramString);
    String str1 = DEFAULT_SEQUENCE_SUFFIX;
    String str2 = str1;
    if (isEntityNamesMustBeUpCase())
      str2 = str2.toUpperCase();
    return str2;
  }

  protected boolean generatedIdSqlAtEnd()
  {
    return true;
  }

  public String getCommentLinePrefix()
  {
    return "-- ";
  }

  protected abstract String getDriverClassName();

  public FieldConverter getFieldConverter(DataPersister paramDataPersister)
  {
    return paramDataPersister;
  }

  public String getPingStatement()
  {
    return "SELECT 1";
  }

  public boolean isAllowGeneratedIdInsertSupported()
  {
    return true;
  }

  public boolean isBatchUseTransaction()
  {
    return false;
  }

  public boolean isCreateIfNotExistsSupported()
  {
    return false;
  }

  public boolean isCreateIndexIfNotExistsSupported()
  {
    return isCreateIfNotExistsSupported();
  }

  public boolean isCreateTableReturnsNegative()
  {
    return false;
  }

  public boolean isCreateTableReturnsZero()
  {
    return true;
  }

  public boolean isEntityNamesMustBeUpCase()
  {
    return false;
  }

  public boolean isIdSequenceNeeded()
  {
    return false;
  }

  public boolean isLimitAfterSelect()
  {
    return false;
  }

  public boolean isLimitSqlSupported()
  {
    return true;
  }

  public boolean isNestedSavePointsSupported()
  {
    return true;
  }

  public boolean isOffsetLimitArgument()
  {
    return false;
  }

  public boolean isOffsetSqlSupported()
  {
    return true;
  }

  public boolean isSelectSequenceBeforeInsert()
  {
    return false;
  }

  public boolean isTruncateSupported()
  {
    return false;
  }

  public boolean isVarcharFieldWidthSupported()
  {
    return true;
  }

  public void loadDriver()
    throws SQLException
  {
    String str1 = getDriverClassName();
    if (str1 == null)
      return;
    try
    {
      Class localClass = Class.forName(str1);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Driver class was not found for ");
      String str2 = getDatabaseName();
      throw SqlExceptionUtil.create(str2 + " database.  Missing jar with class " + str1 + ".", localClassNotFoundException);
    }
  }

  public void setDriver(Driver paramDriver)
  {
    this.driver = paramDriver;
  }

  protected static class BooleanNumberFieldConverter extends BaseFieldConverter
    implements FieldConverter
  {
    public SqlType getSqlType()
    {
      return SqlType.BOOLEAN;
    }

    public Object javaToSqlArg(FieldType paramFieldType, Object paramObject)
    {
      if (((Boolean)paramObject).booleanValue());
      for (Byte localByte = Byte.valueOf((byte)1); ; localByte = Byte.valueOf((byte)0))
        return localByte;
    }

    public Object parseDefaultString(FieldType paramFieldType, String paramString)
    {
      if (Boolean.parseBoolean(paramString));
      for (Byte localByte = Byte.valueOf((byte)1); ; localByte = Byte.valueOf((byte)0))
        return localByte;
    }

    public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
      throws SQLException
    {
      return Byte.valueOf(paramDatabaseResults.getByte(paramInt));
    }

    public Object sqlArgToJava(FieldType paramFieldType, Object paramObject, int paramInt)
    {
      if (((Byte)paramObject).byteValue() == 1);
      for (Boolean localBoolean = Boolean.valueOf(true); ; localBoolean = Boolean.valueOf(false))
        return localBoolean;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.db.BaseDatabaseType
 * JD-Core Version:    0.6.2
 */