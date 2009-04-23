
package br.com.caelum.stella.nfe.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nfeCancelamentoNFResult"
})
@XmlRootElement(name = "nfeCancelamentoNFResponse", namespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeCancelamento")
public class NfeCancelamentoNFResponse {

    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeCancelamento")
    protected String nfeCancelamentoNFResult;

    public String getNfeCancelamentoNFResult() {
        return nfeCancelamentoNFResult;
    }

    public void setNfeCancelamentoNFResult(String value) {
        this.nfeCancelamentoNFResult = value;
    }

}
