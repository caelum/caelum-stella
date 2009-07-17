package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface PISOutrasOperacoes<T> extends NFeBuilder<T> {
    public PISOutrasOperacoes<T> withValorDaBaseDeCalculo(BigDecimal string);

    public PISOutrasOperacoes<T> withAliquota(BigDecimal bigDecimal);

    public PISOutrasOperacoes<T> withQuantidadeVendida(BigDecimal string);

    public PISOutrasOperacoes<T> withAliquotaDoProduto(BigDecimal string);

    public PISOutrasOperacoes<T> withValor(BigDecimal string);
}