package com.hopstop.ClientView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.hopstop.ClientModel.Model;
import com.hopstop.ClientModel.directions.ViewStep;
import com.hopstop.ClientModel.directions.ViewStepAddress;
import com.hopstop.ClientModel.directions.ViewStepDirections;
import com.hopstop.ClientModel.directions.ViewStepTotal;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.ui.BaseActivity;
import com.hopstop.ui.PageNames;
import java.util.ArrayList;
import java.util.Hashtable;

public class MoreMyTripsActivity extends BaseActivity
{
  private Handler alertHandlerMsg;
  private AlertDialog alertMsg;
  private AlertDialog.Builder builderMsg;
  private int myTripCount = 0;

  public MoreMyTripsActivity()
  {
    Handler local1 = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        if (paramAnonymousMessage.what == 1)
        {
          MoreMyTripsActivity localMoreMyTripsActivity1 = MoreMyTripsActivity.this;
          AlertDialog localAlertDialog1 = MoreMyTripsActivity.this.builderMsg.create();
          localMoreMyTripsActivity1.alertMsg = localAlertDialog1;
          MoreMyTripsActivity.this.alertMsg.show();
          return;
        }
        if (paramAnonymousMessage.what == 9)
        {
          MoreMyTripsActivity.this.alertMsg.dismiss();
          return;
        }
        if (paramAnonymousMessage.what != 2)
          return;
        MoreMyTripsActivity localMoreMyTripsActivity2 = MoreMyTripsActivity.this;
        AlertDialog localAlertDialog2 = MoreMyTripsActivity.this.builderMsg.create();
        localMoreMyTripsActivity2.alertMsg = localAlertDialog2;
        MoreMyTripsActivity.this.alertMsg.show();
      }
    };
    this.alertHandlerMsg = local1;
  }

  private void addSingleTripView(ArrayList<ViewStep> paramArrayList, LinearLayout paramLinearLayout, int paramInt)
  {
    final View localView = getLayoutInflater().inflate(2130903091, null);
    TextView localTextView1 = (TextView)localView.findViewById(2131493066);
    TextView localTextView2 = (TextView)localView.findViewById(2131493065);
    int i = 0 + 1;
    final ViewStepTotal localViewStepTotal = (ViewStepTotal)paramArrayList.get(0);
    int j = i + 1;
    final ViewStepAddress localViewStepAddress1 = (ViewStepAddress)paramArrayList.get(i);
    int k = paramArrayList.size();
    final ViewStepAddress localViewStepAddress2;
    label130: TextView localTextView3;
    label164: TextView localTextView4;
    if ((j >= k) || (!(paramArrayList.get(j) instanceof ViewStepDirections)))
    {
      localViewStepAddress2 = (ViewStepAddress)paramArrayList.get(j);
      if ((localViewStepTotal.getMyTripName() == null) || (paramInt < 0))
        break label368;
      String str1 = localViewStepTotal.getMyTripName();
      localTextView1.setText(str1);
      localTextView3 = (TextView)localView.findViewById(2131493068);
      if (localViewStepAddress1.getFullAddress1() == null)
        break label385;
      String str2 = localViewStepAddress1.getFullAddress1();
      localTextView3.setText(str2);
      localTextView4 = (TextView)localView.findViewById(2131493071);
      if (localViewStepAddress2.getFullAddress2() == null)
        break label395;
      String str3 = localViewStepAddress2.getFullAddress2();
      localTextView4.setText(str3);
    }
    while (true)
    {
      Button localButton1 = (Button)localView.findViewById(2131493072);
      MoreMyTripsActivity localMoreMyTripsActivity1 = this;
      final int m = paramInt;
      View.OnClickListener local2 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          StringBuilder localStringBuilder1 = new StringBuilder("MyTrips Click ");
          String str1 = localViewStepAddress1.getFullAddress1();
          StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append(" to ");
          String str2 = localViewStepAddress2.getFullAddress2();
          StringBuilder localStringBuilder3 = localStringBuilder2.append(str2).append(", routeId:");
          String str3 = localViewStepTotal.getRouteId();
          Crashlytics.log(str3);
          MoreMyTripsActivity localMoreMyTripsActivity = MoreMyTripsActivity.this;
          Intent localIntent1 = new Intent(localMoreMyTripsActivity, MoreMyTripsDirectionActivity.class);
          int i = m;
          Intent localIntent2 = localIntent1.putExtra("index", i);
          MoreMyTripsActivity.this.startActivityForResult(localIntent1, 6);
        }
      };
      localButton1.setOnClickListener(local2);
      Button localButton2 = (Button)localView.findViewById(2131493073);
      MoreMyTripsActivity localMoreMyTripsActivity2 = this;
      View.OnClickListener local3 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          MoreMyTripsActivity localMoreMyTripsActivity = MoreMyTripsActivity.this;
          Intent localIntent1 = new Intent(localMoreMyTripsActivity, DirectionsMainViewActivity.class);
          String str1 = ApplicationEngine.REVERSE_TRIP_START_ADDRESS;
          String str2 = localViewStepAddress1.getFullAddress1();
          Intent localIntent2 = localIntent1.putExtra(str1, str2);
          String str3 = ApplicationEngine.REVERSE_TRIP_END_ADDRESS;
          String str4 = localViewStepAddress2.getFullAddress2();
          Intent localIntent3 = localIntent1.putExtra(str3, str4);
          String str5 = ApplicationEngine.REVERSE_TRIP_START_CITY;
          String str6 = localViewStepAddress1.getCity1();
          Intent localIntent4 = localIntent1.putExtra(str5, str6);
          String str7 = ApplicationEngine.REVERSE_TRIP_END_CITY;
          String str8 = localViewStepAddress2.getCity2();
          Intent localIntent5 = localIntent1.putExtra(str7, str8);
          MoreMyTripsActivity.this.startActivityForResult(localIntent1, 1);
        }
      };
      localButton2.setOnClickListener(local3);
      if ((localViewStepAddress1.getFullAddress1().equals("Current Location (Approximate)")) || (localViewStepAddress2.getFullAddress2().equals("Current Location (Approximate)")))
        localButton2.setVisibility(8);
      Button localButton3 = (Button)localView.findViewById(2131493074);
      MoreMyTripsActivity localMoreMyTripsActivity3 = this;
      final int n = paramInt;
      View.OnClickListener local4 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          MoreMyTripsActivity localMoreMyTripsActivity = MoreMyTripsActivity.this;
          int i = n;
          View localView = localView;
          localMoreMyTripsActivity.delete_trip(i, localView);
        }
      };
      localButton3.setOnClickListener(local4);
      paramLinearLayout.addView(localView);
      return;
      j += 1;
      break;
      label368: localTextView2.setVisibility(8);
      localTextView1.setVisibility(8);
      break label130;
      label385: localTextView3.setVisibility(8);
      break label164;
      label395: localTextView4.setVisibility(8);
    }
  }

  private void addTripViews()
  {
    ArrayList localArrayList = ApplicationEngine.getModel().getRecentTrip();
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(2131493060);
    LinearLayout localLinearLayout2;
    int i;
    if (localArrayList != null)
    {
      addSingleTripView(localArrayList, localLinearLayout1, -1);
      findViewById(2131493060).findViewById(2131493074).setVisibility(8);
      localLinearLayout2 = (LinearLayout)findViewById(2131493062);
      if (ApplicationEngine.getModel().getMyTrips().size() == 0)
        findViewById(2131493063).setVisibility(0);
      i = 0;
    }
    while (true)
    {
      int j = ApplicationEngine.getModel().getMyTrips().size();
      if (i >= j)
      {
        int k = ApplicationEngine.getModel().getMyTrips().size();
        Crashlytics.setInt("NumberOfMyTripsSaved", k);
        return;
        findViewById(2131493061).setVisibility(0);
        break;
      }
      localArrayList = ApplicationEngine.getModel().getMyTrip(i);
      if (localArrayList != null)
        addSingleTripView(localArrayList, localLinearLayout2, i);
      i += 1;
    }
  }

  private void delete_trip_finished(View paramView)
  {
    paramView.setVisibility(8);
    paramView.invalidate();
    Toast.makeText(this, "Trip Deleted.", 0).show();
  }

  private void loadMyTrips()
  {
    setContentView(2130903090);
    addTripViews();
    int i = ApplicationEngine.getModel().getMyTrips().size();
    this.myTripCount = i;
    AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(this);
    this.builderMsg = localBuilder1;
    AlertDialog.Builder localBuilder2 = this.builderMsg.setTitle("Sorry!");
    AlertDialog localAlertDialog = this.builderMsg.create();
    this.alertMsg = localAlertDialog;
    String str1 = PageNames.MyTripMain;
    displayAds(str1);
    Hashtable localHashtable = new Hashtable();
    String str2 = ApplicationEngine.getModel().getDefaultCityId();
    Object localObject = localHashtable.put("defaultcity", str2);
    int j = ApplicationEngine.ZONE_DIRECTION_SEARCH;
    update(j, localHashtable, null, null);
  }

  protected void delete_trip(final int paramInt, final View paramView)
  {
    AlertDialog.Builder localBuilder1 = this.builderMsg.setTitle("Delete Trip");
    AlertDialog.Builder localBuilder2 = this.builderMsg.setMessage("Are you sure you want to delete this trip?");
    AlertDialog.Builder localBuilder3 = this.builderMsg;
    DialogInterface.OnClickListener local5 = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        MoreMyTripsActivity.this.dismissErrorMessage();
        Model localModel = ApplicationEngine.getModel();
        int i = paramInt;
        localModel.deleteMyTrip(i);
        MoreMyTripsActivity localMoreMyTripsActivity = MoreMyTripsActivity.this;
        View localView = paramView;
        localMoreMyTripsActivity.delete_trip_finished(localView);
      }
    };
    AlertDialog.Builder localBuilder4 = localBuilder3.setPositiveButton("Yes", local5);
    AlertDialog.Builder localBuilder5 = this.builderMsg;
    DialogInterface.OnClickListener local6 = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        MoreMyTripsActivity.this.dismissErrorMessage();
      }
    };
    AlertDialog.Builder localBuilder6 = localBuilder5.setNegativeButton("No", local6);
    Message localMessage = new Message();
    localMessage.what = 1;
    boolean bool = this.alertHandlerMsg.sendMessage(localMessage);
  }

  @SuppressLint({"HandlerLeak"})
  public void dismissErrorMessage()
  {
    Message localMessage = new Message();
    localMessage.what = 9;
    boolean bool = this.alertHandlerMsg.sendMessage(localMessage);
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    setResult(paramInt2, paramIntent);
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    try
    {
      loadMyTrips();
      String str = PageNames.MyTripMain;
      trackEvent(str);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void onResume()
  {
    int i = this.myTripCount;
    int j = ApplicationEngine.getModel().getMyTrips().size();
    if (i != j)
      loadMyTrips();
    super.onResume();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.MoreMyTripsActivity
 * JD-Core Version:    0.6.2
 */