package com.hopstop.ClientModel.Schedules;

import com.hopstop.ClientModel.ResponseStatus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root
public class Groups
  implements Serializable
{

  @ElementList(name="Groups")
  private ArrayList<Group> groupList;

  @Element(name="ResponseStatus", required=false)
  private ResponseStatus responseStatus;

  public Groups()
  {
    ArrayList localArrayList = new ArrayList();
    this.groupList = localArrayList;
  }

  public Groups(ArrayList<Group> paramArrayList)
  {
    this.groupList = paramArrayList;
  }

  public void addGroup(int paramInt, Group paramGroup)
    throws IndexOutOfBoundsException
  {
    this.groupList.add(paramInt, paramGroup);
  }

  public void addGroup(Group paramGroup)
    throws IndexOutOfBoundsException
  {
    boolean bool = this.groupList.add(paramGroup);
  }

  public Groups clone()
  {
    Groups localGroups = new Groups();
    ResponseStatus localResponseStatus1 = new ResponseStatus();
    localGroups.responseStatus = localResponseStatus1;
    ArrayList localArrayList1 = new ArrayList();
    localGroups.groupList = localArrayList1;
    ResponseStatus localResponseStatus2 = new ResponseStatus();
    localGroups.responseStatus = localResponseStatus2;
    ArrayList localArrayList2 = (ArrayList)this.groupList.clone();
    localGroups.groupList = localArrayList2;
    return localGroups;
  }

  public Group getGroup(int paramInt)
    throws IndexOutOfBoundsException
  {
    if (paramInt >= 0)
    {
      int i = this.groupList.size();
      if (paramInt < i);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder("getGroup: Index value '").append(paramInt).append("' not in range [0..");
      int j = this.groupList.size() + -1;
      String str = j + "]";
      throw new IndexOutOfBoundsException(str);
    }
    return (Group)this.groupList.get(paramInt);
  }

  public Group[] getGroup()
  {
    Group[] arrayOfGroup = new Group[0];
    return (Group[])this.groupList.toArray(arrayOfGroup);
  }

  public int getGroupCount()
  {
    return this.groupList.size();
  }

  public ArrayList<Group> getGroups()
  {
    return this.groupList;
  }

  public ResponseStatus getResponseStatus()
  {
    return this.responseStatus;
  }

  public int getSize()
  {
    if (this.groupList == null);
    for (int i = 0; ; i = this.groupList.size())
      return i;
  }

  public void reArrange()
  {
    ArrayList localArrayList = this.groupList;
    NaturalOrderComparator localNaturalOrderComparator = new NaturalOrderComparator();
    Collections.sort(localArrayList, localNaturalOrderComparator);
  }

  public void removeAllGroup()
  {
    this.groupList.clear();
  }

  public boolean removeGroup(Group paramGroup)
  {
    return this.groupList.remove(paramGroup);
  }

  public Group removeGroupAt(int paramInt)
  {
    return (Group)this.groupList.remove(paramInt);
  }

  public void setGroup(int paramInt, Group paramGroup)
    throws IndexOutOfBoundsException
  {
    if (paramInt >= 0)
    {
      int i = this.groupList.size();
      if (paramInt < i);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder("setGroup: Index value '").append(paramInt).append("' not in range [0..");
      int j = this.groupList.size() + -1;
      String str = j + "]";
      throw new IndexOutOfBoundsException(str);
    }
    Object localObject = this.groupList.set(paramInt, paramGroup);
  }

  public void setGroup(Group[] paramArrayOfGroup)
  {
    this.groupList.clear();
    int i = 0;
    while (true)
    {
      int j = paramArrayOfGroup.length;
      if (i >= j)
        return;
      ArrayList localArrayList = this.groupList;
      Group localGroup = paramArrayOfGroup[i];
      boolean bool = localArrayList.add(localGroup);
      i += 1;
    }
  }

  public void setOrder()
  {
    Group localGroup1 = (Group)this.groupList.get(0);
    Group.CategoryOrder localCategoryOrder1 = Group.CategoryOrder.First;
    localGroup1.setOrder(localCategoryOrder1);
    ArrayList localArrayList1 = this.groupList;
    int i = this.groupList.size() + -1;
    Group localGroup2 = (Group)localArrayList1.get(i);
    Group.CategoryOrder localCategoryOrder2 = Group.CategoryOrder.Last;
    localGroup2.setOrder(localCategoryOrder2);
    int j = 1;
    int k = this.groupList.size() + -1;
    if (j >= k)
      return;
    ArrayList localArrayList2 = this.groupList;
    int m = j + -1;
    Group localGroup3 = (Group)localArrayList2.get(m);
    Group localGroup4 = (Group)this.groupList.get(j);
    ArrayList localArrayList3 = this.groupList;
    int n = j + 1;
    Group localGroup5 = (Group)localArrayList3.get(n);
    String str1 = localGroup4.getCategory();
    String str2 = localGroup3.getCategory();
    if (!str1.equals(str2))
    {
      String str3 = localGroup4.getCategory();
      String str4 = localGroup5.getCategory();
      if (!str3.equals(str4))
      {
        Group.CategoryOrder localCategoryOrder3 = Group.CategoryOrder.First;
        localGroup4.setOrder(localCategoryOrder3);
      }
    }
    while (true)
    {
      j += 1;
      break;
      String str5 = localGroup4.getCategory();
      String str6 = localGroup3.getCategory();
      if (!str5.equals(str6))
      {
        String str7 = localGroup4.getCategory();
        String str8 = localGroup5.getCategory();
        if (str7.equals(str8))
        {
          Group.CategoryOrder localCategoryOrder4 = Group.CategoryOrder.First;
          localGroup4.setOrder(localCategoryOrder4);
        }
      }
      else
      {
        String str9 = localGroup4.getCategory();
        String str10 = localGroup3.getCategory();
        if (str9.equals(str10))
        {
          String str11 = localGroup4.getCategory();
          String str12 = localGroup5.getCategory();
          if (str11.equals(str12))
          {
            Group.CategoryOrder localCategoryOrder5 = Group.CategoryOrder.Middle;
            localGroup4.setOrder(localCategoryOrder5);
          }
        }
        else
        {
          String str13 = localGroup4.getCategory();
          String str14 = localGroup3.getCategory();
          if (str13.equals(str14))
          {
            String str15 = localGroup4.getCategory();
            String str16 = localGroup5.getCategory();
            if (!str15.equals(str16))
            {
              Group.CategoryOrder localCategoryOrder6 = Group.CategoryOrder.Last;
              localGroup4.setOrder(localCategoryOrder6);
            }
          }
          else
          {
            Group.CategoryOrder localCategoryOrder7 = Group.CategoryOrder.Middle;
            localGroup4.setOrder(localCategoryOrder7);
          }
        }
      }
    }
  }

  public void setResponseStatus(ResponseStatus paramResponseStatus)
  {
    this.responseStatus = paramResponseStatus;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Schedules.Groups
 * JD-Core Version:    0.6.2
 */