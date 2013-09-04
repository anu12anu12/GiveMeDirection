package com.j256.ormlite.dao;

import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.support.DatabaseResults;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class EagerForeignCollection<T, ID> extends BaseForeignCollection<T, ID>
  implements ForeignCollection<T>, CloseableWrappedIterable<T>, Serializable
{
  private static final long serialVersionUID = -2523335606983317721L;
  private List<T> results;

  public EagerForeignCollection(Dao<T, ID> paramDao, Object paramObject1, Object paramObject2, String paramString1, String paramString2)
    throws SQLException
  {
    super(paramDao, paramObject1, paramObject2, paramString1, paramString2);
    if (paramObject2 == null)
    {
      ArrayList localArrayList = new ArrayList();
      this.results = localArrayList;
      return;
    }
    PreparedQuery localPreparedQuery = getPreparedQuery();
    List localList = paramDao.query(localPreparedQuery);
    this.results = localList;
  }

  public boolean add(T paramT)
  {
    if (this.results.add(paramT));
    for (boolean bool = super.add(paramT); ; bool = false)
      return bool;
  }

  public boolean addAll(Collection<? extends T> paramCollection)
  {
    if (this.results.addAll(paramCollection));
    for (boolean bool = super.addAll(paramCollection); ; bool = false)
      return bool;
  }

  public void clear()
  {
    this.results.clear();
    super.clear();
  }

  public void close()
  {
  }

  public void closeLastIterator()
  {
  }

  public CloseableIterator<T> closeableIterator()
  {
    return iteratorThrow();
  }

  public boolean contains(Object paramObject)
  {
    return this.results.contains(paramObject);
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    return this.results.containsAll(paramCollection);
  }

  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof EagerForeignCollection));
    List localList1;
    List localList2;
    for (boolean bool = false; ; bool = localList1.equals(localList2))
    {
      return bool;
      EagerForeignCollection localEagerForeignCollection = (EagerForeignCollection)paramObject;
      localList1 = this.results;
      localList2 = localEagerForeignCollection.results;
    }
  }

  public CloseableWrappedIterable<T> getWrappedIterable()
  {
    return this;
  }

  public int hashCode()
  {
    return this.results.hashCode();
  }

  public boolean isEager()
  {
    return true;
  }

  public boolean isEmpty()
  {
    return this.results.isEmpty();
  }

  public CloseableIterator<T> iterator()
  {
    return iteratorThrow();
  }

  public CloseableIterator<T> iteratorThrow()
  {
    return new CloseableIterator()
    {
      private int offset = -1;

      public void close()
      {
      }

      public T current()
      {
        if (this.offset < 0)
          this.offset = 0;
        int i = this.offset;
        int j = EagerForeignCollection.this.results.size();
        if (i >= j);
        List localList;
        int k;
        for (Object localObject = null; ; localObject = localList.get(k))
        {
          return localObject;
          localList = EagerForeignCollection.this.results;
          k = this.offset;
        }
      }

      public T first()
      {
        this.offset = 0;
        int i = this.offset;
        int j = EagerForeignCollection.this.results.size();
        if (i >= j);
        for (Object localObject = null; ; localObject = EagerForeignCollection.this.results.get(0))
          return localObject;
      }

      public DatabaseResults getRawResults()
      {
        return null;
      }

      public boolean hasNext()
      {
        int i = this.offset + 1;
        int j = EagerForeignCollection.this.results.size();
        if (i < j);
        for (boolean bool = true; ; bool = false)
          return bool;
      }

      public T moveRelative(int paramAnonymousInt)
      {
        int i = this.offset + paramAnonymousInt;
        this.offset = i;
        if (this.offset >= 0)
        {
          int j = this.offset;
          int k = EagerForeignCollection.this.results.size();
          if (j < k)
            break label50;
        }
        label50: List localList;
        int m;
        for (Object localObject = null; ; localObject = localList.get(m))
        {
          return localObject;
          localList = EagerForeignCollection.this.results;
          m = this.offset;
        }
      }

      public void moveToNext()
      {
        int i = this.offset + 1;
        this.offset = i;
      }

      public T next()
      {
        int i = this.offset + 1;
        this.offset = i;
        List localList = EagerForeignCollection.this.results;
        int j = this.offset;
        return localList.get(j);
      }

      public T nextThrow()
      {
        int i = this.offset + 1;
        this.offset = i;
        int j = this.offset;
        int k = EagerForeignCollection.this.results.size();
        if (j >= k);
        List localList;
        int m;
        for (Object localObject = null; ; localObject = localList.get(m))
        {
          return localObject;
          localList = EagerForeignCollection.this.results;
          m = this.offset;
        }
      }

      public T previous()
      {
        int i = this.offset + -1;
        this.offset = i;
        if (this.offset >= 0)
        {
          int j = this.offset;
          int k = EagerForeignCollection.this.results.size();
          if (j < k)
            break label49;
        }
        label49: List localList;
        int m;
        for (Object localObject = null; ; localObject = localList.get(m))
        {
          return localObject;
          localList = EagerForeignCollection.this.results;
          m = this.offset;
        }
      }

      public void remove()
      {
        if (this.offset < 0)
          throw new IllegalStateException("next() must be called before remove()");
        int i = this.offset;
        int j = EagerForeignCollection.this.results.size();
        if (i >= j)
        {
          StringBuilder localStringBuilder = new StringBuilder().append("current results position (");
          int k = this.offset;
          String str = k + ") is out of bounds";
          throw new IllegalStateException(str);
        }
        List localList = EagerForeignCollection.this.results;
        int m = this.offset;
        Object localObject = localList.remove(m);
        if (EagerForeignCollection.this.dao == null)
          return;
        try
        {
          int n = EagerForeignCollection.this.dao.delete(localObject);
          return;
        }
        catch (SQLException localSQLException)
        {
          throw new RuntimeException(localSQLException);
        }
      }
    };
  }

  public int refreshAll()
    throws SQLException
  {
    int i = 0;
    Iterator localIterator = this.results.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      int j = this.dao.refresh(localObject);
      i += j;
    }
    return i;
  }

  public int refreshCollection()
    throws SQLException
  {
    Dao localDao = this.dao;
    PreparedQuery localPreparedQuery = getPreparedQuery();
    List localList = localDao.query(localPreparedQuery);
    this.results = localList;
    return this.results.size();
  }

  public boolean remove(Object paramObject)
  {
    boolean bool = true;
    if ((!this.results.remove(paramObject)) || (this.dao == null))
      bool = false;
    while (true)
    {
      return bool;
      Object localObject = paramObject;
      try
      {
        int i = this.dao.delete(localObject);
        if (i == 1)
          continue;
        bool = false;
      }
      catch (SQLException localSQLException)
      {
        throw new IllegalStateException("Could not delete data element from dao", localSQLException);
      }
    }
  }

  public boolean removeAll(Collection<?> paramCollection)
  {
    boolean bool = false;
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (remove(localObject))
        bool = true;
    }
    return bool;
  }

  public boolean retainAll(Collection<?> paramCollection)
  {
    return super.retainAll(paramCollection);
  }

  public int size()
  {
    return this.results.size();
  }

  public Object[] toArray()
  {
    return this.results.toArray();
  }

  public <E> E[] toArray(E[] paramArrayOfE)
  {
    return this.results.toArray(paramArrayOfE);
  }

  public int updateAll()
    throws SQLException
  {
    int i = 0;
    Iterator localIterator = this.results.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      int j = this.dao.update(localObject);
      i += j;
    }
    return i;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.dao.EagerForeignCollection
 * JD-Core Version:    0.6.2
 */