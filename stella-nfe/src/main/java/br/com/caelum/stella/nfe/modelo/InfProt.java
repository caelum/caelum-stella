/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

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
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String dhRecbto;
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

    public void setTpAmb(final String value) {
        tpAmb = value;
    }

    public String getVerAplic() {
        return verAplic;
    }

    public void setVerAplic(final String value) {
        verAplic = value;
    }

    public String getChNFe() {
        return chNFe;
    }

    public void setChNFe(final String value) {
        chNFe = value;
    }

    public String getDhRecbto() {
        return dhRecbto;
    }

    public void setDhRecbto(final Calendar calendar) {
        dhRecbto = calendar.toString(); // TODO formatar isso
    }

    public String getNProt() {
        return nProt;
    }

    public void setNProt(final String value) {
        nProt = value;
    }

    public byte[] getDigVal() {
        return digVal;
    }

    public void setDigVal(final byte[] value) {
        digVal = value;
    }

    public String getCStat() {
        return cStat;
    }

    public void setCStat(final String value) {
        cStat = value;
    }

    public String getXMotivo() {
        return xMotivo;
    }

    public void setXMotivo(final String value) {
        xMotivo = value;
    }

    public String getId() {
        return id;
    }

    public void setId(final String value) {
        id = value;
    }

}