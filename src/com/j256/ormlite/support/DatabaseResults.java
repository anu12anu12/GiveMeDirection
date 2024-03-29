package com.j256.ormlite.support;

import com.j256.ormlite.dao.ObjectCache;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;

public abstract interface DatabaseResults
{
  public abstract int findColumn(String paramString)
    throws SQLException;

  public abstract boolean first()
    throws SQLException;

  public abstract BigDecimal getBigDecimal(int paramInt)
    throws SQLException;

  public abstract InputStream getBlobStream(int paramInt)
    throws SQLException;

  public abstract boolean getBoolean(int paramInt)
    throws SQLException;

  public abstract byte getByte(int paramInt)
    throws SQLException;

  public abstract byte[] getBytes(int paramInt)
    throws SQLException;

  public abstract char getChar(int paramInt)
    throws SQLException;

  public abstract int getColumnCount()
    throws SQLException;

  public abstract double getDouble(int paramInt)
    throws SQLException;

  public abstract float getFloat(int paramInt)
    throws SQLException;

  public abstract int getInt(int paramInt)
    throws SQLException;

  public abstract long getLong(int paramInt)
    throws SQLException;

  public abstract ObjectCache getObjectCache();

  public abstract short getShort(int paramInt)
    throws SQLException;

  public abstract String getString(int paramInt)
    throws SQLException;

  public abstract Timestamp getTimestamp(int paramInt)
    throws SQLException;

  public abstract boolean moveRelative(int paramInt)
    throws SQLException;

  public abstract boolean next()
    throws SQLException;

  public abstract boolean previous()
    throws SQLException;

  public abstract boolean wasNull(int paramInt)
    throws SQLException;
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.support.DatabaseResults
 * JD-Core Version:    0.6.2
 */