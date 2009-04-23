package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.TUf;

public final class InfAtuCadEmiDFeImpl implements InfAtuCadEmiDFe, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.InfAtuCadEmiDFe infAtuCadEmiDFe;

    public InfAtuCadEmiDFeImpl() {
        infAtuCadEmiDFe = new br.com.caelum.stella.nfe.modelo.InfAtuCadEmiDFe();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) infAtuCadEmiDFe;
    }

    public InfAtuCadEmiDFe withUF(final TUf tUf) {
        infAtuCadEmiDFe.setUF(tUf);
        return this;
    }

    public InfAtuCadEmiDFe withInclui(final TEmissor tEmissor) {
        infAtuCadEmiDFe.setInclui((br.com.caelum.stella.nfe.modelo.TEmissor) ((ObjectCreator) tEmissor).getInstance());
        return this;
    }

    public InfAtuCadEmiDFe withExclui(final Exclui exclui) {
        infAtuCadEmiDFe.setExclui((br.com.caelum.stella.nfe.modelo.Exclui) ((ObjectCreator) exclui).getInstance());
        return this;
    }

    public InfAtuCadEmiDFe withId(final String string) {
        infAtuCadEmiDFe.setId(string);
        return this;
    }
}