package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface ICMSSobreOperacoesInterestaduais<T> extends NFeBuilder<T> {
    public ICMSSobreOperacoesInterestaduais<T> withValorDaBaseDeCalculoDoICMSSubstituicaoTributariaDoDestino(
            BigDecimal string);

    public ICMSSobreOperacoesInterestaduais<T> withValorDoICMSSubstituicaoTributariaDoDestino(BigDecimal string);
}