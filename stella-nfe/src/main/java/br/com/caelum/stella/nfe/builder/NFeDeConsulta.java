package br.com.caelum.stella.nfe.builder;

import net.vidageek.fluid.FluidInterface;
import br.com.caelum.stella.nfe.fluid.PedidoDeConsultaDoRecidoDoLoteDeNFE;
import br.com.caelum.stella.nfe.fluid.TConsCad;
import br.com.caelum.stella.nfe.fluid.TConsSitNFe;
import br.com.caelum.stella.nfe.fluid.TConsStatServ;

/**
 * @author jonasabreu
 * 
 */
public interface NFeDeConsulta<T> extends FluidInterface<T> {

    NFeWebServiceWrapper<TConsSitNFe<T>> deSituacao();

    NFeWebServiceWrapper<TConsStatServ<T>> deStatusDeServico();

    NFeWebServiceWrapper<PedidoDeConsultaDoRecidoDoLoteDeNFE<T>> deRecibo();

    NFeWebServiceWrapper<TConsCad<T>> deCadastro();

}
