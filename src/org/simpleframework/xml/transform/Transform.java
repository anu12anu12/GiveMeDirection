package org.simpleframework.xml.transform;

public abstract interface Transform<T>
{
  public abstract T read(String paramString)
    throws Exception;

  public abstract String write(T paramT)
    throws Exception;
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.Transform
 * JD-Core Version:    0.6.2
 */