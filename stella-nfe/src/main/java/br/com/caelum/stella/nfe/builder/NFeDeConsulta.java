package br.com.caelum.stella.nfe.builder;

import br.com.caelum.stella.nfe.fluid.PedidoDeConsultaDoRecidoDoLoteDeNFE;
import br.com.caelum.stella.nfe.fluid.TConsCad;
import br.com.caelum.stella.nfe.fluid.TConsSitNFe;
import br.com.caelum.stella.nfe.fluid.TConsStatServ;

/**
 * @author jonasabreu
 * 
 */
public interface NFeDeConsulta<T> {

    TConsSitNFe<NFeDeConsulta<T>> deSituacao();

    TConsStatServ<NFeDeConsulta<T>> deStatusDeServico();

    PedidoDeConsultaDoRecidoDoLoteDeNFE<NFeDeConsulta<T>> deRecibo();

    TConsCad<NFeDeConsulta<T>> deCadastro();

}
