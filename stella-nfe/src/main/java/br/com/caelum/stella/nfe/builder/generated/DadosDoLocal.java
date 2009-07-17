package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.modelo.UF;
import br.com.caelum.stella.tinytype.CNPJ;

public interface DadosDoLocal<T> extends NFeBuilder<T> {
    public DadosDoLocal<T> withCNPJ(CNPJ cnpj);

    public DadosDoLocal<T> withLogradouro(String string);

    public DadosDoLocal<T> withNumero(String string);

    public DadosDoLocal<T> withComplemento(String string);

    public DadosDoLocal<T> withBairro(String string);

    public DadosDoLocal<T> withCodigoDoMunicipio(String string);

    public DadosDoLocal<T> withNomeDoMunicipio(String string);

    public DadosDoLocal<T> withUF(UF tUf);
}