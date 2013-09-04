package org.simpleframework.xml.core;

import java.util.Iterator;
import org.simpleframework.xml.Version;
import org.simpleframework.xml.strategy.Type;
import org.simpleframework.xml.stream.InputNode;
import org.simpleframework.xml.stream.NamespaceMap;
import org.simpleframework.xml.stream.NodeMap;
import org.simpleframework.xml.stream.OutputNode;
import org.simpleframework.xml.stream.Position;

class Composite
  implements Converter
{
  private final Context context;
  private final Criteria criteria;
  private final ObjectFactory factory;
  private final Primitive primitive;
  private final Revision revision;
  private final Type type;

  public Composite(Context paramContext, Type paramType)
  {
    this(paramContext, paramType, null);
  }

  public Composite(Context paramContext, Type paramType, Class paramClass)
  {
    ObjectFactory localObjectFactory = new ObjectFactory(paramContext, paramType, paramClass);
    this.factory = localObjectFactory;
    Primitive localPrimitive = new Primitive(paramContext, paramType);
    this.primitive = localPrimitive;
    Collector localCollector = new Collector();
    this.criteria = localCollector;
    Revision localRevision = new Revision();
    this.revision = localRevision;
    this.context = paramContext;
    this.type = paramType;
  }

  private boolean isOverridden(OutputNode paramOutputNode, Object paramObject, Type paramType)
    throws Exception
  {
    return this.factory.setOverride(paramType, paramObject, paramOutputNode);
  }

  private Object read(InputNode paramInputNode, Instance paramInstance, Class paramClass)
    throws Exception
  {
    Schema localSchema = this.context.getSchema(paramClass);
    Caller localCaller = localSchema.getCaller();
    Object localObject1 = read(localSchema, paramInstance).read(paramInputNode);
    localCaller.validate(localObject1);
    localCaller.commit(localObject1);
    Object localObject2 = paramInstance.setInstance(localObject1);
    return readResolve(paramInputNode, localObject1, localCaller);
  }

  private Builder read(Schema paramSchema, Instance paramInstance)
    throws Exception
  {
    Criteria localCriteria1;
    if (paramSchema.getInstantiator().isDefault())
      localCriteria1 = this.criteria;
    Criteria localCriteria2;
    Composite localComposite1;
    Composite localComposite2;
    Schema localSchema;
    Instance localInstance;
    for (Object localObject = new Builder(this, localCriteria1, paramSchema, paramInstance); ; localObject = new Injector(localComposite2, localCriteria2, localSchema, localInstance, null))
    {
      return localObject;
      localCriteria2 = this.criteria;
      localComposite1 = this;
      localComposite2 = this;
      localSchema = paramSchema;
      localInstance = paramInstance;
    }
  }

  private void read(InputNode paramInputNode, Object paramObject, Schema paramSchema)
    throws Exception
  {
    Section localSection = paramSchema.getSection();
    readVersion(paramInputNode, paramObject, paramSchema);
    readSection(paramInputNode, paramObject, localSection);
  }

  private void readAttribute(InputNode paramInputNode, Object paramObject, Section paramSection, LabelMap paramLabelMap)
    throws Exception
  {
    String str1 = paramInputNode.getName();
    String str2 = paramSection.getAttribute(str1);
    Label localLabel = paramLabelMap.getLabel(str2);
    if (localLabel == null)
    {
      Position localPosition = paramInputNode.getPosition();
      Context localContext1 = this.context;
      Type localType = this.type;
      Class localClass = localContext1.getType(localType, paramObject);
      Context localContext2 = this.context;
      if (!paramLabelMap.isStrict(localContext2))
        return;
      if (!this.revision.isEqual())
        return;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = str2;
      arrayOfObject[1] = localClass;
      arrayOfObject[2] = localPosition;
      throw new AttributeException("Attribute '%s' does not have a match in %s at %s", arrayOfObject);
    }
    Object localObject = readInstance(paramInputNode, paramObject, localLabel);
  }

  private void readAttributes(InputNode paramInputNode, Object paramObject, Section paramSection)
    throws Exception
  {
    NodeMap localNodeMap = paramInputNode.getAttributes();
    LabelMap localLabelMap = paramSection.getAttributes();
    Iterator localIterator = localNodeMap.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      InputNode localInputNode = paramInputNode.getAttribute(str);
      if (localInputNode != null)
        readAttribute(localInputNode, paramObject, paramSection, localLabelMap);
    }
    validate(paramInputNode, localLabelMap, paramObject);
  }

  private void readElement(InputNode paramInputNode, Object paramObject, Section paramSection, LabelMap paramLabelMap)
    throws Exception
  {
    String str1 = paramInputNode.getName();
    String str2 = paramSection.getPath(str1);
    Object localObject = paramLabelMap.getLabel(str2);
    if (localObject == null)
      localObject = this.criteria.resolve(str2);
    if (localObject == null)
    {
      Position localPosition = paramInputNode.getPosition();
      Context localContext1 = this.context;
      Type localType = this.type;
      Class localClass = localContext1.getType(localType, paramObject);
      Context localContext2 = this.context;
      if ((paramLabelMap.isStrict(localContext2)) && (this.revision.isEqual()))
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = str2;
        arrayOfObject[1] = localClass;
        arrayOfObject[2] = localPosition;
        throw new ElementException("Element '%s' does not have a match in %s at %s", arrayOfObject);
      }
      paramInputNode.skip();
      return;
    }
    readUnion(paramInputNode, paramObject, paramLabelMap, (Label)localObject);
  }

  private void readElements(InputNode paramInputNode, Object paramObject, Section paramSection)
    throws Exception
  {
    LabelMap localLabelMap = paramSection.getElements();
    InputNode localInputNode = paramInputNode.getNext();
    if (localInputNode != null)
    {
      String str = localInputNode.getName();
      Section localSection = paramSection.getSection(str);
      if (localSection != null)
        readSection(localInputNode, paramObject, localSection);
      while (true)
      {
        localInputNode = paramInputNode.getNext();
        break;
        readElement(localInputNode, paramObject, paramSection, localLabelMap);
      }
    }
    validate(paramInputNode, localLabelMap, paramObject);
  }

  private Object readInstance(InputNode paramInputNode, Object paramObject, Label paramLabel)
    throws Exception
  {
    Object localObject1 = readVariable(paramInputNode, paramObject, paramLabel);
    if (localObject1 == null)
    {
      Position localPosition = paramInputNode.getPosition();
      Context localContext1 = this.context;
      Type localType = this.type;
      Class localClass = localContext1.getType(localType, paramObject);
      if ((paramLabel.isRequired()) && (this.revision.isEqual()))
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = paramLabel;
        arrayOfObject[1] = localClass;
        arrayOfObject[2] = localPosition;
        throw new ValueRequiredException("Empty value for %s in %s at %s", arrayOfObject);
      }
    }
    else
    {
      Context localContext2 = this.context;
      Object localObject2 = paramLabel.getEmpty(localContext2);
      if (localObject1 != localObject2)
        this.criteria.set(paramLabel, localObject1);
    }
    return localObject1;
  }

  private Object readPrimitive(InputNode paramInputNode, Instance paramInstance)
    throws Exception
  {
    Class localClass = paramInstance.getType();
    Object localObject1 = this.primitive.read(paramInputNode, localClass);
    if (localClass != null)
      Object localObject2 = paramInstance.setInstance(localObject1);
    return localObject1;
  }

  private Object readResolve(InputNode paramInputNode, Object paramObject, Caller paramCaller)
    throws Exception
  {
    Object localObject;
    if (paramObject != null)
    {
      Position localPosition = paramInputNode.getPosition();
      localObject = paramCaller.resolve(paramObject);
      Class localClass1 = this.type.getType();
      Class localClass2 = localObject.getClass();
      if (!localClass1.isAssignableFrom(localClass2))
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = localClass2;
        arrayOfObject[1] = localClass1;
        arrayOfObject[2] = localPosition;
        throw new ElementException("Type %s does not match %s at %s", arrayOfObject);
      }
    }
    else
    {
      localObject = paramObject;
    }
    return localObject;
  }

  private void readSection(InputNode paramInputNode, Object paramObject, Section paramSection)
    throws Exception
  {
    readText(paramInputNode, paramObject, paramSection);
    readAttributes(paramInputNode, paramObject, paramSection);
    readElements(paramInputNode, paramObject, paramSection);
  }

  private void readText(InputNode paramInputNode, Object paramObject, Section paramSection)
    throws Exception
  {
    Label localLabel = paramSection.getText();
    if (localLabel == null)
      return;
    Object localObject = readInstance(paramInputNode, paramObject, localLabel);
  }

  private void readUnion(InputNode paramInputNode, Object paramObject, LabelMap paramLabelMap, Label paramLabel)
    throws Exception
  {
    Object localObject = readInstance(paramInputNode, paramObject, paramLabel);
    String[] arrayOfString = paramLabel.getPaths();
    int i = arrayOfString.length;
    int j = 0;
    while (j < i)
    {
      String str = arrayOfString[j];
      Label localLabel = paramLabelMap.getLabel(str);
      j += 1;
    }
    if (!paramLabel.isInline())
      return;
    this.criteria.set(paramLabel, localObject);
  }

  private Object readVariable(InputNode paramInputNode, Object paramObject, Label paramLabel)
    throws Exception
  {
    Context localContext = this.context;
    Converter localConverter = paramLabel.getConverter(localContext);
    Contact localContact;
    Object localObject2;
    if (paramLabel.isCollection())
    {
      Variable localVariable = this.criteria.get(paramLabel);
      localContact = paramLabel.getContact();
      if (localVariable != null)
      {
        Object localObject1 = localVariable.getValue();
        localObject2 = localConverter.read(paramInputNode, localObject1);
      }
    }
    while (true)
    {
      return localObject2;
      if (paramObject != null)
      {
        Object localObject3 = localContact.get(paramObject);
        if (localObject3 != null)
          localObject2 = localConverter.read(paramInputNode, localObject3);
      }
      else
      {
        localObject2 = localConverter.read(paramInputNode);
      }
    }
  }

  private void readVersion(InputNode paramInputNode, Object paramObject, Label paramLabel)
    throws Exception
  {
    Object localObject = readInstance(paramInputNode, paramObject, paramLabel);
    Class localClass = this.type.getType();
    if (localObject == null)
      return;
    Double localDouble = Double.valueOf(this.context.getVersion(localClass).revision());
    Revision localRevision = this.revision;
    if (localObject.equals(localRevision))
      return;
    boolean bool = this.revision.compare(localDouble, localObject);
  }

  private void readVersion(InputNode paramInputNode, Object paramObject, Schema paramSchema)
    throws Exception
  {
    Label localLabel = paramSchema.getVersion();
    Class localClass = this.type.getType();
    if (localLabel == null)
      return;
    String str = localLabel.getName();
    InputNode localInputNode = (InputNode)paramInputNode.getAttributes().remove(str);
    if (localInputNode != null)
    {
      readVersion(localInputNode, paramObject, localLabel);
      return;
    }
    Version localVersion = this.context.getVersion(localClass);
    Double localDouble1 = Double.valueOf(this.revision.getDefault());
    Double localDouble2 = Double.valueOf(localVersion.revision());
    this.criteria.set(localLabel, localDouble1);
    boolean bool = this.revision.compare(localDouble2, localDouble1);
  }

  private void validate(InputNode paramInputNode, Label paramLabel)
    throws Exception
  {
    Context localContext = this.context;
    Converter localConverter = paramLabel.getConverter(localContext);
    Position localPosition = paramInputNode.getPosition();
    Class localClass = this.type.getType();
    if (!localConverter.validate(paramInputNode))
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = paramLabel;
      arrayOfObject[1] = localClass;
      arrayOfObject[2] = localPosition;
      throw new PersistenceException("Invalid value for %s in %s at %s", arrayOfObject);
    }
    this.criteria.set(paramLabel, null);
  }

  private void validate(InputNode paramInputNode, LabelMap paramLabelMap)
    throws Exception
  {
    Position localPosition = paramInputNode.getPosition();
    Iterator localIterator = paramLabelMap.iterator();
    Label localLabel;
    Class localClass;
    do
    {
      if (!localIterator.hasNext())
        return;
      localLabel = (Label)localIterator.next();
      localClass = this.type.getType();
    }
    while ((!localLabel.isRequired()) || (!this.revision.isEqual()));
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = localLabel;
    arrayOfObject[1] = localClass;
    arrayOfObject[2] = localPosition;
    throw new ValueRequiredException("Unable to satisfy %s for %s at %s", arrayOfObject);
  }

  private void validate(InputNode paramInputNode, LabelMap paramLabelMap, Object paramObject)
    throws Exception
  {
    Context localContext1 = this.context;
    Type localType = this.type;
    Class localClass = localContext1.getType(localType, paramObject);
    Position localPosition = paramInputNode.getPosition();
    Iterator localIterator = paramLabelMap.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Label localLabel = (Label)localIterator.next();
      if ((localLabel.isRequired()) && (this.revision.isEqual()))
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = localLabel;
        arrayOfObject[1] = localClass;
        arrayOfObject[2] = localPosition;
        throw new ValueRequiredException("Unable to satisfy %s for %s at %s", arrayOfObject);
      }
      Context localContext2 = this.context;
      Object localObject = localLabel.getEmpty(localContext2);
      if (localObject != null)
        this.criteria.set(localLabel, localObject);
    }
  }

  private boolean validate(InputNode paramInputNode, Class paramClass)
    throws Exception
  {
    Schema localSchema = this.context.getSchema(paramClass);
    Section localSection = localSchema.getSection();
    validateText(paramInputNode, localSchema);
    validateSection(paramInputNode, localSection);
    return paramInputNode.isElement();
  }

  private void validateAttribute(InputNode paramInputNode, Section paramSection, LabelMap paramLabelMap)
    throws Exception
  {
    Position localPosition = paramInputNode.getPosition();
    String str1 = paramInputNode.getName();
    String str2 = paramSection.getAttribute(str1);
    Label localLabel = paramLabelMap.getLabel(str2);
    if (localLabel == null)
    {
      Class localClass = this.type.getType();
      Context localContext = this.context;
      if (!paramLabelMap.isStrict(localContext))
        return;
      if (!this.revision.isEqual())
        return;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = str2;
      arrayOfObject[1] = localClass;
      arrayOfObject[2] = localPosition;
      throw new AttributeException("Attribute '%s' does not exist for %s at %s", arrayOfObject);
    }
    validate(paramInputNode, localLabel);
  }

  private void validateAttributes(InputNode paramInputNode, Section paramSection)
    throws Exception
  {
    NodeMap localNodeMap = paramInputNode.getAttributes();
    LabelMap localLabelMap = paramSection.getAttributes();
    Iterator localIterator = localNodeMap.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      InputNode localInputNode = paramInputNode.getAttribute(str);
      if (localInputNode != null)
        validateAttribute(localInputNode, paramSection, localLabelMap);
    }
    validate(paramInputNode, localLabelMap);
  }

  private void validateElement(InputNode paramInputNode, Section paramSection, LabelMap paramLabelMap)
    throws Exception
  {
    String str1 = paramInputNode.getName();
    String str2 = paramSection.getPath(str1);
    Object localObject = paramLabelMap.getLabel(str2);
    if (localObject == null)
      localObject = this.criteria.resolve(str2);
    if (localObject == null)
    {
      Position localPosition = paramInputNode.getPosition();
      Class localClass = this.type.getType();
      Context localContext = this.context;
      if ((paramLabelMap.isStrict(localContext)) && (this.revision.isEqual()))
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = str2;
        arrayOfObject[1] = localClass;
        arrayOfObject[2] = localPosition;
        throw new ElementException("Element '%s' does not exist for %s at %s", arrayOfObject);
      }
      paramInputNode.skip();
      return;
    }
    validateUnion(paramInputNode, paramLabelMap, (Label)localObject);
  }

  private void validateElements(InputNode paramInputNode, Section paramSection)
    throws Exception
  {
    LabelMap localLabelMap = paramSection.getElements();
    InputNode localInputNode = paramInputNode.getNext();
    if (localInputNode != null)
    {
      String str = localInputNode.getName();
      Section localSection = paramSection.getSection(str);
      if (localSection != null)
        validateSection(localInputNode, localSection);
      while (true)
      {
        localInputNode = paramInputNode.getNext();
        break;
        validateElement(localInputNode, paramSection, localLabelMap);
      }
    }
    validate(paramInputNode, localLabelMap);
  }

  private void validateSection(InputNode paramInputNode, Section paramSection)
    throws Exception
  {
    validateAttributes(paramInputNode, paramSection);
    validateElements(paramInputNode, paramSection);
  }

  private void validateText(InputNode paramInputNode, Schema paramSchema)
    throws Exception
  {
    Label localLabel = paramSchema.getText();
    if (localLabel == null)
      return;
    validate(paramInputNode, localLabel);
  }

  private void validateUnion(InputNode paramInputNode, LabelMap paramLabelMap, Label paramLabel)
    throws Exception
  {
    String[] arrayOfString = paramLabel.getPaths();
    int i = arrayOfString.length;
    int j = 0;
    while (j < i)
    {
      String str = arrayOfString[j];
      Label localLabel = paramLabelMap.getLabel(str);
      j += 1;
    }
    if (paramLabel.isInline())
      this.criteria.set(paramLabel, null);
    validate(paramInputNode, paramLabel);
  }

  private void write(OutputNode paramOutputNode, Object paramObject, Schema paramSchema)
    throws Exception
  {
    Section localSection = paramSchema.getSection();
    writeVersion(paramOutputNode, paramObject, paramSchema);
    writeSection(paramOutputNode, paramObject, localSection);
  }

  private void writeAttribute(OutputNode paramOutputNode, Object paramObject, Label paramLabel)
    throws Exception
  {
    if (paramObject == null)
      return;
    Decorator localDecorator = paramLabel.getDecorator();
    String str1 = paramLabel.getName();
    String str2 = this.factory.getText(paramObject);
    OutputNode localOutputNode = paramOutputNode.setAttribute(str1, str2);
    localDecorator.decorate(localOutputNode);
  }

  private void writeAttributes(OutputNode paramOutputNode, Object paramObject, Section paramSection)
    throws Exception
  {
    Iterator localIterator = paramSection.getAttributes().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Label localLabel = (Label)localIterator.next();
      Object localObject = localLabel.getContact().get(paramObject);
      Context localContext1 = this.context;
      Type localType = this.type;
      Class localClass = localContext1.getType(localType, paramObject);
      if (localObject == null)
      {
        Context localContext2 = this.context;
        localObject = localLabel.getEmpty(localContext2);
      }
      if ((localObject == null) && (localLabel.isRequired()))
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = localLabel;
        arrayOfObject[1] = localClass;
        throw new AttributeException("Value for %s is null in %s", arrayOfObject);
      }
      writeAttribute(paramOutputNode, localObject, localLabel);
    }
  }

  private void writeElement(OutputNode paramOutputNode, Object paramObject, Converter paramConverter)
    throws Exception
  {
    paramConverter.write(paramOutputNode, paramObject);
  }

  private void writeElement(OutputNode paramOutputNode, Object paramObject, Label paramLabel)
    throws Exception
  {
    if (paramObject == null)
      return;
    Class localClass = paramObject.getClass();
    Label localLabel = paramLabel.getLabel(localClass);
    String str = localLabel.getName();
    Type localType = paramLabel.getType(localClass);
    OutputNode localOutputNode = paramOutputNode.getChild(str);
    if (!localLabel.isInline())
      writeNamespaces(localOutputNode, localType, localLabel);
    if ((!localLabel.isInline()) && (isOverridden(localOutputNode, paramObject, localType)))
      return;
    Context localContext = this.context;
    Converter localConverter = localLabel.getConverter(localContext);
    boolean bool = localLabel.isData();
    localOutputNode.setData(bool);
    writeElement(localOutputNode, paramObject, localConverter);
  }

  private void writeElements(OutputNode paramOutputNode, Object paramObject, Section paramSection)
    throws Exception
  {
    Iterator localIterator = paramSection.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      String str1 = (String)localIterator.next();
      Section localSection = paramSection.getSection(str1);
      if (localSection != null)
      {
        OutputNode localOutputNode = paramOutputNode.getChild(str1);
        writeSection(localOutputNode, paramObject, localSection);
      }
      else
      {
        String str2 = paramSection.getPath(str1);
        Label localLabel = paramSection.getElement(str2);
        Context localContext = this.context;
        Type localType = this.type;
        Class localClass = localContext.getType(localType, paramObject);
        if (this.criteria.get(localLabel) == null)
        {
          if (localLabel == null)
          {
            Object[] arrayOfObject = new Object[2];
            arrayOfObject[0] = str1;
            arrayOfObject[1] = localClass;
            throw new ElementException("Element '%s' not defined in %s", arrayOfObject);
          }
          writeUnion(paramOutputNode, paramObject, paramSection, localLabel);
        }
      }
    }
  }

  private void writeNamespaces(OutputNode paramOutputNode, Type paramType, Label paramLabel)
    throws Exception
  {
    Class localClass = paramType.getType();
    Decorator localDecorator = this.context.getDecorator(localClass);
    paramLabel.getDecorator().decorate(paramOutputNode, localDecorator);
  }

  private Object writeReplace(Object paramObject)
    throws Exception
  {
    if (paramObject != null)
    {
      Class localClass = paramObject.getClass();
      paramObject = this.context.getCaller(localClass).replace(paramObject);
    }
    return paramObject;
  }

  private void writeSection(OutputNode paramOutputNode, Object paramObject, Section paramSection)
    throws Exception
  {
    NamespaceMap localNamespaceMap = paramOutputNode.getNamespaces();
    String str1 = paramSection.getPrefix();
    if (str1 != null)
    {
      String str2 = localNamespaceMap.getReference(str1);
      if (str2 == null)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = str1;
        Type localType = this.type;
        arrayOfObject[1] = localType;
        throw new ElementException("Namespace prefix '%s' in %s is not in scope", arrayOfObject);
      }
      paramOutputNode.setReference(str2);
    }
    writeAttributes(paramOutputNode, paramObject, paramSection);
    writeElements(paramOutputNode, paramObject, paramSection);
    writeText(paramOutputNode, paramObject, paramSection);
  }

  private void writeText(OutputNode paramOutputNode, Object paramObject, Label paramLabel)
    throws Exception
  {
    if (paramObject == null)
      return;
    if (paramLabel.isTextList())
      return;
    String str = this.factory.getText(paramObject);
    boolean bool = paramLabel.isData();
    paramOutputNode.setData(bool);
    paramOutputNode.setValue(str);
  }

  private void writeText(OutputNode paramOutputNode, Object paramObject, Section paramSection)
    throws Exception
  {
    Label localLabel = paramSection.getText();
    if (localLabel == null)
      return;
    Object localObject = localLabel.getContact().get(paramObject);
    Context localContext1 = this.context;
    Type localType = this.type;
    Class localClass = localContext1.getType(localType, paramObject);
    if (localObject == null)
    {
      Context localContext2 = this.context;
      localObject = localLabel.getEmpty(localContext2);
    }
    if ((localObject == null) && (localLabel.isRequired()))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localLabel;
      arrayOfObject[1] = localClass;
      throw new TextException("Value for %s is null in %s", arrayOfObject);
    }
    writeText(paramOutputNode, localObject, localLabel);
  }

  private void writeUnion(OutputNode paramOutputNode, Object paramObject, Section paramSection, Label paramLabel)
    throws Exception
  {
    Object localObject1 = paramLabel.getContact().get(paramObject);
    Context localContext = this.context;
    Type localType = this.type;
    Class localClass = localContext.getType(localType, paramObject);
    if ((localObject1 == null) && (paramLabel.isRequired()))
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = paramLabel;
      arrayOfObject[1] = localClass;
      throw new ElementException("Value for %s is null in %s", arrayOfObject);
    }
    Object localObject2 = writeReplace(localObject1);
    if (localObject2 != null)
      writeElement(paramOutputNode, localObject2, paramLabel);
    this.criteria.set(paramLabel, localObject2);
  }

  private void writeVersion(OutputNode paramOutputNode, Object paramObject, Schema paramSchema)
    throws Exception
  {
    Version localVersion = paramSchema.getRevision();
    Label localLabel = paramSchema.getVersion();
    if (localVersion == null)
      return;
    Double localDouble1 = Double.valueOf(this.revision.getDefault());
    Double localDouble2 = Double.valueOf(localVersion.revision());
    if (this.revision.compare(localDouble2, localDouble1))
    {
      if (!localLabel.isRequired())
        return;
      writeAttribute(paramOutputNode, localDouble2, localLabel);
      return;
    }
    writeAttribute(paramOutputNode, localDouble2, localLabel);
  }

  public Object read(InputNode paramInputNode)
    throws Exception
  {
    Instance localInstance = this.factory.getInstance(paramInputNode);
    Class localClass = localInstance.getType();
    Object localObject;
    if (localInstance.isReference())
      localObject = localInstance.getInstance();
    while (true)
    {
      return localObject;
      if (this.context.isPrimitive(localClass))
        localObject = readPrimitive(paramInputNode, localInstance);
      else
        localObject = read(paramInputNode, localInstance, localClass);
    }
  }

  public Object read(InputNode paramInputNode, Object paramObject)
    throws Exception
  {
    Class localClass = paramObject.getClass();
    Schema localSchema = this.context.getSchema(localClass);
    Caller localCaller = localSchema.getCaller();
    read(paramInputNode, paramObject, localSchema);
    this.criteria.commit(paramObject);
    localCaller.validate(paramObject);
    localCaller.commit(paramObject);
    return readResolve(paramInputNode, paramObject, localCaller);
  }

  public boolean validate(InputNode paramInputNode)
    throws Exception
  {
    Instance localInstance = this.factory.getInstance(paramInputNode);
    Class localClass;
    if (!localInstance.isReference())
    {
      Object localObject = localInstance.setInstance(null);
      localClass = localInstance.getType();
    }
    for (boolean bool = validate(paramInputNode, localClass); ; bool = true)
      return bool;
  }

  public void write(OutputNode paramOutputNode, Object paramObject)
    throws Exception
  {
    Class localClass = paramObject.getClass();
    Schema localSchema = this.context.getSchema(localClass);
    Caller localCaller = localSchema.getCaller();
    try
    {
      if (localSchema.isPrimitive())
        this.primitive.write(paramOutputNode, paramObject);
      while (true)
      {
        return;
        localCaller.persist(paramObject);
        write(paramOutputNode, paramObject, localSchema);
      }
    }
    finally
    {
      localCaller.complete(paramObject);
    }
  }

  private class Injector extends Composite.Builder
  {
    private Injector(Composite paramCriteria, Criteria paramSchema, Schema paramInstance, Instance arg5)
    {
      super(paramSchema, paramInstance, localInstance);
    }

    private Object readInject(InputNode paramInputNode)
      throws Exception
    {
      Instantiator localInstantiator = this.schema.getInstantiator();
      Criteria localCriteria = this.criteria;
      Object localObject1 = localInstantiator.getInstance(localCriteria);
      Object localObject2 = this.value.setInstance(localObject1);
      this.criteria.commit(localObject1);
      return localObject1;
    }

    public Object read(InputNode paramInputNode)
      throws Exception
    {
      Section localSection = this.schema.getSection();
      Composite localComposite = this.composite;
      Schema localSchema = this.schema;
      localComposite.readVersion(paramInputNode, null, localSchema);
      this.composite.readText(paramInputNode, null, localSection);
      this.composite.readAttributes(paramInputNode, null, localSection);
      this.composite.readElements(paramInputNode, null, localSection);
      return readInject(paramInputNode);
    }
  }

  private static class Builder
  {
    protected final Composite composite;
    protected final Criteria criteria;
    protected final Schema schema;
    protected final Instance value;

    public Builder(Composite paramComposite, Criteria paramCriteria, Schema paramSchema, Instance paramInstance)
    {
      this.composite = paramComposite;
      this.criteria = paramCriteria;
      this.schema = paramSchema;
      this.value = paramInstance;
    }

    public Object read(InputNode paramInputNode)
      throws Exception
    {
      Object localObject1 = this.value.getInstance();
      Section localSection = this.schema.getSection();
      Object localObject2 = this.value.setInstance(localObject1);
      Composite localComposite = this.composite;
      Schema localSchema = this.schema;
      localComposite.readVersion(paramInputNode, localObject1, localSchema);
      this.composite.readText(paramInputNode, localObject1, localSection);
      this.composite.readAttributes(paramInputNode, localObject1, localSection);
      this.composite.readElements(paramInputNode, localObject1, localSection);
      this.criteria.commit(localObject1);
      return localObject1;
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.Composite
 * JD-Core Version:    0.6.2
 */