package org.simpleframework.xml.filter;

public class SystemFilter
  implements Filter
{
  private Filter filter;

  public SystemFilter()
  {
    this(null);
  }

  public SystemFilter(Filter paramFilter)
  {
    this.filter = paramFilter;
  }

  public String replace(String paramString)
  {
    String str = System.getProperty(paramString);
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
 * Qualified Name:     org.simpleframework.xml.filter.SystemFilter
 * JD-Core Version:    0.6.2
 */