
package br.com.caelum.stella.nfe.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nfeInutilizacaoNFResult"
})
@XmlRootElement(name = "nfeInutilizacaoNFResponse", namespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeInutilizacao")
public class NfeInutilizacaoNFResponse {

    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe/wsdl/NfeInutilizacao")
    protected String nfeInutilizacaoNFResult;

    public String getNfeInutilizacaoNFResult() {
        return nfeInutilizacaoNFResult;
    }

    public void setNfeInutilizacaoNFResult(String value) {
        this.nfeInutilizacaoNFResult = value;
    }

}
