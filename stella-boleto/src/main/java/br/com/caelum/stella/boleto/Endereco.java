package br.com.caelum.stella.boleto;

import java.io.Serializable;

import static br.com.caelum.stella.boleto.utils.StellaStringUtils.suffixNotNullStringOrDefault;

/**
 * Dados do endereço
 * 
 * @author Mario Amaral <a href="github.com/mariofts">Github</a>
 *
 */
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	private String logradouro;
	private String bairro;
	private String cep;
	private String cidade;
	private String uf;

	private Endereco() {
	}

	public Endereco(String logradouro, String bairro, String cep, String cidade, String uf) {
		super();
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.uf = uf;
	}
	
	/**
	 * <p>Retorna o endereço completo no formato:</p>
	 * <p> <b>logradouro</b>, <b>bairro</b> <b>cep</b> - <b>cidade</b> - <b>uf</b>
	 * 
	 * @return endereço formatado
	 */
	public String getEnderecoCompleto(){
		return (suffixNotNullStringOrDefault(logradouro, "", ", "))
				+ (suffixNotNullStringOrDefault(bairro, "", " "))
				+ (suffixNotNullStringOrDefault(cep, "", " - "))
				+ (suffixNotNullStringOrDefault(cidade, "", " - "))
				+ (suffixNotNullStringOrDefault(uf, "", ""));  
	}
	
	/**
	 * Imprime o endereço no formado do {@link #getEnderecoCompleto()}
	 * 
	 * @see Object#toString()
	 * @see #getEnderecoCompleto()
	 * @return endereço completo
	 */
	@Override
	public String toString() {
		return this.getEnderecoCompleto();
	}

	/**
	 * Cria um novo endereço
	 * 
	 * @return this
	 */
	public static Endereco novoEndereco() {
		return new Endereco();
	}

	/**
	 * Logradouro (rua, numero e complemento) do endereço
	 * 
	 * @return logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * Define logradouro 
	 * 
	 * @param logradouro logradouro do pagador
	 * @return this
	 */
	public Endereco comLogradouro(String logradouro) {
		this.logradouro = logradouro;
		return this;
	}

	/**
	 * Bairro
	 * 
	 * @return bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * Define o bairro
	 * 
	 * @param bairro bairro
	 * @return this
	 */
	public Endereco comBairro(String bairro) {
		this.bairro = bairro;
		return this;
	}

	/**
	 * CEP
	 * 
	 * @return cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * Define o CEP
	 * 
	 * @param cep CEP
	 * @return this
	 */
	public Endereco comCep(String cep) {
		this.cep = cep;
		return this;
	}

	/**
	 * Cidade
	 * 
	 * @return cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * Define cidade
	 * 
	 * @param cidade cidade
	 * @return this
	 */
	public Endereco comCidade(String cidade) {
		this.cidade = cidade;
		return this;
	}

	/**
	 * UF (Estado)
	 * 
	 * @return Estado
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * Define UF(Estado)
	 * 
	 * @param uf Estado
	 * @return this
	 */
	public Endereco comUf(String uf) {
		this.uf = uf;
		return this;
	}

}
