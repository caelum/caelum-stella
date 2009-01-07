/**
 * 
 */
package br.com.caelum.stella.nfe.builder.icms;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.ICMS;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeSubstituicaoTributaria;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;

/**
 * @author jonasabreu
 * 
 */
public interface ICMSTributadoComSubstituicaoTributaria extends ICMS {

    public ICMSTributadoComSubstituicaoTributaria withOrigem(final OrigemICMS origem);

    public ICMSTributadoComSubstituicaoTributaria withModalidade(final ModalidadeBaseCalculo modalidade);

    public ICMSTributadoComSubstituicaoTributaria withBaseDeCalculo(final BigDecimal baseCalculo);

    public ICMSTributadoComSubstituicaoTributaria withAliquota(final BigDecimal aliquota);

    public ICMSTributadoComSubstituicaoTributaria withValor(final BigDecimal valor);

    public ICMSTributadoComSubstituicaoTributaria withModalidadeSubstituicaoTributaria(
            final ModalidadeSubstituicaoTributaria modalidade);

    public ICMSTributadoComSubstituicaoTributaria withPercentualAdicionado(final BigDecimal percentualAdicionado);

    public ICMSTributadoComSubstituicaoTributaria withPercentualReducaoBaseCalculo(
            final BigDecimal percentualReducaoBaseCalculo);

    public ICMSTributadoComSubstituicaoTributaria withValorBaseCalculoSubstituicaoTributaria(
            final BigDecimal valorBaseCalculo);

    public ICMSTributadoComSubstituicaoTributaria withAliquotaSubstituicaoTributaria(final BigDecimal aliquota);

    public ICMSTributadoComSubstituicaoTributaria withValorSubstituicaoTributaria(final BigDecimal valor);

}
