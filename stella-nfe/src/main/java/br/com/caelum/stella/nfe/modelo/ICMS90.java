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
@XmlType(name = "ICMS90 ", propOrder = { "orig", "cst", "modBC", "vbc", "pRedBC", "picms", "vicms", "modBCST",
        "pmvast", "pRedBCST", "vbcst", "picmsst", "vicmsst" })
public class ICMS90 {

    @XmlElement(name = "orig", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String origem;

    @XmlElement(name = "CST", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String tipoTributacao;

    @XmlElement(name = "modBC")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String modalidade;

    @XmlElement(name = "vBC")
    protected String valorBaseCalculo;

    @XmlElement(name = "pRedBC")
    protected String percentualReducaoBaseCalculo;

    @XmlElement(name = "pICMS")
    protected String aliquota;

    @XmlElement(name = "vICMS")
    protected String valor;

    @XmlElement(name = "modBCST")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String modalidadeSubstituicaoTributaria;

    @XmlElement(name = "pMVAST")
    protected String percentualAdicionadoSubstituicaoTributaria;

    @XmlElement(name = "pRedBCST")
    protected String percentualReducaoSubstituicaoTributaria;

    @XmlElement(name = "vBCST")
    protected String valorBaseCalculoSubstituicaoTributaria;

    @XmlElement(name = "pICMSST")
    protected String aliquotaSubstituicaoTributaria;

    @XmlElement(name = "vICMSST")
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

    public String getVBC() {
        return valorBaseCalculo;
    }

    public void setVBC(final String value) {
        valorBaseCalculo = value;
    }

    public String getPercentualReducaoBaseCalculo() {
        return percentualReducaoBaseCalculo;
    }

    public void setPercentualReducaoBaseCalculo(final String value) {
        percentualReducaoBaseCalculo = value;
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

}