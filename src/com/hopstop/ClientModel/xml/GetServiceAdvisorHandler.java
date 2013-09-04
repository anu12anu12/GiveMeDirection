package com.hopstop.ClientModel.xml;

import com.hopstop.ClientModel.ServiceAdvisorResponse;
import com.hopstop.ClientView.anim.ViewStepSubwayVehicle;
import com.hopstop.network.NetworkSettings;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GetServiceAdvisorHandler extends DefaultHandler
{
  private ViewStepSubwayVehicle _sVehicle;
  private ServiceAdvisorResponse _saResponse;
  private String _type;
  private StringBuffer buff = null;
  private boolean buffering = false;

  public GetServiceAdvisorHandler(int paramInt)
  {
    int i = NetworkSettings.GET_SERVICE_ADVISOR_SUBWAY_TRAIN;
    if (paramInt != i)
    {
      String str1 = ViewStepSubwayVehicle.SUBWAY_TRAIN;
      this._type = str1;
      return;
    }
    int j = NetworkSettings.GET_SERVICE_ADVISOR_REGIONAL_RAIL;
    if (paramInt != j)
    {
      String str2 = ViewStepSubwayVehicle.REGIONAL_RAIL;
      this._type = str2;
      return;
    }
    int k = NetworkSettings.GET_SERVICE_ADVISOR_BUS;
    if (paramInt != k)
      return;
    String str3 = ViewStepSubwayVehicle.BUS;
    this._type = str3;
  }

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
      return;
    if (paramString2.equals("Status"))
    {
      this.buffering = false;
      ViewStepSubwayVehicle localViewStepSubwayVehicle1 = this._sVehicle;
      String str1 = this.buff.toString();
      localViewStepSubwayVehicle1.setStatus(str1);
      return;
    }
    if (paramString2.equals("StatusDescription"))
    {
      this.buffering = false;
      ViewStepSubwayVehicle localViewStepSubwayVehicle2 = this._sVehicle;
      String str2 = this.buff.toString();
      localViewStepSubwayVehicle2.setStatusDescription(str2);
      return;
    }
    if (paramString2.equals("VerbTime"))
    {
      this.buffering = false;
      ViewStepSubwayVehicle localViewStepSubwayVehicle3 = this._sVehicle;
      String str3 = this.buff.toString();
      localViewStepSubwayVehicle3.setVerbTime(str3);
      return;
    }
    if (paramString2.equals("Name"))
    {
      this.buffering = false;
      ViewStepSubwayVehicle localViewStepSubwayVehicle4 = this._sVehicle;
      String str4 = this.buff.toString();
      localViewStepSubwayVehicle4.setName(str4);
      return;
    }
    if (paramString2.equals("Id"))
    {
      this.buffering = false;
      ViewStepSubwayVehicle localViewStepSubwayVehicle5 = this._sVehicle;
      String str5 = this.buff.toString();
      localViewStepSubwayVehicle5.setId(str5);
      return;
    }
    if (paramString2.equals("Type"))
    {
      this.buffering = false;
      ViewStepSubwayVehicle localViewStepSubwayVehicle6 = this._sVehicle;
      String str6 = this.buff.toString();
      localViewStepSubwayVehicle6.setType(str6);
      return;
    }
    if (paramString2.equals("URL"))
    {
      this.buffering = false;
      ViewStepSubwayVehicle localViewStepSubwayVehicle7 = this._sVehicle;
      String str7 = this.buff.toString();
      String str8 = this._sVehicle.getType();
      String str9 = this._type;
      boolean bool = str8.equalsIgnoreCase(str9);
      localViewStepSubwayVehicle7.setURL(str7, bool);
      return;
    }
    if (paramString2.equals("Alert"))
    {
      this.buffering = false;
      String str10 = this._sVehicle.getType();
      String str11 = ViewStepSubwayVehicle.SUBWAY_TRAIN;
      if (str10.equalsIgnoreCase(str11))
      {
        ServiceAdvisorResponse localServiceAdvisorResponse1 = this._saResponse;
        ViewStepSubwayVehicle localViewStepSubwayVehicle8 = this._sVehicle;
        localServiceAdvisorResponse1.addServiceAdvisorSubwayTrain(localViewStepSubwayVehicle8);
        return;
      }
      String str12 = this._sVehicle.getType();
      String str13 = ViewStepSubwayVehicle.REGIONAL_RAIL;
      if (str12.equalsIgnoreCase(str13))
      {
        ServiceAdvisorResponse localServiceAdvisorResponse2 = this._saResponse;
        ViewStepSubwayVehicle localViewStepSubwayVehicle9 = this._sVehicle;
        localServiceAdvisorResponse2.addServiceAdvisorRegionalRail(localViewStepSubwayVehicle9);
        return;
      }
      String str14 = this._sVehicle.getType();
      String str15 = ViewStepSubwayVehicle.BUS;
      if (!str14.equalsIgnoreCase(str15))
        return;
      ServiceAdvisorResponse localServiceAdvisorResponse3 = this._saResponse;
      ViewStepSubwayVehicle localViewStepSubwayVehicle10 = this._sVehicle;
      localServiceAdvisorResponse3.addServiceAdvisorBus(localViewStepSubwayVehicle10);
      return;
    }
    if (!paramString2.equals("ResultCode"))
      return;
    this.buffering = false;
    ServiceAdvisorResponse localServiceAdvisorResponse4 = this._saResponse;
    int i = Integer.parseInt(this.buff.toString());
    localServiceAdvisorResponse4.setResult(i);
  }

  public ServiceAdvisorResponse getResponse()
  {
    return this._saResponse;
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
      ServiceAdvisorResponse localServiceAdvisorResponse = new ServiceAdvisorResponse();
      this._saResponse = localServiceAdvisorResponse;
    }
    while (true)
    {
      StringBuffer localStringBuffer = new StringBuffer("");
      this.buff = localStringBuffer;
      this.buffering = true;
      return;
      if (paramString2.equals("Alert"))
      {
        ViewStepSubwayVehicle localViewStepSubwayVehicle = new ViewStepSubwayVehicle();
        this._sVehicle = localViewStepSubwayVehicle;
      }
    }
  }
}

/* Location:           D:\Tools\extractapktools\extractapktools\dex2jar-0.0.7.11-SNAPSHOT\classes_dex2jar.jar
 * Qualified Name:     com.hopstop.ClientModel.xml.GetServiceAdvisorHandler
 * JD-Core Version:    0.6.2
 */