package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

class SignatureBuilder
{
  private final Constructor factory;
  private final ParameterTable table;

  public SignatureBuilder(Constructor paramConstructor)
  {
    ParameterTable localParameterTable = new ParameterTable();
    this.table = localParameterTable;
    this.factory = paramConstructor;
  }

  private List<Signature> build(ParameterTable paramParameterTable)
    throws Exception
  {
    if (this.table.isEmpty());
    for (List localList = create(); ; localList = create(paramParameterTable))
    {
      return localList;
      build(paramParameterTable, 0);
    }
  }

  private void build(ParameterTable paramParameterTable, int paramInt)
  {
    ParameterList localParameterList = new ParameterList();
    build(paramParameterTable, localParameterList, paramInt);
  }

  private void build(ParameterTable paramParameterTable, ParameterList paramParameterList, int paramInt)
  {
    ParameterList localParameterList1 = this.table.get(paramInt);
    int i = localParameterList1.size();
    if (this.table.width() + -1 > paramInt)
    {
      int j = 0;
      while (true)
      {
        if (j >= i)
          return;
        ParameterList localParameterList2 = new ParameterList(paramParameterList);
        if (paramParameterList != null)
        {
          Parameter localParameter = (Parameter)localParameterList1.get(j);
          boolean bool = localParameterList2.add(localParameter);
          int k = paramInt + 1;
          build(paramParameterTable, localParameterList2, k);
        }
        j += 1;
      }
    }
    populate(paramParameterTable, paramParameterList, paramInt);
  }

  private List<Signature> create()
    throws Exception
  {
    ArrayList localArrayList = new ArrayList();
    Constructor localConstructor = this.factory;
    Signature localSignature = new Signature(localConstructor);
    if (isValid())
      boolean bool = localArrayList.add(localSignature);
    return localArrayList;
  }

  private List<Signature> create(ParameterTable paramParameterTable)
    throws Exception
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramParameterTable.height();
    int j = paramParameterTable.width();
    int k = 0;
    while (k < i)
    {
      Constructor localConstructor1 = this.factory;
      Signature localSignature = new Signature(localConstructor1);
      int m = 0;
      while (m < j)
      {
        Parameter localParameter = paramParameterTable.get(m, k);
        String str = localParameter.getPath();
        Object localObject = localParameter.getKey();
        if (localSignature.contains(localObject))
        {
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = str;
          Constructor localConstructor2 = this.factory;
          arrayOfObject[1] = localConstructor2;
          throw new ConstructorException("Parameter '%s' is a duplicate in %s", arrayOfObject);
        }
        localSignature.add(localParameter);
        m += 1;
      }
      boolean bool = localArrayList.add(localSignature);
      k += 1;
    }
    return localArrayList;
  }

  private void populate(ParameterTable paramParameterTable, ParameterList paramParameterList, int paramInt)
  {
    ParameterList localParameterList1 = this.table.get(paramInt);
    int i = paramParameterList.size();
    int j = localParameterList1.size();
    int k = 0;
    while (true)
    {
      if (k >= j)
        return;
      int m = 0;
      while (m < i)
      {
        ParameterList localParameterList2 = paramParameterTable.get(m);
        Parameter localParameter1 = (Parameter)paramParameterList.get(m);
        boolean bool1 = localParameterList2.add(localParameter1);
        m += 1;
      }
      ParameterList localParameterList3 = paramParameterTable.get(paramInt);
      Parameter localParameter2 = (Parameter)localParameterList1.get(k);
      boolean bool2 = localParameterList3.add(localParameter2);
      k += 1;
    }
  }

  public List<Signature> build()
    throws Exception
  {
    ParameterTable localParameterTable = new ParameterTable();
    return build(localParameterTable);
  }

  public void insert(Parameter paramParameter, int paramInt)
  {
    this.table.insert(paramParameter, paramInt);
  }

  public boolean isValid()
  {
    Class[] arrayOfClass = this.factory.getParameterTypes();
    int i = this.table.width();
    if (arrayOfClass.length != i);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private static class ParameterList extends ArrayList<Parameter>
  {
    public ParameterList()
    {
    }

    public ParameterList(ParameterList paramParameterList)
    {
      super();
    }
  }

  private static class ParameterTable extends ArrayList<SignatureBuilder.ParameterList>
  {
    private int height()
    {
      int i = 0;
      if (width() > 0)
        i = get(0).size();
      return i;
    }

    private int width()
    {
      return size();
    }

    public Parameter get(int paramInt1, int paramInt2)
    {
      return (Parameter)get(paramInt1).get(paramInt2);
    }

    public SignatureBuilder.ParameterList get(int paramInt)
    {
      int i = size();
      while (i <= paramInt)
      {
        SignatureBuilder.ParameterList localParameterList = new SignatureBuilder.ParameterList();
        boolean bool = add(localParameterList);
        i += 1;
      }
      return (SignatureBuilder.ParameterList)super.get(paramInt);
    }

    public void insert(Parameter paramParameter, int paramInt)
    {
      SignatureBuilder.ParameterList localParameterList = get(paramInt);
      if (localParameterList == null)
        return;
      boolean bool = localParameterList.add(paramParameter);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.SignatureBuilder
 * JD-Core Version:    0.6.2
 */