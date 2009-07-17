package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface Cobranca<T> extends NFeBuilder<T> {
    public Cobranca<T> withFatura(Fatura<?> fat);

    public Cobranca<T> withDuplicatas(Duplicata<?>... dups);
}