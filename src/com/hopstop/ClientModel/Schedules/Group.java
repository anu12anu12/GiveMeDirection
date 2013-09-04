package com.hopstop.ClientModel.Schedules;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.io.Serializable;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@DatabaseTable(tableName="schedules_stationgroups")
@Root(name="Group", strict=false)
public class Group
  implements Serializable
{
  public static final String ID_COLUMN_NAME = "id";

  @DatabaseField
  @Element(name="Category", required=false)
  private String category;

  @Element(name="Icon", required=false)
  private Icon icon;

  @Element(name="IconLarge", required=false)
  private IconLarge iconLarge;

  @DatabaseField(id=true, index=true, unique=true)
  @Element(name="Id")
  private String id;

  @DatabaseField
  @Element(name="Name")
  private String name;
  private CategoryOrder order;

  @DatabaseField
  @Element(name="VehicleTypes", required=false)
  private String vehicleTypes;

  public String getCategory()
  {
    return this.category;
  }

  public Icon getIcon()
  {
    return this.icon;
  }

  public IconLarge getIconLarge()
  {
    return this.iconLarge;
  }

  public String getId()
  {
    return this.id;
  }

  public String getName()
  {
    return this.name;
  }

  public CategoryOrder getOrder()
  {
    return this.order;
  }

  public String getVehicleTypes()
  {
    return this.vehicleTypes;
  }

  public void setCategory(String paramString)
  {
    this.category = paramString;
  }

  public void setIcon(Icon paramIcon)
  {
    this.icon = paramIcon;
  }

  public void setIconLarge(IconLarge paramIconLarge)
  {
    this.iconLarge = paramIconLarge;
  }

  public void setId(String paramString)
  {
    this.id = paramString;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }

  public void setOrder(CategoryOrder paramCategoryOrder)
  {
    this.order = paramCategoryOrder;
  }

  public void setVehicleTypes(String paramString)
  {
    this.vehicleTypes = paramString;
  }

  public static enum CategoryOrder
  {
    static
    {
      Last = new CategoryOrder("Last", 2);
      CategoryOrder[] arrayOfCategoryOrder = new CategoryOrder[3];
      CategoryOrder localCategoryOrder1 = First;
      arrayOfCategoryOrder[0] = localCategoryOrder1;
      CategoryOrder localCategoryOrder2 = Middle;
      arrayOfCategoryOrder[1] = localCategoryOrder2;
      CategoryOrder localCategoryOrder3 = Last;
      arrayOfCategoryOrder[2] = localCategoryOrder3;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.Schedules.Group
 * JD-Core Version:    0.6.2
 */