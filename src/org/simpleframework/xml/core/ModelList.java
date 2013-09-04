package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;

class ModelList extends ArrayList<Model>
{
  public ModelList build()
  {
    ModelList localModelList = new ModelList();
    Iterator localIterator = iterator();
    while (localIterator.hasNext())
    {
      Model localModel = (Model)localIterator.next();
      localModelList.register(localModel);
    }
    return localModelList;
  }

  public boolean isEmpty()
  {
    Iterator localIterator = iterator();
    Model localModel;
    do
    {
      if (!localIterator.hasNext())
        break;
      localModel = (Model)localIterator.next();
    }
    while ((localModel == null) || (localModel.isEmpty()));
    for (boolean bool = false; ; bool = true)
      return bool;
  }

  public Model lookup(int paramInt)
  {
    int i = size();
    int j;
    if (paramInt <= i)
      j = paramInt + -1;
    for (Model localModel = (Model)get(j); ; localModel = null)
      return localModel;
  }

  public void register(Model paramModel)
  {
    int i = paramModel.getIndex();
    int j = size();
    int k = 0;
    while (true)
    {
      if (k >= i)
        return;
      if (k >= j)
        boolean bool = add(null);
      int m = i + -1;
      if (k != m)
      {
        int n = i + -1;
        Object localObject = set(n, paramModel);
      }
      k += 1;
    }
  }

  public Model take()
  {
    Model localModel;
    do
    {
      if (isEmpty())
        break;
      localModel = (Model)remove(0);
    }
    while (localModel.isEmpty());
    while (true)
    {
      return localModel;
      localModel = null;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ModelList
 * JD-Core Version:    0.6.2
 */