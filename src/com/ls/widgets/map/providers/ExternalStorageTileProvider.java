package com.ls.widgets.map.providers;

import com.ls.widgets.map.config.OfflineMapConfig;
import com.ls.widgets.map.utils.OfflineMapUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExternalStorageTileProvider extends TileProvider
{
  private StringBuilder a;

  public ExternalStorageTileProvider(OfflineMapConfig paramOfflineMapConfig)
  {
    super(paramOfflineMapConfig);
    StringBuilder localStringBuilder = new StringBuilder();
    this.a = localStringBuilder;
  }

  protected InputStream openTile(int paramInt1, int paramInt2, int paramInt3)
    throws IOException
  {
    String str1 = OfflineMapUtil.getFilesPath(this.config.getMapRootPath());
    StringBuilder localStringBuilder1 = this.a;
    int i = this.a.length();
    StringBuilder localStringBuilder2 = localStringBuilder1.delete(0, i);
    StringBuilder localStringBuilder3 = this.a.append(str1);
    StringBuilder localStringBuilder4 = this.a.append(paramInt1);
    StringBuilder localStringBuilder5 = this.a.append("/");
    StringBuilder localStringBuilder6 = this.a.append(paramInt2);
    StringBuilder localStringBuilder7 = this.a.append("_");
    StringBuilder localStringBuilder8 = this.a.append(paramInt3);
    StringBuilder localStringBuilder9 = this.a.append(".");
    StringBuilder localStringBuilder10 = this.a;
    String str2 = this.config.getImageFormat();
    StringBuilder localStringBuilder11 = localStringBuilder10.append(str2);
    String str3 = this.a.toString();
    File localFile = new File(str3);
    if (localFile.exists());
    for (FileInputStream localFileInputStream = new FileInputStream(localFile); ; localFileInputStream = null)
      return localFileInputStream;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.ls.widgets.map.providers.ExternalStorageTileProvider
 * JD-Core Version:    0.6.2
 */