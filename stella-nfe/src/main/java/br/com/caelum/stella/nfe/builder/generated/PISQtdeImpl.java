package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class PISQtdeImpl implements PISQtde, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.PISQtde pISQtde;

    public PISQtdeImpl() {
        pISQtde = new br.com.caelum.stella.nfe.modelo.PISQtde();
    }

    public br.com.caelum.stella.nfe.modelo.PISQtde getInstance() {
        return pISQtde;
    }

    public PISQtde withCodigoSituacaoTributaria(final String string) {
        pISQtde.setCST(string);
        return this;
    }

    public PISQtde withQuantidadeVendida(final BigDecimal string) {
        pISQtde.setQBCProd(string.toString());
        return this;
    }

    public PISQtde withAliquota(final BigDecimal string) {
        pISQtde.setVAliqProd(string.toString());
        return this;
    }

    public PISQtde withVPIS(final BigDecimal string) {
        pISQtde.setVPIS(string.toString());
        return this;
    }
}