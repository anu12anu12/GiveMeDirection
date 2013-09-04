package org.simpleframework.xml.stream;

import org.simpleframework.xml.util.Cache;
import org.simpleframework.xml.util.ConcurrentCache;

class Builder
  implements Style
{
  private final Cache<String> attributes;
  private final Cache<String> elements;
  private final Style style;

  public Builder(Style paramStyle)
  {
    ConcurrentCache localConcurrentCache1 = new ConcurrentCache();
    this.attributes = localConcurrentCache1;
    ConcurrentCache localConcurrentCache2 = new ConcurrentCache();
    this.elements = localConcurrentCache2;
    this.style = paramStyle;
  }

  public String getAttribute(String paramString)
  {
    String str1 = (String)this.attributes.fetch(paramString);
    if (str1 != null);
    for (String str2 = str1; ; str2 = str1)
    {
      return str2;
      str1 = this.style.getAttribute(paramString);
      if (str1 != null)
        this.attributes.cache(paramString, str1);
    }
  }

  public String getElement(String paramString)
  {
    String str1 = (String)this.elements.fetch(paramString);
    if (str1 != null);
    for (String str2 = str1; ; str2 = str1)
    {
      return str2;
      str1 = this.style.getElement(paramString);
      if (str1 != null)
        this.elements.cache(paramString, str1);
    }
  }

  public void setAttribute(String paramString1, String paramString2)
  {
    this.attributes.cache(paramString1, paramString2);
  }

  public void setElement(String paramString1, String paramString2)
  {
    this.elements.cache(paramString1, paramString2);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.Builder
 * JD-Core Version:    0.6.2
 */