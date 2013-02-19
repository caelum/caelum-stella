package br.com.caelum.stella.boleto.bancos;

import java.net.URL;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.bancos.gerador.GeradorDeDigito;
import br.com.caelum.stella.boleto.bancos.gerador.GeradorDeDigitoSantander;

public class Santander extends AbstractBanco implements Banco {

	private final static String NUMERO_SANTANDER = "033";
	private final static String NUMERO_SANTANDER_COM_DIGITO = "033-7";

	private final GeradorDeDigito dvGenerator = new GeradorDeDigitoSantander();

	public String geraCodigoDeBarrasPara(Boleto boleto) {
		StringBuilder codigoDeBarras = new StringBuilder();
		codigoDeBarras.append(NUMERO_SANTANDER);
		codigoDeBarras.append(String.valueOf(boleto.getCodigoEspecieMoeda()));
		// Digito Verificador sera inserido aqui.

		codigoDeBarras.append(boleto.getFatorVencimento());
		codigoDeBarras.append(boleto.getValorFormatado());

		Emissor emissor = boleto.getEmissor();
		//campo livre
		codigoDeBarras.append(String.format("%05d", Integer.parseInt(emissor.getAgenciaFormatado())));
		codigoDeBarras.append(getContaCorrenteDoEmissorFormatado(emissor));

		codigoDeBarras.append(getNossoNumeroDoEmissorLimpo(emissor));
		codigoDeBarras.append("00"); // filler
		codigoDeBarras.append(NUMERO_SANTANDER);
		
		codigoDeBarras.append(calculaDV1(codigoDeBarras));
		
		codigoDeBarras.append(calculaDV2(codigoDeBarras));
		
		codigoDeBarras.insert(4,this.dvGenerator.geraDigitoMod10(codigoDeBarras.toString()));
		return codigoDeBarras.toString();
	}
	
	private Object getNossoNumeroDoEmissorLimpo(Emissor emissor) {
		String nossoNumero = String.valueOf(emissor.getNossoNumero());
		
		if(nossoNumero.length() > 7){
			nossoNumero = nossoNumeroSemAgencia(nossoNumero);
		}
		return String.format("%07d", Long.parseLong(nossoNumero));
	}

	protected int calculaDV2(StringBuilder codigoDeBarras) {
		
		int tamanho = codigoDeBarras.length();
		int ultimaPosicao = tamanho -1;
		int dv1 = Integer.parseInt(codigoDeBarras.substring(ultimaPosicao));
		
		int digito = this.dvGenerator.geraDigitoMod(codigoDeBarras.substring(18),2,7, 11);
		if(digito == 1){
			int novoDV1 = (dv1 + 1)  % 10;
			codigoDeBarras.replace(ultimaPosicao, tamanho, String.valueOf(novoDV1));
			return calculaDV2(codigoDeBarras);
		}
		
		if( digito > 1){
			return 11 - digito;
		}
		return digito;
	}

	protected int  calculaDV1(StringBuilder codigoDeBarras) {
		return this.dvGenerator.geraDigitoMod10(codigoDeBarras.substring(18));
	}
	
	public URL getImage() {
		return getClass().getResource(
				String.format("/br/com/caelum/stella/boleto/img/%s.png",
						NUMERO_SANTANDER));
	}

	public String getNumeroFormatado() {
		return NUMERO_SANTANDER;
	}

	public String getCarteiraDoEmissorFormatado(Emissor emissor) {
		return String.format("%02d", emissor.getCarteira());
	}

	public String getContaCorrenteDoEmissorFormatado(Emissor emissor) {
		String valor = String.valueOf(emissor.getContaCorrente());
		
		if(emissor.getDigitoContaCorrente() != 0){
			valor += emissor.getDigitoContaCorrente();
		}
		
		return String.format("%06d", Long.parseLong(valor));
	}

	@Override
	public String getNossoNumeroDoEmissorFormatado(Emissor emissor) {
		String digito = calculaDigitoNossoNumero(emissor.getNossoNumero());
		return String.format("%07d", Long.parseLong(emissor.getNossoNumero() + digito));
	}

	private String calculaDigitoNossoNumero(long nossoNumero) {
		int[] pesos =  {7,3,1,9};
		String nnumero = String.valueOf(nossoNumero);
		int soma = 0;
		
		for(int i = 0, j = 0; i< nnumero.length(); i++, j++ ){
			
			if(j == pesos.length)
				j = 0;
			soma+= Integer.parseInt(String.valueOf(nnumero.charAt(i))) * pesos[j];
		}
		
		int resto = soma % 10;
		
		int dv = 10 - resto;
		
		if(dv == 10){
			return "0";
		}else{
			return String.valueOf(dv);
		}
	}

	protected String nossoNumeroSemAgencia(String nossoNumero) {
		return nossoNumero.substring(3, nossoNumero.length());
	}

	@Override
	public String getNumeroFormatadoComDigito() {
		return NUMERO_SANTANDER_COM_DIGITO;
	}

	@Override
	public GeradorDeDigito getGeradorDeDigito() {
		return dvGenerator;
	}
}
