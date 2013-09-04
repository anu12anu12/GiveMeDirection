package com.j256.ormlite.android.apptools;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;

public abstract class OrmLiteBaseActivity<H extends OrmLiteSqliteOpenHelper> extends Activity
{
  private static Logger logger = LoggerFactory.getLogger(OrmLiteBaseActivity.class);
  private volatile boolean created = false;
  private volatile boolean destroyed = false;
  private volatile H helper;

  public ConnectionSource getConnectionSource()
  {
    return getHelper().getConnectionSource();
  }

  public H getHelper()
  {
    if (this.helper == null)
    {
      if (!this.created)
        throw new IllegalStateException("A call has not been made to onCreate() yet so the helper is null");
      if (this.destroyed)
        throw new IllegalStateException("A call to onDestroy has already been made and the helper cannot be used after that point");
      throw new IllegalStateException("Helper is null for some unknown reason");
    }
    return this.helper;
  }

  protected H getHelperInternal(Context paramContext)
  {
    OrmLiteSqliteOpenHelper localOrmLiteSqliteOpenHelper = OpenHelperManager.getHelper(paramContext);
    logger.trace("{}: got new helper {} from OpenHelperManager", this, localOrmLiteSqliteOpenHelper);
    return localOrmLiteSqliteOpenHelper;
  }

  protected void onCreate(Bundle paramBundle)
  {
    if (this.helper == null)
    {
      OrmLiteSqliteOpenHelper localOrmLiteSqliteOpenHelper = getHelperInternal(this);
      this.helper = localOrmLiteSqliteOpenHelper;
      this.created = true;
    }
    super.onCreate(paramBundle);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    OrmLiteSqliteOpenHelper localOrmLiteSqliteOpenHelper = this.helper;
    releaseHelper(localOrmLiteSqliteOpenHelper);
    this.destroyed = true;
  }

  protected void releaseHelper(H paramH)
  {
    OpenHelperManager.releaseHelper();
    logger.trace("{}: helper {} was released, set to null", this, paramH);
    this.helper = null;
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    String str1 = getClass().getSimpleName();
    StringBuilder localStringBuilder2 = localStringBuilder1.append(str1).append("@");
    String str2 = Integer.toHexString(super.hashCode());
    return str2;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.j256.ormlite.android.apptools.OrmLiteBaseActivity
 * JD-Core Version:    0.6.2
 */