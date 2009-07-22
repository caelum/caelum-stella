/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import net.vidageek.fluid.annotations.FluidDataType;
import net.vidageek.fluid.annotations.FluidName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PISAliq ", propOrder = { "cst", "vbc", "ppis", "vpis" })
@FluidName("PISTributadoPelaAliquota")
public class PISAliq {

    @XmlElement(name = "CST", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("codigoSituacaoTributaria")
    protected String cst;

    @XmlElement(name = "vBC", required = true)
    @FluidName("valorDaBaseDeCalculo")
    @FluidDataType(BigDecimal.class)
    protected String vbc;

    @XmlElement(name = "pPIS", required = true)
    @FluidName("aliquotaDoPIS")
    @FluidDataType(BigDecimal.class)
    protected String ppis;

    @XmlElement(name = "vPIS", required = true)
    @FluidName("valorDoPIS")
    @FluidDataType(BigDecimal.class)
    protected String vpis;

    public String getCST() {
        return cst;
    }

    public void setCST(final String value) {
        cst = value;
    }

    public String getVBC() {
        return vbc;
    }

    public void setVBC(final String value) {
        vbc = value;
    }

    public String getPPIS() {
        return ppis;
    }

    public void setPPIS(final String value) {
        ppis = value;
    }

    public String getVPIS() {
        return vpis;
    }

    public void setVPIS(final String value) {
        vpis = value;
    }

}