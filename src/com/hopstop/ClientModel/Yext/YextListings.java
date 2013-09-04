package com.hopstop.ClientModel.Yext;

import java.io.Serializable;
import java.util.ArrayList;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.core.Commit;

@Root(name="listings", strict=false)
public class YextListings
  implements Serializable
{

  @ElementList(inline=true, name="listings", required=false)
  private ArrayList<Listing> _listingList;

  public YextListings()
  {
    ArrayList localArrayList = new ArrayList();
    this._listingList = localArrayList;
  }

  @Commit
  private void build()
  {
    int i = getListingCount();
  }

  public void addListing(int paramInt, Listing paramListing)
    throws IndexOutOfBoundsException
  {
    this._listingList.add(paramInt, paramListing);
  }

  public Listing getListing(int paramInt)
    throws IndexOutOfBoundsException
  {
    if (paramInt >= 0)
    {
      int i = this._listingList.size();
      if (paramInt < i);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder("getListing: Index value '").append(paramInt).append("' not in range [0..");
      int j = this._listingList.size() + -1;
      String str = j + "]";
      throw new IndexOutOfBoundsException(str);
    }
    return (Listing)this._listingList.get(paramInt);
  }

  public Listing[] getListing()
  {
    Listing[] arrayOfListing = new Listing[0];
    return (Listing[])this._listingList.toArray(arrayOfListing);
  }

  public int getListingCount()
  {
    return this._listingList.size();
  }

  public void removeAllListing()
  {
    this._listingList.clear();
  }

  public boolean removeListing(Listing paramListing)
  {
    return this._listingList.remove(paramListing);
  }

  public Listing removeListingAt(int paramInt)
  {
    return (Listing)this._listingList.remove(paramInt);
  }

  public void setListing(int paramInt, Listing paramListing)
    throws IndexOutOfBoundsException
  {
    if (paramInt >= 0)
    {
      int i = this._listingList.size();
      if (paramInt < i);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder("setListing: Index value '").append(paramInt).append("' not in range [0..");
      int j = this._listingList.size() + -1;
      String str = j + "]";
      throw new IndexOutOfBoundsException(str);
    }
    Object localObject = this._listingList.set(paramInt, paramListing);
  }

  public void setListing(Listing[] paramArrayOfListing)
  {
    this._listingList.clear();
    int i = 0;
    while (true)
    {
      int j = paramArrayOfListing.length;
      if (i >= j)
        return;
      ArrayList localArrayList = this._listingList;
      Listing localListing = paramArrayOfListing[i];
      boolean bool = localArrayList.add(localListing);
      i += 1;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Yext.YextListings
 * JD-Core Version:    0.6.2
 */