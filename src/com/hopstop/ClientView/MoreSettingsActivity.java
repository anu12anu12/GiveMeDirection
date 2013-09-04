package com.hopstop.ClientView;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import com.androidquery.AQuery;
import com.androidquery.AbstractAQuery;
import com.hopstop.ClientModel.Model;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.ui.BaseActivity;
import com.hopstop.util.Util;
import java.util.Hashtable;

public class MoreSettingsActivity extends BaseActivity
{
  private static final int NO_CHANGE = 255;
  public static final int REQ_SHARE = 7;
  public final String DISTANCE_SETTING_KEY = "distance_settings";
  private AQuery aq;

  private void createDefaultCityPref()
  {
    MoreSettingsActivity localMoreSettingsActivity = this;
    int i = -1;
    localMoreSettingsActivity.initSpinners(2131492899, 2131492900, 2131492901, true, -1, i);
  }

  private void initSpinners(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5)
  {
    String[] arrayOfString1 = ApplicationEngine.getModel().getCitiesNames();
    MoreSettingsActivity localMoreSettingsActivity1 = this;
    MoreSettingsActivity localMoreSettingsActivity2 = this;
    int i = paramInt2;
    HopStopCityAdapter localHopStopCityAdapter = new HopStopCityAdapter(localMoreSettingsActivity2, 2130903085, arrayOfString1, i);
    String[] arrayOfString2 = ApplicationEngine.getModel().getCountyNames();
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
        break label240;
      int k = paramInt5;
      localSpinner2.setSelection(k);
    }
    while (true)
    {
      if (!ApplicationEngine.getModel().getDefaultCityByWidgetId(paramInt2).equals("newyork"))
        localSpinner2.setVisibility(8);
      AdapterView.OnItemSelectedListener local1 = new AdapterView.OnItemSelectedListener()
      {
        private boolean getResourseId(MoreSettingsActivity.HopStopCityAdapter paramAnonymousHopStopCityAdapter, Resources paramAnonymousResources, String paramAnonymousString)
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
              localSpinner = (Spinner)MoreSettingsActivity.this.findViewById(k);
            }
            while ((localSpinner != null) && (localSpinner.getAdapter().equals(paramAnonymousHopStopCityAdapter)));
            i += 1;
          }
        }

        public void onItemSelected(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          MoreSettingsActivity.HopStopCityAdapter localHopStopCityAdapter = (MoreSettingsActivity.HopStopCityAdapter)paramAnonymousAdapterView.getAdapter();
          if (MoreSettingsActivity.HopStopCityAdapter.access$1(localHopStopCityAdapter))
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
            str3 = (String)((Spinner)MoreSettingsActivity.this.findViewById(2131493009)).getSelectedItem();
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
              str3 = (String)((Spinner)MoreSettingsActivity.this.findViewById(2131493001)).getSelectedItem();
          }
        }

        public void onNothingSelected(AdapterView paramAnonymousAdapterView)
        {
        }
      };
      localSpinner1.setOnItemSelectedListener(local1);
      final boolean bool = paramBoolean;
      AdapterView.OnItemSelectedListener local2 = new AdapterView.OnItemSelectedListener()
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
            Resources localResources1 = MoreSettingsActivity.this.getResources();
            String str1 = String.valueOf(ApplicationEngine.APPLICATION_PACKAGE_NAME);
            StringBuilder localStringBuilder = new StringBuilder(str1).append(":id/");
            String str2 = this.res[i];
            String str3 = str2;
            int m = localResources1.getIdentifier(str3, null, null);
            Spinner localSpinner = (Spinner)MoreSettingsActivity.this.findViewById(m);
            if ((localSpinner != null) && (localSpinner.equals(paramAnonymousAdapterView)));
            switch (i)
            {
            default:
              i += 1;
              break;
            case 0:
              Resources localResources2 = MoreSettingsActivity.this.getResources();
              String str4 = String.valueOf(ApplicationEngine.APPLICATION_PACKAGE_NAME);
              String str5 = str4 + ":id/" + "a_city_spinner";
              k = localResources2.getIdentifier(str5, null, null);
              break;
            case 1:
              Resources localResources3 = MoreSettingsActivity.this.getResources();
              String str6 = String.valueOf(ApplicationEngine.APPLICATION_PACKAGE_NAME);
              String str7 = str6 + ":id/" + "b_city_spinner";
              k = localResources3.getIdentifier(str7, null, null);
              break;
            case 2:
              Resources localResources4 = MoreSettingsActivity.this.getResources();
              String str8 = String.valueOf(ApplicationEngine.APPLICATION_PACKAGE_NAME);
              String str9 = str8 + ":id/" + "map_city_spinner";
              k = localResources4.getIdentifier(str9, null, null);
              break;
            case 3:
              Resources localResources5 = MoreSettingsActivity.this.getResources();
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
            MoreSettingsActivity localMoreSettingsActivity = MoreSettingsActivity.this;
            int i = getResourseId(paramAnonymousAdapterView);
            Spinner localSpinner = (Spinner)localMoreSettingsActivity.findViewById(i);
            MoreSettingsActivity.HopStopCityAdapter localHopStopCityAdapter = (MoreSettingsActivity.HopStopCityAdapter)localSpinner.getAdapter();
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
      localSpinner2.setOnItemSelectedListener(local2);
      return;
      int m = ApplicationEngine.getModel().getDefaultCityPosition(paramInt2);
      localSpinner1.setSelection(m);
      break;
      label240: int n = ApplicationEngine.getModel().getDefaultCountySelection();
      localSpinner2.setSelection(n);
    }
  }

  private void loadSettings()
  {
    setContentView(2130903116);
    AbstractAQuery localAbstractAQuery1 = ((AQuery)this.aq.id(2131492968)).text("Settings");
    if (ApplicationEngine.getModel().getIsMiles())
      AbstractAQuery localAbstractAQuery2 = ((AQuery)this.aq.id(2131493220)).checked(true);
    while (true)
    {
      setOnClickListenerForSettings();
      createDefaultCityPref();
      trackEvent("Settings Screen");
      Hashtable localHashtable = new Hashtable();
      String str = ApplicationEngine.getModel().getDefaultCityId();
      Object localObject = localHashtable.put("defaultcity", str);
      update(152035, localHashtable, null, null);
      return;
      AbstractAQuery localAbstractAQuery3 = ((AQuery)this.aq.id(2131493221)).checked(true);
    }
  }

  private void setOnClickListenerForSettings()
  {
    AbstractAQuery localAbstractAQuery1 = ((AQuery)this.aq.id(2131493220)).clicked(this, "milesClicked");
    AbstractAQuery localAbstractAQuery2 = ((AQuery)this.aq.id(2131493221)).clicked(this, "kilometersClicked");
  }

  public void kilometersClicked(View paramView)
  {
    ApplicationEngine.getModel().setIsMiles(false);
  }

  public void milesClicked(View paramView)
  {
    ApplicationEngine.getModel().setIsMiles(true);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AQuery localAQuery = new AQuery(this);
    this.aq = localAQuery;
    loadSettings();
  }

  protected void onPause()
  {
    boolean bool = ApplicationEngine.getModel().getIsMiles();
    setSharedPreferenceBoolean("distance_settings", bool);
    super.onPause();
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
 * Qualified Name:     com.hopstop.ClientView.MoreSettingsActivity
 * JD-Core Version:    0.6.2
 */