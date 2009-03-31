package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class COFINSTributadoPelaQuantidadeImpl implements COFINSTributadoPelaQuantidade, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.COFINSQtde cOFINSQtde;

    public COFINSTributadoPelaQuantidadeImpl() {
        cOFINSQtde = new br.com.caelum.stella.nfe.modelo.COFINSQtde();
    }

    public br.com.caelum.stella.nfe.modelo.COFINSQtde getInstance() {
        return cOFINSQtde;
    }

    public COFINSTributadoPelaQuantidade withCodigoSituacaoTributaria(final String string) {
        cOFINSQtde.setCodigoSituacaoTributaria(string);
        return this;
    }

    public COFINSTributadoPelaQuantidade withQuantidadeVendida(final BigDecimal string) {
        cOFINSQtde.setQuantidadeVendida(string.toString());
        return this;
    }

    public COFINSTributadoPelaQuantidade withAliquota(final BigDecimal string) {
        cOFINSQtde.setAliquota(string.toString());
        return this;
    }

    public COFINSTributadoPelaQuantidade withValor(final BigDecimal string) {
        cOFINSQtde.setValor(string.toString());
        return this;
    }
}