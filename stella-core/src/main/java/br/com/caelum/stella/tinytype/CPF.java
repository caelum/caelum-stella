package br.com.caelum.stella.tinytype;

import br.com.caelum.stella.constraint.CPFConstraints;
import br.com.caelum.stella.format.CPFFormatter;

/**
 * Representa um CPF (Cadastro de Pessoas Física).
 * 
 * @author leobessa
 *
 */
public final class CPF {

    private final String number;

    /**
     * @param numero do CPF
     * @throws IllegalArgumentException caso o número não possa representar um CPF.
     */
    public CPF(String numero) throws IllegalArgumentException{
        if (CPFConstraints.FORMATED.matcher(numero).matches()) {
            this.number = numero;
        } else if (CPFConstraints.UNFORMATED.matcher(numero).matches()) {
            this.number = (new CPFFormatter()).format(numero);
        } else {
            throw new IllegalArgumentException("A cadeia não pode representar um CPF.");
        }
    }
    
    /**
     * @return número do CPF formatado.
     */
    public String getNumero() {
        return number;
    }
    /**
     * @return número do CPF formatado.
     */
    @Override
    public String toString() {
        return number;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((number == null) ? 0 : number.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final CPF other = (CPF) obj;
        if (number == null) {
            if (other.number != null)
                return false;
        } else if (!number.equals(other.number))
            return false;
        return true;
    }
    
}
