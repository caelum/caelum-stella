package br.com.caelum.stella.nfe.builder.impl;

import br.com.caelum.stella.nfe.builder.NFe;
import br.com.caelum.stella.nfe.proxy.NFeProxyFactory;

/**
 * @author jonasabreu
 * 
 */
final public class NFeWebServiceWrapperFactory {

    public NFeWebServiceWrapperImpl createWrapper(final Class type, final NFe parent) {
        Object creator = new NFeProxyFactory().createProxyFor(type, parent);
        return new NFeWebServiceWrapperImpl(creator);
    }

}
