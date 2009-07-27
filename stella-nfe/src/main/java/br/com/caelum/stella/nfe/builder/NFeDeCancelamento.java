package br.com.caelum.stella.nfe.builder;

import br.com.caelum.stella.nfe.fluid.TCancNFe;
import br.com.caelum.stella.nfe.fluid.TProcCancNFe;

/**
 * @author jonasabreu
 * 
 */
public interface NFeDeCancelamento<T> {

    TProcCancNFe<NFeDeCancelamento<T>> deNotaProcessada();

    TCancNFe<NFeDeCancelamento<T>> deNota();

}
