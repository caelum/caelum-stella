package br.com.caelum.stella.nfe.builder.icms.impl;

import java.math.BigDecimal;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.icms.ICMSDiferimento;
import br.com.caelum.stella.nfe.builder.icms.enums.ModalidadeBaseCalculo;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;
import br.com.caelum.stella.nfe.modelo.ICMS51;

public class ICMSDiferimentoImpl implements ICMSDiferimento, ObjectCreator  {

    private ICMSBuilderDelegate<ICMS51> delegate;

    public ICMSDiferimentoImpl() {
        delegate = new ICMSBuilderDelegate<ICMS51>(ICMS51.class);
    }

    public static ICMSDiferimentoImpl create() {
        return new ICMSDiferimentoImpl();
    }

    public ICMSDiferimentoImpl withOrigem(OrigemICMS origem) {
        delegate.withOrigem(origem);
        return this;
    }

    public ICMSDiferimentoImpl withModalidade(ModalidadeBaseCalculo modalidade) {
        delegate.withModalidade(modalidade);
        return this;
    }

    public ICMSDiferimentoImpl withPercentualReducaoBaseCalculo(BigDecimal percentualReducaoBaseCalculo) {
        delegate.withPercentualReducaoBaseCalculo(percentualReducaoBaseCalculo);
        return this;
    }

    public ICMSDiferimentoImpl withBaseCalculo(BigDecimal baseCalculo) {
        delegate.withBaseDeCalculo(baseCalculo);
        return this;
    }

    public ICMSDiferimentoImpl withAliquota(BigDecimal aliquota) {
        delegate.withAliquota(aliquota);
        return this;
    }

    public ICMSDiferimentoImpl withValor(BigDecimal valor) {
        delegate.withValor(valor);
        return this;
    }

    public ICMS51 getInstance() {
        return delegate.getReference();
    }

}
