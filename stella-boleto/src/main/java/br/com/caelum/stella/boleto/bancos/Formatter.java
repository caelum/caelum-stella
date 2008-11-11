package br.com.caelum.stella.boleto.bancos;

public class Formatter {
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
