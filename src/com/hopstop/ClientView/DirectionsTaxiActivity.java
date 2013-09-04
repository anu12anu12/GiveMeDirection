package com.hopstop.ClientView;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.hopstop.ClientModel.Model;
import com.hopstop.ClientModel.TaxiResponse;
import com.hopstop.ClientModel.directions.ViewStepAddress;
import com.hopstop.ClientModel.directions.ViewStepTaxi;
import com.hopstop.ClientModel.directions.ViewStepTotal;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.ui.BaseActivity;
import com.hopstop.ui.PageNames;
import com.hopstop.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class DirectionsTaxiActivity extends BaseActivity
{
  private View single_taxi;
  private TaxiResponse tr;

  private void addTaxis(TaxiResponse paramTaxiResponse)
  {
    ArrayList localArrayList1 = paramTaxiResponse.getViewStepTaxi();
    int i = 0;
    if ((localArrayList1.get(i) instanceof ViewStepTotal))
    {
      int j = 0;
      ViewStepTotal localViewStepTotal1 = (ViewStepTotal)localArrayList1.get(j);
      DirectionsTaxiActivity localDirectionsTaxiActivity1 = this;
      ViewStepTotal localViewStepTotal2 = localViewStepTotal1;
      localDirectionsTaxiActivity1.fillViewStepTotalData(localViewStepTotal2);
    }
    DirectionsTaxiActivity localDirectionsTaxiActivity2 = this;
    int k = 2131493288;
    TextView localTextView1 = (TextView)localDirectionsTaxiActivity2.findViewById(k);
    int m = 1;
    ViewStepAddress localViewStepAddress1 = (ViewStepAddress)localArrayList1.get(m);
    TextView localTextView2;
    ViewStepAddress localViewStepAddress2;
    if (localViewStepAddress1.getZip1() == null)
    {
      String str1 = localViewStepAddress1.getAddress();
      localTextView1.setText(str1);
      DirectionsTaxiActivity localDirectionsTaxiActivity3 = this;
      int n = 2131493290;
      localTextView2 = (TextView)localDirectionsTaxiActivity3.findViewById(n);
      int i1 = 2;
      localViewStepAddress2 = (ViewStepAddress)localArrayList1.get(i1);
      if (localViewStepAddress2.getZip2() != null)
        break label291;
      String str2 = localViewStepAddress2.getAddress();
      localTextView2.setText(str2);
    }
    ArrayList localArrayList2;
    LinearLayout localLinearLayout;
    LayoutInflater localLayoutInflater;
    while (true)
    {
      localArrayList2 = new java/util/ArrayList;
      int i2 = localArrayList1.size();
      int i3 = 3;
      int i4 = i2;
      List localList1 = localArrayList1.subList(i3, i4);
      ArrayList localArrayList3 = localArrayList2;
      List localList2 = localList1;
      localArrayList3.<init>(localList2);
      DirectionsTaxiActivity localDirectionsTaxiActivity4 = this;
      int i5 = 2131493291;
      localLinearLayout = (LinearLayout)localDirectionsTaxiActivity4.findViewById(i5);
      localLayoutInflater = getLayoutInflater();
      if (localLayoutInflater == null)
        return;
      if (localLinearLayout != null)
        break label346;
      return;
      String str3 = String.valueOf(localViewStepAddress1.getAddress());
      StringBuilder localStringBuilder1 = new StringBuilder(str3).append(", ");
      String str4 = localViewStepAddress1.getZip1();
      String str5 = str4;
      localTextView1.setText(str5);
      break;
      label291: String str6 = String.valueOf(localViewStepAddress2.getAddress());
      StringBuilder localStringBuilder2 = new StringBuilder(str6).append(", ");
      String str7 = localViewStepAddress2.getZip2();
      String str8 = str7;
      localTextView2.setText(str8);
    }
    label346: Iterator localIterator = localArrayList2.iterator();
    if (!localIterator.hasNext())
    {
      int i6 = 2130903102;
      ViewGroup localViewGroup1 = null;
      View localView1 = localLayoutInflater.inflate(i6, localViewGroup1);
      int i7 = 0;
      localView1.setVisibility(i7);
      int i8 = 2131493167;
      Button localButton1 = (Button)localView1.findViewById(i8);
      View.OnClickListener local41 = new com/hopstop/ClientView/DirectionsTaxiActivity$4;
      View.OnClickListener local42 = local41;
      DirectionsTaxiActivity localDirectionsTaxiActivity5 = this;
      TaxiResponse localTaxiResponse = paramTaxiResponse;
      local42.<init>(localDirectionsTaxiActivity5, localTaxiResponse);
      View.OnClickListener local43 = local41;
      localButton1.setOnClickListener(local43);
      int i9 = 2131493168;
      Button localButton2 = (Button)localView1.findViewById(i9);
      View.OnClickListener local51 = new com/hopstop/ClientView/DirectionsTaxiActivity$5;
      View.OnClickListener local52 = local51;
      DirectionsTaxiActivity localDirectionsTaxiActivity6 = this;
      local52.<init>(localDirectionsTaxiActivity6);
      View.OnClickListener local53 = local51;
      localButton2.setOnClickListener(local53);
      int i10 = 2131493073;
      Button localButton3 = (Button)localView1.findViewById(i10);
      View.OnClickListener local61 = new com/hopstop/ClientView/DirectionsTaxiActivity$6;
      View.OnClickListener local62 = local61;
      DirectionsTaxiActivity localDirectionsTaxiActivity7 = this;
      local62.<init>(localDirectionsTaxiActivity7);
      View.OnClickListener local63 = local61;
      localButton3.setOnClickListener(local63);
      localLinearLayout.addView(localView1);
      return;
    }
    ViewStepTaxi localViewStepTaxi = (ViewStepTaxi)localIterator.next();
    int i11 = 2130903117;
    ViewGroup localViewGroup2 = null;
    View localView2 = localLayoutInflater.inflate(i11, localViewGroup2);
    this.single_taxi = localView2;
    if (this.single_taxi == null)
      return;
    TextView localTextView3 = (TextView)this.single_taxi.findViewById(2131493223);
    String str9 = localViewStepTaxi.getName();
    localTextView3.setText(str9);
    TextView localTextView4 = (TextView)this.single_taxi.findViewById(2131493225);
    String str10 = localViewStepTaxi.getPhone();
    localTextView4.setText(str10);
    TextView localTextView5 = (TextView)this.single_taxi.findViewById(2131493224);
    if (localViewStepTaxi.getPrice() > 0.0F)
    {
      StringBuilder localStringBuilder3 = new StringBuilder("Price: $");
      String str11 = Util.roundMyDataTwoDecimal(localViewStepTaxi.getPrice());
      String str12 = str11;
      localTextView5.setText(str12);
    }
    while (true)
    {
      View localView3 = this.single_taxi;
      localLinearLayout.addView(localView3);
      break;
      String str13 = "";
      localTextView5.setText(str13);
    }
  }

  private void fillViewStepTotalData(ViewStepTotal paramViewStepTotal)
  {
    TextView localTextView1 = (TextView)findViewById(2131493259);
    String str1 = localTextView1.getText().toString();
    Object[] arrayOfObject1 = new Object[1];
    boolean bool = ApplicationEngine.getModel().getIsMiles();
    String str2 = paramViewStepTotal.getDistance(bool);
    arrayOfObject1[0] = str2;
    String str3 = String.format(str1, arrayOfObject1);
    localTextView1.setText(str3);
    TextView localTextView2 = (TextView)findViewById(2131493253);
    String str4 = localTextView2.getText().toString();
    Object[] arrayOfObject2 = new Object[1];
    String str5 = paramViewStepTotal.getDeparture();
    arrayOfObject2[0] = str5;
    String str6 = String.format(str4, arrayOfObject2);
    localTextView2.setText(str6);
    TextView localTextView3 = (TextView)findViewById(2131493255);
    String str7 = paramViewStepTotal.getDuration().replace("hours", "h").replace("hour", "h").replace("mins", "m").replace("min", "m");
    String str8 = localTextView3.getText().toString();
    Object[] arrayOfObject3 = new Object[1];
    arrayOfObject3[0] = str7;
    String str9 = String.format(str8, arrayOfObject3);
    localTextView3.setText(str9);
    TextView localTextView4 = (TextView)findViewById(2131493254);
    String str10 = localTextView4.getText().toString();
    Object[] arrayOfObject4 = new Object[1];
    String str11 = paramViewStepTotal.getArrival();
    arrayOfObject4[0] = str11;
    String str12 = String.format(str10, arrayOfObject4);
    localTextView4.setText(str12);
    TextView localTextView5 = (TextView)findViewById(2131493262);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131493260);
    if (!paramViewStepTotal.getFare().contains("0.00"))
    {
      String str13 = localTextView5.getText().toString();
      Object[] arrayOfObject5 = new Object[1];
      String str14 = paramViewStepTotal.getFare();
      arrayOfObject5[0] = str14;
      String str15 = String.format(str13, arrayOfObject5);
      localTextView5.setText(str15);
    }
    while (true)
    {
      TextView localTextView6 = (TextView)findViewById(2131493256);
      String str16 = localTextView6.getText().toString();
      Object[] arrayOfObject6 = new Object[1];
      Integer localInteger = Integer.valueOf(paramViewStepTotal.getWalkingTime());
      arrayOfObject6[0] = localInteger;
      String str17 = String.format(str16, arrayOfObject6);
      localTextView6.setText(str17);
      return;
      localLinearLayout.setVisibility(4);
    }
  }

  public void checkTripName(String paramString)
  {
    if (paramString.trim().equals(""))
    {
      createDialogForTripName("Trip not saved, at least one character expected");
      return;
    }
    if (ApplicationEngine.getModel().checkForDuplicateTrip(paramString))
    {
      createDialogForTripName("Trip not saved, same name exists. Please use other names.");
      return;
    }
    save_route(paramString);
  }

  public void createDialogForTripName(String paramString)
  {
    AlertDialog.Builder localBuilder1 = new AlertDialog.Builder(this);
    final EditText localEditText = new EditText(this);
    AlertDialog.Builder localBuilder2 = localBuilder1.setView(localEditText);
    DialogInterface.OnClickListener local7 = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        String str = localEditText.getText().toString().trim();
        DirectionsTaxiActivity.this.checkTripName(str);
      }
    };
    AlertDialog.Builder localBuilder3 = localBuilder1.setPositiveButton("Ok", local7);
    DialogInterface.OnClickListener local8 = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        paramAnonymousDialogInterface.cancel();
      }
    };
    AlertDialog.Builder localBuilder4 = localBuilder1.setNegativeButton("Cancel", local8);
    AlertDialog.Builder localBuilder5 = localBuilder1.setTitle(paramString);
    AlertDialog localAlertDialog = localBuilder1.show();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    boolean bool = requestWindowFeature(1);
    TaxiResponse localTaxiResponse1 = ApplicationEngine.getModel().getTaxiResponse();
    this.tr = localTaxiResponse1;
    setContentView(2130903138);
    Hashtable localHashtable = new Hashtable();
    String str1 = ApplicationEngine.getModel().getDefaultCityId();
    Object localObject = localHashtable.put("defaultcity", str1);
    int i = ApplicationEngine.ZONE_DIRECTION_RESULT;
    update(i, localHashtable, null, null);
    String str2 = PageNames.DirectionTaxiResult;
    trackEvent(str2);
    if (this.tr != null)
    {
      TaxiResponse localTaxiResponse2 = this.tr;
      addTaxis(localTaxiResponse2);
    }
    View localView1 = findViewById(2131492906);
    View.OnClickListener local1 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Context localContext = DirectionsTaxiActivity.this.getApplicationContext();
        Intent localIntent1 = new Intent(localContext, DirectionsMainViewActivity.class);
        Intent localIntent2 = localIntent1.setFlags(335544320);
        DirectionsTaxiActivity.this.getApplicationContext().startActivity(localIntent1);
      }
    };
    localView1.setOnClickListener(local1);
    final String str3 = ((TelephonyManager)getSystemService("phone")).getNetworkOperatorName();
    View localView2 = findViewById(2131493169);
    View.OnClickListener local2 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent1 = new Intent("android.intent.action.DIAL");
        StringBuilder localStringBuilder = new StringBuilder("tel:");
        String str1 = Uri.encode("#8294");
        Uri localUri = Uri.parse(str1);
        Intent localIntent2 = localIntent1.setData(localUri);
        DirectionsTaxiActivity.this.startActivity(localIntent1);
        DirectionsTaxiActivity localDirectionsTaxiActivity = DirectionsTaxiActivity.this;
        String str2 = PageNames.DirectionTaxiResult;
        String str3 = str3;
        Long localLong = Long.valueOf(-9223372036854775808L);
        localDirectionsTaxiActivity.trackAction(str2, "PoundTaxiClick", str3, localLong);
      }
    };
    localView2.setOnClickListener(local2);
    TextView localTextView = (TextView)findViewById(2131493170);
    MovementMethod localMovementMethod = LinkMovementMethod.getInstance();
    localTextView.setMovementMethod(localMovementMethod);
    ImageButton localImageButton = (ImageButton)findViewById(2131493285);
    View.OnClickListener local3 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        DirectionsTaxiActivity localDirectionsTaxiActivity = DirectionsTaxiActivity.this;
        final Dialog localDialog = new Dialog(localDirectionsTaxiActivity);
        localDialog.setContentView(2130903139);
        localDialog.setTitle("Save Trip / Report problems");
        localDialog.setCancelable(true);
        localDialog.setCanceledOnTouchOutside(true);
        View localView1 = localDialog.findViewById(2131492950);
        View.OnClickListener local1 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            localDialog.dismiss();
            int i = ApplicationEngine.getModel().getMyTripsCount();
            int j = ApplicationEngine.MY_TRIP_MAX;
            if (i >= j)
            {
              Toast.makeText(DirectionsTaxiActivity.this.getApplicationContext(), "Sorry, trip max reached, please delete some before saving", 1).show();
              return;
            }
            DirectionsTaxiActivity.this.createDialogForTripName("Please input trip name");
          }
        };
        localView1.setOnClickListener(local1);
        View localView2 = localDialog.findViewById(2131492952);
        View.OnClickListener local2 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            String str3;
            StringBuilder localStringBuilder2;
            String str5;
            if (DirectionsTaxiActivity.this.tr.getZip1() == null)
            {
              String str1 = String.valueOf("From: ");
              StringBuilder localStringBuilder1 = new StringBuilder(str1);
              String str2 = DirectionsTaxiActivity.this.tr.getAddress1();
              str3 = str2;
              if (DirectionsTaxiActivity.this.tr.getZip2() != null)
                break label328;
              String str4 = String.valueOf("To: ");
              localStringBuilder2 = new StringBuilder(str4);
              str5 = DirectionsTaxiActivity.this.tr.getAddress2();
            }
            label328: StringBuilder localStringBuilder7;
            String str16;
            for (String str6 = str5; ; str6 = str16)
            {
              localDialog.dismiss();
              String str7 = DirectionsTaxiActivity.this.getString(2130968653);
              StringBuilder localStringBuilder3 = new StringBuilder("Please describe the problem: \n\n\n======================\n").append(str3).append("\n").append(str6).append("\n").append("Link: http://hopstop.com/?route_id=");
              String str8 = DirectionsTaxiActivity.this.tr.getRouteId();
              String str9 = String.valueOf(str8 + "\n\n");
              String str10 = str9 + "\n\n\nSent from HopStop Android App " + str7;
              DirectionsTaxiActivity.this.sendEmail("taxi@hopstop.com", "HopStop Android App - Taxi Directions Problem", str10);
              return;
              String str11 = String.valueOf("From: ");
              StringBuilder localStringBuilder4 = new StringBuilder(str11);
              String str12 = DirectionsTaxiActivity.this.tr.getAddress1();
              StringBuilder localStringBuilder5 = localStringBuilder4.append(str12).append(", ");
              String str13 = DirectionsTaxiActivity.this.tr.getZip1();
              str3 = str13;
              break;
              String str14 = String.valueOf("To: ");
              StringBuilder localStringBuilder6 = new StringBuilder(str14);
              String str15 = DirectionsTaxiActivity.this.tr.getAddress2();
              localStringBuilder7 = localStringBuilder6.append(str15).append(", ");
              str16 = DirectionsTaxiActivity.this.tr.getZip2();
            }
          }
        };
        localView2.setOnClickListener(local2);
        View localView3 = localDialog.findViewById(2131492953);
        View.OnClickListener local3 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            localDialog.dismiss();
          }
        };
        localView3.setOnClickListener(local3);
        localDialog.show();
      }
    };
    localImageButton.setOnClickListener(local3);
    String str4 = PageNames.DirectionTaxiResult;
    String str5 = String.valueOf(this.tr.getKeyWords());
    String str6 = str5 + ",taxi";
    displayAds(str4, str6);
  }

  public void onDestroy()
  {
    try
    {
      ApplicationEngine.getModel().saveRecentBeforeFinish();
      super.onDestroy();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (true)
        localOutOfMemoryError.printStackTrace();
    }
    catch (IOException localIOException)
    {
      while (true)
        localIOException.printStackTrace();
    }
  }

  protected void save_route(String paramString)
  {
    Toast.makeText(getApplicationContext(), "Saving trip, please wait...", 1).show();
    SaveTaxiTripTask localSaveTaxiTripTask = new SaveTaxiTripTask();
    String[] arrayOfString = new String[1];
    arrayOfString[0] = paramString;
    AsyncTask localAsyncTask = localSaveTaxiTripTask.execute(arrayOfString);
  }

  protected class SaveTaxiTripTask extends AsyncTask<String, Integer, String>
  {
    protected SaveTaxiTripTask()
    {
    }

    protected String doInBackground(String[] paramArrayOfString)
    {
      Model localModel = ApplicationEngine.getModel();
      String str = paramArrayOfString[0];
      int i = localModel.addMyTrip(str);
      return null;
    }

    protected void onPostExecute(String paramString)
    {
      Toast.makeText(DirectionsTaxiActivity.this.getApplicationContext(), "Taxi Trip Saved", 0).show();
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.DirectionsTaxiActivity
 * JD-Core Version:    0.6.2
 */