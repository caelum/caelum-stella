package br.com.caelum.stella.nfe.fluid;

@net.vidageek.fluid.annotations.FluidClass(br.com.caelum.stella.nfe.modelo.TRetEnviNFe.class)
public interface retornoDoPedidoDeConcessaoDeAutorizacaoDaNFE<T> extends net.vidageek.fluid.FluidInterface<T> {

    @net.vidageek.fluid.annotations.FluidField("tpAmb")
    retornoDoPedidoDeConcessaoDeAutorizacaoDaNFE<T> withTipoDoAmbiente(java.lang.String tipoDoAmbiente);

    @net.vidageek.fluid.annotations.FluidField("verAplic")
    retornoDoPedidoDeConcessaoDeAutorizacaoDaNFE<T> withVersaoAplicativo(java.lang.String versaoAplicativo);

    @net.vidageek.fluid.annotations.FluidField("cStat")
    retornoDoPedidoDeConcessaoDeAutorizacaoDaNFE<T> withCodigoDeStatus(java.lang.String codigoDeStatus);

    @net.vidageek.fluid.annotations.FluidField("xMotivo")
    retornoDoPedidoDeConcessaoDeAutorizacaoDaNFE<T> withDescricaoDoStatus(java.lang.String descricaoDoStatus);

    @net.vidageek.fluid.annotations.FluidField("cuf")
    retornoDoPedidoDeConcessaoDeAutorizacaoDaNFE<T> withCodigoDaUF(java.lang.String codigoDaUF);

    @net.vidageek.fluid.annotations.FluidField("infRec")
    ReciboDoLote<retornoDoPedidoDeConcessaoDeAutorizacaoDaNFE<T>> withReciboDoLote();

    @net.vidageek.fluid.annotations.FluidField("versao")
    retornoDoPedidoDeConcessaoDeAutorizacaoDaNFE<T> withVersaoDaNFE(java.lang.String versaoDaNFE);

}