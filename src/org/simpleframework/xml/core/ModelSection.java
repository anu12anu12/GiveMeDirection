package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ModelSection
  implements Section
{
  private LabelMap attributes;
  private LabelMap elements;
  private Model model;
  private ModelMap models;

  public ModelSection(Model paramModel)
  {
    this.model = paramModel;
  }

  public String getAttribute(String paramString)
    throws Exception
  {
    Expression localExpression = this.model.getExpression();
    if (localExpression == null);
    while (true)
    {
      return paramString;
      paramString = localExpression.getAttribute(paramString);
    }
  }

  public LabelMap getAttributes()
    throws Exception
  {
    if (this.attributes == null)
    {
      LabelMap localLabelMap = this.model.getAttributes();
      this.attributes = localLabelMap;
    }
    return this.attributes;
  }

  public Label getElement(String paramString)
    throws Exception
  {
    return getElements().getLabel(paramString);
  }

  public LabelMap getElements()
    throws Exception
  {
    if (this.elements == null)
    {
      LabelMap localLabelMap = this.model.getElements();
      this.elements = localLabelMap;
    }
    return this.elements;
  }

  public ModelMap getModels()
    throws Exception
  {
    if (this.models == null)
    {
      ModelMap localModelMap = this.model.getModels();
      this.models = localModelMap;
    }
    return this.models;
  }

  public String getName()
  {
    return this.model.getName();
  }

  public String getPath(String paramString)
    throws Exception
  {
    Expression localExpression = this.model.getExpression();
    if (localExpression == null);
    while (true)
    {
      return paramString;
      paramString = localExpression.getElement(paramString);
    }
  }

  public String getPrefix()
  {
    return this.model.getPrefix();
  }

  public Section getSection(String paramString)
    throws Exception
  {
    ModelList localModelList = (ModelList)getModels().get(paramString);
    Model localModel;
    if (localModelList != null)
    {
      localModel = localModelList.take();
      if (localModel == null);
    }
    for (ModelSection localModelSection = new ModelSection(localModel); ; localModelSection = null)
      return localModelSection;
  }

  public Label getText()
    throws Exception
  {
    return this.model.getText();
  }

  public boolean isSection(String paramString)
    throws Exception
  {
    if (getModels().get(paramString) != null);
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public Iterator<String> iterator()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.model.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      boolean bool = localArrayList.add(str);
    }
    return localArrayList.iterator();
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ModelSection
 * JD-Core Version:    0.6.2
 */