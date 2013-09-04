package org.simpleframework.xml.stream;

public enum Mode
{
  static
  {
    Mode[] arrayOfMode = new Mode[3];
    Mode localMode1 = DATA;
    arrayOfMode[0] = localMode1;
    Mode localMode2 = ESCAPE;
    arrayOfMode[1] = localMode2;
    Mode localMode3 = INHERIT;
    arrayOfMode[2] = localMode3;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.Mode
 * JD-Core Version:    0.6.2
 */