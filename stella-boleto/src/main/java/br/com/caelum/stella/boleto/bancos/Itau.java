package br.com.caelum.stella.boleto.bancos;

import java.net.URL;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.CriacaoBoletoException;
import br.com.caelum.stella.boleto.Emissor;

public class Itau implements Banco {

    private static final String NUMERO_ITAU = "341";

    private final DVGenerator dvGenerator = new DVGenerator();

    public String geraCodigoDeBarrasPara(Boleto boleto) {
        StringBuilder codigoDeBarras = new StringBuilder();
        codigoDeBarras.append(getNumeroFormatado());
        codigoDeBarras.append(String.valueOf(boleto.getCodEspecieMoeda()));
        // Digito Verificador sera inserido aqui.

        codigoDeBarras.append(boleto.getFatorVencimento());
        codigoDeBarras.append(boleto.getValorFormatado());

        Emissor emissor = boleto.getEmissor();

        codigoDeBarras.append(getCarteiraDoEmissorFormatado(emissor));
        codigoDeBarras.append(getNossoNumeroDoEmissorFormatado(emissor));
        // Digito Verificador sera inserido aqui.

        codigoDeBarras.append(emissor.getAgenciaFormatado());
        codigoDeBarras.append(getContaCorrenteDoEmissorFormatado(emissor));

        codigoDeBarras.append("000");

        codigoDeBarras.insert(38, this.dvGenerator.geraDVMod10(codigoDeBarras
                .substring(30, 38)));

        codigoDeBarras.insert(29, this.dvGenerator.geraDVMod10(codigoDeBarras
                .substring(30, 38).concat(codigoDeBarras.substring(18, 28))));

        codigoDeBarras.insert(4, this.dvGenerator.geraDVMod11(codigoDeBarras
                .toString()));

        String result = codigoDeBarras.toString();

        if (result.length() != 44) {
            throw new CriacaoBoletoException(
                    "Erro na geração do código de barras. Número de digitos diferente de 44. Verifique todos os dados.");
        }

        return result;
    }

    public String getCarteiraDoEmissorFormatado(Emissor emissor) {
        return String.format("%03d", emissor.getCarteira());
    }

    public String getContaCorrenteDoEmissorFormatado(Emissor emissor) {
        return String.format("%05d", emissor.getContaCorrente());
    }

    public URL getImage() {
        return getClass().getResource(
                String.format("/br/com/caelum/stella/boleto/img/%s.png",
                        getNumeroFormatado()));
    }

    public String getNossoNumeroDoEmissorFormatado(Emissor emissor) {
        return String.format("%08d", emissor.getNossoNumero());
    }

    public String getNumeroFormatado() {
        return NUMERO_ITAU;
    }

}
