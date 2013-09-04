package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementArray;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.ElementUnion;
import org.simpleframework.xml.Order;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.Version;
import org.simpleframework.xml.strategy.Type;

class StructureBuilder
{
  private ModelAssembler assembler;
  private LabelMap attributes;
  private ExpressionBuilder builder;
  private LabelMap elements;
  private Instantiator factory;
  private boolean primitive;
  private InstantiatorBuilder resolver;
  private Model root;
  private Scanner scanner;
  private Support support;
  private Label text;
  private LabelMap texts;
  private Label version;

  public StructureBuilder(Scanner paramScanner, Detail paramDetail, Support paramSupport)
    throws Exception
  {
    ExpressionBuilder localExpressionBuilder1 = new ExpressionBuilder(paramDetail, paramSupport);
    this.builder = localExpressionBuilder1;
    ExpressionBuilder localExpressionBuilder2 = this.builder;
    ModelAssembler localModelAssembler = new ModelAssembler(localExpressionBuilder2, paramDetail, paramSupport);
    this.assembler = localModelAssembler;
    InstantiatorBuilder localInstantiatorBuilder = new InstantiatorBuilder(paramScanner, paramDetail);
    this.resolver = localInstantiatorBuilder;
    TreeModel localTreeModel = new TreeModel(paramScanner, paramDetail);
    this.root = localTreeModel;
    LabelMap localLabelMap1 = new LabelMap(paramScanner);
    this.attributes = localLabelMap1;
    LabelMap localLabelMap2 = new LabelMap(paramScanner);
    this.elements = localLabelMap2;
    LabelMap localLabelMap3 = new LabelMap(paramScanner);
    this.texts = localLabelMap3;
    this.scanner = paramScanner;
    this.support = paramSupport;
  }

  private Model create(Expression paramExpression)
    throws Exception
  {
    Model localModel = this.root;
    while (true)
    {
      if (localModel != null)
      {
        String str1 = paramExpression.getPrefix();
        String str2 = paramExpression.getFirst();
        int i = paramExpression.getIndex();
        if (str2 != null)
          localModel = localModel.register(str2, str1, i);
        if (paramExpression.isPath());
      }
      else
      {
        return localModel;
      }
      paramExpression = paramExpression.getPath(1);
    }
  }

  private boolean isAttribute(String paramString)
    throws Exception
  {
    Expression localExpression = this.builder.build(paramString);
    Model localModel = lookup(localExpression);
    String str;
    boolean bool;
    if (localModel != null)
    {
      str = localExpression.getLast();
      if (!localExpression.isPath())
        bool = localModel.isAttribute(paramString);
    }
    while (true)
    {
      return bool;
      bool = localModel.isAttribute(str);
      continue;
      bool = false;
    }
  }

  private boolean isElement(String paramString)
    throws Exception
  {
    boolean bool = true;
    Expression localExpression = this.builder.build(paramString);
    Model localModel = lookup(localExpression);
    String str;
    int i;
    if (localModel != null)
    {
      str = localExpression.getLast();
      i = localExpression.getIndex();
      if (!localModel.isElement(str));
    }
    while (true)
    {
      return bool;
      if (localModel.isModel(str))
      {
        if (localModel.lookup(str, i).isEmpty())
          bool = false;
      }
      else
        bool = false;
    }
  }

  private boolean isEmpty()
  {
    if (this.text != null);
    for (boolean bool = false; ; bool = this.root.isEmpty())
      return bool;
  }

  private Model lookup(Expression paramExpression)
    throws Exception
  {
    Expression localExpression = paramExpression.getPath(0, 1);
    if (paramExpression.isPath());
    for (Model localModel = this.root.lookup(localExpression); ; localModel = this.root)
      return localModel;
  }

