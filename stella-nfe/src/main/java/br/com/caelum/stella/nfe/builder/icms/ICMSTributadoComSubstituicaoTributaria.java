/**
 * 
 */
package br.com.caelum.stella.nfe.builder.icms;

import br.com.caelum.stella.nfe.builder.ICMS;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeSubstituicaoTributaria;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;
import br.com.caelum.stella.nfe.modelo.ICMS10;

/**
 * @author jonasabreu
 * 
 */
public class ICMSTributadoComSubstituicaoTributaria implements ICMS {

    private final ICMSBuilderDelegate<ICMS10> delegate;

    private ICMSTributadoComSubstituicaoTributaria() {
        delegate = new ICMSBuilderDelegate<ICMS10>(ICMS10.class);
    }

    public static ICMSTributadoComSubstituicaoTributaria create() {
        return new ICMSTributadoComSubstituicaoTributaria();
    }

    public ICMSTributadoComSubstituicaoTributaria withOrigem(final OrigemICMS origem) {
        delegate.withOrigem(origem);
        return this;
    }

    public ICMSTributadoComSubstituicaoTributaria withModalidade(final ModalidadeBaseCalculo modalidade) {
        delegate.withModalidade(modalidade);
        return this;
    }

    public ICMSTributadoComSubstituicaoTributaria withBaseDeCalculo(final String baseCalculo) {
        delegate.withBaseDeCalculo(baseCalculo);
        return this;
    }

    public ICMSTributadoComSubstituicaoTributaria withAliquota(final String aliquota) {
        delegate.withAliquota(aliquota);
        return this;
    }

    public ICMSTributadoComSubstituicaoTributaria withValor(final String valor) {
        delegate.withValor(valor);
        return this;
    }

    public ICMSTributadoComSubstituicaoTributaria withModalidadeSubstituicaoTributaria(
            final ModalidadeSubstituicaoTributaria modalidade) {
        delegate.withModalidadeSubstituicaoTributaria(modalidade);
        return this;
    }

    public ICMSTributadoComSubstituicaoTributaria withPercentualAdicionado(final String percentualAdicionado) {
        delegate.withPercentualAdicionadoSubstituicaoTributaria(percentualAdicionado);
        return this;
    }

    public ICMSTributadoComSubstituicaoTributaria withPercentualReducaoBaseCalculo(
            final String percentualReducaoBaseCalculo) {
        delegate.withPercentualReducaoBaseCalculo(percentualReducaoBaseCalculo);
        return this;
    }

    public ICMSTributadoComSubstituicaoTributaria withValorBaseCalculoSubstituicaoTributaria(
            final String valorBaseCalculo) {
        delegate.withValorBaseCalculoSubstituicaoTributaria(valorBaseCalculo);
        return this;
    }

    public ICMSTributadoComSubstituicaoTributaria withAliquotaSubstituicaoTributaria(final String aliquota) {
        delegate.withAliquotaSubstituicaoTributaria(aliquota);
        return this;
    }

    public ICMSTributadoComSubstituicaoTributaria withValorSubstituicaoTributaria(final String valor) {
        delegate.withValorSubstituicaoTributaria(valor);
        return this;
    }

}
