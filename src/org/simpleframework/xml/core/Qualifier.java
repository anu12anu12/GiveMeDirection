package org.simpleframework.xml.core;

import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.stream.OutputNode;

class Qualifier
  implements Decorator
{
  private NamespaceDecorator decorator;

  public Qualifier(Contact paramContact)
  {
    NamespaceDecorator localNamespaceDecorator = new NamespaceDecorator();
    this.decorator = localNamespaceDecorator;
    scan(paramContact);
  }

  private void namespace(Contact paramContact)
  {
    Namespace localNamespace = (Namespace)paramContact.getAnnotation(Namespace.class);
    if (localNamespace == null)
      return;
    this.decorator.set(localNamespace);
    this.decorator.add(localNamespace);
  }

  private void scan(Contact paramContact)
  {
    namespace(paramContact);
    scope(paramContact);
  }

  private void scope(Contact paramContact)
  {
    NamespaceList localNamespaceList = (NamespaceList)paramContact.getAnnotation(NamespaceList.class);
    if (localNamespaceList == null)
      return;
    Namespace[] arrayOfNamespace = localNamespaceList.value();
    int i = arrayOfNamespace.length;
    int j = 0;
    while (true)
    {
      if (j >= i)
        return;
      Namespace localNamespace = arrayOfNamespace[j];
      this.decorator.add(localNamespace);
      j += 1;
    }
  }

  public void decorate(OutputNode paramOutputNode)
  {
    this.decorator.decorate(paramOutputNode);
  }

  public void decorate(OutputNode paramOutputNode, Decorator paramDecorator)
  {
    this.decorator.decorate(paramOutputNode, paramDecorator);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Qualifier
 * JD-Core Version:    0.6.2
 */