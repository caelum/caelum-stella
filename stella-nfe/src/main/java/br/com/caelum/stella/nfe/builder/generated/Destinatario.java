package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public interface Destinatario {
    public Destinatario withCNPJ(CNPJ cnpj);

    public Destinatario withCPF(CPF cpf);

    /**
     * Atribui ao mesmo campo que
     * {@link Destinatario#withNomeDoDestinatario(String)}
     */
    public Destinatario withRazaoSocial(String string);

    /**
     * Atribui ao mesmo campo que {@link Destinatario#withRazaoSocial(String)}
     */
    public Destinatario withNomeDoDestinatario(String string);

    public Destinatario withEndererecoDoDestinatario(Endereco tEndereco);

    public Destinatario withInscricaoEstadual(String string);

    public Destinatario withInscricaoNaSUFRAMA(String string);
}