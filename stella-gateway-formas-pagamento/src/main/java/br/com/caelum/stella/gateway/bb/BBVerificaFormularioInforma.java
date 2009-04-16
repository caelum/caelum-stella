package br.com.caelum.stella.gateway.bb;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.stella.gateway.core.BigDecimalFormatter;
import br.com.caelum.stella.gateway.core.IntegrationHandler;

public class BBVerificaFormularioInforma implements
		IntegrationHandler<BBFormularioInformaReturn> {

	private HttpServletRequest request;

	public BBVerificaFormularioInforma(HttpServletRequest request) {
		super();
		this.request = request;
	}

	public BBFormularioInformaReturn handle() {
		// TODO Auto-generated method stub
		BigDecimal valor = new BigDecimalFormatter()
				.stringInCentsToBigDecimal(request.getParameter("valor"));
		return new BBFormularioInformaReturn(new BBBasicDataReturn(Integer.valueOf(request
				.getParameter("idConv")), request.getParameter("refTran")),
				valor);
	}

}
