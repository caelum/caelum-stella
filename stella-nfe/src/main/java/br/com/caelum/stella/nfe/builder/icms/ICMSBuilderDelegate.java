package br.com.caelum.stella.nfe.builder.icms;

import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeSubstituicaoTributaria;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;

import static net.vidageek.mirror.Mirror.on;

public class ICMSBuilderDelegate<T> {

    private final T instance;

    public ICMSBuilderDelegate(final Class<T> clazz) {
        T instance = on(clazz).invoke().constructor().withoutArgs();
        on(instance).set().field("tipoTributacao").withValue(clazz.getSimpleName().substring(4));
        this.instance = instance;
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

    public void withBaseDeCalculo(final String baseDeCalculo) {
        on(instance).set().field("valorBaseCalculo").withValue(baseDeCalculo);
    }

    public void withAliquota(final String aliquota) {
        on(instance).set().field("aliquota").withValue(aliquota);
    }

    public void withValor(final String valor) {
        on(instance).set().field("valor").withValue(valor);
    }

    public void withModalidadeSubstituicaoTributaria(final ModalidadeSubstituicaoTributaria modalidade) {
        on(instance).set().field("modalidadeSubstituicaoTributaria").withValue(modalidade.getValue());

    }

    public void withPercentualAdicionadoSubstituicaoTributaria(final String percentualAdicionado) {
        on(instance).set().field("percentualAdicionadoSubstituicaoTributaria").withValue(percentualAdicionado);
    }

    public void withPercentualReducaoBaseCalculo(final String percentualReducaoBaseCalculo) {
        on(instance).set().field("percentualReducaoBaseCalculo").withValue(percentualReducaoBaseCalculo);
    }

    public void withValorBaseCalculoSubstituicaoTributaria(final String valorBaseCalculo) {
        on(instance).set().field("valorBaseCalculoSubstituicaoTributaria").withValue(valorBaseCalculo);
    }

    public void withAliquotaSubstituicaoTributaria(final String aliquota) {
        on(instance).set().field("aliquotaSubstituicaoTributaria").withValue(aliquota);
    }

    public void withValorSubstituicaoTributaria(final String valor) {
        on(instance).set().field("valorSubstituicaoTributaria").withValue(valor);
    }

}
