package br.com.caelum.stella.nfe.builder.impl;

import net.vidageek.fluid.proxy.ObjectCreator;
import br.com.caelum.stella.nfe.builder.NFe;
import br.com.caelum.stella.nfe.builder.NFeDeConsulta;
import br.com.caelum.stella.nfe.builder.NFeWebServiceWrapper;
import br.com.caelum.stella.nfe.fluid.PedidoDeConsultaDoRecidoDoLoteDeNFE;
import br.com.caelum.stella.nfe.fluid.TConsCad;
import br.com.caelum.stella.nfe.fluid.TConsSitNFe;
import br.com.caelum.stella.nfe.fluid.TConsStatServ;

/**
 * @author jonasabreu
 * 
 */
final public class NFeDeConsultaImpl implements NFeDeConsulta<NFe>, ObjectCreator {

    private final NFe nfe;
    private NFeWebServiceWrapper wrapper;

    public NFeDeConsultaImpl(final NFe nfe) {
        this.nfe = nfe;
    }

    public NFeWebServiceWrapper<TConsCad<NFe>> deCadastro() {
        wrapper = new NFeWebServiceWrapperFactory().createWrapper(TConsCad.class, nfe);
        return wrapper;
    }

    public NFeWebServiceWrapper<PedidoDeConsultaDoRecidoDoLoteDeNFE<NFe>> deRecibo() {
        wrapper = new NFeWebServiceWrapperFactory().createWrapper(PedidoDeConsultaDoRecidoDoLoteDeNFE.class, nfe);
        return wrapper;
    }

    public NFeWebServiceWrapper<TConsSitNFe<NFe>> deSituacao() {
        wrapper = new NFeWebServiceWrapperFactory().createWrapper(TConsSitNFe.class, nfe);
        return wrapper;
    }

    public NFeWebServiceWrapper<TConsStatServ<NFe>> deStatusDeServico() {
        wrapper = new NFeWebServiceWrapperFactory().createWrapper(TConsStatServ.class, nfe);
        return wrapper;
    }

    public NFe build() {
        return nfe;
    }

    public Object getInstance() {
        return wrapper;
    }

}
