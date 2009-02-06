package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;

public final class EmitImpl implements Emit, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Emit emit;

    public EmitImpl() {
        emit = new br.com.caelum.stella.nfe.modelo.Emit();
    }

    public br.com.caelum.stella.nfe.modelo.Emit getInstance() {
        return emit;
    }

    public Emit withCNPJ(final String string) {
        emit.setCNPJ(string);
        return this;
    }

    public Emit withCPF(final String string) {
        emit.setCPF(string);
        return this;
    }

    public Emit withXNome(final String string) {
        emit.setXNome(string);
        return this;
    }

    public Emit withXFant(final String string) {
        emit.setXFant(string);
        return this;
    }

    public Emit withEnderEmit(final TEndereco tEndereco) {
        emit.setEnderEmit((br.com.caelum.stella.nfe.modelo.TEndereco) ((ObjectCreator) tEndereco).getInstance());
        return this;
    }

    public Emit withIE(final String string) {
        emit.setIE(string);
        return this;
    }

    public Emit withIEST(final String string) {
        emit.setIEST(string);
        return this;
    }

    public Emit withIM(final String string) {
        emit.setIM(string);
        return this;
    }

    public Emit withCNAE(final String string) {
        emit.setCNAE(string);
        return this;
    }
}