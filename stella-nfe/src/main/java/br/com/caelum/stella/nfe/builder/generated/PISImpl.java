package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class PISImpl implements PIS, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.PIS pIS;

    public PISImpl() {
        pIS = new br.com.caelum.stella.nfe.modelo.PIS();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.pIS;
    }

    public PIS withPISTributadoPelaAliquota(final PISTributadoPelaAliquota pISAliq) {
        pIS.setPISAliq((br.com.caelum.stella.nfe.modelo.PISAliq) ((ObjectCreator) pISAliq).getInstance());
        return this;
    }

    public PIS withPISTributadoPorQuantidade(final PISTributadoPorQuantidade pISQtde) {
        pIS.setPISQtde((br.com.caelum.stella.nfe.modelo.PISQtde) ((ObjectCreator) pISQtde).getInstance());
        return this;
    }

    public PIS withPISNaoTributado(final PISNaoTributado pISNT) {
        pIS.setPISNT((br.com.caelum.stella.nfe.modelo.PISNT) ((ObjectCreator) pISNT).getInstance());
        return this;
    }

    public PIS withPISOutrasOperacoes(final PISOutrasOperacoes pISOutr) {
        pIS.setPISOutr((br.com.caelum.stella.nfe.modelo.PISOutr) ((ObjectCreator) pISOutr).getInstance());
        return this;
    }
}