package br.com.caelum.stella.nfe.builder.impl;

import net.vidageek.fluid.proxy.ObjectCreator;
import br.com.caelum.stella.nfe.builder.NFe;
import br.com.caelum.stella.nfe.builder.NFeDeConsulta;
import br.com.caelum.stella.nfe.fluid.PedidoDeConsultaDoRecidoDoLoteDeNFE;
import br.com.caelum.stella.nfe.fluid.TConsCad;
import br.com.caelum.stella.nfe.fluid.TConsSitNFe;
import br.com.caelum.stella.nfe.fluid.TConsStatServ;
import br.com.caelum.stella.nfe.proxy.NFeProxyFactory;

/**
 * @author jonasabreu
 * 
 */
final public class NFeDeConsultaImpl implements NFeDeConsulta<NFe>, ObjectCreator {

    private final NFe nfe;
    private Object creator;

    public NFeDeConsultaImpl(final NFe nfe) {
        this.nfe = nfe;
    }

    public TConsCad<NFeDeConsulta<NFe>> deCadastro() {
        TConsCad creator = new NFeProxyFactory().createProxyFor(TConsCad.class);
        this.creator = creator;
        return creator;
    }

    public PedidoDeConsultaDoRecidoDoLoteDeNFE<NFeDeConsulta<NFe>> deRecibo() {
        PedidoDeConsultaDoRecidoDoLoteDeNFE creator = new NFeProxyFactory()
            .createProxyFor(PedidoDeConsultaDoRecidoDoLoteDeNFE.class);
        this.creator = creator;
        return creator;
    }

    public TConsSitNFe<NFeDeConsulta<NFe>> deSituacao() {
        TConsSitNFe creator = new NFeProxyFactory().createProxyFor(TConsSitNFe.class);
        this.creator = creator;
        return creator;
    }

    public TConsStatServ<NFeDeConsulta<NFe>> deStatusDeServico() {
        TConsStatServ creator = new NFeProxyFactory().createProxyFor(TConsStatServ.class);
        this.creator = creator;
        return creator;
    }

    public NFe build() {
        return nfe;
    }

    public Object getInstance() {
        return ((ObjectCreator) creator).getInstance();
    }

}
