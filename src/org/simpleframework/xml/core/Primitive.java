package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

class Primitive
  implements Converter
{
  private final Context context;
  private final String empty;
  private final Class expect;
  private final PrimitiveFactory factory;
  private final Type type;

  public Primitive(Context paramContext, Type paramType)
  {
    this(paramContext, paramType, null);
  }

  public Primitive(Context paramContext, Type paramType, String paramString)
  {
    PrimitiveFactory localPrimitiveFactory = new PrimitiveFactory(paramContext, paramType);
    this.factory = localPrimitiveFactory;
    Class localClass = paramType.getType();
    this.expect = localClass;
    this.context = paramContext;
    this.empty = paramString;
    this.type = paramType;
  }

  private Object readElement(InputNode paramInputNode)
    throws Exception
  {
    Instance localInstance = this.factory.getInstance(paramInputNode);
    if (!localInstance.isReference());
    for (Object localObject = readElement(paramInputNode, localInstance); ; localObject = localInstance.getInstance())
      return localObject;
  }

  private Object readElement(InputNode paramInputNode, Instance paramInstance)
    throws Exception
  {
    Class localClass = this.expect;
    Object localObject1 = read(paramInputNode, localClass);
    if (paramInstance != null)
      Object localObject2 = paramInstance.setInstance(localObject1);
    return localObject1;
  }

  private Object readTemplate(String paramString, Class paramClass)
    throws Exception
  {
    String str = this.context.getProperty(paramString);
    if (str != null);
    for (Object localObject = this.factory.getInstance(str, paramClass); ; localObject = null)
      return localObject;
  }

  private boolean validateElement(InputNode paramInputNode)
    throws Exception
  {
    Instance localInstance = this.factory.getInstance(paramInputNode);
    if (!localInstance.isReference())
      Object localObject = localInstance.setInstance(null);
    return true;
  }

  public Object read(InputNode paramInputNode)
    throws Exception
  {
    if (paramInputNode.isElement());
    Class localClass;
    for (Object localObject = readElement(paramInputNode); ; localObject = read(paramInputNode, localClass))
    {
      return localObject;
      localClass = this.expect;
    }
  }

  public Object read(InputNode paramInputNode, Class paramClass)
    throws Exception
  {
    String str1 = paramInputNode.getValue();
    Object localObject;
    if (str1 == null)
      localObject = null;
    while (true)
    {
      return localObject;
      if (this.empty != null)
      {
        String str2 = this.empty;
        if (str1.equals(str2))
          localObject = this.empty;
      }
      else
      {
        localObject = readTemplate(str1, paramClass);
      }
    }
  }

  public Object read(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    if (paramObject != null)
    {
      Object[] arrayOfObject = new Object[2];
      Class localClass = this.expect;
      arrayOfObject[0] = localClass;
      Type localType = this.type;
      arrayOfObject[1] = localType;
      throw new PersistenceException("Can not read existing %s for %s", arrayOfObject);
    }
    return read(paramInputNode);
  }

  public boolean validate(InputNode paramInputNode)
    throws Exception
  {
    if (paramInputNode.isElement())
      boolean bool = validateElement(paramInputNode);
    while (true)
    {
      return true;
      String str = paramInputNode.getValue();
    }
  }

  public void write(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    String str = this.factory.getText(paramObject);
    if (str == null)
      return;
    paramOutputNode.setValue(str);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Primitive
 * JD-Core Version:    0.6.2
 */