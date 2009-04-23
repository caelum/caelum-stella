
package br.com.caelum.stella.nfe.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nfeConsultaNFResult"
})
@XmlRootElement(name = "nfeConsultaNFResponse", namespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeConsulta")
public class NfeConsultaNFResponse {

    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeConsulta")
    protected String nfeConsultaNFResult;

    public String getNfeConsultaNFResult() {
        return nfeConsultaNFResult;
    }

    public void setNfeConsultaNFResult(String value) {
        this.nfeConsultaNFResult = value;
    }

}
