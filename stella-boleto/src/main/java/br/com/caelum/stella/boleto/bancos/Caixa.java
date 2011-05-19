package br.com.caelum.stella.boleto.bancos;

import java.net.URL;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.CriacaoBoletoException;
import br.com.caelum.stella.boleto.Emissor;

public class Caixa implements Banco {

    private static final String NUMERO_CAIXA = "104";

    private final DVGenerator dvGenerator = new DVGenerator();

    public String geraCodigoDeBarrasPara(Boleto boleto) {
        StringBuilder codigoDeBarras = new StringBuilder();
        codigoDeBarras.append(getNumeroFormatado());
        codigoDeBarras.append(String.valueOf(boleto.getCodigoEspecieMoeda()));
        // Digito Verificador sera inserido aqui.

        codigoDeBarras.append(boleto.getFatorVencimento());
        codigoDeBarras.append(boleto.getValorFormatado());

        Emissor emissor = boleto.getEmissor();

        codigoDeBarras.append(emissor.getCarteira());
        codigoDeBarras.append(getNossoNumeroDoEmissorFormatado(emissor));

        codigoDeBarras.append(emissor.getAgenciaFormatado());
        codigoDeBarras.append(getCodOperacaoFormatado(emissor));
        codigoDeBarras.append(getCodFornecidoPelaAgenciaFormatado(emissor));

        codigoDeBarras.insert(4, this.dvGenerator.geraDVMod11(codigoDeBarras
                .toString()));

        String result = codigoDeBarras.toString();

        if (result.length() != 44) {
            throw new CriacaoBoletoException(
                    "Erro na geração do código de barras. Número de digitos diferente de 44. Verifique todos os dados."
                            + result.length());
        }

        return result;
    }

    public String getCarteiraDoEmissorFormatado(Emissor emissor) {
        return String.format("%02d", emissor.getCarteira());
    }

    public String getContaCorrenteDoEmissorFormatado(Emissor emissor) {
        return String.format("%05d", emissor.getContaCorrente());
    }

    String getCodFornecidoPelaAgenciaFormatado(Emissor emissor) {
        return String.format("%08d", emissor.getCodFornecidoPelaAgencia());
    }

    String getCodOperacaoFormatado(Emissor emissor) {
        return String.format("%03d", emissor.getCodOperacao());
    }

    public URL getImage() {
        return getClass().getResource(
                String.format("/br/com/caelum/stella/boleto/img/%s.png",
                        getNumeroFormatado()));
    }

    public String getNossoNumeroDoEmissorFormatado(Emissor emissor) {
        int length = 10 - (emissor.getCarteira() / 10);
        return String.format("%0" + (length - 1) + "d", emissor
                .getNossoNumero());
    }

    public String getNumeroFormatado() {
        return NUMERO_CAIXA;
    }

}
