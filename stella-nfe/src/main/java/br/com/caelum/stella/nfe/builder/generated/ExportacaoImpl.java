package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.UF;

public final class ExportacaoImpl implements Exportacao, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Exporta exporta;

    public ExportacaoImpl() {
        exporta = new br.com.caelum.stella.nfe.modelo.Exporta();
    }

    public br.com.caelum.stella.nfe.modelo.Exporta getInstance() {
        return exporta;
    }

    public Exportacao withUFDoEmbarque(final UF tUf) {
        exporta.setUFEmbarq(tUf);
        return this;
    }

    public Exportacao withLocalDoEmbarque(final String string) {
        exporta.setXLocEmbarq(string);
        return this;
    }
}