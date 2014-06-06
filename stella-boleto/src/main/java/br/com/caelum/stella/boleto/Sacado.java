package br.com.caelum.stella.boleto;

import java.io.Serializable;

/**
 * Interface com métodos do sacado<br> Sacado é a pessoa/empresa que vai pagar
 * pelo boleto gerado.
 * 
 * @author Cauê Guerra
 * @deprecated
 */
@Deprecated
public class Sacado implements Serializable {

	private static final long serialVersionUID = 1L;

    private String nome = "";
    private String cpf = "";
    private String endereco = "";
    private String cep = "";
    private String bairro = "";
    private String cidade = "";
    private String uf = "";

    private Sacado() {
    }

    /**
     * Cria um novo sacado
     * 
     * @return novo sacado
     */
    public static Sacado novoSacado() {
        return new Sacado();
    }

    /**
     * Devolve o nome do sacado
     * 
     * @return nome do pagador
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Associa um nome ao pagador
     * 
     * @param nome nome do pagador
     * @return this
     */
    public Sacado comNome(String nome) {
        this.nome = nome;
        return this;
    }

    /**
     * Devolve o CPF do sacado
     * 
     * @return cpf
     */
    public String getCpf() {
        return this.cpf;
    }

    /**
     * Associa um CPF ao sacado
     * 
     * @param cpf cpf do pagador
     * @return this
     */
    public Sacado comCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    /**
     * Devolve o endereço do sacado
     * 
     * @return logradouro
     */
    public String getEndereco() {
        return this.endereco;
    }

    /**
     * Associa um endereço ao sacado
     * 
     * @param endereco endereco do pagador
     * @return this
     */
    public Sacado comEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    /**
     * Devolve o CEP do sacado
     * 
     * @return cep
     */
    public String getCep() {
        return this.cep;
    }

    /**
     * Associa o CEP ao sacado
     * 
     * @param cep cep do pagador
     * @return this
     */
    public Sacado comCep(String cep) {
        this.cep = cep;
        return this;
    }

    /**
     * Devolve o bairro do sacado
     * 
     * @return bairro
     */
    public String getBairro() {
        return this.bairro;
    }

    /**
     * Associa o bairro ao sacado
     * 
     * @param bairro bairro do pagador
     * @return this
     */
    public Sacado comBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    /**
     * Devolve a cidade do sacado
     * 
     * @return cidade do pagador
     */
    public String getCidade() {
        return this.cidade;
    }

    /**
     * Associa uma cidade ao sacado
     * 
     * @param cidade cidade do pagador
     * @return this
     */
    public Sacado comCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    /**
     * Devolve a UF do sacado
     * 
     * @return estado estado do pagador
     */
    public String getUf() {
        return this.uf;
    }

    /**
     * Associa uma UF ao sacado
     * 
     * @param uf estado do pagador
     * @return this
     */
    public Sacado comUf(String uf) {
        this.uf = uf;
		return this;
	}
}
