package br.com.caelum.stella.nfe.builder.impl;

import net.vidageek.fluid.proxy.ObjectCreator;
import br.com.caelum.stella.nfe.builder.NFe;
import br.com.caelum.stella.nfe.builder.NFeDeInutilizacao;
import br.com.caelum.stella.nfe.fluid.TInutNFe;
import br.com.caelum.stella.nfe.fluid.TProcInutNFe;

/**
 * @author jonasabreu
 * 
 */
final public class NFeDeInutilizacaoImpl implements NFeDeInutilizacao<NFe>, ObjectCreator {

    public NFeDeInutilizacaoImpl(final NFe fe) {
    }

    public TInutNFe<NFeDeInutilizacao<NFe>> deNota() {
        return null;
    }

    public TProcInutNFe<NFeDeInutilizacao<NFe>> deNotaProcessada() {
        return null;
    }

    public NFe build() {
        return null;
    }

    public Object getInstance() {
        return null;
    }

}
