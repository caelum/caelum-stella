package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.Compra.class)
public interface Compra<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("xnEmp")
    Compra<T> withInformacoesDaNotaDeEmpenhoDeComprasPublicas(java.lang.String informacoesDaNotaDeEmpenhoDeComprasPublicas);

    @net.vidageek.fluid.annotations.FluidField("xPed")
    Compra<T> withInformacaoDoPedido(java.lang.String informacaoDoPedido);

    @net.vidageek.fluid.annotations.FluidField("xCont")
    Compra<T> withInformacaoDoContrato(java.lang.String informacaoDoContrato);

}