/**
 * 
 */
package br.com.caelum.stella.nfe.builder.icms.impl;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.icms.ICMSTributadoComSubstituicaoTributaria;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeSubstituicaoTributaria;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;
import br.com.caelum.stella.nfe.modelo.ICMS10;

/**
 * @author jonasabreu
 * 
 */
public class ICMSTributadoComSubstituicaoTributariaImpl implements ICMSTributadoComSubstituicaoTributaria, ObjectCreator  {

    private final ICMSBuilderDelegate<ICMS10> delegate;

    public ICMSTributadoComSubstituicaoTributariaImpl() {
        delegate = new ICMSBuilderDelegate<ICMS10>(ICMS10.class);
    }

    public static ICMSTributadoComSubstituicaoTributariaImpl create() {
        return new ICMSTributadoComSubstituicaoTributariaImpl();
    }

    public ICMSTributadoComSubstituicaoTributariaImpl withOrigem(final OrigemICMS origem) {
        delegate.withOrigem(origem);
        return this;
    }

    public ICMSTributadoComSubstituicaoTributariaImpl withModalidade(final ModalidadeBaseCalculo modalidade) {
        delegate.withModalidade(modalidade);
        return this;
    }

    public ICMSTributadoComSubstituicaoTributariaImpl withBaseDeCalculo(final BigDecimal baseCalculo) {
        delegate.withBaseDeCalculo(baseCalculo);
        return this;
    }

    public ICMSTributadoComSubstituicaoTributariaImpl withAliquota(final BigDecimal aliquota) {
        delegate.withAliquota(aliquota);
        return this;
    }

    public ICMSTributadoComSubstituicaoTributariaImpl withValor(final BigDecimal valor) {
        delegate.withValor(valor);
        return this;
    }

    public ICMSTributadoComSubstituicaoTributariaImpl withModalidadeSubstituicaoTributaria(
            final ModalidadeSubstituicaoTributaria modalidade) {
        delegate.withModalidadeSubstituicaoTributaria(modalidade);
        return this;
    }

    public ICMSTributadoComSubstituicaoTributariaImpl withPercentualAdicionado(final BigDecimal percentualAdicionado) {
        delegate.withPercentualAdicionadoSubstituicaoTributaria(percentualAdicionado);
        return this;
    }

    public ICMSTributadoComSubstituicaoTributariaImpl withPercentualReducaoBaseCalculo(
            final BigDecimal percentualReducaoBaseCalculo) {
        delegate.withPercentualReducaoBaseCalculo(percentualReducaoBaseCalculo);
        return this;
    }

    public ICMSTributadoComSubstituicaoTributariaImpl withValorBaseCalculoSubstituicaoTributaria(
            final BigDecimal valorBaseCalculo) {
        delegate.withValorBaseCalculoSubstituicaoTributaria(valorBaseCalculo);
        return this;
    }

    public ICMSTributadoComSubstituicaoTributariaImpl withAliquotaSubstituicaoTributaria(final BigDecimal aliquota) {
        delegate.withAliquotaSubstituicaoTributaria(aliquota);
        return this;
    }

    public ICMSTributadoComSubstituicaoTributariaImpl withValorSubstituicaoTributaria(final BigDecimal valor) {
        delegate.withValorSubstituicaoTributaria(valor);
        return this;
    }

    public ICMS10 getInstance() {
        return delegate.getReference();
    }

}
