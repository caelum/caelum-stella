package br.com.caelum.stella.nfe.builder.generated;

public final class COFINSNaoTributadoImpl<T> implements COFINSNaoTributado<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.COFINSNT cOFINSNT;
    private final T parent;

    public COFINSNaoTributadoImpl(final T parent) {
        this.parent = parent;
        cOFINSNT = new br.com.caelum.stella.nfe.modelo.COFINSNT();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.cOFINSNT;
    }

    public COFINSNaoTributado<T> withCodigoSituacaoTributaria(final String string) {
        cOFINSNT.setCodigoSituacaoTributaria(string);
        return this;
    }
}