
package br.com.caelum.stella.nfe.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nfeRecepcaoLoteResult"
})
@XmlRootElement(name = "nfeRecepcaoLoteResponse", namespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeRecepcao")
public class NfeRecepcaoLoteResponse {

    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeRecepcao")
    protected String nfeRecepcaoLoteResult;

    public String getNfeRecepcaoLoteResult() {
        return nfeRecepcaoLoteResult;
    }

    public void setNfeRecepcaoLoteResult(String value) {
        this.nfeRecepcaoLoteResult = value;
    }

}
