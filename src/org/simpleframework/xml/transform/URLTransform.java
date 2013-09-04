package org.simpleframework.xml.transform;

import java.net.URL;

class URLTransform
  implements Transform<URL>
{
  public URL read(String paramString)
    throws Exception
  {
    return new URL(paramString);
  }

  public String write(URL paramURL)
    throws Exception
  {
    return paramURL.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.URLTransform
 * JD-Core Version:    0.6.2
 */