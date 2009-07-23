package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TConsReciNFe.class)
public interface PedidoDeConsultaDoRecidoDoLoteDeNFE<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("tpAmb")
    PedidoDeConsultaDoRecidoDoLoteDeNFE<T> withTipoDoAmbiente(java.lang.String tipoDoAmbiente);

    @net.vidageek.fluid.annotations.FluidField("nRec")
    PedidoDeConsultaDoRecidoDoLoteDeNFE<T> withNumeroDoRecibo(java.lang.String numeroDoRecibo);

    @net.vidageek.fluid.annotations.FluidField("versao")
    PedidoDeConsultaDoRecidoDoLoteDeNFE<T> withVersao(java.lang.String versao);

}