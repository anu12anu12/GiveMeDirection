package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.logger.Log.Level;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.support.GeneratedKeyHolder;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedCreate<T, ID> extends BaseMappedStatement<T, ID>
{
  private String dataClassName;
  private final String queryNextSequenceStmt;
  private int versionFieldTypeIndex;

  private MappedCreate(TableInfo<T, ID> paramTableInfo, String paramString1, FieldType[] paramArrayOfFieldType, String paramString2, int paramInt)
  {
    super(paramTableInfo, paramString1, paramArrayOfFieldType);
    String str = paramTableInfo.getDataClass().getSimpleName();
    this.dataClassName = str;
    this.queryNextSequenceStmt = paramString2;
    this.versionFieldTypeIndex = paramInt;
  }

  private void assignIdValue(T paramT, Number paramNumber, String paramString, ObjectCache paramObjectCache)
    throws SQLException
  {
    Object localObject = this.idField.assignIdValue(paramT, paramNumber, paramObjectCache);
    Logger localLogger1 = logger;
    Log.Level localLevel = Log.Level.DEBUG;
    if (!localLogger1.isLevelEnabled(localLevel))
      return;
    Logger localLogger2 = logger;
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = paramNumber;
    arrayOfObject[1] = paramString;
    String str1 = this.idField.getFieldName();
    arrayOfObject[2] = str1;
    String str2 = this.dataClassName;
    arrayOfObject[3] = str2;
    localLogger2.debug("assigned id '{}' from {} to '{}' in {} object", arrayOfObject);
  }

  private void assignSequenceId(DatabaseConnection paramDatabaseConnection, T paramT, ObjectCache paramObjectCache)
    throws SQLException
  {
    String str1 = this.queryNextSequenceStmt;
    long l = paramDatabaseConnection.queryForLong(str1);
    Logger localLogger = logger;
    Long localLong1 = Long.valueOf(l);
    String str2 = this.queryNextSequenceStmt;
    localLogger.debug("queried for sequence {} using stmt: {}", localLong1, str2);
    if (l == 0L)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Should not have returned 0 for stmt: ");
      String str3 = this.queryNextSequenceStmt;
      String str4 = str3;
      throw new SQLException(str4);
    }
    Long localLong2 = Long.valueOf(l);
    assignIdValue(paramT, localLong2, "sequence", paramObjectCache);
  }

  public static <T, ID> MappedCreate<T, ID> build(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo)
  {
    StringBuilder localStringBuilder1 = new StringBuilder(128);
    String str1 = paramTableInfo.getTableName();
    appendTableName(paramDatabaseType, localStringBuilder1, "INSERT INTO ", str1);
    StringBuilder localStringBuilder2 = localStringBuilder1.append('(');
    int i = 0;
    int j = -1;
    FieldType[] arrayOfFieldType1 = paramTableInfo.getFieldTypes();
    int k = arrayOfFieldType1.length;
    int m = 0;
    while (m < k)
    {
      FieldType localFieldType1 = arrayOfFieldType1[m];
      if (isFieldCreatable(paramDatabaseType, localFieldType1))
      {
        if (localFieldType1.isVersion())
          j = i;
        i += 1;
      }
      m += 1;
    }
    FieldType[] arrayOfFieldType2 = new FieldType[i];
    int n = 1;
    FieldType[] arrayOfFieldType3 = paramTableInfo.getFieldTypes();
    int i1 = arrayOfFieldType3.length;
    int i2 = 0;
    int i3 = 0;
    while (i2 < i1)
    {
      FieldType localFieldType2 = arrayOfFieldType3[i2];
      int i4;
      if (!isFieldCreatable(paramDatabaseType, localFieldType2))
      {
        i4 = i3;
        i2 += 1;
        i3 = i4;
      }
      else
      {
        if (n != 0)
          n = 0;
        while (true)
        {
          appendFieldColumnName(paramDatabaseType, localStringBuilder1, localFieldType2, null);
          i4 = i3 + 1;
          arrayOfFieldType2[i3] = localFieldType2;
          break;
          StringBuilder localStringBuilder3 = localStringBuilder1.append(",");
        }
      }
    }
    StringBuilder localStringBuilder4 = localStringBuilder1.append(") VALUES (");
    int i5 = 1;
    FieldType[] arrayOfFieldType4 = paramTableInfo.getFieldTypes();
    int i6 = arrayOfFieldType4.length;
    int i7 = 0;
    while (i7 < i6)
    {
      FieldType localFieldType3 = arrayOfFieldType4[i7];
      if (!isFieldCreatable(paramDatabaseType, localFieldType3))
      {
        i7 += 1;
      }
      else
      {
        if (i5 != 0)
          i5 = 0;
        while (true)
        {
          StringBuilder localStringBuilder5 = localStringBuilder1.append("?");
          break;
          StringBuilder localStringBuilder6 = localStringBuilder1.append(",");
        }
      }
    }
    StringBuilder localStringBuilder7 = localStringBuilder1.append(")");
    FieldType localFieldType4 = paramTableInfo.getIdField();
    String str2 = buildQueryNextSequence(paramDatabaseType, localFieldType4);
    String str3 = localStringBuilder1.toString();
    TableInfo<T, ID> localTableInfo = paramTableInfo;
    return new MappedCreate(localTableInfo, str3, arrayOfFieldType2, str2, j);
  }

  private static String buildQueryNextSequence(DatabaseType paramDatabaseType, FieldType paramFieldType)
  {
    String str1 = null;
    if (paramFieldType == null);
    while (true)
    {
      return str1;
      String str2 = paramFieldType.getGeneratedIdSequence();
      if (str2 != null)
      {
        StringBuilder localStringBuilder = new StringBuilder(64);
        paramDatabaseType.appendSelectNextValFromSequence(localStringBuilder, str2);
        str1 = localStringBuilder.toString();
      }
    }
  }

  private boolean foreignCollectionsAreAssigned(FieldType[] paramArrayOfFieldType, Object paramObject)
    throws SQLException
  {
    FieldType[] arrayOfFieldType = paramArrayOfFieldType;
    int i = arrayOfFieldType.length;
    int j = 0;
    if (j < i)
      if (arrayOfFieldType[j].extractJavaFieldValue(paramObject) != null);
    for (boolean bool = false; ; bool = true)
    {
      return bool;
      j += 1;
      break;
    }
  }

  private static boolean isFieldCreatable(DatabaseType paramDatabaseType, FieldType paramFieldType)
  {
    boolean bool = false;
    if (paramFieldType.isForeignCollection());
    while (true)
    {
      return bool;
      if ((paramDatabaseType.isIdSequenceNeeded()) && (paramDatabaseType.isSelectSequenceBeforeInsert()))
        bool = true;
      else if ((!paramFieldType.isGeneratedId()) || (paramFieldType.isSelfGeneratedId()) || (paramFieldType.isAllowGeneratedIdInsert()))
        bool = true;
    }
  }

  public int insert(DatabaseType paramDatabaseType, DatabaseConnection paramDatabaseConnection, T paramT, ObjectCache paramObjectCache)
    throws SQLException
  {
    KeyHolder localKeyHolder = null;
    int i;
    if (this.idField != null)
    {
      if (!this.idField.isAllowGeneratedIdInsert())
        break label175;
      FieldType localFieldType1 = this.idField;
      T ? = paramT;
      if (localFieldType1.isObjectsFieldValueDefault(?))
        break label175;
      i = 0;
    }
    while (true)
    {
      if ((this.idField.isSelfGeneratedId()) && (this.idField.isGeneratedId()))
        if (i != 0)
        {
          FieldType localFieldType2 = this.idField;
          Object localObject1 = this.idField.generateId();
          FieldType localFieldType3 = localFieldType2;
          T ? = paramT;
          Object localObject2 = localObject1;
          boolean bool1 = false;
          ObjectCache localObjectCache1 = paramObjectCache;
          localFieldType3.assignField(?, localObject2, bool1, localObjectCache1);
        }
      try
      {
        label113: if (this.tableInfo.isForeignAutoCreate())
        {
          FieldType[] arrayOfFieldType1 = this.tableInfo.getFieldTypes();
          int j = arrayOfFieldType1.length;
          int k = 0;
          if (k < j)
          {
            FieldType localFieldType4 = arrayOfFieldType1[k];
            boolean bool2 = localFieldType4.isForeignAutoCreate();
            if (!bool2);
            while (true)
            {
              k += 1;
              break label140;
              i = 1;
              break;
              if ((this.idField.isGeneratedIdSequence()) && (paramDatabaseType.isSelectSequenceBeforeInsert()))
              {
                if (i == 0)
                  break label113;
                MappedCreate localMappedCreate1 = this;
                DatabaseConnection localDatabaseConnection1 = paramDatabaseConnection;
                T ? = paramT;
                ObjectCache localObjectCache2 = paramObjectCache;
                localMappedCreate1.assignSequenceId(localDatabaseConnection1, ?, localObjectCache2);
                break label113;
              }
              if ((!this.idField.isGeneratedId()) || (i == 0))
                break label113;
              Object local1 = null;
              localKeyHolder = new KeyHolder(local1);
              break label113;
              T ? = paramT;
              Object localObject3 = localFieldType4.extractRawJavaFieldValue(?);
              if ((localObject3 != null) && (localFieldType4.getForeignIdField().isObjectsFieldValueDefault(localObject3)))
                int m = localFieldType4.createWithForeignDao(localObject3);
            }
          }
        }
      }
      catch (SQLException localSQLException)
      {
        label140: label175: StringBuilder localStringBuilder1 = new StringBuilder().append("Unable to run insert stmt on object ");
        T ? = paramT;
        StringBuilder localStringBuilder2 = localStringBuilder1.append(?).append(": ");
        String str1 = this.statement;
        throw SqlExceptionUtil.create(str1, localSQLException);
      }
    }
    MappedCreate localMappedCreate2 = this;
    T ? = paramT;
    Object[] arrayOfObject = localMappedCreate2.getFieldObjects(?);
    Object localObject4 = null;
    if (this.versionFieldTypeIndex >= 0)
    {
      int n = this.versionFieldTypeIndex;
      if (arrayOfObject[n] == null)
      {
        FieldType[] arrayOfFieldType2 = this.argFieldTypes;
        int i1 = this.versionFieldTypeIndex;
        FieldType localFieldType5 = arrayOfFieldType2[i1];
        localObject4 = localFieldType5.moveToNextValue(null);
        int i2 = this.versionFieldTypeIndex;
        FieldType localFieldType6 = localFieldType5;
        Object localObject5 = localObject4;
        Object localObject6 = localFieldType6.convertJavaFieldToSqlArgValue(localObject5);
        arrayOfObject[i2] = localObject6;
      }
    }
    String str2 = this.statement;
    FieldType[] arrayOfFieldType3 = this.argFieldTypes;
    DatabaseConnection localDatabaseConnection2 = paramDatabaseConnection;
    String str3 = str2;
    FieldType[] arrayOfFieldType4 = arrayOfFieldType3;
    int i3 = localDatabaseConnection2.insert(str3, arrayOfObject, arrayOfFieldType4, localKeyHolder);
    Logger localLogger1 = logger;
    String str4 = this.statement;
    Integer localInteger1 = Integer.valueOf(arrayOfObject.length);
    Integer localInteger2 = Integer.valueOf(i3);
    localLogger1.debug("insert data with statement '{}' and {} args, changed {} rows", str4, localInteger1, localInteger2);
    if (arrayOfObject.length > 0)
    {
      Logger localLogger2 = logger;
      String str5 = "insert arguments: {}";
      localLogger2.trace(str5, arrayOfObject);
    }
    if (i3 > 0)
    {
      if (localObject4 != null)
      {
        FieldType[] arrayOfFieldType5 = this.argFieldTypes;
        int i4 = this.versionFieldTypeIndex;
        FieldType localFieldType7 = arrayOfFieldType5[i4];
        T ? = paramT;
        Object localObject7 = localObject4;
        boolean bool3 = false;
        ObjectCache localObjectCache3 = null;
        localFieldType7.assignField(?, localObject7, bool3, localObjectCache3);
      }
      if (localKeyHolder != null)
      {
        Number localNumber = localKeyHolder.getKey();
        if (localNumber == null)
          throw new SQLException("generated-id key was not set by the update call");
        if (localNumber.longValue() == 0L)
          throw new SQLException("generated-id key must not be 0 value");
        MappedCreate localMappedCreate3 = this;
        T ? = paramT;
        String str6 = "keyholder";
        ObjectCache localObjectCache4 = paramObjectCache;
        localMappedCreate3.assignIdValue(?, localNumber, str6, localObjectCache4);
      }
      if (paramObjectCache != null)
      {
        FieldType[] arrayOfFieldType6 = this.tableInfo.getForeignCollections();
        MappedCreate localMappedCreate4 = this;
        FieldType[] arrayOfFieldType7 = arrayOfFieldType6;
        T ? = paramT;
        if (localMappedCreate4.foreignCollectionsAreAssigned(arrayOfFieldType7, ?))
        {
          FieldType localFieldType8 = this.idField;
          T ? = paramT;
          Object localObject8 = localFieldType8.extractJavaFieldValue(?);
          Class localClass1 = this.clazz;
          ObjectCache localObjectCache5 = paramObjectCache;
          Class localClass2 = localClass1;
          T ? = paramT;
          localObjectCache5.put(localClass2, localObject8, ?);
        }
      }
    }
    return i3;
  }

  private static class KeyHolder
    implements GeneratedKeyHolder
  {
    Number key;

    public void addKey(Number paramNumber)
      throws SQLException
    {
      if (this.key == null)
      {
        this.key = paramNumber;
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder().append("generated key has already been set to ");
      Number localNumber = this.key;
      String str = localNumber + ", now set to " + paramNumber;
      throw new SQLException(str);
    }

    public Number getKey()
    {
      return this.key;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.mapped.MappedCreate
 * JD-Core Version:    0.6.2
 */