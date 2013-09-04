package org.simpleframework.xml.strategy;

import java.util.Map;
import org.simpleframework.xml.stream.NodeMap;

public class CycleStrategy
  implements Strategy
{
  private final Contract contract;
  private final ReadState read;
  private final WriteState write;

  public CycleStrategy()
  {
    this("id", "reference");
  }

  public CycleStrategy(String paramString1, String paramString2)
  {
    this(paramString1, paramString2, "class");
  }

  public CycleStrategy(String paramString1, String paramString2, String paramString3)
  {
    this(paramString1, paramString2, paramString3, "length");
  }

  public CycleStrategy(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Contract localContract1 = new Contract(paramString1, paramString2, paramString3, paramString4);
    this.contract = localContract1;
    Contract localContract2 = this.contract;
    WriteState localWriteState = new WriteState(localContract2);
    this.write = localWriteState;
    Contract localContract3 = this.contract;
    ReadState localReadState = new ReadState(localContract3);
    this.read = localReadState;
  }

  public Value read(Type paramType, NodeMap paramNodeMap, Map paramMap)
    throws Exception
  {
    ReadGraph localReadGraph = this.read.find(paramMap);
    if (localReadGraph != null);
    for (Value localValue = localReadGraph.read(paramType, paramNodeMap); ; localValue = null)
      return localValue;
  }

  public boolean write(Type paramType, Object paramObject, NodeMap paramNodeMap, Map paramMap)
  {
    WriteGraph localWriteGraph = this.write.find(paramMap);
    if (localWriteGraph != null);
    for (boolean bool = localWriteGraph.write(paramType, paramObject, paramNodeMap); ; bool = false)
      return bool;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.strategy.CycleStrategy
 * JD-Core Version:    0.6.2
 */