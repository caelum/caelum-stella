/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

final @XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "uf",
    "cnpj"
})
public class Exclui {

    @XmlElement(name = "UF", namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected TUf uf;
    @XmlElement(name = "CNPJ", namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected Object cnpj;

    
    public TUf getUF() {
        return uf;
    }

    
    public void setUF(TUf value) {
        this.uf = value;
    }

    
    public Object getCNPJ() {
        return cnpj;
    }

    
    public void setCNPJ(Object value) {
        this.cnpj = value;
    }

}