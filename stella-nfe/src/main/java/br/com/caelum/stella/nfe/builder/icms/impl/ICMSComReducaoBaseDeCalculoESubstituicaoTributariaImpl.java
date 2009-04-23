package br.com.caelum.stella.nfe.builder.icms.impl;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.icms.ICMSComReducaoBaseDeCalculoEST;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeST;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;
import br.com.caelum.stella.nfe.modelo.ICMS70;

public class ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl implements ICMSComReducaoBaseDeCalculoEST,
        ObjectCreator {

    private final ICMSBuilderDelegate<ICMS70> delegate;

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl() {
        delegate = new ICMSBuilderDelegate<ICMS70>(ICMS70.class);
    }

    public static ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl create() {
        return new ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl();
    }

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl withOrigem(final OrigemICMS origem) {
        delegate.withOrigem(origem);
        return this;
    }

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl withModalidade(final ModalidadeBaseCalculo modalidade) {
        delegate.withModalidade(modalidade);
        return this;
    }

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl withPercentualReducaoBaseCalculo(
            final BigDecimal percentualReducaoBaseCalculo) {
        delegate.withPercentualReducaoBaseCalculo(percentualReducaoBaseCalculo);
        return this;
    }

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl withBaseDeCalculo(final BigDecimal baseCalculo) {
        delegate.withBaseDeCalculo(baseCalculo);
        return this;
    }

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl withAliquota(final BigDecimal aliquota) {
        delegate.withAliquota(aliquota);
        return this;
    }

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl withValor(final BigDecimal valor) {
        delegate.withValor(valor);
        return this;
    }

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl withModalidadeST(final ModalidadeST modalidade) {
        delegate.withModalidadeSubstituicaoTributaria(modalidade);
        return this;
    }

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl withPercentualAdicionadoST(
            final BigDecimal percentualAdicionado) {
        delegate.withPercentualAdicionadoSubstituicaoTributaria(percentualAdicionado);
        return this;
    }

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl withPercentualReducaoBaseCalculoST(
            final BigDecimal percentualReducao) {
        delegate.withPercentualReducaoBaseCalculoSubstituicaoTributaria(percentualReducao);
        return this;
    }

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl withValorDaBaseDeCalculoST(
            final BigDecimal valorDaBaseDeCalculo) {
        delegate.withValorDaBaseDeCalculoSubstituicaoTributaria(valorDaBaseDeCalculo);
        return this;
    }

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl withAliquotaST(final BigDecimal aliquota) {
        delegate.withAliquotaSubstituicaoTributaria(aliquota);
        return this;
    }

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributariaImpl withValorST(final BigDecimal valor) {
        delegate.withValorSubstituicaoTributaria(valor);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) delegate.getReference();
    }

}
