package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.generated.enums.TipoDoAmbiente;

public final class RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFEImpl implements
        RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TRetConsReciNFe tRetConsReciNFe;

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFEImpl() {
        tRetConsReciNFe = new br.com.caelum.stella.nfe.modelo.TRetConsReciNFe();
    }

    public br.com.caelum.stella.nfe.modelo.TRetConsReciNFe getInstance() {
        return tRetConsReciNFe;
    }

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE withTipoDeAmbiente(final TipoDoAmbiente tipoDoAmbiente) {
        tRetConsReciNFe.setTpAmb(tipoDoAmbiente.getCode());
        return this;
    }

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE withVersaoDaAplicativo(final String string) {
        tRetConsReciNFe.setVerAplic(string);
        return this;
    }

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE withNumeroDoReciboConsultado(final String string) {
        tRetConsReciNFe.setNRec(string);
        return this;
    }

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE withCodigoDeStatus(final String string) {
        tRetConsReciNFe.setCStat(string);
        return this;
    }

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE withDescricaoDoStatus(final String string) {
        tRetConsReciNFe.setXMotivo(string);
        return this;
    }

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE withCodigoDaUF(final String string) {
        tRetConsReciNFe.setCUF(string);
        return this;
    }

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE withProtocoloDoResultadoDeProcessamento(final ProtocoloDoResultadoDeProcessamento... protNFe) {
        List<br.com.caelum.stella.nfe.modelo.TProtNFe> list = new ArrayList<br.com.caelum.stella.nfe.modelo.TProtNFe>();
        for (ProtocoloDoResultadoDeProcessamento p : protNFe) {
            list.add((br.com.caelum.stella.nfe.modelo.TProtNFe) ((ObjectCreator) p).getInstance());
        }
        tRetConsReciNFe.setProtNFe(list);
        return this;
    }

    public RetornoDoPedidoDeConsultaDoRecidoDoLoteDeNFE withVersaoNFE(final String string) {
        tRetConsReciNFe.setVersao(string);
        return this;
    }
}