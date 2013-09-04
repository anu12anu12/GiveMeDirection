package com.ls.widgets.map.providers;

import android.os.AsyncTask;
import com.ls.widgets.map.commands.GetTileTask;
import com.ls.widgets.map.config.OfflineMapConfig;
import com.ls.widgets.map.interfaces.TileManagerDelegate;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.RejectedExecutionException;

public abstract class TileProvider
{
  protected static final String TAG = TileProvider.class.getSimpleName();
  protected Queue<GetTileTask> commandQueue;
  protected OfflineMapConfig config;
  protected boolean paused;

  public TileProvider(OfflineMapConfig paramOfflineMapConfig)
  {
    this.config = paramOfflineMapConfig;
    LinkedList localLinkedList = new LinkedList();
    this.commandQueue = localLinkedList;
  }

  protected abstract InputStream openTile(int paramInt1, int paramInt2, int paramInt3)
    throws IOException;

  public void pauseProcessingCommands()
  {
    this.paused = true;
  }

  public void requestTile(int paramInt1, int paramInt2, int paramInt3, TileManagerDelegate paramTileManagerDelegate)
  {
    try
    {
      InputStream localInputStream = openTile(paramInt1, paramInt2, paramInt3);
      if (localInputStream == null)
      {
        paramTileManagerDelegate.onError(null);
        return;
      }
      TileProvider localTileProvider = this;
      final TileManagerDelegate localTileManagerDelegate = paramTileManagerDelegate;
      final int i = paramInt1;
      final int j = paramInt2;
      final int k = paramInt3;
      GetTileTask local1 = new GetTileTask(localInputStream)
      {
        // ERROR //
        protected void a(java.lang.Boolean paramAnonymousBoolean)
        {
          // Byte code:
          //   0: getstatic 43	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
          //   3: astore_2
          //   4: aload_1
          //   5: aload_2
          //   6: invokevirtual 47	java/lang/Boolean:equals	(Ljava/lang/Object;)Z
          //   9: ifeq +51 -> 60
          //   12: aload_0
          //   13: getfield 25	com/ls/widgets/map/providers/TileProvider$1:a	Lcom/ls/widgets/map/interfaces/TileManagerDelegate;
          //   16: astore_3
          //   17: aload_0
          //   18: getfield 27	com/ls/widgets/map/providers/TileProvider$1:b	I
          //   21: istore 4
          //   23: aload_0
          //   24: getfield 29	com/ls/widgets/map/providers/TileProvider$1:c	I
          //   27: istore 5
          //   29: aload_0
          //   30: getfield 31	com/ls/widgets/map/providers/TileProvider$1:d	I
          //   33: istore 6
          //   35: aload_0
          //   36: invokevirtual 51	com/ls/widgets/map/providers/TileProvider$1:getResult	()Landroid/graphics/drawable/Drawable;
          //   39: astore 7
          //   41: aload_3
          //   42: iload 4
          //   44: iload 5
          //   46: iload 6
          //   48: aload 7
          //   50: invokeinterface 57 5 0
          //   55: aload_0
          //   56: invokevirtual 61	com/ls/widgets/map/providers/TileProvider$1:closeStream	()V
          //   59: return
          //   60: getstatic 65	com/ls/widgets/map/providers/TileProvider:TAG	Ljava/lang/String;
          //   63: astore 8
          //   65: new 67	java/lang/StringBuilder
          //   68: dup
          //   69: invokespecial 69	java/lang/StringBuilder:<init>	()V
          //   72: ldc 71
          //   74: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   77: astore 9
          //   79: aload_0
          //   80: getfield 27	com/ls/widgets/map/providers/TileProvider$1:b	I
          //   83: istore 10
          //   85: aload 9
          //   87: iload 10
          //   89: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
          //   92: ldc 80
          //   94: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   97: astore 11
          //   99: aload_0
          //   100: getfield 29	com/ls/widgets/map/providers/TileProvider$1:c	I
          //   103: istore 12
          //   105: aload 11
          //   107: iload 12
          //   109: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
          //   112: ldc 82
          //   114: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   117: astore 13
          //   119: aload_0
          //   120: getfield 31	com/ls/widgets/map/providers/TileProvider$1:d	I
          //   123: istore 14
          //   125: aload 13
          //   127: iload 14
          //   129: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
          //   132: ldc 84
          //   134: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   137: astore 15
          //   139: aload_0
          //   140: getfield 23	com/ls/widgets/map/providers/TileProvider$1:e	Lcom/ls/widgets/map/providers/TileProvider;
          //   143: getfield 88	com/ls/widgets/map/providers/TileProvider:config	Lcom/ls/widgets/map/config/OfflineMapConfig;
          //   146: invokevirtual 94	com/ls/widgets/map/config/OfflineMapConfig:getImageFormat	()Ljava/lang/String;
          //   149: astore 16
          //   151: aload 15
          //   153: aload 16
          //   155: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   158: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   161: astore 17
          //   163: aload 8
          //   165: aload 17
          //   167: invokestatic 103	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
          //   170: istore 18
          //   172: aload_0
          //   173: getfield 25	com/ls/widgets/map/providers/TileProvider$1:a	Lcom/ls/widgets/map/interfaces/TileManagerDelegate;
          //   176: aconst_null
          //   177: invokeinterface 107 2 0
          //   182: goto -127 -> 55
          //   185: astore 19
          //   187: aload_0
          //   188: invokevirtual 61	com/ls/widgets/map/providers/TileProvider$1:closeStream	()V
          //   191: aload 19
          //   193: athrow
          //   194: astore 20
          //   196: aload 20
          //   198: invokevirtual 110	java/io/IOException:printStackTrace	()V
          //   201: getstatic 65	com/ls/widgets/map/providers/TileProvider:TAG	Ljava/lang/String;
          //   204: astore 21
          //   206: new 67	java/lang/StringBuilder
          //   209: dup
          //   210: invokespecial 69	java/lang/StringBuilder:<init>	()V
          //   213: ldc 112
          //   215: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   218: aload 20
          //   220: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
          //   223: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   226: astore 22
          //   228: aload 21
          //   230: aload 22
          //   232: invokestatic 103	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
          //   235: istore 23
          //   237: aload_0
          //   238: getfield 25	com/ls/widgets/map/providers/TileProvider$1:a	Lcom/ls/widgets/map/interfaces/TileManagerDelegate;
          //   241: aconst_null
          //   242: invokeinterface 107 2 0
          //   247: return
          //   248: astore 24
          //   250: aload 24
          //   252: invokevirtual 110	java/io/IOException:printStackTrace	()V
          //   255: getstatic 65	com/ls/widgets/map/providers/TileProvider:TAG	Ljava/lang/String;
          //   258: astore 25
          //   260: new 67	java/lang/StringBuilder
          //   263: dup
          //   264: invokespecial 69	java/lang/StringBuilder:<init>	()V
          //   267: ldc 112
          //   269: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   272: aload 24
          //   274: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
          //   277: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   280: astore 26
          //   282: aload 25
          //   284: aload 26
          //   286: invokestatic 103	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
          //   289: istore 27
          //   291: aload_0
          //   292: getfield 25	com/ls/widgets/map/providers/TileProvider$1:a	Lcom/ls/widgets/map/interfaces/TileManagerDelegate;
          //   295: aconst_null
          //   296: invokeinterface 107 2 0
          //   301: goto -110 -> 191
          //
          // Exception table:
          //   from	to	target	type
          //   0	55	185	finally
          //   60	182	185	finally
          //   55	59	194	java/io/IOException
          //   187	191	248	java/io/IOException
        }
      };
      if (this.paused)
        synchronized (this.commandQueue)
        {
          boolean bool = this.commandQueue.add(local1);
          return;
        }
    }
    catch (IOException localIOException)
    {
      paramTileManagerDelegate.onError(localIOException);
      return;
    }
    ??? = null;
    try
    {
      Integer[] arrayOfInteger = new Integer[???];
      AsyncTask localAsyncTask = localObject.execute(arrayOfInteger);
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      paramTileManagerDelegate.onError(localRejectedExecutionException);
    }
  }

  public void startProcessingCommands()
  {
    this.paused = false;
    synchronized (this.commandQueue)
    {
      Iterator localIterator = this.commandQueue.iterator();
      if (localIterator.hasNext())
      {
        GetTileTask localGetTileTask = (GetTileTask)localIterator.next();
        Integer[] arrayOfInteger = new Integer[0];
        AsyncTask localAsyncTask = localGetTileTask.execute(arrayOfInteger);
      }
    }
    this.commandQueue.clear();
  }

  public void stopProcessingCommands()
  {
    synchronized (this.commandQueue)
    {
      this.commandQueue.clear();
      return;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.providers.TileProvider
 * JD-Core Version:    0.6.2
 */