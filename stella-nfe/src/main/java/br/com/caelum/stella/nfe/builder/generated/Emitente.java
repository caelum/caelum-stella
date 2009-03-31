package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public interface Emitente {
    public Emitente withCNPJ(CNPJ cnpj);

    public Emitente withCPF(CPF cpf);

    /**
     * Este método atribui ao mesmo campo que {@link Emitente#withNome(String)}
     */
    public Emitente withRazaoSocial(String string);

    /**
     * Este método atribui ao mesmo campo que
     * {@link Emitente#withRazaoSocial(String)}
     */
    public Emitente withNome(String string);

    public Emitente withNomeFantasia(String string);

    public Emitente withEnderecoDoEmitente(Endereco tEndereco);

    public Emitente withInscricaoEstadual(String string);

    public Emitente withInscricaoEstadualDoSubstitutoTributario(String string);

    public Emitente withInscricaoMunicipal(String string);

    public Emitente withCNAEFiscal(String string);
}