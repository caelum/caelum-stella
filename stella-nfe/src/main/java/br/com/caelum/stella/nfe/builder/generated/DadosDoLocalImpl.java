package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.UF;
import br.com.caelum.stella.tinytype.CNPJ;

public final class DadosDoLocalImpl implements DadosDoLocal, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TLocal tLocal;

    public DadosDoLocalImpl() {
        tLocal = new br.com.caelum.stella.nfe.modelo.TLocal();
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) this.tLocal;
    }

    public DadosDoLocal withCNPJ(final CNPJ cnpj) {
        tLocal.setCNPJ(cnpj.getNumero());
        return this;
    }

    public DadosDoLocal withLogradouro(final String string) {
        tLocal.setXLgr(string);
        return this;
    }

    public DadosDoLocal withNumero(final String string) {
        tLocal.setNro(string);
        return this;
    }

    public DadosDoLocal withComplemento(final String string) {
        tLocal.setXCpl(string);
        return this;
    }

    public DadosDoLocal withBairro(final String string) {
        tLocal.setXBairro(string);
        return this;
    }

    public DadosDoLocal withCodigoDoMunicipio(final String string) {
        tLocal.setCMun(string);
        return this;
    }

    public DadosDoLocal withNomeDoMunicipio(final String string) {
        tLocal.setXMun(string);
        return this;
    }

    public DadosDoLocal withUF(final UF tUf) {
        tLocal.setUF(tUf);
        return this;
    }
}