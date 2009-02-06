package br.com.caelum.stella.nfe.builder.generated;

public final class COFINSAliqImpl implements COFINSAliq, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.COFINSAliq cOFINSAliq;

    public COFINSAliqImpl() {
        cOFINSAliq = new br.com.caelum.stella.nfe.modelo.COFINSAliq();
    }

    public br.com.caelum.stella.nfe.modelo.COFINSAliq getInstance() {
        return cOFINSAliq;
    }

    public COFINSAliq withCST(final String string) {
        cOFINSAliq.setCodigoSituacaoTributaria(string);
        return this;
    }

    public COFINSAliq withVBC(final String string) {
        cOFINSAliq.setValorBaseCalculo(string);
        return this;
    }

    public COFINSAliq withPCOFINS(final String string) {
        cOFINSAliq.setAliquotaEmPercentual(string);
        return this;
    }

    public COFINSAliq withVCOFINS(final String string) {
        cOFINSAliq.setValor(string);
        return this;
    }
}