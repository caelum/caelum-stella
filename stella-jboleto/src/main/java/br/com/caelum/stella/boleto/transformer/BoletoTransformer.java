package br.com.caelum.stella.boleto.transformer;

import java.io.InputStream;

import br.com.caelum.stella.boleto.Boleto;

public interface BoletoTransformer {
	InputStream transform(Boleto boleto);
}
