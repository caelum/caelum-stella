package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class VolumeImpl<T> implements Volume<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Vol vol;
    private final T parent;

    public VolumeImpl(final T parent) {
        this.parent = parent;
        vol = new br.com.caelum.stella.nfe.modelo.Vol();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.vol;
    }

    public Volume<T> withQuantidade(final Long string) {
        vol.setQVol(string.toString());
        return this;
    }

    public Volume<T> withEspecie(final String string) {
        vol.setEsp(string);
        return this;
    }

    public Volume<T> withMarca(final String string) {
        vol.setMarca(string);
        return this;
    }

    public Volume<T> withNumeracao(final String string) {
        vol.setNVol(string);
        return this;
    }

    public Volume<T> withPesoLiquido(final String string) {
        vol.setPesoL(string);
        return this;
    }

    public Volume<T> withPesoBruto(final String string) {
        vol.setPesoB(string);
        return this;
    }

    public Volume<T> withLacres(final Lacres<?>... lacres) {
        List<br.com.caelum.stella.nfe.modelo.Lacres> list = new ArrayList<br.com.caelum.stella.nfe.modelo.Lacres>();
        for (Lacres<?> l : lacres) {
            list.add((br.com.caelum.stella.nfe.modelo.Lacres) ((ObjectCreator) l).getInstance());
        }

        vol.setLacres(list);

        return this;
    }
}