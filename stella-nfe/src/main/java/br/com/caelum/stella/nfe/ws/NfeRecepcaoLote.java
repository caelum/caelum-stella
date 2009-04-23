
package br.com.caelum.stella.nfe.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nfeCabecMsg",
    "nfeDadosMsg"
})
@XmlRootElement(name = "nfeRecepcaoLote", namespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeRecepcao")
public class NfeRecepcaoLote {

    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeRecepcao")
    protected String nfeCabecMsg;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeRecepcao")
    protected String nfeDadosMsg;

    public String getNfeCabecMsg() {
        return nfeCabecMsg;
    }

    public void setNfeCabecMsg(String value) {
        this.nfeCabecMsg = value;
    }

    public String getNfeDadosMsg() {
        return nfeDadosMsg;
    }

    public void setNfeDadosMsg(String value) {
        this.nfeDadosMsg = value;
    }

}
