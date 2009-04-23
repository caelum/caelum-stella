package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class PISTributadoPorQuantidadeImpl implements PISTributadoPorQuantidade,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.PISQtde pISQtde;

    public PISTributadoPorQuantidadeImpl() {
        pISQtde = new br.com.caelum.stella.nfe.modelo.PISQtde();
        pISQtde.setCST("03");
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.pISQtde;
    }

    public PISTributadoPorQuantidade withQuantidadeVendida(final BigDecimal string) {
        pISQtde.setQBCProd(string.toString());
        return this;
    }

    public PISTributadoPorQuantidade withAliquota(final BigDecimal string) {
        pISQtde.setVAliqProd(string.toString());
        return this;
    }

    public PISTributadoPorQuantidade withValorDoPIS(final BigDecimal string) {
        pISQtde.setVPIS(string.toString());
        return this;
    }
}