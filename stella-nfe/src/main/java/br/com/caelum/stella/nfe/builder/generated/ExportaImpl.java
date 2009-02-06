package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.TUf;

public final class ExportaImpl implements Exporta, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Exporta exporta;

    public ExportaImpl() {
        this.exporta = new br.com.caelum.stella.nfe.modelo.Exporta();
    }

    public br.com.caelum.stella.nfe.modelo.Exporta getInstance() {
        return this.exporta;
    }

    public Exporta withUFEmbarq(TUf tUf) {
        this.exporta.setUFEmbarq(tUf);
        return this;
    }

    public Exporta withXLocEmbarq(String string) {
        this.exporta.setXLocEmbarq(string);
        return this;
    }
}