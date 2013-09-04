package com.j256.ormlite.field;

import com.j256.ormlite.field.types.EnumStringType;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DataPersisterManager
{
  private static final DataPersister DEFAULT_ENUM_PERSISTER = EnumStringType.getSingleton();
  private static final Map<String, DataPersister> builtInMap;
  private static List<DataPersister> registeredPersisters = null;

  static
  {
    builtInMap = new HashMap();
    DataType[] arrayOfDataType = DataType.values();
    int i = arrayOfDataType.length;
    int j = 0;
    while (true)
    {
      if (j >= i)
        return;
      DataPersister localDataPersister = arrayOfDataType[j].getDataPersister();
      if (localDataPersister != null)
      {
        Object localObject1 = localDataPersister.getAssociatedClasses();
        int k = localObject1.length;
        int m = 0;
        while (m < k)
        {
          Object localObject2 = localObject1[m];
          Map localMap = builtInMap;
          String str = localObject2.getName();
          Object localObject3 = localMap.put(str, localDataPersister);
          int n = m + 1;
        }
        if (localDataPersister.getAssociatedClassNames() != null)
        {
          localObject1 = localDataPersister.getAssociatedClassNames();
          k = localObject1.length;
          m = 0;
          while (m < k)
          {
            Object localObject4 = localObject1[m];
            Object localObject5 = builtInMap.put(localObject4, localDataPersister);
            m += 1;
          }
        }
      }
      j += 1;
    }
  }

  public static void clear()
  {
    registeredPersisters = null;
  }

  public static DataPersister lookupForField(Field paramField)
  {
    Object localObject;
    if (registeredPersisters != null)
    {
      Iterator localIterator = registeredPersisters.iterator();
      if (localIterator.hasNext())
      {
        localObject = (DataPersister)localIterator.next();
        if (!((DataPersister)localObject).isValidForField(paramField));
      }
    }
    while (true)
    {
      return localObject;
      Class[] arrayOfClass = ((DataPersister)localObject).getAssociatedClasses();
      int i = arrayOfClass.length;
      int j = 0;
      while (true)
      {
        if (j >= i)
          break label89;
        Class localClass = arrayOfClass[j];
        if (paramField.getType() == localClass)
          break;
        j += 1;
      }
      label89: break;
      Map localMap = builtInMap;
      String str = paramField.getType().getName();
      DataPersister localDataPersister = (DataPersister)localMap.get(str);
      if (localDataPersister != null)
        localObject = localDataPersister;
      else if (paramField.getType().isEnum())
        localObject = DEFAULT_ENUM_PERSISTER;
      else
        localObject = null;
    }
  }

  public static void registerDataPersisters(DataPersister[] paramArrayOfDataPersister)
  {
    ArrayList localArrayList = new ArrayList();
    if (registeredPersisters != null)
    {
      List localList = registeredPersisters;
      boolean bool1 = localArrayList.addAll(localList);
    }
    DataPersister[] arrayOfDataPersister = paramArrayOfDataPersister;
    int i = arrayOfDataPersister.length;
    int j = 0;
    while (j < i)
    {
      DataPersister localDataPersister = arrayOfDataPersister[j];
      boolean bool2 = localArrayList.add(localDataPersister);
      j += 1;
    }
    registeredPersisters = localArrayList;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.field.DataPersisterManager
 * JD-Core Version:    0.6.2
 */