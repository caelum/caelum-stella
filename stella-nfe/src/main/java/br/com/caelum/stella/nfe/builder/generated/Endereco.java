package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.UF;

public interface Endereco {
    public Endereco withLogradouro(String string);

    public Endereco withNumero(String string);

    public Endereco withComplemento(String string);

    public Endereco withBairro(String string);

    public Endereco withCodigoDoMunicipio(String string);

    public Endereco withNomeDoMunicipio(String string);

    public Endereco withUF(UF tUf);

    public Endereco withCEP(String string);

    public Endereco withCodigoDoPais(String string);

    public Endereco withNomeDoPais(String string);

    public Endereco withTelefone(String string);
}