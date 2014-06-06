package br.com.caelum.stella.boleto;

import java.io.Serializable;

/**
 * Pagador é a pessoa/empresa que vai pagar
 * pelo boleto gerado.
 * 
 * Antigamente este componente era chamado <b>Sacado</b>.
 * 
 */
public class Pagador implements Serializable {

	private static final long serialVersionUID = 1L;

    private String nome = "";
    private String documento = "";
    private Endereco endereco = Endereco.novoEndereco();

    private Pagador() {
    }

    /**
     * Cria um novo pagador
     * 
     * @return this
     */
    public static Pagador novoPagador() {
        return new Pagador();
    }

    /**
     * Devolve o nome do pagador
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
    public Pagador comNome(String nome) {
        this.nome = nome;
        return this;
    }

    /**
     * Devolve o CPF/CNPJ do pagador
     * 
     * @return this
     */
    public String getDocumento() {
        return this.documento;
    }

    /**
     * Associa um CPF/CNPJ ao pagador
     * 
     * @param documento do pagador
     * @return this
     */
    public Pagador comDocumento(String documento) {
        this.documento = documento;
        return this;
    }

    /**
     * Devolve o endereço do pagador
     * 
     * @return endereço do pagador
     */
    public Endereco getEndereco() {
        return this.endereco;
    }

    /**
     * Associa um endereço ao pagador
     * 
     * @param endereco do pagador
     * @return this
     */
    public Pagador comEndereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }
}
