package br.com.caelum.stella.nfe.builder.generated;

public final class ObsFiscoImpl implements ObsFisco, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ObsFisco obsFisco;

    public ObsFiscoImpl() {
        this.obsFisco = new br.com.caelum.stella.nfe.modelo.ObsFisco();
    }

    public br.com.caelum.stella.nfe.modelo.ObsFisco getInstance() {
        return this.obsFisco;
    }

    public ObsFisco withXTexto(String string) {
        this.obsFisco.setXTexto(string);
        return this;
    }

    public ObsFisco withXCampo(String string) {
        this.obsFisco.setXCampo(string);
        return this;
    }
}