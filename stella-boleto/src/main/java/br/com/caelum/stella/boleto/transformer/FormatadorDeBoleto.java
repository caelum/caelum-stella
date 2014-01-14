package br.com.caelum.stella.boleto.transformer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

class FormatadorDeBoleto {
	static String formataData(final Calendar data) {
			return new SimpleDateFormat("dd/MM/yyyy").format(data.getTime());
	}

	static String formataValor(final double valor) {
		return String.format(new Locale("pt", "BR"),"%10.2f", valor);
	}
}
