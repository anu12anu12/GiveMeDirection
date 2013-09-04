package com.nostra13.universalimageloader.core;

import android.net.Uri;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.MemoryCacheKeyUtil;
import java.util.concurrent.locks.ReentrantLock;

final class ImageLoadingInfo
{
  final ImageView imageView;
  final ImageLoadingListener listener;
  final ReentrantLock loadFromUriLock;
  final String memoryCacheKey;
  final DisplayImageOptions options;
  final ImageSize targetSize;
  final String uri;

  public ImageLoadingInfo(String paramString, ImageView paramImageView, ImageSize paramImageSize, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener, ReentrantLock paramReentrantLock)
  {
    String str1 = Uri.encode(paramString, "@#&=*+-_.,:!?()/~'%");
    this.uri = str1;
    this.imageView = paramImageView;
    this.targetSize = paramImageSize;
    this.options = paramDisplayImageOptions;
    this.listener = paramImageLoadingListener;
    this.loadFromUriLock = paramReentrantLock;
    String str2 = MemoryCacheKeyUtil.generateKey(paramString, paramImageSize);
    this.memoryCacheKey = str2;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.ImageLoadingInfo
 * JD-Core Version:    0.6.2
 */