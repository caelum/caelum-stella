package br.com.caelum.stella.boleto.bancos;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Emissor;
import br.com.caelum.stella.boleto.exception.CriacaoBoletoException;

/**
 * Gera dados de um boleto relativos ao Banco Bradesco.
 * 
 * @see <a *
 *      href="http://stella.caelum.com.br/boleto-setup.html">http://stella.caelum
 *      * .com.br/boleto-setup.html< /a>
 * 
 * @see <a * href=
 *      "http://www.bradesco.com.br/br/pj/conteudo/sol_rec/pdf/manualtecnico.pdf"
 *      >MANUAL * DO BLOQUETO DE COBRANÇA< /a>
 * 
 * @author Leonardo Bessa
 * 
 */
public class Bradesco extends AbstractBanco implements Banco {

    private static final String NUMERO_BRADESCO = "237";
    
    private static final String DIGITO_NUMERO_BRADESCO = "2";

    public String geraCodigoDeBarrasPara(Boleto boleto) {
        StringBuilder codigoDeBarras = new StringBuilder();
        codigoDeBarras.append(getNumeroFormatado());
        codigoDeBarras.append(String.valueOf(boleto.getCodigoEspecieMoeda()));
        // Digito Verificador sera inserido aqui.

        codigoDeBarras.append(boleto.getFatorVencimento());
        codigoDeBarras.append(boleto.getValorFormatado());

        Emissor emissor = boleto.getEmissor();

        // CAMPO LIVRE
        codigoDeBarras.append(emissor.getAgenciaFormatado());
        codigoDeBarras.append(getCarteiraDoEmissorFormatado(emissor));
        codigoDeBarras.append(getNossoNumeroDoEmissorFormatado(emissor));
        codigoDeBarras.append(getContaCorrenteDoEmissorFormatado(emissor));
        codigoDeBarras.append("0");

        codigoDeBarras.insert(4, this.dvGenerator.geraDigitoMod11(codigoDeBarras
                .toString()));

        String result = codigoDeBarras.toString();

        if (result.length() != 44) {
            throw new CriacaoBoletoException(
                    "Erro na geração do código de barras. Número de digitos diferente de 44. Verifique todos os dados.");
        }

        return result;
    }
    
    @Override
	public String getNumeroFormatadoComDigito() {
		return NUMERO_BRADESCO;
	}

    public String getNumeroFormatado() {
        return NUMERO_BRADESCO;
    }

    public java.net.URL getImage() {
        return getClass().getResource(
                String.format("/br/com/caelum/stella/boleto/img/%s.png",
                        getNumeroFormatado()));
    }

    @Deprecated
    public String getNumConvenioDoEmissorFormatado(Emissor emissor) {
        return getNumeroConvenioDoEmissorFormatado(emissor);
    }
    
    public String getNumeroConvenioDoEmissorFormatado(Emissor emissor) {
    	return String.format("%07d", emissor.getNumeroConvenio());
    }

    public String getContaCorrenteDoEmissorFormatado(Emissor emissor) {
        return String.format("%07d", emissor.getContaCorrente());
    }

    public String getCarteiraDoEmissorFormatado(Emissor emissor) {
        return String.format("%02d", emissor.getCarteira());
    }

    public String getNossoNumeroDoEmissorFormatado(Emissor emissor) {
        return String.format("%011d", emissor.getNossoNumero());
    }
    
    public String getDigitoNossoNumeroDoEmissorFormatado(Emissor emissor) {
        return String.valueOf(emissor.getDigitoNossoNumero());
    }

	@Override
	public String getDigitoNumeroBanco() {
		return DIGITO_NUMERO_BRADESCO;
	}

}
