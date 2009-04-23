
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

final @XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "mod",
    "sit"
})
public class DFe {

    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String mod;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String sit;

    
    public String getMod() {
        return mod;
    }

    
    public void setMod(String value) {
        this.mod = value;
    }

    
    public String getSit() {
        return sit;
    }

    
    public void setSit(String value) {
        this.sit = value;
    }

}