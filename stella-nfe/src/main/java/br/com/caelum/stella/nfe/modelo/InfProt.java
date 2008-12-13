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
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfProt ", propOrder = { "tpAmb", "verAplic", "chNFe", "dhRecbto", "nProt", "digVal", "cStat",
        "xMotivo" })
public class InfProt {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String tpAmb;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String verAplic;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String chNFe;

    @XmlElement(required = true)
    protected XMLGregorianCalendar dhRecbto;

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nProt;

    protected byte[] digVal;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cStat;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String xMotivo;

    @XmlAttribute(name = "Id")
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

    public String getVerAplic() {
        return verAplic;
    }

    public void setVerAplic(String value) {
        this.verAplic = value;
    }

    public String getChNFe() {
        return chNFe;
    }

    public void setChNFe(String value) {
        this.chNFe = value;
    }

    public XMLGregorianCalendar getDhRecbto() {
        return dhRecbto;
    }

    public void setDhRecbto(XMLGregorianCalendar value) {
        this.dhRecbto = value;
    }

    public String getNProt() {
        return nProt;
    }

    public void setNProt(String value) {
        this.nProt = value;
    }

    public byte[] getDigVal() {
        return digVal;
    }

    public void setDigVal(byte[] value) {
        this.digVal = value;
    }

    public String getCStat() {
        return cStat;
    }

    public void setCStat(String value) {
        this.cStat = value;
    }

    public String getXMotivo() {
        return xMotivo;
    }

    public void setXMotivo(String value) {
        this.xMotivo = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

}