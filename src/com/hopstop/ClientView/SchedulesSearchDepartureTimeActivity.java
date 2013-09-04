package com.hopstop.ClientView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import com.androidquery.AQuery;
import com.androidquery.AbstractAQuery;
import com.hopstop.ClientModel.Model;
import com.hopstop.ClientModel.Schedules.Day;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.ui.BaseActivity;
import java.util.Hashtable;

public class SchedulesSearchDepartureTimeActivity extends BaseActivity
{
  public static final boolean ARRIVE_BY_DEFAULT = false;
  public static final String ARRIVE_BY_KEY = "arrive_by";
  public static final int DAY_DEFAULT = 1;
  public static final String DAY_KEY = "day_key";
  public static final int HOUR_DEFAULT = 1;
  public static final String HOUR_KEY = "hour_key";
  public static final int MINUTE_DEFAULT = 0;
  public static final String MINUTE_KEY = "minute_key";
  public static final boolean TIME_CHANGED_DEFAULT = false;
  public static final String TIME_CHANGED_KEY = "time_changed";
  private AQuery aq;
  RadioButton arriveByBtn;
  private boolean arrive_by = false;
  private int day_original = 1;
  TimePicker picker;
  Spinner spinner;
  private boolean timeChanged = false;

  public void cancel_click()
  {
    finish();
  }

  public void done_click()
  {
    int i = this.spinner.getSelectedItemPosition();
    int j = this.day_original;
    if (i != j)
      this.timeChanged = true;
    int k = this.spinner.getSelectedItemPosition();
    int m = this.picker.getCurrentHour().intValue();
    int n = this.picker.getCurrentMinute().intValue();
    if (this.arriveByBtn != null)
    {
      boolean bool1 = this.arriveByBtn.isChecked();
      this.arrive_by = bool1;
    }
    Intent localIntent1 = new Intent();
    Intent localIntent2 = localIntent1.putExtra("day_key", k);
    Intent localIntent3 = localIntent1.putExtra("hour_key", m);
    Intent localIntent4 = localIntent1.putExtra("minute_key", n);
    boolean bool2 = this.timeChanged;
    Intent localIntent5 = localIntent1.putExtra("time_changed", bool2);
    boolean bool3 = this.arrive_by;
    Intent localIntent6 = localIntent1.putExtra("arrive_by", bool3);
    setResult(-1, localIntent1);
    finish();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    int i = getIntent().getIntExtra("day_key", 1);
    int j = getIntent().getIntExtra("hour_key", 1);
    int k = getIntent().getIntExtra("minute_key", 0);
    boolean bool1 = getIntent().getBooleanExtra("time_changed", false);
    this.timeChanged = bool1;
    boolean bool2 = getIntent().getBooleanExtra("arrive_by", false);
    this.arrive_by = bool2;
    setContentView(2130903111);
    AQuery localAQuery = new AQuery(this);
    this.aq = localAQuery;
    Hashtable localHashtable = new Hashtable();
    String str = ApplicationEngine.getModel().getDefaultCityId();
    Object localObject = localHashtable.put("defaultcity", str);
    update(121259, localHashtable, null, null);
    this.day_original = i;
    RadioButton localRadioButton1 = (RadioButton)findViewById(2131492913);
    this.arriveByBtn = localRadioButton1;
    if (this.arriveByBtn != null)
    {
      RadioButton localRadioButton2 = this.arriveByBtn;
      boolean bool3 = this.arrive_by;
      localRadioButton2.setChecked(bool3);
    }
    ((TextView)findViewById(2131492968)).setText(2130968783);
    Spinner localSpinner = (Spinner)findViewById(2131493211);
    this.spinner = localSpinner;
    Day[] arrayOfDay = Day.values();
    ArrayAdapter localArrayAdapter = new ArrayAdapter(this, 2130903085, arrayOfDay);
    localArrayAdapter.setDropDownViewResource(17367049);
    this.spinner.setAdapter(localArrayAdapter);
    this.spinner.setSelection(i);
    TimePicker localTimePicker1 = (TimePicker)findViewById(2131493212);
    this.picker = localTimePicker1;
    TimePicker localTimePicker2 = this.picker;
    Integer localInteger1 = Integer.valueOf(j);
    localTimePicker2.setCurrentHour(localInteger1);
    TimePicker localTimePicker3 = this.picker;
    Integer localInteger2 = Integer.valueOf(k);
    localTimePicker3.setCurrentMinute(localInteger2);
    TimePicker localTimePicker4 = this.picker;
    TimePicker.OnTimeChangedListener local1 = new TimePicker.OnTimeChangedListener()
    {
      public void onTimeChanged(TimePicker paramAnonymousTimePicker, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        SchedulesSearchDepartureTimeActivity.this.timeChanged = true;
      }
    };
    localTimePicker4.setOnTimeChangedListener(local1);
    AbstractAQuery localAbstractAQuery1 = ((AQuery)this.aq.id(2131492908)).clicked(this, "done_click");
    AbstractAQuery localAbstractAQuery2 = ((AQuery)this.aq.id(2131492881)).clicked(this, "cancel_click");
    trackEvent("Schedules Search Departure Time Screen");
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.SchedulesSearchDepartureTimeActivity
 * JD-Core Version:    0.6.2
 */