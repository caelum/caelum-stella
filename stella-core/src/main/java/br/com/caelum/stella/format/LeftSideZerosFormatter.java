package br.com.caelum.stella.format;

/**
 * Formatador que insere ou remove zeros a esquerda de um String que <b>deve</b>
 * representar um numero decimal.
 * 
 * @author Leonardo Bessa
 * 
 */
public class LeftSideZerosFormatter implements Formatter {

    /**
     * Tamanaho da cadeia a ser retornada quando se chama o metodo
     * {@link #format(String)}
     */
    private final int formatedLength;

    /**
     * @param formatedLength
     *            tamanaho da cadeia a ser retornada quando se chama o metodo
     *            {@link #format(String)}
     */
    public LeftSideZerosFormatter(int formatedLength) {
        super();
        this.formatedLength = formatedLength;
    }

    public String format(String value) {
        boolean matches = value.matches("\\d{0," + formatedLength + "}");
        if (!matches) {
            throw new IllegalArgumentException("Argument value must have only " + formatedLength + " digits at most.");
        }
        String formated = value;
        while (formated.length() < formatedLength) {
            formated = "0" + formated;
        }
        return formated;
    }

    public String unformat(String value) {
        Integer integer = Integer.valueOf(value);
        String formated = integer.toString();
        return formated;
    }

}
