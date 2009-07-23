package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.CabecMsg.class)
public interface Cabecalho<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("versaoDados")
    Cabecalho<T> withVersaoDados(java.lang.String versaoDados);

    @net.vidageek.fluid.annotations.FluidField("versao")
    Cabecalho<T> withVersao(java.lang.String versao);

}