package br.com.caelum.stella.nfe.builder.icms.impl;

import static net.vidageek.mirror.Mirror.on;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeST;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;
import br.com.caelum.stella.nfe.builder.icms.enums.TributacaoICMS;

public class ICMSBuilderDelegate<T> {

    private final T instance;

    public ICMSBuilderDelegate(final Class<T> clazz) {
        instance = on(clazz).invoke().constructor().withoutArgs();
        withTributacao(clazz.getSimpleName().substring(4));
    }

    public T getModelInstance() {
        return instance;
    }

    public void withOrigem(final OrigemICMS origem) {
        on(instance).set().field("origem").withValue(origem.getValue());
    }

    public void withModalidade(final ModalidadeBaseCalculo modalidade) {
        on(instance).set().field("modalidadeBaseCalculo").withValue(modalidade.getValue());
    }

    public void withBaseDeCalculo(final BigDecimal baseDeCalculo) {
        on(instance).set().field("valorBaseCalculo").withValue(baseDeCalculo.toString());
    }

    public void withAliquota(final BigDecimal aliquota) {
        on(instance).set().field("aliquota").withValue(aliquota.toString());
    }

    public void withValor(final BigDecimal valor) {
        on(instance).set().field("valor").withValue(valor.toString());
    }

    public void withModalidadeSubstituicaoTributaria(final ModalidadeST modalidade) {
        on(instance).set().field("modalidadeSubstituicaoTributaria").withValue(modalidade.getValue());
    }

    public void withPercentualAdicionadoSubstituicaoTributaria(final BigDecimal percentualAdicionado) {
        on(instance).set().field("percentualAdicionadoSubstituicaoTributaria").withValue(
                percentualAdicionado.toString());
    }

    public void withPercentualReducaoBaseCalculo(final BigDecimal percentualReducaoBaseCalculo) {
        on(instance).set().field("percentualReducaoBaseCalculo").withValue(percentualReducaoBaseCalculo.toString());
    }

    public void withValorBaseCalculoSubstituicaoTributaria(final BigDecimal valorBaseCalculo) {
        on(instance).set().field("valorBaseCalculoSubstituicaoTributaria").withValue(valorBaseCalculo.toString());
    }

    public void withPercentualReducaoBaseCalculoSubstituicaoTributaria(final BigDecimal percentualReducao) {
        on(instance).set().field("percentualReducaoSubstituicaoTributaria").withValue(percentualReducao.toString());
    }

    public void withAliquotaSubstituicaoTributaria(final BigDecimal aliquota) {
        on(instance).set().field("aliquotaSubstituicaoTributaria").withValue(aliquota.toString());
    }

    public void withValorSubstituicaoTributaria(final BigDecimal valor) {
        on(instance).set().field("valorSubstituicaoTributaria").withValue(valor.toString());
    }

    public void withTributacao(TributacaoICMS tributacao) {
        withTributacao(tributacao.getTributacao());
    }

    private void withTributacao(String tributacao) {
        on(instance).set().field("tipoTributacao").withValue(tributacao);
    }

    public T getReference() {
        return instance;
    }

}
