package br.com.caelum.stella.nfe.builder.impl;

import net.vidageek.fluid.proxy.ObjectCreator;
import br.com.caelum.stella.nfe.fluid.Cabecalho;
import br.com.caelum.stella.nfe.modelo.CabecMsg;

/**
 * @author jonasabreu
 * 
 */
final public class CabecalhoImpl<T> implements Cabecalho<T>, ObjectCreator {

    private final CabecMsg cabecalho;
    private final T parent;

    public CabecalhoImpl(final T parent) {
        this.parent = parent;
        cabecalho = new CabecMsg();
    }

    public Cabecalho<T> withVersao(final String versao) {
        cabecalho.setVersao(versao);
        return this;
    }

    public Cabecalho<T> withVersaoDados(final String versaoDados) {
        cabecalho.setVersaoDados(versaoDados);
        return this;
    }

    public T build() {
        return parent;
    }

    public Object getInstance() {
        return cabecalho;
    }

}
