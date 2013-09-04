package com.j256.ormlite.stmt.query;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.stmt.ArgumentHolder;
import com.j256.ormlite.stmt.SelectArg;
import java.sql.SQLException;
import java.util.List;

abstract class BaseComparison
  implements Comparison
{
  protected final String columnName;
  protected final FieldType fieldType;
  private final Object value;

  protected BaseComparison(String paramString, FieldType paramFieldType, Object paramObject, boolean paramBoolean)
    throws SQLException
  {
    if ((paramBoolean) && (paramFieldType != null) && (!paramFieldType.isComparable()))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Field '").append(paramString).append("' is of data type ");
      DataPersister localDataPersister = paramFieldType.getDataPersister();
      String str = localDataPersister + " which can not be compared";
      throw new SQLException(str);
    }
    this.columnName = paramString;
    this.fieldType = paramFieldType;
    this.value = paramObject;
  }

  protected void appendArgOrValue(DatabaseType paramDatabaseType, FieldType paramFieldType, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList, Object paramObject)
    throws SQLException
  {
    int i = 1;
    if (paramObject == null)
    {
      StringBuilder localStringBuilder1 = new StringBuilder().append("argument for '");
      String str1 = paramFieldType.getFieldName();
      String str2 = str1 + "' is null";
      throw new SQLException(str2);
    }
    if ((paramObject instanceof ArgumentHolder))
    {
      StringBuilder localStringBuilder2 = paramStringBuilder.append('?');
      ArgumentHolder localArgumentHolder = (ArgumentHolder)paramObject;
      String str3 = this.columnName;
      localArgumentHolder.setMetaInfo(str3, paramFieldType);
      boolean bool1 = paramList.add(localArgumentHolder);
    }
    while (true)
    {
      if (i == 0)
        return;
      StringBuilder localStringBuilder3 = paramStringBuilder.append(' ');
      return;
      if (paramFieldType.isArgumentHolderRequired())
      {
        StringBuilder localStringBuilder4 = paramStringBuilder.append('?');
        SelectArg localSelectArg = new SelectArg();
        String str4 = this.columnName;
        localSelectArg.setMetaInfo(str4, paramFieldType);
        localSelectArg.setValue(paramObject);
        boolean bool2 = paramList.add(localSelectArg);
      }
      else if (paramFieldType.isForeign())
      {
        Class localClass1 = paramFieldType.getType();
        Class localClass2 = paramObject.getClass();
        if (localClass1 == localClass2)
        {
          FieldType localFieldType = paramFieldType.getForeignIdField();
          Object localObject1 = localFieldType.extractJavaFieldValue(paramObject);
          BaseComparison localBaseComparison = this;
          DatabaseType localDatabaseType = paramDatabaseType;
          StringBuilder localStringBuilder5 = paramStringBuilder;
          List<ArgumentHolder> localList = paramList;
          localBaseComparison.appendArgOrValue(localDatabaseType, localFieldType, localStringBuilder5, localList, localObject1);
          i = 0;
        }
      }
      else if (paramFieldType.isEscapedValue())
      {
        String str5 = paramFieldType.convertJavaFieldToSqlArgValue(paramObject).toString();
        paramDatabaseType.appendEscapedWord(paramStringBuilder, str5);
      }
      else
      {
        Object localObject2 = paramFieldType.convertJavaFieldToSqlArgValue(paramObject);
        StringBuilder localStringBuilder6 = paramStringBuilder.append(localObject2);
      }
    }
  }

  public abstract void appendOperation(StringBuilder paramStringBuilder);

  public void appendSql(DatabaseType paramDatabaseType, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
    throws SQLException
  {
    String str = this.columnName;
    paramDatabaseType.appendEscapedEntityName(paramStringBuilder, str);
    StringBuilder localStringBuilder = paramStringBuilder.append(' ');
    appendOperation(paramStringBuilder);
    appendValue(paramDatabaseType, paramStringBuilder, paramList);
  }

  public void appendValue(DatabaseType paramDatabaseType, StringBuilder paramStringBuilder, List<ArgumentHolder> paramList)
    throws SQLException
  {
    FieldType localFieldType = this.fieldType;
    Object localObject = this.value;
    BaseComparison localBaseComparison = this;
    DatabaseType localDatabaseType = paramDatabaseType;
    StringBuilder localStringBuilder = paramStringBuilder;
    List<ArgumentHolder> localList = paramList;
    localBaseComparison.appendArgOrValue(localDatabaseType, localFieldType, localStringBuilder, localList, localObject);
  }

  public String getColumnName()
  {
    return this.columnName;
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str = this.columnName;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str).append(' ');
    appendOperation(localStringBuilder1);
    StringBuilder localStringBuilder3 = localStringBuilder1.append(' ');
    Object localObject = this.value;
    StringBuilder localStringBuilder4 = localStringBuilder1.append(localObject);
    return localStringBuilder1.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.query.BaseComparison
 * JD-Core Version:    0.6.2
 */