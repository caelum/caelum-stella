package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface COFINSOutrasOperacoes<T> extends NFeBuilder<T> {
    public COFINSOutrasOperacoes<T> withCodigoSituacaoTributaria(String string);

    public COFINSOutrasOperacoes<T> withValorDaBaseDeCalculo(BigDecimal baseDeCalculo);

    public COFINSOutrasOperacoes<T> withAliquotaEmPercentual(BigDecimal percentual);

    public COFINSOutrasOperacoes<T> withQuantidadeVendida(String string);

    public COFINSOutrasOperacoes<T> withAliquota(String string);

    public COFINSOutrasOperacoes<T> withValor(String string);
}