package br.com.caelum.stella.boleto.transformer;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

class FormatadorDeBoleto {

	private static NumberFormat nfmt = NumberFormat
			.getNumberInstance(new Locale("pt", "BR"));
	
	private static SimpleDateFormat dfmt = new SimpleDateFormat("dd/MM/yyyy"); 
	
	static {
		nfmt.setMinimumFractionDigits(2);
		nfmt.setMaximumFractionDigits(2);
	}
	
	static String formataData(final Calendar data) {
		synchronized (dfmt) {
			return dfmt.format(data.getTime());
		}
	}

	static String formataValor(final double valor) {
		synchronized (nfmt) {
			return nfmt.format(valor);
		}
	}
}
