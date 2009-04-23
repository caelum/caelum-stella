package br.com.caelum.stella.nfe.builder.generated;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.modelo.TUfCons;

public final class InfConsImpl implements InfCons, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.InfCons infCons;

    public InfConsImpl() {
        infCons = new br.com.caelum.stella.nfe.modelo.InfCons();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) infCons;
    }

    public InfCons withVerAplic(final String string) {
        infCons.setVerAplic(string);
        return this;
    }

    public InfCons withCStat(final String string) {
        infCons.setCStat(string);
        return this;
    }

    public InfCons withXMotivo(final String string) {
        infCons.setXMotivo(string);
        return this;
    }

    public InfCons withUF(final TUfCons tUfCons) {
        infCons.setUF(tUfCons);
        return this;
    }

    public InfCons withIE(final String string) {
        infCons.setIE(string);
        return this;
    }

    public InfCons withCNPJ(final String string) {
        infCons.setCNPJ(string);
        return this;
    }

    public InfCons withCPF(final String string) {
        infCons.setCPF(string);
        return this;
    }

    public InfCons withDhCons(final Calendar calendar) {
        infCons.setDhCons(calendar.toString());
        return this;
    }

    public InfCons withCUF(final String string) {
        infCons.setCUF(string);
        return this;
    }

    public InfCons withInfCad(final List<InfCad> listInf) {
        List<br.com.caelum.stella.nfe.modelo.InfCad> list = new ArrayList<br.com.caelum.stella.nfe.modelo.InfCad>();
        for (InfCad infCad : listInf) {
            list.add((br.com.caelum.stella.nfe.modelo.InfCad) ((ObjectCreator) infCad).getInstance());

        }
        infCons.setInfCad(list);
        return this;
    }
}