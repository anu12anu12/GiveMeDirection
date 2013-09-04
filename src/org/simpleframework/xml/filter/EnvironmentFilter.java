package org.simpleframework.xml.filter;

public class EnvironmentFilter
  implements Filter
{
  private Filter filter;

  public EnvironmentFilter()
  {
    this(null);
  }

  public EnvironmentFilter(Filter paramFilter)
  {
    this.filter = paramFilter;
  }

  public String replace(String paramString)
  {
    String str = System.getenv(paramString);
    if (str != null);
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
 * Qualified Name:     org.simpleframework.xml.filter.EnvironmentFilter
 * JD-Core Version:    0.6.2
 */