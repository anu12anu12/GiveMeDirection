package crittercism.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public final class d
{
  public static final a a = a.i;
  public static final Parcelable.Creator b = new Parcelable.Creator()
  {
  };

  public d()
  {
  }

  private d(byte paramByte)
  {
  }

  public static String a()
  {
    int[] arrayOfInt = 2.a;
    int i = a.ordinal();
    String str;
    switch (arrayOfInt[i])
    {
    default:
      str = "https://api.crittercism.com";
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    }
    while (true)
    {
      return str;
      str = "http://10.0.2.2:6013";
      continue;
      str = "http://192.168.2.1:6013";
      continue;
      str = "http://192.168.1.110:6013";
      continue;
      str = "http://192.168.1.134:6013";
      continue;
      str = "http://10.0.1.5:6013";
      continue;
      str = "http://10.0.1.8:6013";
      continue;
      str = "http://192.168.1.100:6013";
      continue;
      str = "https://www.appcred.com";
    }
  }

  public static String a(Context paramContext, String paramString)
  {
    Object localObject = null;
    try
    {
      SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("com.crittercism.prefs", 0);
      if (localSharedPreferences != null)
      {
        String str = localSharedPreferences.getString(paramString, null);
        localObject = str;
      }
      label27: return localObject;
    }
    catch (Exception localException)
    {
      break label27;
    }
  }

  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      Object localObject = paramContext.getSharedPreferences("com.crittercism.prefs", 0);
      if (localObject == null)
        return;
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject == null)
        return;
      SharedPreferences.Editor localEditor1 = ((SharedPreferences.Editor)localObject).remove(paramString1);
      SharedPreferences.Editor localEditor2 = ((SharedPreferences.Editor)localObject).putString(paramString1, paramString2);
      boolean bool = ((SharedPreferences.Editor)localObject).commit();
      return;
    }
    catch (Exception localException)
    {
      String str = localException.toString();
    }
  }

  public static void a(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.has("locale"))
      return;
    a.c.a(true);
  }

  public static String b()
  {
    return "2.1.3_rev1";
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[9];
      a locala1 = a;
      arrayOfa[0] = locala1;
      a locala2 = b;
      arrayOfa[1] = locala2;
      a locala3 = c;
      arrayOfa[2] = locala3;
      a locala4 = d;
      arrayOfa[3] = locala4;
      a locala5 = e;
      arrayOfa[4] = locala5;
      a locala6 = f;
      arrayOfa[5] = locala6;
      a locala7 = g;
      arrayOfa[6] = locala7;
      a locala8 = h;
      arrayOfa[7] = locala8;
      a locala9 = i;
      arrayOfa[8] = locala9;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     crittercism.android.d
 * JD-Core Version:    0.6.2
 */