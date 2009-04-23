package br.com.caelum.stella.nfe.builder.icms.impl;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.icms.ICMSOutros;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeST;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;
import br.com.caelum.stella.nfe.modelo.ICMS90;

public class ICMSOutrosImpl implements ICMSOutros, ObjectCreator {

    private final ICMSBuilderDelegate<ICMS90> delegate;

    public ICMSOutrosImpl() {
        delegate = new ICMSBuilderDelegate<ICMS90>(ICMS90.class);
    }

    public static ICMSOutrosImpl create() {
        return new ICMSOutrosImpl();
    }

    public ICMSOutrosImpl withOrigem(final OrigemICMS origem) {
        delegate.withOrigem(origem);
        return this;
    }

    public ICMSOutrosImpl withModalidade(final ModalidadeBaseCalculo modalidadeBaseCalculo) {
        delegate.withModalidade(modalidadeBaseCalculo);
        return this;
    }

    public ICMSOutrosImpl withBaseDeCalculo(final BigDecimal baseCalculo) {
        delegate.withBaseDeCalculo(baseCalculo);
        return this;
    }

    public ICMSOutrosImpl withPercentualReducaoBaseCalculo(final BigDecimal percentual) {
        delegate.withPercentualReducaoBaseCalculo(percentual);
        return this;
    }

    public ICMSOutrosImpl withAliquota(final BigDecimal aliquota) {
        delegate.withAliquota(aliquota);
        return this;
    }

    public ICMSOutrosImpl withValor(final BigDecimal valor) {
        delegate.withValor(valor);
        return this;
    }

    public ICMSOutrosImpl withModalidadeST(final ModalidadeST modalidade) {
        delegate.withModalidadeSubstituicaoTributaria(modalidade);
        return this;
    }

    public ICMSOutrosImpl withPercentualAdicionadoST(final BigDecimal percentual) {
        delegate.withPercentualAdicionadoSubstituicaoTributaria(percentual);
        return this;
    }

    public ICMSOutrosImpl withValorDaBaseDeCalculoST(final BigDecimal valor) {
        delegate.withValorDaBaseDeCalculoSubstituicaoTributaria(valor);
        return this;
    }

    public ICMSOutrosImpl withAliquotaST(final BigDecimal aliquota) {
        delegate.withAliquotaSubstituicaoTributaria(aliquota);
        return this;
    }

    public ICMSOutrosImpl withValorST(final BigDecimal valor) {
        delegate.withValorSubstituicaoTributaria(valor);
        return this;
    }

    public ICMSOutrosImpl withPercentualReducaoBaseCalculoST(final BigDecimal percentual) {
        delegate.withPercentualReducaoBaseCalculoSubstituicaoTributaria(percentual);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> T getInstance() {
        return (T) delegate.getReference();
    }

}
