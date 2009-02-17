/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ICMS10 ", propOrder = { "orig", "cst", "modBC", "vbc", "picms", "vicms", "modBCST", "pmvast",
        "pRedBCST", "vbcst", "picmsst", "vicmsst" })
public class ICMS10 {

    @XmlElement(name = "orig", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String origem;

    @XmlElement(name = "CST", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String tipoTributacao;

    @XmlElement(name = "modBC", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String modalidadeBaseCalculo;

    @XmlElement(name = "vBC", required = true)
    protected String valorDaBaseDeCalculo;

    @XmlElement(name = "pICMS", required = true)
    protected String aliquota;

    @XmlElement(name = "vICMS", required = true)
    protected String valor;

    @XmlElement(name = "modBCST", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String modalidadeSubstituicaoTributaria;

    @XmlElement(name = "pMVAST")
    protected String percentualAdicionadoSubstituicaoTributaria;

    @XmlElement(name = "pRedBCST")
    protected String percentualReducaoBaseCalculo;

    @XmlElement(name = "vBCST", required = true)
    protected String valorDaBaseDeCalculoSubstituicaoTributaria;

    @XmlElement(name = "pICMSST", required = true)
    protected String aliquotaSubstituicaoTributaria;

    @XmlElement(name = "vICMSST", required = true)
    protected String valorSubstituicaoTributaria;

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(final String value) {
        origem = value;
    }

    public String getCST() {
        return tipoTributacao;
    }

    public void setCST(final String value) {
        tipoTributacao = value;
    }

    public String getModalidadeBaseCalculo() {
        return modalidadeBaseCalculo;
    }

    public void setModalidadeBaseCalculo(final String value) {
        modalidadeBaseCalculo = value;
    }

    public String getVBC() {
        return valorDaBaseDeCalculo;
    }

    public void setVBC(final String value) {
        valorDaBaseDeCalculo = value;
    }

    public String getPICMS() {
        return aliquota;
    }

    public void setPICMS(final String value) {
        aliquota = value;
    }

    public String getVICMS() {
        return valor;
    }

    public void setVICMS(final String value) {
        valor = value;
    }

    public String getModalidadeSubstituicaoTributaria() {
        return modalidadeSubstituicaoTributaria;
    }

    public void setModalidadeSubstituicaoTributaria(final String value) {
        modalidadeSubstituicaoTributaria = value;
    }

    public String getPMVAST() {
        return percentualAdicionadoSubstituicaoTributaria;
    }

    public void setPMVAST(final String value) {
        percentualAdicionadoSubstituicaoTributaria = value;
    }

    public String getPercentualReducaoBaseCalculo() {
        return percentualReducaoBaseCalculo;
    }

    public void setPercentualReducaoBaseCalculo(final String value) {
        percentualReducaoBaseCalculo = value;
    }

    public String getVBCST() {
        return valorDaBaseDeCalculoSubstituicaoTributaria;
    }

    public void setVBCST(final String value) {
        valorDaBaseDeCalculoSubstituicaoTributaria = value;
    }

    public String getPICMSST() {
        return aliquotaSubstituicaoTributaria;
    }

    public void setPICMSST(final String value) {
        aliquotaSubstituicaoTributaria = value;
    }

    public String getVICMSST() {
        return valorSubstituicaoTributaria;
    }

    public void setVICMSST(final String value) {
        valorSubstituicaoTributaria = value;
    }

    public String getTipoTributacao() {
        return tipoTributacao;
    }

    public void setTipoTributacao(final String cst) {
        this.tipoTributacao = cst;
    }

    public String getvalorDaBaseDeCalculo() {
        return valorDaBaseDeCalculo;
    }

    public void setvalorDaBaseDeCalculo(final String vbc) {
        this.valorDaBaseDeCalculo = vbc;
    }

    public String getAliquota() {
        return aliquota;
    }

    public void setAliquota(final String picms) {
        this.aliquota = picms;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(final String vicms) {
        this.valor = vicms;
    }

    public String getPercentualAdicionadoSubstituicaoTributaria() {
        return percentualAdicionadoSubstituicaoTributaria;
    }

    public void setPercentualAdicionadoSubstituicaoTributaria(final String pmvast) {
        this.percentualAdicionadoSubstituicaoTributaria = pmvast;
    }

    public String getvalorDaBaseDeCalculoSubstituicaoTributaria() {
        return valorDaBaseDeCalculoSubstituicaoTributaria;
    }

    public void setvalorDaBaseDeCalculoSubstituicaoTributaria(final String vbcst) {
        this.valorDaBaseDeCalculoSubstituicaoTributaria = vbcst;
    }

    public String getAliquotaSubstituicaoTributaria() {
        return aliquotaSubstituicaoTributaria;
    }

    public void setAliquotaSubstituicaoTributaria(final String picmsst) {
        this.aliquotaSubstituicaoTributaria = picmsst;
    }

    public String getValorSubstituicaoTributaria() {
        return valorSubstituicaoTributaria;
    }

    public void setValorSubstituicaoTributaria(final String vicmsst) {
        this.valorSubstituicaoTributaria = vicmsst;
    }

}