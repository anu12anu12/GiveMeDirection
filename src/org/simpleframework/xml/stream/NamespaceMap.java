package org.simpleframework.xml.stream;

import java.util.Iterator;

public abstract interface NamespaceMap extends Iterable<String>
{
  public abstract String getPrefix();

  public abstract String getPrefix(String paramString);

  public abstract String getReference(String paramString);

  public abstract Iterator<String> iterator();

  public abstract String setReference(String paramString);

  public abstract String setReference(String paramString1, String paramString2);
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.NamespaceMap
 * JD-Core Version:    0.6.2
 */