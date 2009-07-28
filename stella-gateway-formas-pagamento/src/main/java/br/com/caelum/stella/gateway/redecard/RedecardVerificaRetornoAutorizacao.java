package br.com.caelum.stella.gateway.redecard;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import br.com.caelum.stella.gateway.core.CalendarFormatter;
import br.com.caelum.stella.gateway.core.IntegrationHandler;
import br.com.caelum.stella.gateway.core.ProblematicTransactionException;

/**
 * Classe responsável por verificar o retorno da solicitação de autorização da
 * Redecard.
 * 
 * @author Alberto e Rafael
 * 
 */
public class RedecardVerificaRetornoAutorizacao implements
		IntegrationHandler<RedecardAutorizacaoReturn> {

	private HttpServletRequest request;
	private RedecardIdiomaOperacao idiomaOperacao;

	public RedecardVerificaRetornoAutorizacao(HttpServletRequest request,
			RedecardIdiomaOperacao idiomaOperacao) {
		super();
		this.request = request;
		this.idiomaOperacao = idiomaOperacao;
	}

	public RedecardAutorizacaoReturn handle() {
		// TODO Auto-generated method stub
		String mensagemRetorno = request.getParameter("MSGRET");
		String codigoRetorno = request.getParameter("CODRET");
		String numPedido = request.getParameter("NUMPEDIDO");
		if (codigoRetorno == null) {
			int codigoRetornoAprovado = 0;
			String dataDesformatada = request.getParameter("DATA");
			Calendar dataAutorizacao;
			dataAutorizacao = new CalendarFormatter()
					.stringToCalendar(dataDesformatada);
			RedecardAutorizacaoReturn autorizacaoReturn = new RedecardAutorizacaoReturn(
					codigoRetornoAprovado, mensagemRetorno, dataAutorizacao,
					numPedido, request.getParameter("NR_CARTAO"), request
							.getParameter("ORIGEM_BIN"), request
							.getParameter("NUMAUTOR"), request
							.getParameter("NUMCV"), request
							.getParameter("NUMAUTENT"), request
							.getParameter("NUMSQN"), idiomaOperacao);
			return autorizacaoReturn;
		} else {
			throw new ProblematicTransactionException(
					mensagemRetorno,
					new RedecardAutorizacaoReturn(Integer
							.valueOf(codigoRetorno), mensagemRetorno, numPedido));
		}
	}

}
