package br.com.caelum.stella.nfe.builder.impl;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.IPITributacao;
import br.com.caelum.stella.nfe.builder.enums.SituacaoTributaria;
import br.com.caelum.stella.nfe.modelo.IPITrib;

public class IPITributacaoImpl implements IPITributacao, ObjectCreator{

    private IPITrib trib;

    public IPITributacaoImpl() {
        trib = new IPITrib();
    }
    
    public IPITributacaoImpl withSituacaoTribuaria(SituacaoTributaria situacao) {
        trib.setCodigoSituacaoTributaria(situacao.getCodigo());
        return this;
    }

    public IPITributacaoImpl withValorDaBaseDeCalculo(BigDecimal baseDeCalculo) {
        trib.setValorBaseCalculo(baseDeCalculo.toString());
        return this;
    }

    public IPITributacaoImpl withAliquota(BigDecimal aliquota) {
        trib.setAliquotaIPI(aliquota.toString());
        return this;
    }

    public IPITributacaoImpl withQuantidadeTotal(BigDecimal quantidadeTotal) {
        trib.setQuantidade(quantidadeTotal.toString());
        return this;
    }

    public IPITributacaoImpl withValorPorUnidadeTributavel(BigDecimal valorPorUnidade) {
        trib.setValorUnidade(valorPorUnidade.toString());
        return this;
    }

    public IPITributacaoImpl withValorDoIPI(BigDecimal valor) {
        trib.setValorIPI(valor.toString());
        return this;
    }

    public Object getInstance() {
        return trib;
    }
}
