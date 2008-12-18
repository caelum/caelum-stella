package br.com.caelum.stella.nfe.builder.icms;

import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;
import br.com.caelum.stella.nfe.modelo.ICMS20;

public class ICMSComReducaoBaseCalculo {

    private final ICMSBuilderDelegate<ICMS20> delegate;

    private ICMSComReducaoBaseCalculo() {
        delegate = new ICMSBuilderDelegate<ICMS20>(ICMS20.class);
    }

    public static ICMSComReducaoBaseCalculo create() {
        return new ICMSComReducaoBaseCalculo();
    }

    public ICMSComReducaoBaseCalculo withOrigem(OrigemICMS origem) {
        delegate.withOrigem(origem);
        return this;
    }

    public ICMSComReducaoBaseCalculo withModalidade(ModalidadeBaseCalculo modalidade) {
        delegate.withModalidade(modalidade);
        return this;
    }

    public ICMSComReducaoBaseCalculo withPercentualReducaoBaseCalculo(String percentual) {
        delegate.withPercentualReducaoBaseCalculo(percentual);
        return this;
    }

    public ICMSComReducaoBaseCalculo withBaseCalculo(String valor) {
        delegate.withBaseDeCalculo(valor);
        return this;
    }

    public ICMSComReducaoBaseCalculo withAliquota(String aliquota) {
        delegate.withAliquota(aliquota);
        return this;
    }

    public ICMSComReducaoBaseCalculo withValor(String valor) {
        delegate.withValor(valor);
        return this;
    }

}
