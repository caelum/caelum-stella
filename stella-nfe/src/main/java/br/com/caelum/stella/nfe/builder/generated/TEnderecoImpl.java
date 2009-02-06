package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.TUf;

public final class TEnderecoImpl implements TEndereco, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TEndereco tEndereco;

    public TEnderecoImpl() {
        this.tEndereco = new br.com.caelum.stella.nfe.modelo.TEndereco();
    }

    public br.com.caelum.stella.nfe.modelo.TEndereco getInstance() {
        return this.tEndereco;
    }

    public TEndereco withXLgr(String string) {
        this.tEndereco.setXLgr(string);
        return this;
    }

    public TEndereco withNro(String string) {
        this.tEndereco.setNro(string);
        return this;
    }

    public TEndereco withXCpl(String string) {
        this.tEndereco.setXCpl(string);
        return this;
    }

    public TEndereco withXBairro(String string) {
        this.tEndereco.setXBairro(string);
        return this;
    }

    public TEndereco withCMun(String string) {
        this.tEndereco.setCMun(string);
        return this;
    }

    public TEndereco withXMun(String string) {
        this.tEndereco.setXMun(string);
        return this;
    }

    public TEndereco withUF(TUf tUf) {
        this.tEndereco.setUF(tUf);
        return this;
    }

    public TEndereco withCEP(String string) {
        this.tEndereco.setCEP(string);
        return this;
    }

    public TEndereco withCPais(String string) {
        this.tEndereco.setCPais(string);
        return this;
    }

    public TEndereco withXPais(String string) {
        this.tEndereco.setXPais(string);
        return this;
    }

    public TEndereco withFone(String string) {
        this.tEndereco.setFone(string);
        return this;
    }
}