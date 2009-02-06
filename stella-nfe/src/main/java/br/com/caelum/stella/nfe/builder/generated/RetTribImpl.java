package br.com.caelum.stella.nfe.builder.generated;

public final class RetTribImpl implements RetTrib, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.RetTrib retTrib;

    public RetTribImpl() {
        this.retTrib = new br.com.caelum.stella.nfe.modelo.RetTrib();
    }

    public br.com.caelum.stella.nfe.modelo.RetTrib getInstance() {
        return this.retTrib;
    }

    public RetTrib withVRetPIS(String string) {
        this.retTrib.setVRetPIS(string);
        return this;
    }

    public RetTrib withVRetCOFINS(String string) {
        this.retTrib.setVRetCOFINS(string);
        return this;
    }

    public RetTrib withVRetCSLL(String string) {
        this.retTrib.setVRetCSLL(string);
        return this;
    }

    public RetTrib withVBCIRRF(String string) {
        this.retTrib.setVBCIRRF(string);
        return this;
    }

    public RetTrib withVIRRF(String string) {
        this.retTrib.setVIRRF(string);
        return this;
    }

    public RetTrib withVBCRetPrev(String string) {
        this.retTrib.setVBCRetPrev(string);
        return this;
    }

    public RetTrib withVRetPrev(String string) {
        this.retTrib.setVRetPrev(string);
        return this;
    }
}