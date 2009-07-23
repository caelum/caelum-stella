package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.ICMSInter.class)
public interface ICMSSobreOperacoesInterestaduais<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("vbcicmsstDest")
    ICMSSobreOperacoesInterestaduais<T> withValorDaBaseDeCalculoDoICMSSubstituicaoTributariaDoDestino(java.lang.String valorDaBaseDeCalculoDoICMSSubstituicaoTributariaDoDestino);

    @net.vidageek.fluid.annotations.FluidField("vicmsstDest")
    ICMSSobreOperacoesInterestaduais<T> withValorDoICMSSubstituicaoTributariaDoDestino(java.lang.String valorDoICMSSubstituicaoTributariaDoDestino);

}