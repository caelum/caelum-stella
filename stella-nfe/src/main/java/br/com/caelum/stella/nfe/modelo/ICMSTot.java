/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import net.vidageek.fluid.annotations.FluidDataType;
import net.vidageek.fluid.annotations.FluidName;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ICMSTot ", propOrder = { "vbc", "vicms", "vbcst", "vst", "vProd", "vFrete", "vSeg", "vDesc", "vii",
        "vipi", "vpis", "vcofins", "vOutro", "vnf" })
@FluidName("ICMSTotal")
public class ICMSTot {

    @XmlElement(name = "vBC", required = true)
    @FluidName("valorDaBaseDeCalculo")
    @FluidDataType(BigDecimal.class)
    protected String vbc;

    @XmlElement(name = "vICMS", required = true)
    @FluidName("valorTotal")
    @FluidDataType(BigDecimal.class)
    protected String vicms;

    @XmlElement(name = "vBCST", required = true)
    @FluidName("valorDaBaseDeCalculoDoICMSSubstituicaoTributaria")
    @FluidDataType(BigDecimal.class)
    protected String vbcst;

    @XmlElement(name = "vST", required = true)
    @FluidName("valorTotalDoICMSSubstituicaoTributaria")
    @FluidDataType(BigDecimal.class)
    protected String vst;

    @XmlElement(required = true)
    @FluidName("valorTotalDosProdutosEServicos")
    @FluidDataType(BigDecimal.class)
    protected String vProd;

    @XmlElement(required = true)
    @FluidName("valorTotalDoFrete")
    @FluidDataType(BigDecimal.class)
    protected String vFrete;

    @XmlElement(required = true)
    @FluidName("valorTotalDoSeguro")
    @FluidDataType(BigDecimal.class)
    protected String vSeg;

    @XmlElement(required = true)
    @FluidName("valorTotalDeDesconto")
    @FluidDataType(BigDecimal.class)
    protected String vDesc;

    @XmlElement(name = "vII", required = true)
    @FluidName("valorTotalDoII")
    @FluidDataType(BigDecimal.class)
    protected String vii;

    @XmlElement(name = "vIPI", required = true)
    @FluidName("valorTotalDoIPI")
    @FluidDataType(BigDecimal.class)
    protected String vipi;

    @XmlElement(name = "vPIS", required = true)
    @FluidName("valorTotalDoPIS")
    @FluidDataType(BigDecimal.class)
    protected String vpis;

    @XmlElement(name = "vCOFINS", required = true)
    @FluidName("valor")
    @FluidDataType(BigDecimal.class)
    protected String vcofins;

    @XmlElement(required = true)
    @FluidName("valorTotalDeOutrasDespesas")
    @FluidDataType(BigDecimal.class)
    protected String vOutro;

    @XmlElement(name = "vNF", required = true)
    @FluidName("valorTotalDaNF")
    @FluidDataType(BigDecimal.class)
    protected String vnf;

    public String getVBC() {
        return vbc;
    }

    public void setVBC(final String value) {
        vbc = value;
    }

    public String getVICMS() {
        return vicms;
    }

    public void setVICMS(final String value) {
        vicms = value;
    }

    public String getVBCST() {
        return vbcst;
    }

    public void setVBCST(final String value) {
        vbcst = value;
    }

    public String getVST() {
        return vst;
    }

    public void setVST(final String value) {
        vst = value;
    }

    public String getVProd() {
        return vProd;
    }

    public void setVProd(final String value) {
        vProd = value;
    }

    public String getVFrete() {
        return vFrete;
    }

    public void setVFrete(final String value) {
        vFrete = value;
    }

    public String getVSeg() {
        return vSeg;
    }

    public void setVSeg(final String value) {
        vSeg = value;
    }

    public String getVDesc() {
        return vDesc;
    }

    public void setVDesc(final String value) {
        vDesc = value;
    }

    public String getVII() {
        return vii;
    }

    public void setVII(final String value) {
        vii = value;
    }

    public String getVIPI() {
        return vipi;
    }

    public void setVIPI(final String value) {
        vipi = value;
    }

    public String getVPIS() {
        return vpis;
    }

    public void setVPIS(final String value) {
        vpis = value;
    }

    public String getVCOFINS() {
        return vcofins;
    }

    public void setVCOFINS(final String value) {
        vcofins = value;
    }

    public String getVOutro() {
        return vOutro;
    }

    public void setVOutro(final String value) {
        vOutro = value;
    }

    public String getVNF() {
        return vnf;
    }

    public void setVNF(final String value) {
        vnf = value;
    }

}