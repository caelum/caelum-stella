package br.com.caelum.stella.boleto.transformer;

import java.awt.Color;
import java.awt.Image;

import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.BarcodeInter25;

/**
 * Implementa um gerador de imagem de códigos de barras
 * 
 * @author Cauê Guerra
 * @author Paulo Silveira
 * 
 */
class GeradorDeImagemDoCodigoDeBarras {

	/**
	 * @param codigo, que é a String do código de barras completo.
	 * @param altura, que é a altura (Barheight) que deve ficar a imagem.
	 * 
	 * @return imagem com o código de barras para a string do código
	 */
	static Image geraImagemDoCodigoDeBarrasPara(String codigo, float altura) {
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
