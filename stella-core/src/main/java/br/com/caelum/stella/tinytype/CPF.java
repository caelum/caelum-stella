package br.com.caelum.stella.tinytype;

import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.validation.CPFValidator;

/**
 * Representa um Cadastro de Pessoas Física - CPF.
 *
 * @author leobessa
 */
public final class CPF {

    /**
     * Número do CPF. Possui apenas os caracteres numéricos.
     */
    private final String numero;

    /**
     * Número do CPF. No formato ddd.ddd.ddd-dd .
     */
    private final String numeroFormatado;

    /**
     * Constrói um CPF com o número especificado. Se o número contiver 
     * apenas caracteres numéricos ou estiver no formato ddd.ddd.ddd-dd, 
     * ele é guardado com e sem formatação nos respectivos atributos.
     * Caso contrário, ele guarda o parâmetro como passado em ambos os atributos.
     * 
     * @param numero número do CPF
     */
    public CPF(String numero) {
    	CPFFormatter formatador = new CPFFormatter();
		if (formatador.isFormatted(numero)) {
			this.numero = formatador.unformat(numero);
			this.numeroFormatado = numero;
		} else if (formatador.canBeFormatted(numero)) {
			this.numero = numero;
			this.numeroFormatado = formatador.format(numero);
		} else {
			this.numero = this.numeroFormatado = numero;
		}
    }

    /**
     * Retorna o número do CPF apenas com os caracteres numéricos.
     * 
     * @return número do CPF.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Retorna o número do CPF no formato ddd.ddd.ddd-dd .
     * 
     * @return número do CPF no formato ddd.ddd.ddd-dd .
     */
    public String getNumeroFormatado() {
    	return numeroFormatado;
    }

    /**
     * Retorna se o número do CPF é válido. O resultado é <code>true</code>
     * se os dígitos verificadores estão de acordo com a regra de cálculo.
     * 
     * @return se o número do CPF é valido.
     * 
     * @see CPFValidator
     */
	public boolean isValido() {
		return new CPFValidator().invalidMessagesFor(numero).isEmpty();
	}

    /**
     * Retorna uma representação em string desse CPF. A intenção desse método
     * é ser usado para impressão e retorna o número no formato ddd.ddd.ddd-dd .
     * 
     * @return número do CPF no formato ddd.ddd.ddd-dd.
     */
    @Override
    public String toString() {
        return getNumeroFormatado();
    }

    /**
     * Retorna um hash code para esse CPF.
     * 
     * @return um valor de hash code para esse objeto.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        return result;
    }

    /**
     * Compara esse <code>CPF</code> ao <code>Object</code> 
     * especificado.  O resultado é <code>true</code> se e só se
     * o argumento é um objeto <code>CPF</code> com o mesmo número.
     * 
     * @param obj o objeto a ser comparado
     * @return <code>true</code> se esse objeto é igual a <code>obj</code>;
     * <code>false</code> caso contrário.
     */
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
