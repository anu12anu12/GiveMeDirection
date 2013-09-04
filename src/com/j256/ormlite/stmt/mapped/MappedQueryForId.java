package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedQueryForId<T, ID> extends BaseMappedQuery<T, ID>
{
  private final String label;

  protected MappedQueryForId(TableInfo<T, ID> paramTableInfo, String paramString1, FieldType[] paramArrayOfFieldType1, FieldType[] paramArrayOfFieldType2, String paramString2)
  {
    super(paramTableInfo, paramString1, paramArrayOfFieldType1, paramArrayOfFieldType2);
    this.label = paramString2;
  }

  public static <T, ID> MappedQueryForId<T, ID> build(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, FieldType paramFieldType)
    throws SQLException
  {
    if (paramFieldType == null)
    {
      paramFieldType = paramTableInfo.getIdField();
      if (paramFieldType == null)
      {
        StringBuilder localStringBuilder = new StringBuilder().append("Cannot query-for-id with ");
        Class localClass = paramTableInfo.getDataClass();
        String str1 = localClass + " because it doesn't have an id field";
        throw new SQLException(str1);
      }
    }
    String str2 = buildStatement(paramDatabaseType, paramTableInfo, paramFieldType);
    FieldType[] arrayOfFieldType1 = new FieldType[1];
    arrayOfFieldType1[0] = paramFieldType;
    FieldType[] arrayOfFieldType2 = paramTableInfo.getFieldTypes();
    TableInfo<T, ID> localTableInfo = paramTableInfo;
    return new MappedQueryForId(localTableInfo, str2, arrayOfFieldType1, arrayOfFieldType2, "query-for-id");
  }

  protected static <T, ID> String buildStatement(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, FieldType paramFieldType)
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    String str = paramTableInfo.getTableName();
    appendTableName(paramDatabaseType, localStringBuilder, "SELECT * FROM ", str);
    appendWhereFieldEq(paramDatabaseType, paramFieldType, localStringBuilder, null);
    return localStringBuilder.toString();
  }

  private void logArgs(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length <= 0)
      return;
    Logger localLogger = logger;
    String str = this.label;
    localLogger.trace("{} arguments: {}", str, paramArrayOfObject);
  }

  public T execute(DatabaseConnection paramDatabaseConnection, ID paramID, ObjectCache paramObjectCache)
    throws SQLException
  {
    Object localObject1;
    if (paramObjectCache != null)
    {
      Class localClass = this.clazz;
      localObject1 = paramObjectCache.get(localClass, paramID);
      if (localObject1 != null)
        return localObject1;
    }
    Object[] arrayOfObject = new Object[1];
    Object localObject2 = convertIdToFieldObject(paramID);
    arrayOfObject[0] = localObject2;
    String str1 = this.statement;
    FieldType[] arrayOfFieldType = this.argFieldTypes;
    DatabaseConnection localDatabaseConnection = paramDatabaseConnection;
    MappedQueryForId localMappedQueryForId = this;
    ObjectCache localObjectCache = paramObjectCache;
    Object localObject3 = localDatabaseConnection.queryForOne(str1, arrayOfObject, arrayOfFieldType, localMappedQueryForId, localObjectCache);
    if (localObject3 == null)
    {
      Logger localLogger1 = logger;
      String str2 = this.label;
      String str3 = this.statement;
      Integer localInteger1 = Integer.valueOf(arrayOfObject.length);
      localLogger1.debug("{} using '{}' and {} args, got no results", str2, str3, localInteger1);
    }
    while (true)
    {
      logArgs(arrayOfObject);
      localObject1 = localObject3;
      break;
      Object localObject4 = DatabaseConnection.MORE_THAN_ONE;
      if (localObject3 == localObject4)
      {
        Logger localLogger2 = logger;
        String str4 = this.label;
        String str5 = this.statement;
        Integer localInteger2 = Integer.valueOf(arrayOfObject.length);
        localLogger2.error("{} using '{}' and {} args, got >1 results", str4, str5, localInteger2);
        logArgs(arrayOfObject);
        StringBuilder localStringBuilder1 = new StringBuilder();
        String str6 = this.label;
        StringBuilder localStringBuilder2 = localStringBuilder1.append(str6).append(" got more than 1 result: ");
        String str7 = this.statement;
        String str8 = str7;
        throw new SQLException(str8);
      }
      Logger localLogger3 = logger;
      String str9 = this.label;
      String str10 = this.statement;
      Integer localInteger3 = Integer.valueOf(arrayOfObject.length);
      localLogger3.debug("{} using '{}' and {} args, got 1 result", str9, str10, localInteger3);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.mapped.MappedQueryForId
 * JD-Core Version:    0.6.2
 */