package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class VolImpl implements Vol, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Vol vol;

    public VolImpl() {
        vol = new br.com.caelum.stella.nfe.modelo.Vol();
    }

    public br.com.caelum.stella.nfe.modelo.Vol getInstance() {
        return vol;
    }

    public Vol withQVol(final Long string) {
        vol.setQVol(string.toString());
        return this;
    }

    public Vol withEsp(final String string) {
        vol.setEsp(string);
        return this;
    }

    public Vol withMarca(final String string) {
        vol.setMarca(string);
        return this;
    }

    public Vol withNVol(final String string) {
        vol.setNVol(string);
        return this;
    }

    public Vol withPesoL(final String string) {
        vol.setPesoL(string);
        return this;
    }

    public Vol withPesoB(final String string) {
        vol.setPesoB(string);
        return this;
    }

    public Vol withLacres(final Lacres... lacres) {
        List<br.com.caelum.stella.nfe.modelo.Lacres> list = new ArrayList<br.com.caelum.stella.nfe.modelo.Lacres>();
        for (Lacres l : lacres) {
            list.add((br.com.caelum.stella.nfe.modelo.Lacres) ((ObjectCreator) l).getInstance());
        }

        vol.setLacres(list);

        return this;
    }
}