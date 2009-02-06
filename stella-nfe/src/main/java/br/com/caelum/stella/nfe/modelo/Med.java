/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Med ", propOrder = { "nLote", "qLote", "dFab", "dVal", "vpmc" })
public class Med {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String nLote;

    @XmlElement(required = true)
    protected String qLote;

    @XmlElement(required = true)
    protected String dFab;

    @XmlElement(required = true)
    protected String dVal;

    @XmlElement(name = "vPMC", required = true)
    protected String vpmc;

    public String getNLote() {
        return nLote;
    }

    public void setNLote(final String value) {
        nLote = value;
    }

    public String getQLote() {
        return qLote;
    }

    public void setQLote(final String value) {
        qLote = value;
    }

    public String getDFab() {
        return dFab;
    }

    public void setDFab(final String value) {
        dFab = value;
    }

    public String getDVal() {
        return dVal;
    }

    public void setDVal(final Calendar calendar) {
        dVal = calendar.toString();// TODO formatar isso
    }

    public String getVPMC() {
        return vpmc;
    }

    public void setVPMC(final String value) {
        vpmc = value;
    }

}