package br.com.caelum.stella.nfe.builder.generated;

public final class ObservacaoFiscoImpl implements ObservacaoFisco, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ObsFisco obsFisco;

    public ObservacaoFiscoImpl() {
        obsFisco = new br.com.caelum.stella.nfe.modelo.ObsFisco();
    }

    public br.com.caelum.stella.nfe.modelo.ObsFisco getInstance() {
        return obsFisco;
    }

    public ObservacaoFisco withDescricaoDoTexto(final String string) {
        obsFisco.setXTexto(string);
        return this;
    }

    public ObservacaoFisco withDescricaoDoCampo(final String string) {
        obsFisco.setXCampo(string);
        return this;
    }
}