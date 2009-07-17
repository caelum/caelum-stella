package br.com.caelum.stella.nfe.builder.generated;

//TODO Essa classe deve virar apenas um campo onde ela é necesária
public final class PISNaoTributadoImpl<T> implements PISNaoTributado<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.PISNT pISNT;
    private final T parent;

    public PISNaoTributadoImpl(final T parent) {
        this.parent = parent;
        pISNT = new br.com.caelum.stella.nfe.modelo.PISNT();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) pISNT;
    }

    // TODO Deve ser uma enum
    public PISNaoTributado<T> withCodigoSituacaoTributaria(final String string) {
        pISNT.setCST(string);
        return this;
    }
}