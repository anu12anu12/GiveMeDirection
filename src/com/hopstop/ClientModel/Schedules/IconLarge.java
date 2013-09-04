package com.hopstop.ClientModel.Schedules;

import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(strict=false)
public class IconLarge
  implements Serializable
{

  @Element(name="Height", required=false)
  private int height;

  @Element(name="URL")
  private String url;

  @Element(name="Width", required=false)
  private int width;

  public int getHeight()
  {
    return this.height;
  }

  public String getURL()
  {
    return this.url;
  }

  public int getWidth()
  {
    return this.width;
  }

  public void setHeight(int paramInt)
  {
    this.height = paramInt;
  }

  public void setURL(String paramString)
  {
    this.url = paramString;
  }

  public void setWidth(int paramInt)
  {
    this.width = paramInt;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Schedules.IconLarge
 * JD-Core Version:    0.6.2
 */