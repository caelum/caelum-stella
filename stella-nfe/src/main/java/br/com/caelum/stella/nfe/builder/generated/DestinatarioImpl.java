package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public final class DestinatarioImpl implements Destinatario, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Dest dest;

    public DestinatarioImpl() {
        dest = new br.com.caelum.stella.nfe.modelo.Dest();
    }

    public br.com.caelum.stella.nfe.modelo.Dest getInstance() {
        return dest;
    }

    public Destinatario withCNPJ(final CNPJ cnpj) {
        dest.setCNPJ(cnpj.getNumero());
        return this;
    }

    public Destinatario withCPF(final CPF cpf) {
        dest.setCPF(cpf.getNumero());
        return this;
    }

    public Destinatario withRazaoSocial(final String string) {
        dest.setXNome(string);
        return this;
    }

    public Destinatario withEndererecoDoDestinatario(final Endereco tEndereco) {
        dest.setEnderDest((br.com.caelum.stella.nfe.modelo.TEndereco) ((ObjectCreator) tEndereco).getInstance());
        return this;
    }

    public Destinatario withInscricaoEstadual(final String string) {
        dest.setIE(string);
        return this;
    }

    public Destinatario withInscricaoNaSUFRAMA(final String string) {
        dest.setISUF(string);
        return this;
    }

    public Destinatario withNomeDoDestinatario(final String string) {
        dest.setXNome(string);
        return null;
    }
}