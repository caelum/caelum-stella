package br.com.caelum.stella.tinytype;

import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.validation.CPFValidator;

/**
 * Representa um Cadastro de Pessoas Física - CPF.
 *
 * @author leobessa
 *
 */
public final class CPF {

    private final String numero;
	private final String numeroFormatado;

    /**
     * @param número do CPF.
     */
    public CPF(String numero) {
    	CPFFormatter formatter = new CPFFormatter();
		if (formatter.isFormatted(numero)) {
			this.numero = formatter.unformat(numero);
			this.numeroFormatado = numero;
		} else if (formatter.canBeFormatted(numero)) {
			this.numero = numero;
			this.numeroFormatado = formatter.format(numero);
		} else {
			this.numero = this.numeroFormatado = numero;
		}
    }

    /**
     * @return número do CPF.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @return número do CPF formatado.
     */
    public String getNumeroFormatado() {
    	return numeroFormatado;
    }

    /**
     * @return se o número do CPF é valido.
     */
	public boolean isValido() {
		return new CPFValidator().invalidMessagesFor(numero).isEmpty();
	}

    /**
     * @return número do CPF formatado.
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
        if (this == obj) {
			return true;
		}
        if (obj == null) {
			return false;
		}
        if (getClass() != obj.getClass()) {
			return false;
		}
        final CPF other = (CPF) obj;
        if (numero == null) {
            if (other.numero != null) {
				return false;
			}
        } else if (!numero.equals(other.numero)) {
			return false;
		}
        return true;
    }

}
