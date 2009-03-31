package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.modelo.UF;

public interface ICMSSobreConsumo {
    public ICMSSobreConsumo withValorDaBaseDeCalculoDoICMSDeSubstituicaoTributariaSobreConsumo(BigDecimal string);

    public ICMSSobreConsumo withValorDoICMSSubstituicaoTributariaSobreConsumo(BigDecimal string);

    public ICMSSobreConsumo withUF(UF tUf);
}