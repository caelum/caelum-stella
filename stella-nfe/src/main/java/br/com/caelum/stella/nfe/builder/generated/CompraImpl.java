package br.com.caelum.stella.nfe.builder.generated;

public final class CompraImpl implements Compra, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Compra compra;

    public CompraImpl() {
        this.compra = new br.com.caelum.stella.nfe.modelo.Compra();
    }

    public br.com.caelum.stella.nfe.modelo.Compra getInstance() {
        return this.compra;
    }

    public Compra withXNEmp(String string) {
        this.compra.setXNEmp(string);
        return this;
    }

    public Compra withXPed(String string) {
        this.compra.setXPed(string);
        return this;
    }

    public Compra withXCont(String string) {
        this.compra.setXCont(string);
        return this;
    }
}