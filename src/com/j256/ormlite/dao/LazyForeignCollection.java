package com.j256.ormlite.dao;

import com.j256.ormlite.stmt.PreparedQuery;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LazyForeignCollection<T, ID> extends BaseForeignCollection<T, ID>
  implements ForeignCollection<T>, Serializable
{
  private static final long serialVersionUID = -5460708106909626233L;
  private transient CloseableIterator<T> lastIterator;

  public LazyForeignCollection(Dao<T, ID> paramDao, Object paramObject1, Object paramObject2, String paramString1, String paramString2)
  {
    super(paramDao, paramObject1, paramObject2, paramString1, paramString2);
  }

  public void closeLastIterator()
    throws SQLException
  {
    if (this.lastIterator == null)
      return;
    this.lastIterator.close();
    this.lastIterator = null;
  }

  public CloseableIterator<T> closeableIterator()
  {
    try
    {
      CloseableIterator localCloseableIterator = iteratorThrow();
      return localCloseableIterator;
    }
    catch (SQLException localSQLException)
    {
      StringBuilder localStringBuilder = new StringBuilder().append("Could not build lazy iterator for ");
      Class localClass = this.dao.getDataClass();
      String str = localClass;
      throw new IllegalStateException(str, localSQLException);
    }
  }

  // ERROR //
  public boolean contains(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 76	com/j256/ormlite/dao/LazyForeignCollection:iterator	()Lcom/j256/ormlite/dao/CloseableIterator;
    //   4: astore_2
    //   5: aload_2
    //   6: invokeinterface 80 1 0
    //   11: ifeq +30 -> 41
    //   14: aload_2
    //   15: invokeinterface 84 1 0
    //   20: aload_1
    //   21: invokevirtual 89	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   24: istore_3
    //   25: iload_3
    //   26: ifeq -21 -> 5
    //   29: iconst_1
    //   30: istore 4
    //   32: aload_2
    //   33: invokeinterface 34 1 0
    //   38: iload 4
    //   40: ireturn
    //   41: iconst_0
    //   42: istore 4
    //   44: aload_2
    //   45: invokeinterface 34 1 0
    //   50: goto -12 -> 38
    //   53: astore 5
    //   55: goto -17 -> 38
    //   58: astore 6
    //   60: aload_2
    //   61: invokeinterface 34 1 0
    //   66: aload 6
    //   68: athrow
    //   69: astore 7
    //   71: goto -33 -> 38
    //   74: astore 8
    //   76: goto -10 -> 66
    //
    // Exception table:
    //   from	to	target	type
    //   44	50	53	java/sql/SQLException
    //   5	25	58	finally
    //   32	38	69	java/sql/SQLException
    //   60	66	74	java/sql/SQLException
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    HashSet localHashSet = new HashSet(paramCollection);
    CloseableIterator localCloseableIterator = iterator();
    try
    {
      while (localCloseableIterator.hasNext())
      {
        Object localObject1 = localCloseableIterator.next();
        boolean bool1 = localHashSet.remove(localObject1);
      }
    }
    finally
    {
    }
    try
    {
      localCloseableIterator.close();
      label52: throw localObject2;
      boolean bool2 = localHashSet.isEmpty();
      boolean bool3 = bool2;
      try
      {
        localCloseableIterator.close();
        label73: return bool3;
      }
      catch (SQLException localSQLException1)
      {
        break label73;
      }
    }
    catch (SQLException localSQLException2)
    {
      break label52;
    }
  }

  public boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }

  public CloseableWrappedIterable<T> getWrappedIterable()
  {
    CloseableIterable local1 = new CloseableIterable()
    {
      public CloseableIterator<T> closeableIterator()
      {
        try
        {
          CloseableIterator localCloseableIterator = LazyForeignCollection.this.seperateIteratorThrow();
          return localCloseableIterator;
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder().append("Could not build lazy iterator for ");
          Class localClass = LazyForeignCollection.this.dao.getDataClass();
          String str = localClass;
          throw new IllegalStateException(str, localException);
        }
      }

      public CloseableIterator<T> iterator()
      {
        return closeableIterator();
      }
    };
    return new CloseableWrappedIterableImpl(local1);
  }

  public int hashCode()
  {
    return super.hashCode();
  }

  public boolean isEager()
  {
    return false;
  }

  // ERROR //
  public boolean isEmpty()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 76	com/j256/ormlite/dao/LazyForeignCollection:iterator	()Lcom/j256/ormlite/dao/CloseableIterator;
    //   4: astore_1
    //   5: aload_1
    //   6: invokeinterface 80 1 0
    //   11: istore_2
    //   12: iload_2
    //   13: ifne +13 -> 26
    //   16: iconst_1
    //   17: istore_3
    //   18: aload_1
    //   19: invokeinterface 34 1 0
    //   24: iload_3
    //   25: ireturn
    //   26: iconst_0
    //   27: istore_3
    //   28: goto -10 -> 18
    //   31: astore 4
    //   33: aload_1
    //   34: invokeinterface 34 1 0
    //   39: aload 4
    //   41: athrow
    //   42: astore 5
    //   44: goto -20 -> 24
    //   47: astore 6
    //   49: goto -10 -> 39
    //
    // Exception table:
    //   from	to	target	type
    //   5	12	31	finally
    //   18	24	42	java/sql/SQLException
    //   33	39	47	java/sql/SQLException
  }

  public CloseableIterator<T> iterator()
  {
    return closeableIterator();
  }

  public CloseableIterator<T> iteratorThrow()
    throws SQLException
  {
    CloseableIterator localCloseableIterator = seperateIteratorThrow();
    this.lastIterator = localCloseableIterator;
    return this.lastIterator;
  }

  public int refreshAll()
  {
    throw new UnsupportedOperationException("Cannot call updateAll() on a lazy collection.");
  }

  public int refreshCollection()
  {
    return 0;
  }

  // ERROR //
  public boolean remove(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 76	com/j256/ormlite/dao/LazyForeignCollection:iterator	()Lcom/j256/ormlite/dao/CloseableIterator;
    //   4: astore_2
    //   5: aload_2
    //   6: invokeinterface 80 1 0
    //   11: ifeq +32 -> 43
    //   14: aload_2
    //   15: invokeinterface 84 1 0
    //   20: aload_1
    //   21: invokevirtual 89	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   24: ifeq -19 -> 5
    //   27: aload_2
    //   28: invokeinterface 136 1 0
    //   33: iconst_1
    //   34: istore_3
    //   35: aload_2
    //   36: invokeinterface 34 1 0
    //   41: iload_3
    //   42: ireturn
    //   43: iconst_0
    //   44: istore_3
    //   45: aload_2
    //   46: invokeinterface 34 1 0
    //   51: goto -10 -> 41
    //   54: astore 4
    //   56: goto -15 -> 41
    //   59: astore 5
    //   61: aload_2
    //   62: invokeinterface 34 1 0
    //   67: aload 5
    //   69: athrow
    //   70: astore 6
    //   72: goto -31 -> 41
    //   75: astore 7
    //   77: goto -10 -> 67
    //
    // Exception table:
    //   from	to	target	type
    //   45	51	54	java/sql/SQLException
    //   5	33	59	finally
    //   35	41	70	java/sql/SQLException
    //   61	67	75	java/sql/SQLException
  }

  // ERROR //
  public boolean removeAll(Collection<?> paramCollection)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: invokevirtual 76	com/j256/ormlite/dao/LazyForeignCollection:iterator	()Lcom/j256/ormlite/dao/CloseableIterator;
    //   6: astore_3
    //   7: aload_3
    //   8: invokeinterface 80 1 0
    //   13: ifeq +33 -> 46
    //   16: aload_3
    //   17: invokeinterface 84 1 0
    //   22: astore 4
    //   24: aload_1
    //   25: aload 4
    //   27: invokeinterface 141 2 0
    //   32: ifeq -25 -> 7
    //   35: aload_3
    //   36: invokeinterface 136 1 0
    //   41: iconst_1
    //   42: istore_2
    //   43: goto -36 -> 7
    //   46: aload_3
    //   47: invokeinterface 34 1 0
    //   52: iload_2
    //   53: ireturn
    //   54: astore 5
    //   56: aload_3
    //   57: invokeinterface 34 1 0
    //   62: aload 5
    //   64: athrow
    //   65: astore 6
    //   67: goto -15 -> 52
    //   70: astore 7
    //   72: goto -10 -> 62
    //
    // Exception table:
    //   from	to	target	type
    //   7	41	54	finally
    //   46	52	65	java/sql/SQLException
    //   56	62	70	java/sql/SQLException
  }

  public CloseableIterator<T> seperateIteratorThrow()
    throws SQLException
  {
    if (this.dao == null)
      throw new IllegalStateException("Internal DAO object is null.  Lazy collections cannot be used if they have been deserialized.");
    Dao localDao = this.dao;
    PreparedQuery localPreparedQuery = getPreparedQuery();
    return localDao.iterator(localPreparedQuery);
  }

  // ERROR //
  public int size()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 76	com/j256/ormlite/dao/LazyForeignCollection:iterator	()Lcom/j256/ormlite/dao/CloseableIterator;
    //   4: astore_1
    //   5: iconst_0
    //   6: istore_2
    //   7: aload_1
    //   8: invokeinterface 80 1 0
    //   13: ifeq +16 -> 29
    //   16: aload_1
    //   17: invokeinterface 155 1 0
    //   22: iload_2
    //   23: iconst_1
    //   24: iadd
    //   25: istore_2
    //   26: goto -19 -> 7
    //   29: aload_1
    //   30: invokeinterface 34 1 0
    //   35: iload_2
    //   36: ireturn
    //   37: astore_3
    //   38: aload_1
    //   39: invokeinterface 34 1 0
    //   44: aload_3
    //   45: athrow
    //   46: astore 4
    //   48: goto -13 -> 35
    //   51: astore 5
    //   53: goto -9 -> 44
    //
    // Exception table:
    //   from	to	target	type
    //   7	22	37	finally
    //   29	35	46	java/sql/SQLException
    //   38	44	51	java/sql/SQLException
  }

  public Object[] toArray()
  {
    ArrayList localArrayList = new ArrayList();
    CloseableIterator localCloseableIterator = iterator();
    try
    {
      while (localCloseableIterator.hasNext())
      {
        Object localObject1 = localCloseableIterator.next();
        boolean bool = localArrayList.add(localObject1);
      }
    }
    finally
    {
    }
    try
    {
      localCloseableIterator.close();
      label49: throw localObject2;
      Object[] arrayOfObject1 = localArrayList.toArray();
      Object[] arrayOfObject2 = arrayOfObject1;
      try
      {
        localCloseableIterator.close();
        label70: return arrayOfObject2;
      }
      catch (SQLException localSQLException1)
      {
        break label70;
      }
    }
    catch (SQLException localSQLException2)
    {
      break label49;
    }
  }

  // ERROR //
  public <E> E[] toArray(E[] paramArrayOfE)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: invokevirtual 76	com/j256/ormlite/dao/LazyForeignCollection:iterator	()Lcom/j256/ormlite/dao/CloseableIterator;
    //   6: astore_3
    //   7: aconst_null
    //   8: astore 4
    //   10: aload_3
    //   11: invokeinterface 80 1 0
    //   16: ifeq +118 -> 134
    //   19: aload_3
    //   20: invokeinterface 84 1 0
    //   25: astore 5
    //   27: aload_1
    //   28: arraylength
    //   29: istore 6
    //   31: iload_2
    //   32: iload 6
    //   34: if_icmplt +88 -> 122
    //   37: aload 4
    //   39: ifnonnull +57 -> 96
    //   42: new 159	java/util/ArrayList
    //   45: dup
    //   46: invokespecial 160	java/util/ArrayList:<init>	()V
    //   49: astore 7
    //   51: aload_1
    //   52: astore 8
    //   54: aload 8
    //   56: arraylength
    //   57: istore 9
    //   59: iconst_0
    //   60: istore 10
    //   62: iload 10
    //   64: iload 9
    //   66: if_icmpge +34 -> 100
    //   69: aload 8
    //   71: iload 10
    //   73: aaload
    //   74: astore 11
    //   76: aload 7
    //   78: aload 11
    //   80: invokeinterface 165 2 0
    //   85: istore 12
    //   87: iload 10
    //   89: iconst_1
    //   90: iadd
    //   91: istore 10
    //   93: goto -31 -> 62
    //   96: aload 4
    //   98: astore 7
    //   100: aload 7
    //   102: aload 5
    //   104: invokeinterface 165 2 0
    //   109: istore 13
    //   111: iload_2
    //   112: iconst_1
    //   113: iadd
    //   114: istore_2
    //   115: aload 7
    //   117: astore 4
    //   119: goto -109 -> 10
    //   122: aload_1
    //   123: iload_2
    //   124: aload 5
    //   126: aastore
    //   127: aload 4
    //   129: astore 7
    //   131: goto -20 -> 111
    //   134: aload_3
    //   135: invokeinterface 34 1 0
    //   140: aload 4
    //   142: ifnonnull +37 -> 179
    //   145: aload_1
    //   146: arraylength
    //   147: bipush 255
    //   149: iadd
    //   150: istore 14
    //   152: iload_2
    //   153: iload 14
    //   155: if_icmpge +7 -> 162
    //   158: aload_1
    //   159: iload_2
    //   160: aconst_null
    //   161: aastore
    //   162: aload_1
    //   163: areturn
    //   164: astore 15
    //   166: aload 4
    //   168: astore 16
    //   170: aload_3
    //   171: invokeinterface 34 1 0
    //   176: aload 15
    //   178: athrow
    //   179: aload 4
    //   181: aload_1
    //   182: invokeinterface 170 2 0
    //   187: astore_1
    //   188: goto -26 -> 162
    //   191: astore 17
    //   193: goto -53 -> 140
    //   196: astore 18
    //   198: goto -22 -> 176
    //   201: astore 15
    //   203: goto -33 -> 170
    //
    // Exception table:
    //   from	to	target	type
    //   10	51	164	finally
    //   122	127	164	finally
    //   134	140	191	java/sql/SQLException
    //   170	176	196	java/sql/SQLException
    //   54	111	201	finally
  }

  public int updateAll()
  {
    throw new UnsupportedOperationException("Cannot call updateAll() on a lazy collection.");
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.dao.LazyForeignCollection
 * JD-Core Version:    0.6.2
 */