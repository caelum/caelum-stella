package br.com.caelum.stella.boleto.transformer;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

import com.lowagie.text.DocumentException;

import br.com.caelum.stella.boleto.Boleto;

public interface BoletoTransformer {
	InputStream transform(Boleto boleto) throws IOException, DocumentException,
			NumberFormatException, ParseException;
}
