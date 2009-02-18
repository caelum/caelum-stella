package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public final class IPITribImpl implements IPITrib, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.IPITrib iPITrib;

    public IPITribImpl() {
        iPITrib = new br.com.caelum.stella.nfe.modelo.IPITrib();
    }

    public br.com.caelum.stella.nfe.modelo.IPITrib getInstance() {
        return iPITrib;
    }

    public IPITrib withCodigoSituacaoTributaria(final String string) {
        iPITrib.setCodigoSituacaoTributaria(string);
        return this;
    }

    public IPITrib withValorDaBaseDeCalculo(final BigDecimal baseDeCalculo) {
        iPITrib.setvalorDaBaseDeCalculo(baseDeCalculo.toPlainString());
        return this;
    }

    public IPITrib withAliquota(final BigDecimal aliquota) {
        iPITrib.setAliquotaIPI(aliquota.toPlainString());
        return this;
    }

    public IPITrib withQuantidade(final String string) {
        iPITrib.setQuantidade(string);
        return this;
    }

    public IPITrib withValorPorUnidade(final String string) {
        iPITrib.setValorUnidade(string);
        return this;
    }

    public IPITrib withValor(final String string) {
        iPITrib.setValorIPI(string);
        return this;
    }
}