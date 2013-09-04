package com.hopstop.ClientView;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.androidquery.AQuery;
import com.androidquery.AbstractAQuery;
import com.hopstop.ClientModel.Model;
import com.hopstop.ClientModel.ResponseStatus;
import com.hopstop.ClientModel.Schedules.Route;
import com.hopstop.ClientModel.Schedules.Row;
import com.hopstop.ClientModel.Schedules.SchedulesDetailsStopRequest;
import com.hopstop.ClientModel.Schedules.SchedulesDetailsStopResponce;
import com.hopstop.ClientModel.Schedules.Vehicle;
import com.hopstop.ClientModel.Schedules.stops.EndStop;
import com.hopstop.ClientModel.Schedules.stops.EndStopAfterInactive;
import com.hopstop.ClientModel.Schedules.stops.EndStopBeforeInactive;
import com.hopstop.ClientModel.Schedules.stops.InactiveEndStop;
import com.hopstop.ClientModel.Schedules.stops.InactiveStartStop;
import com.hopstop.ClientModel.Schedules.stops.InactiveStop;
import com.hopstop.ClientModel.Schedules.stops.StartStop;
import com.hopstop.ClientModel.Schedules.stops.Stop;
import com.hopstop.ClientModel.Schedules.stops.TransferEndStop;
import com.hopstop.ClientModel.Schedules.stops.TransferStartStop;
import com.hopstop.ClientModel.Schedules.stops.TransferStop;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.network.NetworkEngine;
import com.hopstop.network.NetworkSettings;
import com.hopstop.network.URLFactoryBuilder;
import com.hopstop.ui.BaseActivity;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class SchedulesDetailsActivity extends BaseActivity
{
  protected static final String ARRIVE_BY = "arrive_by";
  public static final String PAGE_NUMBER = "page_number";
  public static final String ROW_ID = "row_id";
  public static final String SCHEDULE_SESSION_ID = "schedule_session_id";
  private boolean _arrive_by;
  private String _pageId;
  private String _rowId;
  private String _scheduleSessionId;
  private AQuery aq;

  private void LoadList(ArrayList<Stop> paramArrayList)
  {
    SchedulesDetailsListAdapter localSchedulesDetailsListAdapter = new SchedulesDetailsListAdapter(this, paramArrayList);
    ListView localListView = ((AQuery)this.aq.id(2131493177)).getListView();
    localListView.setAdapter(localSchedulesDetailsListAdapter);
    AdapterView.OnItemClickListener local2 = new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
      }
    };
    localListView.setOnItemClickListener(local2);
  }

  private void dismissProgressBar()
  {
    AbstractAQuery localAbstractAQuery = ((AQuery)this.aq.id(2131493176)).gone();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    String str1 = getIntent().getStringExtra("schedule_session_id");
    this._scheduleSessionId = str1;
    String str2 = getIntent().getStringExtra("row_id");
    this._rowId = str2;
    String str3 = getIntent().getStringExtra("page_number");
    this._pageId = str3;
    boolean bool = getIntent().getBooleanExtra("arrive_by", false);
    this._arrive_by = bool;
    setContentView(2130903103);
    Hashtable localHashtable = new Hashtable();
    String str4 = ApplicationEngine.getModel().getDefaultCityId();
    Object localObject = localHashtable.put("defaultcity", str4);
    update(121259, localHashtable, null, null);
    AQuery localAQuery1 = new AQuery(this);
    this.aq = localAQuery1;
    DetailsStopTask localDetailsStopTask = new DetailsStopTask(null);
    SchedulesDetailsStopRequest[] arrayOfSchedulesDetailsStopRequest = new SchedulesDetailsStopRequest[1];
    String str5 = this._scheduleSessionId;
    String str6 = this._rowId;
    String str7 = this._pageId;
    SchedulesDetailsStopRequest localSchedulesDetailsStopRequest = new SchedulesDetailsStopRequest(str5, str6, str7);
    arrayOfSchedulesDetailsStopRequest[0] = localSchedulesDetailsStopRequest;
    AsyncTask localAsyncTask = localDetailsStopTask.execute(arrayOfSchedulesDetailsStopRequest);
    trackEvent("Schedules Stops Screen");
    AQuery localAQuery2 = (AQuery)this.aq.id(2131492906);
    View.OnClickListener local1 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        SchedulesDetailsActivity localSchedulesDetailsActivity = SchedulesDetailsActivity.this;
        String str1 = String.valueOf(getClass().getName());
        String str2 = str1 + "Clicked on logo";
        localSchedulesDetailsActivity.LogD(str2);
        Context localContext = SchedulesDetailsActivity.this.getApplicationContext();
        Intent localIntent1 = new Intent(localContext, DirectionsMainViewActivity.class);
        Intent localIntent2 = localIntent1.setFlags(335544320);
        SchedulesDetailsActivity.this.getApplicationContext().startActivity(localIntent1);
      }
    };
    AbstractAQuery localAbstractAQuery = localAQuery2.clicked(local1);
  }

  protected void onDestroy()
  {
    super.onDestroy();
  }

  public void onResume()
  {
    super.onResume();
  }

  protected void showError(String paramString)
  {
    AbstractAQuery localAbstractAQuery1 = ((AQuery)this.aq.id(2131493177)).gone();
    AbstractAQuery localAbstractAQuery2 = ((AQuery)this.aq.id(2131493178)).visible();
    AbstractAQuery localAbstractAQuery3 = ((AQuery)this.aq.id(2131493178)).text(paramString);
    dismissProgressBar();
  }

  private class DetailsStopTask extends AsyncTask<SchedulesDetailsStopRequest, Void, SchedulesDetailsStopResponce>
  {
    private DetailsStopTask()
    {
    }

    private ArrayList<Stop> extractUsefullStops(ArrayList<Stop> paramArrayList, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      ArrayList localArrayList = new ArrayList();
      int i;
      if (paramBoolean2)
      {
        i = paramArrayList.size() + -1;
        if (!paramBoolean1)
          break label47;
      }
      label38: label47: for (int j = 0; ; j = paramInt1)
      {
        if (j <= i)
          break label53;
        return localArrayList;
        i = paramInt2;
        break;
      }
      label53: if ((paramBoolean1) && (j <= paramInt1))
        if (paramInt1 == 0)
        {
          Stop localStop1 = (Stop)paramArrayList.get(j);
          StartStop localStartStop = new StartStop(localStop1);
          boolean bool1 = localArrayList.add(localStartStop);
        }
      while (true)
      {
        j += 1;
        break;
        if (j == 0)
        {
          Stop localStop2 = (Stop)paramArrayList.get(j);
          InactiveStartStop localInactiveStartStop = new InactiveStartStop(localStop2);
          boolean bool2 = localArrayList.add(localInactiveStartStop);
        }
        else if (j != paramInt1)
        {
          Stop localStop3 = (Stop)paramArrayList.get(j);
          EndStopAfterInactive localEndStopAfterInactive = new EndStopAfterInactive(localStop3);
          boolean bool3 = localArrayList.add(localEndStopAfterInactive);
        }
        else
        {
          Stop localStop4 = (Stop)paramArrayList.get(j);
          InactiveStop localInactiveStop1 = new InactiveStop(localStop4);
          boolean bool4 = localArrayList.add(localInactiveStop1);
          continue;
          if ((paramBoolean2) && (j >= paramInt2))
          {
            if (paramInt2 != i)
            {
              Stop localStop5 = (Stop)paramArrayList.get(j);
              EndStop localEndStop = new EndStop(localStop5);
              boolean bool5 = localArrayList.add(localEndStop);
            }
            else if (j != i)
            {
              Stop localStop6 = (Stop)paramArrayList.get(j);
              InactiveEndStop localInactiveEndStop = new InactiveEndStop(localStop6);
              boolean bool6 = localArrayList.add(localInactiveEndStop);
            }
            else if (j != paramInt2)
            {
              Stop localStop7 = (Stop)paramArrayList.get(j);
              EndStopBeforeInactive localEndStopBeforeInactive = new EndStopBeforeInactive(localStop7);
              boolean bool7 = localArrayList.add(localEndStopBeforeInactive);
            }
            else
            {
              Stop localStop8 = (Stop)paramArrayList.get(j);
              InactiveStop localInactiveStop2 = new InactiveStop(localStop8);
              boolean bool8 = localArrayList.add(localInactiveStop2);
            }
          }
          else
          {
            if (j != paramInt2)
            {
              Stop localStop9 = (Stop)paramArrayList.get(j);
              TransferStartStop localTransferStartStop = new TransferStartStop(localStop9);
              boolean bool9 = localArrayList.add(localTransferStartStop);
              break label38;
            }
            if (j != paramInt1)
            {
              Stop localStop10 = (Stop)paramArrayList.get(j);
              TransferEndStop localTransferEndStop = new TransferEndStop(localStop10);
              boolean bool10 = localArrayList.add(localTransferEndStop);
            }
            else
            {
              Stop localStop11 = (Stop)paramArrayList.get(j);
              boolean bool11 = localArrayList.add(localStop11);
            }
          }
        }
      }
    }

    protected SchedulesDetailsStopResponce doInBackground(SchedulesDetailsStopRequest[] paramArrayOfSchedulesDetailsStopRequest)
    {
      SchedulesDetailsStopResponce localSchedulesDetailsStopResponce1 = new SchedulesDetailsStopResponce();
      SchedulesDetailsStopRequest localSchedulesDetailsStopRequest = paramArrayOfSchedulesDetailsStopRequest[0];
      try
      {
        String str1 = localSchedulesDetailsStopRequest.getRequestUrl();
        String str2 = NetworkSettings.keyNewAPI;
        String str3 = URLFactoryBuilder.GetScheduleInfo(str1, str2);
        String str4 = ApplicationEngine.getNetworkEngine().retrieve(str3);
        if (str4 != null)
        {
          Persister localPersister = new Persister();
          StringReader localStringReader = new StringReader(str4);
          localSchedulesDetailsStopResponce1 = (SchedulesDetailsStopResponce)localPersister.read(SchedulesDetailsStopResponce.class, localStringReader, false);
        }
        localSchedulesDetailsStopResponce2 = localSchedulesDetailsStopResponce1;
        return localSchedulesDetailsStopResponce2;
      }
      catch (IOException localIOException)
      {
        while (true)
          localSchedulesDetailsStopResponce2 = null;
      }
      catch (Exception localException)
      {
        while (true)
          SchedulesDetailsStopResponce localSchedulesDetailsStopResponce2 = null;
      }
    }

    protected void onPostExecute(SchedulesDetailsStopResponce paramSchedulesDetailsStopResponce)
    {
      if (paramSchedulesDetailsStopResponce == null)
        SchedulesDetailsActivity.this.showError("An error happened, please try again");
      while (true)
      {
        SchedulesDetailsActivity.this.dismissProgressBar();
        return;
        if ((paramSchedulesDetailsStopResponce.getRows() != null) && (paramSchedulesDetailsStopResponce.getRows().size() != 0))
          break;
        if (paramSchedulesDetailsStopResponce.getResponseStatus() == null)
        {
          SchedulesDetailsActivity localSchedulesDetailsActivity1 = SchedulesDetailsActivity.this;
          String str1 = SchedulesDetailsActivity.this.getString(2130968786);
          localSchedulesDetailsActivity1.showError(str1);
        }
        else
        {
          SchedulesDetailsActivity localSchedulesDetailsActivity2 = SchedulesDetailsActivity.this;
          String str2 = paramSchedulesDetailsStopResponce.getResponseStatus().getErrorString();
          localSchedulesDetailsActivity2.showError(str2);
        }
      }
      StringBuilder localStringBuilder1 = new StringBuilder("From ");
      String str3 = paramSchedulesDetailsStopResponce.getStation1Name();
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str3).append(" to ");
      String str4 = paramSchedulesDetailsStopResponce.getStation2Name();
      String str5 = str4;
      ((TextView)SchedulesDetailsActivity.this.findViewById(2131493174)).setText(str5);
      if (SchedulesDetailsActivity.this._arrive_by);
      ArrayList localArrayList1;
      ArrayList localArrayList3;
      for (String str6 = "Arrive by: "; ; str6 = "Depart at: ")
      {
        TextView localTextView = (TextView)SchedulesDetailsActivity.this.findViewById(2131493175);
        String str7 = String.valueOf(str6);
        StringBuilder localStringBuilder3 = new StringBuilder(str7);
        String str8 = paramSchedulesDetailsStopResponce.getStartTimeVerb();
        String str9 = str8;
        localTextView.setText(str9);
        AbstractAQuery localAbstractAQuery = ((AQuery)SchedulesDetailsActivity.this.aq.id(2131493173)).visible();
        localArrayList1 = new ArrayList();
        Row localRow = (Row)paramSchedulesDetailsStopResponce.getRows().get(0);
        ArrayList localArrayList2 = localRow.getTransfers();
        localArrayList3 = localRow.getRoutes();
        if ((localArrayList2 != null) && ((localArrayList3 == null) || (localArrayList3.size() != 1)))
          break label410;
        Route localRoute1 = (Route)localArrayList3.get(0);
        String str10 = localRoute1.getVehicle().getName();
        TransferStop localTransferStop1 = new TransferStop(str10);
        boolean bool1 = localArrayList1.add(localTransferStop1);
        ArrayList localArrayList4 = localRoute1.getStops();
        int i = localRoute1.getStartStopIdx();
        int j = localRoute1.getEndStopIdx();
        ArrayList localArrayList5 = extractUsefullStops(localArrayList4, i, j, true, true);
        boolean bool2 = localArrayList1.addAll(localArrayList5);
        SchedulesDetailsActivity.this.LoadList(localArrayList1);
        break;
      }
      label410: Route localRoute2 = (Route)localArrayList3.get(0);
      String str11 = localRoute2.getVehicle().getName();
      TransferStop localTransferStop2 = new TransferStop(str11);
      boolean bool3 = localArrayList1.add(localTransferStop2);
      ArrayList localArrayList6 = localRoute2.getStops();
      int k = localRoute2.getStartStopIdx();
      int m = localRoute2.getEndStopIdx();
      ArrayList localArrayList7 = extractUsefullStops(localArrayList6, k, m, true, false);
      boolean bool4 = localArrayList1.addAll(localArrayList7);
      int n = localArrayList3.size();
      int i1 = 1;
      label505: ArrayList localArrayList8;
      int i2;
      int i3;
      boolean bool6;
      if (i1 < n)
      {
        Route localRoute3 = (Route)localArrayList3.get(i1);
        String str12 = localRoute3.getVehicle().getName();
        TransferStop localTransferStop3 = new TransferStop(str12);
        boolean bool5 = localArrayList1.add(localTransferStop3);
        localArrayList8 = localRoute3.getStops();
        i2 = localRoute3.getStartStopIdx();
        i3 = localRoute3.getEndStopIdx();
        bool6 = false;
        int i4 = n + -1;
        if (i1 == i4)
          break label629;
      }
      label629: for (boolean bool7 = true; ; bool7 = false)
      {
        ArrayList localArrayList9 = extractUsefullStops(localArrayList8, i2, i3, bool6, bool7);
        boolean bool8 = localArrayList1.addAll(localArrayList9);
        i1 += 1;
        break label505;
        break;
      }
    }
  }

  public class SchedulesDetailsListAdapter extends ArrayAdapter<Stop>
  {
    private ArrayList<Stop> stops;

    public SchedulesDetailsListAdapter(ArrayList<Stop> arg2)
    {
      super(2130903108, localList);
      this.stops = localList;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView1 = paramView;
      Stop localStop = (Stop)this.stops.get(paramInt);
      SchedulesDetailsActivity.ViewDetailsHolder localViewDetailsHolder;
      if (localView1 == null)
      {
        LayoutInflater localLayoutInflater = (LayoutInflater)SchedulesDetailsActivity.this.getSystemService("layout_inflater");
        localViewDetailsHolder = new SchedulesDetailsActivity.ViewDetailsHolder();
        localView1 = localLayoutInflater.inflate(2130903104, null);
        View localView2 = localView1.findViewById(2131493180);
        localViewDetailsHolder.da_view = localView2;
        TextView localTextView1 = (TextView)localView1.findViewById(2131493181);
        localViewDetailsHolder.depart_arrival = localTextView1;
        ImageView localImageView = (ImageView)localView1.findViewById(2131493183);
        localViewDetailsHolder.stop_image = localImageView;
        TextView localTextView2 = (TextView)localView1.findViewById(2131493184);
        localViewDetailsHolder.stop_name = localTextView2;
        TextView localTextView3 = (TextView)localView1.findViewById(2131493185);
        localViewDetailsHolder.stop_time = localTextView3;
        localView1.setTag(localViewDetailsHolder);
      }
      while ((localStop instanceof TransferStop))
      {
        localViewDetailsHolder.da_view.setVisibility(8);
        localViewDetailsHolder.stop_image.setVisibility(8);
        TextView localTextView4 = localViewDetailsHolder.stop_name;
        String str1 = ((TransferStop)localStop).getActionsText();
        localTextView4.setText(str1);
        localViewDetailsHolder.stop_name.setGravity(83);
        localViewDetailsHolder.stop_time.setVisibility(8);
        return localView1;
        localViewDetailsHolder = (SchedulesDetailsActivity.ViewDetailsHolder)localView1.getTag();
      }
      localViewDetailsHolder.da_view.setVisibility(0);
      localViewDetailsHolder.depart_arrival.setVisibility(4);
      localViewDetailsHolder.stop_image.setVisibility(0);
      localViewDetailsHolder.stop_time.setVisibility(0);
      label314: TextView localTextView6;
      if ((localStop instanceof StartStop))
      {
        localViewDetailsHolder.stop_image.setImageResource(2130837626);
        localViewDetailsHolder.depart_arrival.setText(2130968732);
        localViewDetailsHolder.depart_arrival.setVisibility(0);
        TextView localTextView5 = localViewDetailsHolder.stop_name;
        String str2 = localStop.getName();
        localTextView5.setText(str2);
        localViewDetailsHolder.stop_name.setGravity(3);
        localTextView6 = localViewDetailsHolder.stop_time;
        if (localStop.getDepartTimeVerb() == null)
          break label633;
      }
      label633: for (String str3 = localStop.getDepartTimeVerb(); ; str3 = localStop.getArriveTimeVerb())
      {
        localTextView6.setText(str3);
        break;
        if ((localStop instanceof EndStopAfterInactive))
        {
          localViewDetailsHolder.stop_image.setImageResource(2130837625);
          localViewDetailsHolder.depart_arrival.setText(2130968732);
          localViewDetailsHolder.depart_arrival.setVisibility(0);
          break label314;
        }
        if ((localStop instanceof TransferStartStop))
        {
          localViewDetailsHolder.stop_image.setImageResource(2130837624);
          break label314;
        }
        if ((localStop instanceof TransferEndStop))
        {
          localViewDetailsHolder.stop_image.setImageResource(2130837626);
          localViewDetailsHolder.depart_arrival.setText(2130968734);
          localViewDetailsHolder.depart_arrival.setVisibility(0);
          break label314;
        }
        if ((localStop instanceof EndStop))
        {
          localViewDetailsHolder.stop_image.setImageResource(2130837624);
          localViewDetailsHolder.depart_arrival.setText(2130968733);
          localViewDetailsHolder.depart_arrival.setVisibility(0);
          break label314;
        }
        if ((localStop instanceof EndStopBeforeInactive))
        {
          localViewDetailsHolder.stop_image.setImageResource(2130837625);
          localViewDetailsHolder.depart_arrival.setText(2130968733);
          localViewDetailsHolder.depart_arrival.setVisibility(0);
          break label314;
        }
        if ((localStop instanceof InactiveStartStop))
        {
          localViewDetailsHolder.stop_image.setImageResource(2130837561);
          break label314;
        }
        if ((localStop instanceof InactiveEndStop))
        {
          localViewDetailsHolder.stop_image.setImageResource(2130837559);
          break label314;
        }
        if ((localStop instanceof InactiveStop))
        {
          localViewDetailsHolder.stop_image.setImageResource(2130837560);
          break label314;
        }
        localViewDetailsHolder.stop_image.setImageResource(2130837625);
        break label314;
      }
    }

    public boolean isEnabled(int paramInt)
    {
      return false;
    }
  }

  static class ViewDetailsHolder
  {
    public View da_view;
    public TextView depart_arrival;
    public ImageView stop_image;
    public TextView stop_name;
    public TextView stop_time;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.SchedulesDetailsActivity
 * JD-Core Version:    0.6.2
 */