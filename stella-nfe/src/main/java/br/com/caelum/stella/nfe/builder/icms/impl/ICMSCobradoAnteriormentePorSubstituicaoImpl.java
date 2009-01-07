package br.com.caelum.stella.nfe.builder.icms.impl;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.icms.ICMSCobradoAnteriormentePorSubstituicao;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;
import br.com.caelum.stella.nfe.modelo.ICMS60;

public class ICMSCobradoAnteriormentePorSubstituicaoImpl implements ICMSCobradoAnteriormentePorSubstituicao, ObjectCreator  {

    private ICMSBuilderDelegate<ICMS60> delegate;

    public ICMSCobradoAnteriormentePorSubstituicaoImpl() {
        delegate = new ICMSBuilderDelegate<ICMS60>(ICMS60.class);
    }

    public static ICMSCobradoAnteriormentePorSubstituicaoImpl create() {
        return new ICMSCobradoAnteriormentePorSubstituicaoImpl();
    }

    public ICMSCobradoAnteriormentePorSubstituicaoImpl withOrigem(OrigemICMS origem) {
        delegate.withOrigem(origem);
        return this;
    }

    public ICMSCobradoAnteriormentePorSubstituicaoImpl withValorBaseCalculoSubstituicaoTributaria(
            BigDecimal valorBaseCalculo) {
        delegate.withValorBaseCalculoSubstituicaoTributaria(valorBaseCalculo);
        return this;
    }

    public ICMSCobradoAnteriormentePorSubstituicaoImpl withValorSubstituicaoTributaria(
            BigDecimal valorSubstituicaoTributaria) {
        delegate.withValorSubstituicaoTributaria(valorSubstituicaoTributaria);
        return this;
    }

    public ICMS60 getInstance() {
        return delegate.getReference();
    }

}
