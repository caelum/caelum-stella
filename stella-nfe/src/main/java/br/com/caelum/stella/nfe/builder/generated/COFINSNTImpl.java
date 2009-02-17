package br.com.caelum.stella.nfe.builder.generated;

public final class COFINSNTImpl implements COFINSNT, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.COFINSNT cOFINSNT;

    public COFINSNTImpl() {
        cOFINSNT = new br.com.caelum.stella.nfe.modelo.COFINSNT();
    }

    public br.com.caelum.stella.nfe.modelo.COFINSNT getInstance() {
        return cOFINSNT;
    }

    public COFINSNT withCodigoSituacaoTributaria(final String string) {
        cOFINSNT.setCodigoSituacaoTributaria(string);
        return this;
    }
}