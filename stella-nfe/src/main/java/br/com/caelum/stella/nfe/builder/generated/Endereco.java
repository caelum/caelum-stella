package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.modelo.UF;

public interface Endereco<T> extends NFeBuilder<T> {
    public Endereco<T> withLogradouro(String string);

    public Endereco<T> withNumero(String string);

    public Endereco<T> withComplemento(String string);

    public Endereco<T> withBairro(String string);

    public Endereco<T> withCodigoDoMunicipio(String string);

    public Endereco<T> withNomeDoMunicipio(String string);

    public Endereco<T> withUF(UF tUf);

    public Endereco<T> withCEP(String string);

    public Endereco<T> withCodigoDoPais(String string);

    public Endereco<T> withNomeDoPais(String string);

    public Endereco<T> withTelefone(String string);
}