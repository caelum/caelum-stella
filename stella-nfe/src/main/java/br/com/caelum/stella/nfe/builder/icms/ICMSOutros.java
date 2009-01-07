package br.com.caelum.stella.nfe.builder.icms;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.ICMS;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeSubstituicaoTributaria;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;

public interface ICMSOutros extends ICMS {

    public ICMSOutros withOrigem(OrigemICMS origem);

    public ICMSOutros withModalidade(ModalidadeBaseCalculo modalidadeBaseCalculo);

    public ICMSOutros withBaseDeCalculo(BigDecimal baseCalculo);

    public ICMSOutros withPercentualReducaoBaseCalculo(BigDecimal percentual);

    public ICMSOutros withAliquota(BigDecimal aliquota);

    public ICMSOutros withValor(BigDecimal valor);

    public ICMSOutros withModalidadeSubstituicaoTributaria(ModalidadeSubstituicaoTributaria modalidade);

    public ICMSOutros withPercentualAdicionadoSubstituicaoTributaria(BigDecimal percentual);

    public ICMSOutros withValorBaseCalculoSubstituicaoTributaria(BigDecimal valor);

    public ICMSOutros withAliquotaSubstituicaoTributaria(BigDecimal aliquota);

    public ICMSOutros withValorSubstituicaoTributaria(BigDecimal valor);

    public ICMSOutros withPercentualReducaoBaseCalculoSubstituicaoTributaria(BigDecimal percentual);

}
