package br.com.caelum.stella.gateway.bb;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.stella.gateway.core.IntegrationHandler;
import br.com.caelum.stella.gateway.core.EnumComCodigoFinder;

public class BBVerificaFormularioRetorno implements
		IntegrationHandler<BBFormualrioRetornoReturn> {

	private HttpServletRequest request;

	public BBVerificaFormularioRetorno(HttpServletRequest request) {
		super();
		this.request = request;
	}

	public BBFormualrioRetornoReturn handle() {
		// TODO Auto-generated method stub
		BBTipoTransacao tipoTransacao = new EnumComCodigoFinder()
				.descobreAEnumPeloCodigo(BBTipoTransacao.class, request
						.getParameter("tpPagamento"));
		return new BBFormualrioRetornoReturn(new BBBasicDataReturn(Integer.valueOf(request
				.getParameter("idConv")), request.getParameter("refTran")),
				tipoTransacao);
	}

}
