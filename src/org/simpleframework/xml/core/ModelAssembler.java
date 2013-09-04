package org.simpleframework.xml.core;

import org.simpleframework.xml.Order;
import org.simpleframework.xml.stream.Format;
import org.simpleframework.xml.stream.Style;

class ModelAssembler
{
  private final ExpressionBuilder builder;
  private final Detail detail;
  private final Format format;

  public ModelAssembler(ExpressionBuilder paramExpressionBuilder, Detail paramDetail, Support paramSupport)
    throws Exception
  {
    Format localFormat = paramSupport.getFormat();
    this.format = localFormat;
    this.builder = paramExpressionBuilder;
    this.detail = paramDetail;
  }

  private void assembleAttributes(Model paramModel, Order paramOrder)
    throws Exception
  {
    String[] arrayOfString = paramOrder.attributes();
    int i = arrayOfString.length;
    int j = 0;
    if (j >= i)
      return;
    String str1 = arrayOfString[j];
    Expression localExpression = this.builder.build(str1);
    if ((!localExpression.isAttribute()) && (localExpression.isPath()))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localExpression;
      Detail localDetail = this.detail;
      arrayOfObject[1] = localDetail;
      throw new PathException("Ordered attribute '%s' references an element in %s", arrayOfObject);
    }
    if (!localExpression.isPath())
    {
      String str2 = this.format.getStyle().getAttribute(str1);
      paramModel.registerAttribute(str2);
    }
    while (true)
    {
      j += 1;
      break;
      registerAttributes(paramModel, localExpression);
    }
  }

  private void assembleElements(Model paramModel, Order paramOrder)
    throws Exception
  {
    String[] arrayOfString = paramOrder.elements();
    int i = arrayOfString.length;
    int j = 0;
    while (true)
    {
      if (j >= i)
        return;
      String str = arrayOfString[j];
      Expression localExpression = this.builder.build(str);
      if (localExpression.isAttribute())
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = localExpression;
        Detail localDetail = this.detail;
        arrayOfObject[1] = localDetail;
        throw new PathException("Ordered element '%s' references an attribute in %s", arrayOfObject);
      }
      registerElements(paramModel, localExpression);
      j += 1;
    }
  }

  private void registerAttribute(Model paramModel, Expression paramExpression)
    throws Exception
  {
    String str = paramExpression.getFirst();
    if (str == null)
      return;
    paramModel.registerAttribute(str);
  }

  private void registerAttributes(Model paramModel, Expression paramExpression)
    throws Exception
  {
    String str1 = paramExpression.getPrefix();
    String str2 = paramExpression.getFirst();
    int i = paramExpression.getIndex();
    if (paramExpression.isPath())
    {
      Model localModel = paramModel.register(str2, str1, i);
      Expression localExpression = paramExpression.getPath(1);
      if (localModel == null)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = str2;
        Detail localDetail = this.detail;
        arrayOfObject[1] = localDetail;
        throw new PathException("Element '%s' does not exist in %s", arrayOfObject);
      }
      registerAttributes(localModel, localExpression);
      return;
    }
    registerAttribute(paramModel, paramExpression);
  }

  private void registerElement(Model paramModel, Expression paramExpression)
    throws Exception
  {
    String str1 = paramExpression.getPrefix();
    String str2 = paramExpression.getFirst();
    int i = paramExpression.getIndex();
    if (i > 1)
    {
      int j = i + -1;
      if (paramModel.lookup(str2, j) == null)
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = str2;
        arrayOfObject[1] = paramExpression;
        Detail localDetail = this.detail;
        arrayOfObject[2] = localDetail;
        throw new PathException("Ordered element '%s' in path '%s' is out of sequence for %s", arrayOfObject);
      }
    }
    Model localModel = paramModel.register(str2, str1, i);
  }

  private void registerElements(Model paramModel, Expression paramExpression)
    throws Exception
  {
    String str1 = paramExpression.getPrefix();
    String str2 = paramExpression.getFirst();
    int i = paramExpression.getIndex();
    if (str2 != null)
    {
      Model localModel = paramModel.register(str2, str1, i);
      Expression localExpression = paramExpression.getPath(1);
      if (paramExpression.isPath())
        registerElements(localModel, localExpression);
    }
    registerElement(paramModel, paramExpression);
  }

  public void assemble(Model paramModel, Order paramOrder)
    throws Exception
  {
    assembleElements(paramModel, paramOrder);
    assembleAttributes(paramModel, paramOrder);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ModelAssembler
 * JD-Core Version:    0.6.2
 */