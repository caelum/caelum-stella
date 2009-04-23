package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class COFINSOutrasOperacoesImpl implements COFINSOutrasOperacoes, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.COFINSOutr cOFINSOutr;

    public COFINSOutrasOperacoesImpl() {
        cOFINSOutr = new br.com.caelum.stella.nfe.modelo.COFINSOutr();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.cOFINSOutr;
    }

    public COFINSOutrasOperacoes withCodigoSituacaoTributaria(final String string) {
        cOFINSOutr.setCodigoSituacaoTributaria(string);
        return this;
    }

    public COFINSOutrasOperacoes withValorDaBaseDeCalculo(final BigDecimal baseDeCalculo) {
        cOFINSOutr.setvalorDaBaseDeCalculo(baseDeCalculo.toPlainString());
        return this;
    }

    public COFINSOutrasOperacoes withAliquotaEmPercentual(final BigDecimal percentual) {
        cOFINSOutr.setAliquotaEmPercentual(percentual.toPlainString());
        return this;
    }

    public COFINSOutrasOperacoes withQuantidadeVendida(final String string) {
        cOFINSOutr.setQuantidadeVendida(string);
        return this;
    }

    public COFINSOutrasOperacoes withAliquota(final String string) {
        cOFINSOutr.setAliquota(string);
        return this;
    }

    public COFINSOutrasOperacoes withValor(final String string) {
        cOFINSOutr.setValor(string);
        return this;
    }
}