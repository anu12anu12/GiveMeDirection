package org.simpleframework.xml.transform;

class DoubleTransform
  implements Transform<Double>
{
  public Double read(String paramString)
  {
    return Double.valueOf(paramString);
  }

  public String write(Double paramDouble)
  {
    return paramDouble.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.DoubleTransform
 * JD-Core Version:    0.6.2
 */