package br.com.caelum.stella.boleto.bancos;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.bancos.AbstractBanco;
import br.com.caelum.stella.boleto.bancos.CodigoDeBarrasBuilder;
import br.com.caelum.stella.boleto.utils.StellaStringUtils;
import java.net.URL;

public class BofA
extends AbstractBanco
implements Banco {
    private static final long serialVersionUID = 1;
    private static final String NUMERO_BOFA = "755";
    private static final String DIGITO_NUMERO_BOFA = "2";

    public String geraCodigoDeBarrasPara(Boleto boleto) {
        Beneficiario beneficiario = boleto.getBeneficiario();

        StringBuilder cdb = new StringBuilder();
        cdb.append(NUMERO_BOFA);
        cdb.append(boleto.getCodigoEspecieMoeda());
        cdb.append(boleto.getFatorVencimento());
        cdb.append(boleto.getValorFormatado());
        cdb.append("000");
        cdb.append(this.getCodigoBeneficiarioFormatado(beneficiario));
        cdb.append(getNossoNumeroFormatado(beneficiario));
        cdb.append(StellaStringUtils.leftPadWithZeros((String)beneficiario.getCarteira(), (int)2)).append("4");

        String digit = String.valueOf(this.getGeradorDeDigito().geraDigitoMod11(cdb.toString()));
        cdb.insert(4, digit);

        return cdb.toString();
    }

    public String getNumeroFormatadoComDigito() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getNumeroFormatado()).append("-");
        return builder.append("2").toString();
    }

    public String getNumeroFormatado() {
        return NUMERO_BOFA;
    }

    public URL getImage() {
        String arquivo = "/br/com/caelum/stella/boleto/img/%s.png";
        String imagem = String.format(arquivo, this.getNumeroFormatado());
        return this.getClass().getResource(imagem);
    }

    public String getCodigoBeneficiarioFormatado(Beneficiario beneficiario) {
        return StellaStringUtils.leftPadWithZeros((String)beneficiario.getCodigoBeneficiario(), (int)9);
    }

    public String getCarteiraFormatado(Beneficiario beneficiario) {
        return StellaStringUtils.leftPadWithZeros((String)beneficiario.getCarteira(), (int)2);
    }

    public String getNossoNumeroFormatado(Beneficiario beneficiario) {
        return StellaStringUtils.leftPadWithZeros((String)beneficiario.getNossoNumero(), (int)10);
    }

    public String getNossoNumeroECodigoDocumento(Boleto boleto) {
        Beneficiario beneficiario = boleto.getBeneficiario();
        StringBuilder builder = new StringBuilder().append(this.getNossoNumeroFormatado(beneficiario));
        return builder.append(" ").append(StellaStringUtils.leftPadWithZeros((String)beneficiario.getCarteira(), (int)2)).append("4").toString();
    }
}
