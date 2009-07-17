package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

final public class ISSQNtotImpl<T> implements ISSQNTotal<T>, ObjectCreator {

    private final T parent;

    public ISSQNtotImpl(final T parent) {
        this.parent = parent;
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) new br.com.caelum.stella.nfe.modelo.ISSQNtot();
    }

}
