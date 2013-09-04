package checkpoint.forms;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import com.MASTAdView.MASTAdLog;
import com.MASTAdView.MASTAdView;
import com.MASTAdView.MASTAdViewCore.MASTOnAdDownload;
import com.MASTAdView.MASTAdViewCore.MASTOnThirdPartyRequest;
import java.util.HashMap;

public class MainAdvanced extends Activity
{
  MASTAdView adserverView;
  byte[] array;
  private Context context;
  Handler handler;
  private LinearLayout linearLayout;

  public MainAdvanced()
  {
    byte[] arrayOfByte = new byte[2097152];
    this.array = arrayOfByte;
    Handler localHandler = new Handler();
    this.handler = localHandler;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.context = this;
    MASTAdLog.setDefaultLogLevel(3);
    int i = R.layout.main_advanced;
    setContentView(i);
    int j = R.id.frameAdContent;
    LinearLayout localLinearLayout1 = (LinearLayout)findViewById(j);
    this.linearLayout = localLinearLayout1;
    MASTAdLog.setDefaultLogLevel(3);
    int k = R.id.interstitialAd;
    Button localButton = (Button)findViewById(k);
    View.OnClickListener local1 = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Context localContext = MainAdvanced.this.context;
        Integer localInteger1 = Integer.valueOf(8061);
        Integer localInteger2 = Integer.valueOf(20249);
        MASTAdView localMASTAdView = new MASTAdView(localContext, localInteger1, localInteger2);
        localMASTAdView.setLogLevel(3);
        Boolean localBoolean = Boolean.valueOf(true);
        localMASTAdView.setIsShowPhoneStatusBar(localBoolean);
        ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(320, 50);
        localMASTAdView.setLayoutParams(localLayoutParams);
        localMASTAdView.show();
      }
    };
    localButton.setOnClickListener(local1);
    Integer localInteger1 = Integer.valueOf(8061);
    Integer localInteger2 = Integer.valueOf(20249);
    MASTAdView localMASTAdView1 = new MASTAdView(this, localInteger1, localInteger2);
    this.adserverView = localMASTAdView1;
    MASTAdView localMASTAdView2 = this.adserverView;
    MASTAdViewCore.MASTOnThirdPartyRequest local2 = new MASTAdViewCore.MASTOnThirdPartyRequest()
    {
      public void event(MASTAdView paramAnonymousMASTAdView, HashMap<String, String> paramAnonymousHashMap)
      {
      }
    };
    localMASTAdView2.setOnThirdPartyRequest(local2);
    this.adserverView.setInternalBrowser(true);
    this.adserverView.setId(1);
    MASTAdView localMASTAdView3 = this.adserverView;
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(320, 300);
    localMASTAdView3.setLayoutParams(localLayoutParams);
    this.adserverView.update();
    MASTAdView localMASTAdView4 = this.adserverView;
    MASTAdViewCore.MASTOnAdDownload local3 = new MASTAdViewCore.MASTOnAdDownload()
    {
      public void begin(MASTAdView paramAnonymousMASTAdView)
      {
      }

      public void end(MASTAdView paramAnonymousMASTAdView)
      {
      }

      public void error(MASTAdView paramAnonymousMASTAdView, String paramAnonymousString)
      {
      }
    };
    localMASTAdView4.setOnAdDownload(local3);
    LinearLayout localLinearLayout2 = this.linearLayout;
    MASTAdView localMASTAdView5 = this.adserverView;
    localLinearLayout2.addView(localMASTAdView5);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     checkpoint.forms.MainAdvanced
 * JD-Core Version:    0.6.2
 */