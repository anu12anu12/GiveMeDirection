package org.simpleframework.xml.transform;

class ShortTransform
  implements Transform<Short>
{
  public Short read(String paramString)
  {
    return Short.valueOf(paramString);
  }

  public String write(Short paramShort)
  {
    return paramShort.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.ShortTransform
 * JD-Core Version:    0.6.2
 */