package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class TConsCadImpl<T> implements TConsCad<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TConsCad tConsCad;
    private final T parent;

    public TConsCadImpl(final T parent) {
        this.parent = parent;
        tConsCad = new br.com.caelum.stella.nfe.modelo.TConsCad();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) tConsCad;
    }

    public TConsCad<T> withInfCons(final InfCons<?> infCons) {
        tConsCad.setInfCons((br.com.caelum.stella.nfe.modelo.InfCons) ((ObjectCreator) infCons).getInstance());
        return this;
    }

    public TConsCad<T> withVersao(final String string) {
        tConsCad.setVersao(string);
        return this;
    }
}