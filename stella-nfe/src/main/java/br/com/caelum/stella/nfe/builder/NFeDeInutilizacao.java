package br.com.caelum.stella.nfe.builder;

import br.com.caelum.stella.nfe.fluid.TInutNFe;
import br.com.caelum.stella.nfe.fluid.TProcInutNFe;

/**
 * @author jonasabreu
 * 
 */
public interface NFeDeInutilizacao<T> {

    TProcInutNFe<NFeDeInutilizacao<T>> deNotaProcessada();

    TInutNFe<NFeDeInutilizacao<T>> deNota();

}
