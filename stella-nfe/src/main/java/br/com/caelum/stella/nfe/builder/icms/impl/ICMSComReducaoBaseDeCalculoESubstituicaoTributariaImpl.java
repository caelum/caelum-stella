package br.com.caelum.stella.nfe.builder.icms.impl;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.icms.ICMSComReducaoBaseDeCalculoEST;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeST;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;
import br.com.caelum.stella.nfe.modelo.ICMS70;

public class ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl implements ICMSComReducaoBaseDeCalculoEST, ObjectCreator  {

    private ICMSBuilderDelegate<ICMS70> delegate;

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl() {
        delegate = new ICMSBuilderDelegate<ICMS70>(ICMS70.class);
    }

    public static ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl create() {
        return new ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl();
    }

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl withOrigem(OrigemICMS origem) {
        delegate.withOrigem(origem);
        return this;
    }

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl withModalidade(ModalidadeBaseCalculo modalidade) {
        delegate.withModalidade(modalidade);
        return this;
    }

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl withPercentualReducaoBaseCalculo(
            BigDecimal percentualReducaoBaseCalculo) {
        delegate.withPercentualReducaoBaseCalculo(percentualReducaoBaseCalculo);
        return this;
    }

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl withBaseDeCalculo(BigDecimal baseCalculo) {
        delegate.withBaseDeCalculo(baseCalculo);
        return this;
    }

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl withAliquota(BigDecimal aliquota) {
        delegate.withAliquota(aliquota);
        return this;
    }

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl withValor(BigDecimal valor) {
        delegate.withValor(valor);
        return this;
    }

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl withModalidadeST(
            ModalidadeST modalidade) {
        delegate.withModalidadeSubstituicaoTributaria(modalidade);
        return this;
    }

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl withPercentualAdicionadoST(
            BigDecimal percentualAdicionado) {
        delegate.withPercentualAdicionadoSubstituicaoTributaria(percentualAdicionado);
        return this;
    }

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl withPercentualReducaoBaseCalculoST(
            BigDecimal percentualReducao) {
        delegate.withPercentualReducaoBaseCalculoSubstituicaoTributaria(percentualReducao);
        return this;
    }

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl withValorBaseCalculoST(
            BigDecimal valorBaseCalculo) {
        delegate.withValorBaseCalculoSubstituicaoTributaria(valorBaseCalculo);
        return this;
    }

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl withAliquotaST(BigDecimal aliquota) {
        delegate.withAliquotaSubstituicaoTributaria(aliquota);
        return this;
    }

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl withValorST(BigDecimal valor) {
        delegate.withValorSubstituicaoTributaria(valor);
        return this;
    }

    public ICMS70 getInstance() {
        return delegate.getReference();
    }

}
