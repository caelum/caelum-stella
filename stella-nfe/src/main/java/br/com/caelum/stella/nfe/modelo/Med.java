/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Med ", propOrder = { "nLote", "qLote", "dFab", "dVal", "vpmc" })
public class Med {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nLote;

    @XmlElement(required = true)
    protected String qLote;

    @XmlElement(required = true)
    protected XMLGregorianCalendar dFab;

    @XmlElement(required = true)
    protected XMLGregorianCalendar dVal;

    @XmlElement(name = "vPMC", required = true)
    protected String vpmc;

    public String getNLote() {
        return nLote;
    }

    public void setNLote(String value) {
        this.nLote = value;
    }

    public String getQLote() {
        return qLote;
    }

    public void setQLote(String value) {
        this.qLote = value;
    }

    public XMLGregorianCalendar getDFab() {
        return dFab;
    }

    public void setDFab(XMLGregorianCalendar value) {
        this.dFab = value;
    }

    public XMLGregorianCalendar getDVal() {
        return dVal;
    }

    public void setDVal(XMLGregorianCalendar value) {
        this.dVal = value;
    }

    public String getVPMC() {
        return vpmc;
    }

    public void setVPMC(String value) {
        this.vpmc = value;
    }

}