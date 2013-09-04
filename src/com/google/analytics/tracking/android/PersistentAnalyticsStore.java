package com.google.analytics.tracking.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.Command;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

class PersistentAnalyticsStore
  implements AnalyticsStore
{
  static final String BACKEND_LIBRARY_VERSION = "-s1";
  private static final String CREATE_HITS_TABLE = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL);", arrayOfObject);
  private static final String DATABASE_FILENAME = "google_analytics_v2.db";
  private static final String HITS_TABLE = "hits2";
  private static final String HIT_ID = "hit_id";
  private static final String HIT_STRING = "hit_string";
  private static final String HIT_TIME = "hit_time";
  private static final String HIT_URL = "hit_url";
  static final long MAX_TOKENS = 120000L;
  static final long TIME_PER_TOKEN_MILLIS = 2000L;
  private final Context context;
  private final String databaseName;
  private final AnalyticsDatabaseHelper dbHelper;
  private volatile Dispatcher dispatcher;
  private long lastDeleteStaleHitsTime;
  private long lastTrackTime;
  private final AnalyticsStoreStateListener listener;
  private boolean throttlingEnabled = true;
  private long tokens = 120000L;

  static
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = "hits2";
    arrayOfObject[1] = "hit_id";
    arrayOfObject[2] = "hit_time";
    arrayOfObject[3] = "hit_url";
    arrayOfObject[4] = "hit_string";
  }

  PersistentAnalyticsStore(AnalyticsStoreStateListener paramAnalyticsStoreStateListener, Context paramContext)
  {
    this(paramAnalyticsStoreStateListener, paramContext, "google_analytics_v2.db");
  }

  PersistentAnalyticsStore(AnalyticsStoreStateListener paramAnalyticsStoreStateListener, Context paramContext, String paramString)
  {
    Context localContext1 = paramContext.getApplicationContext();
    this.context = localContext1;
    this.databaseName = paramString;
    this.listener = paramAnalyticsStoreStateListener;
    Context localContext2 = this.context;
    String str = this.databaseName;
    AnalyticsDatabaseHelper localAnalyticsDatabaseHelper = new AnalyticsDatabaseHelper(localContext2, str);
    this.dbHelper = localAnalyticsDatabaseHelper;
    HttpClientFactory localHttpClientFactory = createDefaultHttpClientFactory();
    Context localContext3 = this.context;
    SimpleNetworkDispatcher localSimpleNetworkDispatcher = new SimpleNetworkDispatcher(this, localHttpClientFactory, localContext3);
    this.dispatcher = localSimpleNetworkDispatcher;
    this.lastDeleteStaleHitsTime = 0L;
  }

  private HttpClientFactory createDefaultHttpClientFactory()
  {
    return new HttpClientFactory()
    {
      public HttpClient newInstance()
      {
        return new DefaultHttpClient();
      }
    };
  }

  private void fillVersionParametersIfNecessary(Map<String, String> paramMap, Collection<Command> paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    Command localCommand;
    do
    {
      if (!localIterator.hasNext())
        return;
      localCommand = (Command)localIterator.next();
    }
    while (!localCommand.getId().equals("appendVersion"));
    String str1 = localCommand.getValue();
    String str2 = localCommand.getUrlParam();
    storeVersion(paramMap, str2, str1);
  }

  public static String generateHitString(Map<String, String> paramMap)
  {
    int i = paramMap.size();
    ArrayList localArrayList = new ArrayList(i);
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      StringBuilder localStringBuilder1 = new StringBuilder();
      String str1 = (String)localEntry.getKey();
      StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append("=");
      String str2 = HitBuilder.encode((String)localEntry.getValue());
      String str3 = str2;
      boolean bool = localArrayList.add(str3);
    }
    return TextUtils.join("&", localArrayList);
  }

  private SQLiteDatabase getWritableDatabase(String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase1 = this.dbHelper.getWritableDatabase();
      localSQLiteDatabase2 = localSQLiteDatabase1;
      return localSQLiteDatabase2;
    }
    catch (SQLiteException localSQLiteException)
    {
      while (true)
      {
        int i = Log.w(paramString);
        SQLiteDatabase localSQLiteDatabase2 = null;
      }
    }
  }

  private void removeOldHitIfFull()
  {
    int i = getNumStoredHits() + -2000 + 1;
    if (i <= 0)
      return;
    List localList = peekHits(i);
    StringBuilder localStringBuilder = new StringBuilder().append("Store full, deleting ");
    int j = localList.size();
    int k = Log.wDebug(j + " hits to make room");
    deleteHits(localList);
  }

  private void storeVersion(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    String str1 = paramString2;
    if (paramString2 == null);
    for (String str2 = "-s1"; ; str2 = paramString2)
    {
      if (paramString1 == null)
        return;
      Object localObject = paramMap.put(paramString1, str2);
      return;
    }
  }

  private void writeHitToDatabase(Map<String, String> paramMap, long paramLong, String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase("Error opening database for putHit");
    if (localSQLiteDatabase == null)
      return;
    ContentValues localContentValues = new ContentValues();
    String str = generateHitString(paramMap);
    localContentValues.put("hit_string", str);
    Long localLong = Long.valueOf(paramLong);
    localContentValues.put("hit_time", localLong);
    if (paramString == null)
      paramString = "http://www.google-analytics.com/collect";
    if (paramString.length() == 0)
    {
      int i = Log.w("empty path: not sending hit");
      return;
    }
    localContentValues.put("hit_url", paramString);
    try
    {
      long l = localSQLiteDatabase.insert("hits2", null, localContentValues);
      this.listener.reportStoreIsEmpty(false);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      int j = Log.w("Error storing hit");
    }
  }

  public void clearHits()
  {
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase("Error opening database for clearHits");
    if (localSQLiteDatabase == null)
      return;
    int i = localSQLiteDatabase.delete("hits2", null, null);
    this.listener.reportStoreIsEmpty(true);
  }

  public void close()
  {
    try
    {
      this.dbHelper.getWritableDatabase().close();
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      int i = Log.w("Error opening database for close");
    }
  }

  public void deleteHits(Collection<Hit> paramCollection)
  {
    if (paramCollection == null)
      throw new NullPointerException("hits cannot be null");
    if (paramCollection.isEmpty())
      return;
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase("Error opening database for deleteHit");
    if (localSQLiteDatabase == null)
      return;
    String[] arrayOfString = new String[paramCollection.size()];
    Object[] arrayOfObject = new Object[1];
    List localList = Collections.nCopies(arrayOfString.length, "?");
    String str1 = TextUtils.join(",", localList);
    arrayOfObject[0] = str1;
    String str2 = String.format("HIT_ID in (%s)", arrayOfObject);
    int i = 0;
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      Hit localHit = (Hit)localIterator.next();
      int j = i + 1;
      String str3 = Long.toString(localHit.getHitId());
      arrayOfString[i] = str3;
      i = j;
    }
    while (true)
    {
      try
      {
        int k = localSQLiteDatabase.delete("hits2", str2, arrayOfString);
        AnalyticsStoreStateListener localAnalyticsStoreStateListener = this.listener;
        if (getNumStoredHits() == 0)
        {
          bool = true;
          localAnalyticsStoreStateListener.reportStoreIsEmpty(bool);
          return;
        }
      }
      catch (SQLiteException localSQLiteException)
      {
        int m = Log.w("Error deleting hit " + paramCollection);
        return;
      }
      boolean bool = false;
    }
  }

  int deleteStaleHits()
  {
    boolean bool = true;
    int i = 0;
    long l1 = System.currentTimeMillis();
    long l2 = this.lastDeleteStaleHitsTime + 86400000L;
    if (l1 <= l2);
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return i;
      this.lastDeleteStaleHitsTime = l1;
      localSQLiteDatabase = getWritableDatabase("Error opening database for deleteStaleHits");
    }
    while (localSQLiteDatabase == null);
    long l3 = System.currentTimeMillis() - 2592000000L;
    String[] arrayOfString = new String[1];
    String str = Long.toString(l3);
    arrayOfString[0] = str;
    int j = localSQLiteDatabase.delete("hits2", "HIT_TIME < ?", arrayOfString);
    AnalyticsStoreStateListener localAnalyticsStoreStateListener = this.listener;
    if (getNumStoredHits() == 0);
    while (true)
    {
      localAnalyticsStoreStateListener.reportStoreIsEmpty(bool);
      i = j;
      break;
      bool = false;
    }
  }

  public void dispatch()
  {
    int i = Log.vDebug("dispatch running...");
    if (!this.dispatcher.okToDispatch())
      return;
    List localList1 = peekHits(40);
    if (localList1.isEmpty())
    {
      int j = Log.vDebug("...nothing to dispatch");
      this.listener.reportStoreIsEmpty(true);
      return;
    }
    int k = this.dispatcher.dispatchHits(localList1);
    StringBuilder localStringBuilder = new StringBuilder().append("sent ").append(k).append(" of ");
    int m = localList1.size();
    int n = Log.vDebug(m + " hits");
    int i1 = localList1.size();
    int i2 = Math.min(k, i1);
    List localList2 = localList1.subList(0, i2);
    deleteHits(localList2);
    int i3 = localList1.size();
    if (k != i3)
      return;
    if (getNumStoredHits() <= 0)
      return;
    GAServiceManager.getInstance().dispatch();
  }

  AnalyticsDatabaseHelper getHelper()
  {
    return this.dbHelper;
  }

  int getNumStoredHits()
  {
    int i = 0;
    SQLiteDatabase localSQLiteDatabase = getWritableDatabase("Error opening database for requestNumHitsPending");
    int j;
    if (localSQLiteDatabase == null)
      j = 0;
    while (true)
    {
      return j;
      try
      {
        localCursor = localSQLiteDatabase.rawQuery("SELECT COUNT(*) from hits2", null);
        if (localCursor.moveToFirst())
        {
          long l = localCursor.getLong(0);
          i = (int)l;
        }
        if (localCursor != null)
          localCursor.close();
        j = i;
      }
      catch (SQLiteException localSQLiteException)
      {
        while (true)
        {
          int k = Log.w("Error getting numStoredHits");
          if (localCursor != null)
            localCursor.close();
        }
      }
      finally
      {
        Cursor localCursor;
        if (localCursor != null)
          localCursor.close();
      }
    }
  }

  // ERROR //
  public List<Hit> peekHits(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 428
    //   4: invokespecial 259	com/google/analytics/tracking/android/PersistentAnalyticsStore:getWritableDatabase	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore_2
    //   8: aload_2
    //   9: ifnonnull +13 -> 22
    //   12: new 165	java/util/ArrayList
    //   15: dup
    //   16: invokespecial 429	java/util/ArrayList:<init>	()V
    //   19: astore_3
    //   20: aload_3
    //   21: areturn
    //   22: new 165	java/util/ArrayList
    //   25: dup
    //   26: invokespecial 429	java/util/ArrayList:<init>	()V
    //   29: astore 4
    //   31: iconst_3
    //   32: anewarray 62	java/lang/String
    //   35: astore 5
    //   37: aload 5
    //   39: iconst_0
    //   40: ldc 26
    //   42: aastore
    //   43: aload 5
    //   45: iconst_1
    //   46: ldc 32
    //   48: aastore
    //   49: aload 5
    //   51: iconst_2
    //   52: ldc 35
    //   54: aastore
    //   55: iconst_2
    //   56: anewarray 4	java/lang/Object
    //   59: astore 6
    //   61: aload 6
    //   63: iconst_0
    //   64: ldc 35
    //   66: aastore
    //   67: aload 6
    //   69: iconst_1
    //   70: ldc 26
    //   72: aastore
    //   73: ldc_w 431
    //   76: aload 6
    //   78: invokestatic 66	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   81: astore 7
    //   83: iload_1
    //   84: invokestatic 436	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   87: astore 8
    //   89: aload_2
    //   90: ldc 23
    //   92: aload 5
    //   94: aconst_null
    //   95: aconst_null
    //   96: aconst_null
    //   97: aconst_null
    //   98: aload 7
    //   100: aload 8
    //   102: invokevirtual 440	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   105: astore 9
    //   107: new 165	java/util/ArrayList
    //   110: dup
    //   111: invokespecial 429	java/util/ArrayList:<init>	()V
    //   114: astore_3
    //   115: aload 9
    //   117: invokeinterface 419 1 0
    //   122: ifeq +78 -> 200
    //   125: aload 9
    //   127: iconst_0
    //   128: invokeinterface 423 2 0
    //   133: lstore 10
    //   135: aload 9
    //   137: iconst_1
    //   138: invokeinterface 423 2 0
    //   143: lstore 12
    //   145: new 336	com/google/analytics/tracking/android/Hit
    //   148: dup
    //   149: aconst_null
    //   150: lload 10
    //   152: lload 12
    //   154: invokespecial 443	com/google/analytics/tracking/android/Hit:<init>	(Ljava/lang/String;JJ)V
    //   157: astore 14
    //   159: aload 9
    //   161: iconst_2
    //   162: invokeinterface 446 2 0
    //   167: astore 15
    //   169: aload 14
    //   171: aload 15
    //   173: invokevirtual 449	com/google/analytics/tracking/android/Hit:setHitUrl	(Ljava/lang/String;)V
    //   176: aload_3
    //   177: aload 14
    //   179: invokeinterface 205 2 0
    //   184: istore 16
    //   186: aload 9
    //   188: invokeinterface 452 1 0
    //   193: istore 17
    //   195: iload 17
    //   197: ifne -72 -> 125
    //   200: aload 9
    //   202: ifnull +10 -> 212
    //   205: aload 9
    //   207: invokeinterface 424 1 0
    //   212: iconst_0
    //   213: istore 18
    //   215: iconst_2
    //   216: anewarray 62	java/lang/String
    //   219: astore 19
    //   221: aload 19
    //   223: iconst_0
    //   224: ldc 26
    //   226: aastore
    //   227: aload 19
    //   229: iconst_1
    //   230: ldc 29
    //   232: aastore
    //   233: iconst_1
    //   234: anewarray 4	java/lang/Object
    //   237: astore 20
    //   239: aload 20
    //   241: iconst_0
    //   242: ldc 26
    //   244: aastore
    //   245: ldc_w 454
    //   248: aload 20
    //   250: invokestatic 66	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   253: astore 21
    //   255: iload_1
    //   256: invokestatic 436	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   259: astore 22
    //   261: aload_2
    //   262: ldc 23
    //   264: aload 19
    //   266: aconst_null
    //   267: aconst_null
    //   268: aconst_null
    //   269: aconst_null
    //   270: aload 21
    //   272: aload 22
    //   274: invokevirtual 440	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   277: astore 9
    //   279: aload 9
    //   281: invokeinterface 419 1 0
    //   286: ifeq +75 -> 361
    //   289: aload 9
    //   291: instanceof 456
    //   294: ifeq +335 -> 629
    //   297: aload 9
    //   299: checkcast 456	android/database/sqlite/SQLiteCursor
    //   302: invokevirtual 460	android/database/sqlite/SQLiteCursor:getWindow	()Landroid/database/CursorWindow;
    //   305: invokevirtual 465	android/database/CursorWindow:getNumRows	()I
    //   308: ifle +147 -> 455
    //   311: aload_3
    //   312: iload 18
    //   314: invokeinterface 469 2 0
    //   319: checkcast 336	com/google/analytics/tracking/android/Hit
    //   322: astore 23
    //   324: aload 9
    //   326: iconst_1
    //   327: invokeinterface 446 2 0
    //   332: astore 24
    //   334: aload 23
    //   336: aload 24
    //   338: invokevirtual 472	com/google/analytics/tracking/android/Hit:setHitString	(Ljava/lang/String;)V
    //   341: iload 18
    //   343: iconst_1
    //   344: iadd
    //   345: istore 18
    //   347: aload 9
    //   349: invokeinterface 452 1 0
    //   354: istore 17
    //   356: iload 17
    //   358: ifne -69 -> 289
    //   361: aload 9
    //   363: ifnull -343 -> 20
    //   366: aload 9
    //   368: invokeinterface 424 1 0
    //   373: goto -353 -> 20
    //   376: astore 25
    //   378: new 179	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   385: ldc_w 474
    //   388: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: astore 26
    //   393: aload 25
    //   395: invokevirtual 477	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   398: astore 27
    //   400: aload 26
    //   402: aload 27
    //   404: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: invokestatic 226	com/google/analytics/tracking/android/Log:w	(Ljava/lang/String;)I
    //   413: istore 28
    //   415: new 165	java/util/ArrayList
    //   418: dup
    //   419: invokespecial 429	java/util/ArrayList:<init>	()V
    //   422: astore_3
    //   423: aload 9
    //   425: ifnull -405 -> 20
    //   428: aload 9
    //   430: invokeinterface 424 1 0
    //   435: goto -415 -> 20
    //   438: astore 29
    //   440: aload 9
    //   442: ifnull +10 -> 452
    //   445: aload 9
    //   447: invokeinterface 424 1 0
    //   452: aload 29
    //   454: athrow
    //   455: new 179	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   462: ldc_w 479
    //   465: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: astore 30
    //   470: aload_3
    //   471: iload 18
    //   473: invokeinterface 469 2 0
    //   478: checkcast 336	com/google/analytics/tracking/android/Hit
    //   481: invokevirtual 340	com/google/analytics/tracking/android/Hit:getHitId	()J
    //   484: lstore 31
    //   486: aload 30
    //   488: lload 31
    //   490: invokevirtual 482	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   493: ldc_w 484
    //   496: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokestatic 226	com/google/analytics/tracking/android/Log:w	(Ljava/lang/String;)I
    //   505: istore 33
    //   507: goto -166 -> 341
    //   510: astore 25
    //   512: new 179	java/lang/StringBuilder
    //   515: dup
    //   516: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   519: ldc_w 486
    //   522: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: astore 34
    //   527: aload 25
    //   529: invokevirtual 477	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   532: astore 35
    //   534: aload 34
    //   536: aload 35
    //   538: invokevirtual 187	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokestatic 226	com/google/analytics/tracking/android/Log:w	(Ljava/lang/String;)I
    //   547: istore 36
    //   549: new 165	java/util/ArrayList
    //   552: dup
    //   553: invokespecial 429	java/util/ArrayList:<init>	()V
    //   556: astore 37
    //   558: iconst_0
    //   559: istore 35
    //   561: aload_3
    //   562: invokeinterface 487 1 0
    //   567: astore 39
    //   569: aload 39
    //   571: invokeinterface 130 1 0
    //   576: ifeq +35 -> 611
    //   579: aload 39
    //   581: invokeinterface 134 1 0
    //   586: checkcast 336	com/google/analytics/tracking/android/Hit
    //   589: astore 40
    //   591: aload 40
    //   593: invokevirtual 490	com/google/analytics/tracking/android/Hit:getHitParams	()Ljava/lang/String;
    //   596: invokestatic 493	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   599: istore 17
    //   601: iload 17
    //   603: ifeq +76 -> 679
    //   606: iload 35
    //   608: ifeq +71 -> 679
    //   611: aload 9
    //   613: ifnull +10 -> 623
    //   616: aload 9
    //   618: invokeinterface 424 1 0
    //   623: aload 37
    //   625: astore_3
    //   626: goto -606 -> 20
    //   629: aload_3
    //   630: iload 18
    //   632: invokeinterface 469 2 0
    //   637: checkcast 336	com/google/analytics/tracking/android/Hit
    //   640: astore 41
    //   642: aload 9
    //   644: iconst_1
    //   645: invokeinterface 446 2 0
    //   650: astore 42
    //   652: aload 41
    //   654: aload 42
    //   656: invokevirtual 472	com/google/analytics/tracking/android/Hit:setHitString	(Ljava/lang/String;)V
    //   659: goto -318 -> 341
    //   662: astore 43
    //   664: aload 9
    //   666: ifnull +10 -> 676
    //   669: aload 9
    //   671: invokeinterface 424 1 0
    //   676: aload 43
    //   678: athrow
    //   679: aload 37
    //   681: aload 40
    //   683: invokeinterface 205 2 0
    //   688: istore 44
    //   690: goto -121 -> 569
    //   693: astore 29
    //   695: aload_3
    //   696: astore 45
    //   698: goto -258 -> 440
    //   701: astore 25
    //   703: aload_3
    //   704: astore 46
    //   706: goto -328 -> 378
    //
    // Exception table:
    //   from	to	target	type
    //   31	115	376	android/database/sqlite/SQLiteException
    //   31	115	438	finally
    //   378	423	438	finally
    //   215	356	510	android/database/sqlite/SQLiteException
    //   455	507	510	android/database/sqlite/SQLiteException
    //   629	659	510	android/database/sqlite/SQLiteException
    //   215	356	662	finally
    //   455	507	662	finally
    //   512	601	662	finally
    //   629	659	662	finally
    //   679	690	662	finally
    //   115	195	693	finally
    //   115	195	701	android/database/sqlite/SQLiteException
  }

  public void putHit(Map<String, String> paramMap, long paramLong, String paramString, Collection<Command> paramCollection)
  {
    int i = deleteStaleHits();
    if (!tokensAvailable())
      return;
    fillVersionParametersIfNecessary(paramMap, paramCollection);
    removeOldHitIfFull();
    writeHitToDatabase(paramMap, paramLong, paramString);
  }

  public void setDispatch(boolean paramBoolean)
  {
    HttpClientFactory localHttpClientFactory;
    Context localContext;
    if (paramBoolean)
    {
      localHttpClientFactory = createDefaultHttpClientFactory();
      localContext = this.context;
    }
    for (Object localObject = new SimpleNetworkDispatcher(this, localHttpClientFactory, localContext); ; localObject = new NoopDispatcher())
    {
      this.dispatcher = ((Dispatcher)localObject);
      return;
    }
  }

  void setDispatcher(Dispatcher paramDispatcher)
  {
    this.dispatcher = paramDispatcher;
  }

  void setLastDeleteStaleHitsTime(long paramLong)
  {
    this.lastDeleteStaleHitsTime = paramLong;
  }

  void setLastTrackTime(long paramLong)
  {
    this.lastTrackTime = paramLong;
  }

  public void setThrottlingEnabled(boolean paramBoolean)
  {
    this.throttlingEnabled = paramBoolean;
  }

  void setTokens(long paramLong)
  {
    this.tokens = paramLong;
  }

  /** @deprecated */
  boolean tokensAvailable()
  {
    boolean bool1 = true;
    while (true)
    {
      try
      {
        boolean bool2 = this.throttlingEnabled;
        if (!bool2)
          return bool1;
        long l1 = System.currentTimeMillis();
        if (this.tokens < 120000L)
        {
          long l2 = this.lastTrackTime;
          long l3 = l1 - l2;
          if (l3 > 0L)
          {
            long l4 = this.tokens + l3;
            long l5 = Math.min(120000L, l4);
            this.tokens = l5;
          }
        }
        this.lastTrackTime = l1;
        if (this.tokens >= 2000L)
        {
          long l6 = this.tokens - 2000L;
          this.tokens = l6;
          continue;
        }
      }
      finally
      {
      }
      int i = Log.wDebug("Excessive tracking detected.  Tracking call ignored.");
      bool1 = false;
    }
  }

  class AnalyticsDatabaseHelper extends SQLiteOpenHelper
  {
    private boolean badDatabase;

    AnalyticsDatabaseHelper(Context paramString, String arg3)
    {
      super(str, null, 1);
    }

    private boolean tablePresent(String paramString, SQLiteDatabase paramSQLiteDatabase)
    {
      try
      {
        String[] arrayOfString1 = new String[1];
        arrayOfString1[0] = "name";
        String[] arrayOfString2 = new String[1];
        arrayOfString2[0] = paramString;
        localCursor = paramSQLiteDatabase.query("SQLITE_MASTER", arrayOfString1, "name=?", arrayOfString2, null, null, null);
        boolean bool1 = localCursor.moveToFirst();
        bool2 = bool1;
        return bool2;
      }
      catch (SQLiteException localSQLiteException)
      {
        while (true)
        {
          int i = Log.w("error querying for table " + paramString);
          if (localCursor != null)
            localCursor.close();
          boolean bool2 = false;
        }
      }
      finally
      {
        Cursor localCursor;
        if (localCursor != null)
          localCursor.close();
      }
    }

    public SQLiteDatabase getWritableDatabase()
    {
      if (this.badDatabase)
        throw new SQLiteException("Database creation failed");
      return super.getWritableDatabase();
    }

    boolean isBadDatabase()
    {
      return this.badDatabase;
    }

    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      boolean bool = FutureApis.setOwnerOnlyReadWrite(paramSQLiteDatabase.getPath());
    }

    public void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      try
      {
        if (tablePresent("hits2", paramSQLiteDatabase))
          return;
        String str = PersistentAnalyticsStore.CREATE_HITS_TABLE;
        paramSQLiteDatabase.execSQL(str);
        return;
      }
      catch (SQLiteException localSQLiteException)
      {
        int i = Log.w("Error on database open");
        this.badDatabase = true;
      }
    }

    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
    {
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.google.analytics.tracking.android.PersistentAnalyticsStore
 * JD-Core Version:    0.6.2
 */