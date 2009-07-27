package br.com.caelum.stella.nfe.builder;

import net.vidageek.fluid.FluidInterface;
import br.com.caelum.stella.nfe.fluid.TInutNFe;
import br.com.caelum.stella.nfe.fluid.TProcInutNFe;

/**
 * @author jonasabreu
 * 
 */
public interface NFeDeInutilizacao<T> extends FluidInterface<T> {

    TProcInutNFe<NFeDeInutilizacao<T>> deNotaProcessada();

    TInutNFe<NFeDeInutilizacao<T>> deNota();

}
