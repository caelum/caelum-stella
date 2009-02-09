package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.tinytype.CNPJ;

public interface RefNF {
    public RefNF withCUF(String string);

    public RefNF withAAMM(String string);

    public RefNF withCNPJ(CNPJ cnpj);

    public RefNF withMod(String string);

    public RefNF withSerie(String string);

    public RefNF withNNF(String string);
}