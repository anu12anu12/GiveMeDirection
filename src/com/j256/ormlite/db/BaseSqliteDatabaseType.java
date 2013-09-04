package com.j256.ormlite.db;

import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldConverter;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.BigDecimalStringType;
import java.util.List;

public abstract class BaseSqliteDatabaseType extends BaseDatabaseType
  implements DatabaseType
{
  private static final FieldConverter booleanConverter = new BaseDatabaseType.BooleanNumberFieldConverter();

  protected void appendLongType(FieldType paramFieldType, StringBuilder paramStringBuilder, int paramInt)
  {
    SqlType localSqlType1 = paramFieldType.getSqlType();
    SqlType localSqlType2 = SqlType.LONG;
    if ((localSqlType1 == localSqlType2) && (paramFieldType.isGeneratedId()))
    {
      StringBuilder localStringBuilder1 = paramStringBuilder.append("INTEGER");
      return;
    }
    StringBuilder localStringBuilder2 = paramStringBuilder.append("BIGINT");
  }

  protected void configureGeneratedId(String paramString, StringBuilder paramStringBuilder, FieldType paramFieldType, List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4)
  {
    SqlType localSqlType1 = paramFieldType.getSqlType();
    SqlType localSqlType2 = SqlType.INTEGER;
    if (localSqlType1 != localSqlType2)
    {
      SqlType localSqlType3 = paramFieldType.getSqlType();
      SqlType localSqlType4 = SqlType.LONG;
      if (localSqlType3 != localSqlType4)
        throw new IllegalArgumentException("Sqlite requires that auto-increment generated-id be integer or long type");
    }
    StringBuilder localStringBuilder = paramStringBuilder.append("PRIMARY KEY AUTOINCREMENT ");
  }

  protected boolean generatedIdSqlAtEnd()
  {
    return false;
  }

  public FieldConverter getFieldConverter(DataPersister paramDataPersister)
  {
    int[] arrayOfInt = 1.$SwitchMap$com$j256$ormlite$field$SqlType;
    int i = paramDataPersister.getSqlType().ordinal();
    Object localObject;
    switch (arrayOfInt[i])
    {
    default:
      localObject = super.getFieldConverter(paramDataPersister);
    case 1:
    case 2:
    }
    while (true)
    {
      return localObject;
      localObject = booleanConverter;
      continue;
      localObject = BigDecimalStringType.getSingleton();
    }
  }

  public boolean isCreateIfNotExistsSupported()
  {
    return true;
  }

  public boolean isCreateTableReturnsZero()
  {
    return false;
  }

  public boolean isVarcharFieldWidthSupported()
  {
    return false;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.db.BaseSqliteDatabaseType
 * JD-Core Version:    0.6.2
 */