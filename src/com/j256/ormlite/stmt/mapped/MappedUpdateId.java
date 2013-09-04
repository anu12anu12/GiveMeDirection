package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedUpdateId<T, ID> extends BaseMappedStatement<T, ID>
{
  private MappedUpdateId(TableInfo<T, ID> paramTableInfo, String paramString, FieldType[] paramArrayOfFieldType)
  {
    super(paramTableInfo, paramString, paramArrayOfFieldType);
  }

  public static <T, ID> MappedUpdateId<T, ID> build(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo)
    throws SQLException
  {
    FieldType localFieldType = paramTableInfo.getIdField();
    if (localFieldType == null)
    {
      StringBuilder localStringBuilder1 = new StringBuilder().append("Cannot update-id in ");
      Class localClass = paramTableInfo.getDataClass();
      String str1 = localClass + " because it doesn't have an id field";
      throw new SQLException(str1);
    }
    StringBuilder localStringBuilder2 = new StringBuilder(64);
    String str2 = paramTableInfo.getTableName();
    appendTableName(paramDatabaseType, localStringBuilder2, "UPDATE ", str2);
    StringBuilder localStringBuilder3 = localStringBuilder2.append("SET ");
    appendFieldColumnName(paramDatabaseType, localStringBuilder2, localFieldType, null);
    StringBuilder localStringBuilder4 = localStringBuilder2.append("= ? ");
    appendWhereFieldEq(paramDatabaseType, localFieldType, localStringBuilder2, null);
    String str3 = localStringBuilder2.toString();
    FieldType[] arrayOfFieldType = new FieldType[2];
    arrayOfFieldType[0] = localFieldType;
    arrayOfFieldType[1] = localFieldType;
    return new MappedUpdateId(paramTableInfo, str3, arrayOfFieldType);
  }

  private Object extractIdToFieldObject(T paramT)
    throws SQLException
  {
    return this.idField.extractJavaFieldToSqlArgValue(paramT);
  }

  public int execute(DatabaseConnection paramDatabaseConnection, T paramT, ID paramID, ObjectCache paramObjectCache)
    throws SQLException
  {
    try
    {
      Object[] arrayOfObject = new Object[2];
      Object localObject1 = convertIdToFieldObject(paramID);
      arrayOfObject[0] = localObject1;
      Object localObject2 = extractIdToFieldObject(paramT);
      arrayOfObject[1] = localObject2;
      String str1 = this.statement;
      FieldType[] arrayOfFieldType = this.argFieldTypes;
      int i = paramDatabaseConnection.update(str1, arrayOfObject, arrayOfFieldType);
      if (i > 0)
      {
        if (paramObjectCache != null)
        {
          Object localObject3 = this.idField.extractJavaFieldValue(paramT);
          Class localClass = this.clazz;
          Object localObject4 = paramObjectCache.updateId(localClass, localObject3, paramID);
          if ((localObject4 != null) && (localObject4 != paramT))
            this.idField.assignField(localObject4, paramID, false, paramObjectCache);
        }
        this.idField.assignField(paramT, paramID, false, paramObjectCache);
      }
      Logger localLogger = logger;
      String str2 = this.statement;
      Integer localInteger1 = Integer.valueOf(arrayOfObject.length);
      Integer localInteger2 = Integer.valueOf(i);
      localLogger.debug("updating-id with statement '{}' and {} args, changed {} rows", str2, localInteger1, localInteger2);
      if (arrayOfObject.length > 0)
        logger.trace("updating-id arguments: {}", arrayOfObject);
      return i;
    }
    catch (SQLException localSQLException)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Unable to run update-id stmt on object ").append(paramT).append(": ");
      String str3 = this.statement;
      throw SqlExceptionUtil.create(str3, localSQLException);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.mapped.MappedUpdateId
 * JD-Core Version:    0.6.2
 */