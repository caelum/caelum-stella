package br.com.caelum.stella.nfe.builder.icms;

import br.com.caelum.stella.nfe.builder.ICMS;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;
import br.com.caelum.stella.nfe.modelo.ICMS00;

public class ICMSTributadoIntegralmente implements ICMS {

    private final ICMSBuilderDelegate<ICMS00> delegate;

    private ICMSTributadoIntegralmente() {
        delegate = new ICMSBuilderDelegate<ICMS00>(ICMS00.class);
    }

    public static ICMSTributadoIntegralmente create() {
        return new ICMSTributadoIntegralmente();
    }

    public ICMSTributadoIntegralmente withOrigem(final OrigemICMS origem) {
        delegate.withOrigem(origem);
        return this;
    }

    public ICMSTributadoIntegralmente withModalidade(final ModalidadeBaseCalculo modalidade) {
        delegate.withModalidade(modalidade);
        return this;
    }

    public ICMSTributadoIntegralmente withBaseDeCalculo(final String baseDeCalculo) {
        delegate.withBaseDeCalculo(baseDeCalculo);
        return this;
    }

    public ICMSTributadoIntegralmente withAliquota(final String aliquota) {
        delegate.withAliquota(aliquota);
        return this;
    }

    public ICMSTributadoIntegralmente withValor(final String valor) {
        delegate.withValor(valor);
        return this;
    }

}
