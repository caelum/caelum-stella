package br.com.caelum.stella.nfe.builder;

import net.vidageek.fluid.FluidInterface;
import br.com.caelum.stella.nfe.fluid.TInutNFe;
import br.com.caelum.stella.nfe.fluid.TProcInutNFe;

/**
 * @author jonasabreu
 * 
 */
public interface NFeDeInutilizacao<T> extends FluidInterface<T> {

    NFeWebServiceWrapper<TProcInutNFe<T>> deNotaProcessada();

    NFeWebServiceWrapper<TInutNFe<T>> deNota();

}
