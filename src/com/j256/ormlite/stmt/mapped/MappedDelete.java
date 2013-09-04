package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedDelete<T, ID> extends BaseMappedStatement<T, ID>
{
  private MappedDelete(TableInfo<T, ID> paramTableInfo, String paramString, FieldType[] paramArrayOfFieldType)
  {
    super(paramTableInfo, paramString, paramArrayOfFieldType);
  }

  public static <T, ID> MappedDelete<T, ID> build(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo)
    throws SQLException
  {
    FieldType localFieldType = paramTableInfo.getIdField();
    if (localFieldType == null)
    {
      StringBuilder localStringBuilder1 = new StringBuilder().append("Cannot delete from ");
      Class localClass = paramTableInfo.getDataClass();
      String str1 = localClass + " because it doesn't have an id field";
      throw new SQLException(str1);
    }
    StringBuilder localStringBuilder2 = new StringBuilder(64);
    String str2 = paramTableInfo.getTableName();
    appendTableName(paramDatabaseType, localStringBuilder2, "DELETE FROM ", str2);
    appendWhereFieldEq(paramDatabaseType, localFieldType, localStringBuilder2, null);
    String str3 = localStringBuilder2.toString();
    FieldType[] arrayOfFieldType = new FieldType[1];
    arrayOfFieldType[0] = localFieldType;
    return new MappedDelete(paramTableInfo, str3, arrayOfFieldType);
  }

  public int delete(DatabaseConnection paramDatabaseConnection, T paramT, ObjectCache paramObjectCache)
    throws SQLException
  {
    try
    {
      Object[] arrayOfObject = getFieldObjects(paramT);
      String str1 = this.statement;
      FieldType[] arrayOfFieldType = this.argFieldTypes;
      int i = paramDatabaseConnection.delete(str1, arrayOfObject, arrayOfFieldType);
      Logger localLogger = logger;
      String str2 = this.statement;
      Integer localInteger1 = Integer.valueOf(arrayOfObject.length);
      Integer localInteger2 = Integer.valueOf(i);
      localLogger.debug("delete data with statement '{}' and {} args, changed {} rows", str2, localInteger1, localInteger2);
      if (arrayOfObject.length > 0)
        logger.trace("delete arguments: {}", arrayOfObject);
      if ((i > 0) && (paramObjectCache != null))
      {
        Object localObject = this.idField.extractJavaFieldToSqlArgValue(paramT);
        Class localClass = this.clazz;
        paramObjectCache.remove(localClass, localObject);
      }
      return i;
    }
    catch (SQLException localSQLException)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Unable to run delete stmt on object ").append(paramT).append(": ");
      String str3 = this.statement;
      throw SqlExceptionUtil.create(str3, localSQLException);
    }
  }

  public int deleteById(DatabaseConnection paramDatabaseConnection, ID paramID, ObjectCache paramObjectCache)
    throws SQLException
  {
    try
    {
      Object[] arrayOfObject = new Object[1];
      Object localObject = convertIdToFieldObject(paramID);
      arrayOfObject[0] = localObject;
      String str1 = this.statement;
      FieldType[] arrayOfFieldType = this.argFieldTypes;
      int i = paramDatabaseConnection.delete(str1, arrayOfObject, arrayOfFieldType);
      Logger localLogger = logger;
      String str2 = this.statement;
      Integer localInteger1 = Integer.valueOf(arrayOfObject.length);
      Integer localInteger2 = Integer.valueOf(i);
      localLogger.debug("delete data with statement '{}' and {} args, changed {} rows", str2, localInteger1, localInteger2);
      if (arrayOfObject.length > 0)
        logger.trace("delete arguments: {}", arrayOfObject);
      if ((i > 0) && (paramObjectCache != null))
      {
        Class localClass = this.clazz;
        paramObjectCache.remove(localClass, paramID);
      }
      return i;
    }
    catch (SQLException localSQLException)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Unable to run deleteById stmt on id ").append(paramID).append(": ");
      String str3 = this.statement;
      throw SqlExceptionUtil.create(str3, localSQLException);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.mapped.MappedDelete
 * JD-Core Version:    0.6.2
 */