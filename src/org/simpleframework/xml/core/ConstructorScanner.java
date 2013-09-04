package org.simpleframework.xml.core;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ConstructorScanner
{
  private Signature primary;
  private ParameterMap registry;
  private List<Signature> signatures;
  private Support support;

  public ConstructorScanner(Detail paramDetail, Support paramSupport)
    throws Exception
  {
    ArrayList localArrayList = new ArrayList();
    this.signatures = localArrayList;
    ParameterMap localParameterMap = new ParameterMap();
    this.registry = localParameterMap;
    this.support = paramSupport;
    scan(paramDetail);
  }

  private void scan(Constructor paramConstructor)
    throws Exception
  {
    ParameterMap localParameterMap = this.registry;
    Support localSupport = this.support;
    SignatureScanner localSignatureScanner = new SignatureScanner(paramConstructor, localParameterMap, localSupport);
    if (!localSignatureScanner.isValid())
      return;
    Iterator localIterator = localSignatureScanner.getSignatures().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      Signature localSignature = (Signature)localIterator.next();
      if (localSignature.size() == 0)
        this.primary = localSignature;
      boolean bool = this.signatures.add(localSignature);
    }
  }

  private void scan(Detail paramDetail)
    throws Exception
  {
    Constructor[] arrayOfConstructor1 = paramDetail.getConstructors();
    if (!paramDetail.isInstantiable())
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramDetail;
      throw new ConstructorException("Can not construct inner %s", arrayOfObject);
    }
    Constructor[] arrayOfConstructor2 = arrayOfConstructor1;
    int i = arrayOfConstructor2.length;
    int j = 0;
    while (true)
    {
      if (j >= i)
        return;
      Constructor localConstructor = arrayOfConstructor2[j];
      if (!paramDetail.isPrimitive())
        scan(localConstructor);
      j += 1;
    }
  }

  public ParameterMap getParameters()
  {
    return this.registry;
  }

  public Signature getSignature()
  {
    return this.primary;
  }

  public List<Signature> getSignatures()
  {
    List localList = this.signatures;
    return new ArrayList(localList);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ConstructorScanner
 * JD-Core Version:    0.6.2
 */