package br.com.caelum.stella.format;

import br.com.caelum.stella.annotations.GwtCompatible;

/**
 * Formatter é responsável por transfomar cadeias sem formatação em cadeias
 * formatadas e vice-versa.
 * 
 * @author Leonardo Bessa
 */
@GwtCompatible
public interface Formatter {

    /**
     * <p>
     * Formata uma cadeia.
     * </p>
     * 
     * @param value
     *            cadeia sem formatado
     * @return cadeia formatada
     * @throws IllegalArgumentException
     *             caso argumento seja nulo ou não represente propriamente um
     *             valor sem formato.
     */
    public abstract String format(String value) throws IllegalArgumentException;

    /**
     * <p>
     * Remove a formatação de uma cadeia.
     * </p>
     * 
     * @param value
     *            cadeia formatada
     * @return cadeia sem formato
     * @throws IllegalArgumentException
     *             caso argumento seja nulo ou não represente propriamente um
     *             valor formatado.
     */
    public abstract String unformat(String value) throws IllegalArgumentException;

}