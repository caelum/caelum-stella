package br.com.caelum.stella.nfe.builder.generated;

import br.com.caelum.stella.nfe.modelo.TUf;
import br.com.caelum.stella.tinytype.CNPJ;

public final class TLocalImpl implements TLocal, br.com.caelum.stella.nfe.ObjectCreator {
    private final br.com.caelum.stella.nfe.modelo.TLocal tLocal;

    public TLocalImpl() {
        this.tLocal = new br.com.caelum.stella.nfe.modelo.TLocal();
    }

    public br.com.caelum.stella.nfe.modelo.TLocal getInstance() {
        return this.tLocal;
    }

    public TLocal withCNPJ(CNPJ cnpj) {
        this.tLocal.setCNPJ(cnpj.getNumero());
        return this;
    }

    public TLocal withXLgr(String string) {
        this.tLocal.setXLgr(string);
        return this;
    }

    public TLocal withNro(String string) {
        this.tLocal.setNro(string);
        return this;
    }

    public TLocal withXCpl(String string) {
        this.tLocal.setXCpl(string);
        return this;
    }

    public TLocal withXBairro(String string) {
        this.tLocal.setXBairro(string);
        return this;
    }

    public TLocal withCMun(String string) {
        this.tLocal.setCMun(string);
        return this;
    }

    public TLocal withXMun(String string) {
        this.tLocal.setXMun(string);
        return this;
    }

    public TLocal withUF(TUf tUf) {
        this.tLocal.setUF(tUf);
        return this;
    }
}