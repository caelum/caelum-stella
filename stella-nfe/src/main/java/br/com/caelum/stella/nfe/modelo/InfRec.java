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
@XmlType(name = "InfRec ", propOrder = { "nRec", "dhRecbto", "tMed" })
public class InfRec {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nRec;
    @XmlElement(required = true)
    protected XMLGregorianCalendar dhRecbto;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String tMed;

    public String getNRec() {
        return nRec;
    }

    public void setNRec(String value) {
        this.nRec = value;
    }

    public XMLGregorianCalendar getDhRecbto() {
        return dhRecbto;
    }

    public void setDhRecbto(XMLGregorianCalendar value) {
        this.dhRecbto = value;
    }

    public String getTMed() {
        return tMed;
    }

    public void setTMed(String value) {
        this.tMed = value;
    }

}