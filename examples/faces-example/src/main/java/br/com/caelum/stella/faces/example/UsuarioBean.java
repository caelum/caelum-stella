package br.com.caelum.stella.faces.example;

/**
 * Managed bean que recebe o cpf do formulario
 *
 * @author Fabio Kung
 */
public class UsuarioBean {

    private String cpf;
    private String cpfFormatado;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        System.out.println("Mudando o cpf para: " + cpf);
        this.cpf = cpf;
    }

    public String getCpfFormatado() {
        return cpfFormatado;
    }

    public void setCpfFormatado(String cpfFormatado) {
        System.out.println("Mudando o cpf formtado para: " + cpfFormatado);
        this.cpfFormatado = cpfFormatado;
    }
    
    private String cnpj;
    private String cnpjFormatado;

    public String getcnpj() {
        return cnpj;
    }

    public void setcnpj(String cnpj) {
        System.out.println("Mudando o cnpj para: " + cnpj);
        this.cnpj = cnpj;
    }

    public String getcnpjFormatado() {
        return cnpjFormatado;
    }

    public void setcnpjFormatado(String cnpjFormatado) {
        System.out.println("Mudando o cnpj formtado para: " + cnpjFormatado);
        this.cnpjFormatado = cnpjFormatado;
    }
}
