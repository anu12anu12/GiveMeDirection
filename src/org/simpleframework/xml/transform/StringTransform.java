package org.simpleframework.xml.transform;

class StringTransform
  implements Transform<String>
{
  public String read(String paramString)
  {
    return paramString;
  }

  public String write(String paramString)
  {
    return paramString;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.StringTransform
 * JD-Core Version:    0.6.2
 */