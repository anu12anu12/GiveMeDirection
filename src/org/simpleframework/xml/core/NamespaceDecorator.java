package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.stream.NamespaceMap;
import org.simpleframework.xml.stream.OutputNode;

class NamespaceDecorator
  implements Decorator
{
  private Namespace primary;
  private List<Namespace> scope;

  public NamespaceDecorator()
  {
    ArrayList localArrayList = new ArrayList();
    this.scope = localArrayList;
  }

  private void namespace(OutputNode paramOutputNode)
  {
    if (this.primary == null)
      return;
    String str = this.primary.reference();
    paramOutputNode.setReference(str);
  }

  private void scope(OutputNode paramOutputNode)
  {
    NamespaceMap localNamespaceMap = paramOutputNode.getNamespaces();
    Iterator localIterator = this.scope.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Namespace localNamespace = (Namespace)localIterator.next();
      String str1 = localNamespace.reference();
      String str2 = localNamespace.prefix();
      String str3 = localNamespaceMap.setReference(str1, str2);
    }
  }

  public void add(Namespace paramNamespace)
  {
    boolean bool = this.scope.add(paramNamespace);
  }

  public void decorate(OutputNode paramOutputNode)
  {
    decorate(paramOutputNode, null);
  }

  public void decorate(OutputNode paramOutputNode, Decorator paramDecorator)
  {
    if (paramDecorator != null)
      paramDecorator.decorate(paramOutputNode);
    scope(paramOutputNode);
    namespace(paramOutputNode);
  }

  public void set(Namespace paramNamespace)
  {
    if (paramNamespace != null)
      add(paramNamespace);
    this.primary = paramNamespace;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.NamespaceDecorator
 * JD-Core Version:    0.6.2
 */