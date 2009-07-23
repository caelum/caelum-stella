package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TRetConsReciNFe.class)
public interface retornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("tpAmb")
    retornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> withTipoDeAmbiente(java.lang.String tipoDeAmbiente);

    @net.vidageek.fluid.annotations.FluidField("verAplic")
    retornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> withVersaoDaAplicativo(java.lang.String versaoDaAplicativo);

    @net.vidageek.fluid.annotations.FluidField("nRec")
    retornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> withNumeroDoReciboConsultado(java.lang.String numeroDoReciboConsultado);

    @net.vidageek.fluid.annotations.FluidField("cStat")
    retornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> withCodigoDeStatus(java.lang.String codigoDeStatus);

    @net.vidageek.fluid.annotations.FluidField("xMotivo")
    retornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> withDescricaoDoStatus(java.lang.String descricaoDoStatus);

    @net.vidageek.fluid.annotations.FluidField("cuf")
    retornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> withCodigoDaUF(java.lang.String codigoDaUF);

    @net.vidageek.fluid.annotations.FluidField("protNFe")
    retornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> addProtocoloDoResultadoDeProcessamento();

    @net.vidageek.fluid.annotations.FluidField("versao")
    retornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> withVersaoNFE(java.lang.String versaoNFE);

}