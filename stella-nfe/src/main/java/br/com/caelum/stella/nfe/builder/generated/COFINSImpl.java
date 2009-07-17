package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class COFINSImpl<T> implements COFINS<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.COFINS cOFINS;
    private final T parent;

    public COFINSImpl(final T parent) {
        this.parent = parent;
        cOFINS = new br.com.caelum.stella.nfe.modelo.COFINS();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.cOFINS;
    }

    public COFINS<T> withTributacaoPelaAliquota(final COFINSTributadoPelaAliquota<?> cOFINSAliq) {
        cOFINS.setCOFINSAliq((br.com.caelum.stella.nfe.modelo.COFINSAliq) ((ObjectCreator) cOFINSAliq).getInstance());
        return this;
    }

    public COFINS<T> withTributacaoPelaQuantidade(final COFINSTributadoPelaQuantidade<?> cOFINSQtde) {
        cOFINS.setCOFINSQtde((br.com.caelum.stella.nfe.modelo.COFINSQtde) ((ObjectCreator) cOFINSQtde).getInstance());
        return this;
    }

    public COFINS<T> withNaoTributado(final COFINSNaoTributado<?> cOFINSNT) {
        cOFINS.setCOFINSNT((br.com.caelum.stella.nfe.modelo.COFINSNT) ((ObjectCreator) cOFINSNT).getInstance());
        return this;
    }

    public COFINS<T> withTributacaoDeOutrasOperacoes(final COFINSOutrasOperacoes<?> cOFINSOutr) {
        cOFINS.setCOFINSOutr((br.com.caelum.stella.nfe.modelo.COFINSOutr) ((ObjectCreator) cOFINSOutr).getInstance());
        return this;
    }
}