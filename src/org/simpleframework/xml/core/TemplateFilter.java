package org.simpleframework.xml.core;

import org.simpleframework.xml.filter.Filter;

class TemplateFilter
  implements Filter
{
  private Context context;
  private Filter filter;

  public TemplateFilter(Context paramContext, Filter paramFilter)
  {
    this.context = paramContext;
    this.filter = paramFilter;
  }

  public String replace(String paramString)
  {
    Object localObject = this.context.getAttribute(paramString);
    if (localObject != null);
    for (String str = localObject.toString(); ; str = this.filter.replace(paramString))
      return str;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.TemplateFilter
 * JD-Core Version:    0.6.2
 */