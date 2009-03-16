package br.com.caelum.stella.nfe.builder.generated;

public final class ObservacoesDoContribuinteImpl implements ObservacoesDoContribuinte, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ObsCont obsCont;

    public ObservacoesDoContribuinteImpl() {
        obsCont = new br.com.caelum.stella.nfe.modelo.ObsCont();
    }

    public br.com.caelum.stella.nfe.modelo.ObsCont getInstance() {
        return obsCont;
    }

    public ObservacoesDoContribuinte withTextoDeDescricao(final String string) {
        obsCont.setXTexto(string);
        return this;
    }

    public ObservacoesDoContribuinte withDescricaoDoCampo(final String string) {
        obsCont.setXCampo(string);
        return this;
    }
}