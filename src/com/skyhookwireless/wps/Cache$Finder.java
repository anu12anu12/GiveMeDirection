package com.skyhookwireless.wps;

import java.util.Iterator;
import java.util.Map.Entry;

public abstract interface Cache$Finder<K, V>
{
  public abstract Map.Entry<K, V> call(Iterator<Map.Entry<K, V>> paramIterator, K paramK);
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps.Cache.Finder
 * JD-Core Version:    0.6.2
 */