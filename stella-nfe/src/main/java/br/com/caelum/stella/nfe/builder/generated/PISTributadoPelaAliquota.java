package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface PISTributadoPelaAliquota<T> extends NFeBuilder<T> {
    public PISTributadoPelaAliquota<T> withCodigoSituacaoTributaria(String string);

    public PISTributadoPelaAliquota<T> withValorDaBaseDeCalculo(BigDecimal string);

    public PISTributadoPelaAliquota<T> withAliquotaDoPIS(BigDecimal aliquota);

    public PISTributadoPelaAliquota<T> withValorDoPIS(BigDecimal string);
}