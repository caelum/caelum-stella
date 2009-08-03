package br.com.caelum.stella.nfe.builder.impl;

import net.vidageek.fluid.proxy.ObjectCreator;
import br.com.caelum.stella.nfe.builder.NFe;
import br.com.caelum.stella.nfe.builder.NFeDeInutilizacao;
import br.com.caelum.stella.nfe.builder.NFeWebServiceWrapper;
import br.com.caelum.stella.nfe.fluid.TInutNFe;
import br.com.caelum.stella.nfe.fluid.TProcInutNFe;

/**
 * @author jonasabreu
 * 
 */
final public class NFeDeInutilizacaoImpl implements NFeDeInutilizacao<NFe>, ObjectCreator {

    private final NFe nfe;
    private NFeWebServiceWrapperImpl wrapper;

    public NFeDeInutilizacaoImpl(final NFe nfe) {
        this.nfe = nfe;
    }

    public NFeWebServiceWrapper<TInutNFe<NFe>> deNota() {
        wrapper = new NFeWebServiceWrapperFactory().createWrapper(TInutNFe.class);
        return wrapper;
    }

    public NFeWebServiceWrapper<TProcInutNFe<NFe>> deNotaProcessada() {
        wrapper = new NFeWebServiceWrapperFactory().createWrapper(TProcInutNFe.class);
        return wrapper;
    }

    public NFe build() {
        return nfe;
    }

    public Object getInstance() {
        return wrapper;
    }

}
