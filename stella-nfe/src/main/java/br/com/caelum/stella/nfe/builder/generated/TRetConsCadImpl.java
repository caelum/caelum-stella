package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class TRetConsCadImpl<T> implements TRetConsCad<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TRetConsCad tRetConsCad;
    private final T parent;

    public TRetConsCadImpl(final T parent) {
        this.parent = parent;
        tRetConsCad = new br.com.caelum.stella.nfe.modelo.TRetConsCad();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.tRetConsCad;
    }

    public TRetConsCad<T> withInfCons(final InfCons<?> infCons) {
        tRetConsCad.setInfCons((br.com.caelum.stella.nfe.modelo.InfCons) ((ObjectCreator) infCons).getInstance());
        return this;
    }

    public TRetConsCad<T> withVersao(final String string) {
        tRetConsCad.setVersao(string);
        return this;
    }
}