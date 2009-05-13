package br.com.caelum.stella.boleto.transformer;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Calendar;

import javax.swing.text.NumberFormatter;

import br.com.caelum.stella.boleto.CriacaoBoletoException;

/**
 * Classe que serve apenas para centralizar alguns metodos comuns na geração dos 
 * boletos.
 * @author Alberto
 *
 */
class BoletoFormatter {
	
    private final NumberFormatter formatter = new NumberFormatter(new DecimalFormat(
            "#,##0.00"));
    private final String datePattern = "%1$td/%1$tm/%1$tY"; 

	public String formatDate(Calendar date){
		return String.format(datePattern, date);
	}
	
	public String formatValue(double value){
		try {
			return formatter.valueToString(value);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new CriacaoBoletoException("Erro na formatação do valor",e);
		}
	}
}
