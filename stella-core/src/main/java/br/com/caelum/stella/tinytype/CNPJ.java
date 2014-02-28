package br.com.caelum.stella.tinytype;

import br.com.caelum.stella.format.CNPJFormatter;
import br.com.caelum.stella.validation.CNPJValidator;

/**
 * Representa um Cadastro Nacional da Pessoa Jurídica - CNPJ.
 *
 * @author leobessa
 */
public final class CNPJ {

    /**
     * Número do CNPJ. Possui apenas os caracteres numéricos.
     */
    private final String numero;

    /**
     * Número do CNPJ. No formato dd.ddd.ddd/dddd-dd .
     */
	private String numeroFormatado;

    /**
     * Constrói um CPF com o número especificado. Se o número contiver 
     * apenas caracteres numéricos ou estiver no formato dd.ddd.ddd/dddd-dd,
     * ele é guardado com e sem formatação nos respectivos atributos.
     * Caso contrário, ele guarda o parâmetro como passado em ambos os atributos.
     * 
     * @param numero número do CPF.
     */
    public CNPJ(String numero) {
    	CNPJFormatter formatador = new CNPJFormatter();
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
     * Retorna o número do CNPJ apenas com os caracteres numéricos.
     * 
     * @return número do CNPJ.
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Retorna o número do CNPJ no formato dd.ddd.ddd/dddd-dd .
     * 
     * @return número do CNPJ no formato dd.ddd.ddd/dddd-dd .
     */
    public String getNumeroFormatado() {
    	return numeroFormatado;
    }

    /**
     * Retorna se o número do CNPJ é válido. O resultado é <code>true</code>
     * se os dígitos verificadores estão de acordo com a regra de cálculo.
     * 
     * @return se o número do CNPJ é valido.
     * 
     * @see CNPJValidator
     */
    public boolean isValid() {
    	return new CNPJValidator().invalidMessagesFor(numero).isEmpty();
    }

    /**
     * Retorna uma representação em string desse CNPJ. A intenção desse método
     * é ser usado para impressão e retorna o número no formato dd.ddd.ddd/dddd-dd .
     * 
     * @return número do CNPJ no formato dd.ddd.ddd/dddd-dd .
     */
    @Override
    public String toString() {
    	return getNumeroFormatado();
    }

    /**
     * Retorna um hash code para esse CPNJ.
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
     * Compara esse <code>CNPJ</code> ao <code>Object</code> 
     * especificado.  O resultado é <code>true</code> se e só se
     * o argumento é um objeto <code>CNPJ</code> com o mesmo número.
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
        final CNPJ other = (CNPJ) obj;
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