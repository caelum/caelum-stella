package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.TUf;

public final class InfRetAtuCadEmiDFeImpl implements InfRetAtuCadEmiDFe, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.InfRetAtuCadEmiDFe infRetAtuCadEmiDFe;

    public InfRetAtuCadEmiDFeImpl() {
        this.infRetAtuCadEmiDFe = new br.com.caelum.stella.nfe.modelo.InfRetAtuCadEmiDFe();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.infRetAtuCadEmiDFe;
    }

    public InfRetAtuCadEmiDFe withUF(TUf tUf) {
        this.infRetAtuCadEmiDFe.setUF(tUf);
        return this;
    }

    public InfRetAtuCadEmiDFe withCNPJ(Object object) {
        this.infRetAtuCadEmiDFe.setCNPJ(object);
        return this;
    }

    public InfRetAtuCadEmiDFe withOpe(String string) {
        this.infRetAtuCadEmiDFe.setOpe(string);
        return this;
    }

    public InfRetAtuCadEmiDFe withResOpe(String string) {
        this.infRetAtuCadEmiDFe.setResOpe(string);
        return this;
    }

    public InfRetAtuCadEmiDFe withId(String string) {
        this.infRetAtuCadEmiDFe.setId(string);
        return this;
    }
}