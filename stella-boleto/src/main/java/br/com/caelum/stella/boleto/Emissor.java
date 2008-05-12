package br.com.caelum.stella.boleto;

public interface Emissor {
	/**
	 * Numero da agencia sem o digito
	 */
	String getAgencia();

	/**
	 * Digito verificador da agencia
	 * @return
	 */
	String getDvAgencia();
	
	/**
	 * Numero da conta corrente sem o digito.
	 * @return
	 */
	String getContaCorrente();
	String getDvContaCorrente();
	String getCarteira();
	String getNumConvenio();
	String getNossoNumero();
	String getCedente();
	String getContaCorrenteFormatado();
}
