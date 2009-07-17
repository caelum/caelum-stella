package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface PISSubstituicaoTributaria<T> extends NFeBuilder<T> {
    public PISSubstituicaoTributaria<T> withValorDaBaseDeCalculo(BigDecimal string);

    public PISSubstituicaoTributaria<T> withAliquotaDaSubstituicaoTributaria(BigDecimal string);

    public PISSubstituicaoTributaria<T> withQuantidadeVendida(BigDecimal string);

    public PISSubstituicaoTributaria<T> withAliquota(BigDecimal string);

    public PISSubstituicaoTributaria<T> withValor(BigDecimal string);
}