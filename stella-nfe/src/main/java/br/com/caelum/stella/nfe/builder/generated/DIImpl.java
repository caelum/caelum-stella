package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.UF;

public final class DIImpl implements DI, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.DI dI;

    public DIImpl() {
        dI = new br.com.caelum.stella.nfe.modelo.DI();
    }

    public br.com.caelum.stella.nfe.modelo.DI getInstance() {
        return dI;
    }

    public DI withNDI(final String string) {
        dI.setNDI(string);
        return this;
    }

    public DI withDDI(final Calendar calendar) {
        dI.setDDI(calendar);
        return this;
    }

    public DI withXLocDesemb(final String string) {
        dI.setXLocDesemb(string);
        return this;
    }

    public DI withUFDesemb(final UF tUf) {
        dI.setUFDesemb(tUf);
        return this;
    }

    public DI withDDesemb(final Calendar calendar) {
        dI.setDDesemb(calendar);
        return this;
    }

    public DI withCExportador(final String string) {
        dI.setCExportador(string);
        return this;
    }

    public DI withAdi(final Adi... adis) {
        List<br.com.caelum.stella.nfe.modelo.Adi> list = new ArrayList<br.com.caelum.stella.nfe.modelo.Adi>();
        for (Adi p : adis) {
            list.add((br.com.caelum.stella.nfe.modelo.Adi) ((ObjectCreator) p).getInstance());
        }
        dI.setAdi(list);
        return this;
    }
}