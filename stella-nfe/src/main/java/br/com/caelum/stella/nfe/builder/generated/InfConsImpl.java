package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.TUfCons;

public final class InfConsImpl<T> implements InfCons<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.InfCons infCons;
    private final T parent;

    public InfConsImpl(final T parent) {
        this.parent = parent;
        infCons = new br.com.caelum.stella.nfe.modelo.InfCons();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) infCons;
    }

    public InfCons<T> withVerAplic(final String string) {
        infCons.setVerAplic(string);
        return this;
    }

    public InfCons<T> withCStat(final String string) {
        infCons.setCStat(string);
        return this;
    }

    public InfCons<T> withXMotivo(final String string) {
        infCons.setXMotivo(string);
        return this;
    }

    public InfCons<T> withUF(final TUfCons tUfCons) {
        infCons.setUF(tUfCons);
        return this;
    }

    public InfCons<T> withIE(final String string) {
        infCons.setIE(string);
        return this;
    }

    public InfCons<T> withCNPJ(final String string) {
        infCons.setCNPJ(string);
        return this;
    }

    public InfCons<T> withCPF(final String string) {
        infCons.setCPF(string);
        return this;
    }

    public InfCons<T> withDhCons(final Calendar calendar) {
        infCons.setDhCons(calendar.toString());
        return this;
    }

    public InfCons<T> withCUF(final String string) {
        infCons.setCUF(string);
        return this;
    }

    public InfCons<T> withInfCad(final List<InfCad<?>> listInf) {
        List<br.com.caelum.stella.nfe.modelo.InfCad> list = new ArrayList<br.com.caelum.stella.nfe.modelo.InfCad>();
        for (InfCad<?> infCad : listInf) {
            list.add((br.com.caelum.stella.nfe.modelo.InfCad) ((ObjectCreator) infCad).getInstance());

        }
        infCons.setInfCad(list);
        return this;
    }
}