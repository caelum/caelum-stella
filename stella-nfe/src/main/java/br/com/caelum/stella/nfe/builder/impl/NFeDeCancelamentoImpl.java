package br.com.caelum.stella.nfe.builder.impl;

import net.vidageek.fluid.proxy.ObjectCreator;
import br.com.caelum.stella.nfe.builder.NFe;
import br.com.caelum.stella.nfe.builder.NFeDeCancelamento;
import br.com.caelum.stella.nfe.builder.NFeWebServiceWrapper;
import br.com.caelum.stella.nfe.fluid.TCancNFe;
import br.com.caelum.stella.nfe.fluid.TProcCancNFe;

/**
 * @author jonasabreu
 * 
 */
final public class NFeDeCancelamentoImpl implements NFeDeCancelamento<NFe>, ObjectCreator {

    private NFeWebServiceWrapper wrapper;
    private final NFe nfe;

    public NFeDeCancelamentoImpl(final NFe nfe) {
        this.nfe = nfe;
    }

    public NFeWebServiceWrapper<TCancNFe<NFe>> deNota() {
        wrapper = new NFeWebServiceWrapperFactory().createWrapper(TCancNFe.class);
        return wrapper;
    }

    public NFeWebServiceWrapper<TProcCancNFe<NFe>> deNotaProcessada() {
        wrapper = new NFeWebServiceWrapperFactory().createWrapper(TProcCancNFe.class);
        return wrapper;
    }

    public NFe build() {
        return nfe;
    }

    public Object getInstance() {
        return wrapper;
    }

}
