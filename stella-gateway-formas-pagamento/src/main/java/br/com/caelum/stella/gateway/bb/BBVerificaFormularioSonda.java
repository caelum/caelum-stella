package br.com.caelum.stella.gateway.bb;

import java.math.BigDecimal;

import org.apache.commons.httpclient.methods.PostMethod;

import br.com.caelum.stella.gateway.core.BigDecimalFormatter;
import br.com.caelum.stella.gateway.core.GatewaysConf;
import br.com.caelum.stella.gateway.core.HttpIntegrationRequester;
import br.com.caelum.stella.gateway.core.IntegrationHandler;

public class BBVerificaFormularioSonda implements
		IntegrationHandler<BBFormularioSondaReturn> {

	private BBBasicDataReturn dadosRetornoPadrao;
	private BigDecimal valorSonda;
	private BBFormularioSondaReturnBuilder formularioSondaReturnBuilder;

	public BBVerificaFormularioSonda(String refTran, BigDecimal valorSonda,
			BBFormularioSondaReturnBuilder formularioSondaReturnBuilder) {
		this(new BBBasicDataReturn(new BBDadosConfiguracao().getIdConv(), refTran), valorSonda,
				formularioSondaReturnBuilder);
	}

	public BBVerificaFormularioSonda(BBBasicDataReturn dadosRetornoPadrao,
			BigDecimal valorSonda,
			BBFormularioSondaReturnBuilder formularioSondaReturnBuilder) {
		super();
		this.dadosRetornoPadrao = dadosRetornoPadrao;
		this.valorSonda = valorSonda;
		this.formularioSondaReturnBuilder = formularioSondaReturnBuilder;
	}

	public BBFormularioSondaReturn handle() {
		// TODO Auto-generated method stub
		PostMethod postMethod = new PostMethod(new GatewaysConf()
				.getBBUrlSonda());
		postMethod.addParameter("refTran", dadosRetornoPadrao.getRefTran());
		postMethod.addParameter("idConv", String.valueOf(dadosRetornoPadrao.getIdConv()));
		postMethod.addParameter("valorSonda", new BigDecimalFormatter()
				.bigDecimalToStringInCents(valorSonda));
		postMethod.addParameter("formato", formularioSondaReturnBuilder
				.getCodigo());
		String retorno = new HttpIntegrationRequester(postMethod).makeRequest();
		return formularioSondaReturnBuilder.buildReturn(retorno);
	}

}
