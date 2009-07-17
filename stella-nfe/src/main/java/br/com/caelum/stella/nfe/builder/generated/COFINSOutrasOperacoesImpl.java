package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class COFINSOutrasOperacoesImpl<T> implements COFINSOutrasOperacoes<T>,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.COFINSOutr cOFINSOutr;
    private final T parent;

    public COFINSOutrasOperacoesImpl(final T parent) {
        this.parent = parent;
        cOFINSOutr = new br.com.caelum.stella.nfe.modelo.COFINSOutr();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.cOFINSOutr;
    }

    public COFINSOutrasOperacoes<T> withCodigoSituacaoTributaria(final String string) {
        cOFINSOutr.setCodigoSituacaoTributaria(string);
        return this;
    }

    public COFINSOutrasOperacoes<T> withValorDaBaseDeCalculo(final BigDecimal baseDeCalculo) {
        cOFINSOutr.setvalorDaBaseDeCalculo(baseDeCalculo.toPlainString());
        return this;
    }

    public COFINSOutrasOperacoes<T> withAliquotaEmPercentual(final BigDecimal percentual) {
        cOFINSOutr.setAliquotaEmPercentual(percentual.toPlainString());
        return this;
    }

    public COFINSOutrasOperacoes<T> withQuantidadeVendida(final String string) {
        cOFINSOutr.setQuantidadeVendida(string);
        return this;
    }

    public COFINSOutrasOperacoes<T> withAliquota(final String string) {
        cOFINSOutr.setAliquota(string);
        return this;
    }

    public COFINSOutrasOperacoes<T> withValor(final String string) {
        cOFINSOutr.setValor(string);
        return this;
    }
}