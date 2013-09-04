package org.simpleframework.xml.strategy;

import org.simpleframework.xml.util.WeakCache;

class ReadState extends WeakCache<ReadGraph>
{
  private final Contract contract;
  private final Loader loader;

  public ReadState(Contract paramContract)
  {
    Loader localLoader = new Loader();
    this.loader = localLoader;
    this.contract = paramContract;
  }

  private ReadGraph create(Object paramObject)
    throws Exception
  {
    ReadGraph localReadGraph = (ReadGraph)fetch(paramObject);
    if (localReadGraph == null)
    {
      Contract localContract = this.contract;
      Loader localLoader = this.loader;
      localReadGraph = new ReadGraph(localContract, localLoader);
      cache(paramObject, localReadGraph);
    }
    return localReadGraph;
  }

  public ReadGraph find(Object paramObject)
    throws Exception
  {
    ReadGraph localReadGraph = (ReadGraph)fetch(paramObject);
    if (localReadGraph != null);
    while (true)
    {
      return localReadGraph;
      localReadGraph = create(paramObject);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.ReadState
 * JD-Core Version:    0.6.2
 */