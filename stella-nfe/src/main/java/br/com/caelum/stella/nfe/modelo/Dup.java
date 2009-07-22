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

import net.vidageek.fluid.annotations.FluidName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Dup ", propOrder = { "nDup", "dVenc", "vDup" })
@FluidName("Duplicata")
public class Dup {

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("numero")
    protected String nDup;

    @FluidName("dataDeVencimento")
    protected String dVenc;

    @FluidName("valorDaDuplicata")
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