package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.generated.enums.OrigemDoProcesso;

public final class ProcessoReferenciadoImpl implements ProcessoReferenciado, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ProcRef procRef;

    public ProcessoReferenciadoImpl() {
        procRef = new br.com.caelum.stella.nfe.modelo.ProcRef();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.procRef;
    }

    public ProcessoReferenciado withIdentificadorDoProcesso(final String string) {
        procRef.setNProc(string);
        return this;
    }

    public ProcessoReferenciado withOrigemDoProcesso(final OrigemDoProcesso string) {
        procRef.setIndProc(string.getCode());
        return this;
    }
}