package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class InstantiatorBuilder
{
  private LabelMap attributes;
  private Comparer comparer;
  private Detail detail;
  private LabelMap elements;
  private Instantiator factory;
  private List<Creator> options;
  private Scanner scanner;
  private LabelMap texts;

  public InstantiatorBuilder(Scanner paramScanner, Detail paramDetail)
  {
    ArrayList localArrayList = new ArrayList();
    this.options = localArrayList;
    Comparer localComparer = new Comparer();
    this.comparer = localComparer;
    LabelMap localLabelMap1 = new LabelMap();
    this.attributes = localLabelMap1;
    LabelMap localLabelMap2 = new LabelMap();
    this.elements = localLabelMap2;
    LabelMap localLabelMap3 = new LabelMap();
    this.texts = localLabelMap3;
    this.scanner = paramScanner;
    this.detail = paramDetail;
  }

  private Instantiator build(Detail paramDetail)
    throws Exception
  {
    if (this.factory == null)
    {
      Instantiator localInstantiator = create(paramDetail);
      this.factory = localInstantiator;
    }
    return this.factory;
  }

  private boolean contains(String[] paramArrayOfString, String paramString)
    throws Exception
  {
    boolean bool = true;
    String[] arrayOfString = paramArrayOfString;
    int i = arrayOfString.length;
    int j = 0;
    String str;
    if (j < i)
    {
      str = arrayOfString[j];
      if (str != paramString);
    }
    while (true)
    {
      return bool;
      if (!str.equals(paramString))
      {
        j += 1;
        break;
        bool = false;
      }
    }
  }

  private Creator create(Signature paramSignature)
  {
    SignatureCreator localSignatureCreator = new SignatureCreator(paramSignature);
    if (paramSignature != null)
      boolean bool = this.options.add(localSignatureCreator);
    return localSignatureCreator;
  }

  private Instantiator create(Detail paramDetail)
    throws Exception
  {
    Signature localSignature = this.scanner.getSignature();
    ParameterMap localParameterMap = this.scanner.getParameters();
    SignatureCreator localSignatureCreator = null;
    if (localSignature != null)
      localSignatureCreator = new SignatureCreator(localSignature);
    List localList = this.options;
    return new ClassInstantiator(localList, localSignatureCreator, localParameterMap, paramDetail);
  }

  private Parameter create(Parameter paramParameter)
    throws Exception
  {
    Label localLabel = resolve(paramParameter);
    if (localLabel != null);
    for (CacheParameter localCacheParameter = new CacheParameter(paramParameter, localLabel); ; localCacheParameter = null)
      return localCacheParameter;
  }

  private void populate(Detail paramDetail)
    throws Exception
  {
    Iterator localIterator = this.scanner.getSignatures().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Signature localSignature = (Signature)localIterator.next();
      populate(localSignature);
    }
  }

  private void populate(Signature paramSignature)
    throws Exception
  {
    Signature localSignature = new Signature(paramSignature);
    Iterator localIterator = paramSignature.iterator();
    while (localIterator.hasNext())
    {
      Parameter localParameter1 = (Parameter)localIterator.next();
      Parameter localParameter2 = create(localParameter1);
      if (localParameter2 != null)
        localSignature.add(localParameter2);
    }
    Creator localCreator = create(localSignature);
  }

  private void register(Label paramLabel, LabelMap paramLabelMap)
    throws Exception
  {
    String str1 = paramLabel.getName();
    String str2 = paramLabel.getPath();
    if (paramLabelMap.containsKey(str1))
      if (!((Label)paramLabelMap.get(str1)).getPath().equals(str1))
        Object localObject1 = paramLabelMap.remove(str1);
    while (true)
    {
      Object localObject2 = paramLabelMap.put(str2, paramLabel);
      return;
      Object localObject3 = paramLabelMap.put(str1, paramLabel);
    }
  }

  private Label resolve(Parameter paramParameter)
    throws Exception
  {
    Label localLabel;
    if (paramParameter.isAttribute())
    {
      LabelMap localLabelMap1 = this.attributes;
      localLabel = resolve(paramParameter, localLabelMap1);
    }
    while (true)
    {
      return localLabel;
      if (paramParameter.isText())
      {
        LabelMap localLabelMap2 = this.texts;
        localLabel = resolve(paramParameter, localLabelMap2);
      }
      else
      {
        LabelMap localLabelMap3 = this.elements;
        localLabel = resolve(paramParameter, localLabelMap3);
      }
    }
  }

  private Label resolve(Parameter paramParameter, LabelMap paramLabelMap)
    throws Exception
  {
    String str1 = paramParameter.getName();
    String str2 = paramParameter.getPath();
    Label localLabel1 = (Label)paramLabelMap.get(str2);
    if (localLabel1 == null);
    for (Label localLabel2 = (Label)paramLabelMap.get(str1); ; localLabel2 = localLabel1)
      return localLabel2;
  }

  private void validate(Detail paramDetail)
    throws Exception
  {
    Iterator localIterator = this.scanner.getParameters().getAll().iterator();
    while (localIterator.hasNext())
    {
      Parameter localParameter = (Parameter)localIterator.next();
      Label localLabel = resolve(localParameter);
      String str = localParameter.getPath();
      if (localLabel == null)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = str;
        arrayOfObject[1] = paramDetail;
        throw new ConstructorException("Parameter '%s' does not have a match in %s", arrayOfObject);
      }
      validateParameter(localLabel, localParameter);
    }
    validateConstructors();
  }

  private void validateAnnotations(Label paramLabel, Parameter paramParameter)
    throws Exception
  {
    Annotation localAnnotation1 = paramLabel.getAnnotation();
    Annotation localAnnotation2 = paramParameter.getAnnotation();
    String str = paramParameter.getName();
    if (this.comparer.equals(localAnnotation1, localAnnotation2))
      return;
    Class localClass1 = localAnnotation1.annotationType();
    Class localClass2 = localAnnotation2.annotationType();
    if (localClass1.equals(localClass2))
      return;
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = localClass2;
    arrayOfObject[1] = localClass1;
    arrayOfObject[2] = str;
    arrayOfObject[3] = paramParameter;
    throw new ConstructorException("Annotation %s does not match %s for '%s' in %s", arrayOfObject);
  }

  private void validateConstructor(Label paramLabel, List<Creator> paramList)
    throws Exception
  {
    Iterator localIterator = paramList.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Signature localSignature = ((Creator)localIterator.next()).getSignature();
      Contact localContact = paramLabel.getContact();
      Object localObject = paramLabel.getKey();
      if ((localContact.isReadOnly()) && (localSignature.get(localObject) == null))
        localIterator.remove();
    }
  }

  private void validateConstructors()
    throws Exception
  {
    List localList = this.factory.getCreators();
    if (this.factory.isDefault())
    {
      LabelMap localLabelMap1 = this.elements;
      validateConstructors(localLabelMap1);
      LabelMap localLabelMap2 = this.attributes;
      validateConstructors(localLabelMap2);
    }
    if (localList.isEmpty())
      return;
    LabelMap localLabelMap3 = this.elements;
    validateConstructors(localLabelMap3, localList);
    LabelMap localLabelMap4 = this.attributes;
    validateConstructors(localLabelMap4, localList);
  }

  private void validateConstructors(LabelMap paramLabelMap)
    throws Exception
  {
    Iterator localIterator = paramLabelMap.iterator();
    Label localLabel;
    do
    {
      if (!localIterator.hasNext())
        return;
      localLabel = (Label)localIterator.next();
    }
    while ((localLabel == null) || (!localLabel.getContact().isReadOnly()));
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = localLabel;
    Detail localDetail = this.detail;
    arrayOfObject[1] = localDetail;
    throw new ConstructorException("Default constructor can not accept read only %s in %s", arrayOfObject);
  }

  private void validateConstructors(LabelMap paramLabelMap, List<Creator> paramList)
    throws Exception
  {
    Iterator localIterator = paramLabelMap.iterator();
    while (localIterator.hasNext())
    {
      Label localLabel = (Label)localIterator.next();
      if (localLabel != null)
        validateConstructor(localLabel, paramList);
    }
    if (!paramList.isEmpty())
      return;
    Object[] arrayOfObject = new Object[1];
    Detail localDetail = this.detail;
    arrayOfObject[0] = localDetail;
    throw new ConstructorException("No constructor accepts all read only values in %s", arrayOfObject);
  }

  private void validateNames(Label paramLabel, Parameter paramParameter)
    throws Exception
  {
    String[] arrayOfString = paramLabel.getNames();
    String str1 = paramParameter.getName();
    if (contains(arrayOfString, str1))
      return;
    String str2 = paramLabel.getName();
    if (str1 == str2)
      return;
    if ((str1 == null) || (str2 == null))
    {
      Object[] arrayOfObject1 = new Object[3];
      arrayOfObject1[0] = paramLabel;
      arrayOfObject1[1] = str1;
      arrayOfObject1[2] = paramParameter;
      throw new ConstructorException("Annotation does not match %s for '%s' in %s", arrayOfObject1);
    }
    if (str1.equals(str2))
      return;
    Object[] arrayOfObject2 = new Object[3];
    arrayOfObject2[0] = paramLabel;
    arrayOfObject2[1] = str1;
    arrayOfObject2[2] = paramParameter;
    throw new ConstructorException("Annotation does not match %s for '%s' in %s", arrayOfObject2);
  }

  private void validateParameter(Label paramLabel, Parameter paramParameter)
    throws Exception
  {
    Contact localContact = paramLabel.getContact();
    String str = paramParameter.getName();
    Class localClass1 = paramParameter.getType();
    Class localClass2 = localContact.getType();
    if (!Support.isAssignable(localClass1, localClass2))
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = paramLabel;
      arrayOfObject[1] = str;
      arrayOfObject[2] = paramParameter;
      throw new ConstructorException("Type is not compatible with %s for '%s' in %s", arrayOfObject);
    }
    validateNames(paramLabel, paramParameter);
    validateAnnotations(paramLabel, paramParameter);
  }

  public Instantiator build()
    throws Exception
  {
    if (this.factory == null)
    {
      Detail localDetail1 = this.detail;
      populate(localDetail1);
      Detail localDetail2 = this.detail;
      Instantiator localInstantiator = build(localDetail2);
      Detail localDetail3 = this.detail;
      validate(localDetail3);
    }
    return this.factory;
  }

  public void register(Label paramLabel)
    throws Exception
  {
    if (paramLabel.isAttribute())
    {
      LabelMap localLabelMap1 = this.attributes;
      register(paramLabel, localLabelMap1);
      return;
    }
    if (paramLabel.isText())
    {
      LabelMap localLabelMap2 = this.texts;
      register(paramLabel, localLabelMap2);
      return;
    }
    LabelMap localLabelMap3 = this.elements;
    register(paramLabel, localLabelMap3);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.InstantiatorBuilder
 * JD-Core Version:    0.6.2
 */