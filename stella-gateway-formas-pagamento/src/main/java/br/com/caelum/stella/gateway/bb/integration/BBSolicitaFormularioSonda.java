package br.com.caelum.stella.gateway.bb.integration;

import java.math.BigDecimal;

import org.apache.commons.httpclient.methods.PostMethod;

import br.com.caelum.stella.gateway.core.BigDecimalFormatter;
import br.com.caelum.stella.gateway.core.GatewaysConf;
import br.com.caelum.stella.gateway.core.HttpIntegrationRequester;
import br.com.caelum.stella.gateway.core.IntegrationHandler;

public class BBSolicitaFormularioSonda implements IntegrationHandler<BBFormularioSondaReturn> {
	
	private final String idConv;
	private final String refTran;
	private final BigDecimal valorSonda;
	private final FormularioSondaReturnBuilder formularioSondaReturnBuilder;
	
	

	private BBSolicitaFormularioSonda(String refTran, BigDecimal valorSonda,
			FormularioSondaReturnBuilder formularioSondaReturnBuilder) {
		this(new GatewaysConf().getBBIdConv(),refTran,valorSonda,formularioSondaReturnBuilder);
	}



	private BBSolicitaFormularioSonda(String idConv, String refTran,
			BigDecimal valorSonda,
			FormularioSondaReturnBuilder formularioSondaReturnBuilder) {
		super();
		this.idConv = idConv;
		this.refTran = refTran;
		this.valorSonda = valorSonda;
		this.formularioSondaReturnBuilder = formularioSondaReturnBuilder;
	}



	public BBFormularioSondaReturn handle() {
		// TODO Auto-generated method stub
		PostMethod postMethod = new PostMethod(new GatewaysConf().getBBUrlSonda());
		postMethod.addParameter("refTran",refTran);
		postMethod.addParameter("idConv",idConv);
		postMethod.addParameter("valorSonda",BigDecimalFormatter.bigDecimalToStringInCents(valorSonda));
		postMethod.addParameter("formato",formularioSondaReturnBuilder.getCodigo());
		String retorno = new HttpIntegrationRequester(postMethod).makeRequest();		
		return formularioSondaReturnBuilder.buildRetorno(retorno);
	}

}
