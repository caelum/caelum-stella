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
@XmlType(name = "RetTransp ", propOrder = { "vServ", "vbcRet", "picmsRet", "vicmsRet", "cfop", "cMunFG" })
@FluidName("ICMSRetidoPeloTransporte")
public class RetTransp {

    @XmlElement(required = true)
    @FluidName("valorDoServico")
    @FluidDataType(BigDecimal.class)
    protected String vServ;

    @XmlElement(name = "vBCRet", required = true)
    @FluidName("valorDaBaseDeCalculoDeRetencaoDoICMS")
    @FluidDataType(BigDecimal.class)
    protected String vbcRet;

    @XmlElement(name = "pICMSRet", required = true)
    @FluidName("aliquotaDaRetencaoDoICMS")
    @FluidDataType(BigDecimal.class)
    protected String picmsRet;

    @XmlElement(name = "vICMSRet", required = true)
    @FluidName("valorDoICMSRetido")
    @FluidDataType(BigDecimal.class)
    protected String vicmsRet;

    @XmlElement(name = "CFOP", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("codigoFiscalDeOperacoesEPrestacoes")
    protected String cfop;

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @FluidName("codigoDoMunicipio")
    protected String cMunFG;

    public String getVServ() {
        return vServ;
    }

    public void setVServ(final String value) {
        vServ = value;
    }

    public String getVBCRet() {
        return vbcRet;
    }

    public void setVBCRet(final String value) {
        vbcRet = value;
    }

    public String getPICMSRet() {
        return picmsRet;
    }

    public void setPICMSRet(final String value) {
        picmsRet = value;
    }

    public String getVICMSRet() {
        return vicmsRet;
    }

    public void setVICMSRet(final String value) {
        vicmsRet = value;
    }

    public String getCFOP() {
        return cfop;
    }

    public void setCFOP(final String value) {
        cfop = value;
    }

    public String getCMunFG() {
        return cMunFG;
    }

    public void setCMunFG(final String value) {
        cMunFG = value;
    }

}