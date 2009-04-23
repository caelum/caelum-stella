package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.UF;

public final class EnderecoImpl implements Endereco, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TEndereco tEndereco;

    public EnderecoImpl() {
        tEndereco = new br.com.caelum.stella.nfe.modelo.TEndereco();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.tEndereco;
    }

    public Endereco withLogradouro(final String string) {
        tEndereco.setXLgr(string);
        return this;
    }

    public Endereco withNumero(final String string) {
        tEndereco.setNro(string);
        return this;
    }

    public Endereco withComplemento(final String string) {
        tEndereco.setXCpl(string);
        return this;
    }

    public Endereco withBairro(final String string) {
        tEndereco.setXBairro(string);
        return this;
    }

    public Endereco withCodigoDoMunicipio(final String string) {
        tEndereco.setCMun(string);
        return this;
    }

    public Endereco withNomeDoMunicipio(final String string) {
        tEndereco.setXMun(string);
        return this;
    }

    public Endereco withUF(final UF tUf) {
        tEndereco.setUF(tUf);
        return this;
    }

    public Endereco withCEP(final String string) {
        tEndereco.setCEP(string);
        return this;
    }

    public Endereco withCodigoDoPais(final String string) {
        tEndereco.setCPais(string);
        return this;
    }

    public Endereco withNomeDoPais(final String string) {
        tEndereco.setXPais(string);
        return this;
    }

    public Endereco withTelefone(final String string) {
        tEndereco.setFone(string);
        return this;
    }
}