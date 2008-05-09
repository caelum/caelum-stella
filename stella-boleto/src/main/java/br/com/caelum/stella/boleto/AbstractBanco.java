package br.com.caelum.stella.boleto;

/**
 * Define a implementação dos Bancos no modo geral.
 * 
 * Documentação que pode ser consultada:
 * 
 * http://www.macoratti.net/boleto.htm
 * http://pt.wikipedia.org/wiki/Boleto_bancário
 * 
 * Manual oficial da Febraban:
 * http://www.bradesco.com.br/br/pj/conteudo/sol_rec/pdf/manualtecnico.pdf
 * 
 * Para testes rapidos: http://evandro.net/codigo_barras.html
 * 
 * Apesar de possuirmos diversos unit tests, sempre é bom ter precaução com
 * valores e testar alguns boletos, em especial se valores serão altos.
 * 
 * Bancos:
 * Banco do Brasil: 001
 * Bradesco: 237
 * Itau: 341
 * Banco Real: 356
 * Caixa Economica: 104
 * Unibanco: 409
 * HSBC: 399
 * 
 * @author Paulo Silveira
 * 
 */
public abstract class AbstractBanco implements Banco {
	private int numero;

	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNumeroFormatado() {
		return String.format("%03d", this.numero);
	}

	public String geraCodigoDeBarrasPara(Boleto boleto) {
		return null;
	}
	
	public int geraDVCodigoDeBarras(String codigoDeBarras) {
		int soma = 0;
		for (int i = codigoDeBarras.length() - 1, multiplicador = 2; i >= 0; i--, multiplicador++) {
			if (i == 4) // pula posição 5
				i--;
			if (multiplicador == 10) // volta pro 2
				multiplicador = 2;
			soma += Integer.parseInt(String.valueOf(codigoDeBarras.charAt(i)))
					* multiplicador;
		}
		
		soma *= 10;

		int resto = soma % 11;
		
		if (resto == 10 || resto == 0)
			return 1;
		else
			return resto;
	}

	public String geraLinhaDigitavelPara(Boleto boleto) {
		return null;
	}
	
	public int geraDVLinhaDigitavel(String campo) {
		int soma = 0;
		for (int i = campo.length() - 1; i >= 0; i--) {
			int multiplicador = (campo.length() - i) % 2 + 1;
			int algarismoMultiplicado = Integer.parseInt(String.valueOf(campo.charAt(i))) * multiplicador;
			soma += (algarismoMultiplicado / 10) + (algarismoMultiplicado % 10);
		}
		
		int resto = soma % 10;
		return (10 - resto) % 10;
	}

	public java.net.URL getImage() {
		return AbstractBanco.class.getResource(String
				.format("/br/com/caelum/stella/boleto/img/%s.png",
						getNumeroFormatado()));
	}
}
