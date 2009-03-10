package br.com.caelum.stella.nfe.builder.generated;

//TODO Essa classe deve virar apenas um campo onde ela Ž neces‡ria
public final class PISNaoTributadoImpl implements PISNaoTributado, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.PISNT pISNT;

    public PISNaoTributadoImpl() {
        pISNT = new br.com.caelum.stella.nfe.modelo.PISNT();
    }

    public br.com.caelum.stella.nfe.modelo.PISNT getInstance() {
        return pISNT;
    }

    // TODO Deve ser uma enum
    public PISNaoTributado withCodigoSituacaoTributaria(final String string) {
        pISNT.setCST(string);
        return this;
    }
}