package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TEnviNFe.class)
public interface PedidoDeAutorizacaoDaNFE<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("idLote")
    PedidoDeAutorizacaoDaNFE<T> withIdDoLote(java.lang.String idDoLote);

    @net.vidageek.fluid.annotations.FluidField("nFe")
    PedidoDeAutorizacaoDaNFE<T> addNFE();

    @net.vidageek.fluid.annotations.FluidField("versao")
    PedidoDeAutorizacaoDaNFE<T> withVersao(java.lang.String versao);

}