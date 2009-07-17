package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.tinytype.CNPJ;
import br.com.caelum.stella.tinytype.CPF;

public interface Emitente<T> extends NFeBuilder<T> {

    public Emitente<T> withCNPJ(CNPJ cnpj);

    public Emitente<T> withCPF(CPF cpf);

    /**
     * Este m�todo atribui ao mesmo campo que {@link Emitente#withNome(String)}
     */
    public Emitente<T> withRazaoSocial(String string);

    /**
     * Este m�todo atribui ao mesmo campo que
     * {@link Emitente#withRazaoSocial(String)}
     */
    public Emitente<T> withNome(String string);

    public Emitente<T> withNomeFantasia(String string);

    public Emitente<T> withEnderecoDoEmitente(Endereco<?> tEndereco);

    public Emitente<T> withInscricaoEstadual(String string);

    public Emitente<T> withInscricaoEstadualDoSubstitutoTributario(String string);

    public Emitente<T> withInscricaoMunicipal(String string);

    public Emitente<T> withCNAEFiscal(String string);
}