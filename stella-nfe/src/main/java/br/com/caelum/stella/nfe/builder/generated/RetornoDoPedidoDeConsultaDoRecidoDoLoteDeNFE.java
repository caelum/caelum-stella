package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.generated.enums.TipoDoAmbiente;

public interface RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE {
    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE withTipoDeAmbiente(TipoDoAmbiente tipoDoAmbiente);

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE withVersaoDaAplicativo(String string);

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE withNumeroDoReciboConsultado(String string);

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE withCodigoDeStatus(String string);

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE withDescricaoDoStatus(String string);

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE withCodigoDaUF(String string);

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE withProtocoloDoResultadoDeProcessamento(
            ProtocoloDoResultadoDeProcessamento... protocolosDoResultadoDeProcessamento);

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE withVersaoNFE(String string);
}