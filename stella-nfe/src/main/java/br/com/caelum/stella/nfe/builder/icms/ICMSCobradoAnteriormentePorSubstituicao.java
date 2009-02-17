package br.com.caelum.stella.nfe.builder.icms;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;

public interface ICMSCobradoAnteriormentePorSubstituicao extends ICMS {

	public ICMSCobradoAnteriormentePorSubstituicao withOrigem(OrigemICMS origem);

	public ICMSCobradoAnteriormentePorSubstituicao withValorDaBaseDeCalculoST(
			BigDecimal valorDaBaseDeCalculo);

	public ICMSCobradoAnteriormentePorSubstituicao withValorST(
			BigDecimal valorST);
}
