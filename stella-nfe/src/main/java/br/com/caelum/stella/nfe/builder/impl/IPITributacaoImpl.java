package br.com.caelum.stella.nfe.builder.impl;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.IPITributacao;
import br.com.caelum.stella.nfe.builder.enums.SituacaoTributaria;
import br.com.caelum.stella.nfe.modelo.IPITrib;

public class IPITributacaoImpl implements IPITributacao, ObjectCreator {

    private final IPITrib trib;

    public IPITributacaoImpl() {
        trib = new IPITrib();
    }

    public IPITributacaoImpl withSituacaoTributaria(final SituacaoTributaria situacao) {
        trib.setCodigoSituacaoTributaria(situacao.getCodigo());
        return this;
    }

    public IPITributacaoImpl withValorDaBaseDeCalculo(final BigDecimal baseDeCalculo) {
        trib.setvalorDaBaseDeCalculo(baseDeCalculo.toString());
        return this;
    }

    public IPITributacaoImpl withAliquota(final BigDecimal aliquota) {
        trib.setAliquotaIPI(aliquota.toString());
        return this;
    }

    public IPITributacaoImpl withQuantidadeTotal(final BigDecimal quantidadeTotal) {
        trib.setQuantidade(quantidadeTotal.toString());
        return this;
    }

    public IPITributacaoImpl withValorPorUnidadeTributavel(final BigDecimal valorPorUnidade) {
        trib.setValorUnidade(valorPorUnidade.toString());
        return this;
    }

    public IPITributacaoImpl withValorDoIPI(final BigDecimal valor) {
        trib.setValorIPI(valor.toString());
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) trib;
    }
}
