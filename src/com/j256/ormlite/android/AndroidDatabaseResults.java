package com.j256.ormlite.android;

import android.database.Cursor;
import com.j256.ormlite.dao.ObjectCache;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.support.DatabaseResults;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AndroidDatabaseResults
  implements DatabaseResults
{
  private static final int MIN_NUM_COLUMN_NAMES_MAP = 8;
  private static final DatabaseType databaseType = new SqliteAndroidDatabaseType();
  private final Map<String, Integer> columnNameMap;
  private final String[] columnNames;
  private final Cursor cursor;
  private final ObjectCache objectCache;

  public AndroidDatabaseResults(Cursor paramCursor, ObjectCache paramObjectCache)
  {
    this.cursor = paramCursor;
    String[] arrayOfString = paramCursor.getColumnNames();
    this.columnNames = arrayOfString;
    if (this.columnNames.length >= 8)
    {
      HashMap localHashMap = new HashMap();
      this.columnNameMap = localHashMap;
      int i = 0;
      while (true)
      {
        int j = this.columnNames.length;
        if (i >= j)
          break;
        Map localMap = this.columnNameMap;
        String str = this.columnNames[i];
        Integer localInteger = Integer.valueOf(i);
        Object localObject = localMap.put(str, localInteger);
        i += 1;
      }
    }
    this.columnNameMap = null;
    this.objectCache = paramObjectCache;
  }

  @Deprecated
  public AndroidDatabaseResults(Cursor paramCursor, boolean paramBoolean, ObjectCache paramObjectCache)
  {
    this(paramCursor, paramObjectCache);
  }

  private int lookupColumn(String paramString)
  {
    int i;
    if (this.columnNameMap == null)
    {
      i = 0;
      int j = this.columnNames.length;
      if (i < j)
        if (!this.columnNames[i].equals(paramString));
    }
    while (true)
    {
      return i;
      i += 1;
      break;
      i = -1;
      continue;
      Integer localInteger = (Integer)this.columnNameMap.get(paramString);
      if (localInteger == null)
        i = -1;
      else
        i = localInteger.intValue();
    }
  }

  public int findColumn(String paramString)
    throws SQLException
  {
    int i = lookupColumn(paramString);
    if (i >= 0);
    for (int j = i; ; j = i)
    {
      return j;
      int k = paramString.length() + 4;
      StringBuilder localStringBuilder1 = new StringBuilder(k);
      databaseType.appendEscapedEntityName(localStringBuilder1, paramString);
      String str1 = localStringBuilder1.toString();
      i = lookupColumn(str1);
      if (i < 0)
        break;
    }
    String[] arrayOfString = this.cursor.getColumnNames();
    StringBuilder localStringBuilder2 = new StringBuilder().append("Unknown field '").append(paramString).append("' from the Android sqlite cursor, not in:");
    String str2 = Arrays.toString(arrayOfString);
    String str3 = str2;
    throw new SQLException(str3);
  }

  public boolean first()
  {
    return this.cursor.moveToFirst();
  }

  public BigDecimal getBigDecimal(int paramInt)
    throws SQLException
  {
    throw new SQLException("Android does not support BigDecimal type.  Use BIG_DECIMAL or BIG_DECIMAL_STRING types");
  }

  public InputStream getBlobStream(int paramInt)
  {
    byte[] arrayOfByte = this.cursor.getBlob(paramInt);
    return new ByteArrayInputStream(arrayOfByte);
  }

  public boolean getBoolean(int paramInt)
  {
    if ((this.cursor.isNull(paramInt)) || (this.cursor.getShort(paramInt) == null));
    for (boolean bool = false; ; bool = true)
      return bool;
  }

  public byte getByte(int paramInt)
  {
    return (byte)getShort(paramInt);
  }

  public byte[] getBytes(int paramInt)
  {
    return this.cursor.getBlob(paramInt);
  }

  public char getChar(int paramInt)
    throws SQLException
  {
    char c = '\000';
    String str1 = this.cursor.getString(paramInt);
    if ((str1 == null) || (str1.length() == 0));
    while (true)
    {
      return c;
      if (str1.length() != 1)
        break;
      c = str1.charAt(0);
    }
    String str2 = "More than 1 character stored in database column: " + paramInt;
    throw new SQLException(str2);
  }

  public int getColumnCount()
  {
    return this.cursor.getColumnCount();
  }

  public double getDouble(int paramInt)
  {
    return this.cursor.getDouble(paramInt);
  }

  public float getFloat(int paramInt)
  {
    return this.cursor.getFloat(paramInt);
  }

  public int getInt(int paramInt)
  {
    return this.cursor.getInt(paramInt);
  }

  public long getLong(int paramInt)
  {
    return this.cursor.getLong(paramInt);
  }

  public ObjectCache getObjectCache()
  {
    return this.objectCache;
  }

  public Cursor getRawCursor()
  {
    return this.cursor;
  }

  public short getShort(int paramInt)
  {
    return this.cursor.getShort(paramInt);
  }

  public String getString(int paramInt)
  {
    return this.cursor.getString(paramInt);
  }

  public Timestamp getTimestamp(int paramInt)
    throws SQLException
  {
    throw new SQLException("Android does not support timestamp.  Use JAVA_DATE_LONG or JAVA_DATE_STRING types");
  }

  public boolean moveRelative(int paramInt)
  {
    return this.cursor.move(paramInt);
  }

  public boolean next()
  {
    return this.cursor.moveToNext();
  }

  public boolean previous()
  {
    return this.cursor.moveToPrevious();
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = getClass().getSimpleName();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append("@");
    String str2 = Integer.toHexString(super.hashCode());
    return str2;
  }

  public boolean wasNull(int paramInt)
  {
    return this.cursor.isNull(paramInt);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.android.AndroidDatabaseResults
 * JD-Core Version:    0.6.2
 */