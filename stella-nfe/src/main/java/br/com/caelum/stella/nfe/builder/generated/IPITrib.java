package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

public interface IPITrib {
    public IPITrib withCodigoSituacaoTributaria(String string);

    public IPITrib withValorDaBaseDeCalculo(BigDecimal baseDeCalculo);

    public IPITrib withAliquota(BigDecimal aliquota);

    public IPITrib withQuantidade(String string);

    public IPITrib withValorPorUnidade(String string);

    public IPITrib withValor(String string);
}