package com.androidquery.service;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.Html;
import android.text.Html.TagHandler;
import android.text.Spanned;
import com.androidquery.AQuery;
import com.androidquery.AbstractAQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;
import java.util.Locale;
import org.json.JSONObject;
import org.xml.sax.XMLReader;

public class MarketService
{
  private static final String BULLET = "•";
  public static final int MAJOR = 2;
  public static final int MINOR = 1;
  public static final int REVISION = 0;
  private static final String SKIP_VERSION = "aqs.skip";
  private static ApplicationInfo ai;
  private static PackageInfo pi;
  private Activity act;
  private AQuery aq;
  private boolean completed;
  private long expire = 720000L;
  private boolean fetch;
  private boolean force;
  private Handler handler;
  private int level = 0;
  private String locale;
  private int progress;
  private String rateUrl;
  private String updateUrl;
  private String version;

  public MarketService(Activity paramActivity)
  {
    this.act = paramActivity;
    AQuery localAQuery = new AQuery(paramActivity);
    this.aq = localAQuery;
    Handler localHandler = new Handler(null);
    this.handler = localHandler;
    String str1 = Locale.getDefault().toString();
    this.locale = str1;
    String str2 = getMarketUrl();
    this.rateUrl = str2;
    String str3 = this.rateUrl;
    this.updateUrl = str3;
  }

  private Drawable getAppIcon()
  {
    ApplicationInfo localApplicationInfo = getApplicationInfo();
    PackageManager localPackageManager = this.act.getPackageManager();
    return localApplicationInfo.loadIcon(localPackageManager);
  }

  private String getAppId()
  {
    return getApplicationInfo().packageName;
  }

  private ApplicationInfo getApplicationInfo()
  {
    if (ai == null)
      ai = this.act.getApplicationInfo();
    return ai;
  }

  private String getHost()
  {
    return "https://androidquery.appspot.com";
  }

  private String getMarketUrl()
  {
    String str = getAppId();
    return "market://details?id=" + str;
  }

  private PackageInfo getPackageInfo()
  {
    if (pi == null);
    try
    {
      PackageManager localPackageManager = this.act.getPackageManager();
      String str = getAppId();
      pi = localPackageManager.getPackageInfo(str, 0);
      return pi;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      while (true)
        localNameNotFoundException.printStackTrace();
    }
  }

