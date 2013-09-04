package org.simpleframework.xml.core;

abstract interface Creator
{
  public abstract Object getInstance()
    throws Exception;

  public abstract Object getInstance(Criteria paramCriteria)
    throws Exception;

  public abstract double getScore(Criteria paramCriteria)
    throws Exception;

  public abstract Signature getSignature()
    throws Exception;

  public abstract Class getType()
    throws Exception;
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Creator
 * JD-Core Version:    0.6.2
 */