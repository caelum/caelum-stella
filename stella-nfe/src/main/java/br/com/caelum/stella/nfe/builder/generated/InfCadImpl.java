package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.modelo.TEndereco;
import br.com.caelum.stella.nfe.modelo.TUf;

public final class InfCadImpl<T> implements InfCad<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.InfCad infCad;
    private final T parent;

    public InfCadImpl(final T parent) {
        this.parent = parent;
        infCad = new br.com.caelum.stella.nfe.modelo.InfCad();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) infCad;
    }

    public InfCad<T> withIE(final String string) {
        infCad.setIE(string);
        return this;
    }

    public InfCad<T> withCNPJ(final String string) {
        infCad.setCNPJ(string);
        return this;
    }

    public InfCad<T> withCPF(final String string) {
        infCad.setCPF(string);
        return this;
    }

    public InfCad<T> withUF(final TUf tUf) {
        infCad.setUF(tUf);
        return this;
    }

    public InfCad<T> withCSit(final String string) {
        infCad.setCSit(string);
        return this;
    }

    public InfCad<T> withXNome(final String string) {
        infCad.setXNome(string);
        return this;
    }

    public InfCad<T> withXFant(final String string) {
        infCad.setXFant(string);
        return this;
    }

    public InfCad<T> withXRegApur(final String string) {
        infCad.setXRegApur(string);
        return this;
    }

    public InfCad<T> withCNAE(final String string) {
        infCad.setCNAE(string);
        return this;
    }

    public InfCad<T> withDIniAtiv(final Calendar calendar) {
        infCad.setDIniAtiv(calendar.toString());
        return this;
    }

    public InfCad<T> withDUltSit(final Calendar calendar) {
        infCad.setDUltSit(calendar.toString());
        return this;
    }

    public InfCad<T> withDBaixa(final Calendar calendar) {
        infCad.setDBaixa(calendar.toString());
        return this;
    }

    public InfCad<T> withIEUnica(final String string) {
        infCad.setIEUnica(string);
        return this;
    }

    public InfCad<T> withIEAtual(final String string) {
        infCad.setIEAtual(string);
        return this;
    }

    public InfCad<T> withEnder(final TEndereco tEndereco) {
        infCad.setEnder(tEndereco);
        return this;
    }
}