package br.com.caelum.stella.nfe.builder.icms.impl;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.icms.ICMSTributadoIntegralmente;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;
import br.com.caelum.stella.nfe.modelo.ICMS00;

public class ICMSTributadoIntegralmenteImpl implements ICMSTributadoIntegralmente, ObjectCreator {

    private final ICMSBuilderDelegate<ICMS00> delegate;

    public ICMSTributadoIntegralmenteImpl() {
        delegate = new ICMSBuilderDelegate<ICMS00>(ICMS00.class);
    }

    public static ICMSTributadoIntegralmenteImpl create() {
        return new ICMSTributadoIntegralmenteImpl();
    }

    public ICMSTributadoIntegralmenteImpl withOrigem(final OrigemICMS origem) {
        delegate.withOrigem(origem);
        return this;
    }

    public ICMSTributadoIntegralmenteImpl withModalidade(final ModalidadeBaseCalculo modalidade) {
        delegate.withModalidade(modalidade);
        return this;
    }

    public ICMSTributadoIntegralmenteImpl withBaseDeCalculo(final BigDecimal baseDeCalculo) {
        delegate.withBaseDeCalculo(baseDeCalculo);
        return this;
    }

    public ICMSTributadoIntegralmenteImpl withAliquota(final BigDecimal aliquota) {
        delegate.withAliquota(aliquota);
        return this;
    }

    public ICMSTributadoIntegralmenteImpl withValor(final BigDecimal valor) {
        delegate.withValor(valor);
        return this;
    }

    public ICMS00 getInstance() {
        return delegate.getReference();
    }

}
