package br.com.caelum.stella.nfe.builder.impl;

import br.com.caelum.stella.nfe.builder.NFe;
import br.com.caelum.stella.nfe.fluid.TProcCancNFe;
import br.com.caelum.stella.nfe.proxy.NFeProxyFactory;

/**
 * @author jonasabreu
 * 
 */
final public class NFeWebServiceWrapperFactory {

    public <T> NFeWebServiceWrapperImpl createWrapper(final Class<T> type) {
        T creator = new NFeProxyFactory().createProxyFor(type);
        NFeWebServiceWrapperImpl<TProcCancNFe<NFe>> nfeWrapper = new NFeWebServiceWrapperImpl(creator);
        return nfeWrapper;
    }

}
