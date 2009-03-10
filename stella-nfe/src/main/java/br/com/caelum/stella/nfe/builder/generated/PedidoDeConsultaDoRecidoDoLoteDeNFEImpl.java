package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.generated.enums.TipoDoAmbiente;

public final class PedidoDeConsultaDoRecidoDoLoteDeNFEImpl implements PedidoDeConsultaDoRecidoDoLoteDeNFE,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TConsReciNFe tConsReciNFe;

    public PedidoDeConsultaDoRecidoDoLoteDeNFEImpl() {
        tConsReciNFe = new br.com.caelum.stella.nfe.modelo.TConsReciNFe();
    }

    public br.com.caelum.stella.nfe.modelo.TConsReciNFe getInstance() {
        return tConsReciNFe;
    }

    public PedidoDeConsultaDoRecidoDoLoteDeNFE withTipoDoAmbiente(final TipoDoAmbiente tipoDoAmbiente) {
        tConsReciNFe.setTpAmb(tipoDoAmbiente.getCode());
        return this;
    }

    public PedidoDeConsultaDoRecidoDoLoteDeNFE withNumeroDoRecibo(final String string) {
        tConsReciNFe.setNRec(string);
        return this;
    }

    public PedidoDeConsultaDoRecidoDoLoteDeNFE withVersao(final String string) {
        tConsReciNFe.setVersao(string);
        return this;
    }
}