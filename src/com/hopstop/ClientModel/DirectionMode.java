package com.hopstop.ClientModel;

public class DirectionMode
{
  private String mode;

  public String getMode()
  {
    if (this.mode == null);
    for (String str = "s"; ; str = this.mode)
      return str;
  }

  public boolean isModeAll()
  {
    return this.mode.equalsIgnoreCase("a");
  }

  public boolean isModeBike()
  {
    return this.mode.equals("z");
  }

  public boolean isModeSet()
  {
    if (this.mode != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void setMode(String paramString)
  {
    if (paramString.equals(""))
    {
      this.mode = "s";
      return;
    }
    this.mode = paramString;
  }

  public String translateModeForKeywords()
  {
    String str;
    if (this.mode != null)
      if (this.mode.equals("s"))
        str = "subway";
    while (true)
    {
      return str;
      if (this.mode.equals("b"))
        str = "bus";
      else if (this.mode.equals("a"))
        str = "allmodes";
      else if (this.mode.equals("w"))
        str = "walking";
      else if (this.mode.equals("j"))
        str = "taxi";
      else
        str = null;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.DirectionMode
 * JD-Core Version:    0.6.2
 */