package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface Adicao<T> extends NFeBuilder<T> {
    public Adicao<T> withNumeroDaAdicao(Integer integer);

    public Adicao<T> withNumeroSequencialDoItemDaAdicao(Integer integer);

    public Adicao<T> withCodigoDoFabricanteEstrangeiro(String string);

    public Adicao<T> withValorDeDescontoDoItemDaDI(BigDecimal bigDecimal);
}