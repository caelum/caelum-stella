package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class InfCadEmiDFeImpl<T> implements InfCadEmiDFe<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.InfCadEmiDFe infCadEmiDFe;
    private final T parent;

    public InfCadEmiDFeImpl(final T parent) {
        this.parent = parent;
        infCadEmiDFe = new br.com.caelum.stella.nfe.modelo.InfCadEmiDFe();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) infCadEmiDFe;
    }

    public InfCadEmiDFe<T> withDPubCad(final Calendar calendar) {
        infCadEmiDFe.setDPubCad(calendar.toString());
        return this;
    }

    public InfCadEmiDFe<T> withEmissor(final List<TEmissor<?>> listEmissor) {
        List<br.com.caelum.stella.nfe.modelo.TEmissor> list = new ArrayList<br.com.caelum.stella.nfe.modelo.TEmissor>();
        for (TEmissor<?> emissor : listEmissor) {
            list.add((br.com.caelum.stella.nfe.modelo.TEmissor) ((ObjectCreator) emissor).getInstance());
        }
        infCadEmiDFe.setEmissor(list);
        return this;
    }

    public InfCadEmiDFe<T> withId(final String string) {
        infCadEmiDFe.setId(string);
        return this;
    }
}