package br.com.caelum.stella.nfe.builder.generated;

public final class PISQtdeImpl implements PISQtde, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.PISQtde pISQtde;

    public PISQtdeImpl() {
        this.pISQtde = new br.com.caelum.stella.nfe.modelo.PISQtde();
    }

    public br.com.caelum.stella.nfe.modelo.PISQtde getInstance() {
        return this.pISQtde;
    }

    public PISQtde withCST(String string) {
        this.pISQtde.setCST(string);
        return this;
    }

    public PISQtde withQBCProd(String string) {
        this.pISQtde.setQBCProd(string);
        return this;
    }

    public PISQtde withVAliqProd(String string) {
        this.pISQtde.setVAliqProd(string);
        return this;
    }

    public PISQtde withVPIS(String string) {
        this.pISQtde.setVPIS(string);
        return this;
    }
}