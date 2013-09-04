package com.androidquery.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import com.androidquery.AQuery;
import com.androidquery.AbstractAQuery;
import com.androidquery.callback.AbstractAjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.AQUtility;
import java.io.IOException;
import org.apache.http.HttpRequest;

public class GoogleHandle extends AccountHandle
  implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener
{
  private Account acc;
  private Account[] accs;
  private Activity act;
  private AccountManager am;
  private String email;
  private String token;
  private String type;

  public GoogleHandle(Activity paramActivity, String paramString1, String paramString2)
  {
    if ("aq.account".equals(paramString2))
      paramString2 = getActiveAccount(paramActivity);
    this.act = paramActivity;
    String str = paramString1.substring(2);
    this.type = str;
    this.email = paramString2;
    AccountManager localAccountManager = AccountManager.get(paramActivity);
    this.am = localAccountManager;
  }

  private void accountDialog()
  {
    Activity localActivity1 = this.act;
    AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(localActivity1);
    Account[] arrayOfAccount = this.am.getAccountsByType("com.google");
    this.accs = arrayOfAccount;
    int i = this.accs.length;
    if (i == 1)
    {
      Account localAccount = this.accs[0];
      auth(localAccount);
      return;
    }
    String[] arrayOfString = new String[i];
    int j = 0;
    while (true)
    {
      if (j >= i)
      {
        AlertDialog.Builder localBuilder2 = localBuilder1.setItems(arrayOfString, this);
        AlertDialog.Builder localBuilder3 = localBuilder1.setOnCancelListener(this);
        AlertDialog localAlertDialog = localBuilder1.create();
        Activity localActivity2 = this.act;
        AbstractAQuery localAbstractAQuery = new AQuery(localActivity2).show(localAlertDialog);
        return;
      }
      String str = this.accs[j].name;
      arrayOfString[j] = str;
      j += 1;
    }
  }

  private void auth(Account paramAccount)
  {
    this.acc = paramAccount;
    Task localTask = new Task(null);
    String[] arrayOfString = new String[0];
    AsyncTask localAsyncTask = localTask.execute(arrayOfString);
  }

  public static String getActiveAccount(Context paramContext)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramContext).getString("aq.account", null);
  }

  public static void setActiveAccount(Context paramContext, String paramString)
  {
    boolean bool = PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putString("aq.account", paramString).commit();
  }

  public void applyToken(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback, HttpRequest paramHttpRequest)
  {
    StringBuilder localStringBuilder = new StringBuilder("GoogleLogin auth=");
    String str1 = this.token;
    String str2 = str1;
    paramHttpRequest.addHeader("Authorization", str2);
  }

  protected void auth()
  {
    if (this.email == null)
    {
      accountDialog();
      return;
    }
    Account[] arrayOfAccount = this.am.getAccountsByType("com.google");
    int i = 0;
    while (true)
    {
      int j = arrayOfAccount.length;
      if (i >= j)
        return;
      Account localAccount = arrayOfAccount[i];
      String str1 = this.email;
      String str2 = localAccount.name;
      if (str1.equals(str2))
      {
        auth(localAccount);
        return;
      }
      i += 1;
    }
  }

  public boolean authenticated()
  {
    if (this.token != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public boolean expired(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback, AjaxStatus paramAjaxStatus)
  {
    int i = paramAjaxStatus.getCode();
    if ((i != 401) && (i != 403));
    for (boolean bool = false; ; bool = true)
      return bool;
  }

  public String getCacheUrl(String paramString)
  {
    String str1 = String.valueOf(paramString);
    StringBuilder localStringBuilder = new StringBuilder(str1).append("#");
    String str2 = this.token;
    return str2;
  }

  public String getType()
  {
    return this.type;
  }

  public void onCancel(DialogInterface paramDialogInterface)
  {
    Activity localActivity = this.act;
    failure(localActivity, 65434, "cancel");
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Account localAccount = this.accs[paramInt];
    String str1 = localAccount.name;
    AQUtility.debug("acc", str1);
    Activity localActivity = this.act;
    String str2 = localAccount.name;
    setActiveAccount(localActivity, str2);
    auth(localAccount);
  }

  public boolean reauth(AbstractAjaxCallback<?, ?> paramAbstractAjaxCallback)
  {
    boolean bool = true;
    AccountManager localAccountManager1 = this.am;
    String str1 = this.acc.type;
    String str2 = this.token;
    localAccountManager1.invalidateAuthToken(str1, str2);
    try
    {
      AccountManager localAccountManager2 = this.am;
      Account localAccount = this.acc;
      String str3 = this.type;
      String str4 = localAccountManager2.blockingGetAuthToken(localAccount, str3, true);
      this.token = str4;
      String str5 = this.token;
      AQUtility.debug("re token", str5);
      if (this.token != null)
        return bool;
    }
    catch (Exception localException)
    {
      while (true)
      {
        AQUtility.debug(localException);
        this.token = null;
        continue;
        bool = false;
      }
    }
  }

  private class Task extends AsyncTask<String, String, Bundle>
  {
    private Task()
    {
    }

    protected Bundle doInBackground(String[] paramArrayOfString)
    {
      AccountManager localAccountManager = GoogleHandle.this.am;
      Account localAccount = GoogleHandle.this.acc;
      String str = GoogleHandle.this.type;
      Activity localActivity = GoogleHandle.this.act;
      AccountManagerCallback localAccountManagerCallback = null;
      Handler localHandler = null;
      AccountManagerFuture localAccountManagerFuture = localAccountManager.getAuthToken(localAccount, str, null, localActivity, localAccountManagerCallback, localHandler);
      try
      {
        Bundle localBundle = (Bundle)localAccountManagerFuture.getResult();
        label68: return localBundle;
      }
      catch (AuthenticatorException localAuthenticatorException)
      {
        while (true)
          AQUtility.debug(localAuthenticatorException);
      }
      catch (IOException localIOException)
      {
        while (true)
          AQUtility.debug(localIOException);
      }
      catch (OperationCanceledException localOperationCanceledException)
      {
        break label68;
      }
    }

    protected void onPostExecute(Bundle paramBundle)
    {
      if ((paramBundle != null) && (paramBundle.containsKey("authtoken")))
      {
        GoogleHandle localGoogleHandle1 = GoogleHandle.this;
        String str = paramBundle.getString("authtoken");
        localGoogleHandle1.token = str;
        GoogleHandle localGoogleHandle2 = GoogleHandle.this;
        Activity localActivity1 = GoogleHandle.this.act;
        localGoogleHandle2.success(localActivity1);
        return;
      }
      GoogleHandle localGoogleHandle3 = GoogleHandle.this;
      Activity localActivity2 = GoogleHandle.this.act;
      localGoogleHandle3.failure(localActivity2, 65434, "rejected");
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.androidquery.auth.GoogleHandle
 * JD-Core Version:    0.6.2
 */