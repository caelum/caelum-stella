package br.com.caelum.stella.boleto.bancos;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;

import java.net.URL;

import static br.com.caelum.stella.boleto.utils.StellaStringUtils.leftPadWithZeros;

/**
 * @author rafael.braga
 */
public class Banrisul extends AbstractBanco implements Banco {

  private static final long serialVersionUID = 1L;
  private static final String NUMERO_BANRISUL = "041";
  private static final String DIGITO_BANRISUL = "0";

  @Override
  public String geraCodigoDeBarrasPara(Boleto boleto) {
    Beneficiario beneficiario = boleto.getBeneficiario();
    StringBuilder campoLivre = new StringBuilder();
    campoLivre.append(beneficiario.getAgenciaFormatada());
    campoLivre.append(getCarteiraFormatado(beneficiario));
    campoLivre.append(getNossoNumeroFormatado(beneficiario));
    campoLivre.append(getCodigoBeneficiarioFormatado(beneficiario));
    campoLivre.append("0");
    return new CodigoDeBarrasBuilder(boleto).comCampoLivre(campoLivre);
  }

  @Override
  public String getNumeroFormatadoComDigito() {
    StringBuilder builder = new StringBuilder();
    builder.append(getNumeroFormatado()).append("-");
    return builder.append(NUMERO_BANRISUL).toString();
  }

  @Override
  public String getNumeroFormatado() {
    return NUMERO_BANRISUL;
  }

  @Override
  public URL getImage() {
    String arquivo = "/br/com/caelum/stella/boleto/img/%s.png";
    String imagem = String.format(arquivo, getNumeroFormatado());
    return getClass().getResource(imagem);
  }

  @Override
  public String getCodigoBeneficiarioFormatado(Beneficiario beneficiario) {
    return leftPadWithZeros(beneficiario.getCodigoBeneficiario(), 7);
  }

  @Override
  public String getCarteiraFormatado(Beneficiario beneficiario) {
    return leftPadWithZeros(beneficiario.getCarteira(), 2);
  }

  @Override
  public String getNossoNumeroFormatado(Beneficiario beneficiario) {
    return leftPadWithZeros(beneficiario.getNossoNumero(), 11);
  }


}
