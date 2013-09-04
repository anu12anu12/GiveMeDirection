package com.j256.ormlite.dao;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.stmt.mapped.MappedPreparedStmt;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

public abstract class BaseForeignCollection<T, ID>
  implements ForeignCollection<T>, Serializable
{
  private static final long serialVersionUID = -5158840898186237589L;
  private final transient String columnName;
  protected final transient Dao<T, ID> dao;
  private final transient String orderColumn;
  private final transient Object parent;
  private final transient Object parentId;
  private transient PreparedQuery<T> preparedQuery;

  protected BaseForeignCollection(Dao<T, ID> paramDao, Object paramObject1, Object paramObject2, String paramString1, String paramString2)
  {
    this.dao = paramDao;
    this.columnName = paramString1;
    this.parentId = paramObject2;
    this.orderColumn = paramString2;
    this.parent = paramObject1;
  }

  public boolean add(T paramT)
  {
    boolean bool;
    if (this.dao == null)
      bool = false;
    while (true)
    {
      return bool;
      try
      {
        int i = this.dao.create(paramT);
        bool = true;
      }
      catch (SQLException localSQLException)
      {
        throw new IllegalStateException("Could not create data element in dao", localSQLException);
      }
    }
  }

  public boolean addAll(Collection<? extends T> paramCollection)
  {
    if (this.dao == null)
    {
      bool = false;
      return bool;
    }
    boolean bool = false;
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      try
      {
        int i = this.dao.create(localObject);
        bool = true;
      }
      catch (SQLException localSQLException)
      {
        throw new IllegalStateException("Could not create data elements in dao", localSQLException);
      }
    }
  }

  // ERROR //
  public void clear()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 33	com/j256/ormlite/dao/BaseForeignCollection:dao	Lcom/j256/ormlite/dao/Dao;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: invokevirtual 83	com/j256/ormlite/dao/BaseForeignCollection:closeableIterator	()Lcom/j256/ormlite/dao/CloseableIterator;
    //   12: astore_1
    //   13: aload_1
    //   14: invokeinterface 86 1 0
    //   19: ifeq +28 -> 47
    //   22: aload_1
    //   23: invokeinterface 87 1 0
    //   28: astore_2
    //   29: aload_1
    //   30: invokeinterface 90 1 0
    //   35: goto -22 -> 13
    //   38: astore_3
    //   39: aload_1
    //   40: invokeinterface 93 1 0
    //   45: aload_3
    //   46: athrow
    //   47: aload_1
    //   48: invokeinterface 93 1 0
    //   53: return
    //   54: astore 4
    //   56: return
    //   57: astore 5
    //   59: goto -14 -> 45
    //
    // Exception table:
    //   from	to	target	type
    //   13	35	38	finally
    //   47	53	54	java/sql/SQLException
    //   39	45	57	java/sql/SQLException
  }

  protected PreparedQuery<T> getPreparedQuery()
    throws SQLException
  {
    if (this.dao == null);
    for (Object localObject1 = null; ; localObject1 = this.preparedQuery)
    {
      return localObject1;
      if (this.preparedQuery == null)
      {
        SelectArg localSelectArg = new SelectArg();
        Object localObject2 = this.parentId;
        localSelectArg.setValue(localObject2);
        QueryBuilder localQueryBuilder1 = this.dao.queryBuilder();
        if (this.orderColumn != null)
        {
          String str1 = this.orderColumn;
          QueryBuilder localQueryBuilder2 = localQueryBuilder1.orderBy(str1, true);
        }
        Where localWhere = localQueryBuilder1.where();
        String str2 = this.columnName;
        PreparedQuery localPreparedQuery = localWhere.eq(str2, localSelectArg).prepare();
        this.preparedQuery = localPreparedQuery;
        if ((this.preparedQuery instanceof MappedPreparedStmt))
        {
          MappedPreparedStmt localMappedPreparedStmt = (MappedPreparedStmt)this.preparedQuery;
          Object localObject3 = this.parent;
          Object localObject4 = this.parentId;
          localMappedPreparedStmt.setParentInformation(localObject3, localObject4);
        }
      }
    }
  }

  public int refresh(T paramT)
    throws SQLException
  {
    if (this.dao == null);
    for (int i = 0; ; i = this.dao.refresh(paramT))
      return i;
  }

  public abstract boolean remove(Object paramObject);

  public abstract boolean removeAll(Collection<?> paramCollection);

  // ERROR //
  public boolean retainAll(Collection<?> paramCollection)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 33	com/j256/ormlite/dao/BaseForeignCollection:dao	Lcom/j256/ormlite/dao/Dao;
    //   4: ifnonnull +7 -> 11
    //   7: iconst_0
    //   8: istore_2
    //   9: iload_2
    //   10: ireturn
    //   11: iconst_0
    //   12: istore_2
    //   13: aload_0
    //   14: invokevirtual 83	com/j256/ormlite/dao/BaseForeignCollection:closeableIterator	()Lcom/j256/ormlite/dao/CloseableIterator;
    //   17: astore_3
    //   18: aload_3
    //   19: invokeinterface 86 1 0
    //   24: ifeq +31 -> 55
    //   27: aload_3
    //   28: invokeinterface 87 1 0
    //   33: astore 4
    //   35: aload_1
    //   36: aload 4
    //   38: invokeinterface 141 2 0
    //   43: ifne -25 -> 18
    //   46: aload_3
    //   47: invokeinterface 90 1 0
    //   52: goto -34 -> 18
    //   55: aload_3
    //   56: invokeinterface 93 1 0
    //   61: goto -52 -> 9
    //   64: astore 5
    //   66: goto -57 -> 9
    //   69: astore 6
    //   71: aload_3
    //   72: invokeinterface 93 1 0
    //   77: aload 6
    //   79: athrow
    //   80: astore 7
    //   82: goto -5 -> 77
    //
    // Exception table:
    //   from	to	target	type
    //   55	61	64	java/sql/SQLException
    //   18	52	69	finally
    //   71	77	80	java/sql/SQLException
  }

  public int update(T paramT)
    throws SQLException
  {
    if (this.dao == null);
    for (int i = 0; ; i = this.dao.update(paramT))
      return i;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.dao.BaseForeignCollection
 * JD-Core Version:    0.6.2
 */