package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.caelum.stella.nfe.builder.NFeBuilder;
import br.com.caelum.stella.nfe.modelo.UF;
import br.com.caelum.stella.tinytype.CNPJ;

public interface Avulsa<T> extends NFeBuilder<T> {
    public Avulsa<T> withCnpj(CNPJ cnpj);

    public Avulsa<T> withOrgaoEmitente(String string);

    public Avulsa<T> withMatriculaDoAgente(String string);

    public Avulsa<T> withNomeDoAgente(String string);

    public Avulsa<T> withTelefone(Long telefone);

    public Avulsa<T> withUf(UF tUf);

    public Avulsa<T> withNumeroDeArrecadacaoDaReceita(String string);

    public Avulsa<T> withDataDeEmissao(Calendar calendar);

    public Avulsa<T> withValorDoDocumentoDeArrecadacao(BigDecimal bigDecimal);

    public Avulsa<T> withReparticaoFiscalEmitente(String string);

    public Avulsa<T> withDataDePagamento(Calendar calendar);
}