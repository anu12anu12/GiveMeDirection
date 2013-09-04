package com.j256.ormlite.field.types;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;
import java.sql.SQLException;

public class CharacterObjectType extends BaseDataType
{
  private static final CharacterObjectType singleTon = new CharacterObjectType();

  private CharacterObjectType()
  {
    super(localSqlType, arrayOfClass);
  }

  protected CharacterObjectType(SqlType paramSqlType, Class<?>[] paramArrayOfClass)
  {
    super(paramSqlType, paramArrayOfClass);
  }

  public static CharacterObjectType getSingleton()
  {
    return singleTon;
  }

  public Object parseDefaultString(FieldType paramFieldType, String paramString)
    throws SQLException
  {
    if (paramString.length() != 1)
    {
      String str = "Problems with field " + paramFieldType + ", default string to long for Character: '" + paramString + "'";
      throw new SQLException(str);
    }
    return Character.valueOf(paramString.charAt(0));
  }

  public Object resultToSqlArg(FieldType paramFieldType, DatabaseResults paramDatabaseResults, int paramInt)
    throws SQLException
  {
    return Character.valueOf(paramDatabaseResults.getChar(paramInt));
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.field.types.CharacterObjectType
 * JD-Core Version:    0.6.2
 */