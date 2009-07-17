package br.com.caelum.stella.nfe.builder.generated;

import java.util.List;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.modelo.TUf;

public interface TEmissor<T> extends NFeBuilder<T> {
    public TEmissor<T> withUF(TUf tUf);

    public TEmissor<T> withCNPJ(String string);

    public TEmissor<T> withCNPJMatriz(String string);

    public TEmissor<T> withIE(String string);

    public TEmissor<T> withDFe(List<DFe<?>> list);
}