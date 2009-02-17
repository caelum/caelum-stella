package br.com.caelum.stella.nfe.builder.icms.impl;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.icms.ICMSOutros;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeST;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;
import br.com.caelum.stella.nfe.modelo.ICMS90;

public class ICMSOutrosImpl implements ICMSOutros, ObjectCreator  {

    private ICMSBuilderDelegate<ICMS90> delegate;

    public ICMSOutrosImpl() {
        delegate = new ICMSBuilderDelegate<ICMS90>(ICMS90.class);
    }

    public static ICMSOutrosImpl create() {
        return new ICMSOutrosImpl();
    }

    public ICMSOutrosImpl withOrigem(OrigemICMS origem) {
        delegate.withOrigem(origem);
        return this;
    }

    public ICMSOutrosImpl withModalidade(ModalidadeBaseCalculo modalidadeBaseCalculo) {
        delegate.withModalidade(modalidadeBaseCalculo);
        return this;
    }

    public ICMSOutrosImpl withBaseDeCalculo(BigDecimal baseCalculo) {
        delegate.withBaseDeCalculo(baseCalculo);
        return this;
    }

    public ICMSOutrosImpl withPercentualReducaoBaseCalculo(BigDecimal percentual) {
        delegate.withPercentualReducaoBaseCalculo(percentual);
        return this;
    }

    public ICMSOutrosImpl withAliquota(BigDecimal aliquota) {
        delegate.withAliquota(aliquota);
        return this;
    }

    public ICMSOutrosImpl withValor(BigDecimal valor) {
        delegate.withValor(valor);
        return this;
    }

    public ICMSOutrosImpl withModalidadeST(ModalidadeST modalidade) {
        delegate.withModalidadeSubstituicaoTributaria(modalidade);
        return this;
    }

    public ICMSOutrosImpl withPercentualAdicionadoST(BigDecimal percentual) {
        delegate.withPercentualAdicionadoSubstituicaoTributaria(percentual);
        return this;
    }

    public ICMSOutrosImpl withValorDaBaseDeCalculoST(BigDecimal valor) {
        delegate.withValorDaBaseDeCalculoSubstituicaoTributaria(valor);
        return this;
    }

    public ICMSOutrosImpl withAliquotaST(BigDecimal aliquota) {
        delegate.withAliquotaSubstituicaoTributaria(aliquota);
        return this;
    }

    public ICMSOutrosImpl withValorST(BigDecimal valor) {
        delegate.withValorSubstituicaoTributaria(valor);
        return this;
    }

    public ICMSOutrosImpl withPercentualReducaoBaseCalculoST(BigDecimal percentual) {
        delegate.withPercentualReducaoBaseCalculoSubstituicaoTributaria(percentual);
        return this;
    }

    public ICMS90 getInstance() {
        return delegate.getReference();
    }

}
