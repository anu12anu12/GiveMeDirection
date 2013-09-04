package com.crittercism;

import com.crittercism.app.Crittercism;
import org.json.JSONObject;

public class NotificationJavascriptInterface
{
  public String getDeviceData()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      boolean bool = Crittercism.getOptOutStatus();
      JSONObject localJSONObject2 = localJSONObject1.put("optout", bool);
      label20: return localJSONObject1.toString();
    }
    catch (Exception localException)
    {
      break label20;
    }
  }

  public void testCheckboxListener(String paramString)
  {
    try
    {
      if (new JSONObject(paramString).getBoolean("optout"))
      {
        Crittercism.setOptOutStatus(true);
        return;
      }
      Crittercism.setOptOutStatus(false);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder("Opting EXCEPTION: ");
      String str1 = localException.getClass().getName();
      String str2 = str1;
      localException.printStackTrace();
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.crittercism.NotificationJavascriptInterface
 * JD-Core Version:    0.6.2
 */