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
@XmlType(name = "ICMS70 ", propOrder = { "orig", "cst", "modBC", "pRedBC", "vbc", "picms", "vicms", "modBCST",
        "pmvast", "pRedBCST", "vbcst", "picmsst", "vicmsst" })
public class ICMS70 {

    @XmlElement(name = "orig", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String origem;

    @XmlElement(name = "CST", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String tipoTributacao;

    @XmlElement(name = "modBC", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String modalidade;

    @XmlElement(name = "pRedBC", required = true)
    protected String percentualReducaoBaseCalculo;

    @XmlElement(name = "vBC", required = true)
    protected String valorBaseCalculo;

    @XmlElement(name = "pICMS", required = true)
    protected String aliquota;

    @XmlElement(name = "vICMS", required = true)
    protected String valor;

    @XmlElement(name = "modBCST", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String modalidadeBaseCalculoSubstituicaoTributaria;

    @XmlElement(name = "pMVAST")
    protected String percentualAdicionadoSubstituicaoTributaria;

    @XmlElement(name = "pRedBCST")
    protected String percentualReducaoSubstituicaoTributaria;

    @XmlElement(name = "vBCST", required = true)
    protected String valorBaseCalculoSubstituicaoTributaria;

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

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(final String value) {
        modalidade = value;
    }

    public String getPercentualReducaoBaseCalculo() {
        return percentualReducaoBaseCalculo;
    }

    public void setPercentualReducaoBaseCalculo(final String value) {
        percentualReducaoBaseCalculo = value;
    }

    public String getVBC() {
        return valorBaseCalculo;
    }

    public void setVBC(final String value) {
        valorBaseCalculo = value;
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

    public String getModalidadeBaseCalculoSubstituicaoTributaria() {
        return modalidadeBaseCalculoSubstituicaoTributaria;
    }

    public void setModalidadeBaseCalculoSubstituicaoTributaria(final String value) {
        modalidadeBaseCalculoSubstituicaoTributaria = value;
    }

    public String getPMVAST() {
        return percentualAdicionadoSubstituicaoTributaria;
    }

    public void setPMVAST(final String value) {
        percentualAdicionadoSubstituicaoTributaria = value;
    }

    public String getPercentualReducaoSubstituicaoTributaria() {
        return percentualReducaoSubstituicaoTributaria;
    }

    public void setPercentualReducaoSubstituicaoTributaria(final String value) {
        percentualReducaoSubstituicaoTributaria = value;
    }

    public String getVBCST() {
        return valorBaseCalculoSubstituicaoTributaria;
    }

    public void setVBCST(final String value) {
        valorBaseCalculoSubstituicaoTributaria = value;
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

    public void setTipoTributacao(final String tipoTributacao) {
        this.tipoTributacao = tipoTributacao;
    }

    public String getValorBaseCalculo() {
        return valorBaseCalculo;
    }

    public void setValorBaseCalculo(final String valorBaseCalculo) {
        this.valorBaseCalculo = valorBaseCalculo;
    }

    public String getAliquota() {
        return aliquota;
    }

    public void setAliquota(final String aliquota) {
        this.aliquota = aliquota;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(final String valor) {
        this.valor = valor;
    }

    public String getPercentualAdicionadoSubstituicaoTributaria() {
        return percentualAdicionadoSubstituicaoTributaria;
    }

    public void setPercentualAdicionadoSubstituicaoTributaria(final String percentualAdicionadoSubstituicaoTributaria) {
        this.percentualAdicionadoSubstituicaoTributaria = percentualAdicionadoSubstituicaoTributaria;
    }

    public String getValorBaseCalculoSubstituicaoTributaria() {
        return valorBaseCalculoSubstituicaoTributaria;
    }

    public void setValorBaseCalculoSubstituicaoTributaria(final String valorBaseCalculoSubstituicaoTributaria) {
        this.valorBaseCalculoSubstituicaoTributaria = valorBaseCalculoSubstituicaoTributaria;
    }

    public String getAliquotaSubstituicaoTributaria() {
        return aliquotaSubstituicaoTributaria;
    }

    public void setAliquotaSubstituicaoTributaria(final String aliquotaSubstituicaoTributaria) {
        this.aliquotaSubstituicaoTributaria = aliquotaSubstituicaoTributaria;
    }

    public String getValorSubstituicaoTributaria() {
        return valorSubstituicaoTributaria;
    }

    public void setValorSubstituicaoTributaria(final String valorSubstituicaoTributaria) {
        this.valorSubstituicaoTributaria = valorSubstituicaoTributaria;
    }

}