package br.com.caelum.stella.gateway.visa;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.stella.gateway.core.BigDecimalFormatter;
import br.com.caelum.stella.gateway.core.ReturnBuilder;

public enum VISAHttpReturnBuilder implements
		ReturnBuilder<VISAIntegrationReturn, HttpServletRequest> {

	AUTORIZACAO_RETORNO_BUILDER() {

		public VISAAutorizacaoReturn buildReturn(HttpServletRequest request) {
			// TODO Auto-generated method stub
			VISACheckout checkout = new VISACheckout(request
					.getParameter("orderid"), null, request
					.getParameter("free"), request.getParameter("Price"), null);
			VISAAutorizacaoReturn retornoAutorizacao = new VISAAutorizacaoReturn(
					new VISABasicDataReturn(Integer.valueOf(request
							.getParameter("lr")), request.getParameter("ars"),
							request.getParameter("tid")), request
							.getParameter("arp"), request.getParameter("Pan"),
					checkout);
			return retornoAutorizacao;
		}

	},

	CAPTURA_RETORNO_BUILDER() {
		public VISACapturaReturn buildReturn(HttpServletRequest request) {
			VISACapturaReturn retornoCaptura = new VISACapturaReturn(
					new VISABasicDataReturn(Integer.valueOf(request
							.getParameter("lr")), request.getParameter("tid"),
							request.getParameter("ars")),
					new BigDecimalFormatter().stringInCentsToBigDecimal(request
							.getParameter("cap")));
			return retornoCaptura;
		}
	},
	CANCELAMENTO_RETORNO_BUILDER() {
		public VISACancelamentoReturn buildReturn(HttpServletRequest request) {
			VISACancelamentoReturn retornoCancelamento = new VISACancelamentoReturn(
					new VISABasicDataReturn(Integer.valueOf(request
							.getParameter("lr")), request.getParameter("tid"),
							request.getParameter("ars")));
			return retornoCancelamento;
		}
	},
	CONSULTA_RETORNO_BUILDER() {

		public VISAConsultaReturn buildReturn(HttpServletRequest request) {
			/*
			 * trecho repetido, mas como é só aqui mesmo, ainda é aceitável.
			 */
			VISACheckout checkout = new VISACheckout(request
					.getParameter("orderid"), null, request
					.getParameter("free"), request.getParameter("price"), null);
			VISAConsultaReturn retornoConsulta = new VISAConsultaReturn(
					new VISABasicDataReturn(Integer.valueOf(request
							.getParameter("lr")), request.getParameter("tid"),
							request.getParameter("ars")), checkout, Integer
							.valueOf(request.getParameter("Authent")), Integer
							.valueOf(request.getParameter("bank")));
			return retornoConsulta;
		}
	};

}
