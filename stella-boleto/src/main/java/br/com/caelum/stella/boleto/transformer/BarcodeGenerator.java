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
class BarcodeGenerator {

    /**
     * Retorna uma imagem com o código de barras para uma determinada String
     * 
     * @param code
     */
    static Image generateBarcodeFor(String code) {
        BarcodeInter25 bar = new BarcodeInter25();
        bar.setCode(code);
        bar.setExtended(true);

        bar.setTextAlignment(Element.ALIGN_LEFT);
        bar.setBarHeight(37.00f);
        bar.setFont(null);
        bar.setX(0.73f);
        bar.setN(3);
        return bar.createAwtImage(Color.BLACK, Color.WHITE);
    }
}
