package br.com.caelum.stella.gateway.redecard.integration;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.stella.gateway.core.CalendarFormatter;
import br.com.caelum.stella.gateway.core.IntegrationHandler;
import br.com.caelum.stella.gateway.core.ProblematicTransactionException;

/**
 * Classe responsável por verificar o retorno da solicitação de autorização da Redecard.
 * @author Alberto e Rafael
 *
 */
public class RedecardVerificaRetornoAutorizacao implements
		IntegrationHandler<RedecardAutorizacaoReturn> {
	
	private final HttpServletRequest request;
	
	
	public RedecardVerificaRetornoAutorizacao(final HttpServletRequest request) {
		super();
		this.request = request;
	}



	public RedecardAutorizacaoReturn handle() {
		// TODO Auto-generated method stub
		final String mensagemRetorno = request.getParameter("MSGRET");
		final String codigoRetorno = request.getParameter("CODRET");
		final String numPedido = request.getParameter("NUMPEDIDO");
		if(codigoRetorno==null){
			final int codigoRetornoAprovado = 0;			
			final String dataDesformatada = request.getParameter("DATA");
			Calendar dataAutorizacao;
			dataAutorizacao = CalendarFormatter.stringToCalendar(dataDesformatada);
			RedecardAutorizacaoReturn autorizacaoReturn = new RedecardAutorizacaoReturn(
					codigoRetornoAprovado, mensagemRetorno, dataAutorizacao, numPedido,
					request.getParameter("NR_CARTAO"), request
							.getParameter("ORIGEM_BIN"), request
							.getParameter("NUMAUTOR"), request
							.getParameter("NUMCV"), request
							.getParameter("NUMAUTENT"), request
							.getParameter("NUMSQN"));
			return autorizacaoReturn;
		}
		else{
			throw new ProblematicTransactionException(mensagemRetorno,new RedecardAutorizacaoReturn(Integer.valueOf(codigoRetorno),mensagemRetorno,numPedido));
		}
	}



}
