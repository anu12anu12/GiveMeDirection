package crittercism.android;

import android.util.Log;
import com.crittercism.app.Crittercism.b;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  public long a = 65535L;
  public JSONObject b;
  private String c = null;
  private String d = null;
  private String e = null;
  private JSONArray f;
  private List g;
  private double h;
  private JSONObject i;

  private e()
  {
    JSONArray localJSONArray = new JSONArray();
    this.f = localJSONArray;
    ArrayList localArrayList = new ArrayList();
    this.g = localArrayList;
    JSONObject localJSONObject1 = new JSONObject();
    this.b = localJSONObject1;
    JSONObject localJSONObject2 = new JSONObject();
    this.i = localJSONObject2;
    double d1 = new Date().getTime() / 1000.0D;
    this.h = d1;
  }

  public static e a(Throwable paramThrowable, Map paramMap, List paramList, JSONObject paramJSONObject1, long paramLong, JSONObject paramJSONObject2)
  {
    try
    {
      locale = new e();
      String str1 = paramThrowable.getMessage();
      locale.c = str1;
      locale.i = paramJSONObject2;
      locale.a = paramLong;
      int j = paramThrowable.toString().indexOf(":");
      if (j >= 0);
      StringWriter localStringWriter;
      for (Object localObject = paramThrowable.toString().substring(0, j); ; localObject = paramThrowable.getClass().getName())
      {
        locale.e = ((String)localObject);
        localStringWriter = new StringWriter();
        PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
        paramThrowable.printStackTrace(localPrintWriter);
        for (localObject = paramThrowable.getCause(); localObject != null; localObject = ((Throwable)localObject).getCause())
        {
          String str2 = localObject.getClass().getName();
          locale.e = str2;
          ((Throwable)localObject).printStackTrace(localPrintWriter);
        }
      }
      String str3 = localStringWriter.toString();
      locale.d = str3;
      locale.a(paramMap);
      locale.a(paramList, paramJSONObject1);
      locale.b(paramList, paramJSONObject1);
      return locale;
    }
    catch (Exception localException)
    {
      while (true)
      {
        String str4 = localException.getClass().getName();
        int k = Log.e("CrittercismThrowable", str4);
        String str5 = localException.getMessage();
        int m = Log.e("CrittercismThrowable", str5);
        e locale = null;
      }
    }
  }

  public static e a(JSONObject paramJSONObject)
  {
    e locale = new e();
    try
    {
      long l = paramJSONObject.getLong("current_thread_id");
      locale.a = l;
      String str1 = paramJSONObject.getJSONArray("unsymbolized_stacktrace").toString();
      locale.d = str1;
      double d1 = paramJSONObject.getDouble("reported_at");
      locale.h = d1;
      JSONArray localJSONArray = paramJSONObject.getJSONArray("threads");
      locale.f = localJSONArray;
      String str2 = paramJSONObject.getString("exception_name");
      locale.e = str2;
      String str3 = paramJSONObject.getString("exception_reason");
      locale.c = str3;
      JSONObject localJSONObject1 = paramJSONObject.getJSONObject("breadcrumbs");
      locale.i = localJSONObject1;
      ArrayList localArrayList = new ArrayList();
      String str4 = paramJSONObject.getString("app_id");
      BasicNameValuePair localBasicNameValuePair1 = new BasicNameValuePair("app_id", str4);
      boolean bool1 = localArrayList.add(localBasicNameValuePair1);
      String str5 = paramJSONObject.getString("hashed_device_id");
      BasicNameValuePair localBasicNameValuePair2 = new BasicNameValuePair("did", str5);
      boolean bool2 = localArrayList.add(localBasicNameValuePair2);
      String str6 = paramJSONObject.getString("device_name");
      BasicNameValuePair localBasicNameValuePair3 = new BasicNameValuePair("device_name", str6);
      boolean bool3 = localArrayList.add(localBasicNameValuePair3);
      String str7 = paramJSONObject.getString("library_version");
      BasicNameValuePair localBasicNameValuePair4 = new BasicNameValuePair("lib_version", str7);
      boolean bool4 = localArrayList.add(localBasicNameValuePair4);
      String str8 = paramJSONObject.getString("key");
      BasicNameValuePair localBasicNameValuePair5 = new BasicNameValuePair("key", str8);
      boolean bool5 = localArrayList.add(localBasicNameValuePair5);
      JSONObject localJSONObject2 = paramJSONObject.getJSONObject("app_state");
      locale.a(localArrayList, localJSONObject2);
      locale.b = paramJSONObject;
      StringBuilder localStringBuilder = new StringBuilder("crittercismThrowable.jsonNameValueList: ");
      JSONObject localJSONObject3 = locale.b;
      String str9 = localJSONObject3;
      return locale;
    }
    catch (JSONException localJSONException)
    {
      while (true)
        localJSONException.printStackTrace();
    }
    catch (Exception localException)
    {
      while (true)
      {
        String str10 = localException.getClass().getName();
        int j = Log.e("CrittercismThrowable", str10);
        String str11 = localException.getMessage();
        int k = Log.e("CrittercismThrowable", str11);
        locale = null;
      }
    }
  }

  private void a(List paramList, JSONObject paramJSONObject)
  {
    this.g = paramList;
    List localList1 = this.g;
    String str1 = Crittercism.b.a;
    BasicNameValuePair localBasicNameValuePair1 = new BasicNameValuePair("type", str1);
    boolean bool1 = localList1.add(localBasicNameValuePair1);
    List localList2 = this.g;
    String str2 = this.e;
    BasicNameValuePair localBasicNameValuePair2 = new BasicNameValuePair("name", str2);
    boolean bool2 = localList2.add(localBasicNameValuePair2);
    if (this.c != null)
    {
      List localList3 = this.g;
      String str3 = this.c;
      BasicNameValuePair localBasicNameValuePair3 = new BasicNameValuePair("reason", str3);
      boolean bool3 = localList3.add(localBasicNameValuePair3);
    }
    JSONArray localJSONArray1;
    while (true)
    {
      localJSONArray1 = new JSONArray();
      String[] arrayOfString = this.d.split("\n");
      int j = 0;
      while (true)
      {
        int k = arrayOfString.length;
        if (j >= k)
          break;
        String str4 = arrayOfString[j];
        JSONArray localJSONArray2 = localJSONArray1.put(str4);
        j += 1;
      }
      List localList4 = this.g;
      BasicNameValuePair localBasicNameValuePair4 = new BasicNameValuePair("reason", "");
      boolean bool4 = localList4.add(localBasicNameValuePair4);
    }
    List localList5 = this.g;
    String str5 = localJSONArray1.toString();
    BasicNameValuePair localBasicNameValuePair5 = new BasicNameValuePair("stacktrace", str5);
    boolean bool5 = localList5.add(localBasicNameValuePair5);
    List localList6 = this.g;
    String str6 = this.f.toString();
    BasicNameValuePair localBasicNameValuePair6 = new BasicNameValuePair("threads", str6);
    boolean bool6 = localList6.add(localBasicNameValuePair6);
    List localList7 = this.g;
    String str7 = paramJSONObject.toString();
    BasicNameValuePair localBasicNameValuePair7 = new BasicNameValuePair("state", str7);
    boolean bool7 = localList7.add(localBasicNameValuePair7);
    List localList8 = this.g;
    String str8 = this.i.toString();
    BasicNameValuePair localBasicNameValuePair8 = new BasicNameValuePair("breadcrumbs", str8);
    boolean bool8 = localList8.add(localBasicNameValuePair8);
  }

  private void a(Map paramMap)
  {
    JSONArray localJSONArray1 = new JSONArray();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      JSONObject localJSONObject1 = new JSONObject();
      int j = (Thread)((Map.Entry)localObject1).getKey();
      try
      {
        long l1 = j.getId();
        long l2 = this.a;
        if (l1 != l2)
        {
          String str1 = j.getName();
          JSONObject localJSONObject2 = localJSONObject1.put("name", str1);
          long l3 = j.getId();
          JSONObject localJSONObject3 = localJSONObject1.put("id", l3);
          String str2 = j.getState().name();
          JSONObject localJSONObject4 = localJSONObject1.put("state", str2);
          JSONArray localJSONArray2 = new JSONArray();
          localObject1 = (StackTraceElement[])((Map.Entry)localObject1).getValue();
          int m = localObject1.length;
          int k = 0;
          while (k < m)
          {
            Object localObject2 = localObject1[k];
            String str3 = "  " + localObject2;
            JSONArray localJSONArray3 = localJSONArray2.put(localObject2);
            k += 1;
          }
          JSONObject localJSONObject5 = localJSONObject1.put("stacktrace", localJSONArray2);
          JSONArray localJSONArray4 = localJSONArray1.put(localJSONObject1);
        }
      }
      catch (Exception localException)
      {
      }
    }
    this.f = localJSONArray1;
  }

  private void b(List paramList, JSONObject paramJSONObject)
  {
    JSONArray localJSONArray1;
    try
    {
      JSONObject localJSONObject1 = this.b;
      String str1 = ((NameValuePair)paramList.get(0)).getValue();
      JSONObject localJSONObject2 = localJSONObject1.put("app_id", str1);
      JSONObject localJSONObject3 = this.b;
      String str2 = ((NameValuePair)paramList.get(1)).getValue();
      JSONObject localJSONObject4 = localJSONObject3.put("hashed_device_id", str2);
      JSONObject localJSONObject5 = this.b;
      String str3 = ((NameValuePair)paramList.get(2)).getValue();
      JSONObject localJSONObject6 = localJSONObject5.put("device_name", str3);
      JSONObject localJSONObject7 = this.b;
      String str4 = ((NameValuePair)paramList.get(3)).getValue();
      JSONObject localJSONObject8 = localJSONObject7.put("library_version", str4);
      JSONObject localJSONObject9 = this.b;
      String str5 = ((NameValuePair)paramList.get(4)).getValue();
      JSONObject localJSONObject10 = localJSONObject9.put("key", str5);
      JSONObject localJSONObject11 = this.b;
      String str6 = Crittercism.b.a;
      JSONObject localJSONObject12 = localJSONObject11.put("type", str6);
      JSONObject localJSONObject13 = this.b;
      String str7 = this.e;
      JSONObject localJSONObject14 = localJSONObject13.put("exception_name", str7);
      if (this.c != null)
      {
        JSONObject localJSONObject15 = this.b;
        String str8 = this.c;
        JSONObject localJSONObject16 = localJSONObject15.put("exception_reason", str8);
      }
      while (true)
      {
        localJSONArray1 = new JSONArray();
        String[] arrayOfString = this.d.split("\n");
        int j = 0;
        while (true)
        {
          int k = arrayOfString.length;
          if (j >= k)
            break;
          String str9 = arrayOfString[j];
          JSONArray localJSONArray2 = localJSONArray1.put(str9);
          j += 1;
        }
        JSONObject localJSONObject17 = this.b.put("exception_reason", "");
      }
    }
    catch (JSONException localJSONException)
    {
      int m = Log.e("CrittercismThrowable", "JSONException when creating CrittercismThrowable name-value list!");
      JSONObject localJSONObject18 = new JSONObject();
      this.b = localJSONObject18;
      return;
    }
    JSONObject localJSONObject19 = this.b.put("unsymbolized_stacktrace", localJSONArray1);
    JSONObject localJSONObject20 = this.b;
    JSONArray localJSONArray3 = this.f;
    JSONObject localJSONObject21 = localJSONObject20.put("threads", localJSONArray3);
    JSONObject localJSONObject22 = this.b.put("app_state", paramJSONObject);
    JSONObject localJSONObject23 = this.b;
    long l = this.a;
    JSONObject localJSONObject24 = localJSONObject23.put("current_thread_id", l);
    JSONObject localJSONObject25 = this.b;
    double d1 = this.h;
    JSONObject localJSONObject26 = localJSONObject25.put("reported_at", d1);
    JSONObject localJSONObject27 = this.b.put("reached_server", false);
    JSONObject localJSONObject28 = this.b;
    JSONObject localJSONObject29 = this.i;
    JSONObject localJSONObject30 = localJSONObject28.put("breadcrumbs", localJSONObject29);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     crittercism.android.e
 * JD-Core Version:    0.6.2
 */