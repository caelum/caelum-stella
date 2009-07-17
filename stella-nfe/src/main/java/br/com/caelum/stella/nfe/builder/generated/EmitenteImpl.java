package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public final class EmitenteImpl<T> implements Emitente<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Emit emit;
    private final T parent;

    public EmitenteImpl(final T parent) {
        this.parent = parent;
        emit = new br.com.caelum.stella.nfe.modelo.Emit();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.emit;
    }

    public Emitente<T> withCNPJ(final CNPJ cnpj) {
        emit.setCNPJ(cnpj.getNumero());
        return this;
    }

    public Emitente<T> withCPF(final CPF cpf) {
        emit.setCPF(cpf.getNumero());
        return this;
    }

    public Emitente<T> withRazaoSocial(final String string) {
        emit.setXNome(string);
        return this;
    }

    public Emitente<T> withNomeFantasia(final String string) {
        emit.setXFant(string);
        return this;
    }

    public Emitente<T> withEnderecoDoEmitente(final Endereco<?> tEndereco) {
        emit.setEnderEmit((br.com.caelum.stella.nfe.modelo.TEndereco) ((ObjectCreator) tEndereco).getInstance());
        return this;
    }

    public Emitente<T> withInscricaoEstadual(final String string) {
        emit.setIE(string);
        return this;
    }

    public Emitente<T> withInscricaoEstadualDoSubstitutoTributario(final String string) {
        emit.setIEST(string);
        return this;
    }

    public Emitente<T> withInscricaoMunicipal(final String string) {
        emit.setIM(string);
        return this;
    }

    public Emitente<T> withCNAEFiscal(final String string) {
        emit.setCNAE(string);
        return this;
    }

    public Emitente<T> withNome(final String string) {
        emit.setXNome(string);
        return this;
    }
}