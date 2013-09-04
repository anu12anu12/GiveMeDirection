package org.simpleframework.xml.stream;

import java.io.IOException;
import java.io.Writer;

class OutputBuffer
{
  private StringBuilder text;

  public OutputBuffer()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    this.text = localStringBuilder;
  }

  public void append(char paramChar)
  {
    StringBuilder localStringBuilder = this.text.append(paramChar);
  }

  public void append(String paramString)
  {
    StringBuilder localStringBuilder = this.text.append(paramString);
  }

  public void append(String paramString, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = this.text.append(paramString, paramInt1, paramInt2);
  }

  public void append(char[] paramArrayOfChar)
  {
    StringBuilder localStringBuilder1 = this.text;
    int i = paramArrayOfChar.length;
    StringBuilder localStringBuilder2 = localStringBuilder1.append(paramArrayOfChar, 0, i);
  }

  public void append(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = this.text.append(paramArrayOfChar, paramInt1, paramInt2);
  }

  public void clear()
  {
    this.text.setLength(0);
  }

  public void write(Writer paramWriter)
    throws IOException
  {
    StringBuilder localStringBuilder = this.text;
    Writer localWriter = paramWriter.append(localStringBuilder);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.OutputBuffer
 * JD-Core Version:    0.6.2
 */