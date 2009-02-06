package br.com.caelum.stella.nfe.builder.generated;

public final class ISSQNImpl implements ISSQN, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ISSQN iSSQN;

    public ISSQNImpl() {
        iSSQN = new br.com.caelum.stella.nfe.modelo.ISSQN();
    }

    public br.com.caelum.stella.nfe.modelo.ISSQN getInstance() {
        return iSSQN;
    }

    public ISSQN withVBC(final String string) {
        iSSQN.setValorBaseCalculo(string);
        return this;
    }

    public ISSQN withVAliq(final String string) {
        iSSQN.setAliquota(string);
        return this;
    }

    public ISSQN withVISSQN(final String string) {
        iSSQN.setValorISSQN(string);
        return this;
    }

    public ISSQN withCMunFG(final String string) {
        iSSQN.setCodigoMunicipio(string);
        return this;
    }

    public ISSQN withCListServ(final String string) {
        iSSQN.setCodigoListaServicos(string);
        return this;
    }
}