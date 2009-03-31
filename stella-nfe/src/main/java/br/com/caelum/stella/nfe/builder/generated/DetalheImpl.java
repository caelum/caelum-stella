package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.Impostos;

public final class DetalheImpl implements Detalhe, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Det det;

    public DetalheImpl() {
        det = new br.com.caelum.stella.nfe.modelo.Det();
    }

    public br.com.caelum.stella.nfe.modelo.Det getInstance() {
        return det;
    }

    public Detalhe withProduto(final Produto prod) {
        det.setProd((br.com.caelum.stella.nfe.modelo.Prod) ((ObjectCreator) prod).getInstance());
        return this;
    }

    public Detalhe withImposto(final Impostos imposto) {
        det.setImposto((br.com.caelum.stella.nfe.modelo.Imposto) ((ObjectCreator) imposto).getInstance());
        return this;
    }

    public Detalhe withInformacaoAdicionalDoProduto(final String string) {
        det.setInfAdProd(string);
        return this;
    }

    public Detalhe withNumeroDoItemNaNF(final String string) {
        det.setNItem(string);
        return this;
    }
}