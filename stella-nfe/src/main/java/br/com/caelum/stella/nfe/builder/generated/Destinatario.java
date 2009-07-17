package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public interface Destinatario<T> extends NFeBuilder<T> {
    public Destinatario<T> withCNPJ(CNPJ cnpj);

    public Destinatario<T> withCPF(CPF cpf);

    /**
     * Atribui ao mesmo campo que
     * {@link Destinatario#withNomeDoDestinatario(String)}
     */
    public Destinatario<T> withRazaoSocial(String string);

    /**
     * Atribui ao mesmo campo que {@link Destinatario#withRazaoSocial(String)}
     */
    public Destinatario<T> withNomeDoDestinatario(String string);

    public Destinatario<T> withEndererecoDoDestinatario(Endereco<?> tEndereco);

    public Destinatario<T> withInscricaoEstadual(String string);

    public Destinatario<T> withInscricaoNaSUFRAMA(String string);
}