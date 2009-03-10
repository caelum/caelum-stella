package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public interface Dest {
    public Dest withCNPJ(CNPJ cnpj);

    public Dest withCPF(CPF cpf);

    public Dest withXNome(String string);

    public Dest withEnderDest(Endereco tEndereco);

    public Dest withIE(String string);

    public Dest withISUF(String string);
}