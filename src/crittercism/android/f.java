package crittercism.android;

import org.json.JSONException;
import org.json.JSONObject;

public final class f
{
  public String a = "";
  public String b = "";
  public String c = "";
  private int d = 0;

  public f()
  {
  }

  private f(String paramString1, int paramInt, String paramString2)
  {
    this.a = paramString1;
    this.d = paramInt;
    this.c = paramString2;
  }

  public static f a(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = null;
    try
    {
      localObject1 = "anonymous";
      if (paramJSONObject.has("username"))
      {
        localObject2 = paramJSONObject.getString("username");
        localObject1 = null;
        if (paramJSONObject.has("votes_left"))
        {
          int i = paramJSONObject.getInt("votes_left");
          String str1 = paramJSONObject.getString("id");
          localObject1 = new f(str1, i, (String)localObject2);
        }
      }
    }
    catch (JSONException localJSONException1)
    {
      while (true)
      {
        Object localObject1;
        try
        {
          if (paramJSONObject.has("notify"))
          {
            localJSONObject = paramJSONObject.getJSONObject("notify");
            if (localJSONObject.has("text"))
            {
              String str2 = localJSONObject.getString("text");
              ((f)localObject1).b = str2;
            }
          }
          return localObject1;
          localJSONException1 = localJSONException1;
          localObject1 = null;
          continue;
        }
        catch (JSONException localJSONException2)
        {
          continue;
        }
        Object localObject3 = localObject1;
        continue;
        Object localObject2 = localObject1;
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     crittercism.android.f
 * JD-Core Version:    0.6.2
 */