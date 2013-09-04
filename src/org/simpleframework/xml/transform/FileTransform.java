package org.simpleframework.xml.transform;

import java.io.File;

class FileTransform
  implements Transform<File>
{
  public File read(String paramString)
  {
    return new File(paramString);
  }

  public String write(File paramFile)
  {
    return paramFile.getPath();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.FileTransform
 * JD-Core Version:    0.6.2
 */