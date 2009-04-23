package br.com.caelum.stella.nfe.builder.generated;

public final class CompraImpl implements Compra, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Compra compra;

    public CompraImpl() {
        this.compra = new br.com.caelum.stella.nfe.modelo.Compra();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.compra;
    }

    public Compra withInformacoesDaNotaDeEmpenhoDeComprasPublicas(String string) {
        this.compra.setXNEmp(string);
        return this;
    }

    public Compra withInformacaoDoPedido(String string) {
        this.compra.setXPed(string);
        return this;
    }

    public Compra withInformacaoDoContrato(String string) {
        this.compra.setXCont(string);
        return this;
    }
}