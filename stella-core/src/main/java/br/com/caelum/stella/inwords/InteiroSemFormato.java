package br.com.caelum.stella.inwords;

/**
 * Representa o formato para um número inteiro por extenso, sem tipo de unidade.
 * Ou seja, números são escritos simplesmente como "dois", "vinte e três" ou
 * "um mil quatrocentos e noventa e dois"
 * 
 * 
 * @author Leonardo Garcia Fischer
 * 
 */
public class InteiroSemFormato implements FormatoDeExtenso {

    public String getUnidadeDecimalNoPlural() {
        return "";
    }

    public String getUnidadeDecimalNoSingular() {
        return "";
    }

    public String getUnidadeInteiraNoSingular() {
        return "";
    }

    public String getUnidadeInteiraNoPlural() {
        return "";
    }

    public int getCasasDecimais() {
        return 1;
    }

}
