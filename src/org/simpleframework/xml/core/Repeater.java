package org.simpleframework.xml.core;

import org.simpleframework.xml.stream.InputNode;

abstract interface Repeater extends Converter
{
  public abstract Object read(InputNode paramInputNode, Object paramObject)
    throws Exception;
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Repeater
 * JD-Core Version:    0.6.2
 */