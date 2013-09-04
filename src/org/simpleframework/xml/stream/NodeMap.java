package org.simpleframework.xml.stream;

import java.util.Iterator;

public abstract interface NodeMap<T extends Node> extends Iterable<String>
{
  public abstract T get(String paramString);

  public abstract String getName();

  public abstract T getNode();

  public abstract Iterator<String> iterator();

  public abstract T put(String paramString1, String paramString2);

  public abstract T remove(String paramString);
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.NodeMap
 * JD-Core Version:    0.6.2
 */