package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;
import java.util.List;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface InfCadEmiDFe<T> extends NFeBuilder<T> {
    public InfCadEmiDFe<T> withDPubCad(Calendar calendar);

    public InfCadEmiDFe<T> withEmissor(List<TEmissor<?>> list);

    public InfCadEmiDFe<T> withId(String string);
}