package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import org.simpleframework.xml.Text;
import org.simpleframework.xml.strategy.Type;

class TextListLabel extends TemplateLabel
{
  private final String empty;
  private final Label label;
  private final Text text;

  public TextListLabel(Label paramLabel, Text paramText)
  {
    String str = paramText.empty();
    this.empty = str;
    this.label = paramLabel;
    this.text = paramText;
  }

  public Annotation getAnnotation()
  {
    return this.label.getAnnotation();
  }

  public Contact getContact()
  {
    return this.label.getContact();
  }

  public Converter getConverter(Context paramContext)
    throws Exception
  {
    Contact localContact = getContact();
    if (!this.label.isCollection())
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localContact;
      Label localLabel1 = this.label;
      arrayOfObject[1] = localLabel1;
      throw new TextException("Cannot use %s to represent %s", arrayOfObject);
    }
    Label localLabel2 = this.label;
    return new TextList(paramContext, localContact, localLabel2);
  }

  public Decorator getDecorator()
    throws Exception
  {
    return null;
  }

  public Type getDependent()
    throws Exception
  {
    return this.label.getDependent();
  }

  public String getEmpty(Context paramContext)
    throws Exception
  {
    return this.empty;
  }

  public String getEntry()
    throws Exception
  {
    return this.label.getEntry();
  }

  public Expression getExpression()
    throws Exception
  {
    return this.label.getExpression();
  }

  public Object getKey()
    throws Exception
  {
    return this.label.getKey();
  }

  public String getName()
    throws Exception
  {
    return this.label.getName();
  }

  public String[] getNames()
    throws Exception
  {
    return this.label.getNames();
  }

  public String getOverride()
  {
    return this.label.getOverride();
  }

  public String getPath()
    throws Exception
  {
    return this.label.getPath();
  }

  public String[] getPaths()
    throws Exception
  {
    return this.label.getPaths();
  }

  public Class getType()
  {
    return this.label.getType();
  }

  public boolean isCollection()
  {
    return true;
  }

  public boolean isData()
  {
    return this.label.isData();
  }

  public boolean isInline()
  {
    return this.label.isInline();
  }

  public boolean isRequired()
  {
    return this.label.isRequired();
  }

  public boolean isTextList()
  {
    return true;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    Text localText = this.text;
    arrayOfObject[0] = localText;
    Label localLabel = this.label;
    arrayOfObject[1] = localLabel;
    return String.format("%s %s", arrayOfObject);
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.TextListLabel
 * JD-Core Version:    0.6.2
 */