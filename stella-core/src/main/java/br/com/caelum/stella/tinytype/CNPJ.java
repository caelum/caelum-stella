package br.com.caelum.stella.tinytype;

import br.com.caelum.stella.format.CNPJFormatter;
import br.com.caelum.stella.validation.CNPJValidator;

/**
 * Representa um Cadastro Nacional da Pessoa Jurídica - CNPJ.
 * 
 * @author leobessa
 * 
 */
public final class CNPJ {

    private final String numero;

    /**
     * @param número do CNPJ.
     */
    public CNPJ(String numero) {
    	String numeroCnpj;
    	try {
    		numeroCnpj = new CNPJFormatter().unformat(numero);
		} catch (IllegalArgumentException e) {
			numeroCnpj = numero;
		}
    	this.numero = numeroCnpj;
    }

    /**
     * @return número do CNPJ.
     */
    public String getNumero() {
        return numero;
    }
    
    /**
     * @return número do CNPJ formatado.
     */
    public String getNumeroFormatado() {
    	return new CNPJFormatter().format(numero);
    }

    /**
     * @return se o número do CNPJ é valido.
     */
    public boolean isValid() {
    	return new CNPJValidator().invalidMessagesFor(numero).isEmpty();
    }
    
    /**
     * @return número do CNPJ formatado.
     */
    @Override
    public String toString() {
    	return getNumeroFormatado();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        return true;
    }

}
