package br.com.caelum.stella.tinytype;

import br.com.caelum.stella.constraint.CNPJConstraints;
import br.com.caelum.stella.format.CNPJFormatter;

/**
 * Representa um Cadastro Nacional da Pessoa Jurídica - CNPJ.
 * 
 * @author leobessa
 *
 */
public final class CNPJ {

    private final String number;

    /**
     * @param numero do CNPJ
     * @throws IllegalArgumentException caso o número não possa representar um CNPJ.
     */
    public CNPJ(String numero) throws IllegalArgumentException{
        if (CNPJConstraints.FORMATED.matcher(numero).matches()) {
            this.number = numero;
        } else if (CNPJConstraints.UNFORMATED.matcher(numero).matches()) {
            this.number = (new CNPJFormatter()).format(numero);
        } else {
            throw new IllegalArgumentException("A cadeia não pode representar um CNPJ.");
        }
    }
    
    /**
     * @return número do CNPJ formatado.
     */
    public String getNumero() {
        return number;
    }
    /**
     * @return número do CNPJ formatado.
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
        final CNPJ other = (CNPJ) obj;
        if (number == null) {
            if (other.number != null)
                return false;
        } else if (!number.equals(other.number))
            return false;
        return true;
    }
    
}
