package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class TRetConsCadImpl implements TRetConsCad, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TRetConsCad tRetConsCad;

    public TRetConsCadImpl() {
        tRetConsCad = new br.com.caelum.stella.nfe.modelo.TRetConsCad();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.tRetConsCad;
    }

    public TRetConsCad withInfCons(final InfCons infCons) {
        tRetConsCad.setInfCons((br.com.caelum.stella.nfe.modelo.InfCons) ((ObjectCreator) infCons).getInstance());
        return this;
    }

    public TRetConsCad withVersao(final String string) {
        tRetConsCad.setVersao(string);
        return this;
    }
}