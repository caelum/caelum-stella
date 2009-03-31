package br.com.caelum.stella.nfe.builder.generated;

public final class ObservacaoDoContribuinteImpl implements ObservacaoDoContribuinte,
        br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ObsCont obsCont;

    public ObservacaoDoContribuinteImpl() {
        obsCont = new br.com.caelum.stella.nfe.modelo.ObsCont();
    }

    public br.com.caelum.stella.nfe.modelo.ObsCont getInstance() {
        return obsCont;
    }

    public ObservacaoDoContribuinte withTextoDeDescricao(final String string) {
        obsCont.setXTexto(string);
        return this;
    }

    public ObservacaoDoContribuinte withDescricaoDoCampo(final String string) {
        obsCont.setXCampo(string);
        return this;
    }
}