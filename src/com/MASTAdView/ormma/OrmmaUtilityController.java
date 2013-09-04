package com.MASTAdView.ormma;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import com.MASTAdView.MASTAdViewCore;
import java.lang.reflect.Method;
import java.util.HashMap;

public class OrmmaUtilityController extends OrmmaController
{
  static HashMap<String, Boolean> mFeatureMap = null;

  public OrmmaUtilityController(MASTAdViewCore paramMASTAdViewCore, Context paramContext)
  {
    super(paramMASTAdViewCore, paramContext);
    setFeatureMap();
  }

  private String createTelUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString));
    StringBuilder localStringBuilder1;
    for (String str = null; ; str = localStringBuilder1.toString())
    {
      return str;
      localStringBuilder1 = new StringBuilder("tel:");
      StringBuilder localStringBuilder2 = localStringBuilder1.append(paramString);
    }
  }

  /** @deprecated */
  private void setFeatureMap()
  {
    try
    {
      boolean bool4;
      if (mFeatureMap == null)
      {
        mFeatureMap = new HashMap();
        HashMap localHashMap1 = mFeatureMap;
        Boolean localBoolean1 = Boolean.valueOf(true);
        Object localObject1 = localHashMap1.put("level-1", localBoolean1);
        HashMap localHashMap2 = mFeatureMap;
        Boolean localBoolean2 = Boolean.valueOf(true);
        Object localObject2 = localHashMap2.put("level-2", localBoolean2);
        HashMap localHashMap3 = mFeatureMap;
        Boolean localBoolean3 = Boolean.valueOf(true);
        Object localObject3 = localHashMap3.put("level-3", localBoolean3);
        HashMap localHashMap4 = mFeatureMap;
        Boolean localBoolean4 = Boolean.valueOf(true);
        Object localObject4 = localHashMap4.put("network", localBoolean4);
        HashMap localHashMap5 = mFeatureMap;
        Boolean localBoolean5 = Boolean.valueOf(true);
        Object localObject5 = localHashMap5.put("orientation", localBoolean5);
        HashMap localHashMap6 = mFeatureMap;
        Boolean localBoolean6 = Boolean.valueOf(true);
        Object localObject6 = localHashMap6.put("screen", localBoolean6);
        if ((this.mContext.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) || (this.mContext.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0))
          break label554;
        bool1 = false;
        HashMap localHashMap7 = mFeatureMap;
        Boolean localBoolean7 = Boolean.valueOf(bool1);
        Object localObject7 = localHashMap7.put("location", localBoolean7);
        boolean bool2 = OrmmaSensorController.hasMagneticField(this.mContext);
        boolean bool3 = OrmmaSensorController.hasAccelerometer(this.mContext);
        HashMap localHashMap8 = mFeatureMap;
        String str = "heading";
        if ((!bool2) || (!bool3))
          break label560;
        bool4 = true;
        label235: Boolean localBoolean8 = Boolean.valueOf(bool4);
        Object localObject8 = localHashMap8.put(str, localBoolean8);
        HashMap localHashMap9 = mFeatureMap;
        Boolean localBoolean9 = Boolean.valueOf(bool3);
        Object localObject9 = localHashMap9.put("shake", localBoolean9);
        HashMap localHashMap10 = mFeatureMap;
        Boolean localBoolean10 = Boolean.valueOf(bool3);
        Object localObject10 = localHashMap10.put("tilt", localBoolean10);
        if (this.mContext.checkCallingOrSelfPermission("android.permission.SEND_SMS") != 0)
          break label566;
        bool1 = true;
        label314: HashMap localHashMap11 = mFeatureMap;
        Boolean localBoolean11 = Boolean.valueOf(bool1);
        Object localObject11 = localHashMap11.put("sms", localBoolean11);
        if (this.mContext.checkCallingOrSelfPermission("android.permission.CALL_PHONE") != 0)
          break label572;
        bool1 = true;
        label352: HashMap localHashMap12 = mFeatureMap;
        Boolean localBoolean12 = Boolean.valueOf(bool1);
        Object localObject12 = localHashMap12.put("phone", localBoolean12);
        if ((this.mContext.checkCallingOrSelfPermission("android.permission.WRITE_CALENDAR") != 0) || (this.mContext.checkCallingOrSelfPermission("android.permission.READ_CALENDAR") != 0))
          break label578;
      }
      label554: label560: label566: label572: label578: for (boolean bool1 = true; ; bool1 = false)
      {
        HashMap localHashMap13 = mFeatureMap;
        Boolean localBoolean13 = Boolean.valueOf(bool1);
        Object localObject13 = localHashMap13.put("calendar", localBoolean13);
        HashMap localHashMap14 = mFeatureMap;
        Boolean localBoolean14 = Boolean.valueOf(true);
        Object localObject14 = localHashMap14.put("email", localBoolean14);
        if (this.mContext.checkCallingOrSelfPermission("android.permission.CAMERA") != 0)
          break label584;
        bool1 = true;
        HashMap localHashMap15 = mFeatureMap;
        Boolean localBoolean15 = Boolean.valueOf(bool1);
        Object localObject15 = localHashMap15.put("camera", localBoolean15);
        HashMap localHashMap16 = mFeatureMap;
        Boolean localBoolean16 = Boolean.valueOf(true);
        Object localObject16 = localHashMap16.put("video", localBoolean16);
        HashMap localHashMap17 = mFeatureMap;
        Boolean localBoolean17 = Boolean.valueOf(true);
        Object localObject17 = localHashMap17.put("audio", localBoolean17);
        HashMap localHashMap18 = mFeatureMap;
        Boolean localBoolean18 = Boolean.valueOf(true);
        Object localObject18 = localHashMap18.put("map", localBoolean18);
        return;
        bool1 = true;
        break;
        bool4 = false;
        break label235;
        bool1 = false;
        break label314;
        bool1 = false;
        break label352;
      }
      label584: bool1 = false;
    }
    finally
    {
    }
  }

  public void createEvent(String paramString1, String paramString2, String paramString3)
  {
    if (supports("calendar"))
      try
      {
        MASTAdViewCore localMASTAdViewCore = this.mOrmmaView;
        StringBuilder localStringBuilder1 = new StringBuilder("date=");
        String str1 = paramString1;
        StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(";title=");
        String str2 = paramString2;
        StringBuilder localStringBuilder3 = localStringBuilder2.append(str2).append(";body=");
        String str3 = paramString3;
        String str4 = str3;
        localMASTAdViewCore.ormmaEvent("calendar", str4);
        String[] arrayOfString = new String[2];
        arrayOfString[0] = "_id";
        arrayOfString[1] = "name";
        int i = Integer.parseInt(Build.VERSION.SDK);
        Uri localUri1 = Uri.parse("content://calendar/calendars");
        if (i >= 8)
          localUri1 = Uri.parse("content://com.android.calendar/calendars");
        Cursor localCursor = ((Activity)this.mContext).managedQuery(localUri1, arrayOfString, "selected=1", null, null);
        if ((localCursor != null) && (localCursor.moveToFirst()))
        {
          int j = localCursor.getColumnIndex("_id");
          String str5 = localCursor.getString(j);
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("calendar_id", str5);
          String str6 = paramString2;
          localContentValues.put("title", str6);
          String str7 = paramString3;
          localContentValues.put("description", str7);
          Long localLong = Long.valueOf(Long.parseLong(paramString1));
          localContentValues.put("dtstart", localLong);
          Uri localUri2 = Uri.parse("content://calendar/events");
          if (i >= 8)
            localUri2 = Uri.parse("content://com.android.calendar/events");
          Uri localUri3 = this.mContext.getContentResolver().insert(localUri2, localContentValues);
          return;
        }
        this.mOrmmaView.injectJavaScript("Ormma.fireError(\"createEvent\",\"Could not find a local calendar\")");
        return;
      }
      catch (Exception localException)
      {
        this.mOrmmaView.injectJavaScript("Ormma.fireError(\"createEvent\",\"Internal error\")");
        return;
      }
    this.mOrmmaView.injectJavaScript("Ormma.fireError(\"createEvent\",\"Calendar not available\")");
  }

  public void eventAdded(String paramString)
  {
    MASTAdViewCore localMASTAdViewCore = this.mOrmmaView;
    String str = "name=" + paramString + ";action=add";
    localMASTAdViewCore.ormmaEvent("service", str);
  }

  public void eventRemoved(String paramString)
  {
    MASTAdViewCore localMASTAdViewCore = this.mOrmmaView;
    String str = "name=" + paramString + ";action=remove";
    localMASTAdViewCore.ormmaEvent("service", str);
  }

  public boolean getKeyboardState()
  {
    return ((InputMethodManager)this.mContext.getSystemService("input_method")).isAcceptingText();
  }

  public void makeCall(String paramString)
  {
    if (supports("phone"))
      try
      {
        MASTAdViewCore localMASTAdViewCore = this.mOrmmaView;
        String str1 = "number=" + paramString;
        localMASTAdViewCore.ormmaEvent("makeCall", str1);
        String str2 = createTelUrl(paramString);
        if (str2 == null)
          this.mOrmmaView.injectJavaScript("Ormma.fireError(\"makeCall\",\"Bad Phone Number\")");
        Uri localUri = Uri.parse(str2.toString());
        Intent localIntent = new Intent("android.intent.action.CALL", localUri);
        this.mContext.startActivity(localIntent);
        return;
      }
      catch (Exception localException)
      {
        this.mOrmmaView.injectJavaScript("Ormma.fireError(\"makeCall\",\"Internal error\")");
        return;
      }
    this.mOrmmaView.injectJavaScript("Ormma.fireError(\"makeCall\",\"CALLS not available\")");
  }

  public void sendMail(String paramString1, String paramString2, String paramString3)
  {
    if (supports("email"))
      try
      {
        Intent localIntent1 = new Intent("android.intent.action.SEND");
        Intent localIntent2 = localIntent1.setType("plain/text");
        String[] arrayOfString = new String[1];
        arrayOfString[0] = paramString1;
        Intent localIntent3 = localIntent1.putExtra("android.intent.extra.EMAIL", arrayOfString);
        Intent localIntent4 = localIntent1.putExtra("android.intent.extra.SUBJECT", paramString2);
        Intent localIntent5 = localIntent1.putExtra("android.intent.extra.TEXT", paramString3);
        MASTAdViewCore localMASTAdViewCore = this.mOrmmaView;
        String str = "recipient=" + paramString1 + ";subject=" + paramString2 + ";body=" + paramString3;
        localMASTAdViewCore.ormmaEvent("sendMail", str);
        this.mContext.startActivity(localIntent1);
        return;
      }
      catch (ActivityNotFoundException localActivityNotFoundException)
      {
        this.mOrmmaView.injectJavaScript("Ormma.fireError(\"sendMail\",\"Email client not available\")");
        return;
      }
      catch (Exception localException)
      {
        this.mOrmmaView.injectJavaScript("Ormma.fireError(\"sendMail\",\"Internal error\")");
        return;
      }
    this.mOrmmaView.injectJavaScript("Ormma.fireError(\"sendMail\",\"Email not available\")");
  }

  public void sendSMS(String paramString1, String paramString2)
  {
    if (supports("sms"))
    {
      MASTAdViewCore localMASTAdViewCore = this.mOrmmaView;
      String str = "recipient=" + paramString1 + ";body=" + paramString2;
      localMASTAdViewCore.ormmaEvent("sms", str);
      try
      {
        if (Integer.parseInt(Build.VERSION.SDK) < 4)
        {
          Object localObject1 = Class.forName("android.telephony.gsm.SmsManager").getMethod("getDefault", null).invoke(null, null);
          Class localClass1 = Class.forName("android.telephony.gsm.SmsManager");
          Class[] arrayOfClass1 = new Class[5];
          arrayOfClass1[0] = String.class;
          arrayOfClass1[1] = String.class;
          arrayOfClass1[2] = String.class;
          arrayOfClass1[3] = PendingIntent.class;
          arrayOfClass1[4] = PendingIntent.class;
          Method localMethod1 = localClass1.getMethod("sendTextMessage", arrayOfClass1);
          Object[] arrayOfObject1 = new Object[5];
          arrayOfObject1[0] = paramString1;
          arrayOfObject1[2] = paramString2;
          Object localObject2 = localMethod1.invoke(localObject1, arrayOfObject1);
          return;
        }
        Object localObject3 = Class.forName("android.telephony.SmsManager").getMethod("getDefault", null).invoke(null, null);
        Class localClass2 = Class.forName("android.telephony.SmsManager");
        Class[] arrayOfClass2 = new Class[5];
        arrayOfClass2[0] = String.class;
        arrayOfClass2[1] = String.class;
        arrayOfClass2[2] = String.class;
        arrayOfClass2[3] = PendingIntent.class;
        arrayOfClass2[4] = PendingIntent.class;
        Method localMethod2 = localClass2.getMethod("sendTextMessage", arrayOfClass2);
        Object[] arrayOfObject2 = new Object[5];
        arrayOfObject2[0] = paramString1;
        arrayOfObject2[2] = paramString2;
        Object localObject4 = localMethod2.invoke(localObject3, arrayOfObject2);
        return;
      }
      catch (Exception localException)
      {
        this.mOrmmaView.injectJavaScript("Ormma.fireError(\"sendSMS\",\"Internal error\")");
        return;
      }
    }
    this.mOrmmaView.injectJavaScript("Ormma.fireError(\"sendSMS\",\"SMS not available\")");
  }

  public boolean supports(String paramString)
  {
    if (mFeatureMap.containsKey(paramString));
    for (boolean bool = ((Boolean)mFeatureMap.get(paramString)).booleanValue(); ; bool = false)
      return bool;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.ormma.OrmmaUtilityController
 * JD-Core Version:    0.6.2
 */