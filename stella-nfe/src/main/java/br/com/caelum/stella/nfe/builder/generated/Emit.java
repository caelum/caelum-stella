package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public interface Emit {
    public Emit withCNPJ(CNPJ cnpj);

    public Emit withCPF(CPF cpf);

    public Emit withXNome(String string);

    public Emit withXFant(String string);

    public Emit withEnderEmit(TEndereco tEndereco);

    public Emit withIE(String string);

    public Emit withIEST(String string);

    public Emit withIM(String string);

    public Emit withCNAE(String string);
}