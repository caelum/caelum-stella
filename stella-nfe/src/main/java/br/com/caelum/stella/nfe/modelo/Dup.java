/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Dup ", propOrder = { "nDup", "dVenc", "vDup" })
public class Dup {

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nDup;

    protected String dVenc;

    protected String vDup;

    public String getNDup() {
        return nDup;
    }

    public void setNDup(final String value) {
        nDup = value;
    }

    public String getDVenc() {
        return dVenc;
    }

    public void setDVenc(final Calendar calendar) {
        dVenc = calendar.toString(); // TODO formatar isso
    }

    public String getVDup() {
        return vDup;
    }

    public void setVDup(final String value) {
        vDup = value;
    }

}