package com.j256.ormlite.stmt.query;

public class OrderBy
{
  private final boolean ascending;
  private final String columnName;

  public OrderBy(String paramString, boolean paramBoolean)
  {
    this.columnName = paramString;
    this.ascending = paramBoolean;
  }

  public String getColumnName()
  {
    return this.columnName;
  }

  public boolean isAscending()
  {
    return this.ascending;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.stmt.query.OrderBy
 * JD-Core Version:    0.6.2
 */