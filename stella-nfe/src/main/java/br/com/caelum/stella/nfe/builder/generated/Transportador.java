package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.UF;
import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public interface Transportador {
    public Transportador withCNPJ(CNPJ cnpj);

    public Transportador withCPF(CPF cpf);

    public Transportador withNome(String string);

    public Transportador withInscricaoEstadual(String string);

    public Transportador withEnderecoCompleto(String string);

    public Transportador withNomeDoMunicipio(String string);

    public Transportador withUF(UF tUf);
}