package org.simpleframework.xml.filter;

import java.util.Map;

public class PlatformFilter extends StackFilter
{
  public PlatformFilter()
  {
    this(null);
  }

  public PlatformFilter(Map paramMap)
  {
    EnvironmentFilter localEnvironmentFilter = new EnvironmentFilter();
    push(localEnvironmentFilter);
    SystemFilter localSystemFilter = new SystemFilter();
    push(localSystemFilter);
    MapFilter localMapFilter = new MapFilter(paramMap);
    push(localMapFilter);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.filter.PlatformFilter
 * JD-Core Version:    0.6.2
 */