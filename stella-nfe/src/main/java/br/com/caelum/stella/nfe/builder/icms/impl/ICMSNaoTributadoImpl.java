package br.com.caelum.stella.nfe.builder.icms.impl;

import br.com.caelum.stella.nfe.ObjectCreator;
import br.com.caelum.stella.nfe.builder.icms.ICMSNaoTributado;
import br.com.caelum.stella.nfe.builder.icms.enums.OrigemICMS;
import br.com.caelum.stella.nfe.builder.icms.enums.TributacaoICMS;
import br.com.caelum.stella.nfe.modelo.ICMS40;

/**
 * 
 * @author jonasabreu
 * 
 */
public class ICMSNaoTributadoImpl implements ICMSNaoTributado, ObjectCreator  {

    private ICMSBuilderDelegate<ICMS40> delegate;

    public ICMSNaoTributadoImpl() {
        delegate = new ICMSBuilderDelegate<ICMS40>(ICMS40.class);
    }

    public static ICMSNaoTributadoImpl create() {
        return new ICMSNaoTributadoImpl();
    }

    public ICMSNaoTributadoImpl withOrigem(OrigemICMS origem) {
        delegate.withOrigem(origem);
        return this;
    }

    public ICMSNaoTributadoImpl withTributacao(TributacaoICMS tributacao) {
        delegate.withTributacao(tributacao);
        return this;
    }

    public ICMS40 getInstance() {
        return delegate.getReference();
    }

}
