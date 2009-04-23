package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public final class EmitenteImpl implements Emitente, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Emit emit;

    public EmitenteImpl() {
        emit = new br.com.caelum.stella.nfe.modelo.Emit();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.emit;
    }

    public Emitente withCNPJ(final CNPJ cnpj) {
        emit.setCNPJ(cnpj.getNumero());
        return this;
    }

    public Emitente withCPF(final CPF cpf) {
        emit.setCPF(cpf.getNumero());
        return this;
    }

    public Emitente withRazaoSocial(final String string) {
        emit.setXNome(string);
        return this;
    }

    public Emitente withNomeFantasia(final String string) {
        emit.setXFant(string);
        return this;
    }

    public Emitente withEnderecoDoEmitente(final Endereco tEndereco) {
        emit.setEnderEmit((br.com.caelum.stella.nfe.modelo.TEndereco) ((ObjectCreator) tEndereco).getInstance());
        return this;
    }

    public Emitente withInscricaoEstadual(final String string) {
        emit.setIE(string);
        return this;
    }

    public Emitente withInscricaoEstadualDoSubstitutoTributario(final String string) {
        emit.setIEST(string);
        return this;
    }

    public Emitente withInscricaoMunicipal(final String string) {
        emit.setIM(string);
        return this;
    }

    public Emitente withCNAEFiscal(final String string) {
        emit.setCNAE(string);
        return this;
    }

    public Emitente withNome(final String string) {
        emit.setXNome(string);
        return this;
    }
}