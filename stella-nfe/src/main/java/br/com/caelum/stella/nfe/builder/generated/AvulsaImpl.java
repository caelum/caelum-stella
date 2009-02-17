package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.caelum.stella.nfe.modelo.TUf;
import br.com.caelum.stella.tinytype.CNPJ;

public final class AvulsaImpl implements Avulsa, br.com.caelum.stella.nfe.ObjectCreator {

    private final br.com.caelum.stella.nfe.modelo.Avulsa avulsa;

    public AvulsaImpl() {
        avulsa = new br.com.caelum.stella.nfe.modelo.Avulsa();
    }

    public br.com.caelum.stella.nfe.modelo.Avulsa getInstance() {
        return avulsa;
    }

    public Avulsa withCnpj(final CNPJ cnpj) {
        avulsa.setCNPJ(cnpj.getNumero());
        return this;
    }

    public Avulsa withOrgaoEmitente(final String string) {
        avulsa.setXOrgao(string);
        return this;
    }

    public Avulsa withMatriculaDoAgente(final String string) {
        avulsa.setMatr(string);
        return this;
    }

    public Avulsa withNomeDoAgente(final String string) {
        avulsa.setXAgente(string);
        return this;
    }

    public Avulsa withTelefone(final Long telefone) {
        avulsa.setFone(telefone.toString().replace("L", ""));
        return this;
    }

    public Avulsa withUf(final TUf tUf) {
        avulsa.setUF(tUf);
        return this;
    }

    public Avulsa withNumeroDeArrecadacaoDaReceita(final String string) {
        avulsa.setNDAR(string);
        return this;
    }

    public Avulsa withDataDeEmissao(final Calendar calendar) {
        avulsa.setDEmi(calendar);
        return this;
    }

    public Avulsa withValorDoDocumentoDeArrecadacao(final BigDecimal bigDecimal) {
        avulsa.setVDAR(bigDecimal.toPlainString());
        return this;
    }

    public Avulsa withReparticaoFiscalEmitente(final String string) {
        avulsa.setRepEmi(string);
        return this;
    }

    public Avulsa withDataDePagamento(final Calendar calendar) {
        avulsa.setDPag(calendar);
        return this;
    }
}