package com.nostra13.universalimageloader.core.assist;

public enum FailReason
{
  static
  {
    FailReason[] arrayOfFailReason = new FailReason[3];
    FailReason localFailReason1 = IO_ERROR;
    arrayOfFailReason[0] = localFailReason1;
    FailReason localFailReason2 = OUT_OF_MEMORY;
    arrayOfFailReason[1] = localFailReason2;
    FailReason localFailReason3 = UNKNOWN;
    arrayOfFailReason[2] = localFailReason3;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.FailReason
 * JD-Core Version:    0.6.2
 */