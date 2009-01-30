package br.com.caelum.stella.nfe.builder.icms;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeST;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;

public interface ICMSComReducaoBaseDeCalculoEST extends ICMS {

    public ICMSComReducaoBaseDeCalculoEST withOrigem(OrigemICMS origem);

    public ICMSComReducaoBaseDeCalculoEST withModalidade(ModalidadeBaseCalculo modalidade);

    public ICMSComReducaoBaseDeCalculoEST withPercentualReducaoBaseCalculo(
            BigDecimal percentualReducaoBaseCalculo);

    public ICMSComReducaoBaseDeCalculoEST withBaseDeCalculo(BigDecimal baseCalculo);

    public ICMSComReducaoBaseDeCalculoEST withAliquota(BigDecimal aliquota);

    public ICMSComReducaoBaseDeCalculoEST withValor(BigDecimal valor);

    public ICMSComReducaoBaseDeCalculoEST withModalidadeST(
            ModalidadeST modalidade);

    public ICMSComReducaoBaseDeCalculoEST withPercentualAdicionadoST(
            BigDecimal percentualAdicionado);

    public ICMSComReducaoBaseDeCalculoEST withPercentualReducaoBaseCalculoST(
            BigDecimal percentualReducao);

    public ICMSComReducaoBaseDeCalculoEST withValorBaseCalculoST(
            BigDecimal valorBaseCalculo);

    public ICMSComReducaoBaseDeCalculoEST withAliquotaST(BigDecimal aliquota);

    public ICMSComReducaoBaseDeCalculoEST withValorST(BigDecimal valor);

}
