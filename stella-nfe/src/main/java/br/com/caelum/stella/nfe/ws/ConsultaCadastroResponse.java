
package br.com.caelum.stella.nfe.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "consultaCadastroResult"
})
@XmlRootElement(name = "consultaCadastroResponse", namespace = "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro")
public class ConsultaCadastroResponse {

    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe/wsdl/CadConsultaCadastro")
    protected String consultaCadastroResult;

    public String getConsultaCadastroResult() {
        return consultaCadastroResult;
    }

    public void setConsultaCadastroResult(String value) {
        this.consultaCadastroResult = value;
    }

}
