package com.hopstop.ClientModel.xml;

import com.hopstop.ClientModel.TaxiResponse;
import com.hopstop.ClientModel.directions.ViewStepTaxi;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetTaxisHandler extends DefaultHandler
{
  private TaxiResponse _taxiRes = null;
  private ViewStepTaxi _taxiStep;
  private StringBuffer buff = null;
  private boolean buffering = false;
  private String responseStatus = null;
  private int resultCode = -1;
  private String resultString = "Failed";

  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (!this.buffering)
      return;
    StringBuffer localStringBuffer = this.buff.append(paramArrayOfChar, paramInt1, paramInt2);
  }

  public void endDocument()
    throws SAXException
  {
  }

  public void endElement(String paramString1, String paramString2, String paramString3)
    throws SAXException
  {
    if (paramString2.equals("HopStopResponse"))
    {
      this.buffering = false;
      String str1 = this.buff.toString();
      return;
    }
    if (paramString2.equals("ResponseStatus"))
    {
      this.buffering = false;
      String str2 = this.buff.toString();
      this.responseStatus = str2;
      return;
    }
    if (paramString2.equals("ResultCode"))
    {
      this.buffering = false;
      int i = Integer.parseInt(this.buff.toString());
      this.resultCode = i;
      return;
    }
    if (paramString2.equals("ResultString"))
    {
      this.buffering = false;
      String str3 = this.buff.toString();
      this.resultString = str3;
      return;
    }
    if (paramString2.equals("item"))
    {
      TaxiResponse localTaxiResponse1 = this._taxiRes;
      ViewStepTaxi localViewStepTaxi1 = this._taxiStep;
      localTaxiResponse1.addTaxiViewStep(localViewStepTaxi1);
      return;
    }
    if (paramString2.equals("Description"))
    {
      this.buffering = false;
      ViewStepTaxi localViewStepTaxi2 = this._taxiStep;
      String str4 = this.buff.toString();
      localViewStepTaxi2.setDescription(str4);
      return;
    }
    if (paramString2.equals("Distance"))
    {
      this.buffering = false;
      String str5 = this.buff.toString();
      ViewStepTaxi localViewStepTaxi3 = this._taxiStep;
      float f1 = Float.parseFloat(str5);
      localViewStepTaxi3.setDistance(f1);
      return;
    }
    if (paramString2.equals("DrivingTime"))
    {
      this.buffering = false;
      String str6 = this.buff.toString();
      ViewStepTaxi localViewStepTaxi4 = this._taxiStep;
      int j = Integer.parseInt(str6);
      localViewStepTaxi4.setDrivingTime(j);
      if (this._taxiRes.getTotalTimeVerb() != null)
        return;
      TaxiResponse localTaxiResponse2 = this._taxiRes;
      double d = this._taxiStep.getDistance();
      int k = this._taxiStep.getDrivingTime();
      localTaxiResponse2.setTotalTimeVerb(d, k);
      return;
    }
    if (paramString2.equals("Id"))
    {
      this.buffering = false;
      ViewStepTaxi localViewStepTaxi5 = this._taxiStep;
      String str7 = this.buff.toString();
      localViewStepTaxi5.setId(str7);
      return;
    }
    if (paramString2.equals("Name"))
    {
      this.buffering = false;
      ViewStepTaxi localViewStepTaxi6 = this._taxiStep;
      String str8 = this.buff.toString();
      localViewStepTaxi6.setName(str8);
      return;
    }
    if (paramString2.equals("Notes"))
    {
      this.buffering = false;
      ViewStepTaxi localViewStepTaxi7 = this._taxiStep;
      String str9 = this.buff.toString();
      localViewStepTaxi7.setNotes(str9);
      return;
    }
    if (paramString2.equals("Phone"))
    {
      this.buffering = false;
      ViewStepTaxi localViewStepTaxi8 = this._taxiStep;
      String str10 = this.buff.toString();
      localViewStepTaxi8.setPhone(str10);
      return;
    }
    if (!paramString2.equals("Price"))
      return;
    this.buffering = false;
    String str11 = this.buff.toString();
    ViewStepTaxi localViewStepTaxi9 = this._taxiStep;
    float f2 = Float.parseFloat(str11);
    localViewStepTaxi9.setPrice(f2);
  }

  public TaxiResponse getTaxiResponse()
  {
    return this._taxiRes;
  }

  public boolean isSuccess()
  {
    if ((this.resultCode == 200) && (this.resultString.equals("Success.")));
    for (boolean bool = true; ; bool = false)
      return bool;
  }

  public void startDocument()
    throws SAXException
  {
  }

  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
    throws SAXException
  {
    if (paramString2.equals("HopStopResponse"))
    {
      StringBuffer localStringBuffer1 = new StringBuffer("");
      this.buff = localStringBuffer1;
      this.buffering = true;
      TaxiResponse localTaxiResponse = new TaxiResponse();
      this._taxiRes = localTaxiResponse;
      return;
    }
    if (paramString2.equals("ResponseStatus"))
    {
      StringBuffer localStringBuffer2 = new StringBuffer("");
      this.buff = localStringBuffer2;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("ResultCode"))
    {
      StringBuffer localStringBuffer3 = new StringBuffer("");
      this.buff = localStringBuffer3;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("ResultString"))
    {
      StringBuffer localStringBuffer4 = new StringBuffer("");
      this.buff = localStringBuffer4;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("item"))
    {
      ViewStepTaxi localViewStepTaxi = new ViewStepTaxi();
      this._taxiStep = localViewStepTaxi;
      return;
    }
    if (paramString2.equals("Description"))
    {
      StringBuffer localStringBuffer5 = new StringBuffer("");
      this.buff = localStringBuffer5;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("Distance"))
    {
      StringBuffer localStringBuffer6 = new StringBuffer("");
      this.buff = localStringBuffer6;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("DrivingTime"))
    {
      StringBuffer localStringBuffer7 = new StringBuffer("");
      this.buff = localStringBuffer7;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("Id"))
    {
      StringBuffer localStringBuffer8 = new StringBuffer("");
      this.buff = localStringBuffer8;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("Name"))
    {
      StringBuffer localStringBuffer9 = new StringBuffer("");
      this.buff = localStringBuffer9;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("Notes"))
    {
      StringBuffer localStringBuffer10 = new StringBuffer("");
      this.buff = localStringBuffer10;
      this.buffering = true;
      return;
    }
    if (paramString2.equals("Phone"))
    {
      StringBuffer localStringBuffer11 = new StringBuffer("");
      this.buff = localStringBuffer11;
      this.buffering = true;
      return;
    }
    if (!paramString2.equals("Price"))
      return;
    StringBuffer localStringBuffer12 = new StringBuffer("");
    this.buff = localStringBuffer12;
    this.buffering = true;
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.xml.GetTaxisHandler
 * JD-Core Version:    0.6.2
 */