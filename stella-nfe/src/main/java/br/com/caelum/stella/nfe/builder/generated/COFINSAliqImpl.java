package br.com.caelum.stella.nfe.builder.generated;

public final class COFINSAliqImpl implements COFINSAliq, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.COFINSAliq cOFINSAliq;

    public COFINSAliqImpl() {
        cOFINSAliq = new br.com.caelum.stella.nfe.modelo.COFINSAliq();
    }

    public br.com.caelum.stella.nfe.modelo.COFINSAliq getInstance() {
        return cOFINSAliq;
    }

    public COFINSAliq withCodigoSituacaoTributaria(final String string) {
        cOFINSAliq.setCodigoSituacaoTributaria(string);
        return this;
    }

    public COFINSAliq withValorDaBaseDeCalculo(final String string) {
        cOFINSAliq.setvalorDaBaseDeCalculo(string);
        return this;
    }

    public COFINSAliq withAliquotaEmPercentual(final String string) {
        cOFINSAliq.setAliquotaEmPercentual(string);
        return this;
    }

    public COFINSAliq withValor(final String string) {
        cOFINSAliq.setValor(string);
        return this;
    }
}