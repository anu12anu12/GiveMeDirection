package org.simpleframework.xml.stream;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

class PrefixResolver extends LinkedHashMap<String, String>
  implements NamespaceMap
{
  private final OutputNode source;

  public PrefixResolver(OutputNode paramOutputNode)
  {
    this.source = paramOutputNode;
  }

  private String resolvePrefix(String paramString)
  {
    NamespaceMap localNamespaceMap = this.source.getNamespaces();
    String str;
    if (localNamespaceMap != null)
    {
      str = localNamespaceMap.getPrefix(paramString);
      if (containsValue(str));
    }
    while (true)
    {
      return str;
      str = null;
    }
  }

  private String resolveReference(String paramString)
  {
    NamespaceMap localNamespaceMap = this.source.getNamespaces();
    if (localNamespaceMap != null);
    for (String str = localNamespaceMap.getReference(paramString); ; str = null)
      return str;
  }

  public String getPrefix()
  {
    return this.source.getPrefix();
  }

  public String getPrefix(String paramString)
  {
    String str;
    if (size() > 0)
    {
      str = (String)get(paramString);
      if (str == null);
    }
    while (true)
    {
      return str;
      str = resolvePrefix(paramString);
    }
  }

  public String getReference(String paramString)
  {
    String str1;
    if (containsValue(paramString))
    {
      Iterator localIterator = iterator();
      String str2;
      do
      {
        if (!localIterator.hasNext())
          break;
        str1 = (String)localIterator.next();
        str2 = (String)get(str1);
      }
      while ((str2 == null) || (!str2.equals(paramString)));
    }
    while (true)
    {
      return str1;
      str1 = resolveReference(paramString);
    }
  }

  public Iterator<String> iterator()
  {
    return keySet().iterator();
  }

  public String setReference(String paramString)
  {
    return setReference(paramString, "");
  }

  public String setReference(String paramString1, String paramString2)
  {
    if (resolvePrefix(paramString1) != null);
    for (String str = null; ; str = (String)put(paramString1, paramString2))
      return str;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.PrefixResolver
 * JD-Core Version:    0.6.2
 */