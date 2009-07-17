package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.builder.generated.enums.OrigemDoProcesso;

public interface ProcessoReferenciado<T> extends NFeBuilder<T> {
    public ProcessoReferenciado<T> withIdentificadorDoProcesso(String string);

    public ProcessoReferenciado<T> withOrigemDoProcesso(OrigemDoProcesso string);
}