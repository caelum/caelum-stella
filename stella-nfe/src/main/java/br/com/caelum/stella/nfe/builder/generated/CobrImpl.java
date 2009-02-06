package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class CobrImpl implements Cobr, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Cobr cobr;

    public CobrImpl() {
        cobr = new br.com.caelum.stella.nfe.modelo.Cobr();
    }

    public br.com.caelum.stella.nfe.modelo.Cobr getInstance() {
        return cobr;
    }

    public Cobr withFat(final Fat fat) {
        cobr.setFat((br.com.caelum.stella.nfe.modelo.Fat) ((ObjectCreator) fat).getInstance());
        return this;
    }

    public Cobr withDup(final Dup... dups) {
        List<br.com.caelum.stella.nfe.modelo.Dup> list = new ArrayList<br.com.caelum.stella.nfe.modelo.Dup>();
        for (Dup p : dups) {
            list.add((br.com.caelum.stella.nfe.modelo.Dup) ((ObjectCreator) p).getInstance());
        }
        cobr.setDup(list);
        return this;
    }
}