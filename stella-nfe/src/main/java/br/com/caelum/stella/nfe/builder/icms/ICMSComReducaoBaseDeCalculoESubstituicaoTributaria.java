package br.com.caelum.stella.nfe.builder.icms;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.ICMS;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeSubstituicaoTributaria;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;

public interface ICMSComReducaoBaseDeCalculoESubstituicaoTributaria extends ICMS {

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributaria withOrigem(OrigemICMS origem);

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributaria withModalidade(ModalidadeBaseCalculo modalidade);

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributaria withPercentualReducaoBaseCalculo(
            BigDecimal percentualReducaoBaseCalculo);

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributaria withBaseDeCalculo(BigDecimal baseCalculo);

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributaria withAliquota(BigDecimal aliquota);

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributaria withValor(BigDecimal valor);

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributaria withModalidadeSubstituicaoTributaria(
            ModalidadeSubstituicaoTributaria modalidade);

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributaria withPercentualAdicionadoSubstituicaoTributaria(
            BigDecimal percentualAdicionado);

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributaria withPercentualReducaoBaseCalculoSubstituicaoTributaria(
            BigDecimal percentualReducao);

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributaria withValorBaseCalculoSubstituicaoTributaria(
            BigDecimal valorBaseCalculo);

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributaria withAliquotaSubstituicaoTributaria(BigDecimal aliquota);

    public ICMSComReducaoBaseDeCalculoESubstituicaoTributaria withValorSubstituicaoTributaria(BigDecimal valor);

}
