package br.com.caelum.stella.boleto;

/**
 * Interface com métodos do sacado<br/> Sacado é a pessoa/empresa que vai pagar
 * pelo boleto gerado.
 * 
 * @author Cauê Guerra
 * 
 */
public class Sacado {
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
     * @return
     */
    public static Sacado novoSacado() {
        return new Sacado();
    }

    /**
     * Devolve o nome do sacado
     * 
     * @return
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Associa um nome ao sacado
     * 
     * @param nome
     * @return
     */
    public Sacado comNome(String nome) {
        this.nome = nome;
        return this;
    }

    /**
     * Devolve o CPF do sacado
     * 
     * @return
     */
    public String getCpf() {
        return this.cpf;
    }

    /**
     * Associa um CPF ao sacado
     * 
     * @param cpf
     * @return
     */
    public Sacado comCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    /**
     * Devolve o endereço do sacado
     * 
     * @return
     */
    public String getEndereco() {
        return this.endereco;
    }

    /**
     * Associa um endereço ao sacado
     * 
     * @param endereco
     * @return
     */
    public Sacado comEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    /**
     * Devolve o CEP do sacado
     * 
     * @return
     */
    public String getCep() {
        return this.cep;
    }

    /**
     * Associa o CEP ao sacado
     * 
     * @param cep
     * @return
     */
    public Sacado comCep(String cep) {
        this.cep = cep;
        return this;
    }

    /**
     * Devolve o bairro do sacado
     * 
     * @return
     */
    public String getBairro() {
        return this.bairro;
    }

    /**
     * Associa o bairro ao sacado
     * 
     * @param bairro
     * @return
     */
    public Sacado comBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    /**
     * Devolve a cidade do sacado
     * 
     * @return
     */
    public String getCidade() {
        return this.cidade;
    }

    /**
     * Associa uma cidade ao sacado
     * 
     * @param cidade
     * @return
     */
    public Sacado comCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    /**
     * Devolve a UF do sacado
     * 
     * @return
     */
    public String getUf() {
        return this.uf;
    }

    /**
     * Associa uma UF ao sacado
     * 
     * @param uf
     * @return
     */
    public Sacado comUf(String uf) {
        this.uf = uf;
		return this;
	}
}
