package com.hopstop.ClientView;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import com.hopstop.ClientModel.Model;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.ui.BaseActivity;
import com.hopstop.ui.PageNames;
import com.hopstop.util.Util;
import java.util.Hashtable;

public class MoreFeedbackActivity extends BaseActivity
{
  private static final int NO_CHANGE = 255;
  public static final int REQ_SHARE = 7;
  private Model model;

  private void createDefaultCityPref()
  {
    MoreFeedbackActivity localMoreFeedbackActivity = this;
    int i = -1;
    localMoreFeedbackActivity.initSpinners(2131492899, 2131492900, 2131492901, true, -1, i);
  }

  private void initSpinners(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5)
  {
    String[] arrayOfString1 = this.model.getCitiesNames();
    MoreFeedbackActivity localMoreFeedbackActivity1 = this;
    MoreFeedbackActivity localMoreFeedbackActivity2 = this;
    int i = paramInt2;
    HopStopCityAdapter localHopStopCityAdapter = new HopStopCityAdapter(localMoreFeedbackActivity2, 2130903085, arrayOfString1, i);
    String[] arrayOfString2 = this.model.getCountyNames();
    ArrayAdapter localArrayAdapter = new ArrayAdapter(this, 2130903085, arrayOfString2);
    final LinearLayout localLinearLayout = (LinearLayout)findViewById(paramInt1);
    final Spinner localSpinner1 = (Spinner)findViewById(paramInt2);
    final Spinner localSpinner2 = (Spinner)findViewById(paramInt3);
    localSpinner1.setAdapter(localHopStopCityAdapter);
    localHopStopCityAdapter.setDropDownViewResource(17367049);
    if (paramInt4 != -1)
    {
      int j = paramInt4;
      localSpinner1.setSelection(j);
      localSpinner2.setAdapter(localArrayAdapter);
      localArrayAdapter.setDropDownViewResource(17367049);
      if (paramInt5 == -1)
        break label243;
      int k = paramInt5;
      localSpinner2.setSelection(k);
    }
    while (true)
    {
      if (!ApplicationEngine.getModel().getDefaultCityByWidgetId(paramInt2).equals("newyork"))
        localSpinner2.setVisibility(8);
      AdapterView.OnItemSelectedListener local6 = new AdapterView.OnItemSelectedListener()
      {
        private boolean getResourseId(MoreFeedbackActivity.HopStopCityAdapter paramAnonymousHopStopCityAdapter, Resources paramAnonymousResources, String paramAnonymousString)
        {
          boolean bool = true;
          String[] arrayOfString = new String[4];
          arrayOfString[0] = "a_city_spinner";
          arrayOfString[bool] = "b_city_spinner";
          arrayOfString[2] = "map_city_spinner";
          arrayOfString[3] = "pref_city_spinner";
          int i = 0;
          while (true)
          {
            int j = arrayOfString.length;
            if (i >= j)
              bool = false;
            Spinner localSpinner;
            do
            {
              return bool;
              String str1 = String.valueOf(paramAnonymousString);
              StringBuilder localStringBuilder = new StringBuilder(str1).append(":id/");
              String str2 = arrayOfString[i];
              String str3 = str2;
              int k = paramAnonymousResources.getIdentifier(str3, null, null);
              localSpinner = (Spinner)MoreFeedbackActivity.this.findViewById(k);
            }
            while ((localSpinner != null) && (localSpinner.getAdapter().equals(paramAnonymousHopStopCityAdapter)));
            i += 1;
          }
        }

        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          MoreFeedbackActivity.HopStopCityAdapter localHopStopCityAdapter = (MoreFeedbackActivity.HopStopCityAdapter)paramAnonymousAdapterView.getAdapter();
          if (MoreFeedbackActivity.HopStopCityAdapter.access$1(localHopStopCityAdapter))
          {
            Model localModel1 = ApplicationEngine.getModel();
            int i = localHopStopCityAdapter.getResourceId();
            Model localModel2 = ApplicationEngine.getModel();
            String str1 = (String)localSpinner1.getSelectedItem();
            String str2 = localModel2.getSelectedCityFromName(str1);
            localModel1.setDefaultCityByWidgetId(i, str2);
          }
          String str3;
          if (paramAnonymousInt != 0)
          {
            localSpinner1.setSelection(0);
            localHopStopCityAdapter.sort(paramAnonymousInt);
            str3 = null;
            if (localHopStopCityAdapter.getResourceId() != 2131493001)
              break label159;
            str3 = (String)((Spinner)MoreFeedbackActivity.this.findViewById(2131493009)).getSelectedItem();
          }
          while (true)
          {
            Spinner localSpinner = localSpinner2;
            LinearLayout localLinearLayout = localLinearLayout;
            String str4 = (String)paramAnonymousAdapterView.getSelectedItem();
            localHopStopCityAdapter.updateSpinners(localSpinner, localLinearLayout, str4, str3);
            return;
            localHopStopCityAdapter.setInit(true);
            break;
            label159: if (localHopStopCityAdapter.getResourceId() == 2131493009)
              str3 = (String)((Spinner)MoreFeedbackActivity.this.findViewById(2131493001)).getSelectedItem();
          }
        }

        public void onNothingSelected(AdapterView paramAnonymousAdapterView)
        {
        }
      };
      localSpinner1.setOnItemSelectedListener(local6);
      final boolean bool = paramBoolean;
      AdapterView.OnItemSelectedListener local7 = new AdapterView.OnItemSelectedListener()
      {
        String[] res;

        private int getResourseId(AdapterView<?> paramAnonymousAdapterView)
        {
          int i = 0;
          int j = this.res.length;
          int k;
          if (i >= j)
            k = -1;
          while (true)
          {
            return k;
            Resources localResources1 = MoreFeedbackActivity.this.getResources();
            String str1 = String.valueOf(ApplicationEngine.APPLICATION_PACKAGE_NAME);
            StringBuilder localStringBuilder = new StringBuilder(str1).append(":id/");
            String str2 = this.res[i];
            String str3 = str2;
            int m = localResources1.getIdentifier(str3, null, null);
            Spinner localSpinner = (Spinner)MoreFeedbackActivity.this.findViewById(m);
            if ((localSpinner != null) && (localSpinner.equals(paramAnonymousAdapterView)));
            switch (i)
            {
            default:
              i += 1;
              break;
            case 0:
              Resources localResources2 = MoreFeedbackActivity.this.getResources();
              String str4 = String.valueOf(ApplicationEngine.APPLICATION_PACKAGE_NAME);
              String str5 = str4 + ":id/" + "a_city_spinner";
              k = localResources2.getIdentifier(str5, null, null);
              break;
            case 1:
              Resources localResources3 = MoreFeedbackActivity.this.getResources();
              String str6 = String.valueOf(ApplicationEngine.APPLICATION_PACKAGE_NAME);
              String str7 = str6 + ":id/" + "b_city_spinner";
              k = localResources3.getIdentifier(str7, null, null);
              break;
            case 2:
              Resources localResources4 = MoreFeedbackActivity.this.getResources();
              String str8 = String.valueOf(ApplicationEngine.APPLICATION_PACKAGE_NAME);
              String str9 = str8 + ":id/" + "map_city_spinner";
              k = localResources4.getIdentifier(str9, null, null);
              break;
            case 3:
              Resources localResources5 = MoreFeedbackActivity.this.getResources();
              String str10 = String.valueOf(ApplicationEngine.APPLICATION_PACKAGE_NAME);
              String str11 = str10 + ":id/" + "pref_city_spinner";
              k = localResources5.getIdentifier(str11, null, null);
            }
          }
        }

        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          String str1 = Util.requiresBoroughChange((String)paramAnonymousAdapterView.getSelectedItem());
          if (str1 != null)
          {
            MoreFeedbackActivity localMoreFeedbackActivity = MoreFeedbackActivity.this;
            int i = getResourseId(paramAnonymousAdapterView);
            Spinner localSpinner = (Spinner)localMoreFeedbackActivity.findViewById(i);
            MoreFeedbackActivity.HopStopCityAdapter localHopStopCityAdapter = (MoreFeedbackActivity.HopStopCityAdapter)localSpinner.getAdapter();
            String str2 = ApplicationEngine.getModel().findSelectedCityFromShotName(str1);
            int j = localHopStopCityAdapter.getCityByName(str2);
            localSpinner.setSelection(j);
            paramAnonymousAdapterView.setVisibility(8);
            paramAnonymousAdapterView.invalidate();
            paramAnonymousAdapterView.setSelection(2);
          }
          if (!bool)
            return;
          Model localModel = ApplicationEngine.getModel();
          if (str1 == null);
          for (int k = paramAnonymousAdapterView.getSelectedItemPosition(); ; k = 2)
          {
            localModel.setDefaultCountySelection(k);
            return;
          }
        }

        public void onNothingSelected(AdapterView<?> paramAnonymousAdapterView)
        {
        }
      };
      localSpinner2.setOnItemSelectedListener(local7);
      return;
      int m = this.model.getDefaultCityPosition(paramInt2);
      localSpinner1.setSelection(m);
      break;
      label243: int n = this.model.getDefaultCountySelection();
      localSpinner2.setSelection(n);
    }
  }

  private void loadFeedback()
  {
    setContentView(2130903063);
    String str1 = PageNames.Feedback;
    trackEvent(str1);
    setOnClickListenerForFeedback();
    String str2 = PageNames.Feedback;
    displayAds(str2);
    Hashtable localHashtable = new Hashtable();
    String str3 = ApplicationEngine.getModel().getDefaultCityId();
    Object localObject = localHashtable.put("defaultcity", str3);
    int i = ApplicationEngine.ZONE_DIRECTION_SEARCH;
    update(i, localHashtable, null, null);
  }

  private void setOnClickListenerForFeedback()
  {
    Button localButton1 = (Button)findViewById(2131492961);
    View.OnClickListener local1 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        String str1 = MoreFeedbackActivity.this.getString(2130968653);
        String str2 = "\n\n\nSent from HopStop Android App " + str1;
        MoreFeedbackActivity.this.sendEmail("feedback@hopstop.com", "HopStop Android App - Feedback", str2);
      }
    };
    localButton1.setOnClickListener(local1);
    Button localButton2 = (Button)findViewById(2131492962);
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        String str1 = MoreFeedbackActivity.this.getString(2130968653);
        String str2 = "Dear HopStop: \n\nI'm interested in advertising on HopStop's new Android app. Please contact me with information on how to run such an ad campaign.\n\nThank you.\n\nSent from HopStop Android App " + str1;
        MoreFeedbackActivity.this.sendEmail("media@hopstop.com", "HopStop Android App - Advertising Inquiry", str2);
      }
    };
    localButton2.setOnClickListener(local2);
    Button localButton3 = (Button)findViewById(2131492963);
    View.OnClickListener local3 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        String str1 = MoreFeedbackActivity.this.getString(2130968653);
        String str2 = "Dear HopStop: \n\nI would like HopStop to add the following agencies:\n\n\n--\nSent from HopStop Android App " + str1;
        MoreFeedbackActivity.this.sendEmail("transit@hopstop.com", "HopStop Android App - Agency Addition Request", str2);
      }
    };
    localButton3.setOnClickListener(local3);
    Button localButton4 = (Button)findViewById(2131492965);
    View.OnClickListener local4 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MoreFeedbackActivity.this.createDialogForShareInFeedback();
      }
    };
    localButton4.setOnClickListener(local4);
    Button localButton5 = (Button)findViewById(2131492966);
    View.OnClickListener local5 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MoreFeedbackActivity.this.launchMarket();
      }
    };
    localButton5.setOnClickListener(local5);
    if (!ApplicationEngine.APPLICATION_FOR_AMAZON_MARKET)
      return;
    localButton5.setVisibility(8);
  }

  private void shareWithFriends(Intent paramIntent)
  {
    StringBuilder localStringBuilder = new StringBuilder("Hey, you should check out HopStop's free mobile apps! HopStop is a really cool service that provides door-to-door mass transit, taxi and walking directions in dozens of markets throughout the U.S., Canada & Europe, including NYC, Boston, DC, Chicago, LA, San Francisco, Seattle, Montreal, Toronto, London, Paris and Moscow.\n\nFind HopStop on the mobile web at http://m.HopStop.com\n\n");
    String str1 = getString(2130968773);
    String str2 = str1;
    String str3 = paramIntent.getComponent().getClassName();
    Intent localIntent1 = paramIntent.putExtra("android.intent.extra.SUBJECT", "HopStop for your Smartphone");
    if (str3.contains("facebook"))
      Intent localIntent2 = paramIntent.putExtra("android.intent.extra.TEXT", "http://www.hopstop.com");
    while (true)
    {
      startActivity(paramIntent);
      return;
      if ((str3.toLowerCase().contains("mail")) || (str3.contains("k9")))
        Intent localIntent3 = paramIntent.putExtra("android.intent.extra.TEXT", str2);
      else
        Intent localIntent4 = paramIntent.putExtra("android.intent.extra.TEXT", "Check out HopStop's free mobile apps at http://m.HopStop.com");
    }
  }

  public void createDialogForShareInFeedback()
  {
    try
    {
      Intent localIntent1 = new Intent("android.intent.action.SEND", null);
      Intent localIntent2 = localIntent1.addCategory("android.intent.category.DEFAULT");
      Intent localIntent3 = localIntent1.setType("text/plain");
      Intent localIntent4 = new Intent("android.intent.action.PICK_ACTIVITY");
      Intent localIntent5 = localIntent4.putExtra("android.intent.extra.INTENT", localIntent1);
      startActivityForResult(localIntent4, 7);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void launchMarket()
  {
    StringBuilder localStringBuilder = new StringBuilder("market://details?id=");
    String str = getPackageName();
    Uri localUri = Uri.parse(str);
    Intent localIntent = new Intent("android.intent.action.VIEW", localUri);
    try
    {
      startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      Toast.makeText(this, " unable to find market app", 1).show();
    }
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 7)
      return;
    if (paramIntent == null)
      return;
    shareWithFriends(paramIntent);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Model localModel = ApplicationEngine.getModel();
    this.model = localModel;
    loadFeedback();
  }

  private class HopStopCityAdapter extends ArrayAdapter<CharSequence>
  {
    private boolean isInit = false;
    private CharSequence[] items = null;
    private int resourceId = 0;

    public HopStopCityAdapter(Context paramInt1, int paramArrayOfCharSequence, CharSequence[] paramInt2, int arg5)
    {
      super(paramArrayOfCharSequence, paramInt2);
      this.items = paramInt2;
      int i;
      this.resourceId = i;
    }

    public int getCityById(String paramString)
    {
      int i = 0;
      while (true)
      {
        int j = this.items.length;
        if (i >= j)
          i = -1;
        String str1;
        String str2;
        do
        {
          return i;
          str1 = this.items[i].toString();
          str2 = ApplicationEngine.getModel().findSelectedCityFromShotName(paramString);
        }
        while (str1.equalsIgnoreCase(str2));
        i += 1;
      }
    }

    public int getCityByName(String paramString)
    {
      int i = 0;
      while (true)
      {
        int j = this.items.length;
        if (i >= j)
          i = -1;
        while (this.items[i].toString().equalsIgnoreCase(paramString))
          return i;
        i += 1;
      }
    }

    public CharSequence getItem(int paramInt)
    {
      return this.items[paramInt];
    }

    public int getResourceId()
    {
      return this.resourceId;
    }

    public void setInit(boolean paramBoolean)
    {
      this.isInit = paramBoolean;
    }

    public void sort(int paramInt)
    {
      Model localModel = ApplicationEngine.getModel();
      String str = this.items[paramInt].toString();
      localModel.rearrangeCities(str);
      String[] arrayOfString = ApplicationEngine.getModel().getCitiesNames();
      this.items = arrayOfString;
      notifyDataSetChanged();
    }

    public int sortByString(String paramString)
    {
      int i;
      if (this.items != null)
      {
        i = 0;
        int j = this.items.length;
        if (i >= j)
          i = -1;
      }
      while (true)
      {
        return i;
        if (!this.items[i].toString().equalsIgnoreCase(paramString))
        {
          i += 1;
          break;
          i = -1;
        }
      }
    }

    public void updateSpinners(Spinner paramSpinner, LinearLayout paramLinearLayout, String paramString1, String paramString2)
    {
      if (!paramString1.equalsIgnoreCase("New York"))
      {
        paramSpinner.setVisibility(8);
        paramLinearLayout.invalidate();
        return;
      }
      if (!paramString1.equalsIgnoreCase("New York"))
        return;
      paramSpinner.setVisibility(0);
      paramLinearLayout.invalidate();
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.MoreFeedbackActivity
 * JD-Core Version:    0.6.2
 */