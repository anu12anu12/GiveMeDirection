package com.MASTAdView.ormma.util;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.VideoView;
import com.MASTAdView.ormma.OrmmaController.PlayerProperties;

public class OrmmaPlayer extends VideoView
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener
{
  private static String LOG_TAG = "Ormma Player";
  private static String transientText = "Loading. Please Wait..";
  private AudioManager aManager;
  private String contentURL;
  private boolean isReleased;
  private OrmmaPlayerListener listener;
  private int mutedVolume;
  private Runnable onCompletionRunnable;
  private Runnable onErrorRunnable;
  private OrmmaController.PlayerProperties playProperties;
  private RelativeLayout transientLayout;

  public OrmmaPlayer(Context paramContext)
  {
    super(paramContext);
    AudioManager localAudioManager = (AudioManager)getContext().getSystemService("audio");
    this.aManager = localAudioManager;
  }

  void addTransientMessage()
  {
    if (this.playProperties.inline)
      return;
    Context localContext1 = getContext();
    RelativeLayout localRelativeLayout1 = new RelativeLayout(localContext1);
    this.transientLayout = localRelativeLayout1;
    RelativeLayout localRelativeLayout2 = this.transientLayout;
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localRelativeLayout2.setLayoutParams(localLayoutParams);
    Context localContext2 = getContext();
    TextView localTextView = new TextView(localContext2);
    String str = transientText;
    localTextView.setText(str);
    localTextView.setTextColor(-1);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams1.addRule(13);
    this.transientLayout.addView(localTextView, localLayoutParams1);
    ViewGroup localViewGroup = (ViewGroup)getParent();
    RelativeLayout localRelativeLayout3 = this.transientLayout;
    localViewGroup.addView(localRelativeLayout3);
  }

  void clearTransientMessage()
  {
    if (this.transientLayout == null)
      return;
    ViewGroup localViewGroup = (ViewGroup)getParent();
    RelativeLayout localRelativeLayout = this.transientLayout;
    localViewGroup.removeView(localRelativeLayout);
  }

  void displayControl()
  {
    if (!this.playProperties.showControl())
      return;
    Context localContext = getContext();
    MediaController localMediaController = new MediaController(localContext);
    setMediaController(localMediaController);
    localMediaController.setAnchorView(this);
  }

  public Runnable getOnCompletionRunnable()
  {
    return this.onCompletionRunnable;
  }

  public Runnable getOnErrorRunnable()
  {
    return this.onErrorRunnable;
  }

  void loadContent()
  {
    String str1 = this.contentURL.trim();
    this.contentURL = str1;
    String str2 = OrmmaUtils.convert(this.contentURL);
    this.contentURL = str2;
    if ((this.contentURL == null) && (this.listener != null))
    {
      removeView();
      this.listener.onError();
      return;
    }
    Uri localUri = Uri.parse(this.contentURL);
    setVideoURI(localUri);
    displayControl();
    startContent();
  }

  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.playProperties.doLoop())
      start();
    while (true)
    {
      if (this.onCompletionRunnable == null)
        return;
      Handler localHandler = new Handler();
      Runnable localRunnable = this.onCompletionRunnable;
      boolean bool = localHandler.post(localRunnable);
      return;
      if ((this.playProperties.exitOnComplete()) || (this.playProperties.inline))
        releasePlayer();
    }
  }

  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    String str1 = LOG_TAG;
    String str2 = "Player error : " + paramInt1;
    int i = Log.i(str1, str2);
    clearTransientMessage();
    removeView();
    if (this.listener != null)
      this.listener.onError();
    if (this.onErrorRunnable != null)
    {
      Handler localHandler = new Handler();
      Runnable localRunnable = this.onErrorRunnable;
      boolean bool = localHandler.post(localRunnable);
    }
    return false;
  }

  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    clearTransientMessage();
    if (this.listener == null)
      return;
    this.listener.onPrepared();
  }

  public void playAudio()
  {
    loadContent();
  }

  public void playVideo()
  {
    if (this.playProperties.doMute())
    {
      int i = this.aManager.getStreamVolume(3);
      this.mutedVolume = i;
      this.aManager.setStreamVolume(3, 0, 4);
    }
    loadContent();
  }

  public void releasePlayer()
  {
    if (this.isReleased)
      return;
    this.isReleased = true;
    stopPlayback();
    removeView();
    if ((this.playProperties != null) && (this.playProperties.doMute()))
      unMute();
    if (this.listener == null)
      return;
    this.listener.onComplete();
  }

  void removeView()
  {
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if (localViewGroup == null)
      return;
    localViewGroup.removeView(this);
  }

  public void setListener(OrmmaPlayerListener paramOrmmaPlayerListener)
  {
    this.listener = paramOrmmaPlayerListener;
  }

  public void setOnCompletionRunnable(Runnable paramRunnable)
  {
    this.onCompletionRunnable = paramRunnable;
  }

  public void setOnErrorRunnable(Runnable paramRunnable)
  {
    this.onErrorRunnable = paramRunnable;
  }

  public void setPlayData(OrmmaController.PlayerProperties paramPlayerProperties, String paramString)
  {
    this.isReleased = false;
    this.playProperties = paramPlayerProperties;
    this.contentURL = paramString;
  }

  void startContent()
  {
    setOnCompletionListener(this);
    setOnErrorListener(this);
    setOnPreparedListener(this);
    if (!this.playProperties.inline)
      addTransientMessage();
    if (!this.playProperties.isAutoPlay())
      return;
    start();
  }

  void unMute()
  {
    AudioManager localAudioManager = this.aManager;
    int i = this.mutedVolume;
    localAudioManager.setStreamVolume(3, i, 4);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.MASTAdView.ormma.util.OrmmaPlayer
 * JD-Core Version:    0.6.2
 */