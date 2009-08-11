package br.com.caelum.stella.nfe.builder.impl;

import br.com.caelum.stella.nfe.builder.NFe;
import br.com.caelum.stella.nfe.proxy.NFeProxyFactory;

/**
 * @author jonasabreu
 * 
 */
final public class NFeWebServiceWrapperFactory {

    public NFeWebServiceWrapperImpl createWrapper(final NFeWebServiceType wsType, final NFe parent) {
        Object creator = new NFeProxyFactory().createProxyFor(wsType.getBuilderType(), parent);
        return new NFeWebServiceWrapperImpl(wsType, creator);
    }

}
