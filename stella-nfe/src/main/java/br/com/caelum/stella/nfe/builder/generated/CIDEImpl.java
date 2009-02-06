package br.com.caelum.stella.nfe.builder.generated;

public final class CIDEImpl implements CIDE, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.CIDE cIDE;

    public CIDEImpl() {
        this.cIDE = new br.com.caelum.stella.nfe.modelo.CIDE();
    }

    public br.com.caelum.stella.nfe.modelo.CIDE getInstance() {
        return this.cIDE;
    }

    public CIDE withQBCProd(String string) {
        this.cIDE.setQBCProd(string);
        return this;
    }

    public CIDE withVAliqProd(String string) {
        this.cIDE.setVAliqProd(string);
        return this;
    }

    public CIDE withVCIDE(String string) {
        this.cIDE.setVCIDE(string);
        return this;
    }
}