package org.simpleframework.xml.core;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.Mode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

class CompositeInlineMap
  implements Repeater
{
  private final Entry entry;
  private final MapFactory factory;
  private final Converter key;
  private final Style style;
  private final Converter value;

  public CompositeInlineMap(Context paramContext, Entry paramEntry, Type paramType)
    throws Exception
  {
    MapFactory localMapFactory = new MapFactory(paramContext, paramType);
    this.factory = localMapFactory;
    Converter localConverter1 = paramEntry.getValue(paramContext);
    this.value = localConverter1;
    Converter localConverter2 = paramEntry.getKey(paramContext);
    this.key = localConverter2;
    Style localStyle = paramContext.getStyle();
    this.style = localStyle;
    this.entry = paramEntry;
  }

  private Object read(InputNode paramInputNode, Map paramMap)
    throws Exception
  {
    InputNode localInputNode = paramInputNode.getParent();
    String str = paramInputNode.getName();
    while (paramInputNode != null)
    {
      Object localObject1 = this.key.read(paramInputNode);
      Object localObject2 = this.value.read(paramInputNode);
      if (paramMap != null)
        Object localObject3 = paramMap.put(localObject1, localObject2);
      paramInputNode = localInputNode.getNext(str);
    }
    return paramMap;
  }

  private void write(OutputNode paramOutputNode, Map paramMap, Mode paramMode)
    throws Exception
  {
    String str1 = this.entry.getEntry();
    String str2 = this.style.getElement(str1);
    Iterator localIterator = paramMap.keySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Object localObject1 = localIterator.next();
      OutputNode localOutputNode = paramOutputNode.getChild(str2);
      Object localObject2 = paramMap.get(localObject1);
      localOutputNode.setMode(paramMode);
      this.key.write(localOutputNode, localObject1);
      this.value.write(localOutputNode, localObject2);
    }
  }

  public Object read(InputNode paramInputNode)
    throws Exception
  {
    Map localMap = (Map)this.factory.getInstance();
    if (localMap != null);
    for (Object localObject = read(paramInputNode, localMap); ; localObject = null)
      return localObject;
  }

  public Object read(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    Map localMap = (Map)paramObject;
    if (localMap != null);
    for (Object localObject = read(paramInputNode, localMap); ; localObject = read(paramInputNode))
      return localObject;
  }

  public boolean validate(InputNode paramInputNode)
    throws Exception
  {
    boolean bool = false;
    InputNode localInputNode = paramInputNode.getParent();
    String str = paramInputNode.getName();
    if (paramInputNode != null)
      if (this.key.validate(paramInputNode));
    while (true)
    {
      return bool;
      if (this.value.validate(paramInputNode))
      {
        paramInputNode = localInputNode.getNext(str);
        break;
        bool = true;
      }
    }
  }

  public void write(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    OutputNode localOutputNode = paramOutputNode.getParent();
    Mode localMode = paramOutputNode.getMode();
    Map localMap = (Map)paramObject;
    if (!paramOutputNode.isCommitted())
      paramOutputNode.remove();
    write(localOutputNode, localMap, localMode);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.CompositeInlineMap
 * JD-Core Version:    0.6.2
 */