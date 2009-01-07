package br.com.caelum.stella.nfe.builder.icms.impl;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.icms.ICMSComReducaoBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;
import br.com.caelum.stella.nfe.modelo.ICMS20;

public class ICMSComReducaoBaseCalculoImpl implements ICMSComReducaoBaseCalculo, ObjectCreator  {

    private final ICMSBuilderDelegate<ICMS20> delegate;

    public ICMSComReducaoBaseCalculoImpl() {
        delegate = new ICMSBuilderDelegate<ICMS20>(ICMS20.class);
    }

    public static ICMSComReducaoBaseCalculoImpl create() {
        return new ICMSComReducaoBaseCalculoImpl();
    }

    public ICMSComReducaoBaseCalculoImpl withOrigem(OrigemICMS origem) {
        delegate.withOrigem(origem);
        return this;
    }

    public ICMSComReducaoBaseCalculoImpl withModalidade(ModalidadeBaseCalculo modalidade) {
        delegate.withModalidade(modalidade);
        return this;
    }

    public ICMSComReducaoBaseCalculoImpl withPercentualReducaoBaseCalculo(BigDecimal percentual) {
        delegate.withPercentualReducaoBaseCalculo(percentual);
        return this;
    }

    public ICMSComReducaoBaseCalculoImpl withBaseCalculo(BigDecimal valor) {
        delegate.withBaseDeCalculo(valor);
        return this;
    }

    public ICMSComReducaoBaseCalculoImpl withAliquota(BigDecimal aliquota) {
        delegate.withAliquota(aliquota);
        return this;
    }

    public ICMSComReducaoBaseCalculoImpl withValor(BigDecimal valor) {
        delegate.withValor(valor);
        return this;
    }

    public ICMS20 getInstance() {
        return delegate.getReference();
    }

}
