/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Dup ", propOrder = { "nDup", "dVenc", "vDup" })
public class Dup {

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nDup;
    protected XMLGregorianCalendar dVenc;
    protected String vDup;

    public String getNDup() {
        return nDup;
    }

    public void setNDup(String value) {
        this.nDup = value;
    }

    public XMLGregorianCalendar getDVenc() {
        return dVenc;
    }

    public void setDVenc(XMLGregorianCalendar value) {
        this.dVenc = value;
    }

    public String getVDup() {
        return vDup;
    }

    public void setVDup(String value) {
        this.vDup = value;
    }

}