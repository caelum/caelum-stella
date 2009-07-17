package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.UF;

public final class ExportacaoImpl<T> implements Exportacao<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Exporta exporta;
    private final T parent;

    public ExportacaoImpl(final T parent) {
        this.parent = parent;
        exporta = new br.com.caelum.stella.nfe.modelo.Exporta();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.exporta;
    }

    public Exportacao<T> withUFDoEmbarque(final UF tUf) {
        exporta.setUFEmbarq(tUf);
        return this;
    }

    public Exportacao<T> withLocalDoEmbarque(final String string) {
        exporta.setXLocEmbarq(string);
        return this;
    }
}