
package br.com.caelum.stella.nfe.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nfeStatusServicoNFResult"
})
@XmlRootElement(name = "nfeStatusServicoNFResponse")
public class NfeStatusServicoNFResponse {

    protected String nfeStatusServicoNFResult;

    public String getNfeStatusServicoNFResult() {
        return nfeStatusServicoNFResult;
    }

    public void setNfeStatusServicoNFResult(String value) {
        this.nfeStatusServicoNFResult = value;
    }

}
