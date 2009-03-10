package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.UF;
import br.com.caelum.stella.tinytype.CNPJ;

public interface DadosDoLocal {
    public DadosDoLocal withCNPJ(CNPJ cnpj);

    public DadosDoLocal withLogradouro(String string);

    public DadosDoLocal withNumero(String string);

    public DadosDoLocal withComplemento(String string);

    public DadosDoLocal withBairro(String string);

    public DadosDoLocal withCodigoDoMunicipio(String string);

    public DadosDoLocal withNomeDoMunicipio(String string);

    public DadosDoLocal withUF(UF tUf);
}