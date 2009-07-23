package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.ObsCont.class)
public interface ObservacaoDoContribuinte<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("xTexto")
    ObservacaoDoContribuinte<T> withTextoDeDescricao(java.lang.String textoDeDescricao);

    @net.vidageek.fluid.annotations.FluidField("xCampo")
    ObservacaoDoContribuinte<T> withDescricaoDoCampo(java.lang.String descricaoDoCampo);

}