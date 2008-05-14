package br.com.caelum.stella.boleto;

/**
 * Interface com métodos do sacado<br/> Sacado é a pessoa/empresa que irá pagar
 * pelo boleto gerado
 * 
 * @author Cauê Guerra
 * 
 */
public interface Sacado {

	public String getNome();

	public String getCpf();

	public String getEndereco();

	public String getCep();

	public String getBairro();

	public String getCidade();

	public String getUf();
}
