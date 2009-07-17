package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.UF;

public final class EnderecoImpl<T> implements Endereco<T>, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TEndereco tEndereco;
    private final T parent;

    public EnderecoImpl(final T parent) {
        this.parent = parent;
        tEndereco = new br.com.caelum.stella.nfe.modelo.TEndereco();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.tEndereco;
    }

    public Endereco<T> withLogradouro(final String string) {
        tEndereco.setXLgr(string);
        return this;
    }

    public Endereco<T> withNumero(final String string) {
        tEndereco.setNro(string);
        return this;
    }

    public Endereco<T> withComplemento(final String string) {
        tEndereco.setXCpl(string);
        return this;
    }

    public Endereco<T> withBairro(final String string) {
        tEndereco.setXBairro(string);
        return this;
    }

    public Endereco<T> withCodigoDoMunicipio(final String string) {
        tEndereco.setCMun(string);
        return this;
    }

    public Endereco<T> withNomeDoMunicipio(final String string) {
        tEndereco.setXMun(string);
        return this;
    }

    public Endereco<T> withUF(final UF tUf) {
        tEndereco.setUF(tUf);
        return this;
    }

    public Endereco<T> withCEP(final String string) {
        tEndereco.setCEP(string);
        return this;
    }

    public Endereco<T> withCodigoDoPais(final String string) {
        tEndereco.setCPais(string);
        return this;
    }

    public Endereco<T> withNomeDoPais(final String string) {
        tEndereco.setXPais(string);
        return this;
    }

    public Endereco<T> withTelefone(final String string) {
        tEndereco.setFone(string);
        return this;
    }
}