
package br.com.caelum.stella.nfe.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nfeRetRecepcaoResult"
})
@XmlRootElement(name = "nfeRetRecepcaoResponse", namespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeRetRecepcao")
public class NfeRetRecepcaoResponse {

    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeRetRecepcao")
    protected String nfeRetRecepcaoResult;

    public String getNfeRetRecepcaoResult() {
        return nfeRetRecepcaoResult;
    }

    public void setNfeRetRecepcaoResult(String value) {
        this.nfeRetRecepcaoResult = value;
    }

}
