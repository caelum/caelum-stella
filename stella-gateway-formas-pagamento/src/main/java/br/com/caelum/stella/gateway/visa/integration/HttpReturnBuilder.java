package br.com.caelum.stella.gateway.visa.integration;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.stella.gateway.visa.Checkout;
import br.com.caelum.stella.gateway.visa.BasicDataReturn;

public enum HttpReturnBuilder implements ReturnBuilder<HttpServletRequest>{	

	AUTORIZACAO_RETORNO_BUILDER(){
		
		public AutorizacaoReturn buildRetorno(HttpServletRequest request) {
			// TODO Auto-generated method stub
			Checkout checkout = new Checkout(request
					.getParameter("orderid"), null, request
					.getParameter("free"), request.getParameter("price"),
					null, null);		
			AutorizacaoReturn retornoAutorizacao = new AutorizacaoReturn(
					new BasicDataReturn(Integer.valueOf(request.getParameter("lr")), request
							.getParameter("ars"), request.getParameter("tid")),
					request.getParameter("arp"), request.getParameter("pan"),
					request.getParameter("bank"),checkout);			
			return retornoAutorizacao;
		}
		
		
	},
	
	CAPTURA_RETORNO_BUILDER(){
		public CapturaReturn buildRetorno(HttpServletRequest request) {
			CapturaReturn retornoCaptura = new CapturaReturn(new BasicDataReturn(Integer.valueOf(request.getParameter("lr")),request.getParameter("tid"),request.getParameter("ars")),new BigDecimal(request.getParameter("cap")),request.getParameter("free"));			
			return retornoCaptura;		
		}
	},
	CANCELAMENTO_RETORNO_BUILDER(){
		public CancelamentoReturn buildRetorno(HttpServletRequest request) {
			CancelamentoReturn retornoCancelamento = new CancelamentoReturn(new BasicDataReturn(Integer.valueOf(request.getParameter("lr")),request.getParameter("tid"),request.getParameter("ars")),new BigDecimal(request.getParameter("cancel_amount")),request.getParameter("free"));			
			return retornoCancelamento;		
		}
	},
	CONSULTA_RETORNO_BUILDER(){
		
		public ConsultaReturn buildRetorno(HttpServletRequest request) {
			/*
			 * trecho repetido, mas só por isso é aceitavel.
			 */
			Checkout checkout = new Checkout(request
					.getParameter("orderid"), null, request
					.getParameter("free"), request.getParameter("price"),
					null, null);				
			ConsultaReturn retornoConsulta = new ConsultaReturn(new BasicDataReturn(Integer.valueOf(request.getParameter("lr")),request.getParameter("tid"),request.getParameter("ars")),checkout,Integer.valueOf(request.getParameter("authent")),request.getParameter("bank"));
			return retornoConsulta;
		}
	}	
	;
	
	
	

}
