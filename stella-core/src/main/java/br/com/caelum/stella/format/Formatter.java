package br.com.caelum.stella.format;

/**
 * Formatter é responsável por transfomar cadeias sem formatação em cadeias
 * formatadas e vice-versa.
 * 
 * @author Leonardo Bessa
 */
public interface Formatter {

    /**
     * Formata uma cadeia.
     * <p>
     * Será lançada {@linkplain IllegalArgumentException} caso receba
     * <code>null</code> como parâmetro.
     * </p>
     * 
     * @param value
     *                cadeia sem formatado
     * @return cadeia formatada
     */
    public abstract String format(String value);

    /**
     * Remove a formatação de uma cadeia.
     * <p>
     * Será lançada {@linkplain IllegalArgumentException} caso receba
     * <code>null</code> como parâmetro.
     * </p>
     * 
     * @param cadeia
     *                formatada
     * @return cadeia sem formato
     */
    public abstract String unformat(String value);

}