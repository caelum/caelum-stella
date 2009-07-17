package br.com.caelum.stella.nfe.builder.generated;

public final class CabecalhoImpl<T> implements Cabecalho<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.CabecMsg cabecMsg;
    private final T parent;

    public CabecalhoImpl(final T parent) {
        this.parent = parent;
        cabecMsg = new br.com.caelum.stella.nfe.modelo.CabecMsg();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) cabecMsg;
    }

    public Cabecalho<T> withVersaoDados(final String string) {
        cabecMsg.setVersaoDados(string);
        return this;
    }

    public Cabecalho<T> withVersao(final String string) {
        cabecMsg.setVersao(string);
        return this;
    }
}