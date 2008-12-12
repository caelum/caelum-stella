package br.com.caelum.stella.nfe.builder.icms;

import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeICMS;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;
import br.com.caelum.stella.nfe.modelo.ICMS00;

public class ICMSTributadoIntegralmente {

    private final ICMSBuilderDelegate<ICMS00> delegate;

    private ICMSTributadoIntegralmente() {
        delegate = new ICMSBuilderDelegate<ICMS00>(ICMS00.class);
    }

    public static ICMSTributadoIntegralmente create() {
        return new ICMSTributadoIntegralmente();
    }

    public ICMSTributadoIntegralmente withOrigem(OrigemICMS origem) {
        return this;
    }

    public ICMSTributadoIntegralmente withModalidade(ModalidadeICMS modalidade) {
        return this;
    }

    public ICMSTributadoIntegralmente withBaseDeCalculo(String string) {
        return this;
    }

    public ICMSTributadoIntegralmente withAliquota(String string) {
        return this;
    }

    public ICMSTributadoIntegralmente withValor(String string) {
        return this;
    }

}
