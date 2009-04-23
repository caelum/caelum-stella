package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class InfCadEmiDFeImpl implements InfCadEmiDFe, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.InfCadEmiDFe infCadEmiDFe;

    public InfCadEmiDFeImpl() {
        infCadEmiDFe = new br.com.caelum.stella.nfe.modelo.InfCadEmiDFe();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) infCadEmiDFe;
    }

    public InfCadEmiDFe withDPubCad(final Calendar calendar) {
        infCadEmiDFe.setDPubCad(calendar.toString());
        return this;
    }

    public InfCadEmiDFe withEmissor(final List<TEmissor> listEmissor) {
        List<br.com.caelum.stella.nfe.modelo.TEmissor> list = new ArrayList<br.com.caelum.stella.nfe.modelo.TEmissor>();
        for (TEmissor emissor : listEmissor) {
            list.add((br.com.caelum.stella.nfe.modelo.TEmissor) ((ObjectCreator) emissor).getInstance());
        }
        infCadEmiDFe.setEmissor(list);
        return this;
    }

    public InfCadEmiDFe withId(final String string) {
        infCadEmiDFe.setId(string);
        return this;
    }
}