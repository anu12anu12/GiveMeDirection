package org.simpleframework.xml.transform;

class IntegerTransform
  implements Transform<Integer>
{
  public Integer read(String paramString)
  {
    return Integer.valueOf(paramString);
  }

  public String write(Integer paramInteger)
  {
    return paramInteger.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.IntegerTransform
 * JD-Core Version:    0.6.2
 */