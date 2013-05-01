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
        return null;
    }

    public String getUnidadeDecimalNoSingular() {
        return null;
    }

    public String getUnidadeInteiraNoSingular() {
        return null;
    }

    public String getUnidadeInteiraNoPlural() {
        return null;
    }

    public int getCasasDecimais() {
        return 0;
    }

}
