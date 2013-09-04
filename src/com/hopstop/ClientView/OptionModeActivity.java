package com.hopstop.ClientView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.ToggleButton;
import com.hopstop.ClientModel.DirectionMode;
import com.hopstop.ClientModel.Model;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.ui.BaseActivity;
import com.hopstop.ui.PageNames;
import com.hopstop.ui.SubwayRail;
import java.util.Hashtable;

public class OptionModeActivity extends BaseActivity
  implements View.OnClickListener, RadioGroup.OnCheckedChangeListener
{
  private RadioGroup _radio_group;
  private RadioGroup _radio_group2;
  private RadioButton bike;
  private RadioButton bus_only;
  private boolean isBikeEnabled;
  private Spinner lang;
  private Model model;
  private RadioButton more_transfers;
  private RadioButton more_walking;
  private RadioButton subway_rail_bus;
  private RadioButton subway_rail_only;
  private RadioButton taxi;
  private RadioButton walking_only;

  private void completeSettings()
  {
    RadioGroup localRadioGroup = getRadioGroup();
    String str1 = "";
    switch (localRadioGroup.getCheckedRadioButtonId())
    {
    default:
      this.model.getDirectionMode().setMode(str1);
      if (this._radio_group2.getCheckedRadioButtonId() == 2131493145)
        this.model.setTransferPriority(1);
      break;
    case 2131493136:
    case 2131493137:
    case 2131493138:
    case 2131493139:
    case 2131493140:
    case 2131493141:
    }
    while (true)
    {
      int i = this.lang.getSelectedItemPosition();
      Model localModel1 = ApplicationEngine.getModel();
      String str2 = ApplicationEngine.getModel().getShortLanguage(i);
      localModel1.setLanguage(str2);
      ToggleButton localToggleButton1 = (ToggleButton)findViewById(2131493148);
      Model localModel2 = this.model;
      boolean bool1 = localToggleButton1.isChecked();
      localModel2.setRegional_rail(bool1);
      ToggleButton localToggleButton2 = (ToggleButton)findViewById(2131493150);
      Model localModel3 = this.model;
      boolean bool2 = localToggleButton2.isChecked();
      localModel3.setPrivate_vehicles(bool2);
      ToggleButton localToggleButton3 = (ToggleButton)findViewById(2131493154);
      Model localModel4 = this.model;
      boolean bool3 = localToggleButton3.isChecked();
      localModel4.setWheelChairOn(bool3);
      ToggleButton localToggleButton4 = (ToggleButton)findViewById(2131493149);
      Model localModel5 = this.model;
      boolean bool4 = localToggleButton4.isChecked();
      localModel5.setIsExpressBusIncluded(bool4);
      ToggleButton localToggleButton5 = (ToggleButton)findViewById(2131493153);
      Model localModel6 = this.model;
      boolean bool5 = localToggleButton5.isChecked();
      localModel6.setIsSimplifiedDirections(bool5);
      ToggleButton localToggleButton6 = (ToggleButton)findViewById(2131493152);
      Model localModel7 = this.model;
      boolean bool6 = localToggleButton6.isChecked();
      localModel7.setIsSmartRouteEnabled(bool6);
      Intent localIntent = new Intent();
      setResult(1, localIntent);
      finish();
      return;
      str1 = "s";
      break;
      str1 = "b";
      break;
      str1 = "a";
      break;
      str1 = "w";
      break;
      str1 = "j";
      break;
      str1 = "z";
      break;
      this.model.setTransferPriority(0);
    }
  }

  private RadioGroup getRadioGroup()
  {
    return this._radio_group;
  }

  private void setRagionalRails()
  {
    RadioButton localRadioButton = (RadioButton)findViewById(2131493148);
    boolean bool = localRadioButton.isChecked();
    localRadioButton.setChecked(false);
  }

  public void onBackPressed()
  {
    completeSettings();
    super.onBackPressed();
  }

  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
  }

  public void onClick(View paramView)
  {
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    OptionModeActivity localOptionModeActivity1 = this;
    int i = 2130903098;
    localOptionModeActivity1.setContentView(i);
    boolean bool1 = getIntent().getBooleanExtra("bike_enabled", false);
    this.isBikeEnabled = bool1;
    Model localModel = ApplicationEngine.getModel();
    this.model = localModel;
    OptionModeActivity localOptionModeActivity2 = this;
    int j = 2131493131;
    View localView1 = localOptionModeActivity2.findViewById(j);
    OptionModeActivity localOptionModeActivity3 = this;
    int k = 2131493136;
    SubwayRail localSubwayRail = (SubwayRail)localOptionModeActivity3.findViewById(k);
    OptionModeActivity localOptionModeActivity4 = this;
    int m = 2131492904;
    Button localButton1 = (Button)localOptionModeActivity4.findViewById(m);
    View.OnClickListener local11 = new com/hopstop/ClientView/OptionModeActivity$1;
    View.OnClickListener local12 = local11;
    OptionModeActivity localOptionModeActivity5 = this;
    local12.<init>(localOptionModeActivity5);
    View.OnClickListener local13 = local11;
    localButton1.setOnClickListener(local13);
    OptionModeActivity localOptionModeActivity6 = this;
    int n = 2131492906;
    View localView2 = localOptionModeActivity6.findViewById(n);
    View.OnClickListener local21 = new com/hopstop/ClientView/OptionModeActivity$2;
    View.OnClickListener local22 = local21;
    OptionModeActivity localOptionModeActivity7 = this;
    local22.<init>(localOptionModeActivity7);
    View localView3 = localView2;
    View.OnClickListener local23 = local21;
    localView3.setOnClickListener(local23);
    OptionModeActivity localOptionModeActivity8 = this;
    int i1 = 2131492908;
    Button localButton2 = (Button)localOptionModeActivity8.findViewById(i1);
    View.OnClickListener local31 = new com/hopstop/ClientView/OptionModeActivity$3;
    View.OnClickListener local32 = local31;
    OptionModeActivity localOptionModeActivity9 = this;
    local32.<init>(localOptionModeActivity9);
    View.OnClickListener local33 = local31;
    localButton2.setOnClickListener(local33);
    OptionModeActivity localOptionModeActivity10 = this;
    int i2 = 2131493135;
    RadioGroup localRadioGroup1 = (RadioGroup)localOptionModeActivity10.findViewById(i2);
    this._radio_group = localRadioGroup1;
    RadioGroup localRadioGroup2 = this._radio_group;
    OptionModeActivity localOptionModeActivity11 = this;
    localRadioGroup2.setOnCheckedChangeListener(localOptionModeActivity11);
    OptionModeActivity localOptionModeActivity12 = this;
    int i3 = 2131493136;
    RadioButton localRadioButton1 = (RadioButton)localOptionModeActivity12.findViewById(i3);
    this.subway_rail_only = localRadioButton1;
    OptionModeActivity localOptionModeActivity13 = this;
    int i4 = 2131493137;
    RadioButton localRadioButton2 = (RadioButton)localOptionModeActivity13.findViewById(i4);
    this.bus_only = localRadioButton2;
    OptionModeActivity localOptionModeActivity14 = this;
    int i5 = 2131493138;
    RadioButton localRadioButton3 = (RadioButton)localOptionModeActivity14.findViewById(i5);
    this.subway_rail_bus = localRadioButton3;
    OptionModeActivity localOptionModeActivity15 = this;
    int i6 = 2131493139;
    RadioButton localRadioButton4 = (RadioButton)localOptionModeActivity15.findViewById(i6);
    this.walking_only = localRadioButton4;
    OptionModeActivity localOptionModeActivity16 = this;
    int i7 = 2131493140;
    RadioButton localRadioButton5 = (RadioButton)localOptionModeActivity16.findViewById(i7);
    this.taxi = localRadioButton5;
    OptionModeActivity localOptionModeActivity17 = this;
    int i8 = 2131493141;
    RadioButton localRadioButton6 = (RadioButton)localOptionModeActivity17.findViewById(i8);
    this.bike = localRadioButton6;
    RadioButton localRadioButton7 = this.bike;
    boolean bool2 = this.isBikeEnabled;
    localRadioButton7.setEnabled(bool2);
    String str1 = this.model.getDirectionMode().getMode();
    String str2 = "s";
    if (str1.equals(str2))
    {
      this.subway_rail_only.setChecked(true);
      OptionModeActivity localOptionModeActivity18 = this;
      int i9 = 2131493148;
      ToggleButton localToggleButton1 = (ToggleButton)localOptionModeActivity18.findViewById(i9);
      boolean bool3 = this.model.isRegional_rail();
      localToggleButton1.setChecked(bool3);
      View.OnClickListener local41 = new com/hopstop/ClientView/OptionModeActivity$4;
      View.OnClickListener local42 = local41;
      OptionModeActivity localOptionModeActivity19 = this;
      local42.<init>(localOptionModeActivity19);
      View.OnClickListener local43 = local41;
      localToggleButton1.setOnClickListener(local43);
      OptionModeActivity localOptionModeActivity20 = this;
      int i10 = 2131493150;
      ToggleButton localToggleButton2 = (ToggleButton)localOptionModeActivity20.findViewById(i10);
      boolean bool4 = this.model.isPrivate_vehicles();
      localToggleButton2.setChecked(bool4);
      OptionModeActivity localOptionModeActivity21 = this;
      int i11 = 2131493154;
      ToggleButton localToggleButton3 = (ToggleButton)localOptionModeActivity21.findViewById(i11);
      boolean bool5 = this.model.isWheelChairOn();
      localToggleButton3.setChecked(bool5);
      OptionModeActivity localOptionModeActivity22 = this;
      int i12 = 2131493149;
      ToggleButton localToggleButton4 = (ToggleButton)localOptionModeActivity22.findViewById(i12);
      boolean bool6 = this.model.getIsExpressBusIncluded();
      localToggleButton4.setChecked(bool6);
      OptionModeActivity localOptionModeActivity23 = this;
      int i13 = 2131493153;
      ToggleButton localToggleButton5 = (ToggleButton)localOptionModeActivity23.findViewById(i13);
      boolean bool7 = this.model.getIsSimplifiedDirections();
      localToggleButton5.setChecked(bool7);
      OptionModeActivity localOptionModeActivity24 = this;
      int i14 = 2131493152;
      ToggleButton localToggleButton6 = (ToggleButton)localOptionModeActivity24.findViewById(i14);
      boolean bool8 = this.model.getIsSmartRouteEnabled();
      localToggleButton6.setChecked(bool8);
      OptionModeActivity localOptionModeActivity25 = this;
      int i15 = 2131493156;
      Spinner localSpinner1 = (Spinner)localOptionModeActivity25.findViewById(i15);
      this.lang = localSpinner1;
      String[] arrayOfString1 = this.model.getLanguages();
      OptionModeActivity localOptionModeActivity26 = this;
      OptionModeActivity localOptionModeActivity27 = this;
      int i16 = 2130903085;
      String[] arrayOfString2 = arrayOfString1;
      HopStopLanguageAdapter localHopStopLanguageAdapter = new HopStopLanguageAdapter(localOptionModeActivity27, i16, arrayOfString2);
      this.lang.setAdapter(localHopStopLanguageAdapter);
      int i17 = 17367049;
      localHopStopLanguageAdapter.setDropDownViewResource(i17);
      Spinner localSpinner2 = this.lang;
      AdapterView.OnItemSelectedListener local51 = new com/hopstop/ClientView/OptionModeActivity$5;
      AdapterView.OnItemSelectedListener local52 = local51;
      OptionModeActivity localOptionModeActivity28 = this;
      local52.<init>(localOptionModeActivity28);
      localSpinner2.setOnItemSelectedListener(local51);
      Spinner localSpinner3 = this.lang;
      int i18 = ApplicationEngine.getModel().getSelectedLanguageId();
      localSpinner3.setSelection(i18);
      OptionModeActivity localOptionModeActivity29 = this;
      int i19 = 2131493143;
      RadioGroup localRadioGroup3 = (RadioGroup)localOptionModeActivity29.findViewById(i19);
      this._radio_group2 = localRadioGroup3;
      OptionModeActivity localOptionModeActivity30 = this;
      int i20 = 2131493145;
      RadioButton localRadioButton8 = (RadioButton)localOptionModeActivity30.findViewById(i20);
      this.more_walking = localRadioButton8;
      OptionModeActivity localOptionModeActivity31 = this;
      int i21 = 2131493144;
      RadioButton localRadioButton9 = (RadioButton)localOptionModeActivity31.findViewById(i21);
      this.more_transfers = localRadioButton9;
      int i22 = this.model.getTransferPriority();
      int i23 = 1;
      if (i22 != i23)
        break label1169;
      this.more_walking.setChecked(true);
    }
    while (true)
    {
      String str3 = PageNames.DirectionOptions;
      OptionModeActivity localOptionModeActivity32 = this;
      String str4 = str3;
      localOptionModeActivity32.displayAds(str4);
      Hashtable localHashtable = new Hashtable();
      String str5 = ApplicationEngine.getModel().getDefaultCityId();
      String str6 = "defaultcity";
      String str7 = str5;
      Object localObject = localHashtable.put(str6, str7);
      int i24 = ApplicationEngine.ZONE_DIRECTION_OPTIONS;
      OptionModeActivity localOptionModeActivity33 = this;
      int i25 = i24;
      String str8 = null;
      String str9 = null;
      localOptionModeActivity33.update(i25, localHashtable, str8, str9);
      return;
      String str10 = "b";
      if (str1.equals(str10))
      {
        this.bus_only.setChecked(true);
        break;
      }
      String str11 = "a";
      if (str1.equals(str11))
      {
        this.subway_rail_bus.setChecked(true);
        break;
      }
      String str12 = "w";
      if (str1.equals(str12))
      {
        this.walking_only.setChecked(true);
        break;
      }
      String str13 = "j";
      if (str1.equals(str13))
      {
        this.taxi.setChecked(true);
        break;
      }
      String str14 = "z";
      if (!str1.equals(str14))
        break;
      this.bike.setChecked(true);
      break;
      label1169: this.more_transfers.setChecked(true);
    }
  }

  private class HopStopLanguageAdapter extends ArrayAdapter<CharSequence>
  {
    private CharSequence[] items = null;

    public HopStopLanguageAdapter(Context paramInt, int paramArrayOfCharSequence, CharSequence[] arg4)
    {
      super(paramArrayOfCharSequence, arrayOfObject);
      this.items = arrayOfObject;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.OptionModeActivity
 * JD-Core Version:    0.6.2
 */