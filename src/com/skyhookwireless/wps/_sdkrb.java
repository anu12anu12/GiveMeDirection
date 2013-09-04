package com.skyhookwireless.wps;

import com.skyhookwireless._sdkhd;
import com.skyhookwireless._sdkw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;

class _sdkrb
  implements Cache.Finder<_sdkzb, _sdkib>
{
  final _sdkqb _sdka;

  _sdkrb(_sdkqb param_sdkqb)
  {
  }

  public Map.Entry<_sdkzb, _sdkib> call(Iterator<Map.Entry<_sdkzb, _sdkib>> paramIterator, _sdkzb param_sdkzb)
  {
    int i = Location._sdki;
    ArrayList localArrayList1 = param_sdkzb.getCells();
    Object localObject2;
    for (Object localObject1 = null; ; localObject1 = localObject2)
    {
      if (paramIterator.hasNext())
      {
        localObject2 = (Map.Entry)paramIterator.next();
        ArrayList localArrayList2 = ((_sdkzb)((Map.Entry)localObject2).getKey()).getCells();
        int j = localArrayList2.size();
        int k = localArrayList1.size();
        if (j != k)
        {
          Comparator localComparator = _sdkw.CELL_COMPARATOR;
          if (_sdkhd._sdka(localArrayList2, localArrayList1, localComparator))
            if (i == 0)
              continue;
        }
      }
      while (true)
      {
        return localObject2;
        localObject2 = localObject1;
        break;
        localObject2 = localObject1;
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.skyhookwireless.wps._sdkrb
 * JD-Core Version:    0.6.2
 */