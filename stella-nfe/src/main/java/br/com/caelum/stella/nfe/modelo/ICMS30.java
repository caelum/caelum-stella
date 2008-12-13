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
@XmlType(name = "ICMS30 ", propOrder = { "orig", "cst", "modBCST", "pmvast", "pRedBCST", "vbcst", "picmsst", "vicmsst" })
public class ICMS30 {

    @XmlElement(name = "orig", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String origem;

    @XmlElement(name = "CST", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String tipoTributacao;

    @XmlElement(name = "modBCST", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String modalidadeSubstituicaoTributaria;

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