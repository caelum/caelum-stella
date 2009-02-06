package br.com.caelum.stella.nfe.builder.generated;

public final class ProcRefImpl implements ProcRef, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ProcRef procRef;

    public ProcRefImpl() {
        this.procRef = new br.com.caelum.stella.nfe.modelo.ProcRef();
    }

    public br.com.caelum.stella.nfe.modelo.ProcRef getInstance() {
        return this.procRef;
    }

    public ProcRef withNProc(String string) {
        this.procRef.setNProc(string);
        return this;
    }

    public ProcRef withIndProc(String string) {
        this.procRef.setIndProc(string);
        return this;
    }
}