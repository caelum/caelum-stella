package br.com.caelum.stella.nfe.builder.generated;

public final class IPINTImpl implements IPINT, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.IPINT iPINT;

    public IPINTImpl() {
        iPINT = new br.com.caelum.stella.nfe.modelo.IPINT();
    }

    public br.com.caelum.stella.nfe.modelo.IPINT getInstance() {
        return iPINT;
    }

    public IPINT withCodigoSituacaoTributaria(final String string) {
        iPINT.setCodigoSituacaoTributaria(string);
        return this;
    }
}