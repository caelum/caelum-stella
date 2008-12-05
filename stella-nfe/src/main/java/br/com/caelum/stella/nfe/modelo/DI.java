/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DI ", propOrder = { "ndi", "ddi", "xLocDesemb", "ufDesemb", "dDesemb", "cExportador", "adi" })
public class DI {

    @XmlElement(name = "nDI", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ndi;
    @XmlElement(name = "dDI", required = true)
    protected XMLGregorianCalendar ddi;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String xLocDesemb;
    @XmlElement(name = "UFDesemb", required = true)
    protected TUf ufDesemb;
    @XmlElement(required = true)
    protected XMLGregorianCalendar dDesemb;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String cExportador;
    @XmlElement(required = true)
    protected List<Adi> adi;

    public String getNDI() {
        return ndi;
    }

    public void setNDI(String value) {
        this.ndi = value;
    }

    public XMLGregorianCalendar getDDI() {
        return ddi;
    }

    public void setDDI(XMLGregorianCalendar value) {
        this.ddi = value;
    }

    public String getXLocDesemb() {
        return xLocDesemb;
    }

    public void setXLocDesemb(String value) {
        this.xLocDesemb = value;
    }

    public TUf getUFDesemb() {
        return ufDesemb;
    }

    public void setUFDesemb(TUf value) {
        this.ufDesemb = value;
    }

    public XMLGregorianCalendar getDDesemb() {
        return dDesemb;
    }

    public void setDDesemb(XMLGregorianCalendar value) {
        this.dDesemb = value;
    }

    public String getCExportador() {
        return cExportador;
    }

    public void setCExportador(String value) {
        this.cExportador = value;
    }

    public List<Adi> getAdi() {
        if (adi == null) {
            adi = new ArrayList<Adi>();
        }
        return this.adi;
    }

}