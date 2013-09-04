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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.androidquery.AQuery;
import com.androidquery.AbstractAQuery;
import com.hopstop.ClientController.HSAsyncTask;
import com.hopstop.ClientModel.Model;
import com.hopstop.ClientModel.ResponseStatus;
import com.hopstop.ClientModel.Schedules.Day;
import com.hopstop.ClientModel.Schedules.Row;
import com.hopstop.ClientModel.Schedules.SchedulesSearchRequest;
import com.hopstop.ClientModel.Schedules.SchedulesSearchResponse;
import com.hopstop.ClientModel.Schedules.Station;
import com.hopstop.ClientModel.Schedules.Transfer;
import com.hopstop.ClientModel.Schedules.Vehicle;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.network.NetworkEngine;
import com.hopstop.network.NetworkSettings;
import com.hopstop.network.URLFactoryBuilder;
import com.hopstop.ui.BaseActivity;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class SchedulesResultActivity extends BaseActivity
{
  protected static final String ARRIVE_BY_KEY = "ArriveBy";
  protected static final String DAY_KEY = "DaySelected";
  protected static final String END_STATION_ID_KEY = "EndStationId";
  protected static final String END_STATION_NAME_KEY = "EndStationName";
  public static String SCHEDULES_DEFAULT_STATION_GROUP_KEY = "SchedulesDefaultStationGroup";
  protected static final String START_STATION_ID_KEY = "StartStationId";
  protected static final String START_STATION_NAME_KEY = "StartStationName";
  protected static final String STATION_GROUP_ID_KEY = "StationGroupId";
  protected static final String STATION_GROUP_NAME_KEY = "StationGroupName";
  protected static final String TIME_KEY = "TimeSelected";
  private AQuery aq;
  private boolean arriveBy;
  private CallAPITask callAPItask;
  private int dayValue;
  private String endStationIdValue;
  private String endStationNameValue;
  private String startStationIdValue;
  private String startStationNameValue;
  private String stationGroupIdValue;
  private String stationGroupNameValue;
  private int timeValue;

  private void LoadList(ArrayList<Row> paramArrayList, String paramString)
  {
    SchedulesResultListAdapter localSchedulesResultListAdapter = new SchedulesResultListAdapter(this, paramArrayList, paramString);
    ListView localListView = ((AQuery)this.aq.id(2131493177)).getListView();
    localListView.setAdapter(localSchedulesResultListAdapter);
    AdapterView.OnItemClickListener local2 = new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        SchedulesResultActivity.SchedulesResultListAdapter localSchedulesResultListAdapter = (SchedulesResultActivity.SchedulesResultListAdapter)paramAnonymousAdapterView.getAdapter();
        String str1 = String.valueOf(((Row)localSchedulesResultListAdapter.getItem(paramAnonymousInt)).getId());
        SchedulesResultActivity localSchedulesResultActivity = SchedulesResultActivity.this;
        Intent localIntent1 = new Intent(localSchedulesResultActivity, SchedulesDetailsActivity.class);
        String str2 = localSchedulesResultListAdapter.getScheduleSessionId();
        Intent localIntent2 = localIntent1.putExtra("schedule_session_id", str2);
        Intent localIntent3 = localIntent1.putExtra("row_id", str1);
        Intent localIntent4 = localIntent1.putExtra("page_number", "1");
        boolean bool = SchedulesResultActivity.this.arriveBy;
        Intent localIntent5 = localIntent1.putExtra("arrive_by", bool);
        SchedulesResultActivity.this.startActivity(localIntent1);
      }
    };
    localListView.setOnItemClickListener(local2);
  }

  private void dismissProgressBar()
  {
    AbstractAQuery localAbstractAQuery = ((AQuery)this.aq.id(2131493176)).gone();
  }

  public void GoHome()
  {
    Context localContext = getApplicationContext();
    Intent localIntent1 = new Intent(localContext, DirectionsMainViewActivity.class);
    Intent localIntent2 = localIntent1.setFlags(335544320);
    getApplicationContext().startActivity(localIntent1);
  }

  protected void LoadScreen(SchedulesSearchResponse paramSchedulesSearchResponse)
  {
    if (paramSchedulesSearchResponse == null)
      showError("An error happened, please try again");
    while (true)
    {
      dismissProgressBar();
      return;
      if ((paramSchedulesSearchResponse.getRows() != null) && (paramSchedulesSearchResponse.getRows().size() != 0))
        break;
      if (paramSchedulesSearchResponse.getResponseStatus() == null)
      {
        showError(2130968786);
      }
      else
      {
        String str1 = paramSchedulesSearchResponse.getResponseStatus().getErrorString();
        showError(str1);
      }
    }
    AQuery localAQuery1 = (AQuery)this.aq.id(2131493187);
    StringBuilder localStringBuilder1 = new StringBuilder("From ");
    String str2 = this.startStationNameValue;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str2).append(" to ");
    String str3 = this.endStationNameValue;
    String str4 = str3;
    AbstractAQuery localAbstractAQuery1 = localAQuery1.text(str4);
    if (paramSchedulesSearchResponse.getArriveBy() == 0);
    for (String str5 = "Depart at: "; ; str5 = "Arrive by: ")
    {
      AQuery localAQuery2 = (AQuery)this.aq.id(2131493188);
      String str6 = String.valueOf(str5);
      StringBuilder localStringBuilder3 = new StringBuilder(str6);
      String str7 = paramSchedulesSearchResponse.getStartTimeVerb();
      String str8 = str7;
      AbstractAQuery localAbstractAQuery2 = localAQuery2.text(str8);
      AbstractAQuery localAbstractAQuery3 = ((AQuery)this.aq.id(2131493173)).visible();
      ArrayList localArrayList = paramSchedulesSearchResponse.getRows();
      String str9 = paramSchedulesSearchResponse.getId();
      LoadList(localArrayList, str9);
      break;
    }
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    String str1 = getIntent().getStringExtra("StationGroupId");
    this.stationGroupIdValue = str1;
    String str2 = getIntent().getStringExtra("StartStationId");
    this.startStationIdValue = str2;
    String str3 = getIntent().getStringExtra("EndStationId");
    this.endStationIdValue = str3;
    String str4 = getIntent().getStringExtra("StartStationName");
    this.startStationNameValue = str4;
    String str5 = getIntent().getStringExtra("EndStationName");
    this.endStationNameValue = str5;
    String str6 = getIntent().getStringExtra("StationGroupName");
    this.stationGroupNameValue = str6;
    int i = getIntent().getIntExtra("DaySelected", 1);
    this.dayValue = i;
    int j = getIntent().getIntExtra("TimeSelected", 0);
    this.timeValue = j;
    boolean bool1 = getIntent().getBooleanExtra("ArriveBy", false);
    this.arriveBy = bool1;
    String str7 = this.stationGroupIdValue;
    String str8 = this.startStationIdValue;
    String str9 = this.endStationIdValue;
    Day[] arrayOfDay = Day.values();
    int k = this.dayValue;
    Day localDay = arrayOfDay[k];
    int m = this.timeValue;
    boolean bool2 = this.arriveBy;
    SchedulesSearchRequest localSchedulesSearchRequest = new SchedulesSearchRequest(str7, str8, str9, localDay, m, bool2);
    setContentView(2130903107);
    Hashtable localHashtable = new Hashtable();
    String str10 = ApplicationEngine.getModel().getDefaultCityId();
    Object localObject = localHashtable.put("defaultcity", str10);
    update(121259, localHashtable, null, null);
    AQuery localAQuery1 = new AQuery(this);
    this.aq = localAQuery1;
    AQuery localAQuery2 = (AQuery)this.aq.id(2131492968);
    String str11 = String.valueOf(this.stationGroupNameValue);
    String str12 = str11 + " schedule";
    AbstractAQuery localAbstractAQuery1 = localAQuery2.text(str12);
    CallAPITask localCallAPITask1 = new CallAPITask(null);
    this.callAPItask = localCallAPITask1;
    CallAPITask localCallAPITask2 = this.callAPItask;
    SchedulesSearchRequest[] arrayOfSchedulesSearchRequest = new SchedulesSearchRequest[1];
    arrayOfSchedulesSearchRequest[0] = localSchedulesSearchRequest;
    AsyncTask localAsyncTask = localCallAPITask2.execute(arrayOfSchedulesSearchRequest);
    trackEvent("Schedules Result Screen");
    AQuery localAQuery3 = (AQuery)this.aq.id(2131492906);
    View.OnClickListener local1 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        SchedulesResultActivity localSchedulesResultActivity = SchedulesResultActivity.this;
        String str1 = String.valueOf(getClass().getName());
        String str2 = str1 + "Clicked on logo";
        localSchedulesResultActivity.LogD(str2);
        Context localContext = SchedulesResultActivity.this.getApplicationContext();
        Intent localIntent1 = new Intent(localContext, DirectionsMainViewActivity.class);
        Intent localIntent2 = localIntent1.setFlags(335544320);
        SchedulesResultActivity.this.getApplicationContext().startActivity(localIntent1);
      }
    };
    AbstractAQuery localAbstractAQuery2 = localAQuery3.clicked(local1);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (this.callAPItask.isCancelled())
      return;
    boolean bool = this.callAPItask.cancel(true);
  }

  protected void onPause()
  {
    super.onPause();
  }

  protected void showError(int paramInt)
  {
    String str = getString(paramInt);
    showError(str);
  }

  protected void showError(String paramString)
  {
    AbstractAQuery localAbstractAQuery1 = ((AQuery)this.aq.id(2131493177)).gone();
    AbstractAQuery localAbstractAQuery2 = ((AQuery)this.aq.id(2131493178)).visible();
    AbstractAQuery localAbstractAQuery3 = ((AQuery)this.aq.id(2131493178)).text(paramString);
    dismissProgressBar();
  }

  private class CallAPITask extends HSAsyncTask<SchedulesSearchRequest, Void, SchedulesSearchResponse>
  {
    private CallAPITask()
    {
    }

    protected SchedulesSearchResponse doInBackground(SchedulesSearchRequest[] paramArrayOfSchedulesSearchRequest)
    {
      SchedulesSearchResponse localSchedulesSearchResponse = new SchedulesSearchResponse();
      SchedulesSearchRequest localSchedulesSearchRequest = paramArrayOfSchedulesSearchRequest[0];
      try
      {
        String str1 = localSchedulesSearchRequest.getRequestUrl();
        String str2 = NetworkSettings.keyNewAPI;
        String str3 = URLFactoryBuilder.GetSchedulesSearch(str1, str2);
        String str4 = ApplicationEngine.getNetworkEngine().retrieve(str3);
        if (str4 != null)
        {
          Persister localPersister = new Persister();
          StringReader localStringReader = new StringReader(str4);
          localSchedulesSearchResponse = (SchedulesSearchResponse)localPersister.read(SchedulesSearchResponse.class, localStringReader, false);
        }
        return localSchedulesSearchResponse;
      }
      catch (IOException localIOException)
      {
        while (true)
        {
          String str5 = SchedulesResultActivity.this.getString(2130968784);
          Error(localIOException, str5);
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          String str6 = SchedulesResultActivity.this.getString(2130968785);
          Error(localException, str6);
        }
      }
    }

    protected void onCancelled()
    {
      SchedulesResultActivity.this.LogD("SchedulesResultActivity, CallAPITask cancelled");
    }

    protected void onPostExecute(SchedulesSearchResponse paramSchedulesSearchResponse)
    {
      if (hasError())
      {
        SchedulesResultActivity localSchedulesResultActivity = SchedulesResultActivity.this;
        String str = getErrorString();
        localSchedulesResultActivity.showError(str);
        return;
      }
      SchedulesResultActivity.this.LoadScreen(paramSchedulesSearchResponse);
    }

    protected void onPreExecute()
    {
    }

    protected void onProgressUpdate(Void[] paramArrayOfVoid)
    {
    }
  }

  static class ListViewItemHolder
  {
    public TextView duration;
    public TextView start_end_time;
    LinearLayout transfer_view;
    public TextView vehicle_name;
  }

  static class ListViewItemTransferHolder
  {
    public TextView station;
    public TextView time;
  }

  public class SchedulesResultListAdapter extends ArrayAdapter<Row>
  {
    private LayoutInflater inflater;
    private ArrayList<Row> rows;
    private String sessionId;

    public SchedulesResultListAdapter(ArrayList<Row> paramString, String arg3)
    {
      super(2130903108, localList);
      this.rows = localList;
      Object localObject;
      this.sessionId = localObject;
      LayoutInflater localLayoutInflater = (LayoutInflater)paramString.getSystemService("layout_inflater");
      this.inflater = localLayoutInflater;
    }

    String TimeWeightLoss(String paramString)
    {
      return paramString.replace("hour", "h").replace("hours", "h").replace("mins", "min");
    }

    public String getScheduleSessionId()
    {
      return this.sessionId;
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      SchedulesResultActivity.ListViewItemHolder localListViewItemHolder;
      Iterator localIterator;
      if (paramView == null)
      {
        paramView = this.inflater.inflate(2130903108, null);
        localListViewItemHolder = new SchedulesResultActivity.ListViewItemHolder();
        TextView localTextView1 = (TextView)paramView.findViewById(2131493189);
        localListViewItemHolder.start_end_time = localTextView1;
        TextView localTextView2 = (TextView)paramView.findViewById(2131493190);
        localListViewItemHolder.duration = localTextView2;
        TextView localTextView3 = (TextView)paramView.findViewById(2131493191);
        localListViewItemHolder.vehicle_name = localTextView3;
        LinearLayout localLinearLayout = (LinearLayout)paramView.findViewById(2131493192);
        localListViewItemHolder.transfer_view = localLinearLayout;
        paramView.setTag(localListViewItemHolder);
        TextView localTextView4 = localListViewItemHolder.start_end_time;
        String str1 = String.valueOf(((Row)this.rows.get(paramInt)).getDepartTimeVerb());
        StringBuilder localStringBuilder1 = new StringBuilder(str1).append(" - ");
        String str2 = ((Row)this.rows.get(paramInt)).getArriveTimeVerb();
        String str3 = str2;
        localTextView4.setText(str3);
        TextView localTextView5 = localListViewItemHolder.duration;
        String str4 = ((Row)this.rows.get(paramInt)).getTotalTimeVerb();
        String str5 = TimeWeightLoss(str4);
        localTextView5.setText(str5);
        TextView localTextView6 = localListViewItemHolder.vehicle_name;
        String str6 = ((Row)this.rows.get(paramInt)).getVehicle().getName();
        localTextView6.setText(str6);
        if (localListViewItemHolder.transfer_view.getChildCount() > 0)
          localListViewItemHolder.transfer_view.removeAllViews();
        if ((this.rows.get(paramInt) != null) && (((Row)this.rows.get(paramInt)).getTransfers() != null))
        {
          localIterator = ((Row)this.rows.get(paramInt)).getTransfers().iterator();
          label316: if (localIterator.hasNext())
            break label378;
        }
        if (((Row)this.rows.get(paramInt)).getNextAvailable() != 1)
          break label517;
        localListViewItemHolder.start_end_time.setTypeface(null, 1);
        localListViewItemHolder.duration.setTypeface(null, 1);
      }
      while (true)
      {
        return paramView;
        localListViewItemHolder = (SchedulesResultActivity.ListViewItemHolder)paramView.getTag();
        break;
        label378: Transfer localTransfer = (Transfer)localIterator.next();
        View localView = this.inflater.inflate(2130903109, paramViewGroup, false);
        TextView localTextView7 = (TextView)localView.findViewById(2131493193);
        StringBuilder localStringBuilder2 = new StringBuilder("Transfer ");
        String str7 = localTransfer.getStation().getName();
        String str8 = str7;
        localTextView7.setText(str8);
        TextView localTextView8 = (TextView)localView.findViewById(2131493194);
        StringBuilder localStringBuilder3 = new StringBuilder("Depart at: ");
        String str9 = localTransfer.getDepartTimeVerb();
        String str10 = str9;
        localTextView8.setText(str10);
        localListViewItemHolder.transfer_view.addView(localView);
        break label316;
        label517: localListViewItemHolder.start_end_time.setTypeface(null, 0);
        localListViewItemHolder.duration.setTypeface(null, 0);
      }
    }

    public boolean isEnabled(int paramInt)
    {
      return true;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.SchedulesResultActivity
 * JD-Core Version:    0.6.2
 */