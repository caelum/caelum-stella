package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class PISImpl<T> implements PIS<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.PIS pIS;
    private final T parent;

    public PISImpl(final T parent) {
        this.parent = parent;
        pIS = new br.com.caelum.stella.nfe.modelo.PIS();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.pIS;
    }

    public PIS<T> withPISTributadoPelaAliquota(final PISTributadoPelaAliquota<?> pISAliq) {
        pIS.setPISAliq((br.com.caelum.stella.nfe.modelo.PISAliq) ((ObjectCreator) pISAliq).getInstance());
        return this;
    }

    public PIS<T> withPISTributadoPorQuantidade(final PISTributadoPorQuantidade<?> pISQtde) {
        pIS.setPISQtde((br.com.caelum.stella.nfe.modelo.PISQtde) ((ObjectCreator) pISQtde).getInstance());
        return this;
    }

    public PIS<T> withPISNaoTributado(final PISNaoTributado<?> pISNT) {
        pIS.setPISNT((br.com.caelum.stella.nfe.modelo.PISNT) ((ObjectCreator) pISNT).getInstance());
        return this;
    }

    public PIS<T> withPISOutrasOperacoes(final PISOutrasOperacoes<?> pISOutr) {
        pIS.setPISOutr((br.com.caelum.stella.nfe.modelo.PISOutr) ((ObjectCreator) pISOutr).getInstance());
        return this;
    }
}