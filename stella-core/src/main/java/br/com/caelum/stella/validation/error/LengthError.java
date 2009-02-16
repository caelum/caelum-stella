package br.com.caelum.stella.validation.error;

import br.com.caelum.stella.validation.InvalidValue;

/**
 * Representa possíveis erros na validação do tamanho de dígitos.
 * 
 * @author Leonardo Bessa
 */
public class LengthError implements InvalidValue {

    private final int validLength;

    /**
     * @param validLength
     *            tamanho esperado para considerar válida a cadeia.
     */
    public LengthError(int validLength) {
        this.validLength = validLength;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + validLength;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        LengthError other = (LengthError) obj;
        if (validLength != other.validLength) {
            return false;
        }
        return true;
    }

    /**
     * @return tamanho esperado para considerar válida a cadeia.
     */
    public int getValidLength() {
        return validLength;
    }

    public String name() {
        return "INVALID_LENGTH";
    }


}
