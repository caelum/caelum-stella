/**
 * 
 */
package br.com.caelum.stella.nfe.modelo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "II ", propOrder = { "vbc", "vDespAdu", "vii", "viof" })
public class II {

    @XmlElement(name = "vBC", required = true)
    protected String valorBaseCalculo;

    @XmlElement(required = true, name = "vDespAdu")
    protected String valorDespesaAduaneira;

    @XmlElement(name = "vII", required = true)
    protected String valorImpostoImportacao;

    @XmlElement(name = "vIOF", required = true)
    protected String valorImpostoSobreOperacoesFinanceiras;

    public String getValorBaseCalculo() {
        return valorBaseCalculo;
    }

    public void setValorBaseCalculo(String valorBaseCalculo) {
        this.valorBaseCalculo = valorBaseCalculo;
    }

    public String getValorDespesaAduaneira() {
        return valorDespesaAduaneira;
    }

    public void setValorDespesaAduaneira(String valorDespesaAduaneira) {
        this.valorDespesaAduaneira = valorDespesaAduaneira;
    }

    public String getValorImpostoImportacao() {
        return valorImpostoImportacao;
    }

    public void setValorImpostoImportacao(String valorImpostoImportacao) {
        this.valorImpostoImportacao = valorImpostoImportacao;
    }

    public String getValorImpostoSobreOperacoesFinanceiras() {
        return valorImpostoSobreOperacoesFinanceiras;
    }

    public void setValorImpostoSobreOperacoesFinanceiras(String valorImpostoSobreOperacoesFinanceiras) {
        this.valorImpostoSobreOperacoesFinanceiras = valorImpostoSobreOperacoesFinanceiras;
    }

}