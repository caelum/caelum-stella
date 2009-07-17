package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class PedidoDeAutorizacaoDaNFEImpl<T> implements PedidoDeAutorizacaoDaNFE<T>,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TEnviNFe tEnviNFe;
    private final T parent;

    public PedidoDeAutorizacaoDaNFEImpl(final T parent) {
        this.parent = parent;
        tEnviNFe = new br.com.caelum.stella.nfe.modelo.TEnviNFe();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.tEnviNFe;
    }

    public PedidoDeAutorizacaoDaNFE<T> withIdDoLote(final String string) {
        tEnviNFe.setIdLote(string);
        return this;
    }

    public PedidoDeAutorizacaoDaNFE<T> withNFE(final NFE<?>... nfes) {
        List<br.com.caelum.stella.nfe.modelo.TNFe> list = new ArrayList<br.com.caelum.stella.nfe.modelo.TNFe>();
        for (NFE<?> p : nfes) {
            list.add((br.com.caelum.stella.nfe.modelo.TNFe) ((ObjectCreator) p).getInstance());
        }
        tEnviNFe.setNFe(list);
        return this;
    }

    public PedidoDeAutorizacaoDaNFE<T> withVersao(final String string) {
        tEnviNFe.setVersao(string);
        return this;
    }
}