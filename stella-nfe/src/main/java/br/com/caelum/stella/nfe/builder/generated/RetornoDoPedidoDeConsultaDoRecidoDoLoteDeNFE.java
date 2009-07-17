package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDoAmbiente;

public interface RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> extends NFeBuilder<T> {
    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> withTipoDeAmbiente(TipoDoAmbiente tipoDoAmbiente);

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> withVersaoDaAplicativo(String string);

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> withNumeroDoReciboConsultado(String string);

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> withCodigoDeStatus(String string);

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> withDescricaoDoStatus(String string);

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> withCodigoDaUF(String string);

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> withProtocoloDoResultadoDeProcessamento(
            ProtocoloDoResultadoDeProcessamento<?>... protocolosDoResultadoDeProcessamento);

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE<T> withVersaoNFE(String string);
}