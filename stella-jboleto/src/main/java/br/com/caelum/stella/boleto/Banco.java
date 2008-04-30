package br.com.caelum.stella.boleto;

public interface Banco {
    /**
     * Pega o codigo do banco
     */
	int getNumero();
	
	/**
	 * Pga codigo de barras para determinado boleto
	 */
	String getCodigoBarras(Boleto boleto);
	
    /**
     * Recupera a numeracao para a geracao da linha digitavel do boleto
     */
	String getLinhaDigitavel(Boleto boleto);
}
