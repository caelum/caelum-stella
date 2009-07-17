package br.com.caelum.stella.nfe.builder.generated;

import java.util.Calendar;

import br.com.caelum.stella.nfe.builder.NFeBuilder;

public interface Duplicata<T> extends NFeBuilder<T> {
    public Duplicata<T> withNumero(String string);

    public Duplicata<T> withDataDeVencimento(Calendar calendar);

    public Duplicata<T> withValorDaDuplicata(String string);
}