package br.com.caelum.stella.gateway.visa;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.stella.gateway.core.BigDecimalFormatter;
import br.com.caelum.stella.gateway.core.ReturnBuilder;

public enum VISAHttpReturnBuilder implements ReturnBuilder<VISAIntegrationReturn,HttpServletRequest> {

	AUTORIZACAO_RETORNO_BUILDER() {

		public VISAAutorizacaoReturn buildReturn(HttpServletRequest request) {
			// TODO Auto-generated method stub
			VISACheckout checkout = new VISACheckout(request.getParameter("orderid"),
					null, request.getParameter("free"), request
							.getParameter("price"), null, null);
			VISAAutorizacaoReturn retornoAutorizacao = new VISAAutorizacaoReturn(
					new VISABasicDataReturn(Integer.valueOf(request
							.getParameter("lr")), request.getParameter("ars"),
							request.getParameter("tid")), request
							.getParameter("arp"), request.getParameter("pan"),
					Integer.valueOf(request.getParameter("bank")), checkout);
			return retornoAutorizacao;
		}

	},

	CAPTURA_RETORNO_BUILDER() {
		public VISACapturaReturn buildReturn(HttpServletRequest request) {
			VISACapturaReturn retornoCaptura = new VISACapturaReturn(
					new VISABasicDataReturn(Integer.valueOf(request
							.getParameter("lr")), request.getParameter("tid"),
							request.getParameter("ars")), new BigDecimalFormatter()
							.stringInCentsToBigDecimal(request.getParameter("cap")),
					request.getParameter("free"));
			return retornoCaptura;
		}
	},
	CANCELAMENTO_RETORNO_BUILDER() {
		public VISACancelamentoReturn buildReturn(HttpServletRequest request) {
			VISACancelamentoReturn retornoCancelamento = new VISACancelamentoReturn(
					new VISABasicDataReturn(Integer.valueOf(request
							.getParameter("lr")), request.getParameter("tid"),
							request.getParameter("ars")), new BigDecimalFormatter()
							.stringInCentsToBigDecimal(request
									.getParameter("cancel_amount")), request
							.getParameter("free"));
			return retornoCancelamento;
		}
	},
	CONSULTA_RETORNO_BUILDER() {

		public VISAConsultaReturn buildReturn(HttpServletRequest request) {
			/*
			 * trecho repetido, mas como é só aqui mesmo, ainda é aceitável.
			 */
			VISACheckout checkout = new VISACheckout(request.getParameter("orderid"),
					null, request.getParameter("free"), request
							.getParameter("price"), null, null);
			VISAConsultaReturn retornoConsulta = new VISAConsultaReturn(
					new VISABasicDataReturn(Integer.valueOf(request
							.getParameter("lr")), request.getParameter("tid"),
							request.getParameter("ars")), checkout, Integer
							.valueOf(request.getParameter("authent")), Integer.valueOf(request
							.getParameter("bank")));
			return retornoConsulta;
		}
	};

}
