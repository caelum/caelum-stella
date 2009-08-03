package br.com.caelum.stella.nfe.builder;

import net.vidageek.fluid.FluidInterface;
import br.com.caelum.stella.nfe.fluid.Cabecalho;

/**
 * @author jonasabreu
 * 
 */
public interface NFeWebServiceWrapper<T> extends FluidInterface<T> {

    Cabecalho<NFeWebServiceWrapper<T>> withCabecalho();

    T withCorpo();

}
