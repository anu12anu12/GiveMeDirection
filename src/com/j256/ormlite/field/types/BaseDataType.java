package com.j256.ormlite.field.types;

import com.j256.ormlite.field.BaseFieldConverter;
import com.j256.ormlite.field.DataPersister;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.lang.reflect.Field;
import java.sql.SQLException;

public abstract class BaseDataType extends BaseFieldConverter
  implements DataPersister
{
  private final Class<?>[] classes;
  private final SqlType sqlType;

  public BaseDataType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    this.sqlType = paramSqlType;
    this.classes = paramArrayOfClass;
  }

  public Object convertIdNumber(Number paramNumber)
  {
    return null;
  }

  public boolean dataIsEqual(Object paramObject1, Object paramObject2)
  {
    boolean bool = false;
    if (paramObject1 == null)
      if (paramObject2 == null)
        bool = true;
    while (true)
    {
      return bool;
      if (paramObject2 != null)
        bool = paramObject1.equals(paramObject2);
    }
  }

  public Object generateId()
  {
    throw new IllegalStateException("Should not have tried to generate this type");
  }

  public String[] getAssociatedClassNames()
  {
    return null;
  }

  public Class<?>[] getAssociatedClasses()
  {
    return this.classes;
  }

  public int getDefaultWidth()
  {
    return 0;
  }

  public SqlType getSqlType()
  {
    return this.sqlType;
  }

  public boolean isAppropriateId()
  {
    return true;
  }

  public boolean isArgumentHolderRequired()
  {
    return false;
  }

  public boolean isComparable()
  {
    return true;
  }

  public boolean isEscapedDefaultValue()
  {
    return isEscapedValue();
  }

  public boolean isEscapedValue()
  {
    return true;
  }

  public boolean isPrimitive()
  {
    return false;
  }

  public boolean isSelfGeneratedId()
  {
    return false;
  }

  public boolean isValidForField(Field paramField)
  {
    boolean bool = true;
    if (this.classes.length == 0);
    while (true)
    {
      return bool;
      Class[] arrayOfClass = this.classes;
      int i = arrayOfClass.length;
      int j = 0;
      while (true)
      {
        if (j >= i)
          break label62;
        Class localClass1 = arrayOfClass[j];
        Class localClass2 = paramField.getType();
        if (localClass1.isAssignableFrom(localClass2))
          break;
        j += 1;
      }
      label62: bool = false;
    }
  }

  public boolean isValidForVersion()
  {
    return false;
  }

  public boolean isValidGeneratedType()
  {
    return false;
  }

  public Object makeConfigObject(FieldType paramFieldType)
    throws SQLException
  {
    return null;
  }

  public Object moveToNextValue(Object paramObject)
  {
    return null;
  }

  public abstract Object parseDefaultString(FieldType paramFieldType, String paramString)
    throws SQLException;

  public abstract Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException;
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.field.types.BaseDataType
 * JD-Core Version:    0.6.2
 */