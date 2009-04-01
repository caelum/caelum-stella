package br.com.caelum.stella.gateway.visa.integration;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.stella.gateway.core.BigDecimalFormatter;
import br.com.caelum.stella.gateway.core.ReturnBuilder;
import br.com.caelum.stella.gateway.visa.Checkout;

public enum VISAHttpReturnBuilder implements ReturnBuilder<VISAIntegrationReturn,HttpServletRequest> {

	AUTORIZACAO_RETORNO_BUILDER() {

		public VISAAutorizacaoReturn buildRetorno(HttpServletRequest request) {
			// TODO Auto-generated method stub
			Checkout checkout = new Checkout(request.getParameter("orderid"),
					null, request.getParameter("free"), request
							.getParameter("price"), null, null);
			VISAAutorizacaoReturn retornoAutorizacao = new VISAAutorizacaoReturn(
					new VISABasicDataReturn(Integer.valueOf(request
							.getParameter("lr")), request.getParameter("ars"),
							request.getParameter("tid")), request
							.getParameter("arp"), request.getParameter("pan"),
					request.getParameter("bank"), checkout);
			return retornoAutorizacao;
		}

	},

	CAPTURA_RETORNO_BUILDER() {
		public VISACapturaReturn buildRetorno(HttpServletRequest request) {
			VISACapturaReturn retornoCaptura = new VISACapturaReturn(
					new VISABasicDataReturn(Integer.valueOf(request
							.getParameter("lr")), request.getParameter("tid"),
							request.getParameter("ars")), BigDecimalFormatter
							.stringInCentsToBigDecimal(request.getParameter("cap")),
					request.getParameter("free"));
			return retornoCaptura;
		}
	},
	CANCELAMENTO_RETORNO_BUILDER() {
		public VISACancelamentoReturn buildRetorno(HttpServletRequest request) {
			VISACancelamentoReturn retornoCancelamento = new VISACancelamentoReturn(
					new VISABasicDataReturn(Integer.valueOf(request
							.getParameter("lr")), request.getParameter("tid"),
							request.getParameter("ars")), BigDecimalFormatter
							.stringInCentsToBigDecimal(request
									.getParameter("cancel_amount")), request
							.getParameter("free"));
			return retornoCancelamento;
		}
	},
	CONSULTA_RETORNO_BUILDER() {

		public VISAConsultaReturn buildRetorno(HttpServletRequest request) {
			/*
			 * trecho repetido, mas como é só aqui mesmo, ainda é aceitável.
			 */
			Checkout checkout = new Checkout(request.getParameter("orderid"),
					null, request.getParameter("free"), request
							.getParameter("price"), null, null);
			VISAConsultaReturn retornoConsulta = new VISAConsultaReturn(
					new VISABasicDataReturn(Integer.valueOf(request
							.getParameter("lr")), request.getParameter("tid"),
							request.getParameter("ars")), checkout, Integer
							.valueOf(request.getParameter("authent")), request
							.getParameter("bank"));
			return retornoConsulta;
		}
	};

}
