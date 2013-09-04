package org.simpleframework.xml.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class TreeModel
  implements Model
{
  private LabelMap attributes;
  private Detail detail;
  private LabelMap elements;
  private Expression expression;
  private int index;
  private Label list;
  private ModelMap models;
  private String name;
  private OrderList order;
  private Policy policy;
  private String prefix;
  private Label text;

  public TreeModel(Policy paramPolicy, Detail paramDetail)
  {
  }

  public TreeModel(Policy paramPolicy, Detail paramDetail, String paramString1, String paramString2, int paramInt)
  {
    LabelMap localLabelMap1 = new LabelMap(paramPolicy);
    this.attributes = localLabelMap1;
    LabelMap localLabelMap2 = new LabelMap(paramPolicy);
    this.elements = localLabelMap2;
    ModelMap localModelMap = new ModelMap(paramDetail);
    this.models = localModelMap;
    OrderList localOrderList = new OrderList();
    this.order = localOrderList;
    this.detail = paramDetail;
    this.policy = paramPolicy;
    this.prefix = paramString2;
    this.index = paramInt;
    this.name = paramString1;
  }

  private Model create(String paramString1, String paramString2, int paramInt)
    throws Exception
  {
    Policy localPolicy = this.policy;
    Detail localDetail = this.detail;
    String str1 = paramString1;
    String str2 = paramString2;
    int i = paramInt;
    TreeModel localTreeModel = new TreeModel(localPolicy, localDetail, str1, str2, i);
    if (paramString1 != null)
    {
      this.models.register(paramString1, localTreeModel);
      boolean bool = this.order.add(paramString1);
    }
    return localTreeModel;
  }

  private void validateAttributes(Class paramClass)
    throws Exception
  {
    Iterator localIterator = this.attributes.keySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      String str1 = (String)localIterator.next();
      if ((Label)this.attributes.get(str1) == null)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = str1;
        arrayOfObject[1] = paramClass;
        throw new AttributeException("Ordered attribute '%s' does not exist in %s", arrayOfObject);
      }
      if (this.expression != null)
        String str2 = this.expression.getAttribute(str1);
    }
  }

  private void validateElements(Class paramClass)
    throws Exception
  {
    Iterator localIterator = this.elements.keySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      String str1 = (String)localIterator.next();
      ModelList localModelList = (ModelList)this.models.get(str1);
      Label localLabel = (Label)this.elements.get(str1);
      if ((localModelList == null) && (localLabel == null))
      {
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = str1;
        arrayOfObject1[1] = paramClass;
        throw new ElementException("Ordered element '%s' does not exist in %s", arrayOfObject1);
      }
      if ((localModelList != null) && (localLabel != null) && (!localModelList.isEmpty()))
      {
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = str1;
        arrayOfObject2[1] = paramClass;
        throw new ElementException("Element '%s' is also a path name in %s", arrayOfObject2);
      }
      if (this.expression != null)
        String str2 = this.expression.getElement(str1);
    }
  }

  private void validateExpression(Label paramLabel)
    throws Exception
  {
    Expression localExpression = paramLabel.getExpression();
    if (this.expression != null)
    {
      String str1 = this.expression.getPath();
      String str2 = localExpression.getPath();
      if (str1.equals(str2))
        return;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = str1;
      arrayOfObject[1] = str2;
      Detail localDetail = this.detail;
      arrayOfObject[2] = localDetail;
      throw new PathException("Path '%s' does not match '%s' in %s", arrayOfObject);
    }
    this.expression = localExpression;
  }

  private void validateExpressions(Class paramClass)
    throws Exception
  {
    Iterator localIterator1 = this.elements.iterator();
    while (localIterator1.hasNext())
    {
      Label localLabel1 = (Label)localIterator1.next();
      if (localLabel1 != null)
        validateExpression(localLabel1);
    }
    Iterator localIterator2 = this.attributes.iterator();
    while (localIterator2.hasNext())
    {
      Label localLabel2 = (Label)localIterator2.next();
      if (localLabel2 != null)
        validateExpression(localLabel2);
    }
    if (this.text == null)
      return;
    Label localLabel3 = this.text;
    validateExpression(localLabel3);
  }

  private void validateModels(Class paramClass)
    throws Exception
  {
    Iterator localIterator1 = this.models.iterator();
    while (true)
    {
      if (!localIterator1.hasNext())
        return;
      ModelList localModelList = (ModelList)localIterator1.next();
      int i = 1;
      Iterator localIterator2 = localModelList.iterator();
      while (localIterator2.hasNext())
      {
        Model localModel = (Model)localIterator2.next();
        if (localModel != null)
        {
          String str = localModel.getName();
          int j = localModel.getIndex();
          int k = i + 1;
          if (j != i)
          {
            Object[] arrayOfObject = new Object[3];
            arrayOfObject[0] = str;
            Integer localInteger = Integer.valueOf(j);
            arrayOfObject[1] = localInteger;
            arrayOfObject[2] = paramClass;
            throw new ElementException("Path section '%s[%s]' is out of sequence in %s", arrayOfObject);
          }
          localModel.validate(paramClass);
          i = k;
        }
      }
    }
  }

  private void validateText(Class paramClass)
    throws Exception
  {
    if (this.text == null)
      return;
    if (!this.elements.isEmpty())
    {
      Object[] arrayOfObject1 = new Object[2];
      Label localLabel1 = this.text;
      arrayOfObject1[0] = localLabel1;
      arrayOfObject1[1] = paramClass;
      throw new TextException("Text annotation %s used with elements in %s", arrayOfObject1);
    }
    if (!isComposite())
      return;
    Object[] arrayOfObject2 = new Object[2];
    Label localLabel2 = this.text;
    arrayOfObject2[0] = localLabel2;
    arrayOfObject2[1] = paramClass;
    throw new TextException("Text annotation %s can not be used with paths in %s", arrayOfObject2);
  }

  public LabelMap getAttributes()
    throws Exception
  {
    return this.attributes.getLabels();
  }

  public LabelMap getElements()
    throws Exception
  {
    return this.elements.getLabels();
  }

  public Expression getExpression()
  {
    return this.expression;
  }

  public int getIndex()
  {
    return this.index;
  }

  public ModelMap getModels()
    throws Exception
  {
    return this.models.getModels();
  }

  public String getName()
  {
    return this.name;
  }

  public String getPrefix()
  {
    return this.prefix;
  }

  public Label getText()
  {
    if (this.list != null);
    for (Label localLabel = this.list; ; localLabel = this.text)
      return localLabel;
  }

  public boolean isAttribute(String paramString)
  {
    return this.attributes.containsKey(paramString);
  }

  public boolean isComposite()
  {
    boolean bool = true;
    Model localModel;
    do
    {
      Iterator localIterator1 = this.models.iterator();
      Iterator localIterator2;
      while (!localIterator2.hasNext())
      {
        if (!localIterator1.hasNext())
          break;
        localIterator2 = ((ModelList)localIterator1.next()).iterator();
      }
      localModel = (Model)localIterator2.next();
    }
    while ((localModel == null) || (localModel.isEmpty()));
    while (true)
    {
      return bool;
      if (this.models.isEmpty())
        bool = false;
    }
  }

  public boolean isElement(String paramString)
  {
    return this.elements.containsKey(paramString);
  }

  public boolean isEmpty()
  {
    boolean bool = false;
    if (this.text != null);
    while (true)
    {
      return bool;
      if ((this.elements.isEmpty()) && (this.attributes.isEmpty()) && (!isComposite()))
        bool = true;
    }
  }

  public boolean isModel(String paramString)
  {
    return this.models.containsKey(paramString);
  }

  public Iterator<String> iterator()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.order.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      boolean bool = localArrayList.add(str);
    }
    return localArrayList.iterator();
  }

  public Model lookup(String paramString, int paramInt)
  {
    return this.models.lookup(paramString, paramInt);
  }

  public Model lookup(Expression paramExpression)
  {
    String str = paramExpression.getFirst();
    int i = paramExpression.getIndex();
    Model localModel = lookup(str, i);
    if (paramExpression.isPath())
    {
      paramExpression = paramExpression.getPath(1, 0);
      if (localModel != null)
        localModel = localModel.lookup(paramExpression);
    }
    return localModel;
  }

  public Model register(String paramString1, String paramString2, int paramInt)
    throws Exception
  {
    Model localModel = this.models.lookup(paramString1, paramInt);
    if (localModel == null)
      localModel = create(paramString1, paramString2, paramInt);
    return localModel;
  }

  public void register(Label paramLabel)
    throws Exception
  {
    if (paramLabel.isAttribute())
    {
      registerAttribute(paramLabel);
      return;
    }
    if (paramLabel.isText())
    {
      registerText(paramLabel);
      return;
    }
    registerElement(paramLabel);
  }

  public void registerAttribute(String paramString)
    throws Exception
  {
    Object localObject = this.attributes.put(paramString, null);
  }

  public void registerAttribute(Label paramLabel)
    throws Exception
  {
    String str = paramLabel.getName();
    if (this.attributes.get(str) != null)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = str;
      arrayOfObject[1] = paramLabel;
      throw new AttributeException("Duplicate annotation of name '%s' on %s", arrayOfObject);
    }
    Object localObject = this.attributes.put(str, paramLabel);
  }

  public void registerElement(String paramString)
    throws Exception
  {
    if (!this.order.contains(paramString))
      boolean bool = this.order.add(paramString);
    Object localObject = this.elements.put(paramString, null);
  }

  public void registerElement(Label paramLabel)
    throws Exception
  {
    String str = paramLabel.getName();
    if (this.elements.get(str) != null)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = str;
      arrayOfObject[1] = paramLabel;
      throw new ElementException("Duplicate annotation of name '%s' on %s", arrayOfObject);
    }
    if (!this.order.contains(str))
      boolean bool = this.order.add(str);
    if (paramLabel.isTextList())
      this.list = paramLabel;
    Object localObject = this.elements.put(str, paramLabel);
  }

  public void registerText(Label paramLabel)
    throws Exception
  {
    if (this.text != null)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramLabel;
      throw new TextException("Duplicate text annotation on %s", arrayOfObject);
    }
    this.text = paramLabel;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    String str = this.name;
    arrayOfObject[0] = str;
    Integer localInteger = Integer.valueOf(this.index);
    arrayOfObject[1] = localInteger;
    return String.format("model '%s[%s]'", arrayOfObject);
  }

  public void validate(Class paramClass)
    throws Exception
  {
    validateExpressions(paramClass);
    validateAttributes(paramClass);
    validateElements(paramClass);
    validateModels(paramClass);
    validateText(paramClass);
  }

  private static class OrderList extends ArrayList<String>
  {
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.TreeModel
 * JD-Core Version:    0.6.2
 */