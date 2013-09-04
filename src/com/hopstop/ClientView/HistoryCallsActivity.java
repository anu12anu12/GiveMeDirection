package com.hopstop.ClientView;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract.Data;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.hopstop.ClientController.Controller;
import com.hopstop.ClientModel.DateTimeUtil;
import com.hopstop.ClientModel.Model;
import com.hopstop.core.ApplicationEngine;
import com.hopstop.ui.BaseActivity;
import com.hopstop.ui.HopStopRadioButton;
import com.hopstop.ui.PageNames;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class HistoryCallsActivity extends BaseActivity
  implements View.OnClickListener
{
  private static final String EMPTY_STRING = "";
  private static final int PICK_CONTACT;
  private String QUESTION;
  private ArrayList<String> _addresses;
  private ArrayList<Hashtable<String, Object>> _contacts = null;
  private ArrayAdapter<Hashtable<String, Object>> adapter;
  private Button cancelButton;
  private LinearLayout contact_layout;
  private RadioButton contacts;
  private DateTimeUtil cur_time;
  private ArrayList<String> deletedRecords;
  private Button editButton;
  private Field field;
  private Handler handler;
  private RadioButton history;
  private LinearLayout history_layout;
  private boolean isEdit = true;
  private TextView loadingContacts;
  private ListView mList;
  private ProgressDialog m_ProgressDialog;
  private Class<?> refClass;
  private Object result;
  public RunnableContacts returnContactsRes;
  private Runnable returnRes;
  private Runnable viewContacts;
  private Runnable viewHistory;

  public HistoryCallsActivity()
  {
    ArrayList localArrayList = new ArrayList();
    this.deletedRecords = localArrayList;
    DateTimeUtil localDateTimeUtil = new DateTimeUtil();
    this.cur_time = localDateTimeUtil;
    this.refClass = null;
    this.field = null;
    this.result = null;
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        HistoryCallsActivity.this.refresh();
      }
    };
    this.returnRes = local1;
    this.adapter = null;
    this.m_ProgressDialog = null;
    Handler local2 = new Handler()
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        if (paramAnonymousMessage.what == 0)
        {
          LinearLayout localLinearLayout1 = HistoryCallsActivity.this.history_layout;
          View localView1 = (View)paramAnonymousMessage.obj;
          localLinearLayout1.addView(localView1);
        }
        if (paramAnonymousMessage.what == 1)
        {
          LinearLayout localLinearLayout2 = HistoryCallsActivity.this.contact_layout;
          View localView2 = (View)paramAnonymousMessage.obj;
          localLinearLayout2.addView(localView2);
        }
        if (paramAnonymousMessage.what != 2)
          return;
        if (HistoryCallsActivity.this.loadingContacts == null)
          return;
        HistoryCallsActivity.this.loadingContacts.setVisibility(8);
      }
    };
    this.handler = local2;
    RunnableContacts localRunnableContacts = new RunnableContacts(null);
    this.returnContactsRes = localRunnableContacts;
    this.QUESTION = "?";
  }

  private void addElementsFromHistory()
  {
    int i = 0;
    Iterator localIterator = this._addresses.iterator();
    if (!localIterator.hasNext())
    {
      Runnable localRunnable = this.returnRes;
      runOnUiThread(localRunnable);
      return;
    }
    String str1 = (String)localIterator.next();
    View localView = View.inflate(this, 2130903068, null);
    HopStopRadioButton localHopStopRadioButton = (HopStopRadioButton)localView.findViewById(2131492975);
    localHopStopRadioButton.setOnClickListener(this);
    int j = i + 1;
    String str2 = Integer.toString(i);
    localHopStopRadioButton.setTag(str2);
    localHopStopRadioButton.setVisibility(4);
    TextView localTextView = (TextView)localView.findViewById(2131492976);
    String[] arrayOfString = str1.split("&&");
    if ((arrayOfString != null) && (arrayOfString.length > 1))
    {
      String str3 = arrayOfString[0];
      localTextView.setText(str3);
      String str4 = arrayOfString[1];
      localTextView.setTag(str4);
    }
    while (true)
    {
      Button localButton = (Button)localView.findViewById(2131492977);
      View.OnClickListener local13 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          ViewGroup localViewGroup = (ViewGroup)paramAnonymousView.getParent().getParent();
          View localView = (View)paramAnonymousView.getParent();
          TextView localTextView = (TextView)localView.findViewById(2131492976);
          String str1 = (String)localTextView.getText();
          String str2 = (String)localTextView.getTag();
          if (str1 != null)
          {
            ArrayList localArrayList = HistoryCallsActivity.this.deletedRecords;
            String str3 = String.valueOf(str1);
            String str4 = str3 + "&&" + str2;
            boolean bool1 = localArrayList.add(str4);
          }
          boolean bool2 = HistoryCallsActivity.this._addresses.remove(str1);
          localViewGroup.removeView(localView);
          localViewGroup.invalidate();
        }
      };
      localButton.setOnClickListener(local13);
      localHopStopRadioButton.setDeleteButton(localButton);
      Message localMessage = this.handler.obtainMessage(1, localView);
      localMessage.what = 0;
      boolean bool = this.handler.sendMessage(localMessage);
      View.OnClickListener local14 = new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          TextView localTextView = (TextView)paramAnonymousView.findViewById(2131492976);
          Intent localIntent1 = new Intent();
          CharSequence localCharSequence = localTextView.getText();
          Intent localIntent2 = localIntent1.putExtra("get_address", localCharSequence);
          String str = (String)localTextView.getTag();
          Intent localIntent3 = localIntent1.putExtra("history_market", str);
          HistoryCallsActivity.this.setResult(1, localIntent1);
          HistoryCallsActivity.this.finish();
        }
      };
      localView.setOnClickListener(local14);
      i = j;
      break;
      localTextView.setText(str1);
    }
  }

  private void addString(StringBuffer paramStringBuffer, String paramString1, String paramString2)
  {
    if (paramString1 == null)
      return;
    if (paramString1.length() <= 0)
      return;
    if (paramStringBuffer.length() > 0)
    {
      StringBuffer localStringBuffer1 = paramStringBuffer.append(paramString2);
      StringBuffer localStringBuffer2 = paramStringBuffer.append(paramString1);
      return;
    }
    StringBuffer localStringBuffer3 = paramStringBuffer.append(paramString1);
  }

  private String fixContactName(String paramString)
  {
    if (paramString == null)
      paramString = "Not Available";
    return paramString;
  }

  private String formatContactAddress(Cursor paramCursor)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramCursor.getColumnIndex("data4");
    String str1 = paramCursor.getString(i);
    String str2;
    if (str1 == null)
    {
      str2 = null;
      return str2;
    }
    int j = paramCursor.getColumnIndex("data7");
    String str3 = paramCursor.getString(j);
    int k = paramCursor.getColumnIndex("data8");
    String str4 = paramCursor.getString(k);
    int m = paramCursor.getColumnIndex("data9");
    String str5 = paramCursor.getString(m);
    if (str1 == null)
      str1 = "";
    String str6;
    label119: String str7;
    if (str3 == null)
    {
      str6 = "";
      if (str4 != null)
        break label214;
      str7 = "";
      label128: if (str5 != null)
        break label237;
    }
    label214: label237: for (String str8 = ""; ; str8 = ", " + str5)
    {
      String str9 = String.valueOf(str1);
      String str10 = str9 + str6 + str7 + str8;
      addString(localStringBuffer, str10, "");
      str2 = localStringBuffer.toString();
      break;
      str6 = ", " + str3;
      break label119;
      str7 = ", " + str4;
      break label128;
    }
  }

  private ImageView getDivideLine()
  {
    Context localContext = getApplicationContext();
    ImageView localImageView = new ImageView(localContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 1);
    localImageView.setLayoutParams(localLayoutParams);
    localImageView.setBackgroundColor(-1);
    return localImageView;
  }

  public static int getPostalTypeStringId(int paramInt)
  {
    return 2130968643;
  }

  private Object getReflexiveContactInfo(String paramString1, String paramString2)
  {
    try
    {
      Class localClass = Class.forName(paramString1);
      this.refClass = localClass;
      Field localField = this.refClass.getField(paramString2);
      this.field = localField;
      Object localObject1 = this.field.get(null);
      this.result = localObject1;
      Object localObject2 = this.result;
      label48: return localObject2;
    }
    catch (Exception localException)
    {
      break label48;
    }
  }

  private ArrayList<Hashtable<String, Object>> importContacts()
  {
    ArrayList localArrayList1;
    Cursor localCursor;
    String str4;
    String str5;
    if (this._contacts == null)
    {
      localArrayList1 = new ArrayList();
      Uri localUri = ContactsContract.Data.CONTENT_URI;
      StringBuilder localStringBuilder = new StringBuilder("mimetype=");
      String str1 = this.QUESTION;
      String str2 = str1;
      String[] arrayOfString = new String[1];
      arrayOfString[0] = "vnd.android.cursor.item/postal-address_v2";
      localCursor = managedQuery(localUri, null, str2, arrayOfString, "display_name");
      if (localCursor.moveToFirst())
      {
        int i = localCursor.getColumnIndex("display_name");
        String str3 = localCursor.getString(i);
        str4 = fixContactName(str3);
        str5 = formatContactAddress(localCursor);
        if (str5 == null)
          label129: if (localCursor.moveToNext())
            break label272;
      }
      else
      {
        this._contacts = localArrayList1;
      }
    }
    else
    {
      RunnableContacts localRunnableContacts1 = this.returnContactsRes;
      ArrayList localArrayList2 = this._contacts;
      localRunnableContacts1.nextResult(localArrayList2);
      RunnableContacts localRunnableContacts2 = this.returnContactsRes;
      runOnUiThread(localRunnableContacts2);
      return this._contacts;
    }
    if (localCursor.moveToNext())
    {
      int j = localCursor.getColumnIndex("display_name");
      String str6 = localCursor.getString(j);
      String str7 = fixContactName(str6);
      boolean bool1 = localCursor.moveToPrevious();
    }
    while (true)
    {
      Hashtable localHashtable = new Hashtable();
      String str8 = str4;
      Object localObject = localHashtable.put(str8, str5);
      if (localArrayList1.contains(localHashtable))
        break label129;
      boolean bool2 = localArrayList1.add(localHashtable);
      break label129;
      label272: break;
    }
  }

  private void loadContacts()
  {
    setContentView(2130903045);
    Hashtable localHashtable = new Hashtable();
    String str = ApplicationEngine.getModel().getDefaultCityId();
    Object localObject = localHashtable.put("defaultcity", str);
    int i = ApplicationEngine.ZONE_DIRECTION_SEARCH;
    update(i, localHashtable, null, null);
    ListView localListView = (ListView)findViewById(2131492883);
    this.mList = localListView;
    if (this.loadingContacts != null)
      this.loadingContacts.setVisibility(0);
    displayAds("contactsScreen");
    Button localButton1 = (Button)findViewById(2131492881);
    this.cancelButton = localButton1;
    Button localButton2 = this.cancelButton;
    View.OnClickListener local8 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent();
        HistoryCallsActivity.this.setResult(0, localIntent);
        HistoryCallsActivity.this.finish();
      }
    };
    localButton2.setOnClickListener(local8);
    RadioButton localRadioButton1 = (RadioButton)findViewById(2131492879);
    this.history = localRadioButton1;
    RadioButton localRadioButton2 = this.history;
    View.OnClickListener local9 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        HistoryCallsActivity.this.loadHistoryCall();
      }
    };
    localRadioButton2.setOnClickListener(local9);
    polulateContactsList();
  }

  private void loadHistoryCall()
  {
    setContentView(2130903067);
    Hashtable localHashtable = new Hashtable();
    String str1 = ApplicationEngine.getModel().getDefaultCityId();
    Object localObject = localHashtable.put("defaultcity", str1);
    int i = ApplicationEngine.ZONE_DIRECTION_SEARCH;
    update(i, localHashtable, null, null);
    String str2 = PageNames.History;
    displayAds(str2);
    LinkedList localLinkedList = ApplicationEngine.getModel().getHistoryCallsKeys();
    ArrayList localArrayList1 = new ArrayList(localLinkedList);
    ArrayList localArrayList2 = new ArrayList();
    this._addresses = localArrayList2;
    Iterator localIterator = localArrayList1.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        Button localButton1 = (Button)findViewById(2131492972);
        this.editButton = localButton1;
        Button localButton2 = this.editButton;
        View.OnClickListener local3 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            if (HistoryCallsActivity.this.isEdit)
            {
              HistoryCallsActivity.this.editButton.setText("Done");
              HistoryCallsActivity.this.isEdit = false;
              i = 0;
              while (true)
              {
                int j = HistoryCallsActivity.this.history_layout.getChildCount();
                if (i >= j)
                  return;
                HopStopRadioButton localHopStopRadioButton1 = (HopStopRadioButton)HistoryCallsActivity.this.history_layout.getChildAt(i).findViewById(2131492975);
                localHopStopRadioButton1.setVisibility(0);
                localHopStopRadioButton1.setChecked(false);
                i += 1;
              }
            }
            HistoryCallsActivity.this.editButton.setText("Edit");
            HistoryCallsActivity.this.isEdit = true;
            int i = 0;
            while (true)
            {
              int k = HistoryCallsActivity.this.history_layout.getChildCount();
              if (i >= k);
              try
              {
                Controller localController = ApplicationEngine.getController();
                Object[] arrayOfObject = HistoryCallsActivity.this.deletedRecords.toArray();
                localController.handleViewRequest(202, arrayOfObject, null);
                return;
              }
              catch (OutOfMemoryError localOutOfMemoryError)
              {
                localOutOfMemoryError.printStackTrace();
                return;
                View localView = HistoryCallsActivity.this.history_layout.getChildAt(i);
                HopStopRadioButton localHopStopRadioButton2 = (HopStopRadioButton)localView.findViewById(2131492975);
                localHopStopRadioButton2.setVisibility(4);
                localHopStopRadioButton2.setChecked(false);
                ((Button)localView.findViewById(2131492977)).setVisibility(4);
                i += 1;
              }
              catch (IOException localIOException)
              {
                localIOException.printStackTrace();
              }
            }
          }
        };
        localButton2.setOnClickListener(local3);
        Button localButton3 = (Button)findViewById(2131492881);
        this.cancelButton = localButton3;
        Button localButton4 = this.cancelButton;
        View.OnClickListener local4 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            Intent localIntent = new Intent();
            HistoryCallsActivity.this.setResult(0, localIntent);
            HistoryCallsActivity.this.finish();
          }
        };
        localButton4.setOnClickListener(local4);
        RadioButton localRadioButton1 = (RadioButton)findViewById(2131492880);
        this.contacts = localRadioButton1;
        RadioButton localRadioButton2 = this.contacts;
        View.OnClickListener local5 = new View.OnClickListener()
        {
          public void onClick(View paramAnonymousView)
          {
            HistoryCallsActivity.this.loadContacts();
            HistoryCallsActivity.this.trackEvent("Contact Screen");
          }
        };
        localRadioButton2.setOnClickListener(local5);
        LinearLayout localLinearLayout = (LinearLayout)findViewById(2131492973);
        this.history_layout = localLinearLayout;
        Runnable local6 = new Runnable()
        {
          public void run()
          {
            HistoryCallsActivity.this.addElementsFromHistory();
          }
        };
        this.viewHistory = local6;
        Runnable localRunnable = this.viewHistory;
        new Thread(null, localRunnable, "MagentoBackground").start();
        return;
      }
      String str3 = (String)localIterator.next();
      boolean bool = this._addresses.add(str3);
    }
  }

  private void polulateContactsList()
  {
    ArrayList localArrayList = new ArrayList();
    if ((localArrayList != null) && (localArrayList.size() > 0))
      ((TextView)findViewById(2131492884)).setVisibility(8);
    ArrayAdapter local10 = new ArrayAdapter(this, 2130903047, localArrayList)
    {
      public View getView(int paramAnonymousInt, View paramAnonymousView, ViewGroup paramAnonymousViewGroup)
      {
        View localView = paramAnonymousView;
        Hashtable localHashtable = (Hashtable)getItem(paramAnonymousInt);
        HistoryCallsActivity.1ViewHolder local1ViewHolder;
        if (localView == null)
        {
          LayoutInflater localLayoutInflater = (LayoutInflater)HistoryCallsActivity.this.getSystemService("layout_inflater");
          HistoryCallsActivity localHistoryCallsActivity = HistoryCallsActivity.this;
          local1ViewHolder = new HistoryCallsActivity.1ViewHolder(localHistoryCallsActivity);
          localView = localLayoutInflater.inflate(2130903047, null);
          TextView localTextView1 = (TextView)localView.findViewById(2131492890);
          local1ViewHolder.contact_name = localTextView1;
          TextView localTextView2 = (TextView)localView.findViewById(2131492891);
          local1ViewHolder.contact_address = localTextView2;
          localView.setTag(local1ViewHolder);
        }
        while (true)
        {
          String str1 = (String)localHashtable.keys().nextElement();
          local1ViewHolder.contact_name.setText(str1);
          TextView localTextView3 = local1ViewHolder.contact_address;
          String str2 = (String)localHashtable.get(str1);
          localTextView3.setText(str2);
          return localView;
          local1ViewHolder = (HistoryCallsActivity.1ViewHolder)localView.getTag();
        }
      }
    };
    this.adapter = local10;
    ListView localListView1 = this.mList;
    ArrayAdapter localArrayAdapter = this.adapter;
    localListView1.setAdapter(localArrayAdapter);
    Runnable local11 = new Runnable()
    {
      public void run()
      {
        ArrayList localArrayList = HistoryCallsActivity.this.importContacts();
      }
    };
    this.viewContacts = local11;
    ListView localListView2 = this.mList;
    AdapterView.OnItemClickListener local12 = new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        TextView localTextView = (TextView)paramAnonymousView.findViewById(2131492891);
        Intent localIntent1 = new Intent();
        CharSequence localCharSequence = localTextView.getText();
        Intent localIntent2 = localIntent1.putExtra("get_address", localCharSequence);
        HistoryCallsActivity.this.setResult(1, localIntent1);
        HistoryCallsActivity.this.finish();
      }
    };
    localListView2.setOnItemClickListener(local12);
    Runnable localRunnable = this.viewContacts;
    new Thread(null, localRunnable, "MagentoBackground").start();
    ProgressDialog localProgressDialog = ProgressDialog.show(this, "Please wait...", "Retrieving data ...", true);
    this.m_ProgressDialog = localProgressDialog;
  }

  @SuppressLint({"ShowToast"})
  private void startContactClient()
  {
    try
    {
      Uri localUri = (Uri)getReflexiveContactInfo("android.provider.ContactsContract$Contacts", "CONTENT_URI");
      Intent localIntent = new Intent("android.intent.action.PICK", localUri);
      startActivityForResult(localIntent, 0);
      return;
    }
    catch (Exception localException)
    {
      Toast localToast = Toast.makeText(this, 2130968689, 1);
      localException.printStackTrace();
    }
  }

  protected void alertbox(String paramString1, String paramString2)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this).setMessage(paramString2).setTitle(paramString1).setCancelable(true);
    DialogInterface.OnClickListener local7 = new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
      }
    };
    AlertDialog localAlertDialog = localBuilder.setNeutralButton(17039370, local7).show();
  }

  protected String getContactInfo(Intent paramIntent)
  {
    String str1 = null;
    Cursor localCursor1 = null;
    ContentResolver localContentResolver = getContentResolver();
    try
    {
      Uri localUri1 = paramIntent.getData();
      Cursor localCursor2 = managedQuery(localUri1, null, null, null, null);
      String str2 = (String)getReflexiveContactInfo("android.provider.ContactsContract$Contacts", "_ID");
      label219: String str8;
      do
      {
        boolean bool = localCursor2.moveToNext();
        if (bool == null)
          return str1;
        int i = localCursor2.getColumnIndex(str2);
        String str4 = localCursor2.getString(i);
        StringBuilder localStringBuilder1 = new StringBuilder();
        Object localObject1 = getReflexiveContactInfo("android.provider.ContactsContract$Data", "CONTACT_ID");
        StringBuilder localStringBuilder2 = localStringBuilder1.append(localObject1).append(" = ? AND ");
        Object localObject2 = getReflexiveContactInfo("android.provider.ContactsContract$Data", "MIMETYPE");
        String str5 = localObject2 + " = ?";
        String[] arrayOfString = new String[2];
        arrayOfString[0] = str4;
        String str6 = (String)getReflexiveContactInfo("android.provider.ContactsContract$CommonDataKinds$StructuredPostal", "CONTENT_ITEM_TYPE");
        arrayOfString[1] = str6;
        Uri localUri2 = (Uri)getReflexiveContactInfo("android.provider.ContactsContract$Data", "CONTENT_URI");
        localCursor1 = localContentResolver.query(localUri2, null, str5, arrayOfString, null);
        if (!localCursor1.moveToNext())
          break;
        String str7 = (String)getReflexiveContactInfo("android.provider.ContactsContract$CommonDataKinds$StructuredPostal", "STREET");
        int j = localCursor1.getColumnIndex(str7);
        str8 = localCursor1.getString(j);
      }
      while (str8 == null);
      String str9 = (String)getReflexiveContactInfo("android.provider.ContactsContract$CommonDataKinds$StructuredPostal", "CITY");
      int k = localCursor1.getColumnIndex(str9);
      String str10 = localCursor1.getString(k);
      String str11 = (String)getReflexiveContactInfo("android.provider.ContactsContract$CommonDataKinds$StructuredPostal", "POSTCODE");
      int m = localCursor1.getColumnIndex(str11);
      String str12 = localCursor1.getString(m);
      if (str8 == null)
        str8 = "";
      if (str10 == null)
      {
        str10 = "";
        label356: if (str12 != null)
          break label421;
      }
      label421: String str3;
      for (str12 = ""; ; str12 = str3)
      {
        String str13 = String.valueOf(str8);
        str1 = str13 + str10 + str12;
        break label219;
        break;
        str10 = ", " + str10;
        break label356;
        str3 = ", " + str12;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        if (localCursor1 != null)
          localCursor1.close();
      }
    }
    finally
    {
      if (localCursor1 != null)
        localCursor1.close();
    }
  }

  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 0;
    if (paramInt1 != 0)
      return;
    if (paramIntent != null);
    String str1;
    for (int j = 1; ; j = 0)
    {
      if (paramInt2 == -1)
        i = 1;
      if ((i & j) == 0)
        return;
      str1 = getContactInfo(paramIntent);
      if (str1 != null)
        break;
      String str2 = getString(2130968691);
      String str3 = getString(2130968690);
      alertbox(str2, str3);
      return;
    }
    Intent localIntent1 = new Intent();
    Intent localIntent2 = localIntent1.putExtra("get_address", str1);
    setResult(1, localIntent1);
    finish();
  }

  public void onClick(View paramView)
  {
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    loadHistoryCall();
    String str = PageNames.History;
    trackEvent(str);
  }

  public void refresh()
  {
    this.history_layout.invalidate();
  }

  private class RunnableContacts
    implements Runnable
  {
    private ArrayList<Hashtable<String, Object>> _result;

    private RunnableContacts()
    {
    }

    public void nextResult(ArrayList<Hashtable<String, Object>> paramArrayList)
    {
      this._result = paramArrayList;
    }

    public void run()
    {
      if (this._result.size() > 0)
        ((TextView)HistoryCallsActivity.this.findViewById(2131492884)).setVisibility(8);
      int i = 0;
      while (true)
      {
        int j = this._result.size();
        if (i >= j)
        {
          HistoryCallsActivity.this.m_ProgressDialog.dismiss();
          HistoryCallsActivity.this.adapter.notifyDataSetChanged();
          return;
        }
        ArrayAdapter localArrayAdapter = HistoryCallsActivity.this.adapter;
        Hashtable localHashtable = (Hashtable)this._result.get(i);
        localArrayAdapter.add(localHashtable);
        i += 1;
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientView.HistoryCallsActivity
 * JD-Core Version:    0.6.2
 */