package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public final class DestinatarioImpl<T> implements Destinatario<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Dest dest;
    private final T parent;

    public DestinatarioImpl(final T parent) {
        this.parent = parent;
        dest = new br.com.caelum.stella.nfe.modelo.Dest();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.dest;
    }

    public Destinatario<T> withCNPJ(final CNPJ cnpj) {
        dest.setCNPJ(cnpj.getNumero());
        return this;
    }

    public Destinatario<T> withCPF(final CPF cpf) {
        dest.setCPF(cpf.getNumero());
        return this;
    }

    public Destinatario<T> withRazaoSocial(final String string) {
        dest.setXNome(string);
        return this;
    }

    public Destinatario<T> withEndererecoDoDestinatario(final Endereco<?> tEndereco) {
        dest.setEnderDest((br.com.caelum.stella.nfe.modelo.TEndereco) ((ObjectCreator) tEndereco).getInstance());
        return this;
    }

    public Destinatario<T> withInscricaoEstadual(final String string) {
        dest.setIE(string);
        return this;
    }

    public Destinatario<T> withInscricaoNaSUFRAMA(final String string) {
        dest.setISUF(string);
        return this;
    }

    public Destinatario<T> withNomeDoDestinatario(final String string) {
        dest.setXNome(string);
        return null;
    }
}