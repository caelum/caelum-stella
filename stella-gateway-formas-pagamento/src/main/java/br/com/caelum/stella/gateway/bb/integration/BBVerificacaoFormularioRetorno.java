package br.com.caelum.stella.gateway.bb.integration;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.stella.gateway.bb.TipoTransacao;
import br.com.caelum.stella.gateway.core.IntegrationHandler;
import br.com.caelum.stella.gateway.core.EnumComCodigoFinder;

public class BBVerificacaoFormularioRetorno implements IntegrationHandler<BBFormualrioRetornoReturn>{

	private final HttpServletRequest request;

	public BBVerificacaoFormularioRetorno(final HttpServletRequest request) {
		super();
		this.request = request;
	}

	public BBFormualrioRetornoReturn handle() {
		// TODO Auto-generated method stub		
		TipoTransacao tipoTransacao = new EnumComCodigoFinder().descobreAEnumPeloCodigo(TipoTransacao.class,request.getParameter("tpPagamento"));		
		return new BBFormualrioRetornoReturn(new BBBasicDataReturn(request.getParameter("idConv"),request.getParameter("refTran")),tipoTransacao);
	}

	
	
}
