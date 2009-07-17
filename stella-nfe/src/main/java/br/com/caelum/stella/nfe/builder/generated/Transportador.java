package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.modelo.UF;
import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public interface Transportador<T> extends NFeBuilder<T> {
    public Transportador<T> withCNPJ(CNPJ cnpj);

    public Transportador<T> withCPF(CPF cpf);

    public Transportador<T> withNome(String string);

    public Transportador<T> withInscricaoEstadual(String string);

    public Transportador<T> withEnderecoCompleto(String string);

    public Transportador<T> withNomeDoMunicipio(String string);

    public Transportador<T> withUF(UF tUf);
}