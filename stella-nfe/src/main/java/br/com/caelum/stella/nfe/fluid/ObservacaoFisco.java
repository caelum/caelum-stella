package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.ObsFisco.class)
public interface ObservacaoFisco<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("xTexto")
    ObservacaoFisco<T> withDescricaoDoTexto(java.lang.String descricaoDoTexto);

    @net.vidageek.fluid.annotations.FluidField("xCampo")
    ObservacaoFisco<T> withDescricaoDoCampo(java.lang.String descricaoDoCampo);

}