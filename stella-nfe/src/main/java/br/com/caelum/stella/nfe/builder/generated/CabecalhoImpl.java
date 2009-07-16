package br.com.caelum.stella.nfe.builder.generated;

public final class CabecalhoImpl implements Cabecalho, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.CabecMsg cabecMsg;

    public CabecalhoImpl() {
        cabecMsg = new br.com.caelum.stella.nfe.modelo.CabecMsg();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) cabecMsg;
    }

    public Cabecalho withVersaoDados(final String string) {
        cabecMsg.setVersaoDados(string);
        return this;
    }

    public Cabecalho withVersao(final String string) {
        cabecMsg.setVersao(string);
        return this;
    }
}