package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.UF;
import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public final class TransportadorImpl<T> implements Transportador<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Transporta transporta;
    private final T parent;

    public TransportadorImpl(final T parent) {
        this.parent = parent;
        transporta = new br.com.caelum.stella.nfe.modelo.Transporta();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.transporta;
    }

    public Transportador<T> withCNPJ(final CNPJ cnpj) {
        transporta.setCNPJ(cnpj.getNumero());
        return this;
    }

    public Transportador<T> withCPF(final CPF cpf) {
        transporta.setCPF(cpf.getNumero());
        return this;
    }

    public Transportador<T> withNome(final String string) {
        transporta.setXNome(string);
        return this;
    }

    public Transportador<T> withInscricaoEstadual(final String string) {
        transporta.setIE(string);
        return this;
    }

    public Transportador<T> withEnderecoCompleto(final String string) {
        transporta.setXEnder(string);
        return this;
    }

    public Transportador<T> withNomeDoMunicipio(final String string) {
        transporta.setXMun(string);
        return this;
    }

    public Transportador<T> withUF(final UF tUf) {
        transporta.setUF(tUf);
        return this;
    }
}