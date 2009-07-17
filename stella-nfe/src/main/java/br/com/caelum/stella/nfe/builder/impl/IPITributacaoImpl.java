package br.com.caelum.stella.nfe.builder.impl;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.IPITributacao;
import br.com.caelum.stella.nfe.builder.enums.SituacaoTributaria;
import br.com.caelum.stella.nfe.modelo.IPITrib;

public class IPITributacaoImpl<T> implements IPITributacao<T>, ObjectCreator {

    private final IPITrib trib;
    private final T parent;

    public IPITributacaoImpl(final T parent) {
        this.parent = parent;
        trib = new IPITrib();
    }

    public T build() {
        return parent;
    }

    public IPITributacao<T> withSituacaoTributaria(final SituacaoTributaria situacao) {
        trib.setCodigoSituacaoTributaria(situacao.getCodigo());
        return this;
    }

    public IPITributacao<T> withValorDaBaseDeCalculo(final BigDecimal baseDeCalculo) {
        trib.setvalorDaBaseDeCalculo(baseDeCalculo.toString());
        return this;
    }

    public IPITributacao<T> withAliquota(final BigDecimal aliquota) {
        trib.setAliquotaIPI(aliquota.toString());
        return this;
    }

    public IPITributacao<T> withQuantidadeTotal(final BigDecimal quantidadeTotal) {
        trib.setQuantidade(quantidadeTotal.toString());
        return this;
    }

    public IPITributacao<T> withValorPorUnidadeTributavel(final BigDecimal valorPorUnidade) {
        trib.setValorUnidade(valorPorUnidade.toString());
        return this;
    }

    public IPITributacao<T> withValorDoIPI(final BigDecimal valor) {
        trib.setValorIPI(valor.toString());
        return this;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) trib;
    }
}
