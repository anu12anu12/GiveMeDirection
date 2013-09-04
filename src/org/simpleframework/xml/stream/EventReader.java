package org.simpleframework.xml.stream;

abstract interface EventReader
{
  public abstract EventNode next()
    throws Exception;

  public abstract EventNode peek()
    throws Exception;
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.EventReader
 * JD-Core Version:    0.6.2
 */