package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

class CompositeValue
  implements Converter
{
  private final Context context;
  private final Entry entry;
  private final Traverser root;
  private final Style style;
  private final Type type;

  public CompositeValue(Context paramContext, Entry paramEntry, Type paramType)
    throws Exception
  {
    Traverser localTraverser = new Traverser(paramContext);
    this.root = localTraverser;
    Style localStyle = paramContext.getStyle();
    this.style = localStyle;
    this.context = paramContext;
    this.entry = paramEntry;
    this.type = paramType;
  }

  private boolean validate(InputNode paramInputNode, String paramString)
    throws Exception
  {
    boolean bool = true;
    String str = this.style.getElement(paramString);
    InputNode localInputNode = paramInputNode.getNext(str);
    Class localClass = this.type.getType();
    if (localInputNode == null);
    while (true)
    {
      return bool;
      if (!localInputNode.isEmpty())
        bool = this.root.validate(localInputNode, localClass);
    }
  }

  public Object read(InputNode paramInputNode)
    throws Exception
  {
    Object localObject = null;
    InputNode localInputNode = paramInputNode.getNext();
    Class localClass = this.type.getType();
    if (localInputNode == null);
    while (true)
    {
      return localObject;
      if (!localInputNode.isEmpty())
        localObject = this.root.read(localInputNode, localClass);
    }
  }

  public Object read(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    Class localClass = this.type.getType();
    if (paramObject != null)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localClass;
      Entry localEntry = this.entry;
      arrayOfObject[1] = localEntry;
      throw new PersistenceException("Can not read value of %s for %s", arrayOfObject);
    }
    return read(paramInputNode);
  }

  public boolean validate(InputNode paramInputNode)
    throws Exception
  {
    Class localClass = this.type.getType();
    String str = this.entry.getValue();
    if (str == null)
      str = this.context.getName(localClass);
    return validate(paramInputNode, str);
  }

  public void write(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    Class localClass = this.type.getType();
    String str1 = this.entry.getValue();
    if (str1 == null)
      str1 = this.context.getName(localClass);
    String str2 = this.style.getElement(str1);
    this.root.write(paramOutputNode, paramObject, localClass, str2);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.CompositeValue
 * JD-Core Version:    0.6.2
 */