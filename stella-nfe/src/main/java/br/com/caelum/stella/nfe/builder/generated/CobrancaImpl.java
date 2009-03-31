package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class CobrancaImpl implements Cobranca, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Cobr cobr;

    public CobrancaImpl() {
        cobr = new br.com.caelum.stella.nfe.modelo.Cobr();
    }

    public br.com.caelum.stella.nfe.modelo.Cobr getInstance() {
        return cobr;
    }

    public Cobranca withFatura(final Fatura fat) {
        cobr.setFat((br.com.caelum.stella.nfe.modelo.Fat) ((ObjectCreator) fat).getInstance());
        return this;
    }

    public Cobranca withDuplicatas(final Duplicata... dups) {
        List<br.com.caelum.stella.nfe.modelo.Dup> list = new ArrayList<br.com.caelum.stella.nfe.modelo.Dup>();
        for (Duplicata p : dups) {
            list.add((br.com.caelum.stella.nfe.modelo.Dup) ((ObjectCreator) p).getInstance());
        }
        cobr.setDup(list);
        return this;
    }
}