package br.com.caelum.stella.inwords;

/**
 * Representa o formato utilizado para os números serem transformados em
 * extenso.
 * 
 * @author Victor dos Santos Pereira
 * @author Leonardo Bessa
 * 
 */
public interface FormatoDeExtenso {

    /**
     * @return A unidade no singular da parte inteira do número .
     */
    String getUnidadeInteiraNoSingular();

    /**
     * @return A unidade no plural da parte inteira do número.
     */
    String getUnidadeInteiraNoPlural();

    /**
     * @return A unidade no singular da parte decimal do número.
     */
    String getUnidadeDecimalNoSingular();

    /**
     * @return A unidade no plural da parte decimal do número.
     */
    String getUnidadeDecimalNoPlural();

    /**
     * @return A quantidade de casas decimais a serem consideradas na
     *         transfomação em extenso.
     */
    int getCasasDecimais();

}
