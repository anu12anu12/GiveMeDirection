package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

public class MappedDeleteCollection<T, ID> extends BaseMappedStatement<T, ID>
{
  private MappedDeleteCollection(TableInfo<T, ID> paramTableInfo, String paramString, FieldType[] paramArrayOfFieldType)
  {
    super(paramTableInfo, paramString, paramArrayOfFieldType);
  }

  private static void appendWhereIds(DatabaseType paramDatabaseType, FieldType paramFieldType, StringBuilder paramStringBuilder, int paramInt, FieldType[] paramArrayOfFieldType)
  {
    StringBuilder localStringBuilder1 = paramStringBuilder.append("WHERE ");
    String str = paramFieldType.getColumnName();
    paramDatabaseType.appendEscapedEntityName(paramStringBuilder, str);
    StringBuilder localStringBuilder2 = paramStringBuilder.append(" IN (");
    int i = 1;
    int j = 0;
    if (j < paramInt)
    {
      if (i != 0)
        i = 0;
      while (true)
      {
        StringBuilder localStringBuilder3 = paramStringBuilder.append('?');
        if (paramArrayOfFieldType != null)
          paramArrayOfFieldType[j] = paramFieldType;
        j += 1;
        break;
        StringBuilder localStringBuilder4 = paramStringBuilder.append(',');
      }
    }
    StringBuilder localStringBuilder5 = paramStringBuilder.append(") ");
  }

  private static <T, ID> MappedDeleteCollection<T, ID> build(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, int paramInt)
    throws SQLException
  {
    FieldType localFieldType = paramTableInfo.getIdField();
    if (localFieldType == null)
    {
      StringBuilder localStringBuilder1 = new StringBuilder().append("Cannot delete ");
      Class localClass = paramTableInfo.getDataClass();
      String str1 = localClass + " because it doesn't have an id field defined";
      throw new SQLException(str1);
    }
    StringBuilder localStringBuilder2 = new StringBuilder(128);
    String str2 = paramTableInfo.getTableName();
    appendTableName(paramDatabaseType, localStringBuilder2, "DELETE FROM ", str2);
    FieldType[] arrayOfFieldType = new FieldType[paramInt];
    appendWhereIds(paramDatabaseType, localFieldType, localStringBuilder2, paramInt, arrayOfFieldType);
    String str3 = localStringBuilder2.toString();
    return new MappedDeleteCollection(paramTableInfo, str3, arrayOfFieldType);
  }

  public static <T, ID> int deleteIds(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, DatabaseConnection paramDatabaseConnection, Collection<ID> paramCollection, ObjectCache paramObjectCache)
    throws SQLException
  {
    int i = paramCollection.size();
    MappedDeleteCollection localMappedDeleteCollection = build(paramDatabaseType, paramTableInfo, i);
    Object[] arrayOfObject = new Object[paramCollection.size()];
    FieldType localFieldType = paramTableInfo.getIdField();
    int j = 0;
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = localFieldType.convertJavaFieldToSqlArgValue(localObject1);
      arrayOfObject[j] = localObject2;
      j += 1;
    }
    Class localClass = paramTableInfo.getDataClass();
    return updateRows(paramDatabaseConnection, localClass, localMappedDeleteCollection, arrayOfObject, paramObjectCache);
  }

  public static <T, ID> int deleteObjects(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo, DatabaseConnection paramDatabaseConnection, Collection<T> paramCollection, ObjectCache paramObjectCache)
    throws SQLException
  {
    int i = paramCollection.size();
    MappedDeleteCollection localMappedDeleteCollection = build(paramDatabaseType, paramTableInfo, i);
    Object[] arrayOfObject = new Object[paramCollection.size()];
    FieldType localFieldType = paramTableInfo.getIdField();
    int j = 0;
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = localFieldType.extractJavaFieldToSqlArgValue(localObject1);
      arrayOfObject[j] = localObject2;
      j += 1;
    }
    Class localClass = paramTableInfo.getDataClass();
    return updateRows(paramDatabaseConnection, localClass, localMappedDeleteCollection, arrayOfObject, paramObjectCache);
  }

  private static <T, ID> int updateRows(DatabaseConnection paramDatabaseConnection, Class<T> paramClass, MappedDeleteCollection<T, ID> paramMappedDeleteCollection, Object[] paramArrayOfObject, ObjectCache paramObjectCache)
    throws SQLException
  {
    try
    {
      String str1 = paramMappedDeleteCollection.statement;
      FieldType[] arrayOfFieldType = paramMappedDeleteCollection.argFieldTypes;
      int i = paramDatabaseConnection.delete(str1, paramArrayOfObject, arrayOfFieldType);
      if ((i > 0) && (paramObjectCache != null))
      {
        Object[] arrayOfObject = paramArrayOfObject;
        int j = arrayOfObject.length;
        int k = 0;
        while (k < j)
        {
          Object localObject = arrayOfObject[k];
          paramObjectCache.remove(paramClass, localObject);
          k += 1;
        }
      }
      Logger localLogger = logger;
      String str2 = paramMappedDeleteCollection.statement;
      Integer localInteger1 = Integer.valueOf(paramArrayOfObject.length);
      Integer localInteger2 = Integer.valueOf(i);
      localLogger.debug("delete-collection with statement '{}' and {} args, changed {} rows", str2, localInteger1, localInteger2);
      if (paramArrayOfObject.length > 0)
        logger.trace("delete-collection arguments: {}", paramArrayOfObject);
      return i;
    }
    catch (SQLException localSQLException)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Unable to run delete collection stmt: ");
      String str3 = paramMappedDeleteCollection.statement;
      throw SqlExceptionUtil.create(str3, localSQLException);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.mapped.MappedDeleteCollection
 * JD-Core Version:    0.6.2
 */