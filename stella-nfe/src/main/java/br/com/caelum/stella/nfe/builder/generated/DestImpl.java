package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public final class DestImpl implements Dest, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.Dest dest;

    public DestImpl() {
        dest = new br.com.caelum.stella.nfe.modelo.Dest();
    }

    public br.com.caelum.stella.nfe.modelo.Dest getInstance() {
        return dest;
    }

    public Dest withCNPJ(final CNPJ cnpj) {
        dest.setCNPJ(cnpj.getNumero());
        return this;
    }

    public Dest withCPF(final CPF cpf) {
        dest.setCPF(cpf.getNumero());
        return this;
    }

    public Dest withXNome(final String string) {
        dest.setXNome(string);
        return this;
    }

    public Dest withEnderDest(final TEndereco tEndereco) {
        dest.setEnderDest((br.com.caelum.stella.nfe.modelo.TEndereco) ((ObjectCreator) tEndereco).getInstance());
        return this;
    }

    public Dest withIE(final String string) {
        dest.setIE(string);
        return this;
    }

    public Dest withISUF(final String string) {
        dest.setISUF(string);
        return this;
    }
}