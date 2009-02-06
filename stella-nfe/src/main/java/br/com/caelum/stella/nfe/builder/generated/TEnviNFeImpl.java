package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class TEnviNFeImpl implements TEnviNFe, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TEnviNFe tEnviNFe;

    public TEnviNFeImpl() {
        tEnviNFe = new br.com.caelum.stella.nfe.modelo.TEnviNFe();
    }

    public br.com.caelum.stella.nfe.modelo.TEnviNFe getInstance() {
        return tEnviNFe;
    }

    public TEnviNFe withIdLote(final String string) {
        tEnviNFe.setIdLote(string);
        return this;
    }

    public TEnviNFe withNFe(final TNFe... nfes) {
        List<br.com.caelum.stella.nfe.modelo.TNFe> list = new ArrayList<br.com.caelum.stella.nfe.modelo.TNFe>();
        for (TNFe p : nfes) {
            list.add((br.com.caelum.stella.nfe.modelo.TNFe) ((ObjectCreator) p).getInstance());
        }
        tEnviNFe.setNFe(list);
        return this;
    }

    public TEnviNFe withVersao(final String string) {
        tEnviNFe.setVersao(string);
        return this;
    }
}