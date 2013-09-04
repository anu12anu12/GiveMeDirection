package org.simpleframework.xml.util;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Resolver<M extends Match> extends AbstractSet<M>
{
  protected final Resolver<M>.Cache cache;
  protected final Resolver<M>.Stack stack;

  public Resolver()
  {
    Stack localStack = new Stack(null);
    this.stack = localStack;
    Cache localCache = new Cache();
    this.cache = localCache;
  }

  private boolean match(char[] paramArrayOfChar1, int paramInt1, char[] paramArrayOfChar2, int paramInt2)
  {
    boolean bool = true;
    while (true)
    {
      int i = paramArrayOfChar2.length;
      if (paramInt2 < i)
      {
        int j = paramArrayOfChar1.length;
        if (paramInt1 < j)
          if (paramArrayOfChar2[paramInt2] == '*')
          {
            int k;
            do
            {
              if (paramArrayOfChar2[paramInt2] != '*')
                break;
              paramInt2 += 1;
              k = paramArrayOfChar2.length;
            }
            while (paramInt2 < k);
          }
      }
      label160: int i4;
      int i6;
      while (true)
      {
        return bool;
        if (paramArrayOfChar2[paramInt2] == '?')
        {
          paramInt2 += 1;
          int m = paramArrayOfChar2.length;
          if (paramInt2 >= m);
        }
        else
        {
          while (true)
          {
            int n = paramArrayOfChar1.length;
            if (paramInt1 >= n)
              break label160;
            int i1 = paramArrayOfChar1[paramInt1];
            int i2 = paramArrayOfChar2[paramInt2];
            if ((i1 == i2) || (paramArrayOfChar2[paramInt2] == '?'))
            {
              int i3 = paramInt2 + -1;
              if (paramArrayOfChar2[i3] == '?')
                break label160;
              if (match(paramArrayOfChar1, paramInt1, paramArrayOfChar2, paramInt2))
                break;
            }
            paramInt1 += 1;
          }
          if (paramArrayOfChar1.length != paramInt1)
          {
            bool = false;
          }
          else
          {
            i4 = paramInt1 + 1;
            int i5 = paramArrayOfChar1[paramInt1];
            i6 = paramInt2 + 1;
            int i7 = paramArrayOfChar2[paramInt2];
            if (i5 == i7)
              break;
            int i8 = i6 + -1;
            if (paramArrayOfChar2[i8] == '?')
              break;
            int i9 = i6;
            int i10 = i4;
            bool = false;
            continue;
            if (paramArrayOfChar2.length != paramInt2)
            {
              if (paramArrayOfChar1.length != paramInt1)
                bool = false;
            }
            else
            {
              while (true)
                if (paramArrayOfChar2[paramInt2] == '*')
                {
                  paramInt2 += 1;
                  int i11 = paramArrayOfChar2.length;
                  if (paramInt2 >= i11)
                    break;
                }
              bool = false;
            }
          }
        }
      }
      paramInt2 = i6;
      paramInt1 = i4;
    }
  }

  private boolean match(char[] paramArrayOfChar1, char[] paramArrayOfChar2)
  {
    return match(paramArrayOfChar1, 0, paramArrayOfChar2, 0);
  }

  private List<M> resolveAll(String paramString, char[] paramArrayOfChar)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.stack.iterator();
    while (localIterator.hasNext())
    {
      Match localMatch = (Match)localIterator.next();
      char[] arrayOfChar = localMatch.getPattern().toCharArray();
      if (match(paramArrayOfChar, arrayOfChar))
      {
        Object localObject = this.cache.put(paramString, localArrayList);
        boolean bool = localArrayList.add(localMatch);
      }
    }
    return localArrayList;
  }

  public boolean add(M paramM)
  {
    this.stack.push(paramM);
    return true;
  }

  public void clear()
  {
    this.cache.clear();
    this.stack.clear();
  }

  public Iterator<M> iterator()
  {
    return this.stack.sequence();
  }

  public boolean remove(M paramM)
  {
    this.cache.clear();
    return this.stack.remove(paramM);
  }

  public M resolve(String paramString)
  {
    List localList = (List)this.cache.get(paramString);
    if (localList == null)
      localList = resolveAll(paramString);
    if (localList.isEmpty());
    for (Object localObject = null; ; localObject = (Match)localList.get(0))
      return localObject;
  }

  public List<M> resolveAll(String paramString)
  {
    List localList = (List)this.cache.get(paramString);
    if (localList != null);
    while (true)
    {
      return localList;
      char[] arrayOfChar = paramString.toCharArray();
      if (arrayOfChar == null)
        localList = null;
      else
        localList = resolveAll(paramString, arrayOfChar);
    }
  }

  public int size()
  {
    return this.stack.size();
  }

  private class Stack extends LinkedList<M>
  {
    private Stack()
    {
    }

    public void purge(int paramInt)
    {
      Resolver.this.cache.clear();
      Object localObject = remove(paramInt);
    }

    public void push(M paramM)
    {
      Resolver.this.cache.clear();
      addFirst(paramM);
    }

    public Iterator<M> sequence()
    {
      return new Sequence();
    }

    private class Sequence
      implements Iterator<M>
    {
      private int cursor;

      public Sequence()
      {
        int i = Resolver.Stack.this.size();
        this.cursor = i;
      }

      public boolean hasNext()
      {
        if (this.cursor > 0);
        for (boolean bool = true; ; bool = false)
          return bool;
      }

      public M next()
      {
        Resolver.Stack localStack;
        int i;
        if (hasNext())
        {
          localStack = Resolver.Stack.this;
          i = this.cursor + -1;
          this.cursor = i;
        }
        for (Match localMatch = (Match)localStack.get(i); ; localMatch = null)
          return localMatch;
      }

      public void remove()
      {
        Resolver.Stack localStack = Resolver.Stack.this;
        int i = this.cursor;
        localStack.purge(i);
      }
    }
  }

  private class Cache extends LimitedCache<List<M>>
  {
    public Cache()
    {
      super();
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.util.Resolver
 * JD-Core Version:    0.6.2
 */