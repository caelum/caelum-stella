
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

final @XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "uf",
    "inclui",
    "exclui"
})
public class InfAtuCadEmiDFe {

    @XmlElement(name = "UF", namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    protected TUf uf;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe")
    protected TEmissor inclui;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe")
    protected Exclui exclui;
    @XmlAttribute(name = "Id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    
    public TUf getUF() {
        return uf;
    }

    
    public void setUF(TUf value) {
        this.uf = value;
    }

    
    public TEmissor getInclui() {
        return inclui;
    }

    
    public void setInclui(TEmissor value) {
        this.inclui = value;
    }

    
    public Exclui getExclui() {
        return exclui;
    }

    
    public void setExclui(Exclui value) {
        this.exclui = value;
    }

    
    public String getId() {
        return id;
    }

    
    public void setId(String value) {
        this.id = value;
    }

}