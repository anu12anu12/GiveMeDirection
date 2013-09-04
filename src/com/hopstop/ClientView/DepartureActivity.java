package com.hopstop.ClientView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.TimePicker;
import com.androidquery.AQuery;
import com.androidquery.AbstractAQuery;
import com.hopstop.ClientModel.Model;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.ui.BaseActivity;
import com.hopstop.ui.PageNames;
import java.util.Hashtable;

public class DepartureActivity extends BaseActivity
{
  private AQuery aq;
  private Spinner mDaySpinner;
  private Model model;
  private RadioGroup.OnCheckedChangeListener radioGroupDepartOrArriveChangedListener;
  private TimePicker tp;

  public DepartureActivity()
  {
    RadioGroup.OnCheckedChangeListener local1 = new RadioGroup.OnCheckedChangeListener()
    {
      public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
      {
        DepartureActivity localDepartureActivity = DepartureActivity.this;
        boolean bool = DepartureActivity.this.getIsArriveBy();
        localDepartureActivity.setUpTitle(bool);
      }
    };
    this.radioGroupDepartOrArriveChangedListener = local1;
  }

  private void completeSettings()
  {
    this.tp.clearFocus();
    Model localModel1 = this.model;
    boolean bool = getIsArriveBy();
    localModel1.setIsArriveBy(bool);
    Model localModel2 = this.model;
    int i = getWeekDay();
    localModel2.set_selection_for_day(i);
    Model localModel3 = this.model;
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = pad(getHourOfDay());
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(":");
    String str2 = pad(getMinutes());
    String str3 = str2;
    localModel3.setTime(str3);
    Intent localIntent = new Intent();
    setResult(1, localIntent);
    finish();
  }

  private int getHourOfDay()
  {
    return this.tp.getCurrentHour().intValue();
  }

  private boolean getIsArriveBy()
  {
    if (((AQuery)this.aq.find(2131492913)).isChecked());
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  private int getMinutes()
  {
    return this.tp.getCurrentMinute().intValue();
  }

  private int getWeekDay()
  {
    return this.mDaySpinner.getSelectedItemPosition();
  }

  private static String pad(int paramInt)
  {
    if (paramInt >= 10);
    StringBuilder localStringBuilder;
    String str2;
    for (String str1 = String.valueOf(paramInt); ; str1 = str2)
    {
      return str1;
      localStringBuilder = new StringBuilder("0");
      str2 = String.valueOf(paramInt);
    }
  }

  private void setUpRouteType(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      AbstractAQuery localAbstractAQuery1 = ((AQuery)this.aq.find(2131492913)).checked(true);
      return;
    }
    AbstractAQuery localAbstractAQuery2 = ((AQuery)this.aq.find(2131492912)).checked(true);
  }

  private void setUpTitle(boolean paramBoolean)
  {
    AQuery localAQuery = (AQuery)this.aq.id(2131492907);
    if (paramBoolean);
    for (String str = getString(2130968624); ; str = getString(2130968623))
    {
      AbstractAQuery localAbstractAQuery = localAQuery.text(str);
      return;
    }
  }

  public void onBackPressed()
  {
    completeSettings();
    super.onBackPressed();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903051);
    AQuery localAQuery = new AQuery(this);
    this.aq = localAQuery;
    Model localModel = ApplicationEngine.getModel();
    this.model = localModel;
    boolean bool1 = this.model.getIsArriveBy();
    setUpRouteType(bool1);
    boolean bool2 = this.model.getIsArriveBy();
    setUpTitle(bool2);
    RadioGroup localRadioGroup = (RadioGroup)findViewById(2131492911);
    if (localRadioGroup != null);
    RadioGroup.OnCheckedChangeListener localOnCheckedChangeListener = this.radioGroupDepartOrArriveChangedListener;
    localRadioGroup.setOnCheckedChangeListener(localOnCheckedChangeListener);
    Spinner localSpinner1 = (Spinner)findViewById(2131492915);
    this.mDaySpinner = localSpinner1;
    ArrayAdapter localArrayAdapter = ArrayAdapter.createFromResource(this, 2131099648, 2130903124);
    localArrayAdapter.setDropDownViewResource(17367049);
    this.mDaySpinner.setAdapter(localArrayAdapter);
    Spinner localSpinner2 = this.mDaySpinner;
    int i = this.model.return_selection_from_day();
    localSpinner2.setSelection(i);
    View localView1 = findViewById(2131492910);
    TimePicker localTimePicker1 = (TimePicker)findViewById(2131492917);
    this.tp = localTimePicker1;
    String[] arrayOfString = this.model.getTime().split(":");
    TimePicker localTimePicker2 = this.tp;
    Integer localInteger1 = Integer.valueOf(Integer.parseInt(arrayOfString[0]));
    localTimePicker2.setCurrentHour(localInteger1);
    TimePicker localTimePicker3 = this.tp;
    Integer localInteger2 = Integer.valueOf(Integer.parseInt(arrayOfString[1]));
    localTimePicker3.setCurrentMinute(localInteger2);
    Button localButton1 = (Button)findViewById(2131492904);
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DepartureActivity.this.finish();
      }
    };
    localButton1.setOnClickListener(local2);
    View localView2 = findViewById(2131492906);
    View.OnClickListener local3 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Context localContext = DepartureActivity.this.getApplicationContext();
        Intent localIntent1 = new Intent(localContext, DirectionsMainViewActivity.class);
        Intent localIntent2 = localIntent1.setFlags(335544320);
        DepartureActivity.this.getApplicationContext().startActivity(localIntent1);
      }
    };
    localView2.setOnClickListener(local3);
    Button localButton2 = (Button)findViewById(2131492908);
    View.OnClickListener local4 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DepartureActivity.this.completeSettings();
      }
    };
    localButton2.setOnClickListener(local4);
    Hashtable localHashtable = new Hashtable();
    String str1 = ApplicationEngine.getModel().getDefaultCityId();
    Object localObject = localHashtable.put("defaultcity", str1);
    int j = ApplicationEngine.ZONE_DIRECTION_OPTIONS;
    update(j, localHashtable, null, null);
    String str2 = PageNames.DirectionDeparture;
    displayAds(str2);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.DepartureActivity
 * JD-Core Version:    0.6.2
 */