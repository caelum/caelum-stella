package br.com.caelum.stella.nfe.builder.generated;

public final class ObservacaoFiscoImpl<T> implements ObservacaoFisco<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ObsFisco obsFisco;
    private final T parent;

    public ObservacaoFiscoImpl(final T parent) {
        this.parent = parent;
        obsFisco = new br.com.caelum.stella.nfe.modelo.ObsFisco();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.obsFisco;
    }

    public ObservacaoFisco<T> withDescricaoDoTexto(final String string) {
        obsFisco.setXTexto(string);
        return this;
    }

    public ObservacaoFisco<T> withDescricaoDoCampo(final String string) {
        obsFisco.setXCampo(string);
        return this;
    }
}