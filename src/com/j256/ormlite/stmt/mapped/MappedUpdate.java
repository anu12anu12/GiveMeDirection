package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedUpdate<T, ID> extends BaseMappedStatement<T, ID>
{
  private final FieldType versionFieldType;
  private final int versionFieldTypeIndex;

  private MappedUpdate(TableInfo<T, ID> paramTableInfo, String paramString, FieldType[] paramArrayOfFieldType, FieldType paramFieldType, int paramInt)
  {
    super(paramTableInfo, paramString, paramArrayOfFieldType);
    this.versionFieldType = paramFieldType;
    this.versionFieldTypeIndex = paramInt;
  }

  public static <T, ID> MappedUpdate<T, ID> build(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo)
    throws SQLException
  {
    FieldType localFieldType1 = paramTableInfo.getIdField();
    if (localFieldType1 == null)
    {
      StringBuilder localStringBuilder1 = new StringBuilder().append("Cannot update ");
      Class localClass = paramTableInfo.getDataClass();
      String str1 = localClass + " because it doesn't have an id field";
      throw new SQLException(str1);
    }
    StringBuilder localStringBuilder2 = new StringBuilder(64);
    String str2 = paramTableInfo.getTableName();
    appendTableName(paramDatabaseType, localStringBuilder2, "UPDATE ", str2);
    int i = 1;
    int j = 0;
    Object localObject = null;
    int k = -1;
    FieldType[] arrayOfFieldType1 = paramTableInfo.getFieldTypes();
    int m = arrayOfFieldType1.length;
    int n = 0;
    while (n < m)
    {
      FieldType localFieldType2 = arrayOfFieldType1[n];
      if (isFieldUpdatable(localFieldType2, localFieldType1))
      {
        if (localFieldType2.isVersion())
        {
          localObject = localFieldType2;
          k = j;
        }
        j += 1;
      }
      n += 1;
    }
    int i1 = j + 1;
    if (localObject != null)
      i1 += 1;
    FieldType[] arrayOfFieldType2 = new FieldType[i1];
    FieldType[] arrayOfFieldType3 = paramTableInfo.getFieldTypes();
    int i2 = arrayOfFieldType3.length;
    int i3 = 0;
    int i4 = 0;
    while (i3 < i2)
    {
      FieldType localFieldType3 = arrayOfFieldType3[i3];
      int i5;
      if (!isFieldUpdatable(localFieldType3, localFieldType1))
      {
        i5 = i4;
        i3 += 1;
        i4 = i5;
      }
      else
      {
        if (i != 0)
        {
          StringBuilder localStringBuilder3 = localStringBuilder2.append("SET ");
          i = 0;
        }
        while (true)
        {
          appendFieldColumnName(paramDatabaseType, localStringBuilder2, localFieldType3, null);
          i5 = i4 + 1;
          arrayOfFieldType2[i4] = localFieldType3;
          StringBuilder localStringBuilder4 = localStringBuilder2.append("= ?");
          break;
          StringBuilder localStringBuilder5 = localStringBuilder2.append(", ");
        }
      }
    }
    StringBuilder localStringBuilder6 = localStringBuilder2.append(' ');
    appendWhereFieldEq(paramDatabaseType, localFieldType1, localStringBuilder2, null);
    int i6 = i4 + 1;
    arrayOfFieldType2[i4] = localFieldType1;
    if (localObject != null)
    {
      StringBuilder localStringBuilder7 = localStringBuilder2.append(" AND ");
      appendFieldColumnName(paramDatabaseType, localStringBuilder2, localObject, null);
      StringBuilder localStringBuilder8 = localStringBuilder2.append("= ?");
      int i7 = i6 + 1;
      arrayOfFieldType2[i6] = localObject;
      int i8 = i7;
    }
    String str3 = localStringBuilder2.toString();
    TableInfo<T, ID> localTableInfo = paramTableInfo;
    return new MappedUpdate(localTableInfo, str3, arrayOfFieldType2, localObject, k);
  }

  private static boolean isFieldUpdatable(FieldType paramFieldType1, FieldType paramFieldType2)
  {
    if ((paramFieldType1 == paramFieldType2) || (paramFieldType1.isForeignCollection()));
    for (boolean bool = false; ; bool = true)
      return bool;
  }

  public int update(DatabaseConnection paramDatabaseConnection, T paramT, ObjectCache paramObjectCache)
    throws SQLException
  {
    try
    {
      int i;
      if (this.argFieldTypes.length <= 1)
        i = 0;
      while (true)
      {
        return i;
        MappedUpdate localMappedUpdate = this;
        T ? = paramT;
        Object[] arrayOfObject = localMappedUpdate.getFieldObjects(?);
        Object localObject1 = null;
        if (this.versionFieldType != null)
        {
          FieldType localFieldType1 = this.versionFieldType;
          T ? = paramT;
          Object localObject2 = localFieldType1.extractJavaFieldValue(?);
          localObject1 = this.versionFieldType.moveToNextValue(localObject2);
          int j = this.versionFieldTypeIndex;
          Object localObject3 = this.versionFieldType.convertJavaFieldToSqlArgValue(localObject1);
          arrayOfObject[j] = localObject3;
        }
        String str1 = this.statement;
        FieldType[] arrayOfFieldType1 = this.argFieldTypes;
        i = paramDatabaseConnection.update(str1, arrayOfObject, arrayOfFieldType1);
        if (i > 0)
        {
          if (localObject1 != null)
          {
            FieldType localFieldType2 = this.versionFieldType;
            T ? = paramT;
            localFieldType2.assignField(?, localObject1, false, null);
          }
          if (paramObjectCache != null)
          {
            FieldType localFieldType3 = this.idField;
            T ? = paramT;
            Object localObject4 = localFieldType3.extractJavaFieldValue(?);
            Class localClass = this.clazz;
            Object localObject5 = paramObjectCache.get(localClass, localObject4);
            if (localObject5 != null)
            {
              T ? = paramT;
              if (localObject5 != ?)
              {
                FieldType[] arrayOfFieldType2 = this.tableInfo.getFieldTypes();
                int k = arrayOfFieldType2.length;
                int m = 0;
                while (m < k)
                {
                  FieldType localFieldType4 = arrayOfFieldType2[m];
                  FieldType localFieldType5 = this.idField;
                  if (localFieldType4 != localFieldType5)
                  {
                    T ? = paramT;
                    Object localObject6 = localFieldType4.extractJavaFieldValue(?);
                    ObjectCache localObjectCache = paramObjectCache;
                    localFieldType4.assignField(localObject5, localObject6, false, localObjectCache);
                  }
                  m += 1;
                }
              }
            }
          }
        }
        Logger localLogger = logger;
        String str2 = this.statement;
        Integer localInteger1 = Integer.valueOf(arrayOfObject.length);
        Integer localInteger2 = Integer.valueOf(i);
        localLogger.debug("update data with statement '{}' and {} args, changed {} rows", str2, localInteger1, localInteger2);
        if (arrayOfObject.length > 0)
          logger.trace("update arguments: {}", arrayOfObject);
      }
    }
    catch (SQLException localSQLException)
    {
      StringBuilder localStringBuilder1 = new StringBuilder().append("Unable to run update stmt on object ");
      T ? = paramT;
      StringBuilder localStringBuilder2 = localStringBuilder1.append(?).append(": ");
      String str3 = this.statement;
      throw SqlExceptionUtil.create(str3, localSQLException);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.mapped.MappedUpdate
 * JD-Core Version:    0.6.2
 */