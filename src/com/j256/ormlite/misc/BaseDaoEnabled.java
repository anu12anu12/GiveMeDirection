package com.j256.ormlite.misc;

import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;

public abstract class BaseDaoEnabled<T, ID>
{
  protected transient Dao<T, ID> dao;

  private void checkForDao()
    throws SQLException
  {
    if (this.dao != null)
      return;
    StringBuilder localStringBuilder = new StringBuilder().append("Dao has not been set on ");
    Class localClass = getClass();
    String str = localClass + " object: " + this;
    throw new SQLException(str);
  }

  public int create()
    throws SQLException
  {
    checkForDao();
    BaseDaoEnabled localBaseDaoEnabled = this;
    return this.dao.create(localBaseDaoEnabled);
  }

  public int delete()
    throws SQLException
  {
    checkForDao();
    BaseDaoEnabled localBaseDaoEnabled = this;
    return this.dao.delete(localBaseDaoEnabled);
  }

  public ID extractId()
    throws SQLException
  {
    checkForDao();
    BaseDaoEnabled localBaseDaoEnabled = this;
    return this.dao.extractId(localBaseDaoEnabled);
  }

  public Dao<T, ID> getDao()
  {
    return this.dao;
  }

  public String objectToString()
  {
    try
    {
      checkForDao();
      BaseDaoEnabled localBaseDaoEnabled = this;
      return this.dao.objectToString(localBaseDaoEnabled);
    }
    catch (SQLException localSQLException)
    {
      throw new IllegalArgumentException(localSQLException);
    }
  }

  public boolean objectsEqual(T paramT)
    throws SQLException
  {
    checkForDao();
    BaseDaoEnabled localBaseDaoEnabled = this;
    return this.dao.objectsEqual(localBaseDaoEnabled, paramT);
  }

  public int refresh()
    throws SQLException
  {
    checkForDao();
    BaseDaoEnabled localBaseDaoEnabled = this;
    return this.dao.refresh(localBaseDaoEnabled);
  }

  public void setDao(Dao<T, ID> paramDao)
  {
    this.dao = paramDao;
  }

  public int update()
    throws SQLException
  {
    checkForDao();
    BaseDaoEnabled localBaseDaoEnabled = this;
    return this.dao.update(localBaseDaoEnabled);
  }

  public int updateId(ID paramID)
    throws SQLException
  {
    checkForDao();
    BaseDaoEnabled localBaseDaoEnabled = this;
    return this.dao.updateId(localBaseDaoEnabled, paramID);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.misc.BaseDaoEnabled
 * JD-Core Version:    0.6.2
 */