package br.com.caelum.stella.nfe.builder.generated;

public final class CabecMsgImpl implements CabecMsg, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.CabecMsg cabecMsg;

    public CabecMsgImpl() {
        this.cabecMsg = new br.com.caelum.stella.nfe.modelo.CabecMsg();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.cabecMsg;
    }

    public CabecMsg withVersaoDados(String string) {
        this.cabecMsg.setVersaoDados(string);
        return this;
    }

    public CabecMsg withVersao(String string) {
        this.cabecMsg.setVersao(string);
        return this;
    }
}