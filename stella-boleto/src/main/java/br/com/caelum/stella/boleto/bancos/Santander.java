package br.com.caelum.stella.boleto.bancos;

import java.net.URL;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.bancos.gerador.GeradorDeDigito;
import br.com.caelum.stella.boleto.bancos.gerador.GeradorDeDigitoSantander;

public class Santander implements Banco {

	private final static String NUMERO_SANTANDER = "033";
	private final static String DIGITO_SANTANDER = "7";
	private GeradorDeDigito gdivSantander = new GeradorDeDigitoSantander();

	@Override
	public String geraCodigoDeBarrasPara(Boleto boleto) {
		Emissor emissor = boleto.getEmissor();
		StringBuilder campoLivre = new StringBuilder("9");
		campoLivre.append(getContaCorrenteDoEmissorFormatado(emissor));
		campoLivre.append(getNossoNumeroDoEmissorFormatado(emissor));
		campoLivre.append("0").append(emissor.getCarteira());
		return new CodigoDeBarrasBuilder(boleto).comCampoLivre(campoLivre);
	}
	
	@Override
	public URL getImage() {
		String pathDoArquivo = "/br/com/caelum/stella/boleto/img/%s.png";
		String imagem = String.format(pathDoArquivo, NUMERO_SANTANDER);
		return getClass().getResource(imagem);
	}

	@Override
	public String getNumeroFormatado() {
		return NUMERO_SANTANDER;
	}

	@Override
	public String getCarteiraDoEmissorFormatado(Emissor emissor) {
		return String.format("%03d", emissor.getCarteira());
	}

	@Override
	public String getContaCorrenteDoEmissorFormatado(Emissor emissor) {
		return String.format("%07d", emissor.getContaCorrente());
	}

	@Override
	public String getNossoNumeroDoEmissorFormatado(Emissor emissor) {
		return String.format("%13d", emissor.getNossoNumero());
	}

	@Override
	public String getNumeroFormatadoComDigito() {
		StringBuilder builder = new StringBuilder();
		builder.append(NUMERO_SANTANDER).append("-");
		return builder.append(DIGITO_SANTANDER).toString();
	}

	@Override
	public String getAgenciaECodigoCedente(Emissor emissor) {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("%05d", emissor.getAgencia()));
		builder.append("/").append(emissor.getContaCorrente());
		return builder.toString();
	}

	@Override
	public String getNossoNumeroECodDocumento(Emissor emissor) {
		String nossoNumero = getNossoNumeroDoEmissorFormatado(emissor);
		StringBuilder builder = new StringBuilder();
		builder.append(nossoNumero.substring(0, 12));
		builder.append("-").append(nossoNumero.substring(12));
		return  builder.toString();
	}
 
	@Override
	public GeradorDeDigito getGeradorDeDigito() {
		return gdivSantander;
	}
}