package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class COFINSTributadoPelaAliquotaImpl implements COFINSTributadoPelaAliquota,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.COFINSAliq cOFINSAliq;

    public COFINSTributadoPelaAliquotaImpl() {
        cOFINSAliq = new br.com.caelum.stella.nfe.modelo.COFINSAliq();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.cOFINSAliq;
    }

    public COFINSTributadoPelaAliquota withCodigoSituacaoTributaria(final String string) {
        cOFINSAliq.setCodigoSituacaoTributaria(string);
        return this;
    }

    public COFINSTributadoPelaAliquota withValorDaBaseDeCalculo(final BigDecimal baseDeCalculo) {
        cOFINSAliq.setvalorDaBaseDeCalculo(baseDeCalculo.toPlainString());
        return this;
    }

    public COFINSTributadoPelaAliquota withAliquotaEmPercentual(final BigDecimal percentual) {
        cOFINSAliq.setAliquotaEmPercentual(percentual.toPlainString());
        return this;
    }

    public COFINSTributadoPelaAliquota withValor(final String string) {
        cOFINSAliq.setValor(string);
        return this;
    }
}