package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class TConsCadImpl implements TConsCad, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TConsCad tConsCad;

    public TConsCadImpl() {
        tConsCad = new br.com.caelum.stella.nfe.modelo.TConsCad();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) tConsCad;
    }

    public TConsCad withInfCons(final InfCons infCons) {
        tConsCad.setInfCons((br.com.caelum.stella.nfe.modelo.InfCons) ((ObjectCreator) infCons).getInstance());
        return this;
    }

    public TConsCad withVersao(final String string) {
        tConsCad.setVersao(string);
        return this;
    }
}