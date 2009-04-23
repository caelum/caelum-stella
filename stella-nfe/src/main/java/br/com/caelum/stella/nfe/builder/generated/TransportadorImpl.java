package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.UF;
import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public final class TransportadorImpl implements Transportador, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Transporta transporta;

    public TransportadorImpl() {
        transporta = new br.com.caelum.stella.nfe.modelo.Transporta();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.transporta;
    }

    public Transportador withCNPJ(final CNPJ cnpj) {
        transporta.setCNPJ(cnpj.getNumero());
        return this;
    }

    public Transportador withCPF(final CPF cpf) {
        transporta.setCPF(cpf.getNumero());
        return this;
    }

    public Transportador withNome(final String string) {
        transporta.setXNome(string);
        return this;
    }

    public Transportador withInscricaoEstadual(final String string) {
        transporta.setIE(string);
        return this;
    }

    public Transportador withEnderecoCompleto(final String string) {
        transporta.setXEnder(string);
        return this;
    }

    public Transportador withNomeDoMunicipio(final String string) {
        transporta.setXMun(string);
        return this;
    }

    public Transportador withUF(final UF tUf) {
        transporta.setUF(tUf);
        return this;
    }
}