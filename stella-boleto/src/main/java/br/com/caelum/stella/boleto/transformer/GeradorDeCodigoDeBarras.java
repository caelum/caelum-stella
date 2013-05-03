package br.com.caelum.stella.boleto.transformer;

import java.awt.Color;
import java.awt.Image;

import com.lowagie.text.Element;
import com.lowagie.text.pdf.BarcodeInter25;

/**
 * Implementa um gerador de códigos de barras
 * 
 * @author Cauê Guerra
 * @author Paulo Silveira
 * 
 */
class GeradorDeCodigoDeBarras {

	/**
	 * Retorna uma imagem com o código de barras para uma determinada String
	 * 
	 * @param codigo
	 */
	static Image geraCodigoDeBarrasPara(String codigo, float altura) {
		BarcodeInter25 bar = new BarcodeInter25();
		bar.setCode(codigo);
		bar.setExtended(true);
		bar.setTextAlignment(Element.ALIGN_LEFT);
		bar.setBarHeight(altura);
		bar.setFont(null);
		bar.setX(0.73f);
		bar.setN(3);
		return bar.createAwtImage(Color.BLACK, Color.WHITE);
	}
}
