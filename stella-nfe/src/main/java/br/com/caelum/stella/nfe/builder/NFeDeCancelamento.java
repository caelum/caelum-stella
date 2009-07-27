package br.com.caelum.stella.nfe.builder;

import net.vidageek.fluid.FluidInterface;
import br.com.caelum.stella.nfe.fluid.TCancNFe;
import br.com.caelum.stella.nfe.fluid.TProcCancNFe;

/**
 * @author jonasabreu
 * 
 */
public interface NFeDeCancelamento<T> extends FluidInterface<T> {

    TProcCancNFe<NFeDeCancelamento<T>> deNotaProcessada();

    TCancNFe<NFeDeCancelamento<T>> deNota();

}
