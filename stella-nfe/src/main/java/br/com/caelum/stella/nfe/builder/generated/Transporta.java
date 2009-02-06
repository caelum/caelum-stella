package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.TUf;

public interface Transporta {
    public Transporta withCNPJ(String string);

    public Transporta withCPF(String string);

    public Transporta withXNome(String string);

    public Transporta withIE(String string);

    public Transporta withXEnder(String string);

    public Transporta withXMun(String string);

    public Transporta withUF(TUf tUf);
}