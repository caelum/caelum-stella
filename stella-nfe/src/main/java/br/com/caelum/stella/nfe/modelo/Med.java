/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import net.vidageek.fluid.annotations.FluidDataType;
import net.vidageek.fluid.annotations.FluidName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Med ", propOrder = { "nLote", "qLote", "dFab", "dVal", "vpmc" })
@FluidName("Medicamento")
public class Med {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("numeroDoLote")
    protected String nLote;

    @XmlElement(required = true)
    @FluidName("quantidadeDoLote")
    protected String qLote;

    @XmlElement(required = true)
    @FluidName("dataDeFabricacao")
    @FluidDataType(Calendar.class)
    protected String dFab;

    @XmlElement(required = true)
    @FluidName("dataDeValidade")
    @FluidDataType(Calendar.class)
    protected String dVal;

    @XmlElement(name = "vPMC", required = true)
    @FluidName("precoMaximoAoConsumidor")
    @FluidDataType(BigDecimal.class)
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