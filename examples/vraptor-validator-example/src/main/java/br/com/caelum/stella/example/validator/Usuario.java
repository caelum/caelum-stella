package br.com.caelum.stella.example.validator;

import br.com.caelum.stella.hibernate.validator.CNPJ;
import br.com.caelum.stella.hibernate.validator.CPF;
import br.com.caelum.stella.hibernate.validator.NIT;

public class Usuario {
    @CPF
    private String cpf;
    @CNPJ
    private String cnpj;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @NIT
    private String nit;

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

}
