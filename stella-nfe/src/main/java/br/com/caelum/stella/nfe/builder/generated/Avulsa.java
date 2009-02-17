package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.caelum.stella.nfe.modelo.TUf;
import br.com.caelum.stella.tinytype.CNPJ;

public interface Avulsa {
    public Avulsa withCnpj(CNPJ cnpj);

    public Avulsa withOrgaoEmitente(String string);

    public Avulsa withMatriculaDoAgente(String string);

    public Avulsa withNomeDoAgente(String string);

    public Avulsa withTelefone(Long telefone);

    public Avulsa withUf(TUf tUf);

    public Avulsa withNumeroDeArrecadacaoDaReceita(String string);

    public Avulsa withDataDeEmissao(Calendar calendar);

    public Avulsa withValorDoDocumentoDeArrecadacao(BigDecimal bigDecimal);

    public Avulsa withReparticaoFiscalEmitente(String string);

    public Avulsa withDataDePagamento(Calendar calendar);
}