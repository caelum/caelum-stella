package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class PedidoDeAutorizacaoDaNFEImpl implements PedidoDeAutorizacaoDaNFE,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TEnviNFe tEnviNFe;

    public PedidoDeAutorizacaoDaNFEImpl() {
        tEnviNFe = new br.com.caelum.stella.nfe.modelo.TEnviNFe();
    }

    public br.com.caelum.stella.nfe.modelo.TEnviNFe getInstance() {
        return tEnviNFe;
    }

    public PedidoDeAutorizacaoDaNFE withIdDoLote(final String string) {
        tEnviNFe.setIdLote(string);
        return this;
    }

    public PedidoDeAutorizacaoDaNFE withNFE(final NFE... nfes) {
        List<br.com.caelum.stella.nfe.modelo.TNFe> list = new ArrayList<br.com.caelum.stella.nfe.modelo.TNFe>();
        for (NFE p : nfes) {
            list.add((br.com.caelum.stella.nfe.modelo.TNFe) ((ObjectCreator) p).getInstance());
        }
        tEnviNFe.setNFe(list);
        return this;
    }

    public PedidoDeAutorizacaoDaNFE withVersao(final String string) {
        tEnviNFe.setVersao(string);
        return this;
    }
}