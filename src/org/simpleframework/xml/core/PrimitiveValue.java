package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

class PrimitiveValue
  implements Converter
{
  private final Context context;
  private final Entry entry;
  private final PrimitiveFactory factory;
  private final Primitive root;
  private final Style style;
  private final Type type;

  public PrimitiveValue(Context paramContext, Entry paramEntry, Type paramType)
  {
    PrimitiveFactory localPrimitiveFactory = new PrimitiveFactory(paramContext, paramType);
    this.factory = localPrimitiveFactory;
    Primitive localPrimitive = new Primitive(paramContext, paramType);
    this.root = localPrimitive;
    Style localStyle = paramContext.getStyle();
    this.style = localStyle;
    this.context = paramContext;
    this.entry = paramEntry;
    this.type = paramType;
  }

  private boolean isOverridden(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    PrimitiveFactory localPrimitiveFactory = this.factory;
    Type localType = this.type;
    return localPrimitiveFactory.setOverride(localType, paramObject, paramOutputNode);
  }

  private Object readAttribute(InputNode paramInputNode, String paramString)
    throws Exception
  {
    if (paramString != null)
    {
      String str = this.style.getAttribute(paramString);
      paramInputNode = paramInputNode.getAttribute(str);
    }
    if (paramInputNode == null);
    for (Object localObject = null; ; localObject = this.root.read(paramInputNode))
      return localObject;
  }

  private Object readElement(InputNode paramInputNode, String paramString)
    throws Exception
  {
    String str = this.style.getAttribute(paramString);
    InputNode localInputNode = paramInputNode.getNext(str);
    if (localInputNode == null);
    for (Object localObject = null; ; localObject = this.root.read(localInputNode))
      return localObject;
  }

  private boolean validateAttribute(InputNode paramInputNode, String paramString)
    throws Exception
  {
    if (paramString != null)
    {
      String str = this.style.getAttribute(paramString);
      paramInputNode = paramInputNode.getNext(str);
    }
    if (paramInputNode == null);
    for (boolean bool = true; ; bool = this.root.validate(paramInputNode))
      return bool;
  }

  private boolean validateElement(InputNode paramInputNode, String paramString)
    throws Exception
  {
    String str = this.style.getAttribute(paramString);
    if (paramInputNode.getNext(str) == null);
    for (boolean bool = true; ; bool = this.root.validate(paramInputNode))
      return bool;
  }

  private void writeAttribute(OutputNode paramOutputNode, Object paramObject, String paramString)
    throws Exception
  {
    if (paramObject == null)
      return;
    if (paramString != null)
    {
      String str = this.style.getAttribute(paramString);
      paramOutputNode = paramOutputNode.setAttribute(str, null);
    }
    this.root.write(paramOutputNode, paramObject);
  }

  private void writeElement(OutputNode paramOutputNode, Object paramObject, String paramString)
    throws Exception
  {
    String str = this.style.getAttribute(paramString);
    OutputNode localOutputNode = paramOutputNode.getChild(str);
    if (paramObject == null)
      return;
    if (isOverridden(localOutputNode, paramObject))
      return;
    this.root.write(localOutputNode, paramObject);
  }

  public Object read(InputNode paramInputNode)
    throws Exception
  {
    Class localClass = this.type.getType();
    String str = this.entry.getValue();
    if (!this.entry.isInline())
      if (str == null)
        str = this.context.getName(localClass);
    for (Object localObject = readElement(paramInputNode, str); ; localObject = readAttribute(paramInputNode, str))
      return localObject;
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
    if (!this.entry.isInline())
      if (str == null)
        str = this.context.getName(localClass);
    for (boolean bool = validateElement(paramInputNode, str); ; bool = validateAttribute(paramInputNode, str))
      return bool;
  }

  public void write(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    Class localClass = this.type.getType();
    String str = this.entry.getValue();
    if (!this.entry.isInline())
    {
      if (str == null)
        str = this.context.getName(localClass);
      writeElement(paramOutputNode, paramObject, str);
      return;
    }
    writeAttribute(paramOutputNode, paramObject, str);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.PrimitiveValue
 * JD-Core Version:    0.6.2
 */