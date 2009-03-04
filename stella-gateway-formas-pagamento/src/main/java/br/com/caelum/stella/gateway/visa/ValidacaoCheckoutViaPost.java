package br.com.caelum.stella.gateway.visa;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.stella.gateway.core.Integracao;
import br.com.caelum.stella.gateway.core.TransacaoComProblemaException;

/**
 * Verifica se a transacao para determinado checkout foi concluida com êxito ou não
 * @author Alberto Pc
 *
 */
public class ValidacaoCheckoutViaPost implements Integracao<ResultadoCheckout> {

	private HttpServletRequest request;	
	
	public ValidacaoCheckoutViaPost(HttpServletRequest request){
		this.request = request;		
	}
	
	public ResultadoCheckout integra() {
		// TODO Auto-generated method stub
		ResultadoCheckout resultadoCheckout = new ResultadoCheckout(request.getParameter("lr"),request.getParameter("arp"),request.getParameter("pan"),request.getParameter("ars"),new Checkout(request.getParameter("orderid"),null,request.getParameter("free"),calculaPrecoDividoPorCem(),null,null));
		if(!resultadoCheckout.getLr().equals("0") || !resultadoCheckout.getLr().equals("00") || !resultadoCheckout.getLr().equals("11")){
			throw new TransacaoComProblemaException("A transacao foi negada",resultadoCheckout);
		}
		return resultadoCheckout;		
	}

	private BigDecimal calculaPrecoDividoPorCem() {
		return new BigDecimal(request.getParameter("price")).divide(new BigDecimal(100));
	}

}
