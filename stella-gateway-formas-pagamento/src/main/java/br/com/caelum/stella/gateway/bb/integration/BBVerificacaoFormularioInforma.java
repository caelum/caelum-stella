package br.com.caelum.stella.gateway.bb.integration;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.stella.gateway.core.BigDecimalFormatter;
import br.com.caelum.stella.gateway.core.IntegrationHandler;

public class BBVerificacaoFormularioInforma implements
		IntegrationHandler<BBFormularioInformaReturn> {

	private final HttpServletRequest request;

	public BBVerificacaoFormularioInforma(final HttpServletRequest request) {
		super();
		this.request = request;
	}

	public BBFormularioInformaReturn handle() {
		// TODO Auto-generated method stub
		BigDecimal valor = new BigDecimalFormatter().stringInCentsToBigDecimal(request.getParameter("valor"));		
		return new BBFormularioInformaReturn(new BBBasicDataReturn(request.getParameter("idConv"),request.getParameter("refTran")),valor);
	}

}
