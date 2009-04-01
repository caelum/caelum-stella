package br.com.caelum.stella.gateway.bb.integration;

import java.text.MessageFormat;

import br.com.caelum.stella.gateway.bb.Checkout;
import br.com.caelum.stella.gateway.core.GatewaysConf;
import br.com.caelum.stella.gateway.core.IntegrationHandler;

public class BBSolicitaAutorizacaoPagamento implements
		IntegrationHandler<BBDadosAutorizacaoPagamento> {
	
	private final Checkout checkout;
	private final String idConv;
	private final String codigoConvenioDeCobranca;
	private final static GatewaysConf gatewaysConf = new GatewaysConf();
	private final String numeroASerAnexadoAoCodigoDeConvenio;
	private final Object[] urlRetornoParams;
	private final Object[] urlInformaParams;
	
	
	
	public BBSolicitaAutorizacaoPagamento(final Checkout checkout,final String numeroASerAnexadoAoCodigoDeConvenio) {
		this(checkout, gatewaysConf.getBBIdConv(), gatewaysConf.getBBCodigoConvenioDeCobranca(), numeroASerAnexadoAoCodigoDeConvenio,new Object[]{},new Object[]{});				
	}

	public BBSolicitaAutorizacaoPagamento(final Checkout checkout,final String numeroASerAnexadoAoCodigoDeConvenio,final Object[] urlRetornoParams,final Object[] urlInformaParams) {
		this(checkout, gatewaysConf.getBBIdConv(), gatewaysConf.getBBCodigoConvenioDeCobranca(), numeroASerAnexadoAoCodigoDeConvenio, urlRetornoParams, urlInformaParams);				
	}

	
	public BBSolicitaAutorizacaoPagamento(final Checkout checkout, final String idConv,
			final String codigoConvenioDeCobranca,final String numeroASerAnexadoAoCodigoDeConvenio) {		
		this(checkout, gatewaysConf.getBBIdConv(), gatewaysConf.getBBCodigoConvenioDeCobranca(), numeroASerAnexadoAoCodigoDeConvenio,new Object[]{},new Object[]{});		
	}


	public BBSolicitaAutorizacaoPagamento(final Checkout checkout, final String idConv,
			final String codigoConvenioDeCobranca,final String numeroASerAnexadoAoCodigoDeConvenio,final Object[] urlRetornoParams,Object[] urlInformaParams) {		
		this.checkout = checkout;
		this.idConv = idConv;
		this.codigoConvenioDeCobranca = codigoConvenioDeCobranca;
		this.numeroASerAnexadoAoCodigoDeConvenio = numeroASerAnexadoAoCodigoDeConvenio;
		this.urlRetornoParams = urlInformaParams;
		this.urlInformaParams = urlInformaParams;		
	}




	public BBDadosAutorizacaoPagamento handle() {
		// TODO Auto-generated method stub		
		return new BBDadosAutorizacaoPagamento(checkout,idConv,new RefTranGenerator().geraRefTran(codigoConvenioDeCobranca,numeroASerAnexadoAoCodigoDeConvenio),MessageFormat.format(gatewaysConf.getBBUrlRetorno(),urlRetornoParams),MessageFormat.format(gatewaysConf.getBBUrlInforma(),urlInformaParams));
	}

	

}
