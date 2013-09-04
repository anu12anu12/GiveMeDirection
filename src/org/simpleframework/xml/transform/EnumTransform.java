package org.simpleframework.xml.transform;

class EnumTransform
  implements Transform<Enum>
{
  private final Class type;

  public EnumTransform(Class paramClass)
  {
    this.type = paramClass;
  }

  public Enum read(String paramString)
    throws Exception
  {
    return Enum.valueOf(this.type, paramString);
  }

  public String write(Enum paramEnum)
    throws Exception
  {
    return paramEnum.name();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.EnumTransform
 * JD-Core Version:    0.6.2
 */