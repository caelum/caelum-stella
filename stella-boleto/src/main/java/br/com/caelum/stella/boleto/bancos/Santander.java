package br.com.caelum.stella.boleto.bancos;

import java.net.URL;

import static br.com.caelum.stella.boleto.utils.StellaStringUtils.leftPadWithZeros;
import br.com.caelum.stella.DigitoPara;
import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.bancos.gerador.GeradorDeDigito;
import br.com.caelum.stella.boleto.bancos.gerador.GeradorDeDigitoSantander;

public class Santander implements Banco {

	private static final long serialVersionUID = 1L;

	private final static String NUMERO_SANTANDER = "033";
	private final static String DIGITO_SANTANDER = "7";
	private GeradorDeDigito gdivSantander = new GeradorDeDigitoSantander();

	@Override
	public String geraCodigoDeBarrasPara(Boleto boleto) {
		Emissor emissor = boleto.getEmissor();
		StringBuilder campoLivre = new StringBuilder("9");
		campoLivre.append(getNumeroConvenioFormatado(emissor));
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
		return leftPadWithZeros(emissor.getCarteira(), 3);
	}

	@Override
	public String getContaCorrenteDoEmissorFormatado(Emissor emissor) {
		return leftPadWithZeros(emissor.getContaCorrente(), 7);
	}

	@Override
	public String getNossoNumeroDoEmissorFormatado(Emissor emissor) {
		if (emissor.getDigitoNossoNumero() != null) {
			return leftPadWithZeros(emissor.getNossoNumero()+emissor.getDigitoNossoNumero(), 13);
		}
		return leftPadWithZeros(emissor.getNossoNumero(), 13);
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
		builder.append(leftPadWithZeros(emissor.getAgencia(), 5));
		builder.append("/").append(getNumeroConvenioFormatado(emissor));
		return builder.toString();
	}

	@Override
	public String getNossoNumeroECodDocumento(Boleto boleto) {
		Emissor emissor = boleto.getEmissor();
		
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
	
	public String getNumeroConvenioFormatado(Emissor emissor) {
		return leftPadWithZeros(emissor.getNumeroConvenio(), 7);
	}
	
	public String calcularDigitoVerificadorNossoNumero(Emissor emissor) {
		if (emissor == null || emissor.getNossoNumero() == null || emissor.getNossoNumero().length() > 12) {
			throw new IllegalArgumentException("Nosso Número inválido: " + emissor.getNossoNumero());
		}
		DigitoPara digitoPara = new DigitoPara(leftPadWithZeros(emissor.getNossoNumero(), 12));
		int digito = Integer.parseInt(digitoPara.comMultiplicadoresDeAte(2,9)
							.mod(11)
							.trocandoPorSeEncontrar("0", 1)
							.trocandoPorSeEncontrar("1", 10)
							.calcula());
		
		if (digito > 1) {
			digito = 11-digito;
		}
		
		return String.valueOf(digito);
	}

}