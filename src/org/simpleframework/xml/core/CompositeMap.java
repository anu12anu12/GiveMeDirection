package org.simpleframework.xml.core;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

class CompositeMap
  implements Converter
{
  private final Entry entry;
  private final MapFactory factory;
  private final Converter key;
  private final Style style;
  private final Converter value;

  public CompositeMap(Context paramContext, Entry paramEntry, Type paramType)
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

  private Object populate(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    Map localMap = (Map)paramObject;
    while (true)
    {
      InputNode localInputNode = paramInputNode.getNext();
      if (localInputNode == null)
        return localMap;
      Object localObject1 = this.key.read(localInputNode);
      Object localObject2 = this.value.read(localInputNode);
      Object localObject3 = localMap.put(localObject1, localObject2);
    }
  }

  private boolean validate(InputNode paramInputNode, Class paramClass)
    throws Exception
  {
    boolean bool = false;
    InputNode localInputNode = paramInputNode.getNext();
    if (localInputNode == null)
      bool = true;
    while (true)
    {
      return bool;
      if (this.key.validate(localInputNode))
        if (this.value.validate(localInputNode))
          break;
    }
  }

  public Object read(InputNode paramInputNode)
    throws Exception
  {
    Instance localInstance = this.factory.getInstance(paramInputNode);
    Object localObject = localInstance.getInstance();
    if (!localInstance.isReference())
      localObject = populate(paramInputNode, localObject);
    return localObject;
  }

  public Object read(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    Instance localInstance = this.factory.getInstance(paramInputNode);
    if (localInstance.isReference())
      paramObject = localInstance.getInstance();
    while (true)
    {
      return paramObject;
      Object localObject = localInstance.setInstance(paramObject);
      if (paramObject != null)
        paramObject = populate(paramInputNode, paramObject);
    }
  }

  public boolean validate(InputNode paramInputNode)
    throws Exception
  {
    Instance localInstance = this.factory.getInstance(paramInputNode);
    Class localClass;
    if (!localInstance.isReference())
    {
      Object localObject = localInstance.setInstance(null);
      localClass = localInstance.getType();
    }
    for (boolean bool = validate(paramInputNode, localClass); ; bool = true)
      return bool;
  }

  public void write(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    Map localMap = (Map)paramObject;
    Iterator localIterator = localMap.keySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Object localObject1 = localIterator.next();
      String str1 = this.entry.getEntry();
      String str2 = this.style.getElement(str1);
      OutputNode localOutputNode = paramOutputNode.getChild(str2);
      Object localObject2 = localMap.get(localObject1);
      this.key.write(localOutputNode, localObject1);
      this.value.write(localOutputNode, localObject2);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.CompositeMap
 * JD-Core Version:    0.6.2
 */