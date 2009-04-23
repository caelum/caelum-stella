package br.com.caelum.stella.nfe.builder.generated;

import java.util.List;

import br.com.caelum.stella.nfe.modelo.TUf;

public interface TEmissor {
    public TEmissor withUF(TUf tUf);

    public TEmissor withCNPJ(String string);

    public TEmissor withCNPJMatriz(String string);

    public TEmissor withIE(String string);

    public TEmissor withDFe(List<DFe> list);
}