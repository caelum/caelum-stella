package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.TUf;
import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public interface Transporta {
    public Transporta withCNPJ(CNPJ cnpj);

    public Transporta withCPF(CPF cpf);

    public Transporta withXNome(String string);

    public Transporta withIE(String string);

    public Transporta withXEnder(String string);

    public Transporta withXMun(String string);

    public Transporta withUF(TUf tUf);
}