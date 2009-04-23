package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.modelo.TEndereco;
import br.com.caelum.stella.nfe.modelo.TUf;

public final class InfCadImpl implements InfCad, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.InfCad infCad;

    public InfCadImpl() {
        infCad = new br.com.caelum.stella.nfe.modelo.InfCad();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) infCad;
    }

    public InfCad withIE(final String string) {
        infCad.setIE(string);
        return this;
    }

    public InfCad withCNPJ(final String string) {
        infCad.setCNPJ(string);
        return this;
    }

    public InfCad withCPF(final String string) {
        infCad.setCPF(string);
        return this;
    }

    public InfCad withUF(final TUf tUf) {
        infCad.setUF(tUf);
        return this;
    }

    public InfCad withCSit(final String string) {
        infCad.setCSit(string);
        return this;
    }

    public InfCad withXNome(final String string) {
        infCad.setXNome(string);
        return this;
    }

    public InfCad withXFant(final String string) {
        infCad.setXFant(string);
        return this;
    }

    public InfCad withXRegApur(final String string) {
        infCad.setXRegApur(string);
        return this;
    }

    public InfCad withCNAE(final String string) {
        infCad.setCNAE(string);
        return this;
    }

    public InfCad withDIniAtiv(final Calendar calendar) {
        infCad.setDIniAtiv(calendar.toString());
        return this;
    }

    public InfCad withDUltSit(final Calendar calendar) {
        infCad.setDUltSit(calendar.toString());
        return this;
    }

    public InfCad withDBaixa(final Calendar calendar) {
        infCad.setDBaixa(calendar.toString());
        return this;
    }

    public InfCad withIEUnica(final String string) {
        infCad.setIEUnica(string);
        return this;
    }

    public InfCad withIEAtual(final String string) {
        infCad.setIEAtual(string);
        return this;
    }

    public InfCad withEnder(final TEndereco tEndereco) {
        infCad.setEnder(tEndereco);
        return this;
    }
}