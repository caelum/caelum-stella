package br.com.caelum.stella.boleto.transformer;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Calendar;

import javax.swing.text.NumberFormatter;

import br.com.caelum.stella.boleto.CriacaoBoletoException;

/**
 * Classe que serve apenas para centralizar alguns metodos comuns na gera��o dos
 * boletos.
 * 
 * @author Alberto
 * 
 */
class BoletoFormatter {

    private static final NumberFormatter formatter = new NumberFormatter(new DecimalFormat("#,##0.00"));
    private static final String datePattern = "%1$td/%1$tm/%1$tY";

    static String formatDate(final Calendar date) {
        return String.format(datePattern, date);
    }

    static String formatValue(final double value) {
        try {
            return formatter.valueToString(value);
        } catch (ParseException e) {
            throw new CriacaoBoletoException("Erro na formata��o do valor", e);
        }
    }
}
