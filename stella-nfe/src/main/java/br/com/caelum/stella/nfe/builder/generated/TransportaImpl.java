package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.TUf;
import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public final class TransportaImpl implements Transporta, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Transporta transporta;

    public TransportaImpl() {
        this.transporta = new br.com.caelum.stella.nfe.modelo.Transporta();
    }

    public br.com.caelum.stella.nfe.modelo.Transporta getInstance() {
        return this.transporta;
    }

    public Transporta withCNPJ(CNPJ cnpj) {
        this.transporta.setCNPJ(cnpj.getNumero());
        return this;
    }

    public Transporta withCPF(CPF cpf) {
        this.transporta.setCPF(cpf.getNumero());
        return this;
    }

    public Transporta withXNome(String string) {
        this.transporta.setXNome(string);
        return this;
    }

    public Transporta withIE(String string) {
        this.transporta.setIE(string);
        return this;
    }

    public Transporta withXEnder(String string) {
        this.transporta.setXEnder(string);
        return this;
    }

    public Transporta withXMun(String string) {
        this.transporta.setXMun(string);
        return this;
    }

    public Transporta withUF(TUf tUf) {
        this.transporta.setUF(tUf);
        return this;
    }
}