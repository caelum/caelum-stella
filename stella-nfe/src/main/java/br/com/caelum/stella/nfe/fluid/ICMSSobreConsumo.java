package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.ICMSCons.class)
public interface ICMSSobreConsumo<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("vbcicmsstCons")
    ICMSSobreConsumo<T> withValorDaBaseDeCalculoDoICMSDeSubstituicaoTributariaSobreConsumo(java.math.BigDecimal valorDaBaseDeCalculoDoICMSDeSubstituicaoTributariaSobreConsumo);

    @net.vidageek.fluid.annotations.FluidField("vicmsstCons")
    ICMSSobreConsumo<T> withValorDoICMSSubstituicaoTributariaSobreConsumo(java.math.BigDecimal valorDoICMSSubstituicaoTributariaSobreConsumo);

    @net.vidageek.fluid.annotations.FluidField("ufCons")
    ICMSSobreConsumo<T> withUF(br.com.caelum.stella.nfe.modelo.UF UF);

}