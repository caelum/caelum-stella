package br.com.caelum.stella.boleto.bancos;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import static br.com.caelum.stella.boleto.utils.StellaStringUtils.leftPadWithZeros;

/**
 * Gera dados de um boleto relativos ao Banco do Brasil.
 * 
 * O manual do BB(janeiro/2016) em relação ao código de barras relata o seguinte.
 * Leiaute com 2 campos (44 posições):
 *
 * 1. obrigatório, FEBRABAN com 19 posições;
 * 2. campo livre, determinado pela modalidade de cobrança utilizada pelo cliente com 25 posições.
 *
 * A classe BancoDoBrasil deve atuar na composição do campo livre seguindo o item 2.3.2, que diz " Os padrões do BB estão identificados nos Anexos VII, VIII, IX e X".
 * Cada anexo é regido pelo número do convênio e não pela carteira como se vê atualmente na classe.
 * O cliente recebe um número de convênio, podendo ser de 4, 6 ou 7 posições - e cada algoritmo de formação do campo livre leva isso em consideração.
 * Nessa implementação a formação/composição do NOSSO NUMERO fica a cargo do desenvolvedor. O NOSSO NUMERO nada mais é
 * do que a união dos campos CONVENIO e COMPLEMENTO, com pequenos requisitos de formatação.
 * Para Boleto registrado:
 *
 * 1. Anexo VII, convênio 4 posições [convênio + complemento + agência + conta + carteira] CCCCNNNNNNN
 * 2. Anexo VIII, convênio 6 posições [convênio + complemento + agência + conta + carteira] CCCCCCNNNNN
 * 3. Anexo IX, convênio 7 posições [000000 + convênio + complemento + carteira] CCCCCCCNNNNNNNNNN
 *
 * Finalmente, Boleto sem registro:
 *
 * 4. Anexo X, convênio 6 posições [convênio + complemento + carteira] NNNNNNNNNNNNNNNNN
 *
 * Um exemplo para número do convênio [1234567]: 
 * String numeroConvenio = "1234567";
 * int numeroComplemento = 206; //identificador interno do BB ou do beneficiário
 * //Responsabilidade do desenvolvedor compor o nosso número
 * String nossoNumero = numeroConvenio + String.format("%010d", numeroComplemento);
 *
 * Referência: www.bb.com.br/docs/pub/emp/mpe/espeboletobb.pdf
 * Útimo acesso: 06/01/2017
 *
 * @author Gilberto C Andrade 
 * @author Cauê Guerra
 * @author Paulo Silveira
 */
public class BancoDoBrasil extends AbstractBanco implements Banco {

	private static final long serialVersionUID = 1L;

	private static final String NUMERO_BB = "001";
	private static final String DIGITO_NUMERO_BB = "9";

	@Override
	public String geraCodigoDeBarrasPara(Boleto boleto) {
		Beneficiario beneficiario = boleto.getBeneficiario();
                String numeroConvenio = beneficiario.getNumeroConvenio();

                //Exigencia do BB: numero do convenio
                if (numeroConvenio == null 
			|| numeroConvenio.isEmpty() ) {
                        throw new IllegalArgumentException("O número do convênio não pode ser nulo!");
                }                
                //Assumimos que o desenvolvedor sabe compor o NOSSO NUMERO,
                //Deveríamos validá-lo com base na modalidade? Hum, NÃO!!
                int numeroPosicoesConvenio = numeroConvenio.length();
                char modalidade = beneficiario.getModalidade();
                
		StringBuilder campoLivre = new StringBuilder();

                if (numeroPosicoesConvenio == 7 && modalidade == 'C') {
                        campoLivre.append("000000");
                        campoLivre.append(beneficiario.getNossoNumero());
                }
                if ((numeroPosicoesConvenio == 4 || numeroPosicoesConvenio == 6) && modalidade == 'C') {
                        campoLivre.append(beneficiario.getNossoNumero());
                        campoLivre.append(beneficiario.getAgenciaFormatada());
                        campoLivre.append(beneficiario.getCodigoBeneficiario());                    
                }
                if (numeroPosicoesConvenio == 6 && modalidade == 'S') {
                        campoLivre.append(beneficiario.getNossoNumero());
                }
                campoLivre.append(boleto.getBanco().getCarteiraFormatado(beneficiario));
                
                if (campoLivre.length() != 25) {
                        throw new IllegalArgumentException("Puts, assim não vai dar!! Campo livre deve ter 25 caracteres, mas tem " + campoLivre.toString());
                }
		return new CodigoDeBarrasBuilder(boleto).comCampoLivre(campoLivre);
	}
        

	@Override
	public String getNumeroFormatado() {
		return NUMERO_BB;
	}

	@Override
	public java.net.URL getImage() {
		String arquivo = "/br/com/caelum/stella/boleto/img/%s.png";
		String imagem = String.format(arquivo, getNumeroFormatado());
		return getClass().getResource(imagem);
	}

	public String getNumeroConvenioFormatado(Beneficiario beneficiario) {
        	return beneficiario.getNumeroConvenio();
	}

	@Override
	public String getCodigoBeneficiarioFormatado(Beneficiario beneficiario) {
		return beneficiario.getCodigoBeneficiario();
	}

	@Override
	public String getCarteiraFormatado(Beneficiario beneficiario) {
		return leftPadWithZeros(beneficiario.getCarteira(),2);
	}

	@Override
	public String getNossoNumeroFormatado(Beneficiario beneficiario) {
		return beneficiario.getNossoNumero();
	}

	@Override
	public String getNumeroFormatadoComDigito() {
		return NUMERO_BB + "-" + DIGITO_NUMERO_BB;
	}

	@Override
	public String getNossoNumeroECodigoDocumento(Boleto boleto) {
		Beneficiario beneficiario = boleto.getBeneficiario();
		return getNossoNumeroFormatado(beneficiario);
	}

}