  private void process(Contact paramContact, Annotation paramAnnotation, LabelMap paramLabelMap)
    throws Exception
  {
    Label localLabel = this.support.getLabel(paramContact, paramAnnotation);
    String str1 = localLabel.getPath();
    String str2 = localLabel.getName();
    if (paramLabelMap.get(str1) != null)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = str2;
      arrayOfObject[1] = paramContact;
      throw new PersistenceException("Duplicate annotation of name '%s' on %s", arrayOfObject);
    }
    process(paramContact, localLabel, paramLabelMap);
  }

  private void process(Contact paramContact, Label paramLabel, LabelMap paramLabelMap)
    throws Exception
  {
    Expression localExpression = paramLabel.getExpression();
    String str = paramLabel.getPath();
    Model localModel = this.root;
    if (!localExpression.isEmpty())
      localModel = register(localExpression);
    this.resolver.register(paramLabel);
    localModel.register(paramLabel);
    Object localObject = paramLabelMap.put(str, paramLabel);
  }

  private Model register(Expression paramExpression)
    throws Exception
  {
    Model localModel = this.root.lookup(paramExpression);
    if (localModel != null);
    while (true)
    {
      return localModel;
      localModel = create(paramExpression);
    }
  }

  private void text(Contact paramContact, Annotation paramAnnotation)
    throws Exception
  {
    Label localLabel = this.support.getLabel(paramContact, paramAnnotation);
    Expression localExpression = localLabel.getExpression();
    String str = localLabel.getPath();
    Model localModel = this.root;
    if (!localExpression.isEmpty())
      localModel = register(localExpression);
    if (this.texts.get(str) != null)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramAnnotation;
      throw new TextException("Multiple text annotations in %s", arrayOfObject);
    }
    this.resolver.register(localLabel);
    localModel.register(localLabel);
    Object localObject = this.texts.put(str, localLabel);
  }

  private void union(Contact paramContact, Annotation paramAnnotation, LabelMap paramLabelMap)
    throws Exception
  {
    Iterator localIterator = this.support.getLabels(paramContact, paramAnnotation).iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Label localLabel = (Label)localIterator.next();
      String str1 = localLabel.getPath();
      String str2 = localLabel.getName();
      if (paramLabelMap.get(str1) != null)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = str2;
        arrayOfObject[1] = localLabel;
        throw new PersistenceException("Duplicate annotation of name '%s' on %s", arrayOfObject);
      }
      process(paramContact, localLabel, paramLabelMap);
    }
  }

  private void validateAttributes(Class paramClass, Order paramOrder)
    throws Exception
  {
    if (paramOrder == null)
      return;
    String[] arrayOfString = paramOrder.attributes();
    int i = arrayOfString.length;
    int j = 0;
    while (true)
    {
      if (j >= i)
        return;
      String str = arrayOfString[j];
      if (!isAttribute(str))
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = str;
        arrayOfObject[1] = paramClass;
        throw new AttributeException("Ordered attribute '%s' missing in %s", arrayOfObject);
      }
      j += 1;
    }
  }

  private void validateElements(Class paramClass, Order paramOrder)
    throws Exception
  {
    if (paramOrder == null)
      return;
    String[] arrayOfString = paramOrder.elements();
    int i = arrayOfString.length;
    int j = 0;
    while (true)
    {
      if (j >= i)
        return;
      String str = arrayOfString[j];
      if (!isElement(str))
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = str;
        arrayOfObject[1] = paramClass;
        throw new ElementException("Ordered element '%s' missing for %s", arrayOfObject);
      }
      j += 1;
    }
  }

  private void validateModel(Class paramClass)
    throws Exception
  {
    if (this.root.isEmpty())
      return;
    this.root.validate(paramClass);
  }

  private void validateText(Class paramClass)
    throws Exception
  {
    Label localLabel = this.root.getText();
    if (localLabel != null)
    {
      if (localLabel.isTextList())
        return;
      if (!this.elements.isEmpty())
      {
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = localLabel;
        arrayOfObject1[1] = paramClass;
        throw new TextException("Elements used with %s in %s", arrayOfObject1);
      }
      if (!this.root.isComposite())
        return;
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = localLabel;
      arrayOfObject2[1] = paramClass;
      throw new TextException("Paths used with %s in %s", arrayOfObject2);
    }
    if (!this.scanner.isEmpty())
      return;
    boolean bool = isEmpty();
    this.primitive = bool;
  }

  private void validateTextList(Class paramClass)
    throws Exception
  {
    Label localLabel1 = this.root.getText();
    if (localLabel1 == null)
      return;
    if (!localLabel1.isTextList())
      return;
    Object localObject = localLabel1.getKey();
    Iterator localIterator = this.elements.iterator();
    while (localIterator.hasNext())
    {
      Label localLabel2 = (Label)localIterator.next();
      if (!localLabel2.getKey().equals(localObject))
      {
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = localLabel1;
        arrayOfObject1[1] = paramClass;
        throw new TextException("Elements used with %s in %s", arrayOfObject1);
      }
      Class localClass = localLabel2.getDependent().getType();
      if (localClass == String.class)
      {
        Object[] arrayOfObject2 = new Object[3];
        arrayOfObject2[0] = localClass;
        arrayOfObject2[1] = localLabel1;
        arrayOfObject2[2] = paramClass;
        throw new TextException("Illegal entry of %s with text annotations on %s in %s", arrayOfObject2);
      }
    }
    if (!this.root.isComposite())
      return;
    Object[] arrayOfObject3 = new Object[2];
    arrayOfObject3[0] = localLabel1;
    arrayOfObject3[1] = paramClass;
    throw new TextException("Paths used with %s in %s", arrayOfObject3);
  }

  private void validateUnions(Class paramClass)
    throws Exception
  {
    Iterator localIterator = this.elements.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Label localLabel1 = (Label)localIterator.next();
      String[] arrayOfString1 = localLabel1.getPaths();
      Contact localContact = localLabel1.getContact();
      String[] arrayOfString2 = arrayOfString1;
      int i = arrayOfString2.length;
      int j = 0;
      while (j < i)
      {
        String str = arrayOfString2[j];
        Annotation localAnnotation = localContact.getAnnotation();
        Label localLabel2 = (Label)this.elements.get(str);
        boolean bool1 = localLabel1.isInline();
        boolean bool2 = localLabel2.isInline();
        if (bool1 != bool2)
        {
          Object[] arrayOfObject1 = new Object[2];
          arrayOfObject1[0] = localAnnotation;
          arrayOfObject1[1] = localContact;
          throw new UnionException("Inline must be consistent in %s for %s", arrayOfObject1);
        }
        boolean bool3 = localLabel1.isRequired();
        boolean bool4 = localLabel2.isRequired();
        if (bool3 != bool4)
        {
          Object[] arrayOfObject2 = new Object[2];
          arrayOfObject2[0] = localAnnotation;
          arrayOfObject2[1] = localContact;
          throw new UnionException("Required must be consistent in %s for %s", arrayOfObject2);
        }
        j += 1;
      }
    }
  }

  private void version(Contact paramContact, Annotation paramAnnotation)
    throws Exception
  {
    Label localLabel = this.support.getLabel(paramContact, paramAnnotation);
    if (this.version != null)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramAnnotation;
      throw new AttributeException("Multiple version annotations in %s", arrayOfObject);
    }
    this.version = localLabel;
  }

  public void assemble(Class paramClass)
    throws Exception
  {
    Order localOrder = this.scanner.getOrder();
    if (localOrder == null)
      return;
    ModelAssembler localModelAssembler = this.assembler;
    Model localModel = this.root;
    localModelAssembler.assemble(localModel, localOrder);
  }

  public Structure build(Class paramClass)
    throws Exception
  {
    Instantiator localInstantiator = this.factory;
    Model localModel = this.root;
    Label localLabel1 = this.version;
    Label localLabel2 = this.text;
    boolean bool = this.primitive;
    return new Structure(localInstantiator, localModel, localLabel1, localLabel2, bool);
  }

  public void commit(Class paramClass)
    throws Exception
  {
    if (this.factory != null)
      return;
    Instantiator localInstantiator = this.resolver.build();
    this.factory = localInstantiator;
  }

  public void process(Contact paramContact, Annotation paramAnnotation)
    throws Exception
  {
    if ((paramAnnotation instanceof Attribute))
    {
      LabelMap localLabelMap1 = this.attributes;
      process(paramContact, paramAnnotation, localLabelMap1);
    }
    if ((paramAnnotation instanceof ElementUnion))
    {
      LabelMap localLabelMap2 = this.elements;
      union(paramContact, paramAnnotation, localLabelMap2);
    }
    if ((paramAnnotation instanceof ElementListUnion))
    {
      LabelMap localLabelMap3 = this.elements;
      union(paramContact, paramAnnotation, localLabelMap3);
    }
    if ((paramAnnotation instanceof ElementMapUnion))
    {
      LabelMap localLabelMap4 = this.elements;
      union(paramContact, paramAnnotation, localLabelMap4);
    }
    if ((paramAnnotation instanceof ElementList))
    {
      LabelMap localLabelMap5 = this.elements;
      process(paramContact, paramAnnotation, localLabelMap5);
    }
    if ((paramAnnotation instanceof ElementArray))
    {
      LabelMap localLabelMap6 = this.elements;
      process(paramContact, paramAnnotation, localLabelMap6);
    }
    if ((paramAnnotation instanceof ElementMap))
    {
      LabelMap localLabelMap7 = this.elements;
      process(paramContact, paramAnnotation, localLabelMap7);
    }
    if ((paramAnnotation instanceof Element))
    {
      LabelMap localLabelMap8 = this.elements;
      process(paramContact, paramAnnotation, localLabelMap8);
    }
    if ((paramAnnotation instanceof Version))
      version(paramContact, paramAnnotation);
    if (!(paramAnnotation instanceof Text))
      return;
    text(paramContact, paramAnnotation);
  }

  public void validate(Class paramClass)
    throws Exception
  {
    Order localOrder = this.scanner.getOrder();
    validateUnions(paramClass);
    validateElements(paramClass, localOrder);
    validateAttributes(paramClass, localOrder);
    validateModel(paramClass);
    validateText(paramClass);
    validateTextList(paramClass);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.StructureBuilder
 * JD-Core Version:    0.6.2
 */