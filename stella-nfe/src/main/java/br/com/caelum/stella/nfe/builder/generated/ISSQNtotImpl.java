package br.com.caelum.stella.nfe.builder.generated;

public final class ISSQNtotImpl implements ISSQNtot, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ISSQNtot iSSQNtot;

    public ISSQNtotImpl() {
        this.iSSQNtot = new br.com.caelum.stella.nfe.modelo.ISSQNtot();
    }

    public br.com.caelum.stella.nfe.modelo.ISSQNtot getInstance() {
        return this.iSSQNtot;
    }

    public ISSQNtot withVServ(String string) {
        this.iSSQNtot.setVServ(string);
        return this;
    }

    public ISSQNtot withVBC(String string) {
        this.iSSQNtot.setVBC(string);
        return this;
    }

    public ISSQNtot withVISS(String string) {
        this.iSSQNtot.setVISS(string);
        return this;
    }

    public ISSQNtot withVPIS(String string) {
        this.iSSQNtot.setVPIS(string);
        return this;
    }

    public ISSQNtot withVCOFINS(String string) {
        this.iSSQNtot.setVCOFINS(string);
        return this;
    }
}