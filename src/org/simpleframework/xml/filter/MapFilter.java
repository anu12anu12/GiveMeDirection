package org.simpleframework.xml.filter;

import java.util.Map;

public class MapFilter
  implements Filter
{
  private Filter filter;
  private Map map;

  public MapFilter(Map paramMap)
  {
    this(paramMap, null);
  }

  public MapFilter(Map paramMap, Filter paramFilter)
  {
    this.filter = paramFilter;
    this.map = paramMap;
  }

  public String replace(String paramString)
  {
    Object localObject = null;
    if (this.map != null)
      localObject = this.map.get(paramString);
    String str;
    if (localObject != null)
      str = localObject.toString();
    while (true)
    {
      return str;
      if (this.filter != null)
        str = this.filter.replace(paramString);
      else
        str = null;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.filter.MapFilter
 * JD-Core Version:    0.6.2
 */