  private String getQueryUrl()
  {
    String str1 = getAppId();
    String str2 = String.valueOf(getHost());
    StringBuilder localStringBuilder1 = new StringBuilder(str2).append("/api/market?app=").append(str1).append("&locale=");
    String str3 = this.locale;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str3).append("&version=");
    String str4 = getVersion();
    StringBuilder localStringBuilder3 = localStringBuilder2.append(str4).append("&code=");
    int i = getVersionCode();
    String str5 = i + "&aq=" + "0.23.16";
    if (this.force)
    {
      String str6 = String.valueOf(str5);
      str5 = str6 + "&force=true";
    }
    return str5;
  }

  private static String getSkipVersion(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("aqs.skip", null);
  }

  private String getVersion()
  {
    return getPackageInfo().versionName;
  }

  private int getVersionCode()
  {
    return getPackageInfo().versionCode;
  }

  private boolean isActive()
  {
    if (this.act.isFinishing());
    for (boolean bool = false; ; bool = true)
      return bool;
  }

  private static boolean openUrl(Activity paramActivity, String paramString)
  {
    boolean bool = false;
    if (paramString == null);
    while (true)
    {
      return bool;
      try
      {
        Uri localUri = Uri.parse(paramString);
        Intent localIntent = new Intent("android.intent.action.VIEW", localUri);
        paramActivity.startActivity(localIntent);
        bool = true;
      }
      catch (Exception localException)
      {
      }
    }
  }

  private boolean outdated(String paramString, int paramInt)
  {
    boolean bool = false;
    String str1 = getSkipVersion(this.act);
    if (paramString.equals(str1));
    while (true)
    {
      return bool;
      String str2 = getVersion();
      int i = getVersionCode();
      if ((!str2.equals(paramString)) && (i <= paramInt))
      {
        int j = this.level;
        bool = requireUpdate(str2, paramString, j);
      }
    }
  }

  private static String patchBody(String paramString)
  {
    return "<small>" + paramString + "</small>";
  }

  private boolean requireUpdate(String paramString1, String paramString2, int paramInt)
  {
    boolean bool1 = false;
    if (paramString1.equals(paramString2));
    while (true)
    {
      return bool1;
      try
      {
        String[] arrayOfString1 = paramString1.split("\\.");
        String[] arrayOfString2 = paramString2.split("\\.");
        if ((arrayOfString1.length < 3) || (arrayOfString2.length < 3))
          bool1 = true;
        else
          switch (paramInt)
          {
          default:
            bool1 = true;
            break;
          case 0:
            int i = arrayOfString1.length + -1;
            String str1 = arrayOfString1[i];
            int j = arrayOfString2.length + -1;
            String str2 = arrayOfString2[j];
            if (!str1.equals(str2))
              bool1 = true;
            break;
          case 1:
            int k = arrayOfString1.length + -2;
            String str3 = arrayOfString1[k];
            int m = arrayOfString2.length + -2;
            String str4 = arrayOfString2[m];
            if (!str3.equals(str4))
              bool1 = true;
            break;
          case 2:
            int n = arrayOfString1.length + -3;
            String str5 = arrayOfString1[n];
            int i1 = arrayOfString2.length + -3;
            String str6 = arrayOfString2[i1];
            boolean bool2 = str5.equals(str6);
            if (!bool2)
              bool1 = true;
            break;
          }
      }
      catch (Exception localException)
      {
        AQUtility.report(localException);
        bool1 = true;
      }
    }
  }

  private static void setSkipVersion(Context paramContext, String paramString)
  {
    boolean bool = PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putString("aqs.skip", paramString).commit();
  }

  protected void callback(String paramString, JSONObject paramJSONObject, AjaxStatus paramAjaxStatus)
  {
    if (paramJSONObject == null)
      return;
    String str1 = paramJSONObject.optString("version", "0");
    int i = paramJSONObject.optInt("code", 0);
    String str2 = String.valueOf(getVersion());
    StringBuilder localStringBuilder = new StringBuilder(str2).append("->").append(str1).append(":");
    int j = getVersionCode();
    String str3 = j + "->" + i;
    AQUtility.debug("version", str3);
    Boolean localBoolean = Boolean.valueOf(outdated(str1, i));
    AQUtility.debug("outdated", localBoolean);
    if ((!this.force) && (!outdated(str1, i)))
      return;
    showUpdateDialog(paramJSONObject);
  }

  public void checkVersion()
  {
    String str = getQueryUrl();
    AjaxCallback localAjaxCallback1 = new AjaxCallback();
    AjaxCallback localAjaxCallback2 = (AjaxCallback)((AjaxCallback)localAjaxCallback1.url(str)).type(JSONObject.class);
    Handler localHandler = this.handler;
    AjaxCallback localAjaxCallback3 = (AjaxCallback)localAjaxCallback2.handler(localHandler, "marketCb");
    if (this.force);
    for (boolean bool = false; ; bool = true)
    {
      AjaxCallback localAjaxCallback4 = (AjaxCallback)localAjaxCallback3.fileCache(bool);
      long l = this.expire;
      Object localObject = localAjaxCallback4.expire(l);
      AQuery localAQuery = this.aq;
      int i = this.progress;
      AbstractAQuery localAbstractAQuery = ((AQuery)localAQuery.progress(i)).ajax(localAjaxCallback1);
      return;
    }
  }

  public MarketService expire(long paramLong)
  {
    this.expire = paramLong;
    return this;
  }

  public MarketService force(boolean paramBoolean)
  {
    this.force = paramBoolean;
    return this;
  }

  public MarketService level(int paramInt)
  {
    this.level = paramInt;
    return this;
  }

  public MarketService locale(String paramString)
  {
    this.locale = paramString;
    return this;
  }

  public MarketService progress(int paramInt)
  {
    this.progress = paramInt;
    return this;
  }

  public MarketService rateUrl(String paramString)
  {
    this.rateUrl = paramString;
    return this;
  }

  protected void showUpdateDialog(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
      return;
    if (this.version != null)
      return;
    if (!isActive())
      return;
    JSONObject localJSONObject = paramJSONObject.optJSONObject("dialog");
    String str1 = localJSONObject.optString("update", "Update");
    String str2 = localJSONObject.optString("skip", "Skip");
    String str3 = localJSONObject.optString("rate", "Rate");
    String str4 = localJSONObject.optString("wbody", "");
    String str5 = localJSONObject.optString("title", "Update Available");
    AQUtility.debug("wbody", str4);
    String str6 = paramJSONObject.optString("version", null);
    this.version = str6;
    Drawable localDrawable = getAppIcon();
    Activity localActivity = this.act;
    AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localActivity).setIcon(localDrawable).setTitle(str5);
    Handler localHandler1 = this.handler;
    AlertDialog.Builder localBuilder2 = localBuilder1.setPositiveButton(str3, localHandler1);
    Handler localHandler2 = this.handler;
    AlertDialog.Builder localBuilder3 = localBuilder2.setNeutralButton(str2, localHandler2);
    Handler localHandler3 = this.handler;
    AlertDialog localAlertDialog = localBuilder3.setNegativeButton(str1, localHandler3).create();
    String str7 = patchBody(str4);
    Handler localHandler4 = this.handler;
    Spanned localSpanned = Html.fromHtml(str7, null, localHandler4);
    localAlertDialog.setMessage(localSpanned);
    AbstractAQuery localAbstractAQuery = this.aq.show(localAlertDialog);
  }

  public MarketService updateUrl(String paramString)
  {
    this.updateUrl = paramString;
    return this;
  }

  private class Handler
    implements DialogInterface.OnClickListener, Html.TagHandler
  {
    private Handler()
    {
    }

    private void cb(String paramString, JSONObject paramJSONObject, AjaxStatus paramAjaxStatus)
    {
      if (MarketService.this.completed)
        return;
      MarketService.this.completed = true;
      MarketService.this.progress = 0;
      MarketService.this.callback(paramString, paramJSONObject, paramAjaxStatus);
    }

    public void detailCb(String paramString1, String paramString2, AjaxStatus paramAjaxStatus)
    {
      if (paramString2 == null)
        return;
      if (paramString2.length() <= 1000)
        return;
      String str = MarketService.this.getQueryUrl();
      AjaxCallback localAjaxCallback = new AjaxCallback();
      Object localObject1 = ((AjaxCallback)((AjaxCallback)localAjaxCallback.url(str)).type(JSONObject.class)).handler(this, "marketCb");
      Object localObject2 = localAjaxCallback.param("html", paramString2);
      AQuery localAQuery = MarketService.this.aq;
      int i = MarketService.this.progress;
      AbstractAQuery localAbstractAQuery = ((AQuery)localAQuery.progress(i)).ajax(localAjaxCallback);
    }

    public void handleTag(boolean paramBoolean, String paramString, Editable paramEditable, XMLReader paramXMLReader)
    {
      if (!"li".equals(paramString))
        return;
      if (paramBoolean)
      {
        Editable localEditable1 = paramEditable.append("  ");
        Editable localEditable2 = paramEditable.append("•");
        Editable localEditable3 = paramEditable.append("  ");
        return;
      }
      Editable localEditable4 = paramEditable.append("\n");
    }

    public void marketCb(String paramString, JSONObject paramJSONObject, AjaxStatus paramAjaxStatus)
    {
      if (MarketService.this.act.isFinishing())
        return;
      if (paramJSONObject != null)
      {
        String str1 = paramJSONObject.optString("status");
        if ("1".equals(str1))
        {
          if (paramJSONObject.has("dialog"))
            cb(paramString, paramJSONObject, paramAjaxStatus);
          if (MarketService.this.fetch)
            return;
          if (!paramJSONObject.optBoolean("fetch", false))
            return;
          if (paramAjaxStatus.getSource() != 1)
            return;
          MarketService.this.fetch = true;
          String str2 = paramJSONObject.optString("marketUrl", null);
          AjaxCallback localAjaxCallback = new AjaxCallback();
          Object localObject = ((AjaxCallback)((AjaxCallback)localAjaxCallback.url(str2)).type(String.class)).handler(this, "detailCb");
          AQuery localAQuery = MarketService.this.aq;
          int i = MarketService.this.progress;
          AbstractAQuery localAbstractAQuery = ((AQuery)localAQuery.progress(i)).ajax(localAjaxCallback);
          return;
        }
        if ("0".equals(str1))
        {
          AjaxStatus localAjaxStatus = paramAjaxStatus.invalidate();
          return;
        }
        cb(paramString, paramJSONObject, paramAjaxStatus);
        return;
      }
      cb(paramString, paramJSONObject, paramAjaxStatus);
    }

    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      switch (paramInt)
      {
      default:
        return;
      case -1:
        Activity localActivity1 = MarketService.this.act;
        String str1 = MarketService.this.rateUrl;
        boolean bool1 = MarketService.openUrl(localActivity1, str1);
        return;
      case -2:
        Activity localActivity2 = MarketService.this.act;
        String str2 = MarketService.this.updateUrl;
        boolean bool2 = MarketService.openUrl(localActivity2, str2);
        return;
      case -3:
      }
      Activity localActivity3 = MarketService.this.act;
      String str3 = MarketService.this.version;
      MarketService.setSkipVersion(localActivity3, str3);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.androidquery.service.MarketService
 * JD-Core Version:    0.6.2
 */