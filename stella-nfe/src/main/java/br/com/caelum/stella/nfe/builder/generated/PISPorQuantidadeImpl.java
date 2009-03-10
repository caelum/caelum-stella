package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class PISPorQuantidadeImpl implements PISPorQuantidade, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.PISQtde pISQtde;

    public PISPorQuantidadeImpl() {
        pISQtde = new br.com.caelum.stella.nfe.modelo.PISQtde();
        pISQtde.setCST("03");
    }

    public br.com.caelum.stella.nfe.modelo.PISQtde getInstance() {
        return pISQtde;
    }

    public PISPorQuantidade withQuantidadeVendida(final BigDecimal string) {
        pISQtde.setQBCProd(string.toString());
        return this;
    }

    public PISPorQuantidade withAliquota(final BigDecimal string) {
        pISQtde.setVAliqProd(string.toString());
        return this;
    }

    public PISPorQuantidade withValorDoPIS(final BigDecimal string) {
        pISQtde.setVPIS(string.toString());
        return this;
    }
}