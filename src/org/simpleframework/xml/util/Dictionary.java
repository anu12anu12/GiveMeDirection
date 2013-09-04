package org.simpleframework.xml.util;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class Dictionary<T extends Entry> extends AbstractSet<T>
{
  protected final Table<T> map;

  public Dictionary()
  {
    Table localTable = new Table();
    this.map = localTable;
  }

  public boolean add(T paramT)
  {
    Table localTable = this.map;
    String str = paramT.getName();
    if (localTable.put(str, paramT) != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public T get(String paramString)
  {
    return (Entry)this.map.get(paramString);
  }

  public Iterator<T> iterator()
  {
    return this.map.values().iterator();
  }

  public T remove(String paramString)
  {
    return (Entry)this.map.remove(paramString);
  }

  public int size()
  {
    return this.map.size();
  }

  private static class Table<T> extends HashMap<String, T>
  {
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.util.Dictionary
 * JD-Core Version:    0.6.2
 */