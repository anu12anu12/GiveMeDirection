package com.j256.ormlite.stmt.query;

import com.j256.ormlite.field.FieldType;
import java.sql.SQLException;

public class SimpleComparison extends BaseComparison
{
  public static final String EQUAL_TO_OPERATION = "=";
  public static final String GREATER_THAN_EQUAL_TO_OPERATION = ">=";
  public static final String GREATER_THAN_OPERATION = ">";
  public static final String LESS_THAN_EQUAL_TO_OPERATION = "<=";
  public static final String LESS_THAN_OPERATION = "<";
  public static final String LIKE_OPERATION = "LIKE";
  public static final String NOT_EQUAL_TO_OPERATION = "<>";
  private final String operation;

  public SimpleComparison(String paramString1, FieldType paramFieldType, Object paramObject, String paramString2)
    throws SQLException
  {
    super(paramString1, paramFieldType, paramObject, true);
    this.operation = paramString2;
  }

  public void appendOperation(StringBuilder paramStringBuilder)
  {
    String str = this.operation;
    StringBuilder localStringBuilder1 = paramStringBuilder.append(str);
    StringBuilder localStringBuilder2 = paramStringBuilder.append(' ');
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.query.SimpleComparison
 * JD-Core Version:    0.6.2
 */