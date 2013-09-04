package com.ls.widgets.map.providers;

import android.content.Context;
import android.content.res.AssetManager;
import com.ls.widgets.map.config.OfflineMapConfig;
import com.ls.widgets.map.utils.OfflineMapUtil;
import java.io.IOException;
import java.io.InputStream;

public class AssetTileProvider extends TileProvider
{
  private AssetManager a;
  private StringBuilder b;

  public AssetTileProvider(Context paramContext, OfflineMapConfig paramOfflineMapConfig)
  {
    super(paramOfflineMapConfig);
    AssetManager localAssetManager = paramContext.getAssets();
    this.a = localAssetManager;
    StringBuilder localStringBuilder = new StringBuilder(256);
    this.b = localStringBuilder;
  }

  protected InputStream openTile(int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    String str1 = OfflineMapUtil.getFilesPath(this.config.getMapRootPath());
    StringBuilder localStringBuilder1 = this.b;
    int i = this.b.length();
    StringBuilder localStringBuilder2 = localStringBuilder1.delete(0, i);
    StringBuilder localStringBuilder3 = this.b.append(str1);
    StringBuilder localStringBuilder4 = this.b.append(paramInt1);
    StringBuilder localStringBuilder5 = this.b.append("/");
    StringBuilder localStringBuilder6 = this.b.append(paramInt2);
    StringBuilder localStringBuilder7 = this.b.append("_");
    StringBuilder localStringBuilder8 = this.b.append(paramInt3);
    StringBuilder localStringBuilder9 = this.b.append(".");
    StringBuilder localStringBuilder10 = this.b;
    String str2 = this.config.getImageFormat();
    StringBuilder localStringBuilder11 = localStringBuilder10.append(str2);
    AssetManager localAssetManager = this.a;
    String str3 = this.b.toString();
    return localAssetManager.open(str3);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.providers.AssetTileProvider
 * JD-Core Version:    0.6.2
 */