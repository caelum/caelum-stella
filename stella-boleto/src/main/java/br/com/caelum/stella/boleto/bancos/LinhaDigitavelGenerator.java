package br.com.caelum.stella.boleto.bancos;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Boleto;

public class LinhaDigitavelGenerator {
    private final DVGenerator dvGenerator = new DVGenerator();

    public String geraLinhaDigitavelPara(Boleto boleto) {
        Banco banco = boleto.getBanco();

        String codigoDeBarras = banco.geraCodigoDeBarrasPara(boleto);

        StringBuilder bloco1 = new StringBuilder();
        bloco1.append(banco.getNumeroFormatado());
        bloco1.append(String.valueOf(boleto.getCodEspecieMoeda()));
        bloco1.append(codigoDeBarras.substring(19, 24));
        bloco1.append(this.dvGenerator.geraDVMod10(bloco1.toString()));

        StringBuilder bloco2 = new StringBuilder();
        bloco2.append(codigoDeBarras.substring(24, 34));
        bloco2.append(this.dvGenerator.geraDVMod10(bloco2.toString()));

        StringBuilder bloco3 = new StringBuilder();
        bloco3.append(codigoDeBarras.substring(34, 44));
        bloco3.append(this.dvGenerator.geraDVMod10(bloco3.toString()));

        StringBuilder bloco4 = new StringBuilder();
        bloco4.append(codigoDeBarras.charAt(4));
        bloco4.append(codigoDeBarras.substring(5, 9));
        bloco4.append(boleto.getValorFormatado());

        StringBuilder linhaDigitavel = new StringBuilder();
        linhaDigitavel.append(bloco1);
        linhaDigitavel.append(bloco2);
        linhaDigitavel.append(bloco3);
        linhaDigitavel.append(bloco4);

        linhaDigitavel = linhaDigitavelFormatter(linhaDigitavel);

        return linhaDigitavel.toString();
    }

    public StringBuilder linhaDigitavelFormatter(StringBuilder linhaDigitavel) {
        linhaDigitavel.insert(5, '.');
        linhaDigitavel.insert(11, "  ");
        linhaDigitavel.insert(18, '.');
        linhaDigitavel.insert(25, "  ");
        linhaDigitavel.insert(32, '.');
        linhaDigitavel.insert(39, "  ");
        linhaDigitavel.insert(42, "  ");

        return linhaDigitavel;
    }
}
