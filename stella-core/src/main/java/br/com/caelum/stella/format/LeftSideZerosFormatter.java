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
    private final int formattedLength;

    /**
     * @param formattedLength
     *            tamanaho da cadeia a ser retornada quando se chama o metodo
     *            {@link #format(String)}
     */
    public LeftSideZerosFormatter(int formattedLength) {
        super();
        this.formattedLength = formattedLength;
    }

    @Override
	public String format(String value) {
        if (!canBeFormatted(value)) {
            throw new IllegalArgumentException("Argument value must have only " + formattedLength + " digits at most.");
        }
        String formated = value;
        while (formated.length() < formattedLength) {
            formated = "0" + formated;
        }
        return formated;
    }

    @Override
	public String unformat(String value) {
        Integer integer = Integer.valueOf(value);
        String formated = integer.toString();
        return formated;
    }

    @Override
    public boolean isFormatted(String value) {
    	return value.matches("\\d{" + formattedLength + "}");
    }

    @Override
    public boolean canBeFormatted(String value) {
    	return value.matches("\\d{0," + formattedLength + "}");
    }
}
