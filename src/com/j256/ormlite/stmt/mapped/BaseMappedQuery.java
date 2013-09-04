package com.j256.ormlite.stmt.mapped;

import com.j256.ormlite.dao.BaseForeignCollection;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.GenericRowMapper;
import com.j256.ormlite.support.DatabaseResults;
import com.j256.ormlite.table.TableInfo;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseMappedQuery<T, ID> extends BaseMappedStatement<T, ID>
  implements GenericRowMapper<T>
{
  private Map<String, Integer> columnPositions = null;
  private Object parent = null;
  private Object parentId = null;
  protected final FieldType[] resultsFieldTypes;

  protected BaseMappedQuery(TableInfo<T, ID> paramTableInfo, String paramString, FieldType[] paramArrayOfFieldType1, FieldType[] paramArrayOfFieldType2)
  {
    super(paramTableInfo, paramString, paramArrayOfFieldType1);
    this.resultsFieldTypes = paramArrayOfFieldType2;
  }

  public T mapRow(DatabaseResults paramDatabaseResults)
    throws SQLException
  {
    Object localObject1;
    ObjectCache localObjectCache;
    Object localObject3;
    if (this.columnPositions == null)
    {
      localObject1 = new HashMap();
      localObjectCache = paramDatabaseResults.getObjectCache();
      if (localObjectCache == null)
        break label71;
      Object localObject2 = this.idField.resultToJava(paramDatabaseResults, (Map)localObject1);
      Class localClass1 = this.clazz;
      localObject3 = localObjectCache.get(localClass1, localObject2);
      if (localObject3 == null)
        break label71;
    }
    while (true)
    {
      return localObject3;
      localObject1 = this.columnPositions;
      break;
      label71: Object localObject4 = this.tableInfo.createObject();
      Object localObject5 = null;
      int i = 0;
      FieldType[] arrayOfFieldType = this.resultsFieldTypes;
      int j = arrayOfFieldType.length;
      int k = 0;
      while (k < j)
      {
        FieldType localFieldType1 = arrayOfFieldType[k];
        if (localFieldType1.isForeignCollection())
        {
          i = 1;
          k += 1;
        }
        else
        {
          Object localObject6 = localFieldType1.resultToJava(paramDatabaseResults, (Map)localObject1);
          if ((localObject6 != null) && (this.parent != null))
          {
            Class localClass2 = localFieldType1.getField().getType();
            Class localClass3 = this.parent.getClass();
            if (localClass2 == localClass3)
            {
              Object localObject7 = this.parentId;
              if (localObject6.equals(localObject7))
              {
                Object localObject8 = this.parent;
                localFieldType1.assignField(localObject4, localObject8, true, localObjectCache);
              }
            }
          }
          while (true)
          {
            FieldType localFieldType2 = this.idField;
            if (localFieldType1 != localFieldType2)
              break;
            Object localObject9 = localObject6;
            break;
            localFieldType1.assignField(localObject4, localObject6, false, localObjectCache);
          }
        }
      }
      if (i != 0)
      {
        arrayOfFieldType = this.resultsFieldTypes;
        j = arrayOfFieldType.length;
        k = 0;
        while (k < j)
        {
          FieldType localFieldType3 = arrayOfFieldType[k];
          if (localFieldType3.isForeignCollection())
          {
            BaseForeignCollection localBaseForeignCollection = localFieldType3.buildForeignCollection(localObject4, localObject5, false);
            if (localBaseForeignCollection != null)
              localFieldType3.assignField(localObject4, localBaseForeignCollection, false, localObjectCache);
          }
          k += 1;
        }
      }
      if ((localObjectCache != null) && (localObject5 != null))
      {
        Class localClass4 = this.clazz;
        localObjectCache.put(localClass4, localObject5, localObject4);
      }
      if (this.columnPositions == null)
        this.columnPositions = ((Map)localObject1);
      localObject3 = localObject4;
    }
  }

  public void setParentInformation(Object paramObject1, Object paramObject2)
  {
    this.parent = paramObject1;
    this.parentId = paramObject2;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.mapped.BaseMappedQuery
 * JD-Core Version:    0.6.2
 */