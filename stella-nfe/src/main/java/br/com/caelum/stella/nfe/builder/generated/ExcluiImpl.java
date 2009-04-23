package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.TUf;

public final class ExcluiImpl implements Exclui, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Exclui exclui;

    public ExcluiImpl() {
        this.exclui = new br.com.caelum.stella.nfe.modelo.Exclui();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.exclui;
    }

    public Exclui withUF(TUf tUf) {
        this.exclui.setUF(tUf);
        return this;
    }

    public Exclui withCNPJ(Object object) {
        this.exclui.setCNPJ(object);
        return this;
    }
}