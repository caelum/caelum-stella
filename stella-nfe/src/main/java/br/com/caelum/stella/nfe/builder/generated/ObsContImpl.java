package br.com.caelum.stella.nfe.builder.generated;

public final class ObsContImpl implements ObsCont, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.ObsCont obsCont;

    public ObsContImpl() {
        this.obsCont = new br.com.caelum.stella.nfe.modelo.ObsCont();
    }

    public br.com.caelum.stella.nfe.modelo.ObsCont getInstance() {
        return this.obsCont;
    }

    public ObsCont withXTexto(String string) {
        this.obsCont.setXTexto(string);
        return this;
    }

    public ObsCont withXCampo(String string) {
        this.obsCont.setXCampo(string);
        return this;
    }
}