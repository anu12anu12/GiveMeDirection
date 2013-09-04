package com.hopstop.ClientView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.hopstop.ClientController.Controller;
import com.hopstop.ClientModel.Model;
import com.hopstop.ClientModel.ServiceAdvisorResponse;
import com.hopstop.ClientView.anim.ViewStepSubwayVehicle;
import com.hopstop.ClientView.anim.ViewStepSubwayVehicleSubClass;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.core.ApplicationEngine.UiCallBack;
import com.hopstop.network.NetworkSettings;
import com.hopstop.ui.BaseActivity;
import com.hopstop.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class MoreSubwayAdvisoriesActivity extends BaseActivity
{
  private String _timeOfDownload;
  private String good_service;
  private ProgressDialog m_ProgressDialog = null;
  private SubwayAdapter m_adapter;
  private ArrayList<ViewStepSubwayVehicle> m_subwayVehicles = null;
  private Runnable returnRes;
  private int service_advisor_type;
  private Runnable viewSubwayVehicle;

  public MoreSubwayAdvisoriesActivity()
  {
    int i = NetworkSettings.GET_SERVICE_ADVISOR_SUBWAY_TRAIN;
    this.service_advisor_type = i;
    this.good_service = "GOOD SERVICE";
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        int i = MoreSubwayAdvisoriesActivity.this.m_subwayVehicles.size();
        if (i > 0)
          ((TextView)MoreSubwayAdvisoriesActivity.this.findViewById(2131493268)).setVisibility(8);
        int j = 0;
        while (true)
        {
          if (j >= i)
          {
            MoreSubwayAdvisoriesActivity.this.m_ProgressDialog.dismiss();
            MoreSubwayAdvisoriesActivity.this.m_adapter.notifyDataSetChanged();
            return;
          }
          MoreSubwayAdvisoriesActivity.SubwayAdapter localSubwayAdapter = MoreSubwayAdvisoriesActivity.this.m_adapter;
          ViewStepSubwayVehicle localViewStepSubwayVehicle = (ViewStepSubwayVehicle)MoreSubwayAdvisoriesActivity.this.m_subwayVehicles.get(j);
          localSubwayAdapter.add(localViewStepSubwayVehicle);
          j += 1;
        }
      }
    };
    this.returnRes = local1;
  }

  public void GoHome()
  {
    Context localContext = getApplicationContext();
    Intent localIntent1 = new Intent(localContext, DirectionsMainViewActivity.class);
    Intent localIntent2 = localIntent1.setFlags(335544320);
    getApplicationContext().startActivity(localIntent1);
  }

  protected void getSubwayVehicle()
  {
    try
    {
      Controller localController = ApplicationEngine.getController();
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this;
      Integer localInteger = Integer.valueOf(this.service_advisor_type);
      arrayOfObject[1] = localInteger;
      ApplicationEngine.UiCallBack local4 = new ApplicationEngine.UiCallBack()
      {
        public void onStatusChanged(int paramAnonymousInt1, int paramAnonymousInt2, Object[] paramAnonymousArrayOfObject)
        {
          int i = NetworkSettings.SUCCESS_GET_SERVICE_ADVISOR;
          ServiceAdvisorResponse localServiceAdvisorResponse;
          if (paramAnonymousInt2 != i)
          {
            localServiceAdvisorResponse = (ServiceAdvisorResponse)paramAnonymousArrayOfObject[0];
            int j = MoreSubwayAdvisoriesActivity.this.service_advisor_type;
            int k = NetworkSettings.GET_SERVICE_ADVISOR_SUBWAY_TRAIN;
            if (j != k)
            {
              MoreSubwayAdvisoriesActivity localMoreSubwayAdvisoriesActivity1 = MoreSubwayAdvisoriesActivity.this;
              ArrayList localArrayList1 = localServiceAdvisorResponse.getViewStepSubwayTrainVehicle();
              ArrayList localArrayList2 = new ArrayList(localArrayList1);
              localMoreSubwayAdvisoriesActivity1.m_subwayVehicles = localArrayList2;
              MoreSubwayAdvisoriesActivity localMoreSubwayAdvisoriesActivity2 = MoreSubwayAdvisoriesActivity.this;
              String str1 = localServiceAdvisorResponse.getTimeOfDownload();
              localMoreSubwayAdvisoriesActivity2._timeOfDownload = str1;
              ApplicationEngine.getModel().setServiceAdvisorResponse(localServiceAdvisorResponse);
            }
          }
          do
          {
            int i3;
            do
            {
              MoreSubwayAdvisoriesActivity localMoreSubwayAdvisoriesActivity3 = MoreSubwayAdvisoriesActivity.this;
              Runnable localRunnable = MoreSubwayAdvisoriesActivity.this.returnRes;
              localMoreSubwayAdvisoriesActivity3.runOnUiThread(localRunnable);
              return;
              int m = MoreSubwayAdvisoriesActivity.this.service_advisor_type;
              int n = NetworkSettings.GET_SERVICE_ADVISOR_REGIONAL_RAIL;
              if (m != n)
              {
                MoreSubwayAdvisoriesActivity localMoreSubwayAdvisoriesActivity4 = MoreSubwayAdvisoriesActivity.this;
                ArrayList localArrayList3 = localServiceAdvisorResponse.getViewStepRegionalRailVehicle();
                ArrayList localArrayList4 = new ArrayList(localArrayList3);
                localMoreSubwayAdvisoriesActivity4.m_subwayVehicles = localArrayList4;
                break;
              }
              int i1 = MoreSubwayAdvisoriesActivity.this.service_advisor_type;
              int i2 = NetworkSettings.GET_SERVICE_ADVISOR_BUS;
              if (i1 == i2)
                break;
              MoreSubwayAdvisoriesActivity localMoreSubwayAdvisoriesActivity5 = MoreSubwayAdvisoriesActivity.this;
              ArrayList localArrayList5 = localServiceAdvisorResponse.getViewStepBusVehicle();
              ArrayList localArrayList6 = new ArrayList(localArrayList5);
              localMoreSubwayAdvisoriesActivity5.m_subwayVehicles = localArrayList6;
              break;
              i3 = NetworkSettings.FAIL_GET_SERVICE_ADVISOR;
            }
            while (paramAnonymousInt2 == i3);
            localServiceAdvisorResponse = ApplicationEngine.getModel().getServiceAdvisorResponse();
          }
          while (localServiceAdvisorResponse == null);
          int i4 = MoreSubwayAdvisoriesActivity.this.service_advisor_type;
          int i5 = NetworkSettings.GET_SERVICE_ADVISOR_SUBWAY_TRAIN;
          if (i4 != i5)
          {
            MoreSubwayAdvisoriesActivity localMoreSubwayAdvisoriesActivity6 = MoreSubwayAdvisoriesActivity.this;
            ArrayList localArrayList7 = localServiceAdvisorResponse.getViewStepSubwayTrainVehicle();
            ArrayList localArrayList8 = new ArrayList(localArrayList7);
            localMoreSubwayAdvisoriesActivity6.m_subwayVehicles = localArrayList8;
          }
          while (true)
          {
            MoreSubwayAdvisoriesActivity localMoreSubwayAdvisoriesActivity7 = MoreSubwayAdvisoriesActivity.this;
            String str2 = localServiceAdvisorResponse.getTimeOfDownload();
            localMoreSubwayAdvisoriesActivity7._timeOfDownload = str2;
            break;
            int i6 = MoreSubwayAdvisoriesActivity.this.service_advisor_type;
            int i7 = NetworkSettings.GET_SERVICE_ADVISOR_REGIONAL_RAIL;
            if (i6 != i7)
            {
              MoreSubwayAdvisoriesActivity localMoreSubwayAdvisoriesActivity8 = MoreSubwayAdvisoriesActivity.this;
              ArrayList localArrayList9 = localServiceAdvisorResponse.getViewStepRegionalRailVehicle();
              ArrayList localArrayList10 = new ArrayList(localArrayList9);
              localMoreSubwayAdvisoriesActivity8.m_subwayVehicles = localArrayList10;
            }
            else
            {
              int i8 = MoreSubwayAdvisoriesActivity.this.service_advisor_type;
              int i9 = NetworkSettings.GET_SERVICE_ADVISOR_BUS;
              if (i8 != i9)
              {
                MoreSubwayAdvisoriesActivity localMoreSubwayAdvisoriesActivity9 = MoreSubwayAdvisoriesActivity.this;
                ArrayList localArrayList11 = localServiceAdvisorResponse.getViewStepBusVehicle();
                ArrayList localArrayList12 = new ArrayList(localArrayList11);
                localMoreSubwayAdvisoriesActivity9.m_subwayVehicles = localArrayList12;
              }
            }
          }
        }
      };
      localController.handleViewRequest(501, arrayOfObject, local4);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    int i = NetworkSettings.GET_SERVICE_ADVISOR_SUBWAY_TRAIN;
    int j = localIntent.getIntExtra("Service_Advisor_Type", i);
    this.service_advisor_type = j;
    setContentView(2130903130);
    Hashtable localHashtable = new Hashtable();
    String str = ApplicationEngine.getModel().getDefaultCityId();
    Object localObject = localHashtable.put("defaultcity", str);
    int k = ApplicationEngine.ZONE_ADVISORIES;
    update(k, localHashtable, null, null);
    View localView = findViewById(2131492906);
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Context localContext = MoreSubwayAdvisoriesActivity.this.getApplicationContext();
        Intent localIntent1 = new Intent(localContext, DirectionsMainViewActivity.class);
        Intent localIntent2 = localIntent1.setFlags(335544320);
        MoreSubwayAdvisoriesActivity.this.getApplicationContext().startActivity(localIntent1);
      }
    };
    localView.setOnClickListener(local2);
    ArrayList localArrayList1 = new ArrayList();
    this.m_subwayVehicles = localArrayList1;
    ArrayList localArrayList2 = this.m_subwayVehicles;
    SubwayAdapter localSubwayAdapter1 = new SubwayAdapter(this, 2130903132, localArrayList2);
    this.m_adapter = localSubwayAdapter1;
    ListView localListView = (ListView)findViewById(2131493267);
    SubwayAdapter localSubwayAdapter2 = this.m_adapter;
    localListView.setAdapter(localSubwayAdapter2);
    Runnable local3 = new Runnable()
    {
      public void run()
      {
        MoreSubwayAdvisoriesActivity.this.getSubwayVehicle();
      }
    };
    this.viewSubwayVehicle = local3;
    trackEvent("Advisories Subway Screen");
    Runnable localRunnable = this.viewSubwayVehicle;
    new Thread(null, localRunnable, "MagentoBackground").start();
    ProgressDialog localProgressDialog = ProgressDialog.show(this, "Please wait...", "Retrieving data ...", true);
    this.m_ProgressDialog = localProgressDialog;
    initiateAsyncImageLoader();
  }

  private class SubwayAdapter extends ArrayAdapter<ViewStepSubwayVehicle>
  {
    private ArrayList<ViewStepSubwayVehicle> items;

    public SubwayAdapter(int paramArrayList, ArrayList<ViewStepSubwayVehicle> arg3)
    {
      super(i, localList);
      this.items = localList;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      final ViewStepSubwayVehicle localViewStepSubwayVehicle = (ViewStepSubwayVehicle)this.items.get(paramInt);
      MoreSubwayAdvisoriesActivity.ViewHolder localViewHolder;
      ImageView localImageView3;
      if (localView == null)
      {
        LayoutInflater localLayoutInflater = (LayoutInflater)MoreSubwayAdvisoriesActivity.this.getSystemService("layout_inflater");
        localViewHolder = new MoreSubwayAdvisoriesActivity.ViewHolder();
        localView = localLayoutInflater.inflate(2130903132, null);
        ImageView localImageView1 = (ImageView)localView.findViewById(2131493271);
        localViewHolder.imageView = localImageView1;
        TextView localTextView1 = (TextView)localView.findViewById(2131493272);
        localViewHolder.textView = localTextView1;
        ImageView localImageView2 = (ImageView)localView.findViewById(2131493273);
        localViewHolder.rightArrow = localImageView2;
        localView.setTag(localViewHolder);
        View.OnClickListener local1 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (localViewStepSubwayVehicle.getStatusDescription() == null)
              return;
            String str1 = localViewStepSubwayVehicle.getStatus();
            String str2 = MoreSubwayAdvisoriesActivity.this.good_service;
            if (str1.equalsIgnoreCase(str2))
              return;
            MoreSubwayAdvisoriesActivity localMoreSubwayAdvisoriesActivity = MoreSubwayAdvisoriesActivity.this;
            Intent localIntent1 = new Intent(localMoreSubwayAdvisoriesActivity, MoreSubwayAdvisoriesDetailActivity.class);
            ViewStepSubwayVehicle localViewStepSubwayVehicle = localViewStepSubwayVehicle;
            String str3 = MoreSubwayAdvisoriesActivity.this._timeOfDownload;
            ViewStepSubwayVehicleSubClass localViewStepSubwayVehicleSubClass = localViewStepSubwayVehicle.getDetails(str3);
            Intent localIntent2 = localIntent1.putExtra("advisorVehicleCopy", localViewStepSubwayVehicleSubClass);
            byte[] arrayOfByte = Util.getBytesFromBitmap(localViewStepSubwayVehicle.getBitmap());
            Intent localIntent3 = localIntent1.putExtra("advisorVehicleImage", arrayOfByte);
            MoreSubwayAdvisoriesActivity.this.startActivityForResult(localIntent1, 1);
          }
        };
        localView.setOnClickListener(local1);
        if (localViewStepSubwayVehicle != null)
        {
          localImageView3 = (ImageView)localViewHolder.imageView;
          TextView localTextView2 = (TextView)localViewHolder.textView;
          if (!localViewStepSubwayVehicle.hasIcon())
            break label268;
          MoreSubwayAdvisoriesActivity localMoreSubwayAdvisoriesActivity = MoreSubwayAdvisoriesActivity.this;
          String str1 = localViewStepSubwayVehicle.getURL();
          localMoreSubwayAdvisoriesActivity.loadImageAsync(str1, localImageView3);
          label192: if (localTextView2 != null)
          {
            String str2 = localViewStepSubwayVehicle.getStatus();
            localTextView2.setText(str2);
          }
          String str3 = localViewStepSubwayVehicle.getStatus();
          String str4 = MoreSubwayAdvisoriesActivity.this.good_service;
          if (!str3.equalsIgnoreCase(str4))
            break label278;
          localView.setEnabled(false);
          localViewHolder.rightArrow.setVisibility(4);
        }
      }
      while (true)
      {
        return localView;
        localViewHolder = (MoreSubwayAdvisoriesActivity.ViewHolder)localView.getTag();
        break;
        label268: localViewStepSubwayVehicle.setImageView(localImageView3);
        break label192;
        label278: localView.setEnabled(true);
        localViewHolder.rightArrow.setVisibility(0);
      }
    }
  }

  static class ViewHolder
  {
    public View imageView;
    public View rightArrow;
    public View textView;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.MoreSubwayAdvisoriesActivity
 * JD-Core Version:    0.6.2
 */