package org.simpleframework.xml.core;

import java.util.List;

abstract interface Instantiator
{
  public abstract List<Creator> getCreators();

  public abstract Object getInstance()
    throws Exception;

  public abstract Object getInstance(Criteria paramCriteria)
    throws Exception;

  public abstract Parameter getParameter(String paramString);

  public abstract List<Parameter> getParameters();

  public abstract boolean isDefault();
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Instantiator
 * JD-Core Version:    0.6.2
 */