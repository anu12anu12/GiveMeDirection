package org.simpleframework.xml.core;

abstract interface Criteria extends Iterable<Object>
{
  public abstract void commit(Object paramObject)
    throws Exception;

  public abstract Variable get(Object paramObject)
    throws Exception;

  public abstract Variable get(Label paramLabel)
    throws Exception;

  public abstract Variable remove(Object paramObject)
    throws Exception;

  public abstract Variable resolve(String paramString)
    throws Exception;

  public abstract void set(Label paramLabel, Object paramObject)
    throws Exception;
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Criteria
 * JD-Core Version:    0.6.2
 */