package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.tinytype.CNPJ;

public interface NFReferenciada {
    public NFReferenciada withCodigoUF(String string);

    public NFReferenciada withAAMM(String string);

    public NFReferenciada withCNPJ(CNPJ cnpj);

    public NFReferenciada withSerie(String string);

    public NFReferenciada withNumero(String string);
}