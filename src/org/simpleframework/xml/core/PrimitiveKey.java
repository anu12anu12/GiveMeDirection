package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

class PrimitiveKey
  implements Converter
{
  private final Context context;
  private final Entry entry;
  private final PrimitiveFactory factory;
  private final Primitive root;
  private final Style style;
  private final Type type;

  public PrimitiveKey(Context paramContext, Entry paramEntry, Type paramType)
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
    String str = this.style.getAttribute(paramString);
    InputNode localInputNode = paramInputNode.getAttribute(str);
    if (localInputNode == null);
    for (Object localObject = null; ; localObject = this.root.read(localInputNode))
      return localObject;
  }

  private Object readElement(InputNode paramInputNode, String paramString)
    throws Exception
  {
    String str = this.style.getElement(paramString);
    InputNode localInputNode = paramInputNode.getNext(str);
    if (localInputNode == null);
    for (Object localObject = null; ; localObject = this.root.read(localInputNode))
      return localObject;
  }

  private boolean validateAttribute(InputNode paramInputNode, String paramString)
    throws Exception
  {
    String str = this.style.getElement(paramString);
    InputNode localInputNode = paramInputNode.getAttribute(str);
    if (localInputNode == null);
    for (boolean bool = true; ; bool = this.root.validate(localInputNode))
      return bool;
  }

  private boolean validateElement(InputNode paramInputNode, String paramString)
    throws Exception
  {
    String str = this.style.getElement(paramString);
    InputNode localInputNode = paramInputNode.getNext(str);
    if (localInputNode == null);
    for (boolean bool = true; ; bool = this.root.validate(localInputNode))
      return bool;
  }

  private void writeAttribute(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    Class localClass = this.type.getType();
    String str1 = this.factory.getText(paramObject);
    String str2 = this.entry.getKey();
    if (str2 == null)
      str2 = this.context.getName(localClass);
    String str3 = this.style.getAttribute(str2);
    if (str1 == null)
      return;
    OutputNode localOutputNode = paramOutputNode.setAttribute(str3, str1);
  }

  private void writeElement(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    Class localClass = this.type.getType();
    String str1 = this.entry.getKey();
    if (str1 == null)
      str1 = this.context.getName(localClass);
    String str2 = this.style.getElement(str1);
    OutputNode localOutputNode = paramOutputNode.getChild(str2);
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
    String str = this.entry.getKey();
    if (str == null)
      str = this.context.getName(localClass);
    if (!this.entry.isAttribute());
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
      throw new PersistenceException("Can not read key of %s for %s", arrayOfObject);
    }
    return read(paramInputNode);
  }

  public boolean validate(InputNode paramInputNode)
    throws Exception
  {
    Class localClass = this.type.getType();
    String str = this.entry.getKey();
    if (str == null)
      str = this.context.getName(localClass);
    if (!this.entry.isAttribute());
    for (boolean bool = validateElement(paramInputNode, str); ; bool = validateAttribute(paramInputNode, str))
      return bool;
  }

  public void write(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    if (!this.entry.isAttribute())
    {
      writeElement(paramOutputNode, paramObject);
      return;
    }
    if (paramObject == null)
      return;
    writeAttribute(paramOutputNode, paramObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.PrimitiveKey
 * JD-Core Version:    0.6.2
 */