package org.simpleframework.xml.core;

import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.OutputNode;

class CompositeUnion
  implements Converter
{
  private final Context context;
  private final LabelMap elements;
  private final Group group;
  private final Expression path;
  private final Type type;

  public CompositeUnion(Context paramContext, Group paramGroup, Expression paramExpression, Type paramType)
    throws Exception
  {
    LabelMap localLabelMap = paramGroup.getElements();
    this.elements = localLabelMap;
    this.context = paramContext;
    this.group = paramGroup;
    this.type = paramType;
    this.path = paramExpression;
  }

  private void write(OutputNode paramOutputNode, Object paramObject, Label paramLabel)
    throws Exception
  {
    Context localContext = this.context;
    paramLabel.getConverter(localContext).write(paramOutputNode, paramObject);
  }

  public Object read(InputNode paramInputNode)
    throws Exception
  {
    String str1 = paramInputNode.getName();
    String str2 = this.path.getElement(str1);
    Label localLabel = (Label)this.elements.get(str2);
    Context localContext = this.context;
    return localLabel.getConverter(localContext).read(paramInputNode);
  }

  public Object read(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    String str1 = paramInputNode.getName();
    String str2 = this.path.getElement(str1);
    Label localLabel = (Label)this.elements.get(str2);
    Context localContext = this.context;
    return localLabel.getConverter(localContext).read(paramInputNode, paramObject);
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
    Class localClass = paramObject.getClass();
    Label localLabel = this.group.getLabel(localClass);
    if (localLabel == null)
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = localClass;
      Type localType = this.type;
      arrayOfObject[1] = localType;
      Group localGroup = this.group;
      arrayOfObject[2] = localGroup;
      throw new UnionException("Value of %s not declared in %s with annotation %s", arrayOfObject);
    }
    write(paramOutputNode, paramObject, localLabel);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.CompositeUnion
 * JD-Core Version:    0.6.2
 */