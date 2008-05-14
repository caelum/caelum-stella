package br.com.caelum.stella.boleto;

public interface Emissor {

	/**
	 * Devolve o número da agencia sem o digito
	 * 
	 */
	String getAgencia();

	String getDvAgencia();

	/**
	 * Devolve o número da conta corrente sem o digito
	 * 
	 */
	String getContaCorrente();

	String getDvContaCorrente();

	/**
	 * Devolve a carteira<br/> Valor informado pelo banco para identificação do
	 * tipo de boleto
	 * 
	 */
	String getCarteira();

	/**
	 * Devolve o número do convênio<br/> Valor que identifica um emissor junto
	 * ao seu banco para associar seus boletos<br/> Valor informado pelo banco
	 * 
	 */
	String getNumConvenio();

	/**
	 * Devolve o nosso número<br/> Valor que o cedente escolhe para manter
	 * controle sobre seus boletos. Esse valor serve para o cedente identificar
	 * quais boletos foram pagos ou não. Recomenda-se o uso de números
	 * sequenciais, na geração de diversos boletos, para facilitar a
	 * identificação dos boletos pagos
	 * 
	 */
	String getNossoNumero();

	/**
	 * Devolve o cedente. (nome do emissor)
	 * 
	 */
	String getCedente();

	String getContaCorrenteFormatado();
}
