package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

class Traverser
{
  private final Context context;
  private final Style style;

  public Traverser(Context paramContext)
  {
    Style localStyle = paramContext.getStyle();
    this.style = localStyle;
    this.context = paramContext;
  }

  private Composite getComposite(Class paramClass)
    throws Exception
  {
    Type localType = getType(paramClass);
    if (paramClass == null)
    {
      Object[] arrayOfObject = new Object[0];
      throw new RootException("Can not instantiate null class", arrayOfObject);
    }
    Context localContext = this.context;
    return new Composite(localContext, localType);
  }

  private Decorator getDecorator(Class paramClass)
    throws Exception
  {
    return this.context.getDecorator(paramClass);
  }

  private Type getType(Class paramClass)
  {
    return new ClassType(paramClass);
  }

  private Object read(InputNode paramInputNode, Class paramClass, Object paramObject)
    throws Exception
  {
    if (getName(paramClass) == null)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramClass;
      throw new RootException("Root annotation required for %s", arrayOfObject);
    }
    return paramObject;
  }

  protected String getName(Class paramClass)
    throws Exception
  {
    String str = this.context.getName(paramClass);
    return this.style.getElement(str);
  }

  public Object read(InputNode paramInputNode, Class paramClass)
    throws Exception
  {
    Object localObject1 = getComposite(paramClass).read(paramInputNode);
    Class localClass;
    if (localObject1 != null)
      localClass = localObject1.getClass();
    for (Object localObject2 = read(paramInputNode, localClass, localObject1); ; localObject2 = null)
      return localObject2;
  }

  public Object read(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    Class localClass = paramObject.getClass();
    Object localObject = getComposite(localClass).read(paramInputNode, paramObject);
    return read(paramInputNode, localClass, localObject);
  }

  public boolean validate(InputNode paramInputNode, Class paramClass)
    throws Exception
  {
    Composite localComposite = getComposite(paramClass);
    if (getName(paramClass) == null)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramClass;
      throw new RootException("Root annotation required for %s", arrayOfObject);
    }
    return localComposite.validate(paramInputNode);
  }

  public void write(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    Class localClass = paramObject.getClass();
    write(paramOutputNode, paramObject, localClass);
  }

  public void write(OutputNode paramOutputNode, Object paramObject, Class paramClass)
    throws Exception
  {
    Class localClass = paramObject.getClass();
    String str = getName(localClass);
    if (str == null)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = localClass;
      throw new RootException("Root annotation required for %s", arrayOfObject);
    }
    write(paramOutputNode, paramObject, paramClass, str);
  }

  public void write(OutputNode paramOutputNode, Object paramObject, Class paramClass, String paramString)
    throws Exception
  {
    OutputNode localOutputNode = paramOutputNode.getChild(paramString);
    Type localType = getType(paramClass);
    if (paramObject != null)
    {
      Class localClass = paramObject.getClass();
      Decorator localDecorator = getDecorator(localClass);
      if (localDecorator != null)
        localDecorator.decorate(localOutputNode);
      if (!this.context.setOverride(localType, paramObject, localOutputNode))
        getComposite(localClass).write(localOutputNode, paramObject);
    }
    localOutputNode.commit();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Traverser
 * JD-Core Version:    0.6.2
 */