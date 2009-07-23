package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.Dup.class)
public interface Duplicata<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("nDup")
    Duplicata<T> withNumero(java.lang.String numero);

    @net.vidageek.fluid.annotations.FluidField("dVenc")
    Duplicata<T> withDataDeVencimento(java.lang.String dataDeVencimento);

    @net.vidageek.fluid.annotations.FluidField("vDup")
    Duplicata<T> withValorDaDuplicata(java.lang.String valorDaDuplicata);

}