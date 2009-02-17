/**
 * 
 */
package br.com.caelum.stella.nfe.builder.icms;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeST;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;

/**
 * @author jonasabreu
 * 
 */
public interface ICMSTributadoComST extends ICMS {

    public ICMSTributadoComST withOrigem(final OrigemICMS origem);

    public ICMSTributadoComST withModalidade(final ModalidadeBaseCalculo modalidade);

    public ICMSTributadoComST withBaseDeCalculo(final BigDecimal baseCalculo);

    public ICMSTributadoComST withAliquota(final BigDecimal aliquota);

    public ICMSTributadoComST withValor(final BigDecimal valor);

    public ICMSTributadoComST withModalidadeST(
            final ModalidadeST modalidade);

    public ICMSTributadoComST withPercentualAdicionado(final BigDecimal percentualAdicionado);

    public ICMSTributadoComST withPercentualReducaoBaseCalculo(
            final BigDecimal percentualReducaoBaseCalculo);

    public ICMSTributadoComST withValorDaBaseDeCalculoST(
            final BigDecimal valorDaBaseDeCalculo);

    public ICMSTributadoComST withAliquotaST(final BigDecimal aliquota);

    public ICMSTributadoComST withValorST(final BigDecimal valor);

}
