package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class VolumeImpl implements Volume, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Vol vol;

    public VolumeImpl() {
        vol = new br.com.caelum.stella.nfe.modelo.Vol();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.vol;
    }

    public Volume withQuantidade(final Long string) {
        vol.setQVol(string.toString());
        return this;
    }

    public Volume withEspecie(final String string) {
        vol.setEsp(string);
        return this;
    }

    public Volume withMarca(final String string) {
        vol.setMarca(string);
        return this;
    }

    public Volume withNumeracao(final String string) {
        vol.setNVol(string);
        return this;
    }

    public Volume withPesoLiquido(final String string) {
        vol.setPesoL(string);
        return this;
    }

    public Volume withPesoBruto(final String string) {
        vol.setPesoB(string);
        return this;
    }

    public Volume withLacres(final Lacres... lacres) {
        List<br.com.caelum.stella.nfe.modelo.Lacres> list = new ArrayList<br.com.caelum.stella.nfe.modelo.Lacres>();
        for (Lacres l : lacres) {
            list.add((br.com.caelum.stella.nfe.modelo.Lacres) ((ObjectCreator) l).getInstance());
        }

        vol.setLacres(list);

        return this;
    }
}