package com.hopstop.ClientView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.hopstop.ClientModel.Model;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.ui.BaseActivity;
import com.hopstop.ui.PageNames;
import java.util.Hashtable;

public class MapOptionActivity extends BaseActivity
  implements View.OnClickListener, RadioGroup.OnCheckedChangeListener
{
  private RadioGroup _radio_group;
  private Button direction_from;
  private Button direction_to;
  private Model model;
  private RadioButton show_bus_stations;
  private RadioButton show_subway_and_bus_stations;
  private RadioButton show_subway_stations;

  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    String str = "";
    switch (paramInt)
    {
    default:
    case 2131493034:
    case 2131493035:
    case 2131493036:
    }
    while (true)
    {
      this.model.setMapMode(str);
      Intent localIntent = new Intent();
      setResult(1, localIntent);
      finish();
      return;
      str = "s";
      continue;
      str = "b";
      continue;
      str = "a";
    }
  }

  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default:
      return;
    case 2131493038:
      Intent localIntent1 = new Intent();
      setResult(2, localIntent1);
      finish();
      return;
    case 2131493039:
    }
    Intent localIntent2 = new Intent();
    setResult(3, localIntent2);
    finish();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    boolean bool = requestWindowFeature(1);
    setContentView(2130903078);
    Hashtable localHashtable = new Hashtable();
    String str1 = ApplicationEngine.getModel().getDefaultCityId();
    Object localObject = localHashtable.put("defaultcity", str1);
    int i = ApplicationEngine.ZONE_STREET_MAP_OPTIONS;
    update(i, localHashtable, null, null);
    Model localModel = ApplicationEngine.getModel();
    this.model = localModel;
    Button localButton1 = (Button)findViewById(2131493029);
    View.OnClickListener local1 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MapOptionActivity.this.finish();
      }
    };
    localButton1.setOnClickListener(local1);
    RadioGroup localRadioGroup = (RadioGroup)findViewById(2131493033);
    this._radio_group = localRadioGroup;
    RadioButton localRadioButton1 = (RadioButton)findViewById(2131493034);
    this.show_subway_stations = localRadioButton1;
    RadioButton localRadioButton2 = (RadioButton)findViewById(2131493035);
    this.show_bus_stations = localRadioButton2;
    RadioButton localRadioButton3 = (RadioButton)findViewById(2131493036);
    this.show_subway_and_bus_stations = localRadioButton3;
    String str2 = this.model.getMapMode();
    if (str2.equals("s"))
      this.show_subway_stations.setChecked(true);
    while (true)
    {
      Button localButton2 = (Button)findViewById(2131493039);
      this.direction_from = localButton2;
      Button localButton3 = (Button)findViewById(2131493038);
      this.direction_to = localButton3;
      this.direction_from.setOnClickListener(this);
      this.direction_to.setOnClickListener(this);
      this._radio_group.setOnCheckedChangeListener(this);
      String str3 = PageNames.MapOption;
      displayAds(str3);
      return;
      if (str2.equals("b"))
        this.show_bus_stations.setChecked(true);
      else if (str2.equals("a"))
        this.show_subway_and_bus_stations.setChecked(true);
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.MapOptionActivity
 * JD-Core Version:    0.6.2
 */