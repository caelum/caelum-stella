package br.com.caelum.stella.boleto;

/**
 * Interface com métodos do sacado
 * 
 * @author caue
 *
 */
public interface Sacado {
	
	/**
	 * Devolve o nome do sacado
	 * 
	 * @return
	 */
	public String getNome();
	
	/**
	 * Devolve o CPF do sacado
	 * 
	 * @return
	 */
	public String getCpf();
	
	/**
	 * Devolve o endereço do sacado
	 * 
	 * @return
	 */
	public String getEndereco();
	
	/**
	 * Devolve o CEP do sacado
	 * 
	 * @return
	 */
	public String getCep();
	
	/**
	 * Devolve o bairro do sacado
	 * 
	 * @return
	 */
	public String getBairro();
	
	/**
	 * Devolve a cidade do sacado
	 * 
	 * @return
	 */
	public String getCidade();
	
	/**
	 * Devolve o UF do sacado
	 * 
	 * @return
	 */
	public String getUf();
}
