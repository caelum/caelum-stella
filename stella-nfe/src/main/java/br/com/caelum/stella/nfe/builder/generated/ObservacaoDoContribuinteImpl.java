package br.com.caelum.stella.nfe.builder.generated;

public final class ObservacaoDoContribuinteImpl<T> implements ObservacaoDoContribuinte<T>,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ObsCont obsCont;
    private final T parent;

    public ObservacaoDoContribuinteImpl(final T parent) {
        this.parent = parent;
        obsCont = new br.com.caelum.stella.nfe.modelo.ObsCont();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.obsCont;
    }

    public ObservacaoDoContribuinte<T> withTextoDeDescricao(final String string) {
        obsCont.setXTexto(string);
        return this;
    }

    public ObservacaoDoContribuinte<T> withDescricaoDoCampo(final String string) {
        obsCont.setXCampo(string);
        return this;
    }
}