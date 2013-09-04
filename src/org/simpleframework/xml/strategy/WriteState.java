package org.simpleframework.xml.strategy;

import org.simpleframework.xml.util.WeakCache;

class WriteState extends WeakCache<WriteGraph>
{
  private Contract contract;

  public WriteState(Contract paramContract)
  {
    this.contract = paramContract;
  }

  public WriteGraph find(Object paramObject)
  {
    WriteGraph localWriteGraph = (WriteGraph)fetch(paramObject);
    if (localWriteGraph == null)
    {
      Contract localContract = this.contract;
      localWriteGraph = new WriteGraph(localContract);
      cache(paramObject, localWriteGraph);
    }
    return localWriteGraph;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.WriteState
 * JD-Core Version:    0.6.2
 */