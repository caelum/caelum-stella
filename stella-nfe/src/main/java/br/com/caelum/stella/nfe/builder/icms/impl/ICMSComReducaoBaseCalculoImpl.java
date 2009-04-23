package br.com.caelum.stella.nfe.builder.icms.impl;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.icms.ICMSComReducaoBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;
import br.com.caelum.stella.nfe.modelo.ICMS20;

public class ICMSComReducaoBaseCalculoImpl implements ICMSComReducaoBaseCalculo, ObjectCreator {

    private final ICMSBuilderDelegate<ICMS20> delegate;

    public ICMSComReducaoBaseCalculoImpl() {
        delegate = new ICMSBuilderDelegate<ICMS20>(ICMS20.class);
    }

    public static ICMSComReducaoBaseCalculoImpl create() {
        return new ICMSComReducaoBaseCalculoImpl();
    }

    public ICMSComReducaoBaseCalculoImpl withOrigem(final OrigemICMS origem) {
        delegate.withOrigem(origem);
        return this;
    }

    public ICMSComReducaoBaseCalculoImpl withModalidade(final ModalidadeBaseCalculo modalidade) {
        delegate.withModalidade(modalidade);
        return this;
    }

    public ICMSComReducaoBaseCalculoImpl withPercentualReducaoBaseCalculo(final BigDecimal percentual) {
        delegate.withPercentualReducaoBaseCalculo(percentual);
        return this;
    }

    public ICMSComReducaoBaseCalculoImpl withBaseCalculo(final BigDecimal valor) {
        delegate.withBaseDeCalculo(valor);
        return this;
    }

    public ICMSComReducaoBaseCalculoImpl withAliquota(final BigDecimal aliquota) {
        delegate.withAliquota(aliquota);
        return this;
    }

    public ICMSComReducaoBaseCalculoImpl withValor(final BigDecimal valor) {
        delegate.withValor(valor);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) delegate.getReference();
    }

}
