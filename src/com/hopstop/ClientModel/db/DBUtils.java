package com.hopstop.ClientModel.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBUtils
{
  public static List<String> GetColumns(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    Object localObject1 = null;
    try
    {
      String str = "select * from " + paramString + " limit 1";
      localCursor = paramSQLiteDatabase.rawQuery(str, null);
      if (localCursor != null)
      {
        List localList = Arrays.asList(localCursor.getColumnNames());
        ArrayList localArrayList = new ArrayList(localList);
        localObject1 = localArrayList;
      }
      return localObject1;
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        if (localCursor != null)
          localCursor.close();
      }
    }
    finally
    {
      Cursor localCursor;
      if (localCursor != null)
        localCursor.close();
    }
  }

  public static String join(List<String> paramList, String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = paramList.size();
    int j = 0;
    while (true)
    {
      if (j >= i)
        return localStringBuilder1.toString();
      if (j != 0)
        StringBuilder localStringBuilder2 = localStringBuilder1.append(paramString);
      String str = (String)paramList.get(j);
      StringBuilder localStringBuilder3 = localStringBuilder1.append(str);
      j += 1;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.db.DBUtils
 * JD-Core Version:    0.6.2
 */