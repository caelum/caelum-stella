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
}
