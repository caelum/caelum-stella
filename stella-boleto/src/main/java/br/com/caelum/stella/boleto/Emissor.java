package br.com.caelum.stella.boleto;

/**
 * Interface com métodos do emissor
 * 
 * @author caue
 *
 */
public interface Emissor {

	/**
	 * Devolve o número da agencia sem o digito
	 * 
	 * @return
	 */
	String getAgencia();

	/**
	 * Devolve o dígito verificador da agencia
	 * 
	 * @return
	 */
	String getDvAgencia();
	
	/**
	 * Devolve o número da conta corrente sem o digito
	 * 
	 * @return
	 */
	String getContaCorrente();
	
	/**
	 * Devolve o dígito verificador da conta corrente
	 * 
	 * @return
	 */
	String getDvContaCorrente();
	
	/**
	 * Devolve a carteira
	 * Valor informado pelo banco para identificação do tipo de boleto
	 * 
	 * @return
	 */
	String getCarteira();
	
	/**
	 * Devolve o número do convênio
	 * Valor que identifica um emissor junto ao seu banco para associar seus boletos
	 * Valor informado pelo banco
	 * 
	 * @return
	 */
	String getNumConvenio();
	
	/**
	 * Devolve o nosso número
	 * Valor que o cedente escolhe para manter controle sobre seus boletos. Esse valor serve
	 * para o cedente identificar quais boletos foram pagos ou não. Recomenda-se o uso de números
	 * sequenciais, na geração de diversos boletos, para facilitar a identificação dos boletos pagos
	 * 
	 * @return
	 */
	String getNossoNumero();
	
	/**
	 * Devolve o cedente. (nome do emissor)
	 * 
	 * @return
	 */
	String getCedente();
	
	/**
	 * Devolve a conta corrente formatada
	 * 
	 * @return
	 */
	String getContaCorrenteFormatado();
}
