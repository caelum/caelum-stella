package br.com.caelum.stella.boleto.bancos;

import java.net.URL;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Emissor;

/**
 * Gera dados de um boleto relativos ao Banco Safra.
 * 
 * @see http://www.boletophp.com.br/documentacao/Documentacao_Safra.zip
 * 
 * @author Bluesoft
 * 
 */
public class Safra extends AbstractBanco implements Banco {

	private static final String NUMERO_SAFRA = "422";
	private static final String DIGITO_NUMERO_SAFRA = "7";
	private static final String COBRANCA_DIRETA_ELETRONICA = "7";
	private static final String TIPO_COBRANCA_EMITIDO_AO_CLIENTE = "2";
	
	@Override
	public String getNumeroFormatado() {
		return NUMERO_SAFRA;
	}

	@Override
	public URL getImage() {
		String arquivo = "/br/com/caelum/stella/boleto/img/%s.png";
		String imagem = String.format(arquivo, getNumeroFormatado());
		return getClass().getResource(imagem);
	}

	@Override
	public String geraCodigoDeBarrasPara(Boleto boleto) {
		Emissor emissor = boleto.getEmissor();
		StringBuilder campoLivre = new StringBuilder().append(COBRANCA_DIRETA_ELETRONICA);
		campoLivre.append(getAgencia(emissor));
		campoLivre.append(getContaCorrenteDoEmissorFormatado(emissor));
		campoLivre.append(getNossoNumeroDoEmissorFormatado(emissor));
		campoLivre.append(TIPO_COBRANCA_EMITIDO_AO_CLIENTE);
		return new CodigoDeBarrasBuilder(boleto).comCampoLivre(campoLivre);
	}
	
	@Override
	public String getContaCorrenteDoEmissorFormatado(Emissor emissor) {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("%08d", emissor.getContaCorrente()));
		builder.append(emissor.getDigitoContaCorrente());
		return builder.toString();
	}

	@Override
	public String getCarteiraDoEmissorFormatado(Emissor emissor) {
		return String.format("%02d", emissor.getCarteira());
	}

	@Override
	public String getNossoNumeroDoEmissorFormatado(Emissor emissor) {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("%09d", emissor.getNossoNumero()));
		return builder.toString();
	}
	
	@Override
	public String getNumeroFormatadoComDigito() {
		StringBuilder builder = new StringBuilder();
		builder.append(getNumeroFormatado()).append("-");
		return builder.append(DIGITO_NUMERO_SAFRA).toString();
	}
	
	private String getAgencia(Emissor emissor){
		StringBuilder builder =new StringBuilder();
		//O Banco Safra espera uma Agencia com 5 posicoes
		builder.append("0");
		return builder.append(emissor.getAgenciaFormatado()).toString();
	}
}
