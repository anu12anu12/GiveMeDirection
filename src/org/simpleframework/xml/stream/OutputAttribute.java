package org.simpleframework.xml.stream;

class OutputAttribute
  implements OutputNode
{
  private String name;
  private String reference;
  private NamespaceMap scope;
  private OutputNode source;
  private String value;

  public OutputAttribute(OutputNode paramOutputNode, String paramString1, String paramString2)
  {
    NamespaceMap localNamespaceMap = paramOutputNode.getNamespaces();
    this.scope = localNamespaceMap;
    this.source = paramOutputNode;
    this.value = paramString2;
    this.name = paramString1;
  }

  public void commit()
  {
  }

  public NodeMap<OutputNode> getAttributes()
  {
    return new OutputNodeMap(this);
  }

  public OutputNode getChild(String paramString)
  {
    return null;
  }

  public String getComment()
  {
    return null;
  }

  public Mode getMode()
  {
    return Mode.INHERIT;
  }

  public String getName()
  {
    return this.name;
  }

  public NamespaceMap getNamespaces()
  {
    return this.scope;
  }

  public OutputNode getParent()
  {
    return this.source;
  }

  public String getPrefix()
  {
    NamespaceMap localNamespaceMap = this.scope;
    String str = this.reference;
    return localNamespaceMap.getPrefix(str);
  }

  public String getPrefix(boolean paramBoolean)
  {
    NamespaceMap localNamespaceMap = this.scope;
    String str = this.reference;
    return localNamespaceMap.getPrefix(str);
  }

  public String getReference()
  {
    return this.reference;
  }

  public String getValue()
  {
    return this.value;
  }

  public boolean isCommitted()
  {
    return true;
  }

  public boolean isRoot()
  {
    return false;
  }

  public void remove()
  {
  }

  public OutputNode setAttribute(String paramString1, String paramString2)
  {
    return null;
  }

  public void setComment(String paramString)
  {
  }

  public void setData(boolean paramBoolean)
  {
  }

  public void setMode(Mode paramMode)
  {
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setReference(String paramString)
  {
    this.reference = paramString;
  }

  public void setValue(String paramString)
  {
    this.value = paramString;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    String str1 = this.name;
    arrayOfObject[0] = str1;
    String str2 = this.value;
    arrayOfObject[1] = str2;
    return String.format("attribute %s='%s'", arrayOfObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.OutputAttribute
 * JD-Core Version:    0.6.2
 */