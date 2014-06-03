package br.com.caelum.stella.boleto;

import java.io.Serializable;

/**
 * Interface com métodos do pagador<br/> Pagador é a pessoa/empresa que vai pagar
 * pelo boleto gerado.
 * 
 */
public class Pagador implements Serializable {

	private static final long serialVersionUID = 1L;

    private String nome = "";
    private String cpf = "";
    private Endereco endereco = Endereco.novoEndereco();

    private Pagador() {
    }

    /**
     * Cria um novo pagador
     * 
     * @return
     */
    public static Pagador novoPagador() {
        return new Pagador();
    }

    /**
     * Devolve o nome do pagador
     * 
     * @return
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Associa um nome ao pagador
     * 
     * @param nome
     * @return
     */
    public Pagador comNome(String nome) {
        this.nome = nome;
        return this;
    }

    /**
     * Devolve o CPF do pagador
     * 
     * @return
     */
    public String getCpf() {
        return this.cpf;
    }

    /**
     * Associa um CPF ao pagador
     * 
     * @param cpf
     * @return
     */
    public Pagador comCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    /**
     * Devolve o endereço do pagador
     * 
     * @return
     */
    public Endereco getEndereco() {
        return this.endereco;
    }

    /**
     * Associa um endereço ao pagador
     * 
     * @param endereco
     * @return
     */
    public Pagador comEndereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }
}
