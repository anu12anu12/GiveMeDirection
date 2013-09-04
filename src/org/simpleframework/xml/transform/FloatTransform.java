package org.simpleframework.xml.transform;

class FloatTransform
  implements Transform<Float>
{
  public Float read(String paramString)
  {
    return Float.valueOf(paramString);
  }

  public String write(Float paramFloat)
  {
    return paramFloat.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.FloatTransform
 * JD-Core Version:    0.6.2
 */