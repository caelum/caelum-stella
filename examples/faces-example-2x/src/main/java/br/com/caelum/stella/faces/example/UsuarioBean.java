package br.com.caelum.stella.faces.example;

/**
 * Managed bean que recebe o cpf do formulario
 * 
 * @author Fabio Kung
 * @author Leonardo Bessa
 */
public class UsuarioBean {

    private String cpf;

    private String cpfFormatado;

    private String cnpj;

    private String cnpjFormatado;

    private String nit;

    private String nitFormatado;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpfFormatado() {
        return cpfFormatado;
    }

    public void setCpfFormatado(String cpfFormatado) {
        this.cpfFormatado = cpfFormatado;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCnpjFormatado() {
        return cnpjFormatado;
    }

    public void setCnpjFormatado(String cnpjFormatado) {
        this.cnpjFormatado = cnpjFormatado;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNitFormatado() {
        return nitFormatado;
    }

    public void setNitFormatado(String nitFormatado) {
        this.nitFormatado = nitFormatado;
    }

}
