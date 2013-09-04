package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseMappedStatement<T, ID>
{
  protected static Logger logger = LoggerFactory.getLogger(BaseMappedStatement.class);
  protected final FieldType[] argFieldTypes;
  protected final Class<T> clazz;
  protected final FieldType idField;
  protected final String statement;
  protected final TableInfo<T, ID> tableInfo;

  protected BaseMappedStatement(TableInfo<T, ID> paramTableInfo, String paramString, FieldType[] paramArrayOfFieldType)
  {
    this.tableInfo = paramTableInfo;
    Class localClass = paramTableInfo.getDataClass();
    this.clazz = localClass;
    FieldType localFieldType = paramTableInfo.getIdField();
    this.idField = localFieldType;
    this.statement = paramString;
    this.argFieldTypes = paramArrayOfFieldType;
  }

  static void appendFieldColumnName(DatabaseType paramDatabaseType, StringBuilder paramStringBuilder, FieldType paramFieldType, List<FieldType> paramList)
  {
    String str = paramFieldType.getColumnName();
    paramDatabaseType.appendEscapedEntityName(paramStringBuilder, str);
    if (paramList != null)
      boolean bool = paramList.add(paramFieldType);
    StringBuilder localStringBuilder = paramStringBuilder.append(' ');
  }

  static void appendTableName(DatabaseType paramDatabaseType, StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    if (paramString1 != null)
      StringBuilder localStringBuilder1 = paramStringBuilder.append(paramString1);
    paramDatabaseType.appendEscapedEntityName(paramStringBuilder, paramString2);
    StringBuilder localStringBuilder2 = paramStringBuilder.append(' ');
  }

  static void appendWhereFieldEq(DatabaseType paramDatabaseType, FieldType paramFieldType, StringBuilder paramStringBuilder, List<FieldType> paramList)
  {
    StringBuilder localStringBuilder1 = paramStringBuilder.append("WHERE ");
    appendFieldColumnName(paramDatabaseType, paramStringBuilder, paramFieldType, paramList);
    StringBuilder localStringBuilder2 = paramStringBuilder.append("= ?");
  }

  protected Object convertIdToFieldObject(ID paramID)
    throws SQLException
  {
    return this.idField.convertJavaFieldToSqlArgValue(paramID);
  }

  protected Object[] getFieldObjects(Object paramObject)
    throws SQLException
  {
    Object[] arrayOfObject = new Object[this.argFieldTypes.length];
    int i = 0;
    int j = this.argFieldTypes.length;
    if (i < j)
    {
      FieldType localFieldType = this.argFieldTypes[i];
      if (localFieldType.isAllowGeneratedIdInsert())
      {
        Object localObject1 = localFieldType.getFieldValueIfNotDefault(paramObject);
        arrayOfObject[i] = localObject1;
      }
      while (true)
      {
        if ((arrayOfObject[i] == null) && (localFieldType.getDefaultValue() != null))
        {
          Object localObject2 = localFieldType.getDefaultValue();
          arrayOfObject[i] = localObject2;
        }
        i += 1;
        break;
        Object localObject3 = localFieldType.extractJavaFieldToSqlArgValue(paramObject);
        arrayOfObject[i] = localObject3;
      }
    }
    return arrayOfObject;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("MappedStatement: ");
    String str = this.statement;
    return str;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.mapped.BaseMappedStatement
 * JD-Core Version:    0.6.2
 */