package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDoAmbiente;

public interface PedidoDeConsultaDoRecidoDoLoteDeNFE<T> extends NFeBuilder<T> {
    public PedidoDeConsultaDoRecidoDoLoteDeNFE<T> withTipoDoAmbiente(TipoDoAmbiente tipoDoAmbiente);

    public PedidoDeConsultaDoRecidoDoLoteDeNFE<T> withNumeroDoRecibo(String string);

    public PedidoDeConsultaDoRecidoDoLoteDeNFE<T> withVersao(String string);
}