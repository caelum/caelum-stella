package br.com.caelum.stella.nfe.builder.generated;

public final class PISSTImpl implements PISST, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.PISST pISST;

    public PISSTImpl() {
        this.pISST = new br.com.caelum.stella.nfe.modelo.PISST();
    }

    public br.com.caelum.stella.nfe.modelo.PISST getInstance() {
        return this.pISST;
    }

    public PISST withVBC(String string) {
        this.pISST.setVBC(string);
        return this;
    }

    public PISST withPPIS(String string) {
        this.pISST.setPPIS(string);
        return this;
    }

    public PISST withQuantidadeVendida(String string) {
        this.pISST.setQBCProd(string);
        return this;
    }

    public PISST withAliquota(String string) {
        this.pISST.setVAliqProd(string);
        return this;
    }

    public PISST withVPIS(String string) {
        this.pISST.setVPIS(string);
        return this;
    }
}