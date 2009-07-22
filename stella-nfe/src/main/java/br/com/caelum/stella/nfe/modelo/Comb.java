/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import net.vidageek.fluid.annotations.FluidDataType;
import net.vidageek.fluid.annotations.FluidName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Comb ", propOrder = { "cProdANP", "codif", "qTemp", "cide", "icmsComb", "icmsInter", "icmsCons" })
@FluidName("Combustivel")
public class Comb {

    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("codigoDoProdutoNaANP")
    protected String cProdANP;

    @XmlElement(name = "CODIF")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("codigoDeAutorizacaoOuRegistroDoCODIF")
    @FluidDataType(BigInteger.class)
    protected String codif;

    @FluidName("quantidadeDeCombustivelFaturadaNaTemperaturaAmbiente")
    @FluidDataType(BigDecimal.class)
    protected String qTemp;

    @XmlElement(name = "CIDE")
    @FluidName("CIDE")
    protected CIDE cide;

    @XmlElement(name = "ICMSComb", required = true)
    @FluidName("ICMS")
    protected ICMSComb icmsComb;

    @XmlElement(name = "ICMSInter")
    @FluidName("ICMSSobreOperacoesInterestaduais")
    protected ICMSInter icmsInter;

    @XmlElement(name = "ICMSCons")
    @FluidName("ICMSSobreConsumo")
    protected ICMSCons icmsCons;

    public String getCProdANP() {
        return cProdANP;
    }

    public void setCProdANP(final String value) {
        cProdANP = value;
    }

    public String getCODIF() {
        return codif;
    }

    public void setCODIF(final String value) {
        codif = value;
    }

    public String getQTemp() {
        return qTemp;
    }

    public void setQTemp(final String value) {
        qTemp = value;
    }

    public CIDE getCIDE() {
        return cide;
    }

    public void setCIDE(final CIDE value) {
        cide = value;
    }

    public ICMSComb getICMSComb() {
        return icmsComb;
    }

    public void setICMSComb(final ICMSComb value) {
        icmsComb = value;
    }

    public ICMSInter getICMSInter() {
        return icmsInter;
    }

    public void setICMSInter(final ICMSInter value) {
        icmsInter = value;
    }

    public ICMSCons getICMSCons() {
        return icmsCons;
    }

    public void setICMSCons(final ICMSCons value) {
        icmsCons = value;
    }

}