package br.com.caelum.stella.nfe.builder.generated;

public final class COFINSNaoTributadoImpl implements COFINSNaoTributado, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.COFINSNT cOFINSNT;

    public COFINSNaoTributadoImpl() {
        cOFINSNT = new br.com.caelum.stella.nfe.modelo.COFINSNT();
    }

    public br.com.caelum.stella.nfe.modelo.COFINSNT getInstance() {
        return cOFINSNT;
    }

    public COFINSNaoTributado withCodigoSituacaoTributaria(final String string) {
        cOFINSNT.setCodigoSituacaoTributaria(string);
        return this;
    }
}