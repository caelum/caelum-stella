/**
 * 
 */
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
    "tpAmb",
    "xServ",
    "chNFe",
    "nProt",
    "xJust"
})
public class InfCanc {

    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String tpAmb;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String xServ;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String chNFe;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nProt;
    @XmlElement(namespace = "http://www.portalfiscal.inf.br/nfe", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String xJust;
    @XmlAttribute(name = "Id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    
    public String getTpAmb() {
        return tpAmb;
    }

    
    public void setTpAmb(String value) {
        this.tpAmb = value;
    }

    
    public String getXServ() {
        return xServ;
    }

    
    public void setXServ(String value) {
        this.xServ = value;
    }

    
    public String getChNFe() {
        return chNFe;
    }

    
    public void setChNFe(String value) {
        this.chNFe = value;
    }

    
    public String getNProt() {
        return nProt;
    }

    
    public void setNProt(String value) {
        this.nProt = value;
    }

    
    public String getXJust() {
        return xJust;
    }

    
    public void setXJust(String value) {
        this.xJust = value;
    }

    
    public String getId() {
        return id;
    }

    
    public void setId(String value) {
        this.id = value;
    }

}