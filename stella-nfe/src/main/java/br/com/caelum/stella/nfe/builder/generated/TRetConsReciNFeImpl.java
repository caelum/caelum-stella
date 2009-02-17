package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class TRetConsReciNFeImpl implements TRetConsReciNFe, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TRetConsReciNFe tRetConsReciNFe;

    public TRetConsReciNFeImpl() {
        tRetConsReciNFe = new br.com.caelum.stella.nfe.modelo.TRetConsReciNFe();
    }

    public br.com.caelum.stella.nfe.modelo.TRetConsReciNFe getInstance() {
        return tRetConsReciNFe;
    }

    public TRetConsReciNFe withTpAmb(final String string) {
        tRetConsReciNFe.setTpAmb(string);
        return this;
    }

    public TRetConsReciNFe withVerAplic(final String string) {
        tRetConsReciNFe.setVerAplic(string);
        return this;
    }

    public TRetConsReciNFe withNRec(final String string) {
        tRetConsReciNFe.setNRec(string);
        return this;
    }

    public TRetConsReciNFe withCodigoDeStatus(final String string) {
        tRetConsReciNFe.setCStat(string);
        return this;
    }

    public TRetConsReciNFe withXMotivo(final String string) {
        tRetConsReciNFe.setXMotivo(string);
        return this;
    }

    public TRetConsReciNFe withCUF(final String string) {
        tRetConsReciNFe.setCUF(string);
        return this;
    }

    public TRetConsReciNFe withProtNFe(final TProtNFe... protNFe) {
        List<br.com.caelum.stella.nfe.modelo.TProtNFe> list = new ArrayList<br.com.caelum.stella.nfe.modelo.TProtNFe>();
        for (TProtNFe p : protNFe) {
            list.add((br.com.caelum.stella.nfe.modelo.TProtNFe) ((ObjectCreator) p).getInstance());
        }
        tRetConsReciNFe.setProtNFe(list);
        return this;
    }

    public TRetConsReciNFe withVersao(final String string) {
        tRetConsReciNFe.setVersao(string);
        return this;
    }
}