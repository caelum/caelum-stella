package br.com.caelum.stella.nfe.builder.generated;

public final class CompraImpl<T> implements Compra<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Compra compra;
    private final T parent;

    public CompraImpl(final T parent) {
        this.parent = parent;
        this.compra = new br.com.caelum.stella.nfe.modelo.Compra();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.compra;
    }

    public Compra<T> withInformacoesDaNotaDeEmpenhoDeComprasPublicas(final String string) {
        this.compra.setXNEmp(string);
        return this;
    }

    public Compra<T> withInformacaoDoPedido(final String string) {
        this.compra.setXPed(string);
        return this;
    }

    public Compra<T> withInformacaoDoContrato(final String string) {
        this.compra.setXCont(string);
        return this;
    }
}