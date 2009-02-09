package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.tinytype.CNPJ;

public final class RefNFImpl implements RefNF, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.RefNF refNF;

    public RefNFImpl() {
        this.refNF = new br.com.caelum.stella.nfe.modelo.RefNF();
    }

    public br.com.caelum.stella.nfe.modelo.RefNF getInstance() {
        return this.refNF;
    }

    public RefNF withCUF(String string) {
        this.refNF.setCUF(string);
        return this;
    }

    public RefNF withAAMM(String string) {
        this.refNF.setAAMM(string);
        return this;
    }

    public RefNF withCNPJ(CNPJ cnpj) {
        this.refNF.setCNPJ(cnpj.getNumero());
        return this;
    }

    public RefNF withMod(String string) {
        this.refNF.setMod(string);
        return this;
    }

    public RefNF withSerie(String string) {
        this.refNF.setSerie(string);
        return this;
    }

    public RefNF withNNF(String string) {
        this.refNF.setNNF(string);
        return this;
    }
}