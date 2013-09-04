package com.hopstop.ClientView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.hopstop.ClientModel.Model;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.network.NetworkSettings;
import com.hopstop.ui.BaseActivity;
import java.util.Hashtable;

public class MoreServiceAdvisorActivity extends BaseActivity
{
  private void registerSendFeedbackButton()
  {
    Button localButton = (Button)findViewById(2131493219);
    View.OnClickListener local5 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MoreServiceAdvisorActivity.this.sendAddAdvisoriesFeedbackEmail();
      }
    };
    localButton.setOnClickListener(local5);
  }

  private void sendAddAdvisoriesFeedbackEmail()
  {
    String str1 = getString(2130968653);
    String str2 = "\n\n\nSent from HopStop Android App " + str1;
    sendEmail("feedback@hopstop.com", "HopStop Android App - Feedback", str2);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903115);
    Hashtable localHashtable = new Hashtable();
    String str = ApplicationEngine.getModel().getDefaultCityId();
    Object localObject = localHashtable.put("defaultcity", str);
    int i = ApplicationEngine.ZONE_ADVISORIES;
    update(i, localHashtable, null, null);
    Button localButton1 = (Button)findViewById(2131493216);
    View.OnClickListener local1 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MoreServiceAdvisorActivity localMoreServiceAdvisorActivity1 = MoreServiceAdvisorActivity.this;
        Intent localIntent1 = new Intent(localMoreServiceAdvisorActivity1, MoreSubwayAdvisoriesActivity.class);
        int i = NetworkSettings.GET_SERVICE_ADVISOR_SUBWAY_TRAIN;
        Intent localIntent2 = localIntent1.putExtra("Service_Advisor_Type", i);
        MoreServiceAdvisorActivity localMoreServiceAdvisorActivity2 = MoreServiceAdvisorActivity.this;
        int j = NetworkSettings.GET_SERVICE_ADVISOR_SUBWAY_TRAIN;
        localMoreServiceAdvisorActivity2.startActivityForResult(localIntent1, j);
      }
    };
    localButton1.setOnClickListener(local1);
    Button localButton2 = (Button)findViewById(2131493217);
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MoreServiceAdvisorActivity localMoreServiceAdvisorActivity1 = MoreServiceAdvisorActivity.this;
        Intent localIntent1 = new Intent(localMoreServiceAdvisorActivity1, MoreSubwayAdvisoriesActivity.class);
        int i = NetworkSettings.GET_SERVICE_ADVISOR_REGIONAL_RAIL;
        Intent localIntent2 = localIntent1.putExtra("Service_Advisor_Type", i);
        MoreServiceAdvisorActivity localMoreServiceAdvisorActivity2 = MoreServiceAdvisorActivity.this;
        int j = NetworkSettings.GET_SERVICE_ADVISOR_REGIONAL_RAIL;
        localMoreServiceAdvisorActivity2.startActivityForResult(localIntent1, j);
      }
    };
    localButton2.setOnClickListener(local2);
    Button localButton3 = (Button)findViewById(2131493218);
    View.OnClickListener local3 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        MoreServiceAdvisorActivity localMoreServiceAdvisorActivity1 = MoreServiceAdvisorActivity.this;
        Intent localIntent1 = new Intent(localMoreServiceAdvisorActivity1, MoreSubwayAdvisoriesActivity.class);
        int i = NetworkSettings.GET_SERVICE_ADVISOR_BUS;
        Intent localIntent2 = localIntent1.putExtra("Service_Advisor_Type", i);
        MoreServiceAdvisorActivity localMoreServiceAdvisorActivity2 = MoreServiceAdvisorActivity.this;
        int j = NetworkSettings.GET_SERVICE_ADVISOR_BUS;
        localMoreServiceAdvisorActivity2.startActivityForResult(localIntent1, j);
      }
    };
    localButton3.setOnClickListener(local3);
    View localView = findViewById(2131492906);
    View.OnClickListener local4 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Context localContext = MoreServiceAdvisorActivity.this.getApplicationContext();
        Intent localIntent1 = new Intent(localContext, DirectionsMainViewActivity.class);
        Intent localIntent2 = localIntent1.setFlags(335544320);
        MoreServiceAdvisorActivity.this.getApplicationContext().startActivity(localIntent1);
      }
    };
    localView.setOnClickListener(local4);
    registerSendFeedbackButton();
    trackEvent("Advisories Main Screen");
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.MoreServiceAdvisorActivity
 * JD-Core Version:    0.6.2
 */