package org.simpleframework.xml.core;

import java.util.List;

class LabelGroup
{
  private final List<Label> list;
  private final int size;

  public LabelGroup(List<Label> paramList)
  {
    int i = paramList.size();
    this.size = i;
    this.list = paramList;
  }

  public LabelGroup(Label paramLabel)
  {
    this(localList);
  }

  public List<Label> getList()
  {
    return this.list;
  }

  public Label getPrimary()
  {
    if (this.size > 0);
    for (Label localLabel = (Label)this.list.get(0); ; localLabel = null)
      return localLabel;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.LabelGroup
 * JD-Core Version:    0.6.2
 */