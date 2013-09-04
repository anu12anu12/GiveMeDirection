package org.simpleframework.xml.transform;

class BooleanTransform
  implements Transform<Boolean>
{
  public Boolean read(String paramString)
  {
    return Boolean.valueOf(paramString);
  }

  public String write(Boolean paramBoolean)
  {
    return paramBoolean.toString();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.BooleanTransform
 * JD-Core Version:    0.6.2
 */