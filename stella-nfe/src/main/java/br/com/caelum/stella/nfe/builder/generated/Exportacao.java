package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.modelo.UF;

public interface Exportacao<T> extends NFeBuilder<T> {
    public Exportacao<T> withUFDoEmbarque(UF tUf);

    public Exportacao<T> withLocalDoEmbarque(String string);
}