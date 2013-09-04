package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.support.DatabaseConnection;
import com.j256.ormlite.table.TableInfo;
import java.sql.SQLException;

public class MappedRefresh<T, ID> extends MappedQueryForId<T, ID>
{
  private MappedRefresh(TableInfo<T, ID> paramTableInfo, String paramString, FieldType[] paramArrayOfFieldType1, FieldType[] paramArrayOfFieldType2)
  {
  }

  public static <T, ID> MappedRefresh<T, ID> build(DatabaseType paramDatabaseType, TableInfo<T, ID> paramTableInfo)
    throws SQLException
  {
    FieldType localFieldType1 = paramTableInfo.getIdField();
    if (localFieldType1 == null)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Cannot refresh ");
      Class localClass = paramTableInfo.getDataClass();
      String str1 = localClass + " because it doesn't have an id field";
      throw new SQLException(str1);
    }
    String str2 = buildStatement(paramDatabaseType, paramTableInfo, localFieldType1);
    FieldType[] arrayOfFieldType1 = new FieldType[1];
    FieldType localFieldType2 = paramTableInfo.getIdField();
    arrayOfFieldType1[0] = localFieldType2;
    FieldType[] arrayOfFieldType2 = paramTableInfo.getFieldTypes();
    return new MappedRefresh(paramTableInfo, str2, arrayOfFieldType1, arrayOfFieldType2);
  }

  public int executeRefresh(DatabaseConnection paramDatabaseConnection, T paramT, ObjectCache paramObjectCache)
    throws SQLException
  {
    int i = 0;
    Object localObject1 = this.idField.extractJavaFieldValue(paramT);
    Object localObject2 = super.execute(paramDatabaseConnection, localObject1, null);
    if (localObject2 == null);
    while (true)
    {
      return i;
      FieldType[] arrayOfFieldType = this.resultsFieldTypes;
      int j = arrayOfFieldType.length;
      int k = 0;
      while (k < j)
      {
        FieldType localFieldType1 = arrayOfFieldType[k];
        FieldType localFieldType2 = this.idField;
        if (localFieldType1 != localFieldType2)
        {
          Object localObject3 = localFieldType1.extractJavaFieldValue(localObject2);
          localFieldType1.assignField(paramT, localObject3, false, paramObjectCache);
        }
        k += 1;
      }
      i = 1;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.mapped.MappedRefresh
 * JD-Core Version:    0.6.2
 */