package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.generated.enums.OrigemDoProcesso;

public final class ProcessoReferenciadoImpl<T> implements ProcessoReferenciado<T>,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ProcRef procRef;
    private final T parent;

    public ProcessoReferenciadoImpl(final T parent) {
        this.parent = parent;
        procRef = new br.com.caelum.stella.nfe.modelo.ProcRef();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.procRef;
    }

    public ProcessoReferenciado<T> withIdentificadorDoProcesso(final String string) {
        procRef.setNProc(string);
        return this;
    }

    public ProcessoReferenciado<T> withOrigemDoProcesso(final OrigemDoProcesso string) {
        procRef.setIndProc(string.getCode());
        return this;
    }
}