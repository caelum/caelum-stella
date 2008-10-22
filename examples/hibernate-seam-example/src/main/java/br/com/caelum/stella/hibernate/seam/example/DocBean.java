package br.com.caelum.stella.hibernate.seam.example;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import br.com.caelum.stella.hibernate.validator.CPF;

/**
 * Data
 * 
 */
@Name("docBean")
@Scope(ScopeType.EVENT)
public class DocBean {
    @CPF
    private String cpf;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}