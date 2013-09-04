package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Style;

class CompositeListUnion
  implements Repeater
{
  private final Context context;
  private final LabelMap elements;
  private final Group group;
  private final Expression path;
  private final Style style;
  private final Type type;

  public CompositeListUnion(Context paramContext, Group paramGroup, Expression paramExpression, Type paramType)
    throws Exception
  {
    LabelMap localLabelMap = paramGroup.getElements();
    this.elements = localLabelMap;
    Style localStyle = paramContext.getStyle();
    this.style = localStyle;
    this.context = paramContext;
    this.group = paramGroup;
    this.type = paramType;
    this.path = paramExpression;
  }

  private Object readElement(InputNode paramInputNode)
    throws Exception
  {
    String str1 = paramInputNode.getName();
    String str2 = this.path.getElement(str1);
    Label localLabel = (Label)this.elements.get(str2);
    Context localContext = this.context;
    return localLabel.getConverter(localContext).read(paramInputNode);
  }

  private Object readElement(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    String str1 = paramInputNode.getName();
    String str2 = this.path.getElement(str1);
    Label localLabel = (Label)this.elements.get(str2);
    Context localContext = this.context;
    return localLabel.getConverter(localContext).read(paramInputNode, paramObject);
  }

  private Object readText(InputNode paramInputNode)
    throws Exception
  {
    Label localLabel = this.group.getText();
    Context localContext = this.context;
    return localLabel.getConverter(localContext).read(paramInputNode);
  }

  private Object readText(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    Label localLabel = this.group.getText();
    Context localContext = this.context;
    Converter localConverter = localLabel.getConverter(localContext);
    InputNode localInputNode = paramInputNode.getParent();
    return localConverter.read(localInputNode, paramObject);
  }

  private void write(OutputNode paramOutputNode, Object paramObject, Label paramLabel)
    throws Exception
  {
    Context localContext = this.context;
    Converter localConverter = paramLabel.getConverter(localContext);
    Set localSet = Collections.singleton(paramObject);
    if (!paramLabel.isInline())
    {
      String str1 = paramLabel.getName();
      String str2 = this.style.getElement(str1);
      if (!paramOutputNode.isCommitted())
        paramOutputNode.setName(str2);
    }
    localConverter.write(paramOutputNode, localSet);
  }

  private void write(OutputNode paramOutputNode, Collection paramCollection)
    throws Exception
  {
    Iterator localIterator = paramCollection.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Object localObject = localIterator.next();
      if (localObject != null)
      {
        Class localClass = localObject.getClass();
        Label localLabel = this.group.getLabel(localClass);
        if (localLabel == null)
        {
          Object[] arrayOfObject = new Object[3];
          arrayOfObject[0] = localClass;
          Type localType = this.type;
          arrayOfObject[1] = localType;
          Group localGroup = this.group;
          arrayOfObject[2] = localGroup;
          throw new UnionException("Entry of %s not declared in %s with annotation %s", arrayOfObject);
        }
        write(paramOutputNode, localObject, localLabel);
      }
    }
  }

  public Object read(InputNode paramInputNode)
    throws Exception
  {
    if (this.group.getText() == null);
    for (Object localObject = readElement(paramInputNode); ; localObject = readText(paramInputNode))
      return localObject;
  }

  public Object read(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    Object localObject = readElement(paramInputNode, paramObject);
    if (this.group.getText() != null)
      localObject = readText(paramInputNode, paramObject);
    return localObject;
  }

  public boolean validate(InputNode paramInputNode)
    throws Exception
  {
    String str1 = paramInputNode.getName();
    String str2 = this.path.getElement(str1);
    Label localLabel = (Label)this.elements.get(str2);
    Context localContext = this.context;
    return localLabel.getConverter(localContext).validate(paramInputNode);
  }

  public void write(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    Collection localCollection = (Collection)paramObject;
    if (this.group.isInline())
    {
      if (!localCollection.isEmpty())
      {
        write(paramOutputNode, localCollection);
        return;
      }
      if (paramOutputNode.isCommitted())
        return;
      paramOutputNode.remove();
      return;
    }
    write(paramOutputNode, localCollection);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.CompositeListUnion
 * JD-Core Version:    0.6.2
 */