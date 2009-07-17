package br.com.caelum.stella.nfe.builder.generated;

import java.math.BigDecimal;
import java.util.Calendar;

import br.com.caelum.stella.nfe.modelo.UF;
import br.com.caelum.stella.tinytype.CNPJ;

public final class AvulsaImpl<T> implements Avulsa<T>, br.com.caelum.stella.nfe.ObjectCreator {

    private final br.com.caelum.stella.nfe.modelo.Avulsa avulsa;
    private final T parent;

    public AvulsaImpl(final T parent) {
        this.parent = parent;
        avulsa = new br.com.caelum.stella.nfe.modelo.Avulsa();
    }

    public T build() {
        return parent;
    }

    @SuppressWarnings("unchecked")
    public <M> M getInstance() {
        return (M) this.avulsa;
    }

    public Avulsa<T> withCnpj(final CNPJ cnpj) {
        avulsa.setCNPJ(cnpj.getNumero());
        return this;
    }

    public Avulsa<T> withOrgaoEmitente(final String string) {
        avulsa.setXOrgao(string);
        return this;
    }

    public Avulsa<T> withMatriculaDoAgente(final String string) {
        avulsa.setMatr(string);
        return this;
    }

    public Avulsa<T> withNomeDoAgente(final String string) {
        avulsa.setXAgente(string);
        return this;
    }

    public Avulsa<T> withTelefone(final Long telefone) {
        avulsa.setFone(telefone.toString().replace("L", ""));
        return this;
    }

    public Avulsa<T> withUf(final UF tUf) {
        avulsa.setUF(tUf);
        return this;
    }

    public Avulsa<T> withNumeroDeArrecadacaoDaReceita(final String string) {
        avulsa.setNDAR(string);
        return this;
    }

    public Avulsa<T> withDataDeEmissao(final Calendar calendar) {
        avulsa.setDEmi(calendar);
        return this;
    }

    public Avulsa<T> withValorDoDocumentoDeArrecadacao(final BigDecimal bigDecimal) {
        avulsa.setVDAR(bigDecimal.toPlainString());
        return this;
    }

    public Avulsa<T> withReparticaoFiscalEmitente(final String string) {
        avulsa.setRepEmi(string);
        return this;
    }

    public Avulsa<T> withDataDePagamento(final Calendar calendar) {
        avulsa.setDPag(calendar);
        return this;
    }
}